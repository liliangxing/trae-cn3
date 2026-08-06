package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.ies.xbridge.platform.web.WebPlatformDataProcessor;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IDLBridgeTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J.\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/bullet/base/bridge/XBridge2ToXBridge3;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "method", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "(Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;)V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "compatibility", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "getCompatibility", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "getMethod", "()Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "name", "", "getName", "()Ljava/lang/String;", "canRunInBackground", "", "realHandle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "", "", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Callback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class XBridge2ToXBridge3 implements IDLXBridgeMethod {
    private final com.bytedance.ies.xbridge.IDLXBridgeMethod method;

    public XBridge2ToXBridge3(com.bytedance.ies.xbridge.IDLXBridgeMethod iDLXBridgeMethod) {
        Intrinsics.checkNotNullParameter(iDLXBridgeMethod, "method");
        this.method = iDLXBridgeMethod;
    }

    public final com.bytedance.ies.xbridge.IDLXBridgeMethod getMethod() {
        return this.method;
    }

    public String getName() {
        return this.method.getName();
    }

    public IDLXBridgeMethod.Access getAccess() {
        IDLXBridgeMethod.Access xbridge2PermissionAdapt = IDLBridgeTransformerKt.xbridge2PermissionAdapt(this.method.getAccess());
        return xbridge2PermissionAdapt == null ? IDLXBridgeMethod.DefaultImpls.getAccess(this) : xbridge2PermissionAdapt;
    }

    public IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.Compatible;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void realHandle(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> params, final IDLXBridgeMethod.Callback callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map<String, ? extends Object> transformPlatformDataToMap = new WebPlatformDataProcessor().transformPlatformDataToMap(new JSONObject(params), this.method.getClass());
        if (transformPlatformDataToMap == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("code", 0);
            linkedHashMap.put("msg", "XBridge2 IDL 数据转换失败");
            callback.invoke(linkedHashMap);
            return;
        }
        this.method.realHandle(transformPlatformDataToMap, new IDLXBridgeMethod.Callback() { // from class: com.bytedance.ies.bullet.base.bridge.XBridge2ToXBridge3$realHandle$2
            @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.Callback
            public void invoke(Map<String, ? extends Object> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                callback.invoke(data);
            }
        }, IDLBridgeTransformerKt.getPlatformType(bridgeContext));
    }

    public boolean canRunInBackground() {
        com.bytedance.ies.xbridge.IDLXBridgeMethod iDLXBridgeMethod = this.method;
        if (iDLXBridgeMethod instanceof XCoreIDLBridgeMethod) {
            return ((XCoreIDLBridgeMethod) iDLXBridgeMethod).canRunInBackground();
        }
        return false;
    }
}
