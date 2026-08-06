package com.ss.bduploader.util;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class Utils {
    public static String mapToString(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(str, obj);
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
