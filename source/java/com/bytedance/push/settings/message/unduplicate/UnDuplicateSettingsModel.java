package com.bytedance.push.settings.message.unduplicate;

import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.Logger;

/* loaded from: classes4.dex */
public class UnDuplicateSettingsModel {
    public boolean enableUnDuplicateMessage;
    public int maxCacheMessage;
    public long maxCacheTimeInHour;

    public UnDuplicateSettingsModel() {
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        this.enableUnDuplicateMessage = false;
        if (pushCommonConfiguration != null && pushCommonConfiguration.mIPushCommonConfiguration != null) {
            this.enableUnDuplicateMessage = pushCommonConfiguration.mIPushCommonConfiguration.defaultEnableUnDuplicateMessage();
            Logger.d("UnDuplicateSettingsModel", "use default UnDuplicateMessage:" + this.enableUnDuplicateMessage);
        }
        this.maxCacheMessage = 200;
        this.maxCacheTimeInHour = 24L;
    }
}
