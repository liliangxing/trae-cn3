package com.bytedance.reparo.secondary;

import android.app.Application;
import com.bytedance.crash.runtime.NpthHandlerThread;
import com.bytedance.platform.thread.Constants;
import com.bytedance.reparo.ReparoNpth;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class NpthService {
    private static Runnable sInitRunnable;
    private static boolean sNoNpth;

    NpthService() {
    }

    public static void init(final Application application, final ExecutorService executorService) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.reparo.secondary.NpthService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ReparoNpth.init(application, executorService, false, 4100L, "0.0.4-rc.50");
                    if (MonitorService.isInited()) {
                        return;
                    }
                    NpthHandlerThread.getDefaultHandler().postDelayed(new Runnable() { // from class: com.bytedance.reparo.secondary.NpthService.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MonitorService.getMonitor();
                        }
                    }, Constants.TASK_WAIT_THRESHOLD);
                } catch (NoClassDefFoundError unused) {
                    boolean unused2 = NpthService.sNoNpth = true;
                }
            }
        };
        sInitRunnable = runnable;
        executorService.execute(runnable);
    }

    public static void updatePatchId(String str) {
        if (sNoNpth) {
            return;
        }
        ReparoNpth.updatePatchId(str);
    }

    public static void reportError(String str, String str2, Throwable th) {
        if (sNoNpth) {
            return;
        }
        ReparoNpth.reportError(str, str2, th);
    }
}
