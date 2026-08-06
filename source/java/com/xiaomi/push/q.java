package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;

/* loaded from: classes7.dex */
public class q {
    private static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static String f908a;

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Context m10114a() {
        return a;
    }

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m10117a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m10116a() {
        return TextUtils.equals((String) av.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m10118b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m10115a() {
        synchronized (q.class) {
            String str = f908a;
            if (str != null) {
                return str;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (a() <= 0) {
                String b = b();
                if (TextUtils.isEmpty(b)) {
                    b = c();
                    if (TextUtils.isEmpty(b)) {
                        b = d();
                        if (TextUtils.isEmpty(b)) {
                            str2 = String.valueOf(p.a(SystemUtils.PRODUCT_BRAND, "Android") + "_" + str2);
                        }
                    }
                }
                str2 = b;
            }
            f908a = str2;
            return str2;
        }
    }

    private static String b() {
        String a2 = p.a("ro.build.version.emui", "");
        f908a = a2;
        return a2;
    }

    private static String c() {
        String a2 = p.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            f908a = "ColorOS_" + a2;
        }
        return f908a;
    }

    private static String d() {
        String a2 = p.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f908a = "FuntouchOS_" + a2;
        }
        return f908a;
    }

    public static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (Throwable unused) {
            }
        }
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m9528a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", th);
        }
    }
}
