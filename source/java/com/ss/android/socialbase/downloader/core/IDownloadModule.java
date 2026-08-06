package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* loaded from: classes7.dex */
public interface IDownloadModule {
    void cancel();

    IDownloadModule init(DownloadCommonParams downloadCommonParams);

    void pause();

    void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException;

    void setThrottleNetSpeed(long j, int i);
}
