package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Worker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.Worker$run$1$1$1$1", f = "Worker.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class Worker$run$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalLazy<JSONObject> $header;
    final /* synthetic */ GroupInterface $it;
    final /* synthetic */ long $runTimeSecs;
    int label;
    final /* synthetic */ Worker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Worker$run$1$1$1$1(Worker worker, GroupInterface groupInterface, LocalLazy<JSONObject> localLazy, long j, Continuation<? super Worker$run$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = worker;
        this.$it = groupInterface;
        this.$header = localLazy;
        this.$runTimeSecs = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Worker$run$1$1$1$1(this.this$0, this.$it, this.$header, this.$runTimeSecs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object runGroup;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            runGroup = this.this$0.runGroup(this.$it, this.$header, this.$runTimeSecs, (Continuation) this);
            if (runGroup == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
