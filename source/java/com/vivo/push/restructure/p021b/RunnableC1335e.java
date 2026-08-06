package com.vivo.push.restructure.p021b;

import android.content.Context;
import com.vivo.push.PushConfig;
import com.vivo.push.util.C1373ah;

/* compiled from: PushRelyImpl.java */
/* renamed from: com.vivo.push.restructure.b.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1335e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f593a;

    /* renamed from: b */
    final /* synthetic */ PushConfig f594b;

    /* renamed from: c */
    final /* synthetic */ C1334d f595c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1335e(C1334d c1334d, Context context, PushConfig pushConfig) {
        this.f595c = c1334d;
        this.f593a = context;
        this.f594b = pushConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f593a;
        C1373ah.m959a(context, context.getPackageName(), this.f594b.isAgreePrivacyStatement());
    }
}
