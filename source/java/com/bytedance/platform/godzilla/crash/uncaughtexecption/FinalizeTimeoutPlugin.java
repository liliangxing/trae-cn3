package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public class FinalizeTimeoutPlugin extends UncaughtExceptionPlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "FinalizeTimeoutPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    private boolean isFinalizeTimeout(Thread thread, Throwable th) {
        return thread != null && th != null && thread.getName().equals("FinalizerWatchdogDaemon") && (th instanceof TimeoutException);
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        boolean isFinalizeTimeout = isFinalizeTimeout(thread, th);
        if (isFinalizeTimeout) {
            Logger.e(getName(), "Hint FinalizeTimeout case ,fix it.");
        }
        return isFinalizeTimeout;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
    }
}
