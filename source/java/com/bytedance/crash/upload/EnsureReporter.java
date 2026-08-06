package com.bytedance.crash.upload;

import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.monitor.MonitorManager;
import java.util.Map;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EnsureReporter {
    public static void reportException(Throwable th, String str, boolean z) {
        MonitorManager.getAppEnsureManager().reportThrowable(th, str, z);
    }

    public static void reportException(Throwable th, String str, boolean z, Map<String, String> map, String str2) {
        MonitorManager.getAppEnsureManager().reportJavaEnsure(th, null, str, map, Thread.currentThread().getName(), EnsureDeliverer.ENSURE_NOT_REACH_HERE, str2, z);
    }
}
