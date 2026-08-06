package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.os.Build;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.utils.RomUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class StopActivityNPEPlugin extends UncaughtExceptionPlugin {
    private static final String STACK_CLASS = "android.app.ActivityThread";
    private static final String STACK_METHOD = "handleStopActivity";
    private static Set<Integer> sOptSDKInts;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "StopActivityNPEPlugin";
    }

    static {
        HashSet hashSet = new HashSet();
        sOptSDKInts = hashSet;
        hashSet.add(23);
        sOptSDKInts.add(24);
        sOptSDKInts.add(25);
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        if (th instanceof NullPointerException) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace.length > 0) {
                StackTraceElement stackTraceElement = stackTrace[0];
                if (STACK_CLASS.equals(stackTraceElement.getClassName()) && STACK_METHOD.equals(stackTraceElement.getMethodName())) {
                    Logger.e(getName(), "Hint StopActivityNPE case ,fix it.");
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        if (sOptSDKInts.contains(Integer.valueOf(Build.VERSION.SDK_INT))) {
            return Build.MODEL.startsWith("GIONEE") || Build.MODEL.startsWith("Funtouch") || Build.MODEL.startsWith("coloros_V3.0") || RomUtils.isAmigo();
        }
        return false;
    }
}
