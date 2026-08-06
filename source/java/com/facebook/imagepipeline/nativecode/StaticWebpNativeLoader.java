package com.facebook.imagepipeline.nativecode;

import com.facebook.imageutils.FrescoSoLoader;

/* loaded from: classes6.dex */
public class StaticWebpNativeLoader {
    private static boolean sInitialized;

    public static synchronized void ensure() {
        synchronized (StaticWebpNativeLoader.class) {
            if (!sInitialized) {
                FrescoSoLoader.loadLibrary("static-webp");
                sInitialized = true;
            }
        }
    }
}
