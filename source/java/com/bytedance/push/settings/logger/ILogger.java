package com.bytedance.push.settings.logger;

/* loaded from: classes4.dex */
public interface ILogger {
    void d(String str);

    void d(String str, String str2);

    void e(String str);

    void e(String str, String str2);

    void i(String str);

    void i(String str, String str2);

    void i(String str, String str2, Throwable th);

    void v(String str, String str2);

    void w(String str, String str2);
}
