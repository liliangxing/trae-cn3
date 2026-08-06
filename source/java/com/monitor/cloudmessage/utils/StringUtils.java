package com.monitor.cloudmessage.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class StringUtils {
    public static String getJsonString(HashMap<String, String> hashMap) {
        JSONObject jSONObject = new JSONObject();
        if (hashMap != null) {
            try {
                for (String str : hashMap.keySet()) {
                    jSONObject.put(str, hashMap.get(str));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static JSONObject getJsonFromMap(Map<String, List<String>> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if (entry.getKey() == null) {
                        jSONObject.put("Response", entry.getValue());
                    } else {
                        jSONObject.put(entry.getKey().toString(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
