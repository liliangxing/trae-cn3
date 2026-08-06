package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceManagement.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceManagementKt$DeviceRow$1$6$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableFloatState $offsetX$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onSwipeInteractionChanged;
    final /* synthetic */ float $openOffset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DeviceManagementKt$DeviceRow$1$6$1(float f, Function1<? super Boolean, Unit> function1, MutableFloatState mutableFloatState) {
        this.$openOffset = f;
        this.$onSwipeInteractionChanged = function1;
        this.$offsetX$delegate = mutableFloatState;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final float f = this.$openOffset;
        final Function1<Boolean, Unit> function1 = this.$onSwipeInteractionChanged;
        final MutableFloatState mutableFloatState = this.$offsetX$delegate;
        Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit invoke$lambda$0;
                invoke$lambda$0 = DeviceManagementKt$DeviceRow$1$6$1.invoke$lambda$0(f, function1, mutableFloatState);
                return invoke$lambda$0;
            }
        };
        final Function1<Boolean, Unit> function12 = this.$onSwipeInteractionChanged;
        final MutableFloatState mutableFloatState2 = this.$offsetX$delegate;
        Function0 function02 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit invoke$lambda$1;
                invoke$lambda$1 = DeviceManagementKt$DeviceRow$1$6$1.invoke$lambda$1(function12, mutableFloatState2);
                return invoke$lambda$1;
            }
        };
        final float f2 = this.$openOffset;
        final MutableFloatState mutableFloatState3 = this.$offsetX$delegate;
        Object detectHorizontalDragGestures$default = DragGestureDetectorKt.detectHorizontalDragGestures$default(pointerInputScope, (Function1) null, function0, function02, new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit invoke$lambda$2;
                invoke$lambda$2 = DeviceManagementKt$DeviceRow$1$6$1.invoke$lambda$2(f2, mutableFloatState3, (PointerInputChange) obj, ((Float) obj2).floatValue());
                return invoke$lambda$2;
            }
        }, continuation, 1, (Object) null);
        return detectHorizontalDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectHorizontalDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2(float f, MutableFloatState mutableFloatState, PointerInputChange pointerInputChange, float f2) {
        float DeviceRow$lambda$41;
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        DeviceRow$lambda$41 = DeviceManagementKt.DeviceRow$lambda$41(mutableFloatState);
        mutableFloatState.setFloatValue(RangesKt.coerceIn(DeviceRow$lambda$41 + f2, f, 0.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(float f, Function1 function1, MutableFloatState mutableFloatState) {
        float DeviceRow$lambda$41;
        float DeviceRow$lambda$412;
        DeviceRow$lambda$41 = DeviceManagementKt.DeviceRow$lambda$41(mutableFloatState);
        if (DeviceRow$lambda$41 >= f / 2.0f) {
            f = 0.0f;
        }
        mutableFloatState.setFloatValue(f);
        DeviceRow$lambda$412 = DeviceManagementKt.DeviceRow$lambda$41(mutableFloatState);
        function1.invoke(Boolean.valueOf(DeviceRow$lambda$412 < 0.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(Function1 function1, MutableFloatState mutableFloatState) {
        float DeviceRow$lambda$41;
        DeviceRow$lambda$41 = DeviceManagementKt.DeviceRow$lambda$41(mutableFloatState);
        function1.invoke(Boolean.valueOf(DeviceRow$lambda$41 < 0.0f));
        return Unit.INSTANCE;
    }
}
