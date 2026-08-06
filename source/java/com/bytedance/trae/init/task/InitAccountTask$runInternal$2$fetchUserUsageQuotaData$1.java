package com.bytedance.trae.init.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitAccountTask.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.init.task.InitAccountTask$runInternal$2", f = "InitAccountTask.kt", i = {}, l = {172}, m = "fetchUserUsageQuotaData", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitAccountTask$runInternal$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1(InitAccountTask$runInternal$2 initAccountTask$runInternal$2, Continuation<? super InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1> continuation) {
        super(continuation);
        this.this$0 = initAccountTask$runInternal$2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchUserUsageQuotaData((Continuation) this);
    }
}
