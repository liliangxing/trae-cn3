package com.bytedance.crash;

import android.os.Build;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GlobalSwitch {
    private static boolean sIsAllowBlockStack;
    private static boolean sIsAnrMonitorOpt;
    private static boolean sIsFilterOtherAnr;
    private static boolean sIsLooperMonitor;
    private static boolean sIsOpenNewAnrMonitor;

    public static void setAnrMonitorOpt(boolean z) {
        sIsAnrMonitorOpt = z;
    }

    public static boolean isAnrMonitorOpt() {
        return sIsAnrMonitorOpt;
    }

    public static void setOpenNewAnrMonitor(boolean z) {
        sIsOpenNewAnrMonitor = z;
    }

    public static boolean isOpenNewAnrMonitor() {
        return sIsOpenNewAnrMonitor;
    }

    public static void setOpenLooperMonitor(boolean z) {
        if (z) {
            sIsLooperMonitor = true;
            if (MonitorManager.getAppMonitor() != null) {
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.GlobalSwitch.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LooperMessageRecorder.getInstance().start();
                    }
                });
            }
        }
    }

    public static boolean isOpenLooperMonitor() {
        return sIsLooperMonitor;
    }

    public static void setAllowBlockStack(boolean z) {
        sIsAllowBlockStack = z;
    }

    public static boolean isAllowBlockStack() {
        return sIsAllowBlockStack;
    }

    public static void setANRImprovementOpt(boolean z) {
        sIsFilterOtherAnr = z;
    }

    public static boolean isFilterNotAnr() {
        return Build.VERSION.SDK_INT >= 30 && sIsFilterOtherAnr;
    }
}
