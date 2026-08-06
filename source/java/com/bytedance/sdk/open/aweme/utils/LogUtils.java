package com.bytedance.sdk.open.aweme.utils;

import android.util.Log;
import com.bytedance.sdk.open.aweme.core.OpenLogService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.impl.SystemOpenLogServiceImpl;

/* loaded from: classes5.dex */
public class LogUtils {
    private static final char BLANK_TAG = ' ';
    private static final String NULL_TAG = "null";
    private static final String TAG_PREFIX = "DYOpen_";
    public static boolean sDebuggable;

    private static String createLog(Object[] objArr) {
        String str;
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(BLANK_TAG);
            if (obj == null) {
                str = "null";
            } else if (obj instanceof Throwable) {
                str = Log.getStackTraceString((Throwable) obj);
            } else {
                sb.append(obj);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static void d(String str, Object... objArr) {
        if (sDebuggable) {
            getLogger().d(formatTag(str), createLog(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        getLogger().e(formatTag(str), createLog(objArr));
    }

    private static String formatTag(String str) {
        return str == null ? "TAG_PREFIX" : !str.startsWith(TAG_PREFIX) ? TAG_PREFIX + str : str;
    }

    private static OpenLogService getLogger() {
        OpenLogService openLogService = (OpenLogService) OpenServiceManager.getInst().getService(OpenLogService.class);
        if (openLogService != null) {
            return openLogService;
        }
        SystemOpenLogServiceImpl systemOpenLogServiceImpl = new SystemOpenLogServiceImpl();
        OpenServiceManager.getInst().registerService(OpenLogService.class, systemOpenLogServiceImpl);
        return systemOpenLogServiceImpl;
    }

    public static void i(String str, Object... objArr) {
        getLogger().i(formatTag(str), createLog(objArr));
    }

    public static void w(String str, Object... objArr) {
        getLogger().w(formatTag(str), createLog(objArr));
    }
}
