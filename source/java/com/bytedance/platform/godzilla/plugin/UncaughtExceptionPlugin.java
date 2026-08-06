package com.bytedance.platform.godzilla.plugin;

import com.bytedance.platform.godzilla.GodzillaCore;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer;

/* loaded from: classes4.dex */
public abstract class UncaughtExceptionPlugin extends BasePlugin implements UncaughtExceptionConsumer {
    public abstract boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable;

    public abstract boolean shouldEnableOpt();

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        if (shouldEnableOpt()) {
            GodzillaCore.INSTANCE.addUncaughtExceptionConsumer(this);
            Logger.e(getName(), "start called.");
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public StartType startType() {
        return StartType.REGISTER_EXCEPTION;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
        if (shouldEnableOpt()) {
            GodzillaCore.INSTANCE.removeUncaughtExceptionConsumer(this);
            Logger.e(getName(), "stop called.");
        }
    }
}
