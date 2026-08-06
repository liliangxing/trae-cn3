package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1572dy;
import com.xiaomi.push.service.XMJobService;

/* renamed from: com.xiaomi.push.ea */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1575ea implements C1572dy.a {

    /* renamed from: a */
    JobScheduler f1506a;

    /* renamed from: a */
    Context f1507a;

    /* renamed from: a */
    private boolean f1508a = false;

    C1575ea(Context context) {
        this.f1507a = context;
        this.f1506a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    /* renamed from: a */
    void m2339a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f1507a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        AbstractC1417b.m1101c("schedule Job = " + builder.build().getId() + " in " + j);
        this.f1506a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.C1572dy.a
    /* renamed from: a */
    public void mo2330a(boolean z) {
        if (z || this.f1508a) {
            long m2547b = C1607ff.m2547b();
            if (z) {
                mo2329a();
                m2547b -= SystemClock.elapsedRealtime() % m2547b;
            }
            this.f1508a = true;
            m2339a(m2547b);
        }
    }

    @Override // com.xiaomi.push.C1572dy.a
    /* renamed from: a */
    public void mo2329a() {
        this.f1508a = false;
        this.f1506a.cancel(1);
    }

    @Override // com.xiaomi.push.C1572dy.a
    /* renamed from: a */
    public boolean mo2331a() {
        return this.f1508a;
    }
}
