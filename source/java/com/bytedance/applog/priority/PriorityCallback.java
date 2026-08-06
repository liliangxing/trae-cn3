package com.bytedance.applog.priority;

/* loaded from: classes3.dex */
public interface PriorityCallback {
    PriorityHttpResponse doHttpPost(String str, byte[] bArr);

    String getHeaderJson();

    boolean isMonitorEnabled();

    boolean isNetworkAvailable();

    boolean isStageEnabled();

    void monitorError(String str, String str2);

    void monitorIncreaseStats(String str, int i);

    void monitorStage(String str, String str2, int i, int i2, String str3, String str4, long j);

    void printLog(int i, String str);
}
