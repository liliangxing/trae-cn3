package com.xiaomi.push;

import java.util.Map;

/* renamed from: com.xiaomi.push.fa */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1602fa implements Cloneable {

    /* renamed from: a */
    public static String f1721a = "wcc-ml-test10.bj";

    /* renamed from: b */
    public static String f1722b;

    /* renamed from: a */
    private int f1723a;

    /* renamed from: a */
    private InterfaceC1605fd f1724a;

    /* renamed from: a */
    private boolean f1725a = AbstractC1600ez.f1697a;

    /* renamed from: b */
    private boolean f1726b = true;

    /* renamed from: c */
    private String f1727c;

    /* renamed from: d */
    private String f1728d;

    /* renamed from: e */
    private String f1729e;

    /* renamed from: a */
    public byte[] mo2536a() {
        return null;
    }

    /* renamed from: a */
    public static final String m2530a() {
        String str = f1722b;
        return str != null ? str : C1802w.m4115a() ? "sandbox.xmpush.xiaomi.com" : C1802w.m4116b() ? "10.38.162.35" : "app.chat.xiaomi.net";
    }

    /* renamed from: a */
    public static final void m2531a(String str) {
        if (C1802w.m4116b()) {
            return;
        }
        f1722b = str;
    }

    public C1602fa(Map<String, Integer> map, int i, String str, InterfaceC1605fd interfaceC1605fd) {
        m2532a(map, i, str, interfaceC1605fd);
    }

    /* renamed from: a */
    private void m2532a(Map<String, Integer> map, int i, String str, InterfaceC1605fd interfaceC1605fd) {
        this.f1723a = i;
        this.f1727c = str;
        this.f1724a = interfaceC1605fd;
    }

    /* renamed from: b */
    public void m2538b(String str) {
        this.f1729e = str;
    }

    /* renamed from: b */
    public String m2537b() {
        return this.f1729e;
    }

    /* renamed from: a */
    public int m2533a() {
        return this.f1723a;
    }

    /* renamed from: c */
    public String m2539c() {
        if (this.f1728d == null) {
            this.f1728d = m2530a();
        }
        return this.f1728d;
    }

    /* renamed from: c */
    public void m2540c(String str) {
        this.f1728d = str;
    }

    /* renamed from: a */
    public boolean m2535a() {
        return this.f1725a;
    }

    /* renamed from: a */
    public void m2534a(boolean z) {
        this.f1725a = z;
    }
}
