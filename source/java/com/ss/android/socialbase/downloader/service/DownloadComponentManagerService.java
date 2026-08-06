package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.cleaner.DirectoryCleaner;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.PluginDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.p005db.DownloadBackgroundCleaner;
import com.ss.android.socialbase.downloader.p005db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadComponentManagerService implements IDownloadComponentManagerService {
    private static final String TAG = "DownloadComponentManagerService";
    private static volatile Future mSleepDownloadTaskFuture;

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public Context getAppContext() {
        return DownloadComponentManager.getAppContext();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setAppContext(Context context) {
        DownloadComponentManager.setAppContext(context);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public JSONObject getDownloadSetting() {
        return DownloadComponentManager.getDownloadSetting();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public IDownloadInterceptor getDownloadInterceptor() {
        return DownloadComponentManager.getDownloadInterceptor();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public boolean isInit() {
        return DownloadComponentManager.isInit();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void initComponent(DownloaderBuilder downloaderBuilder) {
        DownloadComponentManager.initComponent(downloaderBuilder);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void coverComponent(DownloaderBuilder downloaderBuilder) {
        DownloadComponentManager.coverComponent(downloaderBuilder);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void unRegisterDownloadReceiver() {
        DownloadComponentManager.unRegisterDownloadReceiver();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadInMultiProcess() {
        DownloadComponentManager.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return DownloadComponentManager.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        DownloadComponentManager.setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public ITTNetHandler getTTNetHandler() {
        return DownloadComponentManager.getTTNetHandler();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void updateDownloadInfo(DownloadInfo downloadInfo) {
        DownloadHelper.checkWorkerThread("updateDownloadInfo");
        try {
            DownloadComponentManager.getDownloadCache().updateDownloadInfo(downloadInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public long clearAllDownloadCache(boolean z, Set<String> set) {
        return DownloadComponentManager.clearAllDownloadCache(z, set);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void clearMemoryCacheData(final double d) {
        DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.service.DownloadComponentManagerService.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadComponentManager.getDownloadCache().clearMemoryCacheData(d);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitSingleTask(Runnable runnable) {
        DownloadComponentManager.submitSingleTask(runnable);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitIOTask(Runnable runnable) {
        DownloadComponentManager.submitIOTask(runnable);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitScheduleTask(Runnable runnable, long j, TimeUnit timeUnit) {
        DownloadComponentManager.submitScheduleTask(runnable, j, timeUnit);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener iDownloadMemoryInfoListener) {
        DownloadComponentManager.setDownloadMemoryInfoListener(iDownloadMemoryInfoListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadDBListener(IDownloadDBListener iDownloadDBListener) {
        DownloadComponentManager.setDownloadDBListener(iDownloadDBListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadStatusListener(IDownloadStatusListener iDownloadStatusListener) {
        DownloadComponentManager.setDownloadStatusListener(iDownloadStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void initDownloadCacheImmediately() {
        DownloadComponentManager.initDownloadCacheImmediately();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadThreadCheckListener(IDownloadThreadCheckListener iDownloadThreadCheckListener) {
        DownloadComponentManager.setDownloadThreadCheckListener(iDownloadThreadCheckListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void enableLruCache() {
        DownloadComponentManager.enableLruCache();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void startThrottle(String[] strArr, long j) {
        DownloadComponentManager.getTTNetHandler().startThrottle(strArr, j);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void stopThrottle(String[] strArr) {
        DownloadComponentManager.getTTNetHandler().stopThrottle(strArr);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void updateDownloadSpInfo() {
        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
        if (downloadCache instanceof DefaultDownloadCache) {
            ((DefaultDownloadCache) downloadCache).updateDownloadSpInfo();
        }
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void sleepDownloadingTask() {
        final int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.DOWNLOADING_TASK_ANR_SLEEP_TIME_S);
        if (optInt <= 0 || mSleepDownloadTaskFuture != null) {
            return;
        }
        mSleepDownloadTaskFuture = DownloadComponentManager.getIOThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.service.DownloadComponentManagerService.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DownloadHelper.setSleepDownloadingTask(true);
                    Thread.sleep(optInt * 1000);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void resetSleepDownloadingTaskState() {
        try {
            if (mSleepDownloadTaskFuture != null) {
                mSleepDownloadTaskFuture.cancel(true);
                mSleepDownloadTaskFuture = null;
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "resetSleepDownloadingTaskState", "Error:" + th);
        }
        DownloadHelper.setSleepDownloadingTask(false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadNetworkHandler(IDownloadNetworkHandler iDownloadNetworkHandler) {
        DownloadComponentManager.setDownloadNetworkHandler(iDownloadNetworkHandler);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void clearDBSuccessedDownloadInfo(String str, String str2) {
        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
        if (downloadCache instanceof DefaultDownloadCache) {
            ISqlDownloadCache sqlDownloadCache = ((DefaultDownloadCache) downloadCache).getSqlDownloadCache();
            if (sqlDownloadCache instanceof SqlDownloadCache) {
                ((SqlDownloadCache) sqlDownloadCache).clearDBSuccessedDownloadInfo(str, str2);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void clearDirectory(IDirectoryCleanerListener iDirectoryCleanerListener) {
        DirectoryCleaner directoryCleaner = new DirectoryCleaner();
        directoryCleaner.setDirectoryCleanerListener(iDirectoryCleanerListener);
        directoryCleaner.start();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setNotificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        DownloadComponentManager.setNotificationClickCallback(iNotificationClickCallback);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        DownloadComponentManager.setDownloadMonitorListener(iDownloadMonitorListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setAppInfo(String str, String str2) {
        DownloadHelper.setAppInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadMemoryListener(IMemoryListener iMemoryListener) {
        DownloadBackgroundCleaner.setDownloadMemoryListener(iMemoryListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener iDownloadPluginDegradeListener) {
        PluginDownloadEngine.setDownloadPluginDegradeListener(iDownloadPluginDegradeListener);
    }
}
