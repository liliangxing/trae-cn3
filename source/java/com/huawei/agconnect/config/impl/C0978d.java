package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

/* renamed from: com.huawei.agconnect.config.impl.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0978d {

    /* renamed from: a */
    private final String f831a;

    /* renamed from: b */
    private final String f832b;

    /* renamed from: c */
    private final String f833c;

    /* renamed from: d */
    private final String f834d;

    /* renamed from: e */
    private final String f835e;

    /* renamed from: f */
    private final int f836f;

    /* renamed from: g */
    private int f837g;

    public C0978d(String str, String str2, String str3, String str4, String str5, int i) {
        this.f837g = 0;
        this.f831a = str;
        this.f832b = str2;
        this.f833c = str3;
        this.f834d = str4;
        this.f835e = str5;
        this.f836f = i;
        if (str != null) {
            this.f837g = str.length() / 2;
        }
    }

    /* renamed from: a */
    public boolean m800a() {
        return (TextUtils.isEmpty(this.f831a) || TextUtils.isEmpty(this.f832b) || TextUtils.isEmpty(this.f833c) || TextUtils.isEmpty(this.f834d) || this.f831a.length() != this.f832b.length() || this.f832b.length() != this.f833c.length() || this.f833c.length() != this.f837g * 2 || this.f836f < 0 || TextUtils.isEmpty(this.f835e)) ? false : true;
    }

    /* renamed from: b */
    public String m801b() {
        return this.f831a;
    }

    /* renamed from: c */
    public String m802c() {
        return this.f832b;
    }

    /* renamed from: d */
    public String m803d() {
        return this.f833c;
    }

    /* renamed from: e */
    public String m804e() {
        return this.f834d;
    }

    /* renamed from: f */
    public String m805f() {
        return this.f835e;
    }

    /* renamed from: g */
    public int m806g() {
        return this.f836f;
    }

    /* renamed from: h */
    public int m807h() {
        return this.f837g;
    }
}
