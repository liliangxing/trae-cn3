package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;", "", "clientId", "", "deviceId", "deviceInfo", "Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "deviceProof", "Lcom/bytedance/trae/login/traeauth/DeviceProof;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/login/traeauth/DeviceInfo;Lcom/bytedance/trae/login/traeauth/DeviceProof;)V", "getClientId", "()Ljava/lang/String;", "getDeviceId", "getDeviceInfo", "()Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "getDeviceProof", "()Lcom/bytedance/trae/login/traeauth/DeviceProof;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeGetRefreshTokenRequest {

    @SerializedName("clientID")
    private final String clientId;

    @SerializedName("DeviceID")
    private final String deviceId;

    @SerializedName("DeviceInfo")
    private final DeviceInfo deviceInfo;

    @SerializedName("DeviceProof")
    private final DeviceProof deviceProof;

    public TraeGetRefreshTokenRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TraeGetRefreshTokenRequest copy$default(TraeGetRefreshTokenRequest traeGetRefreshTokenRequest, String str, String str2, DeviceInfo deviceInfo, DeviceProof deviceProof, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traeGetRefreshTokenRequest.clientId;
        }
        if ((i & 2) != 0) {
            str2 = traeGetRefreshTokenRequest.deviceId;
        }
        if ((i & 4) != 0) {
            deviceInfo = traeGetRefreshTokenRequest.deviceInfo;
        }
        if ((i & 8) != 0) {
            deviceProof = traeGetRefreshTokenRequest.deviceProof;
        }
        return traeGetRefreshTokenRequest.copy(str, str2, deviceInfo, deviceProof);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component3, reason: from getter */
    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final DeviceProof getDeviceProof() {
        return this.deviceProof;
    }

    public final TraeGetRefreshTokenRequest copy(String clientId, String deviceId, DeviceInfo deviceInfo, DeviceProof deviceProof) {
        return new TraeGetRefreshTokenRequest(clientId, deviceId, deviceInfo, deviceProof);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeGetRefreshTokenRequest)) {
            return false;
        }
        TraeGetRefreshTokenRequest traeGetRefreshTokenRequest = (TraeGetRefreshTokenRequest) other;
        return Intrinsics.areEqual(this.clientId, traeGetRefreshTokenRequest.clientId) && Intrinsics.areEqual(this.deviceId, traeGetRefreshTokenRequest.deviceId) && Intrinsics.areEqual(this.deviceInfo, traeGetRefreshTokenRequest.deviceInfo) && Intrinsics.areEqual(this.deviceProof, traeGetRefreshTokenRequest.deviceProof);
    }

    public int hashCode() {
        String str = this.clientId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        DeviceInfo deviceInfo = this.deviceInfo;
        int hashCode3 = (hashCode2 + (deviceInfo == null ? 0 : deviceInfo.hashCode())) * 31;
        DeviceProof deviceProof = this.deviceProof;
        return hashCode3 + (deviceProof != null ? deviceProof.hashCode() : 0);
    }

    public String toString() {
        return "TraeGetRefreshTokenRequest(clientId=" + this.clientId + ", deviceId=" + this.deviceId + ", deviceInfo=" + this.deviceInfo + ", deviceProof=" + this.deviceProof + ')';
    }

    public TraeGetRefreshTokenRequest(String str, String str2, DeviceInfo deviceInfo, DeviceProof deviceProof) {
        this.clientId = str;
        this.deviceId = str2;
        this.deviceInfo = deviceInfo;
        this.deviceProof = deviceProof;
    }

    public /* synthetic */ TraeGetRefreshTokenRequest(String str, String str2, DeviceInfo deviceInfo, DeviceProof deviceProof, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : deviceInfo, (i & 8) != 0 ? null : deviceProof);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final DeviceProof getDeviceProof() {
        return this.deviceProof;
    }
}
