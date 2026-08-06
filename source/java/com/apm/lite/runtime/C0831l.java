package com.apm.lite.runtime;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.IOOMCallback;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p012b.C0735d;
import com.apm.lite.p013c.C0739a;
import com.apm.lite.p017e.C0750a;
import com.apm.lite.p017e.C0753d;
import com.apm.lite.p019g.C0759b;
import com.apm.lite.p022j.C0775j;
import com.apm.lite.p022j.RunnableC0773h;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.runtime.p024a.C0815e;
import java.io.File;

/* renamed from: com.apm.lite.runtime.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0831l {

    /* renamed from: a */
    private static boolean f716a;

    /* renamed from: b */
    private static boolean f717b;

    /* renamed from: c */
    private static boolean f718c;

    /* renamed from: d */
    private static boolean f719d;

    /* renamed from: e */
    private static C0822c f720e = new C0822c();

    /* renamed from: f */
    private static volatile boolean f721f = false;

    /* renamed from: g */
    private static boolean f722g = false;

    /* renamed from: a */
    public static C0822c m1159a() {
        return f720e;
    }

    /* renamed from: a */
    public static synchronized void m1160a(Application application, Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        synchronized (C0831l.class) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (f716a) {
                return;
            }
            f716a = true;
            if (context == null || application == null) {
                throw new IllegalArgumentException("context or Application must be not null.");
            }
            if (C0749e.m576r() && (m1166a(application) || m1170b(application) || m1188o())) {
                Log.e("apminsight", "Inner npth checked.");
                return;
            }
            C0749e.m555a(application, context);
            if (z || z2) {
                C0750a m581a = C0750a.m581a();
                if (z2) {
                    m581a.m600a(new C0759b(context));
                }
                if (z) {
                    m581a.m603b(new C0753d(context));
                }
                f717b = true;
            }
            NativeImpl.loadLibrary();
            if (z3) {
                f719d = NativeImpl.startMonitorNativeCrash(context);
            }
            if (z4 && C0749e.m567i().isSigQuitEnable() && Looper.myLooper() == Looper.getMainLooper()) {
                f721f = true;
                NativeImpl.registerSignalMainThread();
            }
            m1178f(z4);
            C0794q.m887a((Object) ("Npth.init takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms."));
        }
    }

    /* renamed from: a */
    public static synchronized void m1161a(Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        Application application;
        synchronized (C0831l.class) {
            if (C0749e.m566h() != null) {
                application = C0749e.m566h();
            } else if (context instanceof Application) {
                application = (Application) context;
                if (application.getBaseContext() == null) {
                    throw new IllegalArgumentException("Application not attach.");
                }
            } else {
                application = (Application) context.getApplicationContext();
                if (application == null) {
                    throw new IllegalArgumentException("no Application.");
                }
                if (application.getBaseContext() != null) {
                    context = application.getBaseContext();
                }
            }
            m1160a(application, context, z, z2, z3, z4, j);
        }
    }

    /* renamed from: a */
    public static void m1162a(ICrashCallback iCrashCallback, CrashType crashType) {
        m1159a().m1111a(iCrashCallback, crashType);
    }

    /* renamed from: a */
    public static void m1163a(IOOMCallback iOOMCallback) {
        m1159a().m1112a(iOOMCallback);
    }

    /* renamed from: a */
    public static void m1164a(IOOMCallback iOOMCallback, CrashType crashType) {
        m1159a().m1115b(iOOMCallback);
    }

    /* renamed from: a */
    public static void m1165a(boolean z) {
        C0749e.m557a(z);
    }

    /* renamed from: a */
    private static boolean m1166a(Context context) {
        try {
            return new File(C0792o.m875j(context), "npth").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static void m1167b(ICrashCallback iCrashCallback, CrashType crashType) {
        m1159a().m1114b(iCrashCallback, crashType);
    }

    /* renamed from: b */
    public static void m1168b(boolean z) {
        C0749e.m559b(z);
    }

    /* renamed from: b */
    public static boolean m1169b() {
        return f717b;
    }

    /* renamed from: b */
    private static boolean m1170b(Context context) {
        try {
            return new File(context.getApplicationInfo().nativeLibraryDir, "libnpth.so").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static void m1171c(boolean z) {
        C0749e.m561c(z);
    }

    /* renamed from: c */
    public static boolean m1172c() {
        return f718c;
    }

    /* renamed from: d */
    public static boolean m1173d() {
        return f719d;
    }

    /* renamed from: e */
    public static boolean m1176e() {
        return f716a;
    }

    /* renamed from: f */
    public static void m1177f() {
        if (!f716a || f717b) {
            return;
        }
        Context m565g = C0749e.m565g();
        C0750a m581a = C0750a.m581a();
        m581a.m600a(new C0759b(m565g));
        m581a.m603b(new C0753d(m565g));
    }

    /* renamed from: f */
    private static void m1178f(final boolean z) {
        C0832m.m1190b().m1239a(new Runnable() { // from class: com.apm.lite.runtime.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (C0749e.m567i().isSigQuitEnable() && z && !C0831l.f721f) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.apm.lite.runtime.l.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean unused = C0831l.f721f = true;
                            NativeImpl.registerSignalMainThread();
                        }
                    });
                }
                C0831l.m1180g(z);
            }
        }, 0L);
    }

    /* renamed from: g */
    public static void m1179g() {
        if (f716a) {
            C0735d.m426a(C0749e.m565g()).m432b();
            f718c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m1180g(boolean z) {
        Context m565g = C0749e.m565g();
        C0815e.m1103a();
        NativeImpl.createCallbackThread();
        C0739a.m438a().m440a(m565g);
        RunnableC0773h.m713a(m565g);
        if (z) {
            C0735d.m426a(m565g).m432b();
            f718c = z;
            if (C0749e.m567i().isSigQuitEnable()) {
                NativeImpl.startThreadForAnrMonitor();
            }
        }
        C0775j.m728d();
        NativeImpl.initPThreadDump();
        C0834o.m1195a("afterNpthInitAsync", "noValue");
    }

    /* renamed from: h */
    public static boolean m1181h() {
        if (f716a && !f719d) {
            f719d = NativeImpl.startMonitorNativeCrash(C0749e.m565g());
        }
        return f719d;
    }

    /* renamed from: i */
    public static boolean m1182i() {
        return C0750a.m587b() || NativeImpl.duringNativeCrash();
    }

    /* renamed from: j */
    public static boolean m1183j() {
        return C0750a.m592c() || NativeImpl.duringNativeCrash();
    }

    /* renamed from: k */
    public static boolean m1184k() {
        return C0750a.m587b();
    }

    /* renamed from: l */
    public static boolean m1185l() {
        return f722g;
    }

    /* renamed from: m */
    public static void m1186m() {
        f722g = true;
    }

    /* renamed from: o */
    private static boolean m1188o() {
        return false;
    }
}
