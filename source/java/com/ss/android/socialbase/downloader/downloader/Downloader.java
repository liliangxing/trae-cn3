package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class Downloader extends BaseDownloader {
    private static final String TAG = "Downloader";
    private static volatile Downloader instance;
    private static volatile boolean mSetContext;

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.addMainThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.addNotificationListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.addSubThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean canResume(int i) {
        return super.canResume(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int i) {
        super.cancel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int i, boolean z) {
        super.cancel(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long clearAllDownloadCache(boolean z) {
        return super.clearAllDownloadCache(z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long clearAllDownloadCache(boolean z, Set set) {
        return super.clearAllDownloadCache(z, set);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDBSuccessedDownloadInfo(String str, String str2) {
        super.clearDBSuccessedDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDirectory(IDirectoryCleanerListener iDirectoryCleanerListener) {
        super.clearDirectory(iDirectoryCleanerListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int i) {
        super.clearDownloadData(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int i, boolean z) {
        super.clearDownloadData(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearMemoryCacheData(double d) {
        super.clearMemoryCacheData(d);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void enableLruCache() {
        super.enableLruCache();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long getCurBytes(int i) {
        return super.getCurBytes(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return super.getDownloadFileUriProvider(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getDownloadId(String str, String str2) {
        return super.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int i) {
        return super.getDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String str, String str2) {
        return super.getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String str) {
        return super.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosByFileExtension(String str) {
        return super.getDownloadInfosByFileExtension(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosBySavePath(String str) {
        return super.getDownloadInfosBySavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        return super.getDownloadNotificationEventListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String str) {
        return super.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ Map getInstalledTimeStampBySavePath(String str) {
        return super.getInstalledTimeStampBySavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IReserveWifiStatusListener getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getStatus(int i) {
        return super.getStatus(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String str) {
        return super.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String str) {
        return super.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void initDownloadCacheImmediately() {
        super.initDownloadCacheImmediately();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return super.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloading(int i) {
        return super.isDownloading(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pause(int i) {
        super.pause(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        super.registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        super.registerDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.removeMainThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.removeNotificationListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.removeSubThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int i) {
        super.removeTaskMainListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int i) {
        super.removeTaskNotificationListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int i) {
        super.removeTaskSubListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resetSleepDownloadingTaskState() {
        super.resetSleepDownloadingTaskState();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restart(int i) {
        super.restart(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List list) {
        super.restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List list) {
        super.restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resume(int i) {
        super.resume(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String str) {
        super.setDefaultSavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String str) {
        super.setDefaultSaveTempPath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadDBListener(IDownloadDBListener iDownloadDBListener) {
        super.setDownloadDBListener(iDownloadDBListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener iDownloadMemoryInfoListener) {
        super.setDownloadMemoryInfoListener(iDownloadMemoryInfoListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMemoryListener(IMemoryListener iMemoryListener) {
        super.setDownloadMemoryListener(iMemoryListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        super.setDownloadMonitorListener(iDownloadMonitorListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadNetworkHandler(IDownloadNetworkHandler iDownloadNetworkHandler) {
        super.setDownloadNetworkHandler(iDownloadNetworkHandler);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        super.setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener iDownloadPluginDegradeListener) {
        super.setDownloadPluginDegradeListener(iDownloadPluginDegradeListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadStatusListener(IDownloadStatusListener iDownloadStatusListener) {
        super.setDownloadStatusListener(iDownloadStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadThreadCheckListener(IDownloadThreadCheckListener iDownloadThreadCheckListener) {
        super.setDownloadThreadCheckListener(iDownloadThreadCheckListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setLogLevel(int i) {
        super.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.setMainThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        super.setMainThreadListener(i, iDownloadListener, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setNotificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        super.setNotificationClickCallback(iNotificationClickCallback);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.setNotificationListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        super.setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.setSubThreadListener(i, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int i, long j) {
        super.setThrottleNetSpeed(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int i, long j, int i2) {
        super.setThrottleNetSpeed(i, j, i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void sleepDownloadingTask() {
        super.sleepDownloadingTask();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void startThrottle(String[] strArr, long j) {
        super.startThrottle(strArr, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void stopThrottle(String[] strArr) {
        super.stopThrottle(strArr);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        super.unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        super.unRegisterDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadInfo(DownloadInfo downloadInfo) {
        super.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadSpInfo() {
        super.updateDownloadSpInfo();
    }

    private Downloader() {
    }

    public static void loadService(IDownloadServiceLoader iDownloadServiceLoader) {
        DownloadServiceManager.loadService(iDownloadServiceLoader);
    }

    public static void init(DownloaderBuilder downloaderBuilder) {
        initOrCover(downloaderBuilder, false);
    }

    public static synchronized void initOrCover(DownloaderBuilder downloaderBuilder, boolean z) {
        synchronized (Downloader.class) {
            if (downloaderBuilder == null) {
                return;
            }
            if (instance == null) {
                instance = downloaderBuilder.build();
                return;
            }
            IDownloadComponentManagerService iDownloadComponentManagerService = (IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class);
            if (!iDownloadComponentManagerService.isInit()) {
                iDownloadComponentManagerService.initComponent(downloaderBuilder);
            } else if (z) {
                iDownloadComponentManagerService.coverComponent(downloaderBuilder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Downloader(DownloaderBuilder downloaderBuilder) {
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).initComponent(downloaderBuilder);
    }

    public static Downloader getInstance(Context context) {
        if (instance == null) {
            synchronized (Downloader.class) {
                if (instance == null) {
                    ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).setAppContext(context);
                    instance = new Downloader();
                }
            }
        }
        checkContext(context);
        return instance;
    }

    private static void checkContext(Context context) {
        if (mSetContext) {
            return;
        }
        synchronized (Downloader.class) {
            if (mSetContext) {
                return;
            }
            try {
                if (context != null) {
                    ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).setAppContext(context.getApplicationContext());
                    mSetContext = true;
                } else if (Logger.debug()) {
                    Logger.globalDebug(TAG, "checkContext", "Context is null " + Log.getStackTraceString(new Throwable("context_empty")));
                }
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.globalError(TAG, "checkContext", "Error:" + th);
            }
        }
    }
}
