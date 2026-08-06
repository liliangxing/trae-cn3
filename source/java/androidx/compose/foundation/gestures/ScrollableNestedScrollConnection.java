package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollLogic;", "enabled", "", "<init>", "(Landroidx/compose/foundation/gestures/ScrollLogic;Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollLogic;", "getEnabled", "()Z", "setEnabled", "(Z)V", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private boolean enabled;
    private final ScrollLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollLogic scrollLogic, boolean z) {
        this.scrollingLogic = scrollLogic;
        this.enabled = z;
    }

    public final ScrollLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo777onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.enabled) {
            return this.scrollingLogic.mo762performRawScrollMKHz9U(available);
        }
        return Offset.INSTANCE.m4609getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo776onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        int i;
        long j3;
        long j4;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            if ((scrollableNestedScrollConnection$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label -= Integer.MIN_VALUE;
                Object obj = scrollableNestedScrollConnection$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = scrollableNestedScrollConnection$onPostFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.enabled) {
                        if (this.scrollingLogic.isFlinging()) {
                            j4 = Velocity.Companion.getZero-9UxMQ8M();
                            j3 = Velocity.minus-AH228Gc(j2, j4);
                            return Velocity.box-impl(j3);
                        }
                        ScrollLogic scrollLogic = this.scrollingLogic;
                        scrollableNestedScrollConnection$onPostFling$1.J$0 = j2;
                        scrollableNestedScrollConnection$onPostFling$1.label = 1;
                        obj = scrollLogic.mo761doFlingAnimationQWom1Mo(j2, scrollableNestedScrollConnection$onPostFling$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        j3 = Velocity.Companion.getZero-9UxMQ8M();
                        return Velocity.box-impl(j3);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j2 = scrollableNestedScrollConnection$onPostFling$1.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                j4 = ((Velocity) obj).unbox-impl();
                j3 = Velocity.minus-AH228Gc(j2, j4);
                return Velocity.box-impl(j3);
            }
        }
        scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
        Object obj2 = scrollableNestedScrollConnection$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = scrollableNestedScrollConnection$onPostFling$1.label;
        if (i != 0) {
        }
        j4 = ((Velocity) obj2).unbox-impl();
        j3 = Velocity.minus-AH228Gc(j2, j4);
        return Velocity.box-impl(j3);
    }
}
