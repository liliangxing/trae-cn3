package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Worker.java */
/* loaded from: classes7.dex */
public abstract class ab {
    protected Context a;
    protected Handler b;
    private final Object c = new Object();

    public abstract void b(Message message);

    public ab() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.a = context;
    }

    public final void a(Message message) {
        synchronized (this.c) {
            Handler handler = this.b;
            if (handler == null) {
                com.vivo.push.util.t.e(getClass().getSimpleName(), ("Dead worker dropping a message: " + message.what) + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                handler.sendMessage(message);
            }
        }
    }

    /* compiled from: Worker.java */
    /* loaded from: classes7.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ab.this.b(message);
        }
    }
}
