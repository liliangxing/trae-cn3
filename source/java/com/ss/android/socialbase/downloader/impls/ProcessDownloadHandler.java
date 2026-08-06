package com.ss.android.socialbase.downloader.impls;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.p005db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ProcessDownloadHandler implements IDownloadProxy {
    private static final String TAG = "ProcessDownloadHandler";
    private final IDownloadCache downloadCache;
    private final AbsDownloadEngine downloadEngine;
    private final IDownloadServiceHandler downloadServiceHandler;
    private final boolean enableSingleThread;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
    }

    public ProcessDownloadHandler() {
        this(false);
    }

    public ProcessDownloadHandler(boolean z) {
        this.downloadEngine = DownloadComponentManager.getDownloadEngine();
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        if (!z) {
            this.downloadServiceHandler = DownloadComponentManager.getDownloadServiceHandler();
        } else {
            this.downloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        }
        this.enableSingleThread = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SINGLE_ASYNC_HANDLE_OPERATION) > 0;
    }

    private void runInSingleThread(Runnable runnable) {
        if (this.enableSingleThread) {
            DownloadComponentManager.submitSingleTask(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(final int i, boolean z) {
        Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.1
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.pause(i);
            }
        };
        if (z) {
            runnable.run();
        } else {
            runInSingleThread(runnable);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(final int i, final boolean z) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.2
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.cancel(i, z);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int i) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.isInDownloadTaskPool(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(final int i) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.3
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.resume(i);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(final int i) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.4
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.restart(i);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.5
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.shutDown();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getAllDownloadInfo();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getDownloadInfosByFilters(str, str2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(final List<String> list) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.6
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.restartAllFailedDownloadTasks(list);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(final List<String> list) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.7
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.restartAllPauseReserveOnWifiDownloadTasks(list);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int i) {
        DownloadInfo downloadInfo;
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache == null || (downloadInfo = iDownloadCache.getDownloadInfo(i)) == null) {
            return 0L;
        }
        return downloadInfo.getCurBytes();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int i) {
        DownloadInfo downloadInfo = this.downloadEngine.getDownloadInfo(i);
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int i) {
        return this.downloadEngine.isDownloading(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int i) {
        return this.downloadEngine.getDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosBySavePath(String str) {
        ISqlDownloadCache sqlDownloadCache;
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache == null || !(iDownloadCache instanceof DefaultDownloadCache) || (sqlDownloadCache = ((DefaultDownloadCache) iDownloadCache).getSqlDownloadCache()) == null || !(sqlDownloadCache instanceof SqlDownloadCache)) {
            return null;
        }
        return ((SqlDownloadCache) sqlDownloadCache).getDownloadInfosBySavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String str) {
        ISqlDownloadCache sqlDownloadCache;
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache == null || !(iDownloadCache instanceof DefaultDownloadCache) || (sqlDownloadCache = ((DefaultDownloadCache) iDownloadCache).getSqlDownloadCache()) == null || !(sqlDownloadCache instanceof SqlDownloadCache)) {
            return null;
        }
        return ((SqlDownloadCache) sqlDownloadCache).getInstalledTimeStampBySavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String str) {
        return this.downloadEngine.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String str, String str2) {
        return getDownloadInfo(DownloadComponentManager.getDownloadId(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String str, String str2) {
        return DownloadComponentManager.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(final int i, final boolean z, final boolean z2) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.8
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.clearDownloadData(i, z, z2);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(final int i, final boolean z) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.9
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.resetDownloadData(i, z);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        this.downloadEngine.addDownloadListener(i, i2, iDownloadListener, listenerType, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        this.downloadEngine.addDownloadListener(i, i2, iDownloadListener, listenerType, z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        this.downloadEngine.removeDownloadListener(i, i2, iDownloadListener, listenerType, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean isDownloadSuccessAndFileNotExist = DownloadUtils.isDownloadSuccessAndFileNotExist(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (isDownloadSuccessAndFileNotExist) {
            resetDownloadData(downloadInfo.getId(), true);
        }
        return isDownloadSuccessAndFileNotExist;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return this.downloadEngine.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
        return this.downloadCache.getDownloadInfosByFileExtension(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(final DownloadTask downloadTask) {
        DownloadComponentManager.updateCurrentDownloadThreadInfo(downloadTask, true);
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.10
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadServiceHandler.tryDownload(downloadTask);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(final DownloadTask downloadTask) {
        DownloadComponentManager.updateCurrentDownloadThreadInfo(downloadTask, true);
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.11
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadServiceHandler.tryDownloadWithEngine(downloadTask);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int i) {
        Logger.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        return this.downloadCache.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        this.downloadCache.syncDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int i, boolean z) {
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int i) {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        return this.downloadCache.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int i) {
        return this.downloadCache.removeDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int i) {
        return this.downloadCache.removeDownloadTaskData(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        this.downloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int i) {
        this.downloadCache.syncDownloadInfoFromOtherCache(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        return iDownloadServiceHandler != null && iDownloadServiceHandler.isServiceAlive();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback processCallback) {
        DownloadComponentManager.addProcessCallback(processCallback);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int i, int i2) {
        if (DownloadComponentManager.getProcessCallbacks() != null) {
            for (ProcessCallback processCallback : DownloadComponentManager.getProcessCallbacks()) {
                if (processCallback != null) {
                    processCallback.callback(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        return this.downloadEngine.getDownloadNotificationEventListener(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int i) {
        INotificationClickCallback notificationClickCallback = this.downloadEngine.getNotificationClickCallback(i);
        return notificationClickCallback == null ? DownloadComponentManager.getNotificationClickCallback() : notificationClickCallback;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        this.downloadEngine.setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return this.downloadEngine.getDownloadFileUriProvider(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(final int i, final long j, final int i2) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler.12
            @Override // java.lang.Runnable
            public void run() {
                ProcessDownloadHandler.this.downloadEngine.setThrottleNetSpeed(i, j, i2);
            }
        });
    }
}
