package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;

/* loaded from: classes6.dex */
public abstract class ImageResizeOptionStrategy {
    private static ImageResizeOptionStrategy sStrategy;

    public abstract ResizeOptions getResizeConfig(Uri uri, int i, int i2, int i3, int i4, boolean z, ImageFormat imageFormat);

    public static ImageResizeOptionStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageResizeOptionStrategy imageResizeOptionStrategy) {
        sStrategy = imageResizeOptionStrategy;
    }
}
