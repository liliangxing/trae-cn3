package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* renamed from: com.xiaomi.push.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1702q {

    /* renamed from: a */
    private static Context f2832a;

    /* renamed from: a */
    private static String f2833a;

    /* renamed from: a */
    public static void m3465a(Context context) {
        f2832a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static Context m3462a() {
        return f2832a;
    }

    /* renamed from: a */
    public static int m3461a() {
        try {
            Class<?> m3463a = m3463a(null, "miui.os.Build");
            if (m3463a.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return m3463a.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static boolean m3467a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m3466a() {
        return TextUtils.equals((String) C1488av.m1570a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, "sys.boot_completed"), PushClient.DEFAULT_REQUEST_ID);
    }

    /* renamed from: b */
    public static boolean m3469b() {
        try {
            return m3463a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException unused) {
            AbstractC1417b.m1103d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return false;
        }
    }

    /* renamed from: a */
    public static synchronized String m3464a() {
        synchronized (C1702q.class) {
            String str = f2833a;
            if (str != null) {
                return str;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (m3461a() <= 0) {
                String m3468b = m3468b();
                if (TextUtils.isEmpty(m3468b)) {
                    m3468b = m3470c();
                    if (TextUtils.isEmpty(m3468b)) {
                        m3468b = m3471d();
                        if (TextUtils.isEmpty(m3468b)) {
                            str2 = String.valueOf(C1700p.m3459a("ro.product.brand", "Android") + RomUtils.SEPARATOR + str2);
                        }
                    }
                }
                str2 = m3468b;
            }
            f2833a = str2;
            return str2;
        }
    }

    /* renamed from: b */
    private static String m3468b() {
        String m3459a = C1700p.m3459a("ro.build.version.emui", "");
        f2833a = m3459a;
        return m3459a;
    }

    /* renamed from: c */
    private static String m3470c() {
        String m3459a = C1700p.m3459a(RomUtils.RUNTIME_OPPO, "");
        if (!TextUtils.isEmpty(m3459a) && !m3459a.startsWith("ColorOS_")) {
            f2833a = "ColorOS_" + m3459a;
        }
        return f2833a;
    }

    /* renamed from: d */
    private static String m3471d() {
        String m3459a = C1700p.m3459a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(m3459a) && !m3459a.startsWith("FuntouchOS_")) {
            f2833a = "FuntouchOS_" + m3459a;
        }
        return f2833a;
    }

    /* renamed from: a */
    public static Class<?> m3463a(Context context, String str) {
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
            AbstractC1417b.m1089a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", th);
        }
    }
}
