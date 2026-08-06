package com.cmic.sso.sdk.c.b;

import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetPrePhoneScripParameter.java */
/* loaded from: classes6.dex */
public class e extends g {
    private a a;
    private byte[] b;
    private String c;
    private byte[] d;
    private String e;
    private boolean f = false;

    @Override // com.cmic.sso.sdk.c.b.g
    protected String a_(String str) {
        return null;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b(String str) {
        this.e = str;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    public void c(String str) {
        this.c = str;
    }

    public void b(byte[] bArr) {
        this.d = bArr;
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public a c() {
        return this.a;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.a.a();
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f) {
            try {
                jSONObject.put(TicketGuardProviderKt.COL_ENCRYPTED, this.c);
                jSONObject.put("encryptedIV", Base64.encodeToString(this.d, 0));
                jSONObject.put("reqdata", com.cmic.sso.sdk.e.a.a(this.b, this.a.toString(), this.d));
                jSONObject.put("securityreinforce", this.e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
