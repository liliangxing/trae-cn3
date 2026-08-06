package com.bytedance.sysoptimizer.tools;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes5.dex */
public class IndirectReferenceTableMonitor {
    public static final int CAP_GLOBAL = 1;
    public static final int CAP_WEAK_GLOBAL = 2;
    private static final String TAG = "IndirectRefMonitor";
    private static boolean sOptimized;

    private static native void changeConfig0(Config config);

    public static native int dump2file(String str);

    public static native int getReferenceCount(int i);

    public static native void mockLeak();

    private static native void monitor(Config config, int i);

    public static native boolean startMonitor(int i, int i2);

    /* loaded from: classes5.dex */
    public static class Config {
        private int cap;
        private RefConfig globalConfig;
        private RefConfig weakGlobalConfig;

        public boolean isValid() {
            int i = this.cap;
            return (i & 1) != 0 ? this.globalConfig != null : ((i & 2) == 0 || this.weakGlobalConfig == null) ? false : true;
        }

        /* loaded from: classes5.dex */
        public static class RefConfig {
            public final int crashCount;
            public final int crawlStackCount;
            public final int maxStackDump;

            public RefConfig(int i, int i2, int i3) {
                this.crashCount = i;
                this.crawlStackCount = i2;
                this.maxStackDump = i3;
            }
        }

        private Config() {
        }

        /* loaded from: classes5.dex */
        public static final class Builder {
            private final Config config = new Config();

            public Builder setCapability(int i) {
                this.config.cap = i;
                return this;
            }

            public Builder setGlobalConfig(RefConfig refConfig) {
                this.config.globalConfig = refConfig;
                return this;
            }

            public Builder setWeakGlobalConfig(RefConfig refConfig) {
                this.config.weakGlobalConfig = refConfig;
                return this;
            }

            public Config getConfig() {
                return this.config;
            }
        }
    }

    public static synchronized void monitor(Context context, Config config) {
        synchronized (IndirectReferenceTableMonitor.class) {
            if (!sOptimized && config != null && config.isValid()) {
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                    try {
                        monitor(config, Build.VERSION.SDK_INT);
                        sOptimized = true;
                    } catch (NoSuchMethodError e) {
                        Log.e(TAG, "NoSuchMethodError", e);
                    } catch (UnsatisfiedLinkError e2) {
                        Log.e(TAG, "UnsatisfiedLinkError", e2);
                    }
                }
            }
        }
    }

    public static void changeConfig(Config config) {
        if (config == null || !config.isValid()) {
            return;
        }
        changeConfig0(config);
    }

    private static void ThrowCustomException() {
        throw new RuntimeException("Leak IndirectReferenceTable");
    }

    private static String getJavaStackTrace() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < stackTrace.length; i++) {
            sb.append(stackTrace[i].toString()).append(UpdateDialogNewBase.TYPE);
        }
        return sb.toString();
    }

    private static void e(String str, String str2) {
        if (str2.length() <= 3072) {
            Log.e(str, str2);
            return;
        }
        while (str2.length() > 3072) {
            String substring = str2.substring(0, 3072);
            str2 = str2.replace(substring, "");
            Log.e(str, substring);
        }
        Log.e(str, str2);
    }
}
