package com.ss.bytertc.base.media.screen;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ScreenServiceManager {
    private static final String TAG = "ScreenServiceManager";

    ScreenServiceManager() {
    }

    public void stopService() {
        if (Build.VERSION.SDK_INT > 28 && RXScreenCaptureService.serviceStarted.get()) {
            try {
                Context applicationContext = ContextUtils.getApplicationContext();
                applicationContext.startForegroundService(RXScreenCaptureService.getServiceIntent(applicationContext, 9, null));
                Log.i(TAG, "stopService");
                RXLogging.w(TAG, String.format("[ScreenCapture] stopService!", new Object[0]));
            } catch (ForegroundServiceStartNotAllowedException unused) {
                Log.e(TAG, "stopService failed.");
            }
        }
    }
}
