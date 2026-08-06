package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.util.Pair;

/* loaded from: classes6.dex */
public abstract class ImageRequestDiskCacheStrategy {
    private static ImageRequestDiskCacheStrategy sStrategy;

    public abstract Pair<Integer, String> getCustomDiskCache(Uri uri, int i, String str);

    public static ImageRequestDiskCacheStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageRequestDiskCacheStrategy imageRequestDiskCacheStrategy) {
        sStrategy = imageRequestDiskCacheStrategy;
    }
}
