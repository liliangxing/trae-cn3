package com.bytedance.ies.bullet.base.service;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GetBridgeListBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/base/service/GetBridgeListBridge;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "name", "", "getName", "()Ljava/lang/String;", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "handle", "", "params", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$ICallback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GetBridgeListBridge extends BridgeMethod implements StatefulMethod {
    private final String name;
    private final ContextProviderFactory providerFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBridgeListBridge(ContextProviderFactory contextProviderFactory) {
        super(contextProviderFactory);
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        this.providerFactory = contextProviderFactory;
        this.name = "getBridgeList";
    }

    public final ContextProviderFactory getProviderFactory() {
        return this.providerFactory;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public void handle(JSONObject params, IBridgeMethod.ICallback callback) {
        Unit unit;
        Map<String, IGenericBridgeMethod> bridges;
        Set<Map.Entry<String, IGenericBridgeMethod>> entrySet;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BulletContext bulletContext = (BulletContext) this.providerFactory.provideInstance(BulletContext.class);
        if (bulletContext != null) {
            JSONArray jSONArray = new JSONArray();
            IBridgeRegistry bridgeRegistry = bulletContext.getBridgeRegistry();
            if (bridgeRegistry != null && (bridges = bridgeRegistry.getBridges()) != null && (entrySet = bridges.entrySet()) != null) {
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", entry.getKey());
                    jSONObject.put("impl", entry.getValue().getClass().getName());
                    jSONArray.put(jSONObject);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", jSONArray);
            callback.onComplete(jSONObject2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.onError(0, "bullet context empty");
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public String getName() {
        return this.name;
    }
}
