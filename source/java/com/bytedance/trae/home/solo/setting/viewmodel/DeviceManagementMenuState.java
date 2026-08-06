package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001a\u001a\u00020\u001bH×\u0001J\t\u0010\u001c\u001a\u00020\u001dH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;", "", "device", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "source", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;", "anchorX", "", "anchorY", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;FF)V", "getDevice", "()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "getSource", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;", "getAnchorX", "()F", "getAnchorY", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceManagementMenuState {
    public static final int $stable = 0;
    private final float anchorX;
    private final float anchorY;
    private final DeviceManagementDevice device;
    private final DeviceManagementMenuSource source;

    public static /* synthetic */ DeviceManagementMenuState copy$default(DeviceManagementMenuState deviceManagementMenuState, DeviceManagementDevice deviceManagementDevice, DeviceManagementMenuSource deviceManagementMenuSource, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceManagementDevice = deviceManagementMenuState.device;
        }
        if ((i & 2) != 0) {
            deviceManagementMenuSource = deviceManagementMenuState.source;
        }
        if ((i & 4) != 0) {
            f = deviceManagementMenuState.anchorX;
        }
        if ((i & 8) != 0) {
            f2 = deviceManagementMenuState.anchorY;
        }
        return deviceManagementMenuState.copy(deviceManagementDevice, deviceManagementMenuSource, f, f2);
    }

    /* renamed from: component1, reason: from getter */
    public final DeviceManagementDevice getDevice() {
        return this.device;
    }

    /* renamed from: component2, reason: from getter */
    public final DeviceManagementMenuSource getSource() {
        return this.source;
    }

    /* renamed from: component3, reason: from getter */
    public final float getAnchorX() {
        return this.anchorX;
    }

    /* renamed from: component4, reason: from getter */
    public final float getAnchorY() {
        return this.anchorY;
    }

    public final DeviceManagementMenuState copy(DeviceManagementDevice device, DeviceManagementMenuSource source, float anchorX, float anchorY) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(source, "source");
        return new DeviceManagementMenuState(device, source, anchorX, anchorY);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceManagementMenuState)) {
            return false;
        }
        DeviceManagementMenuState deviceManagementMenuState = (DeviceManagementMenuState) other;
        return Intrinsics.areEqual(this.device, deviceManagementMenuState.device) && this.source == deviceManagementMenuState.source && Float.compare(this.anchorX, deviceManagementMenuState.anchorX) == 0 && Float.compare(this.anchorY, deviceManagementMenuState.anchorY) == 0;
    }

    public int hashCode() {
        return (((((this.device.hashCode() * 31) + this.source.hashCode()) * 31) + Float.hashCode(this.anchorX)) * 31) + Float.hashCode(this.anchorY);
    }

    public String toString() {
        return "DeviceManagementMenuState(device=" + this.device + ", source=" + this.source + ", anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ')';
    }

    public DeviceManagementMenuState(DeviceManagementDevice device, DeviceManagementMenuSource source, float f, float f2) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(source, "source");
        this.device = device;
        this.source = source;
        this.anchorX = f;
        this.anchorY = f2;
    }

    public final DeviceManagementDevice getDevice() {
        return this.device;
    }

    public final DeviceManagementMenuSource getSource() {
        return this.source;
    }

    public final float getAnchorX() {
        return this.anchorX;
    }

    public final float getAnchorY() {
        return this.anchorY;
    }
}
