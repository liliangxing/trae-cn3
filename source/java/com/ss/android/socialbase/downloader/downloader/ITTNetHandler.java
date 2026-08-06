package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* loaded from: classes7.dex */
public interface ITTNetHandler {

    /* loaded from: classes7.dex */
    public static class DefaultTTNetHandler implements ITTNetHandler {
        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void enableTTNetLogger() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public int getResponseCode(Throwable th) {
            return -1;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public IDownloadHttpService getTTNetDownloadHttpService() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public boolean isTTNetEnable() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void startThrottle(String[] strArr, long j) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void stopThrottle(String[] strArr) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public DownloadTTNetException translateTTNetException(Throwable th, String str) {
            return null;
        }
    }

    void enableTTNetLogger();

    int getResponseCode(Throwable th);

    IDownloadHttpService getTTNetDownloadHttpService();

    boolean isTTNetEnable();

    void startThrottle(String[] strArr, long j);

    void stopThrottle(String[] strArr);

    DownloadTTNetException translateTTNetException(Throwable th, String str);
}
