package com.bytedance.sync.p005v4.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ToolUtils {
    private static Boolean isMainProcess;
    private static String sCurProcessName;
    private static String sCurProcessNameSuffix;

    public static String getProcessSuffix(Context context, String str) {
        return (!TextUtils.equals(str, context.getPackageName()) && str.contains(":")) ? str.split(":")[1] : "";
    }

    public static String getCurProcessNameSuffix(Context context) {
        String str = sCurProcessNameSuffix;
        if (!StringUtils.isEmpty(str)) {
            return str;
        }
        String processSuffix = getProcessSuffix(context, getCurProcessName(context));
        sCurProcessNameSuffix = processSuffix;
        return processSuffix;
    }

    public static synchronized String getCurProcessName(Context context) {
        synchronized (ToolUtils.class) {
            if (!TextUtils.isEmpty(sCurProcessName)) {
                return sCurProcessName;
            }
            String currentProcessNameByApplication = getCurrentProcessNameByApplication();
            sCurProcessName = currentProcessNameByApplication;
            if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
                return sCurProcessName;
            }
            String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
            sCurProcessName = currentProcessNameByActivityThread;
            if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
                return sCurProcessName;
            }
            String curProcessNameFromProc = getCurProcessNameFromProc();
            sCurProcessName = curProcessNameFromProc;
            if (!TextUtils.isEmpty(curProcessNameFromProc)) {
                return sCurProcessName;
            }
            String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
            sCurProcessName = currentProcessNameByActivityManager;
            return currentProcessNameByActivityManager;
        }
    }

    private static String getCurrentProcessNameByApplication() {
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

    private static String getCurrentProcessNameByActivityThread() {
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

    private static String getCurrentProcessNameByActivityManager(Context context) {
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = getRunningAppProcesses(context);
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
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

    public static boolean isMainProcessAlive(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            String packageName = context.getPackageName();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    if (packageName.equals(it.next().processName)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
    }

    public static boolean isMainProcess(Context context) {
        Boolean bool = isMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        String curProcessName = getCurProcessName(context);
        boolean z = false;
        if (curProcessName != null && curProcessName.contains(":")) {
            return false;
        }
        if (curProcessName != null && curProcessName.equals(context.getPackageName())) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        isMainProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static String addUrlParam(String str, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        return addUrlParam(str, arrayList);
    }

    public static String addUrlParam(String str, List<Pair<String, String>> list) {
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(NetworkUtils.format(list, "UTF-8"));
        return sb.toString();
    }
}
