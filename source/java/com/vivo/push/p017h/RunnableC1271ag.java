package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.p010b.C1212i;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnUnBindAppReceiveTask.java */
/* renamed from: com.vivo.push.h.ag */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1271ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1212i f466a;

    /* renamed from: b */
    final /* synthetic */ C1270af f467b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1271ag(C1270af c1270af, C1212i c1212i) {
        this.f467b = c1270af;
        this.f466a = c1212i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f467b.f454b;
        context = this.f467b.f625a;
        pushMessageCallback.onUnBind(context, this.f466a.m627j(), this.f466a.m594e());
    }
}
