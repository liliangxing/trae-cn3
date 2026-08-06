package com.bytedance.retrofit2;

/* loaded from: classes4.dex */
public class OptConfig {
    private static volatile boolean sEnableRequestOpt;

    public static void setEnableRequestOpt(boolean z) {
        sEnableRequestOpt = z;
    }

    public static boolean isEnableRequestOpt() {
        return sEnableRequestOpt;
    }
}
