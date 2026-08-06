package com.cmic.sso.sdk.auth;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p001a.C0089a;
import com.cmic.sso.sdk.p001a.C0091c;
import com.cmic.sso.sdk.p002b.C0105a;
import com.cmic.sso.sdk.p008d.C0129a;
import com.cmic.sso.sdk.p008d.C0130b;
import com.cmic.sso.sdk.p009e.C0132b;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0135e;
import com.cmic.sso.sdk.p009e.C0138h;
import com.cmic.sso.sdk.p009e.C0140j;
import com.cmic.sso.sdk.p009e.C0141k;
import com.cmic.sso.sdk.p009e.C0143m;
import com.cmic.sso.sdk.p009e.C0144n;
import com.cmic.sso.sdk.p009e.C0145o;
import com.cmic.sso.sdk.p009e.C0147q;
import com.cmic.sso.sdk.p009e.C0148r;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AuthnHelper {
    public static final String SDK_VERSION = "quick_login_android_9.5.5.1";

    /* renamed from: c */
    private static AuthnHelper f121c;

    /* renamed from: a */
    private final C0101a f122a;

    /* renamed from: b */
    private final Context f123b;

    /* renamed from: d */
    private long f124d;

    /* renamed from: e */
    private final Handler f125e;

    /* renamed from: f */
    private String f126f;

    /* renamed from: g */
    private final Object f127g;

    private AuthnHelper(Context context) {
        this.f124d = 8000L;
        this.f127g = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f123b = applicationContext;
        this.f125e = new Handler(applicationContext.getMainLooper());
        this.f122a = C0101a.m158a(applicationContext);
        C0148r.m405a(applicationContext);
        C0141k.m369a(applicationContext);
        C0140j.m357a(applicationContext);
        C0144n.m391a(new C0144n.a() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.1
            @Override // com.cmic.sso.sdk.p009e.C0144n.a
            /* renamed from: a */
            protected void mo128a() {
                String m374b = C0141k.m374b("AID", "");
                C0133c.m328b("AuthnHelper", "aid = " + m374b);
                if (TextUtils.isEmpty(m374b)) {
                    AuthnHelper.this.m148a();
                }
                if (C0132b.m321a(AuthnHelper.this.f123b, true)) {
                    C0133c.m328b("AuthnHelper", "生成androidkeystore成功");
                } else {
                    C0133c.m328b("AuthnHelper", "生成androidkeystore失败");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m148a() {
        String str = CustomImageSizeResolverDef.UNIT_PERCENT + C0147q.m399b();
        C0133c.m328b("AuthnHelper", "generate aid = " + str);
        C0141k.m371a("AID", str);
    }

    private AuthnHelper(Context context, String str) {
        this(context);
        this.f126f = str;
    }

    public static AuthnHelper getInstance(Context context) {
        if (f121c == null) {
            synchronized (AuthnHelper.class) {
                if (f121c == null) {
                    f121c = new AuthnHelper(context);
                }
            }
        }
        return f121c;
    }

    public static AuthnHelper getInstance(Context context, String str) {
        if (f121c == null) {
            synchronized (AuthnHelper.class) {
                if (f121c == null) {
                    f121c = new AuthnHelper(context, str);
                }
            }
        }
        return f121c;
    }

    public void loginAuth(final String str, final String str2, final TokenListener tokenListener) {
        final C0088a m147a = m147a(tokenListener);
        C0144n.m391a(new C0144n.a(this.f123b, m147a) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.2
            @Override // com.cmic.sso.sdk.p009e.C0144n.a
            /* renamed from: a */
            protected void mo128a() {
                if (AuthnHelper.this.m153a(m147a, str, str2, "loginAuth", 1, tokenListener)) {
                    AuthnHelper.this.m150a(m147a);
                }
            }
        });
    }

    public void mobileAuth(final String str, final String str2, final TokenListener tokenListener) {
        final C0088a m147a = m147a(tokenListener);
        C0144n.m391a(new C0144n.a(this.f123b, m147a) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.3
            @Override // com.cmic.sso.sdk.p009e.C0144n.a
            /* renamed from: a */
            protected void mo128a() {
                if (AuthnHelper.this.m153a(m147a, str, str2, "mobileAuth", 0, tokenListener)) {
                    AuthnHelper.this.m150a(m147a);
                }
            }
        });
    }

    public void getPhoneInfo(final String str, final String str2, final TokenListener tokenListener) {
        final C0088a m147a = m147a(tokenListener);
        C0144n.m391a(new C0144n.a(this.f123b, m147a) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.4
            @Override // com.cmic.sso.sdk.p009e.C0144n.a
            /* renamed from: a */
            protected void mo128a() {
                if (AuthnHelper.this.m153a(m147a, str, str2, "preGetMobile", 3, tokenListener)) {
                    AuthnHelper.this.m150a(m147a);
                }
            }
        });
    }

    /* renamed from: a */
    private C0088a m147a(TokenListener tokenListener) {
        C0088a c0088a = new C0088a(64);
        String m401c = C0147q.m401c();
        c0088a.m57a(new C0129a());
        c0088a.m60a("traceId", m401c);
        C0133c.m326a("traceId", m401c);
        if (tokenListener != null) {
            C0135e.m331a(m401c, tokenListener);
        }
        return c0088a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.cmic.sso.sdk.auth.AuthnHelper$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC0100a implements Runnable {

        /* renamed from: b */
        private final C0088a f154b;

        RunnableC0100a(C0088a c0088a) {
            this.f154b = c0088a;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject m167a = C0103c.m167a("200023", "登录超时");
            AuthnHelper.this.callBackResult(m167a.optString("resultCode", "200023"), m167a.optString("desc", "登录超时"), this.f154b, m167a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m150a(C0088a c0088a) {
        final RunnableC0100a runnableC0100a = new RunnableC0100a(c0088a);
        this.f125e.postDelayed(runnableC0100a, this.f124d);
        this.f122a.m164a(c0088a, new InterfaceC0102b() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.5
            @Override // com.cmic.sso.sdk.auth.InterfaceC0102b
            /* renamed from: a */
            public void mo157a(String str, String str2, C0088a c0088a2, JSONObject jSONObject) {
                AuthnHelper.this.f125e.removeCallbacks(runnableC0100a);
                AuthnHelper.this.callBackResult(str, str2, c0088a2, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m153a(C0088a c0088a, String str, String str2, String str3, int i, TokenListener tokenListener) {
        boolean m347a;
        C0089a m133a = C0091c.m130a(this.f123b).m133a();
        C0133c.m328b("AuthnHelper", "umcConfigBean = " + m133a.toString());
        c0088a.m56a(m133a);
        c0088a.m61a("use2048PublicKey", "rsa2048".equals(this.f126f));
        c0088a.m59a("systemStartTime", SystemClock.elapsedRealtime());
        c0088a.m60a("starttime", C0145o.m393a());
        c0088a.m60a("loginMethod", str3);
        c0088a.m60a("appkey", str2);
        c0088a.m60a(HiAnalyticsConstant.HaKey.BI_KEY_APPID, str);
        c0088a.m60a("timeOut", String.valueOf(this.f124d));
        boolean m385a = C0143m.m385a(this.f123b);
        C0105a.m170a().m173a(this.f123b, m385a);
        String m361b = C0140j.m356a().m361b();
        String m362c = C0140j.m356a().m362c();
        String m360a = C0140j.m356a().m360a(m362c);
        c0088a.m60a("operator", m362c);
        c0088a.m60a("operatortype", m360a);
        c0088a.m58a("logintype", i);
        C0133c.m328b("AuthnHelper", "subId = " + m361b);
        if (!TextUtils.isEmpty(m361b)) {
            C0133c.m326a("AuthnHelper", "使用subId作为缓存key = " + m361b);
            c0088a.m60a("scripType", "subid");
            c0088a.m60a("scripKey", m361b);
        } else if (!TextUtils.isEmpty(m362c)) {
            C0133c.m326a("AuthnHelper", "使用operator作为缓存key = " + m362c);
            c0088a.m60a("scripType", "operator");
            c0088a.m60a("scripKey", m362c);
        }
        int m383a = C0143m.m383a(this.f123b, m385a, c0088a);
        c0088a.m58a("networktype", m383a);
        if (!m385a) {
            c0088a.m60a("authType", String.valueOf(0));
            callBackResult("200010", "无法识别sim卡或没有sim卡", c0088a, null);
            return false;
        }
        if (tokenListener == null) {
            callBackResult("102203", "listener不能为空", c0088a, null);
            return false;
        }
        if (m133a.m89g()) {
            callBackResult("200082", "服务器繁忙，请稍后重试", c0088a, null);
            return false;
        }
        if (TextUtils.isEmpty(str == null ? "" : str.trim())) {
            callBackResult("102203", "appId 不能为空", c0088a, null);
            return false;
        }
        if (TextUtils.isEmpty(str2 == null ? "" : str2.trim())) {
            callBackResult("102203", "appkey不能为空", c0088a, null);
            return false;
        }
        if (m383a == 0) {
            callBackResult("102101", "未检测到网络", c0088a, null);
            return false;
        }
        if ("2".equals(m360a) && m133a.m88f()) {
            callBackResult("200082", "服务器繁忙，请稍后重试", c0088a, null);
            return false;
        }
        if ("3".equals(m360a) && m133a.m87e()) {
            callBackResult("200082", "服务器繁忙，请稍后重试", c0088a, null);
            return false;
        }
        synchronized (this.f127g) {
            m347a = C0138h.m347a(c0088a);
            if (m347a) {
                c0088a.m60a("securityphone", C0141k.m374b("securityphone", ""));
                if (3 != i) {
                    String m342a = C0138h.m342a(this.f123b);
                    C0133c.m328b("AuthnHelper", "解密phoneScript " + (!TextUtils.isEmpty(m342a)));
                    if (TextUtils.isEmpty(m342a)) {
                        m347a = false;
                    } else {
                        c0088a.m60a("phonescrip", m342a);
                    }
                    C0138h.m345a(true, false);
                }
            }
            c0088a.m61a("isCacheScrip", m347a);
            C0133c.m328b("AuthnHelper", "isCachePhoneScrip = " + m347a);
        }
        if (m383a != 2 || m347a) {
            return true;
        }
        callBackResult("102103", "无数据网络", c0088a, null);
        return false;
    }

    public static void setDebugMode(boolean z) {
        C0133c.m327a(z);
    }

    public void callBackResult(String str, String str2, C0088a c0088a, JSONObject jSONObject) {
        final JSONObject m168a;
        try {
            String m67b = c0088a.m67b("traceId");
            if (C0135e.m332a(m67b)) {
                return;
            }
            synchronized (this) {
                final TokenListener m334c = C0135e.m334c(m67b);
                C0135e.m333b(m67b);
                if (m334c == null) {
                    return;
                }
                c0088a.m59a("systemEndTime", SystemClock.elapsedRealtime());
                c0088a.m60a("endtime", C0145o.m393a());
                int m70c = c0088a.m70c("logintype");
                if (jSONObject == null) {
                    jSONObject = C0103c.m167a(str, str2);
                }
                if (m70c == 3) {
                    m168a = C0103c.m166a(str, c0088a, jSONObject);
                } else {
                    m168a = C0103c.m168a(str, str2, c0088a, jSONObject);
                }
                m168a.put("scripExpiresIn", String.valueOf(C0138h.m341a()));
                this.f125e.post(new Runnable() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.6
                    @Override // java.lang.Runnable
                    public void run() {
                        m334c.onGetTokenComplete(m168a);
                    }
                });
                C0091c.m130a(this.f123b).m134a(c0088a);
                if (c0088a.m66b().m92j() || C0147q.m397a(c0088a.m66b())) {
                    return;
                }
                m149a(this.f123b, str, c0088a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m149a(final Context context, final String str, final C0088a c0088a) {
        C0144n.m391a(new C0144n.a() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.7
            @Override // com.cmic.sso.sdk.p009e.C0144n.a
            /* renamed from: a */
            protected void mo128a() {
                if ("200023".equals(str)) {
                    SystemClock.sleep(8000L);
                }
                new C0130b().m314a(context, str, c0088a);
            }
        });
    }

    public void setOverTime(long j) {
        this.f124d = j;
    }

    public JSONObject getNetworkType(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                boolean m385a = C0143m.m385a(this.f123b);
                C0105a.m170a().m173a(context, m385a);
                String m360a = C0140j.m356a().m360a((String) null);
                int m383a = C0143m.m383a(context, m385a, new C0088a(1));
                jSONObject.put("operatortype", m360a);
                jSONObject.put("networktype", m383a + "");
                C0133c.m328b("AuthnHelper", "网络类型: " + m383a);
                C0133c.m328b("AuthnHelper", "运营商类型: " + m360a);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            }
        } catch (Exception unused) {
            jSONObject.put("errorDes", "发生未知错误");
            return jSONObject;
        }
    }

    public void delScrip() {
        try {
            C0138h.m345a(true, true);
            C0133c.m328b("AuthnHelper", "删除scrip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
