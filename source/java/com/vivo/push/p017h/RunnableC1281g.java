package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyOpenClientClickTask.java */
/* renamed from: com.vivo.push.h.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1281g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UPSNotificationMessage f471a;

    /* renamed from: b */
    final /* synthetic */ C1279e f472b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1281g(C1279e c1279e, UPSNotificationMessage uPSNotificationMessage) {
        this.f472b = c1279e;
        this.f471a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f472b.f454b;
        context = this.f472b.f625a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f471a);
    }
}
