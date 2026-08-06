package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C1393t;

/* compiled from: PushClientThread.java */
/* renamed from: com.vivo.push.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class HandlerC1358u extends Handler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1358u(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof AbstractRunnableC1352s) {
            AbstractRunnableC1352s abstractRunnableC1352s = (AbstractRunnableC1352s) obj;
            C1393t.m1046c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(abstractRunnableC1352s)));
            abstractRunnableC1352s.run();
        }
    }
}
