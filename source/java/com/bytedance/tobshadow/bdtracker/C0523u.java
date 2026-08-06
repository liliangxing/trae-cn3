package com.bytedance.tobshadow.bdtracker;

import com.bytedance.security.android.aopcheck.reporter.Constant;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0523u extends AbstractC0551y {

    /* renamed from: b */
    public String f1075b;

    /* renamed from: c */
    public String f1076c;

    /* renamed from: d */
    public String f1077d;

    /* renamed from: e */
    public String f1078e;

    /* renamed from: f */
    public String f1079f;

    /* renamed from: g */
    public String f1080g;

    /* renamed from: h */
    public String f1081h;

    /* renamed from: i */
    public String f1082i;

    /* renamed from: j */
    public String f1083j;

    /* renamed from: k */
    public String f1084k;

    /* renamed from: l */
    public String f1085l;

    /* renamed from: m */
    public String f1086m;

    /* renamed from: n */
    public String f1087n;

    /* renamed from: o */
    public String f1088o;

    /* renamed from: p */
    public Integer f1089p;

    /* renamed from: q */
    public String f1090q;

    /* renamed from: r */
    public String f1091r;

    /* renamed from: s */
    public String f1092s;

    /* renamed from: t */
    public String f1093t;

    /* renamed from: u */
    public String f1094u;

    /* renamed from: v */
    public String f1095v;

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0551y
    /* renamed from: a */
    public JSONObject mo665a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", this.f1088o);
        jSONObject.put(Constant.KEY_AID, this.f1075b);
        jSONObject.put("os", this.f1085l);
        jSONObject.put("bd_did", this.f1076c);
        jSONObject.put("ssid", this.f1077d);
        jSONObject.put("user_unique_id", this.f1078e);
        jSONObject.put("androidid", this.f1081h);
        jSONObject.put("imei", this.f1082i);
        jSONObject.put("oaid", this.f1083j);
        jSONObject.put(Constant.KEY_OS_VERSION, this.f1086m);
        jSONObject.put(Constant.KEY_DEVICE_MODEL, this.f1087n);
        jSONObject.put("google_aid", this.f1084k);
        jSONObject.put("click_time", this.f1089p);
        jSONObject.put("tr_shareuser", this.f1090q);
        jSONObject.put("tr_admaster", this.f1091r);
        jSONObject.put("tr_param1", this.f1092s);
        jSONObject.put("tr_param2", this.f1093t);
        jSONObject.put("tr_param3", this.f1094u);
        jSONObject.put("tr_param4", this.f1095v);
        jSONObject.put("ab_version", this.f1079f);
        jSONObject.put("tr_web_ssid", this.f1080g);
        return jSONObject;
    }

    /* renamed from: a */
    public final void m706a(String str) {
        this.f1075b = str;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0551y
    /* renamed from: a */
    public void mo666a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1088o = jSONObject.optString("tr_token", null);
            this.f1075b = jSONObject.optString(Constant.KEY_AID, null);
            this.f1085l = jSONObject.optString("os", null);
            this.f1076c = jSONObject.optString("bd_did", null);
            this.f1077d = jSONObject.optString("ssid", null);
            this.f1078e = jSONObject.optString("user_unique_id", null);
            this.f1081h = jSONObject.optString("androidid", null);
            this.f1082i = jSONObject.optString("imei", null);
            this.f1083j = jSONObject.optString("oaid", null);
            this.f1086m = jSONObject.optString(Constant.KEY_OS_VERSION, null);
            this.f1087n = jSONObject.optString(Constant.KEY_DEVICE_MODEL, null);
            this.f1084k = jSONObject.optString("google_aid", null);
            this.f1089p = Integer.valueOf(jSONObject.optInt("click_time"));
            this.f1090q = jSONObject.optString("tr_shareuser", null);
            this.f1091r = jSONObject.optString("tr_admaster", null);
            this.f1092s = jSONObject.optString("tr_param1", null);
            this.f1093t = jSONObject.optString("tr_param2", null);
            this.f1094u = jSONObject.optString("tr_param3", null);
            this.f1095v = jSONObject.optString("tr_param4", null);
            this.f1079f = jSONObject.optString("ab_version", null);
            this.f1080g = jSONObject.optString("tr_web_ssid", null);
        }
    }

    /* renamed from: b */
    public final String m707b() {
        return this.f1079f;
    }

    /* renamed from: b */
    public final void m708b(String str) {
        this.f1076c = str;
    }

    /* renamed from: c */
    public final String m709c() {
        return this.f1088o;
    }

    /* renamed from: c */
    public final void m710c(String str) {
        this.f1077d = str;
    }

    /* renamed from: d */
    public final String m711d() {
        return this.f1080g;
    }

    /* renamed from: d */
    public final void m712d(String str) {
        this.f1078e = str;
    }
}
