package com.bytedance.applog.sampling;

/* loaded from: classes3.dex */
public class SamplingUser implements AbsSamplingUser {
    private String appId;
    private String deviceId;
    private String userId;
    private String userType;
    private String userUniqueId;

    public SamplingUser(String str, String str2) {
        this.appId = str;
        this.deviceId = str2;
    }

    public SamplingUser(String str, String str2, String str3) {
        this(str, str2);
        this.userUniqueId = str3;
    }

    public SamplingUser(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3);
        this.userId = str4;
        this.userType = str5;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String str) {
        this.userType = str;
    }

    public String getUserUniqueId() {
        return this.userUniqueId;
    }

    public void setUserUniqueId(String str) {
        this.userUniqueId = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    @Override // com.bytedance.applog.sampling.AbsSamplingUser
    public String getAppIdCallback() {
        return this.appId;
    }

    @Override // com.bytedance.applog.sampling.AbsSamplingUser
    public String getDeviceIdCallback() {
        return this.deviceId;
    }

    @Override // com.bytedance.applog.sampling.AbsSamplingUser
    public String getUserUniqueIdCallback() {
        return this.userUniqueId;
    }

    @Override // com.bytedance.applog.sampling.AbsSamplingUser
    public String getUserIdCallback() {
        return this.userId;
    }

    @Override // com.bytedance.applog.sampling.AbsSamplingUser
    public String getUserTypeCallback() {
        return this.userType;
    }
}
