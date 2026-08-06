package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\r\u001a\u00020\u000eH×\u0001J\t\u0010\u000f\u001a\u00020\u0010H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;", "", "device", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;)V", "getDevice", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceManagementDeleteState {
    public static final int $stable = 0;
    private final DeviceManagementDevice device;

    public static /* synthetic */ DeviceManagementDeleteState copy$default(DeviceManagementDeleteState deviceManagementDeleteState, DeviceManagementDevice deviceManagementDevice, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceManagementDevice = deviceManagementDeleteState.device;
        }
        return deviceManagementDeleteState.copy(deviceManagementDevice);
    }

    /* renamed from: component1, reason: from getter */
    public final DeviceManagementDevice getDevice() {
        return this.device;
    }

    public final DeviceManagementDeleteState copy(DeviceManagementDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return new DeviceManagementDeleteState(device);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeviceManagementDeleteState) && Intrinsics.areEqual(this.device, ((DeviceManagementDeleteState) other).device);
    }

    public int hashCode() {
        return this.device.hashCode();
    }

    public String toString() {
        return "DeviceManagementDeleteState(device=" + this.device + ')';
    }

    public DeviceManagementDeleteState(DeviceManagementDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.device = device;
    }

    public final DeviceManagementDevice getDevice() {
        return this.device;
    }
}
