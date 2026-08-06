package com.bytedance.kmp.network;

import com.bytedance.reparo.core.exception.PatchException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl", f = "KmpNetworkManagerImpl.kt", i = {0, 1}, l = {PatchException.ERR_LOAD_SO_HOOK_ERR4, 330}, m = "preprocessRequest", n = {"request", "processedRequestBuilder"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkManagerImpl$preprocessRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNetworkManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNetworkManagerImpl$preprocessRequest$1(KmpNetworkManagerImpl kmpNetworkManagerImpl, Continuation<? super KmpNetworkManagerImpl$preprocessRequest$1> continuation) {
        super(continuation);
        this.this$0 = kmpNetworkManagerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.preprocessRequest(null, (Continuation) this);
    }
}
