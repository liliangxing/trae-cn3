package com.bytedance.trae.apm.impl.plugin;

import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import com.bytedance.services.apm.api.EnsureManager;

/* loaded from: classes5.dex */
public class UnsupportedOperationExceptionPlugin extends UncaughtExceptionPlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "UnsupportedOperationExceptionPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        try {
            String message = th.getMessage();
            if (!(th instanceof UnsupportedOperationException) || TextUtils.isEmpty(message) || !message.contains("This isn't a hierarchical URI")) {
                return false;
            }
            Logger.e(getName(), "Hint UnsupportedOperationExceptionPlugin case ,fix it.");
            EnsureManager.ensureNotReachHere(th, "UnsupportedOperationExceptionPlugin");
            return true;
        } catch (Throwable th2) {
            Logger.e(getName(), getName() + " error", th2.getMessage());
            return false;
        }
    }
}
