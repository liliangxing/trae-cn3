package ms.bd.p001c;

/* renamed from: ms.bd.c.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class RunnableC0161k implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0167l f203a;

    public RunnableC0161k(C0167l c0167l) {
        this.f203a = c0167l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f203a.getClass();
        if (AbstractC0177n.m148a() != 0) {
            AbstractC0177n.f253h.postDelayed(new RunnableC0155j(this), 1000L);
        } else {
            AbstractC0177n.m149a(0);
            AbstractC0177n.f250e = false;
        }
    }
}
