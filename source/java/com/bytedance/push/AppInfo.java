package com.bytedance.push;

/* loaded from: classes4.dex */
public class AppInfo {
    private int aid;
    private String appName;
    private String channel;
    private int updateVersionCode;
    private int versionCode;
    private String versionName;

    public int getAid() {
        return this.aid;
    }

    public void setAid(int i) {
        this.aid = i;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public int getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public void setUpdateVersionCode(int i) {
        this.updateVersionCode = i;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String toString() {
        return "AppInfo{aid=" + this.aid + ", versionCode=" + this.versionCode + ", versionName='" + this.versionName + "', updateVersionCode=" + this.updateVersionCode + ", channel='" + this.channel + "', appName='" + this.appName + "'}";
    }
}
