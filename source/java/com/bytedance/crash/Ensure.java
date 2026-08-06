package com.bytedance.crash;

import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.CustomJavaHandler;
import com.bytedance.crash.event.SLIExceptionManager;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Ensure {
    public static final String ENSURE_NOT_NULL = "EnsureNotNull";
    private static final int JAVA_CRASH_MAX_SIZE = 3;
    private static final int STACKTRACE_NORMAL_DEPTH = 4;
    public static boolean isEnableUploadCustomJavaCrash;
    private static EventMonitor sAppMonitor;

    @Deprecated
    private static final EnsureImpl sInstance = new EnsureImpl();
    private static int customJavaCrashCount = 0;

    @Deprecated
    public static boolean ensureFalse(boolean z) {
        return false;
    }

    @Deprecated
    public static boolean ensureFalse(boolean z, String str) {
        return false;
    }

    @Deprecated
    public static boolean ensureFalse(boolean z, String str, Map<String, String> map) {
        return false;
    }

    @Deprecated
    public static boolean ensureNotEmpty(Collection collection) {
        return false;
    }

    @Deprecated
    public static boolean ensureNotNull(Object obj) {
        return false;
    }

    @Deprecated
    public static boolean ensureNotNull(Object obj, String str) {
        return false;
    }

    @Deprecated
    public static boolean ensureTrue(boolean z) {
        return false;
    }

    @Deprecated
    public static boolean ensureTrue(boolean z, String str) {
        return false;
    }

    @Deprecated
    public static boolean ensureTrue(boolean z, String str, Map<String, String> map) {
        return false;
    }

    @Deprecated
    public static EnsureImpl getInstance() {
        return sInstance;
    }

    private static EventMonitor getMonitor() {
        if (sAppMonitor == null) {
            sAppMonitor = MonitorManager.getAppMonitor();
        }
        return sAppMonitor;
    }

    public static void ensureNotReachHere() {
        MonitorManager.getAppEnsureManager().reportMessage(4);
    }

    public static void ensureNotReachHere(String str) {
        MonitorManager.getAppEnsureManager().reportMessage(str, 4);
    }

    public static void ensureNotReachHere(String str, Map<String, String> map) {
        MonitorManager.getAppEnsureManager().reportMessage(str, map, 4);
    }

    public static void ensureNotReachHere(Throwable th) {
        if (filterException(th)) {
            return;
        }
        MonitorManager.getAppEnsureManager().reportThrowable(th);
    }

    public static void ensureNativeStackWithLogTypeDirect(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        MonitorManager.getAppEnsureManager().reportNativeEnsure(str2, str3, str4, str5, map, str);
    }

    public static void ensureNotReachHereWithLogTypeDirect(String str, Throwable th, String str2) {
        if (filterException(th)) {
            return;
        }
        MonitorManager.getAppEnsureManager().reportThrowable(th, str2, str);
    }

    public static void ensureNativeStack(String str, String str2, String str3, String str4, Map<String, String> map) {
        MonitorManager.getAppEnsureManager().reportNativeEnsure(str, str2, str3, str4, map, null);
    }

    public static void reportCustomExceptionReasonDirect(String str, Throwable th, String str2, String str3, Map<String, String> map, String str4, File file) {
        if (filterException(th) || str4 == null || file == null) {
            return;
        }
        SLIExceptionManager.getInstance().reportException(th, str2, str3, true, map, str4, str, file);
    }

    public static void ensureNotReachHere(Throwable th, String str) {
        if (filterException(th)) {
            return;
        }
        MonitorManager.getAppEnsureManager().reportThrowable(th, str);
    }

    public static void ensureNotReachHere(Throwable th, String str, Map<String, String> map) {
        if (filterException(th)) {
            return;
        }
        MonitorManager.getAppEnsureManager().reportThrowable(th, str, map);
    }

    public static void reportCustomJavaCrash(Thread thread, Throwable th) {
        CrashManager.getCustomJavaHandler().handleCustomException(thread, th);
    }

    public static void ensureNotReachHereWithLogType(String str, Throwable th, String str2) {
        if (filterException(th)) {
            return;
        }
        MonitorManager.getAppEnsureManager().reportThrowable(th, str2, str);
    }

    public static void ensureNotReachHere(String str, Throwable th, String str2, Map<String, String> map) {
        if (filterException(th)) {
            return;
        }
        MonitorManager.getAppEnsureManager().reportJavaEnsure(th, null, str2, map, Thread.currentThread().getName(), str, str, true);
    }

    public static void ensureNotReachHere(Throwable th, String str, String str2, String str3) {
        if (filterException(th)) {
            return;
        }
        MonitorManager.getAppEnsureManager().reportJavaEnsure(th, null, str2, null, str, str3, str3, true);
    }

    public static void ensureNativeNotReachHere(String str, String str2, String str3, String str4, String str5) {
        MonitorManager.getAppEnsureManager().reportNativeEnsure(str, str2, str3, str4, null, str5);
    }

    public static void ensureNativeStack(String str, String str2, String str3, String str4, Map<String, String> map, String str5) {
        MonitorManager.getAppEnsureManager().reportNativeEnsure(str, str2, str3, str4, map, str5);
    }

    public static boolean filterException(Throwable th) {
        if (th == null) {
            return true;
        }
        try {
            if ((th instanceof ConnectTimeoutException) || (th instanceof SocketTimeoutException) || (th instanceof BindException) || (th instanceof ConnectException) || (th instanceof NoRouteToHostException) || (th instanceof PortUnreachableException) || (th instanceof SocketException) || (th instanceof UnknownHostException) || (th instanceof ProtocolException)) {
                return true;
            }
            return th instanceof SSLException;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void setUploadCustomJavaCrashEnable(boolean z) {
        isEnableUploadCustomJavaCrash = z;
    }

    public static void reportJavaCrash(Thread thread, Throwable th) {
        if (!NpthCore.isInit()) {
            NpthLog.m227d("reportJavaCrash: npth is not init, dispose");
            return;
        }
        if (NpthCore.isStopUpload()) {
            NpthLog.m227d("reportJavaCrash: stop upload, dispose");
            return;
        }
        if (customJavaCrashCount >= 3) {
            NpthLog.m227d("reportJavaCrash: > 3 times, dispose");
            return;
        }
        if (!isEnableUploadCustomJavaCrash) {
            NpthLog.m227d("reportJavaCrash: discard because config");
            return;
        }
        CustomJavaHandler customJavaHandler = CrashManager.getCustomJavaHandler();
        if (customJavaHandler == null) {
            return;
        }
        customJavaCrashCount++;
        customJavaHandler.handleCustomException(thread, th);
    }
}
