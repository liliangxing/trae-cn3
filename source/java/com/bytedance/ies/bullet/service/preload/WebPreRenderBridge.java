package com.bytedance.ies.bullet.service.preload;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.IPreRenderCallback;
import com.bytedance.ies.bullet.service.base.IPreRenderService;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.platform.thread.Constants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebPreRenderBridge.kt */
@XBridgeMethod(biz = "bullet", name = "__prerender")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J \u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020!H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/WebPreRenderBridge;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "_availDuration", "", "access", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "setAccess", "(Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;)V", "name", "", "getName", "()Ljava/lang/String;", "needCallback", "", "getNeedCallback", "()Z", "setNeedCallback", "(Z)V", "poolService", "Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "getPoolService", "()Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "poolService$delegate", "Lkotlin/Lazy;", "getContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "handle", "", "params", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$ICallback;", "makeResultJson", "result", "code", "", "message", "release", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebPreRenderBridge extends BridgeMethod implements StatefulMethod {
    public static final String DEFAULT_BRIDGE_NAME = "__prerender";
    private final long _availDuration;
    private IBridgeMethod.Access access;
    private final String name;
    private boolean needCallback;

    /* renamed from: poolService$delegate, reason: from kotlin metadata */
    private final Lazy poolService;
    private final ContextProviderFactory providerFactory;

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebPreRenderBridge(ContextProviderFactory contextProviderFactory) {
        super(contextProviderFactory);
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        this.providerFactory = contextProviderFactory;
        this.access = IBridgeMethod.Access.PRIVATE;
        this.name = "__prerender";
        this.poolService = LazyKt.lazy(new Function0<IPreRenderService>() { // from class: com.bytedance.ies.bullet.service.preload.WebPreRenderBridge$poolService$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IPreRenderService m583invoke() {
                BulletContext context;
                String str;
                context = WebPreRenderBridge.this.getContext();
                if (context == null || (str = context.getBid()) == null) {
                    str = "default_bid";
                }
                return (IPreRenderService) StandardServiceManager.INSTANCE.get(str, IPreRenderService.class);
            }
        });
        this._availDuration = Constants.TASK_WAIT_THRESHOLD;
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

    @Override // com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public boolean getNeedCallback() {
        return this.needCallback;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod
    public void setNeedCallback(boolean z) {
        this.needCallback = z;
    }

    private final IPreRenderService getPoolService() {
        return (IPreRenderService) this.poolService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BulletContext getContext() {
        IBulletContainer iBulletContainer = (IBulletContainer) this.providerFactory.provideInstance(IBulletContainer.class);
        if (iBulletContainer != null) {
            return iBulletContainer.getBulletContext();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public void handle(JSONObject params, final IBridgeMethod.ICallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String optString = params.optString("schema");
        BulletContext context = getContext();
        Context context2 = context != null ? context.getContext() : null;
        if (context2 == null) {
            callback.onComplete(makeResultJson(false, -1, "context is null"));
            return;
        }
        Uri parse = Uri.parse(optString);
        IPreRenderService poolService = getPoolService();
        if (poolService != null) {
            Intrinsics.checkNotNullExpressionValue(parse, "originUri");
            poolService.preRender(parse, context2, this._availDuration, new IPreRenderCallback() { // from class: com.bytedance.ies.bullet.service.preload.WebPreRenderBridge$handle$2
                @Override // com.bytedance.ies.bullet.service.base.IPreRenderCallback
                public void onSuccess(String sessionId) {
                    JSONObject makeResultJson;
                    Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                    makeResultJson = WebPreRenderBridge.this.makeResultJson(true, 0, "succeed");
                    callback.onComplete(makeResultJson);
                }

                @Override // com.bytedance.ies.bullet.service.base.IPreRenderCallback
                public void onFailed(PoolResult result, String errorMsg) {
                    JSONObject makeResultJson;
                    Intrinsics.checkNotNullParameter(result, "result");
                    makeResultJson = WebPreRenderBridge.this.makeResultJson(false, -2, "load failed");
                    callback.onComplete(makeResultJson);
                }
            });
        }
        if (getPoolService() == null) {
            callback.onComplete(makeResultJson(false, -3, "poolService is null"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject makeResultJson(boolean result, int code, String message) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("__status_message__", message);
        jSONObject2.put("container", "BulletX");
        jSONObject2.put("result", result);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("data", jSONObject2);
        return jSONObject;
    }
}
