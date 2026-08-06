package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadCheckPathModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckPathModule";

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        try {
            checkSavePathValid();
            iDownloadModuleChain.proceed();
        } catch (BaseException e) {
            if (this.mSetting.optInt(DownloadSettingKeys.SAVE_PATH_INVALID_DOWNGRADE) > 0) {
                this.mDownloadInfo.setSavePath(DownloadDirUtils.getDefaultDataPath());
            }
            throw e;
        }
    }

    private void checkSavePathValid() throws BaseException {
        DownloadFile downloadFile = new DownloadFile(this.mDownloadInfo.getSavePath(), this.mDownloadInfo.getName());
        int i = 0;
        if (downloadFile.isTypeError()) {
            this.mDownloadCache.removeDownloadTaskData(this.mDownloadInfo.getId());
            if (DownloadFileUtils.isExternalDownloadEnabled() && DownloadFileUtils.isMediaUri(this.mDownloadInfo.getSavePath())) {
                DownloadFileUtils.setEnableExternalDownload(false);
                this.mDownloadInfo.setSavePath(DownloadDirUtils.getDefaultDataPath());
            }
            throw new BaseException(1081, "download savePath error:" + this.mDownloadInfo.getSavePath() + " extra:" + downloadFile.getExtraMsg());
        }
        if (downloadFile.isTypeMediaStore()) {
            return;
        }
        File file = new File(this.mDownloadInfo.getSavePath());
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (mkdirs || file.exists()) {
                return;
            }
            while (!mkdirs) {
                int i2 = i + 1;
                if (i >= 3) {
                    break;
                }
                try {
                    Thread.sleep(10L);
                    mkdirs = file.mkdirs();
                    i = i2;
                } catch (InterruptedException unused) {
                }
            }
            if (mkdirs || file.exists()) {
                return;
            }
            if (DownloadUtils.getAvailableSpaceBytes(this.mDownloadInfo.getSavePath()) < DownloadConstants.MK_DIR_MIN_SPACE) {
                throw new BaseException(1006, "download savePath directory can not created:" + this.mDownloadInfo.getSavePath());
            }
            throw new BaseException(1030, "download savePath directory can not created:" + this.mDownloadInfo.getSavePath());
        }
        if (file.isDirectory()) {
            return;
        }
        file.delete();
        if (!file.mkdirs() && !file.exists()) {
            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + this.mDownloadInfo.getSavePath());
        }
    }
}
