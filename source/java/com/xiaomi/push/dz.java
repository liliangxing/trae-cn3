package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.ss.ttm.utils.AVLogger;
import com.xiaomi.push.dy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class dz implements dy.a {

    /* renamed from: a, reason: collision with other field name */
    protected Context f409a;

    /* renamed from: a, reason: collision with other field name */
    private PendingIntent f408a = null;
    private volatile long a = 0;

    public dz(Context context) {
        this.f409a = null;
        this.f409a = context;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f409a.getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 31) {
            this.f408a = PendingIntent.getBroadcast(this.f409a, 0, intent, AVLogger.LEVEL_LOG_INFO);
        } else {
            this.f408a = PendingIntent.getBroadcast(this.f409a, 0, intent, 0);
        }
        if (Build.VERSION.SDK_INT >= 31 && !j.m10105a(this.f409a)) {
            alarmManager.set(2, j, this.f408a);
        } else {
            av.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f408a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + j);
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e);
        }
    }

    @Override // com.xiaomi.push.dy.a
    public void a(boolean z) {
        long m10201a = com.xiaomi.push.service.m.a(this.f409a).m10201a();
        if (z || this.a != 0) {
            if (z) {
                a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.a == 0) {
                this.a = elapsedRealtime + (m10201a - (elapsedRealtime % m10201a));
            } else if (this.a <= elapsedRealtime) {
                this.a += m10201a;
                if (this.a < elapsedRealtime) {
                    this.a = elapsedRealtime + m10201a;
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.an.q);
            intent.setPackage(this.f409a.getPackageName());
            a(intent, this.a);
        }
    }

    @Override // com.xiaomi.push.dy.a
    public void a() {
        if (this.f408a != null) {
            try {
                ((AlarmManager) this.f409a.getSystemService("alarm")).cancel(this.f408a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f408a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.a = 0L;
                throw th;
            }
            this.f408a = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.a = 0L;
        }
        this.a = 0L;
    }

    @Override // com.xiaomi.push.dy.a
    /* renamed from: a */
    public boolean mo9850a() {
        return this.a != 0;
    }
}
