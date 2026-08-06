package com.ss.android.socialbase.downloader.service;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadProcessDispatcherService {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadProcessDispatcherService implements IDownloadProcessDispatcherService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean canResume(int i) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void cancel(int i, boolean z) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void clearDownloadData(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void clearDownloadData(int i, boolean z) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getAllDownloadInfo() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public long getCurBytes(int i) {
            return 0L;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public int getDownloadId(String str, String str2) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public DownloadInfo getDownloadInfo(int i) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public DownloadInfo getDownloadInfo(String str, String str2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfoList(String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosBySavePath(String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public INotificationClickCallback getNotificationClickCallback(int i) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public int getStatus(int i) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloadCacheSyncSuccess() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloading(int i) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isHttpServiceInit() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void pause(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void pauseAll() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeTaskNotificationListener(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeTaskSubListener(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restart(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restartAllFailedDownloadTasks(List<String> list) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void resume(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setLogLevel(int i) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setThrottleNetSpeed(int i, long j, int i2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void tryDownload(DownloadTask downloadTask) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        }
    }

    void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z);

    void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2);

    void addNotificationListener(int i, IDownloadListener iDownloadListener);

    boolean canResume(int i);

    void cancel(int i, boolean z);

    void clearDownloadData(int i);

    void clearDownloadData(int i, boolean z);

    List<DownloadInfo> getAllDownloadInfo();

    long getCurBytes(int i);

    IDownloadFileUriProvider getDownloadFileUriProvider(int i);

    int getDownloadId(String str, String str2);

    DownloadInfo getDownloadInfo(int i);

    DownloadInfo getDownloadInfo(String str, String str2);

    List<DownloadInfo> getDownloadInfoList(String str);

    List<DownloadInfo> getDownloadInfosByFileExtension(String str);

    List<DownloadInfo> getDownloadInfosByFilters(String str, String str2);

    List<DownloadInfo> getDownloadInfosBySavePath(String str);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int i);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str);

    Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String str);

    INotificationClickCallback getNotificationClickCallback(int i);

    int getStatus(int i);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str);

    boolean isDownloadCacheSyncSuccess();

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo);

    boolean isDownloading(int i);

    boolean isHttpServiceInit();

    void pause(int i);

    void pauseAll();

    void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener);

    void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener);

    void removeDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z);

    void removeNotificationListener(int i, IDownloadListener iDownloadListener);

    void removeSubThreadListener(int i, IDownloadListener iDownloadListener);

    @Deprecated
    void removeTaskNotificationListener(int i);

    @Deprecated
    void removeTaskSubListener(int i);

    void restart(int i);

    void restartAllFailedDownloadTasks(List<String> list);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> list);

    void resume(int i);

    void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener);

    void setLogLevel(int i);

    @Deprecated
    void setNotificationListener(int i, IDownloadListener iDownloadListener);

    void setThrottleNetSpeed(int i, long j, int i2);

    void tryDownload(DownloadTask downloadTask);

    void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener);

    void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener);
}
