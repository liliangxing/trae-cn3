package ms.bd.c;

/* loaded from: classes8.dex */
public final class o1 implements Runnable {
    public final /* synthetic */ p1 a;

    public o1(p1 p1Var) {
        this.a = p1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.h.await();
        } catch (InterruptedException unused) {
        }
        this.a.g.quitSafely();
    }
}
