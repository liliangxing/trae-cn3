package com.bytedance.mt.protector;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LogUtils {
    static final int LOG_TYPES = 1;
    static final String TAG = "SafeProtector";

    public static void dWithTag(String str, String str2) {
        Protector.getCallback().logd(TAG, String.format("%s %s", str, str2), 1);
    }

    /* renamed from: d */
    public static void m112d(String str) {
        Protector.getCallback().logd(TAG, str, 1);
    }

    /* renamed from: i */
    public static void m114i(String str) {
        Protector.getCallback().logi(TAG, str, 1);
    }

    public static void iWithTag(String str, String str2) {
        Protector.getCallback().logi(TAG, String.format("%s %s", str, str2), 1);
    }

    public static void eWithTag(String str, String str2) {
        Protector.getCallback().loge(TAG, String.format("%s %s", str, str2), 1);
    }

    /* renamed from: e */
    public static void m113e(String str, Throwable th) {
        Protector.getCallback().loge(TAG, str, th, 1);
    }
}
