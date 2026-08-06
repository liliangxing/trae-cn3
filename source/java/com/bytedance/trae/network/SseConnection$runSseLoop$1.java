package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SseConnection.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.SseConnection", f = "SseConnection.kt", i = {0, 1}, l = {250, 277}, m = "runSseLoop", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SseConnection$runSseLoop$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SseConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SseConnection$runSseLoop$1(SseConnection sseConnection, Continuation<? super SseConnection$runSseLoop$1> continuation) {
        super(continuation);
        this.this$0 = sseConnection;
    }

    public final Object invokeSuspend(Object obj) {
        Object runSseLoop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runSseLoop = this.this$0.runSseLoop((Continuation) this);
        return runSseLoop;
    }
}
