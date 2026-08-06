package com.cmic.sso.sdk.p003c.p005b;

import android.util.Base64;
import com.cmic.sso.sdk.p009e.C0131a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetPrePhoneScripParameter.java */
/* renamed from: com.cmic.sso.sdk.c.b.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0116e extends AbstractC0118g {

    /* renamed from: a */
    private AbstractC0112a f230a;

    /* renamed from: b */
    private byte[] f231b;

    /* renamed from: c */
    private String f232c;

    /* renamed from: d */
    private byte[] f233d;

    /* renamed from: e */
    private String f234e;

    /* renamed from: f */
    private boolean f235f = false;

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a_ */
    protected String mo218a_(String str) {
        return null;
    }

    /* renamed from: a */
    public void m230a(boolean z) {
        this.f235f = z;
    }

    /* renamed from: b */
    public void m232b(String str) {
        this.f234e = str;
    }

    /* renamed from: a */
    public void m231a(byte[] bArr) {
        this.f231b = bArr;
    }

    /* renamed from: c */
    public void m235c(String str) {
        this.f232c = str;
    }

    /* renamed from: b */
    public void m233b(byte[] bArr) {
        this.f233d = bArr;
    }

    /* renamed from: a */
    public void m229a(AbstractC0112a abstractC0112a) {
        this.f230a = abstractC0112a;
    }

    /* renamed from: c */
    public AbstractC0112a m234c() {
        return this.f230a;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a */
    public String mo196a() {
        return this.f230a.mo196a();
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: b */
    public JSONObject mo219b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f235f) {
            try {
                jSONObject.put("encrypted", this.f232c);
                jSONObject.put("encryptedIV", Base64.encodeToString(this.f233d, 0));
                jSONObject.put("reqdata", C0131a.m315a(this.f231b, this.f230a.toString(), this.f233d));
                jSONObject.put("securityreinforce", this.f234e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
