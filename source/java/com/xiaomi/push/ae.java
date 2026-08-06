package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class ae {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f148a;

    /* renamed from: a, reason: collision with other field name */
    private a f149a;

    /* renamed from: a, reason: collision with other field name */
    private volatile b f150a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f151a;
    private final boolean b;

    /* loaded from: classes7.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo9743c() {
        }
    }

    public ae() {
        this(false);
    }

    public ae(boolean z) {
        this(z, 0);
    }

    public ae(boolean z, int i) {
        this.f148a = null;
        this.f151a = false;
        this.a = 0;
        this.f148a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.push.ae.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                if (message.what == 0) {
                    bVar.a();
                } else if (message.what == 1) {
                    bVar.mo9743c();
                }
                super.handleMessage(message);
            }
        };
        this.b = z;
        this.a = i;
    }

    public synchronized void a(b bVar) {
        if (this.f149a == null) {
            a aVar = new a();
            this.f149a = aVar;
            aVar.setDaemon(this.b);
            this.f151a = false;
            this.f149a.start();
        }
        this.f149a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f149a = null;
        this.f151a = true;
    }

    public void a(final b bVar, long j) {
        this.f148a.postDelayed(new Runnable() { // from class: com.xiaomi.push.ae.2
            @Override // java.lang.Runnable
            public void run() {
                ae.this.a(bVar);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends Thread {

        /* renamed from: a, reason: collision with other field name */
        private final LinkedBlockingQueue<b> f153a;

        public a() {
            super("PackageProcessor");
            this.f153a = new LinkedBlockingQueue<>();
        }

        public void a(b bVar) {
            try {
                this.f153a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void a(int i, b bVar) {
            try {
                ae.this.f148a.sendMessage(ae.this.f148a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = ae.this.a > 0 ? ae.this.a : Long.MAX_VALUE;
            while (!ae.this.f151a) {
                try {
                    b poll = this.f153a.poll(j, TimeUnit.SECONDS);
                    ae.this.f150a = poll;
                    if (poll == null) {
                        if (ae.this.a > 0) {
                            ae.this.a();
                        }
                    } else {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }
}
