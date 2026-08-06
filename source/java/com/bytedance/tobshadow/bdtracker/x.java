package com.bytedance.tobshadow.bdtracker;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class x extends y {
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;

    @Override // com.bytedance.tobshadow.bdtracker.y
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", this.b);
        jSONObject.put("device_id", this.c);
        jSONObject.put("bd_did", this.d);
        jSONObject.put("install_id", this.e);
        jSONObject.put("os", this.f);
        jSONObject.put("caid", this.g);
        jSONObject.put("androidid", this.l);
        jSONObject.put("imei", this.m);
        jSONObject.put("oaid", this.n);
        jSONObject.put("google_aid", this.o);
        jSONObject.put("ip", this.p);
        jSONObject.put(BaseHttpRequestInfo.KEY_USER_AGENT, this.q);
        jSONObject.put("device_model", this.r);
        jSONObject.put("os_version", this.s);
        jSONObject.put("is_new_user", this.h);
        jSONObject.put("exist_app_cache", this.i);
        jSONObject.put("app_version", this.j);
        jSONObject.put("channel", this.k);
        jSONObject.put("package", this.t);
        return jSONObject;
    }

    @Override // com.bytedance.tobshadow.bdtracker.y
    public void a(JSONObject jSONObject) {
    }
}
