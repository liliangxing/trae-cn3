package com.bytedance.p009dr;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.p009dr.impl.C1066a;
import com.bytedance.p009dr.impl.C1068c;
import com.bytedance.p009dr.impl.C1069d;
import com.bytedance.p009dr.impl.C1070e;
import com.bytedance.p009dr.impl.C1072g;
import com.bytedance.p009dr.impl.C1073h;
import com.bytedance.p009dr.impl.C1074i;
import com.bytedance.p009dr.impl.C1075j;
import com.bytedance.p009dr.impl.C1076k;
import com.bytedance.p009dr.impl.C1077l;
import com.bytedance.p009dr.impl.C1078m;
import com.bytedance.p009dr.impl.C1079n;
import com.bytedance.p009dr.impl.C1080o;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.w5;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class OaidFactory {
    /* JADX WARN: Removed duplicated region for block: B:58:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static OaidApi createOaidImpl(Context context) {
        boolean z;
        String str;
        if (w5.b()) {
            return new C1077l(new C1080o());
        }
        boolean z2 = true;
        if ((Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI")) && C1080o.m287a()) {
            return new C1080o();
        }
        if (((Boolean) C1076k.f181a.b(new Object[0])).booleanValue()) {
            return new C1076k();
        }
        if (w5.d() && w5.a()) {
            LoggerImpl.global().debug("honor# Oaid#old honor oaid", new Object[0]);
            return new C1070e();
        }
        if (w5.d() && !w5.a()) {
            LoggerImpl.global().debug("honor# Oaid#new honor oaid", new Object[0]);
            return new C1072g();
        }
        if (w5.e()) {
            return new C1070e();
        }
        if ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) {
            return new C1077l(null);
        }
        String str2 = Build.BRAND;
        if (str2 == null ? false : str2.toLowerCase(Locale.ENGLISH).contains("meizu")) {
            return new C1074i();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.uiversion", "");
            LoggerImpl.global().info("Current 360OS UI: " + str, new Object[0]);
        } catch (Throwable unused) {
            LoggerImpl.global().info("Current OS isn't 360OS.", new Object[0]);
        }
        if (str != null) {
            if (str.contains("360UI")) {
                z = true;
                if (!z) {
                    LoggerImpl.global().debug("Oaid#Qiku360OaidImpl", new Object[0]);
                    return new C1078m();
                }
                if (Build.VERSION.SDK_INT <= 28) {
                    if (w5.f() || !C1070e.m267a(context)) {
                        return null;
                    }
                    return new C1070e();
                }
                if ("samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
                    return new C1079n();
                }
                String str3 = Build.MANUFACTURER;
                if ((str3 == null ? "" : str3.trim()).toUpperCase().contains("NUBIA")) {
                    return new C1075j();
                }
                String str4 = Build.FINGERPRINT;
                if (TextUtils.isEmpty(str4)) {
                    String a = w5.a("ro.build.version.incremental");
                    if (TextUtils.isEmpty(a) || !a.contains("VIBEUI_V2")) {
                        z2 = false;
                    }
                } else {
                    z2 = str4.contains("VIBEUI_V2");
                }
                if (z2) {
                    return new C1073h();
                }
                String str5 = Build.MANUFACTURER;
                if ((str5 != null ? str5.trim() : "").toUpperCase().contains("ASUS")) {
                    return new C1066a();
                }
                C1069d c1069d = new C1069d(context);
                return c1069d.support(context) ? c1069d : new C1068c();
            }
        }
        z = false;
        if (!z) {
        }
    }
}
