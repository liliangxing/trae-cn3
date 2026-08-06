package com.ss.android.account.model2;

/* loaded from: classes7.dex */
public class LoginInfoPlatformEntity {
    private String platform;
    private String platformScreenName;
    private String profileImageUrl;

    public LoginInfoPlatformEntity(String str, String str2, String str3) {
        this.platform = str;
        this.platformScreenName = str2;
        this.profileImageUrl = str3;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public String getPlatformScreenName() {
        return this.platformScreenName;
    }

    public String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public String toString() {
        return "LoginInfoPlatformEntity{platform='" + this.platform + "', platformScreenName='" + this.platformScreenName + "', profileImageUrl='" + this.profileImageUrl + "'}";
    }
}
