package com.bytedance.android.monitorV2.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsonUtils {
    public static int safeOptInt(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.optInt(str, 0);
    }

    public static boolean safeOptBool(JSONObject jSONObject, String str, Boolean bool) {
        return jSONObject == null ? bool.booleanValue() : jSONObject.optBoolean(str, bool.booleanValue());
    }

    public static long safeOptLong(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        return jSONObject.optLong(str, 0L);
    }

    public static String safeOptStr(JSONObject jSONObject, String str) {
        return jSONObject == null ? "" : jSONObject.optString(str, "");
    }

    public static String safeOptStr(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return str2;
        }
        try {
            return jSONObject.optString(str, str2);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return str2;
        }
    }

    public static JSONObject safeOptJsonObj(JSONObject jSONObject, String str) {
        return jSONObject == null ? new JSONObject() : jSONObject.optJSONObject(str);
    }

    public static JSONArray safeOptJsonArray(JSONObject jSONObject, String str) {
        return jSONObject == null ? new JSONArray() : jSONObject.optJSONArray(str);
    }

    public static Object safeOptObj(JSONObject jSONObject, String str) {
        return jSONObject == null ? new Object() : jSONObject.opt(str);
    }

    public static Object safeOptObjForArray(JSONArray jSONArray, int i) {
        try {
            return jSONArray.opt(i);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return new Object();
        }
    }

    public static void safePut(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    public static void safePut(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    public static void safePut(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, Object obj) {
        if (obj != null) {
            try {
                jSONObject.put(str, obj);
            } catch (Exception e) {
                ExceptionUtil.handleException(e);
            }
        }
    }

    public static void putIfNotBlank(JSONObject jSONObject, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            jSONObject.put(str, str2);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    public static void safePut(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    public static JSONObject safeToJsonOb(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            return new JSONObject(str);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return new JSONObject();
        }
    }

    public static void deepCopy(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                safePut(jSONObject, next, safeOptObj(jSONObject2, next));
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    public static boolean safeCompare(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        return jSONObject.toString().equals(jSONObject2.toString());
    }

    public static boolean safeCompareStr(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        return safeOptStr(jSONObject, str).equals(safeOptStr(jSONObject2, str));
    }

    public static boolean safeCompareArgs(JSONObject jSONObject, JSONObject jSONObject2, String... strArr) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        for (String str : strArr) {
            if (!safeOptStr(jSONObject, str).equals(safeOptStr(jSONObject2, str))) {
                return false;
            }
        }
        return true;
    }

    public static JSONObject merge(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
        if (jSONObject == null) {
            return merge(new JSONObject(), jSONObject2);
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject2.opt(next);
            if (opt instanceof JSONObject) {
                safePut(jSONObject, next, merge(jSONObject.optJSONObject(next), jSONObject2.optJSONObject(next)));
            } else {
                safePut(jSONObject, next, opt);
            }
        }
        return jSONObject;
    }

    public static Map<String, Object> safeToMap(JSONObject jSONObject) {
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.opt(next));
            }
            return hashMap;
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return new HashMap();
        }
    }

    public static List<String> jsonArrToList(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return new ArrayList();
        }
    }
}
