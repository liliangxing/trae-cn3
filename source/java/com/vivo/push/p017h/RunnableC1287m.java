package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* renamed from: com.vivo.push.h.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1287m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f476a;

    /* renamed from: b */
    final /* synthetic */ List f477b;

    /* renamed from: c */
    final /* synthetic */ List f478c;

    /* renamed from: d */
    final /* synthetic */ String f479d;

    /* renamed from: e */
    final /* synthetic */ C1286l f480e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1287m(C1286l c1286l, int i, List list, List list2, String str) {
        this.f480e = c1286l;
        this.f476a = i;
        this.f477b = list;
        this.f478c = list2;
        this.f479d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f480e.f454b;
        context = this.f480e.f625a;
        pushMessageCallback.onDelTags(context, this.f476a, this.f477b, this.f478c, this.f479d);
    }
}
