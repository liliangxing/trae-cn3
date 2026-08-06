package com.bytedance.ies.xbridge.platform.web.inner;

import com.bytedance.ies.xbridge.exception.IllegalOperationException;
import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.bytedance.ies.xbridge.model.idl.XDynamicType;
import com.bytedance.ies.xbridge.platform.web.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: IDLXDynamicImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/xbridge/platform/web/inner/IDLXDynamicImpl;", "Lcom/bytedance/ies/xbridge/model/idl/IDLXDynamic;", "value", "", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "asArray", "", "asBoolean", "", "asByteArray", "", "asDouble", "", "asInt", "", "asLong", "", "asMap", "", "", "asString", "getType", "Lcom/bytedance/ies/xbridge/model/idl/XDynamicType;", "isNull", "recycle", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLXDynamicImpl implements IDLXDynamic {
    private final Object value;

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public void recycle() {
    }

    public IDLXDynamicImpl(Object obj) {
        this.value = obj;
    }

    public final Object getValue() {
        return this.value;
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public boolean isNull() {
        return this.value == null;
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public boolean asBoolean() {
        Object obj = this.value;
        if (obj instanceof Boolean) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) obj).booleanValue();
        }
        throw new IllegalOperationException("");
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public double asDouble() {
        Object obj = this.value;
        if (obj instanceof Double) {
            return ((Number) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return ((Number) obj).floatValue();
        }
        if (obj instanceof Long) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        throw new IllegalOperationException("");
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public int asInt() {
        Object obj = this.value;
        if (obj instanceof Double) {
            return (int) ((Number) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return (int) ((Number) obj).floatValue();
        }
        if (obj instanceof Long) {
            return (int) ((Number) obj).longValue();
        }
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        throw new IllegalOperationException("");
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public long asLong() {
        Object obj = this.value;
        if (obj instanceof Double) {
            return (long) ((Number) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return ((Number) obj).floatValue();
        }
        if (obj instanceof Long) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        throw new IllegalOperationException("");
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public String asString() {
        Object obj = this.value;
        if (obj instanceof String) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return (String) obj;
        }
        throw new IllegalOperationException("");
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public List<Object> asArray() {
        if (this.value instanceof JSONArray) {
            List<Object> jsonToList = Utils.INSTANCE.jsonToList((JSONArray) this.value);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = jsonToList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        throw new IllegalOperationException("");
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public Map<String, Object> asMap() {
        if (this.value instanceof JSONObject) {
            Map<String, Object> jsonToMap = Utils.INSTANCE.jsonToMap((JSONObject) this.value);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : jsonToMap.entrySet()) {
                if (((JSONObject) this.value).get(entry.getKey()) != null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
        throw new IllegalOperationException("");
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public byte[] asByteArray() {
        throw new IllegalOperationException("");
    }

    @Override // com.bytedance.ies.xbridge.model.idl.IDLXDynamic
    public XDynamicType getType() {
        Object obj = this.value;
        if (obj instanceof JSONArray) {
            return XDynamicType.Array;
        }
        if (obj instanceof Boolean) {
            return XDynamicType.Boolean;
        }
        if (obj instanceof JSONObject) {
            return XDynamicType.Map;
        }
        if (obj instanceof Integer) {
            return XDynamicType.Int;
        }
        if (obj instanceof Long) {
            return XDynamicType.Long;
        }
        if (obj instanceof String) {
            return XDynamicType.String;
        }
        if (!(obj instanceof Double) && !(obj instanceof Float)) {
            return XDynamicType.Null;
        }
        return XDynamicType.Number;
    }
}
