package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.p002ui.MotionDurationScale;
import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;

/* compiled from: UpdatableAnimationState.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006JJ\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00150\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0086@\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "lastFrameTime", "", "lastVelocity", "isRunning", "", "value", "getValue", "()F", "setValue", "(F)V", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class UpdatableAnimationState {

    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    private boolean isRunning;
    private long lastFrameTime = Long.MIN_VALUE;
    private AnimationVector1D lastVelocity = ZeroVector;
    private float value;
    private final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);

    public UpdatableAnimationState(AnimationSpec<Float> animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a7, code lost:
    
        if (1 != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007f, code lost:
    
        if (0 != 0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089 A[Catch: all -> 0x00ab, TryCatch #1 {all -> 0x00ab, blocks: (B:40:0x00ce, B:22:0x009d, B:15:0x007f, B:17:0x0089, B:33:0x00ad, B:37:0x00bb), top: B:21:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb A[Catch: all -> 0x00ab, TryCatch #1 {all -> 0x00ab, blocks: (B:40:0x00ce, B:22:0x009d, B:15:0x007f, B:17:0x0089, B:33:0x00ad, B:37:0x00bb), top: B:21:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToZero(Function1<? super Float, Unit> function1, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        UpdatableAnimationState$animateToZero$1 updatableAnimationState$animateToZero$1;
        int i;
        final UpdatableAnimationState updatableAnimationState;
        final float f;
        Function0<Unit> function02;
        final Function1<? super Float, Unit> function12;
        Function0<Unit> function03;
        if (continuation instanceof UpdatableAnimationState$animateToZero$1) {
            updatableAnimationState$animateToZero$1 = (UpdatableAnimationState$animateToZero$1) continuation;
            if ((updatableAnimationState$animateToZero$1.label & Integer.MIN_VALUE) != 0) {
                updatableAnimationState$animateToZero$1.label -= Integer.MIN_VALUE;
                Object obj = updatableAnimationState$animateToZero$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = updatableAnimationState$animateToZero$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!(!this.isRunning)) {
                        InlineClassHelperKt.throwIllegalStateException("animateToZero called while previous animation is running");
                    }
                    MotionDurationScale motionDurationScale = (MotionDurationScale) updatableAnimationState$animateToZero$1.getContext().get(MotionDurationScale.INSTANCE);
                    float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
                    this.isRunning = true;
                    updatableAnimationState = this;
                    function12 = function1;
                    f = scaleFactor;
                    function02 = function0;
                    if (!Companion.isZeroish(updatableAnimationState.value)) {
                    }
                    function03 = function02;
                    if (Math.abs(updatableAnimationState.value) == 0.0f) {
                    }
                    if (!z) {
                    }
                    updatableAnimationState.lastFrameTime = Long.MIN_VALUE;
                    updatableAnimationState.lastVelocity = ZeroVector;
                    updatableAnimationState.isRunning = false;
                    return Unit.INSTANCE;
                }
                try {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        function03 = (Function0) updatableAnimationState$animateToZero$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        updatableAnimationState = this;
                        function03.invoke();
                        updatableAnimationState.lastFrameTime = Long.MIN_VALUE;
                        updatableAnimationState.lastVelocity = ZeroVector;
                        updatableAnimationState.isRunning = false;
                        return Unit.INSTANCE;
                    }
                    f = updatableAnimationState$animateToZero$1.F$0;
                    Function0<Unit> function04 = (Function0) updatableAnimationState$animateToZero$1.L$1;
                    Function1<? super Float, Unit> function13 = (Function1) updatableAnimationState$animateToZero$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    function02 = function04;
                    function12 = function13;
                    updatableAnimationState = this;
                    try {
                        function02.invoke();
                        if (f != 0.0f) {
                        }
                        if (!Companion.isZeroish(updatableAnimationState.value)) {
                            Function1 function14 = new Function1() { // from class: androidx.compose.foundation.gestures.UpdatableAnimationState$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2) {
                                    Unit animateToZero$lambda$1;
                                    animateToZero$lambda$1 = UpdatableAnimationState.animateToZero$lambda$1(UpdatableAnimationState.this, f, function12, ((Long) obj2).longValue());
                                    return animateToZero$lambda$1;
                                }
                            };
                            updatableAnimationState$animateToZero$1.L$0 = function12;
                            updatableAnimationState$animateToZero$1.L$1 = function02;
                            updatableAnimationState$animateToZero$1.F$0 = f;
                            updatableAnimationState$animateToZero$1.label = 1;
                            if (MonotonicFrameClockKt.withFrameNanos(function14, updatableAnimationState$animateToZero$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function02.invoke();
                            if (f != 0.0f) {
                            }
                            if (!Companion.isZeroish(updatableAnimationState.value)) {
                            }
                        }
                        function03 = function02;
                        if (Math.abs(updatableAnimationState.value) == 0.0f) {
                            z = false;
                        }
                        if (!z) {
                            Function1 function15 = new Function1() { // from class: androidx.compose.foundation.gestures.UpdatableAnimationState$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj2) {
                                    Unit animateToZero$lambda$2;
                                    animateToZero$lambda$2 = UpdatableAnimationState.animateToZero$lambda$2(UpdatableAnimationState.this, function12, ((Long) obj2).longValue());
                                    return animateToZero$lambda$2;
                                }
                            };
                            updatableAnimationState$animateToZero$1.L$0 = function03;
                            updatableAnimationState$animateToZero$1.L$1 = null;
                            updatableAnimationState$animateToZero$1.label = 2;
                            if (MonotonicFrameClockKt.withFrameNanos(function15, updatableAnimationState$animateToZero$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function03.invoke();
                        }
                        updatableAnimationState.lastFrameTime = Long.MIN_VALUE;
                        updatableAnimationState.lastVelocity = ZeroVector;
                        updatableAnimationState.isRunning = false;
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        updatableAnimationState.lastFrameTime = Long.MIN_VALUE;
                        updatableAnimationState.lastVelocity = ZeroVector;
                        updatableAnimationState.isRunning = false;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    updatableAnimationState = this;
                    updatableAnimationState.lastFrameTime = Long.MIN_VALUE;
                    updatableAnimationState.lastVelocity = ZeroVector;
                    updatableAnimationState.isRunning = false;
                    throw th;
                }
            }
        }
        updatableAnimationState$animateToZero$1 = new UpdatableAnimationState$animateToZero$1(this, continuation);
        Object obj2 = updatableAnimationState$animateToZero$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updatableAnimationState$animateToZero$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateToZero$lambda$1(UpdatableAnimationState updatableAnimationState, float f, Function1 function1, long j) {
        long roundToLong;
        if (updatableAnimationState.lastFrameTime == Long.MIN_VALUE) {
            updatableAnimationState.lastFrameTime = j;
        }
        AnimationVector1D animationVector1D = new AnimationVector1D(updatableAnimationState.value);
        if (f == 0.0f) {
            roundToLong = updatableAnimationState.vectorizedSpec.getDurationNanos(new AnimationVector1D(updatableAnimationState.value), ZeroVector, updatableAnimationState.lastVelocity);
        } else {
            roundToLong = MathKt.roundToLong(((float) (j - updatableAnimationState.lastFrameTime)) / f);
        }
        VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec = updatableAnimationState.vectorizedSpec;
        AnimationVector1D animationVector1D2 = animationVector1D;
        AnimationVector1D animationVector1D3 = ZeroVector;
        long j2 = roundToLong;
        float value = vectorizedAnimationSpec.getValueFromNanos(j2, animationVector1D2, animationVector1D3, updatableAnimationState.lastVelocity).getValue();
        updatableAnimationState.lastVelocity = updatableAnimationState.vectorizedSpec.getVelocityFromNanos(j2, animationVector1D2, animationVector1D3, updatableAnimationState.lastVelocity);
        updatableAnimationState.lastFrameTime = j;
        float f2 = updatableAnimationState.value - value;
        updatableAnimationState.value = value;
        function1.invoke(Float.valueOf(f2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateToZero$lambda$2(UpdatableAnimationState updatableAnimationState, Function1 function1, long j) {
        float f = updatableAnimationState.value;
        updatableAnimationState.value = 0.0f;
        function1.invoke(Float.valueOf(f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdatableAnimationState.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u00020\u000b*\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "<init>", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float f) {
            return Math.abs(f) < 0.01f;
        }
    }
}
