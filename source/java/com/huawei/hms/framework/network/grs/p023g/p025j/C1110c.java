package com.huawei.hms.framework.network.grs.p023g.p025j;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p022f.C1095b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.j.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1110c {

    /* renamed from: a */
    private final GrsBaseInfo f1369a;

    /* renamed from: b */
    private final Context f1370b;

    /* renamed from: c */
    private final Set<String> f1371c = new HashSet();

    public C1110c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f1369a = grsBaseInfo;
        this.f1370b = context;
    }

    /* renamed from: e */
    private String m1350e() {
        Set<String> m1277b = C1095b.m1270a(this.f1370b.getPackageName()).m1277b();
        if (m1277b.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = m1277b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.m1181d("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: f */
    private String m1351f() {
        Logger.m1187v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f1371c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.m1188v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public Context m1352a() {
        return this.f1370b;
    }

    /* renamed from: a */
    public void m1353a(String str) {
        this.f1371c.add(str);
    }

    /* renamed from: b */
    public GrsBaseInfo m1354b() {
        return this.f1369a;
    }

    /* renamed from: c */
    public String m1355c() {
        return this.f1371c.size() == 0 ? m1350e() : m1351f();
    }

    /* renamed from: d */
    public Set<String> m1356d() {
        return this.f1371c;
    }
}
