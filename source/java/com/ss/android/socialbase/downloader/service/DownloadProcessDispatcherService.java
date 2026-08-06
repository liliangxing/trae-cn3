package com.ss.android.socialbase.downloader.service;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadProcessDispatcherService implements IDownloadProcessDispatcherService {
    private static final String TAG = "DownloadProcessDispatcherService";

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void tryDownload(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (Logger.alog() && downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            Logger.taskDebug(TAG, downloadInfo, "tryDownload", downloadInfo.toDetailString(), true);
            Logger.taskDebug(TAG, downloadInfo, "tryDownload", "Setting:" + DownloadSetting.obtain(downloadInfo.getId()), true);
        }
        DownloadProcessDispatcher.getInstance().tryDownload(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void pause(int i) {
        DownloadProcessDispatcher.getInstance().pause(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public int getDownloadId(String str, String str2) {
        return DownloadProcessDispatcher.getInstance().getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfoList(String str) {
        DownloadHelper.checkWorkerThread("getDownloadInfoList");
        return DownloadProcessDispatcher.getInstance().getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void cancel(int i, boolean z) {
        DownloadProcessDispatcher.getInstance().cancel(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void resume(int i) {
        DownloadProcessDispatcher.getInstance().resume(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean canResume(int i) {
        DownloadHelper.checkWorkerThread("canResume");
        return DownloadProcessDispatcher.getInstance().canResume(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restart(int i) {
        DownloadProcessDispatcher.getInstance().restart(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void pauseAll() {
        DownloadProcessDispatcher.getInstance().pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restartAllFailedDownloadTasks(List<String> list) {
        DownloadProcessDispatcher.getInstance().restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        DownloadProcessDispatcher.getInstance().restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public long getCurBytes(int i) {
        DownloadHelper.checkWorkerThread("getCurBytes");
        return DownloadProcessDispatcher.getInstance().getCurBytes(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public int getStatus(int i) {
        DownloadHelper.checkWorkerThread("getStatus");
        return DownloadProcessDispatcher.getInstance().getStatus(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloading(int i) {
        DownloadHelper.checkWorkerThread("isDownloading");
        return DownloadProcessDispatcher.getInstance().isDownloading(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public DownloadInfo getDownloadInfo(int i) {
        DownloadHelper.checkWorkerThread("getDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public DownloadInfo getDownloadInfo(String str, String str2) {
        DownloadHelper.checkWorkerThread("getDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        DownloadHelper.checkWorkerThread("getDownloadNotificationEventListener");
        return DownloadProcessDispatcher.getInstance().getDownloadNotificationEventListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        DownloadHelper.checkWorkerThread("setDownloadNotificationEventListener");
        DownloadProcessDispatcher.getInstance().setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        DownloadHelper.checkWorkerThread("getSuccessedDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void clearDownloadData(int i) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(i, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void clearDownloadData(int i, boolean z) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        DownloadHelper.checkWorkerThread("removeDownloadListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, listenerType, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        DownloadHelper.checkWorkerThread("addDownloadListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, listenerType, z);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        DownloadHelper.checkWorkerThread("addDownloadListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, listenerType, z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeTaskSubListener(int i) {
        DownloadHelper.checkWorkerThread("removeTaskSubListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, null, ListenerType.SUB, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadHelper.checkWorkerThread("removeSubThreadListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, ListenerType.SUB, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeTaskNotificationListener(int i) {
        DownloadHelper.checkWorkerThread("removeTaskNotificationListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, null, ListenerType.NOTIFICATION, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadHelper.checkWorkerThread("removeNotificationListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadHelper.checkWorkerThread("setNotificationListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadHelper.checkWorkerThread("addNotificationListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        DownloadHelper.checkWorkerThread("isDownloadSuccessAndFileNotExist");
        return DownloadProcessDispatcher.getInstance().isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isHttpServiceInit() {
        return DownloadProcessDispatcher.getInstance().isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        DownloadHelper.checkWorkerThread("getUnCompletedDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        DownloadHelper.checkWorkerThread("getDownloadingDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
        DownloadHelper.checkWorkerThread("getDownloadInfosByFileExtension");
        return DownloadProcessDispatcher.getInstance().getDownloadInfosByFileExtension(str);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getAllDownloadInfo() {
        DownloadHelper.checkWorkerThread("getAllDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        DownloadHelper.checkWorkerThread("getDownloadInfosByFilters");
        return DownloadProcessDispatcher.getInstance().getDownloadInfosByFilters(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setLogLevel(int i) {
        DownloadProcessDispatcher.getInstance().setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadProcessDispatcher.getInstance().registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadProcessDispatcher.getInstance().unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloadCacheSyncSuccess() {
        return DownloadProcessDispatcher.getInstance().isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        DownloadHelper.checkWorkerThread("getDownloadFileUriProvider");
        return DownloadProcessDispatcher.getInstance().getDownloadFileUriProvider(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        DownloadProcessDispatcher.getInstance().registerDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        DownloadProcessDispatcher.getInstance().unRegisterDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setThrottleNetSpeed(int i, long j, int i2) {
        DownloadProcessDispatcher.getInstance().setThrottleNetSpeed(i, j, i2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public INotificationClickCallback getNotificationClickCallback(int i) {
        return DownloadProcessDispatcher.getInstance().getNotificationClickCallback(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosBySavePath(String str) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfosBySavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String str) {
        return DownloadProcessDispatcher.getInstance().getInstalledTimeStampBySavePath(str);
    }
}
