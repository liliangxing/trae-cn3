package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes7.dex */
public class n {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a, reason: collision with other field name */
    private final a f1047a;

    /* renamed from: a, reason: collision with other field name */
    private final c f1048a;

    /* loaded from: classes7.dex */
    public static abstract class b implements Runnable {
        protected int a;

        public b(int i) {
            this.a = i;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        a = elapsedRealtime;
        b = elapsedRealtime;
    }

    static synchronized long a() {
        long j;
        synchronized (n.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = b;
            if (elapsedRealtime > j2) {
                a += elapsedRealtime - j2;
            }
            b = elapsedRealtime;
            j = a;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class d {
        int a;

        /* renamed from: a, reason: collision with other field name */
        long f1053a;

        /* renamed from: a, reason: collision with other field name */
        b f1054a;

        /* renamed from: a, reason: collision with other field name */
        final Object f1055a = new Object();

        /* renamed from: a, reason: collision with other field name */
        boolean f1056a;
        private long b;

        d() {
        }

        void a(long j) {
            synchronized (this.f1055a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1055a) {
                z = !this.f1056a && this.f1053a > 0;
                this.f1056a = true;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class c extends Thread {

        /* renamed from: b, reason: collision with other field name */
        private boolean f1051b;
        private boolean c;
        private volatile long a = 0;

        /* renamed from: a, reason: collision with other field name */
        private volatile boolean f1050a = false;
        private long b = 50;

        /* renamed from: a, reason: collision with other field name */
        private a f1049a = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public static final class a {
            private int a;

            /* renamed from: a, reason: collision with other field name */
            private d[] f1052a;
            private int b;
            private int c;

            private a() {
                this.a = 256;
                this.f1052a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            public d a() {
                return this.f1052a[0];
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m10216a() {
                return this.b == 0;
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m10215a(d dVar) {
                d[] dVarArr = this.f1052a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f1052a = dVarArr2;
                }
                d[] dVarArr3 = this.f1052a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m10217a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f1052a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f1052a[i2].a == i) {
                        this.f1052a[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f1052a[i2].f1054a == bVar) {
                        this.f1052a[i2].a();
                    }
                }
                b();
            }

            public void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.b)) {
                    return;
                }
                d[] dVarArr = this.f1052a;
                int i3 = i2 - 1;
                this.b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (this.f1052a[i].f1053a < this.f1052a[i2].f1053a) {
                    d[] dVarArr = this.f1052a;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3 && this.f1052a[i4].f1053a < this.f1052a[i2].f1053a) {
                        i2 = i4;
                    }
                    if (this.f1052a[i].f1053a < this.f1052a[i2].f1053a) {
                        return;
                    }
                    d[] dVarArr = this.f1052a;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m10214a() {
                this.f1052a = new d[this.a];
                this.b = 0;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f1052a[i].f1056a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f1052a;
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
        
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f1050a = true;
            r2.f1054a.run();
            r10.f1050a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a4, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
        
            r10.f1051b = true;
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
                    if (this.f1051b) {
                        return;
                    }
                    if (this.f1049a.m10216a()) {
                        if (this.c) {
                            return;
                        } else {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                            }
                        }
                    } else {
                        long a2 = n.a();
                        d a3 = this.f1049a.a();
                        synchronized (a3.f1055a) {
                            if (a3.f1056a) {
                                this.f1049a.b(0);
                            } else {
                                long j = a3.f1053a - a2;
                                if (j > 0) {
                                    long j2 = this.b;
                                    if (j > j2) {
                                        j = j2;
                                    }
                                    long j3 = j2 + 50;
                                    this.b = j3;
                                    if (j3 > 500) {
                                        this.b = 500L;
                                    }
                                    try {
                                        wait(j);
                                    } catch (InterruptedException unused2) {
                                    }
                                } else {
                                    this.b = 50L;
                                    synchronized (a3.f1055a) {
                                        int a4 = this.f1049a.a().f1053a != a3.f1053a ? this.f1049a.a(a3) : 0;
                                        if (a3.f1056a) {
                                            a aVar = this.f1049a;
                                            aVar.b(aVar.a(a3));
                                        } else {
                                            a3.a(a3.f1053a);
                                            this.f1049a.b(a4);
                                            a3.f1053a = 0L;
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
        public void a(d dVar) {
            this.f1049a.m10215a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f1051b = true;
            this.f1049a.m10214a();
            notify();
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m10213a() {
            return this.f1050a && SystemClock.uptimeMillis() - this.a > 600000;
        }
    }

    /* loaded from: classes7.dex */
    private static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.a) {
                    this.a.c = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    private static synchronized long b() {
        long j;
        synchronized (n.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    public n(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f1048a = cVar;
        this.f1047a = new a(cVar);
    }

    public n(String str) {
        this(str, false);
    }

    public n(boolean z) {
        this("Timer-" + b(), z);
    }

    public n() {
        this(false);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m10208a() {
        com.xiaomi.channel.commonutils.logger.b.m9528a("quit. finalizer:" + this.f1047a);
        this.f1048a.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m10210a(int i) {
        boolean m10217a;
        synchronized (this.f1048a) {
            m10217a = this.f1048a.f1049a.m10217a(i);
        }
        return m10217a;
    }

    public void a(int i) {
        synchronized (this.f1048a) {
            this.f1048a.f1049a.a(i);
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m10211b() {
        synchronized (this.f1048a) {
            this.f1048a.f1049a.m10214a();
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f1048a) {
            this.f1048a.f1049a.a(i, bVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m10209a() {
        return this.f1048a.m10213a();
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() < 1 && Thread.currentThread() != this.f1048a) {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    public void a(b bVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("delay < 0: " + j);
        }
        b(bVar, j);
    }

    private void b(b bVar, long j) {
        synchronized (this.f1048a) {
            if (this.f1048a.f1051b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.a = bVar.a;
            dVar.f1054a = bVar;
            dVar.f1053a = a2;
            this.f1048a.a(dVar);
        }
    }
}
