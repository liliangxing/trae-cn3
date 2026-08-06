package com.apm.lite.runtime.p024a;

import android.content.Context;
import com.apm.lite.CrashType;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0747c;
import com.apm.lite.p023k.C0796s;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.apm.lite.runtime.a.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0818h extends AbstractC0813c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0818h(Context context, C0812b c0812b, C0814d c0814d) {
        super(CrashType.JAVA, context, c0812b, c0814d);
    }

    @Override // com.apm.lite.runtime.p024a.AbstractC0813c
    /* renamed from: a */
    public C0745a mo1089a(int i, C0745a c0745a) {
        C0745a mo1089a = super.mo1089a(i, c0745a);
        if (i == 0) {
            mo1089a.m484a("app_count", (Object) 1);
            mo1089a.m484a("magic_tag", "ss_app_log");
            m1099g(mo1089a);
            C0747c m512a = C0747c.m512a(this.f681b);
            m512a.m534d();
            mo1089a.m477a(m512a);
            C0796s.m898a(mo1089a, m512a, this.f680a);
        } else if (i == 1) {
            C0747c m499i = mo1089a.m499i();
            m499i.m535e();
            m499i.m536f();
        } else if (i == 2) {
            C0747c.m514a(mo1089a.m499i());
        } else if (i == 5) {
            C0747c.m518b(mo1089a.m499i());
        }
        return mo1089a;
    }
}
