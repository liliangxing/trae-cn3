package com.xiaomi.push.service;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.xiaomi.push.service.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1785n {

    /* renamed from: a */
    private static long f3167a;

    /* renamed from: b */
    private static long f3168b;

    /* renamed from: c */
    private static long f3169c;

    /* renamed from: a */
    private final a f3170a;

    /* renamed from: a */
    private final c f3171a;

    /* renamed from: com.xiaomi.push.service.n$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class b implements Runnable {

        /* renamed from: a */
        protected int f3173a;

        public b(int i) {
            this.f3173a = i;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f3167a = elapsedRealtime;
        f3168b = elapsedRealtime;
    }

    /* renamed from: a */
    static synchronized long m3912a() {
        long j;
        synchronized (C1785n.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = f3168b;
            if (elapsedRealtime > j2) {
                f3167a += elapsedRealtime - j2;
            }
            f3168b = elapsedRealtime;
            j = f3167a;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.n$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class d {

        /* renamed from: a */
        int f3184a;

        /* renamed from: a */
        long f3185a;

        /* renamed from: a */
        b f3186a;

        /* renamed from: a */
        final Object f3187a = new Object();

        /* renamed from: a */
        boolean f3188a;

        /* renamed from: b */
        private long f3189b;

        d() {
        }

        /* renamed from: a */
        void m3943a(long j) {
            synchronized (this.f3187a) {
                this.f3189b = j;
            }
        }

        /* renamed from: a */
        public boolean m3944a() {
            boolean z;
            synchronized (this.f3187a) {
                z = !this.f3188a && this.f3185a > 0;
                this.f3188a = true;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.n$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class c extends Thread {

        /* renamed from: b */
        private boolean f3178b;

        /* renamed from: c */
        private boolean f3179c;

        /* renamed from: a */
        private volatile long f3174a = 0;

        /* renamed from: a */
        private volatile boolean f3176a = false;

        /* renamed from: b */
        private long f3177b = 50;

        /* renamed from: a */
        private a f3175a = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.xiaomi.push.service.n$c$a */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public static final class a {

            /* renamed from: a */
            private int f3180a;

            /* renamed from: a */
            private d[] f3181a;

            /* renamed from: b */
            private int f3182b;

            /* renamed from: c */
            private int f3183c;

            private a() {
                this.f3180a = 256;
                this.f3181a = new d[256];
                this.f3182b = 0;
                this.f3183c = 0;
            }

            /* renamed from: a */
            public d m3934a() {
                return this.f3181a[0];
            }

            /* renamed from: a */
            public boolean m3939a() {
                return this.f3182b == 0;
            }

            /* renamed from: a */
            public void m3938a(d dVar) {
                d[] dVarArr = this.f3181a;
                int length = dVarArr.length;
                int i = this.f3182b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f3181a = dVarArr2;
                }
                d[] dVarArr3 = this.f3181a;
                int i2 = this.f3182b;
                this.f3182b = i2 + 1;
                dVarArr3[i2] = dVar;
                m3932c();
            }

            /* renamed from: a */
            public boolean m3940a(int i) {
                for (int i2 = 0; i2 < this.f3182b; i2++) {
                    if (this.f3181a[i2].f3184a == i) {
                        return true;
                    }
                }
                return false;
            }

            /* renamed from: a */
            public void m3936a(int i) {
                for (int i2 = 0; i2 < this.f3182b; i2++) {
                    if (this.f3181a[i2].f3184a == i) {
                        this.f3181a[i2].m3944a();
                    }
                }
                m3941b();
            }

            /* renamed from: a */
            public void m3937a(int i, b bVar) {
                for (int i2 = 0; i2 < this.f3182b; i2++) {
                    if (this.f3181a[i2].f3186a == bVar) {
                        this.f3181a[i2].m3944a();
                    }
                }
                m3941b();
            }

            /* renamed from: b */
            public void m3942b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.f3182b)) {
                    return;
                }
                d[] dVarArr = this.f3181a;
                int i3 = i2 - 1;
                this.f3182b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                m3933c(i);
            }

            /* renamed from: c */
            private void m3932c() {
                int i = this.f3182b - 1;
                int i2 = (i - 1) / 2;
                while (this.f3181a[i].f3185a < this.f3181a[i2].f3185a) {
                    d[] dVarArr = this.f3181a;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            /* renamed from: c */
            private void m3933c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.f3182b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3 && this.f3181a[i4].f3185a < this.f3181a[i2].f3185a) {
                        i2 = i4;
                    }
                    if (this.f3181a[i].f3185a < this.f3181a[i2].f3185a) {
                        return;
                    }
                    d[] dVarArr = this.f3181a;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            /* renamed from: a */
            public void m3935a() {
                this.f3181a = new d[this.f3180a];
                this.f3182b = 0;
            }

            /* renamed from: b */
            public void m3941b() {
                int i = 0;
                while (i < this.f3182b) {
                    if (this.f3181a[i].f3188a) {
                        this.f3183c++;
                        m3942b(i);
                        i--;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public int m3931a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f3181a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
        
            r10.f3174a = android.os.SystemClock.uptimeMillis();
            r10.f3176a = true;
            r2.f3186a.run();
            r10.f3176a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a4, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
        
            r10.f3178b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a8, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (this) {
                    if (this.f3178b) {
                        return;
                    }
                    if (this.f3175a.m3939a()) {
                        if (this.f3179c) {
                            return;
                        } else {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                            }
                        }
                    } else {
                        long m3912a = C1785n.m3912a();
                        d m3934a = this.f3175a.m3934a();
                        synchronized (m3934a.f3187a) {
                            if (m3934a.f3188a) {
                                this.f3175a.m3942b(0);
                            } else {
                                long j = m3934a.f3185a - m3912a;
                                if (j > 0) {
                                    long j2 = this.f3177b;
                                    if (j > j2) {
                                        j = j2;
                                    }
                                    long j3 = j2 + 50;
                                    this.f3177b = j3;
                                    if (j3 > 500) {
                                        this.f3177b = 500L;
                                    }
                                    try {
                                        wait(j);
                                    } catch (InterruptedException unused2) {
                                    }
                                } else {
                                    this.f3177b = 50L;
                                    synchronized (m3934a.f3187a) {
                                        int m3931a = this.f3175a.m3934a().f3185a != m3934a.f3185a ? this.f3175a.m3931a(m3934a) : 0;
                                        if (m3934a.f3188a) {
                                            a aVar = this.f3175a;
                                            aVar.m3942b(aVar.m3931a(m3934a));
                                        } else {
                                            m3934a.m3943a(m3934a.f3185a);
                                            this.f3175a.m3942b(m3931a);
                                            m3934a.f3185a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3925a(d dVar) {
            this.f3175a.m3938a(dVar);
            notify();
        }

        /* renamed from: a */
        public synchronized void m3928a() {
            this.f3178b = true;
            this.f3175a.m3935a();
            notify();
        }

        /* renamed from: a */
        public boolean m3929a() {
            return this.f3176a && SystemClock.uptimeMillis() - this.f3174a > 600000;
        }
    }

    /* renamed from: com.xiaomi.push.service.n$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static final class a {

        /* renamed from: a */
        private final c f3172a;

        a(c cVar) {
            this.f3172a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.f3172a) {
                    this.f3172a.f3179c = true;
                    this.f3172a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: b */
    private static synchronized long m3913b() {
        long j;
        synchronized (C1785n.class) {
            j = f3169c;
            f3169c = 1 + j;
        }
        return j;
    }

    public C1785n(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f3171a = cVar;
        this.f3170a = new a(cVar);
    }

    public C1785n(String str) {
        this(str, false);
    }

    public C1785n(boolean z) {
        this("Timer-" + m3913b(), z);
    }

    public C1785n() {
        this(false);
    }

    /* renamed from: a */
    public void m3915a() {
        AbstractC1417b.m1089a("quit. finalizer:" + this.f3170a);
        this.f3171a.m3928a();
    }

    /* renamed from: a */
    public boolean m3921a(int i) {
        boolean m3940a;
        synchronized (this.f3171a) {
            m3940a = this.f3171a.f3175a.m3940a(i);
        }
        return m3940a;
    }

    /* renamed from: a */
    public void m3916a(int i) {
        synchronized (this.f3171a) {
            this.f3171a.f3175a.m3936a(i);
        }
    }

    /* renamed from: b */
    public void m3922b() {
        synchronized (this.f3171a) {
            this.f3171a.f3175a.m3935a();
        }
    }

    /* renamed from: a */
    public void m3917a(int i, b bVar) {
        synchronized (this.f3171a) {
            this.f3171a.f3175a.m3937a(i, bVar);
        }
    }

    /* renamed from: a */
    public boolean m3920a() {
        return this.f3171a.m3929a();
    }

    /* renamed from: a */
    public void m3918a(b bVar) {
        if (AbstractC1417b.m1076a() < 1 && Thread.currentThread() != this.f3171a) {
            AbstractC1417b.m1103d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    /* renamed from: a */
    public void m3919a(b bVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("delay < 0: " + j);
        }
        m3914b(bVar, j);
    }

    /* renamed from: b */
    private void m3914b(b bVar, long j) {
        synchronized (this.f3171a) {
            if (this.f3171a.f3178b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long m3912a = j + m3912a();
            if (m3912a < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + m3912a);
            }
            d dVar = new d();
            dVar.f3184a = bVar.f3173a;
            dVar.f3186a = bVar;
            dVar.f3185a = m3912a;
            this.f3171a.m3925a(dVar);
        }
    }
}
