package com.bytedance.ies.bullet.kit.web.jsbridge;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.ies.bullet.core.kit.bridge.BridgePerfData;
import com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.web.jsbridge.IJavaMethod;
import com.bytedance.ies.web.jsbridge2.Environment;
import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.ies.web.jsbridge2.IDataConverter;
import com.bytedance.ies.web.jsbridge2.IMethodInvocationListener;
import com.bytedance.ies.web.jsbridge2.JsBridge2;
import com.bytedance.ies.web.jsbridge2.JsBridge2IESSupport;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.TimeLineEventSummary;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.push.interfaze.ISignalReportService;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* compiled from: WebJsBridge.kt */
@Deprecated(message = "XBridge3.0 is ready, XBridge2.0's Web Bridge Module is not recommended to continue to use", replaceWith = @ReplaceWith(expression = "WebBDXBridge", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u0000 k2\u00020\u0001:\u0001kB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010>\u001a\u00020\u00002\b\u0010:\u001a\u0004\u0018\u00010;J\u0010\u0010?\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010=J\u0006\u0010@\u001a\u00020\u0000J\u0018\u0010A\u001a\u00020\b2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010CH\u0016J\u0006\u0010D\u001a\u00020.J\u0010\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\u0006H\u0002J\b\u0010G\u001a\u00020\u0003H\u0016J\u0012\u0010H\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\b\u0010F\u001a\u0004\u0018\u00010\u00062\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J-\u0010O\u001a\u00020.2\u0006\u0010K\u001a\u00020\u00062\u0016\u0010P\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060Q\"\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010RJ\u0012\u0010S\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010T\u001a\u00020.J$\u0010U\u001a\u00020\u00002\b\u0010K\u001a\u0004\u0018\u00010\u00062\b\u0010V\u001a\u0004\u0018\u00010W2\b\b\u0002\u0010X\u001a\u00020YJ\u001c\u0010Z\u001a\u00020.2\b\u0010[\u001a\u0004\u0018\u00010\u00062\b\u0010P\u001a\u0004\u0018\u00010NH\u0016J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020\bJ\u0014\u0010`\u001a\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060aJ\u000e\u0010b\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020(J\u000e\u0010e\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0010\u0010f\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u000104J\u0014\u0010g\u001a\u00020\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060aJ\u0014\u0010h\u001a\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060aJ\u0014\u0010i\u001a\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060aJ\u0006\u0010j\u001a\u00020.R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/WebJsBridge;", "Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;", "webView", "Landroid/webkit/WebView;", "(Landroid/webkit/WebView;)V", "bridgeScheme", "", MemoryApi.DEBUG, "", "disableAllPermissionCheck", "environment", "Lcom/bytedance/ies/web/jsbridge2/Environment;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "iesJsBridge", "Lcom/bytedance/ies/web/jsbridge/IESJsBridge;", "getIesJsBridge", "()Lcom/bytedance/ies/web/jsbridge/IESJsBridge;", "setIesJsBridge", "(Lcom/bytedance/ies/web/jsbridge/IESJsBridge;)V", "ignoreGeckoSafeHost", "", "jsBridge2", "Lcom/bytedance/ies/web/jsbridge2/JsBridge2;", "getJsBridge2", "()Lcom/bytedance/ies/web/jsbridge2/JsBridge2;", "setJsBridge2", "(Lcom/bytedance/ies/web/jsbridge2/JsBridge2;)V", "jsBridge2Support", "Lcom/bytedance/ies/web/jsbridge2/JsBridge2IESSupport;", "getJsBridge2Support", "()Lcom/bytedance/ies/web/jsbridge2/JsBridge2IESSupport;", "setJsBridge2Support", "(Lcom/bytedance/ies/web/jsbridge2/JsBridge2IESSupport;)V", "jsObjectName", "methodInvocationListener", "Lcom/bytedance/ies/web/jsbridge2/IMethodInvocationListener;", "perDataMap", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "perfDataReadyHandler", "Lkotlin/Function2;", "", "getPerfDataReadyHandler", "()Lkotlin/jvm/functions/Function2;", "setPerfDataReadyHandler", "(Lkotlin/jvm/functions/Function2;)V", "permissionCheckingListener", "Lcom/bytedance/ies/web/jsbridge2/IBridgePermissionConfigurator$PermissionCheckingListener;", "protectedFunc", "publicFunc", "safeHost", "validator", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig$IOpenJsbPermissionValidator;", "webChromeClient", "Landroid/webkit/WebChromeClient;", "webViewClient", "Landroid/webkit/WebViewClient;", "bindWebChromeClient", "bindWebViewClient", "build", "checkJsEventEnable", "valueCallback", "Landroid/webkit/ValueCallback;", "disablePermissionCheck", "getOrCreatePerfData", "callBackId", "getWebView", "invokeJavaMethod", "url", "invokeJsCallback", "method", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "result", "Lorg/json/JSONObject;", "invokeJsMethod", "params", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "isSafeHost", "onDestroy", "registerJavaMethod", "func", "Lcom/bytedance/ies/web/jsbridge/IJavaMethod;", "access", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "sendJsEvent", ISignalReportService.BODY_KEY_EVENT, "setBridgeScheme", "setDebug", "setDisableAllPermissionCheck", "value", "setIgnoreGeckoSafeHost", "", "setJsObjectName", "setMethodInvocationListener", "listener", "setOpenJsbPermissionValidator", "setPermissionCheckingListener", "setProtectedFunc", "setPublicFunc", "setSafeHost", "setup", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebJsBridge implements IWebJsBridge {
    public static final String BRIDGE_SCHEME = "bytedance";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String JS_OBJECT_NAME = "ToutiaoJSBridge";
    private String bridgeScheme;
    private boolean debug;
    private boolean disableAllPermissionCheck;
    private Environment environment;

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private final Lazy gson;
    private IESJsBridge iesJsBridge;
    private List<String> ignoreGeckoSafeHost;
    private JsBridge2 jsBridge2;
    private JsBridge2IESSupport jsBridge2Support;
    private String jsObjectName;
    private IMethodInvocationListener methodInvocationListener;
    private final Map<String, BridgePerfData> perDataMap;
    private Function2<? super String, ? super BridgePerfData, Unit> perfDataReadyHandler;
    private IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener;
    private List<String> protectedFunc;
    private List<String> publicFunc;
    private List<String> safeHost;
    private IWebJsBridgeConfig.IOpenJsbPermissionValidator validator;
    private WebChromeClient webChromeClient;
    private final WebView webView;
    private WebViewClient webViewClient;

    @JvmStatic
    public static final WebJsBridge create(WebView webView) {
        return INSTANCE.create(webView);
    }

    @JvmStatic
    public static final void injectId(WebView webView, String str) {
        INSTANCE.injectId(webView, str);
    }

    public WebJsBridge(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
        this.safeHost = new ArrayList();
        this.ignoreGeckoSafeHost = new ArrayList();
        this.publicFunc = new ArrayList();
        this.protectedFunc = new ArrayList();
        this.debug = AnnieX.isDebug();
        this.jsObjectName = JS_OBJECT_NAME;
        this.bridgeScheme = BRIDGE_SCHEME;
        this.gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge$gson$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Gson m509invoke() {
                return new Gson();
            }
        });
        this.perDataMap = new LinkedHashMap();
    }

    public final IESJsBridge getIesJsBridge() {
        return this.iesJsBridge;
    }

    public final void setIesJsBridge(IESJsBridge iESJsBridge) {
        this.iesJsBridge = iESJsBridge;
    }

    public final JsBridge2IESSupport getJsBridge2Support() {
        return this.jsBridge2Support;
    }

    public final void setJsBridge2Support(JsBridge2IESSupport jsBridge2IESSupport) {
        this.jsBridge2Support = jsBridge2IESSupport;
    }

    public final JsBridge2 getJsBridge2() {
        return this.jsBridge2;
    }

    public final void setJsBridge2(JsBridge2 jsBridge2) {
        this.jsBridge2 = jsBridge2;
    }

    public final Function2<String, BridgePerfData, Unit> getPerfDataReadyHandler() {
        return this.perfDataReadyHandler;
    }

    public final void setPerfDataReadyHandler(Function2<? super String, ? super BridgePerfData, Unit> function2) {
        this.perfDataReadyHandler = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Gson getGson() {
        return (Gson) this.gson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BridgePerfData getOrCreatePerfData(String callBackId) {
        BridgePerfData bridgePerfData = this.perDataMap.get(callBackId);
        if (bridgePerfData != null) {
            return bridgePerfData;
        }
        BridgePerfData bridgePerfData2 = new BridgePerfData();
        this.perDataMap.put(callBackId, bridgePerfData2);
        return bridgePerfData2;
    }

    /* compiled from: WebJsBridge.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/WebJsBridge$Companion;", "", "()V", "BRIDGE_SCHEME", "", "JS_OBJECT_NAME", "create", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/WebJsBridge;", "webView", "Landroid/webkit/WebView;", "injectId", "", "id", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WebJsBridge create(WebView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            return new WebJsBridge(webView);
        }

        @JvmStatic
        public final void injectId(WebView webView, String id) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            if (id != null) {
                webView.loadUrl("javascript:(function () {    window.reactId = '" + id + "';})();");
            }
        }
    }

    public final WebJsBridge bindWebViewClient(WebViewClient webViewClient) {
        this.webViewClient = webViewClient;
        return this;
    }

    public final WebJsBridge bindWebChromeClient(WebChromeClient webChromeClient) {
        this.webChromeClient = webChromeClient;
        return this;
    }

    public final WebJsBridge setSafeHost(List<String> safeHost) {
        Intrinsics.checkNotNullParameter(safeHost, "safeHost");
        this.safeHost.addAll(safeHost);
        return this;
    }

    public final WebJsBridge setIgnoreGeckoSafeHost(List<String> safeHost) {
        Intrinsics.checkNotNullParameter(safeHost, "safeHost");
        this.ignoreGeckoSafeHost.addAll(safeHost);
        return this;
    }

    public final WebJsBridge setPublicFunc(List<String> publicFunc) {
        Intrinsics.checkNotNullParameter(publicFunc, "publicFunc");
        this.publicFunc.addAll(publicFunc);
        return this;
    }

    public final WebJsBridge setProtectedFunc(List<String> protectedFunc) {
        Intrinsics.checkNotNullParameter(protectedFunc, "protectedFunc");
        this.protectedFunc.addAll(protectedFunc);
        return this;
    }

    public final WebJsBridge setJsObjectName(String jsObjectName) {
        Intrinsics.checkNotNullParameter(jsObjectName, "jsObjectName");
        this.jsObjectName = jsObjectName;
        return this;
    }

    public final WebJsBridge setBridgeScheme(String bridgeScheme) {
        Intrinsics.checkNotNullParameter(bridgeScheme, "bridgeScheme");
        this.bridgeScheme = bridgeScheme;
        return this;
    }

    public final WebJsBridge setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public final WebJsBridge setDisableAllPermissionCheck(boolean value) {
        this.disableAllPermissionCheck = value;
        return this;
    }

    public final WebJsBridge setOpenJsbPermissionValidator(IWebJsBridgeConfig.IOpenJsbPermissionValidator validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        this.validator = validator;
        return this;
    }

    public final WebJsBridge setMethodInvocationListener(IMethodInvocationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.methodInvocationListener = listener;
        return this;
    }

    public final WebJsBridge setPermissionCheckingListener(IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener) {
        this.permissionCheckingListener = permissionCheckingListener;
        return this;
    }

    public final WebJsBridge build() {
        BulletSettings provideBulletSettings;
        Environment addMethodInvocationListener = JsBridge2.createWith(this.webView).enablePermissionCheck(true).setJsObjectName(this.jsObjectName).addPublicMethod(this.publicFunc).setDataConverter(new IDataConverter() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge$build$environment$1
            @Override // com.bytedance.ies.web.jsbridge2.IDataConverter
            public <T> T fromRawData(String data, Type type) {
                Gson gson;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(type, "type");
                gson = WebJsBridge.this.getGson();
                return (T) gson.fromJson(data, type);
            }

            @Override // com.bytedance.ies.web.jsbridge2.IDataConverter
            public <T> String toRawData(T value) {
                Gson gson;
                gson = WebJsBridge.this.getGson();
                String json = gson.toJson(value);
                Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(value)");
                return json;
            }
        }).addPermissionCheckingListener(this.permissionCheckingListener).addMethodInvocationListener(new IMethodInvocationListener() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge$build$environment$2
            @Override // com.bytedance.ies.web.jsbridge2.IMethodInvocationListener
            public void onInvoked(String url, String methodName) {
            }

            @Override // com.bytedance.ies.web.jsbridge2.IMethodInvocationListener
            public void onRejected(String url, String methodName, int reason) {
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x000e, B:8:0x002b, B:10:0x0031, B:12:0x0040, B:14:0x004a, B:16:0x0050, B:17:0x0058, B:19:0x005c, B:23:0x0066, B:25:0x0074, B:26:0x007b, B:28:0x0085, B:29:0x008c, B:31:0x0096, B:32:0x009d, B:34:0x00a3, B:38:0x00b6, B:40:0x00b9, B:44:0x00bc), top: B:2:0x0002 }] */
            @Override // com.bytedance.ies.web.jsbridge2.IMethodInvocationListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onInvoked(String url, String methodName, TimeLineEventSummary timeLineEventSummary) {
                List<TimeLineEvent> list;
                String str;
                BridgePerfData orCreatePerfData;
                Map map;
                WebJsBridge webJsBridge = WebJsBridge.this;
                try {
                    Result.Companion companion = Result.Companion;
                    WebJsBridge$build$environment$2 webJsBridge$build$environment$2 = this;
                    Unit unit = null;
                    if (timeLineEventSummary != null && (list = timeLineEventSummary.jsbCallTimeLineEvents) != null) {
                        List<TimeLineEvent> list2 = list;
                        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                        for (Object obj : list2) {
                            linkedHashMap.put(((TimeLineEvent) obj).getLabel(), obj);
                        }
                        TimeLineEvent timeLineEvent = (TimeLineEvent) linkedHashMap.get(TimeLineEvent.Constants.LABEL_CREATE_JAVA_CALL);
                        if (timeLineEvent != null) {
                            HashMap<String, Object> extra = timeLineEvent.getExtra();
                            Object obj2 = extra != null ? extra.get("callbackId") : null;
                            str = obj2 instanceof String ? (String) obj2 : null;
                            if (str != null) {
                                if (str != null) {
                                    orCreatePerfData = webJsBridge.getOrCreatePerfData(str);
                                    TimeLineEvent timeLineEvent2 = (TimeLineEvent) linkedHashMap.get(TimeLineEvent.Constants.LABEL_PRE_CALL_ORIGIN_URL);
                                    if (timeLineEvent2 != null) {
                                        orCreatePerfData.onCallFromJs(timeLineEvent2.getTimeInMillis());
                                    }
                                    TimeLineEvent timeLineEvent3 = (TimeLineEvent) linkedHashMap.get(TimeLineEvent.Constants.LABEL_CALL_ORIGIN_URL);
                                    if (timeLineEvent3 != null) {
                                        orCreatePerfData.onDecodeEnd(timeLineEvent3.getTimeInMillis());
                                    }
                                    TimeLineEvent timeLineEvent4 = (TimeLineEvent) linkedHashMap.get(TimeLineEvent.Constants.LABEL_PRE_HANDLE_ORIGIN_URL);
                                    if (timeLineEvent4 != null) {
                                        orCreatePerfData.onMethodCall(timeLineEvent4.getTimeInMillis());
                                    }
                                    if (orCreatePerfData.isReady()) {
                                        map = webJsBridge.perDataMap;
                                        map.remove(str);
                                        Function2<String, BridgePerfData, Unit> perfDataReadyHandler = webJsBridge.getPerfDataReadyHandler();
                                        if (perfDataReadyHandler != null) {
                                            perfDataReadyHandler.invoke(methodName == null ? "" : methodName, orCreatePerfData);
                                        }
                                    }
                                    unit = Unit.INSTANCE;
                                }
                            }
                        }
                        str = null;
                        if (str != null) {
                        }
                    }
                    Result.constructor-impl(unit);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                onInvoked(url, methodName);
            }
        });
        final IWebJsBridgeConfig.IOpenJsbPermissionValidator iOpenJsbPermissionValidator = this.validator;
        if (iOpenJsbPermissionValidator != null) {
            addMethodInvocationListener.addOpenJsbValidator(new IBridgePermissionConfigurator.OpenJsbPermissionValidator() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge$build$environment$3$1$1
                @Override // com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator.OpenJsbPermissionValidator
                public boolean shouldIntercept(String url, String methodName) {
                    return IWebJsBridgeConfig.IOpenJsbPermissionValidator.this.shouldIntercept(url, methodName);
                }

                @Override // com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator.OpenJsbPermissionValidator
                public boolean shouldValidateUrl(String url) {
                    return IWebJsBridgeConfig.IOpenJsbPermissionValidator.this.shouldValidateUrl(url);
                }
            });
        }
        List<String> list = this.ignoreGeckoSafeHost;
        boolean z = false;
        Environment methodInvocationListener = addMethodInvocationListener.addSafeHost(list == null || list.isEmpty() ? this.safeHost : this.ignoreGeckoSafeHost).setDebug(this.debug).setShouldFlattenData(true).setMethodInvocationListener(this.methodInvocationListener);
        if (this.disableAllPermissionCheck) {
            methodInvocationListener.disableAllPermissionCheck();
        }
        this.environment = methodInvocationListener;
        JsBridge2 build = methodInvocationListener.build();
        this.jsBridge2 = build;
        JsBridge2IESSupport from = JsBridge2IESSupport.from(this.webView, build);
        this.jsBridge2Support = from;
        Intrinsics.checkNotNull(from);
        this.iesJsBridge = from.getLegacyJsBridge();
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService != null && (provideBulletSettings = iSettingService.provideBulletSettings()) != null) {
            z = provideBulletSettings.getUseBDXbridge();
        }
        if (z) {
            new JSB4Support(this.webView, this.jsBridge2, this.iesJsBridge);
        }
        return this;
    }

    public final void disablePermissionCheck() {
        Environment environment = this.environment;
        if (environment != null) {
            environment.disableAllPermissionCheck();
        }
    }

    public final void setup() {
        IESJsBridge iESJsBridge = this.iesJsBridge;
        if (iESJsBridge != null) {
            iESJsBridge.setBridgeScheme(this.bridgeScheme).setSafeHost(this.safeHost).setPublicFunc(this.publicFunc).setProtectedFunc(this.protectedFunc);
            WebChromeClient webChromeClient = this.webChromeClient;
            if (webChromeClient != null) {
                iESJsBridge.setWebChromeClient(webChromeClient);
            }
            WebViewClient webViewClient = this.webViewClient;
            if (webViewClient != null) {
                iESJsBridge.setWebViewClient(webViewClient);
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge
    public void sendJsEvent(String event, JSONObject params) {
        IESJsBridge iESJsBridge = this.iesJsBridge;
        if (iESJsBridge != null) {
            iESJsBridge.sendJsEvent(event, params);
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge
    public void invokeJsCallback(IGenericBridgeMethod method, String callBackId, JSONObject result) {
        Intrinsics.checkNotNullParameter(method, "method");
        BridgePerfData orCreatePerfData = callBackId != null ? getOrCreatePerfData(callBackId) : null;
        if (orCreatePerfData != null) {
            BridgePerfData.onCallbackStart$default(orCreatePerfData, 0L, 1, null);
        }
        IESJsBridge iESJsBridge = this.iesJsBridge;
        if (iESJsBridge != null) {
            iESJsBridge.invokeJsCallback(callBackId, result);
        }
        if (orCreatePerfData != null) {
            BridgePerfData.onEncodeEnd$default(orCreatePerfData, 0L, 1, null);
            BridgePerfData.onCallbackEnd$default(orCreatePerfData, 0L, 1, null);
            if (orCreatePerfData.isReady()) {
                if (callBackId != null) {
                    this.perDataMap.remove(callBackId);
                }
                Function2<? super String, ? super BridgePerfData, Unit> function2 = this.perfDataReadyHandler;
                if (function2 != null) {
                    function2.invoke(method.getName(), orCreatePerfData);
                }
            }
        }
    }

    public static /* synthetic */ WebJsBridge registerJavaMethod$default(WebJsBridge webJsBridge, String str, IJavaMethod iJavaMethod, IBridgeMethod.Access access, int i, Object obj) {
        if ((i & 4) != 0) {
            access = IBridgeMethod.Access.PRIVATE;
        }
        return webJsBridge.registerJavaMethod(str, iJavaMethod, access);
    }

    public final WebJsBridge registerJavaMethod(String method, IJavaMethod func, IBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "access");
        if (this.jsBridge2Support != null) {
            if (access == IBridgeMethod.Access.SECURE) {
                JsBridge2IESSupport jsBridge2IESSupport = this.jsBridge2Support;
                Intrinsics.checkNotNull(jsBridge2IESSupport);
                jsBridge2IESSupport.registerJavaMethod(method, func, PermissionGroup.SECURE);
            } else {
                JsBridge2IESSupport jsBridge2IESSupport2 = this.jsBridge2Support;
                Intrinsics.checkNotNull(jsBridge2IESSupport2);
                jsBridge2IESSupport2.registerJavaMethod(method, func);
            }
        } else {
            IESJsBridge iESJsBridge = this.iesJsBridge;
            if (iESJsBridge != null) {
                iESJsBridge.registerJavaMethod(method, func);
            }
        }
        return this;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge
    public boolean isSafeHost(String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        JsBridge2 jsBridge2 = this.jsBridge2;
        if (jsBridge2 != null) {
            Intrinsics.checkNotNull(jsBridge2);
            Intrinsics.checkNotNull(url);
            return jsBridge2.isSafeHost(url, null);
        }
        IESJsBridge iESJsBridge = this.iesJsBridge;
        if (iESJsBridge == null) {
            return false;
        }
        Intrinsics.checkNotNull(iESJsBridge);
        return iESJsBridge.isSafeHost(url);
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge
    public boolean checkJsEventEnable(ValueCallback<Boolean> valueCallback) {
        IESJsBridge iESJsBridge = this.iesJsBridge;
        if (iESJsBridge == null) {
            return false;
        }
        Intrinsics.checkNotNull(iESJsBridge);
        return iESJsBridge.checkJsEventEnable(valueCallback);
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge
    public void invokeJsMethod(String method, String... params) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(params, "params");
        IESJsBridge iESJsBridge = this.iesJsBridge;
        if (iESJsBridge != null) {
            iESJsBridge.invokeJsMethod(method, (String[]) Arrays.copyOf(params, params.length));
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge
    public boolean invokeJavaMethod(String url) {
        IESJsBridge iESJsBridge = this.iesJsBridge;
        return iESJsBridge != null && iESJsBridge.invokeJavaMethod(url);
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge
    public WebView getWebView() {
        return this.webView;
    }

    public final void onDestroy() {
        IESJsBridge iESJsBridge = this.iesJsBridge;
        if (iESJsBridge != null) {
            iESJsBridge.onDestroy();
        }
        JsBridge2 jsBridge2 = this.jsBridge2;
        if (jsBridge2 != null) {
            jsBridge2.release();
        }
    }
}
