package com.bytedance.rheatrace.core;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/* loaded from: classes4.dex */
public class RheaTrace3 {
    private static volatile Boolean isMainProcess;
    private static volatile String sProcessName;

    public static void init(Context context, RheaAppStartCallback rheaAppStartCallback) {
        if (!isMainProcess(context) || rheaAppStartCallback == null) {
            return;
        }
        rheaAppStartCallback.onAppStart(context);
    }

    private static boolean isMainProcess(Context context) {
        if (isMainProcess == null) {
            isMainProcess = Boolean.valueOf(context.getPackageName().equals(getProcessName(context)));
        }
        return isMainProcess.booleanValue();
    }

    private static String getProcessName(Context context) {
        if (sProcessName != null) {
            return sProcessName;
        }
        String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : null;
        if (TextUtils.isEmpty(processName)) {
            try {
                processName = getProcessNameClassical(context);
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(processName)) {
            processName = getProcessNameSecure();
        }
        sProcessName = processName;
        return processName;
    }

    private static String getProcessNameClassical(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str = "";
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    private static String getProcessNameSecure() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            str = bufferedReader.readLine().trim();
            bufferedReader.close();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }
}
