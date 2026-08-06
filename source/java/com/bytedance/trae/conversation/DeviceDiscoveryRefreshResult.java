package com.bytedance.trae.conversation;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.devices.MobileDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CliListRepository.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;", "", "devices", "", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "isSuccess", "", "<init>", "(Ljava/util/List;Z)V", "getDevices", "()Ljava/util/List;", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceDiscoveryRefreshResult {
    private final List<MobileDevice> devices;
    private final boolean isSuccess;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceDiscoveryRefreshResult copy$default(DeviceDiscoveryRefreshResult deviceDiscoveryRefreshResult, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deviceDiscoveryRefreshResult.devices;
        }
        if ((i & 2) != 0) {
            z = deviceDiscoveryRefreshResult.isSuccess;
        }
        return deviceDiscoveryRefreshResult.copy(list, z);
    }

    public final List<MobileDevice> component1() {
        return this.devices;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final DeviceDiscoveryRefreshResult copy(List<MobileDevice> devices, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        return new DeviceDiscoveryRefreshResult(devices, isSuccess);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceDiscoveryRefreshResult)) {
            return false;
        }
        DeviceDiscoveryRefreshResult deviceDiscoveryRefreshResult = (DeviceDiscoveryRefreshResult) other;
        return Intrinsics.areEqual(this.devices, deviceDiscoveryRefreshResult.devices) && this.isSuccess == deviceDiscoveryRefreshResult.isSuccess;
    }

    public int hashCode() {
        return (this.devices.hashCode() * 31) + Boolean.hashCode(this.isSuccess);
    }

    public String toString() {
        return "DeviceDiscoveryRefreshResult(devices=" + this.devices + ", isSuccess=" + this.isSuccess + ')';
    }

    public DeviceDiscoveryRefreshResult(List<MobileDevice> devices, boolean z) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        this.devices = devices;
        this.isSuccess = z;
    }

    public final List<MobileDevice> getDevices() {
        return this.devices;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
