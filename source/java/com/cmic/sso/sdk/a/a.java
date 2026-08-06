package com.cmic.sso.sdk.a;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: UmcConfigBean.java */
/* loaded from: classes6.dex */
public class a implements Cloneable {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;

    private a() {
        this.a = "rcs.cmpassport.com";
        this.b = "rcs.cmpassport.com";
        this.c = "config2.cmpassport.com";
        this.d = "log2.cmpassport.com:9443";
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = 3;
        this.l = 1;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    public String toString() {
        return "UmcConfigBean{mHttpsGetTokenHost='" + this.a + "', mHttpsGetPhoneScripHost='" + this.b + "', mConfigHost='" + this.c + "', mLogHost='" + this.d + "', mCloseCtccWork=" + this.e + ", mCloseCuccWort=" + this.f + ", mCloseM008Business=" + this.g + ", mCloseGetPhoneIpv4=" + this.h + ", mCloseGetPhoneIpv6=" + this.i + ", mCloseLog=" + this.j + ", mMaxFailedLogTimes=" + this.k + ", mLogSuspendTime=" + this.l + AbstractJsonLexerKt.END_OBJ;
    }

    /* compiled from: UmcConfigBean.java */
    /* renamed from: com.cmic.sso.sdk.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0132a {
        private final a a = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a a(String str) {
            this.a.a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a b(String str) {
            this.a.b = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a c(String str) {
            this.a.c = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a d(String str) {
            this.a.d = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a a(boolean z) {
            this.a.e = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a b(boolean z) {
            this.a.f = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a c(boolean z) {
            this.a.g = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a d(boolean z) {
            this.a.h = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a e(boolean z) {
            this.a.i = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a f(boolean z) {
            this.a.j = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a a(int i) {
            this.a.k = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0132a b(int i) {
            this.a.l = i;
            return this;
        }

        public a a() {
            return this.a;
        }
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a clone() throws CloneNotSupportedException {
        return (a) super.clone();
    }
}
