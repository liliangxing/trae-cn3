package com.ss.android.socialbase.downloader.impls;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
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
import com.ss.android.socialbase.downloader.thread.DownloadThreadPool;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NewDownloadEngine extends BaseDownloadEngine implements WeakDownloadHandler.IHandler {
    private static final String TAG = "NewDownloadEngine";
    private Map<Integer, DownloadTask> mDownloadTaskMap = new ConcurrentHashMap();
    private Map<Integer, DownloadTask> mSuccessDownloadTaskMap = new ConcurrentHashMap();
    private Map<Integer, DownloadTask> mFailedDownloadTaskMap = new ConcurrentHashMap();
    private Map<Integer, DownloadTask> mWaitingAsyncDownloadTaskMap = new ConcurrentHashMap();
    private Map<Integer, Map<Integer, DownloadTask>> mDownloadTaskWithListenerMap = new ConcurrentHashMap();
    private Map<Integer, DownloadTask> mPendingTaskCache = new ConcurrentHashMap();
    private LinkedBlockingDeque<DownloadTask> mOrderedTaskQueue = new LinkedBlockingDeque<>();
    private IDownloadCache mDownloadCache = DownloadComponentManager.getDownloadCache();
    private WeakDownloadHandler mMainHandler = new WeakDownloadHandler(Looper.getMainLooper(), this);
    private DownloadThreadPool mDownloadThreadPool = new DownloadThreadPool();

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void tryDownloadImpl(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            enqueue(downloadTask);
        } else {
            doDownloadImpl(downloadTask);
        }
    }

    private void doDownloadImpl(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        boolean z;
        DownloadInfo downloadInfo2;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            Logger.taskError(TAG, downloadInfo.getId(), "doDownloadImpl", "Entity invalid");
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        downloadTask.getTimingInfo().tryDownloadTime = System.currentTimeMillis();
        DownloadComponentManager.updateCurrentDownloadThreadInfo(downloadTask, true);
        int i = 0;
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.NO_NET_OPT, 0) == 1 && !DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) && !downloadInfo.isFirstDownload() && !DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK)) {
            new DownloadStatusHandler(downloadTask, this.mMainHandler).onError(new BaseException(1049, "network_not_available"));
            return;
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "doDownloadImpl", "Url: " + downloadInfo.getUrl() + " savePath: " + downloadInfo.getSavePath() + " saveName: " + downloadInfo.getName());
        }
        int id = downloadInfo.getId();
        if (this.mFailedDownloadTaskMap.containsKey(Integer.valueOf(id))) {
            this.mFailedDownloadTaskMap.remove(Integer.valueOf(id));
        }
        if (this.mSuccessDownloadTaskMap.containsKey(Integer.valueOf(id))) {
            this.mSuccessDownloadTaskMap.remove(Integer.valueOf(id));
        }
        if (this.mWaitingAsyncDownloadTaskMap.containsKey(Integer.valueOf(id))) {
            this.mWaitingAsyncDownloadTaskMap.remove(Integer.valueOf(id));
        }
        if (isDownloading(id) && !downloadInfo.canReStartAsyncTask()) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "doDownloadImpl", "Another task with same id is downloading when tryDownload");
            }
            downloadTask.addListenerToDownloadingSameTask();
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "doDownloadImpl", "No downloading task");
        }
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
        }
        DownloadTask remove = this.mPendingTaskCache.remove(Integer.valueOf(id));
        if (remove != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        if (DownloadConstants.MIME_PLG.equals(downloadInfo.getMimeType())) {
            downloadTask.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
        }
        DownloadTask downloadTask2 = this.mDownloadTaskMap.get(Integer.valueOf(id));
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            z = false;
        } else {
            int status = downloadInfo2.getStatus();
            z = DownloadStatus.isDownloading(status);
            i = status;
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "doDownloadImpl", "Can add listener " + z + " , oldTaskStatus is :" + i);
        }
        if (z) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        tryCacheSameTaskWithListenerHashCode(downloadTask);
        this.mDownloadTaskMap.put(Integer.valueOf(id), downloadTask);
        doDownload(downloadTask);
    }

    private void tryCacheSameTaskWithListenerHashCode(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        Map<Integer, DownloadTask> map = this.mDownloadTaskWithListenerMap.get(Integer.valueOf(downloadTask.getDownloadId()));
        if (map == null) {
            map = new ConcurrentHashMap<>();
            this.mDownloadTaskWithListenerMap.put(Integer.valueOf(downloadTask.getDownloadId()), map);
        }
        if (Logger.debugScene(downloadTask.getDownloadInfo())) {
            Logger.taskDebug(TAG, downloadTask.getDownloadInfo(), "tryCacheSameTaskWithListenerHashCode", "Listener hashCode:" + hashCodeForSameTask);
        }
        map.put(Integer.valueOf(hashCodeForSameTask), downloadTask);
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
            if (this.mOrderedTaskQueue.isEmpty()) {
                tryDownloadImpl(downloadTask);
                this.mOrderedTaskQueue.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.mOrderedTaskQueue.getFirst().getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.mOrderedTaskQueue.iterator();
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
                this.mOrderedTaskQueue.put(downloadTask);
                return;
            }
            DownloadTask first = this.mOrderedTaskQueue.getFirst();
            if (first.getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                return;
            }
            pause(first.getDownloadId());
            tryDownloadImpl(downloadTask);
            if (first.getDownloadId() != downloadTask.getDownloadId()) {
                this.mOrderedTaskQueue.putFirst(downloadTask);
            }
        } catch (Throwable th) {
            Logger.taskError(TAG, downloadInfo.getId(), "enqueue", "Error:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void pauseImpl(int i) {
        DownloadInfo downloadInfo = this.mDownloadCache.getDownloadInfo(i);
        if (downloadInfo == null || downloadInfo.getStatus() != 11) {
            doPause(i, true);
            if (downloadInfo == null) {
                DownloadTask downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
                if (downloadTask != null) {
                    new DownloadStatusHandler(downloadTask, this.mMainHandler).onPause();
                    return;
                }
                return;
            }
            if (downloadInfo.getStatus() == 1) {
                DownloadTask downloadTask2 = this.mDownloadTaskMap.get(Integer.valueOf(i));
                if (downloadTask2 != null) {
                    new DownloadStatusHandler(downloadTask2, this.mMainHandler).onPause();
                    return;
                }
                return;
            }
            if (DownloadStatus.isDownloading(downloadInfo.getStatus())) {
                downloadInfo.setStatus(-2);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void cancelImpl(int i, boolean z) {
        final DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask != null) {
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setStatus(-4);
            }
            final Map<Integer, IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
            final Map<Integer, IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
            this.mMainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.NewDownloadEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    Map map;
                    Map map2 = downloadListeners;
                    if (map2 != null) {
                        DownloadListenerUtils.notifyCancelListener(downloadTask, downloadInfo, map2, ListenerType.MAIN, true);
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (map = downloadListeners2) == null) {
                        return;
                    }
                    DownloadListenerUtils.notifyCancelListener(downloadTask, downloadInfo, map, ListenerType.NOTIFICATION, true);
                }
            });
        }
        DownloadInfo downloadInfo2 = this.mDownloadCache.getDownloadInfo(i);
        if (downloadInfo2 != null) {
            downloadInfo2.setStatus(-4);
        }
        clearDownloadData(i, z, false);
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void resumeImpl(int i) {
        DownloadTask downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            tryDownload(downloadTask);
            return;
        }
        restart(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void restartImpl(int i) {
        DownloadTask downloadTask = this.mFailedDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        tryDownload(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void restartAsyncWaitingTaskImpl(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.mWaitingAsyncDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null || !downloadInfo.canReStartAsyncTask()) {
            return;
        }
        tryDownload(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void restartAllFailedDownloadTasksImpl(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean isWifi = DownloadUtils.isWifi(DownloadComponentManager.getAppContext());
            for (DownloadTask downloadTask : this.mFailedDownloadTaskMap.values()) {
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && (!downloadInfo.isOnlyWifi() || isWifi)) {
                    if ((DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.AUTO_RESUME, 0) == 1) || (downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()))) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        tryDownload(downloadTask);
                    }
                }
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "restartAllFailedDownloadTasksImpl", "Error:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void restartAllPauseReserveOnWifiDownloadTasksImpl(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (DownloadUtils.isWifi(DownloadComponentManager.getAppContext())) {
                for (DownloadTask downloadTask : this.mDownloadTaskMap.values()) {
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && downloadInfo.statusInPause() && downloadInfo.isPauseReserveOnWifi()) {
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
        } catch (Throwable th) {
            Logger.globalError(TAG, "restartAllPauseReserveOnWifiDownloadTasksImpl", "Error:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void refreshDownloadTaskMapImpl(int i, int i2, int i3) {
        if (i3 != -7) {
            if (i3 == -6) {
                DownloadTask downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
                if (downloadTask != null) {
                    this.mSuccessDownloadTaskMap.put(Integer.valueOf(i), downloadTask);
                }
                removeTask(i, i2);
                return;
            }
            if (i3 == -4) {
                removeTask(i, i2);
                tryDownloadNextTaskInQueue(i);
                return;
            }
            if (i3 == -3) {
                DownloadTask downloadTask2 = this.mDownloadTaskMap.get(Integer.valueOf(i));
                if (downloadTask2 != null) {
                    this.mSuccessDownloadTaskMap.put(Integer.valueOf(i), downloadTask2);
                }
                removeTask(i, i2);
                tryDownloadNextTaskInQueue(i);
                return;
            }
            if (i3 != -1) {
                if (i3 != 8) {
                    return;
                }
                DownloadTask downloadTask3 = this.mDownloadTaskMap.get(Integer.valueOf(i));
                if (downloadTask3 != null && this.mWaitingAsyncDownloadTaskMap.get(Integer.valueOf(i)) == null) {
                    this.mWaitingAsyncDownloadTaskMap.put(Integer.valueOf(i), downloadTask3);
                }
                tryDownloadNextTaskInQueue(i);
                return;
            }
        }
        DownloadTask downloadTask4 = this.mDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask4 != null) {
            if (this.mFailedDownloadTaskMap.get(Integer.valueOf(i)) == null) {
                this.mFailedDownloadTaskMap.put(Integer.valueOf(i), downloadTask4);
            }
            removeTask(i, i2);
        }
        tryDownloadNextTaskInQueue(i);
    }

    private void removeTask(int i, int i2) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "removeTask", "Listener hashCode: " + i2);
        }
        if (i2 == 0) {
            this.mDownloadTaskMap.remove(Integer.valueOf(i));
            this.mDownloadTaskWithListenerMap.remove(Integer.valueOf(i));
            return;
        }
        Map<Integer, DownloadTask> map = this.mDownloadTaskWithListenerMap.get(Integer.valueOf(i));
        if (map != null) {
            map.remove(Integer.valueOf(i2));
            if (Logger.debug()) {
                Logger.taskDebug(TAG, i, "removeTask", "After downloadTaskWithListenerMap removeTask taskArray.size: " + map.size());
            }
            if (map.size() == 0) {
                this.mDownloadTaskMap.remove(Integer.valueOf(i));
                this.mDownloadTaskWithListenerMap.remove(Integer.valueOf(i));
                return;
            }
            return;
        }
        this.mDownloadTaskMap.remove(Integer.valueOf(i));
    }

    private void tryDownloadNextTaskInQueue(int i) {
        DownloadTask first;
        if (this.mOrderedTaskQueue.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.mOrderedTaskQueue.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.mOrderedTaskQueue.poll();
        }
        if (this.mOrderedTaskQueue.isEmpty() || (first = this.mOrderedTaskQueue.getFirst()) == null) {
            return;
        }
        tryDownloadImpl(first);
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void setThrottleNetSpeedImpl(int i, long j, int i2) {
        DownloadInfo downloadInfo = this.mDownloadCache.getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setThrottleNetSpeed(j, i2);
        }
        doSetThrottleNetSpeed(i, j, i2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        addDownloadListener(i, i2, iDownloadListener, listenerType, z, true);
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    protected void addDownloadListenerImpl(int i, int i2, final IDownloadListener iDownloadListener, final ListenerType listenerType, boolean z, boolean z2) {
        final DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask != null) {
            downloadTask.addDownloadListener(i2, iDownloadListener, listenerType, z);
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (!z2 || downloadInfo == null || isDownloading(i)) {
                return;
            }
            if (listenerType == ListenerType.MAIN || listenerType == ListenerType.NOTIFICATION) {
                if (listenerType != ListenerType.NOTIFICATION || downloadInfo.canShowNotification()) {
                    final int status = downloadInfo.getStatus();
                    this.mMainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.NewDownloadEngine.2
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
                    return;
                }
                return;
            }
            return;
        }
        DownloadInfo downloadInfo2 = this.mDownloadCache.getDownloadInfo(i);
        if (downloadInfo2 == null || downloadInfo2.getStatus() == -3) {
            return;
        }
        DownloadTask downloadTask2 = this.mPendingTaskCache.get(Integer.valueOf(i));
        if (downloadTask2 == null) {
            downloadTask2 = new DownloadTask(downloadInfo2);
            this.mPendingTaskCache.put(Integer.valueOf(i), downloadTask2);
        }
        downloadTask2.addDownloadListener(i2, iDownloadListener, listenerType, z);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public DownloadInfo getDownloadInfo(int i) {
        DownloadTask downloadTask;
        DownloadInfo downloadInfo = this.mDownloadCache.getDownloadInfo(i);
        return (downloadInfo != null || (downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i))) == null) ? downloadInfo : downloadTask.getDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public List<DownloadInfo> getDownloadInfoList(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> downloadInfoList = this.mDownloadCache.getDownloadInfoList(str);
        if (downloadInfoList != null && !downloadInfoList.isEmpty()) {
            return downloadInfoList;
        }
        ArrayList arrayList = new ArrayList();
        for (DownloadTask downloadTask : this.mDownloadTaskMap.values()) {
            if (downloadTask != null && downloadTask.getDownloadInfo() != null && str.equals(downloadTask.getDownloadInfo().getUrl())) {
                arrayList.add(downloadTask.getDownloadInfo());
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        DownloadTask downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask == null) {
            return;
        }
        downloadTask.setNotificationEventListener(iDownloadNotificationEventListener);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public INotificationClickCallback getNotificationClickCallback(int i) {
        DownloadTask downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.mSuccessDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.mFailedDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.mWaitingAsyncDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        DownloadTask downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.mSuccessDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.mFailedDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.mWaitingAsyncDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        DownloadTask downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.mSuccessDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.mFailedDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.mWaitingAsyncDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean isInDownloadTaskPool(int i) {
        return (i == 0 || (this.mDownloadTaskMap.get(Integer.valueOf(i)) == null && this.mFailedDownloadTaskMap.get(Integer.valueOf(i)) == null)) ? false : true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void removeDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask == null) {
            downloadTask = this.mPendingTaskCache.get(Integer.valueOf(i));
        }
        if (downloadTask != null) {
            downloadTask.removeDownloadListener(i2, iDownloadListener, listenerType, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask getDownloadTask(int i) {
        DownloadTask downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.mFailedDownloadTaskMap.get(Integer.valueOf(i));
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.mSuccessDownloadTaskMap.get(Integer.valueOf(i));
        return downloadTask3 == null ? this.mWaitingAsyncDownloadTaskMap.get(Integer.valueOf(i)) : downloadTask3;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
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

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public DownloadTask getDownloadTask(int i, int i2) {
        if (i2 == 0) {
            return this.mDownloadTaskMap.get(Integer.valueOf(i));
        }
        Map<Integer, DownloadTask> map = this.mDownloadTaskWithListenerMap.get(Integer.valueOf(i));
        if (map != null) {
            return map.get(Integer.valueOf(i2));
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
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

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void clearDownloadData(final int i, final boolean z, final boolean z2) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "clearDownloadData", "DeleteFile:" + z + " deleteFileIgnoreSecurity:" + z2);
        }
        this.mMainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.NewDownloadEngine.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.NewDownloadEngine.4
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTask;
                if (NewDownloadEngine.this.doCancel(i) == null && (downloadTask = NewDownloadEngine.this.getDownloadTask(i)) != null) {
                    DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                    Map<Integer, IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.SUB);
                    if (downloadListeners != null) {
                        DownloadListenerUtils.notifyCancelListener(downloadTask, downloadInfo, downloadListeners, ListenerType.SUB, true);
                    }
                }
                NewDownloadEngine.this.clearDownloadDataImpl(i, z, z2);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDownloadDataImpl(int i, boolean z, boolean z2) {
        try {
            DownloadInfo downloadInfo = this.mDownloadCache.getDownloadInfo(i);
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
            this.mDownloadCache.removeDownloadTaskData(i);
            refreshDownloadTaskMap(i, 0, -4);
            if (this.mFailedDownloadTaskMap.containsKey(Integer.valueOf(i))) {
                this.mFailedDownloadTaskMap.remove(Integer.valueOf(i));
            }
            if (this.mSuccessDownloadTaskMap.containsKey(Integer.valueOf(i))) {
                this.mSuccessDownloadTaskMap.remove(Integer.valueOf(i));
            }
            if (this.mPendingTaskCache.containsKey(Integer.valueOf(i))) {
                this.mPendingTaskCache.remove(Integer.valueOf(i));
            }
            DownloadSetting.removeTaskDownloadSetting(i);
        } catch (Throwable th) {
            Logger.globalError(TAG, "clearDownloadDataInSubThread", "Error:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void resetDownloadData(final int i, final boolean z) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "resetDownloadData", "DeleteFile:" + z + "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        this.mMainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.NewDownloadEngine.5
            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.NewDownloadEngine.6
            @Override // java.lang.Runnable
            public void run() {
                NewDownloadEngine.this.doCancel(i);
                NewDownloadEngine.this.resetDownloadDataInSubThread(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDownloadDataInSubThread(int i, boolean z) {
        try {
            DownloadInfo downloadInfo = this.mDownloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                DownloadUtils.deleteAllDownloadFiles(downloadInfo, z);
                downloadInfo.erase();
            }
            this.mDownloadCache.updateDownloadInfo(downloadInfo);
            if (this.mFailedDownloadTaskMap.containsKey(Integer.valueOf(i))) {
                this.mFailedDownloadTaskMap.remove(Integer.valueOf(i));
            }
            if (this.mSuccessDownloadTaskMap.containsKey(Integer.valueOf(i))) {
                this.mSuccessDownloadTaskMap.remove(Integer.valueOf(i));
            }
            if (this.mPendingTaskCache.containsKey(Integer.valueOf(i))) {
                this.mPendingTaskCache.remove(Integer.valueOf(i));
            }
            DownloadSetting.removeTaskDownloadSetting(i);
        } catch (Throwable th) {
            Logger.globalError(TAG, "resetDownloadDataInSubThread", "Error:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void handleMsg(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "handleMsg", "Listener hashCode: " + i2);
        }
        DownloadTask downloadTask = null;
        BaseException baseException = message.obj instanceof Exception ? (BaseException) message.obj : null;
        if (i2 == 0) {
            downloadTask = this.mDownloadTaskMap.get(Integer.valueOf(i));
        } else {
            Map<Integer, DownloadTask> map = this.mDownloadTaskWithListenerMap.get(Integer.valueOf(i));
            if (map != null) {
                downloadTask = map.get(Integer.valueOf(i2));
            }
        }
        if (downloadTask == null) {
            return;
        }
        notifyDownloadTaskStatus(message.what, baseException, downloadTask);
        refreshDownloadTaskMap(i, i2, message.what);
    }

    private void notifyDownloadTaskStatus(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            Logger.globalError(TAG, "notifyDownloadTaskStatus", "DownloadInfo is null");
            return;
        }
        Map<Integer, IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
        Map<Integer, IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
        boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
        DownloadListenerUtils.notifyListener(i, downloadListeners, true, downloadInfo, baseException, ListenerType.MAIN, downloadTask);
        DownloadListenerUtils.notifyListener(i, downloadListeners2, z, downloadInfo, baseException, ListenerType.NOTIFICATION, downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean isDownloading(int i) {
        DownloadInfo downloadInfo;
        if (this.mDownloadThreadPool.containsTask(i) && (downloadInfo = getDownloadInfo(i)) != null) {
            return DownloadStatus.isDownloading(downloadInfo.getStatus());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void removeDownloadRunnable(DownloadRunnable downloadRunnable) {
        this.mDownloadThreadPool.removeUnAliveDownloadRunnable(downloadRunnable);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public Future doDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        if (Logger.debugScene(downloadTask.getDownloadInfo())) {
            Logger.taskDebug(TAG, downloadTask.getDownloadInfo(), "doDownload", "start doDownload for task");
        }
        downloadTask.getTimingInfo().doDownloadTime = System.currentTimeMillis();
        return this.mDownloadThreadPool.execute(new DownloadRunnable(downloadTask, this.mMainHandler));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void doPause(int i, boolean z) {
        this.mDownloadThreadPool.pause(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    protected DownloadRunnable doCancel(int i) {
        return this.mDownloadThreadPool.cancel(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    protected List<Integer> getAllAliveDownloadIds() {
        return this.mDownloadThreadPool.getAllAliveDownloadIds();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doSetThrottleNetSpeed(int i, long j, int i2) {
        this.mDownloadThreadPool.setThrottleNetSpeed(i, j, i2);
    }
}
