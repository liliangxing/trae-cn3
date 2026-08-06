package com.apm.lite.p023k;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.k.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0789l {
    /* renamed from: a */
    public static int m816a(JSONObject jSONObject, int i, String... strArr) {
        JSONObject m825c = m825c(jSONObject, strArr);
        if (m825c == null) {
            return i;
        }
        int optInt = m825c.optInt(strArr[strArr.length - 1], i);
        C0794q.m889a("JSONUtil", "normal get jsonInt: " + strArr[strArr.length - 1] + " : " + optInt);
        return optInt;
    }

    /* renamed from: a */
    public static JSONArray m817a(int i, int i2, JSONArray jSONArray) {
        int i3 = i2 + i;
        if (jSONArray.length() <= i3) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i4 = 0; i4 < i; i4++) {
            jSONArray2.put(jSONArray.opt(i4));
        }
        while (i < i3) {
            jSONArray2.put(jSONArray.opt(jSONArray.length() - (i3 - i)));
            i++;
        }
        return jSONArray2;
    }

    /* renamed from: a */
    public static JSONArray m818a(JSONObject jSONObject, String... strArr) {
        JSONObject m825c = m825c(jSONObject, strArr);
        if (m825c == null) {
            return null;
        }
        JSONArray optJSONArray = m825c.optJSONArray(strArr[strArr.length - 1]);
        C0794q.m889a("ApmConfig", "normal get configArray: " + strArr[strArr.length - 1] + " : " + optJSONArray);
        return optJSONArray;
    }

    /* renamed from: a */
    public static JSONArray m819a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static void m820a(JSONObject jSONObject, JSONObject jSONObject2) {
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

    /* renamed from: a */
    public static boolean m821a(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    /* renamed from: a */
    public static boolean m822a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    /* renamed from: a */
    public static boolean m823a(JSONObject jSONObject, String str) {
        return m822a(jSONObject) || m821a(jSONObject.optJSONArray(str));
    }

    /* renamed from: b */
    public static String m824b(JSONObject jSONObject, String... strArr) {
        JSONObject m825c = m825c(jSONObject, strArr);
        if (m825c == null) {
            return null;
        }
        String optString = m825c.optString(strArr[strArr.length - 1]);
        C0794q.m889a("ApmConfig", "normal get configArray: " + strArr[strArr.length - 1] + " : " + optString);
        return optString;
    }

    /* renamed from: c */
    public static JSONObject m825c(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            C0794q.m890a("JSONUtil", "err get JsonFromParent: null json", new RuntimeException());
            return null;
        }
        for (int i = 0; i < strArr.length - 1; i++) {
            jSONObject = jSONObject.optJSONObject(strArr[i]);
            if (jSONObject == null) {
                C0794q.m889a("JSONUtil", "err get json: not found node:" + strArr[i]);
                return null;
            }
        }
        return jSONObject;
    }
}
