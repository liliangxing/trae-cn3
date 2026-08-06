package ms.bd.c;

import android.content.Context;
import android.webkit.WebSettings;

/* loaded from: classes8.dex */
public abstract class i4 {
    public static String a;

    public static synchronized String a(Context context) {
        synchronized (i4.class) {
            String str = a;
            if (str != null) {
                return str;
            }
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            a = defaultUserAgent;
            return defaultUserAgent;
        }
    }
}
