package com.bytedance.ies.bullet.kit.web;

import com.bytedance.ies.bullet.core.BaseEngineGlobalConfig;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.export.BulletWebChromeClient;
import com.bytedance.ies.bullet.kit.web.export.BulletWebViewClient;
import com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig;
import com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDelegate;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebEngineGlobalConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010N\u001a\u00020O2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040QH\u0002J\u001e\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u00020T2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040QH\u0016J\u0010\u0010U\u001a\u00020(2\b\u0010V\u001a\u0004\u0018\u00010\u0004J\b\u0010W\u001a\u00020OH\u0016J\b\u0010X\u001a\u00020OH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0$¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u001c\u00101\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040$¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040$¢\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040$¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020A0$¢\u0006\b\n\u0000\u001a\u0004\bB\u0010&R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e0$¢\u0006\b\n\u0000\u001a\u0004\bD\u0010&R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020F0$¢\u0006\b\n\u0000\u001a\u0004\bG\u0010&R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006Y"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/WebEngineGlobalConfig;", "Lcom/bytedance/ies/bullet/core/BaseEngineGlobalConfig;", "()V", "bridgeScheme", "", "getBridgeScheme", "()Ljava/lang/String;", "setBridgeScheme", "(Ljava/lang/String;)V", "bridgeValidator", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig$IOpenJsbPermissionValidator;", "getBridgeValidator", "()Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig$IOpenJsbPermissionValidator;", "setBridgeValidator", "(Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig$IOpenJsbPermissionValidator;)V", "customAuthenticators", "", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/Authenticator;", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthPriority;", "getCustomAuthenticators", "()Ljava/util/Map;", "setCustomAuthenticators", "(Ljava/util/Map;)V", "customWebSettings", "Lcom/bytedance/ies/bullet/kit/web/CustomWebSettings;", "getCustomWebSettings", "()Lcom/bytedance/ies/bullet/kit/web/CustomWebSettings;", "setCustomWebSettings", "(Lcom/bytedance/ies/bullet/kit/web/CustomWebSettings;)V", "defaultGlobalWebConfigService", "Lcom/bytedance/ies/bullet/kit/web/service/IWebGlobalConfigService;", "getDefaultGlobalWebConfigService", "()Lcom/bytedance/ies/bullet/kit/web/service/IWebGlobalConfigService;", "setDefaultGlobalWebConfigService", "(Lcom/bytedance/ies/bullet/kit/web/service/IWebGlobalConfigService;)V", "ignoreGeckoSafeHost", "", "getIgnoreGeckoSafeHost", "()Ljava/util/List;", "jsBridgeDebug", "", "getJsBridgeDebug", "()Ljava/lang/Boolean;", "setJsBridgeDebug", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "jsInterfaceList", "Lcom/bytedance/ies/bullet/kit/web/IJavascriptInterfaceDelegate;", "getJsInterfaceList", "jsObjectName", "getJsObjectName", "setJsObjectName", "permissionCheckingListener", "Lcom/bytedance/ies/web/jsbridge2/IBridgePermissionConfigurator$PermissionCheckingListener;", "getPermissionCheckingListener", "()Lcom/bytedance/ies/web/jsbridge2/IBridgePermissionConfigurator$PermissionCheckingListener;", "setPermissionCheckingListener", "(Lcom/bytedance/ies/web/jsbridge2/IBridgePermissionConfigurator$PermissionCheckingListener;)V", "protectedFunc", "getProtectedFunc", "publicFunc", "getPublicFunc", "safeHost", "getSafeHost", "webChromeClientList", "Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDelegate;", "getWebChromeClientList", "webGlobalConfigServiceList", "getWebGlobalConfigServiceList", "webViewClientList", "Lcom/bytedance/ies/bullet/service/base/web/WebViewClientDelegate;", "getWebViewClientList", "webViewLoadUrlInterface", "Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "getWebViewLoadUrlInterface", "()Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "setWebViewLoadUrlInterface", "(Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;)V", "annieXConfig", "", "packageNames", "", "config", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "disableAllPermissionCheck", "uri", "reset", "updateGlobalProps", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebEngineGlobalConfig extends BaseEngineGlobalConfig {
    private String bridgeScheme;
    private IWebJsBridgeConfig.IOpenJsbPermissionValidator bridgeValidator;
    private CustomWebSettings customWebSettings;
    private IWebGlobalConfigService defaultGlobalWebConfigService;
    private Boolean jsBridgeDebug;
    private String jsObjectName;
    private IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener;
    private IWebViewLoadUrlInterceptorDelegate webViewLoadUrlInterface;
    private final List<IWebGlobalConfigService> webGlobalConfigServiceList = new ArrayList();
    private final List<WebViewClientDelegate> webViewClientList = new ArrayList();
    private final List<WebChromeClientDelegate> webChromeClientList = new ArrayList();
    private final List<IJavascriptInterfaceDelegate> jsInterfaceList = new ArrayList();
    private final List<String> safeHost = new ArrayList();
    private final List<String> ignoreGeckoSafeHost = new ArrayList();
    private final List<String> publicFunc = new ArrayList();
    private final List<String> protectedFunc = new ArrayList();
    private Map<Authenticator, AuthPriority> customAuthenticators = new LinkedHashMap();

    public final IWebGlobalConfigService getDefaultGlobalWebConfigService() {
        return this.defaultGlobalWebConfigService;
    }

    public final void setDefaultGlobalWebConfigService(IWebGlobalConfigService iWebGlobalConfigService) {
        this.defaultGlobalWebConfigService = iWebGlobalConfigService;
    }

    public final List<IWebGlobalConfigService> getWebGlobalConfigServiceList() {
        return this.webGlobalConfigServiceList;
    }

    public final List<WebViewClientDelegate> getWebViewClientList() {
        return this.webViewClientList;
    }

    public final List<WebChromeClientDelegate> getWebChromeClientList() {
        return this.webChromeClientList;
    }

    public final List<IJavascriptInterfaceDelegate> getJsInterfaceList() {
        return this.jsInterfaceList;
    }

    public final IWebViewLoadUrlInterceptorDelegate getWebViewLoadUrlInterface() {
        return this.webViewLoadUrlInterface;
    }

    public final void setWebViewLoadUrlInterface(IWebViewLoadUrlInterceptorDelegate iWebViewLoadUrlInterceptorDelegate) {
        this.webViewLoadUrlInterface = iWebViewLoadUrlInterceptorDelegate;
    }

    public final CustomWebSettings getCustomWebSettings() {
        return this.customWebSettings;
    }

    public final void setCustomWebSettings(CustomWebSettings customWebSettings) {
        this.customWebSettings = customWebSettings;
    }

    public final Boolean getJsBridgeDebug() {
        return this.jsBridgeDebug;
    }

    public final void setJsBridgeDebug(Boolean bool) {
        this.jsBridgeDebug = bool;
    }

    public final String getJsObjectName() {
        return this.jsObjectName;
    }

    public final void setJsObjectName(String str) {
        this.jsObjectName = str;
    }

    public final String getBridgeScheme() {
        return this.bridgeScheme;
    }

    public final void setBridgeScheme(String str) {
        this.bridgeScheme = str;
    }

    public final List<String> getSafeHost() {
        return this.safeHost;
    }

    public final List<String> getIgnoreGeckoSafeHost() {
        return this.ignoreGeckoSafeHost;
    }

    public final List<String> getPublicFunc() {
        return this.publicFunc;
    }

    public final List<String> getProtectedFunc() {
        return this.protectedFunc;
    }

    public final IWebJsBridgeConfig.IOpenJsbPermissionValidator getBridgeValidator() {
        return this.bridgeValidator;
    }

    public final void setBridgeValidator(IWebJsBridgeConfig.IOpenJsbPermissionValidator iOpenJsbPermissionValidator) {
        this.bridgeValidator = iOpenJsbPermissionValidator;
    }

    public final IBridgePermissionConfigurator.PermissionCheckingListener getPermissionCheckingListener() {
        return this.permissionCheckingListener;
    }

    public final void setPermissionCheckingListener(IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener) {
        this.permissionCheckingListener = permissionCheckingListener;
    }

    public final Map<Authenticator, AuthPriority> getCustomAuthenticators() {
        return this.customAuthenticators;
    }

    public final void setCustomAuthenticators(Map<Authenticator, AuthPriority> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.customAuthenticators = map;
    }

    @Override // com.bytedance.ies.bullet.core.BaseEngineGlobalConfig, com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void reset() {
        super.reset();
        this.defaultGlobalWebConfigService = null;
        this.webGlobalConfigServiceList.clear();
        this.webViewClientList.clear();
        this.webChromeClientList.clear();
        this.jsInterfaceList.clear();
        this.webViewLoadUrlInterface = null;
        this.customWebSettings = null;
        this.jsBridgeDebug = null;
        this.jsObjectName = null;
        this.bridgeScheme = null;
        this.safeHost.clear();
        this.ignoreGeckoSafeHost.clear();
        this.publicFunc.clear();
        this.protectedFunc.clear();
        this.bridgeValidator = null;
    }

    @Override // com.bytedance.ies.bullet.core.BaseEngineGlobalConfig, com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void config(BulletContext bulletContext, List<String> packageNames) {
        IBulletLoadLifeCycle createKitViewLifecycleDelegate;
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        super.config(bulletContext, packageNames);
        if (bulletContext.getIsSimpleCard()) {
            annieXConfig(packageNames);
            return;
        }
        this.defaultGlobalWebConfigService = (IWebGlobalConfigService) ServiceCenter.INSTANCE.instance().get(getDefaultBid(), IWebGlobalConfigService.class);
        Iterator<T> it = packageNames.iterator();
        while (it.hasNext()) {
            IWebGlobalConfigService iWebGlobalConfigService = (IWebGlobalConfigService) ServiceCenter.INSTANCE.instance().get((String) it.next(), IWebGlobalConfigService.class);
            if (iWebGlobalConfigService != null && !Intrinsics.areEqual(iWebGlobalConfigService.getBid(), getDefaultBid())) {
                this.webGlobalConfigServiceList.add(iWebGlobalConfigService);
            }
        }
        final ContextProviderFactory providerFactory = ContextProviderManager.INSTANCE.getProviderFactory(bulletContext.getSessionId());
        Function1<IWebGlobalConfigService, Unit> function1 = new Function1<IWebGlobalConfigService, Unit>() { // from class: com.bytedance.ies.bullet.kit.web.WebEngineGlobalConfig$config$handler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IWebGlobalConfigService) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IWebGlobalConfigService iWebGlobalConfigService2) {
                Intrinsics.checkNotNullParameter(iWebGlobalConfigService2, "$this$null");
                BulletWebViewClient createWebViewClientDelegate = iWebGlobalConfigService2.createWebViewClientDelegate(ContextProviderFactory.this);
                if (createWebViewClientDelegate != null) {
                    this.getWebViewClientList().add(createWebViewClientDelegate);
                }
                BulletWebChromeClient createWebChromeClientDelegate = iWebGlobalConfigService2.createWebChromeClientDelegate(ContextProviderFactory.this);
                if (createWebChromeClientDelegate != null) {
                    this.getWebChromeClientList().add(createWebChromeClientDelegate);
                }
                IJavascriptInterfaceDelegate createJavascriptInterfaceDelegate = iWebGlobalConfigService2.createJavascriptInterfaceDelegate(ContextProviderFactory.this);
                if (createJavascriptInterfaceDelegate != null) {
                    this.getJsInterfaceList().add(createJavascriptInterfaceDelegate);
                }
                IWebViewLoadUrlInterceptorDelegate createWebViewLoadUrlInterceptorDelegate = iWebGlobalConfigService2.createWebViewLoadUrlInterceptorDelegate(ContextProviderFactory.this);
                if (createWebViewLoadUrlInterceptorDelegate != null) {
                    this.setWebViewLoadUrlInterface(createWebViewLoadUrlInterceptorDelegate);
                }
            }
        };
        for (IWebGlobalConfigService iWebGlobalConfigService2 : this.webGlobalConfigServiceList) {
            IBulletLoadLifeCycle createKitViewLifecycleDelegate2 = iWebGlobalConfigService2.createKitViewLifecycleDelegate(providerFactory);
            if (createKitViewLifecycleDelegate2 != null) {
                getBulletLifeCycleListenerList().add(createKitViewLifecycleDelegate2);
            }
            function1.invoke(iWebGlobalConfigService2);
        }
        IWebGlobalConfigService iWebGlobalConfigService3 = this.defaultGlobalWebConfigService;
        if (iWebGlobalConfigService3 != null && (createKitViewLifecycleDelegate = iWebGlobalConfigService3.createKitViewLifecycleDelegate(providerFactory)) != null) {
            getBulletLifeCycleListenerList().add(createKitViewLifecycleDelegate);
        }
        IWebGlobalConfigService iWebGlobalConfigService4 = this.defaultGlobalWebConfigService;
        if (iWebGlobalConfigService4 != null) {
            function1.invoke(iWebGlobalConfigService4);
        }
        BulletWebViewClient bulletWebViewClient = (BulletWebViewClient) providerFactory.provideInstance(BulletWebViewClient.class);
        if (bulletWebViewClient != null) {
            this.webViewClientList.add(bulletWebViewClient);
        }
        BulletWebChromeClient bulletWebChromeClient = (BulletWebChromeClient) providerFactory.provideInstance(BulletWebChromeClient.class);
        if (bulletWebChromeClient != null) {
            this.webChromeClientList.add(bulletWebChromeClient);
        }
        Function1<IWebGlobalConfigService, Unit> function12 = new Function1<IWebGlobalConfigService, Unit>() { // from class: com.bytedance.ies.bullet.kit.web.WebEngineGlobalConfig$config$settingsHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IWebGlobalConfigService) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IWebGlobalConfigService iWebGlobalConfigService5) {
                CustomWebSettings customWebSettings;
                Intrinsics.checkNotNullParameter(iWebGlobalConfigService5, "$this$null");
                if (WebEngineGlobalConfig.this.getCustomWebSettings() == null) {
                    WebEngineGlobalConfig.this.setCustomWebSettings(iWebGlobalConfigService5.createCustomSettings(providerFactory));
                } else {
                    CustomWebSettings createCustomSettings = iWebGlobalConfigService5.createCustomSettings(providerFactory);
                    if (createCustomSettings != null && (customWebSettings = WebEngineGlobalConfig.this.getCustomWebSettings()) != null) {
                        customWebSettings.merge(createCustomSettings, false);
                    }
                }
                IWebJsBridgeConfig provideWebJsBridgeConfig = iWebGlobalConfigService5.provideWebJsBridgeConfig(providerFactory);
                if (provideWebJsBridgeConfig != null) {
                    WebEngineGlobalConfig webEngineGlobalConfig = WebEngineGlobalConfig.this;
                    Boolean jsBridgeDebug = provideWebJsBridgeConfig.jsBridgeDebug();
                    if (jsBridgeDebug != null) {
                        webEngineGlobalConfig.setJsBridgeDebug(Boolean.valueOf(jsBridgeDebug.booleanValue()));
                    }
                    String jsObjectName = provideWebJsBridgeConfig.jsObjectName();
                    if (jsObjectName != null) {
                        webEngineGlobalConfig.setJsObjectName(jsObjectName);
                    }
                    String bridgeScheme = provideWebJsBridgeConfig.bridgeScheme();
                    if (bridgeScheme != null) {
                        webEngineGlobalConfig.setBridgeScheme(bridgeScheme);
                    }
                    List<String> safeHost = provideWebJsBridgeConfig.getSafeHost();
                    if (safeHost != null) {
                        webEngineGlobalConfig.getSafeHost().addAll(safeHost);
                    }
                    List<String> ignoreGeckoSafeHost = provideWebJsBridgeConfig.getIgnoreGeckoSafeHost();
                    if (ignoreGeckoSafeHost != null) {
                        webEngineGlobalConfig.getIgnoreGeckoSafeHost().addAll(ignoreGeckoSafeHost);
                    }
                    List<String> publicFunc = provideWebJsBridgeConfig.getPublicFunc();
                    if (publicFunc != null) {
                        webEngineGlobalConfig.getPublicFunc().addAll(publicFunc);
                    }
                    List<String> protectedFunc = provideWebJsBridgeConfig.getProtectedFunc();
                    if (protectedFunc != null) {
                        webEngineGlobalConfig.getProtectedFunc().addAll(protectedFunc);
                    }
                    IWebJsBridgeConfig.IOpenJsbPermissionValidator openJsbPermissionValidator = provideWebJsBridgeConfig.openJsbPermissionValidator();
                    if (openJsbPermissionValidator != null) {
                        webEngineGlobalConfig.setBridgeValidator(openJsbPermissionValidator);
                    }
                    IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener = provideWebJsBridgeConfig.permissionCheckingListener();
                    if (permissionCheckingListener != null) {
                        webEngineGlobalConfig.setPermissionCheckingListener(permissionCheckingListener);
                    }
                    Map<Authenticator, AuthPriority> addCustomAuthenticator = provideWebJsBridgeConfig.addCustomAuthenticator();
                    if (addCustomAuthenticator != null) {
                        webEngineGlobalConfig.getCustomAuthenticators().putAll(addCustomAuthenticator);
                    }
                }
            }
        };
        Iterator<T> it2 = this.webGlobalConfigServiceList.iterator();
        while (it2.hasNext()) {
            function12.invoke((IWebGlobalConfigService) it2.next());
        }
        IWebGlobalConfigService iWebGlobalConfigService5 = this.defaultGlobalWebConfigService;
        if (iWebGlobalConfigService5 != null) {
            function12.invoke(iWebGlobalConfigService5);
        }
        bulletContext.setBridgeRegistry(getBridgeRegistry());
        bulletContext.getBulletGlobalLifeCycleListenerList().clear();
        bulletContext.setBulletGlobalLifeCycleListenerList(getBulletLifeCycleListenerList());
    }

    private final void annieXConfig(List<String> packageNames) {
        this.defaultGlobalWebConfigService = (IWebGlobalConfigService) ServiceCenter.INSTANCE.instance().get(getDefaultBid(), IWebGlobalConfigService.class);
        Iterator<T> it = packageNames.iterator();
        while (it.hasNext()) {
            IWebGlobalConfigService iWebGlobalConfigService = (IWebGlobalConfigService) ServiceCenter.INSTANCE.instance().get((String) it.next(), IWebGlobalConfigService.class);
            if (iWebGlobalConfigService != null && !Intrinsics.areEqual(iWebGlobalConfigService.getBid(), getDefaultBid())) {
                this.webGlobalConfigServiceList.add(iWebGlobalConfigService);
            }
        }
    }

    public final boolean disableAllPermissionCheck(String uri) {
        IWebJsBridgeConfig provideWebJsBridgeConfig;
        Boolean disableAllPermissionCheck;
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        ContextProviderFactory providerFactory = contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null);
        IWebGlobalConfigService iWebGlobalConfigService = this.defaultGlobalWebConfigService;
        if (iWebGlobalConfigService == null || (provideWebJsBridgeConfig = iWebGlobalConfigService.provideWebJsBridgeConfig(providerFactory)) == null || (disableAllPermissionCheck = provideWebJsBridgeConfig.disableAllPermissionCheck(uri)) == null) {
            return false;
        }
        return disableAllPermissionCheck.booleanValue();
    }

    @Override // com.bytedance.ies.bullet.core.BaseEngineGlobalConfig, com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void updateGlobalProps() {
        Map<String, Object> constants;
        super.updateGlobalProps();
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        ContextProviderFactory providerFactory = contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null);
        Map<String, Object> globalProps = getGlobalProps();
        Iterator<T> it = this.webGlobalConfigServiceList.iterator();
        while (it.hasNext()) {
            Map<String, Object> constants2 = ((IWebGlobalConfigService) it.next()).getConstants(providerFactory);
            if (constants2 != null) {
                globalProps.putAll(constants2);
            }
        }
        IWebGlobalConfigService iWebGlobalConfigService = this.defaultGlobalWebConfigService;
        if (iWebGlobalConfigService == null || (constants = iWebGlobalConfigService.getConstants(providerFactory)) == null) {
            return;
        }
        globalProps.putAll(constants);
    }
}
