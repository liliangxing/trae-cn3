package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenRequest;", "", "clientId", "", "deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getDeviceId", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ClearRefreshTokenRequest {

    @SerializedName("ClientID")
    private final String clientId;

    @SerializedName("DeviceID")
    private final String deviceId;

    /* JADX WARN: Multi-variable type inference failed */
    public ClearRefreshTokenRequest() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClearRefreshTokenRequest copy$default(ClearRefreshTokenRequest clearRefreshTokenRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clearRefreshTokenRequest.clientId;
        }
        if ((i & 2) != 0) {
            str2 = clearRefreshTokenRequest.deviceId;
        }
        return clearRefreshTokenRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final ClearRefreshTokenRequest copy(String clientId, String deviceId) {
        return new ClearRefreshTokenRequest(clientId, deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClearRefreshTokenRequest)) {
            return false;
        }
        ClearRefreshTokenRequest clearRefreshTokenRequest = (ClearRefreshTokenRequest) other;
        return Intrinsics.areEqual(this.clientId, clearRefreshTokenRequest.clientId) && Intrinsics.areEqual(this.deviceId, clearRefreshTokenRequest.deviceId);
    }

    public int hashCode() {
        String str = this.clientId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ClearRefreshTokenRequest(clientId=" + this.clientId + ", deviceId=" + this.deviceId + ')';
    }

    public ClearRefreshTokenRequest(String str, String str2) {
        this.clientId = str;
        this.deviceId = str2;
    }

    public /* synthetic */ ClearRefreshTokenRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}
