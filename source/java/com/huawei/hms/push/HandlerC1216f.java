package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: CommonHandler.java */
/* renamed from: com.huawei.hms.push.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HandlerC1216f extends Handler {

    /* renamed from: a */
    private WeakReference<a> f1685a;

    /* compiled from: CommonHandler.java */
    /* renamed from: com.huawei.hms.push.f$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface a {
        /* renamed from: a */
        void mo1913a(Message message);
    }

    public HandlerC1216f(a aVar) {
        this.f1685a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f1685a.get();
        if (aVar != null) {
            aVar.mo1913a(message);
        }
    }
}
