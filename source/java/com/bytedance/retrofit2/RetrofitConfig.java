package com.bytedance.retrofit2;

/* loaded from: classes4.dex */
public class RetrofitConfig {
    private static boolean loadServiceMethodOpt;

    public static void enableLoadServiceMethodOpt() {
        loadServiceMethodOpt = true;
    }

    public static boolean isLoadServiceMethodOptOpen() {
        return loadServiceMethodOpt;
    }
}
