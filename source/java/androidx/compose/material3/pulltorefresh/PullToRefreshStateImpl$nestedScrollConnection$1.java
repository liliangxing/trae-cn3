package androidx.compose.material3.pulltorefresh;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"androidx/compose/material3/pulltorefresh/PullToRefreshStateImpl$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PullToRefreshStateImpl$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ Function0<Boolean> $enabled;
    final /* synthetic */ PullToRefreshStateImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PullToRefreshStateImpl$nestedScrollConnection$1(Function0<Boolean> function0, PullToRefreshStateImpl pullToRefreshStateImpl) {
        this.$enabled = function0;
        this.this$0 = pullToRefreshStateImpl;
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo1159onPreScrollOzD1aCk(long available, int source) {
        if (!((Boolean) this.$enabled.invoke()).booleanValue()) {
            return Offset.INSTANCE.m4609getZeroF1C5BW0();
        }
        if (NestedScrollSource.m6020equalsimpl0(source, NestedScrollSource.INSTANCE.m6028getDragWNlRxjI()) && Offset.m4594getYimpl(available) < 0.0f) {
            return this.this$0.m3401consumeAvailableOffsetMKHz9U(available);
        }
        return Offset.INSTANCE.m4609getZeroF1C5BW0();
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo777onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!((Boolean) this.$enabled.invoke()).booleanValue()) {
            return Offset.INSTANCE.m4609getZeroF1C5BW0();
        }
        if (NestedScrollSource.m6020equalsimpl0(source, NestedScrollSource.INSTANCE.m6028getDragWNlRxjI()) && Offset.m4594getYimpl(available) > 0.0f) {
            return this.this$0.m3401consumeAvailableOffsetMKHz9U(available);
        }
        return Offset.INSTANCE.m4609getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1158onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1;
        int i;
        float f;
        if (continuation instanceof PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1) {
            pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 = (PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1) continuation;
            if ((pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                Object obj = pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    PullToRefreshStateImpl pullToRefreshStateImpl = this.this$0;
                    float f2 = Velocity.getY-impl(j);
                    pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.F$0 = 0.0f;
                    pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label = 1;
                    obj = pullToRefreshStateImpl.onRelease(f2, pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f = 0.0f;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f = pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.F$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Velocity.box-impl(VelocityKt.Velocity(f, ((Number) obj).floatValue()));
            }
        }
        pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 = new PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1(this, continuation);
        Object obj2 = pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1.label;
        if (i != 0) {
        }
        return Velocity.box-impl(VelocityKt.Velocity(f, ((Number) obj2).floatValue()));
    }
}
