package cn.com.chinatelecom.account.api.p007b;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.Helper;
import cn.com.chinatelecom.account.api.p006a.C0678d;
import cn.com.chinatelecom.account.api.p008c.AbstractRunnableC0685e;
import cn.com.chinatelecom.account.api.p008c.C0683c;
import cn.com.chinatelecom.account.api.p008c.C0684d;
import cn.com.chinatelecom.account.api.p008c.InterfaceC0682b;
import cn.com.chinatelecom.account.api.p009d.C0687b;
import cn.com.chinatelecom.account.api.p009d.C0688c;
import cn.com.chinatelecom.account.api.p009d.C0692g;
import cn.com.chinatelecom.account.api.p010e.C0694a;
import cn.com.chinatelecom.account.api.p010e.C0695b;
import cn.com.chinatelecom.account.api.p010e.C0697d;
import cn.com.chinatelecom.account.api.p010e.C0699f;
import cn.com.chinatelecom.account.api.p010e.C0700g;
import cn.com.chinatelecom.account.api.p010e.C0701h;
import cn.com.chinatelecom.account.api.p010e.C0703j;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: cn.com.chinatelecom.account.api.b.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0680b {

    /* renamed from: a */
    public static final byte[] f125a = {122, 99, 122, 102};

    /* renamed from: b */
    public static final byte[] f126b = {44, 104, 120, 99, 109, 75, 122, 122, 55};

    /* renamed from: c */
    public static final byte[] f127c = {44, 121, 126, 55};

    /* renamed from: d */
    public static final byte[] f128d = {44, 104, 126, 55};

    /* renamed from: e */
    public static final byte[] f129e = {44, 107, Byte.MAX_VALUE, 126, 98, 94, 115, 122, 111, 55};

    /* renamed from: f */
    private static final String f130f = "b";

    /* renamed from: g */
    private C0683c f131g;

    /* renamed from: cn.com.chinatelecom.account.api.b.b$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    class AnonymousClass2 implements InterfaceC0682b {

        /* renamed from: a */
        final /* synthetic */ String f139a;

        /* renamed from: b */
        final /* synthetic */ int f140b;

        /* renamed from: c */
        final /* synthetic */ Context f141c;

        /* renamed from: d */
        final /* synthetic */ String f142d;

        /* renamed from: e */
        final /* synthetic */ String f143e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC0679a f144f;

        AnonymousClass2(String str, int i, Context context, String str2, String str3, InterfaceC0679a interfaceC0679a) {
            this.f139a = str;
            this.f140b = i;
            this.f141c = context;
            this.f142d = str2;
            this.f143e = str3;
            this.f144f = interfaceC0679a;
        }

        @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
        /* renamed from: a */
        public void mo201a() {
            C0680b.this.m193a(80800, C0678d.m189a(C0703j.f312o), this.f139a, 2500L, "Switching network timeout (4.x)", this.f144f);
        }

        @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
        /* renamed from: a */
        public void mo202a(long j) {
            C0680b.this.m193a(80801, C0678d.m189a(C0703j.f313p), this.f139a, j, "Switching network failed (4.x)", this.f144f);
        }

        @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
        /* renamed from: a */
        public void mo203a(Network network, long j) {
            C0699f.m328a(this.f139a).m320b(j);
            long j2 = this.f140b - j;
            if (j2 > 100) {
                C0680b.this.m194a(this.f141c, this.f142d, this.f143e, network, j2, this.f139a, "preCodeByJs", this.f144f);
            } else {
                C0680b.this.m193a(80000, C0678d.m189a(C0703j.f298a), this.f139a, j, "", this.f144f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public JSONObject m190a(Context context, String str, String str2, Network network, String str3, String str4) {
        try {
            C0692g.a aVar = new C0692g.a();
            aVar.m271a(str4);
            aVar.m274a(false, C0688c.m243a(), C0678d.m189a(C0695b.f255f));
            aVar.m277b(str3);
            aVar.m270a(network);
            aVar.m269a(CtSetting.getConnTimeout(null));
            aVar.m276b(CtSetting.getReadTimeout(null));
            HashMap hashMap = new HashMap();
            hashMap.put(C0678d.m189a(f125a), Helper.dnprecohdjs());
            aVar.m272a(hashMap);
            JSONObject m283a = C0694a.m283a(context, new C0687b(context).mo239a(str2, "", 0, aVar.m275a()), str, network, true, str3);
            C0699f.m334b(str3, m283a, str2);
            return m283a;
        } catch (Throwable th) {
            JSONObject m371g = C0703j.m371g();
            C0699f.m328a(str3).m327g("gpm ：" + th.getMessage()).m316a(80102).m325e(C0678d.m189a(C0703j.f308k));
            CtAuth.warn(f130f, "GPM Throwable", th);
            return m371g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m192a() {
        C0683c c0683c = this.f131g;
        if (c0683c != null) {
            c0683c.m230a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m193a(int i, String str, String str2, long j, String str3, InterfaceC0679a interfaceC0679a) {
        C0699f.m328a(str2).m316a(i).m325e(str).m320b(j).m327g(str3);
        C0699f.m335c(str2);
        String m362a = C0703j.m362a(i, str, str2);
        if (interfaceC0679a != null) {
            interfaceC0679a.callbackPreCode(m362a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m194a(final Context context, final String str, final String str2, final Network network, long j, final String str3, final String str4, final InterfaceC0679a interfaceC0679a) {
        new C0684d().m233a(new AbstractRunnableC0685e(j) { // from class: cn.com.chinatelecom.account.api.b.b.3
            @Override // cn.com.chinatelecom.account.api.p008c.AbstractRunnableC0685e
            /* renamed from: a */
            public void mo204a() {
                JSONObject m190a = C0680b.this.m190a(context, str, str2, network, str3, str4);
                synchronized (this) {
                    if (!m236c()) {
                        m235a(true);
                        m237d();
                        if (interfaceC0679a != null) {
                            try {
                                m190a.put("reqId", str3);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            interfaceC0679a.callbackPreCode(m190a.toString());
                        }
                        C0699f.m335c(str3);
                    }
                }
                if (network != null) {
                    C0680b.this.m192a();
                }
            }

            @Override // cn.com.chinatelecom.account.api.p008c.AbstractRunnableC0685e
            /* renamed from: b */
            public void mo205b() {
                super.mo205b();
                synchronized (this) {
                    if (!m236c()) {
                        m235a(true);
                        C0680b.this.m193a(80000, C0678d.m189a(C0703j.f298a), str3, 0L, "", interfaceC0679a);
                    }
                }
                if (network != null) {
                    C0680b.this.m192a();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0081  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m198a(String str, InterfaceC0679a interfaceC0679a) {
        String str2;
        String str3;
        Context context = CtAuth.getInstance().getContext();
        String str4 = "";
        String str5 = null;
        if (TextUtils.isEmpty(str)) {
            str3 = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str4 = jSONObject.optString("st");
                str2 = jSONObject.optString("bt");
                try {
                    str5 = jSONObject.optString("authType");
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    String str6 = str5;
                    str5 = str2;
                    str3 = str6;
                    long m278a = C0694a.m278a(context);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(C0678d.m189a(f126b)).append(CtAuth.mAppId);
                    stringBuffer.append(C0678d.m189a(f127c)).append(str4);
                    StringBuffer append = stringBuffer.append(C0678d.m189a(f128d));
                    if (TextUtils.isEmpty(str5)) {
                    }
                    append.append(str5);
                    StringBuffer append2 = stringBuffer.append(C0678d.m189a(f129e));
                    if (TextUtils.isEmpty(str3)) {
                    }
                    append2.append(str3);
                    String m353a = C0701h.m353a(context, m278a, stringBuffer.toString());
                    if (interfaceC0679a == null) {
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                str2 = null;
            }
            String str62 = str5;
            str5 = str2;
            str3 = str62;
        }
        long m278a2 = C0694a.m278a(context);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(C0678d.m189a(f126b)).append(CtAuth.mAppId);
        stringBuffer2.append(C0678d.m189a(f127c)).append(str4);
        StringBuffer append3 = stringBuffer2.append(C0678d.m189a(f128d));
        if (TextUtils.isEmpty(str5)) {
            str5 = "tyx";
        }
        append3.append(str5);
        StringBuffer append22 = stringBuffer2.append(C0678d.m189a(f129e));
        if (TextUtils.isEmpty(str3)) {
            str3 = ExifInterface.GPS_MEASUREMENT_2D;
        }
        append22.append(str3);
        String m353a2 = C0701h.m353a(context, m278a2, stringBuffer2.toString());
        if (interfaceC0679a == null) {
            interfaceC0679a.callbackPreCodeParams(m353a2);
        }
    }

    /* renamed from: a */
    public void m199a(String str, String str2, InterfaceC0679a interfaceC0679a) {
        Context context = CtAuth.getInstance().getContext();
        int totalTimeout = CtSetting.getTotalTimeout(null);
        String m296a = C0697d.m296a();
        C0699f.m328a(m296a).m317a(C0697d.m297a(context)).m323c("preCodeByJs").m321b(C0700g.m346e(context)).m326f(C0700g.m350i(context));
        m194a(context, str, str2, null, totalTimeout, m296a, "preCodeByJs", interfaceC0679a);
    }

    /* renamed from: b */
    public void m200b(final String str, final String str2, final InterfaceC0679a interfaceC0679a) {
        final Context context = CtAuth.getInstance().getContext();
        final int totalTimeout = CtSetting.getTotalTimeout(null);
        final String m296a = C0697d.m296a();
        C0699f.m328a(m296a).m317a(C0697d.m297a(context)).m323c("preCodeByJs").m321b("BOTH").m326f(C0700g.m350i(context));
        C0683c c0683c = new C0683c(context);
        this.f131g = c0683c;
        c0683c.m231a(new InterfaceC0682b() { // from class: cn.com.chinatelecom.account.api.b.b.1
            @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
            /* renamed from: a */
            public void mo201a() {
                C0680b.this.m192a();
                C0680b.this.m193a(80800, C0678d.m189a(C0703j.f312o), m296a, 2500L, "", interfaceC0679a);
            }

            @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
            /* renamed from: a */
            public void mo202a(long j) {
                C0680b.this.m192a();
                C0680b.this.m193a(80801, C0678d.m189a(C0703j.f313p), m296a, j, "", interfaceC0679a);
            }

            @Override // cn.com.chinatelecom.account.api.p008c.InterfaceC0682b
            /* renamed from: a */
            public void mo203a(Network network, long j) {
                C0699f.m328a(m296a).m320b(j);
                long j2 = totalTimeout - j;
                if (j2 > 100) {
                    C0680b.this.m194a(context, str, str2, network, j2, m296a, "preCodeByJs", interfaceC0679a);
                } else {
                    C0680b.this.m192a();
                    C0680b.this.m193a(80000, C0678d.m189a(C0703j.f298a), m296a, j, "", interfaceC0679a);
                }
            }
        });
    }
}
