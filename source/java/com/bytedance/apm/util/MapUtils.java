package com.bytedance.apm.util;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MapUtils {
    public static JSONObject mapToJson(Map<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject(map);
        jSONObject.put("", "");
        return jSONObject;
    }
}
