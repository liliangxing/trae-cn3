package com.bytedance.kmp.network.cinterop;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KmpNativeNetworkService.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.KmpNativeNetworkService", f = "KmpNativeNetworkService.kt", i = {0, 0, 0, 0, 0, 0}, l = {301, 163}, m = "executeStream", n = {"request", "callback", "nativeRequest", "call", "$this$withLock_u24default$iv", "requestId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNativeNetworkService$executeStream$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNativeNetworkService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNativeNetworkService$executeStream$1(KmpNativeNetworkService kmpNativeNetworkService, Continuation<? super KmpNativeNetworkService$executeStream$1> continuation) {
        super(continuation);
        this.this$0 = kmpNativeNetworkService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeStream(null, null, (Continuation) this);
    }
}
