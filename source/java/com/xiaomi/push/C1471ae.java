package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.ae */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1471ae {

    /* renamed from: a */
    private int f930a;

    /* renamed from: a */
    private Handler f931a;

    /* renamed from: a */
    private a f932a;

    /* renamed from: a */
    private volatile b f933a;

    /* renamed from: a */
    private volatile boolean f934a;

    /* renamed from: b */
    private final boolean f935b;

    /* renamed from: com.xiaomi.push.ae$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class b {
        /* renamed from: a */
        public void m1469a() {
        }

        /* renamed from: b */
        public abstract void mo1470b();

        /* renamed from: c */
        public void mo1471c() {
        }
    }

    public C1471ae() {
        this(false);
    }

    public C1471ae(boolean z) {
        this(z, 0);
    }

    public C1471ae(boolean z, int i) {
        this.f931a = null;
        this.f934a = false;
        this.f930a = 0;
        this.f931a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.push.ae.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                if (message.what == 0) {
                    bVar.m1469a();
                } else if (message.what == 1) {
                    bVar.mo1471c();
                }
                super.handleMessage(message);
            }
        };
        this.f935b = z;
        this.f930a = i;
    }

    /* renamed from: a */
    public synchronized void m1465a(b bVar) {
        if (this.f932a == null) {
            a aVar = new a();
            this.f932a = aVar;
            aVar.setDaemon(this.f935b);
            this.f934a = false;
            this.f932a.start();
        }
        this.f932a.m1468a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m1462a() {
        this.f932a = null;
        this.f934a = true;
    }

    /* renamed from: a */
    public void m1466a(final b bVar, long j) {
        this.f931a.postDelayed(new Runnable() { // from class: com.xiaomi.push.ae.2
            @Override // java.lang.Runnable
            public void run() {
                C1471ae.this.m1465a(bVar);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.ae$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class a extends Thread {

        /* renamed from: a */
        private final LinkedBlockingQueue<b> f940a;

        public a() {
            super("PackageProcessor");
            this.f940a = new LinkedBlockingQueue<>();
        }

        /* renamed from: a */
        public void m1468a(b bVar) {
            try {
                this.f940a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        private void m1467a(int i, b bVar) {
            try {
                C1471ae.this.f931a.sendMessage(C1471ae.this.f931a.obtainMessage(i, bVar));
            } catch (Exception e) {
                AbstractC1417b.m1093a(e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = C1471ae.this.f930a > 0 ? C1471ae.this.f930a : Long.MAX_VALUE;
            while (!C1471ae.this.f934a) {
                try {
                    b poll = this.f940a.poll(j, TimeUnit.SECONDS);
                    C1471ae.this.f933a = poll;
                    if (poll == null) {
                        if (C1471ae.this.f930a > 0) {
                            C1471ae.this.m1462a();
                        }
                    } else {
                        m1467a(0, poll);
                        poll.mo1470b();
                        m1467a(1, poll);
                    }
                } catch (InterruptedException e) {
                    AbstractC1417b.m1093a(e);
                }
            }
        }
    }
}
