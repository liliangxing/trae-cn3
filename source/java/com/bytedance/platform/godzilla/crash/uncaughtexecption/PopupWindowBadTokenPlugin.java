package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.view.WindowManager;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* loaded from: classes4.dex */
public class PopupWindowBadTokenPlugin extends UncaughtExceptionPlugin {
    private static final String STACK_CLASS = "android.widget.PopupWindow";
    private static final String STACK_METHOD = "invokePopup";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "PopupWindowBadTokenPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    private boolean isPopupWindowBadToken(Thread thread, Throwable th) {
        if (th instanceof WindowManager.BadTokenException) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement != null && STACK_CLASS.equals(stackTraceElement.getClassName()) && STACK_METHOD.equals(stackTraceElement.getMethodName())) {
                    Logger.e(getName(), "Hint PopWindow BadToken case ,fix it.");
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        return isPopupWindowBadToken(thread, th);
    }
}
