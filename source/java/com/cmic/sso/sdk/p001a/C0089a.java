package com.cmic.sso.sdk.p001a;

/* compiled from: UmcConfigBean.java */
/* renamed from: com.cmic.sso.sdk.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0089a implements Cloneable {

    /* renamed from: a */
    private String f95a;

    /* renamed from: b */
    private String f96b;

    /* renamed from: c */
    private String f97c;

    /* renamed from: d */
    private String f98d;

    /* renamed from: e */
    private boolean f99e;

    /* renamed from: f */
    private boolean f100f;

    /* renamed from: g */
    private boolean f101g;

    /* renamed from: h */
    private boolean f102h;

    /* renamed from: i */
    private boolean f103i;

    /* renamed from: j */
    private boolean f104j;

    /* renamed from: k */
    private int f105k;

    /* renamed from: l */
    private int f106l;

    private C0089a() {
        this.f95a = "rcs.cmpassport.com";
        this.f96b = "rcs.cmpassport.com";
        this.f97c = "config2.cmpassport.com";
        this.f98d = "log2.cmpassport.com:9443";
        this.f99e = false;
        this.f100f = false;
        this.f101g = false;
        this.f102h = false;
        this.f103i = false;
        this.f104j = false;
        this.f105k = 3;
        this.f106l = 1;
    }

    /* renamed from: a */
    public String m83a() {
        return this.f95a;
    }

    /* renamed from: b */
    public String m84b() {
        return this.f96b;
    }

    /* renamed from: c */
    public String m85c() {
        return this.f97c;
    }

    /* renamed from: d */
    public String m86d() {
        return this.f98d;
    }

    /* renamed from: e */
    public boolean m87e() {
        return this.f99e;
    }

    /* renamed from: f */
    public boolean m88f() {
        return this.f100f;
    }

    /* renamed from: g */
    public boolean m89g() {
        return this.f101g;
    }

    /* renamed from: h */
    public boolean m90h() {
        return this.f102h;
    }

    /* renamed from: i */
    public boolean m91i() {
        return this.f103i;
    }

    /* renamed from: j */
    public boolean m92j() {
        return this.f104j;
    }

    /* renamed from: k */
    public int m93k() {
        return this.f105k;
    }

    /* renamed from: l */
    public int m94l() {
        return this.f106l;
    }

    public String toString() {
        return "UmcConfigBean{mHttpsGetTokenHost='" + this.f95a + "', mHttpsGetPhoneScripHost='" + this.f96b + "', mConfigHost='" + this.f97c + "', mLogHost='" + this.f98d + "', mCloseCtccWork=" + this.f99e + ", mCloseCuccWort=" + this.f100f + ", mCloseM008Business=" + this.f101g + ", mCloseGetPhoneIpv4=" + this.f102h + ", mCloseGetPhoneIpv6=" + this.f103i + ", mCloseLog=" + this.f104j + ", mMaxFailedLogTimes=" + this.f105k + ", mLogSuspendTime=" + this.f106l + '}';
    }

    /* compiled from: UmcConfigBean.java */
    /* renamed from: com.cmic.sso.sdk.a.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class a {

        /* renamed from: a */
        private final C0089a f107a = new C0089a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public a m97a(String str) {
            this.f107a.f95a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public a m101b(String str) {
            this.f107a.f96b = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public a m103c(String str) {
            this.f107a.f97c = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public a m105d(String str) {
            this.f107a.f98d = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public a m98a(boolean z) {
            this.f107a.f99e = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public a m102b(boolean z) {
            this.f107a.f100f = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public a m104c(boolean z) {
            this.f107a.f101g = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public a m106d(boolean z) {
            this.f107a.f102h = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: e */
        public a m107e(boolean z) {
            this.f107a.f103i = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public a m108f(boolean z) {
            this.f107a.f104j = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public a m96a(int i) {
            this.f107a.f105k = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public a m100b(int i) {
            this.f107a.f106l = i;
            return this;
        }

        /* renamed from: a */
        public C0089a m99a() {
            return this.f107a;
        }
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0089a clone() throws CloneNotSupportedException {
        return (C0089a) super.clone();
    }
}
