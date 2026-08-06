package com.ss.android.socialbase.appdownloader.service;

import com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService;
import com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService;
import com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService;
import com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService;
import com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService;
import com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;

/* loaded from: classes7.dex */
public class AppDownloadServiceManager extends DownloadServiceManager {
    private static final String APPDOWNLOAD_SERVICE_LOADER = "com.ss.android.socialbase.appdownloader.service.AppDownloadServiceLoader";
    private static final String TAG = "AppDownloadServiceManager";
    private static volatile boolean isLoadService;

    private static void loadDefaultService(String str) {
        synchronized (DownloadServiceManager.class) {
            if (isLoadService) {
                return;
            }
            if (runLoad(str)) {
                isLoadService = true;
                return;
            }
            registerService(IDownloadAhUtilsService.class, new IDownloadAhUtilsService.DefaultDownloadAhUtilsService());
            registerService(IDownloadHandlerService.class, new IDownloadHandlerService.DefaultIDownloadHandlerService());
            registerService(IDownloadPackageInfoUtilsService.class, new IDownloadPackageInfoUtilsService.DefaultDownloadPackageInfoUtilsService());
            registerService(IDownloadReceiverService.class, new IDownloadReceiverService.DefaultDownloadReceiverService());
            registerService(IDownloadRetryJobSchedulerService.class, new IDownloadRetryJobSchedulerService.DefaultDownloadRetryJobSchedulerService());
            registerService(IDownloadAppInstallService.class, new IDownloadAppInstallService.DefaultDownloadAppInstallService());
            Logger.globalError(TAG, "loadDefaultService", "Register default appdownload service");
            isLoadService = true;
        }
    }

    public static void setServiceLoaded() {
        isLoadService = true;
    }

    public static <T> T getService(Class<T> cls) {
        if (!isLoadService) {
            loadDefaultService(APPDOWNLOAD_SERVICE_LOADER);
        }
        return (T) DownloadServiceManager.getService(cls);
    }
}
