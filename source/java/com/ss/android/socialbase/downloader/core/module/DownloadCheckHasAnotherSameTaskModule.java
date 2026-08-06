package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadCheckHasAnotherSameTaskModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckHasAnotherSameTaskModule";

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
        checkHasAnotherSameTask();
        iDownloadModuleChain.proceed();
    }

    private void checkHasAnotherSameTask() throws BaseException {
        int id = this.mDownloadInfo.getId();
        int downloadId = DownloadComponentManager.getDownloadId(this.mDownloadInfo);
        DownloadInfo downloadInfo = this.mDownloadCache.getDownloadInfo(downloadId);
        if (downloadInfo == null || downloadInfo.getId() == id || !downloadInfo.equalsTask(this.mDownloadInfo)) {
            return;
        }
        if (DownloadComponentManager.getDownloadEngine().isDownloading(downloadInfo.getId())) {
            this.mDownloadCache.removeDownloadTaskData(id);
            throw new BaseException(1025, "another same task is downloading");
        }
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        this.mDownloadCache.removeDownloadTaskData(downloadId);
        if (downloadInfo.isFileDataValid()) {
            this.mDownloadInfo.copyFromCacheData(downloadInfo, false);
            this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
            throw new BaseException(DownloadErrorCode.ERROR_INNER_RETRY, "retry task because id generator changed");
        }
    }
}
