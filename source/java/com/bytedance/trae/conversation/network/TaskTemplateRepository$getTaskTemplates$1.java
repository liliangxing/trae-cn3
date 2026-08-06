package com.bytedance.trae.conversation.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskTemplateRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.TaskTemplateRepository", f = "TaskTemplateRepository.kt", i = {0}, l = {88}, m = "getTaskTemplates", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskTemplateRepository$getTaskTemplates$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskTemplateRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskTemplateRepository$getTaskTemplates$1(TaskTemplateRepository taskTemplateRepository, Continuation<? super TaskTemplateRepository$getTaskTemplates$1> continuation) {
        super(continuation);
        this.this$0 = taskTemplateRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getTaskTemplates((Continuation) this);
    }
}
