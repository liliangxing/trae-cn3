package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessDestination;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowConnectionSuccessPolicy.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;", "", "<init>", "()V", "destination", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;", "initialRoute", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "device", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "canNavigate", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceFlowConnectionSuccessPolicy {
    public static final DeviceFlowConnectionSuccessPolicy INSTANCE = new DeviceFlowConnectionSuccessPolicy();

    private DeviceFlowConnectionSuccessPolicy() {
    }

    public static /* synthetic */ DeviceFlowConnectionSuccessDestination destination$default(DeviceFlowConnectionSuccessPolicy deviceFlowConnectionSuccessPolicy, DeviceFlowRoute deviceFlowRoute, MobileDevice mobileDevice, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return deviceFlowConnectionSuccessPolicy.destination(deviceFlowRoute, mobileDevice, z);
    }

    public final DeviceFlowConnectionSuccessDestination destination(DeviceFlowRoute initialRoute, MobileDevice device, boolean canNavigate) {
        Intrinsics.checkNotNullParameter(initialRoute, "initialRoute");
        Intrinsics.checkNotNullParameter(device, "device");
        if (!(initialRoute instanceof DeviceFlowRoute.DeviceSelect)) {
            return DeviceFlowConnectionSuccessDestination.NotifyHost.INSTANCE;
        }
        if (canNavigate) {
            return new DeviceFlowConnectionSuccessDestination.ReturnToDeviceSelection(device.getId());
        }
        return new DeviceFlowConnectionSuccessDestination.DeferReturnToDeviceSelection(device.getId());
    }
}
