package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AndroidException;
import com.huawei.hms.base.log.a;
import com.huawei.hms.base.log.b;

/* loaded from: classes6.dex */
public class HMSLog {
    private static final b a = new b();

    private static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (AndroidException | RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(String str, String str2) {
        a.a(3, str, str2);
    }

    public static void e(String str, String str2) {
        a.a(6, str, str2);
    }

    public static void i(String str, String str2) {
        a.a(4, str, str2);
    }

    public static void init(Context context, int i, String str) {
        b bVar = a;
        bVar.a(context, i, str);
        StringBuilder sb = new StringBuilder("============================================================================\n====== ");
        sb.append(a(context)).append("\n============================================================================");
        bVar.a(str, sb.toString());
    }

    public static boolean isErrorEnable() {
        return a.a(6);
    }

    public static boolean isInfoEnable() {
        return a.a(4);
    }

    public static boolean isWarnEnable() {
        return a.a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z) throws IllegalArgumentException {
        if (hMSExtLogger != null) {
            a aVar = new a(hMSExtLogger);
            if (z) {
                a.a(aVar);
                return;
            } else {
                a.a().a(aVar);
                return;
            }
        }
        throw new IllegalArgumentException("extLogger is not able to be null");
    }

    public static void w(String str, String str2) {
        a.a(5, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        a.b(6, str, str2, th);
    }

    public static void e(String str, long j, String str2) {
        a.a(6, str, "[" + j + "] " + str2);
    }

    public static void e(String str, long j, String str2, Throwable th) {
        a.b(6, str, "[" + j + "] " + str2, th);
    }
}
