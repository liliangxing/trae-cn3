package com.bytedance.sysoptimizer.tools;

import android.content.Context;
import android.util.Log;
import com.bytedance.sysoptimizer.SysOptimizer;

/* loaded from: classes5.dex */
public class PGODumpFileUtil {
    private static final String TAG = "PGODumpFileUtil";

    private static native int dump_pgo_profile(String str, String str2);

    public static synchronized int dumpPGOProfile(Context context, String str, String str2) {
        synchronized (PGODumpFileUtil.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    try {
                        return dump_pgo_profile(str, str2);
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(TAG, "UnsatisfiedLinkError", e);
                    }
                } catch (NoSuchMethodError e2) {
                    Log.e(TAG, "NoSuchMethodError", e2);
                }
            }
            return -1;
        }
    }
}
