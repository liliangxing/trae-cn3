package com.bytedance.tobshadow.bdtracker;

import android.os.Process;
import com.bytedance.tobshadow.applog.exception.AppCrashType;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.C0453k;
import java.lang.Thread;
import java.util.Collections;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.v0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0531v0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: b */
    public static volatile C0531v0 f1109b;

    /* renamed from: a */
    public final Thread.UncaughtExceptionHandler f1110a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: com.bytedance.tobshadow.bdtracker.v0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements C0453k.e {
        public a(C0531v0 c0531v0) {
        }

        @Override // com.bytedance.tobshadow.bdtracker.C0453k.e
        /* renamed from: a */
        public boolean mo248a(C0467m c0467m) {
            return c0467m.getInitConfig() != null && AppCrashType.hasJavaCrashType(c0467m.getInitConfig().getTrackCrashType());
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.v0$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class b implements C0453k.d {

        /* renamed from: a */
        public final /* synthetic */ Throwable f1111a;

        /* renamed from: b */
        public final /* synthetic */ C0453k.e f1112b;

        /* renamed from: c */
        public final /* synthetic */ C0528u4 f1113c;

        public b(C0531v0 c0531v0, Throwable th, C0453k.e eVar, C0528u4 c0528u4) {
            this.f1111a = th;
            this.f1112b = eVar;
            this.f1113c = c0528u4;
        }

        @Override // com.bytedance.tobshadow.bdtracker.C0453k.d
        /* renamed from: a */
        public void mo499a(C0467m c0467m) {
            if (c0467m.getInitConfig() != null && c0467m.getInitConfig().isMonitorEnabled()) {
                C0547x2.m748b(c0467m.getMonitor(), this.f1111a);
            }
            if (this.f1112b.mo248a(c0467m)) {
                c0467m.receive(this.f1113c);
                c0467m.flush();
            }
        }
    }

    public C0531v0() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    public static synchronized void m716a() {
        synchronized (C0531v0.class) {
            if (f1109b == null) {
                f1109b = new C0531v0();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(this);
        if (!C0453k.m497a(aVar)) {
            C0453k.m493a(new C0538w0(this, th));
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1110a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            try {
                Process.killProcess(Process.myPid());
                System.exit(10);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$is_backstage", !C0389b0.f453b);
            jSONObject.put("$event_time", currentTimeMillis);
            jSONObject.put("$crash_thread", thread.getName());
            jSONObject.put("$crash_process", C0411e.m368b());
            StringBuilder sb = new StringBuilder();
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                sb.append(th2.toString());
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    sb.append("\n\tat ").append(stackTraceElement);
                }
            }
            jSONObject.put("$detailed_stack", sb.length() > 2000 ? sb.substring(0, 2000) : sb.toString());
        } catch (Throwable th3) {
            LoggerImpl.global().error(Collections.singletonList("ExceptionHandler"), "Collect crash params failed", th3, new Object[0]);
        }
        C0453k.m493a(new b(this, th, aVar, new C0528u4("$crash", jSONObject)));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f1110a;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th);
            return;
        }
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }
}
