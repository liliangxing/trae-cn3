package com.bytedance.ies.xbridge.model.collections.defaultimpl;

import com.bytedance.ies.xbridge.XDynamic;
import com.bytedance.ies.xbridge.XReadableArray;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DefaultXReadableMapImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/xbridge/model/collections/defaultimpl/DefaultDynamicImpl;", "Lcom/bytedance/ies/xbridge/XDynamic;", "origin", "", "(Ljava/lang/Object;)V", "asArray", "Lcom/bytedance/ies/xbridge/XReadableArray;", "asBoolean", "", "asDouble", "", "asInt", "", "asMap", "Lcom/bytedance/ies/xbridge/XReadableMap;", "asString", "", "getType", "Lcom/bytedance/ies/xbridge/XReadableType;", "isNull", "recycle", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultDynamicImpl implements XDynamic {
    private final Object origin;

    @Override // com.bytedance.ies.xbridge.XDynamic
    public void recycle() {
    }

    public DefaultDynamicImpl(Object obj) {
        this.origin = obj;
    }

    @Override // com.bytedance.ies.xbridge.XDynamic
    public boolean isNull() {
        return this.origin == null;
    }

    @Override // com.bytedance.ies.xbridge.XDynamic
    public XReadableType getType() {
        Object obj = this.origin;
        return obj instanceof JSONArray ? XReadableType.Array : obj instanceof Boolean ? XReadableType.Boolean : obj instanceof JSONObject ? XReadableType.Map : obj instanceof Integer ? XReadableType.Int : obj instanceof Number ? XReadableType.Number : obj instanceof String ? XReadableType.String : XReadableType.Null;
    }

    @Override // com.bytedance.ies.xbridge.XDynamic
    public boolean asBoolean() {
        Object obj = this.origin;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        throw new IllegalArgumentException("Dynamic is not Boolean");
    }

    @Override // com.bytedance.ies.xbridge.XDynamic
    public double asDouble() {
        Object obj = this.origin;
        if (obj instanceof Double) {
            return ((Number) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Number) obj).floatValue();
        }
        if (obj instanceof Long) {
            return ((Number) obj).longValue();
        }
        throw new IllegalArgumentException("Dynamic is not Double");
    }

    @Override // com.bytedance.ies.xbridge.XDynamic
    public int asInt() {
        Object obj = this.origin;
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        throw new IllegalArgumentException("Dynamic is not Int");
    }

    @Override // com.bytedance.ies.xbridge.XDynamic
    public String asString() {
        Object obj = this.origin;
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new IllegalArgumentException("Dynamic is not String");
    }

    @Override // com.bytedance.ies.xbridge.XDynamic
    public XReadableArray asArray() {
        if (this.origin instanceof JSONArray) {
            return new DefaultXReadableArrayImpl((JSONArray) this.origin);
        }
        throw new IllegalArgumentException("Dynamic is not JSONArray");
    }

    @Override // com.bytedance.ies.xbridge.XDynamic
    public XReadableMap asMap() {
        if (this.origin instanceof JSONObject) {
            return new DefaultXReadableMapImpl((JSONObject) this.origin);
        }
        throw new IllegalArgumentException("Dynamic is not JSONObject");
    }
}
