package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.C1788q;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.xiaomi.push.cj */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1530cj {

    /* renamed from: a */
    private static final List<String> f1183a = Arrays.asList("001", "002", "003", "004", "005");

    /* renamed from: a */
    private static Boolean f1182a = null;

    /* renamed from: a */
    public static void m1860a(String str, String str2) {
    }

    /* renamed from: a */
    public static boolean m1861a(Context context) {
        if (f1182a == null) {
            try {
                if (!C1694j.m3427a(context)) {
                    f1182a = false;
                }
                String m3957a = C1788q.m3957a(context);
                if (!TextUtils.isEmpty(m3957a) && m3957a.length() >= 3) {
                    f1182a = Boolean.valueOf(f1183a.contains(m3957a.substring(m3957a.length() - 3)));
                } else {
                    f1182a = false;
                }
                m1859a("Sampling statistical connection quality: " + f1182a);
            } catch (Throwable th) {
                f1182a = false;
                AbstractC1417b.m1102c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th);
            }
        }
        return f1182a.booleanValue();
    }

    /* renamed from: a */
    static void m1859a(String str) {
        m1860a("Push-ConnectionQualityStatsHelper", str);
    }
}
