package io.noties.markwon.ext.onetex;

import android.graphics.Rect;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.ImageSizeResolver;

/* loaded from: classes7.dex */
public class LatexInlineImageSizeResolver extends ImageSizeResolver {
    private final boolean fitCanvas;

    public LatexInlineImageSizeResolver(boolean z) {
        this.fitCanvas = z;
    }

    @Override // io.noties.markwon.image.ImageSizeResolver
    public Rect resolveImageSize(AsyncDrawable asyncDrawable) {
        Rect bounds = asyncDrawable.getResult().getBounds();
        int lastKnownCanvasWidth = asyncDrawable.getLastKnownCanvasWidth();
        int width = bounds.width();
        if (!this.fitCanvas || width <= lastKnownCanvasWidth) {
            return bounds;
        }
        return new Rect(0, 0, lastKnownCanvasWidth, (int) ((lastKnownCanvasWidth / (width / bounds.height())) + 0.5f));
    }
}
