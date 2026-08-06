package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.hms.hatool.z0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1191z0 {

    /* renamed from: a */
    private String f1589a;

    /* renamed from: b */
    public C1159l1 f1590b;

    public C1191z0(String str) {
        this.f1589a = str;
        this.f1590b = new C1159l1(str);
        C1176s.m1722c().m1726a(this.f1589a, this.f1590b);
    }

    /* renamed from: b */
    private C1177s0 m1828b(int i) {
        if (i == 0) {
            return this.f1590b.m1619c();
        }
        if (i == 1) {
            return this.f1590b.m1617b();
        }
        if (i == 2) {
            return this.f1590b.m1620d();
        }
        if (i != 3) {
            return null;
        }
        return this.f1590b.m1614a();
    }

    /* renamed from: c */
    private boolean m1829c(int i) {
        String str;
        if (i != 2) {
            C1177s0 m1828b = m1828b(i);
            if (m1828b != null && !TextUtils.isEmpty(m1828b.m1751h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i;
        } else {
            if ("_default_config_tag".equals(this.f1589a)) {
                return true;
            }
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        C1182v.m1785e("hmsSdk", str);
        return false;
    }

    /* renamed from: a */
    public void m1830a(int i) {
        C1182v.m1783d("hmsSdk", "onReport. TAG: " + this.f1589a + ", TYPE: " + i);
        C1143g0.m1502a().m1506a(this.f1589a, i);
    }

    /* renamed from: a */
    public void m1831a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        C1182v.m1783d("hmsSdk", "onEvent. TAG: " + this.f1589a + ", TYPE: " + i + ", eventId : " + str);
        if (C1138e1.m1492a(str) || !m1829c(i)) {
            C1182v.m1785e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f1589a + ", TYPE: " + i);
            return;
        }
        if (!C1138e1.m1495a(linkedHashMap)) {
            C1182v.m1785e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f1589a + ", TYPE: " + i);
            linkedHashMap = null;
        }
        C1143g0.m1502a().m1507a(this.f1589a, i, str, linkedHashMap);
    }

    /* renamed from: a */
    public void m1832a(Context context, String str, String str2) {
        C1182v.m1783d("hmsSdk", "onEvent(context). TAG: " + this.f1589a + ", eventId : " + str);
        if (context == null) {
            C1182v.m1785e("hmsSdk", "context is null in onevent ");
            return;
        }
        if (C1138e1.m1492a(str) || !m1829c(0)) {
            C1182v.m1785e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f1589a);
            return;
        }
        if (!C1138e1.m1493a(CustomDataTagHandler.VALUE_ATTRIBUTE, str2, 65536)) {
            C1182v.m1785e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f1589a);
            str2 = "";
        }
        C1143g0.m1502a().m1508a(this.f1589a, context, str, str2);
    }

    /* renamed from: a */
    public void m1833a(C1177s0 c1177s0) {
        C1182v.m1775a("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f1589a);
        if (c1177s0 != null) {
            this.f1590b.m1616a(c1177s0);
        } else {
            C1182v.m1785e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f1590b.m1616a((C1177s0) null);
        }
    }

    /* renamed from: b */
    public void m1834b(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        C1182v.m1783d("hmsSdk", "onStreamEvent. TAG: " + this.f1589a + ", TYPE: " + i + ", eventId : " + str);
        if (C1138e1.m1492a(str) || !m1829c(i)) {
            C1182v.m1785e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f1589a + ", TYPE: " + i);
            return;
        }
        if (!C1138e1.m1495a(linkedHashMap)) {
            C1182v.m1785e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f1589a + ", TYPE: " + i);
            linkedHashMap = null;
        }
        C1143g0.m1502a().m1509b(this.f1589a, i, str, linkedHashMap);
    }

    /* renamed from: b */
    public void m1835b(C1177s0 c1177s0) {
        C1182v.m1775a("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f1589a);
        if (c1177s0 != null) {
            this.f1590b.m1618b(c1177s0);
        } else {
            this.f1590b.m1618b(null);
            C1182v.m1785e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }
}
