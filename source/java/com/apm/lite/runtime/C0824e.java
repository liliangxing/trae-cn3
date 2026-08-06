package com.apm.lite.runtime;

import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0794q;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.apm.lite.runtime.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0824e {

    /* renamed from: a */
    private static HashMap<String, C0824e> f703a = new HashMap<>();

    /* renamed from: b */
    private JSONObject f704b = null;

    /* renamed from: c */
    private JSONObject f705c = null;

    /* renamed from: d */
    private boolean f706d = false;

    /* renamed from: e */
    private String f707e;

    public C0824e(JSONObject jSONObject, String str) {
        this.f707e = str;
        m1128a(jSONObject);
        f703a.put(this.f707e, this);
        C0794q.m887a((Object) ("after update aid " + str));
    }

    /* renamed from: a */
    public static void m1127a(String str, JSONObject jSONObject) {
        C0824e c0824e = f703a.get(str);
        if (c0824e != null) {
            c0824e.m1128a(jSONObject);
        } else {
            new C0824e(jSONObject, str);
        }
    }

    /* renamed from: a */
    private void m1128a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f704b = jSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.f706d = optJSONObject.optInt("switcher") == 1 && optJSONObject.optInt("err_sampling_rate") == 1;
    }

    /* renamed from: a */
    public static boolean m1129a(String str) {
        return f703a.get(str) != null;
    }

    /* renamed from: b */
    public static JSONObject m1130b(String str) {
        C0824e c0824e = f703a.get(str);
        if (c0824e != null) {
            return c0824e.m1136a();
        }
        return null;
    }

    /* renamed from: c */
    public static long m1131c(String str) {
        C0824e c0824e = f703a.get(str);
        if (c0824e == null) {
            return 3600000L;
        }
        try {
            return Long.decode(C0789l.m824b(c0824e.m1136a(), "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000L;
        }
    }

    /* renamed from: d */
    public static boolean m1132d(String str) {
        C0824e c0824e = f703a.get(str);
        return c0824e != null && c0824e.m1137b() && c0824e.m1140e();
    }

    /* renamed from: e */
    public static boolean m1133e(String str) {
        C0824e c0824e = f703a.get(str);
        return c0824e != null && c0824e.m1138c() && c0824e.m1140e();
    }

    /* renamed from: f */
    public static boolean m1134f(String str) {
        C0824e c0824e = f703a.get(str);
        return c0824e != null && c0824e.m1139d() && c0824e.m1140e();
    }

    /* renamed from: g */
    public static boolean m1135g(String str) {
        C0824e c0824e = f703a.get(str);
        return c0824e == null || c0824e.m1140e();
    }

    /* renamed from: a */
    public JSONObject m1136a() {
        return this.f704b;
    }

    /* renamed from: b */
    public boolean m1137b() {
        JSONObject jSONObject = this.f704b;
        return jSONObject != null && 1 == C0789l.m816a(jSONObject, 0, "crash_module", "switcher");
    }

    /* renamed from: c */
    public boolean m1138c() {
        JSONObject jSONObject = this.f704b;
        return jSONObject != null && 1 == C0789l.m816a(jSONObject, 0, "crash_module", "switcher");
    }

    /* renamed from: d */
    public boolean m1139d() {
        JSONObject jSONObject = this.f704b;
        return jSONObject != null && 1 == C0789l.m816a(jSONObject, 0, "crash_module", "switcher");
    }

    /* renamed from: e */
    public boolean m1140e() {
        try {
            JSONObject jSONObject = this.f704b;
            if (jSONObject != null) {
                return jSONObject.optInt("status") == 0;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
