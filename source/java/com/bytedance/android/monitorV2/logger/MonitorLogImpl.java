package com.bytedance.android.monitorV2.logger;

import android.util.Log;

/* loaded from: classes3.dex */
public class MonitorLogImpl implements ILogger {
    private static final String TAG_NA_PRE = "NA_";
    private static final int maxLogLength = 3000;
    private static final String TAG_LOGCAT = "HBMonitorSDK_Logcat";
    private static final boolean USE_LOGCAT = Log.isLoggable(TAG_LOGCAT, 3);

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void v(String str, String str2) {
        while (str2.length() > 3000) {
            if (USE_LOGCAT || !ALogUtil.v(str, str2.substring(0, 3000))) {
                Log.v(TAG_NA_PRE + str, str2.substring(0, 3000));
            }
            str2 = str2.substring(3000);
        }
        if (USE_LOGCAT || !ALogUtil.v(str, str2)) {
            Log.v(TAG_NA_PRE + str, str2);
        }
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void d(String str, String str2) {
        while (str2.length() > 3000) {
            if (USE_LOGCAT || !ALogUtil.d(str, str2.substring(0, 3000))) {
                Log.d(TAG_NA_PRE + str, str2.substring(0, 3000));
            }
            str2 = str2.substring(3000);
        }
        if (USE_LOGCAT || !ALogUtil.d(str, str2)) {
            Log.d(TAG_NA_PRE + str, str2);
        }
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void i(String str, String str2) {
        while (str2.length() > 3000) {
            if (USE_LOGCAT || !ALogUtil.i(str, str2.substring(0, 3000))) {
                Log.i(TAG_NA_PRE + str, str2.substring(0, 3000));
            }
            str2 = str2.substring(3000);
        }
        if (USE_LOGCAT || !ALogUtil.i(str, str2)) {
            Log.i(TAG_NA_PRE + str, str2);
        }
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void w(String str, String str2) {
        while (str2.length() > 3000) {
            if (USE_LOGCAT || !ALogUtil.w(str, str2.substring(0, 3000))) {
                Log.w(TAG_NA_PRE + str, str2.substring(0, 3000));
            }
            str2 = str2.substring(3000);
        }
        if (USE_LOGCAT || !ALogUtil.w(str, str2)) {
            Log.i(TAG_NA_PRE + str, str2);
        }
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void e(String str, String str2) {
        while (str2.length() > 3000) {
            if (USE_LOGCAT || !ALogUtil.e(str, str2.substring(0, 3000))) {
                Log.w(TAG_NA_PRE + str, str2.substring(0, 3000));
            }
            str2 = str2.substring(3000);
        }
        if (USE_LOGCAT || !ALogUtil.e(str, str2)) {
            Log.e(TAG_NA_PRE + str, str2);
        }
    }

    @Override // com.bytedance.android.monitorV2.logger.ILogger
    public void e(String str, String str2, Throwable th) {
        if (USE_LOGCAT || !ALogUtil.e(str, str2, th)) {
            Log.e(TAG_NA_PRE + str, str2, th);
        }
    }
}
