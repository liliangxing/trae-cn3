package com.bytedance.pia.core.utils;

import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WorkerUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0007J\f\u0010\u000f\u001a\u00020\u000b*\u00020\u0010H\u0007J\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0005H\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/core/utils/WorkerUtils;", "", "()V", "forEachKey", "", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "block", "Lkotlin/Function1;", "", "toJavaOnlyArray", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;", "Lcom/google/gson/JsonArray;", "toJavaOnlyMap", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "Lcom/google/gson/JsonObject;", "toJson", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableArray;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WorkerUtils {
    public static final WorkerUtils INSTANCE = new WorkerUtils();

    /* compiled from: WorkerUtils.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 2;
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
                iArr[ReadableType.Number.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private WorkerUtils() {
    }

    @JvmStatic
    public static final void forEachKey(ReadableMap readableMap, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            String str = nextKey;
            if (!(str == null || StringsKt.isBlank(str))) {
                Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                function1.invoke(nextKey);
            }
        }
    }

    @JvmStatic
    public static final JsonObject toJson(final ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        final JsonObject jsonObject = new JsonObject();
        forEachKey(readableMap, new Function1<String, Unit>() { // from class: com.bytedance.pia.core.utils.WorkerUtils$toJson$1$1

            /* compiled from: WorkerUtils.kt */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ReadableType.values().length];
                    try {
                        iArr[ReadableType.Null.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ReadableType.Boolean.ordinal()] = 2;
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
                        iArr[ReadableType.Number.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[ReadableType.String.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[ReadableType.Map.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[ReadableType.Array.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "key");
                ReadableType type = readableMap.getType(str);
                switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        jsonObject.add(str, JsonNull.INSTANCE);
                        return;
                    case 2:
                        jsonObject.addProperty(str, Boolean.valueOf(readableMap.getBoolean(str)));
                        return;
                    case 3:
                        jsonObject.addProperty(str, Integer.valueOf(readableMap.getInt(str)));
                        return;
                    case 4:
                        jsonObject.addProperty(str, Long.valueOf(readableMap.getLong(str)));
                        return;
                    case 5:
                        jsonObject.addProperty(str, Double.valueOf(readableMap.getDouble(str)));
                        return;
                    case 6:
                        jsonObject.addProperty(str, readableMap.getString(str));
                        return;
                    case 7:
                        JsonObject jsonObject2 = jsonObject;
                        ReadableMap map = readableMap.getMap(str);
                        Intrinsics.checkNotNullExpressionValue(map, "getMap(key)");
                        jsonObject2.add(str, WorkerUtils.toJson(map));
                        return;
                    case 8:
                        JsonObject jsonObject3 = jsonObject;
                        ReadableArray array = readableMap.getArray(str);
                        Intrinsics.checkNotNullExpressionValue(array, "getArray(key)");
                        jsonObject3.add(str, WorkerUtils.toJson(array));
                        return;
                    default:
                        return;
                }
            }
        });
        return jsonObject;
    }

    @JvmStatic
    public static final JsonArray toJson(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "<this>");
        JsonArray jsonArray = new JsonArray();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableType type = readableArray.getType(i);
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    jsonArray.add(JsonNull.INSTANCE);
                    break;
                case 2:
                    jsonArray.add(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case 3:
                    jsonArray.add(Integer.valueOf(readableArray.getInt(i)));
                    break;
                case 4:
                    jsonArray.add(Long.valueOf(readableArray.getLong(i)));
                    break;
                case 5:
                    jsonArray.add(Double.valueOf(readableArray.getDouble(i)));
                    break;
                case 6:
                    jsonArray.add(readableArray.getString(i));
                    break;
                case 7:
                    ReadableMap map = readableArray.getMap(i);
                    Intrinsics.checkNotNullExpressionValue(map, "getMap(index)");
                    jsonArray.add(toJson(map));
                    break;
                case 8:
                    ReadableArray array = readableArray.getArray(i);
                    Intrinsics.checkNotNullExpressionValue(array, "getArray(index)");
                    jsonArray.add(toJson(array));
                    break;
            }
        }
        return jsonArray;
    }

    @JvmStatic
    public static final JavaOnlyMap toJavaOnlyMap(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Map javaOnlyMap = new JavaOnlyMap();
        Set<String> keySet = jsonObject.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
        for (String str : keySet) {
            JsonPrimitive jsonPrimitive = jsonObject.get(str);
            if (jsonPrimitive instanceof JsonNull) {
                javaOnlyMap.put(str, null);
            } else if (jsonPrimitive instanceof JsonObject) {
                javaOnlyMap.put(str, toJavaOnlyMap((JsonObject) jsonPrimitive));
            } else if (jsonPrimitive instanceof JsonArray) {
                javaOnlyMap.put(str, toJavaOnlyArray((JsonArray) jsonPrimitive));
            } else if (jsonPrimitive instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive2 = jsonPrimitive;
                if (jsonPrimitive2.isBoolean()) {
                    javaOnlyMap.put(str, Boolean.valueOf(jsonPrimitive2.getAsBoolean()));
                } else if (jsonPrimitive2.isString()) {
                    javaOnlyMap.put(str, jsonPrimitive2.getAsString());
                } else if (jsonPrimitive2.isNumber()) {
                    if (StringsKt.contains$default(jsonPrimitive2.getAsNumber().toString(), '.', false, 2, (Object) null)) {
                        javaOnlyMap.put(str, Double.valueOf(jsonPrimitive2.getAsNumber().doubleValue()));
                    } else {
                        javaOnlyMap.put(str, Long.valueOf(jsonPrimitive2.getAsNumber().longValue()));
                    }
                }
            }
        }
        return javaOnlyMap;
    }

    @JvmStatic
    public static final JavaOnlyArray toJavaOnlyArray(JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "<this>");
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        for (JsonPrimitive jsonPrimitive : (Iterable) jsonArray) {
            if (jsonPrimitive instanceof JsonNull) {
                javaOnlyArray.add((Object) null);
            } else if (jsonPrimitive instanceof JsonObject) {
                javaOnlyArray.add(toJavaOnlyMap((JsonObject) jsonPrimitive));
            } else if (jsonPrimitive instanceof JsonArray) {
                javaOnlyArray.add(toJavaOnlyArray((JsonArray) jsonPrimitive));
            } else if (jsonPrimitive instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive2 = jsonPrimitive;
                if (jsonPrimitive2.isBoolean()) {
                    javaOnlyArray.add(Boolean.valueOf(jsonPrimitive2.getAsBoolean()));
                } else if (jsonPrimitive2.isString()) {
                    javaOnlyArray.add(jsonPrimitive2.getAsString());
                } else if (jsonPrimitive2.isNumber()) {
                    if (StringsKt.contains$default(jsonPrimitive2.getAsNumber().toString(), '.', false, 2, (Object) null)) {
                        javaOnlyArray.add(Double.valueOf(jsonPrimitive2.getAsNumber().doubleValue()));
                    } else {
                        javaOnlyArray.add(Long.valueOf(jsonPrimitive2.getAsNumber().longValue()));
                    }
                }
            }
        }
        return javaOnlyArray;
    }
}
