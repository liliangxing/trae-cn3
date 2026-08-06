package com.bytedance.crash.terminate;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import com.bytedance.crash.Global;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public final class AppExitInfoUtils {
    public static final String APP_EXIT = "app_exit";
    private static volatile Object LOCK = new Object();
    public static final int MB_1 = 1024;
    private static final int REASON_ANR = 6;
    private static final int REASON_CRASH = 4;
    private static final int REASON_CRASH_NATIVE = 5;
    private static final int REASON_DEPENDENCY_DIED = 12;
    private static final int REASON_EXCESSIVE_RESOURCE_USAGE = 9;
    private static final int REASON_EXIT_SELF = 1;
    private static final int REASON_FREEZER = 14;
    private static final int REASON_INITIALIZATION_FAILURE = 7;
    private static final int REASON_LOW_MEMORY = 3;
    private static final int REASON_OTHER = 13;
    private static final int REASON_PERMISSION_CHANGE = 8;
    private static final int REASON_SIGNALED = 2;
    private static final int REASON_UNKNOWN = 0;
    private static final int REASON_USER_REQUESTED = 10;
    private static final int REASON_USER_STOPPED = 11;
    private static final int SUBREASON_CACHED_IDLE_FORCED_APP_STANDBY = 18;
    private static final int SUBREASON_EXCESSIVE_CPU = 7;
    private static final int SUBREASON_FORCE_STOP = 21;
    private static final int SUBREASON_FREEZER_BINDER_IOCTL = 19;
    private static final int SUBREASON_FREEZER_BINDER_TRANSACTION = 20;
    private static final int SUBREASON_IMPERCEPTIBLE = 15;
    private static final int SUBREASON_INVALID_START = 13;
    private static final int SUBREASON_INVALID_STATE = 14;
    private static final int SUBREASON_ISOLATED_NOT_NEEDED = 17;
    private static final int SUBREASON_KILL_ALL_BG_EXCEPT = 10;
    private static final int SUBREASON_KILL_ALL_FG = 9;
    private static final int SUBREASON_KILL_BACKGROUND = 24;
    private static final int SUBREASON_KILL_PID = 12;
    private static final int SUBREASON_KILL_UID = 11;
    private static final int SUBREASON_LARGE_CACHED = 5;
    private static final int SUBREASON_MEMORY_PRESSURE = 6;
    private static final int SUBREASON_PACKAGE_UPDATE = 25;
    private static final int SUBREASON_REMOVE_LRU = 16;
    private static final int SUBREASON_REMOVE_TASK = 22;
    private static final int SUBREASON_STOP_APP = 23;
    private static final int SUBREASON_SYSTEM_UPDATE_DONE = 8;
    private static final int SUBREASON_TOO_MANY_CACHED = 2;
    private static final int SUBREASON_TOO_MANY_EMPTY = 3;
    private static final int SUBREASON_TRIM_EMPTY = 4;
    private static final int SUBREASON_UNKNOWN = 0;
    private static final int SUBREASON_WAIT_FOR_DEBUGGER = 1;
    private static volatile boolean isLoaded;
    private static List<ApplicationExitInfo> sHistoryList;

    public static String reasonCodeToString(int i) {
        switch (i) {
            case 1:
                return "EXIT_SELF";
            case 2:
                return "SIGNALED";
            case 3:
                return "LOW_MEMORY";
            case 4:
                return "APP CRASH(EXCEPTION)";
            case 5:
                return "APP CRASH(NATIVE)";
            case 6:
                return "ANR";
            case 7:
                return "INITIALIZATION FAILURE";
            case 8:
                return "PERMISSION CHANGE";
            case 9:
                return "EXCESSIVE RESOURCE USAGE";
            case 10:
                return "USER REQUESTED";
            case 11:
                return "USER STOPPED";
            case 12:
                return "DEPENDENCY DIED";
            case 13:
                return "OTHER KILLS BY SYSTEM";
            case 14:
                return "FREEZER";
            default:
                return "UNKNOWN";
        }
    }

    public static String subreasonToString(int i) {
        switch (i) {
            case 1:
                return "WAIT FOR DEBUGGER";
            case 2:
                return "TOO MANY CACHED PROCS";
            case 3:
                return "TOO MANY EMPTY PROCS";
            case 4:
                return "TRIM EMPTY";
            case 5:
                return "LARGE CACHED";
            case 6:
                return "MEMORY PRESSURE";
            case 7:
                return "EXCESSIVE CPU USAGE";
            case 8:
                return "SYSTEM UPDATE_DONE";
            case 9:
                return "KILL ALL FG";
            case 10:
                return "KILL ALL BG EXCEPT";
            case 11:
                return "KILL UID";
            case 12:
                return "KILL PID";
            case 13:
                return "INVALID START";
            case 14:
                return "INVALID STATE";
            case 15:
                return "IMPERCEPTIBLE";
            case 16:
                return "REMOVE LRU";
            case 17:
                return "ISOLATED NOT NEEDED";
            case 18:
                return "CACHED IDLE FORCED APP STANDBY";
            case 19:
                return "FREEZER BINDER IOCTL";
            case 20:
                return "FREEZER BINDER TRANSACTION";
            case 21:
                return "FORCE STOP";
            case 22:
                return "REMOVE TASK";
            case 23:
                return "STOP APP";
            case 24:
                return "KILL BACKGROUND";
            case 25:
                return "PACKAGE UPDATE";
            default:
                return "UNKNOWN";
        }
    }

    public static boolean enableProcessExitReason() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static List<ApplicationExitInfo> getProcessExitReasons() {
        List<ApplicationExitInfo> realGetProcessExitReasons = realGetProcessExitReasons();
        if (realGetProcessExitReasons == null) {
            return null;
        }
        return realGetProcessExitReasons;
    }

    public static List<ApplicationExitInfo> realGetProcessExitReasons() {
        Context context;
        ActivityManager activityManager;
        if (!enableProcessExitReason() || (context = Global.getContext()) == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        if (isLoaded) {
            return sHistoryList;
        }
        synchronized (LOCK) {
            if (!isLoaded) {
                List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(context.getPackageName(), 0, 0);
                sHistoryList = historicalProcessExitReasons;
                historicalProcessExitReasons.sort(new Comparator<ApplicationExitInfo>() { // from class: com.bytedance.crash.terminate.AppExitInfoUtils.1
                    @Override // java.util.Comparator
                    public int compare(ApplicationExitInfo applicationExitInfo, ApplicationExitInfo applicationExitInfo2) {
                        long timestamp = applicationExitInfo2.getTimestamp() - applicationExitInfo.getTimestamp();
                        if (timestamp > 0) {
                            return 1;
                        }
                        return timestamp == 0 ? 0 : -1;
                    }
                });
            }
            isLoaded = true;
        }
        return sHistoryList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String memValueToRange(long j) {
        try {
            long j2 = j / 1024;
            return j2 >= 1 ? j2 <= 30 ? "[1~30MB]" : j2 <= 60 ? "(30~100MB]" : j2 <= 100 ? "(60~100MB]" : j2 <= 200 ? "(100~150MB]" : j2 <= 300 ? "(200~300MB]" : j2 <= 400 ? "(300~400MB]" : j2 <= 500 ? "(400~500MB]" : j2 <= 600 ? "(500~600MB]" : (j2 <= 600 || j2 > 700) ? j2 <= 800 ? "(700~800MB]" : j2 <= 900 ? "(800~900MB]" : j2 <= 1000 ? "(900~1000MB]" : j2 <= 1500 ? "(1GB~1.5GB]" : j2 <= 2000 ? "(1.5GB~2GB]" : j2 <= 3000 ? "(2GB~3GB]" : j2 <= OnekeyLoginConfig.OVER_TIME ? "(3GB~4GB]" : j2 <= 6000 ? "(4GB~6GB]" : j2 <= 8000 ? "(6GB~8GB]" : ">8G" : "(600~700MB]" : "<1MB";
        } catch (Throwable unused) {
            return "invalid";
        }
    }

    static String memValueToRange(String str) {
        if (str == null) {
            return "not obtained";
        }
        try {
            if (!"0.00".equals(str) && !"0".equals(str)) {
                Long valueOf = Long.valueOf(Long.parseLong(str.substring(0, str.indexOf("MB"))));
                return valueOf.longValue() >= 1 ? valueOf.longValue() <= 30 ? "[1~30MB]" : valueOf.longValue() <= 60 ? "(30~100MB]" : valueOf.longValue() <= 100 ? "(60~100MB]" : valueOf.longValue() <= 200 ? "(100~150MB]" : valueOf.longValue() <= 300 ? "(200~300MB]" : valueOf.longValue() <= 400 ? "(300~400MB]" : valueOf.longValue() <= 500 ? "(400~500MB]" : valueOf.longValue() <= 600 ? "(500~600MB]" : valueOf.longValue() <= 700 ? "(600~700MB]" : valueOf.longValue() <= 800 ? "(700~800MB]" : valueOf.longValue() <= 900 ? "(800~900MB]" : valueOf.longValue() <= 1000 ? "(900~1000MB]" : valueOf.longValue() <= 1500 ? "(1GB~1.5GB]" : valueOf.longValue() <= 2000 ? "(1.5GB~2GB]" : valueOf.longValue() <= 3000 ? "(2GB~3GB]" : valueOf.longValue() <= OnekeyLoginConfig.OVER_TIME ? "(3GB~4GB]" : valueOf.longValue() <= 6000 ? "(4GB~6GB]" : valueOf.longValue() <= 8000 ? "(6GB~8GB]" : ">8G" : "< 1MB";
            }
            return "not obtained";
        } catch (Throwable unused) {
            return "invalid";
        }
    }
}
