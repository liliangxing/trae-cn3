package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import com.vivo.push.util.C1393t;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPCManager.java */
/* renamed from: com.vivo.push.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1303j implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC1301i f508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1303j(ServiceConnectionC1301i serviceConnectionC1301i) {
        this.f508a = serviceConnectionC1301i;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            C1393t.m1034a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i = message.what;
        if (i == 1) {
            C1393t.m1034a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.f508a.f500f;
            if (atomicInteger.get() == 2) {
                this.f508a.m740a(1);
            }
        } else if (i == 2) {
            atomicInteger2 = this.f508a.f500f;
            if (atomicInteger2.get() == 4) {
                this.f508a.m747f();
            }
            this.f508a.m740a(1);
        } else {
            C1393t.m1041b("AidlManager", "unknow msg what [" + message.what + "]");
        }
        return true;
    }
}
