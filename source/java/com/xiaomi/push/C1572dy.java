package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.XMJobService;

/* renamed from: com.xiaomi.push.dy */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1572dy {

    /* renamed from: a */
    private static a f1501a;

    /* renamed from: a */
    private static final String f1502a = XMJobService.class.getCanonicalName();

    /* renamed from: a */
    private static int f1500a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.dy$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        void mo2329a();

        /* renamed from: a */
        void mo2330a(boolean z);

        /* renamed from: a */
        boolean mo2331a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r6.equals(com.xiaomi.push.C1702q.m3463a(r9, r5.name).getSuperclass().getCanonicalName()) != false) goto L15;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2325a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f1501a = new C1573dz(applicationContext);
            return;
        }
        int i = 0;
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
            if (packageInfo.services != null) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                int length = serviceInfoArr.length;
                int i2 = 0;
                while (i < length) {
                    try {
                        ServiceInfo serviceInfo = serviceInfoArr[i];
                        if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            String str = f1502a;
                            if (!str.equals(serviceInfo.name)) {
                            }
                            i2 = 1;
                            if (i2 == 1) {
                                break;
                            }
                        }
                        if (f1502a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            i = 1;
                            break;
                        }
                        i++;
                    } catch (Exception e) {
                        e = e;
                        i = i2;
                        AbstractC1417b.m1089a("check service err : " + e.getMessage());
                        if (i != 0) {
                        }
                        f1501a = new C1573dz(applicationContext);
                    }
                }
                i = i2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (i != 0 && C1702q.m3467a(applicationContext)) {
            throw new RuntimeException("Should export service: " + f1502a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
        }
        f1501a = new C1573dz(applicationContext);
    }

    /* renamed from: a */
    public static synchronized void m2326a(Context context, int i) {
        synchronized (C1572dy.class) {
            int i2 = f1500a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    f1500a = 2;
                } else {
                    f1500a = 0;
                }
            }
            int i3 = f1500a;
            if (i2 != i3 && i3 == 2) {
                m2324a();
                f1501a = new C1576eb(context);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m2327a(boolean z) {
        synchronized (C1572dy.class) {
            if (f1501a == null) {
                AbstractC1417b.m1089a("timer is not initialized");
            } else {
                AbstractC1417b.m1089a("[Alarm] register alarm. (" + z + ")");
                f1501a.mo2330a(z);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m2324a() {
        synchronized (C1572dy.class) {
            if (f1501a == null) {
                return;
            }
            AbstractC1417b.m1089a("[Alarm] stop alarm.");
            f1501a.mo2329a();
        }
    }

    /* renamed from: a */
    public static synchronized boolean m2328a() {
        synchronized (C1572dy.class) {
            a aVar = f1501a;
            if (aVar == null) {
                return false;
            }
            return aVar.mo2331a();
        }
    }
}
