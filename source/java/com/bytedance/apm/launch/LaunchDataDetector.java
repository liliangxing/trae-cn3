package com.bytedance.apm.launch;

import android.content.Context;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.apm.trace.LaunchTrace;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.MonitorConfig;
import com.bytedance.monitor.collector.PerfMonitorManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchDataDetector {
    private static volatile boolean isInit;

    @Deprecated
    public static void startDetect(Context context, LaunchTrace.LaunchMonitor launchMonitor) {
        if (isInit) {
            return;
        }
        isInit = true;
        LaunchAnalysisContext.getInstance().setMonitorConfig(launchMonitor);
        FunctionSwitcher.init(context);
        if (launchMonitor.isDetectLongSleep() && FunctionSwitcher.getSwitch(16)) {
            LaunchSleepDetector.startDetect();
        }
        MonitorConfig.Builder builder = new MonitorConfig.Builder();
        boolean z = false;
        MonitorConfig.Builder enableLock = builder.atraceTag(FunctionSwitcher.getAtraceFlags()).enableAtrace(FunctionSwitcher.getAtraceFlags() != 0 && FunctionSwitcher.getSwitch(2)).enableLock(launchMonitor.isDetectLock() && FunctionSwitcher.getSwitch(8));
        if (launchMonitor.isDetectBinder() && FunctionSwitcher.getSwitch(2)) {
            z = true;
        }
        enableLock.enableBinder(z).enableStackSampling(FunctionSwitcher.getSwitch(64)).enableLooperMonitor(true ^ MainThreadMonitor.getMonitor().isEnableLooperOpt()).runMode(FunctionSwitcher.getMonitorRunMode());
        PerfMonitorManager.getInstance().init(context, builder.build());
        if (launchMonitor.isDetectLock() && FunctionSwitcher.getAtraceFlags() != 0 && FunctionSwitcher.getSwitch(8) && FunctionSwitcher.getSwitch(2)) {
            LockMonitorManager.startLockDetect();
        }
    }
}
