package com.bytedance.kmp.network.p010public;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BizInterceptorManager.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.public.BizInterceptorManager", f = "BizInterceptorManager.kt", i = {0, 0, 0}, l = {62}, m = "intercept", n = {"queryMap", "headerMap", "reqContext"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BizInterceptorManager$intercept$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BizInterceptorManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BizInterceptorManager$intercept$1(BizInterceptorManager bizInterceptorManager, Continuation<? super BizInterceptorManager$intercept$1> continuation) {
        super(continuation);
        this.this$0 = bizInterceptorManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.intercept(null, (Continuation) this);
    }
}
