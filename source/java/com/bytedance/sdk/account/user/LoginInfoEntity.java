package com.bytedance.sdk.account.user;

import com.bytedance.sdk.account.save.database.DBData;
import com.ss.android.account.model2.LoginInfoPlatformEntity;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class LoginInfoEntity {
    private String avatarUrl;
    private String cc;
    private String email;
    private Long expireTime;
    private String loginName;
    private String loginTicket;
    private Integer loginType;
    private String maskEmail;
    private String maskMobile;
    private String mobile;
    private LoginInfoPlatformEntity platformEntity;
    private JSONObject rawData;
    private String screenName;

    public LoginInfoEntity(JSONObject jSONObject) {
        this.rawData = jSONObject;
    }

    public void extract() throws Exception {
        extract(this, this.rawData);
    }

    public static void extract(LoginInfoEntity loginInfoEntity, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("login_type")) {
            loginInfoEntity.loginType = Integer.valueOf(jSONObject.optInt("login_type"));
        }
        if (jSONObject.has("mobile")) {
            loginInfoEntity.maskMobile = jSONObject.optString("mobile");
        }
        if (jSONObject.has("login_name")) {
            loginInfoEntity.loginName = jSONObject.optString("login_name");
        }
        if (jSONObject.has("email")) {
            loginInfoEntity.maskEmail = jSONObject.optString("email");
        }
        if (jSONObject.has(DBData.FIELD_SCREEN_NAME)) {
            loginInfoEntity.screenName = jSONObject.optString(DBData.FIELD_SCREEN_NAME);
        }
        if (jSONObject.has("avatar_url")) {
            loginInfoEntity.avatarUrl = jSONObject.optString("avatar_url");
        }
        if (jSONObject.has("login_ticket")) {
            loginInfoEntity.loginTicket = jSONObject.optString("login_ticket");
        }
        if (jSONObject.has("expire_time")) {
            loginInfoEntity.expireTime = Long.valueOf(jSONObject.optLong("expire_time"));
        }
        if (jSONObject.has("connect")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("connect");
            loginInfoEntity.platformEntity = new LoginInfoPlatformEntity(optJSONObject.has("platform") ? optJSONObject.optString("platform") : null, optJSONObject.has(DBData.FIELD_PLATFORM_SCREEN_NAME) ? optJSONObject.optString(DBData.FIELD_PLATFORM_SCREEN_NAME) : null, optJSONObject.has("profile_image_url") ? optJSONObject.optString("profile_image_url") : null);
        }
    }

    public Integer getLoginType() {
        return this.loginType;
    }

    public String getMaskMobile() {
        return this.maskMobile;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getMaskEmail() {
        return this.maskEmail;
    }

    public LoginInfoPlatformEntity getPlatformEntity() {
        return this.platformEntity;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getLoginTicket() {
        return this.loginTicket;
    }

    public Long getExpireTime() {
        return this.expireTime;
    }

    public JSONObject getRawData() {
        return this.rawData;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getCc() {
        return this.cc;
    }

    public void setCc(String str) {
        this.cc = str;
    }

    public String toString() {
        return "LoginInfoEntity{loginType=" + this.loginType + ", maskMobile='" + this.maskMobile + "', loginName='" + this.loginName + "', maskEmail='" + this.maskEmail + "', platformEntity=" + this.platformEntity + ", screenName='" + this.screenName + "', avatarUrl='" + this.avatarUrl + "', loginTicket='" + this.loginTicket + "', expireTime=" + this.expireTime + ", rawData=" + this.rawData + ", mobile='" + this.mobile + "', email='" + this.email + "', cc='" + this.cc + "'}";
    }
}
