package com.bytedance.push.model;

import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.ss.android.pushmanager.PushCommonConstants;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TokenCache {
    public String alias;
    private String deviceId;
    public String token;
    public int type;
    public long updateTime;
    private String versionCode;

    public TokenCache(int i, String str, String str2, String str3, long j, String str4) {
        this.type = i;
        this.token = str;
        this.deviceId = str2;
        this.versionCode = str3;
        this.updateTime = j;
        this.alias = str4;
    }

    public boolean isSame(TokenCache tokenCache) {
        if (tokenCache == this) {
            return true;
        }
        return tokenCache.type == this.type && TextUtils.equals(this.versionCode, tokenCache.versionCode) && TextUtils.equals(this.token, tokenCache.token) && TextUtils.equals(this.deviceId, tokenCache.deviceId) && TextUtils.equals(this.alias, tokenCache.alias);
    }

    public JSONObject toJson() {
        if (this.type <= 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("token", this.token);
            jSONObject.put(CommonConstants.KEY_DEVICE_ID, this.deviceId);
            jSONObject.put("vc", this.versionCode);
            jSONObject.put("t", this.updateTime);
            if (!TextUtils.isEmpty(this.alias)) {
                jSONObject.put(PushCommonConstants.KEY_ALIAS, this.alias);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static TokenCache parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("type");
        String optString = jSONObject.optString("token");
        String optString2 = jSONObject.optString(CommonConstants.KEY_DEVICE_ID);
        String optString3 = jSONObject.optString("vc");
        long optLong = jSONObject.optLong("t");
        String optString4 = jSONObject.optString(PushCommonConstants.KEY_ALIAS, null);
        if (optInt <= 0) {
            return null;
        }
        return new TokenCache(optInt, optString, optString2, optString3, optLong, optString4);
    }

    public String toString() {
        return "{updateTime=" + this.updateTime + ", deviceId='" + this.deviceId + "', versionCode='" + this.versionCode + "', token='" + this.token + "', type=" + this.type + AbstractJsonLexerKt.END_OBJ;
    }
}
