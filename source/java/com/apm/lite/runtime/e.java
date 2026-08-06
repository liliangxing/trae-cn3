package com.apm.lite.runtime;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e {
    private static HashMap<String, e> a = new HashMap<>();
    private JSONObject b = null;
    private JSONObject c = null;
    private boolean d = false;
    private String e;

    public e(JSONObject jSONObject, String str) {
        this.e = str;
        a(jSONObject);
        a.put(this.e, this);
        com.apm.lite.k.q.a((Object) ("after update aid " + str));
    }

    public static void a(String str, JSONObject jSONObject) {
        e eVar = a.get(str);
        if (eVar != null) {
            eVar.a(jSONObject);
        } else {
            new e(jSONObject, str);
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.b = jSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.d = optJSONObject.optInt("switcher") == 1 && optJSONObject.optInt("err_sampling_rate") == 1;
    }

    public static boolean a(String str) {
        return a.get(str) != null;
    }

    public static JSONObject b(String str) {
        e eVar = a.get(str);
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public static long c(String str) {
        e eVar = a.get(str);
        if (eVar == null) {
            return 3600000L;
        }
        try {
            return Long.decode(com.apm.lite.k.l.b(eVar.a(), "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000L;
        }
    }

    public static boolean d(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.b() && eVar.e();
    }

    public static boolean e(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.c() && eVar.e();
    }

    public static boolean f(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.d() && eVar.e();
    }

    public static boolean g(String str) {
        e eVar = a.get(str);
        return eVar == null || eVar.e();
    }

    public JSONObject a() {
        return this.b;
    }

    public boolean b() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.lite.k.l.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean c() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.lite.k.l.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean d() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.lite.k.l.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean e() {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject != null) {
                return jSONObject.optInt("status") == 0;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
