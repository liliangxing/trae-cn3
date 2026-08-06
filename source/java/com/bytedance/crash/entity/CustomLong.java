package com.bytedance.crash.entity;

import com.bytedance.crash.util.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CustomLong {
    public static final String TAG = "custom_long";

    public static void add(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray.length() != 0) {
            JSONUtils.put(JSONUtils.get(jSONObject, TAG), str, jSONArray);
        }
    }
}
