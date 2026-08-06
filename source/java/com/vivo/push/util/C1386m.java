package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Device.java */
/* renamed from: com.vivo.push.util.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1386m {

    /* renamed from: f */
    private static Method f708f;

    /* renamed from: a */
    public static final boolean f703a = C1373ah.m962b("ro.vivo.product.overseas", "no").equals("yes");

    /* renamed from: b */
    public static final boolean f704b = m1012b("rom_1.0");

    /* renamed from: c */
    public static final boolean f705c = m1012b("rom_2.0");

    /* renamed from: d */
    public static final boolean f706d = m1012b("rom_2.5");

    /* renamed from: e */
    public static final boolean f707e = m1012b("rom_3.0");

    /* renamed from: g */
    private static String f709g = null;

    /* renamed from: h */
    private static String f710h = null;

    /* renamed from: a */
    public static String m1010a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e) {
            e.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* renamed from: a */
    public static synchronized String m1008a() {
        synchronized (C1386m.class) {
            if (f709g == null && f710h == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class);
                    f708f = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f709g = (String) f708f.invoke(null, "ro.vivo.rom", "@><@");
                    f710h = (String) f708f.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    C1393t.m1041b("Device", "getRomCode error");
                }
            }
            C1393t.m1048d("Device", "sRomProperty1 : " + f709g + " ; sRomProperty2 : " + f710h);
            String m1009a = m1009a(f709g);
            if (!TextUtils.isEmpty(m1009a)) {
                return m1009a;
            }
            String m1009a2 = m1009a(f710h);
            if (TextUtils.isEmpty(m1009a2)) {
                return null;
            }
            return m1009a2;
        }
    }

    /* renamed from: a */
    private static String m1009a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1) + (TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        }
        return null;
    }

    /* renamed from: b */
    private static boolean m1012b(String str) {
        String m962b = C1373ah.m962b("ro.vivo.rom", "");
        String m962b2 = C1373ah.m962b("ro.vivo.rom.version", "");
        C1393t.m1048d("Device", "ro.vivo.rom = " + m962b + " ; ro.vivo.rom.version = " + m962b2);
        if (m962b == null || !m962b.contains(str)) {
            return m962b2 != null && m962b2.contains(str);
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m1011b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            C1393t.m1048d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        C1393t.m1048d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith("vivo");
    }
}
