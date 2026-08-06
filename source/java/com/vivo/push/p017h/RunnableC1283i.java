package com.vivo.push.p017h;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.p010b.C1212i;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnBindAppReceiveTask.java */
/* renamed from: com.vivo.push.h.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1283i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f473a;

    /* renamed from: b */
    final /* synthetic */ C1212i f474b;

    /* renamed from: c */
    final /* synthetic */ C1282h f475c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1283i(C1282h c1282h, String str, C1212i c1212i) {
        this.f475c = c1282h;
        this.f473a = str;
        this.f474b = c1212i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f473a)) {
            PushMessageCallback pushMessageCallback = this.f475c.f454b;
            context2 = this.f475c.f625a;
            pushMessageCallback.onReceiveRegId(context2, this.f473a);
        }
        PushMessageCallback pushMessageCallback2 = this.f475c.f454b;
        context = this.f475c.f625a;
        pushMessageCallback2.onBind(context, this.f474b.m627j(), this.f474b.m594e());
    }
}
