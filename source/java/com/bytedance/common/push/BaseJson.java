package com.bytedance.common.push;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BaseJson {
    public void add(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, String str, double d) {
        try {
            jSONObject.put(str, d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, String str, float f) {
        try {
            jSONObject.put(str, f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject.put(next, jSONObject2.get(next));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
