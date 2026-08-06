package com.apm.lite.runtime;

import com.apm.lite.C0749e;
import com.apm.lite.p022j.C0766a;
import com.apm.lite.p022j.C0775j;
import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0794q;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.runtime.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0810a {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<Object> f647a = new ConcurrentLinkedQueue<>();

    /* renamed from: a */
    public static int m1014a(int i, String... strArr) {
        return C0789l.m816a(m1017a(), i, strArr);
    }

    /* renamed from: a */
    public static int m1015a(String... strArr) {
        return C0789l.m816a(m1017a(), -1, strArr);
    }

    /* renamed from: a */
    public static String m1016a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("exception_modules")) == null) {
            return null;
        }
        return optJSONObject.optString("npth");
    }

    /* renamed from: a */
    public static JSONObject m1017a() {
        return C0824e.m1130b(C0749e.m553a().m1125e());
    }

    /* renamed from: a */
    public static JSONObject m1018a(JSONArray jSONArray, String str) {
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i).optJSONObject(str);
                if (optJSONObject != null) {
                    return optJSONObject;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m1019a(JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        C0794q.m889a("apmconfig", "fromnet " + z + " : " + jSONArray);
        if (z) {
            C0775j.m730f();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String next = optJSONObject.keys().next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                C0794q.m887a((Object) ("update config " + next + " : " + optJSONObject2));
                C0824e.m1127a(next, optJSONObject2);
                if (z) {
                    C0775j.m722a(next);
                }
            } catch (Throwable unused) {
            }
        }
        C0830k.m1152a(m1018a(jSONArray, String.valueOf(C0749e.m553a().m1125e())));
        if (z) {
            C0775j.m723a(false, jSONArray);
        }
    }

    /* renamed from: a */
    public static boolean m1020a(String str) {
        if (!C0824e.m1129a(str)) {
            C0766a.m649b();
        }
        return C0824e.m1132d(str);
    }

    /* renamed from: b */
    public static boolean m1021b() {
        return C0831l.m1176e();
    }

    /* renamed from: b */
    public static boolean m1022b(String str) {
        if (!C0824e.m1129a(str)) {
            C0766a.m649b();
        }
        return C0824e.m1134f(str);
    }

    /* renamed from: c */
    public static JSONArray m1023c() {
        return C0789l.m818a(m1017a(), "custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore");
    }

    /* renamed from: c */
    public static boolean m1024c(String str) {
        if (!C0824e.m1129a(str)) {
            C0766a.m649b();
        }
        return C0824e.m1133e(str);
    }

    /* renamed from: d */
    public static boolean m1025d() {
        return m1015a("custom_event_settings", "npth_simple_setting", "disable_looper_monitor") == 1;
    }

    /* renamed from: e */
    public static boolean m1026e() {
        return m1015a("custom_event_settings", "npth_simple_setting", "enable_all_thread_stack_native") == 1;
    }

    /* renamed from: f */
    public static boolean m1027f() {
        return m1015a("custom_event_settings", "npth_simple_setting", "anr_with_traces_txt") == 1;
    }

    /* renamed from: g */
    public static boolean m1028g() {
        return m1015a("custom_event_settings", "npth_simple_setting", "upload_crash_crash") == 1;
    }

    /* renamed from: h */
    public static boolean m1029h() {
        return m1015a("custom_event_settings", "npth_simple_setting", "enable_killed_anr") == 1;
    }

    /* renamed from: i */
    public static boolean m1030i() {
        return m1015a("custom_event_settings", "npth_simple_setting", "enable_anr_all_process_trace") == 1;
    }
}
