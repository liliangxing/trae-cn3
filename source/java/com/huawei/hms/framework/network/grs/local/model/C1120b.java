package com.huawei.hms.framework.network.grs.local.model;

import com.heytap.mcssdk.constant.C0879b;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1120b {

    /* renamed from: a */
    private String f1386a;

    /* renamed from: b */
    private String f1387b;

    /* renamed from: c */
    private Set<String> f1388c;

    /* renamed from: d */
    private String f1389d;

    /* renamed from: a */
    public Set<String> m1387a() {
        return this.f1388c;
    }

    /* renamed from: a */
    public void m1388a(String str) {
        this.f1389d = str;
    }

    /* renamed from: a */
    public void m1389a(Set<String> set) {
        this.f1388c = set;
    }

    /* renamed from: b */
    public String m1390b() {
        return this.f1386a;
    }

    /* renamed from: b */
    public void m1391b(String str) {
        this.f1386a = str;
    }

    /* renamed from: c */
    public JSONObject m1392c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f1386a);
        jSONObject.put(DefaultLogicExecutor.GLOBAL_EVENT_NAME, this.f1387b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f1388c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("countries", jSONArray);
        jSONObject.put(C0879b.f565i, this.f1389d);
        return jSONObject;
    }

    /* renamed from: c */
    public void m1393c(String str) {
        this.f1387b = str;
    }
}
