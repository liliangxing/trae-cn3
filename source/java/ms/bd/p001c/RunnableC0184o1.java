package ms.bd.p001c;

/* renamed from: ms.bd.c.o1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class RunnableC0184o1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0189p1 f295a;

    public RunnableC0184o1(C0189p1 c0189p1) {
        this.f295a = c0189p1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f295a.f310h.await();
        } catch (InterruptedException unused) {
        }
        this.f295a.f309g.quitSafely();
    }
}
