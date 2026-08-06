package cn.com.chinatelecom.account.api.p008c;

import android.content.Context;
import android.net.Network;
import cn.com.chinatelecom.account.api.C0674a;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.p006a.C0678d;
import cn.com.chinatelecom.account.api.p009d.C0687b;
import cn.com.chinatelecom.account.api.p009d.C0688c;
import cn.com.chinatelecom.account.api.p009d.C0692g;
import cn.com.chinatelecom.account.api.p009d.C0693h;
import cn.com.chinatelecom.account.api.p010e.C0694a;
import cn.com.chinatelecom.account.api.p010e.C0695b;
import cn.com.chinatelecom.account.api.p010e.C0697d;
import cn.com.chinatelecom.account.api.p010e.C0699f;
import cn.com.chinatelecom.account.api.p010e.C0700g;
import cn.com.chinatelecom.account.api.p010e.C0701h;
import cn.com.chinatelecom.account.api.p010e.C0703j;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import org.json.JSONObject;

/* renamed from: cn.com.chinatelecom.account.api.c.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0681a {

    /* renamed from: a */
    private static final String f154a = "a";

    /* renamed from: b */
    private boolean f155b = false;

    /* renamed from: c */
    private Context f156c;

    /* renamed from: d */
    private String f157d;

    /* renamed from: e */
    private String f158e;

    /* renamed from: f */
    private C0683c f159f;

    /* renamed from: cn.com.chinatelecom.account.api.c.a$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    class AnonymousClass2 implements InterfaceC0682b {

        /* renamed from: a */
        final /* synthetic */ int f168a;

        /* renamed from: b */
        final /* synthetic */ String f169b;

        /* renamed from: c */
        final /* synthetic */ CtSetting f170c;

        /* renamed from: d */
        final /* synthetic */ ResultListener f171d;

        /* renamed from: e */
        final /* synthetic */ String f172e;

        /* renamed from: f */
        final /* synthetic */ String f173f;

        /* renamed from: g */
        final /* synthetic */ int f174g;

        AnonymousClass2(int i, String str, CtSetting ctSetting, ResultListener resultListener, String str2, String str3, int i2) {
            this.f168a = i;
            this.f169b = str;
            this.f170c = ctSetting;
            this.f171d = resultListener;
            this.f172e = str2;
            this.f173f = str3;
            this.f174g = i2;
        }

        @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
        /* renamed from: a */
        public void mo201a() {
            C0681a.this.m209a(80800, C0678d.m189a(C0703j.f312o), this.f172e, 2500L, "Switching network timeout (4.x)", this.f171d);
        }

        @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
        /* renamed from: a */
        public void mo202a(long j) {
            C0681a.this.m209a(80801, C0678d.m189a(C0703j.f313p), this.f172e, j, "Switching network failed (4.x)", this.f171d);
        }

        @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
        /* renamed from: a */
        public void mo203a(Network network, long j) {
            long j2 = this.f168a - j;
            if (j2 > 100) {
                C0681a.this.m213a(this.f169b, this.f170c, null, this.f171d, j2, this.f172e, this.f173f, this.f174g);
            } else {
                CtAuth.postResultOnMainThread(this.f172e, C0703j.m367c(), this.f171d);
            }
            C0699f.m328a(this.f172e).m320b(j);
        }
    }

    public C0681a(Context context, String str, String str2) {
        this.f156c = context;
        this.f157d = str;
        this.f158e = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public JSONObject m206a(Context context, String str, String str2, String str3, CtSetting ctSetting, Network network, String str4, String str5, int i) {
        String m356b;
        String m357b;
        boolean z;
        try {
            long m278a = C0694a.m278a(context);
            if (i == C0674a.f116d) {
                m356b = C0701h.m352a();
                m357b = C0701h.m354a(context, str, str2, str3, m278a, "");
            } else {
                m356b = C0701h.m356b();
                m357b = C0701h.m357b(context, str, str2, str3, m278a, "");
            }
            if (C0700g.m338a() != null) {
                m356b = m356b.replace(C0678d.m189a(C0695b.f255f), C0700g.m338a());
            }
            JSONObject jSONObject = new JSONObject(m357b);
            String optString = jSONObject.optString(AirActionConstant.ActionId.ACTION_ID_PARAMS);
            String optString2 = jSONObject.optString("k");
            C0692g.a aVar = new C0692g.a();
            aVar.m271a(str5);
            aVar.m274a(false, C0688c.m243a(), C0678d.m189a(C0695b.f255f));
            aVar.m277b(str4);
            aVar.m270a(network);
            aVar.m269a(CtSetting.getConnTimeout(ctSetting));
            aVar.m276b(CtSetting.getReadTimeout(ctSetting));
            C0692g m275a = aVar.m275a();
            C0687b c0687b = new C0687b(context);
            C0693h mo239a = c0687b.mo239a(m356b, optString, 1, m275a);
            if (mo239a.f247d) {
                synchronized (this) {
                    z = this.f155b;
                }
                if (!z) {
                    C0693h mo239a2 = c0687b.mo239a(m356b, optString, 1, aVar.m273a(true).m274a(false, "", "").m275a());
                    C0699f.m328a(str4).m319b(1);
                    mo239a = mo239a2;
                }
            }
            JSONObject m283a = C0694a.m283a(context, mo239a, optString2, network, true, str4);
            C0699f.m334b(str4, m283a, optString);
            return m283a;
        } catch (Throwable th) {
            JSONObject m371g = C0703j.m371g();
            C0699f.m328a(str4).m327g("gpm ：" + th.getMessage()).m316a(80102).m325e(C0678d.m189a(C0703j.f308k));
            CtAuth.warn(f154a, "GPM Throwable", th);
            return m371g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m208a() {
        C0683c c0683c = this.f159f;
        if (c0683c != null) {
            c0683c.m230a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m209a(int i, String str, String str2, long j, String str3, ResultListener resultListener) {
        C0699f.m328a(str2).m316a(i).m325e(str).m320b(j).m327g(str3);
        C0699f.m335c(str2);
        String m362a = C0703j.m362a(i, str, str2);
        if (resultListener != null) {
            resultListener.onResult(m362a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m213a(final String str, final CtSetting ctSetting, final Network network, final ResultListener resultListener, long j, final String str2, final String str3, final int i) {
        new C0684d().m233a(new AbstractRunnableC0685e(j) { // from class: cn.com.chinatelecom.account.api.c.a.3
            @Override // cn.com.chinatelecom.account.api.p008c.AbstractRunnableC0685e
            /* renamed from: a */
            public void mo204a() {
                C0681a c0681a = C0681a.this;
                JSONObject m206a = c0681a.m206a(c0681a.f156c, C0681a.this.f157d, C0681a.this.f158e, str, ctSetting, network, str2, str3, i);
                synchronized (this) {
                    if (!m236c()) {
                        m235a(true);
                        m237d();
                        CtAuth.postResultOnMainThread(str2, m206a, resultListener);
                    }
                }
                if (network != null) {
                    C0681a.this.m208a();
                }
            }

            @Override // cn.com.chinatelecom.account.api.p008c.AbstractRunnableC0685e
            /* renamed from: b */
            public void mo205b() {
                super.mo205b();
                synchronized (C0681a.this) {
                    C0681a.this.f155b = true;
                }
                synchronized (this) {
                    if (!m236c()) {
                        m235a(true);
                        C0681a.this.m209a(80000, C0678d.m189a(C0703j.f298a), str2, 0L, "", resultListener);
                    }
                }
                if (network != null) {
                    C0681a.this.m208a();
                }
            }
        });
    }

    /* renamed from: a */
    public void m218a(String str, CtSetting ctSetting, int i, ResultListener resultListener) {
        int totalTimeout = CtSetting.getTotalTimeout(ctSetting);
        String m296a = C0697d.m296a();
        String m297a = C0697d.m297a(this.f156c);
        String m281a = C0694a.m281a(i);
        C0699f.m328a(m296a).m317a(m297a).m323c(m281a).m321b(C0700g.m346e(this.f156c)).m326f(C0700g.m350i(this.f156c));
        m213a(str, ctSetting, null, resultListener, totalTimeout, m296a, m281a, i);
    }

    /* renamed from: b */
    public void m219b(final String str, final CtSetting ctSetting, final int i, final ResultListener resultListener) {
        final int totalTimeout = CtSetting.getTotalTimeout(ctSetting);
        final String m296a = C0697d.m296a();
        String m297a = C0697d.m297a(this.f156c);
        final String m281a = C0694a.m281a(i);
        C0699f.m328a(m296a).m317a(m297a).m323c(m281a).m321b("BOTH").m326f(C0700g.m350i(this.f156c));
        C0683c c0683c = new C0683c(this.f156c);
        this.f159f = c0683c;
        c0683c.m231a(new InterfaceC0682b() { // from class: cn.com.chinatelecom.account.api.c.a.1
            @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
            /* renamed from: a */
            public void mo201a() {
                C0681a.this.m208a();
                C0681a.this.m209a(80800, C0678d.m189a(C0703j.f312o), m296a, 2500L, "", resultListener);
            }

            @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
            /* renamed from: a */
            public void mo202a(long j) {
                C0681a.this.m208a();
                C0681a.this.m209a(80801, C0678d.m189a(C0703j.f313p), m296a, j, "", resultListener);
            }

            @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
            /* renamed from: a */
            public void mo203a(Network network, long j) {
                long j2 = totalTimeout - j;
                if (j2 > 100) {
                    C0681a.this.m213a(str, ctSetting, network, resultListener, j2, m296a, m281a, i);
                } else {
                    C0681a.this.m208a();
                    CtAuth.postResultOnMainThread(m296a, C0703j.m367c(), resultListener);
                }
                C0699f.m328a(m296a).m320b(j);
            }
        });
    }
}
