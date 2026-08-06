package ms.bd.c;

import android.content.Context;

/* loaded from: classes8.dex */
public final class z2 {
    public static volatile z2 d;
    public String a = null;
    public String b = null;
    public String c = null;

    public z2(Context context) {
        try {
            new Thread(new b0(new d0(new y2(this)), context)).start();
        } catch (Throwable unused) {
        }
    }

    public static z2 a(Context context) {
        if (d == null) {
            synchronized (z2.class) {
                if (d == null) {
                    d = new z2(context);
                }
            }
        }
        return d;
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
