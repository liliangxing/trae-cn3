package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsDownloadEngine implements WeakDownloadHandler.IHandler, IDownloadEngine {
    private static final String TAG = "AbsDownloadEngine";
    private boolean fixAnrIsolateEngineAndCache;
    private boolean mFixCancelAnr;
    private final SparseArray<DownloadTask> downloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> successDownloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> failedDownloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> waitingAsyncDownloadTaskMap = new SparseArray<>();
    private final SparseArray<SparseArray<DownloadTask>> downloadTaskWithListenerMap = new SparseArray<>();
    private final LruCache<Integer, DownloadTask> pengingTaskCache = new LruCache<>();
    private final LinkedBlockingDeque<DownloadTask> orderedTaskQueue = new LinkedBlockingDeque<>();
    protected final WeakDownloadHandler mainHandler = new WeakDownloadHandler(Looper.getMainLooper(), this);
    private final IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();

    protected abstract DownloadRunnable doCancel(int i);

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public abstract Future doDownload(DownloadTask downloadTask);

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public abstract void doPause(int i, boolean z);

    public abstract void doSetThrottleNetSpeed(int i, long j, int i2);

    protected abstract List<Integer> getAllAliveDownloadIds();

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public abstract boolean isDownloading(int i);

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public abstract void removeDownloadRunnable(DownloadRunnable downloadRunnable);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsDownloadEngine() {
        this.fixAnrIsolateEngineAndCache = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_ANR_ISOLATE_ENGINE_AND_CACHE) > 0;
        this.mFixCancelAnr = DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_CALLBACK_DEADLOCK);
    }

    private void tryCacheSameTaskWithListenerHashCode(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.downloadTaskWithListenerMap.put(downloadTask.getDownloadId(), sparseArray);
        }
        if (Logger.debugScene(downloadTask.getDownloadInfo())) {
            Logger.taskDebug(TAG, downloadTask.getDownloadInfo(), "tryCacheSameTaskWithListenerHashCode", "Listener hashCode:" + hashCodeForSameTask);
        }
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void tryDownloadImpl(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        boolean z;
        DownloadInfo downloadInfo2;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            Logger.taskError(TAG, downloadInfo.getId(), "tryDownload", "entity invalid");
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        downloadTask.getTimingInfo().tryDownloadTime = System.currentTimeMillis();
        DownloadComponentManager.updateCurrentDownloadThreadInfo(downloadTask, true);
        int i = 0;
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.NO_NET_OPT, 0) == 1 && !DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) && !downloadInfo.isFirstDownload() && !DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK)) {
            new DownloadStatusHandler(downloadTask, this.mainHandler).onError(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "tryDownload", "Url: " + downloadInfo.getUrl() + " savePath: " + downloadInfo.getSavePath() + " saveName: " + downloadInfo.getName());
        }
        if (this.failedDownloadTaskMap.get(id) != null) {
            this.failedDownloadTaskMap.remove(id);
        }
        if (this.successDownloadTaskMap.get(id) != null) {
            this.successDownloadTaskMap.remove(id);
        }
        if (this.waitingAsyncDownloadTaskMap.get(id) != null) {
            this.waitingAsyncDownloadTaskMap.remove(id);
        }
        if (isDownloading(id) && !downloadInfo.canReStartAsyncTask()) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "tryDownload", "Another task with same id is downloading when tryDownload");
            }
            downloadTask.addListenerToDownloadingSameTask();
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "tryDownload", "No downloading task");
        }
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
        }
        DownloadTask downloadTask2 = (DownloadTask) this.pengingTaskCache.remove(Integer.valueOf(id));
        if (downloadTask2 != null) {
            downloadTask.copyListenerFromPendingTask(downloadTask2);
        }
        if (DownloadConstants.MIME_PLG.equals(downloadInfo.getMimeType())) {
            downloadTask.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
        }
        DownloadTask downloadTask3 = this.downloadTaskMap.get(id);
        if (downloadTask3 == null || (downloadInfo2 = downloadTask3.getDownloadInfo()) == null) {
            z = false;
        } else {
            int status = downloadInfo2.getStatus();
            z = DownloadStatus.isDownloading(status);
            i = status;
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "tryDownload", "Can add listener " + z + " , oldTaskStatus is :" + i);
        }
        if (z) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        tryCacheSameTaskWithListenerHashCode(downloadTask);
        this.downloadTaskMap.put(id, downloadTask);
        doDownload(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void tryDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            enqueue(downloadTask);
        } else {
            tryDownloadImpl(downloadTask);
        }
    }

    private void enqueue(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (PluginDownloadEngine.isEnabledDownloadPluginOpt(downloadInfo)) {
            PluginDownloadEngine.getInstance().download(downloadTask);
            return;
        }
        try {
            if (this.orderedTaskQueue.isEmpty()) {
                tryDownloadImpl(downloadTask);
                this.orderedTaskQueue.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.orderedTaskQueue.getFirst().getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.orderedTaskQueue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.orderedTaskQueue.put(downloadTask);
                return;
            }
            DownloadTask first = this.orderedTaskQueue.getFirst();
            if (first.getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                return;
            }
            pause(first.getDownloadId());
            tryDownloadImpl(downloadTask);
            if (first.getDownloadId() != downloadTask.getDownloadId()) {
                this.orderedTaskQueue.putFirst(downloadTask);
            }
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public DownloadInfo getDownloadInfo(int i) {
        if (!this.fixAnrIsolateEngineAndCache) {
            return getDownloadInfoImpl(i);
        }
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.downloadTaskMap.get(i);
                if (downloadTask != null) {
                    downloadInfo = downloadTask.getDownloadInfo();
                }
            }
        }
        return downloadInfo;
    }

    private synchronized DownloadInfo getDownloadInfoImpl(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask;
        downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo == null && (downloadTask = this.downloadTaskMap.get(i)) != null) {
            downloadInfo = downloadTask.getDownloadInfo();
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public List<DownloadInfo> getDownloadInfoList(String str) {
        ArrayList arrayList;
        if (!this.fixAnrIsolateEngineAndCache) {
            return getDownloadInfoListImpl(str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> downloadInfoList = this.downloadCache.getDownloadInfoList(str);
        if (downloadInfoList != null && !downloadInfoList.isEmpty()) {
            return downloadInfoList;
        }
        synchronized (this) {
            arrayList = new ArrayList();
            int size = this.downloadTaskMap.size();
            for (int i = 0; i < size; i++) {
                DownloadTask valueAt = this.downloadTaskMap.valueAt(i);
                if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                    arrayList.add(valueAt.getDownloadInfo());
                }
            }
        }
        return arrayList;
    }

    private synchronized List<DownloadInfo> getDownloadInfoListImpl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> downloadInfoList = this.downloadCache.getDownloadInfoList(str);
        if (downloadInfoList != null && !downloadInfoList.isEmpty()) {
            return downloadInfoList;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.downloadTaskMap.size();
        for (int i = 0; i < size; i++) {
            DownloadTask valueAt = this.downloadTaskMap.valueAt(i);
            if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                arrayList.add(valueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean pause(int i) {
        if (!this.fixAnrIsolateEngineAndCache) {
            return pauseImpl(i);
        }
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null && downloadInfo.getStatus() == 11) {
            return false;
        }
        doPause(i, true);
        synchronized (this) {
            if (downloadInfo == null) {
                DownloadTask downloadTask = this.downloadTaskMap.get(i);
                if (downloadTask != null) {
                    new DownloadStatusHandler(downloadTask, this.mainHandler).onPause();
                    return true;
                }
            } else if (downloadInfo.getStatus() == 1) {
                DownloadTask downloadTask2 = this.downloadTaskMap.get(i);
                if (downloadTask2 != null) {
                    new DownloadStatusHandler(downloadTask2, this.mainHandler).onPause();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfo.getStatus())) {
                downloadInfo.setStatus(-2);
                return true;
            }
            return false;
        }
    }

    private synchronized boolean pauseImpl(int i) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null && downloadInfo.getStatus() == 11) {
            return false;
        }
        synchronized (this.downloadTaskMap) {
            doPause(i, true);
        }
        if (downloadInfo == null) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask != null) {
                new DownloadStatusHandler(downloadTask, this.mainHandler).onPause();
                return true;
            }
        } else if (downloadInfo.getStatus() == 1) {
            DownloadTask downloadTask2 = this.downloadTaskMap.get(i);
            if (downloadTask2 != null) {
                new DownloadStatusHandler(downloadTask2, this.mainHandler).onPause();
                return true;
            }
        } else if (DownloadStatus.isDownloading(downloadInfo.getStatus())) {
            downloadInfo.setStatus(-2);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean cancel(int i, boolean z) {
        if (!this.fixAnrIsolateEngineAndCache) {
            return cancelImpl(i, z);
        }
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        final DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask != null) {
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setStatus(-4);
            }
            final Map<Integer, IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
            final Map<Integer, IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
            this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    Map map;
                    Map map2 = downloadListeners;
                    if (map2 != null) {
                        DownloadListenerUtils.notifyCancelListener(downloadTask, downloadInfo, map2, ListenerType.MAIN, AbsDownloadEngine.this.mFixCancelAnr);
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (map = downloadListeners2) == null) {
                        return;
                    }
                    DownloadListenerUtils.notifyCancelListener(downloadTask, downloadInfo, map, ListenerType.NOTIFICATION, AbsDownloadEngine.this.mFixCancelAnr);
                }
            });
        }
        DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo2 != null) {
            downloadInfo2.setStatus(-4);
        }
        clearDownloadData(i, z, false);
        return true;
    }

    private synchronized boolean cancelImpl(int i, boolean z) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        final DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask != null) {
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            final Map<Integer, IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
            final Map<Integer, IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
            this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.2
                @Override // java.lang.Runnable
                public void run() {
                    Map map;
                    Map map2 = downloadListeners;
                    if (map2 != null) {
                        DownloadListenerUtils.notifyCancelListener(downloadTask, downloadInfo, map2, ListenerType.MAIN, AbsDownloadEngine.this.mFixCancelAnr);
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (map = downloadListeners2) == null) {
                        return;
                    }
                    DownloadListenerUtils.notifyCancelListener(downloadTask, downloadInfo, map, ListenerType.NOTIFICATION, AbsDownloadEngine.this.mFixCancelAnr);
                }
            });
        }
        DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo2 != null) {
            downloadInfo2.setStatus(-4);
        }
        clearDownloadData(i, z, false);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized boolean resume(int i) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "resume", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            tryDownload(downloadTask);
        } else {
            restart(i);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized boolean restart(int i) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "restart", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        DownloadTask downloadTask = this.failedDownloadTaskMap.get(i);
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        tryDownload(downloadTask);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(iDownloadNotificationEventListener);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized INotificationClickCallback getNotificationClickCallback(int i) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.waitingAsyncDownloadTaskMap.get(i);
        if (downloadTask4 == null) {
            return null;
        }
        return downloadTask4.getNotificationClickCallback();
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.waitingAsyncDownloadTaskMap.get(i);
        if (downloadTask4 == null) {
            return null;
        }
        return downloadTask4.getNotificationEventListener();
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.waitingAsyncDownloadTaskMap.get(i);
        if (downloadTask4 == null) {
            return null;
        }
        return downloadTask4.getFileUriProvider();
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized boolean restartAsyncWaitingTask(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.waitingAsyncDownloadTaskMap.get(i);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            tryDownload(downloadTask);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void restartAllFailedDownloadTasks(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean isWifi = DownloadUtils.isWifi(DownloadComponentManager.getAppContext());
            for (int i = 0; i < this.failedDownloadTaskMap.size(); i++) {
                DownloadTask downloadTask = this.failedDownloadTaskMap.get(this.failedDownloadTaskMap.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && (!downloadInfo.isOnlyWifi() || isWifi)) {
                    if ((DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.AUTO_RESUME, 0) == 1) || (downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()))) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        tryDownload(downloadTask);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (DownloadUtils.isWifi(DownloadComponentManager.getAppContext())) {
            for (int i = 0; i < this.downloadTaskMap.size(); i++) {
                DownloadTask downloadTask = this.downloadTaskMap.get(this.downloadTaskMap.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && isPauseReserveOnWifi(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    tryDownload(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    IReserveWifiStatusListener reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.onStatusChanged(downloadInfo, 5, 2);
                    }
                }
            }
        }
    }

    private boolean isPauseReserveOnWifi(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void shutDown() {
        List<Integer> allAliveDownloadIds = getAllAliveDownloadIds();
        if (allAliveDownloadIds == null) {
            return;
        }
        Iterator<Integer> it = allAliveDownloadIds.iterator();
        while (it.hasNext()) {
            pause(it.next().intValue());
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void clearDownloadData(final int i, final boolean z, final boolean z2) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "clearDownloadData", "DeleteFile:" + z + " deleteFileIgnoreSecurity:" + z2 + "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.4
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTask;
                if (AbsDownloadEngine.this.doCancel(i) == null && (downloadTask = AbsDownloadEngine.this.getDownloadTask(i)) != null) {
                    DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                    Map<Integer, IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.SUB);
                    if (downloadListeners != null) {
                        DownloadListenerUtils.notifyCancelListener(downloadTask, downloadInfo, downloadListeners, ListenerType.SUB, AbsDownloadEngine.this.mFixCancelAnr);
                    }
                }
                AbsDownloadEngine.this.clearDownloadDataInSubThread(i, z, z2);
            }
        }, false);
    }

    public void clearDownloadDataInSubThread(int i, boolean z, boolean z2) {
        if (!this.fixAnrIsolateEngineAndCache) {
            clearDownloadDataInSubThreadImpl(i, z, z2);
            return;
        }
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "clearDownloadDataInSubThread", "DeleteFile:" + z + " deleteFileIgnoreSecurity:" + z2);
        }
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                if (z) {
                    if (z2) {
                        new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName(), false, false).delete();
                    }
                    DownloadUtils.deleteAllDownloadFiles(downloadInfo, z);
                } else {
                    DownloadUtils.deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
                }
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeDownloadTaskData(i);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                refreshDownloadTaskMap(i, 0, -4);
                if (this.failedDownloadTaskMap.get(i) != null) {
                    this.failedDownloadTaskMap.remove(i);
                }
                if (this.successDownloadTaskMap.get(i) != null) {
                    this.successDownloadTaskMap.remove(i);
                }
                this.pengingTaskCache.remove(Integer.valueOf(i));
                DownloadSetting.removeTaskDownloadSetting(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private synchronized void clearDownloadDataInSubThreadImpl(int i, boolean z, boolean z2) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "clearDownloadDataInSubThread", "DeleteFile:" + z + " deleteFileIgnoreSecurity:" + z2);
        }
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                if (z) {
                    if (z2) {
                        new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName(), false, false).delete();
                    }
                    DownloadUtils.deleteAllDownloadFiles(downloadInfo, z);
                } else {
                    DownloadUtils.deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
                }
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeDownloadTaskData(i);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            refreshDownloadTaskMap(i, 0, -4);
            if (this.failedDownloadTaskMap.get(i) != null) {
                this.failedDownloadTaskMap.remove(i);
            }
            if (this.successDownloadTaskMap.get(i) != null) {
                this.successDownloadTaskMap.remove(i);
            }
            this.pengingTaskCache.remove(Integer.valueOf(i));
            DownloadSetting.removeTaskDownloadSetting(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void resetDownloadData(final int i, final boolean z) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "resetDownloadData", "DeleteFile:" + z + "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.5
            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.6
            @Override // java.lang.Runnable
            public void run() {
                AbsDownloadEngine.this.doCancel(i);
                AbsDownloadEngine.this.resetDownloadDataInSubThread(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDownloadDataInSubThread(int i, boolean z) {
        if (!this.fixAnrIsolateEngineAndCache) {
            resetDownloadDataInSubThreadImpl(i, z);
            return;
        }
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                DownloadUtils.deleteAllDownloadFiles(downloadInfo, z);
                downloadInfo.erase();
            }
            try {
                this.downloadCache.updateDownloadInfo(downloadInfo);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (this.failedDownloadTaskMap.get(i) != null) {
                    this.failedDownloadTaskMap.remove(i);
                }
                if (this.successDownloadTaskMap.get(i) != null) {
                    this.successDownloadTaskMap.remove(i);
                }
                this.pengingTaskCache.remove(Integer.valueOf(i));
                DownloadSetting.removeTaskDownloadSetting(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void resetDownloadDataInSubThreadImpl(int i, boolean z) {
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                DownloadUtils.deleteAllDownloadFiles(downloadInfo, z);
                downloadInfo.erase();
            }
            try {
                this.downloadCache.updateDownloadInfo(downloadInfo);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            if (this.failedDownloadTaskMap.get(i) != null) {
                this.failedDownloadTaskMap.remove(i);
            }
            if (this.successDownloadTaskMap.get(i) != null) {
                this.successDownloadTaskMap.remove(i);
            }
            this.pengingTaskCache.remove(Integer.valueOf(i));
            DownloadSetting.removeTaskDownloadSetting(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
    
        if (r1.failedDownloadTaskMap.get(r2) != null) goto L8;
     */
    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isInDownloadTaskPool(int i) {
        boolean z;
        if (i != 0) {
            if (this.downloadTaskMap.get(i) == null) {
            }
            z = true;
        }
        z = false;
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public synchronized void removeDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask == null) {
            downloadTask = this.pengingTaskCache.get(Integer.valueOf(i));
        }
        if (downloadTask != null) {
            downloadTask.removeDownloadListener(i2, iDownloadListener, listenerType, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        addDownloadListener(i, i2, iDownloadListener, listenerType, z, true);
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void addDownloadListener(int i, int i2, final IDownloadListener iDownloadListener, final ListenerType listenerType, boolean z, boolean z2) {
        if (!this.fixAnrIsolateEngineAndCache) {
            addDownloadListenerImpl(i, i2, iDownloadListener, listenerType, z, z2);
            return;
        }
        synchronized (this) {
            final DownloadTask downloadTask = getDownloadTask(i);
            if (downloadTask != null) {
                downloadTask.addDownloadListener(i2, iDownloadListener, listenerType, z);
                final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                if (z2 && downloadInfo != null && !isDownloading(i) && (listenerType == ListenerType.MAIN || listenerType == ListenerType.NOTIFICATION)) {
                    if (listenerType != ListenerType.NOTIFICATION || downloadInfo.canShowNotification()) {
                        final int status = downloadInfo.getStatus();
                        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.7
                            @Override // java.lang.Runnable
                            public void run() {
                                IDownloadListener iDownloadListener2 = iDownloadListener;
                                if (iDownloadListener2 != null) {
                                    int i3 = status;
                                    if (i3 == -3) {
                                        iDownloadListener2.onSuccessed(downloadInfo);
                                        downloadTask.removeCallback(listenerType, iDownloadListener);
                                    } else if (i3 == -1) {
                                        iDownloadListener2.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                        downloadTask.removeCallback(listenerType, iDownloadListener);
                                    }
                                }
                            }
                        });
                    }
                }
                return;
            }
            DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
            synchronized (this) {
                if (downloadInfo2 != null) {
                    if (downloadInfo2.getStatus() != -3) {
                        DownloadTask downloadTask2 = this.pengingTaskCache.get(Integer.valueOf(i));
                        if (downloadTask2 == null) {
                            downloadTask2 = new DownloadTask(downloadInfo2);
                            this.pengingTaskCache.put(Integer.valueOf(i), downloadTask2);
                        }
                        downloadTask2.addDownloadListener(i2, iDownloadListener, listenerType, z);
                    }
                }
            }
        }
    }

    private synchronized void addDownloadListenerImpl(int i, int i2, final IDownloadListener iDownloadListener, final ListenerType listenerType, boolean z, boolean z2) {
        final DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask != null) {
            downloadTask.addDownloadListener(i2, iDownloadListener, listenerType, z);
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (z2 && downloadInfo != null && !isDownloading(i) && (listenerType == ListenerType.MAIN || listenerType == ListenerType.NOTIFICATION)) {
                if (listenerType != ListenerType.NOTIFICATION || downloadInfo.canShowNotification()) {
                    this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                    downloadTask.removeCallback(listenerType, iDownloadListener);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                    downloadTask.removeCallback(listenerType, iDownloadListener);
                                }
                            }
                        }
                    });
                }
            }
        } else {
            DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo2 != null && downloadInfo2.getStatus() != -3) {
                DownloadTask downloadTask2 = this.pengingTaskCache.get(Integer.valueOf(i));
                if (downloadTask2 == null) {
                    downloadTask2 = new DownloadTask(downloadInfo2);
                    this.pengingTaskCache.put(Integer.valueOf(i), downloadTask2);
                }
                downloadTask2.addDownloadListener(i2, iDownloadListener, listenerType, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask getDownloadTask(int i) {
        DownloadTask downloadTask;
        if (!this.fixAnrIsolateEngineAndCache) {
            return getDownloadTaskImpl(i);
        }
        synchronized (this) {
            downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask == null && (downloadTask = this.failedDownloadTaskMap.get(i)) == null && (downloadTask = this.successDownloadTaskMap.get(i)) == null) {
                downloadTask = this.waitingAsyncDownloadTaskMap.get(i);
            }
        }
        return downloadTask;
    }

    private DownloadTask getDownloadTaskImpl(int i) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.failedDownloadTaskMap.get(i);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.successDownloadTaskMap.get(i);
        return downloadTask3 == null ? this.waitingAsyncDownloadTaskMap.get(i) : downloadTask3;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = getAllAliveDownloadIds().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfo = getDownloadInfo(it.next().intValue());
            if (downloadInfo != null && str.equals(downloadInfo.getMimeType())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    private void notifyDownloadTaskStatus(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                Logger.globalError(TAG, "notifyDownloadTaskStatus", "DownloadInfo is null\"");
                return;
            }
            Map<Integer, IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
            Map<Integer, IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            DownloadListenerUtils.notifyListener(i, downloadListeners, true, downloadInfo, baseException, ListenerType.MAIN, downloadTask);
            DownloadListenerUtils.notifyListener(i, downloadListeners2, z, downloadInfo, baseException, ListenerType.NOTIFICATION, downloadTask);
        }
    }

    private void tryDownloadNextTaskInQueue(int i) {
        DownloadTask first;
        if (this.orderedTaskQueue.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.orderedTaskQueue.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.orderedTaskQueue.poll();
        }
        if (this.orderedTaskQueue.isEmpty() || (first = this.orderedTaskQueue.getFirst()) == null) {
            return;
        }
        tryDownloadImpl(first);
    }

    private void removeTask(int i, int i2) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "removeTask", "Listener hashCode: " + i2);
        }
        if (i2 == 0) {
            this.downloadTaskMap.remove(i);
            this.downloadTaskWithListenerMap.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            if (Logger.debug()) {
                Logger.taskDebug(TAG, i, "removeTask", "After downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            }
            if (sparseArray.size() == 0) {
                this.downloadTaskMap.remove(i);
                this.downloadTaskWithListenerMap.remove(i);
                return;
            }
            return;
        }
        this.downloadTaskMap.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void refreshDownloadTaskMap(int i, int i2, int i3) {
        if (i3 != -7) {
            if (i3 == -6) {
                synchronized (this) {
                    this.successDownloadTaskMap.put(i, this.downloadTaskMap.get(i));
                    removeTask(i, i2);
                }
                return;
            }
            if (i3 == -4) {
                synchronized (this) {
                    removeTask(i, i2);
                    tryDownloadNextTaskInQueue(i);
                }
                return;
            }
            if (i3 == -3) {
                synchronized (this) {
                    this.successDownloadTaskMap.put(i, this.downloadTaskMap.get(i));
                    removeTask(i, i2);
                    tryDownloadNextTaskInQueue(i);
                }
                return;
            }
            if (i3 != -1) {
                if (i3 != 8) {
                    return;
                }
                synchronized (this) {
                    DownloadTask downloadTask = this.downloadTaskMap.get(i);
                    if (downloadTask != null && this.waitingAsyncDownloadTaskMap.get(i) == null) {
                        this.waitingAsyncDownloadTaskMap.put(i, downloadTask);
                    }
                    tryDownloadNextTaskInQueue(i);
                }
                return;
            }
        }
        synchronized (this) {
            DownloadTask downloadTask2 = this.downloadTaskMap.get(i);
            if (downloadTask2 != null) {
                if (this.failedDownloadTaskMap.get(i) == null) {
                    this.failedDownloadTaskMap.put(i, downloadTask2);
                }
                removeTask(i, i2);
            }
            tryDownloadNextTaskInQueue(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void handleMsg(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "handleMsg", "Listener hashCode: " + i2);
        }
        DownloadTask downloadTask = null;
        BaseException baseException = message.obj instanceof Exception ? (BaseException) message.obj : null;
        synchronized (this) {
            if (i2 == 0) {
                downloadTask = this.downloadTaskMap.get(i);
            } else {
                SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i2);
                }
            }
            if (downloadTask == null) {
                return;
            }
            notifyDownloadTaskStatus(message.what, baseException, downloadTask);
            refreshDownloadTaskMap(i, i2, message.what);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public DownloadTask getDownloadTask(int i, int i2) {
        DownloadTask downloadTask;
        synchronized (this) {
            if (i2 == 0) {
                downloadTask = this.downloadTaskMap.get(i);
            } else {
                SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i);
                downloadTask = sparseArray != null ? sparseArray.get(i2) : null;
            }
        }
        return downloadTask;
    }

    @Override // com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void setThrottleNetSpeed(int i, long j, int i2) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setThrottleNetSpeed(j, i2);
        }
        doSetThrottleNetSpeed(i, j, i2);
    }
}
