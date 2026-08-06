package com.bytedance.applog.util;

import com.bytedance.applog.log.LoggerImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class JsonUtils {
    private static boolean commonCompare(Object obj, Object obj2, String str) {
        return (obj != null || obj2 == null) && (obj == null || obj2 != null);
    }

    public static boolean compareJsons(JSONObject jSONObject, JSONObject jSONObject2, String str) throws JSONException {
        if (!commonCompare(jSONObject, jSONObject2, str)) {
            return false;
        }
        if (jSONObject != null && jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        boolean z = true;
        while (keys.hasNext()) {
            String next = keys.next();
            z = compareJsons(jSONObject.get(next), jSONObject2.get(next), next);
            if (!z) {
                break;
            }
        }
        return z;
    }

    private static boolean compareJsons(Object obj, Object obj2, String str) throws JSONException {
        if (!commonCompare(obj, obj2, str)) {
            return false;
        }
        if (obj instanceof JSONObject) {
            return compareJsons((JSONObject) obj, (JSONObject) obj2, str);
        }
        if (obj instanceof JSONArray) {
            return compareJsons((JSONArray) obj, (JSONArray) obj2, str);
        }
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return compareJsons(obj.toString(), obj2.toString(), str);
    }

    private static boolean compareJsons(JSONArray jSONArray, JSONArray jSONArray2, String str) throws JSONException {
        if (!commonCompare(jSONArray, jSONArray2, str)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (hashMap.containsKey(obj) && hashMap.get(obj) != null) {
                hashMap.put(obj, Integer.valueOf(((Integer) hashMap.get(obj)).intValue() + 1));
            } else {
                hashMap.put(obj, 1);
            }
        }
        HashMap hashMap2 = new HashMap();
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            Object obj2 = jSONArray2.get(i2);
            if (hashMap2.containsKey(obj2) && hashMap2.get(obj2) != null) {
                hashMap2.put(obj2, Integer.valueOf(((Integer) hashMap2.get(obj2)).intValue() + 1));
            } else {
                hashMap2.put(obj2, 1);
            }
        }
        if (hashMap.size() != hashMap2.size()) {
            return false;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!((Integer) entry.getValue()).equals((Integer) hashMap2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareJsons(String str, String str2, String str3) {
        return commonCompare(str, str2, str3) && str.equals(str2);
    }

    public static boolean paramValueCheck(JSONObject jSONObject, Class<?>[] clsArr, Class<?>[] clsArr2) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object obj = jSONObject.get(keys.next());
            if (obj == null) {
                return false;
            }
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj2 = jSONArray.get(i);
                    if (clsArr2 != null && !arrayContains(clsArr2, obj2.getClass())) {
                        return false;
                    }
                }
            } else if (clsArr != null && !arrayContains(clsArr, obj.getClass())) {
                return false;
            }
        }
        return true;
    }

    private static <T> boolean arrayContains(T[] tArr, T t) {
        for (T t2 : tArr) {
            if (t2 == t) {
                return true;
            }
        }
        return false;
    }

    public static JSONObject mergeJsonObject(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return jSONObject2;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                LoggerImpl.global().error(Collections.singletonList("JsonUtils"), "Merge json interrupted.", e, new Object[0]);
            }
        }
        return jSONObject2;
    }

    public static boolean isJsonArrayEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static boolean jsonContainsAll(JSONObject jSONObject, Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (!jSONObject.has(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isJsonObjectLike(String str) {
        if (Utils.isEmpty(str)) {
            return false;
        }
        return (str.startsWith("{") && str.startsWith("}")) || (str.startsWith("[") && str.endsWith("]"));
    }
}
