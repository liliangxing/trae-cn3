package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class JavaFrameInfoOpt {
    private static final String TAG = "JavaFrameInfoOpt";
    private static volatile boolean sInit;

    private static native int nStart(ExceptionInfo[] exceptionInfoArr, boolean z, boolean z2, boolean z3, int i);

    public static int start(Context context, ExceptionInfo[] exceptionInfoArr, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        if (!Process.is64Bit()) {
            System.out.println("JavaFrameInfoOpt only support 64 bits");
            return 0;
        }
        if (sInit) {
            return 1;
        }
        if (!SysOptimizer.loadOptimizerLibrary(context) || sInit) {
            return -1;
        }
        ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
        int nStart = nStart(exceptionInfoArr, z, z2, z3, i);
        sInit = true;
        mockCrash(z4);
        return nStart;
    }

    private static void mockCrash(boolean z) {
        if (z) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sysoptimizer.JavaFrameInfoOpt.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        testGetMethodParams(true, (byte) 17, 'a', (short) 52, 4369, 286331153L, 0.11f, 0.11d, "aa", new Object());
                        testGetMethodParams(false, (byte) 34, 'b', (short) 67, 8738, 572662306L, 0.22f, 0.22d, "bb", new Object());
                        testGetMethodParams(true, (byte) 51, 'c', (short) 34, 13107, 858993459L, 0.33f, 0.33d, "cc", null);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                private void testGetMethodParams(boolean z2, byte b, char c, short s, int i, long j, float f, double d, String str, Object obj) {
                    Log.d(JavaFrameInfoOpt.TAG, "testGetMethodParams() called with: b = [" + z2 + "], b1 = [" + ((int) b) + "], a = [" + c + "], i = [" + ((int) s) + "], i1 = [" + i + "], l = [" + j + "], v = [" + f + "], v1 = [" + d + "], hi = [" + str + "], o = [" + obj + "]");
                    obj.hashCode();
                }
            }, 1000L);
        }
    }

    /* loaded from: classes5.dex */
    public static class ExceptionInfo {
        public String msg;
        public String type;

        public ExceptionInfo(String str, String str2) {
            this.type = str;
            this.msg = str2;
        }
    }
}
