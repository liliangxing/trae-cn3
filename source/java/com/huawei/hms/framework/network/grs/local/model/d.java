package com.huawei.hms.framework.network.grs.local.model;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class d {
    private String a;
    private Map<String, String> b;

    public Map<String, String> a() {
        return this.b;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(Map<String, String> map) {
        this.b = map;
    }

    public String b() {
        return this.a;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("countryGroup", this.a);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.b.keySet()) {
            jSONObject2.put(str, this.b.get(str));
        }
        jSONObject.put("addresses", jSONObject2);
        return jSONObject;
    }
}
