package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IBizCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AbsAppDownloadEventHandler implements IAppDownloadEventHandler, IBizCallback {
    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleAppInstallError(int i, int i2, String str, String str2, String str3) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleAppInstalled(Context context, String str) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleDownloadCancel(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleDownloadEvent(int i, int i2, String str, int i3, long j) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public boolean installIntercept(int i, boolean z) {
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public boolean isForbidInvalidatePackageInstall() {
        return false;
    }

    public void handleAppInstalled(DownloadInfo downloadInfo, Context context, String str) {
        handleAppInstalled(context, str);
    }

    public boolean isForbidInvalidatePackageInstall(DownloadInfo downloadInfo) {
        return isForbidInvalidatePackageInstall();
    }
}
