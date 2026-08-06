package com.apm.lite;

import android.app.Application;
import android.content.Context;
import com.apm.lite.runtime.ConfigManager;
import com.apm.lite.runtime.i;
import com.apm.lite.runtime.q;
import com.bytedance.crash.NpthBus;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class e {
    private static Context a;
    private static Application b;
    private static long c;
    private static boolean d;
    private static com.apm.lite.runtime.d e;
    private static volatile ConcurrentHashMap<Integer, String> h;
    private static volatile String m;
    private static ConfigManager f = new ConfigManager();
    private static a g = new a();
    private static q i = null;
    private static volatile String j = null;
    private static Object k = new Object();
    private static volatile int l = 0;
    private static int n = 0;
    private static boolean o = true;
    private static boolean p = false;
    private static boolean q = true;

    public static com.apm.lite.runtime.d a() {
        if (e == null) {
            e = i.a(a);
        }
        return e;
    }

    public static String a(long j2, CrashType crashType, boolean z, boolean z2) {
        return j2 + "_" + crashType.getName() + '_' + f() + '_' + (z ? "oom_" : "normal_") + j() + '_' + (z2 ? "ignore_" : "normal_") + Long.toHexString(new Random().nextLong()) + NpthBus.UUID_SUFIX_3_1_3;
    }

    public static void a(Application application, Context context) {
        if (b == null) {
            c = System.currentTimeMillis();
            a = context;
            b = application;
            j = Long.toHexString(new Random().nextLong()) + NpthBus.UUID_SUFIX_3_1_3;
        }
    }

    public static void a(com.apm.lite.runtime.d dVar) {
        e = dVar;
    }

    public static void a(boolean z) {
        o = z;
    }

    public static a b() {
        return g;
    }

    public static void b(boolean z) {
        p = z;
    }

    public static q c() {
        if (i == null) {
            synchronized (e.class) {
                i = new q(a);
            }
        }
        return i;
    }

    public static void c(boolean z) {
        q = z;
    }

    public static boolean d() {
        return i().isDebugMode() && n().contains("local_test");
    }

    public static String e() {
        return f() + '_' + Long.toHexString(new Random().nextLong()) + NpthBus.UUID_SUFIX_3_1_3;
    }

    public static String f() {
        if (j == null) {
            synchronized (k) {
                if (j == null) {
                    j = Long.toHexString(new Random().nextLong()) + "U";
                }
            }
        }
        return j;
    }

    public static Context g() {
        return a;
    }

    public static Application h() {
        return b;
    }

    public static ConfigManager i() {
        return f;
    }

    public static long j() {
        return c;
    }

    public static String k() {
        return "default";
    }

    public static int l() {
        return n;
    }

    public static boolean m() {
        return d;
    }

    public static String n() {
        Object obj = a().a().get("channel");
        return obj == null ? "unknown" : String.valueOf(obj);
    }

    public static ConcurrentHashMap<Integer, String> o() {
        return h;
    }

    public static int p() {
        return l;
    }

    public static String q() {
        return m;
    }

    public static boolean r() {
        return p;
    }

    public static boolean s() {
        return q;
    }

    public static boolean t() {
        return o;
    }
}
