package com.facebook.net;

import android.net.Uri;

/* loaded from: classes6.dex */
public abstract class ImageBlurhashStrategy {
    public static ImageBlurhashStrategy DEFAULT;
    private static ImageBlurhashStrategy sStrategy;

    public abstract boolean isUseBlurhash(Uri uri, long j);

    static {
        ImageBlurhashStrategy imageBlurhashStrategy = new ImageBlurhashStrategy() { // from class: com.facebook.net.ImageBlurhashStrategy.1
            @Override // com.facebook.net.ImageBlurhashStrategy
            public boolean isUseBlurhash(Uri uri, long j) {
                return true;
            }
        };
        DEFAULT = imageBlurhashStrategy;
        sStrategy = imageBlurhashStrategy;
    }

    public static ImageBlurhashStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageBlurhashStrategy imageBlurhashStrategy) {
        sStrategy = imageBlurhashStrategy;
    }
}
