package com.bytedance.sdk.xbridge.cn.platform.web;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompatKt;
import com.bytedance.android.monitorV2.entity.JSBError;
import com.bytedance.android.monitorV2.entity.JSBInfo;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.SLInfoCategory;
import com.bytedance.salamander.anniex.SLInfoPerf;
import com.bytedance.salamander.anniex.SLJSBErrorEventInfo;
import com.bytedance.salamander.anniex.SLJSBPerfEventInfo;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType;
import com.bytedance.sdk.xbridge.cn.protocol.auth.ISafeAuthWebView;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMonitorHelper;
import com.bytedance.tracing.log.Fields;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebBridgeProtocol.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u0000 I2\u00020\u0001:\u0001IB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003H&J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H&J \u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00032\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000104J \u00105\u001a\u0002012\u0006\u00102\u001a\u00020\u00032\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000104H\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u00107\u001a\u00020(J\b\u00108\u001a\u0004\u0018\u00010\u0003J\u0010\u00109\u001a\u0002012\b\u0010+\u001a\u0004\u0018\u00010\u0003J\u0012\u0010:\u001a\u0002012\b\u0010+\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010;\u001a\u0002012\u0006\u00102\u001a\u00020\u0003H\u0016J\b\u0010<\u001a\u000201H\u0016J\u0010\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020 H&J\u0018\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u0010A\u001a\u000201J\u001a\u0010B\u001a\u0002012\u0006\u0010C\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010/H&J\u0016\u0010D\u001a\u0002012\u0006\u0010>\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010E\u001a\u00020\u00152\u0006\u0010@\u001a\u00020*H\u0002J\u0012\u0010F\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u00010\u0003H\u0016J\u0015\u0010G\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bHR\u001a\u0010\u0005\u001a\u00020\u0006X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006J"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeProtocol;", "", LynxBridgeCall.NAME_SPACE, "", "(Ljava/lang/String;)V", "bdxBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;", "getBdxBridge$anniex_release", "()Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;", "setBdxBridge$anniex_release", "(Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;)V", "bridgeHandler", "Lcom/bytedance/sdk/xbridge/cn/platform/web/JsonBridgeHandler;", "getBridgeHandler$anniex_release", "()Lcom/bytedance/sdk/xbridge/cn/platform/web/JsonBridgeHandler;", "bridgeHandler$delegate", "Lkotlin/Lazy;", "defaultNameSpace", "getDefaultNameSpace$anniex_release", "()Ljava/lang/String;", "hasReleased", "", "getHasReleased", "()Z", "setHasReleased", "(Z)V", "jsbAuthUrlFromV1", "jsbAuthUrlSource", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthUrlSourceType;", "mainHandler", "Landroid/os/Handler;", "webView", "Landroid/webkit/WebView;", "getWebView$anniex_release", "()Landroid/webkit/WebView;", "setWebView$anniex_release", "(Landroid/webkit/WebView;)V", "composeErrorMessage", "message", "code", "", "createBridgeCall", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeCall;", "invocation", "createCallbackMessage", "call", "data", "Lorg/json/JSONObject;", "evaluateJavaScript", "", IWeixinService.ResponseConstants.URL, "callback", "Landroid/webkit/ValueCallback;", "evaluateJavaScriptInternal", "getSafeAuthUrl", "getWebAuthUrlType", "getWebViewUrlSync", "handleJSMessage", "handleJSMessageInternal", "onLoadResource", "onRelease", "onSetUp", "view", "reportToMonitor", "bridgeCall", "safeSetV1AuthUrl", "sendEvent", Fields.EVENT, "setup", "shouldIgnoreJsbError", "shouldOverrideUrlLoading", "wrapHostNamespace", "wrapHostNamespace$anniex_release", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class WebBridgeProtocol {
    private static final String EMPTY_JSON = "{}";
    public WebBDXBridge bdxBridge;

    /* renamed from: bridgeHandler$delegate, reason: from kotlin metadata */
    private final Lazy bridgeHandler;
    private final String defaultNameSpace;
    private volatile boolean hasReleased;
    private String jsbAuthUrlFromV1;
    private AuthUrlSourceType jsbAuthUrlSource;
    private final Handler mainHandler;
    public WebView webView;

    public abstract WebBridgeCall createBridgeCall(String invocation);

    public abstract String createCallbackMessage(WebBridgeCall call, JSONObject data);

    public void onLoadResource(String url) {
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
    }

    public abstract void onSetUp(WebView view);

    public abstract void sendEvent(String event, JSONObject data);

    public boolean shouldOverrideUrlLoading(String url) {
        return false;
    }

    public WebBridgeProtocol(String str) {
        Intrinsics.checkNotNullParameter(str, LynxBridgeCall.NAME_SPACE);
        this.bridgeHandler = LazyKt.lazy(new Function0<JsonBridgeHandler>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol$bridgeHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final JsonBridgeHandler m902invoke() {
                return new JsonBridgeHandler();
            }
        });
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.defaultNameSpace = str;
        this.jsbAuthUrlSource = AuthUrlSourceType.DisableSafeAuthInXBridge3;
    }

    public final JsonBridgeHandler getBridgeHandler$anniex_release() {
        return (JsonBridgeHandler) this.bridgeHandler.getValue();
    }

    public final WebView getWebView$anniex_release() {
        WebView webView = this.webView;
        if (webView != null) {
            return webView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webView");
        return null;
    }

    public final void setWebView$anniex_release(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<set-?>");
        this.webView = webView;
    }

    public final WebBDXBridge getBdxBridge$anniex_release() {
        WebBDXBridge webBDXBridge = this.bdxBridge;
        if (webBDXBridge != null) {
            return webBDXBridge;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bdxBridge");
        return null;
    }

    public final void setBdxBridge$anniex_release(WebBDXBridge webBDXBridge) {
        Intrinsics.checkNotNullParameter(webBDXBridge, "<set-?>");
        this.bdxBridge = webBDXBridge;
    }

    public final boolean getHasReleased() {
        return this.hasReleased;
    }

    public final void setHasReleased(boolean z) {
        this.hasReleased = z;
    }

    /* renamed from: getDefaultNameSpace$anniex_release, reason: from getter */
    public final String getDefaultNameSpace() {
        return this.defaultNameSpace;
    }

    public final String wrapHostNamespace$anniex_release(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        return Intrinsics.areEqual(PermissionConfigParser.WEBCAST_HOST_NAMESPACE, namespace) ? "" : namespace;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void evaluateJavaScript$default(WebBridgeProtocol webBridgeProtocol, String str, ValueCallback valueCallback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: evaluateJavaScript");
        }
        if ((i & 2) != 0) {
            valueCallback = null;
        }
        webBridgeProtocol.evaluateJavaScript(str, valueCallback);
    }

    public final void evaluateJavaScript(final String url, final ValueCallback<String> callback) {
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            evaluateJavaScriptInternal(url, callback);
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol$evaluateJavaScript$1
                @Override // java.lang.Runnable
                public final void run() {
                    WebBridgeProtocol.this.evaluateJavaScriptInternal(url, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void evaluateJavaScriptInternal(String url, ValueCallback<String> callback) {
        if (this.hasReleased) {
            XBridge.log("webview已销毁，evaluateJavaScriptInternal未执行，url: " + url);
            return;
        }
        if (this.webView == null) {
            XBridge.log("webview对象未初始化，evaluateJavaScriptInternal未执行");
            return;
        }
        try {
            getWebView$anniex_release().evaluateJavascript(url, callback);
        } catch (Throwable th) {
            XBridge.log("webview.evaluateJavascript失败：" + th.getMessage());
        }
    }

    public final void setup(WebView view, WebBDXBridge bdxBridge) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(bdxBridge, "bdxBridge");
        setWebView$anniex_release(view);
        setBdxBridge$anniex_release(bdxBridge);
        onSetUp(view);
    }

    public final void handleJSMessage(final String invocation) {
        if (this.hasReleased) {
            XBridge.log("webview已销毁，handleJSMessage未执行");
        } else if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            handleJSMessageInternal(invocation);
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol$handleJSMessage$1
                @Override // java.lang.Runnable
                public final void run() {
                    WebBridgeProtocol.this.handleJSMessageInternal(invocation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleJSMessageInternal(String invocation) {
        final WebBridgeCall createBridgeCall = createBridgeCall(invocation == null ? EMPTY_JSON : invocation);
        BridgeResultCallback<JSONObject> bridgeResultCallback = new BridgeResultCallback<JSONObject>(this) { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol$handleJSMessageInternal$callback$1
            private JSONObject data;
            final /* synthetic */ WebBridgeProtocol this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(WebBridgeCall.this);
                this.this$0 = this;
            }

            @Override // com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback
            public void dispatchPlatformInvoke(JSONObject data) {
                Intrinsics.checkNotNullParameter(data, "data");
                WebBridgeProtocol.evaluateJavaScript$default(this.this$0, this.this$0.createCallbackMessage(WebBridgeCall.this, data), null, 2, null);
                this.this$0.reportToMonitor(WebBridgeCall.this, data);
            }

            @Override // com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback
            public JSONObject convertDataToJSONObject() {
                JSONObject jSONObject = this.data;
                return jSONObject == null ? super.convertDataToJSONObject() : jSONObject;
            }
        };
        String str = invocation;
        if ((str == null || str.length() == 0) || Intrinsics.areEqual(invocation, EMPTY_JSON)) {
            bridgeResultCallback.invoke(getBridgeHandler$anniex_release().createErrorData(createBridgeCall, 0, "invoke msg is empty"));
        } else if (Intrinsics.areEqual(getBdxBridge$anniex_release().getIsThreadOptEnable(), true)) {
            getBdxBridge$anniex_release().handleCallV2(createBridgeCall, bridgeResultCallback);
        } else {
            getBdxBridge$anniex_release().handleCall(createBridgeCall, bridgeResultCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportToMonitor(WebBridgeCall bridgeCall, JSONObject data) {
        long elapsedRealtime;
        if (bridgeCall.getCode() == 1) {
            IWebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.getInstance();
            WebView webView$anniex_release = getWebView$anniex_release();
            JSBInfo jSBInfo = new JSBInfo();
            jSBInfo.bridgeName = bridgeCall.getMethodName();
            jSBInfo.statusCode = 0;
            jSBInfo.costTime = System.currentTimeMillis() - bridgeCall.getNativeCallStartTime();
            jSBInfo.invokeTime = SystemClock.elapsedRealtime() - (System.currentTimeMillis() - bridgeCall.getNativeCallStartTime());
            if (bridgeCall.getNativeCallbackStartTime() != bridgeCall.getNativeCallStartTime()) {
                elapsedRealtime = SystemClock.elapsedRealtime() - (System.currentTimeMillis() - bridgeCall.getNativeCallbackStartTime());
            } else {
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
            jSBInfo.callbackTime = elapsedRealtime;
            if (Intrinsics.areEqual(jSBInfo.bridgeName, "x.request")) {
                JSONObject params = bridgeCall.getParams();
                jSBInfo.requestUrl = params != null ? params.optString(IWeixinService.ResponseConstants.URL) : null;
            }
            jSBInfo.protocolVersion = bridgeCall.getProtocolVersion();
            Unit unit = Unit.INSTANCE;
            webViewMonitorHelper.handleJSBInfo(webView$anniex_release, jSBInfo);
            SLAnnieXMonitor monitorWithSessionId = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(getBdxBridge$anniex_release().getContainerID());
            SLJSBPerfEventInfo sLJSBPerfEventInfo = new SLJSBPerfEventInfo();
            SLInfoCategory sLInfoCategory = new SLInfoCategory();
            sLInfoCategory.setJsb_name(bridgeCall.getMethodName());
            sLInfoCategory.setJsb_protocol_version(Integer.parseInt(bridgeCall.getProtocolVersion()));
            sLJSBPerfEventInfo.setInfo(sLInfoCategory);
            SLInfoPerf sLInfoPerf = new SLInfoPerf();
            sLInfoPerf.setJsb_call(System.currentTimeMillis() - bridgeCall.getNativeCallStartTime());
            sLJSBPerfEventInfo.setPerf(sLInfoPerf);
            monitorWithSessionId.reportJSBPerf(sLJSBPerfEventInfo);
            return;
        }
        if (shouldIgnoreJsbError(bridgeCall)) {
            XBridgeMonitorHelper.INSTANCE.reportJSBFailed(XBridgeMonitorHelper.EVENTNAME_JSB2_FINISH_WITH_FAILURE, bridgeCall.getMethodName(), bridgeCall.getUrl(), bridgeCall.getMessage(), getWebView$anniex_release());
            return;
        }
        IWebViewMonitorHelper webViewMonitorHelper2 = WebViewMonitorHelper.getInstance();
        WebView webView$anniex_release2 = getWebView$anniex_release();
        JSBError jSBError = new JSBError();
        jSBError.bridgeName = bridgeCall.getMethodName();
        jSBError.errorCode = bridgeCall.getCode();
        jSBError.errorMessage = composeErrorMessage(bridgeCall.getMessage(), bridgeCall.getCode());
        Unit unit2 = Unit.INSTANCE;
        webViewMonitorHelper2.handleJSBError(webView$anniex_release2, jSBError);
        SLAnnieXMonitor monitorWithSessionId2 = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(getBdxBridge$anniex_release().getContainerID());
        SLJSBErrorEventInfo sLJSBErrorEventInfo = new SLJSBErrorEventInfo();
        sLJSBErrorEventInfo.setError_ts(System.currentTimeMillis());
        sLJSBErrorEventInfo.setBridge_name(bridgeCall.getMethodName());
        sLJSBErrorEventInfo.setError_code(bridgeCall.getCode());
        sLJSBErrorEventInfo.setError_message(bridgeCall.getMessage());
        try {
            Result.Companion companion = Result.Companion;
            if (IConditionCallKt.enableSLMonitorJSBErrorParams()) {
                sLJSBErrorEventInfo.setJsb_params(bridgeCall.getParams().toString());
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        monitorWithSessionId2.reportJSBError(sLJSBErrorEventInfo);
        SLAnnieXMonitor monitorWithSessionId3 = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(getBdxBridge$anniex_release().getContainerID());
        SLJSBPerfEventInfo sLJSBPerfEventInfo2 = new SLJSBPerfEventInfo();
        SLInfoCategory sLInfoCategory2 = new SLInfoCategory();
        sLInfoCategory2.setJsb_name(bridgeCall.getMethodName());
        sLInfoCategory2.setJsb_protocol_version(Integer.parseInt(bridgeCall.getProtocolVersion()));
        sLJSBPerfEventInfo2.setInfo(sLInfoCategory2);
        SLInfoPerf sLInfoPerf2 = new SLInfoPerf();
        sLInfoPerf2.setJsb_call(-1L);
        sLJSBPerfEventInfo2.setPerf(sLInfoPerf2);
        monitorWithSessionId3.reportJSBPerf(sLJSBPerfEventInfo2);
    }

    private final String composeErrorMessage(String message, int code) {
        try {
            Result.Companion companion = Result.Companion;
            String jSONObject = new JSONObject().putOpt("message", message).putOpt("code", Integer.valueOf(code)).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n           …              .toString()");
            return jSONObject;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return message;
        }
    }

    private final boolean shouldIgnoreJsbError(WebBridgeCall bridgeCall) {
        if (IConditionCallKt.enableAnnieXIgnoreJSB2Failure()) {
            return bridgeCall.getIgnoreJSBError();
        }
        return false;
    }

    public final String getWebViewUrlSync() {
        String safeAuthUrl;
        try {
            if (!TextUtils.isEmpty(this.jsbAuthUrlFromV1)) {
                XBridge.log("GetWebViewUrlSync: from V1 protocol, " + this.jsbAuthUrlFromV1 + ' ');
                safeAuthUrl = this.jsbAuthUrlFromV1;
            } else {
                safeAuthUrl = getSafeAuthUrl();
            }
            if (safeAuthUrl != null) {
                return safeAuthUrl;
            }
            if (!this.hasReleased && this.webView != null) {
                WebView webView$anniex_release = getWebView$anniex_release();
                if (webView$anniex_release != null) {
                    return webView$anniex_release.getUrl();
                }
                return null;
            }
            return "unknown:destroyed or not initialize";
        } catch (Throwable th) {
            XBridge.log("get url failed: " + th.getMessage());
            return "unknown: exception: " + th.getMessage();
        }
    }

    public void onRelease() {
        this.hasReleased = true;
    }

    public final void safeSetV1AuthUrl() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.jsbAuthUrlFromV1 = getSafeAuthUrl();
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol$safeSetV1AuthUrl$2
                @Override // java.lang.Runnable
                public final void run() {
                    String safeAuthUrl;
                    safeAuthUrl = WebBridgeProtocol.this.getSafeAuthUrl();
                    WebBridgeProtocol.this.jsbAuthUrlFromV1 = safeAuthUrl;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSafeAuthUrl() {
        ViewParent webView$anniex_release = getWebView$anniex_release();
        if (webView$anniex_release instanceof ISafeAuthWebView) {
            ISafeAuthWebView iSafeAuthWebView = (ISafeAuthWebView) webView$anniex_release;
            if (iSafeAuthWebView.isEnableSafeAuth()) {
                if (this.hasReleased || this.webView == null) {
                    XBridge.log("webview已销毁或未初始化，无法获取");
                    return "unknown:destroyed or not initialize";
                }
                String xSafeUrl = iSafeAuthWebView.getXSafeUrl();
                this.jsbAuthUrlSource = iSafeAuthWebView.getAuthUrlSourceType();
                if (!TextUtils.isEmpty(xSafeUrl)) {
                    return xSafeUrl;
                }
                WebView webView$anniex_release2 = getWebView$anniex_release();
                if (webView$anniex_release2 != null) {
                    return webView$anniex_release2.getUrl();
                }
                return null;
            }
        }
        return null;
    }

    public final int getWebAuthUrlType() {
        return this.jsbAuthUrlSource.getCode();
    }
}
