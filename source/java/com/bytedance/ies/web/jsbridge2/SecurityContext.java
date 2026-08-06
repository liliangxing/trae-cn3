package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
public class SecurityContext {
    String authUrl = "";
    String authFeId = "";
    String methodName = "";
    String appId = "";
    String appVersion = "";
    String containerType = "";
    String channel = "";

    public String getAuthUrl() {
        return this.authUrl;
    }

    public void setAuthUrl(String str) {
        this.authUrl = str;
    }

    public String getAuthFeId() {
        return this.authFeId;
    }

    public void setAuthFeId(String str) {
        this.authFeId = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getContainerType() {
        return this.containerType;
    }

    public void setContainerType(String str) {
        this.containerType = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String str) {
        this.methodName = str;
    }
}
