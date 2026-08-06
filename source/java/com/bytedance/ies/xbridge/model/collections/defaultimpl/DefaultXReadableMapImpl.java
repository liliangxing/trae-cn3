package com.bytedance.ies.xbridge.model.collections.defaultimpl;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.xbridge.XDynamic;
import com.bytedance.ies.xbridge.XKeyIterator;
import com.bytedance.ies.xbridge.XReadableArray;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.utils.JsonUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DefaultXReadableMapImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/xbridge/model/collections/defaultimpl/DefaultXReadableMapImpl;", "Lcom/bytedance/ies/xbridge/XReadableMap;", "origin", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/xbridge/XDynamic;", "name", "", "getArray", "Lcom/bytedance/ies/xbridge/XReadableArray;", "getBoolean", "", "getDouble", "", "getInt", "", "getMap", "getString", "getType", "Lcom/bytedance/ies/xbridge/XReadableType;", "hasKey", "isNull", "keyIterator", "Lcom/bytedance/ies/xbridge/XKeyIterator;", "toMap", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultXReadableMapImpl implements XReadableMap {
    private final JSONObject origin;

    public DefaultXReadableMapImpl(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "origin");
        this.origin = jSONObject;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public boolean hasKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.origin.has(name);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public boolean isNull(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.origin.isNull(name);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public boolean getBoolean(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.origin.optBoolean(name);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public double getDouble(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.origin.optDouble(name);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public int getInt(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.origin.optInt(name);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public String getString(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String optString = this.origin.optString(name);
        Intrinsics.checkNotNullExpressionValue(optString, "origin.optString(name)");
        return optString;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XReadableArray getArray(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optJSONArray = this.origin.optJSONArray(name);
        if (optJSONArray == null) {
            optJSONArray = this.origin.opt(name);
        }
        if (optJSONArray == null) {
            return null;
        }
        if (optJSONArray instanceof JSONArray) {
            return new DefaultXReadableArrayImpl((JSONArray) optJSONArray);
        }
        if (optJSONArray instanceof List) {
            return new DefaultXReadableArrayImpl(JsonUtils.INSTANCE.listToJSON((List) optJSONArray));
        }
        return null;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XReadableMap getMap(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optJSONObject = this.origin.optJSONObject(name);
        if (optJSONObject == null) {
            optJSONObject = this.origin.opt(name);
        }
        if (optJSONObject == null) {
            return null;
        }
        if (optJSONObject instanceof JSONObject) {
            return new DefaultXReadableMapImpl((JSONObject) optJSONObject);
        }
        if (optJSONObject instanceof Map) {
            return new DefaultXReadableMapImpl(JsonUtils.INSTANCE.mapToJSON((Map) optJSONObject));
        }
        return null;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XDynamic get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DefaultDynamicImpl(this.origin.opt(name));
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XReadableType getType(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object opt = this.origin.opt(name);
        if (opt instanceof JSONArray ? true : opt instanceof List) {
            return XReadableType.Array;
        }
        if (opt instanceof Boolean) {
            return XReadableType.Boolean;
        }
        return opt instanceof JSONObject ? true : opt instanceof Map ? XReadableType.Map : opt instanceof Integer ? XReadableType.Int : opt instanceof Number ? XReadableType.Number : opt instanceof String ? XReadableType.String : XReadableType.Null;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XKeyIterator keyIterator() {
        Iterator<String> keys = this.origin.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "origin.keys()");
        return new DefaultXKeyIteratorImpl(keys);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public Map<String, Object> toMap() {
        return DefaultXReadableMapUtils.INSTANCE.jsonToMap(this.origin);
    }
}
