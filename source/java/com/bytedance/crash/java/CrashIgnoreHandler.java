package com.bytedance.crash.java;

/* loaded from: classes3.dex */
public abstract class CrashIgnoreHandler {
    public static final int DEFAULT = 0;
    public static final int IGNORE = 1;
    public static final int NO_UPLOAD = 2;

    public abstract void afterIgnore(Throwable th, Thread thread);

    public abstract int shouldIgnore(Throwable th, Thread thread);
}
