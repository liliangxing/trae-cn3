package com.cmic.sso.sdk.c.b;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LogReportParameter.java */
/* loaded from: classes6.dex */
public class f extends g {
    private b a;
    private a b;

    @Override // com.cmic.sso.sdk.c.b.g
    protected String a_(String str) {
        return null;
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    /* compiled from: LogReportParameter.java */
    /* loaded from: classes6.dex */
    public static class b extends g {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;

        @Override // com.cmic.sso.sdk.c.b.g
        public JSONObject b() {
            return null;
        }

        public String c() {
            return this.e;
        }

        public void b(String str) {
            this.e = str;
        }

        @Override // com.cmic.sso.sdk.c.b.g
        public String a() {
            return this.d;
        }

        @Override // com.cmic.sso.sdk.c.b.g
        protected String a_(String str) {
            return this.e + this.d + this.c + this.b + "@Fdiwmxy7CBDDQNUI";
        }

        public void c(String str) {
            this.d = str;
        }

        public String d() {
            return this.a;
        }

        public void d(String str) {
            this.a = str;
        }

        public String e() {
            return this.b;
        }

        public void e(String str) {
            this.b = str;
        }

        public String f() {
            return this.c;
        }

        public void f(String str) {
            this.c = str;
        }
    }

    /* compiled from: LogReportParameter.java */
    /* loaded from: classes6.dex */
    public static class a {
        private JSONObject a;

        public JSONObject a() {
            return this.a;
        }

        public void a(JSONObject jSONObject) {
            this.a = jSONObject;
        }
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.a.d;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(TicketGuardProviderKt.PATH_SIGN, this.a.d());
            jSONObject2.put("msgid", this.a.e());
            jSONObject2.put("systemtime", this.a.f());
            jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.a.a());
            jSONObject2.put("version", this.a.c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", this.b.a());
            jSONObject.put(ReportConst.ValidationReport.BODY, jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
