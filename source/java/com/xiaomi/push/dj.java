package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.ad;

/* loaded from: classes7.dex */
public class dj {
    private static volatile dj a;

    /* renamed from: a, reason: collision with other field name */
    private Context f317a;

    /* renamed from: a, reason: collision with other field name */
    private a f318a;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public static dj a(Context context) {
        if (a == null) {
            synchronized (dj.class) {
                if (a == null) {
                    a = new dj(context);
                }
            }
        }
        return a;
    }

    private dj(Context context) {
        this.f317a = context;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9748a() {
        ad.a(this.f317a).a(new Runnable() { // from class: com.xiaomi.push.dj.1
            @Override // java.lang.Runnable
            public void run() {
                dj.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        ad a2 = ad.a(this.f317a);
        com.xiaomi.push.service.ah a3 = com.xiaomi.push.service.ah.a(this.f317a);
        SharedPreferences sharedPreferences = this.f317a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < 172800000) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(gj.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(gj.StorageCollectionFrequency.a(), 86400));
            a2.a(new dl(this.f317a, a4), a4, 0);
        }
        if (j.m10105a(this.f317a) && (aVar = this.f318a) != null) {
            aVar.a();
        }
        if (a3.a(gj.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(a3, a2, true);
    }

    private void a(com.xiaomi.push.service.ah ahVar, ad adVar, boolean z) {
        if (ahVar.a(gj.UploadSwitch.a(), true)) {
            dm dmVar = new dm(this.f317a);
            if (z) {
                adVar.a((ad.a) dmVar, a(ahVar.a(gj.UploadFrequency.a(), 86400)));
            } else {
                adVar.m9608a((ad.a) dmVar);
            }
        }
    }

    public static int a(int i) {
        return Math.max(60, i);
    }

    private boolean a() {
        Application application;
        try {
            Context context = this.f317a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new dd(this.f317a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
