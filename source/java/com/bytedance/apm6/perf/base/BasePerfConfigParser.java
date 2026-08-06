package com.bytedance.apm6.perf.base;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BasePerfConfigParser {
    private static final String PERF_KEY = "performance_modules";

    public static JSONObject parseData(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.optJSONObject("performance_modules").optJSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
