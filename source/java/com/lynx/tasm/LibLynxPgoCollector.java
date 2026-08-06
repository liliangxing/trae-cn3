package com.lynx.tasm;

import android.content.Context;
import java.io.File;

/* loaded from: classes6.dex */
public class LibLynxPgoCollector {
    private static native void nativeDumpSampleProfileToFile(String str, String str2, boolean z);

    public static void dumpSampleProfileToFile(Context context, String str, boolean z) {
        nativeDumpSampleProfileToFile(new File(context.getExternalFilesDir(null), "dancecc_pgo_profiles").getPath(), str, z);
    }
}
