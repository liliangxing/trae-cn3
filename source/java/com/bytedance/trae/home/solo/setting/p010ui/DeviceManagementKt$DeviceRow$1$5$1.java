package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceManagement.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceManagementKt$DeviceRow$1$5$1 implements PointerInputEventHandler {
    final /* synthetic */ DeviceManagementDevice $device;
    final /* synthetic */ boolean $isSwipeOpen;
    final /* synthetic */ Function1<DeviceManagementAction, Unit> $onAction;
    final /* synthetic */ MutableFloatState $rowAnchorX$delegate;
    final /* synthetic */ MutableFloatState $rowAnchorY$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DeviceManagementKt$DeviceRow$1$5$1(boolean z, Function1<? super DeviceManagementAction, Unit> function1, DeviceManagementDevice deviceManagementDevice, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2) {
        this.$isSwipeOpen = z;
        this.$onAction = function1;
        this.$device = deviceManagementDevice;
        this.$rowAnchorX$delegate = mutableFloatState;
        this.$rowAnchorY$delegate = mutableFloatState2;
    }

    public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final boolean z = this.$isSwipeOpen;
        final Function1<DeviceManagementAction, Unit> function1 = this.$onAction;
        final DeviceManagementDevice deviceManagementDevice = this.$device;
        final MutableFloatState mutableFloatState = this.$rowAnchorX$delegate;
        final MutableFloatState mutableFloatState2 = this.$rowAnchorY$delegate;
        Object detectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, (Function1) null, new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = DeviceManagementKt$DeviceRow$1$5$1.invoke$lambda$0(z, pointerInputScope, function1, deviceManagementDevice, mutableFloatState, mutableFloatState2, (Offset) obj);
                return invoke$lambda$0;
            }
        }, (Function3) null, (Function1) null, continuation, 13, (Object) null);
        return detectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(boolean z, PointerInputScope pointerInputScope, Function1 function1, DeviceManagementDevice deviceManagementDevice, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, Offset offset) {
        float DeviceRow$lambda$44;
        float DeviceRow$lambda$47;
        if (!z) {
            DeviceRow$lambda$44 = DeviceManagementKt.DeviceRow$lambda$44(mutableFloatState);
            float f = (DeviceRow$lambda$44 - (((int) (pointerInputScope.getSize-YbymL2g() >> 32)) / 2.0f)) + Float.intBitsToFloat((int) (offset.unbox-impl() >> 32));
            DeviceRow$lambda$47 = DeviceManagementKt.DeviceRow$lambda$47(mutableFloatState2);
            function1.invoke(new DeviceManagementAction.OpenMenu(deviceManagementDevice, DeviceManagementMenuSource.LongPress, f, (DeviceRow$lambda$47 - (((int) (pointerInputScope.getSize-YbymL2g() & 4294967295L)) / 2.0f)) + Float.intBitsToFloat((int) (offset.unbox-impl() & 4294967295L))));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
