package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallDetectorListener;
import com.ss.android.socialbase.appdownloader.util.ApkInstallDetector;
import com.ss.android.socialbase.appdownloader.util.AppInstallUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadAppInstallService implements IDownloadAppInstallService {
    private static final String TAG = "DownloadAppInstallService";

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
    public void startInstall(DownloadInfo downloadInfo) {
        AppInstallUtils.startInstall(downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
    public void handleApkInstalled(String str) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "handleApkInstalled", "PackageName:" + str);
        }
        try {
            handleApkInstalledImpl(str);
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "handleApkInstalled", "Error:" + th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleApkInstalledImpl(String str) {
        List successedDownloadInfosWithMimeType;
        Context appContext = DownloadComponentManager.getAppContext();
        IAppDownloadEventHandler appDownloadEventHandler = AppDownloader.getInstance().getAppDownloadEventHandler();
        int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.DELETE_APK_DURATION_INSTALL_TIME_DELAY_S);
        List downloadInfosByFileExtension = Downloader.getInstance(appContext).getDownloadInfosByFileExtension(Constants.APK_SUFFIX);
        if (downloadInfosByFileExtension != null && !downloadInfosByFileExtension.isEmpty()) {
            reverseOrder(downloadInfosByFileExtension);
            for (DownloadInfo downloadInfo : downloadInfosByFileExtension) {
                if (downloadInfo != null && downloadInfo.getStatus() == -3 && AppDownloadUtils.isPackageNameValid(downloadInfo, str)) {
                    if (downloadInfo.getInstalledTimeStamp() <= 0) {
                        downloadInfo.setInstalledTimeStamp(System.currentTimeMillis());
                        Downloader.getInstance(appContext).updateDownloadInfo(downloadInfo);
                    }
                    if (optInt > 0) {
                        deleteInstallApkFile(downloadInfo, optInt);
                        optInt = 0;
                    }
                    if (appDownloadEventHandler != null) {
                        if (appDownloadEventHandler instanceof AbsAppDownloadEventHandler) {
                            ((AbsAppDownloadEventHandler) appDownloadEventHandler).handleAppInstalled(downloadInfo, appContext, str);
                        } else {
                            appDownloadEventHandler.handleAppInstalled(appContext, str);
                        }
                    }
                    successedDownloadInfosWithMimeType = Downloader.getInstance(appContext).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
                    if (successedDownloadInfosWithMimeType != null || successedDownloadInfosWithMimeType.isEmpty()) {
                    }
                    reverseOrder(successedDownloadInfosWithMimeType);
                    for (final DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                        if (downloadInfo2 != null && AppDownloadUtils.isPackageNameValid(downloadInfo2, str)) {
                            if (Logger.debugScene(downloadInfo2)) {
                                Logger.taskDebug(TAG, downloadInfo2, "handleApkInstalledImpl", "Callback");
                            }
                            IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(appContext).getDownloadNotificationEventListener(downloadInfo2.getId());
                            if (downloadNotificationEventListener != null && DownloadUtils.isProcessNameSame(downloadNotificationEventListener.getNotifyProcessName())) {
                                downloadNotificationEventListener.onNotificationEvent(9, downloadInfo2, str, "");
                            }
                            AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo2.getId());
                            if (notificationItem != null) {
                                notificationItem.updateNotification(null, false);
                            }
                            ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorDownloadApp(downloadInfo2, Constants.APP_INSTALL_FINISH, 3);
                            if (optInt > 0) {
                                deleteInstallApkFile(downloadInfo2, optInt);
                            }
                            DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.service.DownloadAppInstallService.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (downloadInfo2.isSavePathRedirected()) {
                                            DownloadUtils.clearAntiHijackDir(downloadInfo2);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }, 1000L, TimeUnit.MILLISECONDS);
                            return;
                        }
                    }
                    return;
                }
            }
        }
        downloadInfo = null;
        if (appDownloadEventHandler != null) {
        }
        successedDownloadInfosWithMimeType = Downloader.getInstance(appContext).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (successedDownloadInfosWithMimeType != null) {
        }
    }

    private void reverseOrder(List<DownloadInfo> list) {
        Collections.sort(list, new Comparator<DownloadInfo>() { // from class: com.ss.android.socialbase.appdownloader.service.DownloadAppInstallService.2
            @Override // java.util.Comparator
            public int compare(DownloadInfo downloadInfo, DownloadInfo downloadInfo2) {
                if (downloadInfo.getDownloadFinishTimeStamp() > downloadInfo2.getDownloadFinishTimeStamp()) {
                    return -1;
                }
                return downloadInfo.getDownloadFinishTimeStamp() == downloadInfo2.getDownloadFinishTimeStamp() ? 0 : 1;
            }
        });
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
    public void setAppInstallDetectorListener(IAppInstallDetectorListener iAppInstallDetectorListener) {
        ApkInstallDetector.getInstance().setAppInstallDetectorListener(iAppInstallDetectorListener);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
    public void startAppInstallDetector(Context context, PackageInfo packageInfo, JSONObject jSONObject) {
        if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName)) {
            return;
        }
        DownloadInfo downloadInfo = new DownloadInfo();
        String md5Hex = DownloadUtils.md5Hex(packageInfo.packageName);
        if (TextUtils.isEmpty(md5Hex)) {
            downloadInfo.setId(0);
        } else {
            downloadInfo.setId(md5Hex.hashCode());
        }
        ApkInstallDetector.getInstance().start(context, downloadInfo, packageInfo, jSONObject);
    }

    private static void deleteInstallApkFile(final DownloadInfo downloadInfo, int i) {
        if (DownloadDirUtils.isSavePathSecurity(downloadInfo.getSavePath()) || (DownloadFileUtils.isExternalDownloadEnabled() && DownloadFileUtils.isMediaUri(downloadInfo.getSavePath()))) {
            DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.service.DownloadAppInstallService.3
                @Override // java.lang.Runnable
                public void run() {
                    if (Logger.debug()) {
                        Logger.taskDebug(DownloadAppInstallService.TAG, DownloadInfo.this, "deleteInstallApkFile", "Run");
                    }
                    DownloadUtils.deleteAllDownloadFiles(DownloadInfo.this);
                }
            }, i, TimeUnit.SECONDS);
        }
    }
}
