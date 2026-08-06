package com.ss.bduploader.util;

import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class CustomVerify {
    public static final int CUSTOM_VERFIY_STATUS_IS_EXCEPTION = -99996;
    public static final int CUSTOM_VERFIY_STATUS_IS_GET_METHOD_EXCEPTION = -99995;
    private static Method getVerifyStatusMethod;
    private static boolean hasInited;
    private static Method verifyMethod;
    private static Class<?> verifyResultClass;

    static {
        try {
            verifyMethod = Class.forName("com.ss.bduploader.util.X509Util").getMethod("verifyServerCertificates", byte[][].class, String.class, String.class);
            Class<?> cls = Class.forName("com.ss.bduploader.util.AndroidCertVerifyResult");
            verifyResultClass = cls;
            getVerifyStatusMethod = cls.getMethod("getStatus", new Class[0]);
            Log.e("custom_verify", "find default verify suc");
        } catch (Exception e) {
            Log.e("custom_verify", "found verify class or method exception:" + e.getMessage());
            Log.e("custom_verify", "find default verify fail");
        }
        hasInited = true;
        if (verifyMethod == null || verifyResultClass == null) {
            return;
        }
        Log.e("custom_verify", "get verify method or verify result class suc");
    }

    public static int doVerify(byte[][] bArr, String str, String str2) {
        if (verifyMethod == null || verifyResultClass == null || getVerifyStatusMethod == null) {
            Log.e("custom_verify", "verify method is null ecception");
            return -99995;
        }
        try {
            Log.e("custom_verify", "host: " + str2 + "  authType: " + str);
            Object invoke = verifyMethod.invoke(null, bArr, str, str2);
            Log.e("custom_verify", "get status end");
            int intValue = ((Integer) getVerifyStatusMethod.invoke(invoke, new Object[0])).intValue();
            Log.e("custom_verify", "verify result status: " + intValue);
            return intValue;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e("custom_verify", "verify exception stacktrace:" + th.getMessage());
            return -99996;
        }
    }
}
