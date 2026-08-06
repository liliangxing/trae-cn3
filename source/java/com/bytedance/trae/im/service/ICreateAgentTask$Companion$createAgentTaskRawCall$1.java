package com.bytedance.trae.im.service;

import com.bytedance.trae.im.service.ICreateAgentTask;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ICreateAgentTask.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.ICreateAgentTask$Companion", f = "ICreateAgentTask.kt", i = {0}, l = {53}, m = "createAgentTaskRawCall", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ICreateAgentTask$Companion$createAgentTaskRawCall$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ICreateAgentTask.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ICreateAgentTask$Companion$createAgentTaskRawCall$1(ICreateAgentTask.Companion companion, Continuation<? super ICreateAgentTask$Companion$createAgentTaskRawCall$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createAgentTaskRawCall(null, (Continuation) this);
    }
}
