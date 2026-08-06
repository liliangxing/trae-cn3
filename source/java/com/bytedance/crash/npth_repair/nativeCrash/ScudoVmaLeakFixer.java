package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.utils.RepairLog;

/* loaded from: classes3.dex */
public class ScudoVmaLeakFixer {
    private static final String TAG = "ScudoVmaLeakFixer";
    private static boolean doFix;
    private static int fixErrno;

    private static native int nFixScudoVmaLeak();

    public static synchronized int doFixCrash() {
        synchronized (ScudoVmaLeakFixer.class) {
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
                fixErrno = nFixScudoVmaLeak();
            } catch (Throwable unused) {
                fixErrno = -4;
            }
            return fixErrno;
        }
    }

    public static synchronized void unFixCrash() {
        synchronized (ScudoVmaLeakFixer.class) {
        }
    }
}
