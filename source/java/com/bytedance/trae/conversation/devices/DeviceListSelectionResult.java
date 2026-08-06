package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceListSelectionPolicy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceListSelectionResult;", "", "devices", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "sessionSelectedDeviceId", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getDevices", "()Ljava/util/List;", "getSessionSelectedDeviceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceListSelectionResult {
    private final List<DeviceItem> devices;
    private final String sessionSelectedDeviceId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceListSelectionResult copy$default(DeviceListSelectionResult deviceListSelectionResult, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deviceListSelectionResult.devices;
        }
        if ((i & 2) != 0) {
            str = deviceListSelectionResult.sessionSelectedDeviceId;
        }
        return deviceListSelectionResult.copy(list, str);
    }

    public final List<DeviceItem> component1() {
        return this.devices;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionSelectedDeviceId() {
        return this.sessionSelectedDeviceId;
    }

    public final DeviceListSelectionResult copy(List<DeviceItem> devices, String sessionSelectedDeviceId) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        return new DeviceListSelectionResult(devices, sessionSelectedDeviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceListSelectionResult)) {
            return false;
        }
        DeviceListSelectionResult deviceListSelectionResult = (DeviceListSelectionResult) other;
        return Intrinsics.areEqual(this.devices, deviceListSelectionResult.devices) && Intrinsics.areEqual(this.sessionSelectedDeviceId, deviceListSelectionResult.sessionSelectedDeviceId);
    }

    public int hashCode() {
        int hashCode = this.devices.hashCode() * 31;
        String str = this.sessionSelectedDeviceId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DeviceListSelectionResult(devices=" + this.devices + ", sessionSelectedDeviceId=" + this.sessionSelectedDeviceId + ')';
    }

    public DeviceListSelectionResult(List<DeviceItem> devices, String str) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        this.devices = devices;
        this.sessionSelectedDeviceId = str;
    }

    public final List<DeviceItem> getDevices() {
        return this.devices;
    }

    public final String getSessionSelectedDeviceId() {
        return this.sessionSelectedDeviceId;
    }
}
