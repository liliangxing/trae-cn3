package com.bytedance.news.common.settings.api;

/* loaded from: classes4.dex */
public interface SettingsReportingService {
    void d(String str, String str2);

    boolean debug();

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void e(String str, Throwable th);

    void i(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);

    void w(String str, Throwable th);
}
