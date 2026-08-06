package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$startPollingIfNeeded$1", f = "TaskViewModel.kt", i = {}, l = {576}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$startPollingIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$startPollingIfNeeded$1(TaskViewModel taskViewModel, Continuation<? super TaskViewModel$startPollingIfNeeded$1> continuation) {
        super(2, continuation);
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskViewModel$startPollingIfNeeded$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b A[EDGE_INSN: B:30:0x006b->B:9:0x006b BREAK  A[LOOP:0: B:18:0x004d->B:27:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002b -> B:5:0x002e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TaskViewModel$startPollingIfNeeded$1 taskViewModel$startPollingIfNeeded$1;
        long j;
        MutableStateFlow mutableStateFlow;
        Iterable iterable;
        boolean z;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            taskViewModel$startPollingIfNeeded$1 = this;
            j = taskViewModel$startPollingIfNeeded$1.this$0.pollingIntervalMs;
            taskViewModel$startPollingIfNeeded$1.label = 1;
            if (DelayKt.delay(j, (Continuation) taskViewModel$startPollingIfNeeded$1) == coroutine_suspended) {
            }
            mutableStateFlow = taskViewModel$startPollingIfNeeded$1.this$0._allTasks;
            iterable = (Iterable) mutableStateFlow.getValue();
            z = false;
            if (iterable instanceof Collection) {
            }
            it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                }
            }
            if (z) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            taskViewModel$startPollingIfNeeded$1 = this;
            mutableStateFlow = taskViewModel$startPollingIfNeeded$1.this$0._allTasks;
            iterable = (Iterable) mutableStateFlow.getValue();
            z = false;
            if ((iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((TaskModel) it.next()).getStatus().getDisplayState() == TaskDisplayState.LOADING) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                taskViewModel$startPollingIfNeeded$1.this$0.forceLoadTasks();
                j = taskViewModel$startPollingIfNeeded$1.this$0.pollingIntervalMs;
                taskViewModel$startPollingIfNeeded$1.label = 1;
                if (DelayKt.delay(j, (Continuation) taskViewModel$startPollingIfNeeded$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableStateFlow = taskViewModel$startPollingIfNeeded$1.this$0._allTasks;
                iterable = (Iterable) mutableStateFlow.getValue();
                z = false;
                if (iterable instanceof Collection) {
                }
                it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                    }
                }
                if (z) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
