package com.bytedance.sdk.account.trace;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* loaded from: classes5.dex */
public class TraceManager {
    private static volatile String sScene;
    private static volatile String sTraceId;

    public static String getTraceId() {
        return sTraceId;
    }

    public static void startTrace(String str) {
        sScene = str;
        sTraceId = str + "_" + UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static void stopTrace(String str) {
        if (TextUtils.equals(sScene, str)) {
            sScene = null;
            sTraceId = null;
        }
    }
}
