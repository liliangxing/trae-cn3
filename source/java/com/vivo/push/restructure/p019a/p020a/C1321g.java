package com.vivo.push.restructure.p019a.p020a;

import android.os.SystemClock;
import com.vivo.push.restructure.p019a.InterfaceC1314a;

/* compiled from: IPCNode.java */
/* renamed from: com.vivo.push.restructure.a.a.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1321g extends AbstractC1315a<InterfaceC1314a> {

    /* renamed from: b */
    private long f573b;

    @Override // com.vivo.push.restructure.p019a.p020a.AbstractC1315a
    /* renamed from: a */
    protected final /* bridge */ /* synthetic */ int mo834a(InterfaceC1314a interfaceC1314a) {
        return 0;
    }

    public C1321g(InterfaceC1314a interfaceC1314a, C1324j c1324j) {
        super("IPCNode", interfaceC1314a, c1324j);
        this.f573b = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long mo822d = interfaceC1314a.mo822d();
        if (mo822d <= 0 || elapsedRealtime <= mo822d) {
            return;
        }
        this.f573b = elapsedRealtime - mo822d;
    }

    @Override // com.vivo.push.restructure.p019a.p020a.AbstractC1315a
    /* renamed from: b */
    public final synchronized String mo838b() {
        m836a(this.f573b);
        return super.mo838b();
    }
}
