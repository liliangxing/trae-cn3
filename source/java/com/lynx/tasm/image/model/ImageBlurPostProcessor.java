package com.lynx.tasm.image.model;

import android.graphics.Bitmap;
import com.lynx.tasm.utils.BlurUtils;

/* loaded from: classes7.dex */
public class ImageBlurPostProcessor implements BitmapPostProcessor {
    private final int mBlurRadius;
    private String mCacheKey;

    public ImageBlurPostProcessor(int i) {
        this.mBlurRadius = i;
    }

    @Override // com.lynx.tasm.image.model.BitmapPostProcessor
    public void process(Bitmap bitmap, Bitmap bitmap2) {
        BlurUtils.iterativeBoxBlur(bitmap2, this.mBlurRadius);
    }

    @Override // com.lynx.tasm.image.model.BitmapPostProcessor
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override // com.lynx.tasm.image.model.BitmapPostProcessor
    public String getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = String.valueOf(this.mBlurRadius);
        }
        return this.mCacheKey;
    }
}
