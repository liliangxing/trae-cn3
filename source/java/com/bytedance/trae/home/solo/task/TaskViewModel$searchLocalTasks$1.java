package com.bytedance.trae.home.solo.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel", f = "TaskViewModel.kt", i = {}, l = {662}, m = "searchLocalTasks", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$searchLocalTasks$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$searchLocalTasks$1(TaskViewModel taskViewModel, Continuation<? super TaskViewModel$searchLocalTasks$1> continuation) {
        super(continuation);
        this.this$0 = taskViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object searchLocalTasks;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        searchLocalTasks = this.this$0.searchLocalTasks(null, (Continuation) this);
        return searchLocalTasks;
    }
}
