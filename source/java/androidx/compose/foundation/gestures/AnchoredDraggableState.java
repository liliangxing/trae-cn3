package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001n\b\u0007\u0018\u0000 \u0082\u0001*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0082\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0083\u0001\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0016B4\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0017BD\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0018J\u0006\u0010N\u001a\u00020\u000bJ\u001d\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00028\u00002\u0006\u0010R\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010SJ#\u0010d\u001a\u00020e2\f\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010g\u001a\u00028\u0000¢\u0006\u0002\u0010hJ\u001c\u0010i\u001a\u00020e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0086@¢\u0006\u0002\u0010jJ\u0016\u0010i\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\u000bH\u0087@¢\u0006\u0002\u0010lJ\\\u0010p\u001a\u00020e2\b\b\u0002\u0010q\u001a\u00020r2B\u0010s\u001a>\b\u0001\u0012\u0004\u0012\u00020u\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0v\u0012\u0006\u0012\u0004\u0018\u00010\u00020t¢\u0006\u0002\bwH\u0086@¢\u0006\u0002\u0010xJy\u0010p\u001a\u00020e2\u0006\u0010C\u001a\u00028\u00002\b\b\u0002\u0010q\u001a\u00020r2W\u0010s\u001aS\b\u0001\u0012\u0004\u0012\u00020u\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(z\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(C\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0v\u0012\u0006\u0012\u0004\u0018\u00010\u00020y¢\u0006\u0002\bwH\u0086@¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000bH\u0000¢\u0006\u0002\b~J\u000e\u0010\u007f\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000bJ\u0017\u0010\u0080\u0001\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010\u0081\u0001R5\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\nX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R8\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R8\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0+2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0+8\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010&\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u00158@X\u0080\u0004¢\u0006\f\u0012\u0004\b3\u0010&\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00109\u001a\u00028\u00002\u0006\u00108\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0005R+\u0010?\u001a\u00028\u00002\u0006\u00108\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010>\u001a\u0004\b@\u0010;\"\u0004\bA\u0010\u0005R\u001b\u0010C\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bD\u0010;R+\u0010G\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0011\u0010O\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bO\u00105R!\u0010P\u001a\u00020\u000b8GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bV\u0010F\u0012\u0004\bT\u0010&\u001a\u0004\bU\u0010IR+\u0010W\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010M\u001a\u0004\bX\u0010I\"\u0004\bY\u0010KR/\u0010[\u001a\u0004\u0018\u00018\u00002\b\u00108\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010>\u001a\u0004\b\\\u0010;\"\u0004\b]\u0010\u0005R7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010>\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0010\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010o¨\u0006\u0083\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;)V", "getConfirmValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setConfirmValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "getPositionalThreshold$foundation_release", "setPositionalThreshold$foundation_release", "getVelocityThreshold$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setVelocityThreshold$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "value", "snapAnimationSpec", "getSnapAnimationSpec$annotations", "()V", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setSnapAnimationSpec$foundation_release", "(Landroidx/compose/animation/core/AnimationSpec;)V", "Landroidx/compose/animation/core/DecayAnimationSpec;", "decayAnimationSpec", "getDecayAnimationSpec$annotations", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "setDecayAnimationSpec$foundation_release", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "usePreModifierChangeBehavior", "getUsePreModifierChangeBehavior$foundation_release$annotations", "getUsePreModifierChangeBehavior$foundation_release", "()Z", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "targetValue", "getTargetValue", "targetValue$delegate", "Landroidx/compose/runtime/State;", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "requireOffset", "isAnimationRunning", "progress", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)F", "getProgress$annotations", "getProgress", "progress$delegate", "lastVelocity", "getLastVelocity", "setLastVelocity", "lastVelocity$delegate", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "updateAnchors", "", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "settle", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDragScope", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "anchoredDrag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "anchor", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newOffsetForDelta", "delta", "newOffsetForDelta$foundation_release", "dispatchRawDelta", "trySnapTo", "(Ljava/lang/Object;)Z", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState$anchoredDragScope$1 anchoredDragScope;

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private Function1<? super T, Boolean> confirmValueChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    public DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;

    /* renamed from: dragTarget$delegate, reason: from kotlin metadata */
    private final MutableState dragTarget;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState offset;
    public Function1<? super Float, Float> positionalThreshold;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* renamed from: settledValue$delegate, reason: from kotlin metadata */
    private final MutableState settledValue;
    public AnimationSpec<Float> snapAnimationSpec;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    public Function0<Float> velocityThreshold;

    public static final boolean _init_$lambda$0(Object obj) {
        return true;
    }

    public static final boolean _init_$lambda$1(Object obj) {
        return true;
    }

    public static final boolean confirmValueChange$lambda$2(Object obj) {
        return true;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
    public static /* synthetic */ void getDecayAnimationSpec$annotations() {
    }

    @Deprecated(message = "Use the progress function to query the progress between two specified anchors.", replaceWith = @ReplaceWith(expression = "progress(state.settledValue, state.targetValue)", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
    public static /* synthetic */ void getSnapAnimationSpec$annotations() {
    }

    public static /* synthetic */ void getUsePreModifierChangeBehavior$foundation_release$annotations() {
    }

    public AnchoredDraggableState(T t) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        DefaultDraggableAnchors emptyDraggableAnchors;
        MutableState mutableStateOf$default4;
        this.confirmValueChange = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean confirmValueChange$lambda$2;
                confirmValueChange$lambda$2 = AnchoredDraggableState.confirmValueChange$lambda$2(obj);
                return Boolean.valueOf(confirmValueChange$lambda$2);
            }
        };
        this.dragMutex = new MutatorMutex();
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.currentValue = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.settledValue = mutableStateOf$default2;
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda1
            public final Object invoke() {
                Object targetValue_delegate$lambda$4;
                targetValue_delegate$lambda$4 = AnchoredDraggableState.targetValue_delegate$lambda$4(AnchoredDraggableState.this);
                return targetValue_delegate$lambda$4;
            }
        });
        this.offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda2
            public final Object invoke() {
                float progress_delegate$lambda$6;
                progress_delegate$lambda$6 = AnchoredDraggableState.progress_delegate$lambda$6(AnchoredDraggableState.this);
                return Float.valueOf(progress_delegate$lambda$6);
            }
        });
        this.lastVelocity = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.dragTarget = mutableStateOf$default3;
        emptyDraggableAnchors = AnchoredDraggableKt.emptyDraggableAnchors();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(emptyDraggableAnchors, null, 2, null);
        this.anchors = mutableStateOf$default4;
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors) {
        this(t);
        setAnchors(draggableAnchors);
        trySnapTo(t);
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, Function1 function1, Function0 function0, AnimationSpec animationSpec, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, draggableAnchors, function1, function0, animationSpec, (i & 32) != 0 ? new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda3
            public final Object invoke(Object obj2) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = AnchoredDraggableState._init_$lambda$0(obj2);
                return Boolean.valueOf(_init_$lambda$0);
            }
        } : function12);
    }

    public AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function12) {
        this(t, function12);
        DecayAnimationSpec<Float> decayAnimationSpec;
        setAnchors(draggableAnchors);
        setPositionalThreshold$foundation_release(function1);
        setVelocityThreshold$foundation_release(function0);
        setSnapAnimationSpec$foundation_release(animationSpec);
        decayAnimationSpec = AnchoredDraggableKt.NoOpDecayAnimationSpec;
        setDecayAnimationSpec$foundation_release(decayAnimationSpec);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
    public AnchoredDraggableState(T t, Function1<? super T, Boolean> function1) {
        this(t);
        this.confirmValueChange = function1;
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, draggableAnchors, (i & 4) != 0 ? new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda4
            public final Object invoke(Object obj2) {
                boolean _init_$lambda$1;
                _init_$lambda$1 = AnchoredDraggableState._init_$lambda$1(obj2);
                return Boolean.valueOf(_init_$lambda$1);
            }
        } : function1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
    public AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors, Function1<? super T, Boolean> function1) {
        this(t, function1);
        setAnchors(draggableAnchors);
        trySnapTo(t);
    }

    public final Function1<T, Boolean> getConfirmValueChange$foundation_release() {
        return this.confirmValueChange;
    }

    public final void setConfirmValueChange$foundation_release(Function1<? super T, Boolean> function1) {
        this.confirmValueChange = function1;
    }

    public final Function1<Float, Float> getPositionalThreshold$foundation_release() {
        Function1 function1 = this.positionalThreshold;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
        return null;
    }

    public final void setPositionalThreshold$foundation_release(Function1<? super Float, Float> function1) {
        this.positionalThreshold = function1;
    }

    public final Function0<Float> getVelocityThreshold$foundation_release() {
        Function0<Float> function0 = this.velocityThreshold;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityThreshold");
        return null;
    }

    public final void setVelocityThreshold$foundation_release(Function0<Float> function0) {
        this.velocityThreshold = function0;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        AnimationSpec<Float> animationSpec = this.snapAnimationSpec;
        if (animationSpec != null) {
            return animationSpec;
        }
        Intrinsics.throwUninitializedPropertyAccessException("snapAnimationSpec");
        return null;
    }

    public final void setSnapAnimationSpec$foundation_release(AnimationSpec<Float> animationSpec) {
        this.snapAnimationSpec = animationSpec;
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        DecayAnimationSpec<Float> decayAnimationSpec = this.decayAnimationSpec;
        if (decayAnimationSpec != null) {
            return decayAnimationSpec;
        }
        Intrinsics.throwUninitializedPropertyAccessException("decayAnimationSpec");
        return null;
    }

    public final void setDecayAnimationSpec$foundation_release(DecayAnimationSpec<Float> decayAnimationSpec) {
        this.decayAnimationSpec = decayAnimationSpec;
    }

    public final boolean getUsePreModifierChangeBehavior$foundation_release() {
        return (this.positionalThreshold == null || this.velocityThreshold == null || this.snapAnimationSpec == null || this.decayAnimationSpec == null) ? false : true;
    }

    public final void setCurrentValue(T t) {
        this.currentValue.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    public final void setSettledValue(T t) {
        this.settledValue.setValue(t);
    }

    public final T getSettledValue() {
        return this.settledValue.getValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    public static final Object targetValue_delegate$lambda$4(AnchoredDraggableState anchoredDraggableState) {
        Object currentValue;
        Object dragTarget = anchoredDraggableState.getDragTarget();
        if (dragTarget != null) {
            return dragTarget;
        }
        if (!Float.isNaN(anchoredDraggableState.getOffset())) {
            T closestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
            if (closestAnchor != null) {
                return closestAnchor;
            }
            currentValue = anchoredDraggableState.getCurrentValue();
        } else {
            currentValue = anchoredDraggableState.getCurrentValue();
        }
        return currentValue;
    }

    public final void setOffset(float f) {
        this.offset.setFloatValue(f);
    }

    public final float getOffset() {
        return this.offset.getFloatValue();
    }

    public final float requireOffset() {
        if (!(!Float.isNaN(getOffset()))) {
            InlineClassHelperKt.throwIllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return getOffset();
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float progress(T from, T to) {
        float positionOf = getAnchors().positionOf(from);
        float positionOf2 = getAnchors().positionOf(to);
        float coerceIn = (RangesKt.coerceIn(getOffset(), Math.min(positionOf, positionOf2), Math.max(positionOf, positionOf2)) - positionOf) / (positionOf2 - positionOf);
        if (Float.isNaN(coerceIn)) {
            return 1.0f;
        }
        if (coerceIn < 1.0E-6f) {
            return 0.0f;
        }
        if (coerceIn > 0.999999f) {
            return 1.0f;
        }
        return Math.abs(coerceIn);
    }

    public final float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final float progress_delegate$lambda$6(AnchoredDraggableState anchoredDraggableState) {
        float positionOf = anchoredDraggableState.getAnchors().positionOf(anchoredDraggableState.getSettledValue());
        float positionOf2 = anchoredDraggableState.getAnchors().positionOf(anchoredDraggableState.getTargetValue()) - positionOf;
        float abs = Math.abs(positionOf2);
        if (Float.isNaN(abs) || abs <= 1.0E-6f) {
            return 1.0f;
        }
        float requireOffset = (anchoredDraggableState.requireOffset() - positionOf) / positionOf2;
        if (requireOffset < 1.0E-6f) {
            return 0.0f;
        }
        if (requireOffset > 0.999999f) {
            return 1.0f;
        }
        return requireOffset;
    }

    public final void setLastVelocity(float f) {
        this.lastVelocity.setFloatValue(f);
    }

    public final float getLastVelocity() {
        return this.lastVelocity.getFloatValue();
    }

    private final T getDragTarget() {
        return this.dragTarget.getValue();
    }

    public final void setDragTarget(T t) {
        this.dragTarget.setValue(t);
    }

    private final void setAnchors(DraggableAnchors<T> draggableAnchors) {
        this.anchors.setValue(draggableAnchors);
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            if (!Float.isNaN(anchoredDraggableState.getOffset())) {
                obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset());
                if (obj == null) {
                    obj = anchoredDraggableState.getTargetValue();
                }
            } else {
                obj = anchoredDraggableState.getTargetValue();
            }
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    public final void updateAnchors(DraggableAnchors<T> newAnchors, T newTarget) {
        if (Intrinsics.areEqual(getAnchors(), newAnchors)) {
            return;
        }
        setAnchors(newAnchors);
        if (trySnapTo(newTarget)) {
            return;
        }
        setDragTarget(newTarget);
    }

    public final Object settle(AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        T currentValue = getCurrentValue();
        T closestAnchor = getAnchors().closestAnchor(requireOffset());
        if (closestAnchor != null && ((Boolean) this.confirmValueChange.invoke(closestAnchor)).booleanValue()) {
            Object animateTo = AnchoredDraggableKt.animateTo(this, closestAnchor, animationSpec, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = AnchoredDraggableKt.animateTo(this, currentValue, animationSpec, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSample.kt for example usages.")
    public final Object settle(float f, Continuation<? super Float> continuation) {
        Object computeTarget;
        if (!getUsePreModifierChangeBehavior$foundation_release()) {
            InlineClassHelperKt.throwIllegalArgumentException("AnchoredDraggableState was configured through a constructor without providing positional and velocity threshold. This overload of settle has been deprecated. Please refer to AnchoredDraggableState#settle(animationSpec) for more information.");
        }
        T currentValue = getCurrentValue();
        computeTarget = AnchoredDraggableKt.computeTarget(getAnchors(), requireOffset(), f, getPositionalThreshold$foundation_release(), getVelocityThreshold$foundation_release());
        if (((Boolean) this.confirmValueChange.invoke(computeTarget)).booleanValue()) {
            return AnchoredDraggableKt.animateToWithDecay$default(this, computeTarget, f, null, null, continuation, 12, null);
        }
        return AnchoredDraggableKt.animateToWithDecay$default(this, currentValue, f, null, null, continuation, 12, null);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, function3, continuation);
    }

    public final Object anchoredDrag(MutatePriority mutatePriority, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object mutate = this.dragMutex.mutate(mutatePriority, new AnchoredDraggableState$anchoredDrag$2(this, function3, null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object anchoredDrag(T t, MutatePriority mutatePriority, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super Unit> continuation) {
        AnchoredDraggableState$anchoredDrag$3 anchoredDraggableState$anchoredDrag$3;
        int i;
        try {
            if (continuation instanceof AnchoredDraggableState$anchoredDrag$3) {
                anchoredDraggableState$anchoredDrag$3 = (AnchoredDraggableState$anchoredDrag$3) continuation;
                if ((anchoredDraggableState$anchoredDrag$3.label & Integer.MIN_VALUE) != 0) {
                    anchoredDraggableState$anchoredDrag$3.label -= Integer.MIN_VALUE;
                    Object obj = anchoredDraggableState$anchoredDrag$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anchoredDraggableState$anchoredDrag$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (getAnchors().hasPositionFor(t)) {
                            MutatorMutex mutatorMutex = this.dragMutex;
                            AnchoredDraggableState$anchoredDrag$4 anchoredDraggableState$anchoredDrag$4 = new AnchoredDraggableState$anchoredDrag$4(this, t, function4, null);
                            anchoredDraggableState$anchoredDrag$3.label = 1;
                            if (mutatorMutex.mutate(mutatePriority, anchoredDraggableState$anchoredDrag$4, anchoredDraggableState$anchoredDrag$3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (((Boolean) this.confirmValueChange.invoke(t)).booleanValue()) {
                                setSettledValue(t);
                                setCurrentValue(t);
                            }
                            return Unit.INSTANCE;
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
            if (i != 0) {
            }
            return Unit.INSTANCE;
        } finally {
            setDragTarget(null);
        }
        anchoredDraggableState$anchoredDrag$3 = new AnchoredDraggableState$anchoredDrag$3(this, continuation);
        Object obj2 = anchoredDraggableState$anchoredDrag$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anchoredDraggableState$anchoredDrag$3.label;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function4, continuation);
    }

    public final float newOffsetForDelta$foundation_release(float delta) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getAnchors().minPosition(), getAnchors().maxPosition());
    }

    public final float dispatchRawDelta(float delta) {
        float newOffsetForDelta$foundation_release = newOffsetForDelta$foundation_release(delta);
        float requireOffset = newOffsetForDelta$foundation_release - requireOffset();
        AnchoredDragScope.dragTo$default(this.anchoredDragScope, newOffsetForDelta$foundation_release, 0.0f, 2, null);
        return requireOffset;
    }

    private final boolean trySnapTo(T targetValue) {
        MutatorMutex mutatorMutex = this.dragMutex;
        boolean tryLock = mutatorMutex.tryLock();
        if (tryLock) {
            try {
                AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = this.anchoredDragScope;
                float positionOf = getAnchors().positionOf(targetValue);
                if (!Float.isNaN(positionOf)) {
                    AnchoredDragScope.dragTo$default(anchoredDraggableState$anchoredDragScope$1, positionOf, 0.0f, 2, null);
                    setDragTarget(null);
                }
                setCurrentValue(targetValue);
                setSettledValue(targetValue);
            } finally {
                mutatorMutex.unlock();
            }
        }
        return tryLock;
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u0001J:\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007J\u0087\u0001\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "confirmValueChange", "Lkotlin/Function1;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "distance", "velocityThreshold", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final boolean Saver$lambda$2(Object obj) {
            return true;
        }

        public static final boolean Saver$lambda$5(Object obj) {
            return true;
        }

        private Companion() {
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver() {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Object Saver$lambda$0;
                    Saver$lambda$0 = AnchoredDraggableState.Companion.Saver$lambda$0((SaverScope) obj, (AnchoredDraggableState) obj2);
                    return Saver$lambda$0;
                }
            }, new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    AnchoredDraggableState Saver$lambda$1;
                    Saver$lambda$1 = AnchoredDraggableState.Companion.Saver$lambda$1(obj);
                    return Saver$lambda$1;
                }
            });
        }

        public static final Object Saver$lambda$0(SaverScope saverScope, AnchoredDraggableState anchoredDraggableState) {
            return anchoredDraggableState.getCurrentValue();
        }

        public static final AnchoredDraggableState Saver$lambda$1(Object obj) {
            return new AnchoredDraggableState(obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Saver Saver$default(Companion companion, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj2) {
                        boolean Saver$lambda$2;
                        Saver$lambda$2 = AnchoredDraggableState.Companion.Saver$lambda$2(obj2);
                        return Boolean.valueOf(Saver$lambda$2);
                    }
                };
            }
            return companion.Saver(function1);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final Function1<? super T, Boolean> confirmValueChange) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Object Saver$lambda$3;
                    Saver$lambda$3 = AnchoredDraggableState.Companion.Saver$lambda$3((SaverScope) obj, (AnchoredDraggableState) obj2);
                    return Saver$lambda$3;
                }
            }, new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    AnchoredDraggableState Saver$lambda$4;
                    Saver$lambda$4 = AnchoredDraggableState.Companion.Saver$lambda$4(confirmValueChange, obj);
                    return Saver$lambda$4;
                }
            });
        }

        public static final Object Saver$lambda$3(SaverScope saverScope, AnchoredDraggableState anchoredDraggableState) {
            return anchoredDraggableState.getCurrentValue();
        }

        public static final AnchoredDraggableState Saver$lambda$4(Function1 function1, Object obj) {
            return new AnchoredDraggableState(obj, (Function1<? super Object, Boolean>) function1);
        }

        public static /* synthetic */ Saver Saver$default(Companion companion, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
            if ((i & 16) != 0) {
                function12 = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj2) {
                        boolean Saver$lambda$5;
                        Saver$lambda$5 = AnchoredDraggableState.Companion.Saver$lambda$5(obj2);
                        return Boolean.valueOf(Saver$lambda$5);
                    }
                };
            }
            return companion.Saver(animationSpec, decayAnimationSpec, function1, function0, function12);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> snapAnimationSpec, final DecayAnimationSpec<Float> decayAnimationSpec, final Function1<? super Float, Float> positionalThreshold, final Function0<Float> velocityThreshold, final Function1<? super T, Boolean> confirmValueChange) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Object Saver$lambda$6;
                    Saver$lambda$6 = AnchoredDraggableState.Companion.Saver$lambda$6((SaverScope) obj, (AnchoredDraggableState) obj2);
                    return Saver$lambda$6;
                }
            }, new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    AnchoredDraggableState Saver$lambda$7;
                    Saver$lambda$7 = AnchoredDraggableState.Companion.Saver$lambda$7(positionalThreshold, velocityThreshold, snapAnimationSpec, decayAnimationSpec, confirmValueChange, obj);
                    return Saver$lambda$7;
                }
            });
        }

        public static final Object Saver$lambda$6(SaverScope saverScope, AnchoredDraggableState anchoredDraggableState) {
            return anchoredDraggableState.getCurrentValue();
        }

        public static final AnchoredDraggableState Saver$lambda$7(Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function12, Object obj) {
            return AnchoredDraggableKt.AnchoredDraggableState(obj, function1, function0, animationSpec, decayAnimationSpec, function12);
        }
    }
}
