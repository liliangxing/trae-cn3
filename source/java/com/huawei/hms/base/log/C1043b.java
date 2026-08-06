package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: LogAdaptor.java */
/* renamed from: com.huawei.hms.base.log.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1043b {

    /* renamed from: b */
    private String f1112b;

    /* renamed from: a */
    private int f1111a = 4;

    /* renamed from: c */
    private InterfaceC1045d f1113c = new C1044c();

    /* renamed from: a */
    public void m1046a(Context context, int i, String str) {
        this.f1111a = i;
        this.f1112b = str;
        this.f1113c.mo1039a(context, "HMSCore");
    }

    /* renamed from: b */
    public void m1050b(int i, String str, String str2, Throwable th) {
        try {
            if (m1049a(i)) {
                C1046e m1042a = m1042a(i, str, str2, th);
                this.f1113c.mo1041a(m1042a.m1058c() + m1042a.m1057a(), i, str, str2 + '\n' + Log.getStackTraceString(th));
            }
        } catch (OutOfMemoryError unused) {
            m1043b();
        }
    }

    /* renamed from: a */
    public InterfaceC1045d m1044a() {
        return this.f1113c;
    }

    /* renamed from: a */
    public void m1047a(InterfaceC1045d interfaceC1045d) {
        this.f1113c = interfaceC1045d;
    }

    /* renamed from: a */
    public boolean m1049a(int i) {
        return i >= this.f1111a;
    }

    /* renamed from: a */
    public void m1045a(int i, String str, String str2) {
        try {
            if (m1049a(i)) {
                C1046e m1042a = m1042a(i, str, str2, null);
                this.f1113c.mo1041a(m1042a.m1058c() + m1042a.m1057a(), i, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            m1043b();
        }
    }

    /* renamed from: b */
    private void m1043b() {
        try {
            Log.e("HMSSDK_LogAdaptor", "log happened OOM error.");
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m1048a(String str, String str2) {
        try {
            C1046e m1042a = m1042a(4, str, str2, null);
            this.f1113c.mo1041a(m1042a.m1058c() + '\n' + m1042a.m1057a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            m1043b();
        }
    }

    /* renamed from: a */
    private C1046e m1042a(int i, String str, String str2, Throwable th) {
        C1046e c1046e = new C1046e(8, this.f1112b, i, str);
        c1046e.m1055a((C1046e) str2);
        c1046e.m1056a(th);
        return c1046e;
    }
}
