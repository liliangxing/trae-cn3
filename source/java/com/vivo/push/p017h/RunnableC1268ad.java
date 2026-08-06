package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* renamed from: com.vivo.push.h.ad */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1268ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f456a;

    /* renamed from: b */
    final /* synthetic */ List f457b;

    /* renamed from: c */
    final /* synthetic */ List f458c;

    /* renamed from: d */
    final /* synthetic */ String f459d;

    /* renamed from: e */
    final /* synthetic */ C1267ac f460e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1268ad(C1267ac c1267ac, int i, List list, List list2, String str) {
        this.f460e = c1267ac;
        this.f456a = i;
        this.f457b = list;
        this.f458c = list2;
        this.f459d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f460e.f454b;
        context = this.f460e.f625a;
        pushMessageCallback.onSetTags(context, this.f456a, this.f457b, this.f458c, this.f459d);
    }
}
