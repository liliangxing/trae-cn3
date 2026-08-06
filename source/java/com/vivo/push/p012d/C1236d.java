package com.vivo.push.p012d;

import com.vivo.push.restructure.request.InterfaceC1348c;
import com.vivo.push.util.C1393t;

/* compiled from: NotifyGuideDialogManager.java */
/* renamed from: com.vivo.push.d.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1236d implements InterfaceC1348c<C1241i> {

    /* renamed from: a */
    final /* synthetic */ RunnableC1235c f400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1236d(RunnableC1235c runnableC1235c) {
        this.f400a = runnableC1235c;
    }

    @Override // com.vivo.push.restructure.request.InterfaceC1348c
    /* renamed from: a */
    public final /* synthetic */ void mo672a(C1241i c1241i) {
        C1241i c1241i2 = c1241i;
        if (c1241i2 == null) {
            this.f400a.f398b.onStateChanged(10000);
        } else {
            C1393t.m1048d("NotifyGuideDialogManage", "onReceiveAck:" + c1241i2.m675a());
            this.f400a.f398b.onStateChanged(c1241i2.m675a());
        }
    }

    @Override // com.vivo.push.restructure.request.InterfaceC1348c
    /* renamed from: a */
    public final void mo671a(int i) {
        C1393t.m1048d("NotifyGuideDialogManage", "onError:".concat(String.valueOf(i)));
        this.f400a.f398b.onStateChanged(i);
    }
}
