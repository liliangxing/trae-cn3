package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CNUserPagStatusApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0011H×\u0001J\t\u0010\u0012\u001a\u00020\u0003H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/GetIdeUserPayStatusRequest;", "", "traeClient", "", "deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTraeClient", "()Ljava/lang/String;", "getDeviceId", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetIdeUserPayStatusRequest {
    public static final int $stable = 0;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("trae_client")
    private final String traeClient;

    /* JADX WARN: Multi-variable type inference failed */
    public GetIdeUserPayStatusRequest() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GetIdeUserPayStatusRequest copy$default(GetIdeUserPayStatusRequest getIdeUserPayStatusRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getIdeUserPayStatusRequest.traeClient;
        }
        if ((i & 2) != 0) {
            str2 = getIdeUserPayStatusRequest.deviceId;
        }
        return getIdeUserPayStatusRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraeClient() {
        return this.traeClient;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final GetIdeUserPayStatusRequest copy(String traeClient, String deviceId) {
        return new GetIdeUserPayStatusRequest(traeClient, deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetIdeUserPayStatusRequest)) {
            return false;
        }
        GetIdeUserPayStatusRequest getIdeUserPayStatusRequest = (GetIdeUserPayStatusRequest) other;
        return Intrinsics.areEqual(this.traeClient, getIdeUserPayStatusRequest.traeClient) && Intrinsics.areEqual(this.deviceId, getIdeUserPayStatusRequest.deviceId);
    }

    public int hashCode() {
        String str = this.traeClient;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "GetIdeUserPayStatusRequest(traeClient=" + this.traeClient + ", deviceId=" + this.deviceId + ')';
    }

    public GetIdeUserPayStatusRequest(String str, String str2) {
        this.traeClient = str;
        this.deviceId = str2;
    }

    public /* synthetic */ GetIdeUserPayStatusRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getTraeClient() {
        return this.traeClient;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}
