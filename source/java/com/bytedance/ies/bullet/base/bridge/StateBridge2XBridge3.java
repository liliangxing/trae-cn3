package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.core.kit.bridge.JSB2BridgeMethod;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.bridge.IStateBridgeMethod;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IDLBridgeTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J.\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/bullet/base/bridge/StateBridge2XBridge3;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "method", "Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod;", "(Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod;)V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "compatibility", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "getCompatibility", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "getMethod", "()Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod;", "name", "", "getName", "()Ljava/lang/String;", "canRunInBackground", "", "realHandle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "", "", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Callback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class StateBridge2XBridge3 implements IDLXBridgeMethod {
    private final IStateBridgeMethod method;

    public StateBridge2XBridge3(IStateBridgeMethod iStateBridgeMethod) {
        Intrinsics.checkNotNullParameter(iStateBridgeMethod, "method");
        this.method = iStateBridgeMethod;
    }

    public final IStateBridgeMethod getMethod() {
        return this.method;
    }

    public String getName() {
        return this.method.getName();
    }

    public IDLXBridgeMethod.Access getAccess() {
        IDLXBridgeMethod.Access bulletPermissionAdapt = IDLBridgeTransformerKt.bulletPermissionAdapt(this.method.getAccess());
        return bulletPermissionAdapt == null ? IDLXBridgeMethod.DefaultImpls.getAccess(this) : bulletPermissionAdapt;
    }

    public IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.Compatible;
    }

    public void realHandle(final IBDXBridgeContext bridgeContext, Map<String, ? extends Object> params, final IDLXBridgeMethod.Callback callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            this.method.handle(ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, params, 0, 2, (Object) null), new IStateBridgeMethod.ICallback() { // from class: com.bytedance.ies.bullet.base.bridge.StateBridge2XBridge3$realHandle$1
                @Override // com.bytedance.ies.bullet.service.base.bridge.IStateBridgeMethod.ICallback
                public void finishCall(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    IDLXBridgeMethod.Callback callback2 = callback;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("__jsb2__data__", new JSONObject(value));
                    callback2.invoke(linkedHashMap);
                }

                @Override // com.bytedance.ies.bullet.service.base.bridge.IStateBridgeMethod.ICallback
                public void finishCall(JSONObject value) {
                    if (value != null) {
                        IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                        IDLXBridgeMethod.Callback callback2 = callback;
                        if (IConditionCallKt.enableAnnieXIgnoreJSB2Failure()) {
                            iBDXBridgeContext.getBridgeCall().setIgnoreJSBError(value.remove("ignoreJSB2Error") != null);
                        }
                        if (iBDXBridgeContext.getPlatformType() == PlatformType.LYNX) {
                            Object remove = value.remove("code");
                            value.remove("__data");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("data", value);
                            jSONObject.put("__msg_type", "callback");
                            String optString = value.optString("__callback_id", ViewVisibleBridge.INVISIBLE);
                            Intrinsics.checkNotNullExpressionValue(optString, "_value.optString(\"__callback_id\", \"0\")");
                            jSONObject.put("eventId", Long.parseLong(optString));
                            jSONObject.put("__callback_id", ViewVisibleBridge.INVISIBLE);
                            jSONObject.put("code", remove);
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("__jsb2__data__", jSONObject);
                            callback2.invoke(linkedHashMap);
                        } else {
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            linkedHashMap2.put("__jsb2__data__", value);
                            callback2.invoke(linkedHashMap2);
                        }
                    }
                    if (value == null) {
                        IDLXBridgeMethod.Callback callback3 = callback;
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        linkedHashMap3.put("__jsb2__data__", new JSONObject());
                        callback3.invoke(linkedHashMap3);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public boolean canRunInBackground() {
        IStateBridgeMethod iStateBridgeMethod = this.method;
        if (iStateBridgeMethod instanceof JSB2BridgeMethod) {
            return ((JSB2BridgeMethod) iStateBridgeMethod).canRunInBackground();
        }
        return false;
    }
}
