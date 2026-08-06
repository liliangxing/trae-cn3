package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.w0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1185w0 {
    /* renamed from: a */
    private static void m1793a(String str, String str2) {
        C1128b0.m1435a().m1438a(new C1153j1(str, str2));
    }

    /* renamed from: a */
    public static boolean m1794a() {
        String m1691a = AbstractC1173q0.m1691a();
        if (TextUtils.isEmpty(m1691a)) {
            m1691a = C1133d.m1464a(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_time_interval", "");
            AbstractC1173q0.m1702f(m1691a);
        }
        String m1711m = AbstractC1173q0.m1711m();
        if (TextUtils.isEmpty(m1711m)) {
            m1711m = C1133d.m1464a(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_time_last", "");
            AbstractC1173q0.m1696c(m1711m);
        }
        if (!TextUtils.isEmpty(m1691a) && !TextUtils.isEmpty(m1711m)) {
            try {
                return System.currentTimeMillis() - Long.parseLong(m1711m) > ((long) Integer.parseInt(m1691a));
            } catch (NumberFormatException e) {
                C1182v.m1785e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e.getMessage());
            }
        }
        return true;
    }

    /* renamed from: b */
    public static void m1795b(String str, String str2) {
        C1164n0 c1164n0;
        String str3;
        String replace = "{url}/getPublicKey?keytype=4".replace("{url}", AbstractC1126a1.m1419f(str, str2));
        String m1701f = AbstractC1173q0.m1701f();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", m1701f);
        try {
            c1164n0 = AbstractC1184w.m1788a(replace, new byte[0], hashMap);
        } catch (Exception e) {
            C1182v.m1785e("GetPublicKey", "get pubKey response Exception :" + e.getMessage());
            c1164n0 = null;
        }
        if (c1164n0 == null) {
            str3 = "get pubKey response is null";
        } else {
            if (c1164n0.m1644b() == 200) {
                if (TextUtils.isEmpty(c1164n0.m1643a())) {
                    return;
                }
                m1797d(c1164n0.m1643a(), str2);
                return;
            }
            str3 = "get pubKey fail HttpCode :" + c1164n0.m1644b();
        }
        C1182v.m1785e("GetPublicKey", str3);
    }

    /* renamed from: c */
    public static String m1796c(String str, String str2) {
        String m1713o;
        String m1695c = AbstractC1173q0.m1695c();
        if (TextUtils.isEmpty(m1695c)) {
            m1695c = C1133d.m1464a(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_version", "");
            AbstractC1173q0.m1704g(m1695c);
        }
        if (!"2.0".equals(m1695c)) {
            m1793a(str, str2);
            return null;
        }
        if ("maint".equals(str2)) {
            m1713o = AbstractC1173q0.m1712n();
            if (TextUtils.isEmpty(m1713o)) {
                m1713o = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", C1133d.m1464a(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_maint", ""));
                AbstractC1173q0.m1698d(m1713o);
            }
        } else {
            m1713o = AbstractC1173q0.m1713o();
            if (TextUtils.isEmpty(m1713o)) {
                m1713o = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", C1133d.m1464a(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_oper", ""));
                AbstractC1173q0.m1700e(m1713o);
            }
        }
        if (!TextUtils.isEmpty(m1713o) && !m1794a()) {
            return m1713o;
        }
        m1793a(str, str2);
        return null;
    }

    /* renamed from: d */
    private static void m1797d(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("publicKey");
            String optString2 = jSONObject.optString("publicKeyOM");
            String optString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String optString4 = jSONObject.optString("timeInterval");
            C1133d.m1469b(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_oper", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString));
            C1133d.m1469b(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_maint", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            C1133d.m1469b(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_time_interval", optString4);
            C1133d.m1469b(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_version", optString3);
            C1133d.m1469b(AbstractC1173q0.m1707i(), "Privacy_MY", "public_key_time_last", str3);
            AbstractC1173q0.m1700e(optString);
            AbstractC1173q0.m1698d(optString2);
            AbstractC1173q0.m1704g(optString3);
            AbstractC1173q0.m1696c(str3);
            AbstractC1173q0.m1702f(optString4);
        } catch (JSONException e) {
            C1182v.m1785e("GetPublicKey", "get pubKey parse json JSONException :" + e.getMessage());
        }
    }
}
