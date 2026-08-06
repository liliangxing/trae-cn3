package com.bytedance.trae.im.service;

import com.bytedance.trae.im.service.ICancelTaskApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ICancelTaskApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.ICancelTaskApi$Companion", f = "ICancelTaskApi.kt", i = {0}, l = {38}, m = "cancelTaskRawCall", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ICancelTaskApi$Companion$cancelTaskRawCall$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ICancelTaskApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ICancelTaskApi$Companion$cancelTaskRawCall$1(ICancelTaskApi.Companion companion, Continuation<? super ICancelTaskApi$Companion$cancelTaskRawCall$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cancelTaskRawCall(null, (Continuation) this);
    }
}
