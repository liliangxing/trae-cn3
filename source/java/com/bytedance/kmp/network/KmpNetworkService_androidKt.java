package com.bytedance.kmp.network;

import com.bytedance.kmp.network.websocket.IRawWsService;
import com.bytedance.kmp.spi.IKmpService;
import com.bytedance.kmp.spi.KmpServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KmpNetworkService.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getKmpNetworkService", "Lcom/bytedance/kmp/network/IKmpNetworkService;", "getRawWsService", "Lcom/bytedance/kmp/network/websocket/IRawWsService;", "network_service_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkService_androidKt {
    public static final IKmpNetworkService getKmpNetworkService() {
        IKmpService iKmpService = KmpServiceManager.INSTANCE.get(Reflection.getOrCreateKotlinClass(IKmpNetworkService.class));
        Intrinsics.checkNotNull(iKmpService);
        return (IKmpNetworkService) iKmpService;
    }

    public static final IRawWsService getRawWsService() {
        IKmpService iKmpService = KmpServiceManager.INSTANCE.get(Reflection.getOrCreateKotlinClass(IRawWsService.class));
        Intrinsics.checkNotNull(iKmpService);
        return (IRawWsService) iKmpService;
    }
}
