package com.bytedance.platform.settingsx.api;

import android.app.Application;
import android.content.Context;
import com.bytedance.platform.settingsx.api.internal.DefaultThreadFactory;
import com.bytedance.platform.settingsx.api.storage.BlockCreator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes4.dex */
public class GlobalConfig {
    private static volatile boolean isInit;
    private static volatile Config sConfig;
    private static final ExecutorService ioWritePool = Executors.newSingleThreadExecutor(new DefaultThreadFactory("settingsx-writer"));
    private static final ExecutorService ioReadPool = Executors.newFixedThreadPool(4, new DefaultThreadFactory("settingsx-reader"));

    private GlobalConfig() {
    }

    public static synchronized void init(Config config) {
        synchronized (GlobalConfig.class) {
            if (sConfig == null) {
                if (!(config.context instanceof Application)) {
                    config.context = config.context.getApplicationContext();
                }
                sConfig = config;
            }
        }
    }

    public static void checkConfig() {
        if (sConfig == null) {
            synchronized (GlobalConfig.class) {
                if (sConfig == null) {
                    throw new IllegalStateException("SettingsX Config尚未被配置");
                }
            }
        }
    }

    public static boolean isDebug() {
        if (sConfig == null) {
            return false;
        }
        return sConfig.isDebug;
    }

    public static Context getContext() {
        checkConfig();
        return sConfig.context;
    }

    public static ExecutorService getIOWritePool() {
        checkConfig();
        return ioWritePool;
    }

    public static ExecutorService getIOReadPool() {
        checkConfig();
        return ioReadPool;
    }

    public static ThreadPoolExecutor getWorkPool() {
        checkConfig();
        return sConfig.workPool;
    }

    public static ScheduledThreadPoolExecutor getTimerExecutor() {
        checkConfig();
        return sConfig.timerExecutor;
    }

    public static BlockCreator getBlockCreator() {
        checkConfig();
        return sConfig.blockCreator;
    }

    public static ISharedPreferences getSp() {
        checkConfig();
        return sConfig.sharedPreferences;
    }

    public static IBoost getBoost() {
        checkConfig();
        return sConfig.boost;
    }

    public static Config getConfig() {
        checkConfig();
        return sConfig;
    }

    public static void setManagerInit(boolean z) {
        isInit = z;
    }

    public static boolean isManagerInit() {
        return isInit;
    }
}
