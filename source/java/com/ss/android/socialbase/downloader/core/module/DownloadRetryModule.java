package com.ss.android.socialbase.downloader.core.module;

import android.util.Log;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLHandshakeException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadRetryModule extends AbsDownloadModule {
    private static final String TAG = "DownloadRetryModule";
    private DownloadModuleChain mRealDownloadModuleChain;
    private int mRetainRetryTimes;

    public DownloadRetryModule(DownloadModuleChain downloadModuleChain) {
        this.mRealDownloadModuleChain = downloadModuleChain;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        DownloadModuleChain downloadModuleChain = this.mRealDownloadModuleChain;
        if (downloadModuleChain != null) {
            downloadModuleChain.pause();
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        DownloadModuleChain downloadModuleChain = this.mRealDownloadModuleChain;
        if (downloadModuleChain != null) {
            downloadModuleChain.cancel();
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void setThrottleNetSpeed(long j, int i) {
        DownloadModuleChain downloadModuleChain = this.mRealDownloadModuleChain;
        if (downloadModuleChain != null) {
            downloadModuleChain.setThrottleNetSpeed(j, i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        updateRetainRetryTimes();
        do {
            try {
                this.mRealDownloadModuleChain.reset();
                this.mRealDownloadModuleChain.proceed();
                return;
            } catch (DownloadFileExistException unused) {
                DownloadCheckFileExistModule.finishWithFileExist(this.mCommonParams);
                return;
            } catch (BaseException e) {
                Logger.taskError(TAG, this.mDownloadInfo.getId(), "proceed", "BaseException:" + e);
                if (checkTaskFinishByUser()) {
                    return;
                }
            } catch (Throwable th) {
                Logger.taskError(TAG, this.mDownloadInfo.getId(), "proceed", "Throwable:" + th);
                if (!checkTaskFinishByUser()) {
                    throw new BaseException(1000, th);
                }
                return;
            }
        } while (handleException(e) != RetryCheckStatus.RETURN);
    }

    private void updateRetainRetryTimes() {
        if (this.mDownloadInfo.getRetryCount() <= 0) {
            this.mDownloadInfo.setRetryCount(1);
        }
        this.mRetainRetryTimes = this.mDownloadInfo.getRetryCount();
    }

    private RetryCheckStatus handleException(BaseException baseException) throws BaseException {
        if (handleSwitchBackupUrl(baseException)) {
            return RetryCheckStatus.CONTINUE;
        }
        if (handleDownloadExists(baseException)) {
            return RetryCheckStatus.RETURN;
        }
        if (canRetry(baseException)) {
            return onRetry(baseException);
        }
        throw getTargetException(baseException);
    }

    private boolean handleSwitchBackupUrl(BaseException baseException) throws BaseException {
        if (baseException.getErrorCode() != 1089) {
            return false;
        }
        if (this.mRetainRetryTimes > 0) {
            DownloadInfo downloadInfo = this.mDownloadInfo;
            int i = this.mRetainRetryTimes - 1;
            this.mRetainRetryTimes = i;
            downloadInfo.updateCurRetryTime(i);
            this.mDownloadInfo.setStatus(5);
            return true;
        }
        if (this.mDownloadInfo.trySwitchToNextBackupUrl()) {
            this.mDownloadInfo.setStatus(5);
            this.mRetainRetryTimes = this.mDownloadInfo.getRetryCount();
            this.mDownloadInfo.updateCurRetryTime(this.mRetainRetryTimes);
            return true;
        }
        throw getTargetException(baseException);
    }

    private BaseException getTargetException(BaseException baseException) {
        Throwable cause = baseException.getCause();
        if (cause == null) {
            return baseException;
        }
        if (cause instanceof BaseException) {
            return (BaseException) cause;
        }
        return new BaseException(DownloadErrorCode.ERROR_INNER_RETRY, cause);
    }

    private boolean handleDownloadExists(BaseException baseException) {
        if (baseException.getErrorCode() != 1025) {
            return false;
        }
        this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        return true;
    }

    private boolean canRetry(BaseException baseException) {
        if (DownloadHelper.isInterceptError(baseException)) {
            return false;
        }
        if (baseException instanceof DownloadMultiSegmentException) {
            if (DownloadUtils.isNetworkError(baseException) && this.mRetainRetryTimes < this.mDownloadInfo.getRetryCount()) {
                return false;
            }
            if (DownloadHelper.isResponseCodeError(baseException)) {
                clearCurrentDownloadData();
                return true;
            }
        } else if (baseException instanceof DownloadPCDNException) {
            if (DownloadUtils.isNetworkError(baseException)) {
                return false;
            }
        } else if (this.mCommonParams.mRetryStrategy.canRetry(baseException)) {
            return true;
        }
        return (this.mRetainRetryTimes > 0 || this.mDownloadInfo.hasNextBackupUrl() || (DownloadHelper.isHttpsError(baseException) && this.mDownloadInfo.canReplaceHttpForRetry())) && !(baseException instanceof DownloadRetryNeedlessException);
    }

    private RetryCheckStatus onRetry(BaseException baseException) throws BaseException {
        if (DownloadHelper.isHttpDataDirtyError(baseException)) {
            clearCurrentDownloadData();
        }
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        if (checkTaskFinishByUser()) {
            return RetryCheckStatus.RETURN;
        }
        if (baseException.getErrorCode() == 1047) {
            if (onRetryWithForbidden(baseException) == RetryCheckStatus.RETURN) {
                return RetryCheckStatus.RETURN;
            }
        } else if (DownloadUtils.isInsufficientSpaceError(baseException)) {
            if (onRetryWithInsufficientSpace(baseException) == RetryCheckStatus.RETURN) {
                return RetryCheckStatus.RETURN;
            }
        } else {
            handleRetryTime(baseException);
        }
        this.mStatusHandler.onRetry(baseException);
        return RetryCheckStatus.CONTINUE;
    }

    private RetryCheckStatus onRetryWithForbidden(BaseException baseException) throws BaseException {
        IDownloadForbiddenHandler forbiddenHandler = this.mDownloadTask.getForbiddenHandler();
        if (forbiddenHandler == null || this.mDownloadInfo.isForbiddenRetryed()) {
            handleRetryTime(baseException);
        } else {
            AbsDownloadForbiddenCallback absDownloadForbiddenCallback = new AbsDownloadForbiddenCallback() { // from class: com.ss.android.socialbase.downloader.core.module.DownloadRetryModule.1
                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback, com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
                public void onCallback(List<String> list) {
                    super.onCallback(list);
                    DownloadRetryModule.this.handleForbiddenCallback(list);
                }
            };
            boolean onForbidden = forbiddenHandler.onForbidden(absDownloadForbiddenCallback);
            this.mDownloadInfo.setForbiddenRetryed();
            if (onForbidden && !absDownloadForbiddenCallback.hasCallback()) {
                this.mStatusHandler.handleWaitingAsyncHandler();
                this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                return RetryCheckStatus.RETURN;
            }
        }
        return RetryCheckStatus.CONTINUE;
    }

    private RetryCheckStatus onRetryWithInsufficientSpace(BaseException baseException) throws BaseException {
        long j;
        long totalBytes;
        IDownloadDiskSpaceHandler diskSpaceHandler = this.mDownloadTask.getDiskSpaceHandler();
        if (diskSpaceHandler == null) {
            throw baseException;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback = new IDownloadDiskSpaceCallback() { // from class: com.ss.android.socialbase.downloader.core.module.DownloadRetryModule.2
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback
            public void onDiskCleaned() {
                synchronized (DownloadRetryModule.this) {
                    atomicBoolean.set(true);
                    DownloadRetryModule.this.handleDiskSpaceCallback();
                }
            }
        };
        if (baseException instanceof DownloadOutOfSpaceException) {
            DownloadOutOfSpaceException downloadOutOfSpaceException = (DownloadOutOfSpaceException) baseException;
            long avaliableSpaceBytes = downloadOutOfSpaceException.getAvaliableSpaceBytes();
            long requiredSpaceBytes = downloadOutOfSpaceException.getRequiredSpaceBytes();
            j = avaliableSpaceBytes;
            totalBytes = requiredSpaceBytes;
        } else {
            j = -1;
            totalBytes = this.mDownloadInfo.getTotalBytes();
        }
        synchronized (this) {
            if (diskSpaceHandler.cleanUpDisk(j, totalBytes, iDownloadDiskSpaceCallback)) {
                if (!atomicBoolean.get()) {
                    if (this.mCommonParams.mRunStatus != RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        this.mStatusHandler.handleWaitingAsyncHandler();
                    }
                    return RetryCheckStatus.RETURN;
                }
                handleRetryTime(baseException);
                return RetryCheckStatus.CONTINUE;
            }
            if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return RetryCheckStatus.RETURN;
            }
            throw baseException;
        }
    }

    private void handleRetryTime(BaseException baseException) throws BaseException {
        boolean z;
        if (!(baseException instanceof DownloadMultiSegmentException) && !(baseException instanceof DownloadPCDNException)) {
            this.mCommonParams.mFailoverStrategy.handleError(baseException);
            if (this.mCommonParams.mRetryStrategy.canRetry(baseException)) {
                this.mCommonParams.mRetryStrategy.doRetry();
                this.mDownloadInfo.setCurNetworkRetryCount(this.mCommonParams.mRetryStrategy.getTotalRetryCount());
                return;
            }
        }
        if (this.mRetainRetryTimes <= 0 || baseException.getErrorCode() == 1070) {
            z = false;
            if (this.mDownloadInfo.trySwitchToNextBackupUrl()) {
                this.mRetainRetryTimes = this.mDownloadInfo.getBackUpUrlRetryCount();
                this.mDownloadInfo.updateCurRetryTime(this.mRetainRetryTimes);
            } else if ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.mDownloadInfo.canReplaceHttpForRetry()) {
                this.mRetainRetryTimes = this.mDownloadInfo.getRetryCount();
                this.mDownloadInfo.updateCurRetryTime(this.mRetainRetryTimes);
                this.mDownloadInfo.setHttpsToHttpRetryUsed(true);
            } else {
                throw new BaseException(baseException.getErrorCode(), String.format(Locale.US, "retry for exception, but current retry time : %s , retry Time %d all used, last error is %s", String.valueOf(this.mRetainRetryTimes), Integer.valueOf(this.mDownloadInfo.getRetryCount()), baseException.getErrorMessage()));
            }
        } else {
            z = true;
        }
        if (z) {
            DownloadInfo downloadInfo = this.mDownloadInfo;
            int i = this.mRetainRetryTimes - 1;
            this.mRetainRetryTimes = i;
            downloadInfo.updateCurRetryTime(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleForbiddenCallback(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mDownloadInfo.setForbiddenBackupUrls(list, this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER);
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.restartAsyncWaitingTask(this.mDownloadInfo.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDiskSpaceCallback() {
        AbsDownloadEngine downloadEngine;
        if (checkTaskFinishByUser() || (downloadEngine = DownloadComponentManager.getDownloadEngine()) == null) {
            return;
        }
        downloadEngine.restartAsyncWaitingTask(this.mDownloadInfo.getId());
    }

    private void clearCurrentDownloadData() {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "clearCurrentDownloadData", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        try {
            this.mDownloadCache.removeSegments(this.mDownloadInfo.getId());
            DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
            this.mDownloadInfo.resetDataForEtagEndure("");
            this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
