package com.bytedance.platform.settingsx.manager;

import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.api.exposed.ExposedManagerX;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class ExposedWrapper {
    public static void markExposed(final String str) {
        GlobalConfig.getTimerExecutor().schedule(new Runnable() { // from class: com.bytedance.platform.settingsx.manager.ExposedWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                ExposedManagerX.getInstance(GlobalConfig.getContext()).markExposed(str);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    public static void markLocalABExposed(final String str) {
        GlobalConfig.getTimerExecutor().schedule(new Runnable() { // from class: com.bytedance.platform.settingsx.manager.ExposedWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                ExposedManagerX.getInstance(GlobalConfig.getContext()).markLocalClientExposed(str);
            }
        }, 0L, TimeUnit.SECONDS);
    }
}
