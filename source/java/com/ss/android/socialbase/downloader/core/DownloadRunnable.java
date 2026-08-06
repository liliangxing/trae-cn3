package com.ss.android.socialbase.downloader.core;

import android.os.Handler;
import android.os.Process;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.module.CheckExternalPublicPathModule;
import com.ss.android.socialbase.downloader.core.module.DownloadBandwidthSamplerModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckFileExistModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckHasAnotherSameTaskModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckPathModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckTaskCanResumedModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckTaskRepetitionModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckWifiTaskValidModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.core.module.DownloadCompleteModule;
import com.ss.android.socialbase.downloader.core.module.DownloadLoadCacheModule;
import com.ss.android.socialbase.downloader.core.module.DownloadMimeTypeInterceptModule;
import com.ss.android.socialbase.downloader.core.module.DownloadPrepareModule;
import com.ss.android.socialbase.downloader.core.module.DownloadRetryModule;
import com.ss.android.socialbase.downloader.core.module.DownloadStartModule;
import com.ss.android.socialbase.downloader.core.module.DownloadTaskInterceptModule;
import com.ss.android.socialbase.downloader.core.module.DownloadUrlInterceptModule;
import com.ss.android.socialbase.downloader.core.module.fast.DownloadFastModule;
import com.ss.android.socialbase.downloader.core.module.multi.DownloadMultiSegmentModule;
import com.ss.android.socialbase.downloader.core.module.normal.DownloadSingleSegmentModule;
import com.ss.android.socialbase.downloader.core.module.pcdn.DownloadPCDNSegmentModule;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadRunnable implements Runnable {
    private static final String TAG = "DownloadRunnable";
    private DownloadCommonParams mCommonParams = new DownloadCommonParams();
    private DownloadModuleChain mDownloadModuleChain = new DownloadModuleChain(this.mCommonParams);
    private Future mFuture;

    public DownloadRunnable(DownloadTask downloadTask, Handler handler) {
        this.mCommonParams.mDownloadTask = downloadTask;
        this.mCommonParams.mDownloadInfo = downloadTask.getDownloadInfo();
        this.mCommonParams.mStatusHandler = new DownloadStatusHandler(downloadTask, handler);
        DownloadCommonParams downloadCommonParams = this.mCommonParams;
        downloadCommonParams.mSetting = DownloadSetting.obtain(downloadCommonParams.mDownloadInfo.getId());
        this.mCommonParams.mDownloadCache = DownloadComponentManager.getDownloadCache();
        this.mCommonParams.mRetryStrategy = new NetworkRetryStrategy(this.mCommonParams.mDownloadInfo);
        this.mCommonParams.mFailoverStrategy = new NetworkFailoverStrategy(this.mCommonParams.mDownloadInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mCommonParams.mDownloadTask.getTimingInfo().threadExecuteTime = System.currentTimeMillis();
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "run", "Run");
        }
        Process.setThreadPriority(10);
        this.mDownloadModuleChain.addDownloadModule(new DownloadCheckTaskRepetitionModule()).addDownloadModule(new DownloadBandwidthSamplerModule()).addDownloadModule(new DownloadPrepareModule()).addDownloadModule(new DownloadUrlInterceptModule()).addDownloadModule(new DownloadTaskInterceptModule()).addDownloadModule(new DownloadLoadCacheModule()).addDownloadModule(new DownloadStartModule()).addDownloadModule(new CheckExternalPublicPathModule()).addDownloadModule(new DownloadMimeTypeInterceptModule()).addDownloadModule(new DownloadCheckFileExistModule()).addDownloadModule(new DownloadRetryModule(new DownloadModuleChain(this.mCommonParams).addDownloadModule(new DownloadCheckPathModule()).addDownloadModule(new DownloadCheckHasAnotherSameTaskModule()).addDownloadModule(new DownloadCheckWifiTaskValidModule()).addDownloadModule(new DownloadCheckTaskCanResumedModule()).addDownloadModule(new DownloadFastModule()).addDownloadModule(new DownloadMultiSegmentModule()).addDownloadModule(new DownloadPCDNSegmentModule()).addDownloadModule(new DownloadSingleSegmentModule()).addDownloadModule(new DownloadCompleteModule())));
        try {
            this.mDownloadModuleChain.proceed();
        } catch (Throwable th) {
            th.printStackTrace();
            this.mCommonParams.mStatusHandler.onError(new BaseException(1045, th));
        }
        afterDownload();
    }

    private void afterDownload() {
        resetStats();
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "run", "Run Time:" + (System.currentTimeMillis() - this.mCommonParams.mDownloadTask.getTimingInfo().threadExecuteTime));
        }
        IDownloadStatusListener downloadStatusListener = DownloadComponentManager.getDownloadStatusListener();
        if (downloadStatusListener != null) {
            downloadStatusListener.onFinish(this.mCommonParams.mDownloadInfo.getStatus());
        }
        try {
            DownloadComponentManager.getDownloadEngine().removeDownloadRunnable(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void pause() {
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "pause", "Run");
        }
        this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_PAUSE;
        this.mDownloadModuleChain.pause();
        if (this.mDownloadModuleChain.isStartDownload()) {
            return;
        }
        this.mCommonParams.mStatusHandler.onPause();
        resetStats();
    }

    public void cancel() {
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "cancel", "Run");
        }
        this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_CANCELED;
        this.mDownloadModuleChain.cancel();
        if (this.mDownloadModuleChain.isStartDownload()) {
            return;
        }
        this.mCommonParams.mStatusHandler.onCancel();
        resetStats();
    }

    public void setThrottleNetSpeed(long j, int i) {
        this.mDownloadModuleChain.setThrottleNetSpeed(j, i);
    }

    public DownloadTask getDownloadTask() {
        return this.mCommonParams.mDownloadTask;
    }

    public boolean isAlive() {
        return this.mCommonParams.mIsAlive;
    }

    public int getDownloadId() {
        return this.mCommonParams.mDownloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.mCommonParams.mDownloadInfo;
    }

    public void prepareDownload() {
        this.mCommonParams.mStatusHandler.onPrepare();
    }

    public void setEnableSegmentDownload(boolean z) {
        this.mCommonParams.mEnableSegmentDownload = z;
    }

    public Future getFuture() {
        return this.mFuture;
    }

    public void setFuture(Future future) {
        this.mFuture = future;
    }

    private void resetStats() {
        this.mCommonParams.mDownloadTask.getTimingInfo().reset();
        this.mCommonParams.mDownloadTask.getThreadInfo().reset();
    }
}
