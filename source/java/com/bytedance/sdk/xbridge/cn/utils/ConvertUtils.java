package com.bytedance.sdk.xbridge.cn.utils;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ConvertUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u0005\u001a\u00020\nJ \u0010\u000b\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u00020\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J$\u0010\u0013\u001a\u00020\u0014*\u00020\n2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/ConvertUtils;", "", "()V", "jsonToList", "", "json", "Lorg/json/JSONArray;", "jsonToMap", "", "", "Lorg/json/JSONObject;", "listToJSON", "list", "bigIntStrategy", "", "mapToJSON", "map", "toStringOrJson", "data", "putLongWithStrategy", "", "value", "", StrategyConstants.STRATEGY, "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class ConvertUtils {
    public static final ConvertUtils INSTANCE = new ConvertUtils();

    private ConvertUtils() {
    }

    public final String toStringOrJson(Object data) {
        if (data == null) {
            return "";
        }
        if (data instanceof Map) {
            String jSONObject = new JSONObject((Map) data).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(data).toString()");
            return jSONObject;
        }
        if (!(data instanceof List)) {
            return data.toString();
        }
        String jSONArray = new JSONArray((Collection) data).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(data).toString()");
        return jSONArray;
    }

    public static /* synthetic */ JSONObject mapToJSON$default(ConvertUtils convertUtils, Map map, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return convertUtils.mapToJSON(map, i);
    }

    public final JSONObject mapToJSON(Map<String, ? extends Object> map, int bigIntStrategy) {
        Intrinsics.checkNotNullParameter(map, "map");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Long) {
                INSTANCE.putLongWithStrategy(jSONObject, key, ((Number) value).longValue(), bigIntStrategy);
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
            } else if (value instanceof JSONObject) {
                jSONObject.put(key, value);
            } else if (value instanceof JSONArray) {
                jSONObject.put(key, value);
            } else if (value instanceof Map) {
                try {
                    jSONObject.put(key, INSTANCE.mapToJSON((Map) value, bigIntStrategy));
                } catch (Exception unused) {
                }
            } else if (value instanceof List) {
                jSONObject.put(key, INSTANCE.listToJSON((List) value, bigIntStrategy));
            } else if (value == null) {
                jSONObject.put(key, JSONObject.NULL);
            }
        }
        return jSONObject;
    }

    public static /* synthetic */ JSONArray listToJSON$default(ConvertUtils convertUtils, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return convertUtils.listToJSON(list, i);
    }

    public final JSONArray listToJSON(List<? extends Object> list, int bigIntStrategy) {
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof Float) {
                jSONArray.put(((Number) obj).floatValue());
            } else if (obj instanceof Long) {
                INSTANCE.putLongWithStrategy(jSONArray, ((Number) obj).longValue(), bigIntStrategy);
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
                    ConvertUtils convertUtils = INSTANCE;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    jSONArray.put(convertUtils.mapToJSON((Map) obj, bigIntStrategy));
                } catch (Exception unused) {
                }
            } else if (obj instanceof List) {
                ConvertUtils convertUtils2 = INSTANCE;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                jSONArray.put(convertUtils2.listToJSON((List) obj, bigIntStrategy));
            } else if (obj == null) {
                jSONArray.put(JSONObject.NULL);
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
                ConvertUtils convertUtils = INSTANCE;
                JSONObject optJSONObject = json.optJSONObject(key);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "json.optJSONObject(key)");
                linkedHashMap.put(key, convertUtils.jsonToMap(optJSONObject));
            } else if (opt instanceof JSONArray) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                ConvertUtils convertUtils2 = INSTANCE;
                JSONArray optJSONArray = json.optJSONArray(key);
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "json.optJSONArray(key)");
                linkedHashMap.put(key, convertUtils2.jsonToList(optJSONArray));
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
                ConvertUtils convertUtils = INSTANCE;
                JSONObject optJSONObject = json.optJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "json.optJSONObject(index)");
                arrayList.add(convertUtils.jsonToMap(optJSONObject));
            } else if (opt instanceof JSONArray) {
                ConvertUtils convertUtils2 = INSTANCE;
                JSONArray optJSONArray = json.optJSONArray(i);
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "json.optJSONArray(index)");
                arrayList.add(convertUtils2.jsonToList(optJSONArray));
            } else if (opt instanceof Boolean) {
                arrayList.add(Boolean.valueOf(json.optBoolean(i)));
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    private final void putLongWithStrategy(JSONArray jSONArray, long j, int i) {
        if (i == 0) {
            jSONArray.put(j);
        } else if (i == 1) {
            jSONArray.put(String.valueOf(j));
        } else {
            if (i != 2) {
                return;
            }
            jSONArray.put(j);
        }
    }

    private final void putLongWithStrategy(JSONObject jSONObject, String str, long j, int i) {
        if (i == 0) {
            jSONObject.put(str, j);
        } else if (i == 1) {
            jSONObject.put(str, String.valueOf(j));
        } else {
            if (i != 2) {
                return;
            }
            jSONObject.put(str, j);
        }
    }
}
