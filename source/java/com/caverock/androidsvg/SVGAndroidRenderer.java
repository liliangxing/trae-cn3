package com.caverock.androidsvg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SVGAndroidRenderer {
    private static final float BEZIER_ARC_FACTOR = 0.5522848f;
    private static final String DEFAULT_FONT_FAMILY = "serif";
    public static final float LUMINANCE_TO_ALPHA_BLUE = 0.0722f;
    public static final float LUMINANCE_TO_ALPHA_GREEN = 0.7151f;
    public static final float LUMINANCE_TO_ALPHA_RED = 0.2127f;
    private static final String TAG = "SVGAndroidRenderer";
    private static HashSet<String> supportedFeatures;
    private Canvas canvas;
    private SVG document;
    private float dpi;
    private Stack<Matrix> matrixStack;
    private Stack<SVG.SvgContainer> parentStack;
    private CSSParser.RuleMatchContext ruleMatchContext = null;
    private RendererState state;
    private Stack<RendererState> stateStack;

    private static int clamp255(float f) {
        int i = (int) (f * 256.0f);
        if (i < 0) {
            return 0;
        }
        return i > 255 ? JfifUtil.MARKER_FIRST_BYTE : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void debug(String str, Object... objArr) {
    }

    private float dotProduct(float f, float f2, float f3, float f4) {
        return (f * f3) + (f2 * f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RendererState {
        Paint fillPaint;
        boolean hasFill;
        boolean hasStroke;
        boolean spacePreserve;
        Paint strokePaint;
        SVG.Style style;
        SVG.Box viewBox;
        SVG.Box viewPort;

        RendererState() {
            Paint paint = new Paint();
            this.fillPaint = paint;
            paint.setFlags(193);
            this.fillPaint.setHinting(0);
            this.fillPaint.setStyle(Paint.Style.FILL);
            this.fillPaint.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.strokePaint = paint2;
            paint2.setFlags(193);
            this.strokePaint.setHinting(0);
            this.strokePaint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setTypeface(Typeface.DEFAULT);
            this.style = SVG.Style.getDefaultStyle();
        }

        RendererState(RendererState rendererState) {
            this.hasFill = rendererState.hasFill;
            this.hasStroke = rendererState.hasStroke;
            this.fillPaint = new Paint(rendererState.fillPaint);
            this.strokePaint = new Paint(rendererState.strokePaint);
            if (rendererState.viewPort != null) {
                this.viewPort = new SVG.Box(rendererState.viewPort);
            }
            if (rendererState.viewBox != null) {
                this.viewBox = new SVG.Box(rendererState.viewBox);
            }
            this.spacePreserve = rendererState.spacePreserve;
            try {
                this.style = (SVG.Style) rendererState.style.clone();
            } catch (CloneNotSupportedException e) {
                Log.e(SVGAndroidRenderer.TAG, "Unexpected clone error", e);
                this.style = SVG.Style.getDefaultStyle();
            }
        }
    }

    private void resetState() {
        this.state = new RendererState();
        this.stateStack = new Stack<>();
        updateStyle(this.state, SVG.Style.getDefaultStyle());
        this.state.viewPort = null;
        this.state.spacePreserve = false;
        this.stateStack.push(new RendererState(this.state));
        this.matrixStack = new Stack<>();
        this.parentStack = new Stack<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVGAndroidRenderer(Canvas canvas, float f) {
        this.canvas = canvas;
        this.dpi = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getDPI() {
        return this.dpi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCurrentFontSize() {
        return this.state.fillPaint.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCurrentFontXHeight() {
        return this.state.fillPaint.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVG.Box getCurrentViewPortInUserUnits() {
        if (this.state.viewBox != null) {
            return this.state.viewBox;
        }
        return this.state.viewPort;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void renderDocument(SVG svg, RenderOptions renderOptions) {
        SVG.Box box;
        PreserveAspectRatio preserveAspectRatio;
        if (renderOptions == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.document = svg;
        SVG.Svg rootElement = svg.getRootElement();
        if (rootElement == null) {
            warn("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (renderOptions.hasView()) {
            SVG.SvgElementBase elementById = this.document.getElementById(renderOptions.viewId);
            if (elementById == null || !(elementById instanceof SVG.View)) {
                Log.w(TAG, String.format("View element with id \"%s\" not found.", renderOptions.viewId));
                return;
            }
            SVG.View view = (SVG.View) elementById;
            if (view.viewBox == null) {
                Log.w(TAG, String.format("View element with id \"%s\" is missing a viewBox attribute.", renderOptions.viewId));
                return;
            } else {
                box = view.viewBox;
                preserveAspectRatio = view.preserveAspectRatio;
            }
        } else {
            box = renderOptions.hasViewBox() ? renderOptions.viewBox : rootElement.viewBox;
            preserveAspectRatio = renderOptions.hasPreserveAspectRatio() ? renderOptions.preserveAspectRatio : rootElement.preserveAspectRatio;
        }
        if (renderOptions.hasCss()) {
            svg.addCSSRules(renderOptions.css);
        }
        if (renderOptions.hasTarget()) {
            CSSParser.RuleMatchContext ruleMatchContext = new CSSParser.RuleMatchContext();
            this.ruleMatchContext = ruleMatchContext;
            ruleMatchContext.targetElement = svg.getElementById(renderOptions.targetId);
        }
        resetState();
        checkXMLSpaceAttribute(rootElement);
        statePush();
        SVG.Box box2 = new SVG.Box(renderOptions.viewPort);
        if (rootElement.width != null) {
            box2.width = rootElement.width.floatValue(this, box2.width);
        }
        if (rootElement.height != null) {
            box2.height = rootElement.height.floatValue(this, box2.height);
        }
        render(rootElement, box2, box, preserveAspectRatio);
        statePop();
        if (renderOptions.hasCss()) {
            svg.clearRenderCSSRules();
        }
    }

    private void render(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.NotDirectlyRendered) {
            return;
        }
        statePush();
        checkXMLSpaceAttribute(svgObject);
        if (svgObject instanceof SVG.Svg) {
            render((SVG.Svg) svgObject);
        } else if (svgObject instanceof SVG.Use) {
            render((SVG.Use) svgObject);
        } else if (svgObject instanceof SVG.Switch) {
            render((SVG.Switch) svgObject);
        } else if (svgObject instanceof SVG.Group) {
            render((SVG.Group) svgObject);
        } else if (svgObject instanceof SVG.Image) {
            render((SVG.Image) svgObject);
        } else if (svgObject instanceof SVG.Path) {
            render((SVG.Path) svgObject);
        } else if (svgObject instanceof SVG.Rect) {
            render((SVG.Rect) svgObject);
        } else if (svgObject instanceof SVG.Circle) {
            render((SVG.Circle) svgObject);
        } else if (svgObject instanceof SVG.Ellipse) {
            render((SVG.Ellipse) svgObject);
        } else if (svgObject instanceof SVG.Line) {
            render((SVG.Line) svgObject);
        } else if (svgObject instanceof SVG.Polygon) {
            render((SVG.Polygon) svgObject);
        } else if (svgObject instanceof SVG.PolyLine) {
            render((SVG.PolyLine) svgObject);
        } else if (svgObject instanceof SVG.Text) {
            render((SVG.Text) svgObject);
        }
        statePop();
    }

    private void renderChildren(SVG.SvgContainer svgContainer, boolean z) {
        if (z) {
            parentPush(svgContainer);
        }
        Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            render(it.next());
        }
        if (z) {
            parentPop();
        }
    }

    private void statePush() {
        this.canvas.save();
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private void statePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void parentPush(SVG.SvgContainer svgContainer) {
        this.parentStack.push(svgContainer);
        this.matrixStack.push(this.canvas.getMatrix());
    }

    private void parentPop() {
        this.parentStack.pop();
        this.matrixStack.pop();
    }

    private void updateStyleForElement(RendererState rendererState, SVG.SvgElementBase svgElementBase) {
        rendererState.style.resetNonInheritingProperties(svgElementBase.parent == null);
        if (svgElementBase.baseStyle != null) {
            updateStyle(rendererState, svgElementBase.baseStyle);
        }
        if (this.document.hasCSSRules()) {
            for (CSSParser.Rule rule : this.document.getCSSRules()) {
                if (CSSParser.ruleMatch(this.ruleMatchContext, rule.selector, svgElementBase)) {
                    updateStyle(rendererState, rule.style);
                }
            }
        }
        if (svgElementBase.style != null) {
            updateStyle(rendererState, svgElementBase.style);
        }
    }

    private void checkXMLSpaceAttribute(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.SvgElementBase) {
            SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) svgObject;
            if (svgElementBase.spacePreserve != null) {
                this.state.spacePreserve = svgElementBase.spacePreserve.booleanValue();
            }
        }
    }

    private void doFilledPath(SVG.SvgElement svgElement, Path path) {
        if (this.state.style.fill instanceof SVG.PaintReference) {
            SVG.SvgObject resolveIRI = this.document.resolveIRI(((SVG.PaintReference) this.state.style.fill).href);
            if (resolveIRI instanceof SVG.Pattern) {
                fillWithPattern(svgElement, path, (SVG.Pattern) resolveIRI);
                return;
            }
        }
        this.canvas.drawPath(path, this.state.fillPaint);
    }

    private void doStroke(Path path) {
        if (this.state.style.vectorEffect == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.canvas.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.canvas.setMatrix(new Matrix());
            Shader shader = this.state.strokePaint.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.canvas.drawPath(path2, this.state.strokePaint);
            this.canvas.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.canvas.drawPath(path, this.state.strokePaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void error(String str, Object... objArr) {
        Log.e(TAG, String.format(str, objArr));
    }

    private void render(SVG.Svg svg) {
        render(svg, makeViewPort(svg.f39x, svg.f40y, svg.width, svg.height), svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Box box) {
        render(svg, box, svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        debug("Svg render", new Object[0]);
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        if (preserveAspectRatio == null) {
            preserveAspectRatio = svg.preserveAspectRatio != null ? svg.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        }
        updateStyleForElement(this.state, svg);
        if (display()) {
            this.state.viewPort = box;
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
            }
            checkForClipPath(svg, this.state.viewPort);
            if (box2 != null) {
                this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box2, preserveAspectRatio));
                this.state.viewBox = svg.viewBox;
            } else {
                this.canvas.translate(this.state.viewPort.minX, this.state.viewPort.minY);
            }
            boolean pushLayer = pushLayer();
            viewportFill();
            renderChildren(svg, true);
            if (pushLayer) {
                popLayer(svg);
            }
            updateParentBoundingBox(svg);
        }
    }

    private SVG.Box makeViewPort(SVG.Length length, SVG.Length length2, SVG.Length length3, SVG.Length length4) {
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
        return new SVG.Box(floatValueX, floatValueY, length3 != null ? length3.floatValueX(this) : currentViewPortInUserUnits.width, length4 != null ? length4.floatValueY(this) : currentViewPortInUserUnits.height);
    }

    private void render(SVG.Group group) {
        debug("Group render", new Object[0]);
        updateStyleForElement(this.state, group);
        if (display()) {
            if (group.transform != null) {
                this.canvas.concat(group.transform);
            }
            checkForClipPath(group);
            boolean pushLayer = pushLayer();
            renderChildren(group, true);
            if (pushLayer) {
                popLayer(group);
            }
            updateParentBoundingBox(group);
        }
    }

    private void updateParentBoundingBox(SVG.SvgElement svgElement) {
        if (svgElement.parent == null || svgElement.boundingBox == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.matrixStack.peek().invert(matrix)) {
            float[] fArr = {svgElement.boundingBox.minX, svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.maxY(), svgElement.boundingBox.minX, svgElement.boundingBox.maxY()};
            matrix.preConcat(this.canvas.getMatrix());
            matrix.mapPoints(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            RectF rectF = new RectF(f, f2, f, f2);
            for (int i = 2; i <= 6; i += 2) {
                if (fArr[i] < rectF.left) {
                    rectF.left = fArr[i];
                }
                if (fArr[i] > rectF.right) {
                    rectF.right = fArr[i];
                }
                int i2 = i + 1;
                if (fArr[i2] < rectF.top) {
                    rectF.top = fArr[i2];
                }
                if (fArr[i2] > rectF.bottom) {
                    rectF.bottom = fArr[i2];
                }
            }
            SVG.SvgElement svgElement2 = (SVG.SvgElement) this.parentStack.peek();
            if (svgElement2.boundingBox == null) {
                svgElement2.boundingBox = SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                svgElement2.boundingBox.union(SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private boolean pushLayer() {
        SVG.SvgObject resolveIRI;
        if (!requiresCompositing()) {
            return false;
        }
        this.canvas.saveLayerAlpha(null, clamp255(this.state.style.opacity.floatValue()), 31);
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        if (rendererState.style.mask != null && ((resolveIRI = this.document.resolveIRI(this.state.style.mask)) == null || !(resolveIRI instanceof SVG.Mask))) {
            error("Mask reference '%s' not found", this.state.style.mask);
            this.state.style.mask = null;
        }
        return true;
    }

    private void popLayer(SVG.SvgElement svgElement) {
        popLayer(svgElement, svgElement.boundingBox);
    }

    private void popLayer(SVG.SvgElement svgElement, SVG.Box box) {
        if (this.state.style.mask != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.canvas.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.canvas.saveLayer(null, paint2, 31);
            SVG.Mask mask = (SVG.Mask) this.document.resolveIRI(this.state.style.mask);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.canvas.saveLayer(null, paint3, 31);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            this.canvas.restore();
        }
        statePop();
    }

    private boolean requiresCompositing() {
        return this.state.style.opacity.floatValue() < 1.0f || this.state.style.mask != null;
    }

    private void render(SVG.Switch r3) {
        debug("Switch render", new Object[0]);
        updateStyleForElement(this.state, r3);
        if (display()) {
            if (r3.transform != null) {
                this.canvas.concat(r3.transform);
            }
            checkForClipPath(r3);
            boolean pushLayer = pushLayer();
            renderSwitchChild(r3);
            if (pushLayer) {
                popLayer(r3);
            }
            updateParentBoundingBox(r3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void renderSwitchChild(SVG.Switch r8) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        SVGExternalFileResolver fileResolver = SVG.getFileResolver();
        for (SVG.SvgObject svgObject : r8.getChildren()) {
            if (svgObject instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) svgObject;
                if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                    Set<String> requiredFeatures = svgConditional.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (supportedFeatures == null) {
                            initialiseSupportedFeaturesMap();
                        }
                        if (!requiredFeatures.isEmpty() && supportedFeatures.containsAll(requiredFeatures)) {
                        }
                    }
                    Set<String> requiredFormats = svgConditional.getRequiredFormats();
                    if (requiredFormats != null) {
                        if (!requiredFormats.isEmpty() && fileResolver != null) {
                            Iterator<String> it = requiredFormats.iterator();
                            while (it.hasNext()) {
                                if (!fileResolver.isFormatSupported(it.next())) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> requiredFonts = svgConditional.getRequiredFonts();
                    if (requiredFonts != null) {
                        if (!requiredFonts.isEmpty() && fileResolver != null) {
                            Iterator<String> it2 = requiredFonts.iterator();
                            while (it2.hasNext()) {
                                if (fileResolver.resolveFont(it2.next(), this.state.style.fontWeight.intValue(), String.valueOf(this.state.style.fontStyle)) == null) {
                                    break;
                                }
                            }
                        }
                    }
                    render(svgObject);
                    return;
                }
            }
        }
    }

    private static synchronized void initialiseSupportedFeaturesMap() {
        synchronized (SVGAndroidRenderer.class) {
            HashSet<String> hashSet = new HashSet<>();
            supportedFeatures = hashSet;
            hashSet.add("Structure");
            supportedFeatures.add("BasicStructure");
            supportedFeatures.add("ConditionalProcessing");
            supportedFeatures.add("Image");
            supportedFeatures.add("Style");
            supportedFeatures.add("ViewportAttribute");
            supportedFeatures.add("Shape");
            supportedFeatures.add("BasicText");
            supportedFeatures.add("PaintAttribute");
            supportedFeatures.add("BasicPaintAttribute");
            supportedFeatures.add("OpacityAttribute");
            supportedFeatures.add("BasicGraphicsAttribute");
            supportedFeatures.add("Marker");
            supportedFeatures.add("Gradient");
            supportedFeatures.add("Pattern");
            supportedFeatures.add("Clip");
            supportedFeatures.add("BasicClip");
            supportedFeatures.add("Mask");
            supportedFeatures.add("View");
        }
    }

    private void render(SVG.Use use) {
        debug("Use render", new Object[0]);
        if (use.width == null || !use.width.isZero()) {
            if (use.height == null || !use.height.isZero()) {
                updateStyleForElement(this.state, use);
                if (display()) {
                    SVG.SvgObject resolveIRI = use.document.resolveIRI(use.href);
                    if (resolveIRI == null) {
                        error("Use reference '%s' not found", use.href);
                        return;
                    }
                    if (use.transform != null) {
                        this.canvas.concat(use.transform);
                    }
                    this.canvas.translate(use.f63x != null ? use.f63x.floatValueX(this) : 0.0f, use.f64y != null ? use.f64y.floatValueY(this) : 0.0f);
                    checkForClipPath(use);
                    boolean pushLayer = pushLayer();
                    parentPush(use);
                    if (resolveIRI instanceof SVG.Svg) {
                        SVG.Box makeViewPort = makeViewPort(null, null, use.width, use.height);
                        statePush();
                        render((SVG.Svg) resolveIRI, makeViewPort);
                        statePop();
                    } else if (resolveIRI instanceof SVG.Symbol) {
                        SVG.Box makeViewPort2 = makeViewPort(null, null, use.width != null ? use.width : new SVG.Length(100.0f, SVG.Unit.percent), use.height != null ? use.height : new SVG.Length(100.0f, SVG.Unit.percent));
                        statePush();
                        render((SVG.Symbol) resolveIRI, makeViewPort2);
                        statePop();
                    } else {
                        render(resolveIRI);
                    }
                    parentPop();
                    if (pushLayer) {
                        popLayer(use);
                    }
                    updateParentBoundingBox(use);
                }
            }
        }
    }

    private void render(SVG.Path path) {
        debug("Path render", new Object[0]);
        if (path.f32d == null) {
            return;
        }
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (path.transform != null) {
                    this.canvas.concat(path.transform);
                }
                Path path2 = new PathConverter(path.f32d).getPath();
                if (path.boundingBox == null) {
                    path.boundingBox = calculatePathBounds(path2);
                }
                updateParentBoundingBox(path);
                checkForGradientsAndPatterns(path);
                checkForClipPath(path);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    path2.setFillType(getFillTypeFromState());
                    doFilledPath(path, path2);
                }
                if (this.state.hasStroke) {
                    doStroke(path2);
                }
                renderMarkers(path);
                if (pushLayer) {
                    popLayer(path);
                }
            }
        }
    }

    private SVG.Box calculatePathBounds(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private void render(SVG.Rect rect) {
        debug("Rect render", new Object[0]);
        if (rect.width == null || rect.height == null || rect.width.isZero() || rect.height.isZero()) {
            return;
        }
        updateStyleForElement(this.state, rect);
        if (display() && visible()) {
            if (rect.transform != null) {
                this.canvas.concat(rect.transform);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(rect);
            updateParentBoundingBox(rect);
            checkForGradientsAndPatterns(rect);
            checkForClipPath(rect);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(rect, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(rect);
            }
        }
    }

    private void render(SVG.Circle circle) {
        debug("Circle render", new Object[0]);
        if (circle.f19r == null || circle.f19r.isZero()) {
            return;
        }
        updateStyleForElement(this.state, circle);
        if (display() && visible()) {
            if (circle.transform != null) {
                this.canvas.concat(circle.transform);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(circle);
            updateParentBoundingBox(circle);
            checkForGradientsAndPatterns(circle);
            checkForClipPath(circle);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(circle, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(circle);
            }
        }
    }

    private void render(SVG.Ellipse ellipse) {
        debug("Ellipse render", new Object[0]);
        if (ellipse.f22rx == null || ellipse.f23ry == null || ellipse.f22rx.isZero() || ellipse.f23ry.isZero()) {
            return;
        }
        updateStyleForElement(this.state, ellipse);
        if (display() && visible()) {
            if (ellipse.transform != null) {
                this.canvas.concat(ellipse.transform);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(ellipse);
            updateParentBoundingBox(ellipse);
            checkForGradientsAndPatterns(ellipse);
            checkForClipPath(ellipse);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(ellipse, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(ellipse);
            }
        }
    }

    private void render(SVG.Line line) {
        debug("Line render", new Object[0]);
        updateStyleForElement(this.state, line);
        if (display() && visible() && this.state.hasStroke) {
            if (line.transform != null) {
                this.canvas.concat(line.transform);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(line);
            updateParentBoundingBox(line);
            checkForGradientsAndPatterns(line);
            checkForClipPath(line);
            boolean pushLayer = pushLayer();
            doStroke(makePathAndBoundingBox);
            renderMarkers(line);
            if (pushLayer) {
                popLayer(line);
            }
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.Line line) {
        float floatValueX = line.f26x1 != null ? line.f26x1.floatValueX(this) : 0.0f;
        float floatValueY = line.f28y1 != null ? line.f28y1.floatValueY(this) : 0.0f;
        float floatValueX2 = line.f27x2 != null ? line.f27x2.floatValueX(this) : 0.0f;
        float floatValueY2 = line.f29y2 != null ? line.f29y2.floatValueY(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f = floatValueX2 - floatValueX;
        float f2 = floatValueY2 - floatValueY;
        arrayList.add(new MarkerVector(floatValueX, floatValueY, f, f2));
        arrayList.add(new MarkerVector(floatValueX2, floatValueY2, f, f2));
        return arrayList;
    }

    private void render(SVG.PolyLine polyLine) {
        debug("PolyLine render", new Object[0]);
        updateStyleForElement(this.state, polyLine);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (polyLine.transform != null) {
                    this.canvas.concat(polyLine.transform);
                }
                if (polyLine.points.length < 2) {
                    return;
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(polyLine);
                updateParentBoundingBox(polyLine);
                makePathAndBoundingBox.setFillType(getFillTypeFromState());
                checkForGradientsAndPatterns(polyLine);
                checkForClipPath(polyLine);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polyLine, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                renderMarkers(polyLine);
                if (pushLayer) {
                    popLayer(polyLine);
                }
            }
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.PolyLine polyLine) {
        int length = polyLine.points.length;
        int i = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        MarkerVector markerVector = new MarkerVector(polyLine.points[0], polyLine.points[1], 0.0f, 0.0f);
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < length) {
            f = polyLine.points[i];
            f2 = polyLine.points[i + 1];
            markerVector.add(f, f2);
            arrayList.add(markerVector);
            i += 2;
            markerVector = new MarkerVector(f, f2, f - markerVector.f67x, f2 - markerVector.f68y);
        }
        if (!(polyLine instanceof SVG.Polygon)) {
            arrayList.add(markerVector);
        } else if (f != polyLine.points[0] && f2 != polyLine.points[1]) {
            float f3 = polyLine.points[0];
            float f4 = polyLine.points[1];
            markerVector.add(f3, f4);
            arrayList.add(markerVector);
            MarkerVector markerVector2 = new MarkerVector(f3, f4, f3 - markerVector.f67x, f4 - markerVector.f68y);
            markerVector2.add((MarkerVector) arrayList.get(0));
            arrayList.add(markerVector2);
            arrayList.set(0, markerVector2);
        }
        return arrayList;
    }

    private void render(SVG.Polygon polygon) {
        debug("Polygon render", new Object[0]);
        updateStyleForElement(this.state, polygon);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (polygon.transform != null) {
                    this.canvas.concat(polygon.transform);
                }
                if (polygon.points.length < 2) {
                    return;
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(polygon);
                updateParentBoundingBox(polygon);
                checkForGradientsAndPatterns(polygon);
                checkForClipPath(polygon);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polygon, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                renderMarkers(polygon);
                if (pushLayer) {
                    popLayer(polygon);
                }
            }
        }
    }

    private void render(SVG.Text text) {
        debug("Text render", new Object[0]);
        updateStyleForElement(this.state, text);
        if (display()) {
            if (text.transform != null) {
                this.canvas.concat(text.transform);
            }
            float f = 0.0f;
            float floatValueX = (text.f53x == null || text.f53x.size() == 0) ? 0.0f : text.f53x.get(0).floatValueX(this);
            float floatValueY = (text.f54y == null || text.f54y.size() == 0) ? 0.0f : text.f54y.get(0).floatValueY(this);
            float floatValueX2 = (text.f51dx == null || text.f51dx.size() == 0) ? 0.0f : text.f51dx.get(0).floatValueX(this);
            if (text.f52dy != null && text.f52dy.size() != 0) {
                f = text.f52dy.get(0).floatValueY(this);
            }
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(text);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValueX -= calculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
                enumerateTextSpans(text, textBoundsCalculator);
                text.boundingBox = new SVG.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
            }
            updateParentBoundingBox(text);
            checkForGradientsAndPatterns(text);
            checkForClipPath(text);
            boolean pushLayer = pushLayer();
            enumerateTextSpans(text, new PlainTextDrawer(floatValueX + floatValueX2, floatValueY + f));
            if (pushLayer) {
                popLayer(text);
            }
        }
    }

    private SVG.Style.TextAnchor getAnchorPosition() {
        if (this.state.style.direction == SVG.Style.TextDirection.LTR || this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
            return this.state.style.textAnchor;
        }
        return this.state.style.textAnchor == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class PlainTextDrawer extends TextProcessor {

        /* renamed from: x */
        float f69x;

        /* renamed from: y */
        float f70y;

        PlainTextDrawer(float f, float f2) {
            super(SVGAndroidRenderer.this, null);
            this.f69x = f;
            this.f70y = f2;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            SVGAndroidRenderer.debug("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.f69x, this.f70y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.f69x, this.f70y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f69x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public abstract class TextProcessor {
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            return true;
        }

        public abstract void processText(String str);

        private TextProcessor() {
        }

        /* synthetic */ TextProcessor(SVGAndroidRenderer sVGAndroidRenderer, C00851 c00851) {
            this();
        }
    }

    private void enumerateTextSpans(SVG.TextContainer textContainer, TextProcessor textProcessor) {
        if (display()) {
            Iterator<SVG.SvgObject> it = textContainer.children.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.SvgObject next = it.next();
                if (next instanceof SVG.TextSequence) {
                    textProcessor.processText(textXMLSpaceTransform(((SVG.TextSequence) next).text, z, !it.hasNext()));
                } else {
                    processTextChild(next, textProcessor);
                }
                z = false;
            }
        }
    }

    private void processTextChild(SVG.SvgObject svgObject, TextProcessor textProcessor) {
        float f;
        float f2;
        float f3;
        SVG.Style.TextAnchor anchorPosition;
        if (textProcessor.doTextContainer((SVG.TextContainer) svgObject)) {
            if (svgObject instanceof SVG.TextPath) {
                statePush();
                renderTextPath((SVG.TextPath) svgObject);
                statePop();
                return;
            }
            if (svgObject instanceof SVG.TSpan) {
                debug("TSpan render", new Object[0]);
                statePush();
                SVG.TSpan tSpan = (SVG.TSpan) svgObject;
                updateStyleForElement(this.state, tSpan);
                if (display()) {
                    boolean z = tSpan.f53x != null && tSpan.f53x.size() > 0;
                    boolean z2 = textProcessor instanceof PlainTextDrawer;
                    float f4 = 0.0f;
                    if (z2) {
                        float floatValueX = !z ? ((PlainTextDrawer) textProcessor).f69x : tSpan.f53x.get(0).floatValueX(this);
                        f2 = (tSpan.f54y == null || tSpan.f54y.size() == 0) ? ((PlainTextDrawer) textProcessor).f70y : tSpan.f54y.get(0).floatValueY(this);
                        f3 = (tSpan.f51dx == null || tSpan.f51dx.size() == 0) ? 0.0f : tSpan.f51dx.get(0).floatValueX(this);
                        if (tSpan.f52dy != null && tSpan.f52dy.size() != 0) {
                            f4 = tSpan.f52dy.get(0).floatValueY(this);
                        }
                        f = f4;
                        f4 = floatValueX;
                    } else {
                        f = 0.0f;
                        f2 = 0.0f;
                        f3 = 0.0f;
                    }
                    if (z && (anchorPosition = getAnchorPosition()) != SVG.Style.TextAnchor.Start) {
                        float calculateTextWidth = calculateTextWidth(tSpan);
                        if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                            calculateTextWidth /= 2.0f;
                        }
                        f4 -= calculateTextWidth;
                    }
                    checkForGradientsAndPatterns((SVG.SvgElement) tSpan.getTextRoot());
                    if (z2) {
                        PlainTextDrawer plainTextDrawer = (PlainTextDrawer) textProcessor;
                        plainTextDrawer.f69x = f4 + f3;
                        plainTextDrawer.f70y = f2 + f;
                    }
                    boolean pushLayer = pushLayer();
                    enumerateTextSpans(tSpan, textProcessor);
                    if (pushLayer) {
                        popLayer(tSpan);
                    }
                }
                statePop();
                return;
            }
            if (svgObject instanceof SVG.TRef) {
                statePush();
                SVG.TRef tRef = (SVG.TRef) svgObject;
                updateStyleForElement(this.state, tRef);
                if (display()) {
                    checkForGradientsAndPatterns((SVG.SvgElement) tRef.getTextRoot());
                    SVG.SvgObject resolveIRI = svgObject.document.resolveIRI(tRef.href);
                    if (resolveIRI == null || !(resolveIRI instanceof SVG.TextContainer)) {
                        error("Tref reference '%s' not found", tRef.href);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        extractRawText((SVG.TextContainer) resolveIRI, sb);
                        if (sb.length() > 0) {
                            textProcessor.processText(sb.toString());
                        }
                    }
                }
                statePop();
            }
        }
    }

    private void renderTextPath(SVG.TextPath textPath) {
        debug("TextPath render", new Object[0]);
        updateStyleForElement(this.state, textPath);
        if (display() && visible()) {
            SVG.SvgObject resolveIRI = textPath.document.resolveIRI(textPath.href);
            if (resolveIRI == null) {
                error("TextPath reference '%s' not found", textPath.href);
                return;
            }
            SVG.Path path = (SVG.Path) resolveIRI;
            Path path2 = new PathConverter(path.f32d).getPath();
            if (path.transform != null) {
                path2.transform(path.transform);
            }
            float floatValue = textPath.startOffset != null ? textPath.startOffset.floatValue(this, new PathMeasure(path2, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(textPath);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValue -= calculateTextWidth;
            }
            checkForGradientsAndPatterns((SVG.SvgElement) textPath.getTextRoot());
            boolean pushLayer = pushLayer();
            enumerateTextSpans(textPath, new PathTextDrawer(path2, floatValue, 0.0f));
            if (pushLayer) {
                popLayer(textPath);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class PathTextDrawer extends PlainTextDrawer {
        private Path path;

        PathTextDrawer(Path path, float f, float f2) {
            super(f, f2);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.PlainTextDrawer, com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.f69x, this.f70y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.f69x, this.f70y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f69x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private float calculateTextWidth(SVG.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator(this, null);
        enumerateTextSpans(textContainer, textWidthCalculator);
        return textWidthCalculator.f75x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class TextWidthCalculator extends TextProcessor {

        /* renamed from: x */
        float f75x;

        private TextWidthCalculator() {
            super(SVGAndroidRenderer.this, null);
            this.f75x = 0.0f;
        }

        /* synthetic */ TextWidthCalculator(SVGAndroidRenderer sVGAndroidRenderer, C00851 c00851) {
            this();
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            this.f75x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class TextBoundsCalculator extends TextProcessor {
        RectF bbox;

        /* renamed from: x */
        float f73x;

        /* renamed from: y */
        float f74y;

        TextBoundsCalculator(float f, float f2) {
            super(SVGAndroidRenderer.this, null);
            this.bbox = new RectF();
            this.f73x = f;
            this.f74y = f2;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVG.TextPath textPath = (SVG.TextPath) textContainer;
            SVG.SvgObject resolveIRI = textContainer.document.resolveIRI(textPath.href);
            if (resolveIRI == null) {
                SVGAndroidRenderer.error("TextPath path reference '%s' not found", textPath.href);
                return false;
            }
            SVG.Path path = (SVG.Path) resolveIRI;
            Path path2 = new PathConverter(path.f32d).getPath();
            if (path.transform != null) {
                path2.transform(path.transform);
            }
            RectF rectF = new RectF();
            path2.computeBounds(rectF, true);
            this.bbox.union(rectF);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.state.fillPaint.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f73x, this.f74y);
                this.bbox.union(rectF);
            }
            this.f73x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private void extractRawText(SVG.TextContainer textContainer, StringBuilder sb) {
        Iterator<SVG.SvgObject> it = textContainer.children.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.SvgObject next = it.next();
            if (next instanceof SVG.TextContainer) {
                extractRawText((SVG.TextContainer) next, sb);
            } else if (next instanceof SVG.TextSequence) {
                sb.append(textXMLSpaceTransform(((SVG.TextSequence) next).text, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private String textXMLSpaceTransform(String str, boolean z, boolean z2) {
        if (this.state.spacePreserve) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    private void render(SVG.Symbol symbol, SVG.Box box) {
        debug("Symbol render", new Object[0]);
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = symbol.preserveAspectRatio != null ? symbol.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        updateStyleForElement(this.state, symbol);
        this.state.viewPort = box;
        if (!this.state.style.overflow.booleanValue()) {
            setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
        }
        if (symbol.viewBox != null) {
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, symbol.viewBox, preserveAspectRatio));
            this.state.viewBox = symbol.viewBox;
        } else {
            this.canvas.translate(this.state.viewPort.minX, this.state.viewPort.minY);
        }
        boolean pushLayer = pushLayer();
        renderChildren(symbol, true);
        if (pushLayer) {
            popLayer(symbol);
        }
        updateParentBoundingBox(symbol);
    }

    private void render(SVG.Image image) {
        debug("Image render", new Object[0]);
        if (image.width == null || image.width.isZero() || image.height == null || image.height.isZero() || image.href == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = image.preserveAspectRatio != null ? image.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        Bitmap checkForImageDataURL = checkForImageDataURL(image.href);
        if (checkForImageDataURL == null) {
            SVGExternalFileResolver fileResolver = SVG.getFileResolver();
            if (fileResolver == null) {
                return;
            } else {
                checkForImageDataURL = fileResolver.resolveImage(image.href);
            }
        }
        if (checkForImageDataURL == null) {
            error("Could not locate image '%s'", image.href);
            return;
        }
        SVG.Box box = new SVG.Box(0.0f, 0.0f, checkForImageDataURL.getWidth(), checkForImageDataURL.getHeight());
        updateStyleForElement(this.state, image);
        if (display() && visible()) {
            if (image.transform != null) {
                this.canvas.concat(image.transform);
            }
            this.state.viewPort = new SVG.Box(image.f24x != null ? image.f24x.floatValueX(this) : 0.0f, image.f25y != null ? image.f25y.floatValueY(this) : 0.0f, image.width.floatValueX(this), image.height.floatValueX(this));
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
            }
            image.boundingBox = this.state.viewPort;
            updateParentBoundingBox(image);
            checkForClipPath(image);
            boolean pushLayer = pushLayer();
            viewportFill();
            this.canvas.save();
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box, preserveAspectRatio));
            this.canvas.drawBitmap(checkForImageDataURL, 0.0f, 0.0f, new Paint(this.state.style.imageRendering != SVG.Style.RenderQuality.optimizeSpeed ? 2 : 0));
            this.canvas.restore();
            if (pushLayer) {
                popLayer(image);
            }
        }
    }

    private Bitmap checkForImageDataURL(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            Log.e(TAG, "Could not decode bad Data URL", e);
            return null;
        }
    }

    private boolean display() {
        if (this.state.style.display != null) {
            return this.state.style.display.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean visible() {
        if (this.state.style.visibility != null) {
            return this.state.style.visibility.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        if (r11 != 8) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Matrix calculateViewBoxTransform(SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        float f;
        float f2;
        Matrix matrix = new Matrix();
        if (preserveAspectRatio != null && preserveAspectRatio.getAlignment() != null) {
            float f3 = box.width / box2.width;
            float f4 = box.height / box2.height;
            float f5 = -box2.minX;
            float f6 = -box2.minY;
            if (preserveAspectRatio.equals(PreserveAspectRatio.STRETCH)) {
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(f3, f4);
                matrix.preTranslate(f5, f6);
                return matrix;
            }
            float max = preserveAspectRatio.getScale() == PreserveAspectRatio.Scale.slice ? Math.max(f3, f4) : Math.min(f3, f4);
            float f7 = box.width / max;
            float f8 = box.height / max;
            switch (C00851.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[preserveAspectRatio.getAlignment().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    f2 = (box2.width - f7) / 2.0f;
                    break;
                case 4:
                case 5:
                case 6:
                    f2 = box2.width - f7;
                    break;
            }
            f5 -= f2;
            int i = C00851.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[preserveAspectRatio.getAlignment().ordinal()];
            if (i != 2) {
                if (i != 3) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i != 7) {
                            }
                        }
                    }
                }
                f = box2.height - f8;
                f6 -= f;
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(max, max);
                matrix.preTranslate(f5, f6);
            }
            f = (box2.height - f8) / 2.0f;
            f6 -= f;
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(max, max);
            matrix.preTranslate(f5, f6);
        }
        return matrix;
    }

    private boolean isSpecified(SVG.Style style, long j) {
        return (style.specifiedFlags & j) != 0;
    }

    private void updateStyle(RendererState rendererState, SVG.Style style) {
        if (isSpecified(style, 4096L)) {
            rendererState.style.color = style.color;
        }
        if (isSpecified(style, 2048L)) {
            rendererState.style.opacity = style.opacity;
        }
        if (isSpecified(style, 1L)) {
            rendererState.style.fill = style.fill;
            rendererState.hasFill = (style.fill == null || style.fill == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 4L)) {
            rendererState.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149L)) {
            setPaintColour(rendererState, true, rendererState.style.fill);
        }
        if (isSpecified(style, 2L)) {
            rendererState.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8L)) {
            rendererState.style.stroke = style.stroke;
            rendererState.hasStroke = (style.stroke == null || style.stroke == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 16L)) {
            rendererState.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168L)) {
            setPaintColour(rendererState, false, rendererState.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            rendererState.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32L)) {
            rendererState.style.strokeWidth = style.strokeWidth;
            rendererState.strokePaint.setStrokeWidth(rendererState.style.strokeWidth.floatValue(this));
        }
        if (isSpecified(style, 64L)) {
            rendererState.style.strokeLineCap = style.strokeLineCap;
            int i = C00851.$SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[style.strokeLineCap.ordinal()];
            if (i == 1) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.BUTT);
            } else if (i == 2) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.ROUND);
            } else if (i == 3) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (isSpecified(style, 128L)) {
            rendererState.style.strokeLineJoin = style.strokeLineJoin;
            int i2 = C00851.$SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[style.strokeLineJoin.ordinal()];
            if (i2 == 1) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.MITER);
            } else if (i2 == 2) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.ROUND);
            } else if (i2 == 3) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (isSpecified(style, 256L)) {
            rendererState.style.strokeMiterLimit = style.strokeMiterLimit;
            rendererState.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512L)) {
            rendererState.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024L)) {
            rendererState.style.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typeface = null;
        if (isSpecified(style, 1536L)) {
            if (rendererState.style.strokeDashArray == null) {
                rendererState.strokePaint.setPathEffect(null);
            } else {
                int length = rendererState.style.strokeDashArray.length;
                int i3 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i3];
                float f = 0.0f;
                for (int i4 = 0; i4 < i3; i4++) {
                    float floatValue = rendererState.style.strokeDashArray[i4 % length].floatValue(this);
                    fArr[i4] = floatValue;
                    f += floatValue;
                }
                if (f == 0.0f) {
                    rendererState.strokePaint.setPathEffect(null);
                } else {
                    float floatValue2 = rendererState.style.strokeDashOffset.floatValue(this);
                    if (floatValue2 < 0.0f) {
                        floatValue2 = (floatValue2 % f) + f;
                    }
                    rendererState.strokePaint.setPathEffect(new DashPathEffect(fArr, floatValue2));
                }
            }
        }
        if (isSpecified(style, 16384L)) {
            float currentFontSize = getCurrentFontSize();
            rendererState.style.fontSize = style.fontSize;
            rendererState.fillPaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
            rendererState.strokePaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
        }
        if (isSpecified(style, 8192L)) {
            rendererState.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, 32768L)) {
            if (style.fontWeight.intValue() == -1 && rendererState.style.fontWeight.intValue() > 100) {
                SVG.Style style2 = rendererState.style;
                style2.fontWeight = Integer.valueOf(style2.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() == 1 && rendererState.style.fontWeight.intValue() < 900) {
                SVG.Style style3 = rendererState.style;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() + 100);
            } else {
                rendererState.style.fontWeight = style.fontWeight;
            }
        }
        if (isSpecified(style, 65536L)) {
            rendererState.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 106496L)) {
            if (rendererState.style.fontFamily != null && this.document != null) {
                SVGExternalFileResolver fileResolver = SVG.getFileResolver();
                for (String str : rendererState.style.fontFamily) {
                    Typeface checkGenericFont = checkGenericFont(str, rendererState.style.fontWeight, rendererState.style.fontStyle);
                    typeface = (checkGenericFont != null || fileResolver == null) ? checkGenericFont : fileResolver.resolveFont(str, rendererState.style.fontWeight.intValue(), String.valueOf(rendererState.style.fontStyle));
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                typeface = checkGenericFont(DEFAULT_FONT_FAMILY, rendererState.style.fontWeight, rendererState.style.fontStyle);
            }
            rendererState.fillPaint.setTypeface(typeface);
            rendererState.strokePaint.setTypeface(typeface);
        }
        if (isSpecified(style, 131072L)) {
            rendererState.style.textDecoration = style.textDecoration;
            rendererState.fillPaint.setStrikeThruText(style.textDecoration == SVG.Style.TextDecoration.LineThrough);
            rendererState.fillPaint.setUnderlineText(style.textDecoration == SVG.Style.TextDecoration.Underline);
            rendererState.strokePaint.setStrikeThruText(style.textDecoration == SVG.Style.TextDecoration.LineThrough);
            rendererState.strokePaint.setUnderlineText(style.textDecoration == SVG.Style.TextDecoration.Underline);
        }
        if (isSpecified(style, 68719476736L)) {
            rendererState.style.direction = style.direction;
        }
        if (isSpecified(style, 262144L)) {
            rendererState.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, 524288L)) {
            rendererState.style.overflow = style.overflow;
        }
        if (isSpecified(style, ImagePipelineConfig.DEFAULT_BIG_IMG_SIZE_LIMIT)) {
            rendererState.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, 4194304L)) {
            rendererState.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, 8388608L)) {
            rendererState.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216L)) {
            rendererState.style.display = style.display;
        }
        if (isSpecified(style, 33554432L)) {
            rendererState.style.visibility = style.visibility;
        }
        if (isSpecified(style, 1048576L)) {
            rendererState.style.clip = style.clip;
        }
        if (isSpecified(style, 268435456L)) {
            rendererState.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912L)) {
            rendererState.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, 1073741824L)) {
            rendererState.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864L)) {
            rendererState.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728L)) {
            rendererState.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            rendererState.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            rendererState.style.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (isSpecified(style, 137438953472L)) {
            rendererState.style.imageRendering = style.imageRendering;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.SVGAndroidRenderer$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C00851 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin;

        static {
            int[] iArr = new int[SVG.Style.LineJoin.values().length];
            $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin = iArr;
            try {
                iArr[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SVG.Style.LineCap.values().length];
            $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap = iArr2;
            try {
                iArr2[SVG.Style.LineCap.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[SVG.Style.LineCap.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[SVG.Style.LineCap.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[PreserveAspectRatio.Alignment.values().length];
            $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment = iArr3;
            try {
                iArr3[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private void setPaintColour(RendererState rendererState, boolean z, SVG.SvgPaint svgPaint) {
        int i;
        SVG.Style style = rendererState.style;
        float floatValue = (z ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i = rendererState.style.color.colour;
        }
        int colourWithOpacity = colourWithOpacity(i, floatValue);
        if (z) {
            rendererState.fillPaint.setColor(colourWithOpacity);
        } else {
            rendererState.strokePaint.setColor(colourWithOpacity);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0053, code lost:
    
        if (r6.equals("monospace") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Typeface checkGenericFont(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        char c = 1;
        boolean z = fontStyle == SVG.Style.FontStyle.Italic;
        int i = num.intValue() > 500 ? z ? 3 : 1 : z ? 2 : 0;
        str.hashCode();
        switch (str.hashCode()) {
            case -1536685117:
                if (str.equals("sans-serif")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1431958525:
                break;
            case -1081737434:
                if (str.equals("fantasy")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 109326717:
                if (str.equals(DEFAULT_FONT_FAMILY)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1126973893:
                if (str.equals("cursive")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return Typeface.create(Typeface.SANS_SERIF, i);
            case 1:
                return Typeface.create(Typeface.MONOSPACE, i);
            case 2:
                return Typeface.create(Typeface.SANS_SERIF, i);
            case 3:
                return Typeface.create(Typeface.SERIF, i);
            case 4:
                return Typeface.create(Typeface.SANS_SERIF, i);
            default:
                return null;
        }
    }

    private static int colourWithOpacity(int i, float f) {
        int i2 = JfifUtil.MARKER_FIRST_BYTE;
        int round = Math.round(((i >> 24) & JfifUtil.MARKER_FIRST_BYTE) * f);
        if (round < 0) {
            i2 = 0;
        } else if (round <= 255) {
            i2 = round;
        }
        return (i & 16777215) | (i2 << 24);
    }

    private Path.FillType getFillTypeFromState() {
        if (this.state.style.fillRule != null && this.state.style.fillRule == SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void setClipRect(float f, float f2, float f3, float f4) {
        float f5 = f3 + f;
        float f6 = f4 + f2;
        if (this.state.style.clip != null) {
            f += this.state.style.clip.left.floatValueX(this);
            f2 += this.state.style.clip.top.floatValueY(this);
            f5 -= this.state.style.clip.right.floatValueX(this);
            f6 -= this.state.style.clip.bottom.floatValueY(this);
        }
        this.canvas.clipRect(f, f2, f5, f6);
    }

    private void viewportFill() {
        int i;
        if (this.state.style.viewportFill instanceof SVG.Colour) {
            i = ((SVG.Colour) this.state.style.viewportFill).colour;
        } else if (!(this.state.style.viewportFill instanceof SVG.CurrentColor)) {
            return;
        } else {
            i = this.state.style.color.colour;
        }
        if (this.state.style.viewportFillOpacity != null) {
            i = colourWithOpacity(i, this.state.style.viewportFillOpacity.floatValue());
        }
        this.canvas.drawColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class PathConverter implements SVG.PathInterface {
        float lastX;
        float lastY;
        Path path = new Path();

        PathConverter(SVG.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.enumeratePath(this);
        }

        Path getPath() {
            return this.path;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            this.path.moveTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            this.path.lineTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.path.cubicTo(f, f2, f3, f4, f5, f6);
            this.lastX = f5;
            this.lastY = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.path.quadTo(f, f2, f3, f4);
            this.lastX = f3;
            this.lastY = f4;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            SVGAndroidRenderer.arcTo(this.lastX, this.lastY, f, f2, f3, z, z2, f4, f5, this);
            this.lastX = f4;
            this.lastY = f5;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.path.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void arcTo(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, float f6, float f7, SVG.PathInterface pathInterface) {
        float f8;
        SVG.PathInterface pathInterface2;
        if (f == f6 && f2 == f7) {
            return;
        }
        if (f3 == 0.0f) {
            f8 = f6;
            pathInterface2 = pathInterface;
        } else {
            if (f4 != 0.0f) {
                float abs = Math.abs(f3);
                float abs2 = Math.abs(f4);
                double radians = Math.toRadians(f5 % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d = (f - f6) / 2.0d;
                double d2 = (f2 - f7) / 2.0d;
                double d3 = (cos * d) + (sin * d2);
                double d4 = ((-sin) * d) + (d2 * cos);
                double d5 = abs * abs;
                double d6 = abs2 * abs2;
                double d7 = d3 * d3;
                double d8 = d4 * d4;
                double d9 = (d7 / d5) + (d8 / d6);
                if (d9 > 0.99999d) {
                    double sqrt = Math.sqrt(d9) * 1.00001d;
                    abs = (float) (abs * sqrt);
                    abs2 = (float) (sqrt * abs2);
                    d5 = abs * abs;
                    d6 = abs2 * abs2;
                }
                double d10 = z == z2 ? -1.0d : 1.0d;
                double d11 = d5 * d6;
                double d12 = d5 * d8;
                double d13 = d6 * d7;
                double d14 = ((d11 - d12) - d13) / (d12 + d13);
                if (d14 < 0.0d) {
                    d14 = 0.0d;
                }
                double sqrt2 = d10 * Math.sqrt(d14);
                double d15 = abs;
                double d16 = abs2;
                double d17 = ((d15 * d4) / d16) * sqrt2;
                float f9 = abs;
                float f10 = abs2;
                double d18 = sqrt2 * (-((d16 * d3) / d15));
                double d19 = ((f + f6) / 2.0d) + ((cos * d17) - (sin * d18));
                double d20 = ((f2 + f7) / 2.0d) + (sin * d17) + (cos * d18);
                double d21 = (d3 - d17) / d15;
                double d22 = (d4 - d18) / d16;
                double d23 = ((-d3) - d17) / d15;
                double d24 = ((-d4) - d18) / d16;
                double d25 = (d21 * d21) + (d22 * d22);
                double acos = (d22 < 0.0d ? -1.0d : 1.0d) * Math.acos(d21 / Math.sqrt(d25));
                double checkedArcCos = ((d21 * d24) - (d22 * d23) >= 0.0d ? 1.0d : -1.0d) * checkedArcCos(((d21 * d23) + (d22 * d24)) / Math.sqrt(d25 * ((d23 * d23) + (d24 * d24))));
                if (!z2 && checkedArcCos > 0.0d) {
                    checkedArcCos -= 6.283185307179586d;
                } else if (z2 && checkedArcCos < 0.0d) {
                    checkedArcCos += 6.283185307179586d;
                }
                float[] arcToBeziers = arcToBeziers(acos % 6.283185307179586d, checkedArcCos % 6.283185307179586d);
                Matrix matrix = new Matrix();
                matrix.postScale(f9, f10);
                matrix.postRotate(f5);
                matrix.postTranslate((float) d19, (float) d20);
                matrix.mapPoints(arcToBeziers);
                arcToBeziers[arcToBeziers.length - 2] = f6;
                arcToBeziers[arcToBeziers.length - 1] = f7;
                for (int i = 0; i < arcToBeziers.length; i += 6) {
                    pathInterface.cubicTo(arcToBeziers[i], arcToBeziers[i + 1], arcToBeziers[i + 2], arcToBeziers[i + 3], arcToBeziers[i + 4], arcToBeziers[i + 5]);
                }
                return;
            }
            pathInterface2 = pathInterface;
            f8 = f6;
        }
        pathInterface2.lineTo(f8, f7);
    }

    private static double checkedArcCos(double d) {
        if (d < -1.0d) {
            return 3.141592653589793d;
        }
        if (d > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d);
    }

    private static float[] arcToBeziers(double d, double d2) {
        int ceil = (int) Math.ceil((Math.abs(d2) * 2.0d) / 3.141592653589793d);
        double d3 = d2 / ceil;
        double d4 = d3 / 2.0d;
        double sin = (Math.sin(d4) * 1.3333333333333333d) / (Math.cos(d4) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i = 0;
        for (int i2 = 0; i2 < ceil; i2++) {
            double d5 = d + (i2 * d3);
            double cos = Math.cos(d5);
            double sin2 = Math.sin(d5);
            int i3 = i + 1;
            fArr[i] = (float) (cos - (sin * sin2));
            int i4 = i3 + 1;
            fArr[i3] = (float) (sin2 + (cos * sin));
            d3 = d3;
            double d6 = d5 + d3;
            double cos2 = Math.cos(d6);
            double sin3 = Math.sin(d6);
            int i5 = i4 + 1;
            fArr[i4] = (float) ((sin * sin3) + cos2);
            int i6 = i5 + 1;
            fArr[i5] = (float) (sin3 - (sin * cos2));
            int i7 = i6 + 1;
            fArr[i6] = (float) cos2;
            i = i7 + 1;
            fArr[i7] = (float) sin3;
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class MarkerVector {

        /* renamed from: dx */
        float f65dx;

        /* renamed from: dy */
        float f66dy;
        boolean isAmbiguous = false;

        /* renamed from: x */
        float f67x;

        /* renamed from: y */
        float f68y;

        MarkerVector(float f, float f2, float f3, float f4) {
            this.f65dx = 0.0f;
            this.f66dy = 0.0f;
            this.f67x = f;
            this.f68y = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.f65dx = (float) (f3 / sqrt);
                this.f66dy = (float) (f4 / sqrt);
            }
        }

        void add(float f, float f2) {
            float f3 = f - this.f67x;
            float f4 = f2 - this.f68y;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                f3 = (float) (f3 / sqrt);
                f4 = (float) (f4 / sqrt);
            }
            float f5 = this.f65dx;
            if (f3 == (-f5) && f4 == (-this.f66dy)) {
                this.isAmbiguous = true;
                this.f65dx = -f4;
                this.f66dy = f3;
            } else {
                this.f65dx = f5 + f3;
                this.f66dy += f4;
            }
        }

        void add(MarkerVector markerVector) {
            float f = markerVector.f65dx;
            float f2 = this.f65dx;
            if (f == (-f2)) {
                float f3 = markerVector.f66dy;
                if (f3 == (-this.f66dy)) {
                    this.isAmbiguous = true;
                    this.f65dx = -f3;
                    this.f66dy = markerVector.f65dx;
                    return;
                }
            }
            this.f65dx = f2 + f;
            this.f66dy += markerVector.f66dy;
        }

        public String toString() {
            return "(" + this.f67x + "," + this.f68y + " " + this.f65dx + "," + this.f66dy + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class MarkerPositionCalculator implements SVG.PathInterface {
        private boolean closepathReAdjustPending;
        private float startX;
        private float startY;
        private List<MarkerVector> markers = new ArrayList();
        private MarkerVector lastPos = null;
        private boolean startArc = false;
        private boolean normalCubic = true;
        private int subpathStartIndex = -1;

        MarkerPositionCalculator(SVG.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.enumeratePath(this);
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
        }

        List<MarkerVector> getMarkers() {
            return this.markers;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
            this.startX = f;
            this.startY = f2;
            this.lastPos = new MarkerVector(f, f2, 0.0f, 0.0f);
            this.subpathStartIndex = this.markers.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f, f2, f - this.lastPos.f67x, f2 - this.lastPos.f68y);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(f, f2);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = new MarkerVector(f5, f6, f5 - f3, f6 - f4);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f3, f4, f3 - f, f4 - f2);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.startArc = true;
            this.normalCubic = false;
            SVGAndroidRenderer.arcTo(this.lastPos.f67x, this.lastPos.f68y, f, f2, f3, z, z2, f4, f5, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b8 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void renderMarkers(SVG.GraphicsElement graphicsElement) {
        SVG.Marker marker;
        SVG.Marker marker2;
        SVG.Marker marker3;
        List<MarkerVector> calculateMarkerPositions;
        int size;
        int i;
        if (this.state.style.markerStart == null && this.state.style.markerMid == null && this.state.style.markerEnd == null) {
            return;
        }
        if (this.state.style.markerStart != null) {
            SVG.SvgObject resolveIRI = graphicsElement.document.resolveIRI(this.state.style.markerStart);
            if (resolveIRI != null) {
                marker = (SVG.Marker) resolveIRI;
                if (this.state.style.markerMid != null) {
                    SVG.SvgObject resolveIRI2 = graphicsElement.document.resolveIRI(this.state.style.markerMid);
                    if (resolveIRI2 != null) {
                        marker2 = (SVG.Marker) resolveIRI2;
                        if (this.state.style.markerEnd != null) {
                            SVG.SvgObject resolveIRI3 = graphicsElement.document.resolveIRI(this.state.style.markerEnd);
                            if (resolveIRI3 != null) {
                                marker3 = (SVG.Marker) resolveIRI3;
                                if (!(graphicsElement instanceof SVG.Path)) {
                                    calculateMarkerPositions = new MarkerPositionCalculator(((SVG.Path) graphicsElement).f32d).getMarkers();
                                } else if (graphicsElement instanceof SVG.Line) {
                                    calculateMarkerPositions = calculateMarkerPositions((SVG.Line) graphicsElement);
                                } else {
                                    calculateMarkerPositions = calculateMarkerPositions((SVG.PolyLine) graphicsElement);
                                }
                                if (calculateMarkerPositions == null && (size = calculateMarkerPositions.size()) != 0) {
                                    SVG.Style style = this.state.style;
                                    SVG.Style style2 = this.state.style;
                                    this.state.style.markerEnd = null;
                                    style2.markerMid = null;
                                    style.markerStart = null;
                                    if (marker != null) {
                                        renderMarker(marker, calculateMarkerPositions.get(0));
                                    }
                                    if (marker2 != null && calculateMarkerPositions.size() > 2) {
                                        MarkerVector markerVector = calculateMarkerPositions.get(0);
                                        MarkerVector markerVector2 = calculateMarkerPositions.get(1);
                                        i = 1;
                                        while (i < size - 1) {
                                            i++;
                                            MarkerVector markerVector3 = calculateMarkerPositions.get(i);
                                            markerVector = markerVector2.isAmbiguous ? realignMarkerMid(markerVector, markerVector2, markerVector3) : markerVector2;
                                            renderMarker(marker2, markerVector);
                                            markerVector2 = markerVector3;
                                        }
                                    }
                                    if (marker3 == null) {
                                        renderMarker(marker3, calculateMarkerPositions.get(size - 1));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            error("Marker reference '%s' not found", this.state.style.markerEnd);
                        }
                        marker3 = null;
                        if (!(graphicsElement instanceof SVG.Path)) {
                        }
                        if (calculateMarkerPositions == null) {
                            return;
                        }
                        SVG.Style style3 = this.state.style;
                        SVG.Style style22 = this.state.style;
                        this.state.style.markerEnd = null;
                        style22.markerMid = null;
                        style3.markerStart = null;
                        if (marker != null) {
                        }
                        if (marker2 != null) {
                            MarkerVector markerVector4 = calculateMarkerPositions.get(0);
                            MarkerVector markerVector22 = calculateMarkerPositions.get(1);
                            i = 1;
                            while (i < size - 1) {
                            }
                        }
                        if (marker3 == null) {
                        }
                    } else {
                        error("Marker reference '%s' not found", this.state.style.markerMid);
                    }
                }
                marker2 = null;
                if (this.state.style.markerEnd != null) {
                }
                marker3 = null;
                if (!(graphicsElement instanceof SVG.Path)) {
                }
                if (calculateMarkerPositions == null) {
                }
            } else {
                error("Marker reference '%s' not found", this.state.style.markerStart);
            }
        }
        marker = null;
        if (this.state.style.markerMid != null) {
        }
        marker2 = null;
        if (this.state.style.markerEnd != null) {
        }
        marker3 = null;
        if (!(graphicsElement instanceof SVG.Path)) {
        }
        if (calculateMarkerPositions == null) {
        }
    }

    private MarkerVector realignMarkerMid(MarkerVector markerVector, MarkerVector markerVector2, MarkerVector markerVector3) {
        float dotProduct = dotProduct(markerVector2.f65dx, markerVector2.f66dy, markerVector2.f67x - markerVector.f67x, markerVector2.f68y - markerVector.f68y);
        if (dotProduct == 0.0f) {
            dotProduct = dotProduct(markerVector2.f65dx, markerVector2.f66dy, markerVector3.f67x - markerVector2.f67x, markerVector3.f68y - markerVector2.f68y);
        }
        if (dotProduct > 0.0f) {
            return markerVector2;
        }
        if (dotProduct == 0.0f && (markerVector2.f65dx > 0.0f || markerVector2.f66dy >= 0.0f)) {
            return markerVector2;
        }
        markerVector2.f65dx = -markerVector2.f65dx;
        markerVector2.f66dy = -markerVector2.f66dy;
        return markerVector2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0114, code lost:
    
        if (r7 != 8) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void renderMarker(SVG.Marker marker, MarkerVector markerVector) {
        float f;
        boolean pushLayer;
        float f2;
        float f3;
        float f4;
        statePush();
        float f5 = 0.0f;
        if (marker.orient != null) {
            if (!Float.isNaN(marker.orient.floatValue())) {
                f = marker.orient.floatValue();
            } else if (markerVector.f65dx != 0.0f || markerVector.f66dy != 0.0f) {
                f = (float) Math.toDegrees(Math.atan2(markerVector.f66dy, markerVector.f65dx));
            }
            float floatValue = !marker.markerUnitsAreUser ? 1.0f : this.state.style.strokeWidth.floatValue(this.dpi);
            this.state = findInheritFromAncestorState(marker);
            Matrix matrix = new Matrix();
            matrix.preTranslate(markerVector.f67x, markerVector.f68y);
            matrix.preRotate(f);
            matrix.preScale(floatValue, floatValue);
            float floatValueX = marker.refX == null ? marker.refX.floatValueX(this) : 0.0f;
            float floatValueY = marker.refY == null ? marker.refY.floatValueY(this) : 0.0f;
            float floatValueX2 = marker.markerWidth == null ? marker.markerWidth.floatValueX(this) : 3.0f;
            float floatValueY2 = marker.markerHeight != null ? marker.markerHeight.floatValueY(this) : 3.0f;
            if (marker.viewBox == null) {
                float f6 = floatValueX2 / marker.viewBox.width;
                float f7 = floatValueY2 / marker.viewBox.height;
                PreserveAspectRatio preserveAspectRatio = marker.preserveAspectRatio != null ? marker.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
                if (!preserveAspectRatio.equals(PreserveAspectRatio.STRETCH)) {
                    f6 = preserveAspectRatio.getScale() == PreserveAspectRatio.Scale.slice ? Math.max(f6, f7) : Math.min(f6, f7);
                    f7 = f6;
                }
                matrix.preTranslate((-floatValueX) * f6, (-floatValueY) * f7);
                this.canvas.concat(matrix);
                float f8 = marker.viewBox.width * f6;
                float f9 = marker.viewBox.height * f7;
                switch (C00851.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[preserveAspectRatio.getAlignment().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        f2 = (floatValueX2 - f8) / 2.0f;
                        f3 = 0.0f - f2;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        f2 = floatValueX2 - f8;
                        f3 = 0.0f - f2;
                        break;
                    default:
                        f3 = 0.0f;
                        break;
                }
                int i = C00851.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[preserveAspectRatio.getAlignment().ordinal()];
                if (i != 2) {
                    if (i != 3) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 7) {
                                }
                            }
                        }
                    }
                    f4 = floatValueY2 - f9;
                    f5 = 0.0f - f4;
                    if (!this.state.style.overflow.booleanValue()) {
                        setClipRect(f3, f5, floatValueX2, floatValueY2);
                    }
                    matrix.reset();
                    matrix.preScale(f6, f7);
                    this.canvas.concat(matrix);
                }
                f4 = (floatValueY2 - f9) / 2.0f;
                f5 = 0.0f - f4;
                if (!this.state.style.overflow.booleanValue()) {
                }
                matrix.reset();
                matrix.preScale(f6, f7);
                this.canvas.concat(matrix);
            } else {
                matrix.preTranslate(-floatValueX, -floatValueY);
                this.canvas.concat(matrix);
                if (!this.state.style.overflow.booleanValue()) {
                    setClipRect(0.0f, 0.0f, floatValueX2, floatValueY2);
                }
            }
            pushLayer = pushLayer();
            renderChildren(marker, false);
            if (pushLayer) {
                popLayer(marker);
            }
            statePop();
        }
        f = 0.0f;
        if (!marker.markerUnitsAreUser) {
        }
        this.state = findInheritFromAncestorState(marker);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(markerVector.f67x, markerVector.f68y);
        matrix2.preRotate(f);
        matrix2.preScale(floatValue, floatValue);
        if (marker.refX == null) {
        }
        if (marker.refY == null) {
        }
        if (marker.markerWidth == null) {
        }
        if (marker.markerHeight != null) {
        }
        if (marker.viewBox == null) {
        }
        pushLayer = pushLayer();
        renderChildren(marker, false);
        if (pushLayer) {
        }
        statePop();
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject) {
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        return findInheritFromAncestorState(svgObject, rendererState);
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject, RendererState rendererState) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (svgObject instanceof SVG.SvgElementBase) {
                arrayList.add(0, (SVG.SvgElementBase) svgObject);
            }
            if (svgObject.parent == null) {
                break;
            }
            svgObject = (SVG.SvgObject) svgObject.parent;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            updateStyleForElement(rendererState, (SVG.SvgElementBase) it.next());
        }
        rendererState.viewBox = this.state.viewBox;
        rendererState.viewPort = this.state.viewPort;
        return rendererState;
    }

    private void checkForGradientsAndPatterns(SVG.SvgElement svgElement) {
        if (this.state.style.fill instanceof SVG.PaintReference) {
            decodePaintReference(true, svgElement.boundingBox, (SVG.PaintReference) this.state.style.fill);
        }
        if (this.state.style.stroke instanceof SVG.PaintReference) {
            decodePaintReference(false, svgElement.boundingBox, (SVG.PaintReference) this.state.style.stroke);
        }
    }

    private void decodePaintReference(boolean z, SVG.Box box, SVG.PaintReference paintReference) {
        SVG.SvgObject resolveIRI = this.document.resolveIRI(paintReference.href);
        if (resolveIRI == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = paintReference.href;
            error("%s reference '%s' not found", objArr);
            if (paintReference.fallback != null) {
                setPaintColour(this.state, z, paintReference.fallback);
                return;
            } else if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        if (resolveIRI instanceof SVG.SvgLinearGradient) {
            makeLinearGradient(z, box, (SVG.SvgLinearGradient) resolveIRI);
        } else if (resolveIRI instanceof SVG.SvgRadialGradient) {
            makeRadialGradient(z, box, (SVG.SvgRadialGradient) resolveIRI);
        } else if (resolveIRI instanceof SVG.SolidColor) {
            setSolidColor(z, (SVG.SolidColor) resolveIRI);
        }
    }

    private void makeLinearGradient(boolean z, SVG.Box box, SVG.SvgLinearGradient svgLinearGradient) {
        float f;
        float floatValue;
        float f2;
        float f3;
        if (svgLinearGradient.href != null) {
            fillInChainedGradientFields(svgLinearGradient, svgLinearGradient.href);
        }
        int i = 0;
        boolean z2 = svgLinearGradient.gradientUnitsAreUser != null && svgLinearGradient.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
        if (z2) {
            SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
            float floatValueX = svgLinearGradient.f42x1 != null ? svgLinearGradient.f42x1.floatValueX(this) : 0.0f;
            float floatValueY = svgLinearGradient.f44y1 != null ? svgLinearGradient.f44y1.floatValueY(this) : 0.0f;
            f3 = svgLinearGradient.f43x2 != null ? svgLinearGradient.f43x2.floatValueX(this) : currentViewPortInUserUnits.width;
            f = floatValueX;
            f2 = floatValueY;
            floatValue = svgLinearGradient.f45y2 != null ? svgLinearGradient.f45y2.floatValueY(this) : 0.0f;
        } else {
            float floatValue2 = svgLinearGradient.f42x1 != null ? svgLinearGradient.f42x1.floatValue(this, 1.0f) : 0.0f;
            float floatValue3 = svgLinearGradient.f44y1 != null ? svgLinearGradient.f44y1.floatValue(this, 1.0f) : 0.0f;
            float floatValue4 = svgLinearGradient.f43x2 != null ? svgLinearGradient.f43x2.floatValue(this, 1.0f) : 1.0f;
            f = floatValue2;
            floatValue = svgLinearGradient.f45y2 != null ? svgLinearGradient.f45y2.floatValue(this, 1.0f) : 0.0f;
            f2 = floatValue3;
            f3 = floatValue4;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgLinearGradient);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (svgLinearGradient.gradientTransform != null) {
            matrix.preConcat(svgLinearGradient.gradientTransform);
        }
        int size = svgLinearGradient.children.size();
        if (size == 0) {
            statePop();
            if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgLinearGradient.children.iterator();
        float f4 = -1.0f;
        while (it.hasNext()) {
            SVG.Stop stop = (SVG.Stop) it.next();
            float floatValue5 = stop.offset != null ? stop.offset.floatValue() : 0.0f;
            if (i == 0 || floatValue5 >= f4) {
                fArr[i] = floatValue5;
                f4 = floatValue5;
            } else {
                fArr[i] = f4;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Colour colour = (SVG.Colour) this.state.style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i] = colourWithOpacity(colour.colour, this.state.style.stopOpacity.floatValue());
            i++;
            statePop();
        }
        if ((f == f3 && f2 == floatValue) || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (svgLinearGradient.spreadMethod != null) {
            if (svgLinearGradient.spreadMethod == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (svgLinearGradient.spreadMethod == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        LinearGradient linearGradient = new LinearGradient(f, f2, f3, floatValue, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private void makeRadialGradient(boolean z, SVG.Box box, SVG.SvgRadialGradient svgRadialGradient) {
        float f;
        float floatValue;
        float f2;
        if (svgRadialGradient.href != null) {
            fillInChainedGradientFields(svgRadialGradient, svgRadialGradient.href);
        }
        int i = 0;
        boolean z2 = svgRadialGradient.gradientUnitsAreUser != null && svgRadialGradient.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
        if (z2) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            float floatValueX = svgRadialGradient.f46cx != null ? svgRadialGradient.f46cx.floatValueX(this) : length.floatValueX(this);
            float floatValueY = svgRadialGradient.f47cy != null ? svgRadialGradient.f47cy.floatValueY(this) : length.floatValueY(this);
            if (svgRadialGradient.f50r != null) {
                length = svgRadialGradient.f50r;
            }
            floatValue = length.floatValue(this);
            f = floatValueX;
            f2 = floatValueY;
        } else {
            float floatValue2 = svgRadialGradient.f46cx != null ? svgRadialGradient.f46cx.floatValue(this, 1.0f) : 0.5f;
            float floatValue3 = svgRadialGradient.f47cy != null ? svgRadialGradient.f47cy.floatValue(this, 1.0f) : 0.5f;
            f = floatValue2;
            floatValue = svgRadialGradient.f50r != null ? svgRadialGradient.f50r.floatValue(this, 1.0f) : 0.5f;
            f2 = floatValue3;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgRadialGradient);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (svgRadialGradient.gradientTransform != null) {
            matrix.preConcat(svgRadialGradient.gradientTransform);
        }
        int size = svgRadialGradient.children.size();
        if (size == 0) {
            statePop();
            if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgRadialGradient.children.iterator();
        float f3 = -1.0f;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SVG.Stop stop = (SVG.Stop) it.next();
            float floatValue4 = stop.offset != null ? stop.offset.floatValue() : 0.0f;
            if (i == 0 || floatValue4 >= f3) {
                fArr[i] = floatValue4;
                f3 = floatValue4;
            } else {
                fArr[i] = f3;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Colour colour = (SVG.Colour) this.state.style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i] = colourWithOpacity(colour.colour, this.state.style.stopOpacity.floatValue());
            i++;
            statePop();
        }
        if (floatValue == 0.0f || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (svgRadialGradient.spreadMethod != null) {
            if (svgRadialGradient.spreadMethod == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (svgRadialGradient.spreadMethod == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        RadialGradient radialGradient = new RadialGradient(f, f2, floatValue, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private void fillInChainedGradientFields(SVG.GradientElement gradientElement, String str) {
        SVG.SvgObject resolveIRI = gradientElement.document.resolveIRI(str);
        if (resolveIRI == null) {
            warn("Gradient reference '%s' not found", str);
            return;
        }
        if (!(resolveIRI instanceof SVG.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (resolveIRI == gradientElement) {
            error("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        SVG.GradientElement gradientElement2 = (SVG.GradientElement) resolveIRI;
        if (gradientElement.gradientUnitsAreUser == null) {
            gradientElement.gradientUnitsAreUser = gradientElement2.gradientUnitsAreUser;
        }
        if (gradientElement.gradientTransform == null) {
            gradientElement.gradientTransform = gradientElement2.gradientTransform;
        }
        if (gradientElement.spreadMethod == null) {
            gradientElement.spreadMethod = gradientElement2.spreadMethod;
        }
        if (gradientElement.children.isEmpty()) {
            gradientElement.children = gradientElement2.children;
        }
        try {
            if (gradientElement instanceof SVG.SvgLinearGradient) {
                fillInChainedGradientFields((SVG.SvgLinearGradient) gradientElement, (SVG.SvgLinearGradient) resolveIRI);
            } else {
                fillInChainedGradientFields((SVG.SvgRadialGradient) gradientElement, (SVG.SvgRadialGradient) resolveIRI);
            }
        } catch (ClassCastException unused) {
        }
        if (gradientElement2.href != null) {
            fillInChainedGradientFields(gradientElement, gradientElement2.href);
        }
    }

    private void fillInChainedGradientFields(SVG.SvgLinearGradient svgLinearGradient, SVG.SvgLinearGradient svgLinearGradient2) {
        if (svgLinearGradient.f42x1 == null) {
            svgLinearGradient.f42x1 = svgLinearGradient2.f42x1;
        }
        if (svgLinearGradient.f44y1 == null) {
            svgLinearGradient.f44y1 = svgLinearGradient2.f44y1;
        }
        if (svgLinearGradient.f43x2 == null) {
            svgLinearGradient.f43x2 = svgLinearGradient2.f43x2;
        }
        if (svgLinearGradient.f45y2 == null) {
            svgLinearGradient.f45y2 = svgLinearGradient2.f45y2;
        }
    }

    private void fillInChainedGradientFields(SVG.SvgRadialGradient svgRadialGradient, SVG.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.f46cx == null) {
            svgRadialGradient.f46cx = svgRadialGradient2.f46cx;
        }
        if (svgRadialGradient.f47cy == null) {
            svgRadialGradient.f47cy = svgRadialGradient2.f47cy;
        }
        if (svgRadialGradient.f50r == null) {
            svgRadialGradient.f50r = svgRadialGradient2.f50r;
        }
        if (svgRadialGradient.f48fx == null) {
            svgRadialGradient.f48fx = svgRadialGradient2.f48fx;
        }
        if (svgRadialGradient.f49fy == null) {
            svgRadialGradient.f49fy = svgRadialGradient2.f49fy;
        }
    }

    private void setSolidColor(boolean z, SVG.SolidColor solidColor) {
        if (z) {
            if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                this.state.style.fill = solidColor.baseStyle.solidColor;
                this.state.hasFill = solidColor.baseStyle.solidColor != null;
            }
            if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                this.state.style.fillOpacity = solidColor.baseStyle.solidOpacity;
            }
            if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                RendererState rendererState = this.state;
                setPaintColour(rendererState, z, rendererState.style.fill);
                return;
            }
            return;
        }
        if (isSpecified(solidColor.baseStyle, 2147483648L)) {
            this.state.style.stroke = solidColor.baseStyle.solidColor;
            this.state.hasStroke = solidColor.baseStyle.solidColor != null;
        }
        if (isSpecified(solidColor.baseStyle, 4294967296L)) {
            this.state.style.strokeOpacity = solidColor.baseStyle.solidOpacity;
        }
        if (isSpecified(solidColor.baseStyle, 6442450944L)) {
            RendererState rendererState2 = this.state;
            setPaintColour(rendererState2, z, rendererState2.style.stroke);
        }
    }

    private void checkForClipPath(SVG.SvgElement svgElement) {
        checkForClipPath(svgElement, svgElement.boundingBox);
    }

    private void checkForClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path calculateClipPath;
        if (this.state.style.clipPath == null || (calculateClipPath = calculateClipPath(svgElement, box)) == null) {
            return;
        }
        this.canvas.clipPath(calculateClipPath);
    }

    private Path calculateClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path objectToPath;
        SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (resolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return null;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) resolveIRI;
        this.stateStack.push(this.state);
        this.state = findInheritFromAncestorState(clipPath);
        boolean z = clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue();
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (clipPath.transform != null) {
            matrix.preConcat(clipPath.transform);
        }
        Path path = new Path();
        for (SVG.SvgObject svgObject : clipPath.children) {
            if ((svgObject instanceof SVG.SvgElement) && (objectToPath = objectToPath((SVG.SvgElement) svgObject, true)) != null) {
                path.op(objectToPath, Path.Op.UNION);
            }
        }
        if (this.state.style.clipPath != null) {
            if (clipPath.boundingBox == null) {
                clipPath.boundingBox = calculatePathBounds(path);
            }
            Path calculateClipPath = calculateClipPath(clipPath, clipPath.boundingBox);
            if (calculateClipPath != null) {
                path.op(calculateClipPath, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.state = this.stateStack.pop();
        return path;
    }

    private Path objectToPath(SVG.SvgElement svgElement, boolean z) {
        Path makePathAndBoundingBox;
        Path calculateClipPath;
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        updateStyleForElement(rendererState, svgElement);
        if (!display() || !visible()) {
            this.state = this.stateStack.pop();
            return null;
        }
        if (svgElement instanceof SVG.Use) {
            if (!z) {
                error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.Use use = (SVG.Use) svgElement;
            SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(use.href);
            if (resolveIRI == null) {
                error("Use reference '%s' not found", use.href);
                this.state = this.stateStack.pop();
                return null;
            }
            if (!(resolveIRI instanceof SVG.SvgElement)) {
                this.state = this.stateStack.pop();
                return null;
            }
            makePathAndBoundingBox = objectToPath((SVG.SvgElement) resolveIRI, false);
            if (makePathAndBoundingBox == null) {
                return null;
            }
            if (use.boundingBox == null) {
                use.boundingBox = calculatePathBounds(makePathAndBoundingBox);
            }
            if (use.transform != null) {
                makePathAndBoundingBox.transform(use.transform);
            }
        } else if (svgElement instanceof SVG.GraphicsElement) {
            SVG.GraphicsElement graphicsElement = (SVG.GraphicsElement) svgElement;
            if (svgElement instanceof SVG.Path) {
                makePathAndBoundingBox = new PathConverter(((SVG.Path) svgElement).f32d).getPath();
                if (svgElement.boundingBox == null) {
                    svgElement.boundingBox = calculatePathBounds(makePathAndBoundingBox);
                }
            } else {
                makePathAndBoundingBox = svgElement instanceof SVG.Rect ? makePathAndBoundingBox((SVG.Rect) svgElement) : svgElement instanceof SVG.Circle ? makePathAndBoundingBox((SVG.Circle) svgElement) : svgElement instanceof SVG.Ellipse ? makePathAndBoundingBox((SVG.Ellipse) svgElement) : svgElement instanceof SVG.PolyLine ? makePathAndBoundingBox((SVG.PolyLine) svgElement) : null;
            }
            if (makePathAndBoundingBox == null) {
                return null;
            }
            if (graphicsElement.boundingBox == null) {
                graphicsElement.boundingBox = calculatePathBounds(makePathAndBoundingBox);
            }
            if (graphicsElement.transform != null) {
                makePathAndBoundingBox.transform(graphicsElement.transform);
            }
            makePathAndBoundingBox.setFillType(getClipRuleFromState());
        } else {
            if (!(svgElement instanceof SVG.Text)) {
                error("Invalid %s element found in clipPath definition", svgElement.getNodeName());
                return null;
            }
            SVG.Text text = (SVG.Text) svgElement;
            makePathAndBoundingBox = makePathAndBoundingBox(text);
            if (makePathAndBoundingBox == null) {
                return null;
            }
            if (text.transform != null) {
                makePathAndBoundingBox.transform(text.transform);
            }
            makePathAndBoundingBox.setFillType(getClipRuleFromState());
        }
        if (this.state.style.clipPath != null && (calculateClipPath = calculateClipPath(svgElement, svgElement.boundingBox)) != null) {
            makePathAndBoundingBox.op(calculateClipPath, Path.Op.INTERSECT);
        }
        this.state = this.stateStack.pop();
        return makePathAndBoundingBox;
    }

    private void checkForClipPath_OldStyle(SVG.SvgElement svgElement, SVG.Box box) {
        SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (resolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) resolveIRI;
        if (clipPath.children.isEmpty()) {
            this.canvas.clipRect(0, 0, 0, 0);
            return;
        }
        boolean z = clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue();
        if ((svgElement instanceof SVG.Group) && !z) {
            warn("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", svgElement.getNodeName());
            return;
        }
        clipStatePush();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
            this.canvas.concat(matrix);
        }
        if (clipPath.transform != null) {
            this.canvas.concat(clipPath.transform);
        }
        this.state = findInheritFromAncestorState(clipPath);
        checkForClipPath(clipPath);
        Path path = new Path();
        Iterator<SVG.SvgObject> it = clipPath.children.iterator();
        while (it.hasNext()) {
            addObjectToClip(it.next(), true, path, new Matrix());
        }
        this.canvas.clipPath(path);
        clipStatePop();
    }

    private void addObjectToClip(SVG.SvgObject svgObject, boolean z, Path path, Matrix matrix) {
        if (display()) {
            clipStatePush();
            if (svgObject instanceof SVG.Use) {
                if (z) {
                    addObjectToClip((SVG.Use) svgObject, path, matrix);
                } else {
                    error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (svgObject instanceof SVG.Path) {
                addObjectToClip((SVG.Path) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.Text) {
                addObjectToClip((SVG.Text) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.GraphicsElement) {
                addObjectToClip((SVG.GraphicsElement) svgObject, path, matrix);
            } else {
                error("Invalid %s element found in clipPath definition", svgObject.toString());
            }
            clipStatePop();
        }
    }

    private void clipStatePush() {
        CanvasLegacy.save(this.canvas, CanvasLegacy.MATRIX_SAVE_FLAG);
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private void clipStatePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private Path.FillType getClipRuleFromState() {
        if (this.state.style.clipRule != null && this.state.style.clipRule == SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void addObjectToClip(SVG.Path path, Path path2, Matrix matrix) {
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            if (path.transform != null) {
                matrix.preConcat(path.transform);
            }
            Path path3 = new PathConverter(path.f32d).getPath();
            if (path.boundingBox == null) {
                path.boundingBox = calculatePathBounds(path3);
            }
            checkForClipPath(path);
            path2.setFillType(getClipRuleFromState());
            path2.addPath(path3, matrix);
        }
    }

    private void addObjectToClip(SVG.GraphicsElement graphicsElement, Path path, Matrix matrix) {
        Path makePathAndBoundingBox;
        updateStyleForElement(this.state, graphicsElement);
        if (display() && visible()) {
            if (graphicsElement.transform != null) {
                matrix.preConcat(graphicsElement.transform);
            }
            if (graphicsElement instanceof SVG.Rect) {
                makePathAndBoundingBox = makePathAndBoundingBox((SVG.Rect) graphicsElement);
            } else if (graphicsElement instanceof SVG.Circle) {
                makePathAndBoundingBox = makePathAndBoundingBox((SVG.Circle) graphicsElement);
            } else if (graphicsElement instanceof SVG.Ellipse) {
                makePathAndBoundingBox = makePathAndBoundingBox((SVG.Ellipse) graphicsElement);
            } else if (!(graphicsElement instanceof SVG.PolyLine)) {
                return;
            } else {
                makePathAndBoundingBox = makePathAndBoundingBox((SVG.PolyLine) graphicsElement);
            }
            checkForClipPath(graphicsElement);
            path.setFillType(getClipRuleFromState());
            path.addPath(makePathAndBoundingBox, matrix);
        }
    }

    private void addObjectToClip(SVG.Use use, Path path, Matrix matrix) {
        updateStyleForElement(this.state, use);
        if (display() && visible()) {
            if (use.transform != null) {
                matrix.preConcat(use.transform);
            }
            SVG.SvgObject resolveIRI = use.document.resolveIRI(use.href);
            if (resolveIRI == null) {
                error("Use reference '%s' not found", use.href);
            } else {
                checkForClipPath(use);
                addObjectToClip(resolveIRI, false, path, matrix);
            }
        }
    }

    private void addObjectToClip(SVG.Text text, Path path, Matrix matrix) {
        updateStyleForElement(this.state, text);
        if (display()) {
            if (text.transform != null) {
                matrix.preConcat(text.transform);
            }
            float f = 0.0f;
            float floatValueX = (text.f53x == null || text.f53x.size() == 0) ? 0.0f : text.f53x.get(0).floatValueX(this);
            float floatValueY = (text.f54y == null || text.f54y.size() == 0) ? 0.0f : text.f54y.get(0).floatValueY(this);
            float floatValueX2 = (text.f51dx == null || text.f51dx.size() == 0) ? 0.0f : text.f51dx.get(0).floatValueX(this);
            if (text.f52dy != null && text.f52dy.size() != 0) {
                f = text.f52dy.get(0).floatValueY(this);
            }
            if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(text);
                if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValueX -= calculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
                enumerateTextSpans(text, textBoundsCalculator);
                text.boundingBox = new SVG.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
            }
            checkForClipPath(text);
            Path path2 = new Path();
            enumerateTextSpans(text, new PlainTextToPath(floatValueX + floatValueX2, floatValueY + f, path2));
            path.setFillType(getClipRuleFromState());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class PlainTextToPath extends TextProcessor {
        Path textAsPath;

        /* renamed from: x */
        float f71x;

        /* renamed from: y */
        float f72y;

        PlainTextToPath(float f, float f2, Path path) {
            super(SVGAndroidRenderer.this, null);
            this.f71x = f;
            this.f72y = f2;
            this.textAsPath = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVGAndroidRenderer.warn("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Path path = new Path();
                SVGAndroidRenderer.this.state.fillPaint.getTextPath(str, 0, str.length(), this.f71x, this.f72y, path);
                this.textAsPath.addPath(path);
            }
            this.f71x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private Path makePathAndBoundingBox(SVG.Line line) {
        float floatValueX = line.f26x1 == null ? 0.0f : line.f26x1.floatValueX(this);
        float floatValueY = line.f28y1 == null ? 0.0f : line.f28y1.floatValueY(this);
        float floatValueX2 = line.f27x2 == null ? 0.0f : line.f27x2.floatValueX(this);
        float floatValueY2 = line.f29y2 != null ? line.f29y2.floatValueY(this) : 0.0f;
        if (line.boundingBox == null) {
            line.boundingBox = new SVG.Box(Math.min(floatValueX, floatValueX2), Math.min(floatValueY, floatValueY2), Math.abs(floatValueX2 - floatValueX), Math.abs(floatValueY2 - floatValueY));
        }
        Path path = new Path();
        path.moveTo(floatValueX, floatValueY);
        path.lineTo(floatValueX2, floatValueY2);
        return path;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Path makePathAndBoundingBox(SVG.Rect rect) {
        float floatValueX;
        float floatValueY;
        float min;
        float floatValueX2;
        float floatValueY2;
        float f;
        float f2;
        Path path;
        Path path2;
        if (rect.f35rx == null && rect.f36ry == null) {
            floatValueX = 0.0f;
        } else if (rect.f35rx == null) {
            floatValueX = rect.f36ry.floatValueY(this);
        } else if (rect.f36ry == null) {
            floatValueX = rect.f35rx.floatValueX(this);
        } else {
            floatValueX = rect.f35rx.floatValueX(this);
            floatValueY = rect.f36ry.floatValueY(this);
            min = Math.min(floatValueX, rect.width.floatValueX(this) / 2.0f);
            float min2 = Math.min(floatValueY, rect.height.floatValueY(this) / 2.0f);
            floatValueX2 = rect.f37x == null ? rect.f37x.floatValueX(this) : 0.0f;
            floatValueY2 = rect.f38y == null ? rect.f38y.floatValueY(this) : 0.0f;
            float floatValueX3 = rect.width.floatValueX(this);
            float floatValueY3 = rect.height.floatValueY(this);
            if (rect.boundingBox == null) {
                rect.boundingBox = new SVG.Box(floatValueX2, floatValueY2, floatValueX3, floatValueY3);
            }
            f = floatValueX2 + floatValueX3;
            f2 = floatValueY2 + floatValueY3;
            path = new Path();
            if (min != 0.0f || min2 == 0.0f) {
                path2 = path;
                path2.moveTo(floatValueX2, floatValueY2);
                path2.lineTo(f, floatValueY2);
                path2.lineTo(f, f2);
                path2.lineTo(floatValueX2, f2);
                path2.lineTo(floatValueX2, floatValueY2);
            } else {
                float f3 = min * BEZIER_ARC_FACTOR;
                float f4 = BEZIER_ARC_FACTOR * min2;
                float f5 = floatValueY2 + min2;
                path.moveTo(floatValueX2, f5);
                float f6 = f5 - f4;
                float f7 = floatValueX2 + min;
                float f8 = f7 - f3;
                path.cubicTo(floatValueX2, f6, f8, floatValueY2, f7, floatValueY2);
                float f9 = f - min;
                path.lineTo(f9, floatValueY2);
                float f10 = f9 + f3;
                path.cubicTo(f10, floatValueY2, f, f6, f, f5);
                float f11 = f2 - min2;
                path.lineTo(f, f11);
                float f12 = f11 + f4;
                path2 = path;
                path.cubicTo(f, f12, f10, f2, f9, f2);
                path2.lineTo(f7, f2);
                path2.cubicTo(f8, f2, floatValueX2, f12, floatValueX2, f11);
                path2.lineTo(floatValueX2, f5);
            }
            path2.close();
            return path2;
        }
        floatValueY = floatValueX;
        min = Math.min(floatValueX, rect.width.floatValueX(this) / 2.0f);
        float min22 = Math.min(floatValueY, rect.height.floatValueY(this) / 2.0f);
        if (rect.f37x == null) {
        }
        if (rect.f38y == null) {
        }
        float floatValueX32 = rect.width.floatValueX(this);
        float floatValueY32 = rect.height.floatValueY(this);
        if (rect.boundingBox == null) {
        }
        f = floatValueX2 + floatValueX32;
        f2 = floatValueY2 + floatValueY32;
        path = new Path();
        if (min != 0.0f) {
        }
        path2 = path;
        path2.moveTo(floatValueX2, floatValueY2);
        path2.lineTo(f, floatValueY2);
        path2.lineTo(f, f2);
        path2.lineTo(floatValueX2, f2);
        path2.lineTo(floatValueX2, floatValueY2);
        path2.close();
        return path2;
    }

    private Path makePathAndBoundingBox(SVG.Circle circle) {
        float floatValueX = circle.f17cx != null ? circle.f17cx.floatValueX(this) : 0.0f;
        float floatValueY = circle.f18cy != null ? circle.f18cy.floatValueY(this) : 0.0f;
        float floatValue = circle.f19r.floatValue(this);
        float f = floatValueX - floatValue;
        float f2 = floatValueY - floatValue;
        float f3 = floatValueX + floatValue;
        float f4 = floatValueY + floatValue;
        if (circle.boundingBox == null) {
            float f5 = 2.0f * floatValue;
            circle.boundingBox = new SVG.Box(f, f2, f5, f5);
        }
        float f6 = BEZIER_ARC_FACTOR * floatValue;
        Path path = new Path();
        path.moveTo(floatValueX, f2);
        float f7 = floatValueX + f6;
        float f8 = floatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, floatValueY);
        float f9 = floatValueY + f6;
        path.cubicTo(f3, f9, f7, f4, floatValueX, f4);
        float f10 = floatValueX - f6;
        path.cubicTo(f10, f4, f, f9, f, floatValueY);
        path.cubicTo(f, f8, f10, f2, floatValueX, f2);
        path.close();
        return path;
    }

    private Path makePathAndBoundingBox(SVG.Ellipse ellipse) {
        float floatValueX = ellipse.f20cx != null ? ellipse.f20cx.floatValueX(this) : 0.0f;
        float floatValueY = ellipse.f21cy != null ? ellipse.f21cy.floatValueY(this) : 0.0f;
        float floatValueX2 = ellipse.f22rx.floatValueX(this);
        float floatValueY2 = ellipse.f23ry.floatValueY(this);
        float f = floatValueX - floatValueX2;
        float f2 = floatValueY - floatValueY2;
        float f3 = floatValueX + floatValueX2;
        float f4 = floatValueY + floatValueY2;
        if (ellipse.boundingBox == null) {
            ellipse.boundingBox = new SVG.Box(f, f2, floatValueX2 * 2.0f, 2.0f * floatValueY2);
        }
        float f5 = floatValueX2 * BEZIER_ARC_FACTOR;
        float f6 = BEZIER_ARC_FACTOR * floatValueY2;
        Path path = new Path();
        path.moveTo(floatValueX, f2);
        float f7 = floatValueX + f5;
        float f8 = floatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, floatValueY);
        float f9 = f6 + floatValueY;
        path.cubicTo(f3, f9, f7, f4, floatValueX, f4);
        float f10 = floatValueX - f5;
        path.cubicTo(f10, f4, f, f9, f, floatValueY);
        path.cubicTo(f, f8, f10, f2, floatValueX, f2);
        path.close();
        return path;
    }

    private Path makePathAndBoundingBox(SVG.PolyLine polyLine) {
        Path path = new Path();
        path.moveTo(polyLine.points[0], polyLine.points[1]);
        for (int i = 2; i < polyLine.points.length; i += 2) {
            path.lineTo(polyLine.points[i], polyLine.points[i + 1]);
        }
        if (polyLine instanceof SVG.Polygon) {
            path.close();
        }
        if (polyLine.boundingBox == null) {
            polyLine.boundingBox = calculatePathBounds(path);
        }
        return path;
    }

    private Path makePathAndBoundingBox(SVG.Text text) {
        float f = 0.0f;
        float floatValueX = (text.f53x == null || text.f53x.size() == 0) ? 0.0f : text.f53x.get(0).floatValueX(this);
        float floatValueY = (text.f54y == null || text.f54y.size() == 0) ? 0.0f : text.f54y.get(0).floatValueY(this);
        float floatValueX2 = (text.f51dx == null || text.f51dx.size() == 0) ? 0.0f : text.f51dx.get(0).floatValueX(this);
        if (text.f52dy != null && text.f52dy.size() != 0) {
            f = text.f52dy.get(0).floatValueY(this);
        }
        if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
            float calculateTextWidth = calculateTextWidth(text);
            if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                calculateTextWidth /= 2.0f;
            }
            floatValueX -= calculateTextWidth;
        }
        if (text.boundingBox == null) {
            TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
            enumerateTextSpans(text, textBoundsCalculator);
            text.boundingBox = new SVG.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
        }
        Path path = new Path();
        enumerateTextSpans(text, new PlainTextToPath(floatValueX + floatValueX2, floatValueY + f, path));
        return path;
    }

    private void fillWithPattern(SVG.SvgElement svgElement, Path path, SVG.Pattern pattern) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = pattern.patternUnitsAreUser != null && pattern.patternUnitsAreUser.booleanValue();
        if (pattern.href != null) {
            fillInChainedPatternFields(pattern, pattern.href);
        }
        if (z) {
            f = pattern.f33x != null ? pattern.f33x.floatValueX(this) : 0.0f;
            f3 = pattern.f34y != null ? pattern.f34y.floatValueY(this) : 0.0f;
            f4 = pattern.width != null ? pattern.width.floatValueX(this) : 0.0f;
            f2 = pattern.height != null ? pattern.height.floatValueY(this) : 0.0f;
        } else {
            float floatValue = pattern.f33x != null ? pattern.f33x.floatValue(this, 1.0f) : 0.0f;
            float floatValue2 = pattern.f34y != null ? pattern.f34y.floatValue(this, 1.0f) : 0.0f;
            float floatValue3 = pattern.width != null ? pattern.width.floatValue(this, 1.0f) : 0.0f;
            float floatValue4 = pattern.height != null ? pattern.height.floatValue(this, 1.0f) : 0.0f;
            f = (floatValue * svgElement.boundingBox.width) + svgElement.boundingBox.minX;
            float f6 = (floatValue2 * svgElement.boundingBox.height) + svgElement.boundingBox.minY;
            float f7 = floatValue3 * svgElement.boundingBox.width;
            f2 = floatValue4 * svgElement.boundingBox.height;
            f3 = f6;
            f4 = f7;
        }
        if (f4 == 0.0f || f2 == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = pattern.preserveAspectRatio != null ? pattern.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        statePush();
        this.canvas.clipPath(path);
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        rendererState.style.overflow = false;
        this.state = findInheritFromAncestorState(pattern, rendererState);
        SVG.Box box = svgElement.boundingBox;
        if (pattern.patternTransform != null) {
            this.canvas.concat(pattern.patternTransform);
            Matrix matrix = new Matrix();
            if (pattern.patternTransform.invert(matrix)) {
                float[] fArr = {svgElement.boundingBox.minX, svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.maxY(), svgElement.boundingBox.minX, svgElement.boundingBox.maxY()};
                matrix.mapPoints(fArr);
                float f8 = fArr[0];
                float f9 = fArr[1];
                RectF rectF = new RectF(f8, f9, f8, f9);
                for (int i = 2; i <= 6; i += 2) {
                    if (fArr[i] < rectF.left) {
                        rectF.left = fArr[i];
                    }
                    if (fArr[i] > rectF.right) {
                        rectF.right = fArr[i];
                    }
                    int i2 = i + 1;
                    if (fArr[i2] < rectF.top) {
                        rectF.top = fArr[i2];
                    }
                    if (fArr[i2] > rectF.bottom) {
                        rectF.bottom = fArr[i2];
                    }
                }
                box = new SVG.Box(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
            }
        }
        float floor = f + (((float) Math.floor((box.minX - f) / f4)) * f4);
        float maxX = box.maxX();
        float maxY = box.maxY();
        SVG.Box box2 = new SVG.Box(0.0f, 0.0f, f4, f2);
        boolean pushLayer = pushLayer();
        for (float floor2 = f3 + (((float) Math.floor((box.minY - f3) / f2)) * f2); floor2 < maxY; floor2 += f2) {
            float f10 = floor;
            while (f10 < maxX) {
                box2.minX = f10;
                box2.minY = floor2;
                statePush();
                if (this.state.style.overflow.booleanValue()) {
                    f5 = floor;
                } else {
                    f5 = floor;
                    setClipRect(box2.minX, box2.minY, box2.width, box2.height);
                }
                if (pattern.viewBox != null) {
                    this.canvas.concat(calculateViewBoxTransform(box2, pattern.viewBox, preserveAspectRatio));
                } else {
                    boolean z2 = pattern.patternContentUnitsAreUser == null || pattern.patternContentUnitsAreUser.booleanValue();
                    this.canvas.translate(f10, floor2);
                    if (!z2) {
                        this.canvas.scale(svgElement.boundingBox.width, svgElement.boundingBox.height);
                    }
                }
                Iterator<SVG.SvgObject> it = pattern.children.iterator();
                while (it.hasNext()) {
                    render(it.next());
                }
                statePop();
                f10 += f4;
                floor = f5;
            }
        }
        if (pushLayer) {
            popLayer(pattern);
        }
        statePop();
    }

    private void fillInChainedPatternFields(SVG.Pattern pattern, String str) {
        SVG.SvgObject resolveIRI = pattern.document.resolveIRI(str);
        if (resolveIRI == null) {
            warn("Pattern reference '%s' not found", str);
            return;
        }
        if (!(resolveIRI instanceof SVG.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (resolveIRI == pattern) {
            error("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        SVG.Pattern pattern2 = (SVG.Pattern) resolveIRI;
        if (pattern.patternUnitsAreUser == null) {
            pattern.patternUnitsAreUser = pattern2.patternUnitsAreUser;
        }
        if (pattern.patternContentUnitsAreUser == null) {
            pattern.patternContentUnitsAreUser = pattern2.patternContentUnitsAreUser;
        }
        if (pattern.patternTransform == null) {
            pattern.patternTransform = pattern2.patternTransform;
        }
        if (pattern.f33x == null) {
            pattern.f33x = pattern2.f33x;
        }
        if (pattern.f34y == null) {
            pattern.f34y = pattern2.f34y;
        }
        if (pattern.width == null) {
            pattern.width = pattern2.width;
        }
        if (pattern.height == null) {
            pattern.height = pattern2.height;
        }
        if (pattern.children.isEmpty()) {
            pattern.children = pattern2.children;
        }
        if (pattern.viewBox == null) {
            pattern.viewBox = pattern2.viewBox;
        }
        if (pattern.preserveAspectRatio == null) {
            pattern.preserveAspectRatio = pattern2.preserveAspectRatio;
        }
        if (pattern2.href != null) {
            fillInChainedPatternFields(pattern, pattern2.href);
        }
    }

    private void renderMask(SVG.Mask mask, SVG.SvgElement svgElement, SVG.Box box) {
        float f;
        float f2;
        debug("Mask render", new Object[0]);
        boolean z = true;
        if (mask.maskUnitsAreUser != null && mask.maskUnitsAreUser.booleanValue()) {
            f = mask.width != null ? mask.width.floatValueX(this) : box.width;
            f2 = mask.height != null ? mask.height.floatValueY(this) : box.height;
        } else {
            float floatValue = mask.width != null ? mask.width.floatValue(this, 1.0f) : 1.2f;
            float floatValue2 = mask.height != null ? mask.height.floatValue(this, 1.0f) : 1.2f;
            f = floatValue * box.width;
            f2 = floatValue2 * box.height;
        }
        if (f == 0.0f || f2 == 0.0f) {
            return;
        }
        statePush();
        RendererState findInheritFromAncestorState = findInheritFromAncestorState(mask);
        this.state = findInheritFromAncestorState;
        findInheritFromAncestorState.style.opacity = Float.valueOf(1.0f);
        boolean pushLayer = pushLayer();
        this.canvas.save();
        if (mask.maskContentUnitsAreUser != null && !mask.maskContentUnitsAreUser.booleanValue()) {
            z = false;
        }
        if (!z) {
            this.canvas.translate(box.minX, box.minY);
            this.canvas.scale(box.width, box.height);
        }
        renderChildren(mask, false);
        this.canvas.restore();
        if (pushLayer) {
            popLayer(svgElement, box);
        }
        statePop();
    }
}
