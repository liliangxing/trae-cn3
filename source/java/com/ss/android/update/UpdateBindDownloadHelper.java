package com.ss.android.update;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.common.util.NetUtils;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateBindDownloadHelper {
    private static UpdateBindDownloadHelper sInstance = new UpdateBindDownloadHelper();

    public static UpdateBindDownloadHelper inst() {
        return sInstance;
    }

    private UpdateBindDownloadHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBindAppDownloadSuccess(Context context, String str) {
        com.ss.android.socialbase.downloader.model.DownloadInfo appDownloadInfo = AppDownloader.getInstance().getAppDownloadInfo(context, str);
        if (appDownloadInfo == null || TextUtils.isEmpty(appDownloadInfo.getSavePath()) || TextUtils.isEmpty(appDownloadInfo.getName()) || AppDownloadUtils.isApkInstalled(context, appDownloadInfo.getSavePath(), appDownloadInfo.getName())) {
            return false;
        }
        return appDownloadInfo.getStatus() == -3 && new File(appDownloadInfo.getSavePath(), appDownloadInfo.getName()).exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleBindAppOpen(Context context, String str) {
        com.ss.android.socialbase.downloader.model.DownloadInfo appDownloadInfo = AppDownloader.getInstance().getAppDownloadInfo(context, str);
        if (appDownloadInfo == null || appDownloadInfo.getStatus() != -3) {
            return;
        }
        AppDownloader.startInstall(context, appDownloadInfo.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bindDownloadUrlLink(String str, String str2, Context context, boolean z, boolean z2, boolean z3, IDownloadListener iDownloadListener) {
        return AppDownloader.getInstance().addDownloadTask(new AppTaskBuilder(context, str).name(str2).showNotification(z2).needWifi(z3).mainThreadListener(iDownloadListener));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int checkApiException(Context context, Throwable th) {
        return NetUtils.checkApiException(context, th);
    }
}
