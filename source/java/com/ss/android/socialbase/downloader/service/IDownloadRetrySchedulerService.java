package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadRetrySchedulerService {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadRetrySchedulerService implements IDownloadRetrySchedulerService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void doSchedulerRetry(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void scheduleRetryWhenHasTaskConnected() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void scheduleRetryWhenHasTaskSucceed() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler retryScheduleHandler) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void tryCancelScheduleRetry(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void tryStartScheduleRetry(DownloadInfo downloadInfo) {
        }
    }

    void doSchedulerRetry(int i);

    void scheduleRetryWhenHasTaskConnected();

    void scheduleRetryWhenHasTaskSucceed();

    void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler retryScheduleHandler);

    void tryCancelScheduleRetry(int i);

    void tryStartScheduleRetry(DownloadInfo downloadInfo);
}
