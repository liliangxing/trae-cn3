package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsDownloadInterceptor implements IDownloadInterceptor, IBizCallback {
    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }

    public boolean intercept(DownloadInfo downloadInfo) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
    @Deprecated
    public boolean intercepte() {
        return false;
    }
}
