package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.b1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1129b1 implements InterfaceC1168o1 {

    /* renamed from: a */
    private String f1418a;

    /* renamed from: b */
    private String f1419b;

    /* renamed from: c */
    private String f1420c;

    /* renamed from: d */
    private String f1421d;

    /* renamed from: e */
    private String f1422e;

    /* renamed from: f */
    private String f1423f;

    @Override // com.huawei.hms.hatool.InterfaceC1168o1
    /* renamed from: a */
    public JSONObject mo1439a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f1418a);
        jSONObject.put("eventtime", this.f1421d);
        jSONObject.put("event", this.f1419b);
        jSONObject.put("event_session_name", this.f1422e);
        jSONObject.put("first_session_event", this.f1423f);
        if (TextUtils.isEmpty(this.f1420c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f1420c));
        return jSONObject;
    }

    /* renamed from: a */
    public void m1440a(String str) {
        this.f1420c = str;
    }

    /* renamed from: a */
    public void m1441a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f1419b = jSONObject.optString("event");
        this.f1420c = C1163n.m1640a(jSONObject.optString("properties"), C1167o0.m1666d().m1670a());
        this.f1418a = jSONObject.optString("type");
        this.f1421d = jSONObject.optString("eventtime");
        this.f1422e = jSONObject.optString("event_session_name");
        this.f1423f = jSONObject.optString("first_session_event");
    }

    /* renamed from: b */
    public String m1442b() {
        return this.f1421d;
    }

    /* renamed from: b */
    public void m1443b(String str) {
        this.f1419b = str;
    }

    /* renamed from: c */
    public String m1444c() {
        return this.f1418a;
    }

    /* renamed from: c */
    public void m1445c(String str) {
        this.f1421d = str;
    }

    /* renamed from: d */
    public JSONObject m1446d() {
        JSONObject mo1439a = mo1439a();
        mo1439a.put("properties", C1163n.m1642b(this.f1420c, C1167o0.m1666d().m1670a()));
        return mo1439a;
    }

    /* renamed from: d */
    public void m1447d(String str) {
        this.f1418a = str;
    }

    /* renamed from: e */
    public void m1448e(String str) {
        this.f1423f = str;
    }

    /* renamed from: f */
    public void m1449f(String str) {
        this.f1422e = str;
    }
}
