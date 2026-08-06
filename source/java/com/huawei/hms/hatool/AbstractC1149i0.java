package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.hatool.i0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1149i0 {
    /* renamed from: a */
    public static String m1559a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(AbstractC1190z.m1817a(str, str2))) {
            return AbstractC1190z.m1817a(str, str2);
        }
        C1182v.m1775a("hmsSdk", "getAndroidId(): to getConfigByType()");
        return m1561c(context, str, str2);
    }

    /* renamed from: b */
    public static String m1560b(Context context, String str, String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            C1182v.m1786f("hmsSdk", "getChannel(): Invalid type: " + str2);
            return "";
        }
        return m1562d(context, str, str2);
    }

    /* renamed from: c */
    private static String m1561c(Context context, String str, String str2) {
        if (!AbstractC1190z.m1818b(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(AbstractC1173q0.m1697d())) {
            C1176s.m1722c().m1727b().m1514b(AbstractC1166o.m1654a(context));
        }
        return AbstractC1173q0.m1697d();
    }

    /* renamed from: d */
    private static String m1562d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(AbstractC1126a1.m1417d(str, str2))) {
            return AbstractC1126a1.m1417d(str, str2);
        }
        C1144g1 m1727b = C1176s.m1722c().m1727b();
        if (TextUtils.isEmpty(m1727b.m1525h())) {
            String m1658b = AbstractC1166o.m1658b(context);
            if (!C1138e1.m1493a("channel", m1658b, 256)) {
                m1658b = "";
            }
            m1727b.m1522f(m1658b);
        }
        return m1727b.m1525h();
    }
}
