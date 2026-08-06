package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {1054, 1074, 1075}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x00ce -> B:17:0x00d0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job launch$default;
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2;
        CoroutineScope coroutineScope;
        ProduceFrameSignal produceFrameSignal;
        boolean shouldKeepRecomposing;
        Object awaitWorkAvailable;
        MutableScatterSet mutableScatterSet;
        boolean hasConcurrentFrameWorkLocked;
        Continuation<Unit> requestFrameLocked;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 0;
        int i4 = 1;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) this.L$1;
            boolean z = this.$recomposeCoroutineContext.get(Job.Key) == null;
            CoroutineContext coroutineContext = this.$recomposeCoroutineContext;
            if (!z) {
                PreconditionsKt.throwIllegalArgumentException("recomposeCoroutineContext may not contain a Job; found " + coroutineContext.get(Job.Key));
            }
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineScope2.getCoroutineContext().plus(this.$recomposeCoroutineContext).plus(JobKt.Job(JobKt.getJob(coroutineScope2.getCoroutineContext()))));
            ProduceFrameSignal produceFrameSignal2 = new ProduceFrameSignal();
            launch$default = BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(this.this$0, monotonicFrameClock, produceFrameSignal2, null), 3, (Object) null);
            recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = this;
            coroutineScope = CoroutineScope;
            produceFrameSignal = produceFrameSignal2;
            shouldKeepRecomposing = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.getShouldKeepRecomposing();
            if (shouldKeepRecomposing) {
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                launch$default = (Job) this.L$0;
                ResultKt.throwOnFailure(obj);
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = this;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = null;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = 3;
                if (JobKt.cancelAndJoin(launch$default, (Continuation) recomposer$runRecomposeConcurrentlyAndApplyChanges$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            launch$default = (Job) this.L$2;
            produceFrameSignal = (ProduceFrameSignal) this.L$1;
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$22 = this;
            CoroutineScope coroutineScope4 = coroutineScope3;
            Recomposer recomposer = recomposer$runRecomposeConcurrentlyAndApplyChanges$22.this$0;
            synchronized (recomposer.stateLock) {
                mutableScatterSet = recomposer.snapshotInvalidations;
                if (mutableScatterSet.isNotEmpty()) {
                    recomposer.snapshotInvalidations = new MutableScatterSet(i3, i4, null);
                }
            }
            Set<? extends Object> wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
            if (((wrapIntoSet.isEmpty() ? 1 : 0) ^ i4) != 0) {
                List knownCompositionsLocked = recomposer.knownCompositionsLocked();
                int size = knownCompositionsLocked.size();
                for (int i5 = i3; i5 < size; i5++) {
                    ((ControlledComposition) knownCompositionsLocked.get(i5)).recordModificationsOf(wrapIntoSet);
                }
            }
            MutableVector mutableVector = recomposer.compositionInvalidations;
            T[] tArr = mutableVector.content;
            int size2 = mutableVector.getSize();
            int i6 = 0;
            ControlledComposition[] controlledCompositionArr = tArr;
            while (i6 < size2) {
                ControlledComposition controlledComposition = controlledCompositionArr[i6];
                synchronized (recomposer.stateLock) {
                    i = recomposer.concurrentCompositionsOutstanding;
                    recomposer.concurrentCompositionsOutstanding = i + 1;
                }
                BuildersKt.launch$default(coroutineScope4, CompositionKt.getRecomposeCoroutineContext(controlledComposition), (CoroutineStart) null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(recomposer, controlledComposition, null), 2, (Object) null);
                i6++;
                controlledCompositionArr = controlledCompositionArr;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$22 = recomposer$runRecomposeConcurrentlyAndApplyChanges$22;
                recomposer = recomposer;
            }
            Recomposer recomposer2 = recomposer;
            Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$23 = recomposer$runRecomposeConcurrentlyAndApplyChanges$22;
            recomposer2.compositionInvalidations.clear();
            synchronized (recomposer2.stateLock) {
                if (recomposer2.deriveStateLocked() != null) {
                    throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                }
                Unit unit = Unit.INSTANCE;
            }
            Object obj2 = recomposer$runRecomposeConcurrentlyAndApplyChanges$23.this$0.stateLock;
            Recomposer recomposer3 = recomposer$runRecomposeConcurrentlyAndApplyChanges$23.this$0;
            synchronized (obj2) {
                hasConcurrentFrameWorkLocked = recomposer3.getHasConcurrentFrameWorkLocked();
                requestFrameLocked = hasConcurrentFrameWorkLocked ? produceFrameSignal.requestFrameLocked() : null;
            }
            if (requestFrameLocked != null) {
                Result.Companion companion = Result.Companion;
                requestFrameLocked.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
            recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = recomposer$runRecomposeConcurrentlyAndApplyChanges$23;
            coroutineScope = coroutineScope4;
            i3 = 0;
            i4 = 1;
            shouldKeepRecomposing = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.getShouldKeepRecomposing();
            if (shouldKeepRecomposing) {
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = launch$default;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = null;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$2 = null;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = 2;
                if (JobKt.cancelAndJoin(JobKt.getJob(coroutineScope.getCoroutineContext()), (Continuation) recomposer$runRecomposeConcurrentlyAndApplyChanges$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = null;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = 3;
                if (JobKt.cancelAndJoin(launch$default, (Continuation) recomposer$runRecomposeConcurrentlyAndApplyChanges$2) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
            recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = produceFrameSignal;
            recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$2 = launch$default;
            recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = i4;
            awaitWorkAvailable = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.awaitWorkAvailable((Continuation) recomposer$runRecomposeConcurrentlyAndApplyChanges$2);
            if (awaitWorkAvailable == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope4 = coroutineScope;
            recomposer$runRecomposeConcurrentlyAndApplyChanges$22 = recomposer$runRecomposeConcurrentlyAndApplyChanges$2;
            Recomposer recomposer4 = recomposer$runRecomposeConcurrentlyAndApplyChanges$22.this$0;
            synchronized (recomposer4.stateLock) {
            }
        }
    }
}
