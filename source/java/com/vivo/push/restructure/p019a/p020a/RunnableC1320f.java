package com.vivo.push.restructure.p019a.p020a;

import com.vivo.push.PushClient;
import com.vivo.push.restructure.C1313a;

/* compiled from: DispatchNode.java */
/* renamed from: com.vivo.push.restructure.a.a.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1320f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f570a;

    /* renamed from: b */
    final /* synthetic */ String f571b;

    /* renamed from: c */
    final /* synthetic */ C1319e f572c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1320f(C1319e c1319e, int i, String str) {
        this.f572c = c1319e;
        this.f570a = i;
        this.f571b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f570a;
        if (i == 3) {
            PushClient.getInstance(C1313a.m810a().m812b()).unBindAlias(this.f571b, null);
        } else if (i == 4) {
            PushClient.getInstance(C1313a.m810a().m812b()).delTopic(this.f571b, null);
        }
    }
}
