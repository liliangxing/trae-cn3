package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadCheckFileExistModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckFileExistModule";

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        if (downloadCommonParams.mDownloadInfo.isFastDownload()) {
            return null;
        }
        return super.init(downloadCommonParams);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        if (!TextUtils.isEmpty(this.mCommonParams.mExistTargetFileName)) {
            if (this.mDownloadInfo.isExpiredRedownload()) {
                this.mCommonParams.mNeedCheckIfModified = DownloadUtils.cacheExpiredWithHttp(this.mDownloadInfo, this.mDownloadInfo.isExpiredHttpCheck());
            }
            if (!this.mCommonParams.mNeedCheckIfModified) {
                finishWithFileExist(this.mCommonParams);
                return;
            }
        }
        if (!this.mDownloadInfo.isExpiredRedownload() && this.mDownloadInfo.isDownloaded()) {
            this.mCommonParams.mExistTargetFileName = this.mDownloadInfo.getName();
            this.mCommonParams.mExistTargetFilePath = this.mDownloadInfo.getSavePath();
            finishWithFileExist(this.mCommonParams);
            return;
        }
        if (this.mDownloadInfo.getChunkCount() > 1) {
            this.mDownloadInfo.reset();
            DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
            this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        }
        iDownloadModuleChain.proceed();
    }

    public static void finishWithFileExist(DownloadCommonParams downloadCommonParams) {
        if (downloadCommonParams.mExistTargetFileName.equals(downloadCommonParams.mDownloadInfo.getName())) {
            downloadCommonParams.mRunStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        } else {
            downloadCommonParams.mRunStatus = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
        }
        downloadCommonParams.mDownloadInfo.setCacheExistsInDownloading(true);
    }
}
