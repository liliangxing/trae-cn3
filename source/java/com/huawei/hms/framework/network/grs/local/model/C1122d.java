package com.huawei.hms.framework.network.grs.local.model;

import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1122d {

    /* renamed from: a */
    private String f1394a;

    /* renamed from: b */
    private Map<String, String> f1395b;

    /* renamed from: a */
    public Map<String, String> m1402a() {
        return this.f1395b;
    }

    /* renamed from: a */
    public void m1403a(String str) {
        this.f1394a = str;
    }

    /* renamed from: a */
    public void m1404a(Map<String, String> map) {
        this.f1395b = map;
    }

    /* renamed from: b */
    public String m1405b() {
        return this.f1394a;
    }

    /* renamed from: c */
    public JSONObject m1406c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("countryGroup", this.f1394a);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.f1395b.keySet()) {
            jSONObject2.put(str, this.f1395b.get(str));
        }
        jSONObject.put("addresses", jSONObject2);
        return jSONObject;
    }
}
