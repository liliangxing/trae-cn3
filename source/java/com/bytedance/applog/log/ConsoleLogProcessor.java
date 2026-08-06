package com.bytedance.applog.log;

import android.util.Log;
import com.bytedance.applog.AppLogInstance;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ConsoleLogProcessor implements ILogProcessor {
    public static final String TAG = "AppLog";
    private final AppLogInstance appLogInstance;

    public ConsoleLogProcessor(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
        onLog(LogInfo.builder().appId(appLogInstance.getAppId()).level(1).thread(Thread.currentThread().getName()).message("Console logger is ready.").build());
    }

    @Override // com.bytedance.applog.log.ILogProcessor
    public void onLog(LogInfo logInfo) {
        if (this.appLogInstance.isLogEnabled()) {
            int level = logInfo.getLevel();
            if (level == 0) {
                Log.v(TAG, logInfo.toLiteString());
                return;
            }
            if (level == 2) {
                Log.i(TAG, logInfo.toLiteString());
                return;
            }
            if (level == 3) {
                Log.w(TAG, logInfo.toLiteString(), logInfo.getThrowable());
            } else if (level == 4 || level == 5) {
                Log.e(TAG, logInfo.toString(), logInfo.getThrowable());
            } else {
                Log.d(TAG, logInfo.toString());
            }
        }
    }
}
