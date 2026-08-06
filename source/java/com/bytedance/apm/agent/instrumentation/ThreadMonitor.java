package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.AppUtils;
import com.bytedance.apm.util.ThreadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ThreadMonitor {
    private static final String TAG = "ThreadMonitor";

    public static void sleepMonitor(long j) throws InterruptedException {
        if (ThreadUtils.isMainThread() && j > 10 && !isDebuggable()) {
            isLocalChannel();
        }
        Thread.sleep(j);
    }

    private static boolean isDebuggable() {
        return AppUtils.isDebug(ApmContext.getContext());
    }

    private static boolean isLocalChannel() {
        return ApmContext.isLocalChannel();
    }
}
