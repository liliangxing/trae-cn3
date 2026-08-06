package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.p010b.C1222s;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnPublishReceiveTask.java */
/* renamed from: com.vivo.push.h.aa */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1265aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1222s f452a;

    /* renamed from: b */
    final /* synthetic */ C1300z f453b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1265aa(C1300z c1300z, C1222s c1222s) {
        this.f453b = c1300z;
        this.f452a = c1222s;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f453b.f454b;
        context = this.f453b.f625a;
        pushMessageCallback.onPublish(context, this.f452a.m627j(), this.f452a.m626i());
    }
}
