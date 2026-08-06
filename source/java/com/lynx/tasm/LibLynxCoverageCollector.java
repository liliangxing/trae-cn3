package com.lynx.tasm;

import android.content.Context;
import java.io.File;

/* loaded from: classes6.dex */
public class LibLynxCoverageCollector {
    private static native void nativeDumpCoverageDataToFile(String str, String str2, boolean z);

    public static String dumpCoverageDataToFile(Context context, String str, boolean z) {
        String path = new File(context.getExternalFilesDir(null), "code_coverage").getPath();
        nativeDumpCoverageDataToFile(path, str, z);
        return new File(path, str).getPath();
    }
}
