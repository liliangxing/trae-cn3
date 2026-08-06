package com.bytedance.platform.godzilla.crash.boostcrash.impl.providerInstalledFailed;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FileProviderInstallFailedExceptionCatcher implements ExceptionCatcher {
    private static List<String> mCrashes;

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean registerCondition() {
        return true;
    }

    static {
        ArrayList arrayList = new ArrayList();
        mCrashes = arrayList;
        arrayList.add("FILE_PROVIDER_PATHS");
        mCrashes.add("NullPointerException");
        mCrashes.add("Failed to resolve canonical path");
        mCrashes.add("android.os.DeadSystemException");
        mCrashes.add("Package manager has died");
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean analysis(Object obj, Throwable th) {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().contains("installProvider") && th != null) {
                String th2 = th.toString();
                for (String str : mCrashes) {
                    if (th2.contains(str)) {
                        Logger.d("ProviderInstallFailed", "Hint the crash " + str);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
