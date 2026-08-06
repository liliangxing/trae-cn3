package com.bytedance.ttnet.config;

import com.bytedance.common.utility.reflect.Reflect;

/* loaded from: classes4.dex */
public class SDKConfig {
    private static final int TTNET_SID = 2616;
    private static volatile boolean enable = true;

    public static void registerSdk() {
        if (enable) {
            try {
                Reflect.on(Class.forName("com.bytedance.crash.Npth").newInstance()).call("registerSdk", new Class[]{Integer.TYPE, String.class}, Integer.valueOf(TTNET_SID), "4.2.243.6-doubao");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void disableRegisterSdk() {
        enable = false;
    }
}
