package com.bytedance.trae.home.solo.setting.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PayRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.data.DefaultPayRepository", f = "PayRepository.kt", i = {}, l = {44, 58}, m = "fetchPayStatus", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultPayRepository$fetchPayStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultPayRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPayRepository$fetchPayStatus$1(DefaultPayRepository defaultPayRepository, Continuation<? super DefaultPayRepository$fetchPayStatus$1> continuation) {
        super(continuation);
        this.this$0 = defaultPayRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchPayStatus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchPayStatus = this.this$0.fetchPayStatus((Continuation) this);
        return fetchPayStatus;
    }
}
