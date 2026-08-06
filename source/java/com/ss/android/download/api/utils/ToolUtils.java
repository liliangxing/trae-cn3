package com.ss.android.download.api.utils;

import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ToolUtils {
    public static long optLong(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
