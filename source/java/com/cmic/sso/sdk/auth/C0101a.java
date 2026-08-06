package com.cmic.sso.sdk.auth;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.C0104b;
import com.cmic.sso.sdk.p003c.p006c.C0121a;
import com.cmic.sso.sdk.p003c.p006c.InterfaceC0124d;
import com.cmic.sso.sdk.p009e.C0131a;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0134d;
import com.cmic.sso.sdk.p009e.C0138h;
import com.cmic.sso.sdk.p009e.C0141k;
import com.cmic.sso.sdk.p009e.C0142l;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthnBusiness.java */
/* renamed from: com.cmic.sso.sdk.auth.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0101a {

    /* renamed from: c */
    private static C0101a f155c;

    /* renamed from: a */
    private final C0121a f156a = C0121a.m254a();

    /* renamed from: b */
    private final Context f157b;

    private C0101a(Context context) {
        this.f157b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C0101a m158a(Context context) {
        if (f155c == null) {
            synchronized (C0101a.class) {
                if (f155c == null) {
                    f155c = new C0101a(context);
                }
            }
        }
        return f155c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m164a(C0088a c0088a, InterfaceC0102b interfaceC0102b) {
        C0133c.m328b("AuthnBusiness", "LoginCheck method start");
        int m70c = c0088a.m70c("logintype");
        if (c0088a.m69b("isCacheScrip", false)) {
            String m68b = c0088a.m68b("securityphone", "");
            if (m70c == 3) {
                interfaceC0102b.mo157a("103000", "true", c0088a, C0103c.m165a(m68b));
                return;
            } else {
                m163b(c0088a, interfaceC0102b);
                return;
            }
        }
        m163b(c0088a, interfaceC0102b);
    }

    /* renamed from: b */
    private void m163b(final C0088a c0088a, final InterfaceC0102b interfaceC0102b) {
        C0133c.m328b("AuthnBusiness", "getScripAndToken start");
        boolean m69b = c0088a.m69b("isGotScrip", false);
        C0133c.m328b("AuthnBusiness", "isGotScrip = " + m69b);
        if (!m69b) {
            m159a(c0088a);
            if (!c0088a.m69b("isCacheScrip", false)) {
                m162b(c0088a);
                if (c0088a.m70c("networktype") == 3 && c0088a.m70c("logintype") != 3) {
                    c0088a.m61a("isRisk", true);
                }
            }
            if (c0088a.m70c("logintype") == 1) {
                c0088a.m60a("userCapaid", "200");
            } else if (c0088a.m70c("logintype") == 0) {
                c0088a.m60a("userCapaid", "50");
            }
        }
        this.f156a.m256a(c0088a, new InterfaceC0124d() { // from class: com.cmic.sso.sdk.auth.a.1
            @Override // com.cmic.sso.sdk.p003c.p006c.InterfaceC0124d
            /* renamed from: a */
            public void mo127a(String str, String str2, JSONObject jSONObject) {
                C0101a.this.m160a(c0088a, interfaceC0102b, str, str2, jSONObject);
            }
        });
    }

    /* renamed from: a */
    private void m159a(C0088a c0088a) {
        String packageName = this.f157b.getPackageName();
        String m330a = C0134d.m330a(C0142l.m382a(this.f157b, packageName));
        c0088a.m60a("apppackage", packageName);
        c0088a.m60a("appsign", m330a);
    }

    /* renamed from: b */
    private void m162b(C0088a c0088a) {
        byte[] bArr = new byte[0];
        if (c0088a.m69b("use2048PublicKey", false)) {
            C0133c.m326a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
            bArr = C0131a.m316a();
        } else {
            C0133c.m326a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
            try {
                bArr = UUID.randomUUID().toString().substring(0, 16).getBytes("utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        byte[] m316a = C0131a.m316a();
        c0088a.m62a(C0104b.a.f162a, bArr);
        c0088a.m62a(C0104b.a.f163b, m316a);
        c0088a.m60a("authType", "3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m160a(C0088a c0088a, InterfaceC0102b interfaceC0102b, String str, String str2, JSONObject jSONObject) {
        String m317b;
        JSONException jSONException;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if ("103000".equals(str)) {
            String optString = jSONObject.optString("resultdata");
            if (TextUtils.isEmpty(optString)) {
                m317b = jSONObject.toString();
            } else {
                m317b = C0131a.m317b(c0088a.m63a(C0104b.a.f162a), optString, c0088a.m63a(C0104b.a.f163b));
            }
            String str6 = null;
            try {
                jSONObject3 = new JSONObject(m317b);
                try {
                    str4 = jSONObject3.optString("phonescrip");
                } catch (JSONException e) {
                    e = e;
                    str4 = null;
                    str5 = null;
                }
            } catch (JSONException e2) {
                jSONException = e2;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            try {
                str5 = jSONObject3.optString("securityphone");
                try {
                    str6 = jSONObject3.optString("openId");
                    if (TextUtils.isEmpty(str6)) {
                        str6 = jSONObject3.optString("pcid");
                    }
                    C0141k.m371a("securityphone", str5);
                    jSONObject2 = jSONObject3;
                } catch (JSONException e3) {
                    jSONException = e3;
                    str3 = str6;
                    str6 = jSONObject3;
                    jSONException.printStackTrace();
                    jSONObject2 = str6;
                    str6 = str3;
                    String str7 = str5;
                    String str8 = str4;
                    C0133c.m328b("AuthnBusiness", "securityPhone  = " + str7);
                    c0088a.m60a("openId", str6);
                    c0088a.m60a("phonescrip", str8);
                    c0088a.m60a("securityphone", str7);
                    if (jSONObject2 != 0) {
                    }
                }
            } catch (JSONException e4) {
                e = e4;
                str5 = null;
                str6 = jSONObject3;
                jSONException = e;
                str3 = str5;
                jSONException.printStackTrace();
                jSONObject2 = str6;
                str6 = str3;
                String str72 = str5;
                String str82 = str4;
                C0133c.m328b("AuthnBusiness", "securityPhone  = " + str72);
                c0088a.m60a("openId", str6);
                c0088a.m60a("phonescrip", str82);
                c0088a.m60a("securityphone", str72);
                if (jSONObject2 != 0) {
                }
            }
            String str722 = str5;
            String str822 = str4;
            C0133c.m328b("AuthnBusiness", "securityPhone  = " + str722);
            c0088a.m60a("openId", str6);
            c0088a.m60a("phonescrip", str822);
            c0088a.m60a("securityphone", str722);
            if (jSONObject2 != 0) {
                if (!c0088a.m69b("isRisk", false)) {
                    C0138h.m344a(this.f157b, str822, Long.parseLong(jSONObject2.optString("scripExpiresIn", AddressParam.TYPE_DISAPPROVE)), c0088a.m68b("scripKey", ""), c0088a.m68b("scripType", ""));
                }
                if (c0088a.m70c("logintype") == 3) {
                    interfaceC0102b.mo157a(str, "true", c0088a, C0103c.m165a(str722));
                    return;
                } else {
                    if (c0088a.m69b("isRisk", false)) {
                        c0088a.m61a("isRisk", false);
                        c0088a.m61a("isGotScrip", true);
                        m163b(c0088a, interfaceC0102b);
                        return;
                    }
                    interfaceC0102b.mo157a(str, str2, c0088a, jSONObject2);
                    return;
                }
            }
            C0133c.m326a("AuthnBusiness", "返回103000，但是数据解析出错");
            interfaceC0102b.mo157a(String.valueOf(102223), "数据解析异常", c0088a, C0103c.m167a(String.valueOf(102223), "数据解析异常"));
            return;
        }
        if (c0088a.m70c("logintype") == 3) {
            interfaceC0102b.mo157a(str, "true", c0088a, C0103c.m169b(str, str2));
        } else {
            interfaceC0102b.mo157a(str, str2, c0088a, jSONObject);
        }
    }
}
