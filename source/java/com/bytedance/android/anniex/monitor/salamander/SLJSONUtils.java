package com.bytedance.android.anniex.monitor.salamander;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SLJSONUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLJSONUtils;", "", "()V", "jsonToList", "", "jsonArray", "Lorg/json/JSONArray;", "jsonToMap", "", "", "jsonObject", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class SLJSONUtils {
    public static final SLJSONUtils INSTANCE = new SLJSONUtils();

    private SLJSONUtils() {
    }

    public final Map<String, Object> jsonToMap(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (value instanceof JSONObject) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                value = jsonToMap((JSONObject) value);
            } else if (value instanceof JSONArray) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                value = jsonToList((JSONArray) value);
            }
            Intrinsics.checkNotNullExpressionValue(value, "when (value) {\n         …se -> value\n            }");
            linkedHashMap.put(key, value);
        }
        return linkedHashMap;
    }

    public final List<Object> jsonToList(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            Object value = jsonArray.get(i);
            if (value instanceof JSONObject) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                value = jsonToMap((JSONObject) value);
            } else if (value instanceof JSONArray) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                value = jsonToList((JSONArray) value);
            }
            Intrinsics.checkNotNullExpressionValue(value, "when (value) {\n         …se -> value\n            }");
            arrayList.add(value);
        }
        return arrayList;
    }
}
