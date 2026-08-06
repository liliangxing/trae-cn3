package ms.bd.p001c;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;

/* renamed from: ms.bd.c.g4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0142g4 extends AbstractC0134f2 {

    /* renamed from: a */
    public long f180a;

    @Override // ms.bd.p001c.AbstractC0134f2
    /* renamed from: a */
    public final void mo97a(long j) {
        this.f180a = j;
        C0136f4 c0136f4 = new C0136f4(this);
        synchronized (this) {
            NetworkParams.setAddSecurityFactorProcessCallback(c0136f4);
        }
    }

    public final void finalize() {
        AbstractC0190p2.m166a(50331650, 0, this.f180a, null, null);
        AbstractC0190p2.m166a(100663298, 0, this.f180a, null, null);
        this.f180a = -1L;
        super.finalize();
    }
}
