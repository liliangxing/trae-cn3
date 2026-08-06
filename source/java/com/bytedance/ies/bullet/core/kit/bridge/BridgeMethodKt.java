package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u001a6\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f¨\u0006\u0010"}, d2 = {"makeCodedData", "Lorg/json/JSONObject;", "code", "", "msg", "", "data", "actualHandle", "", "INPUT", "OUTPUT", "Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod;", "params", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod$ICallback;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BridgeMethodKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <INPUT, OUTPUT> void actualHandle(IIDLGenericBridgeMethod<INPUT, OUTPUT> iIDLGenericBridgeMethod, Object params, final IIDLGenericBridgeMethod.ICallback<?> callback) {
        Intrinsics.checkNotNullParameter(iIDLGenericBridgeMethod, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (callback != null) {
            iIDLGenericBridgeMethod.handle(params, iIDLGenericBridgeMethod.createCallbackProxy(new IIDLGenericBridgeMethod.ICallback<OUTPUT>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeMethodKt$actualHandle$2$1
                @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                public void onComplete(OUTPUT data) {
                    IIDLGenericBridgeMethod.ICallback<Object> iCallback = callback;
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.Any");
                    iCallback.onComplete(data);
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                public void onError(int code, String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    callback.onError(code, message);
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                public void onError(int code, String message, OUTPUT data) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    IIDLGenericBridgeMethod.ICallback<Object> iCallback = callback;
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.Any");
                    iCallback.onError(code, message, data);
                }
            }));
        }
    }

    public static /* synthetic */ JSONObject makeCodedData$default(int i, String str, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            jSONObject = null;
        }
        return makeCodedData(i, str, jSONObject);
    }

    public static final JSONObject makeCodedData(int i, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("code", i);
        if (str != null) {
            jSONObject2.put("msg", str);
        }
        if (jSONObject != null) {
            jSONObject2.put("data", jSONObject);
        }
        return jSONObject2;
    }
}
