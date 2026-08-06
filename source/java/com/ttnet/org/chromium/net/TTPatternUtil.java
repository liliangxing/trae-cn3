package com.ttnet.org.chromium.net;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.regex.Pattern;

@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
/* loaded from: classes7.dex */
public class TTPatternUtil {
    public static boolean isPatternStringValid(String str) {
        try {
            Pattern.compile(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
