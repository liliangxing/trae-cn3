package com.bytedance.ies.bullet.secure;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.ies.argus.api.ArgusAPI;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.argus.api.params.ArgusOnWebViewCreatedParams;
import com.bytedance.ies.argus.api.params.ArgusOnWebViewCreatedRewritePayload;
import com.bytedance.ies.argus.api.params.ArgusRequestNetworkType;
import com.bytedance.ies.argus.api.params.ArgusWebResourceRequestParams;
import com.bytedance.ies.argus.api.params.ArgusWebResourceRequestRewritePayload;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.web.IWebSecureDelegate;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.web.IWebResourceRequest;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusWebDelegateAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B#\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u001cH\u0002J\r\u0010'\u001a\u00020$H\u0000¢\u0006\u0002\b(J\u001a\u0010)\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010)\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\u001cH\u0016JO\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010/\u0018\u00010.2\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u001c2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010/H\u0000¢\u0006\u0002\b1J\u0016\u00102\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u001cJB\u00102\u001a\u001a\u0012\u0004\u0012\u00020\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0/0.2\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u001c2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0/J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206J=\u00107\u001a\u0004\u0018\u0001082\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u00109\u001a\u0004\u0018\u00010\u001c2\b\u0010*\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\rH\u0000¢\u0006\u0002\b=R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001e¨\u0006?"}, d2 = {"Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;", "innerDelegate", "Lcom/bytedance/ies/argus/api/ArgusWebDelegate;", "externDelegate", "providerFactory", "Lcom/bytedance/ies/bullet/secure/SecureProviderFactory;", "(Lcom/bytedance/ies/argus/api/ArgusWebDelegate;Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;Lcom/bytedance/ies/bullet/secure/SecureProviderFactory;)V", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "hasTriggerHigherOverrideUrlLoading", "", "hasTriggerHigherShouldInterceptRequest", "getInnerDelegate", "()Lcom/bytedance/ies/argus/api/ArgusWebDelegate;", "monitorHelper", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback;", "getMonitorHelper", "()Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback;", "schema", "Landroid/net/Uri;", "getSchema", "()Landroid/net/Uri;", "schema$delegate", "Lkotlin/Lazy;", "secLinkScene", "", "getSecLinkScene", "()Ljava/lang/String;", "secLinkScene$delegate", "canGoBack", "webView", "Landroid/webkit/WebView;", "ensureSetup", "", "handleGoBack", "initSecLinkScene", "onViewDestroy", "onViewDestroy$anniex_release", "shouldOverrideUrlLoading", "request", "Lcom/bytedance/ies/bullet/service/base/web/IWebResourceRequest;", "url", "verifyAboutToLoadUrl", "Lkotlin/Pair;", "", "headers", "verifyAboutToLoadUrl$anniex_release", "verifyLoadUrl", "additionalHeaders", "verifyOnWebViewCreated", "view", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "verifyShouldInterceptRequest", "Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestRewritePayload;", "loadUrl", "Landroid/webkit/WebResourceRequest;", "useForest", "fromLowAPI", "verifyShouldInterceptRequest$anniex_release", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArgusWebDelegateAdapter extends IWebSecureDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IWebSecureDelegate externDelegate;
    private boolean hasTriggerHigherOverrideUrlLoading;
    private boolean hasTriggerHigherShouldInterceptRequest;
    private final ArgusWebDelegate innerDelegate;
    private final SecureProviderFactory providerFactory;

    /* renamed from: schema$delegate, reason: from kotlin metadata */
    private final Lazy schema;

    /* renamed from: secLinkScene$delegate, reason: from kotlin metadata */
    private final Lazy secLinkScene;

    public /* synthetic */ ArgusWebDelegateAdapter(ArgusWebDelegate argusWebDelegate, IWebSecureDelegate iWebSecureDelegate, SecureProviderFactory secureProviderFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(argusWebDelegate, iWebSecureDelegate, secureProviderFactory);
    }

    public final ArgusWebDelegate getInnerDelegate() {
        return this.innerDelegate;
    }

    /* compiled from: ArgusWebDelegateAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter$Companion;", "", "()V", "build", "Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "providerFactory", "Lcom/bytedance/ies/bullet/secure/SecureProviderFactory;", "view", "Landroid/webkit/WebView;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgusWebDelegateAdapter build(SecureProviderFactory providerFactory, WebView view) {
            ArgusContainerDelegate argusContainerDelegate;
            Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
            BulletContext context = providerFactory.getContext();
            if (context == null) {
                argusContainerDelegate = HybridSecureManager.INSTANCE.getInstance().initArgusSecureDelegate();
            } else {
                argusContainerDelegate = context.getArgusContainerDelegate();
            }
            IWebSecureDelegate iWebSecureDelegate = null;
            if (argusContainerDelegate != null) {
                return new ArgusWebDelegateAdapter(ArgusAPI.INSTANCE.initWebDelegate(argusContainerDelegate, view), iWebSecureDelegate, providerFactory, iWebSecureDelegate);
            }
            IWebSecureDelegate externDelegate = Intrinsics.areEqual(providerFactory.enablePIA(), true) ? null : providerFactory.getExternDelegate();
            if (externDelegate != null) {
                return new ArgusWebDelegateAdapter(iWebSecureDelegate, externDelegate, providerFactory, iWebSecureDelegate);
            }
            return null;
        }
    }

    private ArgusWebDelegateAdapter(ArgusWebDelegate argusWebDelegate, IWebSecureDelegate iWebSecureDelegate, SecureProviderFactory secureProviderFactory) {
        this.innerDelegate = argusWebDelegate;
        this.externDelegate = iWebSecureDelegate;
        this.providerFactory = secureProviderFactory;
        this.secLinkScene = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter$secLinkScene$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                String initSecLinkScene;
                initSecLinkScene = ArgusWebDelegateAdapter.this.initSecLinkScene();
                return initSecLinkScene;
            }
        });
        this.schema = LazyKt.lazy(new Function0<Uri>() { // from class: com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter$schema$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Uri m549invoke() {
                SecureProviderFactory secureProviderFactory2;
                ISchemaData schemaData;
                secureProviderFactory2 = ArgusWebDelegateAdapter.this.providerFactory;
                BulletContext context = secureProviderFactory2.getContext();
                if (context == null || (schemaData = context.getSchemaData()) == null) {
                    return null;
                }
                return schemaData.getInnerOriginUrl();
            }
        });
        ensureSetup();
    }

    private final String getSecLinkScene() {
        return (String) this.secLinkScene.getValue();
    }

    private final BulletContext getBulletContext() {
        return this.providerFactory.getContext();
    }

    private final AbsBulletMonitorCallback getMonitorHelper() {
        BulletContext bulletContext = getBulletContext();
        if (bulletContext != null) {
            return bulletContext.getMonitorCallback();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String initSecLinkScene() {
        Boolean bool;
        CommonConfig commonConfig;
        List<String> webForceDeeplinkUrls;
        Object obj;
        String secLinkScene = this.providerFactory.getSecLinkScene();
        if (secLinkScene != null) {
            return secLinkScene;
        }
        String schema = this.providerFactory.getSchema();
        if (schema == null) {
            return null;
        }
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (webForceDeeplinkUrls = commonConfig.getWebForceDeeplinkUrls()) == null) {
            bool = null;
        } else {
            List<String> list = webForceDeeplinkUrls;
            boolean z = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    try {
                        Result.Companion companion = Result.Companion;
                        obj = Result.constructor-impl(Boolean.valueOf(Pattern.compile(str).matcher(schema).find()));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        z = true;
                        break;
                    }
                }
            }
            bool = Boolean.valueOf(z);
        }
        if (Intrinsics.areEqual(bool, true)) {
            return "deeplink";
        }
        return null;
    }

    private final Uri getSchema() {
        return (Uri) this.schema.getValue();
    }

    private final void ensureSetup() {
        ArgusWebDelegate argusWebDelegate = this.innerDelegate;
        if (argusWebDelegate != null) {
            argusWebDelegate.ensureCheckRouterRisk(getSecLinkScene(), ArgusWebDelegateAdapterKt.initArgusContainerCreatedParams(getBulletContext(), ArgusContainerCreateType.View));
        }
    }

    public final String verifyLoadUrl(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        return (String) verifyLoadUrl(webView, url, MapsKt.emptyMap()).getFirst();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<String, Map<String, String>> verifyLoadUrl(WebView webView, String url, Map<String, String> additionalHeaders) {
        String buildSecureLink;
        Map<String, String> map;
        AbsBulletMonitorCallback monitorHelper;
        String str = url;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(additionalHeaders, "additionalHeaders");
        AbsBulletMonitorCallback monitorHelper2 = getMonitorHelper();
        if (monitorHelper2 != null) {
            monitorHelper2.recordSecurityEventTime(MetricConstant.SEC_WEB_LOAD_URL_START);
        }
        ArgusWebDelegate argusWebDelegate = this.innerDelegate;
        if (argusWebDelegate != null) {
            WebLoadUrlRewritePayload rewritePayload = argusWebDelegate.verifyLoadUrl(webView, new WebLoadUrlParams(url, getSecLinkScene(), (Uri) null, (Boolean) null, (Boolean) null, (Boolean) null, (CharSequence) null, additionalHeaders, 124, (DefaultConstructorMarker) null)).getRewritePayload();
            if (rewritePayload != null) {
                String url2 = rewritePayload.getUrl();
                if (!LoaderUtil.INSTANCE.isNotNullOrEmpty(url2)) {
                    url2 = null;
                }
                if (url2 != null) {
                    str = url2;
                }
                Map headers = rewritePayload.getHeaders();
                if (headers != null) {
                    LinkedHashMap mutableMap = MapsKt.toMutableMap(additionalHeaders);
                    if (mutableMap == null) {
                        mutableMap = new LinkedHashMap();
                    }
                    for (Map.Entry entry : headers.entrySet()) {
                        mutableMap.put((String) entry.getKey(), (String) entry.getValue());
                    }
                    map = MapsKt.toMap(mutableMap);
                    monitorHelper = getMonitorHelper();
                    if (monitorHelper != null) {
                        monitorHelper.recordSecurityEventTime(MetricConstant.SEC_WEB_LOAD_URL_END);
                    }
                    return new Pair<>(str, map);
                }
            }
        } else {
            IWebSecureDelegate iWebSecureDelegate = this.externDelegate;
            if (iWebSecureDelegate != null && (buildSecureLink = iWebSecureDelegate.buildSecureLink(webView, str)) != null) {
                str = buildSecureLink;
            }
        }
        map = additionalHeaders;
        monitorHelper = getMonitorHelper();
        if (monitorHelper != null) {
        }
        return new Pair<>(str, map);
    }

    @Override // com.bytedance.ies.bullet.kit.web.IWebSecureDelegate
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        boolean z = false;
        if (url != null && !this.hasTriggerHigherOverrideUrlLoading) {
            AbsBulletMonitorCallback monitorHelper = getMonitorHelper();
            if (monitorHelper != null) {
                monitorHelper.recordSecurityEventTime(MetricConstant.SEC_WEB_REDIRECT_START);
            }
            ArgusWebDelegate argusWebDelegate = this.innerDelegate;
            if (argusWebDelegate != null) {
                if (argusWebDelegate.verifyShouldOverrideUrlLoading(webView, new WebLoadUrlParams(url, getSecLinkScene(), (Uri) null, (Boolean) null, (Boolean) null, (Boolean) null, (CharSequence) null, (Map) null, 252, (DefaultConstructorMarker) null)).getAction() == ArgusVerifyAction.BLOCK) {
                    z = true;
                }
            } else {
                IWebSecureDelegate iWebSecureDelegate = this.externDelegate;
                if (iWebSecureDelegate != null) {
                    iWebSecureDelegate.shouldOverrideUrlLoading(webView, url);
                }
            }
            AbsBulletMonitorCallback monitorHelper2 = getMonitorHelper();
            if (monitorHelper2 != null) {
                monitorHelper2.recordSecurityEventTime(MetricConstant.SEC_WEB_REDIRECT_END);
            }
        }
        return z;
    }

    @Override // com.bytedance.ies.bullet.kit.web.IWebSecureDelegate
    public boolean shouldOverrideUrlLoading(WebView webView, IWebResourceRequest request) {
        Uri url;
        Intrinsics.checkNotNullParameter(webView, "webView");
        boolean z = false;
        if (request != null && (url = request.getUrl()) != null) {
            AbsBulletMonitorCallback monitorHelper = getMonitorHelper();
            if (monitorHelper != null) {
                monitorHelper.recordSecurityEventTime(MetricConstant.SEC_WEB_REDIRECT_START);
            }
            ArgusWebDelegate argusWebDelegate = this.innerDelegate;
            if (argusWebDelegate != null) {
                String uri = url.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
                if (argusWebDelegate.verifyShouldOverrideUrlLoading(webView, new WebLoadUrlParams(uri, getSecLinkScene(), (Uri) null, Boolean.valueOf(request.isForMainFrame()), Boolean.valueOf(request.isRedirect()), Boolean.valueOf(request.getHasGesture()), request.getMethod(), request.getRequestHeaders(), 4, (DefaultConstructorMarker) null)).getAction() == ArgusVerifyAction.BLOCK) {
                    z = true;
                }
            } else {
                IWebSecureDelegate iWebSecureDelegate = this.externDelegate;
                if (iWebSecureDelegate != null) {
                    iWebSecureDelegate.shouldOverrideUrlLoading(webView, request);
                }
            }
            this.hasTriggerHigherOverrideUrlLoading = true;
            AbsBulletMonitorCallback monitorHelper2 = getMonitorHelper();
            if (monitorHelper2 != null) {
                monitorHelper2.recordSecurityEventTime(MetricConstant.SEC_WEB_REDIRECT_END);
            }
        }
        return z;
    }

    @Override // com.bytedance.ies.bullet.kit.web.IWebSecureDelegate
    public boolean canGoBack(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        ArgusWebDelegate argusWebDelegate = this.innerDelegate;
        if (argusWebDelegate != null) {
            return argusWebDelegate.verifyCanGoBack(webView).isPass();
        }
        IWebSecureDelegate iWebSecureDelegate = this.externDelegate;
        if (iWebSecureDelegate != null) {
            return iWebSecureDelegate.canGoBack(webView);
        }
        return true;
    }

    @Override // com.bytedance.ies.bullet.kit.web.IWebSecureDelegate
    public boolean handleGoBack(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        ArgusWebDelegate argusWebDelegate = this.innerDelegate;
        if (argusWebDelegate != null) {
            return argusWebDelegate.handleGoBack(webView).isBlock();
        }
        IWebSecureDelegate iWebSecureDelegate = this.externDelegate;
        if (iWebSecureDelegate != null) {
            return iWebSecureDelegate.handleGoBack(webView);
        }
        return false;
    }

    public final Pair<String, Map<String, String>> verifyAboutToLoadUrl$anniex_release(WebView webView, String url, Map<String, String> headers) {
        Map<String, String> map;
        AspectVerifyResult verifyAboutToLoadUrl;
        WebLoadUrlRewritePayload rewritePayload;
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(webView, "webView");
        String str = url;
        Intrinsics.checkNotNullParameter(str, "url");
        AbsBulletMonitorCallback monitorHelper = getMonitorHelper();
        if (monitorHelper != null) {
            monitorHelper.recordSecurityEventTime(MetricConstant.SEC_ABOUT_TO_LOAD_URL_START);
        }
        ArgusWebDelegate argusWebDelegate = this.innerDelegate;
        boolean z = false;
        if (argusWebDelegate == null || (verifyAboutToLoadUrl = argusWebDelegate.verifyAboutToLoadUrl(webView, new WebLoadUrlParams(url, getSecLinkScene(), (Uri) null, (Boolean) null, (Boolean) null, (Boolean) null, (CharSequence) null, headers, 124, (DefaultConstructorMarker) null))) == null || (rewritePayload = verifyAboutToLoadUrl.getRewritePayload()) == null) {
            map = headers;
        } else {
            String url2 = rewritePayload.getUrl();
            if (!LoaderUtil.INSTANCE.isNotNullOrEmpty(url2)) {
                url2 = null;
            }
            if (url2 != null) {
                str = url2;
            }
            Map headers2 = rewritePayload.getHeaders();
            if (headers2 != null) {
                if (headers == null || (linkedHashMap = MapsKt.toMutableMap(headers)) == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                for (Map.Entry entry : headers2.entrySet()) {
                    linkedHashMap.put((String) entry.getKey(), (String) entry.getValue());
                }
                map = MapsKt.toMap(linkedHashMap);
            } else {
                map = headers;
            }
            z = true;
        }
        AbsBulletMonitorCallback monitorHelper2 = getMonitorHelper();
        if (monitorHelper2 != null) {
            monitorHelper2.recordSecurityEventTime(MetricConstant.SEC_ABOUT_TO_LOAD_URL_END);
        }
        if (z) {
            return new Pair<>(str, map);
        }
        return null;
    }

    public final void onViewDestroy$anniex_release() {
        ArgusWebDelegate argusWebDelegate = this.innerDelegate;
        if (argusWebDelegate != null) {
            argusWebDelegate.monitorViewDestroy();
        }
    }

    public final ArgusWebResourceRequestRewritePayload verifyShouldInterceptRequest$anniex_release(WebView webView, String loadUrl, WebResourceRequest request, boolean useForest, boolean fromLowAPI) {
        AspectVerifyResult aspectVerifyResult;
        if (fromLowAPI && this.hasTriggerHigherShouldInterceptRequest) {
            return null;
        }
        if (!fromLowAPI) {
            this.hasTriggerHigherShouldInterceptRequest = true;
        }
        ArgusWebDelegate argusWebDelegate = this.innerDelegate;
        if (argusWebDelegate != null) {
            aspectVerifyResult = argusWebDelegate.verifyShouldInterceptRequest(webView, new ArgusWebResourceRequestParams(loadUrl, request, useForest ? ArgusRequestNetworkType.FOREST : ArgusRequestNetworkType.WEBVIEW));
        } else {
            aspectVerifyResult = null;
        }
        if (!(aspectVerifyResult != null && aspectVerifyResult.isRewrite())) {
            if (!(aspectVerifyResult != null && aspectVerifyResult.isBlock())) {
                return null;
            }
        }
        return aspectVerifyResult.getRewritePayload();
    }

    public final void verifyOnWebViewCreated(SSWebView view) {
        ArgusOnWebViewCreatedRewritePayload rewritePayload;
        String newUserAgent;
        Intrinsics.checkNotNullParameter(view, "view");
        String userAgentString = view.getSettings().getUserAgentString();
        ArgusWebDelegate argusWebDelegate = this.innerDelegate;
        if (argusWebDelegate != null) {
            Intrinsics.checkNotNullExpressionValue(userAgentString, "currentUserAgent");
            AspectVerifyResult verifyOnWebViewCreated = argusWebDelegate.verifyOnWebViewCreated(new ArgusOnWebViewCreatedParams(userAgentString, "anniex"));
            if (!verifyOnWebViewCreated.isRewrite() || (rewritePayload = verifyOnWebViewCreated.getRewritePayload()) == null || (newUserAgent = rewritePayload.getNewUserAgent()) == null) {
                return;
            }
            view.getSettings().setUserAgentString(newUserAgent);
        }
    }
}
