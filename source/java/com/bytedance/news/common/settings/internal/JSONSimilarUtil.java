package com.bytedance.news.common.settings.internal;

import java.math.BigInteger;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JSONSimilarUtil {
    public static boolean similar(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                if (jSONObject.length() != jSONObject2.length()) {
                    return false;
                }
                Iterator<String> keys = jSONObject.keys();
                jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!similar(jSONObject.opt(next), jSONObject2.opt(next))) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean similar(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (!similar(jSONArray.opt(i), jSONArray2.opt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean similar(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj instanceof JSONObject) {
            if (obj2 instanceof JSONObject) {
                return similar((JSONObject) obj, (JSONObject) obj2);
            }
            return false;
        }
        if (obj instanceof JSONArray) {
            if (obj2 instanceof JSONArray) {
                return similar((JSONArray) obj, (JSONArray) obj2);
            }
            return false;
        }
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return isNumberSimilar((Number) obj, (Number) obj2);
        }
        return obj.equals(obj2);
    }

    private static boolean isNumberSimilar(Number number, Number number2) {
        if (number == number2) {
            return true;
        }
        if (number == null || number2 == null) {
            return false;
        }
        if (isIntegral(number) && isIntegral(number2)) {
            return number.longValue() == number2.longValue();
        }
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    private static boolean isIntegral(Number number) {
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }
}
