package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RetryScheduler implements IDownloadRetrySchedulerService {
    public static final int NET_TYPE_COMMON = 1;
    public static final int NET_TYPE_NONE = 0;
    public static final int NET_TYPE_WIFI = 2;
    private static volatile RetryScheduler sInstance;
    private IDownloadRetrySchedulerService service = (IDownloadRetrySchedulerService) DownloadServiceManager.getService(IDownloadRetrySchedulerService.class);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface RetryScheduleHandler {
        void cancelRetry(int i);

        void scheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    private RetryScheduler() {
    }

    public static RetryScheduler getInstance() {
        if (sInstance == null) {
            synchronized (RetryScheduler.class) {
                if (sInstance == null) {
                    sInstance = new RetryScheduler();
                }
            }
        }
        return sInstance;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void setRetryScheduleHandler(RetryScheduleHandler retryScheduleHandler) {
        this.service.setRetryScheduleHandler(retryScheduleHandler);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryStartScheduleRetry(DownloadInfo downloadInfo) {
        this.service.tryStartScheduleRetry(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryCancelScheduleRetry(int i) {
        this.service.tryCancelScheduleRetry(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void doSchedulerRetry(int i) {
        this.service.doSchedulerRetry(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskSucceed() {
        this.service.scheduleRetryWhenHasTaskSucceed();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskConnected() {
        this.service.scheduleRetryWhenHasTaskConnected();
    }
}
