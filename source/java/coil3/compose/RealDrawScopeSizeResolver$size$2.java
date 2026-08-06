package coil3.compose;

import androidx.compose.ui.geometry.Size;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: DrawScopeSizeResolver.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u001b\u0010\u0004\u001a\u0017\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/compose/ui/geometry/Size;", "it", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ParameterName;", StrategyConstants.NAME, StrategyConstants.VALUE}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.RealDrawScopeSizeResolver$size$2", f = "DrawScopeSizeResolver.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class RealDrawScopeSizeResolver$size$2 extends SuspendLambda implements Function3<FlowCollector<? super Size>, Flow<? extends Size>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealDrawScopeSizeResolver$size$2(Continuation<? super RealDrawScopeSizeResolver$size$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super Size> flowCollector, Flow<Size> flow, Continuation<? super Unit> continuation) {
        RealDrawScopeSizeResolver$size$2 realDrawScopeSizeResolver$size$2 = new RealDrawScopeSizeResolver$size$2(continuation);
        realDrawScopeSizeResolver$size$2.L$0 = flowCollector;
        realDrawScopeSizeResolver$size$2.L$1 = flow;
        return realDrawScopeSizeResolver$size$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 1;
            if (FlowKt.emitAll((FlowCollector) this.L$0, (Flow) this.L$1, (Continuation) this) == coroutine_suspended) {
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
