package com.apm.lite.p017e;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.ICrashFilter;
import com.apm.lite.IOOMCallback;
import com.apm.lite.Npth;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p011a.C0730a;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p022j.C0767b;
import com.apm.lite.p022j.RunnableC0773h;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0782e;
import com.apm.lite.p023k.C0783f;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0788k;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.p023k.C0795r;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.runtime.C0810a;
import com.apm.lite.runtime.C0831l;
import com.apm.lite.runtime.C0832m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.apm.lite.e.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0750a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static C0750a f438a;

    /* renamed from: i */
    private static volatile boolean f439i;

    /* renamed from: j */
    private static volatile ThreadLocal<Boolean> f440j = new ThreadLocal<>();

    /* renamed from: o */
    private static ArrayList<AbstractC0751b> f441o = new ArrayList<>();

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f442b;

    /* renamed from: c */
    private InterfaceC0752c f443c;

    /* renamed from: d */
    private InterfaceC0752c f444d;

    /* renamed from: e */
    private volatile int f445e = 0;

    /* renamed from: f */
    private volatile int f446f = 0;

    /* renamed from: g */
    private ConcurrentHashMap<String, Object> f447g = new ConcurrentHashMap<>();

    /* renamed from: h */
    private ConcurrentHashMap<String, Object> f448h = new ConcurrentHashMap<>();

    /* renamed from: k */
    private Stack<Thread.UncaughtExceptionHandler> f449k = new Stack<>();

    /* renamed from: l */
    private HashMap<Thread, Throwable> f450l = new HashMap<>();

    /* renamed from: m */
    private volatile int f451m = 0;

    /* renamed from: n */
    private Runnable f452n = new Runnable() { // from class: com.apm.lite.e.a.1
        @Override // java.lang.Runnable
        public void run() {
            C0794q.m887a((Object) "Recheck uncaught exception handler.");
            if (C0750a.this.f451m < 3) {
                C0750a.m585b(C0750a.this);
                C0750a.this.m594d();
                C0832m.m1190b().m1239a(C0750a.this.f452n, 30000L);
            }
        }
    };

    private C0750a() {
        m594d();
        if (Npth.getConfigManager().isRegisterJavaCrashEnable()) {
            m599a(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        }
    }

    /* renamed from: a */
    private static int m580a(Throwable th, Thread thread) {
        int i = 0;
        for (int i2 = 0; i2 < f441o.size(); i2++) {
            try {
                try {
                    i |= f441o.get(i2).m606a(th, thread);
                } catch (Throwable th2) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th2);
                }
            } catch (Throwable unused) {
            }
        }
        return i;
    }

    /* renamed from: a */
    public static C0750a m581a() {
        if (f438a == null) {
            f438a = new C0750a();
        }
        return f438a;
    }

    /* renamed from: a */
    private String m582a(File file, boolean z, Throwable th, String str, Thread thread, boolean z2) {
        String absolutePath = file.getAbsolutePath();
        this.f448h.put(file.getName(), file);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            NativeImpl.doLock(absolutePath);
        } catch (Throwable unused) {
        }
        String str2 = null;
        if (z2) {
            int openFile = NativeImpl.openFile(absolutePath);
            if (openFile > 0) {
                try {
                    NativeImpl.writeFile(openFile, C0778a.m748c(C0749e.m565g()));
                    NativeImpl.writeFile(openFile, "\n");
                    NativeImpl.writeFile(openFile, th.getMessage());
                    NativeImpl.writeFile(openFile, "\n");
                    NativeImpl.writeFile(openFile, th.getClass().getName());
                    if (th.getMessage() != null) {
                        NativeImpl.writeFile(openFile, ": ");
                        NativeImpl.writeFile(openFile, th.getMessage());
                    }
                    NativeImpl.writeFile(openFile, "\n");
                    NativeImpl.writeFile(openFile, thread.getName());
                    NativeImpl.writeFile(openFile, "\n");
                } catch (Throwable unused2) {
                }
                try {
                    NativeImpl.writeFile(openFile, "stack:");
                    NativeImpl.writeFile(openFile, "\n");
                } catch (Throwable unused3) {
                }
                C0799v.m926a(th, openFile);
                NativeImpl.closeFile(openFile);
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                if (C0795r.m896a(32768)) {
                    throw new RuntimeException("test exception before write stack");
                }
                fileOutputStream.write((C0778a.m748c(C0749e.m565g()) + "\n").getBytes());
                fileOutputStream.write((th.getMessage() + "\n").getBytes());
                fileOutputStream.write((th + "\n").getBytes());
                fileOutputStream.write((thread.getName() + "\n").getBytes());
                try {
                    fileOutputStream.write("stack:\n".getBytes());
                } catch (Throwable unused4) {
                }
                try {
                } catch (Throwable th2) {
                    try {
                        if (C0795r.m896a(16384)) {
                            throw new RuntimeException("test exception system write stack");
                        }
                        th.printStackTrace(new PrintStream(fileOutputStream));
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.write("err:\n".getBytes());
                            fileOutputStream.write((th2 + "\n").getBytes());
                            fileOutputStream.write((th3 + "\n").getBytes());
                        } catch (Throwable unused5) {
                        }
                    }
                }
                if (C0795r.m896a(8192)) {
                    throw new RuntimeException("test exception npth write stack");
                }
                str2 = C0799v.m918a(th, thread, new PrintStream(fileOutputStream), Looper.getMainLooper() == Looper.myLooper() ? new C0782e.a() { // from class: com.apm.lite.e.a.2

                    /* renamed from: a */
                    boolean f454a = false;

                    @Override // com.apm.lite.p023k.C0782e.a
                    /* renamed from: a */
                    public boolean mo605a(String str3) {
                        if (!this.f454a && str3.contains("android.os.Looper.loop")) {
                            this.f454a = true;
                        }
                        return !this.f454a;
                    }
                } : new C0782e.a());
                C0788k.m813a(fileOutputStream);
                C0788k.m813a(fileOutputStream);
            } catch (Throwable unused6) {
            }
        }
        return str2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:11|(1:13)|14|(2:15|16)|(3:186|187|(34:189|19|20|(2:22|23)(2:183|184)|24|25|26|27|28|(19:(2:166|167)|31|32|33|(1:35)(1:162)|36|(3:154|(1:156)(1:158)|157)(1:39)|40|(1:152)(3:43|44|45)|46|(1:48)|50|51|(1:53)(1:147)|54|55|(4:89|(3:92|93|(3:97|98|99))|91|(4:(1:75)(2:69|70)|71|72|73)(4:76|206|81|82))(3:62|63|64)|65|(0)(0))|172|32|33|(0)(0)|36|(0)|154|(0)(0)|157|40|(0)|152|46|(0)|50|51|(0)(0)|54|55|(1:57)|89|(0)|91|(0)(0)))|18|19|20|(0)(0)|24|25|26|27|28|(0)|172|32|33|(0)(0)|36|(0)|154|(0)(0)|157|40|(0)|152|46|(0)|50|51|(0)(0)|54|55|(0)|89|(0)|91|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(40:11|(1:13)|14|15|16|(3:186|187|(34:189|19|20|(2:22|23)(2:183|184)|24|25|26|27|28|(19:(2:166|167)|31|32|33|(1:35)(1:162)|36|(3:154|(1:156)(1:158)|157)(1:39)|40|(1:152)(3:43|44|45)|46|(1:48)|50|51|(1:53)(1:147)|54|55|(4:89|(3:92|93|(3:97|98|99))|91|(4:(1:75)(2:69|70)|71|72|73)(4:76|206|81|82))(3:62|63|64)|65|(0)(0))|172|32|33|(0)(0)|36|(0)|154|(0)(0)|157|40|(0)|152|46|(0)|50|51|(0)(0)|54|55|(1:57)|89|(0)|91|(0)(0)))|18|19|20|(0)(0)|24|25|26|27|28|(0)|172|32|33|(0)(0)|36|(0)|154|(0)(0)|157|40|(0)|152|46|(0)|50|51|(0)(0)|54|55|(0)|89|(0)|91|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01db, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01dc, code lost:
    
        r7 = r1;
        r9 = r3;
        r2 = r2;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x021a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0225, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0226, code lost:
    
        r4 = r5;
        r5 = r10;
        r2 = 1;
        r7 = r28;
        r9 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0233, code lost:
    
        r21 = false;
        r2 = r2;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x022c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x022d, code lost:
    
        r5 = r10;
        r2 = 1;
        r7 = r28;
        r9 = r27;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00c3, code lost:
    
        if (com.apm.lite.C0749e.m567i().isCrashIgnored(r7) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0236, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0237, code lost:
    
        r5 = r10;
        r2 = 1;
        r7 = r28;
        r9 = r27;
        r4 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0250 A[Catch: all -> 0x027b, TRY_LEAVE, TryCatch #14 {all -> 0x027b, blocks: (B:104:0x024a, B:106:0x0250), top: B:103:0x024a }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0151 A[Catch: all -> 0x021a, TryCatch #13 {all -> 0x021a, blocks: (B:53:0x014e, B:54:0x0153, B:57:0x0172, B:60:0x0178, B:62:0x017e, B:147:0x0151), top: B:51:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00f4 A[Catch: all -> 0x0225, TRY_ENTER, TryCatch #1 {all -> 0x0225, blocks: (B:40:0x0119, B:156:0x00f4, B:157:0x00f9, B:158:0x00f7), top: B:36:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00f7 A[Catch: all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:40:0x0119, B:156:0x00f4, B:157:0x00f9, B:158:0x00f7), top: B:36:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0129 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0145 A[Catch: all -> 0x021d, TRY_LEAVE, TryCatch #16 {all -> 0x021d, blocks: (B:45:0x0137, B:46:0x013f, B:48:0x0145), top: B:44:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014e A[Catch: all -> 0x021a, TRY_ENTER, TryCatch #13 {all -> 0x021a, blocks: (B:53:0x014e, B:54:0x0153, B:57:0x0172, B:60:0x0178, B:62:0x017e, B:147:0x0151), top: B:51:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0172 A[Catch: all -> 0x021a, TryCatch #13 {all -> 0x021a, blocks: (B:53:0x014e, B:54:0x0153, B:57:0x0172, B:60:0x0178, B:62:0x017e, B:147:0x0151), top: B:51:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v29, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.apm.lite.a.a] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r9v11, types: [com.apm.lite.e.c] */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.apm.lite.e.c] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Throwable m583a(Thread thread, Throwable th) {
        boolean z;
        boolean z2;
        boolean z3;
        CrashType crashType;
        boolean z4;
        boolean z5;
        Throwable th2;
        Thread thread2;
        boolean z6;
        boolean z7;
        long j;
        int i;
        long j2;
        int i2;
        File file;
        String str;
        String str2;
        String str3;
        long j3;
        ?? m589b;
        String str4;
        Throwable th3;
        Thread thread3;
        long j4;
        int i3;
        InterfaceC0752c interfaceC0752c;
        boolean z8;
        if (this.f445e >= 3 && !C0795r.m896a(65536)) {
            return null;
        }
        if (this.f450l.remove(thread) == th) {
            C0794q.m887a((Object) "Jump this uncaught exception.");
            m595d(thread, th);
            return null;
        }
        this.f450l.put(thread, th);
        this.f445e++;
        this.f446f++;
        if (f439i) {
            f440j.set(true);
        }
        f439i = true;
        long currentTimeMillis = System.currentTimeMillis();
        boolean m588b = m588b(currentTimeMillis);
        try {
            z = C0799v.m938c(th);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            try {
            } catch (Throwable unused2) {
                z2 = z;
                z3 = false;
                if (m588b) {
                }
                String m554a = C0749e.m554a(currentTimeMillis, crashType, z2, false);
                File file2 = new File(C0792o.m846a(C0749e.m565g()), m554a);
                File file3 = new File(file2, "logEventStack");
                File file4 = file3;
                boolean z9 = z2;
                boolean z10 = z2;
                String str5 = m554a;
                z4 = false;
                String m582a = m582a(file3, z9, th, str5, thread, z3);
                if ((m580a(th, thread) & 1) == 0) {
                }
                file = file2;
                z6 = true;
                if (C0746b.m505a(th, thread, file) != null) {
                }
                String str6 = m588b;
                String m554a2 = C0749e.m554a(currentTimeMillis, str6 == null ? CrashType.LAUNCH : CrashType.JAVA, z10, true);
                File file5 = new File(C0792o.m846a(C0749e.m565g()), m554a2);
                file.renameTo(file5);
                file4 = new File(file5, "logEventStack");
                str = m554a2;
                str5 = str6;
                C0783f.m771a();
                C0767b.m656a().m678b();
                z7 = m598g();
                if (z3) {
                }
                str2 = str5;
                str3 = str;
                j3 = str5;
                if (C0795r.m896a(1)) {
                }
                z5 = str2;
                if (!z5) {
                }
                C0794q.m887a((Object) ("[uncaughtException] isLaunchCrash=" + z5));
                ?? m378a = C0730a.m378a();
                ?? r3 = str3;
                m378a.m379a(r1, currentTimeMillis, r3);
                m589b = m589b(thread, th);
                if (m589b != 0) {
                }
                j = currentTimeMillis;
                i = 1;
                if (m589b != 0) {
                }
                th3 = th;
                thread3 = thread;
                i3 = 1;
                j4 = j;
                if (z6) {
                }
            }
            if (C0799v.m939d(th)) {
                z8 = true;
                z2 = z;
                z3 = z8;
                if (m588b) {
                    try {
                        crashType = CrashType.LAUNCH;
                    } catch (Throwable th4) {
                        th = th4;
                        z6 = false;
                        z7 = false;
                        z5 = m588b;
                        j = currentTimeMillis;
                        i = 1;
                        th2 = th;
                        thread2 = thread;
                        i2 = i;
                        j2 = j;
                        try {
                            if (!C0799v.m938c(th)) {
                            }
                            if (z6) {
                            }
                        } catch (Throwable th5) {
                            if (z6) {
                                synchronized (this) {
                                    this.f446f -= i2;
                                    this.f445e -= i2;
                                    return m586b(th2, thread2);
                                }
                            }
                            if (z3 && !z7) {
                                try {
                                    m584a(thread, th, z5, j2);
                                } catch (Throwable unused3) {
                                    throw th5;
                                }
                            }
                            m597f();
                            m596e();
                            m591c(thread, th);
                            throw th5;
                        }
                    }
                } else {
                    try {
                        crashType = CrashType.JAVA;
                    } catch (Throwable th6) {
                        th = th6;
                        z4 = false;
                        z5 = m588b;
                        long j5 = currentTimeMillis;
                        int i4 = 1;
                        th2 = th;
                        thread2 = thread;
                        z6 = z4;
                        z7 = z6;
                        i2 = i4;
                        j2 = j5;
                        if (!C0799v.m938c(th)) {
                        }
                        if (z6) {
                        }
                    }
                }
                String m554a3 = C0749e.m554a(currentTimeMillis, crashType, z2, false);
                File file22 = new File(C0792o.m846a(C0749e.m565g()), m554a3);
                File file32 = new File(file22, "logEventStack");
                File file42 = file32;
                boolean z92 = z2;
                boolean z102 = z2;
                String str52 = m554a3;
                z4 = false;
                String m582a2 = m582a(file32, z92, th, str52, thread, z3);
                if ((m580a(th, thread) & 1) == 0) {
                    if (m582a2 != null) {
                        try {
                        } catch (Throwable th7) {
                            th = th7;
                            j2 = currentTimeMillis;
                            i2 = 1;
                            th2 = th;
                            thread2 = thread;
                            z6 = false;
                            z7 = false;
                            z5 = m588b;
                            if (!C0799v.m938c(th)) {
                            }
                            if (z6) {
                            }
                        }
                    }
                    file = file22;
                    z6 = false;
                    if (!(C0746b.m505a(th, thread, file) != null) || z6) {
                        String str62 = m588b;
                        String m554a22 = C0749e.m554a(currentTimeMillis, str62 == null ? CrashType.LAUNCH : CrashType.JAVA, z102, true);
                        File file52 = new File(C0792o.m846a(C0749e.m565g()), m554a22);
                        file.renameTo(file52);
                        file42 = new File(file52, "logEventStack");
                        str = m554a22;
                        str52 = str62;
                    } else {
                        str = m554a3;
                        str52 = m588b;
                    }
                    C0783f.m771a();
                    C0767b.m656a().m678b();
                    z7 = m598g();
                    if (z3 || !z7) {
                        str2 = str52;
                        str3 = str;
                        j3 = str52;
                    } else {
                        boolean z11 = str52;
                        str2 = str52;
                        str3 = str;
                        long j6 = currentTimeMillis;
                        try {
                            m584a(thread, th, z11, j6);
                            j3 = j6;
                        } catch (Throwable th8) {
                            th = th8;
                            j2 = currentTimeMillis;
                            i2 = 1;
                            th2 = th;
                            thread2 = thread;
                            z5 = str2;
                            if (!C0799v.m938c(th)) {
                            }
                            if (z6) {
                            }
                        }
                    }
                    if (C0795r.m896a(1)) {
                        this.f448h.clear();
                    }
                    z5 = str2;
                    CrashType crashType2 = !z5 ? CrashType.LAUNCH : CrashType.JAVA;
                    C0794q.m887a((Object) ("[uncaughtException] isLaunchCrash=" + z5));
                    ?? m378a2 = C0730a.m378a();
                    ?? r32 = str3;
                    m378a2.m379a(crashType2, currentTimeMillis, r32);
                    m589b = m589b(thread, th);
                    if (m589b != 0 || (interfaceC0752c = this.f443c) == null || !z5 || !interfaceC0752c.mo609a(th)) {
                        j = currentTimeMillis;
                        i = 1;
                        if (m589b != 0) {
                            try {
                                InterfaceC0752c interfaceC0752c2 = this.f444d;
                                if (interfaceC0752c2 != null && interfaceC0752c2.mo609a(th)) {
                                    m589b = th;
                                    r32 = thread;
                                    this.f444d.mo608a(j, thread, th, r32, file42, m582a2, z6);
                                    str4 = "[uncaughtException] mLaunchCrashDisposer " + th.toString();
                                    m378a2 = 1;
                                    j3 = j;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                th2 = th;
                                thread2 = thread;
                                i2 = i;
                                j2 = j;
                                if (!C0799v.m938c(th)) {
                                    C0794q.m892a(th);
                                }
                                if (z6) {
                                    synchronized (this) {
                                        this.f446f -= i2;
                                        this.f445e -= i2;
                                    }
                                    return m586b(th2, thread2);
                                }
                                if (z3 && !z7) {
                                    m584a(thread, th, z5, j2);
                                }
                                m597f();
                                m596e();
                                m591c(thread, th);
                                return null;
                            }
                        }
                        th3 = th;
                        thread3 = thread;
                        i3 = 1;
                        j4 = j;
                        if (z6) {
                            Throwable th10 = th3;
                            Thread thread4 = thread3;
                            synchronized (this) {
                                this.f446f -= i3;
                                this.f445e -= i3;
                            }
                            return m586b(th10, thread4);
                        }
                        if (z3 && !z7) {
                            m584a(thread, th, z5, j4);
                        }
                        m597f();
                        m596e();
                        m591c(thread, th);
                        return null;
                    }
                    j3 = currentTimeMillis;
                    m378a2 = 1;
                    m589b = th;
                    r32 = thread;
                    this.f443c.mo608a(currentTimeMillis, thread, th, r32, file42, m582a2, z6);
                    str4 = "[uncaughtException] mLaunchCrashDisposer " + th.toString();
                    C0794q.m887a((Object) str4);
                    th3 = m589b;
                    i3 = m378a2;
                    thread3 = r32;
                    j4 = j3;
                    if (z6) {
                    }
                }
                file = file22;
                z6 = true;
                if (C0746b.m505a(th, thread, file) != null) {
                }
                String str622 = m588b;
                String m554a222 = C0749e.m554a(currentTimeMillis, str622 == null ? CrashType.LAUNCH : CrashType.JAVA, z102, true);
                File file522 = new File(C0792o.m846a(C0749e.m565g()), m554a222);
                file.renameTo(file522);
                file42 = new File(file522, "logEventStack");
                str = m554a222;
                str52 = str622;
                C0783f.m771a();
                C0767b.m656a().m678b();
                z7 = m598g();
                if (z3) {
                }
                str2 = str52;
                str3 = str;
                j3 = str52;
                if (C0795r.m896a(1)) {
                }
                z5 = str2;
                if (!z5) {
                }
                C0794q.m887a((Object) ("[uncaughtException] isLaunchCrash=" + z5));
                ?? m378a22 = C0730a.m378a();
                ?? r322 = str3;
                m378a22.m379a(crashType2, currentTimeMillis, r322);
                m589b = m589b(thread, th);
                if (m589b != 0) {
                }
                j = currentTimeMillis;
                i = 1;
                if (m589b != 0) {
                }
                th3 = th;
                thread3 = thread;
                i3 = 1;
                j4 = j;
                if (z6) {
                }
            }
        }
        z8 = false;
        z2 = z;
        z3 = z8;
        if (m588b) {
        }
        String m554a32 = C0749e.m554a(currentTimeMillis, crashType, z2, false);
        File file222 = new File(C0792o.m846a(C0749e.m565g()), m554a32);
        File file322 = new File(file222, "logEventStack");
        File file422 = file322;
        boolean z922 = z2;
        boolean z1022 = z2;
        String str522 = m554a32;
        z4 = false;
        String m582a22 = m582a(file322, z922, th, str522, thread, z3);
        if ((m580a(th, thread) & 1) == 0) {
        }
        file = file222;
        z6 = true;
        if (C0746b.m505a(th, thread, file) != null) {
        }
        String str6222 = m588b;
        String m554a2222 = C0749e.m554a(currentTimeMillis, str6222 == null ? CrashType.LAUNCH : CrashType.JAVA, z1022, true);
        File file5222 = new File(C0792o.m846a(C0749e.m565g()), m554a2222);
        file.renameTo(file5222);
        file422 = new File(file5222, "logEventStack");
        str = m554a2222;
        str522 = str6222;
        C0783f.m771a();
        C0767b.m656a().m678b();
        z7 = m598g();
        if (z3) {
        }
        str2 = str522;
        str3 = str;
        j3 = str522;
        if (C0795r.m896a(1)) {
        }
        z5 = str2;
        if (!z5) {
        }
        C0794q.m887a((Object) ("[uncaughtException] isLaunchCrash=" + z5));
        ?? m378a222 = C0730a.m378a();
        ?? r3222 = str3;
        m378a222.m379a(crashType2, currentTimeMillis, r3222);
        m589b = m589b(thread, th);
        if (m589b != 0) {
        }
        j = currentTimeMillis;
        i = 1;
        if (m589b != 0) {
        }
        th3 = th;
        thread3 = thread;
        i3 = 1;
        j4 = j;
        if (z6) {
        }
    }

    /* renamed from: a */
    private void m584a(Thread thread, Throwable th, boolean z, long j) {
        List<IOOMCallback> m1110a = C0831l.m1159a().m1110a();
        CrashType crashType = z ? CrashType.LAUNCH : CrashType.JAVA;
        Iterator<IOOMCallback> it = m1110a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(crashType, th, thread, j);
            } catch (Throwable th2) {
                C0794q.m893b(th2);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m585b(C0750a c0750a) {
        int i = c0750a.f451m;
        c0750a.f451m = i + 1;
        return i;
    }

    /* renamed from: b */
    private static Throwable m586b(Throwable th, Thread thread) {
        for (int i = 0; i < f441o.size(); i++) {
            try {
                try {
                    f441o.get(i).m607b(th, thread);
                } catch (Throwable th2) {
                    return th2;
                }
            } catch (Throwable unused) {
            }
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        try {
            Looper.loop();
            return null;
        } catch (Throwable th3) {
            return th3;
        }
    }

    /* renamed from: b */
    public static boolean m587b() {
        return f439i;
    }

    /* renamed from: b */
    public static boolean m588b(long j) {
        return C0754e.m615a(j);
    }

    /* renamed from: b */
    private boolean m589b(Thread thread, Throwable th) {
        ICrashFilter m376b = C0749e.m558b().m376b();
        if (m376b == null) {
            return true;
        }
        try {
            return m376b.onJavaCrashFilter(th, thread);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: c */
    private void m591c(Thread thread, Throwable th) {
        if (C0795r.m896a(512)) {
            return;
        }
        m595d(thread, th);
    }

    /* renamed from: c */
    public static boolean m592c() {
        Boolean bool = f440j.get();
        return bool != null && bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m594d() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            if (defaultUncaughtExceptionHandler != null) {
                C0794q.m887a((Object) ("Put this uncaught exception handler to stack. " + defaultUncaughtExceptionHandler.getClass().getName()));
                this.f449k.push(defaultUncaughtExceptionHandler);
            }
            this.f442b = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    /* renamed from: d */
    private void m595d(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler pop;
        try {
            if (!this.f449k.isEmpty() && (pop = this.f449k.pop()) != null) {
                this.f442b = pop;
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f442b;
            if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this) {
                C0794q.m887a((Object) "mDefaultHandler != null, call mDefaultHandler.");
                this.f442b.uncaughtException(thread, th);
                return;
            }
        } catch (Throwable unused) {
        }
        C0794q.m887a((Object) "Uncaught exception handler null, kill process.");
        Process.killProcess(Process.myPid());
    }

    /* renamed from: e */
    private void m596e() {
        synchronized (this) {
            this.f446f--;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        while (this.f446f != 0 && SystemClock.uptimeMillis() - uptimeMillis < 10000) {
            SystemClock.sleep(50L);
        }
    }

    /* renamed from: f */
    private void m597f() {
        File m846a = C0792o.m846a(C0749e.m565g());
        File m845a = C0792o.m845a();
        if (C0786i.m802b(m846a) && C0786i.m802b(m845a)) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        while (!RunnableC0773h.m715a() && SystemClock.uptimeMillis() - uptimeMillis < 10000) {
            try {
                SystemClock.sleep(500L);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: g */
    private boolean m598g() {
        return C0810a.m1015a("exception_modules", "oom_callback") == 1;
    }

    /* renamed from: a */
    public void m599a(long j) {
        C0832m.m1190b().m1241b(this.f452n);
        C0832m.m1190b().m1239a(this.f452n, j);
    }

    /* renamed from: a */
    public void m600a(InterfaceC0752c interfaceC0752c) {
        this.f443c = interfaceC0752c;
    }

    /* renamed from: a */
    public void m601a(String str) {
        this.f447g.put(str, new Object());
    }

    /* renamed from: a */
    public void m602a(Thread thread, Throwable th, boolean z, C0745a c0745a) {
        List<ICrashCallback> m1116c;
        CrashType crashType;
        if (z) {
            m1116c = C0831l.m1159a().m1113b();
            crashType = CrashType.LAUNCH;
        } else {
            m1116c = C0831l.m1159a().m1116c();
            crashType = CrashType.JAVA;
        }
        for (ICrashCallback iCrashCallback : m1116c) {
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                iCrashCallback.onCrash(crashType, C0799v.m917a(th), thread);
                c0745a.m486b("callback_cost_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            } catch (Throwable th2) {
                C0794q.m893b(th2);
                c0745a.m486b("callback_err_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    /* renamed from: b */
    public void m603b(InterfaceC0752c interfaceC0752c) {
        this.f444d = interfaceC0752c;
    }

    /* renamed from: b */
    public boolean m604b(String str) {
        return this.f447g.containsKey(str);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        do {
            th = m583a(thread, th);
        } while (th != null);
    }
}
