package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 d2\u00020\u0001:\u0001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010G\u001a\u00020HH\u0080@¢\u0006\u0004\bI\u0010JJ\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0015\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ%\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u0013H\u0000¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u0013H\u0002J0\u0010U\u001a\u00020H2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0006H\u0080@¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\u00020H2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020H2\u0006\u00101\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020HH\u0086@¢\u0006\u0002\u0010JJ\"\u0010^\u001a\u00020H2\u0006\u0010L\u001a\u00020\u00132\b\b\u0002\u0010_\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b`\u0010aJ\f\u0010b\u001a\u00020\u0003*\u00020\u0013H\u0002J\f\u0010c\u001a\u00020\u0003*\u00020\u0013H\u0002R1\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u0011\u0010#\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b%\u0010$R+\u0010(\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0010\u001a\u0004\b)\u0010$\"\u0004\b*\u0010+R+\u0010-\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010$\"\u0004\b/\u0010+R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0019R+\u00103\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010 \u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010:\u001a\u0002092\u0006\u0010\b\u001a\u0002098@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b>\u0010\u0010\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010=R!\u0010?\u001a\u00020@8@X\u0080\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bB\u0010'\u001a\u0004\bA\u0010\fR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/material3/TimePickerState;", "", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac$material3_release", "()J", "setCenter--gyyYBs$material3_release", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getCurrentAngle$material3_release", "()Landroidx/compose/animation/core/Animatable;", "hour", "getHour", "()I", "hourAngle", "getHourAngle$material3_release", "()F", "setHourAngle$material3_release", "(F)V", "hourAngle$delegate", "Landroidx/compose/runtime/MutableFloatState;", "hourForDisplay", "getHourForDisplay$material3_release", "is24hour", "()Z", "isAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/State;", "isAfternoonToggle", "isAfternoonToggle$material3_release", "setAfternoonToggle$material3_release", "(Z)V", "isAfternoonToggle$delegate", "isInnerCircle", "isInnerCircle$material3_release", "setInnerCircle$material3_release", "isInnerCircle$delegate", "minute", "getMinute", "minuteAngle", "getMinuteAngle$material3_release", "setMinuteAngle$material3_release", "minuteAngle$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "Landroidx/compose/material3/Selection;", "selection", "getSelection-JiIwxys$material3_release", "setSelection-iHAOin8$material3_release", "(I)V", "selection$delegate", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos-RKDOV3M$material3_release", "selectorPos$delegate", "values", "", "getValues$material3_release", "()Ljava/util/List;", "animateToCurrent", "", "animateToCurrent$material3_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSelected", "value", "isSelected$material3_release", "moveSelector", "x", "y", "maxDist", "moveSelector$material3_release", "offsetHour", "angle", "onTap", "autoSwitchToMinute", "onTap$material3_release", "(FFFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHour", "setHour$material3_release", "setMinute", "setMinute$material3_release", "settle", "update", "fromTap", "update$material3_release", "(FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHour", "toMinute", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TimePickerState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: center$delegate, reason: from kotlin metadata */
    private final MutableState center;
    private final Animatable<Float, AnimationVector1D> currentAngle;

    /* renamed from: hourAngle$delegate, reason: from kotlin metadata */
    private final MutableFloatState hourAngle;
    private final boolean is24hour;

    /* renamed from: isAfternoon$delegate, reason: from kotlin metadata */
    private final State isAfternoon;

    /* renamed from: isAfternoonToggle$delegate, reason: from kotlin metadata */
    private final MutableState isAfternoonToggle;

    /* renamed from: isInnerCircle$delegate, reason: from kotlin metadata */
    private final MutableState isInnerCircle;

    /* renamed from: minuteAngle$delegate, reason: from kotlin metadata */
    private final MutableFloatState minuteAngle;
    private final MutatorMutex mutex;

    /* renamed from: selection$delegate, reason: from kotlin metadata */
    private final MutableState selection;

    /* renamed from: selectorPos$delegate, reason: from kotlin metadata */
    private final State selectorPos;

    /* JADX INFO: Access modifiers changed from: private */
    public final float offsetHour(float angle) {
        float f = angle + 1.5707964f;
        return f < 0.0f ? f + 6.2831855f : f;
    }

    public TimePickerState(int i, int i2, final boolean z) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        if (!(i >= 0 && i < 24)) {
            throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
        }
        if (!(i2 >= 0 && i2 < 60)) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        }
        this.is24hour = z;
        this.selectorPos = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<DpOffset>() { // from class: androidx.compose.material3.TimePickerState$selectorPos$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                return DpOffset.box-impl(m3260invokeRKDOV3M());
            }

            /* renamed from: invoke-RKDOV3M, reason: not valid java name */
            public final long m3260invokeRKDOV3M() {
                boolean isInnerCircle$material3_release = TimePickerState.this.isInnerCircle$material3_release();
                float f = 2;
                float f2 = Dp.constructor-impl(TimePickerTokens.INSTANCE.m3937getClockDialSelectorHandleContainerSizeD9Ej5fM() / f);
                float f3 = Dp.constructor-impl(Dp.constructor-impl(((z && isInnerCircle$material3_release && Selection.m2900equalsimpl0(TimePickerState.this.m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2904getHourJiIwxys())) ? TimePickerKt.InnerCircleRadius : TimePickerKt.OuterCircleSizeRadius) - f2) + f2);
                return DpKt.DpOffset-YgX7TsA(Dp.constructor-impl(Dp.constructor-impl(((float) Math.cos(TimePickerState.this.getCurrentAngle$material3_release().getValue().floatValue())) * f3) + Dp.constructor-impl(TimePickerTokens.INSTANCE.m3935getClockDialContainerSizeD9Ej5fM() / f)), Dp.constructor-impl(Dp.constructor-impl(f3 * ((float) Math.sin(TimePickerState.this.getCurrentAngle$material3_release().getValue().floatValue()))) + Dp.constructor-impl(TimePickerTokens.INSTANCE.m3935getClockDialContainerSizeD9Ej5fM() / f)));
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), null, 2, null);
        this.center = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Selection.m2897boximpl(Selection.INSTANCE.m2904getHourJiIwxys()), null, 2, null);
        this.selection = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i >= 12 && !z), null, 2, null);
        this.isAfternoonToggle = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i >= 12), null, 2, null);
        this.isInnerCircle = mutableStateOf$default4;
        this.hourAngle = PrimitiveSnapshotStateKt.mutableFloatStateOf(((i % 12) * 0.5235988f) - 1.5707964f);
        this.minuteAngle = PrimitiveSnapshotStateKt.mutableFloatStateOf((i2 * 0.10471976f) - 1.5707964f);
        this.mutex = new MutatorMutex();
        this.isAfternoon = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerState$isAfternoon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m3259invoke() {
                return Boolean.valueOf((TimePickerState.this.getIs24hour() && TimePickerState.this.isInnerCircle$material3_release()) || TimePickerState.this.isAfternoonToggle$material3_release());
            }
        });
        this.currentAngle = AnimatableKt.Animatable$default(getHourAngle$material3_release(), 0.0f, 2, null);
    }

    public final int getMinute() {
        return toMinute(getMinuteAngle$material3_release());
    }

    public final int getHour() {
        return toHour(getHourAngle$material3_release()) + (isAfternoon() ? 12 : 0);
    }

    /* renamed from: is24hour, reason: from getter */
    public final boolean getIs24hour() {
        return this.is24hour;
    }

    public final int getHourForDisplay$material3_release() {
        return hourForDisplay(getHour());
    }

    /* renamed from: getSelectorPos-RKDOV3M$material3_release, reason: not valid java name */
    public final long m3256getSelectorPosRKDOV3M$material3_release() {
        return ((DpOffset) this.selectorPos.getValue()).unbox-impl();
    }

    /* renamed from: getCenter-nOcc-ac$material3_release, reason: not valid java name */
    public final long m3254getCenternOccac$material3_release() {
        return ((IntOffset) this.center.getValue()).unbox-impl();
    }

    /* renamed from: setCenter--gyyYBs$material3_release, reason: not valid java name */
    public final void m3257setCentergyyYBs$material3_release(long j) {
        this.center.setValue(IntOffset.box-impl(j));
    }

    public final List<Integer> getValues$material3_release() {
        List<Integer> list;
        List<Integer> list2;
        if (Selection.m2900equalsimpl0(m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2905getMinuteJiIwxys())) {
            list2 = TimePickerKt.Minutes;
            return list2;
        }
        list = TimePickerKt.Hours;
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSelection-JiIwxys$material3_release, reason: not valid java name */
    public final int m3255getSelectionJiIwxys$material3_release() {
        return ((Selection) this.selection.getValue()).m2903unboximpl();
    }

    /* renamed from: setSelection-iHAOin8$material3_release, reason: not valid java name */
    public final void m3258setSelectioniHAOin8$material3_release(int i) {
        this.selection.setValue(Selection.m2897boximpl(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isAfternoonToggle$material3_release() {
        return ((Boolean) this.isAfternoonToggle.getValue()).booleanValue();
    }

    public final void setAfternoonToggle$material3_release(boolean z) {
        this.isAfternoonToggle.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInnerCircle$material3_release() {
        return ((Boolean) this.isInnerCircle.getValue()).booleanValue();
    }

    public final void setInnerCircle$material3_release(boolean z) {
        this.isInnerCircle.setValue(Boolean.valueOf(z));
    }

    public final float getHourAngle$material3_release() {
        return this.hourAngle.getFloatValue();
    }

    public final void setHourAngle$material3_release(float f) {
        this.hourAngle.setFloatValue(f);
    }

    public final float getMinuteAngle$material3_release() {
        return this.minuteAngle.getFloatValue();
    }

    public final void setMinuteAngle$material3_release(float f) {
        this.minuteAngle.setFloatValue(f);
    }

    private final boolean isAfternoon() {
        return ((Boolean) this.isAfternoon.getValue()).booleanValue();
    }

    public final Animatable<Float, AnimationVector1D> getCurrentAngle$material3_release() {
        return this.currentAngle;
    }

    public final void setMinute$material3_release(int minute) {
        setMinuteAngle$material3_release((minute * 0.10471976f) - 1.5707964f);
    }

    public final void setHour$material3_release(int hour) {
        setInnerCircle$material3_release(hour >= 12);
        setHourAngle$material3_release(((hour % 12) * 0.5235988f) - 1.5707964f);
    }

    public final void moveSelector$material3_release(float x, float y, float maxDist) {
        float dist;
        if (Selection.m2900equalsimpl0(m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2904getHourJiIwxys()) && this.is24hour) {
            dist = TimePickerKt.dist(x, y, IntOffset.getX-impl(m3254getCenternOccac$material3_release()), IntOffset.getY-impl(m3254getCenternOccac$material3_release()));
            setInnerCircle$material3_release(dist < maxDist);
        }
    }

    public final boolean isSelected$material3_release(int value) {
        if (Selection.m2900equalsimpl0(m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2905getMinuteJiIwxys())) {
            if (value == getMinute()) {
                return true;
            }
        } else {
            if (getHour() == value + (isAfternoon() ? 12 : 0)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ Object update$material3_release$default(TimePickerState timePickerState, float f, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timePickerState.update$material3_release(f, z, continuation);
    }

    public final Object update$material3_release(float f, boolean z, Continuation<? super Unit> continuation) {
        Object mutate = this.mutex.mutate(MutatePriority.UserInput, new TimePickerState$update$2(this, f, z, null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToCurrent$material3_release(Continuation<? super Unit> continuation) {
        TimePickerState$animateToCurrent$1 timePickerState$animateToCurrent$1;
        TimePickerState$animateToCurrent$1 timePickerState$animateToCurrent$12;
        Object coroutine_suspended;
        int i;
        TimePickerState timePickerState;
        float f;
        Animatable<Float, AnimationVector1D> animatable;
        Float boxFloat;
        TweenSpec tween$default;
        if (continuation instanceof TimePickerState$animateToCurrent$1) {
            timePickerState$animateToCurrent$1 = (TimePickerState$animateToCurrent$1) continuation;
            if ((timePickerState$animateToCurrent$1.label & Integer.MIN_VALUE) != 0) {
                timePickerState$animateToCurrent$1.label -= Integer.MIN_VALUE;
                timePickerState$animateToCurrent$12 = timePickerState$animateToCurrent$1;
                Object obj = timePickerState$animateToCurrent$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = timePickerState$animateToCurrent$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Pair valuesForAnimation = Selection.m2900equalsimpl0(m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2904getHourJiIwxys()) ? TimePickerKt.valuesForAnimation(getMinuteAngle$material3_release(), getHourAngle$material3_release()) : TimePickerKt.valuesForAnimation(getHourAngle$material3_release(), getMinuteAngle$material3_release());
                    float floatValue = ((Number) valuesForAnimation.component1()).floatValue();
                    float floatValue2 = ((Number) valuesForAnimation.component2()).floatValue();
                    Animatable<Float, AnimationVector1D> animatable2 = this.currentAngle;
                    Float boxFloat2 = Boxing.boxFloat(floatValue);
                    timePickerState$animateToCurrent$12.L$0 = this;
                    timePickerState$animateToCurrent$12.F$0 = floatValue2;
                    timePickerState$animateToCurrent$12.label = 1;
                    if (animatable2.snapTo(boxFloat2, timePickerState$animateToCurrent$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    timePickerState = this;
                    f = floatValue2;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    f = timePickerState$animateToCurrent$12.F$0;
                    timePickerState = (TimePickerState) timePickerState$animateToCurrent$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                animatable = timePickerState.currentAngle;
                boxFloat = Boxing.boxFloat(f);
                tween$default = AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null);
                timePickerState$animateToCurrent$12.L$0 = null;
                timePickerState$animateToCurrent$12.label = 2;
                if (Animatable.animateTo$default(animatable, boxFloat, tween$default, null, null, timePickerState$animateToCurrent$12, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        timePickerState$animateToCurrent$1 = new TimePickerState$animateToCurrent$1(this, continuation);
        timePickerState$animateToCurrent$12 = timePickerState$animateToCurrent$1;
        Object obj2 = timePickerState$animateToCurrent$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = timePickerState$animateToCurrent$12.label;
        if (i != 0) {
        }
        animatable = timePickerState.currentAngle;
        boxFloat = Boxing.boxFloat(f);
        tween$default = AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null);
        timePickerState$animateToCurrent$12.L$0 = null;
        timePickerState$animateToCurrent$12.label = 2;
        if (Animatable.animateTo$default(animatable, boxFloat, tween$default, null, null, timePickerState$animateToCurrent$12, 12, null) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    private final int hourForDisplay(int hour) {
        if (this.is24hour) {
            return hour % 24;
        }
        if (hour % 12 == 0) {
            return 12;
        }
        return isAfternoon() ? hour - 12 : hour;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toHour(float f) {
        return ((int) ((f + (0.2617994f + 1.5707963267948966d)) / 0.5235988f)) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMinute(float f) {
        return ((int) ((f + (0.05235988f + 1.5707963267948966d)) / 0.10471976f)) % 60;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object settle(Continuation<? super Unit> continuation) {
        TimePickerState$settle$1 timePickerState$settle$1;
        TimePickerState$settle$1 timePickerState$settle$12;
        Object coroutine_suspended;
        int i;
        Pair valuesForAnimation;
        TimePickerState timePickerState;
        Animatable<Float, AnimationVector1D> animatable;
        Object second;
        TweenSpec tween$default;
        if (continuation instanceof TimePickerState$settle$1) {
            timePickerState$settle$1 = (TimePickerState$settle$1) continuation;
            if ((timePickerState$settle$1.label & Integer.MIN_VALUE) != 0) {
                timePickerState$settle$1.label -= Integer.MIN_VALUE;
                timePickerState$settle$12 = timePickerState$settle$1;
                Object obj = timePickerState$settle$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = timePickerState$settle$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    valuesForAnimation = TimePickerKt.valuesForAnimation(this.currentAngle.getValue().floatValue(), getMinuteAngle$material3_release());
                    Animatable<Float, AnimationVector1D> animatable2 = this.currentAngle;
                    Object first = valuesForAnimation.getFirst();
                    timePickerState$settle$12.L$0 = this;
                    timePickerState$settle$12.L$1 = valuesForAnimation;
                    timePickerState$settle$12.label = 1;
                    if (animatable2.snapTo(first, timePickerState$settle$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    timePickerState = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    valuesForAnimation = (Pair) timePickerState$settle$12.L$1;
                    timePickerState = (TimePickerState) timePickerState$settle$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                animatable = timePickerState.currentAngle;
                second = valuesForAnimation.getSecond();
                tween$default = AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null);
                timePickerState$settle$12.L$0 = null;
                timePickerState$settle$12.L$1 = null;
                timePickerState$settle$12.label = 2;
                if (Animatable.animateTo$default(animatable, second, tween$default, null, null, timePickerState$settle$12, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        timePickerState$settle$1 = new TimePickerState$settle$1(this, continuation);
        timePickerState$settle$12 = timePickerState$settle$1;
        Object obj2 = timePickerState$settle$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = timePickerState$settle$12.label;
        if (i != 0) {
        }
        animatable = timePickerState.currentAngle;
        second = valuesForAnimation.getSecond();
        tween$default = AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null);
        timePickerState$settle$12.L$0 = null;
        timePickerState$settle$12.L$1 = null;
        timePickerState$settle$12.label = 2;
        if (Animatable.animateTo$default(animatable, second, tween$default, null, null, timePickerState$settle$12, 12, null) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onTap$material3_release(float f, float f2, float f3, boolean z, Continuation<? super Unit> continuation) {
        TimePickerState$onTap$1 timePickerState$onTap$1;
        int i;
        float atan;
        boolean z2;
        float f4;
        float f5;
        TimePickerState timePickerState;
        Pair valuesForAnimation;
        Animatable<Float, AnimationVector1D> animatable;
        Object second;
        TweenSpec tween$default;
        if (continuation instanceof TimePickerState$onTap$1) {
            timePickerState$onTap$1 = (TimePickerState$onTap$1) continuation;
            if ((timePickerState$onTap$1.label & Integer.MIN_VALUE) != 0) {
                timePickerState$onTap$1.label -= Integer.MIN_VALUE;
                TimePickerState$onTap$1 timePickerState$onTap$12 = timePickerState$onTap$1;
                Object obj = timePickerState$onTap$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = timePickerState$onTap$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    atan = TimePickerKt.atan(f2 - IntOffset.getY-impl(m3254getCenternOccac$material3_release()), f - IntOffset.getX-impl(m3254getCenternOccac$material3_release()));
                    timePickerState$onTap$12.L$0 = this;
                    timePickerState$onTap$12.F$0 = f;
                    timePickerState$onTap$12.F$1 = f2;
                    timePickerState$onTap$12.F$2 = f3;
                    timePickerState$onTap$12.Z$0 = z;
                    timePickerState$onTap$12.label = 1;
                    if (update$material3_release(atan, true, timePickerState$onTap$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z2 = z;
                    f4 = f3;
                    f5 = f2;
                    timePickerState = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            if (i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        valuesForAnimation = (Pair) timePickerState$onTap$12.L$1;
                        timePickerState = (TimePickerState) timePickerState$onTap$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        animatable = timePickerState.currentAngle;
                        second = valuesForAnimation.getSecond();
                        tween$default = AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null);
                        timePickerState$onTap$12.L$0 = null;
                        timePickerState$onTap$12.L$1 = null;
                        timePickerState$onTap$12.label = 3;
                        if (Animatable.animateTo$default(animatable, second, tween$default, null, null, timePickerState$onTap$12, 12, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    boolean z3 = timePickerState$onTap$12.Z$0;
                    float f6 = timePickerState$onTap$12.F$2;
                    float f7 = timePickerState$onTap$12.F$1;
                    f = timePickerState$onTap$12.F$0;
                    TimePickerState timePickerState2 = (TimePickerState) timePickerState$onTap$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    z2 = z3;
                    f4 = f6;
                    f5 = f7;
                    timePickerState = timePickerState2;
                }
                timePickerState.moveSelector$material3_release(f, f5, f4);
                if (Selection.m2900equalsimpl0(timePickerState.m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2904getHourJiIwxys())) {
                    timePickerState$onTap$12.L$0 = null;
                    timePickerState$onTap$12.label = 4;
                    if (timePickerState.settle(timePickerState$onTap$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (!z2) {
                    valuesForAnimation = TimePickerKt.valuesForAnimation(timePickerState.currentAngle.getValue().floatValue(), timePickerState.getHourAngle$material3_release());
                    Animatable<Float, AnimationVector1D> animatable2 = timePickerState.currentAngle;
                    Object first = valuesForAnimation.getFirst();
                    timePickerState$onTap$12.L$0 = timePickerState;
                    timePickerState$onTap$12.L$1 = valuesForAnimation;
                    timePickerState$onTap$12.label = 2;
                    if (animatable2.snapTo(first, timePickerState$onTap$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    animatable = timePickerState.currentAngle;
                    second = valuesForAnimation.getSecond();
                    tween$default = AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null);
                    timePickerState$onTap$12.L$0 = null;
                    timePickerState$onTap$12.L$1 = null;
                    timePickerState$onTap$12.label = 3;
                    if (Animatable.animateTo$default(animatable, second, tween$default, null, null, timePickerState$onTap$12, 12, null) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                timePickerState.m3258setSelectioniHAOin8$material3_release(Selection.INSTANCE.m2905getMinuteJiIwxys());
                return Unit.INSTANCE;
            }
        }
        timePickerState$onTap$1 = new TimePickerState$onTap$1(this, continuation);
        TimePickerState$onTap$1 timePickerState$onTap$122 = timePickerState$onTap$1;
        Object obj2 = timePickerState$onTap$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = timePickerState$onTap$122.label;
        if (i != 0) {
        }
        timePickerState.moveSelector$material3_release(f, f5, f4);
        if (Selection.m2900equalsimpl0(timePickerState.m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2904getHourJiIwxys())) {
        }
    }

    /* compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TimePickerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerState;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerState, ?> Saver() {
            return SaverKt.Saver(new Function2<SaverScope, TimePickerState, List<? extends Object>>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$1
                public final List<Object> invoke(SaverScope saverScope, TimePickerState timePickerState) {
                    return CollectionsKt.listOf(new Object[]{Integer.valueOf(timePickerState.getHour()), Integer.valueOf(timePickerState.getMinute()), Boolean.valueOf(timePickerState.getIs24hour())});
                }
            }, new Function1<List, TimePickerState>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$2
                public final TimePickerState invoke(List<? extends Object> list) {
                    Object obj = list.get(0);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) obj).intValue();
                    Object obj2 = list.get(1);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) obj2).intValue();
                    Object obj3 = list.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    return new TimePickerState(intValue, intValue2, ((Boolean) obj3).booleanValue());
                }
            });
        }
    }
}
