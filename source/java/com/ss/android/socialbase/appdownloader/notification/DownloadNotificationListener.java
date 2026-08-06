package com.ss.android.socialbase.appdownloader.notification;

import android.content.Context;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.downloader.depend.AbsNotificationListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadNotificationListener extends AbsNotificationListener {
    private Context context;
    private String extra;

    /* renamed from: id */
    private int f59id;
    private AbsNotificationItem notificationItem;
    private String targetFileName;
    private String targetSavePath;
    private String title;

    public DownloadNotificationListener(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.context = context.getApplicationContext();
        } else {
            this.context = DownloadComponentManager.getAppContext();
        }
        this.f59id = i;
        this.title = str;
        this.targetSavePath = str2;
        this.targetFileName = str3;
        this.extra = str4;
    }

    public DownloadNotificationListener(AbsNotificationItem absNotificationItem) {
        this.context = DownloadComponentManager.getAppContext();
        this.notificationItem = absNotificationItem;
    }

    public DownloadNotificationListener(Context context, DownloadInfo downloadInfo) {
        if (context != null) {
            this.context = context.getApplicationContext();
        } else {
            this.context = DownloadComponentManager.getAppContext();
        }
        if (downloadInfo == null) {
            return;
        }
        this.f59id = downloadInfo.getId();
        this.title = downloadInfo.getTitle();
        this.targetSavePath = downloadInfo.getSavePath();
        this.targetFileName = downloadInfo.getName();
        this.extra = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener
    public AbsNotificationItem createNotificationItem() {
        AbsNotificationItem absNotificationItem = this.notificationItem;
        return (absNotificationItem != null || this.context == null) ? absNotificationItem : new AppNotificationItem(this.context, this.f59id, this.title, this.targetSavePath, this.targetFileName, this.extra);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification() || downloadInfo.getInterceptFlag() != 0) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification() || downloadInfo.getInterceptFlag() != 0) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification() || downloadInfo.getInterceptFlag() != 0) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification() || downloadInfo.getInterceptFlag() != 0) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.context == null || downloadInfo.getInterceptFlag() != 0) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                AppInstallStatsReporter.addStats(downloadInfo.getId(), "DownloadNotificationListener_onSuccessed", "Run");
            }
            ((IDownloadAppInstallService) AppDownloadServiceManager.getService(IDownloadAppInstallService.class)).startInstall(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.context == null || downloadInfo.getInterceptFlag() != 0 || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.IDownloadExtListener
    public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.context == null || downloadInfo.getInterceptFlag() != 0) {
            return;
        }
        super.onWaitingDownloadCompleteHandler(downloadInfo);
    }
}
