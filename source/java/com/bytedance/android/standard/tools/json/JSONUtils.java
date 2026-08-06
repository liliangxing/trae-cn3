package com.bytedance.android.standard.tools.json;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class JSONUtils {
    private JSONUtils() {
    }

    public static long optLong(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        Object opt = jSONObject.opt(str);
        if (opt instanceof Long) {
            return ((Long) opt).longValue();
        }
        if (opt instanceof Number) {
            return ((Number) opt).longValue();
        }
        if (opt instanceof String) {
            try {
                return Long.parseLong((String) opt);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static boolean optBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return z;
        }
        int optInt = jSONObject.optInt(str, -1);
        if (optInt >= 1) {
            return true;
        }
        if (optInt == 0) {
            return false;
        }
        return jSONObject.optBoolean(str, z);
    }

    public static JSONObject mergeJsonObject(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return null;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys != null && keys.hasNext()) {
                    String next = keys.next();
                    if (!jSONObject3.has(next)) {
                        jSONObject3.put(next, jSONObject.opt(next));
                    }
                }
            } catch (Exception unused) {
                return null;
            }
        }
        if (jSONObject2 != null) {
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2 != null) {
                if (!keys2.hasNext()) {
                    break;
                }
                String next2 = keys2.next();
                if (!jSONObject3.has(next2)) {
                    jSONObject3.put(next2, jSONObject2.opt(next2));
                }
            }
        }
        return jSONObject3;
    }

    public static JSONArray parseJsonArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject parseJsonObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
