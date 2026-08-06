package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.n0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0943n0<TResult> {

    /* renamed from: a */
    public final C0908a1<TResult> f745a = new C0908a1<>();

    /* renamed from: a */
    public void m777a(TResult tresult) {
        C0908a1<TResult> c0908a1 = this.f745a;
        synchronized (c0908a1.f684a) {
            if (!c0908a1.f685b) {
                c0908a1.f685b = true;
                c0908a1.f686c = tresult;
                c0908a1.f684a.notifyAll();
                c0908a1.m734a();
            }
        }
    }

    /* renamed from: a */
    public void m776a(Exception exc) {
        C0908a1<TResult> c0908a1 = this.f745a;
        synchronized (c0908a1.f684a) {
            if (!c0908a1.f685b) {
                c0908a1.f685b = true;
                c0908a1.f687d = exc;
                c0908a1.f684a.notifyAll();
                c0908a1.m734a();
            }
        }
    }
}
