package com.bytedance.bdturing.senseless;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TraceDataProcessor {
    private static final String KEY_MIRACULOUS = "miraculous";
    private static final String KEY_RENAISSANCE = "renaissance";
    private static final String KEY_TRANQUILITY = "tranquility";
    private static final String KEY_ZENITH = "zenith";
    private static final String TYPE_NOCAPTCHA = "nocaptcha";
    private static final String TYPE_NOCAPTCHA_COLLECT = "nocaptcha_collect";

    public static Map<String, Long> processData(long j, JSONArray jSONArray, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (jSONArray != null && jSONArray.length() > 0) {
            if ("nocaptcha".equals(str)) {
                return nocaptchaData(j, jSONArray, str2);
            }
            if ("nocaptcha_collect".equals(str)) {
                return nocaptchaCollectData(j, jSONArray, str2);
            }
        }
        return hashMap;
    }

    private static Map<String, Long> nocaptchaData(long j, JSONArray jSONArray, String str) {
        HashMap hashMap = new HashMap();
        int i = 0;
        if (TraceDataManager.DATA_TYPE_PRE.equals(str)) {
            long j2 = 0;
            while (i < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    j2 += optJSONObject.optLong("et");
                }
                i++;
            }
            hashMap.put(KEY_ZENITH, Long.valueOf(j > 0 ? j2 / j : -1L));
        } else if (TraceDataManager.DATA_TYPE_ASYNC.equals(str)) {
            long j3 = 0;
            while (i < jSONArray.length()) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    j3 += optJSONObject2.optLong("t");
                }
                i++;
            }
            hashMap.put(KEY_TRANQUILITY, Long.valueOf(j > 0 ? j3 / j : -1L));
        }
        return hashMap;
    }

    private static Map<String, Long> nocaptchaCollectData(long j, JSONArray jSONArray, String str) {
        HashMap hashMap = new HashMap();
        int i = 0;
        if (TraceDataManager.DATA_TYPE_PRE.equals(str)) {
            long j2 = 0;
            while (i < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    j2 += optJSONObject.optLong("et");
                }
                i++;
            }
            hashMap.put(KEY_RENAISSANCE, Long.valueOf(j > 0 ? j2 % j : -1L));
        } else if (TraceDataManager.DATA_TYPE_ASYNC.equals(str)) {
            long j3 = 0;
            while (i < jSONArray.length()) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    j3 += optJSONObject2.optLong("t");
                }
                i++;
            }
            hashMap.put(KEY_MIRACULOUS, Long.valueOf(j > 0 ? j3 % j : -1L));
        }
        return hashMap;
    }
}
