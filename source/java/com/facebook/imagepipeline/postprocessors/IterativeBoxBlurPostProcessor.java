package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class IterativeBoxBlurPostProcessor extends BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private final int mBlurRadius;
    private CacheKey mCacheKey;
    private final int mIterations;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "IterativeBoxBlurPostProcessor";
    }

    public IterativeBoxBlurPostProcessor(int i) {
        this(3, i);
    }

    public IterativeBoxBlurPostProcessor(int i, int i2) {
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        this.mIterations = i;
        this.mBlurRadius = i2;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        NativeBlurFilter.iterativeBoxBlur(bitmap, this.mIterations, this.mBlurRadius);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new SimpleCacheKey(String.format(null, "i%dr%d", Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)));
        }
        return this.mCacheKey;
    }
}
