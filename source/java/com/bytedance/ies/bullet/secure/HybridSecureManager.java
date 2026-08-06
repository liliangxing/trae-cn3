package com.bytedance.ies.bullet.secure;

import android.app.Application;
import android.net.Uri;
import com.bytedance.ies.argus.api.ArgusAPI;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.ArgusSecureManager;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.api.interfaces.ArgusInitSetting;
import com.bytedance.ies.argus.api.interfaces.ILifeCycleDepend;
import com.bytedance.ies.argus.api.interfaces.IUploadSignFailedLynxDepend;
import com.bytedance.ies.argus.api.params.ArgusResourceFrom;
import com.bytedance.ies.argus.api.params.ArgusResourceLoaderInfo;
import com.bytedance.ies.argus.repository.JSBRequestCheckConfig;
import com.bytedance.ies.argus.repository.MethodAuthTypeSetting;
import com.bytedance.ies.argus.repository.SecuritySettingConfigModel;
import com.bytedance.ies.bullet.base.settings.JSBAuthStrategySetting;
import com.bytedance.ies.bullet.base.settings.LynxSignVerifyConfig;
import com.bytedance.ies.bullet.base.settings.MonitorConfig;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.lynx.scc.cloudservice.SccCloudServiceManager;
import com.bytedance.sdk.xbridge.cn.auth.bean.JSBAuthMethodAuthTypeSetting;
import com.bytedance.sdk.xbridge.cn.auth.bean.LynxAuthStrategyConfig;
import com.bytedance.sdk.xbridge.cn.auth.bean.WebAuthStrategyConfig;
import com.bytedance.sdk.xbridge.cn.auth.repository.AuthStrategyRepository;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XDefaultHostNetworkDependImpl;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: HybridSecureManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0017\u0010\u001c\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0002J\u0015\u0010%\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b&J\f\u0010'\u001a\u00020(*\u00020)H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ies/bullet/secure/HybridSecureManager;", "", "()V", "_configWithBid", "", "", "Lcom/bytedance/ies/bullet/secure/HybridSecureConfig;", "_enableArgus", "", "get_enableArgus", "()Z", "_globalConfig", "copyMethodAuthType", "", "Lcom/bytedance/ies/argus/repository/MethodAuthTypeSetting;", "origin", "Lcom/bytedance/ies/bullet/base/settings/MethodAuthTypeSetting;", "executeInitTask", "", "getSecureConfig", "bid", "getSecureConfig$anniex_release", EventConstants.PARAM_SOURCE_INIT, "config", "init$anniex_release", "initArgusSecureDelegate", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "initArgusSecurityModule", "updateArgusJSONConfig", "updateArgusJSONConfig$anniex_release", "updateGlobalConfig", "sccConfig", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "updateGlobalConfig$anniex_release", "updateJSBAuthConfig", "data", "Lcom/bytedance/ies/bullet/base/settings/SecuritySettingConfig;", "updateSecuritySettingConfig", "updateSecuritySettingConfig$anniex_release", "toResourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HybridSecureManager {
    public static final String DEFAULT_REPORT_BID = "bullet_custom_bid";
    public static final String TAG = "HybridSecureManager";
    private Map<String, HybridSecureConfig> _configWithBid;
    private HybridSecureConfig _globalConfig;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<HybridSecureManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<HybridSecureManager>() { // from class: com.bytedance.ies.bullet.secure.HybridSecureManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final HybridSecureManager m552invoke() {
            return new HybridSecureManager(null);
        }
    });

    /* compiled from: HybridSecureManager.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArgusResourceFrom.values().length];
            try {
                iArr[ArgusResourceFrom.CDN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArgusResourceFrom.GECKO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ HybridSecureManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: HybridSecureManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/secure/HybridSecureManager$Companion;", "", "()V", "DEFAULT_REPORT_BID", "", "TAG", "instance", "Lcom/bytedance/ies/bullet/secure/HybridSecureManager;", "getInstance", "()Lcom/bytedance/ies/bullet/secure/HybridSecureManager;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HybridSecureManager getInstance() {
            return (HybridSecureManager) HybridSecureManager.instance$delegate.getValue();
        }
    }

    private HybridSecureManager() {
        this._configWithBid = new LinkedHashMap();
    }

    private final boolean get_enableArgus() {
        HybridSecureConfig hybridSecureConfig = this._globalConfig;
        if (hybridSecureConfig != null) {
            return hybridSecureConfig.getEnableArgus();
        }
        return false;
    }

    public final void executeInitTask() {
        ArgusSecureManager.INSTANCE.executeInitTask();
    }

    public final void updateGlobalConfig$anniex_release(SccConfig sccConfig) {
        Intrinsics.checkNotNullParameter(sccConfig, "sccConfig");
        SccCloudServiceManager.setSettingsJsonConfig(sccConfig.toJsonObject$anniex_release());
    }

    public final boolean init$anniex_release(String bid, HybridSecureConfig config) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(config, "config");
        String appId = BulletEnv.INSTANCE.getInstance().getAppId();
        if (appId != null) {
            AuthStrategyRepository.INSTANCE.updateAppId(appId);
        }
        if (Intrinsics.areEqual("default_bid", bid)) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "setSecureConfig: set global config", null, null, 12, null);
            if (this._globalConfig != null) {
                return false;
            }
            this._globalConfig = config;
            initArgusSecurityModule(config);
        } else {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "setSecureConfig: set config for " + bid, null, null, 12, null);
            if (this._configWithBid.get(bid) != null) {
                return false;
            }
            this._configWithBid.put(bid, config);
        }
        return true;
    }

    public final HybridSecureConfig getSecureConfig$anniex_release(String bid) {
        HybridSecureConfig hybridSecureConfig;
        HybridSecureConfig clone$anniex_release;
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (Intrinsics.areEqual("default_bid", bid)) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "getSecureConfig: get global config", null, null, 12, null);
            return this._globalConfig;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "getSecureConfig: get config for " + bid, null, null, 12, null);
        HybridSecureConfig hybridSecureConfig2 = this._configWithBid.get(bid);
        if (hybridSecureConfig2 == null || (hybridSecureConfig = this._globalConfig) == null || (clone$anniex_release = hybridSecureConfig.clone$anniex_release()) == null) {
            return null;
        }
        return clone$anniex_release.merge$anniex_release(hybridSecureConfig2);
    }

    public final ArgusContainerDelegate initArgusSecureDelegate() {
        if (get_enableArgus() && ArgusSecureManager.INSTANCE.hasInit()) {
            return ArgusAPI.INSTANCE.initContainerDelegate();
        }
        return null;
    }

    public final void updateArgusJSONConfig$anniex_release(String config) {
        if (config == null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "updateArgusJSONConfig: config is null", null, null, 12, null);
        } else if (get_enableArgus()) {
            ArgusSecureManager.INSTANCE.asyncUpdateJSONConfig(config);
        }
    }

    public final void updateSecuritySettingConfig$anniex_release(SecuritySettingConfig data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SecuritySettingConfigModel securitySettingConfigModel = new SecuritySettingConfigModel();
        JSBAuthStrategySetting jsbAuthStrategySettingConfig = data.getJsbAuthStrategySettingConfig();
        if (jsbAuthStrategySettingConfig != null) {
            com.bytedance.ies.argus.repository.JSBAuthStrategySetting jSBAuthStrategySetting = new com.bytedance.ies.argus.repository.JSBAuthStrategySetting();
            jSBAuthStrategySetting.setEnableSafeWebJSBAuth(jsbAuthStrategySettingConfig.getEnableSafeWebJSBAuth());
            jSBAuthStrategySetting.setPrivateDomains(jsbAuthStrategySettingConfig.getPrivateDomains());
            jSBAuthStrategySetting.setEnableJSBAuthV3(jsbAuthStrategySettingConfig.getEnableJSBAuthV3());
            jSBAuthStrategySetting.setEnableAutoMatchUrl(jsbAuthStrategySettingConfig.getEnableAutoMatchUrl());
            JSBRequestCheckConfig jSBRequestCheckConfig = new JSBRequestCheckConfig();
            com.bytedance.ies.bullet.base.settings.JSBRequestCheckConfig jsbRequestCheck = jsbAuthStrategySettingConfig.getJsbRequestCheck();
            jSBRequestCheckConfig.setMethods(jsbRequestCheck != null ? jsbRequestCheck.getMethods() : null);
            com.bytedance.ies.bullet.base.settings.JSBRequestCheckConfig jsbRequestCheck2 = jsbAuthStrategySettingConfig.getJsbRequestCheck();
            jSBRequestCheckConfig.setSettings(jsbRequestCheck2 != null ? jsbRequestCheck2.getSettings() : null);
            jSBAuthStrategySetting.setJsbRequestCheck(jSBRequestCheckConfig);
            jSBAuthStrategySetting.setCustomMethodAuthTypeSetting(copyMethodAuthType(jsbAuthStrategySettingConfig.getCustomMethodAuthTypeSetting()));
            securitySettingConfigModel.setJsbAuthStrategySettingConfig(jSBAuthStrategySetting);
        }
        LynxSignVerifyConfig lynxSignVerifyStrategyConfig = data.getLynxSignVerifyStrategyConfig();
        if (lynxSignVerifyStrategyConfig != null) {
            com.bytedance.ies.argus.repository.LynxSignVerifyConfig lynxSignVerifyConfig = new com.bytedance.ies.argus.repository.LynxSignVerifyConfig();
            lynxSignVerifyConfig.setForceDegradeCodeList(lynxSignVerifyStrategyConfig.getForceDegradeCodeList());
            securitySettingConfigModel.setLynxSignVerifyStrategyConfig(lynxSignVerifyConfig);
        }
        MonitorConfig monitorConfig = data.getMonitorConfig();
        if (monitorConfig != null) {
            com.bytedance.ies.argus.repository.MonitorConfig monitorConfig2 = new com.bytedance.ies.argus.repository.MonitorConfig();
            monitorConfig2.setEnableUploadLynxSignFailedFile(monitorConfig.getEnableUploadLynxSignFailedFile());
            monitorConfig2.setUploadLynxVerifyCodeList(monitorConfig.getUploadLynxVerifyCodeList());
            securitySettingConfigModel.setMonitorConfig(monitorConfig2);
        }
        ArgusSecureManager.INSTANCE.updateSecuritySettingConfig(securitySettingConfigModel);
        updateJSBAuthConfig(data);
    }

    private final Map<String, MethodAuthTypeSetting> copyMethodAuthType(Map<String, com.bytedance.ies.bullet.base.settings.MethodAuthTypeSetting> origin) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (origin != null) {
            for (Map.Entry<String, com.bytedance.ies.bullet.base.settings.MethodAuthTypeSetting> entry : origin.entrySet()) {
                String key = entry.getKey();
                com.bytedance.ies.bullet.base.settings.MethodAuthTypeSetting value = entry.getValue();
                MethodAuthTypeSetting methodAuthTypeSetting = new MethodAuthTypeSetting();
                methodAuthTypeSetting.setEnableWebForcePrivate(value.getEnableWebForcePrivate());
                methodAuthTypeSetting.setWebPublicMethods(value.getWebPublicMethods());
                methodAuthTypeSetting.setEnableLynxForcePrivate(value.getEnableLynxForcePrivate());
                methodAuthTypeSetting.setLynxPublicMethods(value.getLynxPublicMethods());
                methodAuthTypeSetting.setCommonSecureMethods(value.getCommonSecureMethods());
                linkedHashMap.put(key, methodAuthTypeSetting);
            }
        }
        return linkedHashMap;
    }

    private final void updateJSBAuthConfig(SecuritySettingConfig data) {
        List<Integer> emptyList;
        WebAuthStrategyConfig webAuthStrategyConfig;
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("updateJSBAuthConfig, enableJSBAuthV3: ");
        JSBAuthStrategySetting jsbAuthStrategySettingConfig = data.getJsbAuthStrategySettingConfig();
        HybridLogger.d$default(hybridLogger, TAG, sb.append(jsbAuthStrategySettingConfig != null ? Boolean.valueOf(jsbAuthStrategySettingConfig.getEnableJSBAuthV3()) : null).toString(), null, null, 12, null);
        JSBAuthStrategySetting jsbAuthStrategySettingConfig2 = data.getJsbAuthStrategySettingConfig();
        if (jsbAuthStrategySettingConfig2 != null) {
            if (jsbAuthStrategySettingConfig2.getEnableJSBAuthV3()) {
                webAuthStrategyConfig = new WebAuthStrategyConfig(false, (Map) null, false, 7, (DefaultConstructorMarker) null);
                webAuthStrategyConfig.setEnableJSBAuthV3(true);
                Map<String, String[]> privateDomains = jsbAuthStrategySettingConfig2.getPrivateDomains();
                if (privateDomains == null) {
                    privateDomains = MapsKt.emptyMap();
                }
                webAuthStrategyConfig.setPrivateDomains(privateDomains);
                webAuthStrategyConfig.setEnableAutoMatchUrl(jsbAuthStrategySettingConfig2.getEnableAutoMatchUrl());
            } else {
                webAuthStrategyConfig = new WebAuthStrategyConfig(false, (Map) null, false, 6, (DefaultConstructorMarker) null);
            }
            AuthStrategyRepository.INSTANCE.setWebAuthStrategy(webAuthStrategyConfig);
        }
        LynxSignVerifyConfig lynxSignVerifyStrategyConfig = data.getLynxSignVerifyStrategyConfig();
        AuthStrategyRepository authStrategyRepository = AuthStrategyRepository.INSTANCE;
        LynxAuthStrategyConfig lynxAuthStrategyConfig = new LynxAuthStrategyConfig((String[]) null, (List) null, 3, (DefaultConstructorMarker) null);
        lynxAuthStrategyConfig.setLynxSignVerifyWhiteList(lynxSignVerifyStrategyConfig != null ? lynxSignVerifyStrategyConfig.getWhiteList() : null);
        if (lynxSignVerifyStrategyConfig == null || (emptyList = lynxSignVerifyStrategyConfig.getForceDegradeCodeList()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        lynxAuthStrategyConfig.setForceDegradeCodeList(emptyList);
        authStrategyRepository.setLynxAuthStrategy(lynxAuthStrategyConfig);
        JSBAuthStrategySetting jsbAuthStrategySettingConfig3 = data.getJsbAuthStrategySettingConfig();
        Map<String, com.bytedance.ies.bullet.base.settings.MethodAuthTypeSetting> customMethodAuthTypeSetting = jsbAuthStrategySettingConfig3 != null ? jsbAuthStrategySettingConfig3.getCustomMethodAuthTypeSetting() : null;
        if (customMethodAuthTypeSetting != null) {
            for (Map.Entry<String, com.bytedance.ies.bullet.base.settings.MethodAuthTypeSetting> entry : customMethodAuthTypeSetting.entrySet()) {
                String key = entry.getKey();
                com.bytedance.ies.bullet.base.settings.MethodAuthTypeSetting value = entry.getValue();
                Map customMethodAuthTypeSettings = AuthStrategyRepository.INSTANCE.getCustomMethodAuthTypeSettings();
                JSBAuthMethodAuthTypeSetting jSBAuthMethodAuthTypeSetting = new JSBAuthMethodAuthTypeSetting(false, (String[]) null, false, (String[]) null, (Map) null, 31, (DefaultConstructorMarker) null);
                jSBAuthMethodAuthTypeSetting.setEnableWebForcePrivate(value.getEnableWebForcePrivate());
                String[] webPublicMethods = value.getWebPublicMethods();
                if (webPublicMethods == null) {
                    webPublicMethods = new String[0];
                }
                jSBAuthMethodAuthTypeSetting.setWebPublicMethod(webPublicMethods);
                jSBAuthMethodAuthTypeSetting.setEnableLynxForcePrivate(value.getEnableLynxForcePrivate());
                String[] lynxPublicMethods = value.getLynxPublicMethods();
                if (lynxPublicMethods == null) {
                    lynxPublicMethods = new String[0];
                }
                jSBAuthMethodAuthTypeSetting.setLynxPublicMethod(lynxPublicMethods);
                Map<String, Integer> commonSecureMethods = value.getCommonSecureMethods();
                if (commonSecureMethods == null) {
                    commonSecureMethods = MapsKt.emptyMap();
                }
                jSBAuthMethodAuthTypeSetting.setCommonSecureMethod(commonSecureMethods);
                customMethodAuthTypeSettings.put(key, jSBAuthMethodAuthTypeSetting);
            }
        }
        JSBAuthStrategySetting jsbAuthStrategySettingConfig4 = data.getJsbAuthStrategySettingConfig();
        com.bytedance.ies.bullet.base.settings.JSBRequestCheckConfig jsbRequestCheck = jsbAuthStrategySettingConfig4 != null ? jsbAuthStrategySettingConfig4.getJsbRequestCheck() : null;
        AuthStrategyRepository.INSTANCE.setRequestCheckMethods(jsbRequestCheck != null ? jsbRequestCheck.getMethods() : null);
        AuthStrategyRepository.INSTANCE.setRequestCheckSettings(jsbRequestCheck != null ? jsbRequestCheck.getSettings() : null);
    }

    private final void initArgusSecurityModule(HybridSecureConfig config) {
        if (config.getEnableArgus()) {
            ArgusInitConfig.HostInitConfig argusInitHostConfig = config.getArgusInitHostConfig();
            if (argusInitHostConfig == null) {
                argusInitHostConfig = new ArgusInitConfig.HostInitConfig((ArgusInitSetting) null, false, false, 7, (DefaultConstructorMarker) null);
            }
            ArgusSecureManager.INSTANCE.init(new ArgusInitConfig(argusInitHostConfig, config.getPermissionConfigProvider(), config.getPassportDepend(), new ArgusInitConfig.AppEnv(BulletEnv.INSTANCE.getInstance().getAppId(), BulletEnv.INSTANCE.getInstance().getAppVersion(), BulletEnv.INSTANCE.getInstance().getDid(), BulletEnv.INSTANCE.getInstance().getChannel(), BulletEnv.INSTANCE.getInstance().getDebuggable()), BulletEnv.INSTANCE.getInstance().getApplication(), new IUploadSignFailedLynxDepend() { // from class: com.bytedance.ies.bullet.secure.HybridSecureManager$initArgusSecurityModule$initConfig$1
                public void upload(final byte[] byteArray, final JSONObject reportInfo) {
                    Intrinsics.checkNotNullParameter(byteArray, "byteArray");
                    Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
                    XBaseRuntime.INSTANCE.getHostThreadPoolExecutorDepend().getNormalThreadExecutor().execute(new Runnable() { // from class: com.bytedance.ies.bullet.secure.HybridSecureManager$initArgusSecurityModule$initConfig$1$upload$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                            if (application == null) {
                                return;
                            }
                            JSONObject jSONObject = reportInfo;
                            byte[] bArr = byteArray;
                            final File file = new File(application.getCacheDir(), "temp_sign_failed_lynx_file_" + System.currentTimeMillis());
                            if (!file.createNewFile()) {
                                return;
                            }
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                try {
                                    fileOutputStream.write(bArr);
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                                    IResponseCallback iResponseCallback = new IResponseCallback() { // from class: com.bytedance.ies.bullet.secure.HybridSecureManager$initArgusSecurityModule$initConfig$1$upload$1$1$responseCallback$1
                                        public Unit onParsingFailed(JSONObject jSONObject2, LinkedHashMap<String, String> linkedHashMap, String str, Throwable th, Integer num, int i) {
                                            return IResponseCallback.DefaultImpls.onParsingFailed(this, jSONObject2, linkedHashMap, str, th, num, i);
                                        }

                                        public void onSuccess(JSONObject body, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode) {
                                            Intrinsics.checkNotNullParameter(body, "body");
                                            Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                                            file.delete();
                                        }

                                        public void onFailed(Integer errorCode, LinkedHashMap<String, String> responseHeader, Throwable throwable, int clientCode) {
                                            Intrinsics.checkNotNullParameter(throwable, "throwable");
                                            file.delete();
                                        }
                                    };
                                    XBridgeAPIRequestUtils xBridgeAPIRequestUtils = XBridgeAPIRequestUtils.INSTANCE;
                                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                                    LinkedHashMap linkedMapOf = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("file", file)});
                                    Map mapOf = MapsKt.mapOf(TuplesKt.to("reportInfo", jSONObject.toString()));
                                    IResponseCallback iResponseCallback2 = iResponseCallback;
                                    IHostNetworkDepend hostNetworkDepend = XBaseRuntime.INSTANCE.getHostNetworkDepend();
                                    if (hostNetworkDepend == null) {
                                        hostNetworkDepend = (IHostNetworkDepend) new XDefaultHostNetworkDependImpl();
                                    }
                                    XBridgeAPIRequestUtils.post$default(xBridgeAPIRequestUtils, "https://security.zijieapi.com/api/hybrid/upload", linkedHashMap, linkedMapOf, mapOf, iResponseCallback2, hostNetworkDepend, true, 0, 128, (Object) null);
                                } finally {
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }, new ILifeCycleDepend() { // from class: com.bytedance.ies.bullet.secure.HybridSecureManager$initArgusSecurityModule$initConfig$2
                public void onLynxSignFailed(ArgusResourceLoaderInfo argusResourceInfo) {
                    ResourceInfo resourceInfo;
                    if (argusResourceInfo == null) {
                        return;
                    }
                    ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, null, null, 3, null);
                    resourceInfo = HybridSecureManager.this.toResourceInfo(argusResourceInfo);
                    with$default.deleteResource(resourceInfo);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResourceInfo toResourceInfo(ArgusResourceLoaderInfo argusResourceLoaderInfo) {
        ResourceFrom resourceFrom;
        Uri srcUri = argusResourceLoaderInfo.getSrcUri();
        ArgusResourceFrom from = argusResourceLoaderInfo.getFrom();
        int i = from == null ? -1 : WhenMappings.$EnumSwitchMapping$0[from.ordinal()];
        if (i == 1) {
            resourceFrom = ResourceFrom.CDN;
        } else {
            resourceFrom = i != 2 ? null : ResourceFrom.GECKO;
        }
        ResourceInfo resourceInfo = new ResourceInfo(srcUri, null, null, resourceFrom, false, 0L, false, null, null, null, 0L, null, 4086, null);
        resourceInfo.setCacheKey(argusResourceLoaderInfo.getCacheKey());
        resourceInfo.setFilePath(argusResourceLoaderInfo.getFilePath());
        resourceInfo.setAccessKey(argusResourceLoaderInfo.getAccessKey());
        String channel = argusResourceLoaderInfo.getChannel();
        if (channel != null) {
            resourceInfo.setChannel(channel);
        }
        return resourceInfo;
    }
}
