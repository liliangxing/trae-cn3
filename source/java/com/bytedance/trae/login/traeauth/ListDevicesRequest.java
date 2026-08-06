package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/login/traeauth/ListDevicesRequest;", "", "deviceInfo", "Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "<init>", "(Lcom/bytedance/trae/login/traeauth/DeviceInfo;)V", "getDeviceInfo", "()Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ListDevicesRequest {

    @SerializedName("DeviceInfo")
    private final DeviceInfo deviceInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public ListDevicesRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ListDevicesRequest copy$default(ListDevicesRequest listDevicesRequest, DeviceInfo deviceInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceInfo = listDevicesRequest.deviceInfo;
        }
        return listDevicesRequest.copy(deviceInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final ListDevicesRequest copy(DeviceInfo deviceInfo) {
        return new ListDevicesRequest(deviceInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ListDevicesRequest) && Intrinsics.areEqual(this.deviceInfo, ((ListDevicesRequest) other).deviceInfo);
    }

    public int hashCode() {
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo == null) {
            return 0;
        }
        return deviceInfo.hashCode();
    }

    public String toString() {
        return "ListDevicesRequest(deviceInfo=" + this.deviceInfo + ')';
    }

    public ListDevicesRequest(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public /* synthetic */ ListDevicesRequest(DeviceInfo deviceInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : deviceInfo);
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }
}
