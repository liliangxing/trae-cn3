package com.lynx.tasm.behavior.p000ui.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.UIShadowProxy;
import com.lynx.tasm.behavior.p000ui.background.BackgroundLayerManager;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BackgroundDrawable extends LayerDrawable<BackgroundLayerManager> {
    private static final int ALL_BITS_SET = -1;
    private static final int ALL_BITS_UNSET = 0;
    private static final int DEFAULT_BORDER_ALPHA = 255;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int DEFAULT_BORDER_RGB = 0;
    private int mAlpha;
    private Spacing mBorderAlpha;
    private BorderRadius mBorderCornerRadii;
    private Spacing mBorderRGB;
    private BorderStyle[] mBorderStyle;
    private boolean mBorderWidthChanged;
    private UIShadowProxy.InsetDrawer mBoxShadowInsetDrawer;
    private int mColor;
    private PointF mInnerBottomLeftCorner;
    private PointF mInnerBottomRightCorner;
    private RoundRectPath mInnerClipPathForBorderRadius;
    private PointF mInnerTopLeftCorner;
    private PointF mInnerTopRightCorner;
    private boolean mNeedUpdatePathForBorderRadius;
    private RoundRectPath mOuterClipPathForBorderRadius;
    private boolean mPaddingWidthChanged;
    private final Paint mPaint;
    private Map<RoundRectPath.Pos, RoundRectPath> mPathCache;
    private PathEffect mPathEffectForBorderStyle;
    private Path mPathForBorder;
    private Path mPathForBorderRadiusOutline;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    private static int colorFromAlphaAndRGBComponents(float f, float f2) {
        return ((((int) f) << 24) & DEFAULT_BORDER_COLOR) | (((int) f2) & TypedValue.COMPLEX_MANTISSA_MASK);
    }

    private static int darkenColor(int i) {
        return (i & DEFAULT_BORDER_COLOR) | ((16711422 & i) >> 1);
    }

    private static int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = (i4 > 0 ? i8 : -1) & (i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1);
        if (i <= 0) {
            i5 = 0;
        }
        if (i2 <= 0) {
            i6 = 0;
        }
        int i10 = i5 | i6;
        if (i3 <= 0) {
            i7 = 0;
        }
        int i11 = i10 | i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        if (i9 == (i11 | i8)) {
            return i9;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class RoundRectPath {
        public boolean allCornersWithSameRadius;
        public Path path;
        public float[] radius;
        public RectF rect;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public enum Pos {
            CENTER,
            INNER2,
            OUTER2,
            INNER3,
            OUTER3;

            public float getOffset() {
                int i = C01381.f12x468894d3[ordinal()];
                if (i == 1) {
                    return 0.5f;
                }
                if (i == 2) {
                    return 0.75f;
                }
                if (i == 3) {
                    return 0.25f;
                }
                if (i != 4) {
                    return i != 5 ? 0.0f : 0.16666667f;
                }
                return 0.8333333f;
            }
        }

        public void updateValue(Rect rect, float[] fArr, RectF rectF, float f, boolean z) {
            float[] newBorderRadius;
            if (this.rect == null) {
                this.rect = new RectF();
            }
            this.rect.left = rect.left + (rectF.left * f);
            this.rect.top = rect.top + (rectF.top * f);
            this.rect.right = rect.right - (rectF.right * f);
            this.rect.bottom = rect.bottom - (rectF.bottom * f);
            if (z) {
                newBorderRadius = newCenterBorderRadius(fArr, rectF, f);
            } else {
                newBorderRadius = newBorderRadius(fArr, rectF, f);
            }
            this.radius = newBorderRadius;
            this.allCornersWithSameRadius = checkAllCornersWithSameRadius(newBorderRadius);
            Path path = this.path;
            if (path == null) {
                this.path = new Path();
            } else {
                path.reset();
            }
            this.path.addRoundRect(this.rect, this.radius, Path.Direction.CW);
        }

        public static float[] newBorderRadius(float[] fArr, RectF rectF, float f) {
            return new float[]{Math.max(fArr[0] - (rectF.left * f), 0.0f), Math.max(fArr[1] - (rectF.top * f), 0.0f), Math.max(fArr[2] - (rectF.right * f), 0.0f), Math.max(fArr[3] - (rectF.top * f), 0.0f), Math.max(fArr[4] - (rectF.right * f), 0.0f), Math.max(fArr[5] - (rectF.bottom * f), 0.0f), Math.max(fArr[6] - (rectF.left * f), 0.0f), Math.max(fArr[7] - (rectF.bottom * f), 0.0f)};
        }

        public static float[] newCenterBorderRadius(float[] fArr, RectF rectF, float f) {
            float[] fArr2 = new float[8];
            fArr2[0] = Math.max(fArr[0] - (rectF.left * f), rectF.left > 0.0f ? fArr[0] / rectF.left : 0.0f);
            fArr2[1] = Math.max(fArr[1] - (rectF.top * f), rectF.top > 0.0f ? fArr[1] / rectF.top : 0.0f);
            fArr2[2] = Math.max(fArr[2] - (rectF.right * f), rectF.right > 0.0f ? fArr[2] / rectF.right : 0.0f);
            fArr2[3] = Math.max(fArr[3] - (rectF.top * f), rectF.top > 0.0f ? fArr[3] / rectF.top : 0.0f);
            fArr2[4] = Math.max(fArr[4] - (rectF.right * f), rectF.right > 0.0f ? fArr[4] / rectF.right : 0.0f);
            fArr2[5] = Math.max(fArr[5] - (rectF.bottom * f), rectF.bottom > 0.0f ? fArr[5] / rectF.bottom : 0.0f);
            fArr2[6] = Math.max(fArr[6] - (rectF.left * f), rectF.left > 0.0f ? fArr[6] / rectF.left : 0.0f);
            fArr2[7] = Math.max(fArr[7] - (rectF.bottom * f), rectF.bottom > 0.0f ? fArr[7] / rectF.bottom : 0.0f);
            return fArr2;
        }

        public static boolean checkAllCornersWithSameRadius(float[] fArr) {
            int i;
            while (i <= 6) {
                float f = fArr[i] - fArr[0];
                if (f <= 1.0E-4f && f >= -1.0E-4f) {
                    float f2 = fArr[i + 1] - fArr[1];
                    i = (f2 <= 1.0E-4f && f2 >= -1.0E-4f) ? i + 2 : 2;
                }
                return false;
            }
            return true;
        }

        public void drawToCanvas(Canvas canvas, Paint paint) {
            if (this.allCornersWithSameRadius) {
                RectF rectF = this.rect;
                float[] fArr = this.radius;
                canvas.drawRoundRect(rectF, fArr[0], fArr[1], paint);
                return;
            }
            canvas.drawPath(this.path, paint);
        }
    }

    private RoundRectPath getPathFromCache(RoundRectPath.Pos pos) {
        Map<RoundRectPath.Pos, RoundRectPath> map;
        if (pos == null || (map = this.mPathCache) == null) {
            return null;
        }
        return map.get(pos);
    }

    private void updateCachePath(RoundRectPath.Pos pos, Rect rect, float[] fArr, RectF rectF) {
        RoundRectPath roundRectPath;
        if (pos == null || fArr == null) {
            return;
        }
        try {
            Map<RoundRectPath.Pos, RoundRectPath> map = this.mPathCache;
            if (map != null) {
                roundRectPath = map.get(pos);
            } else {
                this.mPathCache = new HashMap();
                roundRectPath = null;
            }
            if (roundRectPath == null) {
                roundRectPath = new RoundRectPath();
                this.mPathCache.put(pos, roundRectPath);
            }
            roundRectPath.updateValue(rect, fArr, rectF, pos.getOffset(), true);
        } catch (Exception e) {
            LLog.e("BackgroundDrawable", "updateCachePath exception:" + e.toString());
        }
    }

    public BackgroundDrawable(LynxContext lynxContext, float f) {
        super(lynxContext, f);
        this.mPaddingWidthChanged = false;
        this.mBorderWidthChanged = false;
        this.mNeedUpdatePathForBorderRadius = true;
        this.mPaint = new Paint(1);
        this.mColor = 0;
        this.mAlpha = 255;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lynx.tasm.behavior.p000ui.utils.LayerDrawable
    public BackgroundLayerManager createLayerManager() {
        return new BackgroundLayerManager(this.mContext, this, this.mCurFontSize);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mPaddingWidthChanged || this.mBorderWidthChanged) {
            updateContentBox();
            this.mBorderWidthChanged = false;
            this.mPaddingWidthChanged = false;
        }
        drawBackGround(canvas);
        BorderRadius borderRadius = this.mBorderCornerRadii;
        if (borderRadius == null || !borderRadius.hasRoundedBorders()) {
            drawRectangularBorders(canvas);
        } else {
            drawRoundedBorders(canvas);
        }
        UIShadowProxy.InsetDrawer insetDrawer = this.mBoxShadowInsetDrawer;
        if (insetDrawer != null) {
            insetDrawer.draw(canvas);
        }
    }

    private void drawRectangularRect(Canvas canvas) {
        int layerClip = ((BackgroundLayerManager) this.mLayerManager).getLayerClip();
        if (layerClip == 1) {
            canvas.drawRect(getBounds(), this.mPaint);
        } else if (layerClip == 0) {
            canvas.drawRect(this.mPaddingBox, this.mPaint);
        } else {
            canvas.drawRect(this.mContentBox, this.mPaint);
        }
    }

    private void drawRoundedRect(Canvas canvas) {
        RoundRectPath roundRectPath;
        RoundRectPath roundRectPath2;
        int layerClip = ((BackgroundLayerManager) this.mLayerManager).getLayerClip();
        if (layerClip != 1) {
            if (layerClip == 0 && (roundRectPath = this.mInnerClipPathForBorderRadius) != null) {
                roundRectPath.drawToCanvas(canvas, this.mPaint);
                return;
            } else {
                canvas.drawRect(this.mContentBox, this.mPaint);
                return;
            }
        }
        if (hasTransparentBorder() && (roundRectPath2 = this.mOuterClipPathForBorderRadius) != null) {
            roundRectPath2.drawToCanvas(canvas, this.mPaint);
            return;
        }
        RoundRectPath roundRectPath3 = this.mInnerClipPathForBorderRadius;
        if (roundRectPath3 != null) {
            roundRectPath3.drawToCanvas(canvas, this.mPaint);
        }
    }

    public void drawBackGround(Canvas canvas) {
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            this.mPaint.setColor(multiplyColorAlpha);
            this.mPaint.setStyle(Paint.Style.FILL);
            BorderRadius borderRadius = this.mBorderCornerRadii;
            if (borderRadius == null || !borderRadius.hasRoundedBorders()) {
                drawRectangularRect(canvas);
            } else if (updatePath()) {
                drawRoundedRect(canvas);
            }
        }
        if (((BackgroundLayerManager) this.mLayerManager).hasImageLayers()) {
            canvas.save();
            RectF rectF = new RectF(getBounds());
            RectF rectF2 = new RectF(this.mPaddingBox);
            RectF rectF3 = new RectF(this.mContentBox);
            if (this.mBorderCornerRadii != null) {
                updatePath();
            }
            RoundRectPath roundRectPath = this.mOuterClipPathForBorderRadius;
            Path path = roundRectPath != null ? roundRectPath.path : null;
            RoundRectPath roundRectPath2 = this.mInnerClipPathForBorderRadius;
            ((BackgroundLayerManager) this.mLayerManager).draw(canvas, rectF, rectF2, rectF3, rectF, path, roundRectPath2 != null ? roundRectPath2.path : null, this.mBorderWidth != null);
            canvas.restore();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.utils.LayerDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mNeedUpdatePathForBorderRadius = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return ColorUtil.getOpacityFromColor(ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Path path;
        if (this.mBorderCornerRadii != null && updatePath() && (path = this.mPathForBorderRadiusOutline) != null) {
            outline.setConvexPath(path);
        } else {
            outline.setRect(getBounds());
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.utils.LayerDrawable
    public boolean setBorderWidth(int i, float f) {
        boolean borderWidth = super.setBorderWidth(i, f);
        if (borderWidth) {
            this.mNeedUpdatePathForBorderRadius = true;
            this.mBorderWidthChanged = true;
        }
        return borderWidth;
    }

    @Override // com.lynx.tasm.behavior.p000ui.utils.LayerDrawable
    public boolean setPaddingWidth(float f, float f2, float f3, float f4) {
        boolean paddingWidth = super.setPaddingWidth(f, f2, f3, f4);
        if (paddingWidth) {
            this.mNeedUpdatePathForBorderRadius = true;
            this.mPaddingWidthChanged = true;
        }
        return paddingWidth;
    }

    public void setBorderColor(int i, float f, float f2) {
        setBorderRGB(i, f);
        setBorderAlpha(i, f2);
    }

    private void setBorderRGB(int i, float f) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing(0.0f);
        }
        this.mBorderRGB.set(i, f);
    }

    private void setBorderAlpha(int i, float f) {
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        this.mBorderAlpha.set(i, f);
    }

    public BorderStyle getBorderStyle(int i) {
        BorderStyle[] borderStyleArr;
        if (i > 8 || i < 0 || (borderStyleArr = this.mBorderStyle) == null) {
            return null;
        }
        BorderStyle borderStyle = borderStyleArr[i];
        return borderStyle != null ? borderStyle : borderStyleArr[8];
    }

    public void setBorderStyle(int i, int i2) {
        if (i > 8 || i < 0) {
            return;
        }
        if (this.mBorderStyle == null) {
            this.mBorderStyle = new BorderStyle[9];
        }
        try {
            BorderStyle parse = BorderStyle.parse(i2);
            BorderStyle[] borderStyleArr = this.mBorderStyle;
            if (borderStyleArr[i] != parse) {
                borderStyleArr[i] = parse;
                invalidateSelf();
            }
        } catch (Throwable unused) {
        }
    }

    public BorderRadius getBorderRadius() {
        return this.mBorderCornerRadii;
    }

    public void setBorderRadiusCorner(int i, BorderRadius.Corner corner) {
        if (i <= 0 || i > 8) {
            return;
        }
        BorderRadius borderRadius = this.mBorderCornerRadii;
        if (borderRadius == null) {
            this.mBorderCornerRadii = new BorderRadius();
            updateCornerRadii();
        } else {
            borderRadius.clearCache();
        }
        if (this.mBorderCornerRadii.setCorner(i - 1, corner)) {
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    private void updateCornerRadii() {
        if (this.mBorderCornerRadii != null) {
            Rect bounds = getBounds();
            this.mBorderCornerRadii.updateSize(bounds.width(), bounds.height());
        }
    }

    public void setColor(int i) {
        this.mColor = i;
        invalidateSelf();
    }

    public int getColor() {
        return this.mColor;
    }

    private void drawRoundedBorders(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        boolean z;
        boolean z2;
        float f5;
        boolean z3;
        float f6;
        boolean z4;
        float f7;
        boolean z5;
        float f8;
        boolean z6;
        if (updatePath()) {
            canvas.save();
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            int calcBorderMeasureWidth = calcBorderMeasureWidth(directionAwareBorderInsets.left);
            int calcBorderMeasureWidth2 = calcBorderMeasureWidth(directionAwareBorderInsets.top);
            int calcBorderMeasureWidth3 = calcBorderMeasureWidth(directionAwareBorderInsets.right);
            int calcBorderMeasureWidth4 = calcBorderMeasureWidth(directionAwareBorderInsets.bottom);
            if (calcBorderMeasureWidth2 > 0 || calcBorderMeasureWidth4 > 0 || calcBorderMeasureWidth > 0 || calcBorderMeasureWidth3 > 0) {
                int borderColor = getBorderColor(8);
                int borderColor2 = getBorderColor(0);
                boolean z7 = borderColor2 == getBorderColor(2) && borderColor2 == getBorderColor(1) && borderColor2 == getBorderColor(3);
                int i = z7 ? borderColor2 : borderColor;
                boolean z8 = calcBorderMeasureWidth2 == calcBorderMeasureWidth && calcBorderMeasureWidth4 == calcBorderMeasureWidth && calcBorderMeasureWidth3 == calcBorderMeasureWidth;
                if (z8 && z7 && toDrawBorderUseSameStyle() && calcBorderMeasureWidth > 0) {
                    float f9 = calcBorderMeasureWidth;
                    strokeCenterDrawPath(canvas, 1, i, f9, f9);
                } else {
                    int borderColor3 = getBorderColor(0);
                    int borderColor4 = getBorderColor(1);
                    int borderColor5 = getBorderColor(2);
                    int borderColor6 = getBorderColor(3);
                    RectF rectF = this.mOuterClipPathForBorderRadius.rect;
                    float f10 = rectF.left;
                    float f11 = rectF.right;
                    float f12 = rectF.top;
                    float f13 = rectF.bottom;
                    if (calcBorderMeasureWidth2 <= 0 || Color.alpha(borderColor4) == 0) {
                        f = f13;
                        f2 = f12;
                        f3 = f11;
                        f4 = f10;
                        z = true;
                        z2 = false;
                    } else {
                        float f14 = this.mInnerTopLeftCorner.x;
                        float f15 = this.mInnerTopLeftCorner.y;
                        float f16 = this.mInnerTopRightCorner.x;
                        float f17 = this.mInnerTopRightCorner.y;
                        float f18 = directionAwareBorderInsets.top;
                        if (z8) {
                            f8 = f18;
                            z6 = false;
                        } else {
                            float max = Math.max(f18, Math.max(directionAwareBorderInsets.left, directionAwareBorderInsets.right));
                            f8 = max;
                            z6 = max - Math.min(directionAwareBorderInsets.left, directionAwareBorderInsets.right) >= 2.0f;
                        }
                        canvas.save();
                        f = f13;
                        f2 = f12;
                        f3 = f11;
                        f4 = f10;
                        z = true;
                        z2 = false;
                        clipQuadrilateral(canvas, f10, f12, f14, f15, f16, f17, f3, f2, z6);
                        strokeCenterDrawPath(canvas, 1, borderColor4, directionAwareBorderInsets.top, f8);
                        canvas.restore();
                    }
                    if (calcBorderMeasureWidth3 > 0 && Color.alpha(borderColor5) != 0) {
                        float f19 = this.mInnerTopRightCorner.x;
                        float f20 = this.mInnerTopRightCorner.y;
                        float f21 = this.mInnerBottomRightCorner.x;
                        float f22 = this.mInnerBottomRightCorner.y;
                        float f23 = directionAwareBorderInsets.right;
                        if (z8) {
                            f7 = f23;
                            z5 = z2;
                        } else {
                            float max2 = Math.max(f23, Math.max(directionAwareBorderInsets.top, directionAwareBorderInsets.bottom));
                            z5 = max2 - Math.min(directionAwareBorderInsets.top, directionAwareBorderInsets.bottom) >= 2.0f ? z : z2;
                            f7 = max2;
                        }
                        canvas.save();
                        clipQuadrilateral(canvas, f3, f2, f19, f20, f21, f22, f3, f, z5);
                        strokeCenterDrawPath(canvas, 2, borderColor5, directionAwareBorderInsets.right, f7);
                        canvas.restore();
                    }
                    if (calcBorderMeasureWidth4 > 0 && Color.alpha(borderColor6) != 0) {
                        float f24 = this.mInnerBottomLeftCorner.x;
                        float f25 = this.mInnerBottomLeftCorner.y;
                        float f26 = this.mInnerBottomRightCorner.x;
                        float f27 = this.mInnerBottomRightCorner.y;
                        float f28 = directionAwareBorderInsets.bottom;
                        if (z8) {
                            f6 = f28;
                            z4 = z2;
                        } else {
                            float max3 = Math.max(f28, Math.max(directionAwareBorderInsets.left, directionAwareBorderInsets.right));
                            z4 = max3 - Math.min(directionAwareBorderInsets.left, directionAwareBorderInsets.right) >= 2.0f ? z : z2;
                            f6 = max3;
                        }
                        canvas.save();
                        clipQuadrilateral(canvas, f4, f, f24, f25, f26, f27, f3, f, z4);
                        strokeCenterDrawPath(canvas, 3, borderColor6, directionAwareBorderInsets.bottom, f6);
                        canvas.restore();
                    }
                    if (calcBorderMeasureWidth > 0 && Color.alpha(borderColor3) != 0) {
                        float f29 = this.mInnerTopLeftCorner.x;
                        float f30 = this.mInnerTopLeftCorner.y;
                        float f31 = this.mInnerBottomLeftCorner.x;
                        float f32 = this.mInnerBottomLeftCorner.y;
                        float f33 = directionAwareBorderInsets.left;
                        if (z8) {
                            f5 = f33;
                            z3 = z2;
                        } else {
                            float max4 = Math.max(f33, Math.max(directionAwareBorderInsets.top, directionAwareBorderInsets.bottom));
                            z3 = max4 - Math.min(directionAwareBorderInsets.top, directionAwareBorderInsets.bottom) >= 2.0f ? z : z2;
                            f5 = max4;
                        }
                        canvas.save();
                        clipQuadrilateral(canvas, f4, f2, f29, f30, f31, f32, f4, f, z3);
                        strokeCenterDrawPath(canvas, 0, borderColor3, directionAwareBorderInsets.left, f5);
                        canvas.restore();
                    }
                }
            }
            canvas.restore();
        }
    }

    private boolean updatePath() {
        if (this.mBorderCornerRadii == null) {
            return false;
        }
        if (!this.mNeedUpdatePathForBorderRadius) {
            return true;
        }
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            return false;
        }
        this.mNeedUpdatePathForBorderRadius = false;
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        updateCornerRadii();
        BorderRadius borderRadius = this.mBorderCornerRadii;
        float[] array = borderRadius != null ? borderRadius.getArray() : null;
        if (this.mInnerClipPathForBorderRadius == null) {
            this.mInnerClipPathForBorderRadius = new RoundRectPath();
        }
        this.mInnerClipPathForBorderRadius.updateValue(bounds, array, directionAwareBorderInsets, 1.0f, false);
        if (this.mOuterClipPathForBorderRadius == null) {
            this.mOuterClipPathForBorderRadius = new RoundRectPath();
        }
        this.mOuterClipPathForBorderRadius.updateValue(bounds, array, directionAwareBorderInsets, 0.0f, false);
        BorderRadius borderRadius2 = this.mBorderCornerRadii;
        if (borderRadius2 != null && borderRadius2.hasRoundedBorders()) {
            updateCachePath(RoundRectPath.Pos.CENTER, bounds, array, directionAwareBorderInsets);
            if (this.mBorderStyle != null) {
                boolean z = false;
                boolean z2 = false;
                for (int i = 0; i <= 8; i++) {
                    BorderStyle borderStyle = this.mBorderStyle[i];
                    if (borderStyle != null) {
                        if (borderStyle == BorderStyle.DOUBLE) {
                            z = true;
                        } else if (borderStyle == BorderStyle.GROOVE || borderStyle == BorderStyle.RIDGE) {
                            z2 = true;
                        }
                    }
                }
                if (z) {
                    updateCachePath(RoundRectPath.Pos.INNER3, bounds, array, directionAwareBorderInsets);
                    updateCachePath(RoundRectPath.Pos.OUTER3, bounds, array, directionAwareBorderInsets);
                }
                if (z2) {
                    updateCachePath(RoundRectPath.Pos.INNER2, bounds, array, directionAwareBorderInsets);
                    updateCachePath(RoundRectPath.Pos.OUTER2, bounds, array, directionAwareBorderInsets);
                }
            }
        }
        Path path = this.mPathForBorderRadiusOutline;
        if (path == null) {
            this.mPathForBorderRadiusOutline = new Path();
        } else {
            path.reset();
        }
        this.mPathForBorderRadiusOutline.addRoundRect(new RectF(bounds), RoundRectPath.newBorderRadius(array, directionAwareBorderInsets, -0.5f), Path.Direction.CW);
        roundMultiColoredBorderAlgorithm();
        return true;
    }

    private void roundMultiColoredBorderAlgorithm() {
        RectF rectF = this.mInnerClipPathForBorderRadius.rect;
        RectF rectF2 = this.mOuterClipPathForBorderRadius.rect;
        float[] fArr = this.mInnerClipPathForBorderRadius.radius;
        if (this.mInnerTopLeftCorner == null) {
            this.mInnerTopLeftCorner = new PointF();
        }
        this.mInnerTopLeftCorner.x = this.mInnerClipPathForBorderRadius.rect.left;
        this.mInnerTopLeftCorner.y = this.mInnerClipPathForBorderRadius.rect.top;
        getEllipseIntersectionWithLine(rectF.left, rectF.top, rectF.left + (fArr[0] * 2.0f), rectF.top + (fArr[1] * 2.0f), rectF2.left, rectF2.top, rectF.left, rectF.top, this.mInnerTopLeftCorner);
        if (this.mInnerBottomLeftCorner == null) {
            this.mInnerBottomLeftCorner = new PointF();
        }
        this.mInnerBottomLeftCorner.x = rectF.left;
        this.mInnerBottomLeftCorner.y = rectF.bottom;
        getEllipseIntersectionWithLine(rectF.left, rectF.bottom - (fArr[6] * 2.0f), rectF.left + (fArr[7] * 2.0f), rectF.bottom, rectF2.left, rectF2.bottom, rectF.left, rectF.bottom, this.mInnerBottomLeftCorner);
        if (this.mInnerTopRightCorner == null) {
            this.mInnerTopRightCorner = new PointF();
        }
        this.mInnerTopRightCorner.x = rectF.right;
        this.mInnerTopRightCorner.y = rectF.top;
        getEllipseIntersectionWithLine(rectF.right - (fArr[2] * 2.0f), rectF.top, rectF.right, rectF.top + (fArr[3] * 2.0f), rectF2.right, rectF2.top, rectF.right, rectF.top, this.mInnerTopRightCorner);
        if (this.mInnerBottomRightCorner == null) {
            this.mInnerBottomRightCorner = new PointF();
        }
        this.mInnerBottomRightCorner.x = rectF.right;
        this.mInnerBottomRightCorner.y = rectF.bottom;
        getEllipseIntersectionWithLine(rectF.right - (fArr[4] * 2.0f), rectF.bottom - (fArr[5] * 2.0f), rectF.right, rectF.bottom, rectF2.right, rectF2.bottom, rectF.right, rectF.bottom, this.mInnerBottomRightCorner);
    }

    private static void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        double d9 = (d + d3) / 2.0d;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = d5 - d9;
        double d12 = d6 - d10;
        double abs = Math.abs(d3 - d) / 2.0d;
        double abs2 = Math.abs(d4 - d2) / 2.0d;
        double d13 = ((d8 - d10) - d12) / ((d7 - d9) - d11);
        double d14 = d12 - (d11 * d13);
        double d15 = abs2 * abs2;
        double d16 = abs * abs;
        double d17 = d15 + (d16 * d13 * d13);
        double d18 = abs * 2.0d * abs * d14 * d13;
        double d19 = (-(d16 * ((d14 * d14) - d15))) / d17;
        double d20 = d17 * 2.0d;
        double sqrt = ((-d18) / d20) - Math.sqrt(d19 + Math.pow(d18 / d20, 2.0d));
        double d21 = (d13 * sqrt) + d14;
        double d22 = sqrt + d9;
        double d23 = d21 + d10;
        if (Double.isNaN(d22) || Double.isNaN(d23)) {
            return;
        }
        pointF.x = (float) d22;
        pointF.y = (float) d23;
    }

    private boolean toDrawBorderUseSameStyle() {
        BorderStyle[] borderStyleArr = this.mBorderStyle;
        if (borderStyleArr == null) {
            return true;
        }
        BorderStyle borderStyle = borderStyleArr[8];
        BorderStyle borderStyle2 = borderStyleArr[0];
        if (borderStyle2 == null) {
            borderStyle2 = borderStyle;
        }
        BorderStyle borderStyle3 = borderStyleArr[2];
        if (borderStyle3 == null) {
            borderStyle3 = borderStyle;
        }
        if (borderStyle3 != borderStyle2) {
            return false;
        }
        BorderStyle borderStyle4 = borderStyleArr[1];
        if (borderStyle4 == null) {
            borderStyle4 = borderStyle;
        }
        if (borderStyle4 != borderStyle2) {
            return false;
        }
        BorderStyle borderStyle5 = borderStyleArr[3];
        if (borderStyle5 != null) {
            borderStyle = borderStyle5;
        }
        if (borderStyle != borderStyle2) {
            return false;
        }
        return borderStyle2 == null || borderStyle2.isSolidDashedOrDotted();
    }

    private BorderStyle getBorderStyleWithDefaultSolid(int i) {
        BorderStyle borderStyle;
        BorderStyle[] borderStyleArr = this.mBorderStyle;
        if (borderStyleArr == null) {
            borderStyle = null;
        } else {
            borderStyle = borderStyleArr[i];
            if (borderStyle == null) {
                borderStyle = borderStyleArr[8];
            }
        }
        if (borderStyle != null) {
            return borderStyle;
        }
        if (this.mContext.getCssAlignWithLegacyW3c()) {
            return BorderStyle.NONE;
        }
        return BorderStyle.SOLID;
    }

    private void strokeCenterDrawPathMoreLines(Canvas canvas, int i, float f, int i2, int i3, boolean z) {
        this.mPaint.setPathEffect(null);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(f);
        boolean z2 = true;
        if (i != 1 && i != 0) {
            z2 = false;
        }
        this.mPaint.setColor(ColorUtil.multiplyColorAlpha(z2 ? i3 : i2, this.mAlpha));
        RoundRectPath pathFromCache = getPathFromCache(z ? RoundRectPath.Pos.OUTER3 : RoundRectPath.Pos.OUTER2);
        if (pathFromCache != null) {
            pathFromCache.drawToCanvas(canvas, this.mPaint);
        }
        Paint paint = this.mPaint;
        if (!z2) {
            i2 = i3;
        }
        paint.setColor(ColorUtil.multiplyColorAlpha(i2, this.mAlpha));
        RoundRectPath pathFromCache2 = getPathFromCache(z ? RoundRectPath.Pos.INNER3 : RoundRectPath.Pos.INNER2);
        if (pathFromCache2 != null) {
            pathFromCache2.drawToCanvas(canvas, this.mPaint);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x002c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void strokeCenterDrawPath(Canvas canvas, int i, int i2, float f, float f2) {
        BorderStyle borderStyle;
        int i3;
        RoundRectPath pathFromCache;
        BorderStyle[] borderStyleArr = this.mBorderStyle;
        if (borderStyleArr == null) {
            borderStyle = null;
        } else {
            borderStyle = borderStyleArr[i];
            if (borderStyle == null) {
                borderStyle = borderStyleArr[8];
            }
        }
        if (borderStyle == null) {
            if (this.mContext.getCssAlignWithLegacyW3c()) {
                borderStyle = BorderStyle.NONE;
            } else {
                borderStyle = BorderStyle.SOLID;
            }
        }
        this.mPathEffectForBorderStyle = null;
        switch (C01381.$SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[borderStyle.ordinal()]) {
            case 1:
            case 2:
                return;
            case 3:
            case 4:
                this.mPathEffectForBorderStyle = borderStyle.getPathEffect(f);
                i3 = i2;
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setColor(ColorUtil.multiplyColorAlpha(i3, this.mAlpha));
                this.mPaint.setStrokeWidth(f2);
                this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
                this.mPaint.setAntiAlias(true);
                pathFromCache = getPathFromCache(RoundRectPath.Pos.CENTER);
                if (pathFromCache != null) {
                    pathFromCache.drawToCanvas(canvas, this.mPaint);
                }
                this.mPaint.setPathEffect(null);
                return;
            case 5:
            default:
                i3 = i2;
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setColor(ColorUtil.multiplyColorAlpha(i3, this.mAlpha));
                this.mPaint.setStrokeWidth(f2);
                this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
                this.mPaint.setAntiAlias(true);
                pathFromCache = getPathFromCache(RoundRectPath.Pos.CENTER);
                if (pathFromCache != null) {
                }
                this.mPaint.setPathEffect(null);
                return;
            case 6:
                if (i == 1 || i == 0) {
                    i3 = darkenColor(i2);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setColor(ColorUtil.multiplyColorAlpha(i3, this.mAlpha));
                    this.mPaint.setStrokeWidth(f2);
                    this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
                    this.mPaint.setAntiAlias(true);
                    pathFromCache = getPathFromCache(RoundRectPath.Pos.CENTER);
                    if (pathFromCache != null) {
                    }
                    this.mPaint.setPathEffect(null);
                    return;
                }
                i3 = i2;
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setColor(ColorUtil.multiplyColorAlpha(i3, this.mAlpha));
                this.mPaint.setStrokeWidth(f2);
                this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
                this.mPaint.setAntiAlias(true);
                pathFromCache = getPathFromCache(RoundRectPath.Pos.CENTER);
                if (pathFromCache != null) {
                }
                this.mPaint.setPathEffect(null);
                return;
            case 7:
                if (i == 3 || i == 2) {
                    i3 = darkenColor(i2);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setColor(ColorUtil.multiplyColorAlpha(i3, this.mAlpha));
                    this.mPaint.setStrokeWidth(f2);
                    this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
                    this.mPaint.setAntiAlias(true);
                    pathFromCache = getPathFromCache(RoundRectPath.Pos.CENTER);
                    if (pathFromCache != null) {
                    }
                    this.mPaint.setPathEffect(null);
                    return;
                }
                i3 = i2;
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setColor(ColorUtil.multiplyColorAlpha(i3, this.mAlpha));
                this.mPaint.setStrokeWidth(f2);
                this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
                this.mPaint.setAntiAlias(true);
                pathFromCache = getPathFromCache(RoundRectPath.Pos.CENTER);
                if (pathFromCache != null) {
                }
                this.mPaint.setPathEffect(null);
                return;
            case 8:
                strokeCenterDrawPathMoreLines(canvas, i, f / 3.0f, i2, i2, true);
                return;
            case 9:
                strokeCenterDrawPathMoreLines(canvas, i, f / 2.0f, i2, darkenColor(i2), false);
                return;
            case 10:
                strokeCenterDrawPathMoreLines(canvas, i, f / 2.0f, darkenColor(i2), i2, false);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.behavior.ui.utils.BackgroundDrawable$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C01381 {

        /* renamed from: $SwitchMap$com$lynx$tasm$behavior$ui$utils$BackgroundDrawable$RoundRectPath$Pos */
        static final /* synthetic */ int[] f12x468894d3;
        static final /* synthetic */ int[] $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle = iArr;
            try {
                iArr[BorderStyle.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.DASHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.DOTTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.SOLID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.INSET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.OUTSET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.GROOVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.RIDGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[RoundRectPath.Pos.values().length];
            f12x468894d3 = iArr2;
            try {
                iArr2[RoundRectPath.Pos.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12x468894d3[RoundRectPath.Pos.INNER2.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12x468894d3[RoundRectPath.Pos.OUTER2.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f12x468894d3[RoundRectPath.Pos.INNER3.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f12x468894d3[RoundRectPath.Pos.OUTER3.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private int calcBorderMeasureWidth(float f) {
        if (f <= 0.1f || f >= 1.0f) {
            return Math.round(f);
        }
        return 1;
    }

    private boolean hasTransparentBorderColor() {
        return (((Color.alpha(getBorderColor(0)) & Color.alpha(getBorderColor(1))) & Color.alpha(getBorderColor(2))) & Color.alpha(getBorderColor(3))) != 255;
    }

    private boolean isTransparentBorderStyle(BorderStyle borderStyle) {
        return borderStyle == BorderStyle.DASHED || borderStyle == BorderStyle.DOTTED || borderStyle == BorderStyle.HIDDEN;
    }

    private boolean hasTransparentBorderStyle() {
        return isTransparentBorderStyle(getBorderStyle(0)) || isTransparentBorderStyle(getBorderStyle(1)) || isTransparentBorderStyle(getBorderStyle(2)) || isTransparentBorderStyle(getBorderStyle(3));
    }

    private boolean hasTransparentBorder() {
        return hasTransparentBorderColor() || hasTransparentBorderStyle();
    }

    private void drawRectangularBorders(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        int calcBorderMeasureWidth = calcBorderMeasureWidth(directionAwareBorderInsets.left);
        int calcBorderMeasureWidth2 = calcBorderMeasureWidth(directionAwareBorderInsets.top);
        int calcBorderMeasureWidth3 = calcBorderMeasureWidth(directionAwareBorderInsets.right);
        int calcBorderMeasureWidth4 = calcBorderMeasureWidth(directionAwareBorderInsets.bottom);
        if (calcBorderMeasureWidth > 0 || calcBorderMeasureWidth3 > 0 || calcBorderMeasureWidth2 > 0 || calcBorderMeasureWidth4 > 0) {
            Rect bounds = getBounds();
            int borderColor = getBorderColor(0);
            int borderColor2 = getBorderColor(1);
            int borderColor3 = getBorderColor(2);
            int borderColor4 = getBorderColor(3);
            int i18 = bounds.left;
            int i19 = bounds.top;
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStyle(Paint.Style.STROKE);
            int fastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(calcBorderMeasureWidth, calcBorderMeasureWidth2, calcBorderMeasureWidth3, calcBorderMeasureWidth4, borderColor, borderColor2, borderColor3, borderColor4);
            if (fastBorderCompatibleColorOrZero != 0 && toDrawBorderUseSameStyle()) {
                if (Color.alpha(fastBorderCompatibleColorOrZero) != 0) {
                    int i20 = bounds.right;
                    int i21 = bounds.bottom;
                    BorderStyle borderStyleWithDefaultSolid = getBorderStyleWithDefaultSolid(0);
                    if (calcBorderMeasureWidth2 > 0) {
                        float f = calcBorderMeasureWidth2;
                        float f2 = i19 + (f * 0.5f);
                        i17 = calcBorderMeasureWidth2;
                        i15 = i18;
                        i16 = calcBorderMeasureWidth;
                        borderStyleWithDefaultSolid.strokeBorderLine(canvas, this.mPaint, 1, directionAwareBorderInsets.top, fastBorderCompatibleColorOrZero, i15, f2, i20 - (calcBorderMeasureWidth3 > 0 ? calcBorderMeasureWidth3 : 0), f2, i20 - i15, f);
                    } else {
                        i15 = i18;
                        i16 = calcBorderMeasureWidth;
                        i17 = calcBorderMeasureWidth2;
                    }
                    if (calcBorderMeasureWidth3 > 0) {
                        float f3 = calcBorderMeasureWidth3;
                        float f4 = i20 - (f3 * 0.5f);
                        borderStyleWithDefaultSolid.strokeBorderLine(canvas, this.mPaint, 2, directionAwareBorderInsets.right, fastBorderCompatibleColorOrZero, f4, i19, f4, i21 - (calcBorderMeasureWidth4 > 0 ? calcBorderMeasureWidth4 : 0), i21 - i19, f3);
                    }
                    if (calcBorderMeasureWidth4 > 0) {
                        float f5 = calcBorderMeasureWidth4;
                        float f6 = i21 - (f5 * 0.5f);
                        borderStyleWithDefaultSolid.strokeBorderLine(canvas, this.mPaint, 3, directionAwareBorderInsets.bottom, fastBorderCompatibleColorOrZero, i20, f6, (i16 > 0 ? i16 : 0) + i15, f6, i20 - i15, f5);
                    }
                    if (i16 > 0) {
                        float f7 = i16;
                        float f8 = i15 + (0.5f * f7);
                        borderStyleWithDefaultSolid.strokeBorderLine(canvas, this.mPaint, 0, directionAwareBorderInsets.left, fastBorderCompatibleColorOrZero, f8, i21, f8, i19 + (i17 > 0 ? i17 : 0), i21 - i19, f7);
                    }
                }
            } else {
                int width = bounds.width();
                int height = bounds.height();
                if (calcBorderMeasureWidth2 <= 0 || Color.alpha(borderColor2) == 0) {
                    i = i18;
                    i2 = i19;
                    i3 = height;
                    i4 = calcBorderMeasureWidth4;
                    i5 = calcBorderMeasureWidth;
                    i6 = calcBorderMeasureWidth2;
                } else {
                    float f9 = i18;
                    float f10 = i19;
                    float f11 = i18 + calcBorderMeasureWidth;
                    float f12 = i19 + calcBorderMeasureWidth2;
                    float f13 = i18 + width;
                    float f14 = calcBorderMeasureWidth2;
                    float f15 = f10 + (f14 * 0.5f);
                    canvas.save();
                    i = i18;
                    i6 = calcBorderMeasureWidth2;
                    i2 = i19;
                    i3 = height;
                    i5 = calcBorderMeasureWidth;
                    i4 = calcBorderMeasureWidth4;
                    clipQuadrilateral(canvas, f9, f10, f11, f12, r1 - calcBorderMeasureWidth3, f12, f13, f10, false);
                    getBorderStyleWithDefaultSolid(1).strokeBorderLine(canvas, this.mPaint, 1, directionAwareBorderInsets.top, borderColor2, f9, f15, f13, f15, width, f14);
                    canvas.restore();
                }
                if (calcBorderMeasureWidth3 <= 0 || Color.alpha(borderColor3) == 0) {
                    i7 = width;
                    i8 = calcBorderMeasureWidth3;
                    i9 = i3;
                    i10 = i;
                    i11 = i2;
                    i12 = i4;
                } else {
                    int i22 = i;
                    int i23 = i22 + width;
                    float f16 = i23;
                    int i24 = i2;
                    float f17 = i24;
                    float f18 = i24 + i3;
                    float f19 = i23 - calcBorderMeasureWidth3;
                    float f20 = calcBorderMeasureWidth3;
                    float f21 = f16 - (f20 * 0.5f);
                    canvas.save();
                    i12 = i4;
                    i8 = calcBorderMeasureWidth3;
                    i11 = i24;
                    i7 = width;
                    i10 = i22;
                    clipQuadrilateral(canvas, f16, f17, f16, f18, f19, r0 - r5, f19, i24 + i6, false);
                    i9 = i3;
                    getBorderStyleWithDefaultSolid(2).strokeBorderLine(canvas, this.mPaint, 2, directionAwareBorderInsets.right, borderColor3, f21, f17, f21, f18, i9, f20);
                    canvas.restore();
                }
                if (i12 <= 0 || Color.alpha(borderColor4) == 0) {
                    i13 = i12;
                    i14 = i9;
                } else {
                    float f22 = i10;
                    int i25 = i11 + i9;
                    float f23 = i25;
                    float f24 = i10 + i7;
                    float f25 = i25 - i12;
                    float f26 = i12;
                    float f27 = f23 - (f26 * 0.5f);
                    canvas.save();
                    i13 = i12;
                    i14 = i9;
                    clipQuadrilateral(canvas, f22, f23, f24, f23, r0 - i8, f25, i10 + i5, f25, false);
                    getBorderStyleWithDefaultSolid(3).strokeBorderLine(canvas, this.mPaint, 3, directionAwareBorderInsets.bottom, borderColor4, f24, f27, f22, f27, i7, f26);
                    canvas.restore();
                }
                if (i5 > 0 && Color.alpha(borderColor) != 0) {
                    float f28 = i10;
                    float f29 = i11;
                    float f30 = i10 + i5;
                    float f31 = i11 + i14;
                    float f32 = i5;
                    float f33 = f28 + (0.5f * f32);
                    canvas.save();
                    clipQuadrilateral(canvas, f28, f29, f30, i11 + i6, f30, r4 - i13, f28, f31, false);
                    getBorderStyleWithDefaultSolid(0).strokeBorderLine(canvas, this.mPaint, 0, directionAwareBorderInsets.left, borderColor, f33, f31, f33, f29, i14, f32);
                    canvas.restore();
                }
            }
        }
        this.mPaint.setAntiAlias(true);
    }

    private void clipQuadrilateral(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z) {
        if (z) {
            RoundRectPath roundRectPath = this.mOuterClipPathForBorderRadius;
            if (roundRectPath != null) {
                canvas.clipPath(roundRectPath.path, Region.Op.INTERSECT);
            }
            RoundRectPath roundRectPath2 = this.mInnerClipPathForBorderRadius;
            if (roundRectPath2 != null) {
                canvas.clipPath(roundRectPath2.path, Region.Op.DIFFERENCE);
            }
        }
        if (this.mPathForBorder == null) {
            this.mPathForBorder = new Path();
        }
        this.mPathForBorder.reset();
        this.mPathForBorder.moveTo(f, f2);
        this.mPathForBorder.lineTo(f3, f4);
        this.mPathForBorder.lineTo(f5, f6);
        this.mPathForBorder.lineTo(f7, f8);
        this.mPathForBorder.lineTo(f, f2);
        canvas.clipPath(this.mPathForBorder);
    }

    private int getBorderWidth(int i) {
        if (this.mBorderWidth == null) {
            return 0;
        }
        float f = this.mBorderWidth.get(i);
        if (MeasureUtils.isUndefined(f)) {
            return -1;
        }
        return Math.round(f);
    }

    private boolean isBorderColorDefined(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = spacing != null ? spacing.get(i) : 1.0E21f;
        Spacing spacing2 = this.mBorderAlpha;
        return (MeasureUtils.isUndefined(f) || MeasureUtils.isUndefined(spacing2 != null ? spacing2.get(i) : 1.0E21f)) ? false : true;
    }

    private int getBorderColor(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = spacing != null ? spacing.get(i) : 0.0f;
        Spacing spacing2 = this.mBorderAlpha;
        return colorFromAlphaAndRGBComponents(spacing2 != null ? spacing2.get(i) : 255.0f, f);
    }

    public Path getInnerClipPathForBorderRadius() {
        RoundRectPath roundRectPath;
        if (this.mBorderCornerRadii == null || !updatePath() || (roundRectPath = this.mInnerClipPathForBorderRadius) == null) {
            return null;
        }
        return roundRectPath.path;
    }

    public void setBoxShadowInsetDrawer(UIShadowProxy.InsetDrawer insetDrawer) {
        this.mBoxShadowInsetDrawer = insetDrawer;
    }

    public UIShadowProxy.InsetDrawer getBoxShadowInsetDrawer() {
        return this.mBoxShadowInsetDrawer;
    }
}
