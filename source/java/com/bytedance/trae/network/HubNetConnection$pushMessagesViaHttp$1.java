package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HubNetConnection.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection", f = "HubNetConnection.kt", i = {0, 0, 0}, l = {1363}, m = "pushMessagesViaHttp", n = {"this", "messages", "requeued"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnection$pushMessagesViaHttp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HubNetConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$pushMessagesViaHttp$1(HubNetConnection hubNetConnection, Continuation<? super HubNetConnection$pushMessagesViaHttp$1> continuation) {
        super(continuation);
        this.this$0 = hubNetConnection;
    }

    public final Object invokeSuspend(Object obj) {
        Object pushMessagesViaHttp;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        pushMessagesViaHttp = this.this$0.pushMessagesViaHttp(null, (Continuation) this);
        return pushMessagesViaHttp;
    }
}
