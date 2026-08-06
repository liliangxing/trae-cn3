package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.hms.hatool.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1124a {

    /* renamed from: a */
    private static C1191z0 f1396a;

    /* renamed from: a */
    private static synchronized C1191z0 m1407a() {
        C1191z0 c1191z0;
        synchronized (AbstractC1124a.class) {
            if (f1396a == null) {
                f1396a = C1172q.m1687c().m1690b();
            }
            c1191z0 = f1396a;
        }
        return c1191z0;
    }

    /* renamed from: a */
    public static void m1408a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (m1407a() == null || !C1174q1.m1714b().m1715a()) {
            return;
        }
        if (i == 1 || i == 0) {
            f1396a.m1831a(i, str, linkedHashMap);
        } else {
            C1182v.m1783d("hmsSdk", "Data type no longer collects range.type: " + i);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m1409a(Context context, String str, String str2) {
        if (m1407a() != null) {
            f1396a.m1832a(context, str, str2);
        }
    }

    /* renamed from: b */
    public static void m1410b(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (m1407a() == null || !C1174q1.m1714b().m1715a()) {
            return;
        }
        if (i == 1 || i == 0) {
            f1396a.m1834b(i, str, linkedHashMap);
        } else {
            C1182v.m1783d("hmsSdk", "Data type no longer collects range.type: " + i);
        }
    }

    /* renamed from: b */
    public static boolean m1411b() {
        return C1172q.m1687c().m1689a();
    }

    /* renamed from: c */
    public static void m1412c() {
        if (m1407a() == null || !C1174q1.m1714b().m1715a()) {
            return;
        }
        f1396a.m1830a(-1);
    }
}
