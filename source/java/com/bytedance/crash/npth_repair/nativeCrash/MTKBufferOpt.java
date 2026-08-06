package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;

/* loaded from: classes3.dex */
public class MTKBufferOpt {
    private static final String TAG = "RenderD128Opt";
    protected static boolean doFix;
    protected static int fixErrno;

    private static native int nOptMTKBuffer(int i);

    public static synchronized int doOpt(int i) {
        synchronized (MTKBufferOpt.class) {
            if (!NpthRepair.isInited()) {
                return -1;
            }
            if (doFix) {
                return -2;
            }
            doFix = true;
            try {
                fixErrno = nOptMTKBuffer(i);
            } catch (Throwable unused) {
                fixErrno = -4;
            }
            return fixErrno;
        }
    }
}
