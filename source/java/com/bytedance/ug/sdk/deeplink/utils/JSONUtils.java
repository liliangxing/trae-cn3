package com.bytedance.ug.sdk.deeplink.utils;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JSONUtils {
    private JSONUtils() {
    }

    public static void safePutJSONObject(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void safePutString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void safePutLong(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void safePutInt(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject safeOptJSONObject(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return jSONObject.optJSONObject(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String safeOptString(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return jSONObject.optString(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
