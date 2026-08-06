package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.p002ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformableState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateBy$3", f = "TransformableState.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TransformableStateKt$animateBy$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DelegatingAnimationSpec $animationSpec;
    final /* synthetic */ Ref.ObjectRef<AnimationData> $previousState;
    final /* synthetic */ AnimationData $targetState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$animateBy$3(Ref.ObjectRef<AnimationData> objectRef, AnimationData animationData, DelegatingAnimationSpec delegatingAnimationSpec, Continuation<? super TransformableStateKt$animateBy$3> continuation) {
        super(2, continuation);
        this.$previousState = objectRef;
        this.$targetState = animationData;
        this.$animationSpec = delegatingAnimationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> transformableStateKt$animateBy$3 = new TransformableStateKt$animateBy$3(this.$previousState, this.$targetState, this.$animationSpec, continuation);
        transformableStateKt$animateBy$3.L$0 = obj;
        return transformableStateKt$animateBy$3;
    }

    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
        return create(transformScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AnimationData animationData;
        AnimationState AnimationState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final TransformScope transformScope = (TransformScope) this.L$0;
            AnimationDataConverter animationDataConverter = AnimationDataConverter.INSTANCE;
            Object obj2 = this.$previousState.element;
            animationData = TransformableStateKt.ZeroAnimationVelocity;
            AnimationState = AnimationStateKt.AnimationState(animationDataConverter, obj2, animationData, (r19 & 8) != 0 ? Long.MIN_VALUE : 0L, (r19 & 16) != 0 ? Long.MIN_VALUE : 0L, (r19 & 32) != 0 ? false : false);
            AnimationData animationData2 = this.$targetState;
            DelegatingAnimationSpec delegatingAnimationSpec = this.$animationSpec;
            final Ref.ObjectRef<AnimationData> objectRef = this.$previousState;
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(AnimationState, animationData2, delegatingAnimationSpec, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animateBy$3$$ExternalSyntheticLambda0
                public final Object invoke(Object obj3) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = TransformableStateKt$animateBy$3.invokeSuspend$lambda$0(objectRef, transformScope, (AnimationScope) obj3);
                    return invokeSuspend$lambda$0;
                }
            }, (Continuation) this, 4, null) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Ref.ObjectRef objectRef, TransformScope transformScope, AnimationScope animationScope) {
        transformScope.mo657transformByd4ec7I((((AnimationData) objectRef.element).getZoom() > 0.0f ? 1 : (((AnimationData) objectRef.element).getZoom() == 0.0f ? 0 : -1)) == 0 ? 1.0f : ((AnimationData) animationScope.getValue()).getZoom() / ((AnimationData) objectRef.element).getZoom(), Offset.m4597minusMKHz9U(((AnimationData) animationScope.getValue()).m640getOffsetF1C5BW0(), ((AnimationData) objectRef.element).m640getOffsetF1C5BW0()), ((AnimationData) animationScope.getValue()).getDegrees() - ((AnimationData) objectRef.element).getDegrees());
        objectRef.element = animationScope.getValue();
        return Unit.INSTANCE;
    }
}
