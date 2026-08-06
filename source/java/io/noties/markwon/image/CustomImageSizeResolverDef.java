package io.noties.markwon.image;

import android.graphics.Rect;
import io.noties.markwon.image.ImageSize;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CustomImageSizeResolverDef extends ImageSizeResolver {
    public static final String UNIT_DP = "dp";
    public static final String UNIT_EM = "em";
    public static final String UNIT_PERCENT = "%";
    private int contentMaxWidth;
    private Rect defaultSize;
    private int minWidthHeight;

    public CustomImageSizeResolverDef(Rect rect, int i, int i2) {
        this.defaultSize = rect;
        this.contentMaxWidth = i;
        this.minWidthHeight = i2;
    }

    @Override // io.noties.markwon.image.ImageSizeResolver
    public Rect resolveImageSize(AsyncDrawable asyncDrawable) {
        int offsetX = asyncDrawable instanceof CustomAsyncDrawable ? ((CustomAsyncDrawable) asyncDrawable).getOffsetX() : 0;
        if (this.defaultSize != null && asyncDrawable.getImageSize() == null) {
            return resolveImageSizeWithDefaultSize(offsetX, this.defaultSize);
        }
        return resolveImageSize(asyncDrawable.getImageSize(), asyncDrawable.getResult().getBounds(), Math.max(this.contentMaxWidth, asyncDrawable.getLastKnownCanvasWidth()) - offsetX, asyncDrawable.getLastKnowTextSize());
    }

    private Rect resolveImageSizeWithDefaultSize(int i, Rect rect) {
        return i > 0 ? new Rect(rect.left, rect.top, rect.right - i, rect.bottom - ((rect.height() * i) / rect.width())) : rect;
    }

    protected Rect resolveImageSize(ImageSize imageSize, Rect rect, int i, float f) {
        Rect rect2;
        int resolveAbsolute;
        if (imageSize == null) {
            return ImageSizeScaleUtils.INSTANCE.handleScale(rect, i, this.minWidthHeight);
        }
        ImageSize.Dimension dimension = imageSize.width;
        ImageSize.Dimension dimension2 = imageSize.height;
        int width = rect.width();
        int height = rect.height();
        float f2 = width / height;
        if (dimension != null) {
            if (UNIT_PERCENT.equals(dimension.unit)) {
                resolveAbsolute = (int) (i * (dimension.value / 100.0f));
            } else {
                resolveAbsolute = ImageSizeScaleUtils.INSTANCE.resolveAbsolute(dimension, width, f);
            }
            rect2 = new Rect(0, 0, resolveAbsolute, (dimension2 == null || UNIT_PERCENT.equals(dimension2.unit)) ? (int) ((resolveAbsolute / f2) + 0.5f) : ImageSizeScaleUtils.INSTANCE.resolveAbsolute(dimension2, height, f));
        } else {
            if (dimension2 != null && !UNIT_PERCENT.equals(dimension2.unit)) {
                int resolveAbsolute2 = ImageSizeScaleUtils.INSTANCE.resolveAbsolute(dimension2, height, f);
                rect2 = new Rect(0, 0, (int) ((resolveAbsolute2 * f2) + 0.5f), resolveAbsolute2);
            }
            return ImageSizeScaleUtils.INSTANCE.handleScale(rect, i, this.minWidthHeight);
        }
        rect = rect2;
        return ImageSizeScaleUtils.INSTANCE.handleScale(rect, i, this.minWidthHeight);
    }
}
