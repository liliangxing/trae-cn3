package com.bytedance.reparo;

import android.app.Application;
import com.bytedance.crash.Npth;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ReparoNpth {
    private static ConcurrentLinkedQueue<Runnable> sCachedExceptionQueue = new ConcurrentLinkedQueue<>();
    private static String sPatchId = "noPatch";
    private static boolean sInited = false;

    public static void init(Application application, ExecutorService executorService, boolean z, long j, String str) {
        Runnable poll;
        ReparoNpthMonitor.init(application, z, j, str);
        while (!sCachedExceptionQueue.isEmpty() && (poll = sCachedExceptionQueue.poll()) != null) {
            try {
                poll.run();
            } catch (Throwable unused) {
                return;
            }
        }
    }

    public static void updatePatchId(String str) {
        sPatchId = str;
        try {
            Npth.addTag("reparo_patch_id", str);
        } catch (Throwable unused) {
        }
    }

    public static void reportError(String str, final String str2, final Throwable th) {
        if (sInited) {
            ReparoNpthMonitor.reportInnerException(str2, th);
        } else {
            sCachedExceptionQueue.add(new Runnable() { // from class: com.bytedance.reparo.ReparoNpth.1
                @Override // java.lang.Runnable
                public void run() {
                    ReparoNpthMonitor.reportInnerException(str2, th);
                }
            });
        }
    }
}
