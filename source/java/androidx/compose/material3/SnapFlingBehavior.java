package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.p002ui.MotionDurationScale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* compiled from: SnapFlingBehavior.kt */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0014\b\u0001\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0019H\u0002J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u001dH\u0016JH\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@¢\u0006\u0002\u00102JP\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0082@¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u00107\u001a\u00020\u0006H\u0002J(\u00108\u001a\u0002H9\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:*\b\u0012\u0004\u0012\u0002H90;H\u0082\u0002¢\u0006\u0002\u0010<J(\u0010=\u001a\u0002H9\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:*\b\u0012\u0004\u0012\u0002H90;H\u0082\u0002¢\u0006\u0002\u0010<J&\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010@J&\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010@J\u001a\u0010B\u001a\u00020\u0006*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010@J.\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010EJ&\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010)\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010@R\u000e\u0010\f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u000eX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/material3/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/unit/Density;)V", "DefaultScrollMotionDurationScaleFactor", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "F", "itemSize", "getItemSize", "()F", "motionScaleDuration", "androidx/compose/material3/SnapFlingBehavior$motionScaleDuration$1", "Landroidx/compose/material3/SnapFlingBehavior$motionScaleDuration$1;", "velocityThreshold", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "calculateDistanceToDesiredSnapPosition", "layoutInfo", "item", "equals", "", "other", "", "findClosestOffset", "velocity", "hashCode", "animateDecay", "Landroidx/compose/material3/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateSnap", "cancelOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "fling", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "longSnap", "performFling", "runApproach", "initialTargetOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shortSnap", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SnapFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final Density density;
    private final LazyListState lazyListState;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final float velocityThreshold;
    private SnapFlingBehavior$motionScaleDuration$1 motionScaleDuration = new MotionDurationScale() { // from class: androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1
        public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) MotionDurationScale.DefaultImpls.fold(this, r, function2);
        }

        public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
            return (E) MotionDurationScale.DefaultImpls.get(this, key);
        }

        public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
            return MotionDurationScale.DefaultImpls.minusKey(this, key);
        }

        public CoroutineContext plus(CoroutineContext coroutineContext) {
            return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
        }

        @Override // androidx.compose.p002ui.MotionDurationScale
        public float getScaleFactor() {
            float f;
            f = SnapFlingBehavior.this.DefaultScrollMotionDurationScaleFactor;
            return f;
        }
    };
    private final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private final float MinFlingVelocityDp = Dp.constructor-impl(400);

    private static final boolean findClosestOffset$isValidDistance(float f) {
        if (!(f == Float.POSITIVE_INFINITY)) {
            if (!(f == Float.NEGATIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1] */
    public SnapFlingBehavior(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Density density) {
        this.lazyListState = lazyListState;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec;
        this.density = density;
        this.velocityThreshold = density.toPx-0680j_4(this.MinFlingVelocityDp);
    }

    private final List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.lazyListState.getLayoutInfo().getVisibleItemsInfo();
    }

    private final float getItemSize() {
        if (!(!getVisibleItemsInfo().isEmpty())) {
            return 0.0f;
        }
        List<LazyListItemInfo> visibleItemsInfo = getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += visibleItemsInfo.get(i2).getSize();
        }
        return i / getVisibleItemsInfo().size();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(ScrollScope scrollScope, float f, Continuation<? super Float> continuation) {
        SnapFlingBehavior$performFling$1 snapFlingBehavior$performFling$1;
        int i;
        if (continuation instanceof SnapFlingBehavior$performFling$1) {
            snapFlingBehavior$performFling$1 = (SnapFlingBehavior$performFling$1) continuation;
            if ((snapFlingBehavior$performFling$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$performFling$1.label -= Integer.MIN_VALUE;
                Object obj = snapFlingBehavior$performFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$performFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    snapFlingBehavior$performFling$1.label = 1;
                    obj = fling(scrollScope, f, snapFlingBehavior$performFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AnimationResult animationResult = (AnimationResult) obj;
                return Boxing.boxFloat(((Number) animationResult.component1()).floatValue() == 0.0f ? 0.0f : ((Number) animationResult.component2().getVelocity()).floatValue());
            }
        }
        snapFlingBehavior$performFling$1 = new SnapFlingBehavior$performFling$1(this, continuation);
        Object obj2 = snapFlingBehavior$performFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$performFling$1.label;
        if (i != 0) {
        }
        AnimationResult animationResult2 = (AnimationResult) obj2;
        return Boxing.boxFloat(((Number) animationResult2.component1()).floatValue() == 0.0f ? 0.0f : ((Number) animationResult2.component2().getVelocity()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fling(ScrollScope scrollScope, float f, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$fling$1 snapFlingBehavior$fling$1;
        int i;
        if (continuation instanceof SnapFlingBehavior$fling$1) {
            snapFlingBehavior$fling$1 = (SnapFlingBehavior$fling$1) continuation;
            if ((snapFlingBehavior$fling$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$fling$1.label -= Integer.MIN_VALUE;
                Object obj = snapFlingBehavior$fling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$fling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext coroutineContext = this.motionScaleDuration;
                    SnapFlingBehavior$fling$result$1 snapFlingBehavior$fling$result$1 = new SnapFlingBehavior$fling$result$1(f, this, scrollScope, null);
                    snapFlingBehavior$fling$1.label = 1;
                    obj = BuildersKt.withContext(coroutineContext, snapFlingBehavior$fling$result$1, snapFlingBehavior$fling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return (AnimationResult) obj;
            }
        }
        snapFlingBehavior$fling$1 = new SnapFlingBehavior$fling$1(this, continuation);
        Object obj2 = snapFlingBehavior$fling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$fling$1.label;
        if (i != 0) {
        }
        return (AnimationResult) obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object shortSnap(ScrollScope scrollScope, float f, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        float findClosestOffset = findClosestOffset(0.0f, this.lazyListState);
        return animateSnap(scrollScope, findClosestOffset, findClosestOffset, AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null), this.snapAnimationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00b2 A[PHI: r3
      0x00b2: PHI (r3v13 java.lang.Object) = (r3v12 java.lang.Object), (r3v1 java.lang.Object) binds: [B:17:0x00af, B:10:0x0032] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object longSnap(ScrollScope scrollScope, float f, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$longSnap$1 snapFlingBehavior$longSnap$1;
        int i;
        SnapFlingBehavior snapFlingBehavior;
        ScrollScope scrollScope2 = scrollScope;
        if (continuation instanceof SnapFlingBehavior$longSnap$1) {
            snapFlingBehavior$longSnap$1 = (SnapFlingBehavior$longSnap$1) continuation;
            if ((snapFlingBehavior$longSnap$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$longSnap$1.label -= Integer.MIN_VALUE;
                SnapFlingBehavior$longSnap$1 snapFlingBehavior$longSnap$12 = snapFlingBehavior$longSnap$1;
                Object obj = snapFlingBehavior$longSnap$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$longSnap$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    float coerceAtLeast = RangesKt.coerceAtLeast(Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, f)) - getItemSize(), 0.0f);
                    if (!(coerceAtLeast == 0.0f)) {
                        coerceAtLeast *= Math.signum(f);
                    }
                    snapFlingBehavior$longSnap$12.L$0 = this;
                    snapFlingBehavior$longSnap$12.L$1 = scrollScope2;
                    snapFlingBehavior$longSnap$12.label = 1;
                    obj = runApproach(scrollScope2, coerceAtLeast, f, snapFlingBehavior$longSnap$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    snapFlingBehavior = this;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    scrollScope2 = (ScrollScope) snapFlingBehavior$longSnap$12.L$1;
                    SnapFlingBehavior snapFlingBehavior2 = (SnapFlingBehavior) snapFlingBehavior$longSnap$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    snapFlingBehavior = snapFlingBehavior2;
                }
                AnimationResult animationResult = (AnimationResult) obj;
                float floatValue = ((Number) animationResult.component1()).floatValue();
                AnimationState<Float, AnimationVector1D> copy$default = AnimationStateKt.copy$default(animationResult.component2(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                AnimationSpec<Float> animationSpec = snapFlingBehavior.snapAnimationSpec;
                snapFlingBehavior$longSnap$12.L$0 = null;
                snapFlingBehavior$longSnap$12.L$1 = null;
                snapFlingBehavior$longSnap$12.label = 2;
                obj = snapFlingBehavior.animateSnap(scrollScope2, floatValue, floatValue, copy$default, animationSpec, snapFlingBehavior$longSnap$12);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        snapFlingBehavior$longSnap$1 = new SnapFlingBehavior$longSnap$1(this, continuation);
        SnapFlingBehavior$longSnap$1 snapFlingBehavior$longSnap$122 = snapFlingBehavior$longSnap$1;
        Object obj2 = snapFlingBehavior$longSnap$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$longSnap$122.label;
        if (i != 0) {
        }
        AnimationResult animationResult2 = (AnimationResult) obj2;
        float floatValue2 = ((Number) animationResult2.component1()).floatValue();
        AnimationState<Float, AnimationVector1D> copy$default2 = AnimationStateKt.copy$default(animationResult2.component2(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        AnimationSpec<Float> animationSpec2 = snapFlingBehavior.snapAnimationSpec;
        snapFlingBehavior$longSnap$122.L$0 = null;
        snapFlingBehavior$longSnap$122.L$1 = null;
        snapFlingBehavior$longSnap$122.label = 2;
        obj2 = snapFlingBehavior.animateSnap(scrollScope2, floatValue2, floatValue2, copy$default2, animationSpec2, snapFlingBehavior$longSnap$122);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runApproach(ScrollScope scrollScope, float f, float f2, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$runApproach$1 snapFlingBehavior$runApproach$1;
        int i;
        SnapFlingBehavior snapFlingBehavior;
        if (continuation instanceof SnapFlingBehavior$runApproach$1) {
            snapFlingBehavior$runApproach$1 = (SnapFlingBehavior$runApproach$1) continuation;
            if ((snapFlingBehavior$runApproach$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$runApproach$1.label -= Integer.MIN_VALUE;
                SnapFlingBehavior$runApproach$1 snapFlingBehavior$runApproach$12 = snapFlingBehavior$runApproach$1;
                Object obj = snapFlingBehavior$runApproach$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$runApproach$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnimationState<Float, AnimationVector1D> AnimationState$default = AnimationStateKt.AnimationState$default(0.0f, f2, 0L, 0L, false, 28, null);
                    DecayAnimationSpec<Float> decayAnimationSpec = this.decayAnimationSpec;
                    snapFlingBehavior$runApproach$12.L$0 = this;
                    snapFlingBehavior$runApproach$12.label = 1;
                    obj = animateDecay(scrollScope, f, AnimationState$default, decayAnimationSpec, snapFlingBehavior$runApproach$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    snapFlingBehavior = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    snapFlingBehavior = (SnapFlingBehavior) snapFlingBehavior$runApproach$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AnimationState component2 = ((AnimationResult) obj).component2();
                return new AnimationResult(Boxing.boxFloat(snapFlingBehavior.findClosestOffset(((Number) component2.getVelocity()).floatValue(), snapFlingBehavior.lazyListState)), component2);
            }
        }
        snapFlingBehavior$runApproach$1 = new SnapFlingBehavior$runApproach$1(this, continuation);
        SnapFlingBehavior$runApproach$1 snapFlingBehavior$runApproach$122 = snapFlingBehavior$runApproach$1;
        Object obj2 = snapFlingBehavior$runApproach$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$runApproach$122.label;
        if (i != 0) {
        }
        AnimationState component22 = ((AnimationResult) obj2).component2();
        return new AnimationResult(Boxing.boxFloat(snapFlingBehavior.findClosestOffset(((Number) component22.getVelocity()).floatValue(), snapFlingBehavior.lazyListState)), component22);
    }

    public boolean equals(Object other) {
        if (!(other instanceof SnapFlingBehavior)) {
            return false;
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) other;
        return Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.lazyListState, this.lazyListState) && Intrinsics.areEqual(snapFlingBehavior.density, this.density);
    }

    public int hashCode() {
        return ((((((0 + this.snapAnimationSpec.hashCode()) * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.lazyListState.hashCode()) * 31) + this.density.hashCode();
    }

    private final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        return (T) closedFloatingPointRange.getStart();
    }

    private final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        return (T) closedFloatingPointRange.getEndInclusive();
    }

    private static final ClosedFloatingPointRange<Float> findClosestOffset$calculateSnappingOffsetBounds(LazyListState lazyListState, SnapFlingBehavior snapFlingBehavior) {
        LazyListLayoutInfo layoutInfo = lazyListState.getLayoutInfo();
        List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        float f = Float.NEGATIVE_INFINITY;
        float f2 = Float.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            float calculateDistanceToDesiredSnapPosition = snapFlingBehavior.calculateDistanceToDesiredSnapPosition(layoutInfo, visibleItemsInfo.get(i));
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f) {
                f = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f2) {
                f2 = calculateDistanceToDesiredSnapPosition;
            }
        }
        return RangesKt.rangeTo(f, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0032, code lost:
    
        if (java.lang.Math.abs(r7) <= java.lang.Math.abs(r0)) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float findClosestOffset(float velocity, LazyListState lazyListState) {
        ClosedFloatingPointRange<Float> findClosestOffset$calculateSnappingOffsetBounds = findClosestOffset$calculateSnappingOffsetBounds(lazyListState, this);
        float floatValue = ((Number) component1(findClosestOffset$calculateSnappingOffsetBounds)).floatValue();
        float floatValue2 = ((Number) component2(findClosestOffset$calculateSnappingOffsetBounds)).floatValue();
        float signum = Math.signum(velocity);
        if (!(signum == 0.0f)) {
            if (!(signum == 1.0f)) {
                if (!(signum == -1.0f)) {
                    floatValue = 0.0f;
                }
            }
            floatValue = floatValue2;
        }
        if (findClosestOffset$isValidDistance(floatValue)) {
            return floatValue;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateDecay(final ScrollScope scrollScope, final float f, AnimationState<Float, AnimationVector1D> animationState, DecayAnimationSpec<Float> decayAnimationSpec, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$animateDecay$1 snapFlingBehavior$animateDecay$1;
        int i;
        Ref.FloatRef floatRef;
        if (continuation instanceof SnapFlingBehavior$animateDecay$1) {
            snapFlingBehavior$animateDecay$1 = (SnapFlingBehavior$animateDecay$1) continuation;
            if ((snapFlingBehavior$animateDecay$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$animateDecay$1.label -= Integer.MIN_VALUE;
                Object obj = snapFlingBehavior$animateDecay$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$animateDecay$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    boolean z = animationState.getVelocity().floatValue() == 0.0f;
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.SnapFlingBehavior$animateDecay$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            float coerceToTarget;
                            if (Math.abs(animationScope.getValue().floatValue()) >= Math.abs(f)) {
                                coerceToTarget = this.coerceToTarget(animationScope.getValue().floatValue(), f);
                                SnapFlingBehavior.animateDecay$consumeDelta(animationScope, scrollScope, coerceToTarget - floatRef2.element);
                                animationScope.cancelAnimation();
                                return;
                            }
                            SnapFlingBehavior.animateDecay$consumeDelta(animationScope, scrollScope, animationScope.getValue().floatValue() - floatRef2.element);
                            floatRef2.element = animationScope.getValue().floatValue();
                        }
                    };
                    snapFlingBehavior$animateDecay$1.L$0 = animationState;
                    snapFlingBehavior$animateDecay$1.L$1 = floatRef2;
                    snapFlingBehavior$animateDecay$1.F$0 = f;
                    snapFlingBehavior$animateDecay$1.label = 1;
                    if (SuspendAnimationKt.animateDecay(animationState, decayAnimationSpec, !z, function1, (Continuation<? super Unit>) snapFlingBehavior$animateDecay$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    floatRef = floatRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f = snapFlingBehavior$animateDecay$1.F$0;
                    floatRef = (Ref.FloatRef) snapFlingBehavior$animateDecay$1.L$1;
                    animationState = (AnimationState) snapFlingBehavior$animateDecay$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return new AnimationResult(Boxing.boxFloat(f - floatRef.element), animationState);
            }
        }
        snapFlingBehavior$animateDecay$1 = new SnapFlingBehavior$animateDecay$1(this, continuation);
        Object obj2 = snapFlingBehavior$animateDecay$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$animateDecay$1.label;
        if (i != 0) {
        }
        return new AnimationResult(Boxing.boxFloat(f - floatRef.element), animationState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope scrollScope, float f) {
        if (Math.abs(f - scrollScope.scrollBy(f)) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateSnap(final ScrollScope scrollScope, float f, final float f2, AnimationState<Float, AnimationVector1D> animationState, AnimationSpec<Float> animationSpec, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$animateSnap$1 snapFlingBehavior$animateSnap$1;
        int i;
        float f3;
        SnapFlingBehavior snapFlingBehavior;
        Ref.FloatRef floatRef;
        float f4;
        AnimationState<Float, AnimationVector1D> animationState2;
        if (continuation instanceof SnapFlingBehavior$animateSnap$1) {
            snapFlingBehavior$animateSnap$1 = (SnapFlingBehavior$animateSnap$1) continuation;
            if ((snapFlingBehavior$animateSnap$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$animateSnap$1.label -= Integer.MIN_VALUE;
                SnapFlingBehavior$animateSnap$1 snapFlingBehavior$animateSnap$12 = snapFlingBehavior$animateSnap$1;
                Object obj = snapFlingBehavior$animateSnap$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$animateSnap$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    float floatValue = animationState.getVelocity().floatValue();
                    Float boxFloat = Boxing.boxFloat(f);
                    boolean z = !(animationState.getVelocity().floatValue() == 0.0f);
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.SnapFlingBehavior$animateSnap$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:6:0x003a, code lost:
                        
                            if ((r0 == r5.getValue().floatValue()) == false) goto L9;
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            float coerceToTarget;
                            coerceToTarget = SnapFlingBehavior.this.coerceToTarget(animationScope.getValue().floatValue(), f2);
                            float f5 = coerceToTarget - floatRef2.element;
                            float scrollBy = scrollScope.scrollBy(f5);
                            if (Math.abs(f5 - scrollBy) <= 0.5f) {
                            }
                            animationScope.cancelAnimation();
                            floatRef2.element += scrollBy;
                        }
                    };
                    snapFlingBehavior$animateSnap$12.L$0 = this;
                    snapFlingBehavior$animateSnap$12.L$1 = animationState;
                    snapFlingBehavior$animateSnap$12.L$2 = floatRef2;
                    f3 = f;
                    snapFlingBehavior$animateSnap$12.F$0 = f3;
                    snapFlingBehavior$animateSnap$12.F$1 = floatValue;
                    snapFlingBehavior$animateSnap$12.label = 1;
                    if (SuspendAnimationKt.animateTo(animationState, boxFloat, animationSpec, z, function1, snapFlingBehavior$animateSnap$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    snapFlingBehavior = this;
                    floatRef = floatRef2;
                    f4 = floatValue;
                    animationState2 = animationState;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f4 = snapFlingBehavior$animateSnap$12.F$1;
                    float f5 = snapFlingBehavior$animateSnap$12.F$0;
                    floatRef = (Ref.FloatRef) snapFlingBehavior$animateSnap$12.L$2;
                    AnimationState<Float, AnimationVector1D> animationState3 = (AnimationState) snapFlingBehavior$animateSnap$12.L$1;
                    snapFlingBehavior = (SnapFlingBehavior) snapFlingBehavior$animateSnap$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    f3 = f5;
                    animationState2 = animationState3;
                }
                return new AnimationResult(Boxing.boxFloat(f3 - floatRef.element), AnimationStateKt.copy$default((AnimationState) animationState2, 0.0f, snapFlingBehavior.coerceToTarget(animationState2.getVelocity().floatValue(), f4), 0L, 0L, false, 29, (Object) null));
            }
        }
        snapFlingBehavior$animateSnap$1 = new SnapFlingBehavior$animateSnap$1(this, continuation);
        SnapFlingBehavior$animateSnap$1 snapFlingBehavior$animateSnap$122 = snapFlingBehavior$animateSnap$1;
        Object obj2 = snapFlingBehavior$animateSnap$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$animateSnap$122.label;
        if (i != 0) {
        }
        return new AnimationResult(Boxing.boxFloat(f3 - floatRef.element), AnimationStateKt.copy$default((AnimationState) animationState2, 0.0f, snapFlingBehavior.coerceToTarget(animationState2.getVelocity().floatValue(), f4), 0L, 0L, false, 29, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? RangesKt.coerceAtMost(f, f2) : RangesKt.coerceAtLeast(f, f2);
    }

    private final float calculateDistanceToDesiredSnapPosition(LazyListLayoutInfo layoutInfo, LazyListItemInfo item) {
        float f = 2;
        return item.getOffset() - ((((getSingleAxisViewportSize(layoutInfo) - layoutInfo.getBeforeContentPadding()) - layoutInfo.getAfterContentPadding()) / f) - (item.getSize() / f));
    }

    private final int getSingleAxisViewportSize(LazyListLayoutInfo lazyListLayoutInfo) {
        return lazyListLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.getHeight-impl(lazyListLayoutInfo.mo1201getViewportSizeYbymL2g()) : IntSize.getWidth-impl(lazyListLayoutInfo.mo1201getViewportSizeYbymL2g());
    }
}
