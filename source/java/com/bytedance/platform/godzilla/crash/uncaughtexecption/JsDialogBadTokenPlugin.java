package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.os.Build;
import android.view.WindowManager;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* loaded from: classes4.dex */
public class JsDialogBadTokenPlugin extends UncaughtExceptionPlugin {
    private static final String STACK_CLASS = "android.webkit.JsDialogHelper";
    private static final String STACK_METHOD = "showDialog";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "JsDialogBadTokenPlugin";
    }

    private boolean matchBadToken(Throwable th) {
        if (th instanceof WindowManager.BadTokenException) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (STACK_CLASS.equals(stackTraceElement.getClassName()) && STACK_METHOD.equals(stackTraceElement.getMethodName())) {
                    Logger.e(getName(), "Hint JsDialogBadToken case ,fix it.");
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        return matchBadToken(th);
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        int i = Build.VERSION.SDK_INT;
        return i == 24 || i == 25 || i == 26 || i == 27;
    }
}
