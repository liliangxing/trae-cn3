package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.ss.ttm.utils.AVLogger;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1572dy;
import com.xiaomi.push.service.AbstractC1756an;
import com.xiaomi.push.service.C1784m;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.dz */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1573dz implements C1572dy.a {

    /* renamed from: a */
    protected Context f1505a;

    /* renamed from: a */
    private PendingIntent f1504a = null;

    /* renamed from: a */
    private volatile long f1503a = 0;

    public C1573dz(Context context) {
        this.f1505a = null;
        this.f1505a = context;
    }

    /* renamed from: a */
    public void m2333a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f1505a.getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 31) {
            this.f1504a = PendingIntent.getBroadcast(this.f1505a, 0, intent, AVLogger.LEVEL_LOG_INFO);
        } else {
            this.f1504a = PendingIntent.getBroadcast(this.f1505a, 0, intent, 0);
        }
        if (Build.VERSION.SDK_INT >= 31 && !C1694j.m3427a(this.f1505a)) {
            alarmManager.set(2, j, this.f1504a);
        } else {
            C1488av.m1568a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f1504a);
        }
        AbstractC1417b.m1101c("[Alarm] register timer " + j);
    }

    /* renamed from: a */
    private void m2332a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            AbstractC1417b.m1103d("[Alarm] invoke setExact method meet error. " + e);
        }
    }

    @Override // com.xiaomi.push.C1572dy.a
    /* renamed from: a */
    public void mo2330a(boolean z) {
        long m3891a = C1784m.m3872a(this.f1505a).m3891a();
        if (z || this.f1503a != 0) {
            if (z) {
                mo2329a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.f1503a == 0) {
                this.f1503a = elapsedRealtime + (m3891a - (elapsedRealtime % m3891a));
            } else if (this.f1503a <= elapsedRealtime) {
                this.f1503a += m3891a;
                if (this.f1503a < elapsedRealtime) {
                    this.f1503a = elapsedRealtime + m3891a;
                }
            }
            Intent intent = new Intent(AbstractC1756an.f3057q);
            intent.setPackage(this.f1505a.getPackageName());
            m2333a(intent, this.f1503a);
        }
    }

    @Override // com.xiaomi.push.C1572dy.a
    /* renamed from: a */
    public void mo2329a() {
        if (this.f1504a != null) {
            try {
                ((AlarmManager) this.f1505a.getSystemService("alarm")).cancel(this.f1504a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f1504a = null;
                AbstractC1417b.m1101c("[Alarm] unregister timer");
                this.f1503a = 0L;
                throw th;
            }
            this.f1504a = null;
            AbstractC1417b.m1101c("[Alarm] unregister timer");
            this.f1503a = 0L;
        }
        this.f1503a = 0L;
    }

    @Override // com.xiaomi.push.C1572dy.a
    /* renamed from: a */
    public boolean mo2331a() {
        return this.f1503a != 0;
    }
}
