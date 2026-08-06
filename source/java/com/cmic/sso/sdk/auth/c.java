package com.cmic.sso.sdk.auth;

import android.text.TextUtils;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.account.model.internal.BDAccountPlatformEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthnResult.java */
/* loaded from: classes6.dex */
public class c {
    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", str);
            jSONObject.put("desc", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(String str, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        String b;
        String[] strArr = {"未知", BDAccountPlatformEntity.CM, BDAccountPlatformEntity.CU, BDAccountPlatformEntity.CT};
        try {
            b = aVar.b(OnekeyLoginConstants.OPERATOR_TYPE, "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!"0".equals(b) && !TextUtils.isEmpty(b)) {
            jSONObject.put("operatorType", strArr[Integer.parseInt(b)]);
            return jSONObject;
        }
        if (OnekeyLoginConstants.CM_RESULT_SUCCESS.equals(str)) {
            jSONObject.put("operatorType", strArr[1]);
        } else {
            jSONObject.put("operatorType", strArr[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", OnekeyLoginConstants.CM_RESULT_SUCCESS);
            jSONObject.put("desc", RouterConstants.TRUE);
            jSONObject.put(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", str);
            jSONObject.put("desc", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = "0";
        JSONObject jSONObject2 = new JSONObject();
        try {
            int parseInt = Integer.parseInt(aVar.b("authType", "0"));
            int c = aVar.c("networktype");
            if (parseInt == 3) {
                if (c == 3) {
                    str4 = "WIFI下网关鉴权";
                    str5 = "1";
                } else {
                    str4 = "网关鉴权";
                    str5 = "2";
                }
                String str7 = str5;
                str3 = str4;
                str6 = str7;
            } else {
                str3 = "其他";
            }
            jSONObject2.put("resultCode", str);
            jSONObject2.put("authType", str6);
            jSONObject2.put("authTypeDes", str3);
            if (OnekeyLoginConstants.CM_RESULT_SUCCESS.equals(str)) {
                if (1 == aVar.c("logintype")) {
                    jSONObject2.put("openId", aVar.b("openId"));
                    jSONObject2.put(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, aVar.b(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP));
                }
                jSONObject2.put("token", jSONObject.optString("token"));
                jSONObject2.put(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN, jSONObject.optString(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN));
            } else {
                jSONObject2.put("desc", str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.cmic.sso.sdk.e.c.b("AuthnResult", "返回参数:" + jSONObject2.toString());
        return jSONObject2;
    }
}
