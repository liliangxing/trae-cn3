package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsDownloadModule implements IDownloadModule {
    protected DownloadCommonParams mCommonParams;
    protected IDownloadCache mDownloadCache;
    protected DownloadInfo mDownloadInfo;
    protected DownloadTask mDownloadTask;
    protected DownloadSetting mSetting;
    protected DownloadStatusHandler mStatusHandler;

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void setThrottleNetSpeed(long j, int i) {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        this.mCommonParams = downloadCommonParams;
        this.mDownloadCache = downloadCommonParams.mDownloadCache;
        this.mDownloadTask = downloadCommonParams.mDownloadTask;
        this.mDownloadInfo = downloadCommonParams.mDownloadInfo;
        this.mSetting = downloadCommonParams.mSetting;
        this.mStatusHandler = downloadCommonParams.mStatusHandler;
        return this;
    }

    public boolean checkTaskFinishByUser() {
        if (this.mCommonParams.mDownloadInfo.getStatus() == -2) {
            if (this.mCommonParams.mRunStatus != RunStatus.RUN_STATUS_PAUSE) {
                this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_PAUSE;
            }
            return true;
        }
        if (this.mCommonParams.mDownloadInfo.getStatus() != -4) {
            return this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_CANCELED || this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_PAUSE;
        }
        if (this.mCommonParams.mRunStatus != RunStatus.RUN_STATUS_CANCELED) {
            this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_CANCELED;
        }
        return true;
    }
}
