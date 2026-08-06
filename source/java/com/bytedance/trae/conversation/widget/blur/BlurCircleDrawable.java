package com.bytedance.trae.conversation.widget.blur;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: BlurCircleDrawable.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\bH\u0016J\u0012\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\bH\u0017J\b\u0010-\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;", "Landroid/graphics/drawable/Drawable;", "circleColors", "", "blurRadius", "", "radiusWidthRatio", "showHeight", "", "xfermode", "Landroid/graphics/Xfermode;", "gradientRadiusXRatio", "gradientRadiusYRatio", "gradientCenterYRatio", "useMaskFilter", "", "useSoftBlur", "<init>", "([IFFILandroid/graphics/Xfermode;FFFZZ)V", "paint", "Landroid/graphics/Paint;", "circleRadius", "centerX", "centerY", "circleScale", "currentColors", "setCircleColor", "", "colors", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setCircleScale", "scale", "getCircleScale", "softBlurEdgeFraction", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "updateGradientShader", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BlurCircleDrawable extends Drawable {
    private final float blurRadius;
    private float centerX;
    private float centerY;
    private float circleRadius;
    private float circleScale;
    private int[] currentColors;
    private final float gradientCenterYRatio;
    private final float gradientRadiusXRatio;
    private final float gradientRadiusYRatio;
    private final Paint paint;
    private float radiusWidthRatio;
    private final int showHeight;
    private final float softBlurEdgeFraction;
    private final boolean useMaskFilter;
    private final boolean useSoftBlur;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    public /* synthetic */ BlurCircleDrawable(int[] iArr, float f, float f2, int i, Xfermode xfermode, float f3, float f4, float f5, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, (i2 & 2) != 0 ? 60.0f : f, (i2 & 4) != 0 ? 0.923f : f2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : xfermode, (i2 & 32) != 0 ? 0.5892f : f3, (i2 & 64) != 0 ? 0.3747f : f4, (i2 & 128) != 0 ? 0.4553f : f5, (i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? true : z, (i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) == 0 ? z2 : false);
    }

    public BlurCircleDrawable(int[] iArr, float f, float f2, int i, Xfermode xfermode, float f3, float f4, float f5, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(iArr, "circleColors");
        this.blurRadius = f;
        this.radiusWidthRatio = f2;
        this.showHeight = i;
        this.gradientRadiusXRatio = f3;
        this.gradientRadiusYRatio = f4;
        this.gradientCenterYRatio = f5;
        this.useMaskFilter = z;
        this.useSoftBlur = z2;
        Paint paint = new Paint(1);
        this.paint = paint;
        this.circleScale = 1.0f;
        this.currentColors = iArr;
        if (z && !z2) {
            float f6 = f * 1.0f;
            if (f6 > 0.0f) {
                paint.setMaskFilter(new BlurMaskFilter(f6, BlurMaskFilter.Blur.NORMAL));
            } else {
                paint.setMaskFilter(null);
            }
        }
        paint.setXfermode(xfermode);
        this.softBlurEdgeFraction = 0.1f;
    }

    public final void setCircleColor(int[] colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.currentColors = colors;
        updateGradientShader();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.circleRadius = bounds.width() * this.radiusWidthRatio;
        this.centerX = bounds.left + (bounds.width() / 2.0f);
        float f = bounds.bottom - this.showHeight;
        float f2 = this.circleRadius;
        this.centerY = f + f2;
        this.circleRadius = f2 * this.circleScale;
        updateGradientShader();
    }

    public final void setCircleScale(float scale) {
        this.circleScale = scale;
        float width = getBounds().width() * this.radiusWidthRatio;
        float f = this.circleScale;
        this.circleRadius = width * f;
        if (this.useMaskFilter && !this.useSoftBlur) {
            float f2 = this.blurRadius * f;
            if (f2 > 0.0f) {
                this.paint.setMaskFilter(new BlurMaskFilter(f2, BlurMaskFilter.Blur.NORMAL));
            } else {
                this.paint.setMaskFilter(null);
            }
        }
        updateGradientShader();
        invalidateSelf();
    }

    public final float getCircleScale() {
        return this.circleScale;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.useSoftBlur) {
            canvas.drawCircle(this.centerX, this.centerY, this.circleRadius + (this.blurRadius * this.circleScale * this.softBlurEdgeFraction), this.paint);
        } else {
            canvas.drawCircle(this.centerX, this.centerY, this.circleRadius, this.paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    private final void updateGradientShader() {
        int[] iArr;
        float[] fArr;
        if (this.circleRadius <= 0.0f) {
            return;
        }
        if (this.useSoftBlur) {
            int[] iArr2 = this.currentColors;
            if (iArr2.length < 2) {
                iArr2 = new int[]{ArraysKt.first(iArr2), ArraysKt.first(this.currentColors)};
            }
            float f = this.circleRadius;
            float f2 = (this.blurRadius * this.circleScale * this.softBlurEdgeFraction) + f;
            float f3 = f2 > 0.0f ? f / f2 : 1.0f;
            iArr = new int[iArr2.length + 1];
            fArr = new float[iArr2.length + 1];
            int length = iArr2.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = iArr2[i];
                fArr[i] = (i * f3) / RangesKt.coerceAtLeast(iArr2.length - 1, 1);
            }
            int last = ArraysKt.last(iArr2);
            iArr[iArr2.length] = Color.argb(0, Color.red(last), Color.green(last), Color.blue(last));
            fArr[iArr2.length] = 1.0f;
        } else {
            int[] iArr3 = this.currentColors;
            iArr = iArr3.length < 2 ? new int[]{ArraysKt.first(iArr3), ArraysKt.first(this.currentColors)} : iArr3;
            fArr = null;
        }
        int[] iArr4 = iArr;
        float[] fArr2 = fArr;
        float f4 = this.centerX;
        float f5 = this.centerY;
        float f6 = this.circleRadius;
        float f7 = 2;
        float f8 = (f5 - f6) + (f6 * f7 * this.gradientCenterYRatio);
        float max = Math.max(f6 * f7 * this.gradientRadiusXRatio, f6 * f7 * this.gradientRadiusYRatio);
        if (this.useSoftBlur) {
            max += this.blurRadius * this.circleScale * this.softBlurEdgeFraction;
        }
        float f9 = max;
        if (f9 <= 0.0f) {
            return;
        }
        this.paint.setShader(new RadialGradient(f4, f8, f9, iArr4, fArr2, Shader.TileMode.CLAMP));
    }
}
