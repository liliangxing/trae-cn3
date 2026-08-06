package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HubNetConnection.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection", f = "HubNetConnection.kt", i = {0}, l = {383}, m = "registerApp", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnection$registerApp$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HubNetConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$registerApp$1(HubNetConnection hubNetConnection, Continuation<? super HubNetConnection$registerApp$1> continuation) {
        super(continuation);
        this.this$0 = hubNetConnection;
    }

    public final Object invokeSuspend(Object obj) {
        Object registerApp;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        registerApp = this.this$0.registerApp(null, (Continuation) this);
        return registerApp;
    }
}
