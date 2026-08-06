package com.apm.lite.nativecrash;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.Npth;
import com.apm.lite.p011a.C0730a;
import com.apm.lite.p012b.C0735d;
import com.apm.lite.p012b.C0737f;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p022j.C0767b;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.runtime.C0810a;
import com.apm.lite.runtime.C0826g;
import com.apm.lite.runtime.C0831l;
import com.apm.lite.runtime.p024a.AbstractC0813c;
import com.apm.lite.runtime.p024a.C0815e;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.nativecrash.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0804b {
    /* renamed from: a */
    public static int m955a() {
        return 6;
    }

    /* renamed from: a */
    public static void m956a(final String str) {
        String m1012c;
        final long currentTimeMillis = System.currentTimeMillis();
        C0794q.m887a((Object) "[onNativeCrash] enter");
        try {
            try {
                C0767b.m656a().m678b();
                final File file = new File(C0792o.m845a(), C0749e.m564f());
                final File m863e = C0792o.m863e(file);
                C0745a m1105a = C0815e.m1103a().m1105a(CrashType.NATIVE, null, new AbstractC0813c.a() { // from class: com.apm.lite.nativecrash.b.1
                    @Override // com.apm.lite.runtime.p024a.AbstractC0813c.a
                    /* renamed from: a */
                    public C0745a mo612a(int i, C0745a c0745a) {
                        String str2;
                        String str3;
                        str2 = "true";
                        if (i != 1) {
                            if (i == 2) {
                                JSONArray m427a = C0735d.m427a();
                                long uptimeMillis = SystemClock.uptimeMillis();
                                JSONObject m428a = C0735d.m428a(uptimeMillis);
                                JSONArray m434a = C0737f.m434a(100, uptimeMillis);
                                c0745a.m484a("history_message", (Object) m427a);
                                c0745a.m484a("current_message", m428a);
                                c0745a.m484a("pending_messages", (Object) m434a);
                                c0745a.m479a("disable_looper_monitor", String.valueOf(C0810a.m1025d()));
                            } else if (i != 3) {
                                if (i == 4) {
                                    C0778a.m739a(C0749e.m565g(), c0745a.m498h());
                                    C0826g.m1142a(C0792o.m876k(C0749e.m565g()), CrashType.NATIVE, "");
                                }
                            } else if (C0810a.m1026e()) {
                                c0745a.m484a("all_thread_stacks", C0799v.m933b(str));
                                str3 = "has_all_thread_stack";
                            }
                            return c0745a;
                        }
                        C0746b.m507a(file, CrashType.NATIVE);
                        String str4 = str;
                        if (str4 != null && str4.length() != 0) {
                            c0745a.m484a("java_data", (Object) C0804b.m959c(str));
                        }
                        str2 = Npth.hasCrashWhenNativeCrash() ? "true" : "false";
                        str3 = "crash_after_crash";
                        c0745a.m479a(str3, str2);
                        return c0745a;
                    }

                    @Override // com.apm.lite.runtime.p024a.AbstractC0813c.a
                    /* renamed from: a */
                    public C0745a mo613a(int i, C0745a c0745a, boolean z) {
                        try {
                            JSONObject m498h = c0745a.m498h();
                            if (m498h.length() > 0) {
                                C0786i.m791a(new File(m863e.getAbsolutePath() + '.' + i), m498h, false);
                            }
                        } catch (IOException e) {
                            C0738c.m435a();
                            C0738c.m436a("NPTH_CATCH", e);
                        }
                        if (i == 0) {
                            C0730a.m378a().m381b();
                            C0730a.m378a().m379a(CrashType.NATIVE, currentTimeMillis, C0749e.m564f());
                        }
                        return c0745a;
                    }

                    @Override // com.apm.lite.runtime.p024a.AbstractC0813c.a
                    /* renamed from: a */
                    public void mo614a(Throwable th) {
                    }
                }, true);
                JSONObject m498h = m1105a.m498h();
                if (m498h != null && m498h.length() != 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long j = currentTimeMillis2 - currentTimeMillis;
                    try {
                        m498h.put("java_end", currentTimeMillis2);
                        m1105a.m486b("crash_cost", String.valueOf(j));
                        m1105a.m479a("crash_cost", String.valueOf(j / 1000));
                    } catch (Throwable unused) {
                    }
                    File file2 = new File(m863e.getAbsolutePath() + ".tmp");
                    C0786i.m791a(file2, m498h, false);
                    file2.renameTo(m863e);
                }
            } catch (Throwable unused2) {
                m957a("", null);
                return;
            }
        } catch (Throwable th) {
            try {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
                if (C0831l.m1159a().m1117d().isEmpty()) {
                    return;
                }
                File file3 = new File(C0792o.m845a(), C0749e.m564f());
                C0807e c0807e = new C0807e(file3);
                c0807e.m1011b(file3);
                m1012c = c0807e.m1012c();
            } catch (Throwable th2) {
                try {
                    if (!C0831l.m1159a().m1117d().isEmpty()) {
                        File file4 = new File(C0792o.m845a(), C0749e.m564f());
                        C0807e c0807e2 = new C0807e(file4);
                        c0807e2.m1011b(file4);
                        m957a(c0807e2.m1012c(), null);
                    }
                } catch (Throwable unused3) {
                    m957a("", null);
                }
                throw th2;
            }
        }
        if (C0831l.m1159a().m1117d().isEmpty()) {
            return;
        }
        File file5 = new File(C0792o.m845a(), C0749e.m564f());
        C0807e c0807e3 = new C0807e(file5);
        c0807e3.m1011b(file5);
        m1012c = c0807e3.m1012c();
        m957a(m1012c, null);
    }

    /* renamed from: a */
    private static void m957a(String str, Thread thread) {
        Iterator<ICrashCallback> it = C0831l.m1159a().m1117d().iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(CrashType.NATIVE, str, thread);
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static String m959c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("main".equalsIgnoreCase(str)) {
            return C0799v.m920a(Looper.getMainLooper().getThread().getStackTrace());
        }
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        int activeCount = threadGroup.activeCount();
        Thread[] threadArr = new Thread[activeCount + (activeCount / 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        for (int i = 0; i < enumerate; i++) {
            String name = threadArr[i].getName();
            if (!TextUtils.isEmpty(name) && (name.equals(str) || name.startsWith(str) || name.endsWith(str))) {
                return C0799v.m920a(threadArr[i].getStackTrace());
            }
        }
        try {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                String name2 = entry.getKey().getName();
                if (name2.equals(str) || name2.startsWith(str) || name2.endsWith(str)) {
                    return C0799v.m920a(entry.getValue());
                }
            }
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
        return "";
    }
}
