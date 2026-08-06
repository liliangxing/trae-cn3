package com.bytedance.trae.apm.impl.plugin;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* loaded from: classes5.dex */
public class BadParcelableExceptionPlugin extends UncaughtExceptionPlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "BadParcelableExceptionPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        try {
            String message = th.getMessage();
            if ((Build.VERSION.SDK_INT != 29 && Build.VERSION.SDK_INT != 28) || TextUtils.isEmpty(message) || !message.contains("ClassNotFoundException when unmarshalling: androidx.fragment.app.FragmentManagerState")) {
                return false;
            }
            Logger.e(getName(), getName() + " success", th.getMessage());
            return true;
        } catch (Throwable th2) {
            Logger.e(getName(), getName() + " error", th2.getMessage());
            return false;
        }
    }
}
