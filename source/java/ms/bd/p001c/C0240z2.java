package ms.bd.p001c;

import android.content.Context;

/* renamed from: ms.bd.c.z2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0240z2 {

    /* renamed from: d */
    public static volatile C0240z2 f478d;

    /* renamed from: a */
    public String f479a = null;

    /* renamed from: b */
    public String f480b = null;

    /* renamed from: c */
    public String f481c = null;

    public C0240z2(Context context) {
        try {
            new Thread(new RunnableC0108b0(new C0120d0(new C0235y2(this)), context)).start();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static C0240z2 m215a(Context context) {
        if (f478d == null) {
            synchronized (C0240z2.class) {
                if (f478d == null) {
                    f478d = new C0240z2(context);
                }
            }
        }
        return f478d;
    }

    /* renamed from: a */
    public static boolean m216a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
