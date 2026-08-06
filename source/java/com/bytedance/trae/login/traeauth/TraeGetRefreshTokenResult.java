package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JV\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;", "", "refreshToken", "", "refreshExpireAt", "", "boundDeviceId", "deviceBindStatus", "bindDeadlineAt", "deviceLimitReached", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getRefreshToken", "()Ljava/lang/String;", "getRefreshExpireAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBoundDeviceId", "getDeviceBindStatus", "getBindDeadlineAt", "getDeviceLimitReached", "()Ljava/lang/Boolean;", "setDeviceLimitReached", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeGetRefreshTokenResult {

    @SerializedName("BindDeadlineAt")
    private final Long bindDeadlineAt;

    @SerializedName("BoundDeviceID")
    private final String boundDeviceId;

    @SerializedName("DeviceBindStatus")
    private final String deviceBindStatus;

    @SerializedName("DeviceLimitReached")
    private Boolean deviceLimitReached;

    @SerializedName("RefreshExpireAt")
    private final Long refreshExpireAt;

    @SerializedName("RefreshToken")
    private final String refreshToken;

    public TraeGetRefreshTokenResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ TraeGetRefreshTokenResult copy$default(TraeGetRefreshTokenResult traeGetRefreshTokenResult, String str, Long l, String str2, String str3, Long l2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traeGetRefreshTokenResult.refreshToken;
        }
        if ((i & 2) != 0) {
            l = traeGetRefreshTokenResult.refreshExpireAt;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            str2 = traeGetRefreshTokenResult.boundDeviceId;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = traeGetRefreshTokenResult.deviceBindStatus;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            l2 = traeGetRefreshTokenResult.bindDeadlineAt;
        }
        Long l4 = l2;
        if ((i & 32) != 0) {
            bool = traeGetRefreshTokenResult.deviceLimitReached;
        }
        return traeGetRefreshTokenResult.copy(str, l3, str4, str5, l4, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getRefreshExpireAt() {
        return this.refreshExpireAt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBoundDeviceId() {
        return this.boundDeviceId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceBindStatus() {
        return this.deviceBindStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getBindDeadlineAt() {
        return this.bindDeadlineAt;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getDeviceLimitReached() {
        return this.deviceLimitReached;
    }

    public final TraeGetRefreshTokenResult copy(String refreshToken, Long refreshExpireAt, String boundDeviceId, String deviceBindStatus, Long bindDeadlineAt, Boolean deviceLimitReached) {
        return new TraeGetRefreshTokenResult(refreshToken, refreshExpireAt, boundDeviceId, deviceBindStatus, bindDeadlineAt, deviceLimitReached);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeGetRefreshTokenResult)) {
            return false;
        }
        TraeGetRefreshTokenResult traeGetRefreshTokenResult = (TraeGetRefreshTokenResult) other;
        return Intrinsics.areEqual(this.refreshToken, traeGetRefreshTokenResult.refreshToken) && Intrinsics.areEqual(this.refreshExpireAt, traeGetRefreshTokenResult.refreshExpireAt) && Intrinsics.areEqual(this.boundDeviceId, traeGetRefreshTokenResult.boundDeviceId) && Intrinsics.areEqual(this.deviceBindStatus, traeGetRefreshTokenResult.deviceBindStatus) && Intrinsics.areEqual(this.bindDeadlineAt, traeGetRefreshTokenResult.bindDeadlineAt) && Intrinsics.areEqual(this.deviceLimitReached, traeGetRefreshTokenResult.deviceLimitReached);
    }

    public int hashCode() {
        String str = this.refreshToken;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.refreshExpireAt;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.boundDeviceId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceBindStatus;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l2 = this.bindDeadlineAt;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool = this.deviceLimitReached;
        return hashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "TraeGetRefreshTokenResult(refreshToken=" + this.refreshToken + ", refreshExpireAt=" + this.refreshExpireAt + ", boundDeviceId=" + this.boundDeviceId + ", deviceBindStatus=" + this.deviceBindStatus + ", bindDeadlineAt=" + this.bindDeadlineAt + ", deviceLimitReached=" + this.deviceLimitReached + ')';
    }

    public TraeGetRefreshTokenResult(String str, Long l, String str2, String str3, Long l2, Boolean bool) {
        this.refreshToken = str;
        this.refreshExpireAt = l;
        this.boundDeviceId = str2;
        this.deviceBindStatus = str3;
        this.bindDeadlineAt = l2;
        this.deviceLimitReached = bool;
    }

    public /* synthetic */ TraeGetRefreshTokenResult(String str, Long l, String str2, String str3, Long l2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : bool);
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final Long getRefreshExpireAt() {
        return this.refreshExpireAt;
    }

    public final String getBoundDeviceId() {
        return this.boundDeviceId;
    }

    public final String getDeviceBindStatus() {
        return this.deviceBindStatus;
    }

    public final Long getBindDeadlineAt() {
        return this.bindDeadlineAt;
    }

    public final Boolean getDeviceLimitReached() {
        return this.deviceLimitReached;
    }

    public final void setDeviceLimitReached(Boolean bool) {
        this.deviceLimitReached = bool;
    }
}
