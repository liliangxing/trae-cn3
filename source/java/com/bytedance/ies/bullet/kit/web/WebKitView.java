package com.bytedance.ies.bullet.kit.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Looper;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.android.anniex.base.container.INavBarHost;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import com.bytedance.android.anniex.base.service.AnnieXUIService;
import com.bytedance.android.anniex.container.ui.AnnieXSourceLabel;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.common.util.LollipopV21Compat;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.argus.api.params.ArgusWebResourceRequestRewritePayload;
import com.bytedance.ies.bullet.base.depend.INetworkDepend;
import com.bytedance.ies.bullet.container.api.ILongClickListenerProvider;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.BulletWebContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestPreloadHelper;
import com.bytedance.ies.bullet.forest.ForestWebInfoHelper;
import com.bytedance.ies.bullet.kit.web.export.AnnieXWebViewClient;
import com.bytedance.ies.bullet.kit.web.export.BulletWebChromeClient;
import com.bytedance.ies.bullet.kit.web.export.BulletWebViewClient;
import com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IEventHandler;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.ILoadUriListener;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge;
import com.bytedance.ies.bullet.service.base.callbacks.KitViewCallback;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.IWebKitViewService;
import com.bytedance.ies.bullet.service.base.web.IWebResourceRequest;
import com.bytedance.ies.bullet.service.base.web.IWebViewDelegate;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDelegate;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDispatcher;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.context.IContextProviderFactory;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate;
import com.bytedance.ies.bullet.service.webkit.WebKitService;
import com.bytedance.ies.bullet.web.SSPMonitorWebViewClient;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.webx.ExtensionParam;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: WebKitView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u0002:\u0002\u0091\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0010\u0010M\u001a\u00020N2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\u0012H\u0016J\b\u0010Q\u001a\u00020\u0012H\u0016J\u0010\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\bH\u0016J\u0012\u0010S\u001a\u00020N2\b\u0010T\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010U\u001a\u00020\bH\u0016J\b\u0010V\u001a\u00020KH\u0016J\b\u0010W\u001a\u00020\bH\u0016J\b\u0010X\u001a\u00020\bH\u0016J\b\u0010Y\u001a\u00020\bH\u0016J\u0010\u0010Z\u001a\u00020N2\u0006\u0010[\u001a\u00020\\H\u0002J\u0012\u0010]\u001a\u00020\u00122\b\u0010T\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010^\u001a\u00020\u0012H\u0002J\u001a\u0010_\u001a\u00020N2\u0006\u0010T\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\"\u0010b\u001a\u00020N2\u0006\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020\u00122\b\u0010`\u001a\u0004\u0018\u00010aH\u0002J \u0010e\u001a\u00020N2\u0006\u0010T\u001a\u00020\b2\u0006\u0010f\u001a\u00020g2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010h\u001a\u00020iH\u0007J\u0014\u0010h\u001a\u0004\u0018\u00010i2\b\u0010j\u001a\u0004\u0018\u00010kH\u0007J\b\u0010l\u001a\u00020\u0012H\u0016J\b\u0010m\u001a\u00020NH\u0016J\b\u0010n\u001a\u00020NH\u0016J\u0012\u0010o\u001a\u00020N2\b\u0010p\u001a\u0004\u0018\u00010&H\u0002J\n\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010q\u001a\u00020NH\u0016J\b\u0010r\u001a\u00020NH\u0016J,\u0010s\u001a\u00020N2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\b2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020x0\fH\u0016J,\u0010y\u001a\u00020N2\u0006\u0010z\u001a\u00020u2\u0006\u0010v\u001a\u00020\b2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020x0\fH\u0016J\u001a\u0010{\u001a\u00020N2\u0006\u0010|\u001a\u00020\b2\b\u0010}\u001a\u0004\u0018\u00010xH\u0016J\"\u0010{\u001a\u00020N2\u0006\u0010|\u001a\u00020\b2\b\u0010}\u001a\u0004\u0018\u00010x2\u0006\u0010P\u001a\u00020\u0012H\u0016J\u001b\u0010~\u001a\u00020N2\u0006\u0010|\u001a\u00020\b2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0003J\t\u0010\u0081\u0001\u001a\u00020NH\u0002J\u0011\u0010\u0082\u0001\u001a\u00020N2\u0006\u0010[\u001a\u00020GH\u0002J\t\u0010\u0083\u0001\u001a\u00020NH\u0002J\u001b\u0010\u0084\u0001\u001a\u00020N2\u0006\u0010c\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010aH\u0002JG\u0010\u0085\u0001\u001a\u001f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u0086\u00012\b\u0010T\u001a\u0004\u0018\u00010\b2\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002J\u001e\u0010\u0088\u0001\u001a\u00020N2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\\2\b\u0010T\u001a\u0004\u0018\u00010\bH\u0002J\u001e\u0010\u008a\u0001\u001a\u00020N2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\\2\b\u0010T\u001a\u0004\u0018\u00010\bH\u0002J\t\u0010\u008b\u0001\u001a\u00020NH\u0016J\u001d\u0010\u008c\u0001\u001a\u00020N2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020x0\fH\u0016J\u001e\u0010\u008d\u0001\u001a\u00020N2\u0013\u0010\u008e\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020x0\fH\u0016J\r\u0010\u008f\u0001\u001a\u00020N*\u00020\\H\u0002J\r\u0010\u0090\u0001\u001a\u00020N*\u00020\\H\u0002R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000203X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/WebKitView;", "Lcom/bytedance/ies/bullet/service/base/web/IWebKitViewService;", "Lcom/bytedance/ies/bullet/forest/ForestWebInfoHelper;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "kitService", "Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "sessionId", "", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Lcom/bytedance/ies/bullet/service/webkit/WebKitService;Ljava/lang/String;)V", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Lcom/bytedance/ies/bullet/service/webkit/WebKitService;)V", "additionalHttpHeaders", "", "getAdditionalHttpHeaders", "()Ljava/util/Map;", "setAdditionalHttpHeaders", "(Ljava/util/Map;)V", "allowAdBlock", "", "annieXContainerSessionId", "argusAdapter", "Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "getArgusAdapter$anniex_release", "()Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "setArgusAdapter$anniex_release", "(Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;)V", "getContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "setContext", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "contextProviderFactory", "Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;)V", "currentSessionId", "currentUri", "Landroid/net/Uri;", "getCurrentUri", "()Landroid/net/Uri;", "setCurrentUri", "(Landroid/net/Uri;)V", "currentUrl", "delegate", "Lcom/bytedance/ies/bullet/service/webkit/AbsWebKitDelegate;", "initParams", "Lcom/bytedance/ies/bullet/kit/web/WebKitViewInitParams;", "isPageFinished", "isViewFirstAppeared", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "setKitType", "(Lcom/bytedance/ies/bullet/service/base/utils/KitType;)V", "kitViewCallback", "Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "getKitViewCallback", "()Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "setKitViewCallback", "(Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;)V", "mWebJsBridge", "Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;", "getMWebJsBridge", "()Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;", "setMWebJsBridge", "(Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;)V", "reUsePageViewed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "realView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "sccDelegate", "Lcom/bytedance/ies/bullet/web/scc/SccDelegate;", "sccLevel", "Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "shouldResetPageStartUrlWhenReceivedError", "createWebView", "", "destroy", "useDelegate", "ensureViewCreated", "schemaUrl", "finishNavigation", "url", "getCurrentUrl", "getSccLevel", "getSdkVersion", "getSessionId", "getViewTag", "initMonitorConfig", "webView", "Landroid/webkit/WebView;", "invokeJavaMethod", "isCachedView", "load", "listener", "Lcom/bytedance/ies/bullet/service/base/ILoadUriListener;", "loadInner", "loadUrl", "isReload", "loadUri", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "onAdFilter", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "onBackPressed", "onHide", "onShow", "performForestDelayPreload", "uri", "reload", "reloadCurrentUrl", "renderSSR", "template", "", "baseUrl", "data", "", "renderSSRHydrate", "templateArray", "sendEvent", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "sendEventWithJson", "json", "Lorg/json/JSONObject;", "setAdBlock", "setSccDelegate", "setWebChromeClientDelegate", "setWebViewClient", "shouldSecureIntercept", "Lkotlin/Pair;", "headers", "showCloseAll", "view", "startNavigation", "triggerBlankDetect", "updateData", "updateGlobalProps", "globalprops", "setLongClickable", "setWebParams", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebKitView implements IWebKitViewService, ForestWebInfoHelper {
    public static final int ERR_SSL_ERROR = -100;
    public static final String EVENT_VIEW_APPEARED = "viewAppeared";
    public static final String EVENT_VIEW_CLOSED = "pageClosed";
    public static final String EVENT_VIEW_DISAPPEARED = "viewDisappeared";
    public static final String EVENT_VIEW_REUSED = "pageReused";
    public static final int NO_PERMISSION_FAIL_REASON = 1;
    private Map<String, String> additionalHttpHeaders;
    private boolean allowAdBlock;
    private String annieXContainerSessionId;
    private ArgusWebDelegateAdapter argusAdapter;
    private IServiceToken context;
    private IContextProviderFactory contextProviderFactory;
    private String currentSessionId;
    private Uri currentUri;
    private String currentUrl;
    private AbsWebKitDelegate delegate;
    private WebKitViewInitParams initParams;
    private boolean isPageFinished;
    private boolean isViewFirstAppeared;
    private final WebKitService kitService;
    private KitType kitType;
    private KitViewCallback kitViewCallback;
    private IWebJsBridge mWebJsBridge;
    private final AtomicBoolean reUsePageViewed;
    private SSWebView realView;
    private SccDelegate sccDelegate;
    private SccConfig.SccLevel sccLevel;
    private final boolean shouldResetPageStartUrlWhenReceivedError;

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public String getSdkVersion() {
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public String getViewTag() {
        return "BulletWeb";
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void renderSSR(byte[] template, String baseUrl, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void renderSSRHydrate(byte[] templateArray, String baseUrl, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(templateArray, "templateArray");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void triggerBlankDetect() {
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public WebKitView(IServiceToken iServiceToken, WebKitService webKitService) {
        Intrinsics.checkNotNullParameter(iServiceToken, "context");
        Intrinsics.checkNotNullParameter(webKitService, "kitService");
        this.context = iServiceToken;
        this.kitService = webKitService;
        this.kitType = KitType.WEB;
        this.delegate = webKitService.provideDelegate(getContext());
        this.currentSessionId = "";
        this.isViewFirstAppeared = true;
        this.reUsePageViewed = new AtomicBoolean(false);
        this.sccLevel = SccConfig.SccLevel.SAFE;
        ISettingService iSettingService = (ISettingService) webKitService.getService(ISettingService.class);
        this.shouldResetPageStartUrlWhenReceivedError = iSettingService != null ? iSettingService.provideBulletSettings().getShouldResetPageStartUrlWhenReceivedError() : false;
        this.currentUrl = "";
    }

    @Override // com.bytedance.ies.bullet.forest.ForestWebInfoHelper
    public Pair<Boolean, Scene> canInterceptByForest(WebResourceRequest webResourceRequest, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.canInterceptByForest(this, webResourceRequest, iServiceToken, bulletContext, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestWebInfoHelper
    public Pair<Boolean, Scene> canInterceptByForest(String str, boolean z, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.canInterceptByForest(this, str, z, iServiceToken, bulletContext, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestWebInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestWebInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        return ForestWebInfoHelper.DefaultImpls.getTemplateBundleResponse(this, response);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    /* renamed from: realView */
    public /* bridge */ /* synthetic */ View getRealView() {
        return (View) getRealView();
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.sessionID(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.sessionID(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public IServiceToken getContext() {
        return this.context;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void setContext(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "<set-?>");
        this.context = iServiceToken;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebKitView(IServiceToken iServiceToken, WebKitService webKitService, String str) {
        this(iServiceToken, webKitService);
        Intrinsics.checkNotNullParameter(iServiceToken, "context");
        Intrinsics.checkNotNullParameter(webKitService, "kitService");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.annieXContainerSessionId = str;
        this.delegate = webKitService.provideDelegate(iServiceToken, str);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public KitType getKitType() {
        return this.kitType;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void setKitType(KitType kitType) {
        Intrinsics.checkNotNullParameter(kitType, "<set-?>");
        this.kitType = kitType;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitViewService
    public IWebJsBridge getMWebJsBridge() {
        return this.mWebJsBridge;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitViewService
    public void setMWebJsBridge(IWebJsBridge iWebJsBridge) {
        this.mWebJsBridge = iWebJsBridge;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitViewService
    public Map<String, String> getAdditionalHttpHeaders() {
        return this.additionalHttpHeaders;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitViewService
    public void setAdditionalHttpHeaders(Map<String, String> map) {
        this.additionalHttpHeaders = map;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public KitViewCallback getKitViewCallback() {
        return this.kitViewCallback;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void setKitViewCallback(KitViewCallback kitViewCallback) {
        this.kitViewCallback = kitViewCallback;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitViewService
    public Uri getCurrentUri() {
        return this.currentUri;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitViewService
    public void setCurrentUri(Uri uri) {
        this.currentUri = uri;
    }

    /* renamed from: getArgusAdapter$anniex_release, reason: from getter */
    public final ArgusWebDelegateAdapter getArgusAdapter() {
        return this.argusAdapter;
    }

    public final void setArgusAdapter$anniex_release(ArgusWebDelegateAdapter argusWebDelegateAdapter) {
        this.argusAdapter = argusWebDelegateAdapter;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public IContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void setContextProviderFactory(IContextProviderFactory iContextProviderFactory) {
        this.contextProviderFactory = iContextProviderFactory;
    }

    private final void initMonitorConfig(WebView webView) {
        Iterator<String> keys;
        IWebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.getInstance();
        String bid = this.delegate.getContext().getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        MonitorReportService monitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (monitorReportService == null) {
            monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
        }
        MonitorConfig config = monitorReportService.getConfig();
        IWebViewMonitorHelper.Config buildConfig = webViewMonitorHelper.buildConfig();
        buildConfig.setVirtualAID(config.getVirtualAID());
        buildConfig.setBid(config.getBizTag());
        buildConfig.setIsNeedMonitor(config.getLogSwitch());
        buildConfig.setIsNeedInjectBrowser(Boolean.valueOf(config.getInjectBrowser()));
        buildConfig.setWebViewObjKeys(new WebView[]{webView});
        buildConfig.setPerformanceReportAfterDetach();
        buildConfig.setBlankDetectCallback(new DefaultWebBlankCallback(new WeakReference(this.delegate.getContext())));
        buildConfig.setFallbackContainerName("bullet");
        buildConfig.setSessionId(getCurrentSessionId());
        webViewMonitorHelper.addConfig(buildConfig);
        JSONObject category = config.getCategory();
        if (category == null || (keys = category.keys()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject category2 = config.getCategory();
            Intrinsics.checkNotNull(category2);
            webViewMonitorHelper.addContext(webView, next, category2.get(next).toString());
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public boolean ensureViewCreated() {
        String str = this.annieXContainerSessionId;
        if (str == null) {
            return true;
        }
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("annieXContainerSessionId");
            str = null;
        }
        createWebView(str);
        return true;
    }

    @Override // com.bytedance.ies.bullet.IBulletKitViewService, com.bytedance.ies.bullet.service.base.IKitViewService
    public boolean ensureViewCreated(String schemaUrl) {
        Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
        return ensureViewCreated();
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitViewService
    public boolean invokeJavaMethod(String url) {
        IWebJsBridge mWebJsBridge = getMWebJsBridge();
        if (mWebJsBridge != null) {
            return mWebJsBridge.invokeJavaMethod(url);
        }
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitViewService
    public String getCurrentUrl() {
        String url;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            SSWebView sSWebView = this.realView;
            return (sSWebView == null || (url = sSWebView.getUrl()) == null) ? "" : url;
        }
        return this.currentUrl;
    }

    private final void createWebView(String sessionId) {
        if (this.realView == null || this.annieXContainerSessionId == null) {
            this.realView = this.delegate.createWebView(sessionId);
        }
    }

    @Override // com.bytedance.ies.bullet.IBulletKitViewService
    public void loadUri(String url, final IBulletLifeCycle lifeCycle, String sessionId) {
        int i;
        Unit unit;
        IWebViewDelegate webViewDelegate;
        BDXWebKitModel webkitModel;
        IntegerParam overScrollModel;
        Integer value;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.currentSessionId = sessionId;
        setContextProviderFactory(ContextProviderManager.INSTANCE.getProviderFactory(sessionId));
        final Uri parse = Uri.parse(url);
        this.delegate.onLoadStart(url, sessionId);
        if (!this.delegate.bulletContextIsInitialized()) {
            Intrinsics.checkNotNullExpressionValue(parse, "schemaUri");
            lifeCycle.onLoadFail(parse, new Throwable("BulletContext is not initialized"));
            return;
        }
        SchemaModelUnion parseSchema = this.delegate.parseSchema(url, sessionId);
        Intrinsics.checkNotNullExpressionValue(parse, "schemaUri");
        WebKitView webKitView = this;
        lifeCycle.onLoadModelSuccess(parse, webKitView, parseSchema);
        this.initParams = this.delegate.provideWebKitInitParams();
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "webview create " + url, "XWebKit", null, 8, null);
        this.delegate.getContext().getMonitorCallback().onKitViewCreateBegin();
        createWebView(sessionId);
        if (this.realView == null) {
            lifeCycle.onLoadFail(parse, new Throwable("web view is null"));
            return;
        }
        WebKitViewInitParams webKitViewInitParams = this.initParams;
        if (webKitViewInitParams == null || (webkitModel = webKitViewInitParams.getWebkitModel()) == null || (overScrollModel = webkitModel.getOverScrollModel()) == null || (value = overScrollModel.getValue()) == null || ((i = value.intValue()) != 0 && i != 1 && i != 2)) {
            i = 0;
        }
        SSWebView sSWebView = this.realView;
        Intrinsics.checkNotNull(sSWebView);
        sSWebView.setOverScrollMode(i);
        LollipopV21Compat.setAcceptThirdPartyCookies((WebView) this.realView, true);
        WebViewContainer webViewContainer = this.realView;
        Intrinsics.checkNotNull(webViewContainer);
        initMonitorConfig((WebView) webViewContainer);
        SLMonitorCompat sLMonitorCompat = SLMonitorCompat.INSTANCE;
        WebViewContainer webViewContainer2 = this.realView;
        Intrinsics.checkNotNull(webViewContainer2);
        sLMonitorCompat.collectWebBaseField(sessionId, (WebView) webViewContainer2);
        IWebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.getInstance();
        WebViewContainer webViewContainer3 = this.realView;
        Intrinsics.checkNotNull(webViewContainer3);
        webViewMonitorHelper.handleViewCreate((WebView) webViewContainer3);
        lifeCycle.onKitViewCreate(parse, webKitView);
        AbsWebKitDelegate absWebKitDelegate = this.delegate;
        WebViewContainer webViewContainer4 = this.realView;
        Intrinsics.checkNotNull(webViewContainer4);
        absWebKitDelegate.onWebViewCreate((View) webViewContainer4, this);
        try {
            Result.Companion companion = Result.Companion;
            WebKitViewInitParams webKitViewInitParams2 = this.initParams;
            if (webKitViewInitParams2 == null || (webViewDelegate = webKitViewInitParams2.getWebViewDelegate()) == null) {
                unit = null;
            } else {
                for (WebViewClientDelegate webViewClientDelegate : webViewDelegate.getWebViewClientDispatcher().getWebViewClientDelegates()) {
                    if (webViewClientDelegate instanceof BulletWebViewClient) {
                        ((BulletWebViewClient) webViewClientDelegate).setWebKitViewService(this);
                    }
                }
                for (WebChromeClientDelegate webChromeClientDelegate : webViewDelegate.getWebChromeClientDispatcher().getWebChromeClientDelegates()) {
                    if (webChromeClientDelegate instanceof BulletWebChromeClient) {
                        ((BulletWebChromeClient) webChromeClientDelegate).setWebKitViewService(this);
                    }
                }
                unit = Unit.INSTANCE;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        loadInner(this.delegate.injectUrl(url), false, new ILoadUriListener() { // from class: com.bytedance.ies.bullet.kit.web.WebKitView$loadUri$2
            @Override // com.bytedance.ies.bullet.service.base.ILoadUriListener
            public void onLoadSuccess(String uri, IKitViewService kitView) {
                AbsWebKitDelegate absWebKitDelegate2;
                Intrinsics.checkNotNullParameter(uri, "uri");
                Intrinsics.checkNotNullParameter(kitView, "kitView");
                IBulletLifeCycle iBulletLifeCycle = IBulletLifeCycle.this;
                Uri uri2 = parse;
                Intrinsics.checkNotNullExpressionValue(uri2, "schemaUri");
                iBulletLifeCycle.onRuntimeReady(uri2, this);
                absWebKitDelegate2 = this.delegate;
                absWebKitDelegate2.onLoadSuccess();
                IBulletLifeCycle iBulletLifeCycle2 = IBulletLifeCycle.this;
                Uri uri3 = parse;
                Intrinsics.checkNotNullExpressionValue(uri3, "schemaUri");
                iBulletLifeCycle2.onLoadUriSuccess(uri3, kitView);
            }

            @Override // com.bytedance.ies.bullet.service.base.ILoadUriListener
            public void onLoadFailed(String uri, IKitViewService kitView, Throwable reason) {
                AbsWebKitDelegate absWebKitDelegate2;
                Intrinsics.checkNotNullParameter(uri, "uri");
                Intrinsics.checkNotNullParameter(kitView, "kitView");
                Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
                absWebKitDelegate2 = this.delegate;
                absWebKitDelegate2.onLoadFail();
                IBulletLifeCycle iBulletLifeCycle = IBulletLifeCycle.this;
                Uri uri2 = parse;
                Intrinsics.checkNotNullExpressionValue(uri2, "schemaUri");
                iBulletLifeCycle.onLoadFail(uri2, reason);
            }
        });
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    /* renamed from: getSessionId, reason: from getter */
    public String getCurrentSessionId() {
        return this.currentSessionId;
    }

    /* renamed from: realView, reason: collision with other method in class and from getter */
    public SSWebView getRealView() {
        return this.realView;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void load(String url, ILoadUriListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            return;
        }
        if (StringsKt.startsWith$default(url, "javascript:", false, 2, (Object) null)) {
            SSWebView sSWebView = this.realView;
            if (sSWebView != null) {
                sSWebView.loadUrl(url);
                return;
            }
            return;
        }
        loadInner(url, false, listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void loadInner(String loadUrl, boolean isReload, ILoadUriListener listener) {
        IWebViewLoadUrlInterceptorDelegate urlInterceptorDelegate;
        final SSWebView sSWebView = this.realView;
        if (sSWebView != 0) {
            this.isPageFinished = false;
            if (!isReload) {
                setCurrentUri(Uri.parse(loadUrl));
                setWebViewClient(loadUrl, listener);
                setWebChromeClientDelegate();
                setAdBlock();
                setSccDelegate(sSWebView);
                WebView webView = (WebView) sSWebView;
                setWebParams(webView);
                setLongClickable(webView);
                WebKitViewInitParams webKitViewInitParams = this.initParams;
                sSWebView.setEnableSafeWebJSBAuth(webKitViewInitParams != null ? Boolean.valueOf(webKitViewInitParams.getEnableSafeWebJSBAuth()) : null);
            }
            AbsWebKitDelegate absWebKitDelegate = this.delegate;
            Uri currentUri = getCurrentUri();
            Intrinsics.checkNotNull(currentUri);
            WebViewContainer webViewContainer = this.realView;
            Intrinsics.checkNotNull(webViewContainer);
            absWebKitDelegate.updateGlobalProps(currentUri, (View) webViewContainer);
            WebKitViewInitParams webKitViewInitParams2 = this.initParams;
            Function4<WebView, String, Map<String, String>, Function2<? super String, ? super Map<String, String>, Unit>, Unit> provideWebViewLoadUrlInterceptor = (webKitViewInitParams2 == null || (urlInterceptorDelegate = webKitViewInitParams2.getUrlInterceptorDelegate()) == null) ? null : urlInterceptorDelegate.provideWebViewLoadUrlInterceptor();
            this.delegate.getContext().getMonitorCallback().onWebLoadUrl();
            if (provideWebViewLoadUrlInterceptor != null) {
                String valueOf = String.valueOf(getCurrentUri());
                Map<String, String> additionalHttpHeaders = getAdditionalHttpHeaders();
                provideWebViewLoadUrlInterceptor.invoke(sSWebView, valueOf, additionalHttpHeaders != null ? MapsKt.toMutableMap(additionalHttpHeaders) : null, new Function2<String, Map<String, String>, Unit>() { // from class: com.bytedance.ies.bullet.kit.web.WebKitView$loadInner$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((String) obj, (Map<String, String>) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str, Map<String, String> map) {
                        Pair shouldSecureIntercept;
                        AbsWebKitDelegate absWebKitDelegate2;
                        AbsWebKitDelegate absWebKitDelegate3;
                        WebKitView.this.setCurrentUri(Uri.parse(str));
                        WebKitView webKitView = WebKitView.this;
                        webKitView.performForestDelayPreload(webKitView.getCurrentUri());
                        shouldSecureIntercept = WebKitView.this.shouldSecureIntercept(str, map);
                        String str2 = (String) shouldSecureIntercept.component1();
                        Map<String, String> map2 = (Map) shouldSecureIntercept.component2();
                        absWebKitDelegate2 = WebKitView.this.delegate;
                        if (absWebKitDelegate2.isDelegateLoadUrl(str2)) {
                            absWebKitDelegate3 = WebKitView.this.delegate;
                            absWebKitDelegate3.delegateLoadUrl(sSWebView, str2, map2);
                        } else {
                            if (map == null || map.isEmpty()) {
                                sSWebView.loadUrl(str2, new ExtensionParam[0]);
                            } else {
                                sSWebView.loadUrl(str2, map2, new ExtensionParam[0]);
                            }
                        }
                    }
                });
                return;
            }
            if (getAdditionalHttpHeaders() != null) {
                performForestDelayPreload(getCurrentUri());
                Pair<String, Map<String, String>> shouldSecureIntercept = shouldSecureIntercept(String.valueOf(getCurrentUri()), getAdditionalHttpHeaders());
                String str = (String) shouldSecureIntercept.component1();
                Map<String, String> map = (Map) shouldSecureIntercept.component2();
                if (this.delegate.isDelegateLoadUrl(str)) {
                    this.delegate.delegateLoadUrl(sSWebView, str, map);
                    return;
                } else {
                    Intrinsics.checkNotNull(map);
                    sSWebView.loadUrl(str, map, new ExtensionParam[0]);
                    return;
                }
            }
            performForestDelayPreload(getCurrentUri());
            String str2 = (String) shouldSecureIntercept(String.valueOf(getCurrentUri()), null).getFirst();
            if (this.delegate.isDelegateLoadUrl(str2)) {
                AbsWebKitDelegate.delegateLoadUrl$default(this.delegate, sSWebView, str2, null, 4, null);
            } else {
                sSWebView.loadUrl(str2, new ExtensionParam[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, Map<String, String>> shouldSecureIntercept(String url, Map<String, String> headers) {
        ArgusWebDelegateAdapter argusWebDelegateAdapter;
        Pair<String, Map<String, String>> verifyAboutToLoadUrl$anniex_release;
        if (url == null) {
            return new Pair<>(url, headers);
        }
        WebViewContainer webViewContainer = this.realView;
        return (webViewContainer == null || (argusWebDelegateAdapter = this.argusAdapter) == null || (verifyAboutToLoadUrl$anniex_release = argusWebDelegateAdapter.verifyAboutToLoadUrl$anniex_release((WebView) webViewContainer, url, headers)) == null) ? new Pair<>(url, headers) : verifyAboutToLoadUrl$anniex_release;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performForestDelayPreload(Uri uri) {
        WebSettings settings;
        if (uri == null) {
            return;
        }
        BulletContext bulletContext = (BulletContext) getContext().getDependency(BulletContext.class);
        ForestPreloadHelper forestPreloadHelper = ForestPreloadHelper.INSTANCE;
        SSWebView sSWebView = this.realView;
        forestPreloadHelper.preloadPage(bulletContext, uri, (sSWebView == null || (settings = sSWebView.getSettings()) == null) ? null : settings.getUserAgentString(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCloseAll(WebView view, String url) {
        IBulletViewProvider.IBulletTitleBarProvider iBulletTitleBarProvider;
        IBulletViewProvider.IBulletTitleBar provideTitleBar;
        ImageView closeAllView;
        BDXPageModel uiModel;
        BooleanParam showCloseall;
        String str = url;
        if ((str == null || str.length() == 0) || Intrinsics.areEqual("about:blank", url)) {
            return;
        }
        IContextProviderFactory contextProviderFactory = getContextProviderFactory();
        ContextProviderFactory contextProviderFactory2 = contextProviderFactory instanceof ContextProviderFactory ? (ContextProviderFactory) contextProviderFactory : null;
        if (contextProviderFactory2 == null || (iBulletTitleBarProvider = (IBulletViewProvider.IBulletTitleBarProvider) contextProviderFactory2.provideInstance(IBulletViewProvider.IBulletTitleBarProvider.class)) == null || (provideTitleBar = iBulletTitleBarProvider.provideTitleBar()) == null || (closeAllView = provideTitleBar.getCloseAllView()) == null) {
            return;
        }
        WebKitViewInitParams webKitViewInitParams = this.initParams;
        if (!((webKitViewInitParams == null || (uiModel = webKitViewInitParams.getUiModel()) == null || (showCloseall = uiModel.getShowCloseall()) == null) ? false : Intrinsics.areEqual(showCloseall.getValue(), true))) {
            if (!(view != null && view.canGoBack())) {
                closeAllView.setVisibility(8);
                return;
            }
        }
        closeAllView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startNavigation(WebView view, String url) {
        AnnieXUIService.TitleBar titleBar;
        if (!Intrinsics.areEqual(url, "about:blank") && url != null) {
            this.currentUrl = url;
        }
        IContextProviderFactory contextProviderFactory = getContextProviderFactory();
        ContextProviderFactory contextProviderFactory2 = contextProviderFactory instanceof ContextProviderFactory ? (ContextProviderFactory) contextProviderFactory : null;
        if (contextProviderFactory2 == null || (titleBar = (AnnieXUIService.TitleBar) contextProviderFactory2.provideInstance(AnnieXUIService.TitleBar.class)) == null) {
            return;
        }
        titleBar.showCloseButton(!(view == null || view.copyBackForwardList().getCurrentIndex() == 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishNavigation(String url) {
        AnnieXSourceLabel annieXSourceLabel;
        String str;
        String substringAfter$default;
        if (IConditionCallKt.enableThirdPartyWebLogic(this.delegate.getContext())) {
            MonitorCenter.Companion.instance().onNavigateSuccess(getCurrentSessionId());
        }
        IContextProviderFactory contextProviderFactory = getContextProviderFactory();
        ContextProviderFactory contextProviderFactory2 = contextProviderFactory instanceof ContextProviderFactory ? (ContextProviderFactory) contextProviderFactory : null;
        if (contextProviderFactory2 == null || (annieXSourceLabel = (AnnieXSourceLabel) contextProviderFactory2.provideInstance(AnnieXSourceLabel.class)) == null) {
            return;
        }
        if (url == null || (substringAfter$default = StringsKt.substringAfter$default(url, "://", (String) null, 2, (Object) null)) == null || (str = StringsKt.substringBefore$default(substringAfter$default, '/', (String) null, 2, (Object) null)) == null) {
            str = "unknown";
        }
        annieXSourceLabel.updateSource$anniex_release(str);
    }

    private final void setWebViewClient(final String loadUrl, final ILoadUriListener listener) {
        BulletWebContext webContext;
        WebViewClient webViewClient;
        WebKitViewInitParams webKitViewInitParams;
        IWebViewDelegate webViewDelegate;
        WebViewClientDispatcher webViewClientDispatcher;
        WebKitViewInitParams webKitViewInitParams2;
        IWebViewDelegate webViewDelegate2;
        WebViewClientDispatcher webViewClientDispatcher2;
        MonitorSettingsConfig monitorSettingsConfig;
        IWebViewDelegate webViewDelegate3;
        WebViewClientDispatcher webViewClientDispatcher3;
        IWebViewDelegate webViewDelegate4;
        WebViewClientDispatcher webViewClientDispatcher4;
        BulletWebViewClient bulletWebViewClient = new BulletWebViewClient() { // from class: com.bytedance.ies.bullet.kit.web.WebKitView$setWebViewClient$webViewClient$1
            private boolean errorOccurred;

            public final boolean getErrorOccurred() {
                return this.errorOccurred;
            }

            public final void setErrorOccurred(boolean z) {
                this.errorOccurred = z;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                AbsWebKitDelegate absWebKitDelegate;
                boolean z;
                String str;
                WebKitView.this.finishNavigation(url);
                absWebKitDelegate = WebKitView.this.delegate;
                absWebKitDelegate.getContext().getMonitorCallback().onWebPageFinished();
                super.onPageFinished(view, url);
                if (view != null) {
                    WebKitView webKitView = WebKitView.this;
                    WebJsBridge.Companion companion = WebJsBridge.INSTANCE;
                    str = webKitView.currentSessionId;
                    companion.injectId(view, str);
                }
                WebKitView.this.showCloseAll(view, url);
                if (!this.errorOccurred) {
                    z = WebKitView.this.isPageFinished;
                    if (!z) {
                        ILoadUriListener iLoadUriListener = listener;
                        if (iLoadUriListener != null) {
                            iLoadUriListener.onLoadSuccess(loadUrl, WebKitView.this);
                        }
                        WebKitView.this.isPageFinished = true;
                    }
                }
                this.errorOccurred = false;
                BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, WebKitView.this.getCurrentSessionId(), "onPageFinished " + url, "XWebKit", null, 8, null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                boolean unused;
                unused = WebKitView.this.shouldResetPageStartUrlWhenReceivedError;
                this.errorOccurred = true;
                super.onReceivedError(view, errorCode, description, failingUrl);
                BulletLogger.INSTANCE.printCoreLog(WebKitView.this.getCurrentSessionId(), "onReceivedError errorCode:" + errorCode + ", description: " + description, "XWebKit", LogLevel.E);
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            
                r2 = r7.this$0.realView;
             */
            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate, android.webkit.WebViewClient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                ILoadUriListener iLoadUriListener;
                boolean z;
                SSWebView sSWebView;
                if (request != null && request.isForMainFrame()) {
                    z = WebKitView.this.shouldResetPageStartUrlWhenReceivedError;
                    if (z && sSWebView != null) {
                        sSWebView.setPageStartUrl("about:blank");
                    }
                    this.errorOccurred = true;
                }
                super.onReceivedError(view, request, error);
                BulletLogger.INSTANCE.printCoreLog(WebKitView.this.getCurrentSessionId(), "onReceivedError error:" + ((Object) (error != null ? error.getDescription() : null)) + ", isForMainFrame: " + (request != null ? Boolean.valueOf(request.isForMainFrame()) : null), "XWebKit", LogLevel.E);
                if (!(request != null && request.isForMainFrame()) || (iLoadUriListener = listener) == null) {
                    return;
                }
                String str = loadUrl;
                WebKitView webKitView = WebKitView.this;
                int errorCode = error != null ? error.getErrorCode() : 0;
                CharSequence description = error != null ? error.getDescription() : null;
                Uri url = request.getUrl();
                iLoadUriListener.onLoadFailed(str, webKitView, new WebLoadError(errorCode, description, url != null ? url.toString() : null));
            }

            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                String url;
                super.onReceivedHttpError(view, request, errorResponse);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "onReceivedHttpError: request=" + request + ", errorResponse=" + errorResponse, null, "XWebKit", 2, null);
                boolean z = false;
                if (request != null && request.isForMainFrame()) {
                    z = true;
                }
                if (z) {
                    if (IConditionCallKt.shouldIgnoreHttpStatusCode(errorResponse != null ? Integer.valueOf(errorResponse.getStatusCode()) : null)) {
                        return;
                    }
                    this.errorOccurred = true;
                    if (view == null || (url = view.getUrl()) == null) {
                        return;
                    }
                    Uri url2 = request.getUrl();
                    if (!Intrinsics.areEqual(url, url2 != null ? url2.toString() : null)) {
                        url = null;
                    }
                    if (url != null) {
                        ILoadUriListener iLoadUriListener = listener;
                        String str = loadUrl;
                        WebKitView webKitView = WebKitView.this;
                        if (iLoadUriListener != null) {
                            iLoadUriListener.onLoadFailed(str, webKitView, new WebLoadError(errorResponse != null ? errorResponse.getStatusCode() : 404, errorResponse != null ? errorResponse.getReasonPhrase() : null, url));
                        }
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
                super.onReceivedHttpAuthRequest(view, handler, host, realm);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "onReceivedHttpAuthRequest: host=" + host + ", realm=" + realm, null, "XWebKit", 2, null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                String url;
                String path;
                boolean z = true;
                this.errorOccurred = true;
                super.onReceivedSslError(view, handler, error);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "onReceivedSslError: error=" + error, null, "XWebKit", 2, null);
                String url2 = error != null ? error.getUrl() : null;
                if (url2 == null) {
                    url2 = "";
                }
                Uri parse = Uri.parse(url2);
                if (parse != null && (path = parse.getPath()) != null) {
                    z = StringsKt.contains$default(path, ".html", false, 2, (Object) null);
                }
                if (!z || view == null || (url = view.getUrl()) == null) {
                    return;
                }
                ILoadUriListener iLoadUriListener = listener;
                String str = loadUrl;
                WebKitView webKitView = WebKitView.this;
                if (iLoadUriListener != null) {
                    iLoadUriListener.onLoadFailed(str, webKitView, new WebLoadError(-100, error != null ? error.toString() : null, url));
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageCommitVisible(WebView view, String url) {
                SSWebView sSWebView;
                super.onPageCommitVisible(view, url);
                sSWebView = WebKitView.this.realView;
                if (sSWebView != null) {
                    sSWebView.setPageCommitVisibleUrl(url);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                AbsWebKitDelegate absWebKitDelegate;
                AbsWebKitDelegate absWebKitDelegate2;
                SSWebView sSWebView;
                SccDelegate sccDelegate;
                SccConfig.SccLevel syncSecureLevel;
                absWebKitDelegate = WebKitView.this.delegate;
                absWebKitDelegate.getContext().getMonitorCallback().onWebPageStarted();
                absWebKitDelegate2 = WebKitView.this.delegate;
                absWebKitDelegate2.onPageStarted();
                super.onPageStarted(view, url, favicon);
                sSWebView = WebKitView.this.realView;
                if (sSWebView != null) {
                    sSWebView.setPageStartUrl(url);
                }
                WebKitView.this.startNavigation(view, url);
                if (url != null) {
                    WebKitView webKitView = WebKitView.this;
                    ILoadUriListener iLoadUriListener = listener;
                    sccDelegate = webKitView.sccDelegate;
                    if (sccDelegate != null && (syncSecureLevel = sccDelegate.syncSecureLevel(url)) != null) {
                        webKitView.sccLevel = syncSecureLevel;
                        if (syncSecureLevel != SccConfig.SccLevel.SAFE && iLoadUriListener != null) {
                            iLoadUriListener.onLoadFailed(url, webKitView, new WebLoadError(PatchException.ERR_INSTALL_PARSE_SO, "scc check failed", url));
                        }
                    }
                    SLMonitorCompat.reportReusePV$default(SLMonitorCompat.INSTANCE, webKitView.getCurrentSessionId(), (String) null, url, 2, (Object) null);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r0 = r1.this$0.sccDelegate;
             */
            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate, android.webkit.WebViewClient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                SccDelegate sccDelegate;
                if (url != null && sccDelegate != null) {
                    sccDelegate.doCheck(url);
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
            
                r1 = r2.this$0.sccDelegate;
             */
            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean shouldOverrideUrlLoading(WebView view, IWebResourceRequest request) {
                Uri url;
                String uri;
                SccDelegate sccDelegate;
                if (request != null && (url = request.getUrl()) != null && (uri = url.toString()) != null && sccDelegate != null) {
                    sccDelegate.doCheck(uri);
                }
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                boolean z;
                WebKitViewInitParams webKitViewInitParams3;
                AbsWebKitDelegate absWebKitDelegate;
                SccDelegate sccDelegate;
                WebResourceResponse shouldInterceptRequest;
                BDXWebKitModel webkitModel;
                BooleanParam skipIntercept;
                Boolean value;
                String str = url;
                boolean z2 = false;
                if (!(str == null || str.length() == 0)) {
                    WebResourceResponse shouldSecureDelegate = shouldSecureDelegate(view, url);
                    if (shouldSecureDelegate != null) {
                        return shouldSecureDelegate;
                    }
                    webKitViewInitParams3 = WebKitView.this.initParams;
                    if (webKitViewInitParams3 != null && (webkitModel = webKitViewInitParams3.getWebkitModel()) != null && (skipIntercept = webkitModel.getSkipIntercept()) != null && (value = skipIntercept.getValue()) != null) {
                        z2 = value.booleanValue();
                    }
                    if (!z2) {
                        absWebKitDelegate = WebKitView.this.delegate;
                        WebResourceResponse loadResource = absWebKitDelegate.loadResource(url);
                        if (loadResource != null) {
                            return loadResource;
                        }
                        sccDelegate = WebKitView.this.sccDelegate;
                        if (sccDelegate != null && (shouldInterceptRequest = sccDelegate.shouldInterceptRequest(url)) != null) {
                            return shouldInterceptRequest;
                        }
                    }
                }
                z = WebKitView.this.allowAdBlock;
                if (z) {
                    return WebKitView.this.onAdFilter();
                }
                return super.shouldInterceptRequest(view, url);
            }

            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                AbsWebKitDelegate absWebKitDelegate;
                WebKitViewInitParams webKitViewInitParams3;
                boolean z;
                SccDelegate sccDelegate;
                AbsWebKitDelegate absWebKitDelegate2;
                AbsWebKitDelegate absWebKitDelegate3;
                WebKitViewInitParams webKitViewInitParams4;
                BDXWebKitModel webkitModel;
                BooleanParam interceptRequest;
                Boolean value;
                AbsWebKitDelegate absWebKitDelegate4;
                BDXWebKitModel webkitModel2;
                BooleanParam skipIntercept;
                Boolean value2;
                absWebKitDelegate = WebKitView.this.delegate;
                BulletContext context = absWebKitDelegate.getContext();
                boolean z2 = true;
                boolean z3 = WebKitView.this.useForest(context) && ((Boolean) ForestWebInfoHelper.DefaultImpls.canInterceptByForest$default(WebKitView.this, request, null, context, null, 10, null).getFirst()).booleanValue();
                WebResourceResponse shouldSecureDelegate = shouldSecureDelegate(view, request, z3);
                if (shouldSecureDelegate != null) {
                    return shouldSecureDelegate;
                }
                webKitViewInitParams3 = WebKitView.this.initParams;
                if (!((webKitViewInitParams3 == null || (webkitModel2 = webKitViewInitParams3.getWebkitModel()) == null || (skipIntercept = webkitModel2.getSkipIntercept()) == null || (value2 = skipIntercept.getValue()) == null) ? false : value2.booleanValue())) {
                    if (z3 && request != null) {
                        absWebKitDelegate4 = WebKitView.this.delegate;
                        WebResourceResponse loadPiaResource = absWebKitDelegate4.loadPiaResource(request);
                        if (loadPiaResource != null) {
                            context.getResourceContext().setResFrom("pia");
                            return loadPiaResource;
                        }
                    }
                    if (!z3) {
                        webKitViewInitParams4 = WebKitView.this.initParams;
                        z2 = (webKitViewInitParams4 == null || (webkitModel = webKitViewInitParams4.getWebkitModel()) == null || (interceptRequest = webkitModel.getInterceptRequest()) == null || (value = interceptRequest.getValue()) == null) ? false : value.booleanValue();
                    }
                    if (z2 && request != null) {
                        absWebKitDelegate3 = WebKitView.this.delegate;
                        WebResourceResponse loadResource = absWebKitDelegate3.loadResource(request);
                        if (loadResource != null) {
                            return loadResource;
                        }
                    }
                    if (request != null) {
                        WebKitView webKitView = WebKitView.this;
                        if (!z3) {
                            absWebKitDelegate2 = webKitView.delegate;
                            WebResourceResponse loadPiaResource2 = absWebKitDelegate2.loadPiaResource(request);
                            if (loadPiaResource2 != null) {
                                context.getResourceContext().setResFrom("pia");
                                return loadPiaResource2;
                            }
                        }
                        sccDelegate = webKitView.sccDelegate;
                        if (sccDelegate != null) {
                            String uri = request.getUrl().toString();
                            Intrinsics.checkNotNullExpressionValue(uri, "_request.url.toString()");
                            WebResourceResponse shouldInterceptRequest = sccDelegate.shouldInterceptRequest(uri);
                            if (shouldInterceptRequest != null) {
                                return shouldInterceptRequest;
                            }
                        }
                    }
                }
                z = WebKitView.this.allowAdBlock;
                if (z) {
                    return WebKitView.this.onAdFilter(request);
                }
                return super.shouldInterceptRequest(view, request);
            }

            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate, android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "onRenderProcessGone: detail=" + detail, null, "XWebKit", 2, null);
                return super.onRenderProcessGone(view, detail);
            }

            private final WebResourceResponse shouldSecureDelegate(WebView view, String url) {
                ArgusWebDelegateAdapter argusAdapter;
                ArgusWebResourceRequestRewritePayload verifyShouldInterceptRequest$anniex_release;
                SccDelegate sccDelegate;
                boolean z;
                WebResourceResponse shouldInterceptRequest;
                if (url == null || (argusAdapter = WebKitView.this.getArgusAdapter()) == null || (verifyShouldInterceptRequest$anniex_release = argusAdapter.verifyShouldInterceptRequest$anniex_release(view, url, null, false, true)) == null) {
                    return null;
                }
                WebKitView webKitView = WebKitView.this;
                WebResourceResponse response = verifyShouldInterceptRequest$anniex_release.getResponse();
                if (response != null) {
                    return response;
                }
                if (!Intrinsics.areEqual(verifyShouldInterceptRequest$anniex_release.getForceUseOriginNetwork(), true)) {
                    return null;
                }
                sccDelegate = webKitView.sccDelegate;
                if (sccDelegate != null && (shouldInterceptRequest = sccDelegate.shouldInterceptRequest(url)) != null) {
                    return shouldInterceptRequest;
                }
                z = webKitView.allowAdBlock;
                if (z) {
                    return webKitView.onAdFilter();
                }
                return super.shouldInterceptRequest(view, url);
            }

            private final WebResourceResponse shouldSecureDelegate(WebView view, WebResourceRequest request, boolean useForest) {
                ArgusWebDelegateAdapter argusAdapter;
                ArgusWebResourceRequestRewritePayload verifyShouldInterceptRequest$anniex_release;
                SccDelegate sccDelegate;
                boolean z;
                WebResourceResponse shouldInterceptRequest;
                Uri url;
                String uri = (request == null || (url = request.getUrl()) == null) ? null : url.toString();
                if (uri != null && (argusAdapter = WebKitView.this.getArgusAdapter()) != null && (verifyShouldInterceptRequest$anniex_release = argusAdapter.verifyShouldInterceptRequest$anniex_release(view, uri, request, useForest, false)) != null) {
                    WebKitView webKitView = WebKitView.this;
                    WebResourceResponse response = verifyShouldInterceptRequest$anniex_release.getResponse();
                    if (response != null) {
                        return response;
                    }
                    if (Intrinsics.areEqual(verifyShouldInterceptRequest$anniex_release.getForceUseOriginNetwork(), true)) {
                        sccDelegate = webKitView.sccDelegate;
                        if (sccDelegate != null && (shouldInterceptRequest = sccDelegate.shouldInterceptRequest(uri)) != null) {
                            return shouldInterceptRequest;
                        }
                        z = webKitView.allowAdBlock;
                        if (z) {
                            return webKitView.onAdFilter(request);
                        }
                        return super.shouldInterceptRequest(view, request);
                    }
                }
                return null;
            }
        };
        WebKitViewInitParams webKitViewInitParams3 = this.initParams;
        boolean z = false;
        if (webKitViewInitParams3 != null && (webViewDelegate4 = webKitViewInitParams3.getWebViewDelegate()) != null && (webViewClientDispatcher4 = webViewDelegate4.getWebViewClientDispatcher()) != null) {
            webViewClientDispatcher4.addWebViewClient(0, bulletWebViewClient);
        }
        WebKitViewInitParams webKitViewInitParams4 = this.initParams;
        if (webKitViewInitParams4 != null && (webViewDelegate3 = webKitViewInitParams4.getWebViewDelegate()) != null && (webViewClientDispatcher3 = webViewDelegate3.getWebViewClientDispatcher()) != null) {
            webViewClientDispatcher3.addWebViewClient(new MonitorWebViewClient());
        }
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService != null && (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) != null) {
            z = monitorSettingsConfig.getWebSSPReport();
        }
        if (z && (webKitViewInitParams2 = this.initParams) != null && (webViewDelegate2 = webKitViewInitParams2.getWebViewDelegate()) != null && (webViewClientDispatcher2 = webViewDelegate2.getWebViewClientDispatcher()) != null) {
            webViewClientDispatcher2.addWebViewClient(new SSPMonitorWebViewClient());
        }
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(getCurrentSessionId());
        if (context == null || (webContext = context.getWebContext()) == null || (webViewClient = webContext.getWebViewClient()) == null || (webKitViewInitParams = this.initParams) == null || (webViewDelegate = webKitViewInitParams.getWebViewDelegate()) == null || (webViewClientDispatcher = webViewDelegate.getWebViewClientDispatcher()) == null) {
            return;
        }
        webViewClientDispatcher.addWebViewClient(new AnnieXWebViewClient(webViewClient));
    }

    private final void setWebChromeClientDelegate() {
        IWebViewDelegate webViewDelegate;
        WebChromeClientDispatcher webChromeClientDispatcher;
        IWebViewDelegate webViewDelegate2;
        WebChromeClientDispatcher webChromeClientDispatcher2;
        BulletWebChromeClient bulletWebChromeClient = new BulletWebChromeClient() { // from class: com.bytedance.ies.bullet.kit.web.WebKitView$setWebChromeClientDelegate$webChromeClient$1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                AnnieXUIService.LoadingView loadingView;
                super.onProgressChanged(view, newProgress);
                IContextProviderFactory contextProviderFactory = WebKitView.this.getContextProviderFactory();
                ContextProviderFactory contextProviderFactory2 = contextProviderFactory instanceof ContextProviderFactory ? (ContextProviderFactory) contextProviderFactory : null;
                if (contextProviderFactory2 == null || (loadingView = (AnnieXUIService.LoadingView) contextProviderFactory2.provideInstance(AnnieXUIService.LoadingView.class)) == null) {
                    return;
                }
                loadingView.updateProgress(newProgress);
            }

            @Override // com.bytedance.ies.bullet.service.base.web.WebChromeClientDelegate, android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                WebKitViewInitParams webKitViewInitParams;
                BDXWebKitModel webkitModel;
                BooleanParam hideSystemVideoPoster;
                webKitViewInitParams = WebKitView.this.initParams;
                if ((webKitViewInitParams == null || (webkitModel = webKitViewInitParams.getWebkitModel()) == null || (hideSystemVideoPoster = webkitModel.getHideSystemVideoPoster()) == null) ? false : Intrinsics.areEqual(hideSystemVideoPoster.getValue(), true)) {
                    return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                }
                return super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                WebKitViewInitParams webKitViewInitParams;
                AnnieXUIService.TitleBar titleBar;
                BulletSettings provideBulletSettings;
                INavBarHost iNavBarHost;
                BDXPageModel uiModel;
                BooleanParam useWebviewTitle;
                if (title != null) {
                    WebKitView webKitView = WebKitView.this;
                    webKitViewInitParams = webKitView.initParams;
                    if ((webKitViewInitParams == null || (uiModel = webKitViewInitParams.getUiModel()) == null || (useWebviewTitle = uiModel.getUseWebviewTitle()) == null) ? false : Intrinsics.areEqual(useWebviewTitle.getValue(), true)) {
                        IContextProviderFactory contextProviderFactory = webKitView.getContextProviderFactory();
                        ContextProviderFactory contextProviderFactory2 = contextProviderFactory instanceof ContextProviderFactory ? (ContextProviderFactory) contextProviderFactory : null;
                        if (contextProviderFactory2 != null && (iNavBarHost = (INavBarHost) contextProviderFactory2.provideInstance(INavBarHost.class)) != null) {
                            iNavBarHost.setTitle(title);
                        }
                    }
                    IContextProviderFactory contextProviderFactory3 = webKitView.getContextProviderFactory();
                    ContextProviderFactory contextProviderFactory4 = contextProviderFactory3 instanceof ContextProviderFactory ? (ContextProviderFactory) contextProviderFactory3 : null;
                    if (contextProviderFactory4 != null && (titleBar = (AnnieXUIService.TitleBar) contextProviderFactory4.provideInstance(AnnieXUIService.TitleBar.class)) != null) {
                        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
                        if ((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null || !provideBulletSettings.getShowTitle()) ? false : true) {
                            titleBar.setTitle(title);
                        }
                    }
                }
                super.onReceivedTitle(view, title);
            }
        };
        WebKitViewInitParams webKitViewInitParams = this.initParams;
        if (webKitViewInitParams != null && (webViewDelegate2 = webKitViewInitParams.getWebViewDelegate()) != null && (webChromeClientDispatcher2 = webViewDelegate2.getWebChromeClientDispatcher()) != null) {
            webChromeClientDispatcher2.addWebChromeClient(0, bulletWebChromeClient);
        }
        WebKitViewInitParams webKitViewInitParams2 = this.initParams;
        if (webKitViewInitParams2 == null || (webViewDelegate = webKitViewInitParams2.getWebViewDelegate()) == null || (webChromeClientDispatcher = webViewDelegate.getWebChromeClientDispatcher()) == null) {
            return;
        }
        webChromeClientDispatcher.addWebChromeClient(new MonitorChromeClient());
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public SccConfig.SccLevel getSccLevel() {
        return this.sccLevel;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void reloadCurrentUrl() {
        SccDelegate sccDelegate;
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            String url = sSWebView.getUrl();
            if (url != null && (sccDelegate = this.sccDelegate) != null) {
                sccDelegate.onUserAllow(url);
            }
            sSWebView.reload();
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void reload() {
        Uri currentUri = getCurrentUri();
        if (currentUri != null) {
            String uri = currentUri.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "it.toString()");
            loadInner(uri, true, null);
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void sendEvent(String eventName, Object params) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        sendEvent(eventName, params, true);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void sendEvent(String eventName, Object params, boolean useDelegate) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            try {
                Result.Companion companion = Result.Companion;
                BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "send event: " + eventName + " with " + new Gson().toJson(params), "XWebKit", null, 8, null);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        } else {
            BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "send event.", "XWebKit", null, 8, null);
        }
        if (this.delegate.provideEventHandler() != null && useDelegate) {
            IEventHandler provideEventHandler = this.delegate.provideEventHandler();
            if (provideEventHandler != null) {
                provideEventHandler.sendEvent(eventName, params, (View) this.realView);
                return;
            }
            return;
        }
        Object jSONObject = new JSONObject();
        if (params != null) {
            if (!(params instanceof JSONObject)) {
                params = jSONObject;
            }
            jSONObject = params;
        }
        sendEventWithJson(eventName, (JSONObject) jSONObject);
    }

    @Deprecated(message = "use sendEvent", replaceWith = @ReplaceWith(expression = "sendEvent(eventName, json)", imports = {}))
    private final void sendEventWithJson(String eventName, JSONObject json) {
        IWebJsBridge mWebJsBridge = getMWebJsBridge();
        if (mWebJsBridge != null) {
            mWebJsBridge.sendJsEvent(eventName, json);
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void updateGlobalProps(Map<String, ? extends Object> globalprops) {
        Intrinsics.checkNotNullParameter(globalprops, "globalprops");
        if (IConditionCallKt.enableWebKitViewUpdateGlobalProps()) {
            this.delegate.updateGlobalProps((View) this.realView, globalprops);
        }
    }

    private final boolean isCachedView() {
        WebKitViewInitParams webKitViewInitParams = this.initParams;
        return webKitViewInitParams != null && webKitViewInitParams.getIsCachedView();
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void onShow() {
        SSWebView sSWebView;
        if (isCachedView() && this.reUsePageViewed.compareAndSet(false, true)) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "send pageReused event for reused view", null, "XWebKit", 2, null);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            Uri currentUri = getCurrentUri();
            if (currentUri != null) {
                Set<String> queryParameterNames = currentUri.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
                for (String str : queryParameterNames) {
                    jSONObject2.put(str, currentUri.getQueryParameter(str));
                }
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("queryItems", jSONObject2);
            Unit unit2 = Unit.INSTANCE;
            sendEvent(EVENT_VIEW_REUSED, jSONObject);
        }
        SSWebView sSWebView2 = this.realView;
        if (sSWebView2 != null) {
            sSWebView2.onResume();
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("isViewFirstAppeared", this.isViewFirstAppeared);
        Unit unit3 = Unit.INSTANCE;
        jSONObject3.put("data", jSONObject4);
        Unit unit4 = Unit.INSTANCE;
        sendEvent(EVENT_VIEW_APPEARED, jSONObject3);
        this.isViewFirstAppeared = false;
        SSWebView sSWebView3 = this.realView;
        if ((sSWebView3 != null ? sSWebView3.getActionModeProvider() : null) == null && (sSWebView = this.realView) != null) {
            sSWebView.showSearchMode(this.delegate.getContext().getWebContext().getActionModeProvider());
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "kitView status:on show", "XWebKit", null, 8, null);
    }

    private final void setLongClickable(WebView webView) {
        BDXWebKitModel webkitModel;
        WebKitViewInitParams webKitViewInitParams = this.initParams;
        if (webKitViewInitParams == null || (webkitModel = webKitViewInitParams.getWebkitModel()) == null) {
            return;
        }
        if (IConditionCallKt.enableThirdPartyWebLogic(this.delegate.getContext())) {
            ILongClickListenerProvider longClickListenerProvider = this.delegate.getContext().getWebContext().getLongClickListenerProvider();
            View.OnLongClickListener provideLongClickListener = longClickListenerProvider != null ? longClickListenerProvider.provideLongClickListener() : null;
            if (provideLongClickListener != null) {
                webView.setLongClickable(true);
                webView.setOnLongClickListener(provideLongClickListener);
                return;
            }
        }
        Boolean value = webkitModel.getDisableSaveImage().getValue();
        boolean booleanValue = value != null ? value.booleanValue() : false;
        webView.setLongClickable(!booleanValue);
        if (booleanValue) {
            webView.setOnLongClickListener(null);
        }
    }

    private final void setWebParams(WebView webView) {
        BDXWebKitModel webkitModel;
        StringParam webBgColor;
        BDXWebKitModel webkitModel2;
        StringParam webBgColor2;
        WebKitViewInitParams webKitViewInitParams = this.initParams;
        String str = null;
        if (((webKitViewInitParams == null || (webkitModel2 = webKitViewInitParams.getWebkitModel()) == null || (webBgColor2 = webkitModel2.getWebBgColor()) == null) ? null : webBgColor2.getValue()) != null) {
            WebKitViewInitParams webKitViewInitParams2 = this.initParams;
            if (webKitViewInitParams2 != null && (webkitModel = webKitViewInitParams2.getWebkitModel()) != null && (webBgColor = webkitModel.getWebBgColor()) != null) {
                str = webBgColor.getValue();
            }
            if (!Intrinsics.areEqual(str, "transparent")) {
                return;
            }
        }
        webView.setBackgroundColor(0);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void onHide() {
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        sendEvent(EVENT_VIEW_DISAPPEARED, null);
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "kitView status:on hide", "XWebKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public boolean onBackPressed() {
        if (this.sccLevel != SccConfig.SccLevel.SAFE) {
            return false;
        }
        SSWebView sSWebView = this.realView;
        if (!(sSWebView != null && sSWebView.canGoBack())) {
            return false;
        }
        SSWebView sSWebView2 = this.realView;
        if (sSWebView2 != null) {
            sSWebView2.goBack();
        }
        return true;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void destroy(boolean useDelegate) {
        this.delegate.release(this);
        ForestLoader.INSTANCE.release(sessionID(getContext()));
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            sSWebView.setWebChromeClient(null);
            sSWebView.setWebViewClient(new WebViewClient());
            try {
                sSWebView.destroy();
            } catch (Throwable th) {
                BulletLogger.printCoreReject$default(BulletLogger.INSTANCE, getCurrentSessionId(), "WebKitView destroy exception", "XWebKit", th, null, 16, null);
            }
        }
        WebViewMonitorHelper.getInstance().removeConfig(new String[]{SSWebView.class.getName()});
        ArgusWebDelegateAdapter argusWebDelegateAdapter = this.argusAdapter;
        if (argusWebDelegateAdapter != null) {
            argusWebDelegateAdapter.onViewDestroy$anniex_release();
        }
        this.argusAdapter = null;
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "kitView status:destroy", "XWebKit", null, 8, null);
    }

    private final void setAdBlock() {
        BulletSettings provideBulletSettings;
        BDXWebKitModel webkitModel;
        BooleanParam adBlock;
        if (this.kitService.getIsTTWeb()) {
            WebKitViewInitParams webKitViewInitParams = this.initParams;
            if ((webKitViewInitParams == null || (webkitModel = webKitViewInitParams.getWebkitModel()) == null || (adBlock = webkitModel.getAdBlock()) == null) ? false : Intrinsics.areEqual(adBlock.getValue(), true)) {
                this.allowAdBlock = true;
                return;
            }
            ISettingService iSettingService = (ISettingService) this.kitService.getService(ISettingService.class);
            List<String> webViewAdBlockList = (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? null : provideBulletSettings.getWebViewAdBlockList();
            if (webViewAdBlockList != null) {
                for (String str : webViewAdBlockList) {
                    Uri currentUri = getCurrentUri();
                    if (Intrinsics.areEqual(currentUri != null ? currentUri.getHost() : null, str)) {
                        this.allowAdBlock = true;
                    }
                }
            }
        }
    }

    private final void setSccDelegate(SSWebView webView) {
        WebKitViewInitParams webKitViewInitParams;
        SccConfig sccConfig;
        JsonObject jsonObject$anniex_release;
        INetworkDepend networkDepend;
        if (this.kitService.getIsTTWeb() || (webKitViewInitParams = this.initParams) == null || (sccConfig = webKitViewInitParams.getSccConfig()) == null || (jsonObject$anniex_release = sccConfig.toJsonObject$anniex_release()) == null || (networkDepend = webKitViewInitParams.getNetworkDepend()) == null) {
            return;
        }
        SccDelegate sccDelegate = new SccDelegate(jsonObject$anniex_release, networkDepend);
        this.sccDelegate = sccDelegate;
        webView.setSccDelegate$anniex_release(sccDelegate);
    }

    public final WebResourceResponse onAdFilter() {
        WebResourceResponse webResourceResponse = new WebResourceResponse(SccDelegate.MIMETYPE_TEXT_PLAIN, "UTF-8", new ByteArrayInputStream(new byte[0]));
        HashMap hashMap = new HashMap();
        hashMap.put("ttweb_adblock", "");
        webResourceResponse.setResponseHeaders(hashMap);
        return webResourceResponse;
    }

    public final WebResourceResponse onAdFilter(WebResourceRequest request) {
        Map<String, String> requestHeaders = request != null ? request.getRequestHeaders() : null;
        if (requestHeaders == null || !requestHeaders.containsKey("ttweb_adblock") || !Intrinsics.areEqual(requestHeaders.get("ttweb_adblock"), RouterConstants.TRUE)) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(SccDelegate.MIMETYPE_TEXT_PLAIN, "UTF-8", new ByteArrayInputStream(new byte[0]));
        HashMap hashMap = new HashMap();
        hashMap.put("ttweb_adblock", "");
        webResourceResponse.setResponseHeaders(hashMap);
        return webResourceResponse;
    }
}
