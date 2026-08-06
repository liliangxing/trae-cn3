package com.apm.lite.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.apm.lite.C0738c;
import com.apm.lite.p012b.C0735d;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.apm.lite.runtime.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0837r {

    /* renamed from: a */
    static final b<d, Runnable> f746a = new b<d, Runnable>() { // from class: com.apm.lite.runtime.r.1
        @Override // com.apm.lite.runtime.C0837r.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo1244a(d dVar, Runnable runnable) {
            return runnable == null ? dVar == null || dVar.f757a == null || dVar.f757a.getCallback() == null : (dVar == null || dVar.f757a == null || !runnable.equals(dVar.f757a.getCallback())) ? false : true;
        }
    };

    /* renamed from: b */
    static final b<Message, Runnable> f747b = new b<Message, Runnable>() { // from class: com.apm.lite.runtime.r.2
        @Override // com.apm.lite.runtime.C0837r.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo1244a(Message message, Runnable runnable) {
            return runnable == null ? message == null || message.getCallback() == null : message != null && runnable.equals(message.getCallback());
        }
    };

    /* renamed from: c */
    private final HandlerThread f748c;

    /* renamed from: f */
    private volatile Handler f751f;

    /* renamed from: d */
    private final Queue<d> f749d = new ConcurrentLinkedQueue();

    /* renamed from: e */
    private final Queue<Message> f750e = new ConcurrentLinkedQueue();

    /* renamed from: g */
    private final Object f752g = new Object();

    /* renamed from: com.apm.lite.runtime.r$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    class a implements Runnable {
        a() {
        }

        /* renamed from: a */
        void m1245a() {
            while (!C0837r.this.f749d.isEmpty()) {
                d dVar = (d) C0837r.this.f749d.poll();
                if (C0837r.this.f751f != null) {
                    try {
                        C0837r.this.f751f.sendMessageAtTime(dVar.f757a, dVar.f758b);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        /* renamed from: b */
        void m1246b() {
            while (!C0837r.this.f750e.isEmpty()) {
                if (C0837r.this.f751f != null) {
                    try {
                        C0837r.this.f751f.sendMessageAtFrontOfQueue((Message) C0837r.this.f750e.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            m1246b();
            m1245a();
        }
    }

    /* renamed from: com.apm.lite.runtime.r$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface b<A, B> {
        /* renamed from: a */
        boolean mo1244a(A a, B b);
    }

    /* renamed from: com.apm.lite.runtime.r$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    class c extends HandlerThread {

        /* renamed from: a */
        volatile int f754a;

        /* renamed from: b */
        volatile boolean f755b;

        c(String str) {
            super(str);
            this.f754a = 0;
            this.f755b = false;
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (C0837r.this.f752g) {
                C0837r.this.f751f = new Handler();
            }
            C0837r.this.f751f.post(new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    try {
                        C0735d.m429c();
                        if (this.f754a < 5) {
                            C0738c.m435a();
                            C0738c.m436a("NPTH_CATCH", th);
                        } else if (!this.f755b) {
                            this.f755b = true;
                            C0738c.m435a();
                            C0738c.m436a("NPTH_ERR_MAX", new RuntimeException());
                        }
                        this.f754a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.lite.runtime.r$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class d {

        /* renamed from: a */
        Message f757a;

        /* renamed from: b */
        long f758b;

        d(Message message, long j) {
            this.f757a = message;
            this.f758b = j;
        }
    }

    public C0837r(String str) {
        this.f748c = new c(str);
    }

    /* renamed from: a */
    public static <L, O> boolean m1231a(Collection<L> collection, O o, b<? super L, O> bVar) {
        boolean z = false;
        if (collection != null && !collection.isEmpty() && bVar != null) {
            try {
                Iterator<L> it = collection.iterator();
                while (it.hasNext()) {
                    if (bVar.mo1244a(it.next(), o)) {
                        it.remove();
                        z = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    /* renamed from: c */
    private Message m1233c(Runnable runnable) {
        return Message.obtain(this.f751f, runnable);
    }

    /* renamed from: a */
    public Handler m1236a() {
        return this.f751f;
    }

    /* renamed from: a */
    public final boolean m1237a(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return m1242b(message, SystemClock.uptimeMillis() + j);
    }

    /* renamed from: a */
    public final boolean m1238a(Runnable runnable) {
        return m1237a(m1233c(runnable), 0L);
    }

    /* renamed from: a */
    public final boolean m1239a(Runnable runnable, long j) {
        return m1237a(m1233c(runnable), j);
    }

    /* renamed from: b */
    public void m1240b() {
        this.f748c.start();
    }

    /* renamed from: b */
    public final void m1241b(Runnable runnable) {
        if (!this.f749d.isEmpty() || !this.f750e.isEmpty()) {
            m1231a(this.f749d, runnable, f746a);
            m1231a(this.f750e, runnable, f747b);
        }
        if (this.f751f != null) {
            this.f751f.removeCallbacks(runnable);
        }
    }

    /* renamed from: b */
    public final boolean m1242b(Message message, long j) {
        if (this.f751f == null) {
            synchronized (this.f752g) {
                if (this.f751f == null) {
                    this.f749d.add(new d(message, j));
                    return true;
                }
            }
        }
        try {
            return this.f751f.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: c */
    public HandlerThread m1243c() {
        return this.f748c;
    }
}
