package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\\\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0002\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/trae/login/traeauth/BindDeviceResult;", "", "isDeviceLimit", "", "success", "boundDeviceId", "", "deviceBindStatus", "bindDeadlineAt", "", "devices", "", "Lcom/bytedance/trae/login/traeauth/DeviceSummary;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSuccess", "getBoundDeviceId", "()Ljava/lang/String;", "getDeviceBindStatus", "getBindDeadlineAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDevices", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lcom/bytedance/trae/login/traeauth/BindDeviceResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindDeviceResult {

    @SerializedName("BindDeadlineAt")
    private final Long bindDeadlineAt;

    @SerializedName("BoundDeviceID")
    private final String boundDeviceId;

    @SerializedName("DeviceBindStatus")
    private final String deviceBindStatus;

    @SerializedName("Devices")
    private final List<DeviceSummary> devices;

    @SerializedName("IsDeviceLimit")
    private final Boolean isDeviceLimit;

    @SerializedName("Success")
    private final Boolean success;

    public BindDeviceResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ BindDeviceResult copy$default(BindDeviceResult bindDeviceResult, Boolean bool, Boolean bool2, String str, String str2, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = bindDeviceResult.isDeviceLimit;
        }
        if ((i & 2) != 0) {
            bool2 = bindDeviceResult.success;
        }
        Boolean bool3 = bool2;
        if ((i & 4) != 0) {
            str = bindDeviceResult.boundDeviceId;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = bindDeviceResult.deviceBindStatus;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            l = bindDeviceResult.bindDeadlineAt;
        }
        Long l2 = l;
        if ((i & 32) != 0) {
            list = bindDeviceResult.devices;
        }
        return bindDeviceResult.copy(bool, bool3, str3, str4, l2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsDeviceLimit() {
        return this.isDeviceLimit;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
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

    public final List<DeviceSummary> component6() {
        return this.devices;
    }

    public final BindDeviceResult copy(Boolean isDeviceLimit, Boolean success, String boundDeviceId, String deviceBindStatus, Long bindDeadlineAt, List<DeviceSummary> devices) {
        return new BindDeviceResult(isDeviceLimit, success, boundDeviceId, deviceBindStatus, bindDeadlineAt, devices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindDeviceResult)) {
            return false;
        }
        BindDeviceResult bindDeviceResult = (BindDeviceResult) other;
        return Intrinsics.areEqual(this.isDeviceLimit, bindDeviceResult.isDeviceLimit) && Intrinsics.areEqual(this.success, bindDeviceResult.success) && Intrinsics.areEqual(this.boundDeviceId, bindDeviceResult.boundDeviceId) && Intrinsics.areEqual(this.deviceBindStatus, bindDeviceResult.deviceBindStatus) && Intrinsics.areEqual(this.bindDeadlineAt, bindDeviceResult.bindDeadlineAt) && Intrinsics.areEqual(this.devices, bindDeviceResult.devices);
    }

    public int hashCode() {
        Boolean bool = this.isDeviceLimit;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.success;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.boundDeviceId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.deviceBindStatus;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.bindDeadlineAt;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        List<DeviceSummary> list = this.devices;
        return hashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "BindDeviceResult(isDeviceLimit=" + this.isDeviceLimit + ", success=" + this.success + ", boundDeviceId=" + this.boundDeviceId + ", deviceBindStatus=" + this.deviceBindStatus + ", bindDeadlineAt=" + this.bindDeadlineAt + ", devices=" + this.devices + ')';
    }

    public BindDeviceResult(Boolean bool, Boolean bool2, String str, String str2, Long l, List<DeviceSummary> list) {
        this.isDeviceLimit = bool;
        this.success = bool2;
        this.boundDeviceId = str;
        this.deviceBindStatus = str2;
        this.bindDeadlineAt = l;
        this.devices = list;
    }

    public /* synthetic */ BindDeviceResult(Boolean bool, Boolean bool2, String str, String str2, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : list);
    }

    public final Boolean isDeviceLimit() {
        return this.isDeviceLimit;
    }

    public final Boolean getSuccess() {
        return this.success;
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

    public final List<DeviceSummary> getDevices() {
        return this.devices;
    }
}
