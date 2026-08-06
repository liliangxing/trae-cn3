package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IBizCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AbsAppDownloadDepend implements IAppDownloadDepend, IBizCallback {
    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    @Deprecated
    public boolean getAllowBootReceiver() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public boolean getAllowNetwork(Context context) {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(Context context) {
        return null;
    }

    public boolean isForbiddenInstallForInvalidatePackageName() {
        return false;
    }

    @Deprecated
    public boolean needClearWhenTaskReset() {
        return true;
    }

    public boolean getAllowNetwork(int i, Context context) {
        return getAllowNetwork(context);
    }

    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(int i, Context context) {
        return getThemedAlertDlgBuilder(context);
    }

    public boolean isForbiddenInstallForInvalidatePackageName(DownloadInfo downloadInfo) {
        return isForbiddenInstallForInvalidatePackageName();
    }
}
