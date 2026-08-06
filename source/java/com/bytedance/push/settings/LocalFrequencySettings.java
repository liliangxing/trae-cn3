package com.bytedance.push.settings;

import com.bytedance.push.model.LocalRevokeCache;
import com.bytedance.push.model.TokenCache;
import com.bytedance.push.settings.annotation.Settings;
import java.util.List;

@Settings(storageKey = "ttpush_local_setting")
/* loaded from: classes4.dex */
public interface LocalFrequencySettings extends ILocalSettings {
    int getInnerPushEnable();

    String getLastNotificationChannelStatus();

    String getLastRequestSettingsChannel();

    long getLastRequestSettingsTime();

    String getLastRequestSettingsUpdateVersionCode();

    String getLastRequestSettingsVersionCode();

    String getLastUpdateSenderAlias();

    String getLastUpdateSenderChannel();

    String getLastUpdateSenderDid();

    long getLastUpdateSenderTime();

    String getLastUpdateSenderUpdateVersionCode();

    String getLastUpdateSenderVersionCode();

    List<LocalRevokeCache> getRevokeRidList();

    String getSupportSender();

    int getSystemPushEnable();

    List<TokenCache> getTokenCache();

    long getUploadSwitchTs();

    boolean isLastSendNotifyEnableSucc();

    void setInnerPushEnable(int i);

    void setLastNotificationChannelStatus(String str);

    void setLastRequestSettingsChannel(String str);

    void setLastRequestSettingsTime(long j);

    void setLastRequestSettingsUpdateVersionCode(String str);

    void setLastRequestSettingsVersionCode(String str);

    void setLastSendNotifyEnableSucc(boolean z);

    void setLastUpdateSenderAlias(String str);

    void setLastUpdateSenderDid(String str);

    void setLastUpdateSenderTime(long j);

    void setLastUpdateSenderUpdateChannel(String str);

    void setLastUpdateSenderUpdateVersionCode(String str);

    void setLastUpdateSenderVersionCode(String str);

    void setRevokeRidList(List<LocalRevokeCache> list);

    void setSupportSender(String str);

    void setSystemPushEnable(int i);

    void setTokenCache(List<TokenCache> list);

    void setUploadSwitchTs(long j);
}
