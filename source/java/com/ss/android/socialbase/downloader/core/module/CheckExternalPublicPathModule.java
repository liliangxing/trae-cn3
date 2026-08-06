package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CheckExternalPublicPathModule extends AbsDownloadModule {
    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        if (downloadCommonParams.mSetting.optInt(DownloadSettingKeys.RUN_CLEANER_BACKGROUND_DELAY_TIME_S) <= 0 || downloadCommonParams.mSetting.optInt(DownloadSettingKeys.REMOVE_EXTERNAL_PUBLIC_DIR_TASK_FOR_Q) <= 0 || !DownloadFileUtils.isAtLeastAndroidQ()) {
            return null;
        }
        return super.init(downloadCommonParams);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (!TextUtils.isEmpty(this.mDownloadInfo.getSavePath()) && !DownloadFileUtils.isMediaUri(this.mDownloadInfo.getSavePath()) && DownloadFileUtils.isFilePathInExternalPublicDir(this.mDownloadInfo.getSavePath())) {
            throw new BaseException(1094, "External Public Path Error:" + this.mDownloadInfo.getSavePath());
        }
        iDownloadModuleChain.proceed();
    }
}
