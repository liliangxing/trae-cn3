package ms.bd.p001c;

import android.content.Context;
import android.util.DisplayMetrics;
import net.openid.appauth.BuildConfig;

/* renamed from: ms.bd.c.f0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0132f0 {

    /* renamed from: a */
    public static int f165a;

    /* renamed from: a */
    public static String m96a(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                f165a = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return BuildConfig.FLAVOR + f165a;
    }
}
