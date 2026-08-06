package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.utils.RepairLog;

/* loaded from: classes3.dex */
public class ArtDumpNativeStackFixer {
    private static final String TAG = "ArtDumpNativeStackFixer";
    private static boolean doFix;
    private static int fixErrno;

    private static native int nStartFixDumpNativeStack();

    private static native void nStopFixDumpNativeStack();

    public static synchronized int doFixCrash() {
        synchronized (ArtDumpNativeStackFixer.class) {
            if (!NpthRepair.isInited()) {
                RepairLog.d(TAG, "not init yet, please make sure invoke NpthRepair.init first");
                return -1;
            }
            if (doFix) {
                RepairLog.d(TAG, "has fixed");
                return -2;
            }
            doFix = true;
            try {
                fixErrno = nStartFixDumpNativeStack();
            } catch (Throwable unused) {
                fixErrno = -4;
            }
            return fixErrno;
        }
    }

    public static synchronized void stopFixCrash() {
        synchronized (ArtDumpNativeStackFixer.class) {
            if (!NpthRepair.isInited()) {
                RepairLog.d(TAG, "not init yet, please make sure invoke NpthRepair.init first");
                return;
            }
            if (doFix && fixErrno == 0) {
                doFix = false;
                nStopFixDumpNativeStack();
            }
        }
    }
}
