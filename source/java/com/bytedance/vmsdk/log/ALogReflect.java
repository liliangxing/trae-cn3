package com.bytedance.vmsdk.log;

import android.util.Log;

/* loaded from: classes6.dex */
public class ALogReflect {
    public static long getALogNativeAddress() {
        try {
            return ((Long) Class.forName("com.ss.android.agilelogger.ALog").getMethod("getALogSimpleWriteFuncAddr", new Class[0]).invoke(null, new Object[0])).longValue();
        } catch (Exception e) {
            Log.e("vmsdk", "No ALog found in the host [ " + e.getMessage() + " ]");
            return 0L;
        }
    }
}
