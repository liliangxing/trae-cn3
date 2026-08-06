package com.bytedance.rts.foundation;

import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Serializable.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bH\u0016J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0011J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010\u001a\u001a\u00020\u00132\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016JE\u0010\u001e\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\t2#\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u0001H\u001f0$J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0014\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/rts/foundation/RTSSerializable;", "Ljava/io/Serializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "encodeData", "", "", "getEncodeData", "()Ljava/util/Map;", "<set-?>", "rawData", "getRawData", "()Lcom/bytedance/rts/foundation/RTSJSONObject;", "removeRawData", "", "afterInit", "", "afterParse", "afterToJSON", "doInit", "andParse", "encodeElement", "v", "mapping", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "optMapList", "T", "maxLevel", "", "value", "elConv", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "el", RLMonitorReporter.PARSE, "str", "toJSON", "toJSONString", "unmapping", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RTSSerializable implements Serializable {
    private final Map<String, Object> encodeData = new LinkedHashMap();
    private RTSJSONObject rawData;
    private boolean removeRawData;

    public void afterInit() {
    }

    public void afterParse() {
    }

    public void mapping(JSONObject map) {
        Intrinsics.checkNotNullParameter(map, "map");
    }

    public void unmapping() {
    }

    public final RTSJSONObject getRawData() {
        return this.rawData;
    }

    protected final Map<String, Object> getEncodeData() {
        return this.encodeData;
    }

    public RTSSerializable(RTSJSONObject rTSJSONObject, String str) {
        this.rawData = new RTSJSONObject(new JSONObject());
        if (str != null) {
            parse(str);
        } else if (rTSJSONObject != null) {
            this.rawData = rTSJSONObject;
        }
    }

    public final void doInit(boolean andParse) {
        if (andParse) {
            mapping(this.rawData.getRawMap());
            afterParse();
        } else {
            afterInit();
        }
        if (this.removeRawData) {
            this.rawData = new RTSJSONObject(new JSONObject());
        }
    }

    private final void parse(String str) {
        try {
            this.rawData = new RTSJSONObject(new JSONObject(str));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Map<String, Object> toJSON() {
        this.encodeData.clear();
        unmapping();
        return MapsKt.toMutableMap(this.encodeData);
    }

    public Map<String, Object> afterToJSON() {
        return new LinkedHashMap();
    }

    public String toJSONString() {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, Object> json = toJSON();
            json.putAll(afterToJSON());
            for (Map.Entry<String, Object> entry : json.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), encodeElement(entry.getValue()));
                } catch (Throwable unused) {
                }
            }
            Iterator<String> keys = this.rawData.getRawMap().keys();
            Intrinsics.checkNotNullExpressionValue(keys, "this.rawData.rawMap.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                if (!json.containsKey(next)) {
                    try {
                        jSONObject.put(next, encodeElement(this.rawData.getRawMap().opt(next)));
                    } catch (Throwable unused2) {
                    }
                }
            }
            return jSONObject.toString(0);
        } catch (Throwable unused3) {
            return null;
        }
    }

    private final Object encodeElement(Object v) {
        if (v instanceof RTSSerializable) {
            JSONObject jSONObject = new JSONObject();
            RTSSerializable rTSSerializable = (RTSSerializable) v;
            Map<String, Object> json = rTSSerializable.toJSON();
            json.putAll(rTSSerializable.afterToJSON());
            for (Map.Entry<String, Object> entry : json.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), encodeElement(entry.getValue()));
                } catch (Throwable unused) {
                }
            }
            Iterator<String> keys = rTSSerializable.rawData.getRawMap().keys();
            Intrinsics.checkNotNullExpressionValue(keys, "v.rawData.rawMap.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                if (!json.containsKey(next)) {
                    try {
                        jSONObject.put(next, encodeElement(((RTSSerializable) v).rawData.getRawMap().opt(next)));
                    } catch (Throwable unused2) {
                    }
                }
            }
            return jSONObject;
        }
        if (TypeIntrinsics.isMutableList(v)) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((Iterable) v).iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(encodeElement(it.next()));
                } catch (Throwable unused3) {
                }
            }
            return jSONArray;
        }
        if (!TypeIntrinsics.isMutableMap(v)) {
            return v;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry entry2 : ((Map) v).entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            if ((key instanceof String) && value != null) {
                try {
                    jSONObject2.put((String) key, encodeElement(value));
                } catch (Throwable unused4) {
                }
            }
        }
        return jSONObject2;
    }

    public final <T> Object optMapList(int maxLevel, Object value, Function1<Object, ? extends T> elConv) {
        Intrinsics.checkNotNullParameter(elConv, "elConv");
        if (value == null) {
            return null;
        }
        if (maxLevel <= 0) {
            return elConv.invoke(value);
        }
        if (value instanceof JSONArray) {
            ArrayList rtsArrayOf = RTSArrayKt.rtsArrayOf(new Object[0]);
            JSONArray jSONArray = (JSONArray) value;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Object optMapList = optMapList(maxLevel - 1, jSONArray.opt(i), elConv);
                if (optMapList != null) {
                    rtsArrayOf.add(optMapList);
                }
            }
            return rtsArrayOf;
        }
        if (!(value instanceof JSONObject)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = (JSONObject) value;
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "value.keys()");
        for (String str : SequencesKt.toList(SequencesKt.asSequence(keys))) {
            Object opt = jSONObject.opt(str);
            Object optMapList2 = opt != null ? optMapList(maxLevel - 1, opt, elConv) : null;
            if (optMapList2 != null) {
                Intrinsics.checkNotNullExpressionValue(str, "element");
                linkedHashMap.put(str, optMapList2);
            }
        }
        return linkedHashMap;
    }
}
