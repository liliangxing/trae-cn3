package com.bytedance.monitor.collector;

import android.system.Os;
import android.system.OsConstants;

/* loaded from: classes4.dex */
public class Sysconf {
    protected static final long DEFAULT_CLOCK_TICKS_PER_SECOND = 100;
    private static long sJiffyMills = -1;
    private static long sValue = -1;

    public static long getJiffyMills() {
        if (sJiffyMills == -1) {
            sJiffyMills = 1000 / getScClkTck();
        }
        return sJiffyMills;
    }

    public static long getScClkTck() {
        return getScClkTck(100L);
    }

    public static long getScClkTck(long j) {
        long j2 = sValue;
        if (j2 > 0) {
            return j2;
        }
        long sysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (sysconf > 0) {
            j = sysconf;
        }
        sValue = j;
        return j;
    }

    private static long fromLibcore(String str, long j) {
        try {
            int i = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
            Class<?> cls = Class.forName("libcore.io.Libcore");
            Class<?> cls2 = Class.forName("libcore.io.Os");
            return ((Long) cls2.getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i))).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return j;
        }
    }
}
