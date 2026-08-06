package com.bytedance.tobshadow.bdtracker;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;

/* loaded from: classes5.dex */
public class w5 {
    public static final CharSequence a = "amigo";
    public static final CharSequence b = "funtouch";
    public static final h5<Boolean> c = new a();

    /* loaded from: classes5.dex */
    public static class a extends h5<Boolean> {
        @Override // com.bytedance.tobshadow.bdtracker.h5
        public Boolean a(Object[] objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf(RomUtils.OS_HARMONY.equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static String a(String str) {
        Throwable th;
        Process process;
        String a2 = y5.a(str);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        if (!TextUtils.isEmpty(str)) {
            BufferedReader bufferedReader = null;
            try {
                process = Runtime.getRuntime().exec("getprop " + str);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                    try {
                        String readLine = bufferedReader2.readLine();
                        e.a((Closeable) bufferedReader2);
                        process.destroy();
                        return readLine;
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        try {
                            LoggerImpl.global().error("getSysPropByExec error", th, new Object[0]);
                            return "";
                        } finally {
                            e.a((Closeable) bufferedReader);
                            if (process != null) {
                                process.destroy();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                process = null;
            }
        }
        return "";
    }

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                LoggerImpl.global().debug("Honor# oldHonor device, version is" + str, new Object[0]);
                return true;
            }
        } catch (Exception e) {
            LoggerImpl.global().error(com.bytedance.tobshadow.bdtracker.a.a("Honor# ").append(e.getMessage()).toString(), e, new Object[0]);
        }
        return false;
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean c() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean d() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("honor")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor"));
    }

    public static boolean e() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
    }

    public static boolean f() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
