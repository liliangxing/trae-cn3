package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p002ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollExtensions.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$4", f = "ScrollExtensions.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ScrollExtensionsKt$animateScrollBy$4 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Offset> $animationSpec;
    final /* synthetic */ Ref.LongRef $previousValue;
    final /* synthetic */ long $value;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollExtensionsKt$animateScrollBy$4(long j, AnimationSpec<Offset> animationSpec, Ref.LongRef longRef, Continuation<? super ScrollExtensionsKt$animateScrollBy$4> continuation) {
        super(2, continuation);
        this.$value = j;
        this.$animationSpec = animationSpec;
        this.$previousValue = longRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> scrollExtensionsKt$animateScrollBy$4 = new ScrollExtensionsKt$animateScrollBy$4(this.$value, this.$animationSpec, this.$previousValue, continuation);
        scrollExtensionsKt$animateScrollBy$4.L$0 = obj;
        return scrollExtensionsKt$animateScrollBy$4;
    }

    public final Object invoke(Scroll2DScope scroll2DScope, Continuation<? super Unit> continuation) {
        return create(scroll2DScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object animate;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Scroll2DScope scroll2DScope = (Scroll2DScope) this.L$0;
            TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.INSTANCE);
            Offset m4582boximpl = Offset.m4582boximpl(Offset.INSTANCE.m4609getZeroF1C5BW0());
            Offset m4582boximpl2 = Offset.m4582boximpl(this.$value);
            AnimationSpec<Offset> animationSpec = this.$animationSpec;
            final Ref.LongRef longRef = this.$previousValue;
            this.label = 1;
            animate = SuspendAnimationKt.animate(vectorConverter, m4582boximpl, m4582boximpl2, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : animationSpec, new Function2() { // from class: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$4$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2, Object obj3) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = ScrollExtensionsKt$animateScrollBy$4.invokeSuspend$lambda$0(longRef, scroll2DScope, (Offset) obj2, (Offset) obj3);
                    return invokeSuspend$lambda$0;
                }
            }, (Continuation) this);
            if (animate == coroutine_suspended) {
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
    public static final Unit invokeSuspend$lambda$0(Ref.LongRef longRef, Scroll2DScope scroll2DScope, Offset offset, Offset offset2) {
        longRef.element = Offset.m4598plusMKHz9U(longRef.element, scroll2DScope.mo656scrollByMKHz9U(Offset.m4597minusMKHz9U(offset.m4603unboximpl(), longRef.element)));
        return Unit.INSTANCE;
    }
}
