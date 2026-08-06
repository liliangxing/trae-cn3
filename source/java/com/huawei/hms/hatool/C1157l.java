package com.huawei.hms.hatool;

import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1157l extends AbstractC1178t {

    /* renamed from: b */
    private String f1499b = "";

    /* renamed from: c */
    private String f1500c = "";

    /* renamed from: d */
    private String f1501d = "";

    /* renamed from: e */
    private String f1502e = "";

    /* renamed from: f */
    protected String f1503f = "";

    /* renamed from: g */
    private String f1504g;

    @Override // com.huawei.hms.hatool.InterfaceC1168o1
    /* renamed from: a */
    public JSONObject mo1439a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f1568a);
        jSONObject.put("oaid", this.f1504g);
        jSONObject.put("uuid", this.f1503f);
        jSONObject.put("upid", this.f1502e);
        jSONObject.put("imei", this.f1499b);
        jSONObject.put("sn", this.f1500c);
        jSONObject.put("udid", this.f1501d);
        return jSONObject;
    }

    /* renamed from: b */
    public void m1602b(String str) {
        this.f1499b = str;
    }

    /* renamed from: c */
    public void m1603c(String str) {
        this.f1504g = str;
    }

    /* renamed from: d */
    public void m1604d(String str) {
        this.f1500c = str;
    }

    /* renamed from: e */
    public void m1605e(String str) {
        this.f1501d = str;
    }

    /* renamed from: f */
    public void m1606f(String str) {
        this.f1502e = str;
    }

    /* renamed from: g */
    public void m1607g(String str) {
        this.f1503f = str;
    }
}
