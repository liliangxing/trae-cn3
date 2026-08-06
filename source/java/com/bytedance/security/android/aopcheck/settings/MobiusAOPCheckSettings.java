package com.bytedance.security.android.aopcheck.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* compiled from: MobiusAOPCheckSettings.kt */
@Settings(settingsId = "setting_id", storageKey = "aop_check_settings")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/bytedance/security/android/aopcheck/settings/MobiusAOPCheckSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getSettingModel", "Lcom/bytedance/security/android/aopcheck/settings/SettingsModel;", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public interface MobiusAOPCheckSettings extends ISettings {
    SettingsModel getSettingModel();
}
