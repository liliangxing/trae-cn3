package com.bytedance.push.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JsonUtils {
    public static Map<String, Integer> jsonToMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, Integer.valueOf(jSONObject.getInt(next)));
            }
        } catch (Throwable th) {
            Logger.e("JsonUtils", "[jsonToMap]error ", th);
        }
        return hashMap;
    }

    public static JSONObject mapToJson(Map<String, Integer> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            Logger.e("JsonUtils", "[mapToJson]error ", th);
        }
        return jSONObject;
    }
}
