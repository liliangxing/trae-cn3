package ms.bd.p001c;

import net.openid.appauth.BuildConfig;

/* renamed from: ms.bd.c.b4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0112b4 {

    /* renamed from: a */
    public static final /* synthetic */ int f142a = 0;

    static {
    }

    /* renamed from: a */
    public static String m74a(String str) {
        return (str == null || str.length() <= 0) ? BuildConfig.FLAVOR : str.trim().replace('\'', ' ').replace('\"', ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
