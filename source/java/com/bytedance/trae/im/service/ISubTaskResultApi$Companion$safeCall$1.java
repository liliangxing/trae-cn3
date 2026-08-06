package com.bytedance.trae.im.service;

import com.bytedance.trae.im.service.ISubTaskResultApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ISubTaskResultApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.ISubTaskResultApi$Companion", f = "ISubTaskResultApi.kt", i = {}, l = {39}, m = "safeCall", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ISubTaskResultApi$Companion$safeCall$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ISubTaskResultApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ISubTaskResultApi$Companion$safeCall$1(ISubTaskResultApi.Companion companion, Continuation<? super ISubTaskResultApi$Companion$safeCall$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.safeCall(null, (Continuation) this);
    }
}
