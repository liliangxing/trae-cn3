package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: CommonHandler.java */
/* loaded from: classes6.dex */
public class f extends Handler {
    private WeakReference<a> a;

    /* compiled from: CommonHandler.java */
    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public f(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.a.get();
        if (aVar != null) {
            aVar.a(message);
        }
    }
}
