package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.runtime.CommonParams;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.runtime.SettingManager;
import java.util.Random;

@Deprecated
/* loaded from: classes3.dex */
public class NpthBus {
    public static final String UUID_SUFIX_3_1_3 = "G";
    private static SettingManager sSettingManager;
    private static final ConfigManager sConfigManager = new ConfigManager();
    private static AppDataCenter sCenter = new AppDataCenter();
    private static volatile String sUUID = null;
    private static Object sLockUUID = new Object();

    public static long getAppStartUpTime() {
        return 0L;
    }

    public static ConfigManager getConfigManager() {
        return sConfigManager;
    }

    public static boolean isLocalDebug() {
        return RuntimeConfig.isLocalDebug();
    }

    public static boolean isLocalTest() {
        return RuntimeConfig.isLocalTest();
    }

    public static Context getApplicationContext() {
        return Global.getContext();
    }

    public static Application getApplication() {
        return Global.getApplication();
    }

    public static void setApplication(Application application) {
        Global.setApplication(application);
    }

    public static long getAppStartTime() {
        return Global.getAppStartTime();
    }

    public static CommonParams getCommonParams() {
        return CommonParams.getInstance();
    }

    public static AppDataCenter getCallCenter() {
        return sCenter;
    }

    public static String getNativeUUID() {
        if (sUUID == null) {
            synchronized (sLockUUID) {
                if (sUUID == null) {
                    sUUID = Long.toHexString(new Random().nextLong()) + '-' + getAppStartTime() + UUID_SUFIX_3_1_3;
                }
            }
        }
        return sUUID;
    }

    public static SettingManager getSettingManager() {
        if (sSettingManager == null) {
            synchronized (NpthBus.class) {
                sSettingManager = new SettingManager();
            }
        }
        return sSettingManager;
    }
}
