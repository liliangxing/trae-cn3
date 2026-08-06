package com.apm.lite.runtime.p024a;

import android.content.Context;
import com.apm.lite.CrashType;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0747c;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0796s;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.apm.lite.runtime.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0811a extends AbstractC0813c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0811a(Context context, C0812b c0812b, C0814d c0814d) {
        super(CrashType.ANR, context, c0812b, c0814d);
    }

    @Override // com.apm.lite.runtime.p024a.AbstractC0813c
    /* renamed from: a */
    public C0745a mo1031a(C0745a c0745a) {
        C0745a mo1031a = super.mo1031a(c0745a);
        C0747c m512a = C0747c.m512a(this.f681b);
        C0747c.m514a(m512a);
        C0747c.m518b(m512a);
        m512a.m534d();
        m512a.m535e();
        m512a.m536f();
        mo1031a.m477a(m512a);
        mo1031a.m484a("process_name", (Object) C0778a.m748c(this.f681b));
        C0796s.m898a(mo1031a, m512a, this.f680a);
        return mo1031a;
    }

    @Override // com.apm.lite.runtime.p024a.AbstractC0813c
    /* renamed from: a */
    protected boolean mo1032a() {
        return true;
    }
}
