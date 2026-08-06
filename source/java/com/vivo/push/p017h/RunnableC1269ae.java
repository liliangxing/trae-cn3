package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* renamed from: com.vivo.push.h.ae */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1269ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f461a;

    /* renamed from: b */
    final /* synthetic */ List f462b;

    /* renamed from: c */
    final /* synthetic */ List f463c;

    /* renamed from: d */
    final /* synthetic */ String f464d;

    /* renamed from: e */
    final /* synthetic */ C1267ac f465e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1269ae(C1267ac c1267ac, int i, List list, List list2, String str) {
        this.f465e = c1267ac;
        this.f461a = i;
        this.f462b = list;
        this.f463c = list2;
        this.f464d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f465e.f454b;
        context = this.f465e.f625a;
        pushMessageCallback.onSetAlias(context, this.f461a, this.f462b, this.f463c, this.f464d);
    }
}
