package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.p010b.C1216m;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnListTagReceiveTask.java */
/* renamed from: com.vivo.push.h.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1291q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1216m f486a;

    /* renamed from: b */
    final /* synthetic */ C1290p f487b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1291q(C1290p c1290p, C1216m c1216m) {
        this.f487b = c1290p;
        this.f486a = c1216m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f487b.f454b;
        context = this.f487b.f625a;
        pushMessageCallback.onListTags(context, this.f486a.m627j(), this.f486a.m600e(), this.f486a.m626i());
    }
}
