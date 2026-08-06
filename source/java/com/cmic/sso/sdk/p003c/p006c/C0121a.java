package com.cmic.sso.sdk.p003c.p006c;

import android.os.SystemClock;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.C0104b;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.C0103c;
import com.cmic.sso.sdk.p001a.C0089a;
import com.cmic.sso.sdk.p003c.p004a.C0107a;
import com.cmic.sso.sdk.p003c.p004a.C0109c;
import com.cmic.sso.sdk.p003c.p004a.C0110d;
import com.cmic.sso.sdk.p003c.p005b.C0113b;
import com.cmic.sso.sdk.p003c.p005b.C0116e;
import com.cmic.sso.sdk.p003c.p005b.C0117f;
import com.cmic.sso.sdk.p003c.p005b.C0119h;
import com.cmic.sso.sdk.p003c.p007d.C0126a;
import com.cmic.sso.sdk.p003c.p007d.C0127b;
import com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0139i;
import com.cmic.sso.sdk.p009e.C0141k;
import com.cmic.sso.sdk.p009e.C0143m;
import com.cmic.sso.sdk.p009e.C0145o;
import com.cmic.sso.sdk.p009e.C0147q;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* compiled from: BaseRequest.java */
/* renamed from: com.cmic.sso.sdk.c.c.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0121a {

    /* renamed from: a */
    private static C0121a f248a;

    private C0121a() {
    }

    /* renamed from: a */
    public static C0121a m254a() {
        if (f248a == null) {
            synchronized (C0121a.class) {
                if (f248a == null) {
                    f248a = new C0121a();
                }
            }
        }
        return f248a;
    }

    /* renamed from: a */
    public void m258a(boolean z, C0088a c0088a, InterfaceC0124d interfaceC0124d) {
        C0113b c0113b = new C0113b();
        c0113b.m220b("1.0");
        c0113b.m221c("Android");
        c0113b.m222d(C0141k.m374b("AID", ""));
        c0113b.m223e(z ? "1" : AddressParam.TYPE_DISAPPROVE);
        c0113b.m224f(AuthnHelper.SDK_VERSION);
        c0113b.m225g(c0088a.m67b(HiAnalyticsConstant.HaKey.BI_KEY_APPID));
        c0113b.m226h(c0113b.m250v("iYm0HAnkxQtpvN44"));
        m255a(new C0123c("https://" + c0088a.m66b().m85c() + "/client/uniConfig", c0113b, "POST", c0088a.m67b("traceId")), interfaceC0124d, c0088a);
    }

    /* renamed from: a */
    public void m256a(C0088a c0088a, InterfaceC0124d interfaceC0124d) {
        C0123c c0123c;
        String m354a;
        int m70c = c0088a.m70c("networktype");
        C0119h c0119h = new C0119h();
        c0119h.m198b("1.0");
        c0119h.m199c(AuthnHelper.SDK_VERSION);
        c0119h.m200d(c0088a.m67b(HiAnalyticsConstant.HaKey.BI_KEY_APPID));
        c0119h.m201e(c0088a.m67b("operatortype"));
        c0119h.m202f(m70c + "");
        c0119h.m203g(C0143m.m384a());
        c0119h.m204h(C0143m.m387b());
        c0119h.m205i(C0143m.m388c());
        c0119h.m206j(AddressParam.TYPE_DISAPPROVE);
        c0119h.m207k("3.0");
        c0119h.m208l(C0147q.m399b());
        c0119h.m209m(C0145o.m393a());
        c0119h.m211o(c0088a.m67b("apppackage"));
        c0119h.m212p(c0088a.m67b("appsign"));
        c0119h.mo197a(C0141k.m374b("AID", ""));
        if (c0088a.m70c("logintype") == 3 || c0088a.m69b("isRisk", false)) {
            c0119h.m215s("pre");
        } else {
            c0119h.m252x(c0088a.m67b("userCapaid"));
            if (c0088a.m70c("logintype") == 1) {
                c0119h.m252x("200");
            } else {
                c0119h.m252x("50");
            }
            c0119h.m215s("authz");
        }
        C0147q.m396a(c0088a, "scripAndTokenForHttps");
        C0089a m66b = c0088a.m66b();
        if (c0088a.m69b("isCacheScrip", false) || c0088a.m69b("isGotScrip", false)) {
            c0119h.m251w(c0088a.m67b("phonescrip"));
            c0119h.m210n(c0119h.m250v(c0088a.m67b("appkey")));
            c0123c = new C0123c("https://" + m66b.m83a() + "/unisdk/rs/scripAndTokenForHttps", c0119h, "POST", c0088a.m67b("traceId"));
            c0123c.m265a("defendEOF", AddressParam.TYPE_DISAPPROVE);
        } else {
            C0116e c0116e = new C0116e();
            c0116e.m231a(c0088a.m63a(C0104b.a.f162a));
            c0116e.m233b(c0088a.m63a(C0104b.a.f163b));
            c0116e.m229a(c0119h);
            c0116e.m230a(false);
            c0088a.m61a("isCloseIpv4", m66b.m90h());
            c0088a.m61a("isCloseIpv6", m66b.m91i());
            String str = "https://" + m66b.m84b() + "/unisdk/rs/scripAndTokenForHttps";
            if (c0088a.m69b("use2048PublicKey", false)) {
                C0133c.m326a("BaseRequest", "使用2对应的编码");
                c0116e.m232b("2");
                m354a = C0139i.m351a().m355b(c0088a.m63a(C0104b.a.f162a));
            } else {
                m354a = C0139i.m351a().m354a(c0088a.m63a(C0104b.a.f162a));
            }
            c0116e.m235c(m354a);
            c0123c = new C0122b(str, c0116e, "POST", c0088a.m67b("traceId"));
            c0123c.m265a("defendEOF", "1");
            if (m70c == 3) {
                c0123c.m266a(true);
                c0088a.m61a("doNetworkSwitch", true);
            } else {
                c0123c.m266a(false);
                c0088a.m61a("doNetworkSwitch", false);
            }
        }
        c0123c.m265a("interfaceVersion", "3.0");
        m255a(c0123c, interfaceC0124d, c0088a);
    }

    /* renamed from: a */
    public void m257a(JSONObject jSONObject, C0088a c0088a, InterfaceC0124d interfaceC0124d) {
        C0117f c0117f = new C0117f();
        C0117f.a aVar = new C0117f.a();
        C0117f.b bVar = new C0117f.b();
        bVar.m247e(C0147q.m399b());
        bVar.m249f(C0145o.m393a());
        bVar.m241b("2.0");
        bVar.m243c(c0088a.m68b(HiAnalyticsConstant.HaKey.BI_KEY_APPID, ""));
        bVar.m245d(bVar.m250v(""));
        aVar.m239a(jSONObject);
        c0117f.m236a(aVar);
        c0117f.m237a(bVar);
        m255a(new C0123c("https://" + c0088a.m66b().m86d() + "/log/logReport", c0117f, "POST", c0088a.m67b("traceId")), interfaceC0124d, c0088a);
    }

    /* renamed from: a */
    private void m255a(final C0123c c0123c, final InterfaceC0124d interfaceC0124d, final C0088a c0088a) {
        C0110d c0110d = new C0110d();
        C0109c c0109c = new C0109c();
        C0107a c0107a = new C0107a();
        c0110d.m189a(c0109c);
        c0109c.m185a(c0107a);
        c0123c.m263a(SystemClock.elapsedRealtime());
        c0110d.mo183a(c0123c, new InterfaceC0128c() { // from class: com.cmic.sso.sdk.c.c.a.1
            @Override // com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c
            /* renamed from: a */
            public void mo188a(C0127b c0127b) {
                String string;
                if (c0123c.m272g()) {
                    try {
                        m259a();
                        JSONObject jSONObject = new JSONObject(c0127b.m282c());
                        if (jSONObject.has("resultcode")) {
                            string = jSONObject.getString("resultcode");
                        } else {
                            string = jSONObject.getString("resultCode");
                        }
                        C0147q.m400b(c0088a, string);
                        interfaceC0124d.mo127a(string, jSONObject.optString("desc"), jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                        mo187a(C0126a.m277a(102223));
                    }
                }
            }

            @Override // com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c
            /* renamed from: a */
            public void mo187a(C0126a c0126a) {
                if (c0123c.m272g()) {
                    m259a();
                    C0147q.m400b(c0088a, String.valueOf(c0126a.m278a()));
                    interfaceC0124d.mo127a(String.valueOf(c0126a.m278a()), c0126a.m279b(), C0103c.m167a(String.valueOf(c0126a.m278a()), c0126a.m279b()));
                }
            }

            /* renamed from: a */
            private void m259a() {
                if (c0123c.m262a().contains("uniConfig")) {
                    return;
                }
                C0147q.m402c(c0088a, String.valueOf(SystemClock.elapsedRealtime() - c0123c.m274i()));
            }
        }, c0088a);
    }
}
