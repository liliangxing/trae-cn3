package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
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
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BaseDownloader {
    private static IDownloadGlobalThrottleService globalThrottleService = (IDownloadGlobalThrottleService) DownloadServiceManager.getService(IDownloadGlobalThrottleService.class);
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;
    private IDownloadProcessDispatcherService dispatcherService = (IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class);
    private IDownloadComponentManagerService componentService = (IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class);

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void pause(int i) {
        this.dispatcherService.pause(i);
    }

    public int getDownloadId(String str, String str2) {
        return this.dispatcherService.getDownloadId(str, str2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return this.dispatcherService.getDownloadInfoList(str);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void cancel(int i, boolean z) {
        this.dispatcherService.cancel(i, z);
    }

    public void resume(int i) {
        this.dispatcherService.resume(i);
    }

    public boolean canResume(int i) {
        return this.dispatcherService.canResume(i);
    }

    public void restart(int i) {
        this.dispatcherService.restart(i);
    }

    public void pauseAll() {
        this.dispatcherService.pauseAll();
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        this.dispatcherService.restartAllFailedDownloadTasks(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        this.dispatcherService.restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    public long getCurBytes(int i) {
        return this.dispatcherService.getCurBytes(i);
    }

    public int getStatus(int i) {
        return this.dispatcherService.getStatus(i);
    }

    public boolean isDownloading(int i) {
        return this.dispatcherService.isDownloading(i);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return this.dispatcherService.getDownloadInfo(i);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return this.dispatcherService.getDownloadInfo(str, str2);
    }

    public List<DownloadInfo> getDownloadInfosBySavePath(String str) {
        return this.dispatcherService.getDownloadInfosBySavePath(str);
    }

    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String str) {
        return this.dispatcherService.getInstalledTimeStampBySavePath(str);
    }

    public void updateDownloadInfo(DownloadInfo downloadInfo) {
        this.componentService.updateDownloadInfo(downloadInfo);
    }

    public long clearAllDownloadCache(boolean z) {
        return this.componentService.clearAllDownloadCache(z, null);
    }

    public long clearAllDownloadCache(boolean z, Set<String> set) {
        return this.componentService.clearAllDownloadCache(z, set);
    }

    public void clearMemoryCacheData(double d) {
        this.componentService.clearMemoryCacheData(d);
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        return this.dispatcherService.getDownloadNotificationEventListener(i);
    }

    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        this.dispatcherService.setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return this.dispatcherService.getSuccessedDownloadInfosWithMimeType(str);
    }

    public void clearDownloadData(int i) {
        this.dispatcherService.clearDownloadData(i, true);
    }

    public void clearDownloadData(int i, boolean z) {
        this.dispatcherService.clearDownloadData(i, z);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        this.dispatcherService.removeDownloadListener(i, null, ListenerType.MAIN, true);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.removeDownloadListener(i, iDownloadListener, ListenerType.MAIN, false);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.addDownloadListener(i, iDownloadListener, ListenerType.MAIN, true);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.addDownloadListener(i, iDownloadListener, ListenerType.MAIN, true, z);
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.addDownloadListener(i, iDownloadListener, ListenerType.MAIN, false);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.addDownloadListener(i, iDownloadListener, ListenerType.SUB, true);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.addDownloadListener(i, iDownloadListener, ListenerType.SUB, false);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        this.dispatcherService.removeDownloadListener(i, null, ListenerType.SUB, true);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.removeDownloadListener(i, iDownloadListener, ListenerType.SUB, false);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        this.dispatcherService.removeDownloadListener(i, null, ListenerType.NOTIFICATION, true);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.removeDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, false);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.addDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, true);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        this.dispatcherService.addDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, false);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return this.dispatcherService.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    public boolean isHttpServiceInit() {
        return this.dispatcherService.isHttpServiceInit();
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return this.dispatcherService.getUnCompletedDownloadInfosWithMimeType(str);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return this.dispatcherService.getDownloadingDownloadInfosWithMimeType(str);
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
        return this.dispatcherService.getDownloadInfosByFileExtension(str);
    }

    @Deprecated
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.dispatcherService.getAllDownloadInfo();
    }

    public void destoryDownloader() {
        this.componentService.unRegisterDownloadReceiver();
    }

    public void setLogLevel(int i) {
        this.dispatcherService.setLogLevel(i);
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        this.dispatcherService.registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        this.dispatcherService.unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return this.dispatcherService.isDownloadCacheSyncSuccess();
    }

    public void setDownloadInMultiProcess() {
        this.componentService.setDownloadInMultiProcess();
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return this.dispatcherService.getDownloadFileUriProvider(i);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        this.dispatcherService.registerDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        this.dispatcherService.unRegisterDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return this.componentService.getReserveWifiStatusListener();
    }

    public void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        this.componentService.setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    public void setThrottleNetSpeed(int i, long j) {
        setThrottleNetSpeed(i, j, 0);
    }

    public void setThrottleNetSpeed(int i, long j, int i2) {
        this.dispatcherService.setThrottleNetSpeed(i, j, i2);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath);
    }

    private File getGlobalSaveDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (DownloadDirUtils.isValidDirectory(file)) {
            return file;
        }
        return null;
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener iDownloadMemoryInfoListener) {
        this.componentService.setDownloadMemoryInfoListener(iDownloadMemoryInfoListener);
    }

    public void setDownloadDBListener(IDownloadDBListener iDownloadDBListener) {
        this.componentService.setDownloadDBListener(iDownloadDBListener);
    }

    public void setDownloadStatusListener(IDownloadStatusListener iDownloadStatusListener) {
        this.componentService.setDownloadStatusListener(iDownloadStatusListener);
    }

    public void initDownloadCacheImmediately() {
        this.componentService.initDownloadCacheImmediately();
    }

    public void setDownloadThreadCheckListener(IDownloadThreadCheckListener iDownloadThreadCheckListener) {
        this.componentService.setDownloadThreadCheckListener(iDownloadThreadCheckListener);
    }

    public void enableLruCache() {
        this.componentService.enableLruCache();
    }

    public static void setGlobalThrottleSpeed(Context context, int i, int i2) {
        globalThrottleService.setGlobalThrottle(i, i2);
    }

    public static void setGlobalThrottleTaskPriority(int i, int i2) {
        globalThrottleService.setGlobalThrottleTaskPriority(i, i2);
    }

    public void startThrottle(String[] strArr, long j) {
        this.componentService.startThrottle(strArr, j);
    }

    public void stopThrottle(String[] strArr) {
        this.componentService.stopThrottle(strArr);
    }

    public void updateDownloadSpInfo() {
        this.componentService.updateDownloadSpInfo();
    }

    public void sleepDownloadingTask() {
        this.componentService.sleepDownloadingTask();
    }

    public void resetSleepDownloadingTaskState() {
        this.componentService.resetSleepDownloadingTaskState();
    }

    public void setDownloadNetworkHandler(IDownloadNetworkHandler iDownloadNetworkHandler) {
        this.componentService.setDownloadNetworkHandler(iDownloadNetworkHandler);
    }

    public void clearDBSuccessedDownloadInfo(String str, String str2) {
        this.componentService.clearDBSuccessedDownloadInfo(str, str2);
    }

    public void clearDirectory(IDirectoryCleanerListener iDirectoryCleanerListener) {
        this.componentService.clearDirectory(iDirectoryCleanerListener);
    }

    public void setNotificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        this.componentService.setNotificationClickCallback(iNotificationClickCallback);
    }

    public void setDownloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        this.componentService.setDownloadMonitorListener(iDownloadMonitorListener);
    }

    public void setDownloadMemoryListener(IMemoryListener iMemoryListener) {
        this.componentService.setDownloadMemoryListener(iMemoryListener);
    }

    public void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener iDownloadPluginDegradeListener) {
        this.componentService.setDownloadPluginDegradeListener(iDownloadPluginDegradeListener);
    }
}
