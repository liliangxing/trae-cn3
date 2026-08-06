package com.bytedance.android.alog;

import com.ss.android.agilelogger.ALog;
import java.io.File;
import java.util.HashMap;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class Log {
    private static Alog instance;

    public static void setInstance(Alog alog) {
        instance = alog;
        Alog.nativeSetDefaultInstance(alog == null ? 0L : alog.getNativeRef());
    }

    public static Alog getInstance() {
        return instance;
    }

    public static void close() {
        Alog.nativeSetDefaultInstance(0L);
        instance.close();
        instance = null;
    }

    public static void asyncFlush() {
        Alog alog = instance;
        if (alog != null) {
            alog.asyncFlush();
        }
    }

    public static void syncFlush() {
        Alog alog = instance;
        if (alog != null) {
            alog.syncFlush();
        }
    }

    public static void timedSyncFlush(int i) {
        Alog alog = instance;
        if (alog != null) {
            alog.timedSyncFlush(i);
        }
    }

    public static void setLevel(int i) {
        Alog alog = instance;
        if (alog != null) {
            alog.setLevel(i);
        }
    }

    public static void setSyslog(boolean z) {
        Alog alog = instance;
        if (alog != null) {
            alog.setSyslog(z);
        }
    }

    public static File[] getLogs(long j, long j2) {
        Alog alog = instance;
        return alog != null ? alog.getLogs(j, j2) : new File[0];
    }

    public static File[] getLogs(String str, String str2, long j, long j2) {
        Alog alog = instance;
        return alog != null ? alog.getLogs(str, str2, j, j2) : new File[0];
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        Alog alog = instance;
        if (alog != null) {
            return alog.getLastFetchErrorInfo();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reason", "Log.instance does not exist");
        return hashMap;
    }

    public static String getStatus() {
        Alog alog = instance;
        return alog != null ? alog.getStatus() : "default log instance is null";
    }

    public static long getLegacyWriteFuncAddr() {
        Alog alog = instance;
        if (alog != null) {
            return alog.getLegacyWriteFuncAddr();
        }
        return 0L;
    }

    public static long getLegacyFlushFuncAddr() {
        Alog alog = instance;
        if (alog != null) {
            return alog.getLegacyFlushFuncAddr();
        }
        return 0L;
    }

    public static long getLegacyGetLogFileDirFuncAddr() {
        Alog alog = instance;
        if (alog != null) {
            return alog.getLegacyGetLogFileDirFuncAddr();
        }
        return 0L;
    }

    public static long getNativeWriteFuncAddr() {
        Alog alog = instance;
        if (alog != null) {
            return alog.getNativeWriteFuncAddr();
        }
        return 0L;
    }

    public static long getNativeWriteAsyncFuncAddr() {
        Alog alog = instance;
        if (alog != null) {
            return alog.getNativeWriteAsyncFuncAddr();
        }
        return 0L;
    }

    public static long getNativeInitFuncAddr() {
        Alog alog = instance;
        if (alog != null) {
            return alog.getNativeInitFuncAddr();
        }
        return 0L;
    }

    @Deprecated
    /* renamed from: v */
    public static void m1264v(String str, String str2) {
        ALog.v(str, str2);
    }

    @Deprecated
    /* renamed from: d */
    public static void m1260d(String str, String str2) {
        ALog.d(str, str2);
    }

    @Deprecated
    /* renamed from: i */
    public static void m1263i(String str, String str2) {
        ALog.i(str, str2);
    }

    @Deprecated
    /* renamed from: w */
    public static void m1265w(String str, String str2) {
        ALog.w(str, str2);
    }

    @Deprecated
    /* renamed from: e */
    public static void m1261e(String str, String str2) {
        ALog.e(str, str2);
    }

    @Deprecated
    /* renamed from: f */
    public static void m1262f(String str, String str2) {
        ALog.e(str, str2);
    }

    @Deprecated
    public static void write(int i, String str, String str2) {
        Alog alog = instance;
        if (alog != null) {
            alog.write(i, str, str2);
        }
    }

    @Deprecated
    public static void writeAsyncMsg(int i, String str, String str2, long j, long j2) {
        Alog alog = instance;
        if (alog != null) {
            alog.writeAsyncMsg(i, str, str2, j, j2);
        }
    }

    @Deprecated
    public static void innerVerbose(String str, String str2) {
        write(0, str, str2);
    }

    @Deprecated
    public static void innerDebug(String str, String str2) {
        write(1, str, str2);
    }

    @Deprecated
    public static void innerInfo(String str, String str2) {
        write(2, str, str2);
    }

    @Deprecated
    public static void innerWarn(String str, String str2) {
        write(3, str, str2);
    }

    @Deprecated
    public static void innerError(String str, String str2) {
        write(4, str, str2);
    }

    @Deprecated
    public static void innerFatal(String str, String str2) {
        write(5, str, str2);
    }

    @Deprecated
    public static void innerWrite(int i, String str, String str2) {
        Alog alog = instance;
        if (alog != null) {
            alog.write(i, str, str2);
        }
    }

    @Deprecated
    public static void innerWriteAsyncMsg(int i, String str, String str2, long j, long j2) {
        Alog alog = instance;
        if (alog != null) {
            alog.writeAsyncMsg(i, str, str2, j, j2);
        }
    }
}
