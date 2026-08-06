package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C0878a;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1180u {

    /* renamed from: a */
    private List<C1129b1> f1574a;

    /* renamed from: b */
    private String f1575b;

    /* renamed from: c */
    private String f1576c;

    /* renamed from: d */
    private String f1577d;

    public C1180u(List<C1129b1> list, String str, String str2, String str3) {
        this.f1574a = list;
        this.f1575b = str;
        this.f1576c = str2;
        this.f1577d = str3;
    }

    /* renamed from: a */
    private void m1767a(List<C1129b1> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i = 0; i < size; i++) {
            int i2 = i * 500;
            List<C1129b1> subList = list.subList(i2, Math.min(list.size(), i2 + 500));
            String replace = UUID.randomUUID().toString().replace("-", "");
            long currentTimeMillis = System.currentTimeMillis();
            long m1415b = AbstractC1126a1.m1415b(str2, str) * C0878a.f520f;
            ArrayList arrayList = new ArrayList();
            for (C1129b1 c1129b1 : subList) {
                if (!C1131c0.m1455a(c1129b1.m1442b(), currentTimeMillis, m1415b)) {
                    arrayList.add(c1129b1);
                }
            }
            if (arrayList.size() > 0) {
                new C1158l0(str2, str, this.f1577d, arrayList, replace).m1613a();
            } else {
                C1182v.m1785e("hmsSdk", "No data to report handler");
            }
        }
    }

    /* renamed from: a */
    public void m1768a() {
        if (!"_default_config_tag".equals(this.f1576c)) {
            m1767a(this.f1574a, this.f1576c, this.f1575b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (C1129b1 c1129b1 : this.f1574a) {
            String m1444c = c1129b1.m1444c();
            if (TextUtils.isEmpty(m1444c) || "oper".equals(m1444c)) {
                arrayList4.add(c1129b1);
            } else if ("maint".equals(m1444c)) {
                arrayList.add(c1129b1);
            } else if ("preins".equals(m1444c)) {
                arrayList2.add(c1129b1);
            } else if ("diffprivacy".equals(m1444c)) {
                arrayList3.add(c1129b1);
            }
        }
        m1767a(arrayList4, "oper", "_default_config_tag");
        m1767a(arrayList, "maint", "_default_config_tag");
        m1767a(arrayList2, "preins", "_default_config_tag");
        m1767a(arrayList3, "diffprivacy", "_default_config_tag");
    }
}
