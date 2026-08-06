package com.bytedance.ies.bullet.settings;

import com.bytedance.ies.bullet.base.settings.ArgusSecuritySettings;
import com.bytedance.ies.bullet.base.settings.ClientAiConfig;
import com.bytedance.ies.bullet.base.settings.ForestSettingsConfig;
import com.bytedance.ies.bullet.base.settings.MixConfig;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.base.settings.WebConfig;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaModelConfig;
import com.bytedance.ies.bullet.interaction.predefine.model.WasmDisableListConfig;
import com.bytedance.ies.bullet.secure.HybridSecureManager;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.settings.BulletSettingsConfig;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.settings.PineappleConfig;
import com.bytedance.ies.bullet.service.base.settings.ResourceLoaderSettingsConfig;
import com.bytedance.ies.bullet.settings.data.IBulletSettings;
import com.bytedance.news.common.settings.IndividualManager;
import com.bytedance.news.common.settings.LazyConfig;
import com.bytedance.news.common.settings.SettingsConfig;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.pia.core.setting.PIAConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletSettingsService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J#\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/settings/BulletSettingsService;", "Lcom/bytedance/ies/bullet/service/base/settings/IBulletSettingsService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "config", "Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;", "(Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;)V", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;", "setConfig", "settingsListener", "Lcom/bytedance/ies/bullet/settings/BulletSettingsService$OnUpdateListener;", "getSettingsListener", "()Lcom/bytedance/ies/bullet/settings/BulletSettingsService$OnUpdateListener;", "setSettingsListener", "(Lcom/bytedance/ies/bullet/settings/BulletSettingsService$OnUpdateListener;)V", "settingsStorage", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getSettingsStorage", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "checkUpdate", "", "obtainSettings", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "OnUpdateListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletSettingsService extends BaseBulletService implements IBulletSettingsService {
    private BulletSettingsConfig config;
    private OnUpdateListener settingsListener;
    private final ContextProviderFactory settingsStorage;

    /* compiled from: BulletSettingsService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/settings/BulletSettingsService$OnUpdateListener;", "", "onUpdate", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface OnUpdateListener {
        void onUpdate();
    }

    @Override // com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService
    public BulletSettingsConfig getConfig() {
        return this.config;
    }

    @Override // com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService
    public void setConfig(BulletSettingsConfig bulletSettingsConfig) {
        Intrinsics.checkNotNullParameter(bulletSettingsConfig, "<set-?>");
        this.config = bulletSettingsConfig;
    }

    public BulletSettingsService(BulletSettingsConfig bulletSettingsConfig) {
        Intrinsics.checkNotNullParameter(bulletSettingsConfig, "config");
        this.config = bulletSettingsConfig;
        this.settingsStorage = new ContextProviderFactory();
        IndividualManager.obtainManager("Bullet").init(new LazyConfig() { // from class: com.bytedance.ies.bullet.settings.BulletSettingsService.1
            @Override // com.bytedance.news.common.settings.LazyConfig
            public final SettingsConfig create() {
                return new SettingsConfig.Builder().context(BulletEnv.INSTANCE.getInstance().getApplication()).updateInterval(3600000).requestService(new SettingsRequestServiceImpl(BulletSettingsService.this.getConfig())).build();
            }
        });
        BulletLogger.onLog$default(BulletLogger.INSTANCE, "bullet init: ", null, 2, null);
        IndividualManager.obtainManager("Bullet").registerListener(new SettingsUpdateListener() { // from class: com.bytedance.ies.bullet.settings.BulletSettingsService.2
            @Override // com.bytedance.news.common.settings.SettingsUpdateListener
            public final void onSettingsUpdate(SettingsData settingsData) {
                try {
                    BulletLogger.onLog$default(BulletLogger.INSTANCE, "bullet onUpdate,appSettings = " + settingsData.getAppSettings() + ",userSettings = " + settingsData.getUserSettings(), null, 2, null);
                } catch (Throwable unused) {
                }
                Object obtain = IndividualManager.obtainManager("Bullet").obtain(IBulletSettings.class);
                Intrinsics.checkNotNullExpressionValue(obtain, "obtainManager(\"Bullet\").…lletSettings::class.java)");
                IBulletSettings iBulletSettings = (IBulletSettings) obtain;
                BulletSettingsService.this.getSettingsStorage().registerHolder(ResourceLoaderSettingsConfig.class, iBulletSettings.getResourceLoaderConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(CommonConfig.class, iBulletSettings.getCommonConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(WebConfig.class, iBulletSettings.getWebConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(MonitorSettingsConfig.class, iBulletSettings.getMonitorConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(PineappleConfig.class, iBulletSettings.getPineappleConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(MixConfig.class, iBulletSettings.getMixConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(SecuritySettingConfig.class, iBulletSettings.getSecuritySettingConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(ForestSettingsConfig.class, iBulletSettings.getForestSettingConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(MetaModelConfig.class, iBulletSettings.getAnnieXPredefineConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(ArgusSecuritySettings.class, iBulletSettings.getArgusSecuritySettingConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(WasmDisableListConfig.class, iBulletSettings.getAnnieXPredefineWasmConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(PIAConfig.class, iBulletSettings.getPIAConfig());
                BulletSettingsService.this.getSettingsStorage().registerHolder(ClientAiConfig.class, iBulletSettings.getClientAiConfig());
                SccConfig sccSettingsConfig = iBulletSettings.getSccSettingsConfig();
                if (sccSettingsConfig != null) {
                    HybridSecureManager.INSTANCE.getInstance().updateGlobalConfig$anniex_release(sccSettingsConfig);
                }
                OnUpdateListener settingsListener = BulletSettingsService.this.getSettingsListener();
                if (settingsListener != null) {
                    settingsListener.onUpdate();
                }
            }
        }, !getConfig().getSettingsUpdateCallbackAsync());
        if (IConditionCallKt.enableBulletSettingDelay()) {
            IConditionCallKt.delayRunbulletSetting(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.settings.BulletSettingsService.3
                public /* bridge */ /* synthetic */ Object invoke() {
                    m591invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m591invoke() {
                    IndividualManager.obtainManager("Bullet").updateSettings(true);
                }
            });
        } else {
            IndividualManager.obtainManager("Bullet").updateSettings(true);
        }
    }

    public final ContextProviderFactory getSettingsStorage() {
        return this.settingsStorage;
    }

    public final OnUpdateListener getSettingsListener() {
        return this.settingsListener;
    }

    public final void setSettingsListener(OnUpdateListener onUpdateListener) {
        this.settingsListener = onUpdateListener;
    }

    @Override // com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService
    public void checkUpdate() {
        IndividualManager.obtainManager("Bullet").updateSettings(true);
    }

    @Override // com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService
    public <T> T obtainSettings(Class<T> clazz) {
        T t;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            Result.Companion companion = Result.Companion;
            t = (T) Result.constructor-impl(this.settingsStorage.provideInstance(clazz));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = (T) Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(t)) {
            return null;
        }
        return t;
    }
}
