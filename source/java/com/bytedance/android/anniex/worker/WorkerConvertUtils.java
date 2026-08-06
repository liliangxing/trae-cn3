package com.bytedance.android.anniex.worker;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import com.bytedance.vmsdk.jsbridge.utils.Dynamic;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WorkerConvertUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H\u0003J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0003J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0007J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0007J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\rH\u0007J\u0012\u0010\u001b\u001a\u00020\u00042\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0016\u0010\u001d\u001a\u00020\u000b2\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014J\u001e\u0010\u001e\u001a\u00020\u000b2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H\u0007J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u0012\u0010#\u001a\u0004\u0018\u00010\u00012\b\u0010$\u001a\u0004\u0018\u00010\u0001J\u001c\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00142\u0006\u0010&\u001a\u00020\rJ\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00142\u0006\u0010$\u001a\u00020(J\f\u0010#\u001a\u0004\u0018\u00010\u0001*\u00020)¨\u0006*"}, d2 = {"Lcom/bytedance/android/anniex/worker/WorkerConvertUtils;", "", "()V", "convertArrayToJavaOnlyArray", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;", "sourceArray", "", "convertJSONArray2JavaOnlyArray", "arrays", "Lorg/json/JSONArray;", "convertJSONObject2JavaOnlyMap", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "obj", "Lorg/json/JSONObject;", "convertJavaOnlyArrayToJson", "array", "convertJavaOnlyArrayToList", "convertJavaOnlyMapToJson", "map", "convertJavaOnlyMapToMap", "", "", "convertJsonToJavaOnlyArray", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableArray;", "jsonArray", "convertJsonToJavaOnlyMap", "jsonObject", "convertList2JavaOnlyArray", Constants.KEY_LIST, "convertMap2JavaOnlyMap", "convertMapToJavaOnlyMap", "source", "getNumber", "", "rawNumber", "getValue", StrategyConstants.VALUE, "jsonToMap", "json", "readableToMap", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "Lcom/bytedance/vmsdk/jsbridge/utils/Dynamic;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WorkerConvertUtils {
    public static final WorkerConvertUtils INSTANCE = new WorkerConvertUtils();

    /* compiled from: WorkerConvertUtils.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Null.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private WorkerConvertUtils() {
    }

    public final Object getValue(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "<this>");
        ReadableType type = dynamic.getType();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return dynamic.asString();
            case 2:
                return getNumber(Double.valueOf(dynamic.asDouble()));
            case 3:
                return Boolean.valueOf(dynamic.asBoolean());
            case 4:
                return dynamic.asMap();
            case 5:
                return dynamic.asArray();
            case 6:
            default:
                return null;
        }
    }

    public final Map<String, Object> readableToMap(ReadableMap value) {
        Intrinsics.checkNotNullParameter(value, StrategyConstants.VALUE);
        ReadableMapKeySetIterator keySetIterator = value.keySetIterator();
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            Intrinsics.checkNotNullExpressionValue(nextKey, "key");
            Dynamic dynamic = value.getDynamic(nextKey);
            Intrinsics.checkNotNullExpressionValue(dynamic, "value.getDynamic(key)");
            hashMap.put(nextKey, getValue(getValue(dynamic)));
        }
        return hashMap;
    }

    public final Object getValue(Object value) {
        if (value instanceof ReadableArray) {
            ReadableArray readableArray = (ReadableArray) value;
            int size = readableArray.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                Dynamic dynamic = readableArray.getDynamic(i);
                Intrinsics.checkNotNullExpressionValue(dynamic, "value.getDynamic(i)");
                arrayList.add(getValue(getValue(dynamic)));
            }
            return arrayList;
        }
        if (value instanceof ReadableMap) {
            return readableToMap((ReadableMap) value);
        }
        return value instanceof Number ? getNumber((Number) value) : value;
    }

    @JvmStatic
    public static final JavaOnlyArray convertArrayToJavaOnlyArray(List<? extends Object> sourceArray) {
        Intrinsics.checkNotNullParameter(sourceArray, "sourceArray");
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int size = sourceArray.size();
        for (int i = 0; i < size; i++) {
            Object obj = sourceArray.get(i);
            if (obj instanceof Map) {
                try {
                    javaOnlyArray.pushMap(convertMapToJavaOnlyMap((Map) obj));
                } catch (Exception unused) {
                }
            } else if (obj instanceof List) {
                javaOnlyArray.pushArray(convertArrayToJavaOnlyArray((List) obj));
            } else if (obj instanceof Boolean) {
                javaOnlyArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                javaOnlyArray.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                javaOnlyArray.pushDouble(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                javaOnlyArray.pushDouble(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                javaOnlyArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                javaOnlyArray.pushString((String) obj);
            } else {
                javaOnlyArray.pushString(obj.toString());
            }
        }
        return javaOnlyArray;
    }

    @JvmStatic
    public static final JavaOnlyMap convertMapToJavaOnlyMap(Map<String, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(source, "source");
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        for (Map.Entry<String, ? extends Object> entry : source.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                try {
                    javaOnlyMap.putMap(key, convertMapToJavaOnlyMap((Map) value));
                } catch (Exception unused) {
                }
            } else if (value instanceof List) {
                javaOnlyMap.putArray(key, convertArrayToJavaOnlyArray((List) value));
            } else if (value instanceof Boolean) {
                javaOnlyMap.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Integer) {
                javaOnlyMap.putInt(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                javaOnlyMap.putDouble(key, ((Number) value).longValue());
            } else if (value instanceof Float) {
                javaOnlyMap.putDouble(key, ((Number) value).floatValue());
            } else if (value instanceof Double) {
                javaOnlyMap.putDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                javaOnlyMap.putString(key, (String) value);
            } else if (value instanceof JSONObject) {
                javaOnlyMap.putMap(key, convertJsonToJavaOnlyMap((JSONObject) value));
            } else if (value instanceof JSONArray) {
                javaOnlyMap.putArray(key, convertJsonToJavaOnlyArray((JSONArray) value));
            } else if (value == null || Intrinsics.areEqual(value, JSONObject.NULL)) {
                javaOnlyMap.putNull(key);
            } else {
                javaOnlyMap.putString(key, value.toString());
            }
        }
        return javaOnlyMap;
    }

    @JvmStatic
    public static final WritableArray convertJsonToJavaOnlyArray(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        WritableArray javaOnlyArray = new JavaOnlyArray();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jsonArray.get(i);
            if (obj instanceof JSONObject) {
                javaOnlyArray.pushMap(convertJsonToJavaOnlyMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                javaOnlyArray.pushArray(convertJsonToJavaOnlyArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                javaOnlyArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                javaOnlyArray.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                javaOnlyArray.pushDouble(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                javaOnlyArray.pushDouble(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                javaOnlyArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                javaOnlyArray.pushString((String) obj);
            } else {
                javaOnlyArray.pushString(obj.toString());
            }
        }
        return javaOnlyArray;
    }

    @JvmStatic
    public static final JavaOnlyMap convertJsonToJavaOnlyMap(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            String str = next;
            Object obj = jsonObject.get(str);
            if (obj instanceof JSONObject) {
                javaOnlyMap.putMap(str, convertJsonToJavaOnlyMap((JSONObject) obj));
            } else if (Intrinsics.areEqual(obj, JSONObject.NULL)) {
                javaOnlyMap.putMap(str, (WritableMap) null);
            } else if (obj instanceof JSONArray) {
                javaOnlyMap.putArray(str, convertJsonToJavaOnlyArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                javaOnlyMap.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                javaOnlyMap.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                javaOnlyMap.putDouble(str, ((Number) obj).longValue());
            } else if (obj instanceof Float) {
                javaOnlyMap.putDouble(str, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                javaOnlyMap.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                javaOnlyMap.putString(str, (String) obj);
            } else {
                javaOnlyMap.putString(str, obj.toString());
            }
        }
        return javaOnlyMap;
    }

    @JvmStatic
    public static final JSONObject convertJavaOnlyMapToJson(JavaOnlyMap map) {
        JSONObject jSONObject = new JSONObject();
        Map map2 = (Map) map;
        if (map2 == null || map2.isEmpty()) {
            return jSONObject;
        }
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            Object obj = map.get(nextKey);
            try {
                ReadableType type = map.getType(nextKey);
                int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i == 2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
                    jSONObject.put(nextKey, INSTANCE.getNumber((Number) obj));
                } else if (i == 4) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");
                    jSONObject.putOpt(nextKey, convertJavaOnlyMapToJson((JavaOnlyMap) obj));
                } else if (i == 5) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");
                    jSONObject.putOpt(nextKey, convertJavaOnlyArrayToJson((JavaOnlyArray) obj));
                } else {
                    jSONObject.putOpt(nextKey, obj);
                }
            } catch (Throwable th) {
                XBridge.log("revertJavaOnlyMap2JSONObject " + th);
            }
        }
        return jSONObject;
    }

    @JvmStatic
    public static final Map<String, Object> convertJavaOnlyMapToMap(JavaOnlyMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (((Map) map).isEmpty()) {
            return linkedHashMap;
        }
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            Object obj = map.get(nextKey);
            try {
                ReadableType type = map.getType(nextKey);
                int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i == 2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
                    Intrinsics.checkNotNullExpressionValue(nextKey, "nextKey");
                    linkedHashMap.put(nextKey, INSTANCE.getNumber((Number) obj));
                } else if (i == 4) {
                    Intrinsics.checkNotNullExpressionValue(nextKey, "nextKey");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");
                    linkedHashMap.put(nextKey, convertJavaOnlyMapToMap((JavaOnlyMap) obj));
                } else if (i == 5) {
                    Intrinsics.checkNotNullExpressionValue(nextKey, "nextKey");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");
                    linkedHashMap.put(nextKey, convertJavaOnlyArrayToList((JavaOnlyArray) obj));
                } else {
                    Intrinsics.checkNotNullExpressionValue(nextKey, "nextKey");
                    linkedHashMap.put(nextKey, obj);
                }
            } catch (Throwable th) {
                XBridge.log("convertJavaOnlyMapToMap " + th);
            }
        }
        return linkedHashMap;
    }

    @JvmStatic
    private static final List<Object> convertJavaOnlyArrayToList(JavaOnlyArray array) {
        ArrayList arrayList = new ArrayList();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            Object obj = array.get(i);
            try {
                ReadableType type = array.getType(i);
                int i2 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i2 == 2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
                    arrayList.add(INSTANCE.getNumber((Number) obj));
                } else if (i2 == 4) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");
                    arrayList.add(convertJavaOnlyMapToMap((JavaOnlyMap) obj));
                } else if (i2 == 5) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");
                    arrayList.add(convertJavaOnlyArrayToList((JavaOnlyArray) obj));
                } else {
                    Intrinsics.checkNotNullExpressionValue(obj, StrategyConstants.VALUE);
                    arrayList.add(obj);
                }
            } catch (Throwable th) {
                XBridge.log("convertJavaOnlyArrayToList " + th);
            }
        }
        return arrayList;
    }

    @JvmStatic
    private static final JSONArray convertJavaOnlyArrayToJson(JavaOnlyArray array) {
        JSONArray jSONArray = new JSONArray();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            Object obj = array.get(i);
            try {
                ReadableType type = array.getType(i);
                int i2 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i2 == 2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
                    jSONArray.put(INSTANCE.getNumber((Number) obj));
                } else if (i2 == 4) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");
                    jSONArray.put(convertJavaOnlyMapToJson((JavaOnlyMap) obj));
                } else if (i2 == 5) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");
                    jSONArray.put(convertJavaOnlyArrayToJson((JavaOnlyArray) obj));
                } else {
                    jSONArray.put(obj);
                }
            } catch (Throwable th) {
                XBridge.log("revertJavaOnlyArray2JSONArray " + th);
            }
        }
        return jSONArray;
    }

    public final JavaOnlyMap convertJSONObject2JavaOnlyMap(JSONObject obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Iterator<String> keys = obj.keys();
        Map javaOnlyMap = new JavaOnlyMap();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = obj.opt(next);
            if (opt instanceof JSONObject) {
                javaOnlyMap.put(next, convertJSONObject2JavaOnlyMap((JSONObject) opt));
            } else if (opt instanceof JSONArray) {
                javaOnlyMap.put(next, convertJSONArray2JavaOnlyArray((JSONArray) opt));
            } else {
                javaOnlyMap.put(next, opt);
            }
        }
        return javaOnlyMap;
    }

    public final JavaOnlyArray convertList2JavaOnlyArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, Constants.KEY_LIST);
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        for (Object obj : list) {
            if (obj instanceof Map) {
                javaOnlyArray.add(INSTANCE.convertMap2JavaOnlyMap((Map) obj));
            } else if (obj instanceof List) {
                javaOnlyArray.addAll(INSTANCE.convertList2JavaOnlyArray((List) obj));
            } else {
                javaOnlyArray.add(obj);
            }
        }
        return javaOnlyArray;
    }

    public final JavaOnlyMap convertMap2JavaOnlyMap(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        Map javaOnlyMap = new JavaOnlyMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
            String str = (String) key;
            Object value = entry.getValue();
            if (value instanceof Map) {
                javaOnlyMap.put(str, INSTANCE.convertMap2JavaOnlyMap((Map) value));
            } else if (value instanceof List) {
                javaOnlyMap.put(str, INSTANCE.convertList2JavaOnlyArray((List) value));
            } else {
                javaOnlyMap.put(str, value);
            }
        }
        return javaOnlyMap;
    }

    private final JavaOnlyArray convertJSONArray2JavaOnlyArray(JSONArray arrays) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int length = arrays.length();
        for (int i = 0; i < length; i++) {
            Object opt = arrays.opt(i);
            if (opt instanceof JSONArray) {
                javaOnlyArray.add(convertJSONArray2JavaOnlyArray((JSONArray) opt));
            } else if (opt instanceof JSONObject) {
                javaOnlyArray.add(convertJSONObject2JavaOnlyMap((JSONObject) opt));
            } else {
                javaOnlyArray.add(opt);
            }
        }
        return javaOnlyArray;
    }

    public final Number getNumber(Number rawNumber) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(rawNumber, "rawNumber");
        try {
            Result.Companion companion = Result.Companion;
            WorkerConvertUtils workerConvertUtils = this;
            obj = Result.constructor-impl(Integer.valueOf(rawNumber.intValue()));
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
            WorkerConvertUtils workerConvertUtils2 = this;
            obj2 = Result.constructor-impl(Double.valueOf(rawNumber.doubleValue()));
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

    public final Map<String, Object> jsonToMap(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = json.opt(next);
            if (opt instanceof Long) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                linkedHashMap.put(next, Long.valueOf(json.optLong(next)));
            } else if (opt instanceof Double) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                linkedHashMap.put(next, Double.valueOf(json.optDouble(next)));
            } else if (opt instanceof Integer) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                linkedHashMap.put(next, Integer.valueOf(json.optInt(next)));
            } else if (opt instanceof String) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                linkedHashMap.put(next, json.optString(next));
            } else if (opt instanceof JSONObject) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                WorkerConvertUtils workerConvertUtils = INSTANCE;
                JSONObject optJSONObject = json.optJSONObject(next);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "json.optJSONObject(key)");
                linkedHashMap.put(next, workerConvertUtils.jsonToMap(optJSONObject));
            } else if (opt instanceof JSONArray) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                JSONArray optJSONArray = json.optJSONArray(next);
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "json.optJSONArray(key)");
                linkedHashMap.put(next, convertUtils.jsonToList(optJSONArray));
            } else if (opt instanceof Boolean) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                linkedHashMap.put(next, Boolean.valueOf(json.optBoolean(next)));
            } else {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                linkedHashMap.put(next, null);
            }
        }
        return linkedHashMap;
    }
}
