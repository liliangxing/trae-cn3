package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPCManager.java */
/* loaded from: classes7.dex */
public final class j implements Handler.Callback {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.t.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i = message.what;
        if (i == 1) {
            com.vivo.push.util.t.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.a.f;
            if (atomicInteger.get() == 2) {
                this.a.a(1);
            }
        } else if (i == 2) {
            atomicInteger2 = this.a.f;
            if (atomicInteger2.get() == 4) {
                this.a.f();
            }
            this.a.a(1);
        } else {
            com.vivo.push.util.t.b("AidlManager", "unknow msg what [" + message.what + "]");
        }
        return true;
    }
}
