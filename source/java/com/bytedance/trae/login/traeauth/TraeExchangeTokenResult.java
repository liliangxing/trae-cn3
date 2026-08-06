package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jn\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0002\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006*"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;", "", "isDeviceLimit", "", "clientId", "", "token", "tokenExpireAt", "", "refreshToken", "refreshExpireAt", "tokenExpireDuration", "deviceBindStatus", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getClientId", "()Ljava/lang/String;", "getToken", "getTokenExpireAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRefreshToken", "getRefreshExpireAt", "getTokenExpireDuration", "getDeviceBindStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeExchangeTokenResult {

    @SerializedName("ClientID")
    private final String clientId;

    @SerializedName("DeviceBindStatus")
    private final String deviceBindStatus;

    @SerializedName("IsDeviceLimit")
    private final Boolean isDeviceLimit;

    @SerializedName("RefreshExpireAt")
    private final Long refreshExpireAt;

    @SerializedName("RefreshToken")
    private final String refreshToken;

    @SerializedName("Token")
    private final String token;

    @SerializedName("TokenExpireAt")
    private final Long tokenExpireAt;

    @SerializedName("TokenExpireDuration")
    private final Long tokenExpireDuration;

    public TraeExchangeTokenResult() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsDeviceLimit() {
        return this.isDeviceLimit;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getTokenExpireAt() {
        return this.tokenExpireAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getRefreshExpireAt() {
        return this.refreshExpireAt;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getTokenExpireDuration() {
        return this.tokenExpireDuration;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDeviceBindStatus() {
        return this.deviceBindStatus;
    }

    public final TraeExchangeTokenResult copy(Boolean isDeviceLimit, String clientId, String token, Long tokenExpireAt, String refreshToken, Long refreshExpireAt, Long tokenExpireDuration, String deviceBindStatus) {
        return new TraeExchangeTokenResult(isDeviceLimit, clientId, token, tokenExpireAt, refreshToken, refreshExpireAt, tokenExpireDuration, deviceBindStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeExchangeTokenResult)) {
            return false;
        }
        TraeExchangeTokenResult traeExchangeTokenResult = (TraeExchangeTokenResult) other;
        return Intrinsics.areEqual(this.isDeviceLimit, traeExchangeTokenResult.isDeviceLimit) && Intrinsics.areEqual(this.clientId, traeExchangeTokenResult.clientId) && Intrinsics.areEqual(this.token, traeExchangeTokenResult.token) && Intrinsics.areEqual(this.tokenExpireAt, traeExchangeTokenResult.tokenExpireAt) && Intrinsics.areEqual(this.refreshToken, traeExchangeTokenResult.refreshToken) && Intrinsics.areEqual(this.refreshExpireAt, traeExchangeTokenResult.refreshExpireAt) && Intrinsics.areEqual(this.tokenExpireDuration, traeExchangeTokenResult.tokenExpireDuration) && Intrinsics.areEqual(this.deviceBindStatus, traeExchangeTokenResult.deviceBindStatus);
    }

    public int hashCode() {
        Boolean bool = this.isDeviceLimit;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.clientId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.tokenExpireAt;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.refreshToken;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l2 = this.refreshExpireAt;
        int hashCode6 = (hashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.tokenExpireDuration;
        int hashCode7 = (hashCode6 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str4 = this.deviceBindStatus;
        return hashCode7 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "TraeExchangeTokenResult(isDeviceLimit=" + this.isDeviceLimit + ", clientId=" + this.clientId + ", token=" + this.token + ", tokenExpireAt=" + this.tokenExpireAt + ", refreshToken=" + this.refreshToken + ", refreshExpireAt=" + this.refreshExpireAt + ", tokenExpireDuration=" + this.tokenExpireDuration + ", deviceBindStatus=" + this.deviceBindStatus + ')';
    }

    public TraeExchangeTokenResult(Boolean bool, String str, String str2, Long l, String str3, Long l2, Long l3, String str4) {
        this.isDeviceLimit = bool;
        this.clientId = str;
        this.token = str2;
        this.tokenExpireAt = l;
        this.refreshToken = str3;
        this.refreshExpireAt = l2;
        this.tokenExpireDuration = l3;
        this.deviceBindStatus = str4;
    }

    public /* synthetic */ TraeExchangeTokenResult(Boolean bool, String str, String str2, Long l, String str3, Long l2, Long l3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : l3, (i & 128) == 0 ? str4 : null);
    }

    public final Boolean isDeviceLimit() {
        return this.isDeviceLimit;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getToken() {
        return this.token;
    }

    public final Long getTokenExpireAt() {
        return this.tokenExpireAt;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final Long getRefreshExpireAt() {
        return this.refreshExpireAt;
    }

    public final Long getTokenExpireDuration() {
        return this.tokenExpireDuration;
    }

    public final String getDeviceBindStatus() {
        return this.deviceBindStatus;
    }
}
