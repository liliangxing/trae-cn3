package com.bytedance.sdk.xbridge.cn.platform.web;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.jsbridge.IShouldBlockJsbCallListener;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.AbsBridgeLifecycleHandler;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.BlockJsbCallAuthenticator;
import com.bytedance.sdk.xbridge.cn.auth.StandardWebAuthenticator;
import com.bytedance.sdk.xbridge.cn.auth.WebAuthVerifierWrapper;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.optimize.ThreadOptConfig;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeCallInterceptor;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeInterceptorCallback;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebBDXBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010/H\u0016J\u0018\u00100\u001a\u0004\u0018\u0001012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000203H\u0016J\r\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u00104J\u0010\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0007J\b\u00108\u001a\u000206H\u0016J(\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\u00072\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<H\u0016J\u0018\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010\u0002J\u001b\u0010A\u001a\u0002062\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0 H\u0000¢\u0006\u0002\bDJ\u001e\u0010E\u001a\u0002062\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 J\u001f\u0010G\u001a\u0002062\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0I\"\u00020\u001e¢\u0006\u0002\u0010JJ\u0010\u0010K\u001a\u00020\u00182\b\u00107\u001a\u0004\u0018\u00010\u0007J#\u0010L\u001a\u0002062\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0002032\u0006\u0010M\u001a\u00020NH\u0010¢\u0006\u0002\bOR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006P"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;", "Lcom/bytedance/sdk/xbridge/cn/protocol/BDXBridge;", "Lorg/json/JSONObject;", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "context", "Landroid/content/Context;", "containerID", "", "view", "Landroid/webkit/WebView;", "(Landroid/content/Context;Ljava/lang/String;Landroid/webkit/WebView;)V", LynxBridgeCall.NAME_SPACE, "secureDelegate", "Lcom/bytedance/ies/argus/api/ArgusWebDelegate;", "(Landroid/content/Context;Ljava/lang/String;Landroid/webkit/WebView;Ljava/lang/String;Lcom/bytedance/ies/argus/api/ArgusWebDelegate;)V", "bridgeHandler", "Lcom/bytedance/sdk/xbridge/cn/platform/web/JsonBridgeHandler;", "getBridgeHandler", "()Lcom/bytedance/sdk/xbridge/cn/platform/web/JsonBridgeHandler;", "bridgeHandler$delegate", "Lkotlin/Lazy;", "getContainerID", "()Ljava/lang/String;", "isThreadOptEnable", "", "Ljava/lang/Boolean;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "supportedProtocols", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeProtocol;", "threadOptConfig", "", "Lcom/bytedance/sdk/xbridge/cn/optimize/ThreadOptConfig;", "getView", "()Landroid/webkit/WebView;", "webAuthVerifierWrapper", "Lcom/bytedance/sdk/xbridge/cn/auth/WebAuthVerifierWrapper;", "getWebAuthVerifierWrapper", "()Lcom/bytedance/sdk/xbridge/cn/auth/WebAuthVerifierWrapper;", "webBridgeContext", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeContext;", "getWebBridgeContext", "()Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeContext;", "setWebBridgeContext", "(Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeContext;)V", "getBridgeCallInterceptor", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeCallInterceptor;", "getThreadType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "()Ljava/lang/Boolean;", "onLoadResource", "", IWeixinService.ResponseConstants.URL, "onRelease", "sendJSEvent", "eventName", "params", "", "", "sendJSEventToWeb", "name", "data", "setCustomBlockJsbCallAuthenticator", "blockJsbCallListenerList", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IShouldBlockJsbCallListener;", "setCustomBlockJsbCallAuthenticator$anniex_release", "setThreadOpt", "config", "setup", "protocols", "", "([Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeProtocol;)V", "shouldOverrideUrlLoading", "transmitJsbAuthResult", "authResult", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "transmitJsbAuthResult$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WebBDXBridge extends BDXBridge<JSONObject, JSONObject> implements JSEventDelegate {

    /* renamed from: bridgeHandler$delegate, reason: from kotlin metadata */
    private final Lazy bridgeHandler;
    private final String containerID;
    private Boolean isThreadOptEnable;
    private final ContextProviderFactory providerFactory;
    private final ArgusWebDelegate secureDelegate;
    private final CopyOnWriteArrayList<WebBridgeProtocol> supportedProtocols;
    private List<ThreadOptConfig> threadOptConfig;
    private final WebView view;
    private final WebAuthVerifierWrapper webAuthVerifierWrapper;
    private WebBridgeContext webBridgeContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebBDXBridge(Context context, String str, WebView webView, String str2, ArgusWebDelegate argusWebDelegate) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "containerID");
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str2, LynxBridgeCall.NAME_SPACE);
        this.containerID = str;
        this.view = webView;
        this.secureDelegate = argusWebDelegate;
        WebAuthVerifierWrapper webAuthVerifierWrapper = new WebAuthVerifierWrapper();
        this.webAuthVerifierWrapper = webAuthVerifierWrapper;
        this.providerFactory = ContextProviderManager.INSTANCE.getProviderFactory(str);
        BDXBridge.addAuthenticator$default(this, new StandardWebAuthenticator(webAuthVerifierWrapper), null, 2, null);
        this.webBridgeContext = new WebBridgeContext(str, webView, this, str2);
        this.supportedProtocols = new CopyOnWriteArrayList<>();
        this.bridgeHandler = LazyKt.lazy(new Function0<JsonBridgeHandler>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge$bridgeHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final JsonBridgeHandler m901invoke() {
                return new JsonBridgeHandler();
            }
        });
        this.isThreadOptEnable = false;
    }

    public /* synthetic */ WebBDXBridge(Context context, String str, WebView webView, String str2, ArgusWebDelegate argusWebDelegate, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, webView, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? null : argusWebDelegate);
    }

    public final String getContainerID() {
        return this.containerID;
    }

    public final WebView getView() {
        return this.view;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebBDXBridge(Context context, String str, WebView webView) {
        this(context, str, webView, "", null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "containerID");
        Intrinsics.checkNotNullParameter(webView, "view");
    }

    public final WebAuthVerifierWrapper getWebAuthVerifierWrapper() {
        return this.webAuthVerifierWrapper;
    }

    public final WebBridgeContext getWebBridgeContext() {
        return this.webBridgeContext;
    }

    public final void setWebBridgeContext(WebBridgeContext webBridgeContext) {
        Intrinsics.checkNotNullParameter(webBridgeContext, "<set-?>");
        this.webBridgeContext = webBridgeContext;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    /* renamed from: getBridgeHandler, reason: merged with bridge method [inline-methods] */
    public BaseBridgeHandler<JSONObject, JSONObject> getBridgeHandler2() {
        return (JsonBridgeHandler) this.bridgeHandler.getValue();
    }

    public final void setThreadOpt(boolean isThreadOptEnable, List<ThreadOptConfig> config) {
        this.isThreadOptEnable = Boolean.valueOf(isThreadOptEnable);
        this.threadOptConfig = config;
    }

    /* renamed from: isThreadOptEnable, reason: from getter */
    public final Boolean getIsThreadOptEnable() {
        return this.isThreadOptEnable;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public IDLXBridgeMethod.XBridgeThreadType getThreadType(BaseBridgeCall<JSONObject> call) {
        List<ThreadOptConfig> list;
        Intrinsics.checkNotNullParameter(call, "call");
        if (call.getIsPreInit()) {
            return IDLXBridgeMethod.XBridgeThreadType.SYNC_THREAD;
        }
        if (Intrinsics.areEqual(this.isThreadOptEnable, false) || (list = this.threadOptConfig) == null) {
            return null;
        }
        return OptimizeConfigKt.getThreadOptType(list, call);
    }

    public final void setCustomBlockJsbCallAuthenticator$anniex_release(List<? extends IShouldBlockJsbCallListener> blockJsbCallListenerList) {
        Intrinsics.checkNotNullParameter(blockJsbCallListenerList, "blockJsbCallListenerList");
        HybridLogger.i$default(HybridLogger.INSTANCE, "WebBDXBridge", "set custom block jsb call authenticator, listener: " + CollectionsKt.joinToString$default(blockJsbCallListenerList, IWeiboService.Scope.EMPTY_SCOPE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<IShouldBlockJsbCallListener, CharSequence>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge$setCustomBlockJsbCallAuthenticator$1
            public final CharSequence invoke(IShouldBlockJsbCallListener iShouldBlockJsbCallListener) {
                Intrinsics.checkNotNullParameter(iShouldBlockJsbCallListener, "it");
                return iShouldBlockJsbCallListener.name();
            }
        }, 30, (Object) null), (Map) null, (LoggerContext) null, 12, (Object) null);
        addAuthenticator(new BlockJsbCallAuthenticator(this.providerFactory, blockJsbCallListenerList), AuthPriority.HIGH);
    }

    public final void sendJSEventToWeb(String name, JSONObject data) {
        Intrinsics.checkNotNullParameter(name, "name");
        AbsBridgeLifecycleHandler bridgeLifecycle = XBridge.INSTANCE.getConfig().getBridgeLifecycle();
        if (bridgeLifecycle != null) {
            bridgeLifecycle.onSendEvent(name, data, this.webBridgeContext);
        }
        Iterator<T> it = this.supportedProtocols.iterator();
        while (it.hasNext()) {
            ((WebBridgeProtocol) it.next()).sendEvent(name, data);
        }
    }

    public final void setup(WebBridgeProtocol... protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        super.initialize(this.webBridgeContext);
        if (protocols.length == 0) {
            XBridge.log("No Web Protocol provided");
            return;
        }
        this.supportedProtocols.clear();
        CollectionsKt.addAll(this.supportedProtocols, protocols);
        for (WebBridgeProtocol webBridgeProtocol : protocols) {
            webBridgeProtocol.setup(this.view, this);
        }
    }

    public final boolean shouldOverrideUrlLoading(String url) {
        Iterator<T> it = this.supportedProtocols.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (((WebBridgeProtocol) it.next()).shouldOverrideUrlLoading(url)) {
                z = true;
            }
        }
        return z;
    }

    public final void onLoadResource(String url) {
        Iterator<T> it = this.supportedProtocols.iterator();
        while (it.hasNext()) {
            ((WebBridgeProtocol) it.next()).onLoadResource(url == null ? "" : url);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public void onRelease() {
        this.webBridgeContext.release();
        Iterator<T> it = this.supportedProtocols.iterator();
        while (it.hasNext()) {
            ((WebBridgeProtocol) it.next()).onRelease();
        }
        this.supportedProtocols.clear();
    }

    @Override // com.bytedance.sdk.xbridge.cn.service.JSEventDelegate
    public void sendJSEvent(String eventName, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ConvertUtils convertUtils = ConvertUtils.INSTANCE;
        if (params == null) {
            params = MapsKt.emptyMap();
        }
        sendJSEventToWeb(eventName, ConvertUtils.mapToJSON$default(convertUtils, params, 0, 2, null));
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public IBridgeCallInterceptor<JSONObject, JSONObject> getBridgeCallInterceptor() {
        return new IBridgeCallInterceptor<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge$getBridgeCallInterceptor$1
            @Override // com.bytedance.sdk.xbridge.cn.protocol.IBridgeCallInterceptor
            public boolean intercept(BaseBridgeCall<JSONObject> call, IBDXBridgeContext bridgeContext, IBridgeInterceptorCallback<JSONObject> callBack) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
                IBridgeCallInterceptor<Object, Object> callInterceptor = XBridge.INSTANCE.getConfig().getCallInterceptor();
                if (callInterceptor == null) {
                    return false;
                }
                Intrinsics.checkNotNull(callBack, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.IBridgeInterceptorCallback<kotlin.Any>");
                return callInterceptor.intercept(call, bridgeContext, callBack);
            }
        };
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public void transmitJsbAuthResult$anniex_release(BaseBridgeCall<JSONObject> call, AuthResult authResult) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(authResult, "authResult");
        ArgusWebDelegate argusWebDelegate = this.secureDelegate;
        if (argusWebDelegate != null) {
            argusWebDelegate.transmitJsbAuthResult(call, authResult);
        }
    }
}
