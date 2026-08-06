package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
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
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MouseWheelScrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3", f = "MouseWheelScrollable.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {253, 266, 283}, m = "invokeSuspend", n = {"$this$userScroll", "requiredAnimation", "$this$userScroll", "requiredAnimation", "durationMillis", "$this$userScroll", "requiredAnimation"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> $animationState;
    final /* synthetic */ float $speed;
    final /* synthetic */ Ref.ObjectRef<MouseWheelScrollingLogic.MouseWheelScrollDelta> $targetScrollDelta;
    final /* synthetic */ Ref.FloatRef $targetValue;
    final /* synthetic */ ScrollingLogic $this_dispatchMouseWheelScroll;
    final /* synthetic */ float $threshold;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MouseWheelScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(Ref.FloatRef floatRef, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef, Ref.ObjectRef<MouseWheelScrollingLogic.MouseWheelScrollDelta> objectRef2, float f, MouseWheelScrollingLogic mouseWheelScrollingLogic, float f2, ScrollingLogic scrollingLogic, Continuation<? super MouseWheelScrollingLogic$dispatchMouseWheelScroll$3> continuation) {
        super(2, continuation);
        this.$targetValue = floatRef;
        this.$animationState = objectRef;
        this.$targetScrollDelta = objectRef2;
        this.$threshold = f;
        this.this$0 = mouseWheelScrollingLogic;
        this.$speed = f2;
        this.$this_dispatchMouseWheelScroll = scrollingLogic;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> mouseWheelScrollingLogic$dispatchMouseWheelScroll$3 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(this.$targetValue, this.$animationState, this.$targetScrollDelta, this.$threshold, this.this$0, this.$speed, this.$this_dispatchMouseWheelScroll, continuation);
        mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$0 = obj;
        return mouseWheelScrollingLogic$dispatchMouseWheelScroll$3;
    }

    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return create(nestedScrollScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0140  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x013e -> B:8:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x016c -> B:7:0x016d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 mouseWheelScrollingLogic$dispatchMouseWheelScroll$3;
        NestedScrollScope nestedScrollScope;
        Ref.BooleanRef booleanRef;
        int i;
        Object dispatchMouseWheelScroll$waitNextScrollDelta;
        Ref.BooleanRef booleanRef2;
        Object dispatchMouseWheelScroll$waitNextScrollDelta2;
        Object animateMouseWheelScroll;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 2;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            NestedScrollScope nestedScrollScope2 = (NestedScrollScope) this.L$0;
            Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
            booleanRef3.element = true;
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$3 = this;
            nestedScrollScope = nestedScrollScope2;
            booleanRef = booleanRef3;
        } else if (i2 == 1) {
            Ref.BooleanRef booleanRef4 = (Ref.BooleanRef) this.L$2;
            Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) this.L$1;
            NestedScrollScope nestedScrollScope3 = (NestedScrollScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$3 = this;
            nestedScrollScope = nestedScrollScope3;
            booleanRef4.element = ((Boolean) obj).booleanValue();
            booleanRef = booleanRef5;
            i3 = 2;
        } else if (i2 == 2) {
            int i4 = this.I$0;
            Ref.BooleanRef booleanRef6 = (Ref.BooleanRef) this.L$1;
            NestedScrollScope nestedScrollScope4 = (NestedScrollScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$3 = this;
            i = i4;
            booleanRef = booleanRef6;
            nestedScrollScope = nestedScrollScope4;
            if (!booleanRef.element) {
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$0 = nestedScrollScope;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$1 = booleanRef;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$2 = booleanRef;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.label = 3;
                dispatchMouseWheelScroll$waitNextScrollDelta = MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.this$0, mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetScrollDelta, mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetValue, mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$this_dispatchMouseWheelScroll, mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$animationState, 50 - i, (Continuation) mouseWheelScrollingLogic$dispatchMouseWheelScroll$3);
                if (dispatchMouseWheelScroll$waitNextScrollDelta == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef2 = booleanRef;
                booleanRef.element = ((Boolean) dispatchMouseWheelScroll$waitNextScrollDelta).booleanValue();
                booleanRef = booleanRef2;
                i3 = 2;
            }
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef = (Ref.BooleanRef) this.L$2;
            booleanRef2 = (Ref.BooleanRef) this.L$1;
            NestedScrollScope nestedScrollScope5 = (NestedScrollScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            dispatchMouseWheelScroll$waitNextScrollDelta = obj;
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$3 = this;
            nestedScrollScope = nestedScrollScope5;
            booleanRef.element = ((Boolean) dispatchMouseWheelScroll$waitNextScrollDelta).booleanValue();
            booleanRef = booleanRef2;
            i3 = 2;
        }
        while (booleanRef.element) {
            booleanRef.element = false;
            float floatValue = mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetValue.element - ((Number) ((AnimationState) mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$animationState.element).getValue()).floatValue();
            if (((MouseWheelScrollingLogic.MouseWheelScrollDelta) mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetScrollDelta.element).getShouldApplyImmediately() || Math.abs(floatValue) < mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$threshold) {
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.this$0.dispatchMouseWheelScroll(nestedScrollScope, floatValue);
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$0 = nestedScrollScope;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$1 = booleanRef;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$2 = booleanRef;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.label = 1;
                dispatchMouseWheelScroll$waitNextScrollDelta2 = MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.this$0, mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetScrollDelta, mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetValue, mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$this_dispatchMouseWheelScroll, mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$animationState, 50L, (Continuation) mouseWheelScrollingLogic$dispatchMouseWheelScroll$3);
                if (dispatchMouseWheelScroll$waitNextScrollDelta2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.BooleanRef booleanRef7 = booleanRef;
                booleanRef.element = ((Boolean) dispatchMouseWheelScroll$waitNextScrollDelta2).booleanValue();
                booleanRef = booleanRef7;
                i3 = 2;
            } else {
                float signum = Math.signum(floatValue) * mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$threshold;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.this$0.dispatchMouseWheelScroll(nestedScrollScope, signum);
                Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef = mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$animationState;
                objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, ((Number) ((AnimationState) mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$animationState.element).getValue()).floatValue() + signum, 0.0f, 0L, 0L, false, 30, (Object) null);
                i = RangesKt.coerceAtMost(MathKt.roundToInt(Math.abs(mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetValue.element - ((Number) ((AnimationState) mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$animationState.element).getValue()).floatValue()) / mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$speed), 100);
                MouseWheelScrollingLogic mouseWheelScrollingLogic = mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.this$0;
                AnimationState animationState = (AnimationState) mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$animationState.element;
                float f = mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetValue.element;
                final MouseWheelScrollingLogic mouseWheelScrollingLogic2 = mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.this$0;
                final Ref.ObjectRef<MouseWheelScrollingLogic.MouseWheelScrollDelta> objectRef2 = mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetScrollDelta;
                final Ref.FloatRef floatRef = mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$targetValue;
                final ScrollingLogic scrollingLogic = mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.$this_dispatchMouseWheelScroll;
                final Ref.BooleanRef booleanRef8 = booleanRef;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$0 = nestedScrollScope;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$1 = booleanRef;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$2 = null;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.I$0 = i;
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.label = i3;
                animateMouseWheelScroll = mouseWheelScrollingLogic.animateMouseWheelScroll(nestedScrollScope, animationState, f, i, new Function1() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        boolean invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = MouseWheelScrollingLogic$dispatchMouseWheelScroll$3.invokeSuspend$lambda$0(MouseWheelScrollingLogic.this, objectRef2, floatRef, scrollingLogic, booleanRef8, ((Float) obj2).floatValue());
                        return Boolean.valueOf(invokeSuspend$lambda$0);
                    }
                }, (Continuation) mouseWheelScrollingLogic$dispatchMouseWheelScroll$3);
                if (animateMouseWheelScroll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (!booleanRef.element) {
                }
                while (booleanRef.element) {
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(MouseWheelScrollingLogic mouseWheelScrollingLogic, Ref.ObjectRef objectRef, Ref.FloatRef floatRef, ScrollingLogic scrollingLogic, Ref.BooleanRef booleanRef, float f) {
        Channel channel;
        MouseWheelScrollingLogic.MouseWheelScrollDelta sumOrNull;
        boolean isLowScrollingDelta;
        channel = mouseWheelScrollingLogic.channel;
        sumOrNull = mouseWheelScrollingLogic.sumOrNull(channel);
        if (sumOrNull != null) {
            mouseWheelScrollingLogic.trackVelocity(sumOrNull);
            objectRef.element = ((MouseWheelScrollingLogic.MouseWheelScrollDelta) objectRef.element).plus(sumOrNull);
            floatRef.element = scrollingLogic.m793toFloatk4lQ0M(scrollingLogic.m791reverseIfNeededMKHz9U(((MouseWheelScrollingLogic.MouseWheelScrollDelta) objectRef.element).m714getValueF1C5BW0()));
            isLowScrollingDelta = MouseWheelScrollableKt.isLowScrollingDelta(floatRef.element - f);
            booleanRef.element = !isLowScrollingDelta;
        }
        return sumOrNull != null;
    }
}
