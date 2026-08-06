package com.huawei.secure.android.common.util;

/* renamed from: com.huawei.secure.android.common.util.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1308a {

    /* renamed from: a */
    private String f2257a;

    /* renamed from: b */
    private Character f2258b;

    /* renamed from: c */
    private Character f2259c;

    /* renamed from: d */
    private int f2260d = 0;

    /* renamed from: e */
    private int f2261e = 0;

    public C1308a(String str) {
        this.f2257a = str;
    }

    /* renamed from: c */
    public static boolean m2497c(Character ch) {
        char charValue;
        return ch != null && (charValue = ch.charValue()) >= '0' && charValue <= '7';
    }

    /* renamed from: a */
    public void m2498a(Character ch) {
        this.f2258b = ch;
    }

    /* renamed from: b */
    public int m2501b() {
        return this.f2260d;
    }

    /* renamed from: d */
    public Character m2503d() {
        Character ch = this.f2258b;
        if (ch != null) {
            this.f2258b = null;
            return ch;
        }
        String str = this.f2257a;
        if (str == null || str.length() == 0 || this.f2260d >= this.f2257a.length()) {
            return null;
        }
        String str2 = this.f2257a;
        int i = this.f2260d;
        this.f2260d = i + 1;
        return Character.valueOf(str2.charAt(i));
    }

    /* renamed from: e */
    public Character m2504e() {
        Character m2503d = m2503d();
        if (m2503d != null && m2496b(m2503d)) {
            return m2503d;
        }
        return null;
    }

    /* renamed from: f */
    public Character m2505f() {
        Character m2503d = m2503d();
        if (m2503d != null && m2497c(m2503d)) {
            return m2503d;
        }
        return null;
    }

    /* renamed from: g */
    public Character m2506g() {
        Character ch = this.f2258b;
        if (ch != null) {
            return ch;
        }
        String str = this.f2257a;
        if (str == null || str.length() == 0 || this.f2260d >= this.f2257a.length()) {
            return null;
        }
        return Character.valueOf(this.f2257a.charAt(this.f2260d));
    }

    /* renamed from: h */
    protected String m2507h() {
        String substring = this.f2257a.substring(this.f2260d);
        return this.f2258b != null ? this.f2258b + substring : substring;
    }

    /* renamed from: i */
    public void m2508i() {
        this.f2258b = this.f2259c;
        this.f2260d = this.f2261e;
    }

    /* renamed from: b */
    public static boolean m2496b(Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    /* renamed from: a */
    public boolean m2499a() {
        if (this.f2258b != null) {
            return true;
        }
        String str = this.f2257a;
        return (str == null || str.length() == 0 || this.f2260d >= this.f2257a.length()) ? false : true;
    }

    /* renamed from: c */
    public void m2502c() {
        this.f2259c = this.f2258b;
        this.f2261e = this.f2260d;
    }

    /* renamed from: a */
    public boolean m2500a(char c) {
        Character ch = this.f2258b;
        if (ch != null && ch.charValue() == c) {
            return true;
        }
        String str = this.f2257a;
        return str != null && str.length() != 0 && this.f2260d < this.f2257a.length() && this.f2257a.charAt(this.f2260d) == c;
    }
}
