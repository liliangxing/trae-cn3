package com.bytedance.push.network;

import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alliance.IsSupportWakeUp;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.Configuration;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CommonParamProvider {
    private volatile Configuration mConfiguration;

    public CommonParamProvider(Configuration configuration) {
        this.mConfiguration = configuration;
    }

    private Configuration getConfiguration() {
        if (this.mConfiguration == null) {
            synchronized (this) {
                if (this.mConfiguration == null) {
                    this.mConfiguration = Configuration.get();
                }
            }
        }
        return this.mConfiguration;
    }

    public Map<String, String> getHttpCommonParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("proxy_support_type", getProxySupportType(getConfiguration().mApplication));
        return PushCommonSupport.getInstance().getPushCommonParamService().getHttpCommonParams(hashMap);
    }

    private String getProxySupportType(Context context) {
        boolean isSupportProxyNotification = isSupportProxyNotification();
        boolean isSupportWakeUpChannel = isSupportWakeUpChannel(context);
        return (isSupportProxyNotification && isSupportWakeUpChannel) ? "3" : isSupportWakeUpChannel ? "1" : isSupportProxyNotification ? "2" : "";
    }

    private boolean isSupportProxyNotification() {
        try {
            return PushServiceManager.get().getIPushNotificationService().isSupportProxyNotification();
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isSupportWakeUpChannel(Context context) {
        try {
            IsSupportWakeUp isSupportWakeUp = PushServiceManager.get().getIAllianceService().isSupportWakeUp(context);
            if (isSupportWakeUp == null) {
                return false;
            }
            PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(context, PushOnlineSettings.class);
            if (pushOnlineSettings.getWakeUpStrategy() == 1) {
                return isSupportWakeUp.mIsSupportWakeUp;
            }
            if (pushOnlineSettings.getWakeUpStrategy() == 2) {
                return isSupportWakeUp.mIsEnableWakeUp;
            }
            return pushOnlineSettings.getWakeUpStrategy() == 3 && isSupportWakeUp.mIsEnableWakeUp && isSupportWakeUp.mIsSupportWakeUp;
        } catch (Throwable unused) {
            return false;
        }
    }
}
