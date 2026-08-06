package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1572dy;
import com.xiaomi.push.C1694j;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class XMJobService extends Service {

    /* renamed from: a */
    static Service f2855a;

    /* renamed from: a */
    private IBinder f2856a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f2856a = new JobServiceC1707a(this).f2857a;
        f2855a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f2855a = null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f2856a;
        return iBinder != null ? iBinder : new Binder();
    }

    /* renamed from: com.xiaomi.push.service.XMJobService$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class JobServiceC1707a extends JobService {

        /* renamed from: a */
        Binder f2857a;

        /* renamed from: a */
        private Handler f2858a;

        JobServiceC1707a(Service service) {
            this.f2857a = null;
            this.f2857a = (Binder) C1488av.m1568a((Object) this, "onBind", new Intent());
            C1488av.m1568a((Object) this, "attachBaseContext", service);
        }

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        private static class a extends Handler {

            /* renamed from: a */
            JobService f2859a;

            a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f2859a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                AbstractC1417b.m1089a("Job finished " + jobParameters.getJobId());
                this.f2859a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    C1572dy.m2327a(false);
                }
            }
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            AbstractC1417b.m1089a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f2858a == null) {
                this.f2858a = new a(this);
            }
            Handler handler = this.f2858a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            AbstractC1417b.m1089a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (C1694j.m3427a((Context) this)) {
            return onStartCommand;
        }
        return 2;
    }
}
