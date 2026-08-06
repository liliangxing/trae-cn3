package com.cmic.sso.sdk.auth;

import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p009e.C0133c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthnResult.java */
/* renamed from: com.cmic.sso.sdk.auth.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0103c {
    /* renamed from: a */
    public static JSONObject m167a(String str, String str2) {
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
    /* renamed from: a */
    public static JSONObject m166a(String str, C0088a c0088a, JSONObject jSONObject) {
        String m68b;
        String[] strArr = {"未知", "移动", "联通", "电信"};
        try {
            m68b = c0088a.m68b("operatortype", AddressParam.TYPE_DISAPPROVE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!AddressParam.TYPE_DISAPPROVE.equals(m68b) && !TextUtils.isEmpty(m68b)) {
            jSONObject.put("operatorType", strArr[Integer.parseInt(m68b)]);
            return jSONObject;
        }
        if ("103000".equals(str)) {
            jSONObject.put("operatorType", strArr[1]);
        } else {
            jSONObject.put("operatorType", strArr[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static JSONObject m165a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", "103000");
            jSONObject.put("desc", "true");
            jSONObject.put("securityphone", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static JSONObject m169b(String str, String str2) {
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
    /* renamed from: a */
    public static JSONObject m168a(String str, String str2, C0088a c0088a, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = AddressParam.TYPE_DISAPPROVE;
        JSONObject jSONObject2 = new JSONObject();
        try {
            int parseInt = Integer.parseInt(c0088a.m68b("authType", AddressParam.TYPE_DISAPPROVE));
            int m70c = c0088a.m70c("networktype");
            if (parseInt == 3) {
                if (m70c == 3) {
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
            if ("103000".equals(str)) {
                if (1 == c0088a.m70c("logintype")) {
                    jSONObject2.put("openId", c0088a.m67b("openId"));
                    jSONObject2.put("securityphone", c0088a.m67b("securityphone"));
                }
                jSONObject2.put("token", jSONObject.optString("token"));
                jSONObject2.put("tokenExpiresIn", jSONObject.optString("tokenExpiresIn"));
            } else {
                jSONObject2.put("desc", str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C0133c.m328b("AuthnResult", "返回参数:" + jSONObject2.toString());
        return jSONObject2;
    }
}
