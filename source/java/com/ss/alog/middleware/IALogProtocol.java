package com.ss.alog.middleware;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes7.dex */
public interface IALogProtocol {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    void bundle(int i, String str, Bundle bundle);

    void changeLevel(int i);

    void d(String str, String str2);

    void destroy();

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void e(String str, Throwable th);

    void flush();

    void forceLogSharding();

    void header(int i, String str, String str2);

    void i(String str, String str2);

    void init();

    @Deprecated
    void init(String str);

    void intent(int i, String str, Intent intent);

    boolean isBlackTag(String str);

    boolean isLoggable(int i);

    void json(int i, String str, String str2);

    void release();

    void statcktrace(int i, String str, StackTraceElement[] stackTraceElementArr);

    void thread(int i, String str, Thread thread);

    void throwable(int i, String str, Throwable th);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);

    void w(String str, Throwable th);
}
