package com.bytedance.trae.im.service;

import com.bytedance.trae.im.service.IRevertCheckTaskApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IRevertCheckTaskApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.IRevertCheckTaskApi$Companion", f = "IRevertCheckTaskApi.kt", i = {}, l = {27}, m = "revertCheckTaskRawCall", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IRevertCheckTaskApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1(IRevertCheckTaskApi.Companion companion, Continuation<? super IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.revertCheckTaskRawCall(null, (Continuation) this);
    }
}
