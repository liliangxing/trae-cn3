package com.cmic.sso.sdk.p003c.p007d;

/* compiled from: HttpErrorResponse.java */
/* renamed from: com.cmic.sso.sdk.c.d.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0126a {

    /* renamed from: a */
    private int f272a;

    /* renamed from: b */
    private String f273b;

    private C0126a(int i, String str) {
        this.f272a = i;
        this.f273b = str;
    }

    /* renamed from: a */
    public int m278a() {
        return this.f272a;
    }

    /* renamed from: b */
    public String m279b() {
        return this.f273b;
    }

    /* renamed from: a */
    public static C0126a m277a(int i) {
        switch (i) {
            case 102102:
                return new C0126a(102102, "网络异常");
            case 102223:
                return new C0126a(102223, "数据解析异常");
            case 102508:
                return new C0126a(102508, "数据网络切换失败");
            case 200025:
                return new C0126a(200025, "登录超时");
            case 200039:
                return new C0126a(200039, "电信取号接口失败");
            case 200050:
                return new C0126a(200050, "EOF异常");
            default:
                return new C0126a(i, "网络异常");
        }
    }
}
