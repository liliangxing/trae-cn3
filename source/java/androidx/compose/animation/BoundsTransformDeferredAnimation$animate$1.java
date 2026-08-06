package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.p002ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimateBoundsModifier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1", f = "AnimateBoundsModifier.kt", i = {}, l = {425}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BoundsTransformDeferredAnimation$animate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Rect, AnimationVector4D> $anim;
    final /* synthetic */ BoundsTransform $boundsTransform;
    final /* synthetic */ Rect $target;
    int label;
    final /* synthetic */ BoundsTransformDeferredAnimation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoundsTransformDeferredAnimation$animate$1(Animatable<Rect, AnimationVector4D> animatable, Rect rect, BoundsTransform boundsTransform, BoundsTransformDeferredAnimation boundsTransformDeferredAnimation, Continuation<? super BoundsTransformDeferredAnimation$animate$1> continuation) {
        super(2, continuation);
        this.$anim = animatable;
        this.$target = rect;
        this.$boundsTransform = boundsTransform;
        this.this$0 = boundsTransformDeferredAnimation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoundsTransformDeferredAnimation$animate$1(this.$anim, this.$target, this.$boundsTransform, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Rect, AnimationVector4D> animatable = this.$anim;
            Rect rect = this.$target;
            BoundsTransform boundsTransform = this.$boundsTransform;
            Rect currentBounds = this.this$0.getCurrentBounds();
            Intrinsics.checkNotNull(currentBounds);
            this.label = 1;
            if (Animatable.animateTo$default(animatable, rect, boundsTransform.transform(currentBounds, this.$target), null, null, (Continuation) this, 12, null) == coroutine_suspended) {
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
