package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.platform.godzilla.common.CrashPortrait;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.utils.ProcessHelper;
import java.util.List;

/* loaded from: classes4.dex */
public class SuperUncaughtExceptionPlugin extends UncaughtExceptionPlugin {
    private ConfigFetcher mConfigFetcher;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface ConfigFetcher {
        String getAppVersion();

        List<CrashPortrait> getCrashPortrait();

        int getUpdateVersion();

        void onCrashCatchSucceed(CrashPortrait crashPortrait);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CloudUncaughtExceptionCatcher";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    public SuperUncaughtExceptionPlugin(ConfigFetcher configFetcher, Context context) {
        this.mConfigFetcher = configFetcher;
        this.mContext = context;
        if (configFetcher == null || context == null) {
            throw new IllegalArgumentException("mConfigFetcher and mContext can not be null.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread thread, Throwable th) {
        ConfigFetcher configFetcher = this.mConfigFetcher;
        boolean z = false;
        if (configFetcher == null) {
            return false;
        }
        List<CrashPortrait> crashPortrait = configFetcher.getCrashPortrait();
        if (crashPortrait != null && !crashPortrait.isEmpty()) {
            String appVersion = this.mConfigFetcher.getAppVersion();
            int updateVersion = this.mConfigFetcher.getUpdateVersion();
            int i = Build.VERSION.SDK_INT;
            String name = thread.getName();
            String currentProcessName = ProcessHelper.getCurrentProcessName(this.mContext);
            for (CrashPortrait crashPortrait2 : crashPortrait) {
                if (TextUtils.isEmpty(crashPortrait2.appVersion) || crashPortrait2.appVersion.equalsIgnoreCase(appVersion)) {
                    if (crashPortrait2.updateVersion <= 0 || crashPortrait2.updateVersion == updateVersion) {
                        if (crashPortrait2.osVersion <= 0 || i == crashPortrait2.osVersion) {
                            if (TextUtils.isEmpty(crashPortrait2.threadName) || crashPortrait2.threadName.equalsIgnoreCase(name)) {
                                if (TextUtils.isEmpty(crashPortrait2.processName) || crashPortrait2.processName.equalsIgnoreCase(currentProcessName)) {
                                    if (TextUtils.isEmpty(crashPortrait2.detailMessage) || crashPortrait2.detailMessage.equalsIgnoreCase(th.getMessage())) {
                                        if (TextUtils.isEmpty(crashPortrait2.throwableClassName) || crashPortrait2.throwableClassName.equalsIgnoreCase(th.getClass().getName())) {
                                            if (TextUtils.isEmpty(crashPortrait2.clazzName) && TextUtils.isEmpty(crashPortrait2.methodName)) {
                                                Logger.e("CloudUntExPlugin", "Hint crash," + crashPortrait2);
                                                this.mConfigFetcher.onCrashCatchSucceed(crashPortrait2);
                                                return true;
                                            }
                                            if (TextUtils.isEmpty(crashPortrait2.clazzName) || TextUtils.isEmpty(crashPortrait2.methodName)) {
                                                Logger.e("CloudUntExPlugin", crashPortrait2.clazzName + LibrarianImpl.Constants.DOT + crashPortrait2.methodName + " does not match.");
                                            }
                                            StackTraceElement[] stackTrace = th.getStackTrace();
                                            int length = stackTrace.length;
                                            for (?? r14 = z; r14 < length; r14++) {
                                                StackTraceElement stackTraceElement = stackTrace[r14];
                                                if ((TextUtils.isEmpty(crashPortrait2.clazzName) || crashPortrait2.clazzName.equalsIgnoreCase(stackTraceElement.getClassName())) && (TextUtils.isEmpty(crashPortrait2.methodName) || crashPortrait2.methodName.equalsIgnoreCase(stackTraceElement.getMethodName()))) {
                                                    Logger.e("CloudUntExPlugin", "Hint crash," + crashPortrait2);
                                                    this.mConfigFetcher.onCrashCatchSucceed(crashPortrait2);
                                                    return true;
                                                }
                                                z = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }
}
