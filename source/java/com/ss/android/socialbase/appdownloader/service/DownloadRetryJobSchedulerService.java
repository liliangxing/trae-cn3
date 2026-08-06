package com.ss.android.socialbase.appdownloader.service;

import android.app.job.JobParameters;
import com.ss.android.socialbase.appdownloader.RetryJobSchedulerServiceImpl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadRetryJobSchedulerService implements IDownloadRetryJobSchedulerService {
    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
    public void onStartJob(JobParameters jobParameters) {
        RetryJobSchedulerServiceImpl.onStartJob(jobParameters);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
    public void tryStartScheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i) {
        RetryJobSchedulerServiceImpl.tryStartScheduleRetry(downloadInfo, j, z, i);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
    public void tryCancelScheduleRetry(int i) {
        RetryJobSchedulerServiceImpl.tryCancelScheduleRetry(i);
    }
}
