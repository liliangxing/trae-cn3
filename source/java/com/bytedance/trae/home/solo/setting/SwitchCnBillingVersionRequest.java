package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CNBillingVersionApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0003H×\u0001J\t\u0010\u0013\u001a\u00020\u0005H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SwitchCnBillingVersionRequest;", "", "reqSource", "", "clientVersion", "", "<init>", "(ILjava/lang/String;)V", "getReqSource", "()I", "getClientVersion", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SwitchCnBillingVersionRequest {
    public static final int $stable = 0;

    @SerializedName("client_version")
    private final String clientVersion;

    @SerializedName("req_source")
    private final int reqSource;

    public static /* synthetic */ SwitchCnBillingVersionRequest copy$default(SwitchCnBillingVersionRequest switchCnBillingVersionRequest, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = switchCnBillingVersionRequest.reqSource;
        }
        if ((i2 & 2) != 0) {
            str = switchCnBillingVersionRequest.clientVersion;
        }
        return switchCnBillingVersionRequest.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getReqSource() {
        return this.reqSource;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientVersion() {
        return this.clientVersion;
    }

    public final SwitchCnBillingVersionRequest copy(int reqSource, String clientVersion) {
        Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
        return new SwitchCnBillingVersionRequest(reqSource, clientVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwitchCnBillingVersionRequest)) {
            return false;
        }
        SwitchCnBillingVersionRequest switchCnBillingVersionRequest = (SwitchCnBillingVersionRequest) other;
        return this.reqSource == switchCnBillingVersionRequest.reqSource && Intrinsics.areEqual(this.clientVersion, switchCnBillingVersionRequest.clientVersion);
    }

    public int hashCode() {
        return (Integer.hashCode(this.reqSource) * 31) + this.clientVersion.hashCode();
    }

    public String toString() {
        return "SwitchCnBillingVersionRequest(reqSource=" + this.reqSource + ", clientVersion=" + this.clientVersion + ')';
    }

    public SwitchCnBillingVersionRequest(int i, String clientVersion) {
        Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
        this.reqSource = i;
        this.clientVersion = clientVersion;
    }

    public final int getReqSource() {
        return this.reqSource;
    }

    public final String getClientVersion() {
        return this.clientVersion;
    }
}
