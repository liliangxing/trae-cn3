package com.bytedance.kmp.network.cinterop;

import com.bytedance.ug.sdk.share.api.entity.ToastCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KmpNativeNetworkService.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.KmpNativeNetworkService$executeStream$3", f = "KmpNativeNetworkService.kt", i = {1, 2}, l = {ToastCode.SNAPCHAT_NOT_INSTALL, 301, 301}, m = "onSucceed", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNativeNetworkService$executeStream$3$onSucceed$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNativeNetworkService$executeStream$3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNativeNetworkService$executeStream$3$onSucceed$1(KmpNativeNetworkService$executeStream$3 kmpNativeNetworkService$executeStream$3, Continuation<? super KmpNativeNetworkService$executeStream$3$onSucceed$1> continuation) {
        super(continuation);
        this.this$0 = kmpNativeNetworkService$executeStream$3;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onSucceed(null, (Continuation) this);
    }
}
