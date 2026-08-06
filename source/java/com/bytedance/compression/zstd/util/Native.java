package com.bytedance.compression.zstd.util;

/* loaded from: classes3.dex */
public class Native {
    private static final String LIB_NAME = "bdzstd";
    private static boolean loaded;

    public static synchronized void load() {
        synchronized (Native.class) {
            if (loaded) {
                return;
            }
            System.loadLibrary(LIB_NAME);
            loaded = true;
        }
    }
}
