package coil3.compose.internal;

import androidx.compose.p001ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ConstraintsSizeResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.internal.LegacyConstraintsSizeResolver$size$2", f = "ConstraintsSizeResolver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class LegacyConstraintsSizeResolver$size$2 extends SuspendLambda implements Function2<Constraints, Continuation<? super Boolean>, Object> {
    /* synthetic */ long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LegacyConstraintsSizeResolver$size$2(Continuation<? super LegacyConstraintsSizeResolver$size$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> legacyConstraintsSizeResolver$size$2 = new LegacyConstraintsSizeResolver$size$2(continuation);
        legacyConstraintsSizeResolver$size$2.J$0 = ((Constraints) obj).getValue();
        return legacyConstraintsSizeResolver$size$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m3216invokeK40F9xA(((Constraints) obj).getValue(), (Continuation) obj2);
    }

    /* renamed from: invoke-K40F9xA, reason: not valid java name */
    public final Object m3216invokeK40F9xA(long j, Continuation<? super Boolean> continuation) {
        return create(Constraints.m2608boximpl(j), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(!Constraints.m2625isZeroimpl(this.J$0));
    }
}
