package com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed;

/* loaded from: classes4.dex */
public interface ExceptionCatcher {
    boolean analysis(Object obj, Throwable th);

    boolean registerCondition();
}
