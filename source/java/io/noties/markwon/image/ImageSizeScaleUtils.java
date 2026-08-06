package io.noties.markwon.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import io.noties.markwon.image.ImageSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ImageSizeScaleUtils.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ&\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u001d\u001a\u00020\b*\u00020\u001eH\u0002¨\u0006\u001f"}, d2 = {"Lio/noties/markwon/image/ImageSizeScaleUtils;", "", "()V", "convertToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "widthPixels", "", "heightPixels", "createRoundedBmp", "oriBmp", "radius", "createScaledBmp", "size", "Landroid/graphics/Rect;", "handleScale", "imageBounds", "canvasWidth", "minWidthHeight", "imageSizeToRect", "imageSize", "Lio/noties/markwon/image/ImageSize;", "textSize", "", "resolveAbsolute", "dimension", "Lio/noties/markwon/image/ImageSize$Dimension;", "original", "dp2px", "", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ImageSizeScaleUtils {
    public static final ImageSizeScaleUtils INSTANCE = new ImageSizeScaleUtils();

    private ImageSizeScaleUtils() {
    }

    public final Rect imageSizeToRect(ImageSize imageSize, Rect imageBounds, int canvasWidth, float textSize) {
        Rect rect;
        int resolveAbsolute;
        Intrinsics.checkNotNullParameter(imageSize, "imageSize");
        Intrinsics.checkNotNullParameter(imageBounds, "imageBounds");
        ImageSize.Dimension dimension = imageSize.width;
        ImageSize.Dimension dimension2 = imageSize.height;
        int width = imageBounds.width();
        int height = imageBounds.height();
        float f = width / height;
        if (dimension != null) {
            if (Intrinsics.areEqual(CustomImageSizeResolverDef.UNIT_PERCENT, dimension.unit)) {
                resolveAbsolute = (int) (canvasWidth * (dimension.value / 100.0f));
            } else {
                resolveAbsolute = resolveAbsolute(dimension, width, textSize);
            }
            rect = new Rect(0, 0, resolveAbsolute, (dimension2 == null || Intrinsics.areEqual(CustomImageSizeResolverDef.UNIT_PERCENT, dimension2.unit)) ? (int) ((resolveAbsolute / f) + 0.5f) : resolveAbsolute(dimension2, height, textSize));
        } else {
            if (dimension2 == null || Intrinsics.areEqual(CustomImageSizeResolverDef.UNIT_PERCENT, dimension2.unit)) {
                return imageBounds;
            }
            int resolveAbsolute2 = resolveAbsolute(dimension2, height, textSize);
            rect = new Rect(0, 0, (int) ((resolveAbsolute2 * f) + 0.5f), resolveAbsolute2);
        }
        return rect;
    }

    public final Rect handleScale(Rect imageBounds, int canvasWidth, int minWidthHeight) {
        Rect rect;
        Intrinsics.checkNotNullParameter(imageBounds, "imageBounds");
        int width = imageBounds.width();
        int height = imageBounds.height();
        if (width > canvasWidth && width > height) {
            rect = new Rect(0, 0, canvasWidth, (int) Math.min(canvasWidth, Math.max((int) ((imageBounds.height() / (width / canvasWidth)) + 0.5f), minWidthHeight)));
        } else if (height > canvasWidth && height > width) {
            rect = new Rect(0, 0, (int) Math.min(canvasWidth, Math.max((int) ((imageBounds.width() / (height / canvasWidth)) + 0.5f), minWidthHeight)), canvasWidth);
        } else if (width < minWidthHeight && width < height) {
            rect = new Rect(0, 0, minWidthHeight, (int) Math.min(canvasWidth, Math.max((int) ((imageBounds.height() / (width / minWidthHeight)) + 0.5f), minWidthHeight)));
        } else {
            if (height >= minWidthHeight || height >= width) {
                return imageBounds;
            }
            rect = new Rect(0, 0, (int) Math.min(canvasWidth, Math.max((int) ((imageBounds.width() / (height / minWidthHeight)) + 0.5f), minWidthHeight)), minWidthHeight);
        }
        return rect;
    }

    public final int resolveAbsolute(ImageSize.Dimension dimension, int original, float textSize) {
        float f;
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        if (Intrinsics.areEqual(CustomImageSizeResolverDef.UNIT_EM, dimension.unit)) {
            f = dimension.value * textSize;
        } else {
            if (Intrinsics.areEqual(CustomImageSizeResolverDef.UNIT_DP, dimension.unit)) {
                return dp2px(Integer.valueOf((int) dimension.value));
            }
            f = dimension.value;
        }
        return (int) f;
    }

    public final Bitmap createScaledBmp(Bitmap oriBmp, Rect size) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(oriBmp, "oriBmp");
        Intrinsics.checkNotNullParameter(size, "size");
        if (oriBmp.getWidth() == size.width() && oriBmp.getHeight() == size.height()) {
            return oriBmp;
        }
        int width = oriBmp.getWidth();
        int height = oriBmp.getHeight();
        int width2 = size.width();
        int height2 = size.height();
        float f = width2 / width;
        float f2 = height2 / height;
        if (f == f2) {
            Bitmap createBitmap = Bitmap.createBitmap(oriBmp);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(oriBmp)");
            return createBitmap;
        }
        Matrix matrix = new Matrix();
        if (f > f2) {
            int roundToInt = MathKt.roundToInt((height2 / width2) * width);
            int roundToInt2 = MathKt.roundToInt((height - roundToInt) / 2.0f);
            matrix.postScale(f, f);
            i2 = roundToInt;
            i = width;
            i3 = roundToInt2;
            i4 = 0;
        } else {
            int roundToInt3 = MathKt.roundToInt((width2 / height2) * height);
            int roundToInt4 = MathKt.roundToInt((width - roundToInt3) / 2.0f);
            matrix.postScale(f2, f2);
            i = roundToInt3;
            i2 = height;
            i3 = 0;
            i4 = roundToInt4;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(oriBmp, i4, i3, i, i2, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap2, "createBitmap(oriBmp, x, …th, height, matrix, true)");
        return createBitmap2;
    }

    public final Bitmap convertToBitmap(Drawable drawable, int widthPixels, int heightPixels) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Bitmap createBitmap = Bitmap.createBitmap(widthPixels, heightPixels, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(widthPixels… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, widthPixels, heightPixels);
        drawable.draw(canvas);
        return createBitmap;
    }

    public final Bitmap createRoundedBmp(Bitmap oriBmp, int radius) {
        Intrinsics.checkNotNullParameter(oriBmp, "oriBmp");
        Bitmap createBitmap = Bitmap.createBitmap(oriBmp.getWidth(), oriBmp.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(oriBmp.widt… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, oriBmp.getWidth(), oriBmp.getHeight());
        RectF rectF = new RectF(rect);
        canvas.drawARGB(0, 0, 0, 0);
        float f = radius;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(oriBmp, rect, rect, paint);
        return createBitmap;
    }

    private final int dp2px(Number number) {
        return (int) ((number.floatValue() * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
