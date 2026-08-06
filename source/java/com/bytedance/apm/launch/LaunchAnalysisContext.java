package com.bytedance.apm.launch;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.launch.LaunchInitConfig;
import com.bytedance.apm.trace.LaunchTrace;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchAnalysisContext {
    private static final String TAG = "LaunchAnalysis";
    private LaunchInitConfig config;
    private LaunchTrace.LaunchMonitor monitor;

    private LaunchAnalysisContext() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class SingletonHolder {
        private static final LaunchAnalysisContext instance = new LaunchAnalysisContext();

        private SingletonHolder() {
        }
    }

    public static LaunchAnalysisContext getInstance() {
        return SingletonHolder.instance;
    }

    public synchronized void setConfig(LaunchInitConfig launchInitConfig) {
        this.config = launchInitConfig;
    }

    public synchronized LaunchInitConfig getConfig() {
        if (this.config == null) {
            this.config = new LaunchInitConfig.Builder().build();
        }
        return this.config;
    }

    public synchronized void setMonitorConfig(LaunchTrace.LaunchMonitor launchMonitor) {
        this.monitor = launchMonitor;
    }

    public synchronized LaunchTrace.LaunchMonitor getMonitorConfig() {
        if (this.monitor == null) {
            this.monitor = new LaunchTrace.LaunchMonitor.LaunchMonitorBuilder().build();
        }
        return this.monitor;
    }

    public void logE(String str) {
        Log.e(TAG, "notice!!!+ " + str);
    }

    public void logI(String str) {
        Log.i(TAG, str);
    }

    public void logD(String str) {
        if (ApmContext.isDebugMode()) {
            Log.d(TAG, str);
        }
    }
}
