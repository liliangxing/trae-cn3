package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0011\u001a\u00020\u0005H×\u0001J\t\u0010\u0012\u001a\u00020\u0013H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;", "", "requireUsage", "", "reqSource", "", "<init>", "(ZI)V", "getRequireUsage", "()Z", "getReqSource", "()I", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserEntUsageRequest {
    public static final int $stable = 0;

    @SerializedName("req_source")
    private final int reqSource;

    @SerializedName("require_usage")
    private final boolean requireUsage;

    /* JADX WARN: Multi-variable type inference failed */
    public UserEntUsageRequest() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static /* synthetic */ UserEntUsageRequest copy$default(UserEntUsageRequest userEntUsageRequest, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = userEntUsageRequest.requireUsage;
        }
        if ((i2 & 2) != 0) {
            i = userEntUsageRequest.reqSource;
        }
        return userEntUsageRequest.copy(z, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getRequireUsage() {
        return this.requireUsage;
    }

    /* renamed from: component2, reason: from getter */
    public final int getReqSource() {
        return this.reqSource;
    }

    public final UserEntUsageRequest copy(boolean requireUsage, int reqSource) {
        return new UserEntUsageRequest(requireUsage, reqSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserEntUsageRequest)) {
            return false;
        }
        UserEntUsageRequest userEntUsageRequest = (UserEntUsageRequest) other;
        return this.requireUsage == userEntUsageRequest.requireUsage && this.reqSource == userEntUsageRequest.reqSource;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.requireUsage) * 31) + Integer.hashCode(this.reqSource);
    }

    public String toString() {
        return "UserEntUsageRequest(requireUsage=" + this.requireUsage + ", reqSource=" + this.reqSource + ')';
    }

    public UserEntUsageRequest(boolean z, int i) {
        this.requireUsage = z;
        this.reqSource = i;
    }

    public /* synthetic */ UserEntUsageRequest(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? 5 : i);
    }

    public final boolean getRequireUsage() {
        return this.requireUsage;
    }

    public final int getReqSource() {
        return this.reqSource;
    }
}
