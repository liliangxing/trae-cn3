package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutItemAnimation.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", f = "LazyLayoutItemAnimation.kt", i = {0}, l = {141, 148}, m = "invokeSuspend", n = {"finalSpec"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutItemAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00af A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Animatable animatable;
        SpringSpec springSpec;
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec;
        Animatable animatable2;
        Animatable animatable3;
        SpringSpec springSpec2;
        Animatable animatable4;
        final long j;
        Animatable animatable5;
        final LazyLayoutItemAnimation lazyLayoutItemAnimation;
        Function0 function0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            animatable = this.this$0.placementDeltaAnimation;
            if (animatable.isRunning()) {
                FiniteAnimationSpec<IntOffset> finiteAnimationSpec2 = this.$spec;
                if (!(finiteAnimationSpec2 instanceof SpringSpec)) {
                    springSpec2 = LazyLayoutItemAnimationKt.InterruptionSpec;
                } else {
                    springSpec2 = (SpringSpec) finiteAnimationSpec2;
                }
                springSpec = springSpec2;
            } else {
                springSpec = this.$spec;
            }
            finiteAnimationSpec = springSpec;
            animatable2 = this.this$0.placementDeltaAnimation;
            if (!animatable2.isRunning()) {
                animatable3 = this.this$0.placementDeltaAnimation;
                this.L$0 = finiteAnimationSpec;
                this.label = 1;
                if (animatable3.snapTo(IntOffset.box-impl(this.$totalDelta), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            animatable4 = this.this$0.placementDeltaAnimation;
            j = IntOffset.minus-qkQi6aY(((IntOffset) animatable4.getValue()).unbox-impl(), this.$totalDelta);
            animatable5 = this.this$0.placementDeltaAnimation;
            lazyLayoutItemAnimation = this.this$0;
            this.L$0 = null;
            this.label = 2;
            if (Animatable.animateTo$default(animatable5, IntOffset.box-impl(j), finiteAnimationSpec, null, new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = LazyLayoutItemAnimation$animatePlacementDelta$1.invokeSuspend$lambda$0(LazyLayoutItemAnimation.this, j, (Animatable) obj2);
                    return invokeSuspend$lambda$0;
                }
            }, (Continuation) this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.this$0.setPlacementAnimationInProgress(false);
            this.this$0.isRunningMovingAwayAnimation = false;
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.setPlacementAnimationInProgress(false);
            this.this$0.isRunningMovingAwayAnimation = false;
            return Unit.INSTANCE;
        }
        finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
        ResultKt.throwOnFailure(obj);
        function0 = this.this$0.onLayerPropertyChanged;
        function0.invoke();
        animatable4 = this.this$0.placementDeltaAnimation;
        j = IntOffset.minus-qkQi6aY(((IntOffset) animatable4.getValue()).unbox-impl(), this.$totalDelta);
        animatable5 = this.this$0.placementDeltaAnimation;
        lazyLayoutItemAnimation = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (Animatable.animateTo$default(animatable5, IntOffset.box-impl(j), finiteAnimationSpec, null, new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                Unit invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = LazyLayoutItemAnimation$animatePlacementDelta$1.invokeSuspend$lambda$0(LazyLayoutItemAnimation.this, j, (Animatable) obj2);
                return invokeSuspend$lambda$0;
            }
        }, (Continuation) this, 4, null) == coroutine_suspended) {
        }
        this.this$0.setPlacementAnimationInProgress(false);
        this.this$0.isRunningMovingAwayAnimation = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(LazyLayoutItemAnimation lazyLayoutItemAnimation, long j, Animatable animatable) {
        Function0 function0;
        lazyLayoutItemAnimation.m1278setPlacementDeltagyyYBs(IntOffset.minus-qkQi6aY(((IntOffset) animatable.getValue()).unbox-impl(), j));
        function0 = lazyLayoutItemAnimation.onLayerPropertyChanged;
        function0.invoke();
        return Unit.INSTANCE;
    }
}
