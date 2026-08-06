package com.apm.lite;

import android.app.Application;
import android.content.Context;
import com.apm.lite.runtime.C0823d;
import com.apm.lite.runtime.C0828i;
import com.apm.lite.runtime.C0836q;
import com.apm.lite.runtime.ConfigManager;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.apm.lite.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0749e {

    /* renamed from: a */
    private static Context f421a;

    /* renamed from: b */
    private static Application f422b;

    /* renamed from: c */
    private static long f423c;

    /* renamed from: d */
    private static boolean f424d;

    /* renamed from: e */
    private static C0823d f425e;

    /* renamed from: h */
    private static volatile ConcurrentHashMap<Integer, String> f428h;

    /* renamed from: m */
    private static volatile String f433m;

    /* renamed from: f */
    private static ConfigManager f426f = new ConfigManager();

    /* renamed from: g */
    private static C0729a f427g = new C0729a();

    /* renamed from: i */
    private static C0836q f429i = null;

    /* renamed from: j */
    private static volatile String f430j = null;

    /* renamed from: k */
    private static Object f431k = new Object();

    /* renamed from: l */
    private static volatile int f432l = 0;

    /* renamed from: n */
    private static int f434n = 0;

    /* renamed from: o */
    private static boolean f435o = true;

    /* renamed from: p */
    private static boolean f436p = false;

    /* renamed from: q */
    private static boolean f437q = true;

    /* renamed from: a */
    public static C0823d m553a() {
        if (f425e == null) {
            f425e = C0828i.m1149a(f421a);
        }
        return f425e;
    }

    /* renamed from: a */
    public static String m554a(long j, CrashType crashType, boolean z, boolean z2) {
        return j + "_" + crashType.getName() + '_' + m564f() + '_' + (z ? "oom_" : "normal_") + m568j() + '_' + (z2 ? "ignore_" : "normal_") + Long.toHexString(new Random().nextLong()) + "G";
    }

    /* renamed from: a */
    public static void m555a(Application application, Context context) {
        if (f422b == null) {
            f423c = System.currentTimeMillis();
            f421a = context;
            f422b = application;
            f430j = Long.toHexString(new Random().nextLong()) + "G";
        }
    }

    /* renamed from: a */
    public static void m556a(C0823d c0823d) {
        f425e = c0823d;
    }

    /* renamed from: a */
    public static void m557a(boolean z) {
        f435o = z;
    }

    /* renamed from: b */
    public static C0729a m558b() {
        return f427g;
    }

    /* renamed from: b */
    public static void m559b(boolean z) {
        f436p = z;
    }

    /* renamed from: c */
    public static C0836q m560c() {
        if (f429i == null) {
            synchronized (C0749e.class) {
                f429i = new C0836q(f421a);
            }
        }
        return f429i;
    }

    /* renamed from: c */
    public static void m561c(boolean z) {
        f437q = z;
    }

    /* renamed from: d */
    public static boolean m562d() {
        return m567i().isDebugMode() && m572n().contains("local_test");
    }

    /* renamed from: e */
    public static String m563e() {
        return m564f() + '_' + Long.toHexString(new Random().nextLong()) + "G";
    }

    /* renamed from: f */
    public static String m564f() {
        if (f430j == null) {
            synchronized (f431k) {
                if (f430j == null) {
                    f430j = Long.toHexString(new Random().nextLong()) + "U";
                }
            }
        }
        return f430j;
    }

    /* renamed from: g */
    public static Context m565g() {
        return f421a;
    }

    /* renamed from: h */
    public static Application m566h() {
        return f422b;
    }

    /* renamed from: i */
    public static ConfigManager m567i() {
        return f426f;
    }

    /* renamed from: j */
    public static long m568j() {
        return f423c;
    }

    /* renamed from: k */
    public static String m569k() {
        return DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE;
    }

    /* renamed from: l */
    public static int m570l() {
        return f434n;
    }

    /* renamed from: m */
    public static boolean m571m() {
        return f424d;
    }

    /* renamed from: n */
    public static String m572n() {
        Object obj = m553a().m1121a().get("channel");
        return obj == null ? "unknown" : String.valueOf(obj);
    }

    /* renamed from: o */
    public static ConcurrentHashMap<Integer, String> m573o() {
        return f428h;
    }

    /* renamed from: p */
    public static int m574p() {
        return f432l;
    }

    /* renamed from: q */
    public static String m575q() {
        return f433m;
    }

    /* renamed from: r */
    public static boolean m576r() {
        return f436p;
    }

    /* renamed from: s */
    public static boolean m577s() {
        return f437q;
    }

    /* renamed from: t */
    public static boolean m578t() {
        return f435o;
    }
}
