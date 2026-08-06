package com.ss.android.socialbase.appdownloader;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        ((IDownloadRetryJobSchedulerService) AppDownloadServiceManager.getService(IDownloadRetryJobSchedulerService.class)).onStartJob(jobParameters);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tryStartScheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i) {
        ((IDownloadRetryJobSchedulerService) AppDownloadServiceManager.getService(IDownloadRetryJobSchedulerService.class)).tryStartScheduleRetry(downloadInfo, j, z, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tryCancelScheduleRetry(int i) {
        ((IDownloadRetryJobSchedulerService) AppDownloadServiceManager.getService(IDownloadRetryJobSchedulerService.class)).tryCancelScheduleRetry(i);
    }
}
