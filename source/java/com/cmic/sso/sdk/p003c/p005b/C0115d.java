package com.cmic.sso.sdk.p003c.p005b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetPhoneNubmerNotify.java */
/* renamed from: com.cmic.sso.sdk.c.b.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0115d extends AbstractC0118g {

    /* renamed from: a */
    private final String f225a;

    /* renamed from: b */
    private final String f226b;

    /* renamed from: c */
    private final String f227c;

    /* renamed from: d */
    private String f228d = "authz";

    /* renamed from: e */
    private String f229e;

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a_ */
    protected String mo218a_(String str) {
        return null;
    }

    public C0115d(String str, String str2, String str3) {
        this.f225a = str;
        this.f226b = str2;
        this.f227c = str3;
    }

    /* renamed from: b */
    public void m227b(String str) {
        this.f228d = str;
    }

    /* renamed from: c */
    public void m228c(String str) {
        this.f229e = str;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a */
    public String mo196a() {
        return this.f225a;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: b */
    public JSONObject mo219b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f226b);
            jSONObject.put("data", this.f227c);
            jSONObject.put("userCapaid", this.f229e);
            jSONObject.put("funcType", this.f228d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
