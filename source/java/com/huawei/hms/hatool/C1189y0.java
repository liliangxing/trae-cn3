package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.y0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1189y0 extends AbstractC1179t0 {

    /* renamed from: f */
    String f1586f;

    /* renamed from: g */
    String f1587g;

    /* renamed from: h */
    private String f1588h;

    @Override // com.huawei.hms.hatool.InterfaceC1168o1
    /* renamed from: a */
    public JSONObject mo1439a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f1588h);
        jSONObject.put("_emui_ver", this.f1569a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f1586f);
        jSONObject.put("_mnc", this.f1587g);
        jSONObject.put("_package_name", this.f1570b);
        jSONObject.put("_app_ver", this.f1571c);
        jSONObject.put("_lib_ver", "2.2.0.315");
        jSONObject.put("_channel", this.f1572d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f1573e);
        return jSONObject;
    }

    /* renamed from: f */
    public void m1814f(String str) {
        this.f1586f = str;
    }

    /* renamed from: g */
    public void m1815g(String str) {
        this.f1587g = str;
    }

    /* renamed from: h */
    public void m1816h(String str) {
        this.f1588h = str;
    }
}
