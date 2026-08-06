package com.cmic.sso.sdk.p003c.p005b;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetConfigParameter.java */
/* renamed from: com.cmic.sso.sdk.c.b.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0113b extends AbstractC0118g {

    /* renamed from: a */
    private String f217a;

    /* renamed from: b */
    private String f218b;

    /* renamed from: c */
    private String f219c;

    /* renamed from: d */
    private String f220d;

    /* renamed from: e */
    private String f221e;

    /* renamed from: f */
    private String f222f;

    /* renamed from: g */
    private String f223g;

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a */
    public String mo196a() {
        return this.f222f;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: b */
    public JSONObject mo219b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f217a);
            jSONObject.put("apptype", this.f218b);
            jSONObject.put("phone_ID", this.f219c);
            jSONObject.put("certflag", this.f220d);
            jSONObject.put("sdkversion", this.f221e);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f222f);
            jSONObject.put("expandparams", "");
            jSONObject.put("sign", this.f223g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a_ */
    protected String mo218a_(String str) {
        return this.f217a + this.f221e + this.f222f + "iYm0HAnkxQtpvN44";
    }

    /* renamed from: b */
    public void m220b(String str) {
        this.f217a = str;
    }

    /* renamed from: c */
    public void m221c(String str) {
        this.f218b = str;
    }

    /* renamed from: d */
    public void m222d(String str) {
        this.f219c = str;
    }

    /* renamed from: e */
    public void m223e(String str) {
        this.f220d = str;
    }

    /* renamed from: f */
    public void m224f(String str) {
        this.f221e = str;
    }

    /* renamed from: g */
    public void m225g(String str) {
        this.f222f = str;
    }

    /* renamed from: h */
    public void m226h(String str) {
        this.f223g = str;
    }
}
