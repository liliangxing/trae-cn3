package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.ss.android.common.util.NetworkUtils;
import com.vivo.push.util.C1393t;

/* compiled from: PushClientThread.java */
/* renamed from: com.vivo.push.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1357t {

    /* renamed from: a */
    private static final Handler f632a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static final HandlerThread f633b;

    /* renamed from: c */
    private static final Handler f634c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f633b = handlerThread;
        handlerThread.start();
        f634c = new HandlerC1358u(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static void m915a(AbstractRunnableC1352s abstractRunnableC1352s, long j) {
        if (abstractRunnableC1352s == null) {
            C1393t.m1034a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int m906a = abstractRunnableC1352s.m906a();
        if (j > 0) {
            f634c.removeMessages(m906a);
        }
        Message message = new Message();
        message.what = m906a;
        message.obj = abstractRunnableC1352s;
        f634c.sendMessageDelayed(message, j);
    }

    /* renamed from: a */
    public static void m914a(RunnableC1312r runnableC1312r) {
        Handler handler = f634c;
        handler.removeCallbacks(runnableC1312r);
        handler.postDelayed(runnableC1312r, NetworkUtils.DEFAULT_CONN_POOL_TIMEOUT);
    }

    /* renamed from: a */
    public static void m916a(Runnable runnable) {
        f632a.post(runnable);
    }

    /* renamed from: b */
    public static void m917b(Runnable runnable) {
        Handler handler = f634c;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
