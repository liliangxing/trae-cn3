package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadStatusHandler {
    private static final String TAG = "DownloadStatusHandler";
    private IDownloadCache downloadCache;
    private DownloadInfo downloadInfo;
    private IDownloadMonitorDepend downloadMonitorDepend;
    private DownloadTask downloadTask;
    private final boolean fixAnrProcessHandleMsg;
    private final boolean fixSameTaskMonitorReport;
    private boolean isFastDownload;
    private boolean mRemoveUselessReport;
    private final Handler mainThreadHandler;
    private Map<Integer, IDownloadListener> mainThreadListeners;
    private long minByteIntervalForSyncProgress;
    private int minTimeIntervalForSyncProgress;
    private Map<Integer, IDownloadListener> notificationListeners;
    private long prepareDownloadTime;
    private Map<Integer, IDownloadListener> subThreadListeners;
    private boolean forceRefreshProcess = false;
    private volatile long lastSyncProgressTime = 0;
    private final AtomicLong msgPostDataBuffer = new AtomicLong();
    private boolean hasSyncProgressBefore = false;

    public DownloadStatusHandler(DownloadTask downloadTask, Handler handler) {
        this.downloadTask = downloadTask;
        this.downloadInfo = downloadTask.getDownloadInfo();
        this.mainThreadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
        this.notificationListeners = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
        this.subThreadListeners = downloadTask.getDownloadListeners(ListenerType.SUB);
        this.downloadMonitorDepend = downloadTask.getMonitorDepend();
        this.mainThreadHandler = handler;
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        boolean isFastDownload = this.downloadInfo.isFastDownload();
        this.isFastDownload = isFastDownload;
        if (isFastDownload) {
            IDownloadCache iDownloadCache = this.downloadCache;
            if (iDownloadCache instanceof DefaultDownloadCache) {
                this.downloadCache = ((DefaultDownloadCache) iDownloadCache).getDownloadCache();
            }
        }
        this.fixAnrProcessHandleMsg = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_ANR_PROGRESS_HANDLE_MSG) > 0;
        this.fixSameTaskMonitorReport = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_SAME_TASK_MONITOR_REPORT) > 0;
        this.mRemoveUselessReport = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_USELESS_MONITOR_REPORT) > 0;
    }

    public void onPrepare() {
        this.prepareDownloadTime = System.currentTimeMillis();
        if (this.downloadInfo.canSkipStatusHandler()) {
            return;
        }
        this.downloadInfo.setStatus(1);
    }

    public void handlePrepare() {
        this.downloadTask.getTimingInfo().beforeOnPrepareTime = System.currentTimeMillis();
        if (!this.downloadInfo.canSkipStatusHandler()) {
            this.downloadCache.OnDownloadTaskPrepare(this.downloadInfo.getId());
            onStatusChanged(1, null);
        }
        long j = this.prepareDownloadTime;
        if (j > 0) {
            try {
                this.downloadInfo.increaseDownloadPrepareTime(j);
            } catch (Throwable unused) {
            }
        }
        this.downloadTask.getTimingInfo().afterOnPrepareTime = System.currentTimeMillis();
    }

    public void onStart() {
        this.downloadTask.getTimingInfo().beforeOnStartTime = System.currentTimeMillis();
        if (this.downloadInfo.canSkipStatusHandler()) {
            this.downloadInfo.changeSkipStatus();
        } else {
            if (this.downloadInfo.getDownloadStartTimeStamp() <= 0) {
                this.downloadInfo.setDownloadStartTimeStamp(System.currentTimeMillis());
            }
            this.downloadCache.onDownloadTaskStart(this.downloadInfo.getId());
            if (this.downloadInfo.isFirstDownload()) {
                onStatusChanged(6, null);
            }
            onStatusChanged(2, null);
        }
        this.downloadTask.getTimingInfo().afterOnStartTime = System.currentTimeMillis();
    }

    public void onFirstConnectionSuccessed(long j, String str, String str2) {
        this.downloadInfo.setTotalBytes(j);
        this.downloadInfo.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.downloadInfo.getName())) {
            this.downloadInfo.setName(str2);
        }
        try {
            this.downloadCache.OnDownloadTaskConnected(this.downloadInfo.getId(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        onStatusChanged(3, null);
        this.minByteIntervalForSyncProgress = this.downloadInfo.getMinByteIntervalForPostToMainThread(j);
        this.minTimeIntervalForSyncProgress = this.downloadInfo.getMinProgressTimeMsInterval();
        this.forceRefreshProcess = true;
        RetryScheduler.getInstance().scheduleRetryWhenHasTaskConnected();
    }

    public boolean onProgress(long j) {
        this.msgPostDataBuffer.addAndGet(j);
        this.downloadInfo.increaseCurBytes(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return handleProgress(uptimeMillis, needSyncProgress(uptimeMillis));
    }

    public void onCancel() {
        onStatusChanged(-4, null);
    }

    public void onPause() {
        this.downloadInfo.setStatus(-2);
        try {
            this.downloadCache.OnDownloadTaskPause(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        onStatusChanged(-2, null);
    }

    public void onIntercept() {
        this.downloadInfo.setStatus(-7);
        try {
            this.downloadCache.OnDownloadTaskIntercept(this.downloadInfo.getId());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        onStatusChanged(-7, null);
    }

    public void onRetry(BaseException baseException) {
        this.downloadInfo.setFirstDownload(false);
        this.msgPostDataBuffer.set(0L);
        handleRetry(baseException);
    }

    public void onError(BaseException baseException) {
        this.downloadInfo.setFirstDownload(false);
        handleError(baseException);
    }

    public void onReceiveData(byte[] bArr, int i) {
        DownloadListenerUtils.notifyReceiveData(this.subThreadListeners, this.downloadInfo, bArr, i);
    }

    public void onReceiveSegmentData(long j, byte[] bArr, int i) {
        DownloadListenerUtils.notifyReceiveSegmentData(this.subThreadListeners, this.downloadInfo, j, bArr, i);
    }

    public void onReceiveHeader(List<Pair<String, String>> list) {
        DownloadListenerUtils.notifyReceiveHeader(this.subThreadListeners, this.downloadInfo, list);
    }

    public void onReceiveRequestLog(String str) {
        DownloadListenerUtils.notifyReceiveRequestLog(this.subThreadListeners, this.downloadInfo, str);
    }

    private void handleError(BaseException baseException) {
        String str = TAG;
        Logger.taskError(str, this.downloadInfo.getId(), "handleError", "Exception:" + baseException);
        if (Logger.debug()) {
            Logger.taskError(str, this.downloadInfo.getId(), "handleError", "Exception Trace:" + Log.getStackTraceString(new Throwable()));
        }
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                try {
                    this.downloadCache.OnDownloadTaskError(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
                } catch (SQLiteException unused) {
                    this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
        BaseException reviseFailedException = reviseFailedException(baseException);
        this.downloadInfo.setFailedException(reviseFailedException);
        onStatusChanged(reviseFailedException instanceof DownloadPauseReserveWifiException ? -2 : -1, reviseFailedException);
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0) > 0) {
            RetryScheduler.getInstance().tryStartScheduleRetry(this.downloadInfo);
        }
    }

    private BaseException reviseFailedException(BaseException baseException) {
        Context appContext;
        return (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.DOWNLOAD_FAILED_CHECK_NET, 1) != 1 || !DownloadUtils.isNetworkError(baseException) || (appContext = DownloadComponentManager.getAppContext()) == null || DownloadUtils.isNetworkConnected(appContext) || DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK)) ? baseException : new BaseException(1049, baseException.getErrorMessage());
    }

    public void onSaveTempFileSuccess() {
        try {
            if (Logger.debugScene(this.downloadInfo)) {
                Logger.taskDebug(TAG, this.downloadInfo, "onSaveTempFileSuccess", "Success");
            }
            try {
                downloadCompleteProcess();
                DownloadInfo downloadInfo = this.downloadInfo;
                if (downloadInfo == null) {
                    onError(new BaseException(1087, "onSaveTempFileSuccess DownloadInfo is null"));
                    return;
                }
                downloadInfo.setFirstSuccess(false);
                this.downloadInfo.setSuccessByCache(false);
                if (this.downloadInfo.getDownloadFinishTimeStamp() <= 0) {
                    this.downloadInfo.setDownloadFinishTimeStamp(System.currentTimeMillis());
                }
                onStatusChanged(-3, null);
                this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
                this.downloadCache.removeSegments(this.downloadInfo.getId());
            } catch (BaseException e) {
                onError(e);
            }
        } catch (Throwable th) {
            onError(new BaseException(1008, DownloadUtils.getErrorMsgWithTagPrefix(th, "onCompleted")));
        }
    }

    public void onCompleteForFileExist() throws BaseException {
        if (this.downloadInfo == null) {
            throw new BaseException(1087, "onCompleteForFileExist DownloadInfo is null");
        }
        downloadCompleteProcess();
        if (Logger.debugScene(this.downloadInfo)) {
            Logger.taskDebug(TAG, this.downloadInfo, "onCompleteForFileExist", "Success");
        }
        this.downloadInfo.setSuccessByCache(true);
        onStatusChanged(-3, null);
        this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        this.downloadCache.removeSegments(this.downloadInfo.getId());
    }

    public void onCompleteForFileExist(String str, String str2) throws BaseException {
        if (Logger.debugScene(this.downloadInfo)) {
            Logger.taskDebug(TAG, this.downloadInfo, "onCompleteForFileExist", "ExistTargetFileName:" + str2 + " but curName is " + this.downloadInfo.getName());
        }
        DownloadHelper.copyFileFromExistFileWithSameName(this.downloadInfo, str, str2);
        downloadCompleteProcess();
        this.downloadInfo.setSuccessByCache(true);
        onStatusChanged(-3, null);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
    }

    private void downloadCompleteProcess() throws BaseException {
        List<IDownloadCompleteHandler> downloadCompleteHandlers = this.downloadTask.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.downloadInfo;
        onStatusChanged(11, null);
        this.downloadCache.updateDownloadInfo(downloadInfo);
        for (IDownloadCompleteHandler iDownloadCompleteHandler : downloadCompleteHandlers) {
            try {
                if (iDownloadCompleteHandler.needHandle(downloadInfo)) {
                    iDownloadCompleteHandler.handle(downloadInfo);
                    this.downloadCache.updateDownloadInfo(downloadInfo);
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    private boolean handleProgress(long j, boolean z) {
        boolean z2 = false;
        if (this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes()) {
            try {
                this.downloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        if (this.forceRefreshProcess) {
            this.forceRefreshProcess = false;
            this.downloadInfo.setStatus(4);
        }
        if (this.downloadInfo.isNeedPostProgress() && z) {
            z2 = true;
        }
        onStatusChanged(4, null, z2);
        return z;
    }

    private boolean needSyncProgress(long j) {
        boolean z = true;
        if (!this.hasSyncProgressBefore) {
            this.hasSyncProgressBefore = true;
            return true;
        }
        long j2 = j - this.lastSyncProgressTime;
        if (this.msgPostDataBuffer.get() < this.minByteIntervalForSyncProgress && j2 < this.minTimeIntervalForSyncProgress) {
            z = false;
        }
        if (z) {
            this.lastSyncProgressTime = j;
            this.msgPostDataBuffer.set(0L);
        }
        return z;
    }

    private void handleRetry(BaseException baseException) {
        this.downloadCache.OnDownloadTaskRetry(this.downloadInfo.getId());
        onStatusChanged(5, baseException);
    }

    private void onStatusChanged(int i, BaseException baseException) {
        if (this.isFastDownload && (i == 1 || i == 6 || i == 2)) {
            return;
        }
        onStatusChanged(i, baseException, true);
    }

    public void handleWaitingAsyncHandler() {
        this.downloadInfo.setStatus(8);
        this.downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_WAITING);
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), 8);
        }
    }

    private void onStatusChanged(int i, BaseException baseException, boolean z) {
        Map<Integer, IDownloadListener> map;
        Map<Integer, IDownloadListener> map2;
        int status = this.downloadInfo.getStatus();
        if (status == -3 && i == 4) {
            if (Logger.debugScene(this.downloadInfo)) {
                Logger.taskDebug(TAG, this.downloadInfo, "onStatusChanged", "Status = " + status + ", monitorStatus = " + i);
                return;
            }
            return;
        }
        if (i != 4) {
            if (DownloadStatus.isRealTimeUploadStatus(i)) {
                this.downloadInfo.updateRealDownloadTime(false);
                if (DownloadStatus.isTimeUploadStatus(i)) {
                    this.downloadInfo.updateDownloadTime();
                }
            }
            if ((!this.downloadInfo.isAddListenerToSameTask() || this.fixSameTaskMonitorReport) && (!this.mRemoveUselessReport || i != 6)) {
                DownloadMonitorHelper.monitorSend(this.downloadTask, baseException, i);
            }
        }
        if (i == 6) {
            this.downloadInfo.setStatus(2);
        } else if (i == -6) {
            this.downloadInfo.setStatus(-3);
        } else {
            this.downloadInfo.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.downloadInfo.getAsyncHandleStatus() == AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING) {
                this.downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.downloadInfo.getByteInvalidRetryStatus() == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.downloadInfo.setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        DownloadListenerUtils.notifyListener(i, this.subThreadListeners, true, this.downloadInfo, baseException, ListenerType.SUB, this.downloadTask);
        if (i == -4) {
            return;
        }
        if (z && this.mainThreadHandler != null && (((map = this.mainThreadListeners) != null && map.size() > 0) || ((map2 = this.notificationListeners) != null && map2.size() > 0 && (this.downloadInfo.canShowNotification() || this.downloadInfo.isAutoInstallWithoutNotification())))) {
            if (this.fixAnrProcessHandleMsg) {
                notifyDownloadTaskStatus(DownloadComponentManager.getDownloadEngine(), i, baseException);
                return;
            } else {
                this.mainThreadHandler.obtainMessage(i, this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), baseException).sendToTarget();
                return;
            }
        }
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), i);
        }
    }

    private void notifyDownloadTaskStatus(AbsDownloadEngine absDownloadEngine, final int i, final BaseException baseException) {
        final DownloadTask downloadTask = absDownloadEngine.getDownloadTask(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask());
        if (downloadTask == null) {
            Logger.taskError(TAG, this.downloadInfo.getId(), "notifyDownloadTaskStatus", "DownloadTask is null");
            return;
        }
        final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            Logger.taskError(TAG, this.downloadInfo.getId(), "notifyDownloadTaskStatus", "DownloadInfo is null");
            return;
        }
        final Map<Integer, IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
        final Map<Integer, IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
        final boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
        this.mainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadListenerUtils.notifyListener(i, downloadListeners, true, downloadInfo, baseException, ListenerType.MAIN, downloadTask);
                DownloadListenerUtils.notifyListener(i, downloadListeners2, z, downloadInfo, baseException, ListenerType.NOTIFICATION, downloadTask);
            }
        });
        absDownloadEngine.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), i);
    }
}
