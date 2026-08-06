package com.bytedance.platform.thread;

/* loaded from: classes4.dex */
public class PlatformThread {
    public static Thread newThread(String str) {
        return new Thread(str);
    }

    public static Thread newThread(Runnable runnable, String str) {
        return new Thread(runnable, str);
    }

    public static Thread newThread(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }

    public static Thread newThread(String str, String str2) {
        return new Thread(makeThreadName(str, str2));
    }

    public static Thread newThread(ThreadGroup threadGroup, String str, String str2) {
        return new Thread(threadGroup, makeThreadName(str, str2));
    }

    public static Thread newThread(Runnable runnable, String str, String str2) {
        return new Thread(runnable, makeThreadName(str, str2));
    }

    public static Thread newThread(ThreadGroup threadGroup, Runnable runnable, String str, String str2) {
        return new Thread(threadGroup, runnable, makeThreadName(str, str2));
    }

    public static Thread newThread(ThreadGroup threadGroup, Runnable runnable, String str, long j, String str2) {
        return new Thread(threadGroup, runnable, makeThreadName(str, str2), j);
    }

    public static String makeThreadName(String str, String str2) {
        return str == null ? str2 : str.startsWith(str2) ? str : str2 + "#" + str;
    }
}
