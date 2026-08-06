package com.bytedance.ies.xbridge;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BridgeDataConverterHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0018\u001a \u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J.\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u0001H\u0007J>\u0010\u001d\u001a \u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fj\u0004\u0018\u0001`\r2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0007J4\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u00042\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\u0002`\u00132\b\b\u0002\u0010#\u001a\u00020$H\u0007J:\u0010%\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00162 \u0010\"\u001a\u001c\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\fj\u0002`\rH\u0007JL\u0010'\u001a\u00020!2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u000b2 \u0010\"\u001a\u001c\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\fj\u0002`\r2\b\b\u0002\u0010#\u001a\u00020$H\u0007J\u0006\u0010(\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000RK\u0010\t\u001a<\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012.\u0012,\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\fj\u0002`\r0\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR/\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\u0002`\u00130\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fRC\u0010\u0015\u001a4\u0012\u0004\u0012\u00020\u0004\u0012*\u0012(\u0012\u0004\u0012\u00020\u0016\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\fj\u0002`\r0\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006*"}, d2 = {"Lcom/bytedance/ies/xbridge/BridgeDataConverterHolder;", "", "()V", "PLATFORM_LYNX", "", "PLATFORM_REACT_NATIVE", "PLATFORM_WEB", "TYPE_INPUT", "TYPE_OUTPUT", "converterHolderMap", "", "Ljava/lang/Class;", "Lkotlin/Function2;", "Lcom/bytedance/ies/xbridge/TypeConverter;", "getConverterHolderMap", "()Ljava/util/Map;", "jsonConverterHolderMap", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lcom/bytedance/ies/xbridge/JSONTypeConverter;", "getJsonConverterHolderMap", "platformTypeConverter", "Lcom/bytedance/ies/xbridge/ConverterDir;", "getPlatformTypeConverter", "getPlatformInputType", "platform", "getPlatformOutputType", "provideJSONModel", "data", "provideTypeConverter", "inputClass", "outputClass", "registerJSONTypeConverter", "", "typeConverter", StrategyConstants.STRATEGY, "Lcom/bytedance/ies/xbridge/BridgeDataConverterHolder$Strategy;", "registerPlatformTypeConverter", "dir", "registerTypeConverter", "release", "Strategy", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BridgeDataConverterHolder {
    public static final String PLATFORM_LYNX = "LYNX";
    public static final String PLATFORM_REACT_NATIVE = "RN";
    public static final String PLATFORM_WEB = "WEB";
    public static final String TYPE_INPUT = "input";
    public static final String TYPE_OUTPUT = "output";
    private static final Map<String, Function1<Object, JSONObject>> jsonConverterHolderMap;
    public static final BridgeDataConverterHolder INSTANCE = new BridgeDataConverterHolder();
    private static final Map<Class<?>, Map<Class<?>, Function2<Object, Class<?>, Object>>> converterHolderMap = new LinkedHashMap();
    private static final Map<String, Map<ConverterDir, Function2<Object, Class<?>, Object>>> platformTypeConverter = new LinkedHashMap();

    /* compiled from: BridgeDataConverterHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xbridge/BridgeDataConverterHolder$Strategy;", "", "(Ljava/lang/String;I)V", "REPLACE", "IGNORE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Strategy {
        REPLACE,
        IGNORE
    }

    /* compiled from: BridgeDataConverterHolder.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Strategy.values().length];
            try {
                iArr[Strategy.REPLACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Strategy.IGNORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final void registerJSONTypeConverter(String platform, Function1<Object, ? extends JSONObject> typeConverter) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        registerJSONTypeConverter$default(platform, typeConverter, null, 4, null);
    }

    @JvmStatic
    public static final void registerTypeConverter(Class<?> inputClass, Class<?> outputClass, Function2<Object, ? super Class<?>, ? extends Object> typeConverter) {
        Intrinsics.checkNotNullParameter(inputClass, "inputClass");
        Intrinsics.checkNotNullParameter(outputClass, "outputClass");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        registerTypeConverter$default(inputClass, outputClass, typeConverter, null, 8, null);
    }

    private BridgeDataConverterHolder() {
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PLATFORM_WEB, new Function1<Object, JSONObject>() { // from class: com.bytedance.ies.xbridge.BridgeDataConverterHolder$jsonConverterHolderMap$1$1
            @Override // kotlin.jvm.functions.Function1
            public JSONObject invoke(Object params) {
                Intrinsics.checkNotNullParameter(params, "params");
                if (params instanceof JSONObject) {
                    return (JSONObject) params;
                }
                return null;
            }
        });
        jsonConverterHolderMap = linkedHashMap;
    }

    public final Map<Class<?>, Map<Class<?>, Function2<Object, Class<?>, Object>>> getConverterHolderMap() {
        return converterHolderMap;
    }

    public final Map<String, Map<ConverterDir, Function2<Object, Class<?>, Object>>> getPlatformTypeConverter() {
        return platformTypeConverter;
    }

    public final Map<String, Function1<Object, JSONObject>> getJsonConverterHolderMap() {
        return jsonConverterHolderMap;
    }

    public static /* synthetic */ void registerTypeConverter$default(Class cls, Class cls2, Function2 function2, Strategy strategy, int i, Object obj) {
        if ((i & 8) != 0) {
            strategy = Strategy.IGNORE;
        }
        registerTypeConverter(cls, cls2, function2, strategy);
    }

    @JvmStatic
    public static final void registerTypeConverter(Class<?> inputClass, Class<?> outputClass, Function2<Object, ? super Class<?>, ? extends Object> typeConverter, Strategy strategy) {
        Map<Class<?>, Function2<Object, Class<?>, Object>> map;
        Intrinsics.checkNotNullParameter(inputClass, "inputClass");
        Intrinsics.checkNotNullParameter(outputClass, "outputClass");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Map<Class<?>, Map<Class<?>, Function2<Object, Class<?>, Object>>> map2 = converterHolderMap;
        if (map2.get(inputClass) == null) {
            map2.put(inputClass, new LinkedHashMap());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[strategy.ordinal()];
        if (i == 1) {
            Map<Class<?>, Function2<Object, Class<?>, Object>> map3 = map2.get(inputClass);
            if (map3 != null) {
                map3.put(outputClass, typeConverter);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        Map<Class<?>, Function2<Object, Class<?>, Object>> map4 = map2.get(inputClass);
        if ((map4 != null && map4.containsKey(outputClass)) || (map = map2.get(inputClass)) == null) {
            return;
        }
        map.put(outputClass, typeConverter);
    }

    @JvmStatic
    public static final void registerPlatformTypeConverter(String platform, ConverterDir dir, Function2<Object, ? super Class<?>, ? extends Object> typeConverter) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Map<String, Map<ConverterDir, Function2<Object, Class<?>, Object>>> map = platformTypeConverter;
        LinkedHashMap linkedHashMap = map.get(platform);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            map.put(platform, linkedHashMap);
        }
        linkedHashMap.put(dir, typeConverter);
    }

    @JvmStatic
    public static final Function2<Object, Class<?>, Object> getPlatformInputType(String platform) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Map<ConverterDir, Function2<Object, Class<?>, Object>> map = platformTypeConverter.get(platform);
        if (map != null) {
            return map.get(ConverterDir.INPUT);
        }
        return null;
    }

    @JvmStatic
    public static final Function2<Object, Class<?>, Object> getPlatformOutputType(String platform) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Map<ConverterDir, Function2<Object, Class<?>, Object>> map = platformTypeConverter.get(platform);
        if (map != null) {
            return map.get(ConverterDir.OUTPUT);
        }
        return null;
    }

    @JvmStatic
    public static final Function2<Object, Class<?>, Object> provideTypeConverter(Class<?> inputClass, Class<?> outputClass) {
        Intrinsics.checkNotNullParameter(inputClass, "inputClass");
        Intrinsics.checkNotNullParameter(outputClass, "outputClass");
        Map<Class<?>, Function2<Object, Class<?>, Object>> map = converterHolderMap.get(inputClass);
        if (map != null) {
            return map.get(outputClass);
        }
        return null;
    }

    public static /* synthetic */ void registerJSONTypeConverter$default(String str, Function1 function1, Strategy strategy, int i, Object obj) {
        if ((i & 4) != 0) {
            strategy = Strategy.IGNORE;
        }
        registerJSONTypeConverter(str, function1, strategy);
    }

    @JvmStatic
    public static final void registerJSONTypeConverter(String platform, Function1<Object, ? extends JSONObject> typeConverter, Strategy strategy) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        int i = WhenMappings.$EnumSwitchMapping$0[strategy.ordinal()];
        if (i == 1) {
            jsonConverterHolderMap.put(platform, typeConverter);
        } else {
            if (i != 2) {
                return;
            }
            Map<String, Function1<Object, JSONObject>> map = jsonConverterHolderMap;
            if (map.containsKey(platform)) {
                return;
            }
            map.put(platform, typeConverter);
        }
    }

    @JvmStatic
    public static final JSONObject provideJSONModel(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = jsonConverterHolderMap.entrySet().iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) ((Function1) ((Map.Entry) it.next()).getValue()).invoke(data);
            if (jSONObject != null) {
                return jSONObject;
            }
        }
        return null;
    }

    public final void release() {
        converterHolderMap.clear();
        jsonConverterHolderMap.clear();
    }
}
