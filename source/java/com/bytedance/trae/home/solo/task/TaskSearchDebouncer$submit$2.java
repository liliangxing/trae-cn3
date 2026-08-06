package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskSearchDebouncer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskSearchDebouncer$submit$2", f = "TaskSearchDebouncer.kt", i = {}, l = {31, 32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskSearchDebouncer$submit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<String, Continuation<? super Unit>, Object> $onSearch;
    final /* synthetic */ String $trimmedQuery;
    int label;
    final /* synthetic */ TaskSearchDebouncer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TaskSearchDebouncer$submit$2(TaskSearchDebouncer taskSearchDebouncer, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function2, String str, Continuation<? super TaskSearchDebouncer$submit$2> continuation) {
        super(2, continuation);
        this.this$0 = taskSearchDebouncer;
        this.$onSearch = function2;
        this.$trimmedQuery = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskSearchDebouncer$submit$2(this.this$0, this.$onSearch, this.$trimmedQuery, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = this.this$0.debounceMs;
            this.label = 1;
            if (DelayKt.delay(j, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        Function2<String, Continuation<? super Unit>, Object> function2 = this.$onSearch;
        String str = this.$trimmedQuery;
        this.label = 2;
        if (function2.invoke(str, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
