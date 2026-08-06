package com.bytedance.android.monitorV2.logger;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public class MonitorLog {

    @Deprecated
    private static boolean isLogEnable;
    private static boolean isLogVerbose = AnnieX.isDebug();
    private static final String TAG_PRE = "HBMonitorSDK_V2";
    private static final boolean INNER_LOG_ABLE = Log.isLoggable(TAG_PRE, 3);
    private static ILogger sLoggerImpl = new MonitorLogImpl();

    @Deprecated
    public static void setLogger(ILogger iLogger) {
        Log.e("HBMonitorSDK", "logger already deprecated");
    }

    @Deprecated
    public static void setLogEnable(boolean z) {
        isLogEnable = z;
    }

    @Deprecated
    public static void setLogInBackground(boolean z) {
        if (z) {
            sLoggerImpl = new MonitorLogAsyncImpl(new MonitorLogImpl());
        } else {
            sLoggerImpl = new MonitorLogImpl();
        }
    }

    @Deprecated
    public static boolean isLogEnable() {
        return isLogEnable;
    }

    public static void setLogVerbose(boolean z) {
        isLogVerbose = z;
    }

    public static boolean isLogVerbose() {
        return isLogVerbose || INNER_LOG_ABLE;
    }

    public static void v(String str, String str2) {
        if (isLogVerbose()) {
            sLoggerImpl.v(getLogTag(str), str2);
        }
    }

    public static void d(String str, String str2) {
        if (isLogVerbose()) {
            sLoggerImpl.d(getLogTag(str), str2);
        }
    }

    public static void i(String str, String str2) {
        sLoggerImpl.i(getLogTag(str), str2);
    }

    public static void w(String str, String str2) {
        sLoggerImpl.w(getLogTag(str), str2);
    }

    public static void e(String str, String str2) {
        sLoggerImpl.e(getLogTag(str), str2);
    }

    public static void e(String str, String str2, Throwable th) {
        sLoggerImpl.e(getLogTag(str), str2, th);
    }

    private static String getLogTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return TAG_PRE;
        }
        if (!str.startsWith(TAG_PRE)) {
            str = "HBMonitorSDK_V2_" + str;
        }
        return str + "(" + Process.myPid() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myTid() + ")";
    }

    public static String getSafeWebViewString(WebView webView) {
        return webView == null ? "null" : webView.getClass().toString();
    }
}
