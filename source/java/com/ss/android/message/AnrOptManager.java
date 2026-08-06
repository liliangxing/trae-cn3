package com.ss.android.message;

import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.service.IPushConfigurationService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AnrOptManager {
    public static void postRunnable(Runnable runnable) {
        if (enableOptAnr()) {
            PushThreadHandlerManager.inst().postRunnable(runnable);
        } else {
            runnable.run();
        }
    }

    public static boolean enableOptAnr() {
        PushCommonConfiguration pushCommonConfiguration;
        IPushConfigurationService pushConfigurationService = PushCommonSupport.getInstance().getPushConfigurationService();
        if (pushConfigurationService == null || (pushCommonConfiguration = pushConfigurationService.getPushCommonConfiguration()) == null) {
            return false;
        }
        return pushCommonConfiguration.mIPushCommonConfiguration.optAnr();
    }
}
