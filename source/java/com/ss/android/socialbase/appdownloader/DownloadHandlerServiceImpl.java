package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.widget.Toast;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.appdownloader.view.MultiProcessDownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.ttm.player.C0968C;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadHandlerServiceImpl {
    public static void onStartCommand(Context context, Intent intent) {
        handleIntent(context, intent);
    }

    private static boolean handleIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        IAppDownloadEventHandler appDownloadEventHandler = AppDownloader.getInstance().getAppDownloadEventHandler();
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra(Constants.EXTRA_FROM_NOTIFICATION, false) && DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.NOTIFICATION_OPT_2) == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals(Constants.ACTION_CLICK_CONTENT)) {
            handleClickNonBtnAreaWhenUnSuccess(context, downloadInfo, appDownloadEventHandler, downloadNotificationEventListener);
        } else if (action.equals(Constants.ACTION_OPEN)) {
            handleActionClickWithoutType(context, downloadInfo, appDownloadEventHandler, downloadNotificationEventListener);
        } else if (action.equals(Constants.ACTION_CLICK_BTN)) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            handleActionClickWithoutType(context, downloadInfo, appDownloadEventHandler, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION, 0) == 0) {
                if (!(DownloadSetting.obtain(intExtra).optInt("enable_notification_ui") >= 2 && downloadInfo.getStatus() == -1)) {
                    DownloadNotificationManager.getInstance().hideNotification(intExtra);
                    DownloadNotificationManager.getInstance().cancelNotification(intExtra);
                }
            }
        } else if (action.equals(Constants.ACTION_DELETE)) {
            handleDelete(context, downloadInfo, appDownloadEventHandler, downloadNotificationEventListener);
        } else if (action.equals(Constants.ACTION_HIDE)) {
            DownloadNotificationManager.getInstance().hideNotification(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add(DownloadConstants.MIME_PLG);
                        Downloader.getInstance(DownloadComponentManager.getAppContext()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private static void cancelReserveWifi(Context context, DownloadInfo downloadInfo) {
        if (DownloadUtils.isWifi(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void handleClickNotificationInstall(Context context, final IAppDownloadEventHandler iAppDownloadEventHandler, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (iAppDownloadEventHandler == null && downloadNotificationEventListener == null) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfo;
                try {
                    DownloadFile downloadFile = new DownloadFile(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (downloadFile.exists()) {
                        try {
                            String str = (DownloadComponentManager.getAppContext() == null || (packageInfo = AppDownloadUtils.getPackageInfo(DownloadInfo.this, downloadFile.getFile())) == null) ? "" : packageInfo.packageName;
                            IAppDownloadEventHandler iAppDownloadEventHandler2 = iAppDownloadEventHandler;
                            if (iAppDownloadEventHandler2 != null) {
                                iAppDownloadEventHandler2.handleDownloadEvent(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            IDownloadNotificationEventListener iDownloadNotificationEventListener = downloadNotificationEventListener;
                            if (iDownloadNotificationEventListener != null) {
                                iDownloadNotificationEventListener.onNotificationEvent(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void handleClickNonBtnAreaWhenUnSuccess(Context context, DownloadInfo downloadInfo, IAppDownloadEventHandler iAppDownloadEventHandler, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        boolean onClickWhenUnSuccess;
        Intent intent;
        int id = downloadInfo.getId();
        INotificationClickCallback notificationClickCallback = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getNotificationClickCallback(id);
        if (notificationClickCallback != null) {
            try {
                onClickWhenUnSuccess = notificationClickCallback.onClickWhenUnSuccess(downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (onClickWhenUnSuccess) {
                if (DownloadUtils.optimizeMultiProcess()) {
                    intent = new Intent(context, (Class<?>) MultiProcessDownloadTaskDeleteActivity.class);
                } else {
                    intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
                }
                intent.putExtra("extra_click_download_ids", id);
                intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
                context.startActivity(intent);
                DownloadNotificationManager.getInstance().hideNotification(id);
                downloadInfo.updateDownloadTime();
                if (iAppDownloadEventHandler != null) {
                    iAppDownloadEventHandler.handleDownloadEvent(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(7, downloadInfo, "", "");
                    return;
                }
                return;
            }
            return;
        }
        onClickWhenUnSuccess = false;
        if (onClickWhenUnSuccess) {
        }
    }

    private static void handleDelete(Context context, DownloadInfo downloadInfo, IAppDownloadEventHandler iAppDownloadEventHandler, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        Intent intent;
        int id = downloadInfo.getId();
        if (DownloadUtils.optimizeMultiProcess()) {
            intent = new Intent(context, (Class<?>) MultiProcessDownloadTaskDeleteActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        }
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
        DownloadNotificationManager.getInstance().hideNotification(id);
        downloadInfo.updateDownloadTime();
        if (iAppDownloadEventHandler != null) {
            iAppDownloadEventHandler.handleDownloadEvent(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (iDownloadNotificationEventListener != null) {
            iDownloadNotificationEventListener.onNotificationEvent(7, downloadInfo, "", "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void openDownload(Context context, int i, boolean z, String str) {
        boolean z2;
        INotificationClickCallback notificationClickCallback;
        DownloadInfo downloadInfo;
        if (z && (notificationClickCallback = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getNotificationClickCallback(i)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (downloadInfo != null) {
                z2 = notificationClickCallback.onClickWhenSuccess(downloadInfo);
                if (!z2) {
                    if (AppInstallStatsReporter.isEnabled(str)) {
                        AppInstallStatsReporter.addStats(i, "DownloadHandlerServiceImpl_openDownload1", "Run");
                        return;
                    }
                    return;
                } else {
                    if (AppInstallStatsReporter.isEnabled(str)) {
                        AppInstallStatsReporter.addStats(i, "DownloadHandlerServiceImpl_openDownload2", "Run");
                    }
                    if (AppDownloadUtils.startViewIntent(context, i, true) == 0) {
                        Toast.makeText(context, "Open Fail!", 0).show();
                        return;
                    }
                    return;
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
    }

    public static void handleActionClickWithoutType(Context context, DownloadInfo downloadInfo, IAppDownloadEventHandler iAppDownloadEventHandler, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        AbsNotificationItem notificationItem;
        int id = downloadInfo.getId();
        INotificationClickCallback notificationClickCallback = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getNotificationClickCallback(id);
        boolean z = false;
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && notificationClickCallback != null && AppDownloadUtils.isApkInstalled(context, downloadInfo, false) && notificationClickCallback.onClickWhenInstalled(downloadInfo)) {
            if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                AppInstallStatsReporter.addStats(id, "DownloadHandlerServiceImpl_handleActionClickWithoutType", "Run");
                return;
            }
            return;
        }
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (DownloadSetting.obtain(id).optInt("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                return;
            case -3:
                openDownload(DownloadComponentManager.getAppContext(), id, true, downloadInfo.getMonitorScene());
                handleClickNotificationInstall(context, iAppDownloadEventHandler, downloadInfo);
                if (DownloadSetting.obtain(id).optInt(DownloadSettingKeys.NOTIFICATION_CLICK_INSTALL_AUTO_CANCEL, 1) != 0 || (notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(id)) == null) {
                    z = true;
                } else {
                    notificationItem.recordClickInstall();
                    notificationItem.refreshStatus(-3, null, false, true);
                }
                if (z) {
                    DownloadNotificationManager.getInstance().hideNotification(id);
                    return;
                }
                return;
            case -2:
                if (((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).canResume(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    AppDownloadUtils.createDownloadTask(downloadInfo, true, false);
                }
                if (iAppDownloadEventHandler != null) {
                    iAppDownloadEventHandler.handleDownloadEvent(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(6, downloadInfo, "", "");
                    return;
                }
                return;
            case 0:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                downloadInfo.setPauseByNotification(true);
                Downloader.getInstance(context).pause(id);
                cancelReserveWifi(context, downloadInfo);
                if (iAppDownloadEventHandler != null) {
                    iAppDownloadEventHandler.handleDownloadEvent(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(5, downloadInfo, "", "");
                    return;
                }
                return;
        }
    }
}
