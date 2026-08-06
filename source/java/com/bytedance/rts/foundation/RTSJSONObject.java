package com.bytedance.rts.foundation;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Serializable.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ!\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0000J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006!"}, d2 = {"Lcom/bytedance/rts/foundation/RTSJSONObject;", "Ljava/io/Serializable;", "()V", "rawMap", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getRawMap$lib_release", "()Lorg/json/JSONObject;", "setRawMap$lib_release", PrefetchRequestConfig.METHOD_GET, "", "key", "", "getBool", "", "fallback", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getDouble", "", "(Ljava/lang/String;Ljava/lang/Double;)Ljava/lang/Double;", "getInt", "", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "getObject", "getString", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "writeObject", "out", "Ljava/io/ObjectOutputStream;", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RTSJSONObject implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private transient JSONObject rawMap;

    public RTSJSONObject(JSONObject jSONObject) {
        this.rawMap = jSONObject == null ? new JSONObject() : jSONObject;
    }

    /* compiled from: Serializable.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bJ-\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJ/\u0010\r\u001a\u0004\u0018\u00010\n2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\fJ-\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J/\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J-\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015J(\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0018J*\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001e\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0012\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0001J(\u0010#\u001a\u0004\u0018\u00010\b2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bJ*\u0010$\u001a\u0004\u0018\u00010\b2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0002¨\u0006%"}, d2 = {"Lcom/bytedance/rts/foundation/RTSJSONObject$Companion;", "", "()V", PrefetchRequestConfig.METHOD_GET, "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "key", "", "getBool", "", "fallback", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getBoolInner", "getDouble", "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Double;)Ljava/lang/Double;", "getDoubleInner", "getInner", "getInt", "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "getIntInner", "getObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "getObjectInner", "getPlainList", "", "jsonArray", "Lorg/json/JSONArray;", "getPlainMap", "", "jsonObject", "getPlainValue", "value", "getString", "getStringInner", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object getInner(JSONObject map, String key) {
            if (map.has(key)) {
                return map.opt(key);
            }
            return null;
        }

        public final Object get(JSONObject map, String key) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(key, "key");
            return getInner(map, key);
        }

        static /* synthetic */ Integer getIntInner$default(Companion companion, JSONObject jSONObject, String str, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                num = null;
            }
            return companion.getIntInner(jSONObject, str, num);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Integer getIntInner(JSONObject map, String key, Integer fallback) {
            Object inner = getInner(map, key);
            if (inner instanceof Integer) {
                return (Integer) inner;
            }
            if (inner instanceof Number) {
                return Integer.valueOf(((Number) inner).intValue());
            }
            return inner instanceof String ? Integer.valueOf(Integer.parseInt((String) inner)) : fallback;
        }

        public static /* synthetic */ Integer getInt$default(Companion companion, JSONObject jSONObject, String str, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                num = null;
            }
            return companion.getInt(jSONObject, str, num);
        }

        public final Integer getInt(JSONObject map, String key, Integer fallback) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(key, "key");
            return getIntInner(map, key, fallback);
        }

        static /* synthetic */ Double getDoubleInner$default(Companion companion, JSONObject jSONObject, String str, Double d, int i, Object obj) {
            if ((i & 4) != 0) {
                d = null;
            }
            return companion.getDoubleInner(jSONObject, str, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Double getDoubleInner(JSONObject map, String key, Double fallback) {
            Object inner = getInner(map, key);
            if (inner instanceof Double) {
                return (Double) inner;
            }
            if (inner instanceof Number) {
                return Double.valueOf(((Number) inner).doubleValue());
            }
            return inner instanceof String ? Double.valueOf(Double.parseDouble((String) inner)) : fallback;
        }

        public static /* synthetic */ Double getDouble$default(Companion companion, JSONObject jSONObject, String str, Double d, int i, Object obj) {
            if ((i & 4) != 0) {
                d = null;
            }
            return companion.getDouble(jSONObject, str, d);
        }

        public final Double getDouble(JSONObject map, String key, Double fallback) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(key, "key");
            return getDoubleInner(map, key, fallback);
        }

        static /* synthetic */ String getStringInner$default(Companion companion, JSONObject jSONObject, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.getStringInner(jSONObject, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getStringInner(JSONObject map, String key, String fallback) {
            Object inner = getInner(map, key);
            String str = inner instanceof String ? (String) inner : null;
            return str == null ? fallback : str;
        }

        public static /* synthetic */ String getString$default(Companion companion, JSONObject jSONObject, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.getString(jSONObject, str, str2);
        }

        public final String getString(JSONObject map, String key, String fallback) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(key, "key");
            return getStringInner(map, key, fallback);
        }

        static /* synthetic */ Boolean getBoolInner$default(Companion companion, JSONObject jSONObject, String str, Boolean bool, int i, Object obj) {
            if ((i & 4) != 0) {
                bool = null;
            }
            return companion.getBoolInner(jSONObject, str, bool);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Boolean getBoolInner(JSONObject map, String key, Boolean fallback) {
            Object inner = getInner(map, key);
            Boolean bool = inner instanceof Boolean ? (Boolean) inner : null;
            return bool == null ? fallback : bool;
        }

        public static /* synthetic */ Boolean getBool$default(Companion companion, JSONObject jSONObject, String str, Boolean bool, int i, Object obj) {
            if ((i & 4) != 0) {
                bool = null;
            }
            return companion.getBool(jSONObject, str, bool);
        }

        public final Boolean getBool(JSONObject map, String key, Boolean fallback) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(key, "key");
            return getBoolInner$default(this, map, key, null, 4, null);
        }

        static /* synthetic */ RTSJSONObject getObjectInner$default(Companion companion, JSONObject jSONObject, String str, RTSJSONObject rTSJSONObject, int i, Object obj) {
            if ((i & 4) != 0) {
                rTSJSONObject = null;
            }
            return companion.getObjectInner(jSONObject, str, rTSJSONObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final RTSJSONObject getObjectInner(JSONObject map, String key, RTSJSONObject fallback) {
            Object inner = getInner(map, key);
            JSONObject jSONObject = inner instanceof JSONObject ? (JSONObject) inner : null;
            return jSONObject != null ? new RTSJSONObject(jSONObject) : fallback;
        }

        public static /* synthetic */ RTSJSONObject getObject$default(Companion companion, JSONObject jSONObject, String str, RTSJSONObject rTSJSONObject, int i, Object obj) {
            if ((i & 4) != 0) {
                rTSJSONObject = null;
            }
            return companion.getObject(jSONObject, str, rTSJSONObject);
        }

        public final RTSJSONObject getObject(JSONObject map, String key, RTSJSONObject fallback) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(key, "key");
            return getObjectInner(map, key, fallback);
        }

        public final Object getPlainValue(Object value) {
            if (value instanceof JSONObject) {
                return getPlainMap((JSONObject) value);
            }
            if (value instanceof JSONArray) {
                return getPlainList((JSONArray) value);
            }
            if (Intrinsics.areEqual(value, JSONObject.NULL)) {
                return null;
            }
            return value;
        }

        public final Map<String, Object> getPlainMap(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object plainValue = getPlainValue(jsonObject.get(next));
                if (plainValue != null) {
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    linkedHashMap.put(next, plainValue);
                }
            }
            return linkedHashMap;
        }

        public final List<Object> getPlainList(JSONArray jsonArray) {
            if (jsonArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                Object plainValue = getPlainValue(jsonArray.get(i));
                if (plainValue != null) {
                    arrayList.add(plainValue);
                }
            }
            return arrayList;
        }
    }

    public RTSJSONObject() {
        this(null);
    }

    /* renamed from: getRawMap$lib_release, reason: from getter */
    public final JSONObject getRawMap() {
        return this.rawMap;
    }

    public final void setRawMap$lib_release(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.rawMap = jSONObject;
    }

    private final void writeObject(ObjectOutputStream out) {
        try {
            Result.Companion companion = Result.Companion;
            RTSJSONObject rTSJSONObject = this;
            out.defaultWriteObject();
            out.writeObject(this.rawMap.toString());
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void readObject(ObjectInputStream in) {
        try {
            Result.Companion companion = Result.Companion;
            RTSJSONObject rTSJSONObject = this;
            in.defaultReadObject();
            Object readObject = in.readObject();
            Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type kotlin.String");
            this.rawMap = new JSONObject((String) readObject);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final Object get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.getInner(this.rawMap, key);
    }

    public static /* synthetic */ Integer getInt$default(RTSJSONObject rTSJSONObject, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return rTSJSONObject.getInt(str, num);
    }

    public final Integer getInt(String key, Integer fallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.getIntInner(this.rawMap, key, fallback);
    }

    public static /* synthetic */ Double getDouble$default(RTSJSONObject rTSJSONObject, String str, Double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = null;
        }
        return rTSJSONObject.getDouble(str, d);
    }

    public final Double getDouble(String key, Double fallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.getDoubleInner(this.rawMap, key, fallback);
    }

    public static /* synthetic */ String getString$default(RTSJSONObject rTSJSONObject, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return rTSJSONObject.getString(str, str2);
    }

    public final String getString(String key, String fallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.getStringInner(this.rawMap, key, fallback);
    }

    public static /* synthetic */ Boolean getBool$default(RTSJSONObject rTSJSONObject, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        return rTSJSONObject.getBool(str, bool);
    }

    public final Boolean getBool(String key, Boolean fallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.getBoolInner(this.rawMap, key, fallback);
    }

    public static /* synthetic */ RTSJSONObject getObject$default(RTSJSONObject rTSJSONObject, String str, RTSJSONObject rTSJSONObject2, int i, Object obj) {
        if ((i & 2) != 0) {
            rTSJSONObject2 = null;
        }
        return rTSJSONObject.getObject(str, rTSJSONObject2);
    }

    public final RTSJSONObject getObject(String key, RTSJSONObject fallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.getObjectInner(this.rawMap, key, fallback);
    }
}
