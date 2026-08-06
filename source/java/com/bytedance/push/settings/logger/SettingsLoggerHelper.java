package com.bytedance.push.settings.logger;

import android.util.Log;

/* loaded from: classes4.dex */
public class SettingsLoggerHelper implements ILogger {
    private static final SettingsLoggerHelper S_SETTINGS_LOGGER_HELPER = new SettingsLoggerHelper();
    private final String TAG = "SettingsManager";
    private ILogger mILogger;

    public static SettingsLoggerHelper getInstance() {
        return S_SETTINGS_LOGGER_HELPER;
    }

    public void setLogger(ILogger iLogger) {
        this.mILogger = iLogger;
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void d(String str) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.d(str);
        } else {
            Log.d("SettingsManager", str);
        }
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void d(String str, String str2) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.d("SettingsManager-->" + str, str2);
        } else {
            Log.d("SettingsManager-->" + str, str2);
        }
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void e(String str) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.e("SettingsManager-->" + str);
        } else {
            Log.e("SettingsManager", str);
        }
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void e(String str, String str2) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.e("SettingsManager-->" + str, str2);
        } else {
            Log.e("SettingsManager-->" + str, str2);
        }
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void i(String str) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.i("SettingsManager-->" + str);
        } else {
            Log.i("SettingsManager", str);
        }
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void i(String str, String str2) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.i("SettingsManager-->" + str, str2);
        } else {
            Log.i("SettingsManager-->" + str, str2);
        }
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void i(String str, String str2, Throwable th) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.i("SettingsManager-->" + str, str2, th);
        } else {
            Log.i("SettingsManager-->" + str, str2, th);
        }
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void v(String str, String str2) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.v("SettingsManager-->" + str, str2);
        } else {
            Log.v("SettingsManager-->" + str, str2);
        }
    }

    @Override // com.bytedance.push.settings.logger.ILogger
    public void w(String str, String str2) {
        ILogger iLogger = this.mILogger;
        if (iLogger != null) {
            iLogger.w("SettingsManager-->" + str, str2);
        } else {
            Log.w("SettingsManager-->" + str, str2);
        }
    }
}
