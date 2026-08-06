package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1136e {

    /* renamed from: b */
    private static C1136e f1433b;

    /* renamed from: c */
    private static Map<String, Long> f1434c = new HashMap();

    /* renamed from: a */
    private Context f1435a;

    /* renamed from: a */
    public static C1136e m1472a() {
        return m1473b();
    }

    /* renamed from: b */
    private static synchronized C1136e m1473b() {
        C1136e c1136e;
        synchronized (C1136e.class) {
            if (f1433b == null) {
                f1433b = new C1136e();
            }
            c1136e = f1433b;
        }
        return c1136e;
    }

    /* renamed from: b */
    private void m1474b(Context context) {
        String str;
        String m1661d = AbstractC1166o.m1661d(context);
        AbstractC1173q0.m1692a(m1661d);
        if (C1174q1.m1714b().m1715a()) {
            String m1464a = C1133d.m1464a(context, "global_v2", "app_ver", "");
            C1133d.m1469b(context, "global_v2", "app_ver", m1661d);
            AbstractC1173q0.m1694b(m1464a);
            if (!TextUtils.isEmpty(m1464a)) {
                if (m1464a.equals(m1661d)) {
                    return;
                }
                C1182v.m1781c("hmsSdk", "the appVers are different!");
                m1472a().m1480a("", "alltype", m1464a);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        C1182v.m1781c("hmsSdk", str);
    }

    /* renamed from: a */
    public void m1475a(Context context) {
        this.f1435a = context;
        m1474b(context);
        C1176s.m1722c().m1727b().m1526h(AbstractC1166o.m1653a());
    }

    /* renamed from: a */
    public void m1476a(String str, int i) {
        if (this.f1435a == null) {
            C1182v.m1785e("hmsSdk", "onReport() null context or SDK was not init.");
        } else {
            C1182v.m1775a("hmsSdk", "onReport: Before calling runtaskhandler()");
            m1480a(str, AbstractC1165n1.m1647a(i), AbstractC1173q0.m1703g());
        }
    }

    /* renamed from: a */
    public void m1477a(String str, int i, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i) {
            currentTimeMillis = AbstractC1165n1.m1645a("yyyy-MM-dd", currentTimeMillis);
        }
        C1128b0.m1437c().m1438a(new C1125a0(str2, jSONObject, str, AbstractC1165n1.m1647a(i), currentTimeMillis));
    }

    /* renamed from: a */
    public void m1478a(String str, int i, String str2, JSONObject jSONObject, long j) {
        new C1150i1(str, AbstractC1165n1.m1647a(i), str2, jSONObject.toString(), j).m1563a();
    }

    /* renamed from: a */
    public void m1479a(String str, String str2) {
        if (!AbstractC1126a1.m1414a(str, str2)) {
            C1182v.m1781c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long m1423j = AbstractC1126a1.m1423j(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - m1423j <= 30000) {
            C1182v.m1786f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        C1182v.m1775a("hmsSdk", "begin to call onReport!");
        AbstractC1126a1.m1413a(str, str2, currentTimeMillis);
        m1480a(str, str2, AbstractC1173q0.m1703g());
    }

    /* renamed from: a */
    public void m1480a(String str, String str2, String str3) {
        Context context = this.f1435a;
        if (context == null) {
            C1182v.m1785e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String m1719b = C1175r0.m1719b(context);
        if (AbstractC1126a1.m1418e(str, str2) && !"WIFI".equals(m1719b)) {
            C1182v.m1781c("hmsSdk", "strNetworkType is :" + m1719b);
            return;
        }
        if (SystemUtils.UNKNOWN.equals(m1719b) || "none".equals(m1719b) || "2G".equals(m1719b)) {
            C1182v.m1785e("hmsSdk", "The network is bad.");
        } else {
            C1128b0.m1437c().m1438a(new C1183v0(str, str2, str3));
        }
    }
}
