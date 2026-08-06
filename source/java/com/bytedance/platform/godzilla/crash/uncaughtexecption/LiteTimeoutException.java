package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public class LiteTimeoutException extends UncaughtExceptionPlugin {
    private static final String KEY_MESSAGE = "java.util.regex.Pattern.finalize() timed out after";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "LiteTimeoutException";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        return th instanceof TimeoutException;
    }
}
