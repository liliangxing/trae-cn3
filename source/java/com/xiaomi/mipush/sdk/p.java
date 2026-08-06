package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class p {
    private static volatile p a;

    /* renamed from: a, reason: collision with other field name */
    private Context f119a;

    /* renamed from: a, reason: collision with other field name */
    private List<n> f120a = new ArrayList();

    private p(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f119a = applicationContext;
        if (applicationContext == null) {
            this.f119a = context;
        }
    }

    public static p a(Context context) {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p(context);
                }
            }
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9582a(String str) {
        synchronized (this.f120a) {
            n nVar = new n();
            nVar.a = 0;
            nVar.f117a = str;
            if (this.f120a.contains(nVar)) {
                this.f120a.remove(nVar);
            }
            this.f120a.add(nVar);
        }
    }

    public void b(String str) {
        synchronized (this.f120a) {
            n nVar = new n();
            nVar.f117a = str;
            if (this.f120a.contains(nVar)) {
                Iterator<n> it = this.f120a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (nVar.equals(next)) {
                        nVar = next;
                        break;
                    }
                }
            }
            nVar.a++;
            this.f120a.remove(nVar);
            this.f120a.add(nVar);
        }
    }

    public int a(String str) {
        synchronized (this.f120a) {
            n nVar = new n();
            nVar.f117a = str;
            if (this.f120a.contains(nVar)) {
                for (n nVar2 : this.f120a) {
                    if (nVar2.equals(nVar)) {
                        return nVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public void c(String str) {
        synchronized (this.f120a) {
            n nVar = new n();
            nVar.f117a = str;
            if (this.f120a.contains(nVar)) {
                this.f120a.remove(nVar);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m9583a(String str) {
        synchronized (this.f120a) {
            n nVar = new n();
            nVar.f117a = str;
            return this.f120a.contains(nVar);
        }
    }

    public synchronized String a(v vVar) {
        return this.f119a.getSharedPreferences("mipush_extra", 0).getString(vVar.name(), "");
    }

    public synchronized void a(v vVar, String str) {
        SharedPreferences sharedPreferences = this.f119a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(vVar.name(), str).apply();
    }
}
