package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1121c {

    /* renamed from: a */
    private String f1390a;

    /* renamed from: b */
    private String f1391b;

    /* renamed from: c */
    private final Map<String, C1122d> f1392c = new ConcurrentHashMap(16);

    /* renamed from: d */
    private List<C1120b> f1393d = new ArrayList(16);

    /* renamed from: a */
    public C1122d m1394a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f1392c.get(str);
        }
        Logger.m1189w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    /* renamed from: a */
    public List<C1120b> m1395a() {
        return this.f1393d;
    }

    /* renamed from: a */
    public void m1396a(String str, C1122d c1122d) {
        if (TextUtils.isEmpty(str) || c1122d == null) {
            return;
        }
        this.f1392c.put(str, c1122d);
    }

    /* renamed from: a */
    public void m1397a(List<C1120b> list) {
        this.f1393d = list;
    }

    /* renamed from: b */
    public String m1398b() {
        return this.f1391b;
    }

    /* renamed from: b */
    public void m1399b(String str) {
        this.f1390a = str;
    }

    /* renamed from: c */
    public JSONObject m1400c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DefaultLogicExecutor.GLOBAL_EVENT_NAME, this.f1390a);
        jSONObject.put("routeBy", this.f1391b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f1392c.keySet().iterator();
        while (it.hasNext()) {
            C1122d c1122d = this.f1392c.get(it.next());
            if (c1122d != null) {
                jSONArray.put(c1122d.m1406c());
            }
        }
        jSONObject.put("servings", jSONArray);
        if (this.f1393d != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<C1120b> it2 = this.f1393d.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().m1392c());
            }
            jSONObject.put("countryGroups", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void m1401c(String str) {
        this.f1391b = str;
    }
}
