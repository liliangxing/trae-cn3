package com.bytedance.pia.core.utils;

import com.bytedance.pia.core.utils.GsonUtils;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GsonUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004()*+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u001cH\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u001dH\u0002J\u001b\u0010\u001e\u001a\u00020\u001d*\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b J#\u0010!\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b#J\f\u0010$\u001a\u00020\u001c*\u00020%H\u0007J\f\u0010&\u001a\u00020\u001d*\u00020'H\u0007R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e¨\u0006,"}, d2 = {"Lcom/bytedance/pia/core/utils/GsonUtils;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson$annotations", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "parser", "Lcom/google/gson/JsonParser;", "getParser$annotations", "getParser", "()Lcom/google/gson/JsonParser;", "fromJson", "T", "raw", "", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "putValue", "", "value", "out", "Lcom/google/gson/stream/JsonWriter;", "writeInternal", "Lorg/json/JSONArray;", "Lorg/json/JSONObject;", "mergeJSONObject", "merge", "mergeJSONObject$anniex_release", "safelyPut", "key", "safelyPut$anniex_release", "toJSONArray", "Lcom/google/gson/JsonArray;", "toJSONObject", "Lcom/google/gson/JsonObject;", "Exclude", "ExcludeStrategy", "JSONArrayAdapter", "JSONObjectAdapter", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GsonUtils {
    public static final GsonUtils INSTANCE = new GsonUtils();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.bytedance.pia.core.utils.GsonUtils$gson$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m770invoke() {
            return new GsonBuilder().registerTypeAdapter(JSONObject.class, GsonUtils.JSONObjectAdapter.INSTANCE).registerTypeAdapter(JSONArray.class, GsonUtils.JSONArrayAdapter.INSTANCE).setExclusionStrategies(new ExclusionStrategy[]{GsonUtils.ExcludeStrategy.INSTANCE}).serializeNulls().create();
        }
    });
    private static final JsonParser parser = new JsonParser();

    /* compiled from: GsonUtils.kt */
    @Target({ElementType.FIELD})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pia/core/utils/GsonUtils$Exclude;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public @interface Exclude {
    }

    @JvmStatic
    public static /* synthetic */ void getGson$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getParser$annotations() {
    }

    private GsonUtils() {
    }

    public static final Gson getGson() {
        Object value = gson.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gson>(...)");
        return (Gson) value;
    }

    public static final JsonParser getParser() {
        return parser;
    }

    @JvmStatic
    public static final <T> T fromJson(String raw, Class<T> type) {
        Object obj;
        Intrinsics.checkNotNullParameter(type, "type");
        String str = raw;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(getGson().fromJson(raw, type));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            return null;
        }
        return (T) obj;
    }

    @JvmStatic
    public static final JSONObject toJSONObject(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        JSONObject jSONObject = new JSONObject();
        Set<Map.Entry> entrySet = jsonObject.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet()");
        for (Map.Entry entry : entrySet) {
            Intrinsics.checkNotNullExpressionValue(entry, "(key, value)");
            String str = (String) entry.getKey();
            JsonPrimitive jsonPrimitive = (JsonElement) entry.getValue();
            if (jsonPrimitive instanceof JsonObject) {
                Intrinsics.checkNotNullExpressionValue(jsonPrimitive, "value");
                jSONObject.put(str, toJSONObject((JsonObject) jsonPrimitive));
            } else if (jsonPrimitive instanceof JsonArray) {
                Intrinsics.checkNotNullExpressionValue(jsonPrimitive, "value");
                jSONObject.put(str, toJSONArray((JsonArray) jsonPrimitive));
            } else if (jsonPrimitive instanceof JsonNull) {
                jSONObject.put(str, JSONObject.NULL);
            } else if (jsonPrimitive instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive2 = jsonPrimitive;
                if (jsonPrimitive2.isBoolean()) {
                    jSONObject.put(str, jsonPrimitive2.getAsBoolean());
                } else if (jsonPrimitive2.isString()) {
                    jSONObject.put(str, jsonPrimitive2.getAsString());
                } else if (jsonPrimitive2.isNumber()) {
                    if (StringsKt.contains$default(jsonPrimitive2.getAsNumber().toString(), '.', false, 2, (Object) null)) {
                        jSONObject.put(str, jsonPrimitive2.getAsNumber().doubleValue());
                    } else {
                        jSONObject.put(str, jsonPrimitive2.getAsNumber().longValue());
                    }
                }
            }
        }
        return jSONObject;
    }

    @JvmStatic
    public static final JSONArray toJSONArray(JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (JsonPrimitive jsonPrimitive : (Iterable) jsonArray) {
            if (jsonPrimitive instanceof JsonObject) {
                Intrinsics.checkNotNullExpressionValue(jsonPrimitive, "value");
                jSONArray.put(toJSONObject((JsonObject) jsonPrimitive));
            } else if (jsonPrimitive instanceof JsonArray) {
                Intrinsics.checkNotNullExpressionValue(jsonPrimitive, "value");
                jSONArray.put(toJSONArray((JsonArray) jsonPrimitive));
            } else if (jsonPrimitive instanceof JsonNull) {
                jSONArray.put(JSONObject.NULL);
            } else if (jsonPrimitive instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive2 = jsonPrimitive;
                if (jsonPrimitive2.isBoolean()) {
                    jSONArray.put(jsonPrimitive2.getAsBoolean());
                } else if (jsonPrimitive2.isString()) {
                    jSONArray.put(jsonPrimitive2.getAsString());
                } else if (jsonPrimitive2.isNumber()) {
                    if (StringsKt.contains$default(jsonPrimitive2.getAsNumber().toString(), '.', false, 2, (Object) null)) {
                        jSONArray.put(jsonPrimitive2.getAsNumber().doubleValue());
                    } else {
                        jSONArray.put(jsonPrimitive2.getAsNumber().longValue());
                    }
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GsonUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/core/utils/GsonUtils$JSONObjectAdapter;", "Lcom/google/gson/TypeAdapter;", "Lorg/json/JSONObject;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class JSONObjectAdapter extends TypeAdapter<JSONObject> {
        public static final JSONObjectAdapter INSTANCE = new JSONObjectAdapter();

        private JSONObjectAdapter() {
        }

        public void write(JsonWriter out, JSONObject value) {
            Intrinsics.checkNotNullParameter(out, "out");
            Intrinsics.checkNotNullParameter(value, "value");
            GsonUtils.INSTANCE.writeInternal(out, value);
        }

        public JSONObject read(JsonReader reader) {
            JsonObject asJsonObject;
            Intrinsics.checkNotNullParameter(reader, "reader");
            JsonElement parse = GsonUtils.getParser().parse(reader);
            if (!parse.isJsonObject()) {
                parse = null;
            }
            if (parse == null || (asJsonObject = parse.getAsJsonObject()) == null) {
                return null;
            }
            return GsonUtils.toJSONObject(asJsonObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GsonUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/core/utils/GsonUtils$JSONArrayAdapter;", "Lcom/google/gson/TypeAdapter;", "Lorg/json/JSONArray;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class JSONArrayAdapter extends TypeAdapter<JSONArray> {
        public static final JSONArrayAdapter INSTANCE = new JSONArrayAdapter();

        private JSONArrayAdapter() {
        }

        public void write(JsonWriter out, JSONArray value) {
            Intrinsics.checkNotNullParameter(out, "out");
            Intrinsics.checkNotNullParameter(value, "value");
            GsonUtils.INSTANCE.writeInternal(out, value);
        }

        public JSONArray read(JsonReader reader) {
            JsonArray asJsonArray;
            Intrinsics.checkNotNullParameter(reader, "reader");
            JsonElement parse = GsonUtils.getParser().parse(reader);
            if (!parse.isJsonArray()) {
                parse = null;
            }
            if (parse == null || (asJsonArray = parse.getAsJsonArray()) == null) {
                return null;
            }
            return GsonUtils.toJSONArray(asJsonArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GsonUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/pia/core/utils/GsonUtils$ExcludeStrategy;", "Lcom/google/gson/ExclusionStrategy;", "()V", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "field", "Lcom/google/gson/FieldAttributes;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class ExcludeStrategy implements ExclusionStrategy {
        public static final ExcludeStrategy INSTANCE = new ExcludeStrategy();

        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }

        private ExcludeStrategy() {
        }

        public boolean shouldSkipField(FieldAttributes field) {
            Intrinsics.checkNotNullParameter(field, "field");
            return field.getAnnotation(Exclude.class) != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeInternal(JsonWriter out, JSONObject value) {
        out.beginObject();
        Iterator<String> keys = value.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "value.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            out.name(next);
            INSTANCE.putValue(value.opt(next), out);
        }
        out.endObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeInternal(JsonWriter out, JSONArray value) {
        out.beginArray();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            putValue(value.opt(i), out);
        }
        out.endArray();
    }

    private final void putValue(Object value, JsonWriter out) {
        if (value instanceof Boolean) {
            out.value(((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Number) {
            out.value((Number) value);
            return;
        }
        if (value instanceof String) {
            out.value((String) value);
            return;
        }
        if (value instanceof JSONObject) {
            writeInternal(out, (JSONObject) value);
        } else if (value instanceof JSONArray) {
            writeInternal(out, (JSONArray) value);
        } else {
            out.nullValue();
        }
    }

    public final JSONObject mergeJSONObject$anniex_release(JSONObject jSONObject, JSONObject jSONObject2) {
        Object obj;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Result.Companion companion = Result.Companion;
            Iterator<String> keys = jSONObject2.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "merge.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                INSTANCE.safelyPut$anniex_release(jSONObject, next, jSONObject2.get(next));
            }
            obj = Result.constructor-impl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = new JSONObject();
        }
        return (JSONObject) obj;
    }

    public final JSONObject safelyPut$anniex_release(JSONObject jSONObject, String str, Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            Result.Companion companion = Result.Companion;
            if (obj != null) {
                jSONObject = jSONObject.put(str, obj);
            }
            obj2 = Result.constructor-impl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj2) != null) {
            obj2 = new JSONObject();
        }
        return (JSONObject) obj2;
    }
}
