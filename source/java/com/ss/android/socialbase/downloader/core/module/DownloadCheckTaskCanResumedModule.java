package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadCheckTaskCanResumedModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckTaskCanResumedModule";

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
        checkTaskCanResume();
        iDownloadModuleChain.proceed();
    }

    private void checkTaskCanResume() {
        long curByte = DownloadHelper.getCurByte(this.mDownloadInfo);
        long curBytes = this.mDownloadInfo.getCurBytes();
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "checkTaskCanResume", "Offset:" + curByte + " curBytes: " + curBytes);
        }
        this.mDownloadInfo.setCurBytes(curByte);
        if (!(curByte > 0) && !this.mCommonParams.mNeedCheckIfModified) {
            if (Logger.debugScene(this.mDownloadInfo)) {
                Logger.taskDebug(TAG, this.mDownloadInfo, "checkTaskCanResume", "deleteAllDownloadFiles");
            }
            this.mDownloadCache.removeSegments(this.mDownloadInfo.getId());
            DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        }
        if (this.mSetting.optInt(DownloadSettingKeys.CLEAN_INSTALLED_APK) > 0) {
            this.mDownloadInfo.setInstalledTimeStamp(0L);
            this.mDownloadInfo.setHasDoInstallation(false);
        }
    }
}
