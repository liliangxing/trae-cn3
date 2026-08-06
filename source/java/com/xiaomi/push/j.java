package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes7.dex */
public class j {
    private static volatile int a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static Map<String, m> f897a = null;
    private static int b = -1;

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m10104a() {
        return a() == 1;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m10108b() {
        return a() == 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        int i;
        boolean z;
        if (a == 0) {
            try {
                i = 1;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                a = 0;
            }
            if (TextUtils.isEmpty(m10102a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m10102a("ro.miui.ui.version.name"))) {
                z = false;
                if (z) {
                    i = 2;
                }
                a = i;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
            }
            z = true;
            if (z) {
            }
            a = i;
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m10101a() {
        int a2 = q.a();
        return (!m10104a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m10102a(String str) {
        try {
            try {
                return (String) av.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    public static boolean m10109c() {
        if (b < 0) {
            b = !m10111e() ? 1 : 0;
        }
        return b > 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m10105a(Context context) {
        return context != null && m10106a(context.getPackageName());
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m10106a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static String b() {
        String a2 = p.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = m10107b(p.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("get region from system, region = " + a2);
        }
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String country = Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.b.m9528a("locale.default.country = " + country);
        return country;
    }

    public static m a(String str) {
        m b2 = b(str);
        return b2 == null ? m.Global : b2;
    }

    private static m b(String str) {
        m10103a();
        return f897a.get(str.toUpperCase());
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m10103a() {
        if (f897a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f897a = hashMap;
        hashMap.put("CN", m.China);
        f897a.put("FI", m.Europe);
        f897a.put("SE", m.Europe);
        f897a.put("NO", m.Europe);
        f897a.put("FO", m.Europe);
        f897a.put("EE", m.Europe);
        f897a.put("LV", m.Europe);
        f897a.put("LT", m.Europe);
        f897a.put("BY", m.Europe);
        f897a.put("MD", m.Europe);
        f897a.put("UA", m.Europe);
        f897a.put("PL", m.Europe);
        f897a.put("CZ", m.Europe);
        f897a.put("SK", m.Europe);
        f897a.put("HU", m.Europe);
        f897a.put("DE", m.Europe);
        f897a.put("AT", m.Europe);
        f897a.put("CH", m.Europe);
        f897a.put("LI", m.Europe);
        f897a.put("GB", m.Europe);
        f897a.put("IE", m.Europe);
        f897a.put("NL", m.Europe);
        f897a.put("BE", m.Europe);
        f897a.put("LU", m.Europe);
        f897a.put("FR", m.Europe);
        f897a.put("RO", m.Europe);
        f897a.put("BG", m.Europe);
        f897a.put("RS", m.Europe);
        f897a.put("MK", m.Europe);
        f897a.put("AL", m.Europe);
        f897a.put("GR", m.Europe);
        f897a.put("SI", m.Europe);
        f897a.put("HR", m.Europe);
        f897a.put("IT", m.Europe);
        f897a.put("SM", m.Europe);
        f897a.put("MT", m.Europe);
        f897a.put("ES", m.Europe);
        f897a.put("PT", m.Europe);
        f897a.put("AD", m.Europe);
        f897a.put("CY", m.Europe);
        f897a.put("DK", m.Europe);
        f897a.put("IS", m.Europe);
        f897a.put("UK", m.Europe);
        f897a.put("EL", m.Europe);
        f897a.put("RU", m.Russia);
        f897a.put("IN", m.India);
    }

    /* renamed from: d, reason: collision with other method in class */
    public static boolean m10110d() {
        return !m.China.name().equalsIgnoreCase(a(b()).name());
    }

    public static int a(Context context) {
        String m10102a = m10102a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(m10102a) || !TextUtils.isDigitsOnly(m10102a)) {
            return 0;
        }
        return Integer.parseInt(m10102a);
    }

    public static String c() {
        return m10102a("ro.miui.ui.version.name");
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    private static String m10107b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length > 0 ? split[0] : str;
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str).append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb.append(a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: e, reason: collision with other method in class */
    public static boolean m10111e() {
        String str = "";
        try {
            str = p.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }

    public static String d() {
        return m10102a("ro.build.characteristics");
    }

    public static String e() {
        return m10102a("ro.product.manufacturer");
    }
}
