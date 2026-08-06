package com.vivo.push;

import android.content.Context;
import com.vivo.push.p010b.C1217n;
import com.vivo.push.util.C1393t;

/* compiled from: PushClientTask.java */
/* renamed from: com.vivo.push.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractRunnableC1352s implements Runnable {

    /* renamed from: a */
    protected Context f625a;

    /* renamed from: b */
    private int f626b;

    /* renamed from: c */
    private AbstractC1400v f627c;

    /* renamed from: a */
    protected abstract void mo702a(AbstractC1400v abstractC1400v);

    public AbstractRunnableC1352s(AbstractC1400v abstractC1400v) {
        this.f626b = -1;
        this.f627c = abstractC1400v;
        int m1067b = abstractC1400v.m1067b();
        this.f626b = m1067b;
        if (m1067b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f625a = C1306m.m762a().m793h();
    }

    /* renamed from: a */
    public final int m906a() {
        return this.f626b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f625a;
        if (context != null && !(this.f627c instanceof C1217n)) {
            C1393t.m1038a(context, "[执行指令]" + this.f627c);
        }
        mo702a(this.f627c);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(getClass().getSimpleName()).append("{");
        AbstractC1400v abstractC1400v = this.f627c;
        return append.append(abstractC1400v == null ? "[null]" : abstractC1400v.toString()).append("}").toString();
    }
}
