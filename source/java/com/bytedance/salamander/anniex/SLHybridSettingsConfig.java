package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorSettingsSLHybridSettingsConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b,\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00060"}, d2 = {"Lcom/bytedance/salamander/anniex/SLHybridSettingsConfig;", "", "()V", "aid", "", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "channel", "getChannel", "setChannel", "deviceBrand", "getDeviceBrand", "setDeviceBrand", "deviceId", "getDeviceId", "setDeviceId", "deviceModel", "getDeviceModel", "setDeviceModel", "host", "getHost", "setHost", "installId", "getInstallId", "setInstallId", "language", "getLanguage", "setLanguage", "os", "getOs", "setOs", "osVersion", "getOsVersion", "setOsVersion", "region", "getRegion", "setRegion", "sdkVersion", "getSdkVersion", "setSdkVersion", "updateVersionCode", "getUpdateVersionCode", "setUpdateVersionCode", "versionCode", "getVersionCode", "setVersionCode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SLHybridSettingsConfig {
    private String aid = "";
    private String host = "";
    private String os = "";
    private String osVersion = "";
    private String installId = "";
    private String deviceId = "";
    private String channel = "";
    private String versionCode = "";
    private String updateVersionCode = "";
    private String region = "";
    private String language = "";
    private String deviceModel = "";
    private String sdkVersion = "";
    private String deviceBrand = "";

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aid = str;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.os = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.osVersion = str;
    }

    public String getInstallId() {
        return this.installId;
    }

    public void setInstallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.installId = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceId = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channel = str;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.versionCode = str;
    }

    public String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public void setUpdateVersionCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updateVersionCode = str;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.region = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.language = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceModel = str;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sdkVersion = str;
    }

    public String getDeviceBrand() {
        return this.deviceBrand;
    }

    public void setDeviceBrand(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceBrand = str;
    }
}
