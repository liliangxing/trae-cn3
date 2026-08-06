package com.bytedance.ies.argus.repository;

import com.bytedance.applog.server.Api;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusContainerAspect;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.ArgusGlobalCommonConfig;
import com.bytedance.ies.argus.bean.ArgusInitSetting;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.ies.argus.bean.IEnumClass;
import com.bytedance.lynx.service.security.LynxSecurityService;
import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;

/* compiled from: ArgusConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 F2\u00020\u0001:\u0003FGHB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u001aJ\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u0004\u0018\u00010)J\b\u0010+\u001a\u0004\u0018\u00010%J\u001d\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tH\u0000¢\u0006\u0002\b1J\u0006\u00102\u001a\u00020-J\u001d\u00103\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tH\u0000¢\u0006\u0002\b4J\u0018\u00105\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tH\u0002J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010/H\u0002J\u001a\u00108\u001a\u00020-2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020-0:J\u001a\u0010<\u001a\u00020-2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020-0:J\u001a\u0010>\u001a\u00020-2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020-0:J\u0006\u0010@\u001a\u00020-J\u0006\u0010A\u001a\u00020\u000fJ\u0006\u0010B\u001a\u00020-J\u0006\u0010C\u001a\u00020-J\u000e\u0010D\u001a\u00020-2\u0006\u0010.\u001a\u00020)J\u000e\u0010E\u001a\u00020-2\u0006\u0010.\u001a\u00020%R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u00020\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00060\u001fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusConfigManager;", "", "()V", "<set-?>", "Lcom/bytedance/ies/argus/bean/ArgusGlobalCommonConfig;", "argusSecuritySettingConfig", "getArgusSecuritySettingConfig", "()Lcom/bytedance/ies/argus/bean/ArgusGlobalCommonConfig;", "cacheSettingsInfo", "Lcom/bytedance/ies/argus/repository/ConfigInfo;", "containerConfigProvider", "Lcom/bytedance/ies/argus/repository/ContainerConfigProvider;", "getContainerConfigProvider", "()Lcom/bytedance/ies/argus/repository/ContainerConfigProvider;", "forceCloseAll", "", "geckoCdnFetcherRetryLimit", "", "getGeckoCdnFetcherRetryLimit", "()I", "setGeckoCdnFetcherRetryLimit", "(I)V", "globalAllAspectRecoverySwitch", "Ljava/lang/Integer;", "globalAspectRecoverySwitch", "", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "globalConfigProvider", "Lcom/bytedance/ies/argus/repository/ArgusConfigManager$GlobalConfigProvider;", "latestPackageVersion", "recoveryConfigProvider", "Lcom/bytedance/ies/argus/repository/ArgusConfigManager$RecoveryConfigProvider;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "securitySettingConfig", "Lcom/bytedance/ies/argus/repository/SecuritySettingConfigModel;", "disableByRecovery", "aspect", "getContainerConfigSource", "", "getContainerConfigVersionDesc", "getSecuritySettingConfig", "onContainerConfigUpdate", "", "data", "Lorg/json/JSONObject;", "info", "onContainerConfigUpdate$anniex_release", "onFeConfigUpdated", "onGlobalConfigUpdate", "onGlobalConfigUpdate$anniex_release", "onRecoveryConfigUpdate", "parseRecoveryConfig", "recoveryConfig", "registerContainerConfigCollector", "collector", "Lkotlin/Function1;", "Lcom/bytedance/ies/argus/repository/ContainerConfigModel;", "registerGlobalConfigCollector", "Lcom/bytedance/ies/argus/repository/GlobalConfigModel;", "registerRecoverConfigCollector", "Lcom/bytedance/ies/argus/repository/RecoveryConfigModel;", "setup", "shouldCloseAllAspect", "triggerGetLatestConfig", "triggerGetOfflineConfig", "updateFromSettings", "updateSecuritySettingConfig", "Companion", com.bytedance.ies.argus.repository.GlobalConfigProvider.TAG, "RecoveryConfigProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusConfigManager {
    public static final String TAG = "ArgusConfigManager";
    private ArgusGlobalCommonConfig argusSecuritySettingConfig;
    private ConfigInfo cacheSettingsInfo;
    private boolean forceCloseAll;
    private Integer globalAllAspectRecoverySwitch;
    private SecuritySettingConfigModel securitySettingConfig;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<ArgusConfigManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ArgusConfigManager>() { // from class: com.bytedance.ies.argus.repository.ArgusConfigManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ArgusConfigManager m616invoke() {
            return new ArgusConfigManager();
        }
    });
    private Map<IArgusAspect, Integer> globalAspectRecoverySwitch = new LinkedHashMap();
    private final ContainerConfigProvider containerConfigProvider = new ContainerConfigProvider(getScope());
    private final GlobalConfigProvider globalConfigProvider = new GlobalConfigProvider();
    private final RecoveryConfigProvider recoveryConfigProvider = new RecoveryConfigProvider();
    private int latestPackageVersion = -1;
    private int geckoCdnFetcherRetryLimit = -1;

    /* compiled from: ArgusConfigManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusConfigManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/bytedance/ies/argus/repository/ArgusConfigManager;", "getInstance", "()Lcom/bytedance/ies/argus/repository/ArgusConfigManager;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgusConfigManager getInstance() {
            return (ArgusConfigManager) ArgusConfigManager.instance$delegate.getValue();
        }
    }

    public final CoroutineScope getScope() {
        return ArgusEnv.INSTANCE.getInstance().getSharedScope();
    }

    public final ContainerConfigProvider getContainerConfigProvider() {
        return this.containerConfigProvider;
    }

    public final ArgusGlobalCommonConfig getArgusSecuritySettingConfig() {
        return this.argusSecuritySettingConfig;
    }

    public final void setGeckoCdnFetcherRetryLimit(int i) {
        this.geckoCdnFetcherRetryLimit = i;
    }

    public final int getGeckoCdnFetcherRetryLimit() {
        ArgusInitSetting innerInitSettings;
        if (this.geckoCdnFetcherRetryLimit == -1) {
            ArgusGlobalCommonConfig argusGlobalCommonConfig = this.argusSecuritySettingConfig;
            this.geckoCdnFetcherRetryLimit = (argusGlobalCommonConfig == null || (innerInitSettings = argusGlobalCommonConfig.getInnerInitSettings()) == null) ? 2 : innerInitSettings.getGeckoCdnRetryTime();
        }
        return this.geckoCdnFetcherRetryLimit;
    }

    public final void setup() {
        ArgusLog.d$default(ArgusLog.INSTANCE, TAG, "config manager setup. just for debug log", null, 4, null);
    }

    public final void triggerGetOfflineConfig() {
        GeckoConfigFetcherKt.asyncFetchOfflineConfig(this, ArgusConfigType.CONTAINER_CONFIG);
        GeckoConfigFetcherKt.asyncFetchOfflineConfig(this, ArgusConfigType.GLOBAL_CONFIG);
    }

    public final void triggerGetLatestConfig() {
        GeckoConfigFetcherKt.asyncFetchCdnConfig(this, ArgusConfigType.CONTAINER_CONFIG, false);
        GeckoConfigFetcherKt.asyncFetchCdnConfig(this, ArgusConfigType.GLOBAL_CONFIG, false);
    }

    /* renamed from: shouldCloseAllAspect, reason: from getter */
    public final boolean getForceCloseAll() {
        return this.forceCloseAll;
    }

    public final void onFeConfigUpdated() {
        int packageVersion$default = PermissionConfigV2Parser.getPackageVersion$default(PermissionConfigV2Parser.INSTANCE, (String) null, 1, (Object) null);
        if (this.latestPackageVersion == packageVersion$default) {
            return;
        }
        this.latestPackageVersion = packageVersion$default;
        String publicKeys = PermissionConfigV2Parser.INSTANCE.getPublicKeys();
        LynxSecurityService.Companion.getINSTANCE().updateRSAPublicKeys(publicKeys);
        ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "update public keys success, package version: " + packageVersion$default + ", keys length: " + publicKeys.length() + ", config from: " + PermissionConfigV2Parser.INSTANCE.getPackageLoaderName(), null, 4, null);
    }

    public final SecuritySettingConfigModel getSecuritySettingConfig() {
        return this.securitySettingConfig;
    }

    public final void updateFromSettings(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        BuildersKt.launch$default(getScope(), (CoroutineContext) null, (CoroutineStart) null, new ArgusConfigManager$updateFromSettings$1(data, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseRecoveryConfig(JSONObject recoveryConfig) {
        Iterator<String> keys;
        ArgusContainerAspect argusContainerAspect;
        ArgusWebViewAspect argusWebViewAspect;
        ArgusLynxViewAspect argusLynxViewAspect;
        ArgusGlobalAspect argusGlobalAspect;
        this.forceCloseAll = recoveryConfig != null ? recoveryConfig.optBoolean("force_close_all", false) : false;
        JSONObject optJSONObject = recoveryConfig != null ? recoveryConfig.optJSONObject("aspect") : null;
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("global") : null;
        this.globalAllAspectRecoverySwitch = optJSONObject2 != null ? Integer.valueOf(optJSONObject2.optInt(WsChannelMultiProcessSharedProvider.ALL_TYPE, -1)) : null;
        if (optJSONObject2 == null || (keys = optJSONObject2.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            IEnumClass.Companion companion = IEnumClass.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(next, Api.KEY_ENCRYPT_RESP_KEY);
            ArgusContainerAspect[] values = ArgusContainerAspect.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    argusContainerAspect = null;
                    break;
                }
                argusContainerAspect = values[i];
                if (Intrinsics.areEqual(argusContainerAspect.getStringValue(), next)) {
                    break;
                } else {
                    i++;
                }
            }
            ArgusGlobalAspect argusGlobalAspect2 = argusContainerAspect;
            if (argusGlobalAspect2 == null) {
                IEnumClass.Companion companion2 = IEnumClass.INSTANCE;
                ArgusWebViewAspect[] values2 = ArgusWebViewAspect.values();
                int length2 = values2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        argusWebViewAspect = null;
                        break;
                    }
                    argusWebViewAspect = values2[i2];
                    if (Intrinsics.areEqual(argusWebViewAspect.getStringValue(), next)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                argusGlobalAspect2 = argusWebViewAspect;
                if (argusGlobalAspect2 == null) {
                    IEnumClass.Companion companion3 = IEnumClass.INSTANCE;
                    ArgusLynxViewAspect[] values3 = ArgusLynxViewAspect.values();
                    int length3 = values3.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length3) {
                            argusLynxViewAspect = null;
                            break;
                        }
                        argusLynxViewAspect = values3[i3];
                        if (Intrinsics.areEqual(argusLynxViewAspect.getStringValue(), next)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    argusGlobalAspect2 = argusLynxViewAspect;
                    if (argusGlobalAspect2 == null) {
                        IEnumClass.Companion companion4 = IEnumClass.INSTANCE;
                        ArgusGlobalAspect[] values4 = ArgusGlobalAspect.values();
                        int length4 = values4.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length4) {
                                argusGlobalAspect = null;
                                break;
                            }
                            argusGlobalAspect = values4[i4];
                            if (Intrinsics.areEqual(argusGlobalAspect.getStringValue(), next)) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        argusGlobalAspect2 = argusGlobalAspect;
                    }
                }
            }
            if (argusGlobalAspect2 != null) {
                this.globalAspectRecoverySwitch.put(argusGlobalAspect2, Integer.valueOf(optJSONObject2.optInt(next, -1)));
            }
        }
    }

    public final boolean disableByRecovery(IArgusAspect aspect) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        Integer num = this.globalAllAspectRecoverySwitch;
        if (num != null && num.intValue() == 0) {
            return true;
        }
        Integer num2 = this.globalAspectRecoverySwitch.get(aspect);
        return num2 != null && num2.intValue() == 0;
    }

    public final String getContainerConfigVersionDesc() {
        ContainerConfigModel storage = this.containerConfigProvider.getStorage();
        if (storage == null) {
            return "config_is_null";
        }
        String version = storage.getVersion();
        return version == null ? "config_version_is_null" : version;
    }

    public final String getContainerConfigSource() {
        ArgusGeckoFetchType from;
        ContainerConfigModel storage = this.containerConfigProvider.getStorage();
        if (storage == null || (from = storage.getFrom()) == null) {
            return null;
        }
        return from.getStr();
    }

    public final void updateSecuritySettingConfig(SecuritySettingConfigModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.securitySettingConfig = data;
    }

    public final void onContainerConfigUpdate$anniex_release(JSONObject data, ConfigInfo info) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(info, "info");
        this.containerConfigProvider.onConfigUpdate(data, info);
    }

    public final void registerContainerConfigCollector(Function1<? super ContainerConfigModel, Unit> collector) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        this.containerConfigProvider.registerCollector(collector);
    }

    public final void onGlobalConfigUpdate$anniex_release(JSONObject data, ConfigInfo info) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(info, "info");
        this.globalConfigProvider.onConfigUpdate(data, info);
    }

    public final void registerGlobalConfigCollector(Function1<? super GlobalConfigModel, Unit> collector) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        this.globalConfigProvider.registerCollector(collector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRecoveryConfigUpdate(JSONObject data, ConfigInfo info) {
        this.recoveryConfigProvider.onConfigUpdate(data, info);
    }

    public final void registerRecoverConfigCollector(Function1<? super RecoveryConfigModel, Unit> collector) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        this.recoveryConfigProvider.registerCollector(collector);
    }

    /* compiled from: ArgusConfigManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusConfigManager$RecoveryConfigProvider;", "Lcom/bytedance/ies/argus/repository/BaseConfigProvider;", "Lcom/bytedance/ies/argus/repository/RecoveryConfigModel;", "(Lcom/bytedance/ies/argus/repository/ArgusConfigManager;)V", "innerParse", "data", "Lorg/json/JSONObject;", "info", "Lcom/bytedance/ies/argus/repository/ConfigInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class RecoveryConfigProvider extends BaseConfigProvider<RecoveryConfigModel> {
        public RecoveryConfigProvider() {
            super(ArgusConfigManager.this.getScope());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.ies.argus.repository.BaseConfigProvider
        public RecoveryConfigModel innerParse(JSONObject data, ConfigInfo info) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(info, "info");
            return RecoveryConfigModel.INSTANCE.init(data, info);
        }
    }

    /* compiled from: ArgusConfigManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusConfigManager$GlobalConfigProvider;", "Lcom/bytedance/ies/argus/repository/BaseConfigProvider;", "Lcom/bytedance/ies/argus/repository/GlobalConfigModel;", "(Lcom/bytedance/ies/argus/repository/ArgusConfigManager;)V", "innerParse", "data", "Lorg/json/JSONObject;", "info", "Lcom/bytedance/ies/argus/repository/ConfigInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class GlobalConfigProvider extends BaseConfigProvider<GlobalConfigModel> {
        public GlobalConfigProvider() {
            super(ArgusConfigManager.this.getScope());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.ies.argus.repository.BaseConfigProvider
        public GlobalConfigModel innerParse(JSONObject data, ConfigInfo info) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(info, "info");
            return GlobalConfigModel.INSTANCE.init(data, info);
        }
    }
}
