package ms.bd.c;

/* loaded from: classes8.dex */
public final class a4 {
    public static volatile a4 c;
    public int a = 0;
    public Throwable b = null;

    public static a4 a() {
        if (c == null) {
            synchronized (a4.class) {
                if (c == null) {
                    c = new a4();
                }
            }
        }
        return c;
    }
}
