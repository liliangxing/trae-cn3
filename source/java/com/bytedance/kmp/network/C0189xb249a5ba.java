package com.bytedance.kmp.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1", f = "KmpNetworkManagerImpl.kt", i = {}, l = {226, 227}, m = "onResponseStart", n = {}, s = {})
/* renamed from: com.bytedance.kmp.network.KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1$onResponseStart$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class C0189xb249a5ba extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0189xb249a5ba(KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 kmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1, Continuation<? super C0189xb249a5ba> continuation) {
        super(continuation);
        this.this$0 = kmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onResponseStart(null, (Continuation) this);
    }
}
