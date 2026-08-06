package coil3.compose.internal;

import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import coil3.size.Size;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;

/* compiled from: ConstraintsSizeResolver.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil3/compose/internal/OptimizedConstraintsSizeResolver;", "Lcoil3/compose/internal/ConstraintsSizeResolver;", "<init>", "()V", "latestConstraints", "Landroidx/compose/ui/unit/Constraints;", "J", "continuation", "Lkotlin/coroutines/Continuation;", "", "size", "Lcoil3/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "setConstraints", "setConstraints-BRTryo0", "(J)V", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class OptimizedConstraintsSizeResolver implements ConstraintsSizeResolver {
    public static final int $stable = 0;
    private Continuation<? super Unit> continuation;
    private long latestConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 5, null);

    /* JADX WARN: Removed duplicated region for block: B:11:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // coil3.size.SizeResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object size(Continuation<? super Size> continuation) {
        OptimizedConstraintsSizeResolver$size$1 optimizedConstraintsSizeResolver$size$1;
        int i;
        OptimizedConstraintsSizeResolver optimizedConstraintsSizeResolver;
        Continuation<? super Unit> continuation2;
        if (continuation instanceof OptimizedConstraintsSizeResolver$size$1) {
            optimizedConstraintsSizeResolver$size$1 = (OptimizedConstraintsSizeResolver$size$1) continuation;
            if ((optimizedConstraintsSizeResolver$size$1.label & Integer.MIN_VALUE) != 0) {
                optimizedConstraintsSizeResolver$size$1.label -= Integer.MIN_VALUE;
                Object obj = optimizedConstraintsSizeResolver$size$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = optimizedConstraintsSizeResolver$size$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Constraints.m2625isZeroimpl(this.latestConstraints)) {
                        Continuation<? super Unit> continuation3 = this.continuation;
                        optimizedConstraintsSizeResolver$size$1.L$0 = this;
                        optimizedConstraintsSizeResolver$size$1.L$1 = continuation3;
                        optimizedConstraintsSizeResolver$size$1.label = 1;
                        Continuation continuation4 = (Continuation) optimizedConstraintsSizeResolver$size$1;
                        Continuation<? super Unit> safeContinuation = new SafeContinuation<>(IntrinsicsKt.intercepted(continuation4));
                        this.continuation = safeContinuation;
                        Object orThrow = safeContinuation.getOrThrow();
                        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(continuation4);
                        }
                        if (orThrow == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        optimizedConstraintsSizeResolver = this;
                        continuation2 = continuation3;
                    } else {
                        optimizedConstraintsSizeResolver = this;
                        return UtilsKt.m3234toSizeBRTryo0(optimizedConstraintsSizeResolver.latestConstraints);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    continuation2 = (Continuation) optimizedConstraintsSizeResolver$size$1.L$1;
                    optimizedConstraintsSizeResolver = (OptimizedConstraintsSizeResolver) optimizedConstraintsSizeResolver$size$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (continuation2 != null) {
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                }
                return UtilsKt.m3234toSizeBRTryo0(optimizedConstraintsSizeResolver.latestConstraints);
            }
        }
        optimizedConstraintsSizeResolver$size$1 = new OptimizedConstraintsSizeResolver$size$1(this, continuation);
        Object obj2 = optimizedConstraintsSizeResolver$size$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = optimizedConstraintsSizeResolver$size$1.label;
        if (i != 0) {
        }
        if (continuation2 != null) {
        }
        return UtilsKt.m3234toSizeBRTryo0(optimizedConstraintsSizeResolver.latestConstraints);
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3222measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        mo3211setConstraintsBRTryo0(j);
        final Placeable placeable = measurable.measure-BRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1() { // from class: coil3.compose.internal.OptimizedConstraintsSizeResolver$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$1;
                measure_3p2s80s$lambda$1 = OptimizedConstraintsSizeResolver.measure_3p2s80s$lambda$1(placeable, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$1;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // coil3.compose.internal.ConstraintsSizeResolver
    /* renamed from: setConstraints-BRTryo0 */
    public void mo3211setConstraintsBRTryo0(long constraints) {
        this.latestConstraints = constraints;
        if (Constraints.m2625isZeroimpl(constraints)) {
            return;
        }
        Continuation<? super Unit> continuation = this.continuation;
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        this.continuation = null;
    }
}
