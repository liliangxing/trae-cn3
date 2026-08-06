package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1467aa;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1699o;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.service.ay */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1767ay implements InterfaceC1743aa {

    /* renamed from: a */
    private static volatile C1767ay f3102a;

    /* renamed from: a */
    private long f3103a;

    /* renamed from: a */
    Context f3104a;

    /* renamed from: a */
    private SharedPreferences f3105a;

    /* renamed from: a */
    private volatile boolean f3107a = false;

    /* renamed from: a */
    private ConcurrentHashMap<String, a> f3106a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static C1767ay m3783a(Context context) {
        if (f3102a == null) {
            synchronized (C1767ay.class) {
                if (f3102a == null) {
                    f3102a = new C1767ay(context);
                }
            }
        }
        return f3102a;
    }

    private C1767ay(Context context) {
        this.f3104a = context.getApplicationContext();
        this.f3105a = context.getSharedPreferences("sync", 0);
    }

    @Override // com.xiaomi.push.service.InterfaceC1743aa
    /* renamed from: a */
    public void mo3573a() {
        if (this.f3107a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f3103a < DownloadConstants.HOUR) {
            return;
        }
        this.f3103a = currentTimeMillis;
        this.f3107a = true;
        C1470ad.m1444a(this.f3104a).m1450a(new Runnable() { // from class: com.xiaomi.push.service.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = C1767ay.this.f3106a.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).run();
                    }
                } catch (Exception e) {
                    AbstractC1417b.m1089a("Sync job exception :" + e.getMessage());
                }
                C1767ay.this.f3107a = false;
            }
        }, (int) (Math.random() * 10.0d));
    }

    /* renamed from: com.xiaomi.push.service.ay$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a */
        long f3109a;

        /* renamed from: a */
        String f3110a;

        /* renamed from: a */
        abstract void mo3789a(C1767ay c1767ay);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f3110a = str;
            this.f3109a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1767ay.f3102a != null) {
                Context context = C1767ay.f3102a.f3104a;
                if (C1486at.m1548c(context)) {
                    if (System.currentTimeMillis() - C1767ay.f3102a.f3105a.getLong(":ts-" + this.f3110a, 0L) > this.f3109a || C1467aa.m1438a(context)) {
                        C1699o.m3458a(C1767ay.f3102a.f3105a.edit().putLong(":ts-" + this.f3110a, System.currentTimeMillis()));
                        mo3789a(C1767ay.f3102a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public String m3786a(String str, String str2) {
        return this.f3105a.getString(str + Constants.COLON_SEPARATOR + str2, "");
    }

    /* renamed from: a */
    public void m3788a(String str, String str2, String str3) {
        C1699o.m3458a(f3102a.f3105a.edit().putString(str + Constants.COLON_SEPARATOR + str2, str3));
    }

    /* renamed from: a */
    public void m3787a(a aVar) {
        if (this.f3106a.putIfAbsent(aVar.f3110a, aVar) == null) {
            C1470ad.m1444a(this.f3104a).m1450a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }
}
