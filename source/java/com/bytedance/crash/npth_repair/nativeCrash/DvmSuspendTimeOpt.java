package com.bytedance.crash.npth_repair.nativeCrash;

import android.util.Log;
import com.bytedance.crash.npth_repair.NpthRepair;

/* loaded from: classes3.dex */
public class DvmSuspendTimeOpt {
    private static final String TAG = "DvmSuspendTimeOpt";
    protected static boolean doFix;
    protected static int fixErrno;

    private static native int nSuspendTimeOpt();

    public static synchronized int doFixCrash() {
        synchronized (DvmSuspendTimeOpt.class) {
            if (!NpthRepair.isInited()) {
                Log.d(TAG, "not init yet, please make sure invoke NpthRepair.init first");
                return -1;
            }
            if (doFix) {
                Log.d(TAG, "has fixed");
                return -2;
            }
            doFix = true;
            try {
                fixErrno = nSuspendTimeOpt();
            } catch (Throwable th) {
                th.printStackTrace();
                fixErrno = -4;
            }
            return fixErrno;
        }
    }

    public static synchronized void unFixCrash() {
        synchronized (DvmSuspendTimeOpt.class) {
        }
    }
}
