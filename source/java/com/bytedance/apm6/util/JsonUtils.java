package com.bytedance.apm6.util;

import com.bytedance.apm6.util.log.Logger;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static JSONObject copyJson2(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || (keys = jSONObject2.keys()) == null) {
            return null;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.isNull(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    public static boolean isEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static boolean hasData(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    public static boolean hasData(JSONArray jSONArray) {
        return jSONArray != null && jSONArray.length() > 0;
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        return optJSONObject.optJSONObject(str2);
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str, String str2, String str3) {
        JSONObject optJSONObject = optJSONObject(jSONObject, str, str2);
        if (optJSONObject == null) {
            return null;
        }
        return optJSONObject.optJSONObject(str3);
    }

    public static int optInt(JSONObject jSONObject, String str, String str2, String str3) {
        JSONObject optJSONObject = optJSONObject(jSONObject, str, str2);
        if (optJSONObject == null) {
            return 0;
        }
        return optJSONObject.optInt(str3, 0);
    }

    public static int optInt(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return 0;
        }
        return optJSONObject.optInt(str2, 0);
    }

    public static boolean optBoolean(JSONObject jSONObject, String str, String str2, boolean z) {
        JSONObject optJSONObject;
        return (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) ? z : optJSONObject.optBoolean(str2, z);
    }

    public static String removeString(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(str)) {
                return null;
            }
            String string = jSONObject.getString(str);
            jSONObject.remove(str);
            return string;
        } catch (Exception e) {
            Logger.e(TAG, "removeString", e);
            return null;
        }
    }

    public static int removeInt(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(str)) {
                return 0;
            }
            int i = jSONObject.getInt(str);
            jSONObject.remove(str);
            return i;
        } catch (Exception e) {
            Logger.e(TAG, "removeInt", e);
            return 0;
        }
    }

    public static long removeLong(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(str)) {
                return 0L;
            }
            long j = jSONObject.getLong(str);
            jSONObject.remove(str);
            return j;
        } catch (Exception e) {
            Logger.e(TAG, "removeLong", e);
            return 0L;
        }
    }

    public static JSONObject safeCopyJson(JSONObject jSONObject) {
        Iterator<String> keys;
        if (jSONObject == null || (keys = jSONObject.keys()) == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof JSONObject) {
                    JSONObject safeCopyJson2 = safeCopyJson2((JSONObject) opt);
                    if (safeCopyJson2 != null) {
                        jSONObject2.put(next, safeCopyJson2);
                    }
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        jSONArray2.put(jSONArray.get(i));
                    }
                    jSONObject2.put(next, jSONArray2);
                } else {
                    jSONObject2.put(next, opt);
                }
            }
            return jSONObject2;
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    private static JSONObject safeCopyJson2(JSONObject jSONObject) {
        Iterator<String> keys;
        if (jSONObject == null || (keys = jSONObject.keys()) == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            }
            return jSONObject2;
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    public static void mergeNestedData(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject2 == null || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String[] split = next.split("#");
            JSONObject jSONObject3 = jSONObject;
            for (int i = 0; i < split.length - 1; i++) {
                if (!jSONObject3.has(split[i]) || !jSONObject3.get(split[i]).getClass().equals(JSONObject.class)) {
                    jSONObject3.put(split[i], new JSONObject());
                }
                jSONObject3 = jSONObject3.getJSONObject(split[i]);
            }
            jSONObject3.put(split[split.length - 1], jSONObject2.get(next));
        }
    }

    public static void deleteNestedData(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject2 == null || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String[] split = keys.next().split("#");
            JSONObject jSONObject3 = jSONObject;
            for (int i = 0; i < split.length - 1; i++) {
                if (!jSONObject3.has(split[i]) || !jSONObject3.get(split[i]).getClass().equals(JSONObject.class)) {
                    jSONObject3 = null;
                    break;
                }
                jSONObject3 = jSONObject3.getJSONObject(split[i]);
            }
            if (jSONObject3 != null) {
                jSONObject3.remove(split[split.length - 1]);
            }
        }
    }
}
