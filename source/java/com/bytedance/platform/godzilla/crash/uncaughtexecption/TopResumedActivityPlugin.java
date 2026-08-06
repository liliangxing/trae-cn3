package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.os.Build;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* loaded from: classes4.dex */
public class TopResumedActivityPlugin extends UncaughtExceptionPlugin {
    private static final String ERR_MSG = "Activity top position already set to onTop=false";
    private static final String STACK_CLASS = "android.app.ActivityThread";
    private static final String STACK_METHOD = "handleTopResumedActivityChanged";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "TopResumedActivityPlugin";
    }

    private boolean isTopResumedActivityException(Thread thread, Throwable th) {
        if (th instanceof IllegalStateException) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement != null && STACK_CLASS.equals(stackTraceElement.getClassName()) && STACK_METHOD.equals(stackTraceElement.getMethodName()) && ERR_MSG.equals(th.getMessage())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        return isTopResumedActivityException(thread, th);
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return Build.VERSION.SDK_INT == 29;
    }
}
