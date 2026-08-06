package com.apm.lite.p016d;

import com.apm.lite.C0749e;
import com.apm.lite.nativecrash.C0805c;
import com.apm.lite.nativecrash.C0806d;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.runtime.p024a.C0812b;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.d.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0745a {

    /* renamed from: a */
    protected JSONObject f403a;

    /* renamed from: b */
    protected C0747c f404b;

    public C0745a() {
        this.f403a = new JSONObject();
    }

    public C0745a(JSONObject jSONObject) {
        this.f403a = jSONObject;
    }

    /* renamed from: a */
    public static void m466a(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            try {
                optJSONObject = new JSONObject();
                jSONObject.put(str, optJSONObject);
            } catch (Throwable unused) {
                return;
            }
        }
        optJSONObject.put(str2, str3);
    }

    /* renamed from: a */
    public static void m467a(JSONObject jSONObject, Throwable th) {
        String str = "npth_err_info";
        if (jSONObject.opt("npth_err_info") != null) {
            for (int i = 0; i < 5; i++) {
                if (jSONObject.opt("npth_err_info" + i) == null) {
                    try {
                        str = "npth_err_info" + i;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
            return;
        }
        jSONObject.put(str, C0799v.m917a(th));
    }

    /* renamed from: a */
    public static void m468a(JSONObject jSONObject, Map<? extends String, ? extends String> map) {
        if (map != null) {
            try {
                for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m469a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject.put("storage", jSONObject2);
        } catch (Throwable unused) {
        }
        long optLong = jSONObject2.optLong("inner_free");
        long optLong2 = jSONObject2.optLong("sdcard_free");
        long optLong3 = jSONObject2.optLong("inner_free_real");
        String str = "1M - 64M";
        String str2 = optLong <= 1024 ? "0 - 1K" : optLong <= 65536 ? "1K - 64K" : optLong <= 524288 ? "64K - 512K" : optLong <= 1048576 ? "512K - 1M" : optLong <= 67108864 ? "1M - 64M" : "64M - ";
        String str3 = optLong3 <= 1024 ? "0 - 1K" : optLong3 <= 65536 ? "1K - 64K" : optLong3 <= 524288 ? "64K - 512K" : optLong3 <= 1048576 ? "512K - 1M" : optLong3 <= 67108864 ? "1M - 64M" : "64M - ";
        if (optLong2 <= 1024) {
            str = "0 - 1K";
        } else if (optLong2 <= 65536) {
            str = "1K - 64K";
        } else if (optLong2 <= 524288) {
            str = "64K - 512K";
        } else if (optLong2 <= 1048576) {
            str = "512K - 1M";
        } else if (optLong2 > 67108864) {
            str = "64M - ";
        }
        m466a(jSONObject, "filters", "inner_free", str2);
        m466a(jSONObject, "filters", "inner_free_real", str3);
        m466a(jSONObject, "filters", "sdcard_free", str);
    }

    /* renamed from: a */
    public static boolean m470a(String str) {
        return C0792o.m858c(str).exists();
    }

    /* renamed from: b */
    public static void m471b(JSONObject jSONObject, JSONObject jSONObject2) {
        Object opt;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt2 = jSONObject.opt(next);
                if (opt2 == null) {
                    opt = jSONObject2.opt(next);
                } else {
                    if (opt2 instanceof JSONObject) {
                        jSONObject3 = jSONObject.getJSONObject(next);
                        jSONObject4 = jSONObject2.getJSONObject(next);
                    } else if (opt2 instanceof JSONArray) {
                        JSONArray optJSONArray = jSONObject2.optJSONArray(next);
                        if (optJSONArray != null) {
                            JSONArray jSONArray = (JSONArray) opt2;
                            if (jSONArray.length() == 1 && (jSONArray.opt(0) instanceof JSONObject) && (optJSONArray.opt(0) instanceof JSONObject)) {
                                jSONObject3 = jSONArray.getJSONObject(0);
                                jSONObject4 = optJSONArray.getJSONObject(0);
                            } else {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    jSONArray.put(optJSONArray.get(i));
                                }
                            }
                        }
                    } else {
                        opt = jSONObject2.opt(next);
                    }
                    m471b(jSONObject3, jSONObject4);
                }
                jSONObject.put(next, opt);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static boolean m472b(String str) {
        return ((long) C0806d.m1002c(str)) > C0805c.m971i();
    }

    /* renamed from: c */
    public static boolean m473c(String str) {
        return C0806d.m999a(str) > 960;
    }

    /* renamed from: d */
    public static boolean m474d(String str) {
        return C0806d.m1001b(str) > 350;
    }

    /* renamed from: a */
    public C0745a m475a(int i, String str) {
        try {
            this.f403a.put("miniapp_id", i);
            this.f403a.put("miniapp_version", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    /* renamed from: a */
    public C0745a m476a(long j) {
        try {
            m484a("app_start_time", Long.valueOf(j));
            m484a("app_start_time_readable", (Object) new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /* renamed from: a */
    public C0745a m477a(C0747c c0747c) {
        m484a(Constants.KEY_HEADER, c0747c.m537g());
        this.f404b = c0747c;
        return this;
    }

    /* renamed from: a */
    public C0745a m478a(C0812b c0812b) {
        m484a("activity_trace", c0812b.m1085g());
        m480a("activity_track", c0812b.m1087i());
        return this;
    }

    /* renamed from: a */
    public C0745a m479a(String str, String str2) {
        Object opt = m498h().opt(Constants.KEY_DATA);
        m466a(opt instanceof JSONArray ? ((JSONArray) opt).optJSONObject(0) : m498h(), "filters", str, str2);
        return this;
    }

    /* renamed from: a */
    public C0745a m480a(String str, JSONArray jSONArray) {
        JSONObject optJSONObject = m498h().optJSONObject("custom_long");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            m484a("custom_long", optJSONObject);
        }
        try {
            optJSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
        return this;
    }

    /* renamed from: a */
    public C0745a m481a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            m484a("patch_info", (Object) jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        m484a("patch_info", (Object) jSONArray);
        return this;
    }

    /* renamed from: a */
    public C0745a m482a(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.f403a.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MonitorConstants.HOST_APP_PACKAGE_NAME, str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.f403a.put("plugin_info", jSONArray);
        return this;
    }

    /* renamed from: a */
    public C0745a m483a(JSONObject jSONObject) {
        m484a(Constants.KEY_HEADER, jSONObject);
        return this;
    }

    /* renamed from: a */
    public void m484a(String str, Object obj) {
        try {
            this.f403a.put(str, obj);
        } catch (Exception e) {
            C0794q.m893b(e);
        }
    }

    /* renamed from: a */
    public boolean m485a() {
        return m498h().opt(Constants.KEY_DATA) instanceof JSONArray ? !C0789l.m823a(((JSONArray) r0).optJSONObject(0), "logcat") : !C0789l.m823a(this.f403a, "logcat");
    }

    /* renamed from: b */
    public C0745a m486b(String str, String str2) {
        Object opt = m498h().opt(Constants.KEY_DATA);
        m466a(opt instanceof JSONArray ? ((JSONArray) opt).optJSONObject(0) : m498h(), "custom", str, str2);
        return this;
    }

    /* renamed from: b */
    public C0745a m487b(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    C0794q.m893b(e);
                }
            }
            try {
                this.f403a.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    /* renamed from: b */
    public C0745a m488b(JSONObject jSONObject) {
        m469a(this.f403a, jSONObject);
        return this;
    }

    /* renamed from: b */
    public void m489b() {
        m479a("has_logcat", String.valueOf(m485a()));
    }

    /* renamed from: c */
    public C0745a m490c(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject m494e = m494e("filters");
            for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                try {
                    m494e.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
            m484a("filters", m494e);
        }
        return this;
    }

    /* renamed from: c */
    public void m491c() {
        m479a("is_64_devices", String.valueOf(C0747c.m516a()));
        m479a("is_64_runtime", String.valueOf(NativeImpl.is64BitRuntime()));
        m479a("is_x86_devices", String.valueOf(C0747c.m520b()));
    }

    /* renamed from: c */
    public void m492c(JSONObject jSONObject) {
        m471b(this.f403a, jSONObject);
    }

    /* renamed from: d */
    public boolean m493d() {
        return m473c(C0749e.m564f());
    }

    /* renamed from: e */
    public JSONObject m494e(String str) {
        Object opt = m498h().opt(Constants.KEY_DATA);
        JSONObject optJSONObject = opt instanceof JSONArray ? ((JSONArray) opt).optJSONObject(0) : m498h();
        if (optJSONObject == null) {
            return new JSONObject();
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
        if (optJSONObject2 != null) {
            return optJSONObject2;
        }
        JSONObject jSONObject = new JSONObject();
        m484a(str, jSONObject);
        return jSONObject;
    }

    /* renamed from: e */
    public boolean m495e() {
        return m474d(C0749e.m564f());
    }

    /* renamed from: f */
    public boolean m496f() {
        return m472b(C0749e.m564f());
    }

    /* renamed from: g */
    public boolean m497g() {
        return m470a(C0749e.m564f());
    }

    /* renamed from: h */
    public JSONObject m498h() {
        return this.f403a;
    }

    /* renamed from: i */
    public C0747c m499i() {
        if (this.f404b == null) {
            C0747c c0747c = new C0747c(C0749e.m565g());
            this.f404b = c0747c;
            m477a(c0747c);
        }
        return this.f404b;
    }
}
