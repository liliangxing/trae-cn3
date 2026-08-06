package com.bytedance.apm6.consumer.slardar.header;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HeaderInfo {
    private int aid;
    private int apiVersion;
    private String appVersion;
    private String channel;
    private String currentUpdateVersionCode;
    private String deviceBrand;
    private String deviceId;
    private String deviceManufacturer;
    private String deviceModel;
    private JSONObject dynamicExtra;
    private JSONObject filters;
    private String manifestVersionCode;
    private String monitorVersion;
    private long ntpOffset;
    private long ntpTime;
    private String osVersion;
    private String packageName;
    private long phoneStartTime;
    private String processName;
    private String releaseBuild;
    private String romVersion;
    private long sid;
    private JSONObject stableExtra;
    private long uid;
    private String updateVersionCode;
    private String verifyInfo;
    private String versionCode;
    private String versionName;
    private String os = "Android";
    private String devicePlatform = "android";
    private long configTime = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAid() {
        return this.aid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOs(String str) {
        this.os = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDevicePlatform(String str) {
        this.devicePlatform = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setApiVersion(int i) {
        this.apiVersion = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDeviceBrand(String str) {
        this.deviceBrand = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDeviceManufacturer(String str) {
        this.deviceManufacturer = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProcessName(String str) {
        this.processName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSid(long j) {
        this.sid = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAid(int i) {
        this.aid = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getChannel() {
        return this.channel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setChannel(String str) {
        this.channel = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUpdateVersionCode(String str) {
        this.updateVersionCode = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAppVersion() {
        return this.appVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setManifestVersionCode(String str) {
        this.manifestVersionCode = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVersionCode(String str) {
        this.versionCode = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getVersionName() {
        return this.versionName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVersionName(String str) {
        this.versionName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getReleaseBuild() {
        return this.releaseBuild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setReleaseBuild(String str) {
        this.releaseBuild = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getOs() {
        return this.os;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDevicePlatform() {
        return this.devicePlatform;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getApiVersion() {
        return this.apiVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDeviceBrand() {
        return this.deviceBrand;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getProcessName() {
        return this.processName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getSid() {
        return this.sid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRomVersion() {
        return this.romVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPackageName(String str) {
        this.packageName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getMonitorVersion() {
        return this.monitorVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMonitorVersion(String str) {
        this.monitorVersion = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getUid() {
        return this.uid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUid(long j) {
        this.uid = j;
    }

    public JSONObject getDynamicExtra() {
        return this.dynamicExtra;
    }

    public void setDynamicExtra(JSONObject jSONObject) {
        this.dynamicExtra = jSONObject;
    }

    public JSONObject getStableExtra() {
        return this.stableExtra;
    }

    public void setStableExtra(JSONObject jSONObject) {
        this.stableExtra = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getPhoneStartTime() {
        return this.phoneStartTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPhoneStartTime(long j) {
        this.phoneStartTime = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getVerifyInfo() {
        return this.verifyInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVerifyInfo(String str) {
        this.verifyInfo = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject getFilters() {
        return this.filters;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFilters(JSONObject jSONObject) {
        this.filters = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCurrentUpdateVersionCode() {
        return this.currentUpdateVersionCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentUpdateVersionCode(String str) {
        this.currentUpdateVersionCode = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getConfigTime() {
        return this.configTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConfigTime(long j) {
        this.configTime = j;
    }

    public long getNtpTime() {
        return this.ntpTime;
    }

    public long getNtpOffset() {
        return this.ntpOffset;
    }

    public void setNtpTime(long j) {
        this.ntpTime = j;
    }

    public void setNtpOffset(long j) {
        this.ntpOffset = j;
    }

    public String toString() {
        return "HeaderInfo{aid=" + this.aid + ", deviceId='" + this.deviceId + "', channel='" + this.channel + "', updateVersionCode='" + this.updateVersionCode + "', appVersion='" + this.appVersion + "', manifestVersionCode='" + this.manifestVersionCode + "', versionCode='" + this.versionCode + "', versionName='" + this.versionName + "', releaseBuild='" + this.releaseBuild + "', os='" + this.os + "', devicePlatform='" + this.devicePlatform + "', osVersion='" + this.osVersion + "', apiVersion=" + this.apiVersion + ", deviceModel='" + this.deviceModel + "', deviceBrand='" + this.deviceBrand + "', deviceManufacturer='" + this.deviceManufacturer + "', processName='" + this.processName + "', sid=" + this.sid + ", romVersion='" + this.romVersion + "', packageName='" + this.packageName + "', monitorVersion='" + this.monitorVersion + "', uid=" + this.uid + ", phoneStartTime=" + this.phoneStartTime + ", verifyInfo='" + this.verifyInfo + "', dynamicExtra=" + this.dynamicExtra + ", stableExtra=" + this.stableExtra + ", filters=" + this.filters + ", currentUpdateVersionCode='" + this.currentUpdateVersionCode + "'}";
    }
}
