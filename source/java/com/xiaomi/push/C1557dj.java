package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.service.C1750ah;

/* renamed from: com.xiaomi.push.dj */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1557dj {

    /* renamed from: a */
    private static volatile C1557dj f1329a;

    /* renamed from: a */
    private Context f1330a;

    /* renamed from: a */
    private a f1331a;

    /* renamed from: com.xiaomi.push.dj$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        void m2042a();
    }

    /* renamed from: a */
    public static C1557dj m2036a(Context context) {
        if (f1329a == null) {
            synchronized (C1557dj.class) {
                if (f1329a == null) {
                    f1329a = new C1557dj(context);
                }
            }
        }
        return f1329a;
    }

    private C1557dj(Context context) {
        this.f1330a = context;
    }

    /* renamed from: a */
    public void m2041a() {
        C1470ad.m1444a(this.f1330a).m1449a(new Runnable() { // from class: com.xiaomi.push.dj.1
            @Override // java.lang.Runnable
            public void run() {
                C1557dj.this.m2040b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2040b() {
        a aVar;
        C1470ad m1444a = C1470ad.m1444a(this.f1330a);
        C1750ah m3674a = C1750ah.m3674a(this.f1330a);
        SharedPreferences sharedPreferences = this.f1330a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < 172800000) {
            return;
        }
        m2038a(m3674a, m1444a, false);
        if (m3674a.m3686a(EnumC1638gj.StorageCollectionSwitch.m2760a(), true)) {
            int m2035a = m2035a(m3674a.m3678a(EnumC1638gj.StorageCollectionFrequency.m2760a(), Constants.MAX_RETRY_AFTER));
            m1444a.m1453a(new C1559dl(this.f1330a, m2035a), m2035a, 0);
        }
        if (C1694j.m3427a(this.f1330a) && (aVar = this.f1331a) != null) {
            aVar.m2042a();
        }
        if (m3674a.m3686a(EnumC1638gj.ActivityTSSwitch.m2760a(), false)) {
            m2039a();
        }
        m2038a(m3674a, m1444a, true);
    }

    /* renamed from: a */
    private void m2038a(C1750ah c1750ah, C1470ad c1470ad, boolean z) {
        if (c1750ah.m3686a(EnumC1638gj.UploadSwitch.m2760a(), true)) {
            C1560dm c1560dm = new C1560dm(this.f1330a);
            if (z) {
                c1470ad.m1452a((C1470ad.a) c1560dm, m2035a(c1750ah.m3678a(EnumC1638gj.UploadFrequency.m2760a(), Constants.MAX_RETRY_AFTER)));
            } else {
                c1470ad.m1451a((C1470ad.a) c1560dm);
            }
        }
    }

    /* renamed from: a */
    public static int m2035a(int i) {
        return Math.max(60, i);
    }

    /* renamed from: a */
    private boolean m2039a() {
        Application application;
        try {
            Context context = this.f1330a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new C1551dd(this.f1330a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return false;
        }
    }
}
