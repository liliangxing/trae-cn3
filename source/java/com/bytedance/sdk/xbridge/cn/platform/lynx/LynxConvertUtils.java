package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.lynx.jsbridge.Arguments;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
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
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LynxConvertUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0003J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0003J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0007J\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00162\u0006\u0010\u0014\u001a\u00020\rH\u0007J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u001d\u001a\u00020\u00042\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0016\u0010\u001f\u001a\u00020\r2\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0016J(\u0010 \u001a\u00020\r2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00162\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#J\u0012\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010&\u001a\u0004\u0018\u00010\u0001J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u000fJ\u001c\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00162\u0006\u0010&\u001a\u00020*J\f\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020+J\u001c\u0010,\u001a\u00020-*\u00020\u00042\u0006\u0010&\u001a\u00020.2\u0006\u0010/\u001a\u00020\bH\u0002J$\u00100\u001a\u00020-*\u00020\r2\u0006\u00101\u001a\u00020\u00172\u0006\u0010&\u001a\u00020.2\u0006\u0010/\u001a\u00020\bH\u0002¨\u00062"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxConvertUtils;", "", "()V", "convertArrayToJavaOnlyArray", "Lcom/lynx/react/bridge/JavaOnlyArray;", "sourceArray", "", "bigIntStrategy", "", "convertJSONArray2JavaOnlyArray", "arrays", "Lorg/json/JSONArray;", "convertJSONObject2JavaOnlyMap", "Lcom/lynx/react/bridge/JavaOnlyMap;", "obj", "Lorg/json/JSONObject;", "convertJavaOnlyArrayToJson", "array", "convertJavaOnlyArrayToList", "convertJavaOnlyMapToJson", "map", "convertJavaOnlyMapToMap", "", "", "convertJsonToJavaOnlyArray", "Lcom/lynx/react/bridge/WritableArray;", "jsonArray", "convertJsonToJavaOnlyMap", "jsonObject", "convertList2JavaOnlyArray", "list", "convertMap2JavaOnlyMap", "convertMapToJavaOnlyMap", TimonPipeline.KEY_SOURCE, "getNumber", "", "rawNumber", "getValue", "value", "jsonToReact", "Lcom/lynx/react/bridge/WritableMap;", "readableToMap", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/lynx/react/bridge/Dynamic;", "pushLongWithStrategy", "", "", "strategy", "putLongWithStrategy", "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LynxConvertUtils {
    public static final LynxConvertUtils INSTANCE = new LynxConvertUtils();

    /* compiled from: LynxConvertUtils.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
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
                iArr[ReadableType.Long.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Int.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 5;
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

    private LynxConvertUtils() {
    }

    public final Object getValue(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "<this>");
        if (XBridge.INSTANCE.getEnableAnnieXJsbParamInNumberAdapterFix()) {
            ReadableType type = dynamic.getType();
            switch (type != null ? WhenMappings.$EnumSwitchMapping$0[type.ordinal()] : -1) {
                case 1:
                    return dynamic.asString();
                case 2:
                    return getNumber(Double.valueOf(dynamic.asDouble()));
                case 3:
                    return getNumber(Long.valueOf(dynamic.asLong()));
                case 4:
                    return getNumber(Integer.valueOf(dynamic.asInt()));
                case 5:
                    return Boolean.valueOf(dynamic.asBoolean());
                case 6:
                    return dynamic.asMap();
                case 7:
                    return dynamic.asArray();
                case 8:
                default:
                    return null;
            }
        }
        ReadableType type2 = dynamic.getType();
        int i = type2 != null ? WhenMappings.$EnumSwitchMapping$0[type2.ordinal()] : -1;
        if (i == 1) {
            return dynamic.asString();
        }
        if (i == 2) {
            return getNumber(Double.valueOf(dynamic.asDouble()));
        }
        if (i == 5) {
            return Boolean.valueOf(dynamic.asBoolean());
        }
        if (i == 6) {
            return dynamic.asMap();
        }
        if (i != 7) {
            return null;
        }
        return dynamic.asArray();
    }

    public final Map<String, Object> readableToMap(ReadableMap value) {
        Intrinsics.checkNotNullParameter(value, "value");
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
    public static final JavaOnlyArray convertArrayToJavaOnlyArray(List<? extends Object> sourceArray, int bigIntStrategy) {
        Intrinsics.checkNotNullParameter(sourceArray, "sourceArray");
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int size = sourceArray.size();
        for (int i = 0; i < size; i++) {
            Object obj = sourceArray.get(i);
            if (obj instanceof Map) {
                try {
                    javaOnlyArray.pushMap(convertMapToJavaOnlyMap((Map) obj, bigIntStrategy));
                } catch (Exception unused) {
                }
            } else if (obj instanceof List) {
                javaOnlyArray.pushArray(convertArrayToJavaOnlyArray((List) obj, bigIntStrategy));
            } else if (obj instanceof Boolean) {
                javaOnlyArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                javaOnlyArray.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                INSTANCE.pushLongWithStrategy(javaOnlyArray, ((Number) obj).longValue(), bigIntStrategy);
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

    public static /* synthetic */ JavaOnlyMap convertMapToJavaOnlyMap$default(Map map, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return convertMapToJavaOnlyMap(map, i);
    }

    @JvmStatic
    public static final JavaOnlyMap convertMapToJavaOnlyMap(Map<String, ? extends Object> source, int bigIntStrategy) {
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        for (Map.Entry<String, ? extends Object> entry : source.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                try {
                    javaOnlyMap.putMap(key, convertMapToJavaOnlyMap((Map) value, bigIntStrategy));
                } catch (Exception unused) {
                }
            } else if (value instanceof List) {
                javaOnlyMap.putArray(key, convertArrayToJavaOnlyArray((List) value, bigIntStrategy));
            } else if (value instanceof Boolean) {
                javaOnlyMap.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Integer) {
                javaOnlyMap.putInt(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                INSTANCE.putLongWithStrategy(javaOnlyMap, key, ((Number) value).longValue(), bigIntStrategy);
            } else if (value instanceof Float) {
                javaOnlyMap.putDouble(key, ((Number) value).floatValue());
            } else if (value instanceof Double) {
                javaOnlyMap.putDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                javaOnlyMap.putString(key, (String) value);
            } else if (value instanceof JSONObject) {
                javaOnlyMap.putMap(key, convertJsonToJavaOnlyMap((JSONObject) value, bigIntStrategy));
            } else if (value instanceof JSONArray) {
                javaOnlyMap.putArray(key, convertJsonToJavaOnlyArray((JSONArray) value, bigIntStrategy));
            } else if (value == null || Intrinsics.areEqual(value, JSONObject.NULL)) {
                javaOnlyMap.putNull(key);
            } else {
                javaOnlyMap.putString(key, value.toString());
            }
        }
        return javaOnlyMap;
    }

    @JvmStatic
    public static final WritableArray convertJsonToJavaOnlyArray(JSONArray jsonArray, int bigIntStrategy) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jsonArray.get(i);
            if (obj instanceof JSONObject) {
                javaOnlyArray.pushMap(convertJsonToJavaOnlyMap((JSONObject) obj, bigIntStrategy));
            } else if (obj instanceof JSONArray) {
                javaOnlyArray.pushArray(convertJsonToJavaOnlyArray((JSONArray) obj, bigIntStrategy));
            } else if (obj instanceof Boolean) {
                javaOnlyArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                javaOnlyArray.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                INSTANCE.pushLongWithStrategy(javaOnlyArray, ((Number) obj).longValue(), bigIntStrategy);
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
        return (WritableArray) javaOnlyArray;
    }

    public static /* synthetic */ JavaOnlyMap convertJsonToJavaOnlyMap$default(JSONObject jSONObject, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return convertJsonToJavaOnlyMap(jSONObject, i);
    }

    @JvmStatic
    public static final JavaOnlyMap convertJsonToJavaOnlyMap(JSONObject jsonObject, int bigIntStrategy) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            String str = next;
            Object obj = jsonObject.get(str);
            if (obj instanceof JSONObject) {
                javaOnlyMap.putMap(str, convertJsonToJavaOnlyMap((JSONObject) obj, bigIntStrategy));
            } else if (Intrinsics.areEqual(obj, JSONObject.NULL)) {
                javaOnlyMap.putMap(str, (WritableMap) null);
            } else if (obj instanceof JSONArray) {
                javaOnlyMap.putArray(str, convertJsonToJavaOnlyArray((JSONArray) obj, bigIntStrategy));
            } else if (obj instanceof Boolean) {
                javaOnlyMap.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                javaOnlyMap.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                INSTANCE.putLongWithStrategy(javaOnlyMap, str, ((Number) obj).longValue(), bigIntStrategy);
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
                } else if (i == 6) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");
                    jSONObject.putOpt(nextKey, convertJavaOnlyMapToJson((JavaOnlyMap) obj));
                } else if (i == 7) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");
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
                } else if (i == 6) {
                    Intrinsics.checkNotNullExpressionValue(nextKey, "nextKey");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");
                    linkedHashMap.put(nextKey, convertJavaOnlyMapToMap((JavaOnlyMap) obj));
                } else if (i == 7) {
                    Intrinsics.checkNotNullExpressionValue(nextKey, "nextKey");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");
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
                } else if (i2 == 6) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");
                    arrayList.add(convertJavaOnlyMapToMap((JavaOnlyMap) obj));
                } else if (i2 == 7) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");
                    arrayList.add(convertJavaOnlyArrayToList((JavaOnlyArray) obj));
                } else {
                    Intrinsics.checkNotNullExpressionValue(obj, "value");
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
                } else if (i2 == 6) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");
                    jSONArray.put(convertJavaOnlyMapToJson((JavaOnlyMap) obj));
                } else if (i2 == 7) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");
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
        Intrinsics.checkNotNullParameter(list, "list");
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
            LynxConvertUtils lynxConvertUtils = this;
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
            LynxConvertUtils lynxConvertUtils2 = this;
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
                createMap.putDouble(str, jsonObject.getLong(str));
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
            if (obj instanceof Float ? true : obj instanceof Double) {
                createArray.pushDouble(jsonArray.getDouble(i));
            } else if (obj instanceof Long) {
                createArray.pushDouble(jsonArray.getLong(i));
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
        Intrinsics.checkNotNullExpressionValue(createArray, "writableArray");
        return createArray;
    }

    private final void pushLongWithStrategy(JavaOnlyArray javaOnlyArray, long j, int i) {
        if (i == 0) {
            javaOnlyArray.pushDouble(j);
        } else if (i == 1) {
            javaOnlyArray.pushString(String.valueOf(j));
        } else {
            if (i != 2) {
                return;
            }
            javaOnlyArray.pushLong(j);
        }
    }

    private final void putLongWithStrategy(JavaOnlyMap javaOnlyMap, String str, long j, int i) {
        if (i == 0) {
            javaOnlyMap.putDouble(str, j);
        } else if (i == 1) {
            javaOnlyMap.putString(str, String.valueOf(j));
        } else {
            if (i != 2) {
                return;
            }
            javaOnlyMap.putLong(str, j);
        }
    }
}
