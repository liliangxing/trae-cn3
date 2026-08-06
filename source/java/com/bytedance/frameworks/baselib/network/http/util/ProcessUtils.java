package com.bytedance.frameworks.baselib.network.http.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class ProcessUtils {
    public static final String MESSAGE_PROCESS_SERVICE_SUFFIX = ":pushservice";
    public static final String MESSAGE_PROCESS_SUFFIX = ":push";
    private static final String MINIAPP_PROCESS_SUBSTRING = ":miniapp";
    private static AtomicInteger processFlag = new AtomicInteger(0);
    private static volatile String sCurProcessName = null;

    public static boolean isMessageProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        if (curProcessName != null) {
            return curProcessName.endsWith(":push") || curProcessName.endsWith(":pushservice");
        }
        return false;
    }

    public static void setProcessFlag(int i) {
        processFlag.set(i);
    }

    public static int getProcessFlag() {
        return processFlag.get();
    }

    public static boolean isMainProcessByProcessFlag(Context context) {
        if (Logger.debug()) {
            Logger.d("ProcessUtils", "TTNet ProcessFlag: " + processFlag);
        }
        int processFlag2 = getProcessFlag();
        if (processFlag2 == 1) {
            return true;
        }
        if (processFlag2 != 2) {
            return isMainProcess(context);
        }
        return false;
    }

    public static boolean isMainProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return (curProcessName == null || !curProcessName.contains(Constants.COLON_SEPARATOR)) && curProcessName != null && curProcessName.equals(context.getPackageName());
    }

    public static boolean isMiniAppProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return curProcessName != null && curProcessName.contains(MINIAPP_PROCESS_SUBSTRING);
    }

    public static String getCurProcessName(Context context) {
        if (!StringUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurrentProcessNameFromApplication();
        if (!StringUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurrentProcessNameFromActivityThread();
        if (!StringUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurProcessNameFromProc();
        if (!StringUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurProcessNameFromActivityManager(context);
        return sCurProcessName;
    }

    private static String getCurrentProcessNameFromApplication() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getCurrentProcessNameFromActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String getCurProcessNameFromActivityManager(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    if (Logger.debug()) {
                        Logger.d("Process", "processName = " + runningAppProcessInfo.processName);
                    }
                    str = runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
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
            if (Logger.debug()) {
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
}
