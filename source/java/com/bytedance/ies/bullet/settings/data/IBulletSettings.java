package com.bytedance.ies.bullet.settings.data;

import com.bytedance.ies.bullet.base.settings.AnnieXRedirectSettingsConfig;
import com.bytedance.ies.bullet.base.settings.ArgusSecuritySettings;
import com.bytedance.ies.bullet.base.settings.ClientAiConfig;
import com.bytedance.ies.bullet.base.settings.ForestSettingsConfig;
import com.bytedance.ies.bullet.base.settings.MixConfig;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.base.settings.WebConfig;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaModelConfig;
import com.bytedance.ies.bullet.interaction.predefine.model.WasmDisableListConfig;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.settings.PineappleConfig;
import com.bytedance.ies.bullet.service.base.settings.ResourceLoaderSettingsConfig;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.bytedance.pia.core.setting.PIAConfig;
import kotlin.Metadata;

/* compiled from: IBulletSettings.kt */
@Settings(migrations = {}, settingsId = "Bullet", storageKey = "bullet")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\n\u0010\b\u001a\u0004\u0018\u00010\tH'J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH'J\n\u0010\f\u001a\u0004\u0018\u00010\rH'J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH'J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H'J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H'J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H'J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H'J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H'J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH'J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH'J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH'¨\u0006 "}, d2 = {"Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getAnnieXPredefineConfig", "Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaModelConfig;", "getAnnieXPredefineWasmConfig", "Lcom/bytedance/ies/bullet/interaction/predefine/model/WasmDisableListConfig;", "getAnnieXRedirectConfig", "Lcom/bytedance/ies/bullet/base/settings/AnnieXRedirectSettingsConfig;", "getArgusSecuritySettingConfig", "Lcom/bytedance/ies/bullet/base/settings/ArgusSecuritySettings;", "getClientAiConfig", "Lcom/bytedance/ies/bullet/base/settings/ClientAiConfig;", "getCommonConfig", "Lcom/bytedance/ies/bullet/service/base/settings/CommonConfig;", "getForestSettingConfig", "Lcom/bytedance/ies/bullet/base/settings/ForestSettingsConfig;", "getMixConfig", "Lcom/bytedance/ies/bullet/base/settings/MixConfig;", "getMonitorConfig", "Lcom/bytedance/ies/bullet/service/base/settings/MonitorSettingsConfig;", "getPIAConfig", "Lcom/bytedance/pia/core/setting/PIAConfig;", "getPineappleConfig", "Lcom/bytedance/ies/bullet/service/base/settings/PineappleConfig;", "getResourceLoaderConfig", "Lcom/bytedance/ies/bullet/service/base/settings/ResourceLoaderSettingsConfig;", "getSccSettingsConfig", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "getSecuritySettingConfig", "Lcom/bytedance/ies/bullet/base/settings/SecuritySettingConfig;", "getWebConfig", "Lcom/bytedance/ies/bullet/base/settings/WebConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IBulletSettings extends ISettings {
    MetaModelConfig getAnnieXPredefineConfig();

    WasmDisableListConfig getAnnieXPredefineWasmConfig();

    AnnieXRedirectSettingsConfig getAnnieXRedirectConfig();

    ArgusSecuritySettings getArgusSecuritySettingConfig();

    ClientAiConfig getClientAiConfig();

    CommonConfig getCommonConfig();

    ForestSettingsConfig getForestSettingConfig();

    MixConfig getMixConfig();

    MonitorSettingsConfig getMonitorConfig();

    PIAConfig getPIAConfig();

    PineappleConfig getPineappleConfig();

    ResourceLoaderSettingsConfig getResourceLoaderConfig();

    SccConfig getSccSettingsConfig();

    SecuritySettingConfig getSecuritySettingConfig();

    WebConfig getWebConfig();
}
