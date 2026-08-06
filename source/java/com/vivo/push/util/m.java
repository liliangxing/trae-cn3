package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.caverock.androidsvg.SVGParser;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Device.java */
/* loaded from: classes7.dex */
public final class m {
    private static Method f;
    public static final boolean a = ah.b("ro.vivo.product.overseas", SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO).equals("yes");
    public static final boolean b = b("rom_1.0");
    public static final boolean c = b("rom_2.0");
    public static final boolean d = b("rom_2.5");
    public static final boolean e = b("rom_3.0");
    private static String g = null;
    private static String h = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static synchronized String a() {
        synchronized (m.class) {
            if (g == null && h == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    f = declaredMethod;
                    declaredMethod.setAccessible(true);
                    g = (String) f.invoke(null, "ro.vivo.rom", "@><@");
                    h = (String) f.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    t.b("Device", "getRomCode error");
                }
            }
            t.d("Device", "sRomProperty1 : " + g + " ; sRomProperty2 : " + h);
            String a2 = a(g);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
            String a3 = a(h);
            if (TextUtils.isEmpty(a3)) {
                return null;
            }
            return a3;
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1) + (TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        }
        return null;
    }

    private static boolean b(String str) {
        String b2 = ah.b("ro.vivo.rom", "");
        String b3 = ah.b("ro.vivo.rom.version", "");
        t.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            t.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        t.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith("vivo");
    }
}
