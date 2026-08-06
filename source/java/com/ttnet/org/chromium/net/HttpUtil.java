package com.ttnet.org.chromium.net;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
/* loaded from: classes7.dex */
public final class HttpUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface Natives {
        boolean isAllowedHeader(String str, String str2);
    }

    public static boolean isAllowedHeader(String str, String str2) {
        return HttpUtilJni.get().isAllowedHeader(str, str2);
    }
}
