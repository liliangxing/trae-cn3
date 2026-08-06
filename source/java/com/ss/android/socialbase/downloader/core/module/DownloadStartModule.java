package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadStartModule extends AbsDownloadModule {
    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        this.mDownloadInfo.updateStartDownloadTime();
        this.mDownloadInfo.resetRealStartDownloadTime();
        this.mDownloadInfo.setCacheExistsInDownloading(false);
        this.mStatusHandler.onStart();
        iDownloadModuleChain.proceed();
    }
}
