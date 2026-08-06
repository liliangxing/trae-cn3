package com.bytedance.android.anniex.ability;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import bolts.Task;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.optimize.prehandle.intercept.WebJSBResultIntercept;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.kit.service.BaseBridgeService;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.api.IContainerIDProvider;
import com.bytedance.ies.xbridge.utils.XReadableJSONUtils;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.optimize.ThreadOptConfig;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import com.bytedance.sdk.xbridge.cn.platform.web.protocol.IESJSBridgeSupport;
import com.bytedance.sdk.xbridge.cn.platform.web.protocol.JSB2Impl;
import com.bytedance.sdk.xbridge.cn.platform.web.protocol.JSB4Impl;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.service.IAnnieProSupport;
import com.bytedance.sdk.xbridge.cn.service.IContainerInstance;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p000.WebcastContainerInitializer;

/* compiled from: XBridgeWebHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J.\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J0\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J0\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\bH\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\bH\u0002¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/anniex/ability/XBridgeWebHelper;", "", "()V", "configBridgeThread", "", "webBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;", "annieXWebModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "getContextProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXContextProvider;", "bid", "", "getWebBridge", "context", "Landroid/content/Context;", "webViewModel", "webView", "Landroid/webkit/WebView;", "annieXWebKit", "Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "initBridge", "webBdxBridge", "initWebContextProvider", "injectWebLoadContextProvider", "webModel", "updateWebBridgeContext", "viewModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class XBridgeWebHelper {
    public static final XBridgeWebHelper INSTANCE = new XBridgeWebHelper();

    private XBridgeWebHelper() {
    }

    public final WebBDXBridge getWebBridge(Context context, final AnnieXWebModel webViewModel, WebView webView, AnnieXWebKit annieXWebKit, ContextProviderFactory contextProviderFactory) {
        String businessId;
        List createStatefulBridges;
        BulletSettings provideBulletSettings;
        BulletSettings provideBulletSettings2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webViewModel, "webViewModel");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(annieXWebKit, "annieXWebKit");
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        MonitorManager.INSTANCE.onJsbRegisterBegin(webViewModel.getSessionId());
        if (IConditionCallKt.enableLitePageBridgeFix()) {
            businessId = "webcast";
            if (!Intrinsics.areEqual(webViewModel.getBusinessId(), "webcast")) {
                businessId = "";
            }
        } else {
            businessId = webViewModel.getBusinessId();
        }
        final WebBDXBridge webBDXBridge = new WebBDXBridge(context, webViewModel.getSessionId(), webView, businessId, (ArgusWebDelegate) null, 16, (DefaultConstructorMarker) null);
        ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
        if ((iSettingService == null || (provideBulletSettings2 = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings2.getUseBDXbridge()) {
            webBDXBridge.setup(new WebBridgeProtocol[]{new IESJSBridgeSupport(businessId), new JSB2Impl(businessId), new JSB4Impl(businessId)});
        } else {
            webBDXBridge.setup(new WebBridgeProtocol[]{new IESJSBridgeSupport(businessId), new JSB2Impl(businessId)});
        }
        ISettingService iSettingService2 = ServiceCenter.Companion.instance().get(ISettingService.class);
        if (iSettingService2 != null && (provideBulletSettings = iSettingService2.provideBulletSettings()) != null) {
            webBDXBridge.setThreadOpt(provideBulletSettings.isJSBThreadOptEnable(), provideBulletSettings.getJsbThreadOptConfig());
        }
        webBDXBridge.registerService(ContextProviderFactory.class, contextProviderFactory);
        IServiceCenter instance = ServiceCenter.Companion.instance();
        String businessId2 = webViewModel.getBusinessId();
        if (businessId2 == null) {
            businessId2 = "default_bid";
        }
        BaseBridgeService baseBridgeService = (IBridgeService) instance.get(businessId2, IBridgeService.class);
        BaseBridgeService baseBridgeService2 = baseBridgeService instanceof BaseBridgeService ? baseBridgeService : null;
        if (baseBridgeService2 != null) {
            baseBridgeService2.beforePageRender(contextProviderFactory);
        }
        IServiceCenter instance2 = ServiceCenter.Companion.instance();
        String businessId3 = webViewModel.getBusinessId();
        IBridgeService iBridgeService = instance2.get(businessId3 != null ? businessId3 : "default_bid", IBridgeService.class);
        BaseBridgeService baseBridgeService3 = iBridgeService instanceof BaseBridgeService ? (BaseBridgeService) iBridgeService : null;
        if (baseBridgeService3 != null && (createStatefulBridges = baseBridgeService3.createStatefulBridges(contextProviderFactory)) != null) {
            Iterator it = createStatefulBridges.iterator();
            while (it.hasNext()) {
                webBDXBridge.registerStatefulMethod((IDLXBridgeMethod) it.next());
            }
        }
        BulletContext bulletContext = webViewModel.getBulletContext();
        bulletContext.setContext(context);
        webBDXBridge.registerService(BulletContext.class, bulletContext);
        BulletContext bulletContext2 = webViewModel.getBulletContext();
        if (bulletContext2 != null) {
            bulletContext2.setBridge3Registry(new IBridge3Registry() { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$getWebBridge$1$6$1
                public void release() {
                }

                public void handle(String methodName, JSONObject params, final Callback callBack) {
                    Intrinsics.checkNotNullParameter(methodName, "methodName");
                    if (params == null) {
                        params = new JSONObject();
                    }
                    final BaseBridgeCall webBridgeCall = new WebBridgeCall(methodName, params, AnnieXWebModel.this.getUrl());
                    webBDXBridge.handleCall(webBridgeCall, new BridgeResultCallback<JSONObject>(webBridgeCall, callBack) { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$getWebBridge$1$6$1$handle$callback$1
                        final /* synthetic */ Callback $callBack;
                        private JSONObject data;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super((BaseBridgeCall) webBridgeCall);
                            this.$callBack = callBack;
                        }

                        public void dispatchPlatformInvoke(JSONObject data) {
                            Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
                            this.data = data;
                            Callback callback = this.$callBack;
                            if (callback != null) {
                                callback.invoke(new Object[]{data});
                            }
                        }

                        public JSONObject convertDataToJSONObject() {
                            JSONObject jSONObject = this.data;
                            return jSONObject == null ? super.convertDataToJSONObject() : jSONObject;
                        }
                    });
                }
            });
        }
        webBDXBridge.setBridgeResultIntercept(new WebJSBResultIntercept());
        INSTANCE.initBridge(webBDXBridge, annieXWebKit, webView, webViewModel, contextProviderFactory);
        MonitorManager.INSTANCE.onJsbRegisterEnd(webViewModel.getSessionId());
        return webBDXBridge;
    }

    private final void initBridge(final WebBDXBridge webBdxBridge, AnnieXWebKit annieXWebKit, WebView webView, final AnnieXWebModel annieXWebModel, ContextProviderFactory contextProviderFactory) {
        HashSet<String> unSupportMethod;
        Context context = webView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "webView.context");
        initWebContextProvider(annieXWebKit, webView, context, annieXWebModel, contextProviderFactory);
        IAnnieXCustomActivityService iAnnieXCustomActivityService = (IAnnieXCustomActivityService) AnnieX.INSTANCE.getService(annieXWebModel.getBusinessId(), IAnnieXCustomActivityService.class);
        if (iAnnieXCustomActivityService != null) {
            webBdxBridge.registerService(IAnnieXCustomActivityService.class, iAnnieXCustomActivityService);
        }
        webBdxBridge.registerService(IAnnieProSupport.class, new IAnnieProSupport() { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$initBridge$2
            public String getAnnieAppID() {
                ISchemaData schemaData;
                String str;
                SchemaModelUnion schemaModelUnion = AnnieXWebModel.this.getSchemaModelUnion();
                return (schemaModelUnion == null || (schemaData = schemaModelUnion.getSchemaData()) == null || (str = (String) new StringParam(schemaData, "app_id", "").getValue()) == null) ? "" : str;
            }
        });
        BaseBridgeService baseBridgeService = (IBridgeService) ServiceCenter.Companion.instance().get(annieXWebModel.getBusinessId(), IBridgeService.class);
        if (baseBridgeService != null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "DefaultLynxDelegate.onLynxViewCreated, createMethodFinder from " + baseBridgeService.getClass().getName(), (LogLevel) null, (String) null, 6, (Object) null);
            ContextProviderFactory contextProviderFactory2 = (ContextProviderFactory) webBdxBridge.getWebBridgeContext().getService(ContextProviderFactory.class);
            List createMethodFinder = contextProviderFactory2 != null ? baseBridgeService.createMethodFinder(contextProviderFactory2) : null;
            if (createMethodFinder != null) {
                Iterator it = createMethodFinder.iterator();
                while (it.hasNext()) {
                    webBdxBridge.addCustomMethodFinder((MethodFinder) it.next());
                }
            }
            if (baseBridgeService instanceof BaseBridgeService) {
                MethodFinder createFirstFinder = baseBridgeService.createFirstFinder(contextProviderFactory);
                if (createFirstFinder != null) {
                    webBdxBridge.addCustomMethodFinder(createFirstFinder, 0);
                }
                if (Intrinsics.areEqual(annieXWebModel.getOriginalUri().getQueryParameter("enable_annie_jsb_for_common"), DiskLruCache.VERSION)) {
                    new WebcastContainerInitializer().initializeWithAnnieXWebModelInWeb(annieXWebModel, webView, webBdxBridge, contextProviderFactory, annieXWebKit);
                }
            }
        }
        IAnnieXContextProvider contextProvider = getContextProvider(annieXWebModel.getBusinessId());
        if (contextProvider != null && (unSupportMethod = contextProvider.getUnSupportMethod(annieXWebModel.getBusinessId())) != null) {
            webBdxBridge.addUnSupportMethod(unSupportMethod);
        }
        updateWebBridgeContext(webBdxBridge, annieXWebKit, annieXWebModel);
        if (IConditionCallKt.enableBridgePreInit()) {
            Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$initBridge$5
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    JSONObject jSONObject = new JSONObject();
                    String uri = AnnieXWebModel.this.getOriginalUri().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "annieXWebModel.originalUri.toString()");
                    BaseBridgeCall webBridgeCall = new WebBridgeCall("anniex.preInit", jSONObject, uri);
                    AnnieXWebModel annieXWebModel2 = AnnieXWebModel.this;
                    webBridgeCall.setPreInit(true);
                    webBridgeCall.setNamespace(Intrinsics.areEqual(annieXWebModel2.getBusinessId(), "webcast") ? "webcast" : "");
                    webBdxBridge.handleCallV2(webBridgeCall, new BridgeResultCallback<JSONObject>(webBridgeCall) { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$initBridge$5.1
                        public void dispatchPlatformInvoke(JSONObject data) {
                            Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
                        }

                        {
                            super((BaseBridgeCall) webBridgeCall);
                        }
                    });
                }
            });
        }
        configBridgeThread(webBdxBridge, annieXWebModel);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(OptimizeConfigKt.getCAN_RUN_IN_BACKGROUND_FIX(), Boolean.valueOf(IConditionCallKt.enableBridgeCanRunInBackgroundFix()));
        linkedHashMap.put(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT(), Boolean.valueOf(IConditionCallKt.enableXBridgeParamProxyEnhancement()));
        webBdxBridge.addSettings(linkedHashMap);
    }

    private final void configBridgeThread(WebBDXBridge webBDXBridge, AnnieXWebModel annieXWebModel) {
        if (IConditionCallKt.enableAnnieXBridgeThreadOpt() && Intrinsics.areEqual(annieXWebModel.getBusinessId(), "webcast")) {
            webBDXBridge.setThreadOpt(true, CollectionsKt.listOf(new ThreadOptConfig(SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"}), (HashSet) null, SetsKt.hashSetOf(new String[]{"sendLogV3", "setStorage"}), (HashSet) null, (HashSet) null, 26, (DefaultConstructorMarker) null)));
        }
    }

    private final void updateWebBridgeContext(WebBDXBridge webBDXBridge, AnnieXWebKit webView, AnnieXWebModel viewModel) {
        injectWebLoadContextProvider(webBDXBridge, webView, viewModel);
    }

    private final void initWebContextProvider(final AnnieXWebKit annieXWebKit, WebView webView, Context context, AnnieXWebModel annieXWebModel, ContextProviderFactory contextProviderFactory) {
        contextProviderFactory.registerWeakHolder(Context.class, context);
        contextProviderFactory.registerWeakHolder(WebView.class, webView);
        contextProviderFactory.registerWeakHolder(BulletContext.class, annieXWebModel.getBulletContext());
        contextProviderFactory.registerWeakHolder(XBridgeMethod.JsEventDelegate.class, new XBridgeMethod.JsEventDelegate() { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$initWebContextProvider$1$1
            public void sendJsEvent(String eventName, XReadableMap params) {
                JSONObject jSONObject;
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                AnnieXWebKit annieXWebKit2 = AnnieXWebKit.this;
                if (params == null || (jSONObject = XReadableJSONUtils.INSTANCE.xReadableMapToJSONObject(params)) == null) {
                    jSONObject = new JSONObject();
                }
                annieXWebKit2.sendEvent(eventName, jSONObject);
            }
        });
        contextProviderFactory.registerWeakHolder(IDLXBridgeMethod.JSEventDelegate.class, new IDLXBridgeMethod.JSEventDelegate() { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$initWebContextProvider$1$2
            public void sendJSEvent(String eventName, Map<String, ? extends Object> params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                AnnieXWebKit.this.sendEvent(eventName, params);
            }
        });
    }

    private final void injectWebLoadContextProvider(final WebBDXBridge webBDXBridge, final AnnieXWebKit webView, final AnnieXWebModel webModel) {
        IContainerInstance iContainerInstance = new IContainerInstance() { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$injectWebLoadContextProvider$containerInstance$1
            public String sessionId() {
                return AnnieXWebModel.this.getSessionId();
            }

            public String bid() {
                return AnnieXWebModel.this.getBusinessId();
            }

            public Context context() {
                return webBDXBridge.getContext();
            }

            public View view() {
                return webView.getRealView();
            }

            public Uri uri() {
                Uri currentUri = webView.getCurrentUri();
                return currentUri == null ? AnnieXWebModel.this.getOriginalUri() : currentUri;
            }

            public void sendEvent(String eventName, Object params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                webView.sendEvent(eventName, params);
            }
        };
        webBDXBridge.getWebBridgeContext().registerService(IContainerInstance.class, iContainerInstance);
        final ContextProviderFactory contextProviderFactory = (ContextProviderFactory) webBDXBridge.getWebBridgeContext().getService(ContextProviderFactory.class);
        if (contextProviderFactory != null) {
            contextProviderFactory.registerHolder(IContainerIDProvider.class, new IContainerIDProvider() { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$injectWebLoadContextProvider$1$1
                public String provideContainerID() {
                    return AnnieXWebModel.this.getSessionId();
                }
            });
            contextProviderFactory.registerHolder(IContainerInstance.class, iContainerInstance);
            contextProviderFactory.registerHolder(IBulletContainer.class, new IBulletContainer.Base(contextProviderFactory, webModel, webView) { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$injectWebLoadContextProvider$1$2
                final /* synthetic */ AnnieXWebModel $webModel;
                final /* synthetic */ AnnieXWebKit $webView;
                private final ContextProviderFactory providerFactory;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$webModel = webModel;
                    this.$webView = webView;
                    this.providerFactory = contextProviderFactory;
                }

                public ContextProviderFactory getProviderFactory() {
                    return this.providerFactory;
                }

                public BulletContext getBulletContext() {
                    return this.$webModel.getBulletContext();
                }

                public void onEvent(IEvent event) {
                    Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                    this.$webView.sendEvent(event.getName(), event.getParams());
                }

                public String getSessionId() {
                    return this.$webModel.getSessionId();
                }

                public <T extends IBulletService> T getBulletService(Class<T> clazz) {
                    Intrinsics.checkNotNullParameter(clazz, "clazz");
                    return (T) ServiceCenter.Companion.instance().get(this.$webModel.getBusinessId(), clazz);
                }

                public Uri getCurrentUri() {
                    return this.$webModel.getOriginalUri();
                }

                public Uri getProcessingUri() {
                    return this.$webModel.getOriginalUri();
                }

                public IKitViewService getKitView() {
                    final AnnieXWebKit annieXWebKit = this.$webView;
                    final AnnieXWebModel annieXWebModel = this.$webModel;
                    return new BaseWebKitService(annieXWebModel) { // from class: com.bytedance.android.anniex.ability.XBridgeWebHelper$injectWebLoadContextProvider$1$2$getKitView$1
                        final /* synthetic */ AnnieXWebModel $webModel;
                        private Uri currentUri;

                        public String getCurrentUrl() {
                            return "";
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseWebKitService
                        public String getViewTag() {
                            return "annie-x";
                        }

                        public boolean invokeJavaMethod(String url) {
                            return false;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(annieXWebModel);
                            this.$webModel = annieXWebModel;
                            Uri currentUri = AnnieXWebKit.this.getCurrentUri();
                            this.currentUri = currentUri == null ? annieXWebModel.getOriginalUri() : currentUri;
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseWebKitService
                        public View realView() {
                            return AnnieXWebKit.this.getRealView();
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseWebKitService
                        public String getSessionId() {
                            return this.$webModel.getSessionId();
                        }

                        public Uri getCurrentUri() {
                            return this.currentUri;
                        }

                        public void setCurrentUri(Uri uri) {
                            this.currentUri = uri;
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseWebKitService
                        public void sendEvent(String eventName, Object params) {
                            Intrinsics.checkNotNullParameter(eventName, "eventName");
                            AnnieXWebKit.this.sendEvent(eventName, params);
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseWebKitService
                        public void sendEvent(String eventName, Object params, boolean useDelegate) {
                            Intrinsics.checkNotNullParameter(eventName, "eventName");
                            AnnieXWebKit.this.sendEvent(eventName, params);
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseWebKitService
                        public void onHide() {
                            AnnieXWebKit.this.onHide();
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseWebKitService
                        public void onShow() {
                            AnnieXWebKit.this.onShow();
                        }
                    };
                }
            });
        }
    }

    private final IAnnieXContextProvider getContextProvider(String bid) {
        if (AnnieXSettings.INSTANCE.getOptimizeBulletInit()) {
            return (IAnnieXContextProvider) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        }
        IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        return iAnnieXContextProvider == null ? (IAnnieXContextProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXContextProvider.class) : iAnnieXContextProvider;
    }
}
