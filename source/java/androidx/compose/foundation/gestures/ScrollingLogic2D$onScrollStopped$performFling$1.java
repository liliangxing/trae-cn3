package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable2D.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$onScrollStopped$performFling$1", f = "Scrollable2D.kt", i = {0, 1, 1, 2, 2}, l = {379, 382, 385}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ScrollingLogic2D$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic2D$onScrollStopped$performFling$1(ScrollingLogic2D scrollingLogic2D, Continuation<? super ScrollingLogic2D$onScrollStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic2D;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> scrollingLogic2D$onScrollStopped$performFling$1 = new ScrollingLogic2D$onScrollStopped$performFling$1(this.this$0, continuation);
        scrollingLogic2D$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).unbox-impl();
        return scrollingLogic2D$onScrollStopped$performFling$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m805invokesFctU(((Velocity) obj).unbox-impl(), (Continuation) obj2);
    }

    /* renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m805invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return create(Velocity.box-impl(j), continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0097 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NestedScrollDispatcher nestedScrollDispatcher;
        Object m6012dispatchPreFlingQWom1Mo;
        long j;
        long j2;
        Object mo761doFlingAnimationQWom1Mo;
        NestedScrollDispatcher nestedScrollDispatcher2;
        long j3;
        Object m6010dispatchPostFlingRZ2iAVY;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j4 = this.J$0;
            nestedScrollDispatcher = this.this$0.nestedScrollDispatcher;
            this.J$0 = j4;
            this.label = 1;
            m6012dispatchPreFlingQWom1Mo = nestedScrollDispatcher.m6012dispatchPreFlingQWom1Mo(j4, (Continuation) this);
            if (m6012dispatchPreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = j4;
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j5 = this.J$1;
                    long j6 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                    j = j6;
                    j3 = j5;
                    m6010dispatchPostFlingRZ2iAVY = obj;
                    return Velocity.box-impl(Velocity.minus-AH228Gc(j, Velocity.minus-AH228Gc(j3, ((Velocity) m6010dispatchPostFlingRZ2iAVY).unbox-impl())));
                }
                long j7 = this.J$1;
                long j8 = this.J$0;
                ResultKt.throwOnFailure(obj);
                mo761doFlingAnimationQWom1Mo = obj;
                j = j8;
                j2 = j7;
                long j9 = ((Velocity) mo761doFlingAnimationQWom1Mo).unbox-impl();
                nestedScrollDispatcher2 = this.this$0.nestedScrollDispatcher;
                this.J$0 = j;
                this.J$1 = j9;
                this.label = 3;
                j3 = j9;
                m6010dispatchPostFlingRZ2iAVY = nestedScrollDispatcher2.m6010dispatchPostFlingRZ2iAVY(Velocity.minus-AH228Gc(j2, j9), j9, (Continuation) this);
                if (m6010dispatchPostFlingRZ2iAVY == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Velocity.box-impl(Velocity.minus-AH228Gc(j, Velocity.minus-AH228Gc(j3, ((Velocity) m6010dispatchPostFlingRZ2iAVY).unbox-impl())));
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            m6012dispatchPreFlingQWom1Mo = obj;
        }
        j2 = Velocity.minus-AH228Gc(j, ((Velocity) m6012dispatchPreFlingQWom1Mo).unbox-impl());
        this.J$0 = j;
        this.J$1 = j2;
        this.label = 2;
        mo761doFlingAnimationQWom1Mo = this.this$0.mo761doFlingAnimationQWom1Mo(j2, (Continuation) this);
        if (mo761doFlingAnimationQWom1Mo == coroutine_suspended) {
            return coroutine_suspended;
        }
        long j92 = ((Velocity) mo761doFlingAnimationQWom1Mo).unbox-impl();
        nestedScrollDispatcher2 = this.this$0.nestedScrollDispatcher;
        this.J$0 = j;
        this.J$1 = j92;
        this.label = 3;
        j3 = j92;
        m6010dispatchPostFlingRZ2iAVY = nestedScrollDispatcher2.m6010dispatchPostFlingRZ2iAVY(Velocity.minus-AH228Gc(j2, j92), j92, (Continuation) this);
        if (m6010dispatchPostFlingRZ2iAVY == coroutine_suspended) {
        }
        return Velocity.box-impl(Velocity.minus-AH228Gc(j, Velocity.minus-AH228Gc(j3, ((Velocity) m6010dispatchPostFlingRZ2iAVY).unbox-impl())));
    }
}
