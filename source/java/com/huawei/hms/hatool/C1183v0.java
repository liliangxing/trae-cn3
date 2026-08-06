package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.v0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1183v0 implements InterfaceRunnableC1142g {

    /* renamed from: a */
    private Context f1579a = AbstractC1173q0.m1707i();

    /* renamed from: b */
    private String f1580b;

    /* renamed from: c */
    private String f1581c;

    /* renamed from: d */
    private String f1582d;

    public C1183v0(String str, String str2, String str3) {
        this.f1580b = str;
        this.f1581c = str2;
        this.f1582d = str3;
    }

    /* renamed from: a */
    private void m1787a(String str, List<C1129b1> list) {
        Pair<String, String> m1646a = AbstractC1165n1.m1646a(str);
        new C1180u(list, (String) m1646a.first, (String) m1646a.second, this.f1582d).m1768a();
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, List<C1129b1>> m1457a;
        C1182v.m1775a("hmsSdk", "eventReportTask is running");
        boolean m1452a = C1131c0.m1452a(this.f1579a);
        if (m1452a) {
            C1182v.m1781c("hmsSdk", "workKey is refresh,begin report all data");
            this.f1581c = "alltype";
        }
        try {
            try {
                m1457a = C1132c1.m1457a(this.f1579a, this.f1580b, this.f1581c);
            } catch (IllegalArgumentException e) {
                C1182v.m1785e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e.getMessage());
                if ("alltype".equals(this.f1581c)) {
                    C1133d.m1466a(this.f1579a, "stat_v2_1", new String[0]);
                    C1133d.m1466a(this.f1579a, "cached_v2_1", new String[0]);
                } else {
                    String m1648a = AbstractC1165n1.m1648a(this.f1580b, this.f1581c);
                    C1133d.m1466a(this.f1579a, "stat_v2_1", m1648a);
                    C1133d.m1466a(this.f1579a, "cached_v2_1", m1648a);
                }
            } catch (Exception e2) {
                C1182v.m1785e("hmsSdk", "readEventRecords handData Exception:" + e2.getMessage());
                if ("alltype".equals(this.f1581c)) {
                    C1133d.m1466a(this.f1579a, "stat_v2_1", new String[0]);
                    C1133d.m1466a(this.f1579a, "cached_v2_1", new String[0]);
                } else {
                    String m1648a2 = AbstractC1165n1.m1648a(this.f1580b, this.f1581c);
                    C1133d.m1466a(this.f1579a, "stat_v2_1", m1648a2);
                    C1133d.m1466a(this.f1579a, "cached_v2_1", m1648a2);
                }
            }
            if (m1457a.size() == 0) {
                C1182v.m1779b("hmsSdk", "no events to report, tag: %s, type: %s", this.f1580b, this.f1581c);
                if ("alltype".equals(this.f1581c)) {
                    C1133d.m1466a(this.f1579a, "stat_v2_1", new String[0]);
                    C1133d.m1466a(this.f1579a, "cached_v2_1", new String[0]);
                    return;
                } else {
                    String m1648a3 = AbstractC1165n1.m1648a(this.f1580b, this.f1581c);
                    C1133d.m1466a(this.f1579a, "stat_v2_1", m1648a3);
                    C1133d.m1466a(this.f1579a, "cached_v2_1", m1648a3);
                    return;
                }
            }
            for (Map.Entry<String, List<C1129b1>> entry : m1457a.entrySet()) {
                m1787a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.f1581c)) {
                C1133d.m1466a(this.f1579a, "stat_v2_1", new String[0]);
                C1133d.m1466a(this.f1579a, "cached_v2_1", new String[0]);
            } else {
                String m1648a4 = AbstractC1165n1.m1648a(this.f1580b, this.f1581c);
                C1133d.m1466a(this.f1579a, "stat_v2_1", m1648a4);
                C1133d.m1466a(this.f1579a, "cached_v2_1", m1648a4);
            }
            if (m1452a) {
                C1182v.m1781c("hmsSdk", "refresh local key");
                C1167o0.m1666d().m1671b();
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.f1581c)) {
                C1133d.m1466a(this.f1579a, "stat_v2_1", new String[0]);
                C1133d.m1466a(this.f1579a, "cached_v2_1", new String[0]);
            } else {
                String m1648a5 = AbstractC1165n1.m1648a(this.f1580b, this.f1581c);
                C1133d.m1466a(this.f1579a, "stat_v2_1", m1648a5);
                C1133d.m1466a(this.f1579a, "cached_v2_1", m1648a5);
            }
            throw th;
        }
    }
}
