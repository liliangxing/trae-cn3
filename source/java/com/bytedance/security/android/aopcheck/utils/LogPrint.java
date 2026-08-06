package com.bytedance.security.android.aopcheck.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.agilelogger.ALog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class LogPrint {
    public static String TAG = "SecurityAOPCheck";

    /* renamed from: e */
    public static final void m178e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.e(TAG, str);
    }

    /* renamed from: i */
    public static final void m179i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.i(TAG, str);
    }

    /* renamed from: d */
    public static final void m177d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.d(TAG, str);
    }

    /* renamed from: w */
    public static final void m180w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.w(TAG, str);
    }

    public static void printStackTrace(Throwable th) {
        ALog.e(TAG, Log.getStackTraceString(th));
    }

    public static void printInterfaces(Object obj) {
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            try {
                ALog.i(TAG, obj.getClass().getName() + ":interface " + i + ":" + interfaces[i].getName());
            } catch (Throwable th) {
                printStackTrace(th);
                return;
            }
        }
    }
}
