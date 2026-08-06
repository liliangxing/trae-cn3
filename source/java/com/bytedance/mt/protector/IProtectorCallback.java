package com.bytedance.mt.protector;

import java.util.Map;

/* loaded from: classes4.dex */
public interface IProtectorCallback {
    public static final int ALOG_TYPE = 2;
    public static final int LOGCAT_TYPE = 1;

    void logd(String str, String str2, int i);

    void loge(String str, String str2, int i);

    void loge(String str, String str2, Throwable th, int i);

    void logi(String str, String str2, int i);

    void onProtected(ProtectorType protectorType, Throwable th);

    void onReachProtector(ProtectorType protectorType, Throwable th);

    void reportCustomException(Throwable th, String str, String str2, Map<String, String> map);
}
