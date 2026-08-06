package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.g0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C1143g0 {

    /* renamed from: c */
    private static C1143g0 f1443c;

    /* renamed from: a */
    private Context f1444a;

    /* renamed from: b */
    private final Object f1445b = new Object();

    private C1143g0() {
    }

    /* renamed from: a */
    public static C1143g0 m1502a() {
        if (f1443c == null) {
            m1504b();
        }
        return f1443c;
    }

    /* renamed from: a */
    private JSONObject m1503a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                C1182v.m1778b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static synchronized void m1504b() {
        synchronized (C1143g0.class) {
            if (f1443c == null) {
                f1443c = new C1143g0();
            }
        }
    }

    /* renamed from: a */
    public void m1505a(Context context) {
        synchronized (this.f1445b) {
            if (this.f1444a != null) {
                return;
            }
            this.f1444a = context;
            C1136e.m1472a().m1475a(context);
        }
    }

    /* renamed from: a */
    public void m1506a(String str, int i) {
        C1136e.m1472a().m1476a(str, i);
    }

    /* renamed from: a */
    public void m1507a(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        C1136e.m1472a().m1477a(str, i, str2, m1503a(linkedHashMap));
    }

    /* renamed from: a */
    public void m1508a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            C1136e.m1472a().m1477a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            C1182v.m1786f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    /* renamed from: b */
    public void m1509b(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        C1136e.m1472a().m1478a(str, i, str2, m1503a(linkedHashMap), System.currentTimeMillis());
    }
}
