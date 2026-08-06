package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.impls.RetrySchedulerImpl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadRetrySchedulerService implements IDownloadRetrySchedulerService {
    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler retryScheduleHandler) {
        RetrySchedulerImpl.setRetryScheduleHandler(retryScheduleHandler);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryStartScheduleRetry(DownloadInfo downloadInfo) {
        RetrySchedulerImpl.getInstance().tryStartScheduleRetry(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryCancelScheduleRetry(int i) {
        RetrySchedulerImpl.getInstance().tryCancelScheduleRetry(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void doSchedulerRetry(int i) {
        RetrySchedulerImpl.getInstance().doSchedulerRetry(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskSucceed() {
        RetrySchedulerImpl.getInstance().scheduleRetryWhenHasTaskSucceed();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskConnected() {
        RetrySchedulerImpl.getInstance().scheduleRetryWhenHasTaskConnected();
    }
}
