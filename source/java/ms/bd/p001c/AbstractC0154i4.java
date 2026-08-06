package ms.bd.p001c;

import android.content.Context;
import android.webkit.WebSettings;

/* renamed from: ms.bd.c.i4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0154i4 {

    /* renamed from: a */
    public static String f194a;

    /* renamed from: a */
    public static synchronized String m131a(Context context) {
        synchronized (AbstractC0154i4.class) {
            String str = f194a;
            if (str != null) {
                return str;
            }
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            f194a = defaultUserAgent;
            return defaultUserAgent;
        }
    }
}
