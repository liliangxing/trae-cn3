package com.bytedance.ies.bullet.service.monitor.tracert;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletMonitorContext;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BulletSetTracertBridge.kt */
@XBridgeMethod(name = BulletSetTracertBridge.DEFAULT_BRIDGE_NAME, owner = "liushaocong")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/tracert/BulletSetTracertBridge;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "access", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "setAccess", "(Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;)V", "name", "", "getName", "()Ljava/lang/String;", "getContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "handle", "", "params", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$ICallback;", "makeResultJson", "code", "", "release", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletSetTracertBridge extends BridgeMethod implements StatefulMethod {
    public static final String DEFAULT_BRIDGE_NAME = "bullet.setTracert";
    private IBridgeMethod.Access access;
    private final String name;
    private final ContextProviderFactory providerFactory;

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BulletSetTracertBridge(ContextProviderFactory contextProviderFactory) {
        super(contextProviderFactory);
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        this.providerFactory = contextProviderFactory;
        this.name = DEFAULT_BRIDGE_NAME;
        this.access = IBridgeMethod.Access.PRIVATE;
    }

    private final BulletContext getContext() {
        IBulletContainer iBulletContainer = (IBulletContainer) this.providerFactory.provideInstance(IBulletContainer.class);
        if (iBulletContainer != null) {
            return iBulletContainer.getBulletContext();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public IBridgeMethod.Access getAccess() {
        return this.access;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod
    public void setAccess(IBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "<set-?>");
        this.access = access;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public void handle(JSONObject params, IBridgeMethod.ICallback callback) {
        BulletMonitorContext monitorContext;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BulletContext context = getContext();
        if ((context != null ? context.getSessionId() : null) == null) {
            callback.onError(-1, "no sessionId");
            return;
        }
        Object opt = params.opt("categoryDict");
        JSONObject jSONObject = opt instanceof JSONObject ? (JSONObject) opt : null;
        Object opt2 = params.opt("timelineDict");
        JSONObject jSONObject2 = opt2 instanceof JSONObject ? (JSONObject) opt2 : null;
        BulletContext context2 = getContext();
        if ((context2 == null || (monitorContext = context2.getMonitorContext()) == null) ? false : monitorContext.inject(jSONObject, jSONObject2)) {
            callback.onComplete(makeResultJson(1));
        } else {
            callback.onComplete(makeResultJson(2));
        }
    }

    private final JSONObject makeResultJson(int code) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        return jSONObject;
    }
}
