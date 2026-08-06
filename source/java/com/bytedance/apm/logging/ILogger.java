package com.bytedance.apm.logging;

/* loaded from: classes3.dex */
public interface ILogger {
    void d(String str, String... strArr);

    void e(String str, String... strArr);

    void i(String str, String... strArr);

    void printErrStackTrace(String str, Throwable th, String... strArr);

    void v(String str, String... strArr);

    void w(String str, String... strArr);
}
