package com.apm.lite.p023k;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* renamed from: com.apm.lite.k.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0797t {

    /* renamed from: a */
    private static final CharSequence f599a = "sony";

    /* renamed from: b */
    private static final CharSequence f600b = "amigo";

    /* renamed from: c */
    private static final CharSequence f601c = "funtouch";

    /* renamed from: a */
    public static String m900a() {
        if (C0781d.m765c()) {
            return m910j();
        }
        if (C0781d.m767d()) {
            return m912l();
        }
        if (m913m()) {
            return m914n();
        }
        String m911k = m911k();
        if (!TextUtils.isEmpty(m911k)) {
            return m911k;
        }
        if (m905e()) {
            return m904d();
        }
        if (m906f()) {
            return m907g();
        }
        if (m903c()) {
            return m902b();
        }
        String m908h = m908h();
        return !TextUtils.isEmpty(m908h) ? m908h : Build.DISPLAY;
    }

    /* renamed from: a */
    private static String m901a(String str) {
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            Process exec = Runtime.getRuntime().exec("getprop " + str);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader2.readLine();
                exec.destroy();
                C0788k.m813a(bufferedReader2);
                return str2;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                C0788k.m813a(bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    public static String m902b() {
        return m901a("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    /* renamed from: c */
    public static boolean m903c() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    /* renamed from: d */
    public static String m904d() {
        return m901a("ro.vivo.os.build.display.id") + "_" + m901a("ro.vivo.product.version");
    }

    /* renamed from: e */
    public static boolean m905e() {
        String m901a = m901a("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(m901a) && m901a.toLowerCase(Locale.getDefault()).contains(f601c);
    }

    /* renamed from: f */
    public static boolean m906f() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(f600b);
    }

    /* renamed from: g */
    public static String m907g() {
        return Build.DISPLAY + "_" + m901a("ro.gn.sv.version");
    }

    /* renamed from: h */
    public static String m908h() {
        return m909i() ? "eui_" + m901a("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    /* renamed from: i */
    public static boolean m909i() {
        return !TextUtils.isEmpty(m901a("ro.letv.release.version"));
    }

    /* renamed from: j */
    public static String m910j() {
        return C0781d.m765c() ? "miui_" + m901a("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    /* renamed from: k */
    public static String m911k() {
        String m760a = C0781d.m760a();
        return (m760a == null || !m760a.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : m760a + "_" + Build.DISPLAY;
    }

    /* renamed from: l */
    public static String m912l() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    /* renamed from: m */
    public static boolean m913m() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    /* renamed from: n */
    public static String m914n() {
        return m913m() ? "coloros_" + m901a("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }
}
