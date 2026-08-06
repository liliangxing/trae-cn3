package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.lynx.tasm.animation.AnimationConstant;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* compiled from: CommFun.java */
/* renamed from: com.huawei.hms.opendevice.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1197e {

    /* renamed from: a */
    private static String f1598a;

    /* renamed from: a */
    private static String m1849a() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                            return "";
                        }
                        String trim = readLine.trim();
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return trim;
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            HMSLog.m2118e("CommFun", "get current app processes IOException!");
            return "";
        } catch (Exception e) {
            HMSLog.m2118e("CommFun", "get current app processes exception!" + e.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    public static boolean m1852b() {
        int i = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.m2115d("CommFun", "Emui Api Level:" + i);
        return i > 0;
    }

    /* renamed from: d */
    public static long m1854d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", AnimationConstant.PROP_MAX_WIDTH).versionCode;
        } catch (Exception unused) {
            HMSLog.m2118e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    /* renamed from: e */
    public static boolean m1855e(Context context) {
        return m1852b() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && m1854d(context) < 110001400;
    }

    /* renamed from: c */
    public static String m1853c(Context context) {
        String str = context.createDeviceProtectedStorageContext().getDataDir() + "";
        if (TextUtils.isEmpty(str)) {
            HMSLog.m2118e("CommFun", "get storage root path of the current user failed.");
        }
        return str;
    }

    /* renamed from: b */
    private static String m1851b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName != null) {
                    HMSLog.m2120i("CommFun", "info.pid -> " + runningAppProcessInfo.pid + ", info.processName -> " + runningAppProcessInfo.processName);
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        HMSLog.m2121w("CommFun", "get running app processes null!");
        return "";
    }

    /* renamed from: a */
    public static String m1850a(Context context) {
        if (!TextUtils.isEmpty(f1598a)) {
            return f1598a;
        }
        String m1851b = m1851b(context);
        f1598a = m1851b;
        if (!TextUtils.isEmpty(m1851b)) {
            return f1598a;
        }
        String m1849a = m1849a();
        f1598a = m1849a;
        return m1849a;
    }
}
