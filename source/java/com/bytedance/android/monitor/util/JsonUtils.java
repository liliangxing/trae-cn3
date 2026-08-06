package com.bytedance.android.monitor.util;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
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

    public static void safePut(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
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
}
