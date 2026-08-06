package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.diagnose.NpthMonitor;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ANRUtils {
    public static final int ANR_CHECK_MAX_COUNT = 100;
    private static String sAnrInfoFromFile = null;
    private static long sLastAnrInfoTime = -1;
    private static ActivityManager.ProcessErrorStateInfo sLastErrInfo;

    public static boolean isANR() {
        if (Build.VERSION.SDK_INT >= 34 && GlobalSwitch.isAnrMonitorOpt()) {
            return isANRProcess34();
        }
        return isANRProcess();
    }

    private static boolean isANRProcess34() {
        int i = 0;
        while (i < 100) {
            i++;
            if (isANRProcess()) {
                return true;
            }
            Thread.sleep(20L);
        }
        return false;
    }

    private static boolean isANRProcess() {
        boolean z;
        boolean z2;
        ActivityManager activityManager = (ActivityManager) Global.getApplication().getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
        if (processesInErrorState != null) {
            Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.ProcessErrorStateInfo next = it.next();
                if (next != null && next.pid == myPid) {
                    if (next.condition == 1) {
                        z2 = true;
                    }
                }
            }
        }
        z2 = false;
        return !z2;
    }

    public static String getNewCurrentProcessANRInfo(Context context, int i) {
        return getNewCurrentProcessANRInfo(context, i, null);
    }

    public static String getNewCurrentProcessANRInfo(Context context, int i, int[] iArr) {
        if (SystemClock.uptimeMillis() - sLastAnrInfoTime < PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) {
            System.out.println("get_anr_info_is_time_out");
            return null;
        }
        try {
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo = getProcessErrorStateInfo(context, i);
            if (processErrorStateInfo != null && (Process.myPid() == processErrorStateInfo.pid || (iArr != null && processErrorStateInfo.processName.contains(context.getPackageName())))) {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = sLastErrInfo;
                if (processErrorStateInfo2 != null && AnrInfoParser.isSameProcessErrorStateInfo(processErrorStateInfo2, processErrorStateInfo)) {
                    sLastAnrInfoTime = SystemClock.uptimeMillis();
                    return null;
                }
                sLastErrInfo = processErrorStateInfo;
                sAnrInfoFromFile = null;
                sLastAnrInfoTime = SystemClock.uptimeMillis();
                if (iArr != null) {
                    iArr[0] = processErrorStateInfo.pid;
                }
                return AnrInfoParser.format(processErrorStateInfo);
            }
        } catch (Throwable unused) {
        }
        String str = sAnrInfoFromFile;
        if (str == null) {
            return null;
        }
        if (iArr != null) {
            iArr[0] = Process.myPid();
        }
        sAnrInfoFromFile = null;
        sLastAnrInfoTime = SystemClock.uptimeMillis();
        return str;
    }

    private static ActivityManager.ProcessErrorStateInfo getProcessErrorStateInfo(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        int i2 = 0;
        while (i2 < i) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
            i2++;
            if (i == i2) {
                break;
            }
            SystemClock.sleep(600L);
        }
        System.out.println("get_anr_info_times_out");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportInnerError(Throwable th) {
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_ANR_ERROR", th);
    }
}
