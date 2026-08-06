package com.bytedance.trae.conversation.devices.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: DeviceFlowContainerBottomSheet.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class DeviceFlowContainerBottomSheet$openNewFlow$1 extends AdaptedFunctionReference implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceFlowContainerBottomSheet$openNewFlow$1(Object obj) {
        super(0, obj, DeviceFlowContainerBottomSheet.class, "notifyCurrentRouteConnectionSuccess", "notifyCurrentRouteConnectionSuccess(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1446invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m1446invoke() {
        DeviceFlowContainerBottomSheet.notifyCurrentRouteConnectionSuccess$default((DeviceFlowContainerBottomSheet) this.receiver, null, 1, null);
    }
}
