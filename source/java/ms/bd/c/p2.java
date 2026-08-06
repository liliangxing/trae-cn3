package ms.bd.c;

/* loaded from: classes8.dex */
public abstract class p2 {
    public static native Object a(int i, int i2, long j, String str, Object obj);

    public static Object b(int i, int i2, long j, String str, Object obj) {
        try {
            return i2.a(i, i2, j, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
