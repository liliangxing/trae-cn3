package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class a {
    private String a;
    private long b;
    private final Map<String, c> c = new ConcurrentHashMap(16);

    public c a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.c.get(str);
        }
        Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    }

    public String a() {
        return this.a;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        this.c.put(str, cVar);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", TextUtils.isEmpty(this.a) ? "" : this.a);
        jSONObject.put("cacheControl", this.b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            c cVar = this.c.get(it.next());
            if (cVar != null) {
                jSONArray.put(cVar.c());
            }
        }
        Logger.i("ApplicationBean", "local config save to sp, services count:" + jSONArray.length());
        jSONObject.put("services", jSONArray);
        return jSONObject;
    }

    public void b(String str) {
        this.a = str;
    }
}
