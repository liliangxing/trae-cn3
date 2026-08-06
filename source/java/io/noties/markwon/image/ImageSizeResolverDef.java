package io.noties.markwon.image;

import android.graphics.Rect;
import io.noties.markwon.image.ImageSize;

/* loaded from: classes6.dex */
public class ImageSizeResolverDef extends ImageSizeResolver {
    protected static final String UNIT_EM = "em";
    protected static final String UNIT_PERCENT = "%";

    @Override // io.noties.markwon.image.ImageSizeResolver
    public Rect resolveImageSize(AsyncDrawable asyncDrawable) {
        return resolveImageSize(asyncDrawable.getImageSize(), asyncDrawable.getResult().getBounds(), asyncDrawable.getLastKnownCanvasWidth(), asyncDrawable.getLastKnowTextSize());
    }

    protected Rect resolveImageSize(ImageSize imageSize, Rect rect, int i, float f) {
        Rect rect2;
        int resolveAbsolute;
        if (imageSize == null) {
            int width = rect.width();
            if (width > i) {
                return new Rect(0, 0, i, (int) ((rect.height() / (width / i)) + 0.5f));
            }
            return rect;
        }
        ImageSize.Dimension dimension = imageSize.width;
        ImageSize.Dimension dimension2 = imageSize.height;
        int width2 = rect.width();
        int height = rect.height();
        float f2 = width2 / height;
        if (dimension != null) {
            if ("%".equals(dimension.unit)) {
                resolveAbsolute = (int) ((i * (dimension.value / 100.0f)) + 0.5f);
            } else {
                resolveAbsolute = resolveAbsolute(dimension, width2, f);
            }
            rect2 = new Rect(0, 0, resolveAbsolute, (dimension2 == null || "%".equals(dimension2.unit)) ? (int) ((resolveAbsolute / f2) + 0.5f) : resolveAbsolute(dimension2, height, f));
        } else {
            if (dimension2 == null || "%".equals(dimension2.unit)) {
                return rect;
            }
            int resolveAbsolute2 = resolveAbsolute(dimension2, height, f);
            rect2 = new Rect(0, 0, (int) ((resolveAbsolute2 * f2) + 0.5f), resolveAbsolute2);
        }
        return rect2;
    }

    protected int resolveAbsolute(ImageSize.Dimension dimension, int i, float f) {
        float f2;
        if ("em".equals(dimension.unit)) {
            f2 = dimension.value * f;
        } else {
            f2 = dimension.value;
        }
        return (int) (f2 + 0.5f);
    }
}
