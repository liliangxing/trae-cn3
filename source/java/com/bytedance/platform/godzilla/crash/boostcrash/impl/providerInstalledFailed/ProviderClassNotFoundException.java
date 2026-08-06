package com.bytedance.platform.godzilla.crash.boostcrash.impl.providerInstalledFailed;

import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;

/* loaded from: classes4.dex */
public class ProviderClassNotFoundException implements ExceptionCatcher {
    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean registerCondition() {
        return true;
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean analysis(Object obj, Throwable th) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (th instanceof ClassNotFoundException) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getMethodName().contains("installProvider")) {
                    return true;
                }
            }
        }
        return false;
    }
}
