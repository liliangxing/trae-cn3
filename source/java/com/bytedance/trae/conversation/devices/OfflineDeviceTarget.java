package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceOfflineRecoveryPolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;", "", "deviceId", "", "deviceName", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "isPaired", "", "enterFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/devices/DeviceProductType;ZLjava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "()Z", "getEnterFrom", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OfflineDeviceTarget {
    private final String deviceId;
    private final String deviceName;
    private final String enterFrom;
    private final boolean isPaired;
    private final DeviceProductType productType;

    public static /* synthetic */ OfflineDeviceTarget copy$default(OfflineDeviceTarget offlineDeviceTarget, String str, String str2, DeviceProductType deviceProductType, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offlineDeviceTarget.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = offlineDeviceTarget.deviceName;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            deviceProductType = offlineDeviceTarget.productType;
        }
        DeviceProductType deviceProductType2 = deviceProductType;
        if ((i & 8) != 0) {
            z = offlineDeviceTarget.isPaired;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str3 = offlineDeviceTarget.enterFrom;
        }
        return offlineDeviceTarget.copy(str, str4, deviceProductType2, z2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* renamed from: component3, reason: from getter */
    public final DeviceProductType getProductType() {
        return this.productType;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsPaired() {
        return this.isPaired;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final OfflineDeviceTarget copy(String deviceId, String deviceName, DeviceProductType productType, boolean isPaired, String enterFrom) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        return new OfflineDeviceTarget(deviceId, deviceName, productType, isPaired, enterFrom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineDeviceTarget)) {
            return false;
        }
        OfflineDeviceTarget offlineDeviceTarget = (OfflineDeviceTarget) other;
        return Intrinsics.areEqual(this.deviceId, offlineDeviceTarget.deviceId) && Intrinsics.areEqual(this.deviceName, offlineDeviceTarget.deviceName) && this.productType == offlineDeviceTarget.productType && this.isPaired == offlineDeviceTarget.isPaired && Intrinsics.areEqual(this.enterFrom, offlineDeviceTarget.enterFrom);
    }

    public int hashCode() {
        return (((((((this.deviceId.hashCode() * 31) + this.deviceName.hashCode()) * 31) + this.productType.hashCode()) * 31) + Boolean.hashCode(this.isPaired)) * 31) + this.enterFrom.hashCode();
    }

    public String toString() {
        return "OfflineDeviceTarget(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", productType=" + this.productType + ", isPaired=" + this.isPaired + ", enterFrom=" + this.enterFrom + ')';
    }

    public OfflineDeviceTarget(String deviceId, String deviceName, DeviceProductType productType, boolean z, String enterFrom) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.productType = productType;
        this.isPaired = z;
        this.enterFrom = enterFrom;
    }

    public /* synthetic */ OfflineDeviceTarget(String str, String str2, DeviceProductType deviceProductType, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, deviceProductType, (i & 8) != 0 ? true : z, (i & 16) != 0 ? ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST : str3);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final DeviceProductType getProductType() {
        return this.productType;
    }

    public final boolean isPaired() {
        return this.isPaired;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }
}
