package com.bytedance.ies.bullet.kit.web.impl;

import com.bytedance.ies.bullet.core.kit.bridge.BridgePerfData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultWebKitDelegate.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public /* synthetic */ class DefaultWebKitDelegate$createWebJsBridge$1$1 extends FunctionReferenceImpl implements Function2<String, BridgePerfData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultWebKitDelegate$createWebJsBridge$1$1(Object obj) {
        super(2, obj, DefaultWebKitDelegate.class, "onPerfDataReady", "onPerfDataReady(Ljava/lang/String;Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (BridgePerfData) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, BridgePerfData bridgePerfData) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(bridgePerfData, "p1");
        ((DefaultWebKitDelegate) this.receiver).onPerfDataReady(str, bridgePerfData);
    }
}
