package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00103\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010$J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J°\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/bytedance/trae/login/traeauth/DeviceSummary;", "", "deviceId", "", "deviceName", "deviceType", "platformCode", "clientVersion", "deviceModel", "osVersion", "lastLoginIp", "status", "firstBoundAt", "", "lastActiveAt", "currentDevice", "", "boundProducts", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getDeviceType", "getPlatformCode", "getClientVersion", "getDeviceModel", "getOsVersion", "getLastLoginIp", "getStatus", "getFirstBoundAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastActiveAt", "getCurrentDevice", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBoundProducts", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;)Lcom/bytedance/trae/login/traeauth/DeviceSummary;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DeviceSummary {

    @SerializedName("BoundProducts")
    private final List<String> boundProducts;

    @SerializedName("ClientVersion")
    private final String clientVersion;

    @SerializedName("CurrentDevice")
    private final Boolean currentDevice;

    @SerializedName("DeviceID")
    private final String deviceId;

    @SerializedName("DeviceModel")
    private final String deviceModel;

    @SerializedName("DeviceName")
    private final String deviceName;

    @SerializedName("DeviceType")
    private final String deviceType;

    @SerializedName("FirstBoundAt")
    private final Long firstBoundAt;

    @SerializedName("LastActiveAt")
    private final Long lastActiveAt;

    @SerializedName("LastLoginIP")
    private final String lastLoginIp;

    @SerializedName("OSVersion")
    private final String osVersion;

    @SerializedName("PlatformCode")
    private final String platformCode;

    @SerializedName("Status")
    private final String status;

    public DeviceSummary() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getFirstBoundAt() {
        return this.firstBoundAt;
    }

    /* renamed from: component11, reason: from getter */
    public final Long getLastActiveAt() {
        return this.lastActiveAt;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getCurrentDevice() {
        return this.currentDevice;
    }

    public final List<String> component13() {
        return this.boundProducts;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPlatformCode() {
        return this.platformCode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getClientVersion() {
        return this.clientVersion;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* renamed from: component7, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLastLoginIp() {
        return this.lastLoginIp;
    }

    /* renamed from: component9, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final DeviceSummary copy(String deviceId, String deviceName, String deviceType, String platformCode, String clientVersion, String deviceModel, String osVersion, String lastLoginIp, String status, Long firstBoundAt, Long lastActiveAt, Boolean currentDevice, List<String> boundProducts) {
        return new DeviceSummary(deviceId, deviceName, deviceType, platformCode, clientVersion, deviceModel, osVersion, lastLoginIp, status, firstBoundAt, lastActiveAt, currentDevice, boundProducts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceSummary)) {
            return false;
        }
        DeviceSummary deviceSummary = (DeviceSummary) other;
        return Intrinsics.areEqual(this.deviceId, deviceSummary.deviceId) && Intrinsics.areEqual(this.deviceName, deviceSummary.deviceName) && Intrinsics.areEqual(this.deviceType, deviceSummary.deviceType) && Intrinsics.areEqual(this.platformCode, deviceSummary.platformCode) && Intrinsics.areEqual(this.clientVersion, deviceSummary.clientVersion) && Intrinsics.areEqual(this.deviceModel, deviceSummary.deviceModel) && Intrinsics.areEqual(this.osVersion, deviceSummary.osVersion) && Intrinsics.areEqual(this.lastLoginIp, deviceSummary.lastLoginIp) && Intrinsics.areEqual(this.status, deviceSummary.status) && Intrinsics.areEqual(this.firstBoundAt, deviceSummary.firstBoundAt) && Intrinsics.areEqual(this.lastActiveAt, deviceSummary.lastActiveAt) && Intrinsics.areEqual(this.currentDevice, deviceSummary.currentDevice) && Intrinsics.areEqual(this.boundProducts, deviceSummary.boundProducts);
    }

    public int hashCode() {
        String str = this.deviceId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.platformCode;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.clientVersion;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.deviceModel;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.osVersion;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.lastLoginIp;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.status;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l = this.firstBoundAt;
        int hashCode10 = (hashCode9 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.lastActiveAt;
        int hashCode11 = (hashCode10 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool = this.currentDevice;
        int hashCode12 = (hashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<String> list = this.boundProducts;
        return hashCode12 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceSummary(deviceId=");
        sb.append(this.deviceId).append(", deviceName=").append(this.deviceName).append(", deviceType=").append(this.deviceType).append(", platformCode=").append(this.platformCode).append(", clientVersion=").append(this.clientVersion).append(", deviceModel=").append(this.deviceModel).append(", osVersion=").append(this.osVersion).append(", lastLoginIp=").append(this.lastLoginIp).append(", status=").append(this.status).append(", firstBoundAt=").append(this.firstBoundAt).append(", lastActiveAt=").append(this.lastActiveAt).append(", currentDevice=");
        sb.append(this.currentDevice).append(", boundProducts=").append(this.boundProducts).append(')');
        return sb.toString();
    }

    public DeviceSummary(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, Long l2, Boolean bool, List<String> list) {
        this.deviceId = str;
        this.deviceName = str2;
        this.deviceType = str3;
        this.platformCode = str4;
        this.clientVersion = str5;
        this.deviceModel = str6;
        this.osVersion = str7;
        this.lastLoginIp = str8;
        this.status = str9;
        this.firstBoundAt = l;
        this.lastActiveAt = l2;
        this.currentDevice = bool;
        this.boundProducts = list;
    }

    public /* synthetic */ DeviceSummary(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, Long l2, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? null : l2, (i & 2048) != 0 ? null : bool, (i & 4096) == 0 ? list : null);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getPlatformCode() {
        return this.platformCode;
    }

    public final String getClientVersion() {
        return this.clientVersion;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getLastLoginIp() {
        return this.lastLoginIp;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Long getFirstBoundAt() {
        return this.firstBoundAt;
    }

    public final Long getLastActiveAt() {
        return this.lastActiveAt;
    }

    public final Boolean getCurrentDevice() {
        return this.currentDevice;
    }

    public final List<String> getBoundProducts() {
        return this.boundProducts;
    }
}
