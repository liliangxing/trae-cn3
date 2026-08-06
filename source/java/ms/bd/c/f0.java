package ms.bd.c;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: classes8.dex */
public abstract class f0 {
    public static int a;

    public static String a(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                a = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + a;
    }
}
