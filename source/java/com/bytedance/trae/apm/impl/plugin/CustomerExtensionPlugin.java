package com.bytedance.trae.apm.impl.plugin;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* loaded from: classes5.dex */
public class CustomerExtensionPlugin extends UncaughtExceptionPlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CustomerExtensionPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        if (th == null) {
            return false;
        }
        boolean z = isRemoteServiceBadNotificationException(th) || isKillPkgException(th);
        if (z) {
            Logger.e(getName(), "Hint CustomerExtensionPlugin case ,fix it.");
        }
        return z;
    }

    private boolean isRemoteServiceBadNotificationException(Throwable th) {
        try {
            String name = th.getClass().getName();
            if ("android.app.RemoteServiceException".equals(name) || "android.app.RemoteServiceException$CannotPostForegroundServiceNotificationException".equals(name)) {
                return th.getMessage().trim().startsWith("Bad notification");
            }
            return false;
        } catch (Throwable th2) {
            Logger.e(getName(), "isRemoteServiceBadNotificationException error: " + th2.getMessage());
            return false;
        }
    }

    private boolean isKillPkgException(Throwable th) {
        try {
            if (th instanceof SecurityException) {
                return th.getMessage().trim().contains("cannot kill pkg:");
            }
            return false;
        } catch (Throwable th2) {
            Logger.e(getName(), "isKillPkgException error: " + th2.getMessage());
            return false;
        }
    }
}
