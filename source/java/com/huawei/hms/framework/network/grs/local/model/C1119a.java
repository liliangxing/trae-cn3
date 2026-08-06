package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1119a {

    /* renamed from: a */
    private String f1383a;

    /* renamed from: b */
    private long f1384b;

    /* renamed from: c */
    private final Map<String, C1121c> f1385c = new ConcurrentHashMap(16);

    /* renamed from: a */
    public C1121c m1381a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f1385c.get(str);
        }
        Logger.m1189w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    }

    /* renamed from: a */
    public String m1382a() {
        return this.f1383a;
    }

    /* renamed from: a */
    public void m1383a(long j) {
        this.f1384b = j;
    }

    /* renamed from: a */
    public void m1384a(String str, C1121c c1121c) {
        if (TextUtils.isEmpty(str) || c1121c == null) {
            return;
        }
        this.f1385c.put(str, c1121c);
    }

    /* renamed from: b */
    public JSONObject m1385b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DefaultLogicExecutor.GLOBAL_EVENT_NAME, TextUtils.isEmpty(this.f1383a) ? "" : this.f1383a);
        jSONObject.put("cacheControl", this.f1384b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f1385c.keySet().iterator();
        while (it.hasNext()) {
            C1121c c1121c = this.f1385c.get(it.next());
            if (c1121c != null) {
                jSONArray.put(c1121c.m1400c());
            }
        }
        Logger.m1185i("ApplicationBean", "local config save to sp, services count:" + jSONArray.length());
        jSONObject.put("services", jSONArray);
        return jSONObject;
    }

    /* renamed from: b */
    public void m1386b(String str) {
        this.f1383a = str;
    }
}
