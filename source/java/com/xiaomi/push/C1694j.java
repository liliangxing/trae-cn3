package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.xiaomi.push.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1694j {

    /* renamed from: a */
    private static volatile int f2806a = 0;

    /* renamed from: a */
    private static Map<String, EnumC1697m> f2807a = null;

    /* renamed from: b */
    private static int f2808b = -1;

    /* renamed from: a */
    public static boolean m3426a() {
        return m3418a() == 1;
    }

    /* renamed from: b */
    public static boolean m3433b() {
        return m3418a() == 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m3418a() {
        int i;
        boolean z;
        if (f2806a == 0) {
            try {
                i = 1;
            } catch (Throwable th) {
                AbstractC1417b.m1091a("get isMIUI failed", th);
                f2806a = 0;
            }
            if (TextUtils.isEmpty(m3424a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m3424a(RomUtils.RUNTIME_MIUI))) {
                z = false;
                if (z) {
                    i = 2;
                }
                f2806a = i;
                AbstractC1417b.m1098b("isMIUI's value is: " + f2806a);
            }
            z = true;
            if (z) {
            }
            f2806a = i;
            AbstractC1417b.m1098b("isMIUI's value is: " + f2806a);
        }
        return f2806a;
    }

    /* renamed from: a */
    public static String m3421a() {
        int m3461a = C1702q.m3461a();
        return (!m3426a() || m3461a <= 0) ? "" : m3461a < 2 ? "alpha" : m3461a < 3 ? "development" : "stable";
    }

    /* renamed from: a */
    public static String m3424a(String str) {
        try {
            try {
                return (String) C1488av.m1570a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, str, "");
            } catch (Exception e) {
                AbstractC1417b.m1103d("fail to get property. " + e);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m3435c() {
        if (f2808b < 0) {
            f2808b = !m3439e() ? 1 : 0;
        }
        return f2808b > 0;
    }

    /* renamed from: a */
    public static boolean m3427a(Context context) {
        return context != null && m3428a(context.getPackageName());
    }

    /* renamed from: a */
    public static boolean m3428a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    /* renamed from: b */
    public static String m3431b() {
        String m3459a = C1700p.m3459a("ro.miui.region", "");
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = m3432b(C1700p.m3459a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(m3459a)) {
            m3459a = C1700p.m3459a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(m3459a)) {
            AbstractC1417b.m1089a("get region from system, region = " + m3459a);
        }
        if (!TextUtils.isEmpty(m3459a)) {
            return m3459a;
        }
        String country = Locale.getDefault().getCountry();
        AbstractC1417b.m1089a("locale.default.country = " + country);
        return country;
    }

    /* renamed from: a */
    public static EnumC1697m m3420a(String str) {
        EnumC1697m m3430b = m3430b(str);
        return m3430b == null ? EnumC1697m.Global : m3430b;
    }

    /* renamed from: b */
    private static EnumC1697m m3430b(String str) {
        m3425a();
        return f2807a.get(str.toUpperCase());
    }

    /* renamed from: a */
    private static void m3425a() {
        if (f2807a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f2807a = hashMap;
        hashMap.put("CN", EnumC1697m.China);
        f2807a.put("FI", EnumC1697m.Europe);
        f2807a.put("SE", EnumC1697m.Europe);
        f2807a.put("NO", EnumC1697m.Europe);
        f2807a.put("FO", EnumC1697m.Europe);
        f2807a.put("EE", EnumC1697m.Europe);
        f2807a.put("LV", EnumC1697m.Europe);
        f2807a.put("LT", EnumC1697m.Europe);
        f2807a.put("BY", EnumC1697m.Europe);
        f2807a.put("MD", EnumC1697m.Europe);
        f2807a.put("UA", EnumC1697m.Europe);
        f2807a.put("PL", EnumC1697m.Europe);
        f2807a.put("CZ", EnumC1697m.Europe);
        f2807a.put("SK", EnumC1697m.Europe);
        f2807a.put("HU", EnumC1697m.Europe);
        f2807a.put("DE", EnumC1697m.Europe);
        f2807a.put("AT", EnumC1697m.Europe);
        f2807a.put("CH", EnumC1697m.Europe);
        f2807a.put("LI", EnumC1697m.Europe);
        f2807a.put("GB", EnumC1697m.Europe);
        f2807a.put("IE", EnumC1697m.Europe);
        f2807a.put("NL", EnumC1697m.Europe);
        f2807a.put("BE", EnumC1697m.Europe);
        f2807a.put("LU", EnumC1697m.Europe);
        f2807a.put("FR", EnumC1697m.Europe);
        f2807a.put("RO", EnumC1697m.Europe);
        f2807a.put("BG", EnumC1697m.Europe);
        f2807a.put("RS", EnumC1697m.Europe);
        f2807a.put("MK", EnumC1697m.Europe);
        f2807a.put("AL", EnumC1697m.Europe);
        f2807a.put("GR", EnumC1697m.Europe);
        f2807a.put("SI", EnumC1697m.Europe);
        f2807a.put("HR", EnumC1697m.Europe);
        f2807a.put("IT", EnumC1697m.Europe);
        f2807a.put("SM", EnumC1697m.Europe);
        f2807a.put("MT", EnumC1697m.Europe);
        f2807a.put("ES", EnumC1697m.Europe);
        f2807a.put("PT", EnumC1697m.Europe);
        f2807a.put("AD", EnumC1697m.Europe);
        f2807a.put("CY", EnumC1697m.Europe);
        f2807a.put("DK", EnumC1697m.Europe);
        f2807a.put("IS", EnumC1697m.Europe);
        f2807a.put("UK", EnumC1697m.Europe);
        f2807a.put("EL", EnumC1697m.Europe);
        f2807a.put("RU", EnumC1697m.Russia);
        f2807a.put("IN", EnumC1697m.India);
    }

    /* renamed from: d */
    public static boolean m3437d() {
        return !EnumC1697m.China.name().equalsIgnoreCase(m3420a(m3431b()).name());
    }

    /* renamed from: a */
    public static int m3419a(Context context) {
        String m3424a = m3424a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(m3424a) || !TextUtils.isDigitsOnly(m3424a)) {
            return 0;
        }
        return Integer.parseInt(m3424a);
    }

    /* renamed from: c */
    public static String m3434c() {
        return m3424a(RomUtils.RUNTIME_MIUI);
    }

    /* renamed from: b */
    public static int m3429b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private static String m3432b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length > 0 ? split[0] : str;
    }

    /* renamed from: a */
    public static String m3422a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + m3423a(intent.getExtras());
    }

    /* renamed from: a */
    public static String m3423a(Bundle bundle) {
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
                    sb.append(m3423a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: e */
    public static boolean m3439e() {
        String str = "";
        try {
            str = C1700p.m3459a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }

    /* renamed from: d */
    public static String m3436d() {
        return m3424a("ro.build.characteristics");
    }

    /* renamed from: e */
    public static String m3438e() {
        return m3424a("ro.product.manufacturer");
    }
}
