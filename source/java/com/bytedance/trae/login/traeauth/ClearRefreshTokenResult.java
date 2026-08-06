package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;", "", "success", "", "deviceId", "", "deviceStatus", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDeviceId", "()Ljava/lang/String;", "getDeviceStatus", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ClearRefreshTokenResult {

    @SerializedName("DeviceID")
    private final String deviceId;

    @SerializedName("DeviceStatus")
    private final String deviceStatus;

    @SerializedName("Success")
    private final Boolean success;

    public ClearRefreshTokenResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ClearRefreshTokenResult copy$default(ClearRefreshTokenResult clearRefreshTokenResult, Boolean bool, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = clearRefreshTokenResult.success;
        }
        if ((i & 2) != 0) {
            str = clearRefreshTokenResult.deviceId;
        }
        if ((i & 4) != 0) {
            str2 = clearRefreshTokenResult.deviceStatus;
        }
        return clearRefreshTokenResult.copy(bool, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceStatus() {
        return this.deviceStatus;
    }

    public final ClearRefreshTokenResult copy(Boolean success, String deviceId, String deviceStatus) {
        return new ClearRefreshTokenResult(success, deviceId, deviceStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClearRefreshTokenResult)) {
            return false;
        }
        ClearRefreshTokenResult clearRefreshTokenResult = (ClearRefreshTokenResult) other;
        return Intrinsics.areEqual(this.success, clearRefreshTokenResult.success) && Intrinsics.areEqual(this.deviceId, clearRefreshTokenResult.deviceId) && Intrinsics.areEqual(this.deviceStatus, clearRefreshTokenResult.deviceStatus);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.deviceId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.deviceStatus;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ClearRefreshTokenResult(success=" + this.success + ", deviceId=" + this.deviceId + ", deviceStatus=" + this.deviceStatus + ')';
    }

    public ClearRefreshTokenResult(Boolean bool, String str, String str2) {
        this.success = bool;
        this.deviceId = str;
        this.deviceStatus = str2;
    }

    public /* synthetic */ ClearRefreshTokenResult(Boolean bool, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceStatus() {
        return this.deviceStatus;
    }
}
