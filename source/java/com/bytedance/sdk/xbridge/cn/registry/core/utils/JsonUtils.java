package com.bytedance.sdk.xbridge.cn.registry.core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsonUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u0005\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004J\u001a\u0010\r\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/JsonUtils;", "", "()V", "jsonToList", "", "json", "Lorg/json/JSONArray;", "jsonToMap", "", "", "Lorg/json/JSONObject;", "listToJSON", "list", "mapToJSON", "map", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class JsonUtils {
    public static final JsonUtils INSTANCE = new JsonUtils();

    private JsonUtils() {
    }

    public final JSONObject mapToJSON(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Long) {
                jSONObject.put(key, ((Number) value).longValue());
            } else if (value instanceof Float) {
                jSONObject.put(key, ((Number) value).floatValue());
            } else if (value instanceof Integer) {
                jSONObject.put(key, ((Number) value).intValue());
            } else if (value instanceof Double) {
                jSONObject.put(key, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                jSONObject.put(key, value);
            } else if (value instanceof Boolean) {
                jSONObject.put(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Map) {
                try {
                    jSONObject.put(key, INSTANCE.mapToJSON((Map) value));
                } catch (Exception unused) {
                }
            } else if (value instanceof List) {
                jSONObject.put(key, INSTANCE.listToJSON((List) value));
            }
        }
        return jSONObject;
    }

    public final JSONArray listToJSON(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof Float) {
                jSONArray.put(((Number) obj).floatValue());
            } else if (obj instanceof Long) {
                jSONArray.put(((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                jSONArray.put(((Number) obj).intValue());
            } else if (obj instanceof Double) {
                jSONArray.put(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                jSONArray.put(obj);
            } else if (obj instanceof Boolean) {
                jSONArray.put(((Boolean) obj).booleanValue());
            } else if (obj instanceof Map) {
                try {
                    JsonUtils jsonUtils = INSTANCE;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    jSONArray.put(jsonUtils.mapToJSON((Map) obj));
                } catch (Exception unused) {
                }
            } else if (obj instanceof List) {
                JsonUtils jsonUtils2 = INSTANCE;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                jSONArray.put(jsonUtils2.listToJSON((List) obj));
            }
        }
        return jSONArray;
    }

    public final Map<String, Object> jsonToMap(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object opt = json.opt(key);
            if (opt instanceof Long) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, Long.valueOf(json.optLong(key)));
            } else if (opt instanceof Double) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, Double.valueOf(json.optDouble(key)));
            } else if (opt instanceof Integer) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, Integer.valueOf(json.optInt(key)));
            } else if (opt instanceof String) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, json.optString(key));
            } else if (opt instanceof JSONObject) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                JsonUtils jsonUtils = INSTANCE;
                JSONObject optJSONObject = json.optJSONObject(key);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "json.optJSONObject(key)");
                linkedHashMap.put(key, jsonUtils.jsonToMap(optJSONObject));
            } else if (opt instanceof JSONArray) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                JsonUtils jsonUtils2 = INSTANCE;
                JSONArray optJSONArray = json.optJSONArray(key);
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "json.optJSONArray(key)");
                linkedHashMap.put(key, jsonUtils2.jsonToList(optJSONArray));
            } else if (opt instanceof Boolean) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, Boolean.valueOf(json.optBoolean(key)));
            } else {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, null);
            }
        }
        return linkedHashMap;
    }

    public final List<Object> jsonToList(JSONArray json) {
        Intrinsics.checkNotNullParameter(json, "json");
        ArrayList arrayList = new ArrayList();
        int length = json.length();
        for (int i = 0; i < length; i++) {
            Object opt = json.opt(i);
            if (opt instanceof Long) {
                arrayList.add(Long.valueOf(json.optLong(i)));
            } else if (opt instanceof Double) {
                arrayList.add(Double.valueOf(json.optDouble(i)));
            } else if (opt instanceof Integer) {
                arrayList.add(Integer.valueOf(json.getInt(i)));
            } else if (opt instanceof String) {
                arrayList.add(json.optString(i));
            } else if (opt instanceof JSONObject) {
                JsonUtils jsonUtils = INSTANCE;
                JSONObject optJSONObject = json.optJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "json.optJSONObject(index)");
                arrayList.add(jsonUtils.jsonToMap(optJSONObject));
            } else if (opt instanceof JSONArray) {
                JsonUtils jsonUtils2 = INSTANCE;
                JSONArray optJSONArray = json.optJSONArray(i);
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "json.optJSONArray(index)");
                arrayList.add(jsonUtils2.jsonToList(optJSONArray));
            } else if (opt instanceof Boolean) {
                arrayList.add(Boolean.valueOf(json.optBoolean(i)));
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }
}
