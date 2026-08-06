package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.md5.TTMd5;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadCompleteModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCompleteModule";
    private BaseException mException;
    private String mMd5 = null;

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        if (isFinishStatus()) {
            return;
        }
        checkCompleted();
    }

    private boolean isFinishStatus() {
        return checkTaskFinishByUser() || this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_INTERCEPT || this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER || this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_END_RIGHT_NOW || this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
    }

    private void checkCompleted() throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Run");
        }
        this.mException = null;
        if (this.mDownloadInfo.isChunked()) {
            this.mDownloadInfo.setTotalBytes(this.mDownloadInfo.getCurBytes());
        }
        this.mDownloadInfo.setFirstDownload(false);
        if (!this.mDownloadInfo.isIgnoreDataVerify() && this.mDownloadInfo.getCurBytes() != this.mDownloadInfo.getTotalBytes()) {
            if (Logger.debugScene(this.mDownloadInfo)) {
                Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Error curBytes != totalBytes");
            }
            this.mException = new BaseException(1027, "current bytes is not equals to total bytes, curBytes:" + this.mDownloadInfo.getCurBytes() + " totalBytes:" + this.mDownloadInfo.getTotalBytes());
        } else if (this.mDownloadInfo.getCurBytes() <= 0) {
            if (Logger.debugScene(this.mDownloadInfo)) {
                Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Error curBytes <=0");
            }
            this.mException = new BaseException(1026, "curBytes <= 0");
        } else if (!this.mDownloadInfo.isIgnoreDataVerify() && this.mDownloadInfo.getTotalBytes() <= 0) {
            if (Logger.debugScene(this.mDownloadInfo)) {
                Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Error totalBytes <=0");
            }
            this.mException = new BaseException(1044, "TotalBytes <= 0");
        } else {
            this.mMd5 = null;
            if (this.mSetting.optInt(DownloadSettingKeys.ENABLE_REPLACE_EXTERNAL_PATH) > 0 && TextUtils.isEmpty(this.mDownloadInfo.getMd5())) {
                this.mMd5 = TTMd5.md5(new File(this.mDownloadInfo.getTempPath(), this.mDownloadInfo.getTempName()));
            }
            DownloadHelper.saveFileAsTargetName(this.mDownloadInfo, this.mDownloadTask.getMonitorDepend(), new ITempFileSaveCompleteCallback() { // from class: com.ss.android.socialbase.downloader.core.module.DownloadCompleteModule.1
                @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
                public void onSuccess() {
                    DownloadCompleteModule.this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_COMPLETED;
                    if (Logger.debugScene(DownloadCompleteModule.this.mDownloadInfo)) {
                        Logger.taskDebug(DownloadCompleteModule.TAG, DownloadCompleteModule.this.mDownloadInfo, "onSuccess", "Save file success");
                    }
                    if (TextUtils.isEmpty(DownloadCompleteModule.this.mMd5)) {
                        return;
                    }
                    DownloadCompleteModule.this.mDownloadInfo.setMd5(DownloadCompleteModule.this.mMd5);
                    if (Logger.debugScene(DownloadCompleteModule.this.mDownloadInfo)) {
                        Logger.taskDebug(DownloadCompleteModule.TAG, DownloadCompleteModule.this.mDownloadInfo, "onSuccess", "Save file md5:" + DownloadCompleteModule.this.mMd5);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
                public void onFailed(BaseException baseException) {
                    DownloadCompleteModule.this.mException = baseException;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
                public void onSameTaskSave() {
                    DownloadCompleteModule.this.mCommonParams.mRunStatus = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                    if (Logger.debugScene(DownloadCompleteModule.this.mDownloadInfo)) {
                        Logger.taskDebug(DownloadCompleteModule.TAG, DownloadCompleteModule.this.mDownloadInfo, "onSameTaskSave", "Same task save");
                    }
                }
            });
        }
        if (this.mException == null) {
            return;
        }
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Download fail and reset" + this.mException);
        }
        this.mDownloadInfo.reset();
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        this.mDownloadCache.removeSegments(this.mDownloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        throw this.mException;
    }
}
