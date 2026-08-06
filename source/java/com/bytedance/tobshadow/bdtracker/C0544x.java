package com.bytedance.tobshadow.bdtracker;

import com.bytedance.security.android.aopcheck.reporter.Constant;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0544x extends AbstractC0551y {

    /* renamed from: b */
    public String f1202b;

    /* renamed from: c */
    public String f1203c;

    /* renamed from: d */
    public String f1204d;

    /* renamed from: e */
    public String f1205e;

    /* renamed from: f */
    public String f1206f;

    /* renamed from: g */
    public String f1207g;

    /* renamed from: h */
    public boolean f1208h;

    /* renamed from: i */
    public boolean f1209i;

    /* renamed from: j */
    public String f1210j;

    /* renamed from: k */
    public String f1211k;

    /* renamed from: l */
    public String f1212l;

    /* renamed from: m */
    public String f1213m;

    /* renamed from: n */
    public String f1214n;

    /* renamed from: o */
    public String f1215o;

    /* renamed from: p */
    public String f1216p;

    /* renamed from: q */
    public String f1217q;

    /* renamed from: r */
    public String f1218r;

    /* renamed from: s */
    public String f1219s;

    /* renamed from: t */
    public String f1220t;

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0551y
    /* renamed from: a */
    public JSONObject mo665a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constant.KEY_AID, this.f1202b);
        jSONObject.put("device_id", this.f1203c);
        jSONObject.put("bd_did", this.f1204d);
        jSONObject.put("install_id", this.f1205e);
        jSONObject.put("os", this.f1206f);
        jSONObject.put("caid", this.f1207g);
        jSONObject.put("androidid", this.f1212l);
        jSONObject.put("imei", this.f1213m);
        jSONObject.put("oaid", this.f1214n);
        jSONObject.put("google_aid", this.f1215o);
        jSONObject.put("ip", this.f1216p);
        jSONObject.put("ua", this.f1217q);
        jSONObject.put(Constant.KEY_DEVICE_MODEL, this.f1218r);
        jSONObject.put(Constant.KEY_OS_VERSION, this.f1219s);
        jSONObject.put("is_new_user", this.f1208h);
        jSONObject.put("exist_app_cache", this.f1209i);
        jSONObject.put(Constant.KEY_APP_VERSION, this.f1210j);
        jSONObject.put(Constant.KEY_CHANNEL, this.f1211k);
        jSONObject.put("package", this.f1220t);
        return jSONObject;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0551y
    /* renamed from: a */
    public void mo666a(JSONObject jSONObject) {
    }
}
