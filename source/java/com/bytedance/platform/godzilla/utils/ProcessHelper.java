package com.bytedance.platform.godzilla.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: classes4.dex */
public final class ProcessHelper {
    private static String sCurrentProcessName;

    private ProcessHelper() {
    }

    public static String getCurrentProcessName(Context context) {
        if (!TextUtils.isEmpty(sCurrentProcessName)) {
            return sCurrentProcessName;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    sCurrentProcessName = runningAppProcessInfo.processName;
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurrentProcessName = curProcessNameFromProc;
        return curProcessNameFromProc;
    }

    public static boolean isMainProcess(Context context) {
        String currentProcessName = getCurrentProcessName(context);
        return (currentProcessName == null || !currentProcessName.contains(Constants.COLON_SEPARATOR)) && currentProcessName != null && currentProcessName.equals(context.getPackageName());
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return sb2;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        }
    }
}
