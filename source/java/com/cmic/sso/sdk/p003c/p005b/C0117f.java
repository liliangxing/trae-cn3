package com.cmic.sso.sdk.p003c.p005b;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LogReportParameter.java */
/* renamed from: com.cmic.sso.sdk.c.b.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0117f extends AbstractC0118g {

    /* renamed from: a */
    private b f236a;

    /* renamed from: b */
    private a f237b;

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a_ */
    protected String mo218a_(String str) {
        return null;
    }

    /* renamed from: a */
    public void m237a(b bVar) {
        this.f236a = bVar;
    }

    /* renamed from: a */
    public void m236a(a aVar) {
        this.f237b = aVar;
    }

    /* compiled from: LogReportParameter.java */
    /* renamed from: com.cmic.sso.sdk.c.b.f$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class b extends AbstractC0118g {

        /* renamed from: a */
        private String f239a;

        /* renamed from: b */
        private String f240b;

        /* renamed from: c */
        private String f241c;

        /* renamed from: d */
        private String f242d;

        /* renamed from: e */
        private String f243e;

        @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
        /* renamed from: b */
        public JSONObject mo219b() {
            return null;
        }

        /* renamed from: c */
        public String m242c() {
            return this.f243e;
        }

        /* renamed from: b */
        public void m241b(String str) {
            this.f243e = str;
        }

        @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
        /* renamed from: a */
        public String mo196a() {
            return this.f242d;
        }

        @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
        /* renamed from: a_ */
        protected String mo218a_(String str) {
            return this.f243e + this.f242d + this.f241c + this.f240b + "@Fdiwmxy7CBDDQNUI";
        }

        /* renamed from: c */
        public void m243c(String str) {
            this.f242d = str;
        }

        /* renamed from: d */
        public String m244d() {
            return this.f239a;
        }

        /* renamed from: d */
        public void m245d(String str) {
            this.f239a = str;
        }

        /* renamed from: e */
        public String m246e() {
            return this.f240b;
        }

        /* renamed from: e */
        public void m247e(String str) {
            this.f240b = str;
        }

        /* renamed from: f */
        public String m248f() {
            return this.f241c;
        }

        /* renamed from: f */
        public void m249f(String str) {
            this.f241c = str;
        }
    }

    /* compiled from: LogReportParameter.java */
    /* renamed from: com.cmic.sso.sdk.c.b.f$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class a {

        /* renamed from: a */
        private JSONObject f238a;

        /* renamed from: a */
        public JSONObject m238a() {
            return this.f238a;
        }

        /* renamed from: a */
        public void m239a(JSONObject jSONObject) {
            this.f238a = jSONObject;
        }
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a */
    public String mo196a() {
        return this.f236a.f242d;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: b */
    public JSONObject mo219b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f236a.m244d());
            jSONObject2.put("msgid", this.f236a.m246e());
            jSONObject2.put("systemtime", this.f236a.m248f());
            jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f236a.mo196a());
            jSONObject2.put("version", this.f236a.m242c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", this.f237b.m238a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
