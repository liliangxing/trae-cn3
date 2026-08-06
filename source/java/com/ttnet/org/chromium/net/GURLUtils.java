package com.ttnet.org.chromium.net;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
/* loaded from: classes7.dex */
public final class GURLUtils {

    /* loaded from: classes7.dex */
    public interface Natives {
        String getOrigin(String str);
    }

    public static String getOrigin(String str) {
        return GURLUtilsJni.get().getOrigin(str);
    }
}
