package com.bytedance.ug.sdk.deeplink.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class ZLinkToolUtils {
    private static String sCurProcessName;

    public static boolean isMainProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return (curProcessName == null || !curProcessName.contains(Constants.COLON_SEPARATOR)) && curProcessName != null && curProcessName.equals(context.getPackageName());
    }

    public static String getCurProcessName(Context context) {
        String str = sCurProcessName;
        if (!isEmpty(str)) {
            return str;
        }
        String curProcessNameByActivityThread = getCurProcessNameByActivityThread();
        if (!isEmpty(curProcessNameByActivityThread)) {
            return curProcessNameByActivityThread;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    if (HostCommonServices.isDebug()) {
                        Logger.d("Process", "processName = " + runningAppProcessInfo.processName);
                    }
                    String str2 = runningAppProcessInfo.processName;
                    sCurProcessName = str2;
                    return str2;
                }
            }
        } catch (Exception e) {
            Logger.e("Process", "getCurProcessName error e: " + e);
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurProcessName = curProcessNameFromProc;
        return curProcessNameFromProc;
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
            if (HostCommonServices.isDebug()) {
                Logger.d("Process", "get processName = " + sb.toString());
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

    private static String getCurProcessNameByActivityThread() {
        String str = sCurProcessName;
        if (!isEmpty(str)) {
            return str;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                sCurProcessName = (String) invoke;
            }
        } catch (Throwable th) {
            Logger.e("Process", "getCurProcessName error e: " + th);
        }
        return sCurProcessName;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
