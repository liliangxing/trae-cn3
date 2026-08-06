package com.bytedance.sync.p005v4.presistence.converter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ExtraConverter {
    public static Map<String, String> revertTopicType(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static String converterStatus(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        try {
            return new JSONObject(map).toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
