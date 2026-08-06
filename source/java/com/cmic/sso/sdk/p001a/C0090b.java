package com.cmic.sso.sdk.p001a;

import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.p001a.C0089a;
import com.cmic.sso.sdk.p003c.p006c.C0121a;
import com.cmic.sso.sdk.p003c.p006c.InterfaceC0124d;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0141k;
import com.cmic.sso.sdk.p009e.C0144n;
import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONObject;

/* compiled from: UmcConfigHandle.java */
/* renamed from: com.cmic.sso.sdk.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0090b {

    /* renamed from: c */
    private static C0090b f108c;

    /* renamed from: a */
    private C0089a f109a;

    /* renamed from: b */
    private final C0089a f110b;

    /* renamed from: d */
    private volatile boolean f111d = false;

    /* renamed from: e */
    private a f112e;

    /* compiled from: UmcConfigHandle.java */
    /* renamed from: com.cmic.sso.sdk.a.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    interface a {
        /* renamed from: a */
        void mo129a(C0089a c0089a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m123a(a aVar) {
        this.f112e = aVar;
    }

    private C0090b(boolean z) {
        C0089a m99a = new C0089a.a().m99a();
        this.f110b = m99a;
        if (!z) {
            this.f109a = m121d();
        } else {
            this.f109a = m99a;
        }
    }

    /* renamed from: a */
    public static C0090b m111a(boolean z) {
        if (f108c == null) {
            synchronized (C0090b.class) {
                if (f108c == null) {
                    f108c = new C0090b(z);
                }
            }
        }
        return f108c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C0089a m122a() {
        return this.f110b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m119b(C0088a c0088a) {
        if (this.f111d) {
            C0133c.m326a("UmcConfigHandle", "正在获取配置中...");
        } else {
            this.f111d = true;
            C0121a.m254a().m258a(false, c0088a, new InterfaceC0124d() { // from class: com.cmic.sso.sdk.a.b.1
                @Override // com.cmic.sso.sdk.p003c.p006c.InterfaceC0124d
                /* renamed from: a */
                public void mo127a(String str, String str2, JSONObject jSONObject) {
                    try {
                        if ("103000".equals(str)) {
                            C0090b.this.m115a(jSONObject);
                            C0141k.m371a("sdk_config_version", AuthnHelper.SDK_VERSION);
                            C0090b c0090b = C0090b.this;
                            c0090b.f109a = c0090b.m121d();
                            if (C0090b.this.f112e != null) {
                                C0090b.this.f112e.mo129a(C0090b.this.f109a);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    C0090b.this.f111d = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m115a(JSONObject jSONObject) {
        C0141k.a m373b = C0141k.m373b("sso_config_xf");
        try {
            if (jSONObject.has("client_valid")) {
                m373b.m378a("client_valid", System.currentTimeMillis() + (Integer.parseInt(jSONObject.getString("client_valid")) * 60 * 60 * 1000));
            }
            if (jSONObject.has("Configlist")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("Configlist");
                if (jSONObject2.has("CHANGE_HOST")) {
                    String string = jSONObject2.getString("CHANGE_HOST");
                    if (string.contains("M007")) {
                        String m112a = m112a(string, "M007");
                        if (!TextUtils.isEmpty(m112a)) {
                            m373b.m379a("logHost", m112a);
                        }
                    }
                    if (string.contains("M008")) {
                        String m112a2 = m112a(string, "M008");
                        if (!TextUtils.isEmpty(m112a2)) {
                            m373b.m379a("https_get_phone_scrip_host", m112a2);
                        }
                    }
                    if (string.contains("M009")) {
                        String m112a3 = m112a(string, "M009");
                        if (!TextUtils.isEmpty(m112a3)) {
                            m373b.m379a("config_host", m112a3);
                        }
                    }
                } else {
                    m373b.m376a("logHost");
                    m373b.m376a("https_get_phone_scrip_host");
                    m373b.m376a("config_host");
                }
                m116a(jSONObject2, "CLOSE_FRIEND_WAPKS", AddressParam.TYPE_DISAPPROVE, m373b);
                m116a(jSONObject2, "CLOSE_LOGS_VERSION", AddressParam.TYPE_DISAPPROVE, m373b);
                m116a(jSONObject2, "CLOSE_IPV4_LIST", AddressParam.TYPE_DISAPPROVE, m373b);
                m116a(jSONObject2, "CLOSE_IPV6_LIST", AddressParam.TYPE_DISAPPROVE, m373b);
                m116a(jSONObject2, "CLOSE_M008_SDKVERSION_LIST", AddressParam.TYPE_DISAPPROVE, m373b);
                m116a(jSONObject2, "CLOSE_M008_APPID_LIST", AddressParam.TYPE_DISAPPROVE, m373b);
                if (jSONObject2.has("LOGS_CONTROL")) {
                    String[] split = jSONObject2.getString("LOGS_CONTROL").replace("h", "").split(ContainerUtils.FIELD_DELIMITER);
                    if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        try {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            m373b.m377a("maxFailedLogTimes", parseInt);
                            m373b.m377a("pauseTime", parseInt2);
                        } catch (Exception unused) {
                            C0133c.m326a("UmcConfigHandle", "解析日志上报限制时间次数异常");
                        }
                    }
                } else {
                    m373b.m376a("maxFailedLogTimes");
                    m373b.m376a("pauseTime");
                }
            }
            m373b.m380b();
        } catch (Exception e) {
            C0133c.m326a("UmcConfigHandle", "配置项异常，配置失效");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m112a(String str, String str2) {
        String str3;
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str3 = "";
                break;
            }
            str3 = split[i];
            if (str3.contains(str2)) {
                break;
            }
            i++;
        }
        return !TextUtils.isEmpty(str3) ? str3.substring(str3.lastIndexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1) : str3;
    }

    /* renamed from: a */
    private void m116a(JSONObject jSONObject, String str, String str2, C0141k.a aVar) {
        if (jSONObject.has(str)) {
            String optString = jSONObject.optString(str, str2);
            if (!"CLOSE_FRIEND_WAPKS".equals(str)) {
                if (!AddressParam.TYPE_DISAPPROVE.equals(optString) && !"1".equals(optString)) {
                    return;
                }
            } else {
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                if (!optString.contains("CU") && !optString.contains("CT") && !optString.contains("CM")) {
                    return;
                }
            }
            aVar.m379a(str, jSONObject.optString(str, str2));
            return;
        }
        aVar.m376a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public C0089a m125b() {
        return this.f109a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public C0089a m121d() {
        return new C0089a.a().m97a(C0092d.m140b(this.f110b.m83a())).m103c(C0092d.m136a(this.f110b.m85c())).m101b(C0092d.m140b(this.f110b.m84b())).m105d(C0092d.m142c(this.f110b.m86d())).m106d(C0092d.m138a(this.f110b.m90h())).m107e(C0092d.m141b(this.f110b.m91i())).m98a(C0092d.m145e(this.f110b.m87e())).m102b(C0092d.m144d(this.f110b.m88f())).m104c(C0092d.m143c(this.f110b.m89g())).m108f(C0092d.m146f(this.f110b.m92j())).m96a(C0092d.m135a(this.f110b.m93k())).m100b(C0092d.m139b(this.f110b.m94l())).m99a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m124a(final C0088a c0088a) {
        if (C0092d.m137a()) {
            C0144n.m391a(new C0144n.a() { // from class: com.cmic.sso.sdk.a.b.2
                @Override // com.cmic.sso.sdk.p009e.C0144n.a
                /* renamed from: a */
                protected void mo128a() {
                    C0133c.m328b("UmcConfigHandle", "开始拉取配置..");
                    C0090b.this.m119b(c0088a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m126c() {
        C0141k.a m373b = C0141k.m373b("sso_config_xf");
        m373b.m381c();
        m373b.m380b();
    }
}
