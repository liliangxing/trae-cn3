package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: LazyLayoutScrollScope.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a2\u0010\u0010\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0080@¢\u0006\u0002\u0010\u0015\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"TargetDistance", "Landroidx/compose/ui/unit/Dp;", "F", "BoundDistance", "MinimumDistance", "DEBUG", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "isItemVisible", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "index", "", "animateScrollToItem", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyLayoutScrollScopeKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.constructor-impl(2500);
    private static final float BoundDistance = Dp.constructor-impl(1500);
    private static final float MinimumDistance = Dp.constructor-impl(50);

    private static final void debugLog(Function0<String> function0) {
    }

    public static final boolean isItemVisible(LazyLayoutScrollScope lazyLayoutScrollScope, int i) {
        return i <= lazyLayoutScrollScope.getLastVisibleItemIndex() && lazyLayoutScrollScope.getFirstVisibleItemIndex() <= i;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ef A[Catch: ItemFoundInScroll -> 0x01d2, TRY_LEAVE, TryCatch #7 {ItemFoundInScroll -> 0x01d2, blocks: (B:25:0x00eb, B:27:0x00ef, B:33:0x00fe, B:41:0x011d, B:44:0x015b, B:47:0x0166), top: B:24:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0254 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01b0 -> B:21:0x01b2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateScrollToItem(LazyLayoutScrollScope lazyLayoutScrollScope, int i, int i2, int i3, Density density, Continuation<? super Unit> continuation) {
        LazyLayoutScrollScopeKt$animateScrollToItem$1 lazyLayoutScrollScopeKt$animateScrollToItem$1;
        Object coroutine_suspended;
        int i4;
        final LazyLayoutScrollScope lazyLayoutScrollScope2;
        boolean z;
        LazyLayoutScrollScopeKt$animateScrollToItem$1 lazyLayoutScrollScopeKt$animateScrollToItem$12;
        int i5;
        float f;
        float f2;
        float f3;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef objectRef;
        int i6;
        float f4;
        Ref.BooleanRef booleanRef2;
        Ref.IntRef intRef;
        int i7;
        Object obj;
        Ref.ObjectRef objectRef2;
        LazyLayoutScrollScope lazyLayoutScrollScope3;
        float f5;
        float f6;
        int i8;
        LazyLayoutScrollScopeKt$animateScrollToItem$1 lazyLayoutScrollScopeKt$animateScrollToItem$13;
        AnimationState copy$default;
        Float boxFloat;
        Function1 function1;
        int i9;
        LazyLayoutScrollScope lazyLayoutScrollScope4;
        LazyLayoutScrollScope lazyLayoutScrollScope5;
        float f7;
        final float f8;
        AnimationState animationState;
        Float boxFloat2;
        boolean z2;
        Function1 function12;
        int i10 = i;
        if (continuation instanceof LazyLayoutScrollScopeKt$animateScrollToItem$1) {
            lazyLayoutScrollScopeKt$animateScrollToItem$1 = (LazyLayoutScrollScopeKt$animateScrollToItem$1) continuation;
            if ((lazyLayoutScrollScopeKt$animateScrollToItem$1.label & Integer.MIN_VALUE) != 0) {
                lazyLayoutScrollScopeKt$animateScrollToItem$1.label -= Integer.MIN_VALUE;
                Object obj2 = lazyLayoutScrollScopeKt$animateScrollToItem$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i4 = lazyLayoutScrollScopeKt$animateScrollToItem$1.label;
                if (i4 == 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i9 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1;
                        i10 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0;
                        lazyLayoutScrollScope4 = (LazyLayoutScrollScope) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        lazyLayoutScrollScope4.snapToItem(i10, i9);
                        return Unit.INSTANCE;
                    }
                    int i11 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$3;
                    float f9 = lazyLayoutScrollScopeKt$animateScrollToItem$1.F$2;
                    float f10 = lazyLayoutScrollScopeKt$animateScrollToItem$1.F$1;
                    float f11 = lazyLayoutScrollScopeKt$animateScrollToItem$1.F$0;
                    int i12 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$2;
                    int i13 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$1;
                    int i14 = lazyLayoutScrollScopeKt$animateScrollToItem$1.I$0;
                    intRef = (Ref.IntRef) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$3;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$2;
                    Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$1;
                    LazyLayoutScrollScope lazyLayoutScrollScope6 = (LazyLayoutScrollScope) lazyLayoutScrollScopeKt$animateScrollToItem$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        i7 = i14;
                        i6 = i11;
                        i8 = i12;
                        booleanRef2 = booleanRef3;
                        f6 = f10;
                        lazyLayoutScrollScopeKt$animateScrollToItem$13 = lazyLayoutScrollScopeKt$animateScrollToItem$1;
                        i5 = i13;
                        f4 = f11;
                        objectRef2 = objectRef3;
                        obj = coroutine_suspended;
                        f5 = f9;
                        lazyLayoutScrollScope3 = lazyLayoutScrollScope6;
                        try {
                            try {
                                intRef.element++;
                                if (booleanRef2.element && lazyLayoutScrollScope3.getItemCount() > 0) {
                                    try {
                                        try {
                                            int calculateDistanceTo$default = LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope3, i7, 0, 2, null) + i5;
                                            if (Math.abs(calculateDistanceTo$default) < f4) {
                                                if (i6 != 0) {
                                                    f8 = f4;
                                                    objectRef2.element = AnimationStateKt.copy$default((AnimationState) objectRef2.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                                                    animationState = (AnimationState) objectRef2.element;
                                                    boxFloat2 = Boxing.boxFloat(f8);
                                                    z2 = !(((Number) ((AnimationState) objectRef2.element).getVelocity()).floatValue() != 0.0f);
                                                    final boolean z3 = i6 == 0;
                                                    final LazyLayoutScrollScope lazyLayoutScrollScope7 = lazyLayoutScrollScope3;
                                                    final int i15 = i7;
                                                    final Ref.BooleanRef booleanRef4 = booleanRef2;
                                                    final float f12 = f6;
                                                    final Ref.IntRef intRef2 = intRef;
                                                    final int i16 = i8;
                                                    final int i17 = i5;
                                                    final Ref.ObjectRef objectRef4 = objectRef2;
                                                    function12 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda0
                                                        public final Object invoke(Object obj3) {
                                                            Unit animateScrollToItem$lambda$15;
                                                            animateScrollToItem$lambda$15 = LazyLayoutScrollScopeKt.animateScrollToItem$lambda$15(LazyLayoutScrollScope.this, i15, f8, floatRef, booleanRef4, z3, f12, intRef2, i16, i17, objectRef4, (AnimationScope) obj3);
                                                            return animateScrollToItem$lambda$15;
                                                        }
                                                    };
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.L$0 = lazyLayoutScrollScope3;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.L$1 = booleanRef2;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.L$2 = objectRef2;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.L$3 = intRef;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.I$0 = i7;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.I$1 = i5;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.I$2 = i8;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.F$0 = f4;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.F$1 = f6;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.F$2 = f5;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.I$3 = i6;
                                                    lazyLayoutScrollScope5 = lazyLayoutScrollScope3;
                                                    lazyLayoutScrollScopeKt$animateScrollToItem$13.label = 1;
                                                    if (SuspendAnimationKt.animateTo$default(animationState, boxFloat2, null, z2, function12, lazyLayoutScrollScopeKt$animateScrollToItem$13, 2, null) != obj) {
                                                        return obj;
                                                    }
                                                    lazyLayoutScrollScope3 = lazyLayoutScrollScope5;
                                                    intRef.element++;
                                                    if (booleanRef2.element) {
                                                        int calculateDistanceTo$default2 = LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope3, i7, 0, 2, null) + i5;
                                                        if (Math.abs(calculateDistanceTo$default2) < f4) {
                                                            f7 = Math.max(Math.abs(calculateDistanceTo$default2), f5);
                                                            if (i6 == 0) {
                                                                f7 = -f7;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    f7 = -f4;
                                                }
                                            }
                                            f8 = f7;
                                            objectRef2.element = AnimationStateKt.copy$default((AnimationState) objectRef2.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                                            animationState = (AnimationState) objectRef2.element;
                                            boxFloat2 = Boxing.boxFloat(f8);
                                            z2 = !(((Number) ((AnimationState) objectRef2.element).getVelocity()).floatValue() != 0.0f);
                                            if (i6 == 0) {
                                            }
                                            final LazyLayoutScrollScope lazyLayoutScrollScope72 = lazyLayoutScrollScope3;
                                            final int i152 = i7;
                                            final Ref.BooleanRef booleanRef42 = booleanRef2;
                                            final float f122 = f6;
                                            final Ref.IntRef intRef22 = intRef;
                                            final int i162 = i8;
                                            final int i172 = i5;
                                            final Ref.ObjectRef objectRef42 = objectRef2;
                                            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda0
                                                public final Object invoke(Object obj3) {
                                                    Unit animateScrollToItem$lambda$15;
                                                    animateScrollToItem$lambda$15 = LazyLayoutScrollScopeKt.animateScrollToItem$lambda$15(LazyLayoutScrollScope.this, i152, f8, floatRef2, booleanRef42, z3, f122, intRef22, i162, i172, objectRef42, (AnimationScope) obj3);
                                                    return animateScrollToItem$lambda$15;
                                                }
                                            };
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.L$0 = lazyLayoutScrollScope3;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.L$1 = booleanRef2;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.L$2 = objectRef2;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.L$3 = intRef;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.I$0 = i7;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.I$1 = i5;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.I$2 = i8;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.F$0 = f4;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.F$1 = f6;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.F$2 = f5;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.I$3 = i6;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$13.label = 1;
                                            if (SuspendAnimationKt.animateTo$default(animationState, boxFloat2, null, z2, function12, lazyLayoutScrollScopeKt$animateScrollToItem$13, 2, null) != obj) {
                                            }
                                        } catch (ItemFoundInScroll e) {
                                            e = e;
                                            i10 = i7;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$13;
                                            coroutine_suspended = obj;
                                            z = false;
                                            lazyLayoutScrollScope2 = lazyLayoutScrollScope5;
                                            copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                            final float itemOffset = e.getItemOffset() + i5;
                                            final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                                            boxFloat = Boxing.boxFloat(itemOffset);
                                            if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
                                            }
                                            function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj3) {
                                                    Unit animateScrollToItem$lambda$19;
                                                    animateScrollToItem$lambda$19 = LazyLayoutScrollScopeKt.animateScrollToItem$lambda$19(itemOffset, floatRef3, lazyLayoutScrollScope2, (AnimationScope) obj3);
                                                    return animateScrollToItem$lambda$19;
                                                }
                                            };
                                            lazyLayoutScrollScopeKt$animateScrollToItem$12.L$0 = lazyLayoutScrollScope2;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$12.L$1 = null;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$12.L$2 = null;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$12.L$3 = null;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$12.I$0 = i10;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$12.I$1 = i5;
                                            lazyLayoutScrollScopeKt$animateScrollToItem$12.label = 2;
                                            if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, !z, function1, lazyLayoutScrollScopeKt$animateScrollToItem$12, 2, null) == coroutine_suspended) {
                                            }
                                        }
                                        lazyLayoutScrollScope5 = lazyLayoutScrollScope3;
                                    } catch (ItemFoundInScroll e2) {
                                        e = e2;
                                        LazyLayoutScrollScope lazyLayoutScrollScope8 = lazyLayoutScrollScope3;
                                        i10 = i7;
                                        lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$13;
                                        coroutine_suspended = obj;
                                        lazyLayoutScrollScope2 = lazyLayoutScrollScope8;
                                        z = false;
                                    }
                                }
                            } catch (ItemFoundInScroll e3) {
                                e = e3;
                                lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$13;
                                coroutine_suspended = obj;
                                z = false;
                                int i18 = i7;
                                lazyLayoutScrollScope2 = lazyLayoutScrollScope3;
                                i10 = i18;
                            }
                        } catch (ItemFoundInScroll e4) {
                            e = e4;
                            lazyLayoutScrollScope5 = lazyLayoutScrollScope3;
                        }
                    } catch (ItemFoundInScroll e5) {
                        e = e5;
                        lazyLayoutScrollScope2 = lazyLayoutScrollScope6;
                        i10 = i14;
                        z = false;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$1;
                        i5 = i13;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj2);
                if (!(((float) i10) >= 0.0f)) {
                    InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative");
                }
                try {
                    f = density.toPx-0680j_4(TargetDistance);
                    f2 = density.toPx-0680j_4(BoundDistance);
                    f3 = density.toPx-0680j_4(MinimumDistance);
                    booleanRef = new Ref.BooleanRef();
                    booleanRef.element = true;
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
                } catch (ItemFoundInScroll e6) {
                    e = e6;
                    lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                    z = false;
                }
                if (isItemVisible(lazyLayoutScrollScope, i)) {
                    lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                    z = false;
                    try {
                        throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope2, i10, 0, 2, null), (AnimationState) objectRef.element);
                    } catch (ItemFoundInScroll e7) {
                        e = e7;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$1;
                        i5 = i2;
                        copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                        final float itemOffset2 = e.getItemOffset() + i5;
                        final Ref.FloatRef floatRef32 = new Ref.FloatRef();
                        boxFloat = Boxing.boxFloat(itemOffset2);
                        if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
                        }
                        function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj3) {
                                Unit animateScrollToItem$lambda$19;
                                animateScrollToItem$lambda$19 = LazyLayoutScrollScopeKt.animateScrollToItem$lambda$19(itemOffset2, floatRef32, lazyLayoutScrollScope2, (AnimationScope) obj3);
                                return animateScrollToItem$lambda$19;
                            }
                        };
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$0 = lazyLayoutScrollScope2;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$1 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$2 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$3 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$0 = i10;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$1 = i5;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.label = 2;
                        if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, !z, function1, lazyLayoutScrollScopeKt$animateScrollToItem$12, 2, null) == coroutine_suspended) {
                        }
                    }
                } else {
                    try {
                        i6 = i10 > lazyLayoutScrollScope.getFirstVisibleItemIndex() ? 1 : 0;
                        Ref.IntRef intRef3 = new Ref.IntRef();
                        intRef3.element = 1;
                        f4 = f;
                        booleanRef2 = booleanRef;
                        intRef = intRef3;
                        i7 = i10;
                        obj = coroutine_suspended;
                        objectRef2 = objectRef;
                        lazyLayoutScrollScope3 = lazyLayoutScrollScope;
                        f5 = f3;
                        f6 = f2;
                        i8 = i3;
                        lazyLayoutScrollScopeKt$animateScrollToItem$13 = lazyLayoutScrollScopeKt$animateScrollToItem$1;
                        i5 = i2;
                        if (booleanRef2.element) {
                        }
                    } catch (ItemFoundInScroll e8) {
                        e = e8;
                        lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12 = lazyLayoutScrollScopeKt$animateScrollToItem$1;
                        z = false;
                        i5 = i2;
                        copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                        final float itemOffset22 = e.getItemOffset() + i5;
                        final Ref.FloatRef floatRef322 = new Ref.FloatRef();
                        boxFloat = Boxing.boxFloat(itemOffset22);
                        if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
                        }
                        function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj3) {
                                Unit animateScrollToItem$lambda$19;
                                animateScrollToItem$lambda$19 = LazyLayoutScrollScopeKt.animateScrollToItem$lambda$19(itemOffset22, floatRef322, lazyLayoutScrollScope2, (AnimationScope) obj3);
                                return animateScrollToItem$lambda$19;
                            }
                        };
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$0 = lazyLayoutScrollScope2;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$1 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$2 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$3 = null;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$0 = i10;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$1 = i5;
                        lazyLayoutScrollScopeKt$animateScrollToItem$12.label = 2;
                        if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, !z, function1, lazyLayoutScrollScopeKt$animateScrollToItem$12, 2, null) == coroutine_suspended) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                final float itemOffset222 = e.getItemOffset() + i5;
                final Ref.FloatRef floatRef3222 = new Ref.FloatRef();
                boxFloat = Boxing.boxFloat(itemOffset222);
                if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
                    z = true;
                }
                function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj3) {
                        Unit animateScrollToItem$lambda$19;
                        animateScrollToItem$lambda$19 = LazyLayoutScrollScopeKt.animateScrollToItem$lambda$19(itemOffset222, floatRef3222, lazyLayoutScrollScope2, (AnimationScope) obj3);
                        return animateScrollToItem$lambda$19;
                    }
                };
                lazyLayoutScrollScopeKt$animateScrollToItem$12.L$0 = lazyLayoutScrollScope2;
                lazyLayoutScrollScopeKt$animateScrollToItem$12.L$1 = null;
                lazyLayoutScrollScopeKt$animateScrollToItem$12.L$2 = null;
                lazyLayoutScrollScopeKt$animateScrollToItem$12.L$3 = null;
                lazyLayoutScrollScopeKt$animateScrollToItem$12.I$0 = i10;
                lazyLayoutScrollScopeKt$animateScrollToItem$12.I$1 = i5;
                lazyLayoutScrollScopeKt$animateScrollToItem$12.label = 2;
                if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, !z, function1, lazyLayoutScrollScopeKt$animateScrollToItem$12, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i9 = i5;
                lazyLayoutScrollScope4 = lazyLayoutScrollScope2;
                lazyLayoutScrollScope4.snapToItem(i10, i9);
                return Unit.INSTANCE;
            }
        }
        lazyLayoutScrollScopeKt$animateScrollToItem$1 = new LazyLayoutScrollScopeKt$animateScrollToItem$1(continuation);
        Object obj22 = lazyLayoutScrollScopeKt$animateScrollToItem$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i4 = lazyLayoutScrollScopeKt$animateScrollToItem$1.label;
        if (i4 == 0) {
        }
        copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        final float itemOffset2222 = e.getItemOffset() + i5;
        final Ref.FloatRef floatRef32222 = new Ref.FloatRef();
        boxFloat = Boxing.boxFloat(itemOffset2222);
        if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
        }
        function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj3) {
                Unit animateScrollToItem$lambda$19;
                animateScrollToItem$lambda$19 = LazyLayoutScrollScopeKt.animateScrollToItem$lambda$19(itemOffset2222, floatRef32222, lazyLayoutScrollScope2, (AnimationScope) obj3);
                return animateScrollToItem$lambda$19;
            }
        };
        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$0 = lazyLayoutScrollScope2;
        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$1 = null;
        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$2 = null;
        lazyLayoutScrollScopeKt$animateScrollToItem$12.L$3 = null;
        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$0 = i10;
        lazyLayoutScrollScopeKt$animateScrollToItem$12.I$1 = i5;
        lazyLayoutScrollScopeKt$animateScrollToItem$12.label = 2;
        if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, !z, function1, lazyLayoutScrollScopeKt$animateScrollToItem$12, 2, null) == coroutine_suspended) {
        }
    }

    private static final boolean animateScrollToItem$isOvershot(boolean z, LazyLayoutScrollScope lazyLayoutScrollScope, int i, int i2) {
        if (z) {
            if (lazyLayoutScrollScope.getFirstVisibleItemIndex() <= i && (lazyLayoutScrollScope.getFirstVisibleItemIndex() != i || lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() <= i2)) {
                return false;
            }
        } else if (lazyLayoutScrollScope.getFirstVisibleItemIndex() >= i && (lazyLayoutScrollScope.getFirstVisibleItemIndex() != i || lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() >= i2)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateScrollToItem$lambda$15(LazyLayoutScrollScope lazyLayoutScrollScope, int i, float f, Ref.FloatRef floatRef, Ref.BooleanRef booleanRef, boolean z, float f2, Ref.IntRef intRef, int i2, int i3, Ref.ObjectRef objectRef, AnimationScope animationScope) {
        float coerceAtLeast;
        if (!isItemVisible(lazyLayoutScrollScope, i)) {
            if (f > 0.0f) {
                coerceAtLeast = RangesKt.coerceAtMost(((Number) animationScope.getValue()).floatValue(), f);
            } else {
                coerceAtLeast = RangesKt.coerceAtLeast(((Number) animationScope.getValue()).floatValue(), f);
            }
            float f3 = coerceAtLeast - floatRef.element;
            float scrollBy = lazyLayoutScrollScope.scrollBy(f3);
            if (!isItemVisible(lazyLayoutScrollScope, i) && !animateScrollToItem$isOvershot(z, lazyLayoutScrollScope, i, i3)) {
                if (!(f3 == scrollBy)) {
                    animationScope.cancelAnimation();
                    booleanRef.element = false;
                    return Unit.INSTANCE;
                }
                floatRef.element += f3;
                if (z) {
                    if (((Number) animationScope.getValue()).floatValue() > f2) {
                        animationScope.cancelAnimation();
                    }
                } else if (((Number) animationScope.getValue()).floatValue() < (-f2)) {
                    animationScope.cancelAnimation();
                }
                if (z) {
                    if (intRef.element >= 2 && i - lazyLayoutScrollScope.getLastVisibleItemIndex() > i2) {
                        lazyLayoutScrollScope.snapToItem(i - i2, 0);
                    }
                } else if (intRef.element >= 2 && lazyLayoutScrollScope.getFirstVisibleItemIndex() - i > i2) {
                    lazyLayoutScrollScope.snapToItem(i2 + i, 0);
                }
            }
        }
        if (animateScrollToItem$isOvershot(z, lazyLayoutScrollScope, i, i3)) {
            lazyLayoutScrollScope.snapToItem(i, i3);
            booleanRef.element = false;
            animationScope.cancelAnimation();
            return Unit.INSTANCE;
        }
        if (isItemVisible(lazyLayoutScrollScope, i)) {
            throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope, i, 0, 2, null), (AnimationState) objectRef.element);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if ((r0 == ((java.lang.Number) r6.getValue()).floatValue()) == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit animateScrollToItem$lambda$19(float f, Ref.FloatRef floatRef, LazyLayoutScrollScope lazyLayoutScrollScope, AnimationScope animationScope) {
        float f2 = 0.0f;
        if (f > 0.0f) {
            f2 = RangesKt.coerceAtMost(((Number) animationScope.getValue()).floatValue(), f);
        } else if (f < 0.0f) {
            f2 = RangesKt.coerceAtLeast(((Number) animationScope.getValue()).floatValue(), f);
        }
        float f3 = f2 - floatRef.element;
        if (f3 == lazyLayoutScrollScope.scrollBy(f3)) {
        }
        animationScope.cancelAnimation();
        floatRef.element += f3;
        return Unit.INSTANCE;
    }
}
