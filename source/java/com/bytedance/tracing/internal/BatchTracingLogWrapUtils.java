package com.bytedance.tracing.internal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class BatchTracingLogWrapUtils {
    private static final String WRAPPER_ARRAY_DATA = "wrapper_array_data";

    public static JSONObject wrapData(JSONArray jSONArray) throws JSONException {
        return new JSONObject().put("wrapper_array_data", jSONArray);
    }

    public static JSONArray stripData(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("wrapper_array_data")) == null) {
            return null;
        }
        return optJSONArray;
    }
}
