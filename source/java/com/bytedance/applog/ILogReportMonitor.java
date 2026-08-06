package com.bytedance.applog;

/* loaded from: classes3.dex */
public interface ILogReportMonitor {
    void onDbError(String str, String str2);

    void onRequestFailed(String str, String str2);
}
