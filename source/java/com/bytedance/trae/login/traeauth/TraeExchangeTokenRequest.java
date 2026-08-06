package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenRequest;", "", "clientId", "", "clientSecret", "refreshToken", "userId", "deviceInfo", "Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "deviceProof", "Lcom/bytedance/trae/login/traeauth/DeviceProof;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/login/traeauth/DeviceInfo;Lcom/bytedance/trae/login/traeauth/DeviceProof;)V", "getClientId", "()Ljava/lang/String;", "getClientSecret", "getRefreshToken", "getUserId", "getDeviceInfo", "()Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "getDeviceProof", "()Lcom/bytedance/trae/login/traeauth/DeviceProof;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeExchangeTokenRequest {

    @SerializedName("ClientID")
    private final String clientId;

    @SerializedName("ClientSecret")
    private final String clientSecret;

    @SerializedName("DeviceInfo")
    private final DeviceInfo deviceInfo;

    @SerializedName("DeviceProof")
    private final DeviceProof deviceProof;

    @SerializedName("RefreshToken")
    private final String refreshToken;

    @SerializedName("UserID")
    private final String userId;

    public static /* synthetic */ TraeExchangeTokenRequest copy$default(TraeExchangeTokenRequest traeExchangeTokenRequest, String str, String str2, String str3, String str4, DeviceInfo deviceInfo, DeviceProof deviceProof, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traeExchangeTokenRequest.clientId;
        }
        if ((i & 2) != 0) {
            str2 = traeExchangeTokenRequest.clientSecret;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = traeExchangeTokenRequest.refreshToken;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = traeExchangeTokenRequest.userId;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            deviceInfo = traeExchangeTokenRequest.deviceInfo;
        }
        DeviceInfo deviceInfo2 = deviceInfo;
        if ((i & 32) != 0) {
            deviceProof = traeExchangeTokenRequest.deviceProof;
        }
        return traeExchangeTokenRequest.copy(str, str5, str6, str7, deviceInfo2, deviceProof);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientSecret() {
        return this.clientSecret;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    /* renamed from: component6, reason: from getter */
    public final DeviceProof getDeviceProof() {
        return this.deviceProof;
    }

    public final TraeExchangeTokenRequest copy(String clientId, String clientSecret, String refreshToken, String userId, DeviceInfo deviceInfo, DeviceProof deviceProof) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        return new TraeExchangeTokenRequest(clientId, clientSecret, refreshToken, userId, deviceInfo, deviceProof);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeExchangeTokenRequest)) {
            return false;
        }
        TraeExchangeTokenRequest traeExchangeTokenRequest = (TraeExchangeTokenRequest) other;
        return Intrinsics.areEqual(this.clientId, traeExchangeTokenRequest.clientId) && Intrinsics.areEqual(this.clientSecret, traeExchangeTokenRequest.clientSecret) && Intrinsics.areEqual(this.refreshToken, traeExchangeTokenRequest.refreshToken) && Intrinsics.areEqual(this.userId, traeExchangeTokenRequest.userId) && Intrinsics.areEqual(this.deviceInfo, traeExchangeTokenRequest.deviceInfo) && Intrinsics.areEqual(this.deviceProof, traeExchangeTokenRequest.deviceProof);
    }

    public int hashCode() {
        int hashCode = ((((this.clientId.hashCode() * 31) + this.clientSecret.hashCode()) * 31) + this.refreshToken.hashCode()) * 31;
        String str = this.userId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        DeviceInfo deviceInfo = this.deviceInfo;
        int hashCode3 = (hashCode2 + (deviceInfo == null ? 0 : deviceInfo.hashCode())) * 31;
        DeviceProof deviceProof = this.deviceProof;
        return hashCode3 + (deviceProof != null ? deviceProof.hashCode() : 0);
    }

    public String toString() {
        return "TraeExchangeTokenRequest(clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ", refreshToken=" + this.refreshToken + ", userId=" + this.userId + ", deviceInfo=" + this.deviceInfo + ", deviceProof=" + this.deviceProof + ')';
    }

    public TraeExchangeTokenRequest(String clientId, String clientSecret, String refreshToken, String str, DeviceInfo deviceInfo, DeviceProof deviceProof) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.refreshToken = refreshToken;
        this.userId = str;
        this.deviceInfo = deviceInfo;
        this.deviceProof = deviceProof;
    }

    public /* synthetic */ TraeExchangeTokenRequest(String str, String str2, String str3, String str4, DeviceInfo deviceInfo, DeviceProof deviceProof, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : deviceInfo, (i & 32) != 0 ? null : deviceProof);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final DeviceProof getDeviceProof() {
        return this.deviceProof;
    }
}
