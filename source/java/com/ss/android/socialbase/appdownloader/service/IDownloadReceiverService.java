package com.ss.android.socialbase.appdownloader.service;

import com.ss.android.socialbase.appdownloader.depend.ITempAppInstallDownloadReceiverListener;

/* loaded from: classes7.dex */
public interface IDownloadReceiverService {

    /* loaded from: classes7.dex */
    public static class DefaultDownloadReceiverService implements IDownloadReceiverService {
        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
        public void registerDownloadReceiver() {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
        public void setTempAppInstallDownloadReceiverListener(ITempAppInstallDownloadReceiverListener iTempAppInstallDownloadReceiverListener) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
        public void tryRegisterTempAppInstallDownloadReceiver(int i) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
        public void unRegisterDownloadReceiver() {
        }
    }

    void registerDownloadReceiver();

    void setTempAppInstallDownloadReceiverListener(ITempAppInstallDownloadReceiverListener iTempAppInstallDownloadReceiverListener);

    void tryRegisterTempAppInstallDownloadReceiver(int i);

    void unRegisterDownloadReceiver();
}
