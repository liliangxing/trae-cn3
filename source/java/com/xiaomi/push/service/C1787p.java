package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.C1703r;
import com.xiaomi.push.service.C1755am;
import java.util.Locale;

/* renamed from: com.xiaomi.push.service.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1787p {

    /* renamed from: a */
    public final int f3195a;

    /* renamed from: a */
    public final String f3196a;

    /* renamed from: b */
    public final String f3197b;

    /* renamed from: c */
    public final String f3198c;

    /* renamed from: d */
    public final String f3199d;

    /* renamed from: e */
    public final String f3200e;

    /* renamed from: f */
    public final String f3201f;

    public C1787p(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f3196a = str;
        this.f3197b = str2;
        this.f3198c = str3;
        this.f3199d = str4;
        this.f3200e = str5;
        this.f3201f = str6;
        this.f3195a = i;
    }

    /* renamed from: b */
    private static boolean m3951b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* renamed from: a */
    public C1755am.b m3952a(XMPushService xMPushService) {
        C1755am.b bVar = new C1755am.b(xMPushService);
        m3953a(bVar, xMPushService, xMPushService.m3559b(), "c");
        return bVar;
    }

    /* renamed from: a */
    public C1755am.b m3953a(C1755am.b bVar, Context context, C1779h c1779h, String str) {
        bVar.f2995a = context.getPackageName();
        bVar.f2999b = this.f3196a;
        bVar.f3006h = this.f3198c;
        bVar.f3001c = this.f3197b;
        bVar.f3005g = "5";
        bVar.f3002d = "XMPUSH-PASS";
        bVar.f2997a = false;
        C1703r.a aVar = new C1703r.a();
        aVar.m3477a("sdk_ver", 48).m3477a("cpvn", BuildConfig.VERSION_NAME).m3477a("cpvc", Integer.valueOf(BuildConfig.VERSION_CODE)).m3477a("country_code", C1769b.m3796a(context).m3801b()).m3477a(RegistrationHeaderHelper.KEY_REGISON, C1769b.m3796a(context).m3799a()).m3477a("miui_vn", C1694j.m3434c()).m3477a("miui_vc", Integer.valueOf(C1694j.m3419a(context))).m3477a("xmsf_vc", Integer.valueOf(C1628g.m2677a(context, "com.xiaomi.xmsf"))).m3477a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).m3477a("n_belong_to_app", Boolean.valueOf(C1748af.m3633a(context))).m3477a("systemui_vc", Integer.valueOf(C1628g.m2676a(context)));
        String m3948a = m3948a(context);
        if (!TextUtils.isEmpty(m3948a)) {
            aVar.m3477a("latest_country_code", m3948a);
        }
        String m3436d = C1694j.m3436d();
        if (!TextUtils.isEmpty(m3436d)) {
            aVar.m3477a("device_ch", m3436d);
        }
        String m3438e = C1694j.m3438e();
        if (!TextUtils.isEmpty(m3438e)) {
            aVar.m3477a("device_mfr", m3438e);
        }
        bVar.f3003e = aVar.toString();
        String str2 = m3951b(context) ? "1000271" : this.f3199d;
        C1703r.a aVar2 = new C1703r.a();
        aVar2.m3477a("appid", str2).m3477a("locale", Locale.getDefault().toString()).m3477a("sync", 1);
        if (m3950a(context)) {
            aVar2.m3477a("ab", str);
        }
        bVar.f3004f = aVar2.toString();
        bVar.f2994a = c1779h;
        return bVar;
    }

    /* renamed from: a */
    public static boolean m3950a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && m3949a();
    }

    /* renamed from: a */
    public static boolean m3949a() {
        try {
            return C1702q.m3463a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static String m3948a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (!TextUtils.isEmpty(null)) {
                return null;
            }
            String m3424a = C1694j.m3424a("ro.miui.region");
            return TextUtils.isEmpty(m3424a) ? C1694j.m3424a("ro.product.locale.region") : m3424a;
        }
        return C1694j.m3431b();
    }
}
