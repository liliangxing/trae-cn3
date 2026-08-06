package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.lynx.react.bridge.PiperData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PiperDataProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nB\u0007\b\u0002¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0007R\"\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR>\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/PiperDataProxy;", "", "map", "", "", "(Ljava/util/Map;)V", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "str", "(Ljava/lang/String;)V", "()V", "<set-?>", "innerJson", "getInnerJson", "()Lorg/json/JSONObject;", "innerMap", "getInnerMap", "()Ljava/util/Map;", "innerString", "getInnerString", "()Ljava/lang/String;", "piperData", "Lcom/lynx/react/bridge/PiperData;", "getPiperData", "()Lcom/lynx/react/bridge/PiperData;", "setPiperData", "(Lcom/lynx/react/bridge/PiperData;)V", "getValue", "key", "toJsonObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class PiperDataProxy {
    private JSONObject innerJson;
    private Map<String, ? extends Object> innerMap;
    private String innerString;
    public PiperData piperData;

    private PiperDataProxy() {
    }

    public final PiperData getPiperData() {
        PiperData piperData = this.piperData;
        if (piperData != null) {
            return piperData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("piperData");
        return null;
    }

    public final void setPiperData(PiperData piperData) {
        Intrinsics.checkNotNullParameter(piperData, "<set-?>");
        this.piperData = piperData;
    }

    public final Map<String, Object> getInnerMap() {
        return this.innerMap;
    }

    public final JSONObject getInnerJson() {
        return this.innerJson;
    }

    public final String getInnerString() {
        return this.innerString;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PiperDataProxy(Map<String, ? extends Object> map) {
        this();
        Intrinsics.checkNotNullParameter(map, "map");
        PiperData createDisposableFromObject = PiperData.createDisposableFromObject(map);
        Intrinsics.checkNotNullExpressionValue(createDisposableFromObject, "createDisposableFromObject(map)");
        setPiperData(createDisposableFromObject);
        this.innerMap = map;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PiperDataProxy(JSONObject obj) {
        this();
        Intrinsics.checkNotNullParameter(obj, "obj");
        PiperData createDisposableFromObject = PiperData.createDisposableFromObject(obj);
        Intrinsics.checkNotNullExpressionValue(createDisposableFromObject, "createDisposableFromObject(obj)");
        setPiperData(createDisposableFromObject);
        this.innerJson = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PiperDataProxy(String str) {
        this();
        Intrinsics.checkNotNullParameter(str, "str");
        PiperData createDisposableFromString = PiperData.createDisposableFromString(str);
        Intrinsics.checkNotNullExpressionValue(createDisposableFromString, "createDisposableFromString(str)");
        setPiperData(createDisposableFromString);
        this.innerString = str;
    }

    public final Object getValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, ? extends Object> map = this.innerMap;
        if (map != null) {
            if (map != null) {
                return map.get(key);
            }
            return null;
        }
        JSONObject jSONObject = this.innerJson;
        if (jSONObject == null || jSONObject == null) {
            return null;
        }
        return jSONObject.opt(key);
    }

    public final JSONObject toJsonObject() {
        if (this.innerMap != null) {
            return new JSONObject(this.innerMap);
        }
        JSONObject jSONObject = this.innerJson;
        if (jSONObject == null) {
            return this.innerString != null ? new JSONObject(this.innerString) : new JSONObject();
        }
        Intrinsics.checkNotNull(jSONObject);
        return jSONObject;
    }
}
