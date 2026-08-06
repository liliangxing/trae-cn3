package com.apm.lite.p017e;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.Npth;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p012b.C0735d;
import com.apm.lite.p012b.C0737f;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0795r;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.runtime.C0810a;
import com.apm.lite.runtime.C0826g;
import com.apm.lite.runtime.C0829j;
import com.apm.lite.runtime.p024a.AbstractC0813c;
import com.apm.lite.runtime.p024a.C0812b;
import com.apm.lite.runtime.p024a.C0815e;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.e.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0753d implements InterfaceC0752c {

    /* renamed from: a */
    private Context f456a;

    public C0753d(Context context) {
        this.f456a = context;
    }

    /* renamed from: a */
    public static int m610a() {
        return 6;
    }

    @Override // com.apm.lite.p017e.InterfaceC0752c
    /* renamed from: a */
    public void mo608a(final long j, final Thread thread, final Throwable th, final String str, File file, final String str2, final boolean z) {
        final File file2 = new File(C0792o.m846a(this.f456a), str);
        C0750a.m581a().m601a(file2.getName());
        file2.mkdirs();
        C0786i.m810f(file2);
        final boolean m938c = C0799v.m938c(th);
        C0745a m1105a = C0815e.m1103a().m1105a(CrashType.JAVA, null, new AbstractC0813c.a() { // from class: com.apm.lite.e.d.1

            /* renamed from: a */
            long f457a = 0;

            @Override // com.apm.lite.runtime.p024a.AbstractC0813c.a
            /* renamed from: a */
            public C0745a mo612a(int i, C0745a c0745a) {
                String str3;
                String valueOf;
                this.f457a = SystemClock.uptimeMillis();
                if (i != 0) {
                    if (i == 1) {
                        Thread thread2 = thread;
                        c0745a.m484a("crash_thread_name", (Object) (thread2 != null ? thread2.getName() : ""));
                        c0745a.m484a("tid", Integer.valueOf(Process.myTid()));
                        c0745a.m479a("crash_after_crash", Npth.hasCrashWhenJavaCrash() ? "true" : "false");
                        c0745a.m479a("crash_after_native", NativeImpl.duringNativeCrash() ? "true" : "false");
                        C0750a.m581a().m602a(thread, th, false, c0745a);
                    } else if (i == 2) {
                        if (m938c) {
                            C0778a.m739a(C0753d.this.f456a, c0745a.m498h());
                        }
                        JSONArray m427a = C0735d.m427a();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        JSONObject m428a = C0735d.m428a(uptimeMillis);
                        JSONArray m434a = C0737f.m434a(100, uptimeMillis);
                        c0745a.m484a("history_message", (Object) m427a);
                        c0745a.m484a("current_message", m428a);
                        c0745a.m484a("pending_messages", (Object) m434a);
                        valueOf = String.valueOf(C0810a.m1025d());
                        str3 = "disable_looper_monitor";
                        c0745a.m479a(str3, valueOf);
                    } else if (i == 3) {
                        JSONObject m933b = C0799v.m933b(Thread.currentThread().getName());
                        if (m933b != null) {
                            c0745a.m484a("all_thread_stacks", m933b);
                        }
                        c0745a.m484a("logcat", (Object) C0829j.m1151b(C0749e.m564f()));
                    } else if (i != 4) {
                        if (i == 5) {
                            c0745a.m484a("crash_uuid", (Object) str);
                            C0826g.m1142a(C0792o.m876k(C0749e.m565g()), CrashType.JAVA, "");
                        }
                    } else if (!m938c) {
                        C0778a.m739a(C0753d.this.f456a, c0745a.m498h());
                    }
                } else {
                    c0745a.m484a(Constants.KEY_DATA, (Object) C0799v.m917a(th));
                    c0745a.m484a("isOOM", Boolean.valueOf(m938c));
                    c0745a.m484a("isJava", (Object) 1);
                    c0745a.m484a("crash_time", Long.valueOf(j));
                    c0745a.m484a("launch_mode", Integer.valueOf(C0812b.m1046b()));
                    c0745a.m484a("launch_time", Long.valueOf(C0812b.m1051c()));
                    String str4 = str2;
                    if (str4 != null) {
                        c0745a.m484a("crash_md5", (Object) str4);
                        c0745a.m479a("crash_md5", str2);
                        boolean z2 = z;
                        if (z2) {
                            str3 = "has_ignore";
                            valueOf = String.valueOf(z2);
                            c0745a.m479a(str3, valueOf);
                        }
                    }
                }
                return c0745a;
            }

            @Override // com.apm.lite.runtime.p024a.AbstractC0813c.a
            /* renamed from: a */
            public C0745a mo613a(int i, C0745a c0745a, boolean z2) {
                if (C0795r.m896a(C0795r.m897b(i))) {
                    return c0745a;
                }
                try {
                    C0786i.m791a(new File(file2, file2.getName() + "." + i), c0745a.m498h(), false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return c0745a;
            }

            @Override // com.apm.lite.runtime.p024a.AbstractC0813c.a
            /* renamed from: a */
            public void mo614a(Throwable th2) {
            }
        }, true);
        long currentTimeMillis = System.currentTimeMillis() - j;
        try {
            m1105a.m479a("crash_type", "normal");
            m1105a.m486b("crash_cost", String.valueOf(currentTimeMillis));
            m1105a.m479a("crash_cost", String.valueOf(currentTimeMillis / 1000));
        } catch (Throwable th2) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th2);
        }
        if (C0795r.m896a(4)) {
            return;
        }
        C0795r.m896a(2048);
    }

    @Override // com.apm.lite.p017e.InterfaceC0752c
    /* renamed from: a */
    public boolean mo609a(Throwable th) {
        return true;
    }
}
