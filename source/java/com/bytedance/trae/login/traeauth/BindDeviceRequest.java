package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/login/traeauth/BindDeviceRequest;", "", "refreshToken", "", "deviceInfo", "Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "deviceProof", "Lcom/bytedance/trae/login/traeauth/DeviceProof;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/login/traeauth/DeviceInfo;Lcom/bytedance/trae/login/traeauth/DeviceProof;)V", "getRefreshToken", "()Ljava/lang/String;", "getDeviceInfo", "()Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "getDeviceProof", "()Lcom/bytedance/trae/login/traeauth/DeviceProof;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindDeviceRequest {

    @SerializedName("DeviceInfo")
    private final DeviceInfo deviceInfo;

    @SerializedName("DeviceProof")
    private final DeviceProof deviceProof;

    @SerializedName("RefreshToken")
    private final String refreshToken;

    public static /* synthetic */ BindDeviceRequest copy$default(BindDeviceRequest bindDeviceRequest, String str, DeviceInfo deviceInfo, DeviceProof deviceProof, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bindDeviceRequest.refreshToken;
        }
        if ((i & 2) != 0) {
            deviceInfo = bindDeviceRequest.deviceInfo;
        }
        if ((i & 4) != 0) {
            deviceProof = bindDeviceRequest.deviceProof;
        }
        return bindDeviceRequest.copy(str, deviceInfo, deviceProof);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* renamed from: component2, reason: from getter */
    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final DeviceProof getDeviceProof() {
        return this.deviceProof;
    }

    public final BindDeviceRequest copy(String refreshToken, DeviceInfo deviceInfo, DeviceProof deviceProof) {
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        return new BindDeviceRequest(refreshToken, deviceInfo, deviceProof);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindDeviceRequest)) {
            return false;
        }
        BindDeviceRequest bindDeviceRequest = (BindDeviceRequest) other;
        return Intrinsics.areEqual(this.refreshToken, bindDeviceRequest.refreshToken) && Intrinsics.areEqual(this.deviceInfo, bindDeviceRequest.deviceInfo) && Intrinsics.areEqual(this.deviceProof, bindDeviceRequest.deviceProof);
    }

    public int hashCode() {
        int hashCode = ((this.refreshToken.hashCode() * 31) + this.deviceInfo.hashCode()) * 31;
        DeviceProof deviceProof = this.deviceProof;
        return hashCode + (deviceProof == null ? 0 : deviceProof.hashCode());
    }

    public String toString() {
        return "BindDeviceRequest(refreshToken=" + this.refreshToken + ", deviceInfo=" + this.deviceInfo + ", deviceProof=" + this.deviceProof + ')';
    }

    public BindDeviceRequest(String refreshToken, DeviceInfo deviceInfo, DeviceProof deviceProof) {
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.refreshToken = refreshToken;
        this.deviceInfo = deviceInfo;
        this.deviceProof = deviceProof;
    }

    public /* synthetic */ BindDeviceRequest(String str, DeviceInfo deviceInfo, DeviceProof deviceProof, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, deviceInfo, (i & 4) != 0 ? null : deviceProof);
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final DeviceProof getDeviceProof() {
        return this.deviceProof;
    }
}
