package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.mipush.sdk.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1457p {

    /* renamed from: a */
    private static volatile C1457p f869a;

    /* renamed from: a */
    private Context f870a;

    /* renamed from: a */
    private List<C1455n> f871a = new ArrayList();

    private C1457p(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f870a = applicationContext;
        if (applicationContext == null) {
            this.f870a = context;
        }
    }

    /* renamed from: a */
    public static C1457p m1333a(Context context) {
        if (f869a == null) {
            synchronized (C1457p.class) {
                if (f869a == null) {
                    f869a = new C1457p(context);
                }
            }
        }
        return f869a;
    }

    /* renamed from: a */
    public void m1337a(String str) {
        synchronized (this.f871a) {
            C1455n c1455n = new C1455n();
            c1455n.f865a = 0;
            c1455n.f866a = str;
            if (this.f871a.contains(c1455n)) {
                this.f871a.remove(c1455n);
            }
            this.f871a.add(c1455n);
        }
    }

    /* renamed from: b */
    public void m1339b(String str) {
        synchronized (this.f871a) {
            C1455n c1455n = new C1455n();
            c1455n.f866a = str;
            if (this.f871a.contains(c1455n)) {
                Iterator<C1455n> it = this.f871a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1455n next = it.next();
                    if (c1455n.equals(next)) {
                        c1455n = next;
                        break;
                    }
                }
            }
            c1455n.f865a++;
            this.f871a.remove(c1455n);
            this.f871a.add(c1455n);
        }
    }

    /* renamed from: a */
    public int m1334a(String str) {
        synchronized (this.f871a) {
            C1455n c1455n = new C1455n();
            c1455n.f866a = str;
            if (this.f871a.contains(c1455n)) {
                for (C1455n c1455n2 : this.f871a) {
                    if (c1455n2.equals(c1455n)) {
                        return c1455n2.f865a;
                    }
                }
            }
            return 0;
        }
    }

    /* renamed from: c */
    public void m1340c(String str) {
        synchronized (this.f871a) {
            C1455n c1455n = new C1455n();
            c1455n.f866a = str;
            if (this.f871a.contains(c1455n)) {
                this.f871a.remove(c1455n);
            }
        }
    }

    /* renamed from: a */
    public boolean m1338a(String str) {
        synchronized (this.f871a) {
            C1455n c1455n = new C1455n();
            c1455n.f866a = str;
            return this.f871a.contains(c1455n);
        }
    }

    /* renamed from: a */
    public synchronized String m1335a(EnumC1463v enumC1463v) {
        return this.f870a.getSharedPreferences("mipush_extra", 0).getString(enumC1463v.name(), "");
    }

    /* renamed from: a */
    public synchronized void m1336a(EnumC1463v enumC1463v, String str) {
        SharedPreferences sharedPreferences = this.f870a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(enumC1463v.name(), str).apply();
    }
}
