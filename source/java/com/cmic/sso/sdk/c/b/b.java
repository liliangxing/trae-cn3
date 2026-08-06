package com.cmic.sso.sdk.c.b;

import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetConfigParameter.java */
/* loaded from: classes6.dex */
public class b extends g {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.a);
            jSONObject.put("apptype", this.b);
            jSONObject.put("phone_ID", this.c);
            jSONObject.put("certflag", this.d);
            jSONObject.put("sdkversion", this.e);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f);
            jSONObject.put("expandparams", "");
            jSONObject.put(TicketGuardProviderKt.PATH_SIGN, this.g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    protected String a_(String str) {
        return this.a + this.e + this.f + "iYm0HAnkxQtpvN44";
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.f = str;
    }

    public void h(String str) {
        this.g = str;
    }
}
