package com.ss.android.socialbase.appdownloader.service;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceLoader;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppDownloadServiceLoader extends DownloadServiceLoader {
    private static final String TAG = "AppDownloadServiceLoader";
    private static boolean isLoaded;

    @Override // com.ss.android.socialbase.downloader.service.DownloadServiceLoader, com.ss.android.socialbase.downloader.downloader.IDownloadServiceLoader
    public void load() {
        synchronized (DownloadServiceManager.class) {
            if (isLoaded) {
                return;
            }
            isLoaded = true;
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "load", "Load appdownload service start");
            }
            super.load();
            AppDownloadServiceManager.registerService(IDownloadAhUtilsService.class, new DownloadAhUtilsService());
            AppDownloadServiceManager.registerService(IDownloadHandlerService.class, new DownloadHandlerService());
            AppDownloadServiceManager.registerService(IDownloadPackageInfoUtilsService.class, new DownloadPackageInfoUtilsService());
            AppDownloadServiceManager.registerService(IDownloadReceiverService.class, new DownloadReceiverService());
            AppDownloadServiceManager.registerService(IDownloadRetryJobSchedulerService.class, new DownloadRetryJobSchedulerService());
            AppDownloadServiceManager.registerService(IDownloadAppInstallService.class, new DownloadAppInstallService());
            AppDownloadServiceManager.setServiceLoaded();
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "load", "Load appdownload service end");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.service.DownloadServiceLoader, com.ss.android.socialbase.downloader.downloader.IDownloadServiceLoader
    public void defaultLoadCallback(boolean z, String str) {
        super.defaultLoadCallback(z, str);
    }
}
