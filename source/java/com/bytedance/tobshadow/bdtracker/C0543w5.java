package com.bytedance.tobshadow.bdtracker;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;

/* renamed from: com.bytedance.tobshadow.bdtracker.w5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0543w5 {

    /* renamed from: a */
    public static final CharSequence f1199a = "amigo";

    /* renamed from: b */
    public static final CharSequence f1200b = "funtouch";

    /* renamed from: c */
    public static final AbstractC0438h5<Boolean> f1201c = new a();

    /* renamed from: com.bytedance.tobshadow.bdtracker.w5$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a extends AbstractC0438h5<Boolean> {
        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0438h5
        /* renamed from: a */
        public Boolean mo455a(Object[] objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* renamed from: a */
    public static String m734a(String str) {
        Throwable th;
        Process process;
        String m756a = C0557y5.m756a(str);
        if (!TextUtils.isEmpty(m756a)) {
            return m756a;
        }
        if (!TextUtils.isEmpty(str)) {
            BufferedReader bufferedReader = null;
            try {
                process = Runtime.getRuntime().exec("getprop " + str);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                    try {
                        String readLine = bufferedReader2.readLine();
                        C0411e.m356a((Closeable) bufferedReader2);
                        process.destroy();
                        return readLine;
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        try {
                            LoggerImpl.global().error("getSysPropByExec error", th, new Object[0]);
                            return "";
                        } finally {
                            C0411e.m356a((Closeable) bufferedReader);
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

    /* renamed from: a */
    public static boolean m735a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod(ApiRequest.METHOD_GET, String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                LoggerImpl.global().debug("Honor# oldHonor device, version is" + str, new Object[0]);
                return true;
            }
        } catch (Exception e) {
            LoggerImpl.global().error(C0380a.m252a("Honor# ").append(e.getMessage()).toString(), e, new Object[0]);
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m736b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    /* renamed from: c */
    public static boolean m737c() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    /* renamed from: d */
    public static boolean m738d() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("honor")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor"));
    }

    /* renamed from: e */
    public static boolean m739e() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
    }

    /* renamed from: f */
    public static boolean m740f() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
