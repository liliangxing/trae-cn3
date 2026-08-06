package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppInstallUtils {
    public static void startInstall(DownloadInfo downloadInfo) {
        installApk(downloadInfo);
    }

    private static void installApk(final DownloadInfo downloadInfo) {
        final Context appContext = DownloadComponentManager.getAppContext();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || AppDownloadUtils.canNotAutoInstall(downloadInfo.getExtra()) || !AppDownloadUtils.isApkValid(downloadInfo)) && DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.AUTO_INSTALL_WHEN_RESUME, 0) != 1) {
            z = false;
        }
        final int startViewIntent = z ? AppDownloadUtils.startViewIntent(appContext, downloadInfo.getId(), false) : 2;
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug("AppInstallUtils", downloadInfo, "installApk", "Status:" + startViewIntent);
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.util.AppInstallUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorDownloadApp(DownloadInfo.this, Constants.APP_INSTALL_START, startViewIntent);
                IAppDownloadEventHandler appDownloadEventHandler = AppDownloader.getInstance().getAppDownloadEventHandler();
                IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(appContext).getDownloadNotificationEventListener(DownloadInfo.this.getId());
                if (appDownloadEventHandler == null && downloadNotificationEventListener == null) {
                    return;
                }
                DownloadFile downloadFile = new DownloadFile(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                if (downloadFile.exists()) {
                    try {
                        PackageInfo packageInfo = AppDownloadUtils.getPackageInfo(DownloadInfo.this, downloadFile.getFile());
                        if (packageInfo != null) {
                            String packageName = (startViewIntent == 1 || TextUtils.isEmpty(DownloadInfo.this.getPackageName())) ? packageInfo.packageName : DownloadInfo.this.getPackageName();
                            if (appDownloadEventHandler != null) {
                                appDownloadEventHandler.handleDownloadEvent(DownloadInfo.this.getId(), 1, packageName, -3, DownloadInfo.this.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.onNotificationEvent(1, DownloadInfo.this, packageName, "");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
