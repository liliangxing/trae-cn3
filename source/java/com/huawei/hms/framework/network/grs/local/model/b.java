package com.huawei.hms.framework.network.grs.local.model;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class b {
    private String a;
    private String b;
    private Set<String> c;
    private String d;

    public Set<String> a() {
        return this.c;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(Set<String> set) {
        this.c = set;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.a);
        jSONObject.put("name", this.b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("countries", jSONArray);
        jSONObject.put("description", this.d);
        return jSONObject;
    }

    public void c(String str) {
        this.b = str;
    }
}
