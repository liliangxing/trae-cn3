package coil3.compose.internal;

import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import coil3.size.Size;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: ConstraintsSizeResolver.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ#\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcoil3/compose/internal/LegacyConstraintsSizeResolver;", "Lcoil3/compose/internal/ConstraintsSizeResolver;", "<init>", "()V", "currentConstraints", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/compose/ui/unit/Constraints;", "size", "Lcoil3/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "setConstraints", "", "setConstraints-BRTryo0", "(J)V", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LegacyConstraintsSizeResolver implements ConstraintsSizeResolver {
    public static final int $stable = 0;
    private final MutableSharedFlow<Constraints> currentConstraints = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // coil3.size.SizeResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object size(Continuation<? super Size> continuation) {
        LegacyConstraintsSizeResolver$size$1 legacyConstraintsSizeResolver$size$1;
        int i;
        if (continuation instanceof LegacyConstraintsSizeResolver$size$1) {
            legacyConstraintsSizeResolver$size$1 = (LegacyConstraintsSizeResolver$size$1) continuation;
            if ((legacyConstraintsSizeResolver$size$1.label & Integer.MIN_VALUE) != 0) {
                legacyConstraintsSizeResolver$size$1.label -= Integer.MIN_VALUE;
                Object obj = legacyConstraintsSizeResolver$size$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = legacyConstraintsSizeResolver$size$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flow = this.currentConstraints;
                    LegacyConstraintsSizeResolver$size$2 legacyConstraintsSizeResolver$size$2 = new LegacyConstraintsSizeResolver$size$2(null);
                    legacyConstraintsSizeResolver$size$1.label = 1;
                    obj = FlowKt.first(flow, legacyConstraintsSizeResolver$size$2, legacyConstraintsSizeResolver$size$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return UtilsKt.m3234toSizeBRTryo0(((Constraints) obj).getValue());
            }
        }
        legacyConstraintsSizeResolver$size$1 = new LegacyConstraintsSizeResolver$size$1(this, continuation);
        Object obj2 = legacyConstraintsSizeResolver$size$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = legacyConstraintsSizeResolver$size$1.label;
        if (i != 0) {
        }
        return UtilsKt.m3234toSizeBRTryo0(((Constraints) obj2).getValue());
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3215measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        this.currentConstraints.tryEmit(Constraints.m2608boximpl(j));
        final Placeable placeable = measurable.measure-BRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1() { // from class: coil3.compose.internal.LegacyConstraintsSizeResolver$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = LegacyConstraintsSizeResolver.measure_3p2s80s$lambda$0(placeable, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // coil3.compose.internal.ConstraintsSizeResolver
    /* renamed from: setConstraints-BRTryo0 */
    public void mo3211setConstraintsBRTryo0(long constraints) {
        this.currentConstraints.tryEmit(Constraints.m2608boximpl(constraints));
    }
}
