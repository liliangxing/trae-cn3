package com.bytedance.news.common.settings.api.model;

/* loaded from: classes4.dex */
public class SettingsRequestParamsModel {
    public int appId;
    public String callerName;
    public String channel;
    public String deviceBrand;
    public long deviceId;
    public String devicePlatform;
    public String deviceType;
    public long iid;
    public String language;
    public int osApi;
    public String osVersion;
    public String region;
    public int updateVersionCode;
    public int versionCode;

    public String getStringForChecking() {
        return (this.appId + ";" + this.channel + ";" + this.deviceBrand + ";" + this.deviceId + ";" + this.devicePlatform + ";" + this.deviceType + ";" + this.osApi + ";" + this.osVersion + ";" + this.updateVersionCode + ";" + this.versionCode).toLowerCase();
    }
}
