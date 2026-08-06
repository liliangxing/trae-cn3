package com.bytedance.trae.apm.impl.plugin;

import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* loaded from: classes5.dex */
public class HoraeArrayMapException extends UncaughtExceptionPlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "HoraeArrayMapException";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        if (!(th instanceof ArrayIndexOutOfBoundsException)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if ("android.app.ActivityThread".equals(stackTraceElement.getClassName()) && "handleTrimMemory".equals(stackTraceElement.getMethodName())) {
                return true;
            }
            if ("android.app.ActivityThread".equals(stackTraceElement.getClassName()) && "collectComponentCallbacks".equals(stackTraceElement.getMethodName())) {
                return true;
            }
        }
        return false;
    }
}
