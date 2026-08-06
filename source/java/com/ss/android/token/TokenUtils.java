package com.ss.android.token;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TokenUtils {
    private static String sCurProcessName;

    public static String getTopDomain(String str) {
        String[] split;
        String str2 = "";
        try {
            str2 = new URI(str).getHost().toLowerCase();
            Matcher matcher = Pattern.compile("[^\\.]+(\\.com|\\.net|\\.org|\\.cc|\\.me|\\.tel|\\.mobi|\\.asia|\\.biz|\\.info|\\.name|\\.tv|\\.app|\\.edu)").matcher(str2);
            if (matcher.find()) {
                return matcher.group();
            }
        } catch (Exception e) {
            TTTokenMonitor.monitorError(e);
        }
        try {
            if (TextUtils.isEmpty(str2) || (split = str2.split("\\.")) == null || split.length <= 1) {
                return null;
            }
            return split[split.length - 2] + "." + split[split.length - 1];
        } catch (Exception e2) {
            TTTokenMonitor.monitorError(e2);
            return null;
        }
    }

    public static boolean isInDomainList(String str, Set<String> set) {
        if (!TextUtils.isEmpty(str) && set != null && !set.isEmpty()) {
            try {
                String lowerCase = new URI(str).getHost().toLowerCase();
                if (TextUtils.isEmpty(lowerCase)) {
                    return false;
                }
                return isHostInSet(lowerCase, set);
            } catch (Exception e) {
                TTTokenMonitor.monitorError(e);
            }
        }
        return false;
    }

    public static boolean isHostInDomainList(String str, Set<String> set) {
        if (TextUtils.isEmpty(str) || set == null || set.isEmpty()) {
            return false;
        }
        return isHostInSet(str, set);
    }

    private static boolean isHostInSet(String str, Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                if (str.equals(next)) {
                    return true;
                }
                if (!next.startsWith(".")) {
                    next = "." + next;
                }
                if (str.endsWith(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMainProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        if (TextUtils.isEmpty(curProcessName)) {
            return false;
        }
        try {
            return curProcessName.equals(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName);
        } catch (Throwable th) {
            TTTokenManager.log("Process", "isMainProcess exception" + Log.getStackTraceString(th));
            return !curProcessName.contains(Constants.COLON_SEPARATOR) && curProcessName.equals(context.getPackageName());
        }
    }

    public static String getCurProcessName(Context context) {
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurrentProcessNameByApplication();
        TTTokenManager.log("Process", "getCurProcessName: " + sCurProcessName);
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurrentProcessNameByActivityThread();
        TTTokenManager.log("Process", "getCurrentProcessNameByActivityThread: " + sCurProcessName);
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurProcessNameFromProc();
        TTTokenManager.log("Process", "getCurProcessNameFromProc: " + sCurProcessName);
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurrentProcessNameByActivityManager(context);
        TTTokenManager.log("Process", "getCurrentProcessNameByActivityManager: " + sCurProcessName);
        return sCurProcessName;
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

    private static String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                TTTokenManager.log("Process", "get processName = " + sb.toString());
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    TTTokenMonitor.monitorError(e);
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                try {
                    TTTokenMonitor.monitorError(th);
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e2) {
                            TTTokenMonitor.monitorError(e2);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    private static String getCurrentProcessNameByActivityManager(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(RXScreenCaptureService.KEY_LAUNCH_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
