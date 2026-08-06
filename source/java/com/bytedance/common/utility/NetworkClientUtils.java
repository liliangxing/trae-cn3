package com.bytedance.common.utility;

/* loaded from: classes3.dex */
public class NetworkClientUtils {
    public static boolean hasNotSetNetworkClient() {
        return NetworkClient.getDefault() instanceof DummyNetworkClient;
    }
}
