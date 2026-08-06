package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes7.dex */
public interface IBeforeAppInstallInterceptor {
    void intercept(DownloadInfo downloadInfo, IAppInstallInterceptCallback iAppInstallInterceptCallback);
}
