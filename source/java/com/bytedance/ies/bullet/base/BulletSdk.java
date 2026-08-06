package com.bytedance.ies.bullet.base;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.ies.bullet.assembler.settings.BulletMixSwitch;
import com.bytedance.ies.bullet.base.bridge.DefaultXBridgeAuthRecoveryConfigProvider;
import com.bytedance.ies.bullet.base.service.BulletBridgeProviderService;
import com.bytedance.ies.bullet.base.service.BulletByteSyncManager;
import com.bytedance.ies.bullet.base.settings.ArgusSecuritySettings;
import com.bytedance.ies.bullet.base.settings.GeckoLoaderSecureConfig;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.base.storage.LocalStorage;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.LifeCycleManager;
import com.bytedance.ies.bullet.core.common.DebugConfig;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.pool.PreRenderConfig;
import com.bytedance.ies.bullet.pool.PreRenderService;
import com.bytedance.ies.bullet.prefetchv2.PrefetchV2Service;
import com.bytedance.ies.bullet.preloadv2.PreloadLoader;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Kt;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Service;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.secure.GeckoLoaderSecureManager;
import com.bytedance.ies.bullet.secure.HybridSecureConfig;
import com.bytedance.ies.bullet.secure.HybridSecureManager;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IGlobalPropsInjectService;
import com.bytedance.ies.bullet.service.base.IPopUpService;
import com.bytedance.ies.bullet.service.base.IPreLoadService;
import com.bytedance.ies.bullet.service.base.IPreRenderConfig;
import com.bytedance.ies.bullet.service.base.IPreRenderService;
import com.bytedance.ies.bullet.service.base.IPrefetchV2Service;
import com.bytedance.ies.bullet.service.base.IPreloadV2Service;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.bridge.IBulletBridgeProviderService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.impl.ServiceMap;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.router.config.RouterOpenConfig;
import com.bytedance.ies.bullet.service.base.settings.AppInfo;
import com.bytedance.ies.bullet.service.base.settings.BulletSettingsConfig;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.ResourceLoaderSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.base.web.IWebPreCreateService;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.BulletMonitor;
import com.bytedance.ies.bullet.service.monitor.DefaultBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryHelper;
import com.bytedance.ies.bullet.service.monitor.memorywarning.MemoryWarningNotice;
import com.bytedance.ies.bullet.service.popup.PopUpService;
import com.bytedance.ies.bullet.service.popup.PopupConfig;
import com.bytedance.ies.bullet.service.preload.PreLoadService;
import com.bytedance.ies.bullet.service.preload.WebPreCreateService;
import com.bytedance.ies.bullet.service.receiver.BulletReceiverCenter;
import com.bytedance.ies.bullet.service.router.DefaultRouterInterceptor;
import com.bytedance.ies.bullet.service.router.IRouterInterceptor;
import com.bytedance.ies.bullet.service.router.RouterService;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.ies.bullet.service.sdk.GlobalSchemaConfig;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.settings.BulletSettingsService;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.XBridgeAuthRecoveryManager;
import com.bytedance.sdk.xbridge.cn.storage.globalpropsinject.GlobalPropsInjectServiceImpl;
import com.bytedance.sdk.xbridge.cn.utils.Logger;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInject;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BulletSdk.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0010\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00130\u001aj\u0002`\u001bJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0006\u0010\u001f\u001a\u00020\u000bJ,\u0010 \u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ies/bullet/base/BulletSdk;", "", "()V", "BULLET_INIT_CLASS_NAME", "", "DEFAULT_BID", "TAG", "componentCallbacks2", "com/bytedance/ies/bullet/base/BulletSdk$componentCallbacks2$1", "Lcom/bytedance/ies/bullet/base/BulletSdk$componentCallbacks2$1;", "defaultBidReady", "", "lockObj", "Ljava/lang/Object;", "close", "containerId", "bid", "sessionId", "ensureDefaultBidReady", "", "context", "Landroid/content/Context;", EventConstants.PARAM_SOURCE_INIT, "config", "Lcom/bytedance/ies/bullet/base/InitializeConfig;", "initializeMethod", "Lkotlin/Function0;", "Lcom/bytedance/ies/bullet/service/base/api/InitializeMethod;", "initInternal", "initializeDefaultBid", "clsName", "isDefaultBidReady", "open", "uri", "Landroid/net/Uri;", "Lcom/bytedance/ies/bullet/service/base/router/config/RouterOpenConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletSdk {
    private static final String BULLET_INIT_CLASS_NAME = "bullet.BulletDefaultInitializer";
    private static final String DEFAULT_BID = "default_bid";
    private static final String TAG = "BulletSdk";
    private static volatile boolean defaultBidReady;
    public static final BulletSdk INSTANCE = new BulletSdk();
    private static final Object lockObj = new Object();
    private static BulletSdk$componentCallbacks2$1 componentCallbacks2 = new ComponentCallbacks2() { // from class: com.bytedance.ies.bullet.base.BulletSdk$componentCallbacks2$1
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
            Long l;
            CpuMemoryHelper cpuMemoryHelper = CpuMemoryHelper.INSTANCE;
            Map<String, Long> memory = CpuMemoryHelper.INSTANCE.getMemory();
            cpuMemoryHelper.setMemorySizeOnWaring((memory == null || (l = memory.get(CpuMemoryHelper.MEM_JAVA_USED)) == null) ? -1L : l.longValue());
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "memory_warning  onTrimMemory mem: " + CpuMemoryHelper.INSTANCE.getMemorySizeOnWaring(), null, "CpuMemoryPerfMetric", 2, null);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "MEMORY_WARNING  onTrimMemory level:" + level, null, "CpuMemoryPerfMetric", 2, null);
            if (level == 5) {
                MemoryWarningNotice.INSTANCE.notify(level);
            } else if (level == 10) {
                MemoryWarningNotice.INSTANCE.notify(level);
            } else {
                if (level != 15) {
                    return;
                }
                MemoryWarningNotice.INSTANCE.notify(level);
            }
        }
    };

    private BulletSdk() {
    }

    public final void init(InitializeConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletSdk:init start with " + config.getBid(), null, "XInit", 2, null);
        if ("default_bid" != config.getBid()) {
            ensureDefaultBidReady(config.getApplication());
        }
        if ("default_bid" == config.getBid()) {
            if (defaultBidReady) {
                return;
            }
            synchronized (lockObj) {
                if (defaultBidReady) {
                    return;
                }
                INSTANCE.initInternal(config);
                defaultBidReady = true;
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletSdk: init success with " + config.getBid(), null, "XInit", 2, null);
                Unit unit = Unit.INSTANCE;
                return;
            }
        }
        initInternal(config);
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletSdk:init success with " + config.getBid(), null, "XInit", 2, null);
    }

    public final boolean init(String bid, Function0<Unit> initializeMethod) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(initializeMethod, "initializeMethod");
        return ServiceCenter.INSTANCE.instance().bindInitializeMethod(bid, initializeMethod);
    }

    public static /* synthetic */ boolean open$default(BulletSdk bulletSdk, Context context, Uri uri, RouterOpenConfig routerOpenConfig, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            routerOpenConfig = null;
        }
        if ((i & 8) != 0) {
            str = "default_bid";
        }
        return bulletSdk.open(context, uri, routerOpenConfig, str);
    }

    public final boolean open(Context context, Uri uri, RouterOpenConfig config, String bid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (Intrinsics.areEqual(SchemaUtilsKt.getQueryParameterSafely(uri, "mix_container_type"), "anniex")) {
            HybridLogger.i$default(HybridLogger.INSTANCE, BulletMixSwitch.TAG, "match  AnnieXDefault schema is: " + uri, null, null, 12, null);
            return AnnieX.open$default(AnnieX.INSTANCE, context, uri, (Function1) null, 4, (Object) null);
        }
        ensureDefaultBidReady(context);
        HybridLogger.i$default(HybridLogger.INSTANCE, BulletMixSwitch.TAG, "match  AnnieXBullet schema is: " + uri, null, null, 12, null);
        RouterService routerService = (RouterService) StandardServiceManager.INSTANCE.get(bid, RouterService.class);
        if (routerService != null) {
            return routerService.open(context, uri, config == null ? new RouterOpenConfig() : config);
        }
        return false;
    }

    public static /* synthetic */ boolean close$default(BulletSdk bulletSdk, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "default_bid";
        }
        return bulletSdk.close(str, str2);
    }

    public final boolean close(String containerId, String bid) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(bid, "bid");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletSdk close containerId:" + containerId + ",bid:" + bid, null, "XRouter", 2, null);
        RouterService routerService = (RouterService) StandardServiceManager.INSTANCE.get(bid, RouterService.class);
        if (routerService != null) {
            return RouterService.close$default(routerService, containerId, null, 2, null);
        }
        return false;
    }

    public static /* synthetic */ boolean close$default(BulletSdk bulletSdk, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "default_bid";
        }
        return bulletSdk.close(str, str2, str3);
    }

    public final boolean close(String containerId, String bid, String sessionId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("containerID", containerId), TuplesKt.to("bid", bid)});
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(XConstant.SESSION_ID, sessionId);
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XRouter", "close call", mapOf, loggerContext);
        RouterService routerService = (RouterService) StandardServiceManager.INSTANCE.get(bid, RouterService.class);
        if (routerService != null) {
            return routerService.close(containerId, sessionId);
        }
        return false;
    }

    private final void initInternal(InitializeConfig config) {
        AppInfo appInfo;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletSdk:init internal start with " + config.getBid(), null, "XInit", 2, null);
        String bid = config.getBid();
        ServiceMap serviceMap = config.getServiceMap();
        Application application = config.getApplication();
        DebugInfo debugInfo = config.getDebugInfo();
        Boolean debuggable = config.getDebuggable();
        boolean booleanValue = debuggable != null ? debuggable.booleanValue() : false;
        ResourceLoaderConfig resourceLoaderConfig = config.getResourceLoaderConfig();
        GlobalSchemaConfig schemaConfig = config.getSchemaConfig();
        DefaultRouterInterceptor routerInterceptor = config.getRouterInterceptor();
        if (routerInterceptor == null) {
            routerInterceptor = new DefaultRouterInterceptor();
        }
        IRouterInterceptor iRouterInterceptor = routerInterceptor;
        PreRenderConfig preRenderConfig = config.getPreRenderConfig();
        if (preRenderConfig == null) {
            preRenderConfig = new PreRenderConfig.Builder().build();
        }
        IPreRenderConfig iPreRenderConfig = preRenderConfig;
        if (!defaultBidReady && Intrinsics.areEqual(bid, "default_bid")) {
            application.registerComponentCallbacks(componentCallbacks2);
            BulletLogger.INSTANCE.setDebug(booleanValue);
            BulletEnv.INSTANCE.getInstance().setApplication(application);
            BulletEnv.INSTANCE.getInstance().setDebuggable(booleanValue);
            BulletMonitor.INSTANCE.setMonitor(new Function0<AbsBulletMonitorCallback>() { // from class: com.bytedance.ies.bullet.base.BulletSdk$initInternal$1
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final AbsBulletMonitorCallback m486invoke() {
                    return new DefaultBulletMonitorCallback();
                }
            });
            ResourceLoader.INSTANCE.init(application, booleanValue);
            if (ResourceLoader.INSTANCE.getPreloadLoader() == null) {
                ResourceLoader.INSTANCE.setPreloadLoader(new PreloadLoader());
            }
            LifeCycleManager.INSTANCE.register(application);
            XBridgeInject.INSTANCE.inject(new Logger() { // from class: com.bytedance.ies.bullet.base.BulletSdk$initInternal$2
                /* renamed from: d */
                public void m0d(String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    BulletLogger.INSTANCE.onLog(msg, LogLevel.D);
                }

                /* renamed from: e */
                public void m1e(String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    BulletLogger.INSTANCE.onLog(msg, LogLevel.E);
                }

                /* renamed from: w */
                public void m3w(String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    BulletLogger.INSTANCE.onLog(msg, LogLevel.W);
                }

                /* renamed from: i */
                public void m2i(String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    BulletLogger.INSTANCE.onLog(msg, LogLevel.I);
                }
            });
            XBridgeAuthRecoveryManager.INSTANCE.setConfigProvider(new DefaultXBridgeAuthRecoveryConfigProvider());
            LocalStorage.INSTANCE.validate();
        }
        String name = ISettingService.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ISettingService::class.java.name");
        IBulletService iBulletService = serviceMap.get(name);
        if (iBulletService != null) {
            ServiceCenter.INSTANCE.instance().bind(config.getBid(), ISettingService.class, (ISettingService) iBulletService);
        }
        DebugConfig debugConfig = DebugConfig.INSTANCE;
        if (debugInfo == null) {
            debugInfo = DebugConfig.INSTANCE.getDefault();
        }
        debugConfig.bind(bid, debugInfo);
        if (resourceLoaderConfig != null) {
            ResourceLoader.INSTANCE.register(bid, resourceLoaderConfig);
            BulletEnv.INSTANCE.getInstance().setAppId(resourceLoaderConfig.getAppId());
            BulletEnv.INSTANCE.getInstance().setAppVersion(resourceLoaderConfig.getAppVersion());
            BulletEnv.INSTANCE.getInstance().setDid(resourceLoaderConfig.getDid());
        } else if (Intrinsics.areEqual("default_bid", bid)) {
            ExceptionUtil.handle$default(ExceptionUtil.INSTANCE, booleanValue, bid + " should have resourceLoaderConfig", null, 4, null);
        }
        if (schemaConfig != null) {
            SchemaService.INSTANCE.getInstance().bindConfig(bid, schemaConfig);
        } else if (Intrinsics.areEqual("default_bid", bid)) {
            ExceptionUtil.handle$default(ExceptionUtil.INSTANCE, booleanValue, bid + " should have schemaConfig", null, 4, null);
        }
        BulletReceiverCenter.INSTANCE.registerAllReceiver(application);
        StandardServiceManager.INSTANCE.put(bid, new RouterService(bid, iRouterInterceptor));
        StandardServiceManager.INSTANCE.put(bid, new PreRenderService(bid, iPreRenderConfig), IPreRenderService.class);
        StandardServiceManager.INSTANCE.put(new WebPreCreateService(), IWebPreCreateService.class);
        StandardServiceManager.INSTANCE.put(new BulletBridgeProviderService(), IBulletBridgeProviderService.class);
        StandardServiceManager.INSTANCE.put(new PrefetchV2Service(), IPrefetchV2Service.class);
        StandardServiceManager.INSTANCE.put(new PreloadV2Service(application), IPreloadV2Service.class);
        StandardServiceManager.INSTANCE.put(new GlobalPropsInjectServiceImpl(), IGlobalPropsInjectService.class);
        ServiceCenter.INSTANCE.instance().bind(bid, IPopUpService.class, new PopUpService(new PopupConfig(null, 1, null)));
        ServiceCenter.INSTANCE.instance().bind(bid, serviceMap);
        Iterator<T> it = serviceMap.getAllClazzName().iterator();
        while (it.hasNext()) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletSdk: insert service " + ((String) it.next()) + " for " + bid, null, "XInit", 2, null);
        }
        StandardServiceManager.INSTANCE.put(bid, new PreLoadService(application, bid), IPreLoadService.class);
        if (config.getSettingsConfig() != null) {
            BulletLogger.onLog$default(BulletLogger.INSTANCE, "BulletSdk, register settings service", null, 2, null);
            BulletSettingsConfig settingsConfig = config.getSettingsConfig();
            if (settingsConfig != null && (appInfo = settingsConfig.getAppInfo()) != null) {
                String appId = BulletEnv.INSTANCE.getInstance().getAppId();
                if (appId == null || appId.length() == 0) {
                    BulletEnv.INSTANCE.getInstance().setAppId(appInfo.getAppId());
                }
                BulletEnv.INSTANCE.getInstance().setChannel(appInfo.getChannel());
                String did = BulletEnv.INSTANCE.getInstance().getDid();
                if (did == null || did.length() == 0) {
                    BulletEnv.INSTANCE.getInstance().setDid(appInfo.getDid());
                }
            }
            BulletSettingsConfig settingsConfig2 = config.getSettingsConfig();
            Intrinsics.checkNotNull(settingsConfig2);
            final BulletSettingsService bulletSettingsService = new BulletSettingsService(settingsConfig2);
            bulletSettingsService.setSettingsListener(new BulletSettingsService.OnUpdateListener() { // from class: com.bytedance.ies.bullet.base.BulletSdk$initInternal$6
                @Override // com.bytedance.ies.bullet.settings.BulletSettingsService.OnUpdateListener
                public void onUpdate() {
                    Boolean dropALogSwitch;
                    CommonConfig commonConfig = (CommonConfig) BulletSettingsService.this.obtainSettings(CommonConfig.class);
                    boolean booleanValue2 = (commonConfig == null || (dropALogSwitch = commonConfig.getDropALogSwitch()) == null) ? false : dropALogSwitch.booleanValue();
                    BulletLogger.INSTANCE.setDrop(booleanValue2);
                    XBridge.INSTANCE.setDrop(booleanValue2);
                    ResourceLoaderSettingsConfig resourceLoaderSettingsConfig = (ResourceLoaderSettingsConfig) BulletSettingsService.this.obtainSettings(ResourceLoaderSettingsConfig.class);
                    HybridLogger hybridLogger = HybridLogger.INSTANCE;
                    CommonConfig commonConfig2 = (CommonConfig) BulletSettingsService.this.obtainSettings(CommonConfig.class);
                    hybridLogger.setLevel(commonConfig2 != null ? commonConfig2.getHybridLoggerLevel() : 4);
                    if (resourceLoaderSettingsConfig != null) {
                        boolean enableMemCache = resourceLoaderSettingsConfig.getEnableMemCache();
                        int memorySize = resourceLoaderSettingsConfig.getMemorySize();
                        boolean enableRemoteConfig = resourceLoaderSettingsConfig.getEnableRemoteConfig();
                        LinkedHashMap prefix2ak = resourceLoaderSettingsConfig.getPrefix2ak();
                        if (prefix2ak == null) {
                            prefix2ak = new LinkedHashMap();
                        }
                        ResourceLoader.updateResourceLoaderConfig(enableMemCache, memorySize, enableRemoteConfig, prefix2ak);
                        PreloadV2.INSTANCE.setEnablePreload(resourceLoaderSettingsConfig.getEnablePreload());
                        PreloadV2.INSTANCE.setTemplateSize(resourceLoaderSettingsConfig.getPreloadTemplateSize());
                        PreloadV2.INSTANCE.setSubResMemSize(resourceLoaderSettingsConfig.getPreloadSubResMemSize() * PreloadV2Kt.M_MEM_SIZE);
                        PreloadV2.INSTANCE.setMemWarningProportion(resourceLoaderSettingsConfig.getPreloadMemWarningProportion());
                        RedirectManager.INSTANCE.setEnable(resourceLoaderSettingsConfig.getEnableRedirectCache());
                        RedirectManager.INSTANCE.setDefaultCache(resourceLoaderSettingsConfig.getEnableRedirectDefaultCache() || IConditionCallKt.enableRedirectDefaultCache());
                    }
                    BulletByteSyncManager.INSTANCE.updateTimeStamp();
                    ArgusSecuritySettings argusSecuritySettings = (ArgusSecuritySettings) BulletSettingsService.this.obtainSettings(ArgusSecuritySettings.class);
                    HybridSecureManager.INSTANCE.getInstance().updateArgusJSONConfig$anniex_release(argusSecuritySettings != null ? argusSecuritySettings.getConfig() : null);
                    SecuritySettingConfig securitySettingConfig = (SecuritySettingConfig) BulletSettingsService.this.obtainSettings(SecuritySettingConfig.class);
                    if (securitySettingConfig != null) {
                        HybridSecureManager.INSTANCE.getInstance().updateSecuritySettingConfig$anniex_release(securitySettingConfig);
                    }
                    GeckoLoaderSecureConfig geckoLoaderSecureConfig = securitySettingConfig != null ? securitySettingConfig.getGeckoLoaderSecureConfig() : null;
                    if (geckoLoaderSecureConfig != null) {
                        GeckoLoaderSecureManager.INSTANCE.getInstance().updateConfig(geckoLoaderSecureConfig);
                    }
                }
            });
            StandardServiceManager.INSTANCE.put(bulletSettingsService, IBulletSettingsService.class);
        }
        HybridSecureConfig secureConfig = config.getSecureConfig();
        if (secureConfig != null) {
            HybridSecureManager.INSTANCE.getInstance().init$anniex_release(bid, secureConfig);
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "XInit", "init internal success", MapsKt.mapOf(TuplesKt.to("bid", config.getBid())), null, 8, null);
    }

    public final boolean isDefaultBidReady() {
        return defaultBidReady;
    }

    public final void ensureDefaultBidReady(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (defaultBidReady) {
            return;
        }
        String packageName = context.getApplicationContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        if (StringsKt.startsWith$default(packageName, "com.ss.android.ugc.aweme", false, 2, (Object) null) || packageName.equals("com.ss.android.ugc.live") || packageName.equals("com.ss.android.yumme.video") || packageName.equals("com.ss.android.ugc.livelite") || packageName.equals("my.maya.android")) {
            packageName = "com.ss.android.ugc.aweme";
        }
        initializeDefaultBid(packageName + ".bullet.BulletDefaultInitializer");
    }

    private final boolean initializeDefaultBid(String clsName) {
        try {
            Object newInstance = Class.forName(clsName).newInstance();
            if (!(newInstance instanceof IBulletDefaultInitializer)) {
                ExceptionUtil.handle$default(ExceptionUtil.INSTANCE, false, "initializeDefaultBid failed, class name = " + clsName + ", error info = invalid initialize", null, 4, null);
                return false;
            }
            ((IBulletDefaultInitializer) newInstance).init();
            if (defaultBidReady) {
                return true;
            }
            ExceptionUtil.handle$default(ExceptionUtil.INSTANCE, false, "initializeDefaultBid failed, class name = " + clsName + ", error info = initializer not work", null, 4, null);
            return false;
        } catch (Throwable th) {
            ExceptionUtil.INSTANCE.handle(false, "initializeDefaultBid failed, class name = " + clsName + ", error info = " + th.getMessage(), th);
            return false;
        }
    }
}
