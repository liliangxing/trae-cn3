package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.cq */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1537cq implements InterfaceC1604fc {

    /* renamed from: a */
    private Context f1228a;

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1919a(AbstractC1600ez abstractC1600ez) {
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1921a(AbstractC1600ez abstractC1600ez, Exception exc) {
    }

    public C1537cq(Context context) {
        this.f1228a = context;
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1920a(AbstractC1600ez abstractC1600ez, int i, Exception exc) {
        C1533cm.m1870a(this.f1228a, abstractC1600ez.mo2505a(), i);
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: b */
    public void mo1922b(AbstractC1600ez abstractC1600ez) {
        C1533cm.m1867a(this.f1228a);
    }
}
