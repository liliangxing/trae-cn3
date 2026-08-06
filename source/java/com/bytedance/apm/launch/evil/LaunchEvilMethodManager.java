package com.bytedance.apm.launch.evil;

import android.os.Handler;
import android.os.Message;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.perf.monitor.EvilMethodTracer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchEvilMethodManager {
    private static final String LAUNCH_EVIL_METHOD_SCENE = "app_launch_evil_method_scene_apm_2";
    private static final long MAX_INTERVAL = 10000;
    private static EvilMethodTracer evilMethodTracer;
    private static boolean isOpenDispatch;
    private static boolean isStarted;

    public static synchronized void startMonitorEvilMethod() {
        synchronized (LaunchEvilMethodManager.class) {
            if (isStarted) {
                return;
            }
            isStarted = true;
            if (!isOpenDispatch) {
                isOpenDispatch = true;
                EvilMethodTracer.setEvilThresholdMs(EvilMethodSwitcher.getLaunchEvilThresholdMs());
                EvilMethodTracer.setIsEvilMethodTraceEnable(true);
                if (EvilMethodSwitcher.isMessageKeyEnable()) {
                    PerfConfig.setReportMessage();
                }
                MainThreadMonitor.getMonitor().init();
                MethodCollector.getInstance().onStart();
                EvilMethodTracer.isMethodTraced = true;
                EvilMethodTracer evilMethodTracer2 = new EvilMethodTracer(EvilMethodSwitcher.isLaunchLimitEvilMethodDepth(), true);
                evilMethodTracer = evilMethodTracer2;
                evilMethodTracer2.startTrace();
                LooperMonitor.dispatch(true, "launch", (Message) null);
                new Handler().postDelayed(new Runnable() { // from class: com.bytedance.apm.launch.evil.LaunchEvilMethodManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LaunchEvilMethodManager.stopMonitorEvilMethod();
                    }
                }, 10000L);
            }
            FpsTracer.addScene(LAUNCH_EVIL_METHOD_SCENE);
        }
    }

    public static synchronized void stopMonitorEvilMethod() {
        synchronized (LaunchEvilMethodManager.class) {
            if (isStarted) {
                isStarted = false;
                evilMethodTracer.setLimitDepth(EvilMethodSwitcher.isLimitEvilMethodDepth());
                EvilMethodTracer.setEvilThresholdMs(EvilMethodSwitcher.getEvilThresholdMs());
                FpsTracer.removeScene(LAUNCH_EVIL_METHOD_SCENE);
            }
        }
    }

    public static synchronized void registerEvilMethodConfig() {
        synchronized (LaunchEvilMethodManager.class) {
            if (evilMethodTracer != null && EvilMethodSwitcher.isOpenLaunchEvilMethod()) {
                evilMethodTracer.registerConfig();
            }
        }
    }
}
