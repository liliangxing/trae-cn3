package com.bytedance.ies.bullet.lynx.util;

import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.lynx.jsbridge.Arguments;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonConvertHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0082\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001b\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001bH\u0002¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/util/JsonConvertHelper;", "", "()V", "getNumber", "", "intParser", "Lkotlin/Function0;", "", "doubleParser", "", "jsonToReact", "Lcom/lynx/react/bridge/WritableArray;", "jsonArray", "Lorg/json/JSONArray;", "Lcom/lynx/react/bridge/WritableMap;", "jsonObject", "Lorg/json/JSONObject;", "reactToArray", "", "readableArray", "Lcom/lynx/react/bridge/ReadableArray;", "(Lcom/lynx/react/bridge/ReadableArray;)[Ljava/lang/Object;", "reactToJSON", "readableMap", "Lcom/lynx/react/bridge/ReadableMap;", "reactToMap", "", "", "i", "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class JsonConvertHelper {
    public static final JsonConvertHelper INSTANCE = new JsonConvertHelper();

    /* compiled from: JsonConvertHelper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Int.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Long.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ReadableType.Null.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private JsonConvertHelper() {
    }

    private final Number getNumber(Function0<Integer> intParser, Function0<Double> doubleParser) {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            JsonConvertHelper jsonConvertHelper = this;
            obj = Result.constructor-impl(Integer.valueOf(((Number) intParser.invoke()).intValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        int intValue = num != null ? num.intValue() : 0;
        try {
            Result.Companion companion3 = Result.Companion;
            JsonConvertHelper jsonConvertHelper2 = this;
            obj2 = Result.constructor-impl(Double.valueOf(((Number) doubleParser.invoke()).doubleValue()));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        Double d = (Double) (Result.isFailure-impl(obj2) ? null : obj2);
        double doubleValue = d != null ? d.doubleValue() : 0.0d;
        if (Double.compare(intValue, doubleValue) == 0) {
            return Integer.valueOf(intValue);
        }
        long j = (long) doubleValue;
        if (Double.compare(doubleValue, j) == 0) {
            return Long.valueOf(j);
        }
        return Double.valueOf(doubleValue);
    }

    public final JSONObject reactToJSON(ReadableMap readableMap) throws JSONException {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableType type = readableMap.getType(nextKey);
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 2:
                    Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                    Number number = getNumber(readableMap, nextKey);
                    if (!(number instanceof Double)) {
                        if (!(number instanceof Long)) {
                            if (!(number instanceof Integer)) {
                                Unit unit = Unit.INSTANCE;
                                break;
                            } else {
                                jSONObject.put(nextKey, number.intValue());
                                break;
                            }
                        } else {
                            jSONObject.put(nextKey, number.longValue());
                            break;
                        }
                    } else {
                        jSONObject.put(nextKey, number.doubleValue());
                        break;
                    }
                case 3:
                    jSONObject.put(nextKey, readableMap.getInt(nextKey));
                    break;
                case 4:
                    jSONObject.put(nextKey, readableMap.getLong(nextKey));
                    break;
                case 5:
                    jSONObject.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 6:
                    ReadableMap map = readableMap.getMap(nextKey);
                    Intrinsics.checkNotNullExpressionValue(map, "readableMap.getMap(key)");
                    jSONObject.put(nextKey, reactToJSON(map));
                    break;
                case 7:
                    ReadableArray array = readableMap.getArray(nextKey);
                    Intrinsics.checkNotNullExpressionValue(array, "readableMap.getArray(key)");
                    jSONObject.put(nextKey, reactToJSON(array));
                    break;
                case 8:
                    jSONObject.put(nextKey, JSONObject.NULL);
                    break;
            }
        }
        return jSONObject;
    }

    public final JSONArray reactToJSON(ReadableArray readableArray) throws JSONException {
        Intrinsics.checkNotNullParameter(readableArray, "readableArray");
        JSONArray jSONArray = new JSONArray();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableType type = readableArray.getType(i);
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    jSONArray.put(readableArray.getBoolean(i));
                    break;
                case 2:
                    Number number = getNumber(readableArray, i);
                    if (number instanceof Double) {
                        jSONArray.put(number.doubleValue());
                        break;
                    } else if (number instanceof Long) {
                        jSONArray.put(number.longValue());
                        break;
                    } else if (number instanceof Integer) {
                        jSONArray.put(number.intValue());
                        break;
                    } else {
                        Unit unit = Unit.INSTANCE;
                        break;
                    }
                case 4:
                    jSONArray.put(readableArray.getLong(i));
                    break;
                case 5:
                    jSONArray.put(readableArray.getString(i));
                    break;
                case 6:
                    ReadableMap map = readableArray.getMap(i);
                    Intrinsics.checkNotNullExpressionValue(map, "readableArray.getMap(i)");
                    jSONArray.put(reactToJSON(map));
                    break;
                case 7:
                    ReadableArray array = readableArray.getArray(i);
                    Intrinsics.checkNotNullExpressionValue(array, "readableArray.getArray(i)");
                    jSONArray.put(reactToJSON(array));
                    break;
                case 8:
                    jSONArray.put(JSONObject.NULL);
                    break;
            }
        }
        return jSONArray;
    }

    public final WritableMap jsonToReact(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        WritableMap createMap = Arguments.createMap();
        Iterator<String> keys = jsonObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
            String str = next;
            Object obj = jsonObject.get(str);
            if (obj instanceof Float ? true : obj instanceof Double) {
                createMap.putDouble(str, jsonObject.getDouble(str));
            } else if (obj instanceof Long) {
                if (IConditionCallKt.fixJsonLong2Double()) {
                    createMap.putLong(str, jsonObject.getLong(str));
                } else {
                    createMap.putDouble(str, jsonObject.getLong(str));
                }
            } else if (obj instanceof Number) {
                createMap.putInt(str, jsonObject.getInt(str));
            } else if (obj instanceof String) {
                createMap.putString(str, jsonObject.getString(str));
            } else if (obj instanceof Boolean) {
                createMap.putBoolean(str, jsonObject.getBoolean(str));
            } else if (obj instanceof JSONObject) {
                JSONObject jSONObject = jsonObject.getJSONObject(str);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.getJSONObject(key)");
                createMap.putMap(str, jsonToReact(jSONObject));
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = jsonObject.getJSONArray(str);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "jsonObject.getJSONArray(key)");
                createMap.putArray(str, jsonToReact(jSONArray));
            } else if (Intrinsics.areEqual(obj, JSONObject.NULL)) {
                createMap.putNull(str);
            }
        }
        Intrinsics.checkNotNullExpressionValue(createMap, "writableMap");
        return createMap;
    }

    public final WritableArray jsonToReact(JSONArray jsonArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        WritableArray createArray = Arguments.createArray();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jsonArray.get(i);
            if (obj != null) {
                if (obj instanceof Float ? true : obj instanceof Double) {
                    createArray.pushDouble(jsonArray.getDouble(i));
                } else if (obj instanceof Long) {
                    if (IConditionCallKt.fixJsonLong2Double()) {
                        createArray.pushLong(jsonArray.getLong(i));
                    } else {
                        createArray.pushDouble(jsonArray.getLong(i));
                    }
                } else if (obj instanceof Number) {
                    createArray.pushInt(jsonArray.getInt(i));
                } else if (obj instanceof String) {
                    createArray.pushString(jsonArray.getString(i));
                } else if (obj instanceof Boolean) {
                    createArray.pushBoolean(jsonArray.getBoolean(i));
                } else if (obj instanceof JSONObject) {
                    JSONObject jSONObject = jsonArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonArray.getJSONObject(i)");
                    createArray.pushMap(jsonToReact(jSONObject));
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = jsonArray.getJSONArray(i);
                    Intrinsics.checkNotNullExpressionValue(jSONArray, "jsonArray.getJSONArray(i)");
                    createArray.pushArray(jsonToReact(jSONArray));
                } else if (Intrinsics.areEqual(obj, JSONObject.NULL)) {
                    createArray.pushNull();
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(createArray, "writableArray");
        return createArray;
    }

    public final Map<String, Object> reactToMap(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        HashMap hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableType type = readableMap.getType(nextKey);
            int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                hashMap.put(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
            } else if (i == 2) {
                Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                hashMap.put(nextKey, getNumber(readableMap, nextKey));
            } else if (i == 5) {
                Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                hashMap.put(nextKey, readableMap.getString(nextKey));
            } else if (i == 6) {
                Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                ReadableMap map = readableMap.getMap(nextKey);
                Intrinsics.checkNotNullExpressionValue(map, "readableMap.getMap(key)");
                hashMap.put(nextKey, reactToMap(map));
            } else if (i == 7) {
                Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                ReadableArray array = readableMap.getArray(nextKey);
                Intrinsics.checkNotNullExpressionValue(array, "readableMap.getArray(key)");
                hashMap.put(nextKey, reactToArray(array));
            } else if (i == 8) {
                Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                hashMap.put(nextKey, null);
            }
        }
        return hashMap;
    }

    public final Object[] reactToArray(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "readableArray");
        Object[] objArr = new Object[readableArray.size()];
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableType type = readableArray.getType(i);
            int i2 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i2 == 1) {
                objArr[i] = Boolean.valueOf(readableArray.getBoolean(i));
            } else if (i2 == 2) {
                objArr[i] = getNumber(readableArray, i);
            } else if (i2 == 5) {
                objArr[i] = readableArray.getString(i);
            } else if (i2 == 6) {
                ReadableMap map = readableArray.getMap(i);
                Intrinsics.checkNotNullExpressionValue(map, "readableArray.getMap(i)");
                objArr[i] = reactToMap(map);
            } else if (i2 == 7) {
                ReadableArray array = readableArray.getArray(i);
                Intrinsics.checkNotNullExpressionValue(array, "readableArray.getArray(i)");
                objArr[i] = reactToArray(array);
            } else if (i2 == 8) {
                objArr[i] = null;
            }
        }
        return objArr;
    }

    private final Number getNumber(ReadableMap readableMap, String str) {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            JsonConvertHelper jsonConvertHelper = this;
            obj = Result.constructor-impl(Integer.valueOf(readableMap.getInt(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        int intValue = num != null ? num.intValue() : 0;
        try {
            Result.Companion companion3 = Result.Companion;
            JsonConvertHelper jsonConvertHelper2 = this;
            obj2 = Result.constructor-impl(Double.valueOf(readableMap.getDouble(str)));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        Double d = (Double) (Result.isFailure-impl(obj2) ? null : obj2);
        double doubleValue = d != null ? d.doubleValue() : 0.0d;
        if (Double.compare(intValue, doubleValue) == 0) {
            return Integer.valueOf(intValue);
        }
        long j = (long) doubleValue;
        if (Double.compare(doubleValue, j) == 0) {
            return Long.valueOf(j);
        }
        return Double.valueOf(doubleValue);
    }

    private final Number getNumber(ReadableArray readableArray, int i) {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            JsonConvertHelper jsonConvertHelper = this;
            obj = Result.constructor-impl(Integer.valueOf(readableArray.getInt(i)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        int intValue = num != null ? num.intValue() : 0;
        try {
            Result.Companion companion3 = Result.Companion;
            JsonConvertHelper jsonConvertHelper2 = this;
            obj2 = Result.constructor-impl(Double.valueOf(readableArray.getDouble(i)));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        Double d = (Double) (Result.isFailure-impl(obj2) ? null : obj2);
        double doubleValue = d != null ? d.doubleValue() : 0.0d;
        if (Double.compare(intValue, doubleValue) == 0) {
            return Integer.valueOf(intValue);
        }
        long j = (long) doubleValue;
        if (Double.compare(doubleValue, j) == 0) {
            return Long.valueOf(j);
        }
        return Double.valueOf(doubleValue);
    }
}
