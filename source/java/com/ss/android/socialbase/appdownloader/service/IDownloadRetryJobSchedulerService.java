package com.ss.android.socialbase.appdownloader.service;

import android.app.job.JobParameters;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadRetryJobSchedulerService {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadRetryJobSchedulerService implements IDownloadRetryJobSchedulerService {
        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
        public void onStartJob(JobParameters jobParameters) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
        public void tryCancelScheduleRetry(int i) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
        public void tryStartScheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i) {
        }
    }

    void onStartJob(JobParameters jobParameters);

    void tryCancelScheduleRetry(int i);

    void tryStartScheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i);
}
