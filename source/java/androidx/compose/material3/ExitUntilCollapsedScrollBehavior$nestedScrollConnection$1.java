package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"androidx/compose/material3/ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitUntilCollapsedScrollBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior) {
        this.this$0 = exitUntilCollapsedScrollBehavior;
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo1159onPreScrollOzD1aCk(long available, int source) {
        if (!((Boolean) this.this$0.getCanScroll().invoke()).booleanValue() || Offset.m4594getYimpl(available) > 0.0f) {
            return Offset.INSTANCE.m4609getZeroF1C5BW0();
        }
        float heightOffset = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m4594getYimpl(available));
        if (!(heightOffset == this.this$0.getState().getHeightOffset())) {
            return Offset.m4587copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
        }
        return Offset.INSTANCE.m4609getZeroF1C5BW0();
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo777onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!((Boolean) this.this$0.getCanScroll().invoke()).booleanValue()) {
            return Offset.INSTANCE.m4609getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        state.setContentOffset(state.getContentOffset() + Offset.m4594getYimpl(consumed));
        if (Offset.m4594getYimpl(available) < 0.0f || Offset.m4594getYimpl(consumed) < 0.0f) {
            float heightOffset = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m4594getYimpl(consumed));
            return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - heightOffset);
        }
        if ((Offset.m4594getYimpl(consumed) == 0.0f) && Offset.m4594getYimpl(available) > 0.0f) {
            this.this$0.getState().setContentOffset(0.0f);
        }
        if (Offset.m4594getYimpl(available) > 0.0f) {
            float heightOffset2 = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m4594getYimpl(available));
            return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - heightOffset2);
        }
        return Offset.INSTANCE.m4609getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo776onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        C0626x78ae0263 c0626x78ae0263;
        Object obj;
        Object coroutine_suspended;
        int i;
        ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1;
        long j3;
        if (continuation instanceof C0626x78ae0263) {
            c0626x78ae0263 = (C0626x78ae0263) continuation;
            if ((c0626x78ae0263.label & Integer.MIN_VALUE) != 0) {
                c0626x78ae0263.label -= Integer.MIN_VALUE;
                obj = c0626x78ae0263.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0626x78ae0263.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    c0626x78ae0263.L$0 = this;
                    c0626x78ae0263.J$0 = j2;
                    c0626x78ae0263.label = 1;
                    obj = super.mo776onPostFlingRZ2iAVY(j, j2, c0626x78ae0263);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    exitUntilCollapsedScrollBehavior$nestedScrollConnection$1 = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j3 = c0626x78ae0263.J$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.box-impl(Velocity.plus-AH228Gc(j3, ((Velocity) obj).unbox-impl()));
                    }
                    j2 = c0626x78ae0263.J$0;
                    exitUntilCollapsedScrollBehavior$nestedScrollConnection$1 = (ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1) c0626x78ae0263.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                long j4 = ((Velocity) obj).unbox-impl();
                TopAppBarState state = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getState();
                float f = Velocity.getY-impl(j2);
                DecayAnimationSpec<Float> flingAnimationSpec = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
                AnimationSpec<Float> snapAnimationSpec = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
                c0626x78ae0263.L$0 = null;
                c0626x78ae0263.J$0 = j4;
                c0626x78ae0263.label = 2;
                obj = AppBarKt.settleAppBar(state, f, flingAnimationSpec, snapAnimationSpec, c0626x78ae0263);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = j4;
                return Velocity.box-impl(Velocity.plus-AH228Gc(j3, ((Velocity) obj).unbox-impl()));
            }
        }
        c0626x78ae0263 = new C0626x78ae0263(this, continuation);
        obj = c0626x78ae0263.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0626x78ae0263.label;
        if (i != 0) {
        }
        long j42 = ((Velocity) obj).unbox-impl();
        TopAppBarState state2 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getState();
        float f2 = Velocity.getY-impl(j2);
        DecayAnimationSpec<Float> flingAnimationSpec2 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec2 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
        c0626x78ae0263.L$0 = null;
        c0626x78ae0263.J$0 = j42;
        c0626x78ae0263.label = 2;
        obj = AppBarKt.settleAppBar(state2, f2, flingAnimationSpec2, snapAnimationSpec2, c0626x78ae0263);
        if (obj != coroutine_suspended) {
        }
    }
}
