package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "", "deviceId", "", "deviceName", "deviceType", "platformCode", "clientVersion", "deviceModel", "osVersion", "lastLoginIp", "devicePublicKey", "deviceBrand", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getDeviceType", "getPlatformCode", "getClientVersion", "getDeviceModel", "getOsVersion", "getLastLoginIp", "getDevicePublicKey", "getDeviceBrand", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DeviceInfo {

    @SerializedName("ClientVersion")
    private final String clientVersion;

    @SerializedName("DeviceBrand")
    private final String deviceBrand;

    @SerializedName("DeviceID")
    private final String deviceId;

    @SerializedName("DeviceModel")
    private final String deviceModel;

    @SerializedName("DeviceName")
    private final String deviceName;

    @SerializedName("DevicePublicKey")
    private final String devicePublicKey;

    @SerializedName("DeviceType")
    private final String deviceType;

    @SerializedName("LastLoginIP")
    private final String lastLoginIp;

    @SerializedName("OSVersion")
    private final String osVersion;

    @SerializedName("PlatformCode")
    private final String platformCode;

    public DeviceInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDeviceBrand() {
        return this.deviceBrand;
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
    public final String getDevicePublicKey() {
        return this.devicePublicKey;
    }

    public final DeviceInfo copy(String deviceId, String deviceName, String deviceType, String platformCode, String clientVersion, String deviceModel, String osVersion, String lastLoginIp, String devicePublicKey, String deviceBrand) {
        return new DeviceInfo(deviceId, deviceName, deviceType, platformCode, clientVersion, deviceModel, osVersion, lastLoginIp, devicePublicKey, deviceBrand);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) other;
        return Intrinsics.areEqual(this.deviceId, deviceInfo.deviceId) && Intrinsics.areEqual(this.deviceName, deviceInfo.deviceName) && Intrinsics.areEqual(this.deviceType, deviceInfo.deviceType) && Intrinsics.areEqual(this.platformCode, deviceInfo.platformCode) && Intrinsics.areEqual(this.clientVersion, deviceInfo.clientVersion) && Intrinsics.areEqual(this.deviceModel, deviceInfo.deviceModel) && Intrinsics.areEqual(this.osVersion, deviceInfo.osVersion) && Intrinsics.areEqual(this.lastLoginIp, deviceInfo.lastLoginIp) && Intrinsics.areEqual(this.devicePublicKey, deviceInfo.devicePublicKey) && Intrinsics.areEqual(this.deviceBrand, deviceInfo.deviceBrand);
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
        String str9 = this.devicePublicKey;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.deviceBrand;
        return hashCode9 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        return "DeviceInfo(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", deviceType=" + this.deviceType + ", platformCode=" + this.platformCode + ", clientVersion=" + this.clientVersion + ", deviceModel=" + this.deviceModel + ", osVersion=" + this.osVersion + ", lastLoginIp=" + this.lastLoginIp + ", devicePublicKey=" + this.devicePublicKey + ", deviceBrand=" + this.deviceBrand + ')';
    }

    public DeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.deviceId = str;
        this.deviceName = str2;
        this.deviceType = str3;
        this.platformCode = str4;
        this.clientVersion = str5;
        this.deviceModel = str6;
        this.osVersion = str7;
        this.lastLoginIp = str8;
        this.devicePublicKey = str9;
        this.deviceBrand = str10;
    }

    public /* synthetic */ DeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) == 0 ? str10 : null);
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

    public final String getDevicePublicKey() {
        return this.devicePublicKey;
    }

    public final String getDeviceBrand() {
        return this.deviceBrand;
    }
}
