package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* renamed from: com.vivo.push.h.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1288n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f481a;

    /* renamed from: b */
    final /* synthetic */ List f482b;

    /* renamed from: c */
    final /* synthetic */ List f483c;

    /* renamed from: d */
    final /* synthetic */ String f484d;

    /* renamed from: e */
    final /* synthetic */ C1286l f485e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1288n(C1286l c1286l, int i, List list, List list2, String str) {
        this.f485e = c1286l;
        this.f481a = i;
        this.f482b = list;
        this.f483c = list2;
        this.f484d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f485e.f454b;
        context = this.f485e.f625a;
        pushMessageCallback.onDelAlias(context, this.f481a, this.f482b, this.f483c, this.f484d);
    }
}
