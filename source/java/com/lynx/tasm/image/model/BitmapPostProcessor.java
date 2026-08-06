package com.lynx.tasm.image.model;

import android.graphics.Bitmap;

/* loaded from: classes7.dex */
public interface BitmapPostProcessor {
    String getName();

    String getPostprocessorCacheKey();

    void process(Bitmap bitmap, Bitmap bitmap2);
}
