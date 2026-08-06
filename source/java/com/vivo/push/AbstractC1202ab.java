package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C1393t;

/* compiled from: Worker.java */
/* renamed from: com.vivo.push.ab */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1202ab {

    /* renamed from: a */
    protected Context f327a;

    /* renamed from: b */
    protected Handler f328b;

    /* renamed from: c */
    private final Object f329c = new Object();

    /* renamed from: b */
    public abstract void mo581b(Message message);

    public AbstractC1202ab() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f328b = new a(handlerThread.getLooper());
    }

    /* renamed from: a */
    public final void m579a(Context context) {
        this.f327a = context;
    }

    /* renamed from: a */
    public final void m580a(Message message) {
        synchronized (this.f329c) {
            Handler handler = this.f328b;
            if (handler == null) {
                C1393t.m1049e(getClass().getSimpleName(), ("Dead worker dropping a message: " + message.what) + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                handler.sendMessage(message);
            }
        }
    }

    /* compiled from: Worker.java */
    /* renamed from: com.vivo.push.ab$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            AbstractC1202ab.this.mo581b(message);
        }
    }
}
