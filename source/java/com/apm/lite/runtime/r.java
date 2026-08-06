package com.apm.lite.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.crash.constants.Constants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class r {
    static final b<d, Runnable> a = new b<d, Runnable>() { // from class: com.apm.lite.runtime.r.1
        @Override // com.apm.lite.runtime.r.b
        public boolean a(d dVar, Runnable runnable) {
            return runnable == null ? dVar == null || dVar.a == null || dVar.a.getCallback() == null : (dVar == null || dVar.a == null || !runnable.equals(dVar.a.getCallback())) ? false : true;
        }
    };
    static final b<Message, Runnable> b = new b<Message, Runnable>() { // from class: com.apm.lite.runtime.r.2
        @Override // com.apm.lite.runtime.r.b
        public boolean a(Message message, Runnable runnable) {
            return runnable == null ? message == null || message.getCallback() == null : message != null && runnable.equals(message.getCallback());
        }
    };
    private final HandlerThread c;
    private volatile Handler f;
    private final Queue<d> d = new ConcurrentLinkedQueue();
    private final Queue<Message> e = new ConcurrentLinkedQueue();
    private final Object g = new Object();

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        void a() {
            while (!r.this.d.isEmpty()) {
                d dVar = (d) r.this.d.poll();
                if (r.this.f != null) {
                    try {
                        r.this.f.sendMessageAtTime(dVar.a, dVar.b);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        void b() {
            while (!r.this.e.isEmpty()) {
                if (r.this.f != null) {
                    try {
                        r.this.f.sendMessageAtFrontOfQueue((Message) r.this.e.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            a();
        }
    }

    /* loaded from: classes2.dex */
    public interface b<A, B> {
        boolean a(A a, B b);
    }

    /* loaded from: classes2.dex */
    class c extends HandlerThread {
        volatile int a;
        volatile boolean b;

        c(String str) {
            super(str);
            this.a = 0;
            this.b = false;
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (r.this.g) {
                r.this.f = new Handler();
            }
            r.this.f.post(new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    try {
                        com.apm.lite.b.d.c();
                        if (this.a < 5) {
                            com.apm.lite.c.a();
                            com.apm.lite.c.a(Constants.NPTH_CATCH, th);
                        } else if (!this.b) {
                            this.b = true;
                            com.apm.lite.c.a();
                            com.apm.lite.c.a("NPTH_ERR_MAX", new RuntimeException());
                        }
                        this.a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d {
        Message a;
        long b;

        d(Message message, long j) {
            this.a = message;
            this.b = j;
        }
    }

    public r(String str) {
        this.c = new c(str);
    }

    public static <L, O> boolean a(Collection<L> collection, O o, b<? super L, O> bVar) {
        boolean z = false;
        if (collection != null && !collection.isEmpty() && bVar != null) {
            try {
                Iterator<L> it = collection.iterator();
                while (it.hasNext()) {
                    if (bVar.a(it.next(), o)) {
                        it.remove();
                        z = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    private Message c(Runnable runnable) {
        return Message.obtain(this.f, runnable);
    }

    public Handler a() {
        return this.f;
    }

    public final boolean a(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j);
    }

    public final boolean a(Runnable runnable) {
        return a(c(runnable), 0L);
    }

    public final boolean a(Runnable runnable, long j) {
        return a(c(runnable), j);
    }

    public void b() {
        this.c.start();
    }

    public final void b(Runnable runnable) {
        if (!this.d.isEmpty() || !this.e.isEmpty()) {
            a(this.d, runnable, a);
            a(this.e, runnable, b);
        }
        if (this.f != null) {
            this.f.removeCallbacks(runnable);
        }
    }

    public final boolean b(Message message, long j) {
        if (this.f == null) {
            synchronized (this.g) {
                if (this.f == null) {
                    this.d.add(new d(message, j));
                    return true;
                }
            }
        }
        try {
            return this.f.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    public HandlerThread c() {
        return this.c;
    }
}
