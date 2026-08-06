package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceBindingPolicy.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006%"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingTarget;", "", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "existingDeviceIds", "", "", "enterFrom", "triggerBy", "Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;", "deviceId", "deviceName", "<init>", "(Lcom/bytedance/trae/conversation/devices/DeviceProductType;Ljava/util/Set;Ljava/lang/String;Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;Ljava/lang/String;Ljava/lang/String;)V", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "getExistingDeviceIds", "()Ljava/util/Set;", "getEnterFrom", "()Ljava/lang/String;", "getTriggerBy", "()Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;", "getDeviceId", "getDeviceName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BindingTarget {
    private final String deviceId;
    private final String deviceName;
    private final String enterFrom;
    private final Set<String> existingDeviceIds;
    private final DeviceProductType productType;
    private final DevicePairingTrigger triggerBy;

    public static /* synthetic */ BindingTarget copy$default(BindingTarget bindingTarget, DeviceProductType deviceProductType, Set set, String str, DevicePairingTrigger devicePairingTrigger, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceProductType = bindingTarget.productType;
        }
        if ((i & 2) != 0) {
            set = bindingTarget.existingDeviceIds;
        }
        Set set2 = set;
        if ((i & 4) != 0) {
            str = bindingTarget.enterFrom;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            devicePairingTrigger = bindingTarget.triggerBy;
        }
        DevicePairingTrigger devicePairingTrigger2 = devicePairingTrigger;
        if ((i & 16) != 0) {
            str2 = bindingTarget.deviceId;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = bindingTarget.deviceName;
        }
        return bindingTarget.copy(deviceProductType, set2, str4, devicePairingTrigger2, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final DeviceProductType getProductType() {
        return this.productType;
    }

    public final Set<String> component2() {
        return this.existingDeviceIds;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEnterFrom() {
        return this.enterFrom;
    }

    /* renamed from: component4, reason: from getter */
    public final DevicePairingTrigger getTriggerBy() {
        return this.triggerBy;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    public final BindingTarget copy(DeviceProductType productType, Set<String> existingDeviceIds, String enterFrom, DevicePairingTrigger triggerBy, String deviceId, String deviceName) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(existingDeviceIds, "existingDeviceIds");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(triggerBy, "triggerBy");
        return new BindingTarget(productType, existingDeviceIds, enterFrom, triggerBy, deviceId, deviceName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindingTarget)) {
            return false;
        }
        BindingTarget bindingTarget = (BindingTarget) other;
        return this.productType == bindingTarget.productType && Intrinsics.areEqual(this.existingDeviceIds, bindingTarget.existingDeviceIds) && Intrinsics.areEqual(this.enterFrom, bindingTarget.enterFrom) && this.triggerBy == bindingTarget.triggerBy && Intrinsics.areEqual(this.deviceId, bindingTarget.deviceId) && Intrinsics.areEqual(this.deviceName, bindingTarget.deviceName);
    }

    public int hashCode() {
        int hashCode = ((((((this.productType.hashCode() * 31) + this.existingDeviceIds.hashCode()) * 31) + this.enterFrom.hashCode()) * 31) + this.triggerBy.hashCode()) * 31;
        String str = this.deviceId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.deviceName;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BindingTarget(productType=" + this.productType + ", existingDeviceIds=" + this.existingDeviceIds + ", enterFrom=" + this.enterFrom + ", triggerBy=" + this.triggerBy + ", deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ')';
    }

    public BindingTarget(DeviceProductType productType, Set<String> existingDeviceIds, String enterFrom, DevicePairingTrigger triggerBy, String str, String str2) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(existingDeviceIds, "existingDeviceIds");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Intrinsics.checkNotNullParameter(triggerBy, "triggerBy");
        this.productType = productType;
        this.existingDeviceIds = existingDeviceIds;
        this.enterFrom = enterFrom;
        this.triggerBy = triggerBy;
        this.deviceId = str;
        this.deviceName = str2;
    }

    public final DeviceProductType getProductType() {
        return this.productType;
    }

    public final Set<String> getExistingDeviceIds() {
        return this.existingDeviceIds;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public /* synthetic */ BindingTarget(DeviceProductType deviceProductType, Set set, String str, DevicePairingTrigger devicePairingTrigger, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceProductType, set, str, (i & 8) != 0 ? DevicePairingTrigger.CONNECT_BUTTON : devicePairingTrigger, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }

    public final DevicePairingTrigger getTriggerBy() {
        return this.triggerBy;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }
}
