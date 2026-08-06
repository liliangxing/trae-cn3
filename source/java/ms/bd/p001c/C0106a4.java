package ms.bd.p001c;

/* renamed from: ms.bd.c.a4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0106a4 {

    /* renamed from: c */
    public static volatile C0106a4 f128c;

    /* renamed from: a */
    public int f129a = 0;

    /* renamed from: b */
    public Throwable f130b = null;

    /* renamed from: a */
    public static C0106a4 m70a() {
        if (f128c == null) {
            synchronized (C0106a4.class) {
                if (f128c == null) {
                    f128c = new C0106a4();
                }
            }
        }
        return f128c;
    }
}
