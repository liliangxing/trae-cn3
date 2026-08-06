package com.bytedance.reparo.core.log;

import com.bytedance.reparo.core.PatchLogger;

/* loaded from: classes4.dex */
public class TLog {
    public static final String TAG = "hotfix";

    public static void w(String str, Throwable th) {
        PatchLogger.w(TAG, str, th);
    }

    public static void e(String str, Throwable th) {
        PatchLogger.e(TAG, str, th);
    }

    public static void d(String str) {
        PatchLogger.d(TAG, str);
    }

    public static void w(String str) {
        PatchLogger.w(TAG, str);
    }

    public static void i(String str) {
        PatchLogger.i(TAG, str);
    }

    public static void e(String str) {
        PatchLogger.e(TAG, str);
    }
}
