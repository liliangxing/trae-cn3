package com.bytedance.sdk.account.api.call;

import com.ss.android.account.model2.BDAccountPlatformEntity;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ThirdTokenResponse extends BaseApiResponse {
    public String accessToken;
    public String captcha;
    public String descUrl;
    public long expiresIn;
    public String openId;
    public final int platformAppId;
    public final String platformName;

    @Deprecated
    public long refreshExpiresIn;
    public long refreshTime;

    @Deprecated
    public String refreshToken;
    public String scopes;

    public ThirdTokenResponse(boolean z, int i, String str, int i2) {
        super(z, i);
        this.platformName = str;
        this.platformAppId = i2;
    }

    public ThirdTokenResponse(boolean z, int i, String str, String str2) {
        super(z, i);
        int i2;
        try {
            i2 = Integer.parseInt(str2);
        } catch (Exception unused) {
            i2 = -1;
        }
        this.platformName = str;
        this.platformAppId = i2;
    }

    public void parseSuccessResponse(JSONObject jSONObject, JSONObject jSONObject2) {
        this.accessToken = jSONObject2.optString("access_token");
        this.expiresIn = jSONObject2.optLong("expires_in");
        this.openId = jSONObject2.optString("open_id");
        this.refreshToken = jSONObject2.optString("refresh_token");
        this.refreshExpiresIn = jSONObject2.optLong("refresh_expires_in");
        this.scopes = jSONObject2.optString("scopes");
        this.refreshTime = jSONObject2.optLong("refresh_time", this.expiresIn);
        this.result = jSONObject;
    }

    public void parseErrorResponse(JSONObject jSONObject, JSONObject jSONObject2) {
        this.captcha = jSONObject2.optString("captcha");
        this.descUrl = jSONObject2.optString("desc_url");
        this.result = jSONObject;
    }

    @Override // com.bytedance.sdk.account.api.call.BaseApiResponse
    public String toString() {
        return "ThirdTokenResponse{platformName='" + this.platformName + "', platformAppId=" + this.platformAppId + ", accessToken='" + this.accessToken + "', expiresIn=" + this.expiresIn + ", openId='" + this.openId + "', refreshToken='" + this.refreshToken + "', refreshExpiresIn=" + this.refreshExpiresIn + ", scopes='" + this.scopes + "', refreshTime=" + this.refreshTime + ", captcha='" + this.captcha + "', descUrl='" + this.descUrl + "'}";
    }

    public String getLoggableString() {
        return "ThirdTokenResponse{platformName='" + this.platformName + "', platformAppId=" + this.platformAppId + ", accessToken='" + BDAccountPlatformEntity.getMixValue(this.accessToken) + "', expiresIn=" + this.expiresIn + ", openId='" + BDAccountPlatformEntity.getMixValue(this.openId) + "', scopes='" + this.scopes + "'}";
    }
}
