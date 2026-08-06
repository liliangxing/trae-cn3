package com.bytedance.push.frontier.setting;

import com.bytedance.push.settings.ILocalSettings;
import com.bytedance.push.settings.annotation.Settings;

@Settings(storageKey = "frontier_local_setting")
/* loaded from: classes4.dex */
public interface FrontierLocalSetting extends ILocalSettings {
    public static final String KEY_FRONTIER_SETTING = "frontier_setting";
    public static final String KEY_LAST_REQUEST_SETTING_TIME = "last_request_setting_time_mil";

    FrontierSetting getFrontierSetting();

    long getLastRequestSettingTime();

    void setFrontierSetting(FrontierSetting frontierSetting);

    void setLastRequestSettingTime(long j);
}
