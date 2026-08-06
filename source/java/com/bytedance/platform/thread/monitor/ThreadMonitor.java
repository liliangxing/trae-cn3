package com.bytedance.platform.thread.monitor;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.platform.thread.PlatformHandlerThread;
import com.ss.android.update.UpdateDialogNewBase;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ThreadMonitor {
    private static final int DEFAULT_TASK_EXECUTE_TIME_OUT = 10000;
    private static final int DEFAULT_TASK_WAIT_TIME_OUT = 10000;
    private static boolean isEnable;
    private static IMonitor sMonitor;
    private static HandlerThread sHandlerThread = PlatformHandlerThread.getNewHandlerThread("pool-monitor");
    private static Handler sHandler = new Handler(sHandlerThread.getLooper());
    private static int sTaskExecuteTimeout = 10000;
    private static int sTaskWaitTimeout = 10000;

    /* loaded from: classes4.dex */
    public interface IMonitor {
        void monitorLog(String str, JSONObject jSONObject);
    }

    public static void monitorNewThread() {
    }

    public static boolean isEnable() {
        return isEnable;
    }

    public static void setEnable(boolean z) {
        isEnable = z;
    }

    public static void setExecuteTimeout(int i) {
        sTaskExecuteTimeout = i;
    }

    public static void setWaitTimeout(int i) {
        sTaskWaitTimeout = i;
    }

    public static void monitorExecuteTimeOut(ExecuteTimeoutTask executeTimeoutTask) {
        sHandler.postDelayed(executeTimeoutTask, sTaskExecuteTimeout);
    }

    public static void removeMonitorExecuteTimeOut(ExecuteTimeoutTask executeTimeoutTask) {
        sHandler.removeCallbacks(executeTimeoutTask);
    }

    public static void monitorWaitTimeOut(WaitTimeoutTask waitTimeoutTask) {
        sHandler.postDelayed(waitTimeoutTask, sTaskWaitTimeout);
    }

    public static void removeMonitorWaitTimeOut(WaitTimeoutTask waitTimeoutTask) {
        sHandler.removeCallbacks(waitTimeoutTask);
    }

    public static String getStackTraceString(StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr == null) {
            return "";
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            str = str + stackTraceElement.toString() + UpdateDialogNewBase.TYPE;
        }
        return str;
    }

    public static void setMonitorImpl(IMonitor iMonitor) {
        sMonitor = iMonitor;
        setEnable(true);
    }

    public static void monitorCommon(String str, JSONObject jSONObject) {
        IMonitor iMonitor = sMonitor;
        if (iMonitor != null) {
            iMonitor.monitorLog(str, jSONObject);
        }
    }
}
