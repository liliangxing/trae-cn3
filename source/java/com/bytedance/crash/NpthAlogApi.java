package com.bytedance.crash;

import java.util.List;

/* loaded from: classes3.dex */
public class NpthAlogApi {
    private static Runnable sAlogFlushRunnable;
    private static AlogGetFilesInterface sAlogGetFilesImpl;
    private static AlogInitInterface sAlogInitImpl;

    /* loaded from: classes3.dex */
    interface AlogGetFilesInterface {
        List<String> getFiles(long j, String str);
    }

    /* loaded from: classes3.dex */
    interface AlogInitInterface {
        boolean isInited();
    }

    static void setAlogFlushImpl(Runnable runnable) {
        sAlogFlushRunnable = runnable;
    }

    public static boolean sAlogFlushInit() {
        return sAlogFlushRunnable != null;
    }

    public static void flushAlogSync() {
        Runnable runnable = sAlogFlushRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    static void setAlogGetFilesImpl(AlogGetFilesInterface alogGetFilesInterface) {
        sAlogGetFilesImpl = alogGetFilesInterface;
    }

    static void setAlogInitImpl(AlogInitInterface alogInitInterface) {
        sAlogInitImpl = alogInitInterface;
    }

    public static boolean getAlogFilesInit() {
        return sAlogGetFilesImpl != null;
    }

    public static boolean isAlogInit() {
        AlogInitInterface alogInitInterface = sAlogInitImpl;
        return alogInitInterface != null && alogInitInterface.isInited();
    }

    public static List<String> getAlogFiles(long j, String str) {
        AlogGetFilesInterface alogGetFilesInterface = sAlogGetFilesImpl;
        if (alogGetFilesInterface == null) {
            return null;
        }
        return alogGetFilesInterface.getFiles(j, str);
    }
}
