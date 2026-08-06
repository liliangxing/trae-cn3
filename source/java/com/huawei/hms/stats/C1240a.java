package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AnalyticsCacheManager.java */
/* renamed from: com.huawei.hms.stats.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1240a {

    /* renamed from: f */
    private static final C1240a f1762f = new C1240a();

    /* renamed from: a */
    private final Object f1763a = new Object();

    /* renamed from: b */
    private boolean f1764b = false;

    /* renamed from: c */
    private final List<Runnable> f1765c = new ArrayList();

    /* renamed from: d */
    private final Handler f1766d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final Runnable f1767e = new a();

    /* compiled from: AnalyticsCacheManager.java */
    /* renamed from: com.huawei.hms.stats.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m2120i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (!HiAnalyticsUtils.getInstance().getInitFlag()) {
                C1240a.this.m2059a();
            } else {
                C1240a.this.m2061b();
            }
        }
    }

    private C1240a() {
    }

    /* renamed from: c */
    public static C1240a m2058c() {
        return f1762f;
    }

    /* renamed from: a */
    public void m2060a(Runnable runnable) {
        synchronized (this.f1763a) {
            if (runnable == null) {
                return;
            }
            if (this.f1764b) {
                return;
            }
            if (this.f1765c.size() >= 60) {
                return;
            }
            this.f1765c.add(runnable);
            this.f1766d.removeCallbacks(this.f1767e);
            this.f1766d.postDelayed(this.f1767e, C0878a.f531q);
        }
    }

    /* renamed from: b */
    public void m2061b() {
        synchronized (this.f1763a) {
            HMSLog.m2120i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f1765c.size());
            this.f1764b = true;
            try {
                Iterator<Runnable> it = this.f1765c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th) {
                HMSLog.m2118e("AnalyticsCacheManager", "<execCacheBi> failed. " + th.getMessage());
                m2059a();
            }
            this.f1764b = false;
        }
    }

    /* renamed from: a */
    public void m2059a() {
        synchronized (this.f1763a) {
            HMSLog.m2120i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f1765c.clear();
        }
    }
}
