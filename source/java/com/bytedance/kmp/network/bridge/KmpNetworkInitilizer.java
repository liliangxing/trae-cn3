package com.bytedance.kmp.network.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpNetworkInitilizer.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpNetworkInitilizer;", "", "()V", "init", "", "bridge", "Lcom/bytedance/kmp/network/bridge/IKmpNetworkBridge;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpNetworkInitilizer {
    public static final KmpNetworkInitilizer INSTANCE = new KmpNetworkInitilizer();

    public final void init(IKmpNetworkBridge bridge) {
        Intrinsics.checkNotNullParameter(bridge, "bridge");
    }

    private KmpNetworkInitilizer() {
    }
}
