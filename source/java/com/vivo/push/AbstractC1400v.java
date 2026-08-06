package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.util.C1393t;

/* compiled from: PushCommand.java */
/* renamed from: com.vivo.push.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1400v {

    /* renamed from: a */
    private int f726a;

    /* renamed from: b */
    private String f727b;

    /* renamed from: c */
    public static long m1061c() {
        return 0L;
    }

    /* renamed from: c */
    protected abstract void mo582c(C1232d c1232d);

    /* renamed from: d */
    protected abstract void mo583d(C1232d c1232d);

    /* renamed from: d */
    public boolean mo634d() {
        return false;
    }

    public AbstractC1400v(int i) {
        this.f726a = -1;
        if (i < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f726a = i;
    }

    /* renamed from: a */
    public final String m1063a() {
        return this.f727b;
    }

    /* renamed from: a */
    public final void m1066a(String str) {
        this.f727b = str;
    }

    /* renamed from: b */
    public final int m1067b() {
        return this.f726a;
    }

    /* renamed from: a */
    public final void m1064a(Intent intent) {
        C1232d m648a = C1232d.m648a(intent);
        if (m648a == null) {
            C1393t.m1041b("PushCommand", "bundleWapper is null");
            return;
        }
        m1065a(m648a);
        Bundle m660b = m648a.m660b();
        if (m660b != null) {
            intent.putExtras(m660b);
        }
    }

    /* renamed from: a */
    public final void m1065a(C1232d c1232d) {
        String m1070a = C1402x.m1070a(this.f726a);
        if (m1070a == null) {
            m1070a = "";
        }
        c1232d.m654a("method", m1070a);
        m1062e(c1232d);
    }

    /* renamed from: b */
    public final void m1068b(Intent intent) {
        C1232d m648a = C1232d.m648a(intent);
        if (m648a == null) {
            C1393t.m1041b("PushCommand", "bundleWapper is null");
            return;
        }
        m648a.m651a("method", this.f726a);
        m1062e(m648a);
        Bundle m660b = m648a.m660b();
        if (m660b != null) {
            intent.putExtras(m660b);
        }
    }

    /* renamed from: e */
    private void m1062e(C1232d c1232d) {
        c1232d.m651a("command", this.f726a);
        c1232d.m654a("client_pkgname", this.f727b);
        mo582c(c1232d);
    }

    /* renamed from: b */
    public final void m1069b(C1232d c1232d) {
        String m649a = c1232d.m649a();
        if (!TextUtils.isEmpty(m649a)) {
            this.f727b = m649a;
        } else {
            this.f727b = c1232d.m650a("client_pkgname");
        }
        mo583d(c1232d);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
