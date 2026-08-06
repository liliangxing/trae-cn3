package com.bytedance.crash.upload;

import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Net;
import com.bytedance.crash.util.NpthLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LaunchScanner implements Runnable {
    private static long delayTime;

    public static void start() {
        NpthLog.m233i("LaunchScanner start");
        if (App.isMainProcess()) {
            DefaultWorkThread.postDelayed(new LaunchScanner(), 0L);
        }
    }

    public static void setUploadDelayTime(long j) {
        delayTime = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            NpthLog.m233i("LaunchScanner run");
            if (Net.isNetworkAvailable()) {
                NpthLog.m233i("net available");
                AppMonitor appMonitor = MonitorManager.getAppMonitor();
                if (appMonitor != null) {
                    CrashAccessibilityMonitor.getHistoryProcessExitReason();
                    NpthLog.m233i("upload crash");
                    CrashManager.upload(appMonitor, delayTime);
                    AnrManager.upload(appMonitor, delayTime);
                    CrashAccessibilityMonitor.upload();
                    UploadLimits.get().writeUploadTimesFile();
                    AlogManager.upload(appMonitor);
                }
                NativeBridge.notifyUploadDone();
                if (delayTime > 0) {
                    DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.upload.LaunchScanner.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CrashUploadHandler.afterUploadEnd();
                        }
                    }, delayTime);
                    return;
                }
                return;
            }
            NpthLog.m233i("LaunchScanner, network is unavailable");
            DefaultWorkThread.postDelayed(new LaunchScanner(), 1000L);
        } catch (Throwable th) {
            NpthMonitor.reportInnerExceptionWithSpace("NPTH_ANR_ERROR_LaunchScanner", th);
            NpthLog.m232e(th);
        }
    }
}
