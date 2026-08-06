package com.bytedance.tobshadow.bdtracker;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class t extends y {
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public long p;
    public String q;
    public String r;
    public JSONObject s;
    public String t;

    @Override // com.bytedance.tobshadow.bdtracker.y
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.b);
        jSONObject.put("utm_campaign", this.c);
        jSONObject.put("utm_source", this.d);
        jSONObject.put("utm_medium", this.e);
        jSONObject.put("utm_content", this.f);
        jSONObject.put("utm_term", this.g);
        jSONObject.put("tr_shareuser", this.h);
        jSONObject.put("tr_admaster", this.i);
        jSONObject.put("tr_param1", this.j);
        jSONObject.put("tr_param2", this.k);
        jSONObject.put("tr_param3", this.l);
        jSONObject.put("tr_param4", this.m);
        jSONObject.put("tr_dp", this.q);
        jSONObject.put("is_retargeting", this.n);
        jSONObject.put("reengagement_window", this.o);
        jSONObject.put("reengagement_time", this.p);
        jSONObject.put("deeplink_value", this.r);
        jSONObject.put("token", this.t);
        jSONObject.put("extra", this.s);
        return jSONObject;
    }

    @Override // com.bytedance.tobshadow.bdtracker.y
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = jSONObject.optString("name", null);
            this.c = jSONObject.optString("utm_campaign", null);
            this.d = jSONObject.optString("utm_source", null);
            this.e = jSONObject.optString("utm_medium", null);
            this.f = jSONObject.optString("utm_content", null);
            this.g = jSONObject.optString("utm_term", null);
            this.h = jSONObject.optString("tr_shareuser", null);
            this.i = jSONObject.optString("tr_admaster", null);
            this.j = jSONObject.optString("tr_param1", null);
            this.k = jSONObject.optString("tr_param2", null);
            this.l = jSONObject.optString("tr_param3", null);
            this.m = jSONObject.optString("tr_param4", null);
            this.n = jSONObject.optBoolean("is_retargeting");
            this.o = jSONObject.optInt("reengagement_window");
            this.p = jSONObject.optLong("reengagement_time");
            this.q = jSONObject.optString("tr_dp", null);
            this.r = jSONObject.optString("deeplink_value", null);
            this.t = jSONObject.optString("token", null);
            this.s = jSONObject.optJSONObject("extra");
        }
    }
}
