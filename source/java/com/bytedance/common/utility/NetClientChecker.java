package com.bytedance.common.utility;

/* loaded from: classes3.dex */
public class NetClientChecker {
    public static boolean isNetworkClientSet() {
        return !(NetworkClient.getDefault() instanceof DummyNetworkClient);
    }
}
