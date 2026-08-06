package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;

/* loaded from: classes5.dex */
public class ZipCrcOpt {
    private static native int nOptArt();

    private static native int nOptArtBase();

    private static native int nOptZipArchive();

    public static int optArtBase(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ByteHook.init();
        return nOptArtBase();
    }

    public static int optArt(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ByteHook.init();
        return nOptArt();
    }

    public static int optZipArchive(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ByteHook.init();
        return nOptZipArchive();
    }
}
