package com.bytedance.trae.im.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: JsonUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u001a\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¨\u0006\u0011"}, d2 = {"calculateLeftTurnsSteps", "", "currTurn", "maxLeftTurns", "", "mergeJsonValues", "Lcom/google/gson/JsonElement;", "oldValue", "newValue", "mergeJsonObjects", "Lcom/google/gson/JsonObject;", "oldObj", "newObj", "mergeJsonStrings", "", "oldJsonStr", "newJsonStr", "im_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class JsonUtilsKt {
    public static final int calculateLeftTurnsSteps(int i, List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "maxLeftTurns");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (i < intValue) {
                return intValue - i;
            }
            i -= intValue;
        }
        Integer num = (Integer) CollectionsKt.lastOrNull(list);
        if (num != null) {
            return num.intValue() - (i % num.intValue());
        }
        return 1;
    }

    public static final JsonElement mergeJsonValues(JsonElement jsonElement, JsonElement jsonElement2) {
        JsonArray jsonArray;
        JsonArray jsonArray2;
        if (jsonElement2 == null || (jsonElement2 instanceof JsonNull)) {
            return jsonElement;
        }
        if (jsonElement == null || (jsonElement instanceof JsonNull)) {
            return jsonElement2.deepCopy();
        }
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
            if (jsonPrimitive.isString() && (jsonElement2 instanceof JsonPrimitive)) {
                JsonPrimitive jsonPrimitive2 = (JsonPrimitive) jsonElement2;
                if (jsonPrimitive2.isString()) {
                    return new JsonPrimitive(jsonPrimitive.getAsString() + jsonPrimitive2.getAsString());
                }
            }
        }
        if ((jsonElement instanceof JsonArray) && (jsonElement2 instanceof JsonArray)) {
            while (true) {
                jsonArray = (JsonArray) jsonElement;
                jsonArray2 = (JsonArray) jsonElement2;
                if (jsonArray.size() >= jsonArray2.size()) {
                    break;
                }
                jsonArray.add(JsonNull.INSTANCE);
            }
            int size = jsonArray2.size();
            for (int i = 0; i < size; i++) {
                JsonElement mergeJsonValues = mergeJsonValues(jsonArray.get(i), jsonArray2.get(i));
                if (mergeJsonValues == null) {
                    mergeJsonValues = (JsonElement) JsonNull.INSTANCE;
                }
                jsonArray.set(i, mergeJsonValues);
            }
            return jsonElement;
        }
        if ((jsonElement instanceof JsonObject) && (jsonElement2 instanceof JsonObject)) {
            for (Map.Entry entry : ((JsonObject) jsonElement2).entrySet()) {
                Intrinsics.checkNotNull(entry);
                String str = (String) entry.getKey();
                JsonElement jsonElement3 = (JsonElement) entry.getValue();
                JsonObject jsonObject = (JsonObject) jsonElement;
                if (jsonObject.has(str)) {
                    JsonElement mergeJsonValues2 = mergeJsonValues(jsonObject.get(str), jsonElement3);
                    if (mergeJsonValues2 == null) {
                        mergeJsonValues2 = (JsonElement) JsonNull.INSTANCE;
                    }
                    jsonObject.add(str, mergeJsonValues2);
                } else {
                    jsonObject.add(str, jsonElement3.deepCopy());
                }
            }
            return jsonElement;
        }
        return jsonElement2.deepCopy();
    }

    public static final JsonObject mergeJsonObjects(JsonObject jsonObject, JsonObject jsonObject2) {
        Intrinsics.checkNotNullParameter(jsonObject, "oldObj");
        Intrinsics.checkNotNullParameter(jsonObject2, "newObj");
        JsonObject mergeJsonValues = mergeJsonValues((JsonElement) jsonObject, (JsonElement) jsonObject2);
        JsonObject jsonObject3 = mergeJsonValues instanceof JsonObject ? mergeJsonValues : null;
        return jsonObject3 == null ? jsonObject : jsonObject3;
    }

    public static final String mergeJsonStrings(String str, String str2) {
        JsonElement jsonObject;
        JsonElement jsonObject2;
        String jsonElement;
        Intrinsics.checkNotNullParameter(str, "oldJsonStr");
        Intrinsics.checkNotNullParameter(str2, "newJsonStr");
        if (StringsKt.trim(str).toString().length() == 0) {
            jsonObject = (JsonElement) new JsonObject();
        } else {
            try {
                jsonObject = JsonParser.parseString(str);
            } catch (Exception unused) {
                jsonObject = new JsonObject();
            }
            Intrinsics.checkNotNull(jsonObject);
        }
        if (StringsKt.trim(str2).toString().length() == 0) {
            jsonObject2 = (JsonElement) new JsonObject();
        } else {
            try {
                jsonObject2 = JsonParser.parseString(str2);
            } catch (Exception unused2) {
                jsonObject2 = new JsonObject();
            }
            Intrinsics.checkNotNull(jsonObject2);
        }
        JsonElement mergeJsonValues = mergeJsonValues(jsonObject, jsonObject2);
        return (mergeJsonValues == null || (jsonElement = mergeJsonValues.toString()) == null) ? str : jsonElement;
    }
}
