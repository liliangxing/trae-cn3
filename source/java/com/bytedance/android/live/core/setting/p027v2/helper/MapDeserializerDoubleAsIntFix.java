package com.bytedance.android.live.core.setting.p027v2.helper;

import com.bytedance.android.live.core.setting.p027v2.tools.SettingReportMonitor;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
    public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Object read = read(jsonElement);
        if (read != null) {
            return (Map) read;
        }
        return null;
    }

    public Object read(JsonElement jsonElement) {
        if (jsonElement.isJsonArray()) {
            ArrayList arrayList = new ArrayList();
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            if (asJsonArray != null) {
                Iterator it = asJsonArray.iterator();
                while (it.hasNext()) {
                    arrayList.add(read((JsonElement) it.next()));
                }
            }
            return arrayList;
        }
        if (jsonElement.isJsonObject()) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject != null) {
                for (Map.Entry entry : asJsonObject.entrySet()) {
                    linkedTreeMap.put(entry.getKey(), read((JsonElement) entry.getValue()));
                }
            }
            return linkedTreeMap;
        }
        if (!jsonElement.isJsonPrimitive()) {
            return null;
        }
        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
        if (asJsonPrimitive.isBoolean()) {
            return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
        }
        if (asJsonPrimitive.isString()) {
            return asJsonPrimitive.getAsString();
        }
        if (!asJsonPrimitive.isNumber()) {
            return null;
        }
        Number asNumber = asJsonPrimitive.getAsNumber();
        if (Math.ceil(asNumber.doubleValue()) != asNumber.longValue()) {
            return Double.valueOf(asNumber.doubleValue());
        }
        if (asNumber.floatValue() < 0.0f && isFloat(asNumber)) {
            SettingReportMonitor.printLog(SettingReportMonitor.TAG_GSON, "isFloat num= " + asNumber);
            return Double.valueOf(asNumber.doubleValue());
        }
        return Long.valueOf(asNumber.longValue());
    }

    private boolean isFloat(Number number) {
        return (number instanceof LazilyParsedNumber) && new BigDecimal(number.toString()).scale() > 0;
    }
}
