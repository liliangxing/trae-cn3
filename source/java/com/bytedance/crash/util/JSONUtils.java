package com.bytedance.crash.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class JSONUtils {
    public static boolean isEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static void addKVs(JSONObject jSONObject, Object... objArr) {
        if (jSONObject == null || objArr == null || objArr.length % 2 != 0 || objArr.length == 0) {
            NpthLog.e("JSONUtils", "Err use of addKVs!!!!!");
            return;
        }
        for (int i = 0; i < objArr.length; i += 2) {
            put(jSONObject, String.valueOf(objArr[i]), objArr[i + 1]);
        }
    }

    public static JSONArray splitArray(int i, int i2, JSONArray jSONArray) {
        int i3 = i2 + i;
        if (jSONArray.length() <= i3) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i4 = 0; i4 < i; i4++) {
            jSONArray2.put(jSONArray.opt(i4));
        }
        jSONArray2.put("... skip " + ((jSONArray.length() - i2) - i) + " lines");
        while (i < i3) {
            jSONArray2.put(jSONArray.opt(jSONArray.length() - (i3 - i)));
            i++;
        }
        return jSONArray2;
    }

    public static void assignIfNoExist(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable unused) {
                return;
            }
        }
    }

    public static JSONArray getArrayFromParent(JSONObject jSONObject, String... strArr) {
        JSONObject jsonFromParent = getJsonFromParent(jSONObject, strArr);
        if (jsonFromParent == null) {
            return null;
        }
        return jsonFromParent.optJSONArray(strArr[strArr.length - 1]);
    }

    public static String getStringFromParent(JSONObject jSONObject, String... strArr) {
        JSONObject jsonFromParent = getJsonFromParent(jSONObject, strArr);
        if (jsonFromParent == null) {
            return null;
        }
        return jsonFromParent.optString(strArr[strArr.length - 1]);
    }

    public static int getIntFromParent(JSONObject jSONObject, int i, String... strArr) {
        JSONObject jsonFromParent = getJsonFromParent(jSONObject, strArr);
        return jsonFromParent == null ? i : jsonFromParent.optInt(strArr[strArr.length - 1], i);
    }

    public static JSONObject getJsonFromParent(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            return null;
        }
        for (int i = 0; i < strArr.length - 1; i++) {
            jSONObject = jSONObject.optJSONObject(strArr[i]);
            if (jSONObject == null) {
                NpthLog.i("JSONUtil", "err get json: not found node:" + strArr[i]);
                return null;
            }
        }
        return jSONObject;
    }

    public static HashMap<String, Object> toMap(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.opt(next));
        }
        return hashMap;
    }

    public static Map<String, Object> toJson(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.opt(next));
        }
        return hashMap;
    }

    public static JSONObject put(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null && obj != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static void put(JSONObject jSONObject, Map<? extends String, ?> map) {
        if (jSONObject == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject get(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            try {
                jSONObject.put(str, optJSONObject);
            } catch (JSONException unused) {
            }
        }
        return optJSONObject;
    }

    public static void combineJson(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt == null) {
                    jSONObject.put(next, jSONObject2.opt(next));
                } else if (opt instanceof JSONObject) {
                    combineJson(jSONObject.getJSONObject(next), jSONObject2.getJSONObject(next));
                } else if (opt instanceof JSONArray) {
                    JSONArray optJSONArray = jSONObject2.optJSONArray(next);
                    if (optJSONArray != null) {
                        JSONArray jSONArray = (JSONArray) opt;
                        if (jSONArray.length() == 1 && (jSONArray.opt(0) instanceof JSONObject) && (optJSONArray.opt(0) instanceof JSONObject)) {
                            combineJson(jSONArray.getJSONObject(0), optJSONArray.getJSONObject(0));
                        } else {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                jSONArray.put(optJSONArray.get(i));
                            }
                        }
                    }
                } else {
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            }
        } catch (JSONException unused) {
        }
    }

    public static JSONArray toArray(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static void jsonPutAll(JSONObject jSONObject, Map<String, ? extends Object> map) {
        if (jSONObject == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        return optJSONObject.optJSONObject(str2);
    }

    public static void append(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void append(JSONObject jSONObject, String str, Object obj) {
        if (obj != null) {
            try {
                jSONObject.put(str, String.valueOf(obj));
            } catch (JSONException unused) {
            }
        }
    }

    public static void appendInt(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (JSONException unused) {
        }
    }

    public static void appendLong(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (JSONException unused) {
        }
    }

    public static boolean jsonEquals(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (!jSONObject.has(next) || !objectEquals(jSONObject.opt(next), jSONObject2.opt(next))) {
                    return false;
                }
            } catch (Throwable unused) {
                return true;
            }
        }
        return true;
    }

    public static boolean objectEquals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }
}
