package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* loaded from: classes4.dex */
public class BoostMetadataNullPointerPlugin extends UncaughtExceptionPlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "BoostMetadataNullPointerPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable {
        if (!(th instanceof NullPointerException)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if ("android.app.ActivityThread".equalsIgnoreCase(stackTraceElement.getClassName()) && "handleBindApplication".equalsIgnoreCase(stackTraceElement.getMethodName())) {
                return th.toString().contains("Attempt to read from field 'android.os.Bundle android.content.pm.PackageItemInfo.metaData' on a null object reference");
            }
        }
        return false;
    }
}
