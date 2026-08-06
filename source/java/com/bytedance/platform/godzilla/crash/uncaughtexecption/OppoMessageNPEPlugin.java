package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* loaded from: classes4.dex */
public class OppoMessageNPEPlugin extends UncaughtExceptionPlugin {
    private static final String STACK_CLASS = "android.os.Message";
    private static final String STACK_METHOD = "toString";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "OppoMessageNPEPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        return doInterceptMainException(th);
    }

    private boolean doInterceptMainException(Throwable th) {
        if (th instanceof NullPointerException) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (STACK_CLASS.equals(stackTraceElement.getClassName()) && STACK_METHOD.equals(stackTraceElement.getMethodName())) {
                    Logger.e(getName(), "Hint OppoMessageNPE case ,fix it.");
                    return true;
                }
            }
        }
        return false;
    }
}
