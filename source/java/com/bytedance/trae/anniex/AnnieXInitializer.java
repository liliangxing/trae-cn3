package com.bytedance.trae.anniex;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.anniex.ability.DefaultAnnieXPIAMethodProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXPiaMethodProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.ies.bullet.base.InitializeConfig;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.kit.resourceloader.DownloaderDepend;
import com.bytedance.ies.bullet.kit.resourceloader.GeckoXDepender;
import com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService;
import com.bytedance.ies.bullet.lynx.ILynxDelegateProvider;
import com.bytedance.ies.bullet.lynx.LynxKitService;
import com.bytedance.ies.bullet.lynx.init.LynxConfig;
import com.bytedance.ies.bullet.service.base.IKitConfig;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitService;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.web.IWebKitService;
import com.bytedance.ies.bullet.service.page.PageConfig;
import com.bytedance.ies.bullet.service.schema.BulletGlobalSchemaConfig;
import com.bytedance.ies.bullet.service.webkit.IWebKitDelegateProvider;
import com.bytedance.ies.bullet.service.webkit.WebKitService;
import com.bytedance.sdk.xbridge.cn.BidConstants;
import com.bytedance.sdk.xbridge.cn.auth.BDXBridgePermission;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingKeyEntry;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingValueEntry;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.theme.ThemeManager;
import com.bytedance.trae.network.TraeTTNet;
import com.bytedance.trae.platform.service.ApplogService;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXInitializer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/anniex/AnnieXInitializer;", "", "<init>", "()V", "TAG", "", "init", "", "tryInitPiaEnv", "application", "Landroid/app/Application;", "initGecko", "initAnnieX", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AnnieXInitializer {
    public static final int $stable = 0;
    public static final AnnieXInitializer INSTANCE = new AnnieXInitializer();
    private static final String TAG = "AnnieXInitializer";

    private AnnieXInitializer() {
    }

    @JvmStatic
    public static final void init() {
        Application application = AppHost.INSTANCE.getApplication();
        FLogger.INSTANCE.i(TAG, "AnnieX init start");
        AnnieXInitializer annieXInitializer = INSTANCE;
        annieXInitializer.tryInitPiaEnv(application);
        annieXInitializer.initGecko(application);
        annieXInitializer.initAnnieX(application);
        FLogger.INSTANCE.i(TAG, "AnnieX init success");
    }

    private final void tryInitPiaEnv(Application application) {
        try {
            Class.forName("com.bytedance.pia.core.api.PiaEnv$Default").getMethod("setApplicationContext", Context.class).invoke(null, application);
        } catch (Exception unused) {
        }
    }

    private final void initGecko(Application application) {
        GeckoLogger.enable();
        String deviceId = ApplogService.INSTANCE.getDeviceId();
        if (deviceId.length() == 0) {
            deviceId = "unknown";
        }
        GeckoGlobalManager.inst().init(new GeckoGlobalConfig.Builder(application).appId(AppHost.INSTANCE.getAppId()).host("trae").appVersion(AppHost.INSTANCE.getVersionName()).deviceId(deviceId).env(GeckoGlobalConfig.ENVType.PROD).build());
        GeckoGlobalManager.inst().syncGlobalSettings();
    }

    private final void initAnnieX(Application application) {
        boolean isDebug = AppHost.INSTANCE.isDebug();
        DebugInfo debugInfo = new DebugInfo();
        debugInfo.setShowDebugTagView(isDebug);
        debugInfo.setDebugTagPrefix("Trae");
        InitializeConfig initializeConfig = new InitializeConfig(application, BidConstants.DEFAULT);
        initializeConfig.setDebuggable(isDebug);
        initializeConfig.setDebugInfo(debugInfo);
        initializeConfig.setSchemaConfig(new BulletGlobalSchemaConfig(BidConstants.DEFAULT));
        initializeConfig.setResourceLoaderConfig(new ResourceLoaderConfig("gecko.snssdk.com", "CN", new ArrayList(), String.valueOf(AppHost.INSTANCE.getAppId()), AppHost.INSTANCE.getVersionName(), ApplogService.INSTANCE.getDeviceId(), new GeckoConfig("2373bbcf94c1b893dad48961d0a2d086", "offlineX", new GeckoXDepender(), false, false, 24, (DefaultConstructorMarker) null), (Map) null, new DownloaderDepend(), (Object) null, (Object) null, false, 3712, (DefaultConstructorMarker) null));
        initializeConfig.setPageConfig(new PageConfig(AnnieXHostActivity.class));
        initializeConfig.addService(IWebKitService.class, new WebKitService((IKitConfig) null, (IWebKitDelegateProvider) null, 3, (DefaultConstructorMarker) null));
        initializeConfig.addService(IWebGlobalConfigService.class, new TraeWebGlobalConfigService());
        initializeConfig.addService(ILynxKitService.class, new LynxKitService(new LynxConfig.Builder(application).setDebug(isDebug).build(), (ILynxDelegateProvider) null, 2, (DefaultConstructorMarker) null));
        initializeConfig.addService(IBridgeService.class, new DefaultBridgeService());
        initializeConfig.addService(IAnnieXPiaMethodProvider.class, new DefaultAnnieXPIAMethodProvider());
        AnnieX.INSTANCE.init(initializeConfig);
        AnnieX.INSTANCE.ensureLynxInitialized(application);
        BDXBridgePermission.INSTANCE.init(new AnnieXInitializer$initAnnieX$1());
        XBaseRuntime.INSTANCE.setHostContextDepend(new IHostContextDepend() { // from class: com.bytedance.trae.anniex.AnnieXInitializer$initAnnieX$2
            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getCurrentTelcomCarrier() {
                return null;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public boolean isBaseMode() {
                return true;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public boolean isTeenMode() {
                return false;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public Context getApplicationContext() {
                return IHostContextDepend.DefaultImpls.getApplicationContext(this);
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public Application getApplication() {
                return AppHost.INSTANCE.getApplication();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getDeviceId() {
                return ApplogService.INSTANCE.getDeviceId();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public int getAppId() {
                return AppHost.INSTANCE.getAppId();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getAppName() {
                return AppHost.INSTANCE.getAppName();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getChannel() {
                return AppHost.INSTANCE.getBuildChannel();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public long getVersionCode() {
                return AppHost.INSTANCE.getVersionCode();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getVersionName() {
                return AppHost.INSTANCE.getVersionName();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getUpdateVersion() {
                return String.valueOf(AppHost.INSTANCE.getUpdateVersionCode());
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getLanguage() {
                String language = Locale.getDefault().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                return language;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getSkinType() {
                return ThemeManager.INSTANCE.isDarkMode() ? "black" : "white";
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getSkinName() {
                return getSkinType();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getPackageName() {
                String packageName = AppHost.INSTANCE.getApplication().getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                return packageName;
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public boolean isDebuggable() {
                return AppHost.INSTANCE.isDebug();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public boolean isBoeEnable() {
                return TraeTTNet.INSTANCE.getHttpEnv().getBoeEnable();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getBoeChannel() {
                return TraeTTNet.INSTANCE.getHttpEnv().getBoeEnv();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public boolean isPPEEnable() {
                return TraeTTNet.INSTANCE.getHttpEnv().getPpeEnable();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public String getPPEChannel() {
                return TraeTTNet.INSTANCE.getHttpEnv().getPpeEnv();
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
            public List<SettingValueEntry> getSettings(List<SettingKeyEntry> settingKeys) {
                Intrinsics.checkNotNullParameter(settingKeys, "settingKeys");
                return CollectionsKt.emptyList();
            }
        });
    }
}
