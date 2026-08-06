package com.bytedance.tobshadow.bdtracker;

import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0516t extends AbstractC0551y {

    /* renamed from: b */
    public String f1025b;

    /* renamed from: c */
    public String f1026c;

    /* renamed from: d */
    public String f1027d;

    /* renamed from: e */
    public String f1028e;

    /* renamed from: f */
    public String f1029f;

    /* renamed from: g */
    public String f1030g;

    /* renamed from: h */
    public String f1031h;

    /* renamed from: i */
    public String f1032i;

    /* renamed from: j */
    public String f1033j;

    /* renamed from: k */
    public String f1034k;

    /* renamed from: l */
    public String f1035l;

    /* renamed from: m */
    public String f1036m;

    /* renamed from: n */
    public boolean f1037n;

    /* renamed from: o */
    public int f1038o;

    /* renamed from: p */
    public long f1039p;

    /* renamed from: q */
    public String f1040q;

    /* renamed from: r */
    public String f1041r;

    /* renamed from: s */
    public JSONObject f1042s;

    /* renamed from: t */
    public String f1043t;

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0551y
    /* renamed from: a */
    public JSONObject mo665a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f1025b);
        jSONObject.put("utm_campaign", this.f1026c);
        jSONObject.put("utm_source", this.f1027d);
        jSONObject.put("utm_medium", this.f1028e);
        jSONObject.put("utm_content", this.f1029f);
        jSONObject.put("utm_term", this.f1030g);
        jSONObject.put("tr_shareuser", this.f1031h);
        jSONObject.put("tr_admaster", this.f1032i);
        jSONObject.put("tr_param1", this.f1033j);
        jSONObject.put("tr_param2", this.f1034k);
        jSONObject.put("tr_param3", this.f1035l);
        jSONObject.put("tr_param4", this.f1036m);
        jSONObject.put("tr_dp", this.f1040q);
        jSONObject.put("is_retargeting", this.f1037n);
        jSONObject.put("reengagement_window", this.f1038o);
        jSONObject.put("reengagement_time", this.f1039p);
        jSONObject.put("deeplink_value", this.f1041r);
        jSONObject.put("token", this.f1043t);
        jSONObject.put("extra", this.f1042s);
        return jSONObject;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0551y
    /* renamed from: a */
    public void mo666a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1025b = jSONObject.optString("name", null);
            this.f1026c = jSONObject.optString("utm_campaign", null);
            this.f1027d = jSONObject.optString("utm_source", null);
            this.f1028e = jSONObject.optString("utm_medium", null);
            this.f1029f = jSONObject.optString("utm_content", null);
            this.f1030g = jSONObject.optString("utm_term", null);
            this.f1031h = jSONObject.optString("tr_shareuser", null);
            this.f1032i = jSONObject.optString("tr_admaster", null);
            this.f1033j = jSONObject.optString("tr_param1", null);
            this.f1034k = jSONObject.optString("tr_param2", null);
            this.f1035l = jSONObject.optString("tr_param3", null);
            this.f1036m = jSONObject.optString("tr_param4", null);
            this.f1037n = jSONObject.optBoolean("is_retargeting");
            this.f1038o = jSONObject.optInt("reengagement_window");
            this.f1039p = jSONObject.optLong("reengagement_time");
            this.f1040q = jSONObject.optString("tr_dp", null);
            this.f1041r = jSONObject.optString("deeplink_value", null);
            this.f1043t = jSONObject.optString("token", null);
            this.f1042s = jSONObject.optJSONObject("extra");
        }
    }
}
