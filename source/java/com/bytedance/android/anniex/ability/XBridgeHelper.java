package com.bytedance.android.anniex.ability;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.utils.WebcastContainerInitializerInAnnieX;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.kit.service.BaseBridgeService;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.api.BaseServiceContext;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.api.IContainerIDProvider;
import com.bytedance.ies.xbridge.utils.XReadableJSONUtils;
import com.bytedance.sdk.xbridge.cn.optimize.ThreadOptConfig;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeContext;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeOptConfig;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.service.IAnnieProSupport;
import com.bytedance.sdk.xbridge.cn.service.IContainerInstance;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.TraceEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: XBridgeHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rJ \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ \u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\rH\u0002¨\u0006 "}, d2 = {"Lcom/bytedance/android/anniex/ability/XBridgeHelper;", "", "()V", "clearContextProvider", "", "bid", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "configBridgeThread", "lynxBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "lynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "getContextProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXContextProvider;", "getLynxBridge", "context", "Landroid/content/Context;", "lynxViewBuilder", "Lcom/lynx/tasm/LynxViewBuilder;", "initBridge", "lynxBdxBridge", "view", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "initBridgeInternal", "initContextProvider", "lynxView", "injectLoadContextProvider", "releaseContext", "updateLynxBridgeContext", "viewModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class XBridgeHelper {
    public static final XBridgeHelper INSTANCE = new XBridgeHelper();

    private XBridgeHelper() {
    }

    public final void initBridge(final LynxBDXBridge lynxBdxBridge, final AnnieXLynxView view, final AnnieXLynxModel lynxModel) {
        Intrinsics.checkNotNullParameter(lynxBdxBridge, "lynxBdxBridge");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        if (!Intrinsics.areEqual(lynxModel.getBid(), "Loki")) {
            MonitorManager.INSTANCE.onJsbRegisterBegin(lynxModel.getSessionId());
        }
        lynxBdxBridge.init(view);
        AnnieXLynxModel.CompactConfig compactConfig = lynxModel.getCompactConfig();
        boolean z = false;
        if (compactConfig != null && compactConfig.getEnableBridgeDelayInit()) {
            z = true;
        }
        if (z) {
            lynxBdxBridge.addDelayExecuteBlock(new Function0<Unit>() { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$initBridge$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m3286invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m3286invoke() {
                    XBridgeHelper.INSTANCE.initBridgeInternal(lynxBdxBridge, view, lynxModel);
                }
            });
        } else {
            initBridgeInternal(lynxBdxBridge, view, lynxModel);
        }
        if (Intrinsics.areEqual(lynxModel.getBid(), "Loki")) {
            return;
        }
        MonitorManager.INSTANCE.onJsbRegisterEnd(lynxModel.getSessionId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void initBridgeInternal(LynxBDXBridge lynxBdxBridge, AnnieXLynxView view, final AnnieXLynxModel lynxModel) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        lynxBdxBridge.registerService(ContextProviderFactory.class, initContextProvider(view, context));
        IAnnieXCustomActivityService iAnnieXCustomActivityService = (IAnnieXCustomActivityService) AnnieX.INSTANCE.getService(lynxModel.getBid(), IAnnieXCustomActivityService.class);
        if (iAnnieXCustomActivityService != null) {
            lynxBdxBridge.registerService(IAnnieXCustomActivityService.class, iAnnieXCustomActivityService);
        }
        lynxBdxBridge.registerService(IAnnieProSupport.class, new IAnnieProSupport() { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$initBridgeInternal$2
            public String getAnnieAppID() {
                String queryParameter = AnnieXLynxModel.this.getOriginalUri().getQueryParameter("app_id");
                return queryParameter == null ? "" : queryParameter;
            }
        });
        updateLynxBridgeContext(lynxBdxBridge, view, lynxModel);
        BaseBridgeService baseBridgeService = (IBridgeService) ServiceCenter.Companion.instance().get(lynxModel.getBid(), IBridgeService.class);
        if (baseBridgeService != null) {
            ContextProviderFactory contextProviderFactory = (ContextProviderFactory) lynxBdxBridge.getLynxBridgeContext().getService(ContextProviderFactory.class);
            List createMethodFinder = contextProviderFactory != null ? baseBridgeService.createMethodFinder(contextProviderFactory) : null;
            if (createMethodFinder != null) {
                Iterator it = createMethodFinder.iterator();
                while (it.hasNext()) {
                    lynxBdxBridge.addCustomMethodFinder((MethodFinder) it.next());
                }
            }
            if (baseBridgeService instanceof BaseBridgeService) {
                BaseBridgeService baseBridgeService2 = baseBridgeService;
                ContextProviderFactory contextProviderFactory2 = (ContextProviderFactory) lynxBdxBridge.getLynxBridgeContext().getService(ContextProviderFactory.class);
                if (contextProviderFactory2 == null) {
                    contextProviderFactory2 = new ContextProviderFactory();
                }
                MethodFinder createFirstFinder = baseBridgeService2.createFirstFinder(contextProviderFactory2);
                if (createFirstFinder != null) {
                    lynxBdxBridge.addCustomMethodFinder(createFirstFinder, 0);
                }
                if (Intrinsics.areEqual(lynxModel.getOriginalUri().getQueryParameter("enable_annie_jsb_for_common"), DiskLruCache.VERSION)) {
                    ContextProviderFactory contextProviderFactory3 = (ContextProviderFactory) lynxBdxBridge.getLynxBridgeContext().getService(ContextProviderFactory.class);
                    if (contextProviderFactory3 == null) {
                        contextProviderFactory3 = new ContextProviderFactory();
                    }
                    new WebcastContainerInitializerInAnnieX().initializeWithAnnieXLynxModelInLynx(lynxModel, (View) view, lynxBdxBridge, contextProviderFactory3);
                }
            }
        }
        configBridgeThread(lynxBdxBridge, lynxModel);
    }

    private final void configBridgeThread(LynxBDXBridge lynxBDXBridge, AnnieXLynxModel lynxModel) {
        BulletSettings provideBulletSettings;
        if (IConditionCallKt.enableAnnieXBridgeThreadOpt()) {
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            if (iSettingService != null && (provideBulletSettings = iSettingService.provideBulletSettings()) != null) {
                lynxBDXBridge.setThreadOpt(provideBulletSettings.isJSBThreadOptEnable(), provideBulletSettings.getJsbThreadOptConfig());
            }
            if (Intrinsics.areEqual(lynxModel.getBid(), "webcast")) {
                lynxBDXBridge.setThreadOpt(true, CollectionsKt.listOf(new ThreadOptConfig(SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"}), (HashSet) null, SetsKt.hashSetOf(new String[]{"sendLogV3", "setStorage"}), (HashSet) null, (HashSet) null, 26, (DefaultConstructorMarker) null)));
            }
        }
    }

    public final void releaseContext(String bid, LynxBDXBridge lynxBDXBridge) {
        LynxBridgeContext lynxBridgeContext;
        ContextProviderFactory contextProviderFactory;
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (lynxBDXBridge == null || (lynxBridgeContext = lynxBDXBridge.getLynxBridgeContext()) == null || (contextProviderFactory = (ContextProviderFactory) lynxBridgeContext.getService(ContextProviderFactory.class)) == null) {
            return;
        }
        INSTANCE.clearContextProvider(bid, contextProviderFactory);
        contextProviderFactory.removeAll();
    }

    private final void updateLynxBridgeContext(LynxBDXBridge lynxBDXBridge, AnnieXLynxView lynxView, AnnieXLynxModel viewModel) {
        injectLoadContextProvider(lynxBDXBridge, lynxView, viewModel);
    }

    private final ContextProviderFactory initContextProvider(final AnnieXLynxView lynxView, Context context) {
        ContextProviderFactory contextProviderFactory = new ContextProviderFactory();
        contextProviderFactory.registerWeakHolder(Context.class, context);
        contextProviderFactory.registerWeakHolder(LynxView.class, lynxView);
        contextProviderFactory.registerWeakHolder(XBridgeMethod.JsEventDelegate.class, new XBridgeMethod.JsEventDelegate() { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$initContextProvider$1$1
            public void sendJsEvent(String eventName, XReadableMap params) {
                JSONObject jSONObject;
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                AnnieXLynxView annieXLynxView = AnnieXLynxView.this;
                if (params == null || (jSONObject = XReadableJSONUtils.INSTANCE.xReadableMapToJSONObject(params)) == null) {
                    jSONObject = new JSONObject();
                }
                AnnieXLynxView.sendEvent$default(annieXLynxView, eventName, jSONObject, false, 4, null);
            }
        });
        contextProviderFactory.registerWeakHolder(IDLXBridgeMethod.JSEventDelegate.class, new IDLXBridgeMethod.JSEventDelegate() { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$initContextProvider$1$2
            public void sendJSEvent(String eventName, Map<String, ? extends Object> params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                AnnieXLynxView.sendEvent$default(AnnieXLynxView.this, eventName, params, false, 4, null);
            }
        });
        return contextProviderFactory;
    }

    private final void injectLoadContextProvider(final LynxBDXBridge lynxBDXBridge, final AnnieXLynxView lynxView, final AnnieXLynxModel lynxModel) {
        IAnnieXContextProvider contextProvider;
        IContainerInstance iContainerInstance = new IContainerInstance() { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$injectLoadContextProvider$containerInstance$1
            public String sessionId() {
                return AnnieXLynxModel.this.getSessionId();
            }

            public String bid() {
                return AnnieXLynxModel.this.getBid();
            }

            public Context context() {
                if (IConditionCallKt.enableFlowUpdateContext()) {
                    Context context = lynxView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "{\n                    ly…context\n                }");
                    return context;
                }
                return lynxBDXBridge.getContext();
            }

            public View view() {
                return (View) lynxView;
            }

            public Uri uri() {
                return AnnieXLynxModel.this.getOriginalUri();
            }

            public void sendEvent(String eventName, Object params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                AnnieXLynxView.sendEvent$default(lynxView, eventName, params, false, 4, null);
            }
        };
        lynxBDXBridge.getLynxBridgeContext().registerService(IContainerInstance.class, iContainerInstance);
        final ContextProviderFactory contextProviderFactory = (ContextProviderFactory) lynxBDXBridge.getLynxBridgeContext().getService(ContextProviderFactory.class);
        if (contextProviderFactory != null) {
            if (!lynxModel.isCompactMode()) {
                AnnieXLynxModel.CompactConfig compactConfig = lynxModel.getCompactConfig();
                boolean z = false;
                if (compactConfig != null && compactConfig.getCompactBridge()) {
                    z = true;
                }
                if (!z && (contextProvider = INSTANCE.getContextProvider(lynxModel.getBid())) != null) {
                    contextProvider.completeContextProvider(iContainerInstance, lynxBDXBridge.getContext(), contextProviderFactory);
                }
            }
            contextProviderFactory.registerHolder(IContainerIDProvider.class, new IContainerIDProvider() { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$injectLoadContextProvider$1$1
                public String provideContainerID() {
                    return AnnieXLynxModel.this.getSessionId();
                }
            });
            contextProviderFactory.registerHolder(IContainerInstance.class, iContainerInstance);
            contextProviderFactory.registerHolder(IBulletContainer.class, new IBulletContainer.Base(contextProviderFactory, lynxModel, lynxView, lynxBDXBridge) { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$injectLoadContextProvider$1$2
                final /* synthetic */ LynxBDXBridge $lynxBDXBridge;
                final /* synthetic */ AnnieXLynxModel $lynxModel;
                final /* synthetic */ AnnieXLynxView $lynxView;
                private final ContextProviderFactory providerFactory;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$lynxModel = lynxModel;
                    this.$lynxView = lynxView;
                    this.$lynxBDXBridge = lynxBDXBridge;
                    this.providerFactory = contextProviderFactory;
                }

                public ContextProviderFactory getProviderFactory() {
                    return this.providerFactory;
                }

                public BulletContext getBulletContext() {
                    Context context;
                    Integer intOrNull;
                    String queryParameter = this.$lynxModel.getOriginalUri().getQueryParameter("enable_parse_full_scheme_in_lite_card");
                    boolean z2 = false;
                    if (queryParameter != null && (intOrNull = StringsKt.toIntOrNull(queryParameter)) != null && intOrNull.intValue() == 1) {
                        z2 = true;
                    }
                    if (z2) {
                        return BulletContextManager.getOrCreateContext$default(BulletContextManager.Companion.getInstance(), this.$lynxModel.getBid(), this.$lynxModel.getOriginalUri(), (Bundle) null, false, (SchemaConfig) null, 24, (Object) null);
                    }
                    BulletContext createBulletContext = BulletContextManager.Companion.getInstance().createBulletContext();
                    AnnieXLynxModel annieXLynxModel = this.$lynxModel;
                    AnnieXLynxView annieXLynxView = this.$lynxView;
                    LynxBDXBridge lynxBDXBridge2 = this.$lynxBDXBridge;
                    createBulletContext.setSessionId(annieXLynxModel.getSessionId());
                    createBulletContext.setBid(annieXLynxModel.getBid());
                    if (IConditionCallKt.enableFlowUpdateContext()) {
                        context = annieXLynxView.getContext();
                    } else {
                        context = lynxBDXBridge2.getContext();
                    }
                    createBulletContext.setContext(context);
                    createBulletContext.setSimpleCard(true);
                    return createBulletContext;
                }

                public void onEvent(IEvent event) {
                    Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                    AnnieXLynxView.sendEvent$default(this.$lynxView, event.getName(), event.getParams(), false, 4, null);
                }

                public String getSessionId() {
                    return this.$lynxModel.getSessionId();
                }

                public <T extends IBulletService> T getBulletService(Class<T> clazz) {
                    Intrinsics.checkNotNullParameter(clazz, "clazz");
                    return (T) ServiceCenter.Companion.instance().get(this.$lynxModel.getBid(), clazz);
                }

                public Uri getCurrentUri() {
                    return this.$lynxModel.getOriginalUri();
                }

                public Uri getProcessingUri() {
                    return this.$lynxModel.getOriginalUri();
                }

                public IKitViewService getKitView() {
                    final AnnieXLynxView annieXLynxView = this.$lynxView;
                    final AnnieXLynxModel annieXLynxModel = this.$lynxModel;
                    return new BaseLynxKitView(annieXLynxModel) { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$injectLoadContextProvider$1$2$getKitView$1
                        final /* synthetic */ AnnieXLynxModel $lynxModel;
                        private IServiceToken context;

                        public String getViewTag() {
                            return "annie-x";
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$lynxModel = annieXLynxModel;
                            this.context = new IServiceToken(AnnieXLynxView.this, annieXLynxModel) { // from class: com.bytedance.android.anniex.ability.XBridgeHelper$injectLoadContextProvider$1$2$getKitView$1$context$1
                                final /* synthetic */ AnnieXLynxModel $lynxModel;
                                private final IServiceContext serviceContext;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.$lynxModel = annieXLynxModel;
                                    this.serviceContext = new BaseServiceContext(r2.getContext(), BulletEnv.Companion.getInstance().getDebuggable());
                                }

                                public Map<Class<?>, Object> getAllDependency() {
                                    return IServiceToken.DefaultImpls.getAllDependency(this);
                                }

                                public <T> T getDependency(Class<T> cls) {
                                    return (T) IServiceToken.DefaultImpls.getDependency(this, cls);
                                }

                                public <T extends IBulletService> T getService(Class<T> cls) {
                                    return (T) IServiceToken.DefaultImpls.getService(this, cls);
                                }

                                public IServiceContext getServiceContext() {
                                    return this.serviceContext;
                                }

                                public String getBid() {
                                    return this.$lynxModel.getBid();
                                }
                            };
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseLynxKitView
                        public View realView() {
                            return (View) AnnieXLynxView.this;
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseLynxKitView
                        public String getSessionId() {
                            return this.$lynxModel.getSessionId();
                        }

                        public IServiceToken getContext() {
                            return this.context;
                        }

                        public void setContext(IServiceToken iServiceToken) {
                            Intrinsics.checkNotNullParameter(iServiceToken, "<set-?>");
                            this.context = iServiceToken;
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseLynxKitView
                        public void destroy(boolean useDelegate) {
                            AnnieXLynxView.this.destroy();
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseLynxKitView
                        public void sendEvent(String eventName, Object params) {
                            Intrinsics.checkNotNullParameter(eventName, "eventName");
                            AnnieXLynxView.sendEvent$default(AnnieXLynxView.this, eventName, params, false, 4, null);
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseLynxKitView
                        public void sendEvent(String eventName, Object params, boolean useDelegate) {
                            Intrinsics.checkNotNullParameter(eventName, "eventName");
                            AnnieXLynxView.sendEvent$default(AnnieXLynxView.this, eventName, params, false, 4, null);
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseLynxKitView
                        public void onHide() {
                            AnnieXLynxView.sendEvent$default(AnnieXLynxView.this, "viewAppeared", new JavaOnlyArray(), false, 4, null);
                            AnnieXLynxView.this.onEnterBackground();
                        }

                        @Override // com.bytedance.android.anniex.ability.BaseLynxKitView
                        public void onShow() {
                            AnnieXLynxView.sendEvent$default(AnnieXLynxView.this, "viewDisappeared", new JavaOnlyArray(), false, 4, null);
                            AnnieXLynxView.this.onEnterForeground();
                        }
                    };
                }
            });
        }
    }

    private final IAnnieXContextProvider getContextProvider(String bid) {
        if (AnnieX.INSTANCE.optimizeBulletInit()) {
            return (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        }
        IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        return iAnnieXContextProvider == null ? (IAnnieXContextProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXContextProvider.class) : iAnnieXContextProvider;
    }

    private final void clearContextProvider(String bid, ContextProviderFactory contextProviderFactory) {
        IAnnieXContextProvider iAnnieXContextProvider;
        IAnnieXContextProvider iAnnieXContextProvider2 = (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        if (iAnnieXContextProvider2 != null) {
            iAnnieXContextProvider2.clearContextProvider(bid, contextProviderFactory);
        }
        if (AnnieX.INSTANCE.optimizeBulletInit() || (iAnnieXContextProvider = (IAnnieXContextProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXContextProvider.class)) == null) {
            return;
        }
        iAnnieXContextProvider.clearContextProvider(bid, contextProviderFactory);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[Catch: all -> 0x006b, TryCatch #0 {all -> 0x006b, blocks: (B:3:0x0017, B:6:0x0024, B:8:0x002c, B:10:0x0032, B:17:0x0043, B:21:0x0058), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #0 {all -> 0x006b, blocks: (B:3:0x0017, B:6:0x0024, B:8:0x002c, B:10:0x0032, B:17:0x0043, B:21:0x0058), top: B:2:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LynxBDXBridge getLynxBridge(Context context, AnnieXLynxModel lynxModel, LynxViewBuilder lynxViewBuilder) {
        boolean z;
        LynxBDXBridge lynxBDXBridge;
        String str = "webcast";
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        Intrinsics.checkNotNullParameter(lynxViewBuilder, "lynxViewBuilder");
        TraceEvent.beginSection("XBridgeHelper:getLynxBridge");
        try {
            if (!Intrinsics.areEqual(lynxModel.getBid(), "webcast")) {
                str = "";
            }
            if (!lynxModel.isCompactMode()) {
                AnnieXLynxModel.CompactConfig compactConfig = lynxModel.getCompactConfig();
                if (!(compactConfig != null && compactConfig.getCompactBridge())) {
                    z = false;
                    if (!z) {
                        lynxBDXBridge = new LynxBDXBridge(new LynxBridgeOptConfig(false), context, lynxModel.getSessionId());
                        lynxBDXBridge.setup(lynxViewBuilder);
                        lynxBDXBridge.setNamespace(str);
                    } else {
                        lynxBDXBridge = new LynxBDXBridge(context, lynxModel.getSessionId());
                        lynxBDXBridge.setup(lynxViewBuilder);
                        lynxBDXBridge.setNamespace(str);
                    }
                    return lynxBDXBridge;
                }
            }
            z = true;
            if (!z) {
            }
            return lynxBDXBridge;
        } finally {
            TraceEvent.endSection("XBridgeHelper:getLynxBridge");
        }
    }
}
