package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.AbstractC1528ch;
import com.xiaomi.push.C1471ae;
import com.xiaomi.push.C1493b;
import com.xiaomi.push.C1520c;
import com.xiaomi.push.C1561dn;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.C1625fx;
import com.xiaomi.push.C1682i;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.C1801v;
import com.xiaomi.push.InterfaceC1485as;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.ax */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1766ax {

    /* renamed from: a */
    private static C1766ax f3095a = new C1766ax();

    /* renamed from: a */
    private static String f3096a;

    /* renamed from: a */
    private C1471ae.b f3097a;

    /* renamed from: a */
    private C1561dn.a f3098a;

    /* renamed from: a */
    private List<a> f3099a = new ArrayList();

    /* renamed from: com.xiaomi.push.service.ax$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class a {
        /* renamed from: a */
        public void mo3735a(C1561dn.a aVar) {
        }

        /* renamed from: a */
        public void mo2412a(C1562do.b bVar) {
        }
    }

    /* renamed from: a */
    public static C1766ax m3768a() {
        return f3095a;
    }

    private C1766ax() {
    }

    /* renamed from: a */
    public synchronized void m3780a(a aVar) {
        this.f3099a.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m3778a() {
        this.f3099a.clear();
    }

    /* renamed from: b */
    private void m3772b() {
        if (this.f3098a == null) {
            m3774d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m3776a() {
        m3772b();
        C1561dn.a aVar = this.f3098a;
        if (aVar != null) {
            return aVar.m2072c();
        }
        return 0;
    }

    /* renamed from: a */
    public C1561dn.a m3777a() {
        m3772b();
        return this.f3098a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3779a(C1562do.b bVar) {
        a[] aVarArr;
        if (bVar.m2129d() && bVar.m2128d() > m3776a()) {
            m3773c();
        }
        synchronized (this) {
            List<a> list = this.f3099a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.mo2412a(bVar);
        }
    }

    /* renamed from: a */
    public static synchronized String m3769a() {
        String str;
        synchronized (C1766ax.class) {
            if (f3096a == null) {
                SharedPreferences sharedPreferences = C1702q.m3462a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f3096a = string;
                if (string == null) {
                    String m3382a = C1682i.m3382a(C1702q.m3462a(), false);
                    f3096a = m3382a;
                    if (m3382a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f3096a).commit();
                    }
                }
            }
            str = f3096a;
        }
        return str;
    }

    /* renamed from: c */
    private void m3773c() {
        if (this.f3097a != null) {
            return;
        }
        C1471ae.b bVar = new C1471ae.b() { // from class: com.xiaomi.push.service.ax.1

            /* renamed from: a */
            boolean f3101a = false;

            @Override // com.xiaomi.push.C1471ae.b
            /* renamed from: b */
            public void mo1470b() {
                try {
                    C1561dn.a m2058a = C1561dn.a.m2058a(Base64.decode(AbstractC1528ch.m1853a(C1702q.m3462a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<InterfaceC1485as>) null), 10));
                    if (m2058a != null) {
                        C1766ax.this.f3098a = m2058a;
                        this.f3101a = true;
                        C1766ax.this.m3775e();
                    }
                } catch (Exception e) {
                    AbstractC1417b.m1089a("fetch config failure: " + e.getMessage());
                }
            }

            @Override // com.xiaomi.push.C1471ae.b
            /* renamed from: c */
            public void mo1471c() {
                a[] aVarArr;
                C1766ax.this.f3097a = null;
                if (this.f3101a) {
                    synchronized (C1766ax.this) {
                        aVarArr = (a[]) C1766ax.this.f3099a.toArray(new a[C1766ax.this.f3099a.size()]);
                    }
                    for (a aVar : aVarArr) {
                        aVar.mo3735a(C1766ax.this.f3098a);
                    }
                }
            }
        };
        this.f3097a = bVar;
        C1625fx.m2651a(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m3774d() {
        BufferedInputStream bufferedInputStream;
        Exception e;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(C1702q.m3462a().openFileInput("XMCloudCfg"));
                try {
                    this.f3098a = C1561dn.a.m2059b(C1493b.m1598a(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    AbstractC1417b.m1089a("load config failure: " + e.getMessage());
                    C1801v.m4105a((Closeable) bufferedInputStream);
                    if (this.f3098a != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                C1801v.m4105a((Closeable) bufferedInputStream2);
                throw th;
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            C1801v.m4105a((Closeable) bufferedInputStream2);
            throw th;
        }
        C1801v.m4105a((Closeable) bufferedInputStream);
        if (this.f3098a != null) {
            this.f3098a = new C1561dn.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3775e() {
        try {
            if (this.f3098a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(C1702q.m3462a().openFileOutput("XMCloudCfg", 0));
                C1520c m1737a = C1520c.m1737a(bufferedOutputStream);
                this.f3098a.mo2066a(m1737a);
                m1737a.m1749a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            AbstractC1417b.m1089a("save config failure: " + e.getMessage());
        }
    }
}
