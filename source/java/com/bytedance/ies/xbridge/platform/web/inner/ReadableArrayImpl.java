package com.bytedance.ies.xbridge.platform.web.inner;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.xbridge.XDynamic;
import com.bytedance.ies.xbridge.XReadableArray;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.platform.web.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XCollections.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/xbridge/platform/web/inner/ReadableArrayImpl;", "Lcom/bytedance/ies/xbridge/XReadableArray;", "origin", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)V", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/xbridge/XDynamic;", "index", "", "getArray", "getBoolean", "", "getDouble", "", "getInt", "getMap", "Lcom/bytedance/ies/xbridge/XReadableMap;", "getString", "", "getType", "Lcom/bytedance/ies/xbridge/XReadableType;", "isNull", "size", "toList", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ReadableArrayImpl implements XReadableArray {
    private final JSONArray origin;

    public ReadableArrayImpl(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "origin");
        this.origin = jSONArray;
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public int size() {
        return this.origin.length();
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public boolean isNull(int index) {
        return this.origin.isNull(index);
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public boolean getBoolean(int index) {
        return this.origin.optBoolean(index);
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public double getDouble(int index) {
        return this.origin.optDouble(index);
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public int getInt(int index) {
        return this.origin.optInt(index);
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public String getString(int index) {
        String optString = this.origin.optString(index);
        Intrinsics.checkNotNullExpressionValue(optString, "origin.optString(index)");
        return optString;
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public XReadableArray getArray(int index) {
        JSONArray optJSONArray = this.origin.optJSONArray(index);
        if (optJSONArray == null) {
            return null;
        }
        return new ReadableArrayImpl(optJSONArray);
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public XReadableMap getMap(int index) {
        JSONObject optJSONObject = this.origin.optJSONObject(index);
        if (optJSONObject == null) {
            return null;
        }
        return new ReadableMapImpl(optJSONObject);
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public XDynamic get(int index) {
        return new DynamicImpl(this.origin.opt(index));
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public XReadableType getType(int index) {
        Object opt = this.origin.opt(index);
        return opt instanceof JSONArray ? XReadableType.Array : opt instanceof Boolean ? XReadableType.Boolean : opt instanceof JSONObject ? XReadableType.Map : opt instanceof Integer ? XReadableType.Int : opt instanceof Number ? XReadableType.Number : opt instanceof String ? XReadableType.String : XReadableType.Null;
    }

    @Override // com.bytedance.ies.xbridge.XReadableArray
    public List<Object> toList() {
        return Utils.INSTANCE.jsonToList(this.origin);
    }
}
