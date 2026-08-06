package com.bytedance.sync.util;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class JSONUtils {
    public static void safePutParam(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void safePutParam(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void safePutParam(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void safePutParam(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
