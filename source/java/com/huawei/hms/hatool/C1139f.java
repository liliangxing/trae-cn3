package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1139f implements InterfaceRunnableC1142g {

    /* renamed from: a */
    private byte[] f1436a;

    /* renamed from: b */
    private String f1437b;

    /* renamed from: c */
    private String f1438c;

    /* renamed from: d */
    private String f1439d;

    /* renamed from: e */
    private String f1440e;

    /* renamed from: f */
    private List<C1129b1> f1441f;

    public C1139f(byte[] bArr, String str, String str2, String str3, String str4, List<C1129b1> list) {
        this.f1436a = (byte[]) bArr.clone();
        this.f1437b = str;
        this.f1438c = str2;
        this.f1440e = str3;
        this.f1439d = str4;
        this.f1441f = list;
    }

    /* renamed from: a */
    private C1164n0 m1496a(Map<String, String> map) {
        return AbstractC1184w.m1788a(this.f1437b, this.f1436a, map);
    }

    /* renamed from: a */
    private Map<String, String> m1497a() {
        return C1154k.m1588b(this.f1438c, this.f1440e, this.f1439d);
    }

    /* renamed from: b */
    private void m1498b() {
        C1128b0.m1437c().m1438a(new C1135d1(this.f1441f, this.f1438c, this.f1439d, this.f1440e));
    }

    @Override // java.lang.Runnable
    public void run() {
        C1182v.m1775a("hmsSdk", "send data running");
        int m1644b = m1496a(m1497a()).m1644b();
        if (m1644b != 200) {
            m1498b();
        } else {
            C1182v.m1779b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f1439d, this.f1440e, this.f1438c, Integer.valueOf(m1644b));
        }
    }
}
