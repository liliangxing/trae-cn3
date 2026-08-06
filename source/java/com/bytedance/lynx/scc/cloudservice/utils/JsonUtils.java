package com.bytedance.lynx.scc.cloudservice.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class JsonUtils {
    private JsonUtils() {
    }

    public static boolean getJsonValueAsBoolean(JsonObject json, String key, boolean defaultValue) {
        if (json != null && json.has(key)) {
            JsonElement jsonElement = json.get(key);
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
                return jsonElement.getAsBoolean();
            }
        }
        return defaultValue;
    }

    public static int getJsonValueAsInt(JsonObject json, String key, int defaultValue) {
        if (json != null && json.has(key)) {
            JsonElement jsonElement = json.get(key);
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                return jsonElement.getAsInt();
            }
        }
        return defaultValue;
    }

    public static String getJsonValueAsString(JsonObject json, String key, String defaultValue) {
        if (json != null && json.has(key)) {
            JsonElement jsonElement = json.get(key);
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                return jsonElement.getAsString();
            }
        }
        return defaultValue;
    }

    public static JsonArray getJsonValueAsArray(JsonObject json, String key) {
        if (json != null && json.has(key)) {
            JsonElement jsonElement = json.get(key);
            if (jsonElement.isJsonArray() && jsonElement.getAsJsonArray().isJsonArray()) {
                return jsonElement.getAsJsonArray();
            }
        }
        return null;
    }
}
