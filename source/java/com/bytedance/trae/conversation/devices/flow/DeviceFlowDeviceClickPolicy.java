package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.trae.conversation.devices.DeviceItem;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickRoute;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowDeviceClickPolicy.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;", "", "<init>", "()V", "resolve", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;", "device", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceFlowDeviceClickPolicy {
    public static final DeviceFlowDeviceClickPolicy INSTANCE = new DeviceFlowDeviceClickPolicy();

    /* compiled from: DeviceFlowDeviceClickPolicy.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CliType.values().length];
            try {
                iArr[CliType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CliType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CliType.REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DeviceFlowDeviceClickPolicy() {
    }

    public final DeviceFlowDeviceClickRoute resolve(DeviceItem device) {
        DeviceProductType deviceProductType;
        Intrinsics.checkNotNullParameter(device, "device");
        if (device.getType() != CliType.REMOTE && !device.isPaired()) {
            int i = WhenMappings.$EnumSwitchMapping$0[device.getType().ordinal()];
            if (i == 1) {
                deviceProductType = DeviceProductType.WORK;
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalStateException("remote handled above".toString());
                }
                deviceProductType = DeviceProductType.IDE;
            }
            return new DeviceFlowDeviceClickRoute.BindingGuide(deviceProductType);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[device.getType().ordinal()];
        if (i2 == 1) {
            if (device.isOnline()) {
                return DeviceFlowDeviceClickRoute.ProjectSelect.INSTANCE;
            }
            return new DeviceFlowDeviceClickRoute.OfflineActivation(DeviceProductType.WORK, false, 2, null);
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return DeviceFlowDeviceClickRoute.SelectDeviceDirectly.INSTANCE;
        }
        if (device.isOnline()) {
            return DeviceFlowDeviceClickRoute.ProjectSelect.INSTANCE;
        }
        return new DeviceFlowDeviceClickRoute.OfflineActivation(DeviceProductType.IDE, false, 2, null);
    }
}
