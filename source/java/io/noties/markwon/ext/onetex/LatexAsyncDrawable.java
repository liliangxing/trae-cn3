package io.noties.markwon.ext.onetex;

import com.edu.onetex.latex.icon.LaTeXIcon;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.ImageSize;
import io.noties.markwon.image.ImageSizeResolver;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LatexAsyncDrawable extends AsyncDrawable {
    private final boolean isBlock;
    public Integer order;
    LaTeXIcon texIcon;
    public Integer textColor;
    public Float textSize;

    public LatexAsyncDrawable(String str, AsyncDrawableLoader asyncDrawableLoader, ImageSizeResolver imageSizeResolver, ImageSize imageSize, boolean z) {
        super(str, asyncDrawableLoader, imageSizeResolver, imageSize);
        this.isBlock = z;
    }

    public boolean isBlock() {
        return this.isBlock;
    }
}
