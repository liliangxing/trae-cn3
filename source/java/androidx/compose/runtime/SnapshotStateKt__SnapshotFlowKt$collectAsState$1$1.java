package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: SnapshotFlow.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Landroidx/compose/runtime/ProduceStateScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1", f = "SnapshotFlow.kt", i = {}, l = {68, 69}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1<R> extends SuspendLambda implements Function2<ProduceStateScope<R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Flow<T> $this_collectAsState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1(CoroutineContext coroutineContext, Flow<? extends T> flow, Continuation<? super SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1> continuation) {
        super(2, continuation);
        this.$context = coroutineContext;
        this.$this_collectAsState = flow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> snapshotStateKt__SnapshotFlowKt$collectAsState$1$1 = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1<>(this.$context, this.$this_collectAsState, continuation);
        snapshotStateKt__SnapshotFlowKt$collectAsState$1$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$collectAsState$1$1;
    }

    public final Object invoke(ProduceStateScope<R> produceStateScope, Continuation<? super Unit> continuation) {
        return create(produceStateScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
            if (Intrinsics.areEqual(this.$context, EmptyCoroutineContext.INSTANCE)) {
                this.label = 1;
                if (this.$this_collectAsState.collect(new FlowCollector() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1.1
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        produceStateScope.setValue(t);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                if (BuildersKt.withContext(this.$context, new C07502(this.$this_collectAsState, produceStateScope, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1$2", f = "SnapshotFlow.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C07502 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProduceStateScope<R> $$this$produceState;
        final /* synthetic */ Flow<T> $this_collectAsState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07502(Flow<? extends T> flow, ProduceStateScope<R> produceStateScope, Continuation<? super C07502> continuation) {
            super(2, continuation);
            this.$this_collectAsState = flow;
            this.$$this$produceState = produceStateScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07502(this.$this_collectAsState, this.$$this$produceState, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<T> flow = this.$this_collectAsState;
                final ProduceStateScope<R> produceStateScope = this.$$this$produceState;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.collectAsState.1.1.2.1
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        produceStateScope.setValue(t);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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
}
