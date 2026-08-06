package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.trae.conversation.devices.MobileDevice;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DeviceFlowNestedFlowCallbacks.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;", "", "<init>", "()V", "withCurrentRouteRefresh", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;", "callbacks", "refreshCurrentRoute", "Lkotlin/Function0;", "", "onConnectedDevice", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceFlowNestedFlowCallbacks {
    public static final DeviceFlowNestedFlowCallbacks INSTANCE = new DeviceFlowNestedFlowCallbacks();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean withCurrentRouteRefresh$lambda$0(MobileDevice mobileDevice) {
        Intrinsics.checkNotNullParameter(mobileDevice, "it");
        return false;
    }

    private DeviceFlowNestedFlowCallbacks() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceFlowCallbacks withCurrentRouteRefresh$default(DeviceFlowNestedFlowCallbacks deviceFlowNestedFlowCallbacks, DeviceFlowCallbacks deviceFlowCallbacks, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    boolean withCurrentRouteRefresh$lambda$0;
                    withCurrentRouteRefresh$lambda$0 = DeviceFlowNestedFlowCallbacks.withCurrentRouteRefresh$lambda$0((MobileDevice) obj2);
                    return Boolean.valueOf(withCurrentRouteRefresh$lambda$0);
                }
            };
        }
        return deviceFlowNestedFlowCallbacks.withCurrentRouteRefresh(deviceFlowCallbacks, function0, function1);
    }

    public final DeviceFlowCallbacks withCurrentRouteRefresh(final DeviceFlowCallbacks callbacks, final Function0<Unit> refreshCurrentRoute, final Function1<? super MobileDevice, Boolean> onConnectedDevice) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(refreshCurrentRoute, "refreshCurrentRoute");
        Intrinsics.checkNotNullParameter(onConnectedDevice, "onConnectedDevice");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        return DeviceFlowCallbacks.copy$default(callbacks, null, null, null, new Function0() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit withCurrentRouteRefresh$lambda$1;
                withCurrentRouteRefresh$lambda$1 = DeviceFlowNestedFlowCallbacks.withCurrentRouteRefresh$lambda$1(booleanRef, refreshCurrentRoute, callbacks);
                return withCurrentRouteRefresh$lambda$1;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit withCurrentRouteRefresh$lambda$2;
                withCurrentRouteRefresh$lambda$2 = DeviceFlowNestedFlowCallbacks.withCurrentRouteRefresh$lambda$2(booleanRef, onConnectedDevice, callbacks, (MobileDevice) obj);
                return withCurrentRouteRefresh$lambda$2;
            }
        }, null, 39, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit withCurrentRouteRefresh$lambda$2(Ref.BooleanRef booleanRef, Function1 function1, DeviceFlowCallbacks deviceFlowCallbacks, MobileDevice mobileDevice) {
        Intrinsics.checkNotNullParameter(mobileDevice, "device");
        booleanRef.element = ((Boolean) function1.invoke(mobileDevice)).booleanValue();
        Function1<MobileDevice, Unit> onConnectionSuccessWithDevice = deviceFlowCallbacks.getOnConnectionSuccessWithDevice();
        if (onConnectionSuccessWithDevice != null) {
            onConnectionSuccessWithDevice.invoke(mobileDevice);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit withCurrentRouteRefresh$lambda$1(Ref.BooleanRef booleanRef, Function0 function0, DeviceFlowCallbacks deviceFlowCallbacks) {
        if (!booleanRef.element) {
            function0.invoke();
        }
        booleanRef.element = false;
        Function0<Unit> onConnectionSuccess = deviceFlowCallbacks.getOnConnectionSuccess();
        if (onConnectionSuccess != null) {
            onConnectionSuccess.invoke();
        }
        return Unit.INSTANCE;
    }
}
