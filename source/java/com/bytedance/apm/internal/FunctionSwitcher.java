package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm.constant.SlardarConfigConsts;

/* loaded from: classes3.dex */
public class FunctionSwitcher {
    private static long atraceFlags = 0;
    private static int firstFlags = 0;
    private static volatile boolean isInit = false;
    private static int launchThreadInfoCount = 100;
    private static SharedPreferences mSharedPreferences;
    private static int newFirstFlags;

    public static synchronized void init(Context context) {
        synchronized (FunctionSwitcher.class) {
            if (isInit) {
                return;
            }
            isInit = true;
            if (mSharedPreferences == null) {
                mSharedPreferences = context.getSharedPreferences(SlardarConfigConsts.MONITOR_SWITCH_CONFIG, 0);
            }
            SharedPreferences sharedPreferences = mSharedPreferences;
            if (sharedPreferences != null) {
                int i = sharedPreferences.getInt(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_FIRST_FLAG, 0);
                firstFlags = i;
                newFirstFlags = i;
                atraceFlags = mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_ATRACE_FLAG, 0L);
                launchThreadInfoCount = mSharedPreferences.getInt(SlardarConfigConsts.MONITOR_SWITCH_LAUNCH_THREAD_INFO_COUNT, 100);
            }
        }
    }

    public static void updateSwitch(int i, boolean z) {
        if (z) {
            newFirstFlags = i | newFirstFlags;
        } else {
            newFirstFlags = (~i) & newFirstFlags;
        }
    }

    public static void updateGpu(long j, long j2) {
        SharedPreferences sharedPreferences = mSharedPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(SlardarConfigConsts.MONITOR_SWITCH_GPU_LOAD, j).putLong(SlardarConfigConsts.MONITOR_SWITCH_GPU_WINDOW, j2).apply();
        }
    }

    public static long getGpuLoadInterval() {
        SharedPreferences sharedPreferences = mSharedPreferences;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(SlardarConfigConsts.MONITOR_SWITCH_GPU_LOAD, 0L);
    }

    public static long getGpuLoadWindows() {
        SharedPreferences sharedPreferences = mSharedPreferences;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(SlardarConfigConsts.MONITOR_SWITCH_GPU_WINDOW, 1000L);
    }

    public static void updateLaunchThreadInfoCount(int i) {
        if (i > 0) {
            launchThreadInfoCount = i;
        }
    }

    public static void updateSwitch(int i, int i2) {
        newFirstFlags = (i2 & i) + ((~i) & newFirstFlags);
    }

    public static void updateAtraceFlags(long j) {
        atraceFlags = j;
    }

    public static void saveToSp() {
        SharedPreferences sharedPreferences = mSharedPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_FIRST_FLAG, newFirstFlags).putLong(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_ATRACE_FLAG, atraceFlags).putInt(SlardarConfigConsts.MONITOR_SWITCH_LAUNCH_THREAD_INFO_COUNT, launchThreadInfoCount).apply();
        }
    }

    public static boolean getSwitch(int i) {
        return (i & firstFlags) != 0;
    }

    public static long getAtraceFlags() {
        return atraceFlags;
    }

    public static int getMonitorRunMode() {
        return ((-536870912) & firstFlags) >>> 29;
    }

    public static int getLaunchThreadInfoCount() {
        return launchThreadInfoCount;
    }
}
