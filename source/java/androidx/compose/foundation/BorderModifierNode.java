package androidx.compose.foundation;

import androidx.compose.p002ui.draw.CacheDrawModifierNode;
import androidx.compose.p002ui.draw.CacheDrawScope;
import androidx.compose.p002ui.draw.DrawModifierKt;
import androidx.compose.p002ui.draw.DrawResult;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.geometry.RoundRectKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.BlendMode;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Canvas;
import androidx.compose.p002ui.graphics.ClipOp;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.ColorFilter;
import androidx.compose.p002ui.graphics.ImageBitmap;
import androidx.compose.p002ui.graphics.ImageBitmapConfig;
import androidx.compose.p002ui.graphics.ImageBitmapKt;
import androidx.compose.p002ui.graphics.Outline;
import androidx.compose.p002ui.graphics.Path;
import androidx.compose.p002ui.graphics.PathOperation;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.graphics.SolidColor;
import androidx.compose.p002ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p002ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p002ui.graphics.drawscope.DrawContext;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Border.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ,\u0010%\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002JC\u0010-\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b3\u00104J\f\u00105\u001a\u000206*\u000207H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BorderModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private final boolean isImportantForBounds;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    private BorderModifierNode(float f, Brush brush, Shape shape) {
        this.width = f;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = delegate((DelegatableNode) DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                DrawResult drawWithCacheModifierNode$lambda$0;
                drawWithCacheModifierNode$lambda$0 = BorderModifierNode.drawWithCacheModifierNode$lambda$0(BorderModifierNode.this, (CacheDrawScope) obj);
                return drawWithCacheModifierNode$lambda$0;
            }
        }));
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* renamed from: isImportantForBounds, reason: from getter */
    public boolean getIsImportantForBounds() {
        return this.isImportantForBounds;
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m423setWidth0680j_4(float f) {
        if (Dp.equals-impl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush) {
        if (Intrinsics.areEqual(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawWithCacheModifierNode$lambda$0(BorderModifierNode borderModifierNode, CacheDrawScope cacheDrawScope) {
        DrawResult m417drawRectBorderNsqcLGU;
        DrawResult drawContentWithoutBorder;
        if (!(cacheDrawScope.toPx-0680j_4(borderModifierNode.width) >= 0.0f && Size.m4661getMinDimensionimpl(cacheDrawScope.m4356getSizeNHjbRc()) > 0.0f)) {
            drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(cacheDrawScope);
            return drawContentWithoutBorder;
        }
        float f = 2;
        float min = Math.min(Dp.equals-impl0(borderModifierNode.width, Dp.Companion.getHairline-D9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.toPx-0680j_4(borderModifierNode.width)), (float) Math.ceil(Size.m4661getMinDimensionimpl(cacheDrawScope.m4356getSizeNHjbRc()) / f));
        float f2 = min / f;
        long m4585constructorimpl = Offset.m4585constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        float intBitsToFloat = Float.intBitsToFloat((int) (cacheDrawScope.m4356getSizeNHjbRc() >> 32)) - min;
        long m4653constructorimpl = Size.m4653constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m4356getSizeNHjbRc() & 4294967295L)) - min) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32));
        boolean z = f * min > Size.m4661getMinDimensionimpl(cacheDrawScope.m4356getSizeNHjbRc());
        Outline mo469createOutlinePq9zytI = borderModifierNode.shape.mo469createOutlinePq9zytI(cacheDrawScope.m4356getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        if (mo469createOutlinePq9zytI instanceof Outline.Generic) {
            return borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.brush, (Outline.Generic) mo469createOutlinePq9zytI, z, min);
        }
        if (mo469createOutlinePq9zytI instanceof Outline.Rounded) {
            return borderModifierNode.m421drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode.brush, (Outline.Rounded) mo469createOutlinePq9zytI, m4585constructorimpl, m4653constructorimpl, z, min);
        }
        if (mo469createOutlinePq9zytI instanceof Outline.Rectangle) {
            m417drawRectBorderNsqcLGU = BorderKt.m417drawRectBorderNsqcLGU(cacheDrawScope, borderModifierNode.brush, m4585constructorimpl, m4653constructorimpl, z, min);
            return m417drawRectBorderNsqcLGU;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0100, code lost:
    
        if (androidx.compose.p002ui.graphics.ImageBitmapConfig.m5066equalsimpl(r14, r6 != null ? androidx.compose.p002ui.graphics.ImageBitmapConfig.m5064boximpl(r6.mo4702getConfig_sVssgQ()) : null) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final DrawResult drawGenericBorder(CacheDrawScope cacheDrawScope, final Brush brush, final Outline.Generic generic, boolean z, float f) {
        int m5072getArgb8888_sVssgQ;
        ColorFilter colorFilter;
        Canvas canvas;
        ImageBitmap imageBitmap;
        float f2;
        long j;
        DrawContext drawContext;
        if (z) {
            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit drawGenericBorder$lambda$1;
                    drawGenericBorder$lambda$1 = BorderModifierNode.drawGenericBorder$lambda$1(Outline.Generic.this, brush, (ContentDrawScope) obj);
                    return drawGenericBorder$lambda$1;
                }
            });
        }
        if (brush instanceof SolidColor) {
            m5072getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m5071getAlpha8_sVssgQ();
            colorFilter = ColorFilter.Companion.m4880tintxETnrds$default(ColorFilter.INSTANCE, Color.m4838copywmQWz5c$default(((SolidColor) brush).getValue(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null);
        } else {
            m5072getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m5072getArgb8888_sVssgQ();
            colorFilter = null;
        }
        final Rect bounds = generic.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        Path obtainPath = borderCache.obtainPath();
        obtainPath.reset();
        Path.addRect$default(obtainPath, bounds, null, 2, null);
        obtainPath.mo4727opN5in7k0(obtainPath, generic.getPath(), PathOperation.INSTANCE.m5144getDifferenceb3I0S0c());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final long j2 = IntSize.constructor-impl((((int) Math.ceil(bounds.getBottom() - bounds.getTop())) & 4294967295L) | (((int) Math.ceil(bounds.getRight() - bounds.getLeft())) << 32));
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        ImageBitmap imageBitmap2 = borderCache2.imageBitmap;
        Canvas canvas2 = borderCache2.canvas;
        ImageBitmapConfig m5064boximpl = imageBitmap2 != null ? ImageBitmapConfig.m5064boximpl(imageBitmap2.mo4702getConfig_sVssgQ()) : null;
        boolean z2 = false;
        if (!(m5064boximpl == null ? false : ImageBitmapConfig.m5067equalsimpl0(m5064boximpl.m5070unboximpl(), ImageBitmapConfig.INSTANCE.m5072getArgb8888_sVssgQ()))) {
        }
        z2 = true;
        if (imageBitmap2 == null || canvas2 == null || Float.intBitsToFloat((int) (cacheDrawScope.m4356getSizeNHjbRc() >> 32)) > imageBitmap2.getWidth() || Float.intBitsToFloat((int) (cacheDrawScope.m4356getSizeNHjbRc() & 4294967295L)) > imageBitmap2.getHeight() || !z2) {
            ImageBitmap m5077ImageBitmapx__hDU$default = ImageBitmapKt.m5077ImageBitmapx__hDU$default((int) (j2 >> 32), (int) (j2 & 4294967295L), m5072getArgb8888_sVssgQ, false, null, 24, null);
            borderCache2.imageBitmap = m5077ImageBitmapx__hDU$default;
            Canvas Canvas = androidx.compose.p002ui.graphics.CanvasKt.Canvas(m5077ImageBitmapx__hDU$default);
            borderCache2.canvas = Canvas;
            canvas = Canvas;
            imageBitmap = m5077ImageBitmapx__hDU$default;
        } else {
            imageBitmap = imageBitmap2;
            canvas = canvas2;
        }
        CanvasDrawScope canvasDrawScope = borderCache2.canvasDrawScope;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            borderCache2.canvasDrawScope = canvasDrawScope;
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        long j3 = IntSizeKt.toSize-ozmzZPI(j2);
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas3 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m5337setSizeuvyYCjk(j3);
        canvas.save();
        CanvasDrawScope canvasDrawScope3 = canvasDrawScope2;
        DrawScope.m5411drawRectnJ9OG0$default(canvasDrawScope3, Color.INSTANCE.m4865getBlack0d7_KjU(), 0L, j3, 0.0f, null, null, BlendMode.INSTANCE.m4751getClear0nO6VwU(), 58, null);
        float f3 = -bounds.getLeft();
        float f4 = -bounds.getTop();
        canvasDrawScope3.getDrawContext().getTransform().translate(f3, f4);
        try {
            try {
                DrawScope.m5406drawPathGBMwjPU$default(canvasDrawScope3, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                float f5 = 1;
                float intBitsToFloat = (Float.intBitsToFloat((int) (canvasDrawScope3.m5417getSizeNHjbRc() >> 32)) + f5) / Float.intBitsToFloat((int) (canvasDrawScope3.m5417getSizeNHjbRc() >> 32));
                float intBitsToFloat2 = (Float.intBitsToFloat((int) (canvasDrawScope3.m5417getSizeNHjbRc() & 4294967295L)) + f5) / Float.intBitsToFloat((int) (canvasDrawScope3.m5417getSizeNHjbRc() & 4294967295L));
                long m5416getCenterF1C5BW0 = canvasDrawScope3.m5416getCenterF1C5BW0();
                DrawContext drawContext2 = canvasDrawScope3.getDrawContext();
                long mo5338getSizeNHjbRc = drawContext2.mo5338getSizeNHjbRc();
                drawContext2.getCanvas().save();
                try {
                    drawContext2.getTransform().mo5345scale0AR0LA0(intBitsToFloat, intBitsToFloat2, m5416getCenterF1C5BW0);
                    drawContext = drawContext2;
                } catch (Throwable th) {
                    th = th;
                    j = mo5338getSizeNHjbRc;
                    drawContext = drawContext2;
                    f4 = f4;
                    f2 = f3;
                }
                try {
                    DrawScope.m5406drawPathGBMwjPU$default(canvasDrawScope3, obtainPath, brush, 0.0f, null, null, BlendMode.INSTANCE.m4751getClear0nO6VwU(), 28, null);
                    drawContext.getCanvas().restore();
                    drawContext.mo5339setSizeuvyYCjk(mo5338getSizeNHjbRc);
                    canvasDrawScope3.getDrawContext().getTransform().translate(-f3, -f4);
                    canvas.restore();
                    CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
                    drawParams3.setDensity(density);
                    drawParams3.setLayoutDirection(layoutDirection2);
                    drawParams3.setCanvas(canvas3);
                    drawParams3.m5337setSizeuvyYCjk(size);
                    imageBitmap.prepareToDraw();
                    objectRef.element = imageBitmap;
                    final ColorFilter colorFilter2 = colorFilter;
                    return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit drawGenericBorder$lambda$8;
                            drawGenericBorder$lambda$8 = BorderModifierNode.drawGenericBorder$lambda$8(Rect.this, objectRef, j2, colorFilter2, (ContentDrawScope) obj);
                            return drawGenericBorder$lambda$8;
                        }
                    });
                } catch (Throwable th2) {
                    th = th2;
                    f4 = f4;
                    f2 = f3;
                    j = mo5338getSizeNHjbRc;
                    try {
                        drawContext.getCanvas().restore();
                        drawContext.mo5339setSizeuvyYCjk(j);
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        canvasDrawScope3.getDrawContext().getTransform().translate(-f2, -f4);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                f4 = f4;
                f2 = f3;
            }
        } catch (Throwable th5) {
            th = th5;
            f2 = f3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawGenericBorder$lambda$1(Outline.Generic generic, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m5406drawPathGBMwjPU$default(contentDrawScope, generic.getPath(), brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawGenericBorder$lambda$8(Rect rect, Ref.ObjectRef objectRef, long j, ColorFilter colorFilter, ContentDrawScope contentDrawScope) {
        float f;
        float f2;
        contentDrawScope.drawContent();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float left = rect.getLeft();
        float top = rect.getTop();
        contentDrawScope2.getDrawContext().getTransform().translate(left, top);
        try {
            try {
                DrawScope.m5400drawImageAZ2fEMs$default(contentDrawScope2, (ImageBitmap) objectRef.element, 0L, j, 0L, 0L, 0.0f, null, colorFilter, 0, 0, 890, null);
                contentDrawScope2.getDrawContext().getTransform().translate(-left, -top);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                f = top;
                f2 = left;
                contentDrawScope2.getDrawContext().getTransform().translate(-f2, -f);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            f = top;
            f2 = left;
        }
    }

    /* renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    private final DrawResult m421drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        final Path createRoundRectPath;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long m4643getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m4643getTopLeftCornerRadiuskKHJgLs();
            final float f2 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit drawRoundRectBorder_JqoCqck$lambda$10;
                    drawRoundRectBorder_JqoCqck$lambda$10 = BorderModifierNode.drawRoundRectBorder_JqoCqck$lambda$10(z, brush, m4643getTopLeftCornerRadiuskKHJgLs, f2, f, j, j2, stroke, (ContentDrawScope) obj);
                    return drawRoundRectBorder_JqoCqck$lambda$10;
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        createRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit drawRoundRectBorder_JqoCqck$lambda$11;
                drawRoundRectBorder_JqoCqck$lambda$11 = BorderModifierNode.drawRoundRectBorder_JqoCqck$lambda$11(Path.this, brush, (ContentDrawScope) obj);
                return drawRoundRectBorder_JqoCqck$lambda$11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRoundRectBorder_JqoCqck$lambda$10(boolean z, Brush brush, long j, float f, float f2, long j2, long j3, Stroke stroke, ContentDrawScope contentDrawScope) {
        long m418shrinkKibmq7A;
        long j4;
        contentDrawScope.drawContent();
        if (z) {
            DrawScope.m5412drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
        } else if (Float.intBitsToFloat((int) (j >> 32)) >= f) {
            m418shrinkKibmq7A = BorderKt.m418shrinkKibmq7A(j, f);
            DrawScope.m5412drawRoundRectZuiqVtQ$default(contentDrawScope, brush, j2, j3, m418shrinkKibmq7A, 0.0f, stroke, null, 0, 208, null);
        } else {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            float intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() >> 32)) - f2;
            float intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() & 4294967295L)) - f2;
            int m4827getDifferencertfAjoo = ClipOp.INSTANCE.m4827getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            long mo5338getSizeNHjbRc = drawContext.mo5338getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5341clipRectN_I0leg(f2, f2, intBitsToFloat, intBitsToFloat2, m4827getDifferencertfAjoo);
                try {
                    DrawScope.m5412drawRoundRectZuiqVtQ$default(contentDrawScope2, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
                    drawContext.getCanvas().restore();
                    drawContext.mo5339setSizeuvyYCjk(mo5338getSizeNHjbRc);
                } catch (Throwable th) {
                    th = th;
                    j4 = mo5338getSizeNHjbRc;
                    drawContext.getCanvas().restore();
                    drawContext.mo5339setSizeuvyYCjk(j4);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                j4 = mo5338getSizeNHjbRc;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRoundRectBorder_JqoCqck$lambda$11(Path path, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m5406drawPathGBMwjPU$default(contentDrawScope, path, brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }
}
