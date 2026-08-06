package com.bytedance.applog.priority.original;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* compiled from: Worker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.Worker$run$1", f = "Worker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class Worker$run$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ LocalLazy<JSONObject> $header;
    final /* synthetic */ long $runTimeSecs;
    final /* synthetic */ List<GroupInterface> $runs;
    int label;
    final /* synthetic */ Worker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Worker$run$1(Worker worker, List<? extends GroupInterface> list, LocalLazy<JSONObject> localLazy, long j, Continuation<? super Worker$run$1> continuation) {
        super(2, continuation);
        this.this$0 = worker;
        this.$runs = list;
        this.$header = localLazy;
        this.$runTimeSecs = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Worker$run$1(this.this$0, this.$runs, this.$header, this.$runTimeSecs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Worker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applog.priority.original.Worker$run$1$1", f = "Worker.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.applog.priority.original.Worker$run$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class C04711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LocalLazy<JSONObject> $header;
        final /* synthetic */ long $runTimeSecs;
        final /* synthetic */ List<GroupInterface> $runs;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Worker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04711(List<? extends GroupInterface> list, Worker worker, LocalLazy<JSONObject> localLazy, long j, Continuation<? super C04711> continuation) {
            super(2, continuation);
            this.$runs = list;
            this.this$0 = worker;
            this.$header = localLazy;
            this.$runTimeSecs = j;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c04711 = new C04711(this.$runs, this.this$0, this.$header, this.$runTimeSecs, continuation);
            c04711.L$0 = obj;
            return c04711;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                List<GroupInterface> list = this.$runs;
                Worker worker = this.this$0;
                LocalLazy<JSONObject> localLazy = this.$header;
                long j = this.$runTimeSecs;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Worker$run$1$1$1$1(worker, (GroupInterface) it.next(), localLazy, j, null), 3, (Object) null));
                    arrayList = arrayList2;
                }
                this.label = 1;
                if (AwaitKt.awaitAll(arrayList, (Continuation) this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        coroutineScope = this.this$0.getCoroutineScope();
        return BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C04711(this.$runs, this.this$0, this.$header, this.$runTimeSecs, null), 3, (Object) null);
    }
}
