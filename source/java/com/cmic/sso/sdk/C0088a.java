package com.cmic.sso.sdk;

import com.cmic.sso.sdk.p001a.C0089a;
import com.cmic.sso.sdk.p008d.C0129a;
import com.cmic.sso.sdk.p009e.C0133c;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ConcurrentBundle.java */
/* renamed from: com.cmic.sso.sdk.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0088a {

    /* renamed from: a */
    private ConcurrentHashMap<String, Object> f94a;

    public C0088a(int i) {
        this.f94a = new ConcurrentHashMap<>(i);
    }

    /* renamed from: a */
    public void m62a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return;
        }
        this.f94a.put(str, bArr);
    }

    /* renamed from: a */
    public byte[] m63a(String str) {
        if (str != null) {
            return (byte[]) this.f94a.get(str);
        }
        return null;
    }

    /* renamed from: a */
    public void m60a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f94a.put(str, str2);
    }

    /* renamed from: b */
    public String m67b(String str) {
        return m68b(str, "");
    }

    /* renamed from: b */
    public String m68b(String str, String str2) {
        return (str == null || !this.f94a.containsKey(str)) ? str2 : (String) this.f94a.get(str);
    }

    /* renamed from: a */
    public void m61a(String str, boolean z) {
        if (str != null) {
            this.f94a.put(str, Boolean.valueOf(z));
        }
    }

    /* renamed from: b */
    public boolean m69b(String str, boolean z) {
        return (str == null || !this.f94a.containsKey(str)) ? z : ((Boolean) this.f94a.get(str)).booleanValue();
    }

    /* renamed from: a */
    public void m58a(String str, int i) {
        if (str != null) {
            this.f94a.put(str, Integer.valueOf(i));
        }
    }

    /* renamed from: c */
    public int m70c(String str) {
        return m64b(str, 0);
    }

    /* renamed from: b */
    public int m64b(String str, int i) {
        return (str == null || !this.f94a.containsKey(str)) ? i : ((Integer) this.f94a.get(str)).intValue();
    }

    /* renamed from: a */
    public void m59a(String str, long j) {
        if (str != null) {
            this.f94a.put(str, Long.valueOf(j));
        }
    }

    /* renamed from: b */
    public long m65b(String str, long j) {
        return (str == null || !this.f94a.containsKey(str)) ? j : ((Long) this.f94a.get(str)).longValue();
    }

    /* renamed from: a */
    public void m57a(C0129a c0129a) {
        if (c0129a != null) {
            this.f94a.put("logBean", c0129a);
        }
    }

    /* renamed from: a */
    public C0129a m55a() {
        C0129a c0129a = (C0129a) this.f94a.get("logBean");
        return c0129a != null ? c0129a : new C0129a();
    }

    /* renamed from: a */
    public void m56a(C0089a c0089a) {
        if (c0089a != null) {
            this.f94a.put("current_config", c0089a);
        }
    }

    /* renamed from: b */
    public C0089a m66b() {
        C0089a c0089a = (C0089a) this.f94a.get("current_config");
        if (c0089a != null) {
            return c0089a;
        }
        C0133c.m326a("UmcConfigBean为空", "请核查");
        return new C0089a.a().m99a();
    }
}
