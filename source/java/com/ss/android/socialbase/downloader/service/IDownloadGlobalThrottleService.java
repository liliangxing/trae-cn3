package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadTask;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadGlobalThrottleService {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadGlobalThrottleService implements IDownloadGlobalThrottleService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void end(DownloadTask downloadTask) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void setGlobalThrottle(int i, int i2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void setGlobalThrottleTaskPriority(int i, int i2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void start(DownloadTask downloadTask) {
        }
    }

    void end(DownloadTask downloadTask);

    void setGlobalThrottle(int i, int i2);

    void setGlobalThrottleTaskPriority(int i, int i2);

    void start(DownloadTask downloadTask);
}
