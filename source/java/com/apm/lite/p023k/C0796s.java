package com.apm.lite.p023k;

import android.text.TextUtils;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0747c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.k.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0796s {
    /* renamed from: a */
    public static void m898a(C0745a c0745a, C0747c c0747c, CrashType crashType) {
        if (c0745a != null) {
            m899a(c0745a.m498h(), c0747c, crashType);
        }
    }

    /* renamed from: a */
    public static void m899a(JSONObject jSONObject, C0747c c0747c, CrashType crashType) {
        if (jSONObject == null || crashType == null) {
            return;
        }
        long optLong = jSONObject.optLong("crash_time");
        String m1226a = C0749e.m560c().m1226a();
        if (optLong <= 0 || TextUtils.isEmpty(crashType.getName())) {
            return;
        }
        try {
            String str = "android__" + m1226a + "_" + optLong + "_" + crashType;
            if (c0747c == null || (jSONObject = c0747c.m537g()) != null) {
                jSONObject.put("unique_key", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
