package com.lynx.tasm.performance.longtasktiming;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxLongTaskMonitor {
    public static final String PLATFORM_FUNC_TASK = "platform_func_task";
    private static boolean sEnable = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_LONG_TASK_TIMING, false);
    private static volatile boolean sIsNativeLibraryLoaded = false;

    private static native void nativeDidProcessTask();

    private static native void nativeUpdateLongTaskTimingIfNeed(String str, String str2, String str3);

    private static native void nativeWillProcessTask(String str, String str2, String str3, int i);

    public static boolean willProcessTask(String str, int i, LynxBooleanOption lynxBooleanOption) {
        return willProcessTask(PLATFORM_FUNC_TASK, str, null, i, lynxBooleanOption);
    }

    public static boolean willProcessTask(String str, String str2, String str3, int i, LynxBooleanOption lynxBooleanOption) {
        if (lynxBooleanOption == LynxBooleanOption.FALSE || !canExecute()) {
            return false;
        }
        nativeWillProcessTask(str, str2, str3, i);
        return true;
    }

    public static void updateLongTaskTimingIfNeed(String str, String str2, String str3) {
        if (canExecute()) {
            nativeUpdateLongTaskTimingIfNeed(str, str2, str3);
        }
    }

    public static void didProcessTask() {
        if (canExecute()) {
            nativeDidProcessTask();
        }
    }

    private static boolean canExecute() {
        if (!sEnable) {
            return false;
        }
        if (!sIsNativeLibraryLoaded) {
            sIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
        }
        return sIsNativeLibraryLoaded;
    }
}
