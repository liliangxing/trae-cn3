package com.bytedance.bdturing.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsonUtils {
    public static void putValue(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> jsonToMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            String obj = opt != null ? opt.toString() : "";
            if (!TextUtils.isEmpty(obj)) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }
}
