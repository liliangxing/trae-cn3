package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HubNetConnection.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnectionKt", f = "HubNetConnection.kt", i = {0, 0}, l = {99}, m = "startTransportThenRegister", n = {"onRegisterSuccess", "onRegisterFailure"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnectionKt$startTransportThenRegister$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HubNetConnectionKt$startTransportThenRegister$1(Continuation<? super HubNetConnectionKt$startTransportThenRegister$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HubNetConnectionKt.startTransportThenRegister(null, null, null, null, (Continuation) this);
    }
}
