package com.ss.android.socialbase.appdownloader.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppResourceUtils;
import com.ss.android.socialbase.appdownloader.ResourceUtils;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppNotificationItem extends AbsNotificationItem {
    private static final long HOUR_IN_MILLIS = 3600000;
    private static final long MINUTE_IN_MILLIS = 60000;
    private static final String NOTIFICATION_GROUP = "com.ss.android.socialbase.APP_DOWNLOADER";
    private static final long SECOND_IN_MILLIS = 1000;
    private String extra;
    private final Context mContext;
    private IMockNotificationProgressHandler mockNotificationProgressHandler;
    private final Resources res;
    private String targetFileName;
    private String targetSavePath;

    public AppNotificationItem(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.targetSavePath = str2;
        this.targetFileName = str3;
        this.extra = str4;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.res = applicationContext.getResources();
        this.mockNotificationProgressHandler = AppDownloader.getInstance().getMockNotificationProgressHandler();
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotificationItem(DownloadInfo downloadInfo) {
        super.updateNotificationItem(downloadInfo);
        this.targetSavePath = downloadInfo.getSavePath();
        this.targetFileName = downloadInfo.getName();
        this.extra = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotification(BaseException baseException, boolean z) {
        if (this.mContext == null) {
            return;
        }
        try {
            this.notification = createNotification(baseException, z);
            notify(this.notification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Notification createNotification(BaseException baseException, boolean z) {
        boolean z2;
        NotificationCompat.Builder builder;
        int stringId;
        String string;
        String string2;
        String str;
        String str2;
        BaseException baseException2;
        String str3;
        String string3;
        int stringId2;
        int stringId3;
        String str4;
        int i;
        int i2;
        int status = getStatus();
        int notificationType = AppDownloadUtils.getNotificationType(status);
        if (notificationType == 0) {
            return null;
        }
        NotificationCompat.Builder notificationBuilder = getNotificationBuilder();
        notificationBuilder.setWhen(getFirstShowTime());
        int id = getId();
        DownloadSetting obtain = DownloadSetting.obtain(id);
        if (obtain.optInt(DownloadSettingKeys.KEY_SET_NOTIFICATION_GROUP, 0) == 1) {
            notificationBuilder.setGroup(NOTIFICATION_GROUP);
            notificationBuilder.setGroupSummary(false);
        }
        int appSmallIconDrawable = AppResourceUtils.getAppSmallIconDrawable();
        if (appSmallIconDrawable != 0) {
            notificationBuilder.setSmallIcon(appSmallIconDrawable);
            z2 = false;
        } else {
            z2 = true;
        }
        notificationBuilder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        int smallIcon = getSmallIcon(notificationType, id);
        if (z2 && smallIcon != 0) {
            notificationBuilder.setSmallIcon(smallIcon);
        }
        String str5 = Constants.ACTION_CLICK_CONTENT;
        if (notificationType == 1 || notificationType == 4 || notificationType == 2) {
            notificationBuilder.setContentIntent(getCommonHandleIntent(Constants.ACTION_CLICK_CONTENT, notificationType, id));
            notificationBuilder.setAutoCancel(false);
        } else if (notificationType == 3) {
            notificationBuilder.setAutoCancel(true);
            if (status != -1 && status != -4) {
                if (status == -3 && obtain.optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.NOTIFICATION_CLICK_INSTALL_AUTO_CANCEL, 1) == 0) {
                    notificationBuilder.setAutoCancel(false);
                }
                str5 = Constants.ACTION_OPEN;
            }
            notificationBuilder.setContentIntent(getCommonHandleIntent(str5, notificationType, id));
            notificationBuilder.setDeleteIntent(getCommonHandleIntent(Constants.ACTION_HIDE, notificationType, id));
        }
        long curBytes = getCurBytes();
        long totalBytes = getTotalBytes();
        IMockNotificationProgressHandler iMockNotificationProgressHandler = this.mockNotificationProgressHandler;
        if (iMockNotificationProgressHandler != null) {
            curBytes = iMockNotificationProgressHandler.onNotificationUpdate(id, curBytes, totalBytes);
        }
        long j = curBytes;
        int i3 = totalBytes > 0 ? (int) ((100 * j) / totalBytes) : 0;
        String title = getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.res.getString(ResourceUtils.getStringId("tt_appdownloader_download_unknown_title"));
        }
        RemoteViews createRemoteViews = createRemoteViews();
        int downloadActionId = AppResourceUtils.getDownloadActionId();
        if (DownloadSetting.obtain(id).optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.NOTIFICATION_OPT_2) != 1) {
            createRemoteViews.setOnClickPendingIntent(downloadActionId, getCommonHandleIntent(Constants.ACTION_CLICK_BTN, notificationType, id, status));
        }
        if (DownloadSetting.obtain(id).optInt("enable_notification_ui") >= 1) {
            createRemoteViews.setInt(downloadActionId, "setBackgroundResource", AppResourceUtils.getNewNotificationActionDrawable());
            createRemoteViews.setTextColor(downloadActionId, -1);
        }
        createRemoteViews.setTextViewText(AppResourceUtils.getDownloadDescId(), title);
        int downloadProgressId = getDownloadProgressId(id);
        createRemoteViews.setViewVisibility(downloadProgressId, 0);
        createRemoteViews.setProgressBar(downloadProgressId, 100, i3, z);
        int downloadIconId = AppResourceUtils.getDownloadIconId();
        if (smallIcon != 0) {
            createRemoteViews.setImageViewResource(downloadIconId, smallIcon);
        }
        if (DownloadSetting.obtain(id).optInt("enable_notification_ui") >= 1) {
            Bitmap appIconByInfoId = NotificationIconCache.inst().getAppIconByInfoId(id);
            if (appIconByInfoId != null) {
                createRemoteViews.setInt(downloadIconId, "setBackgroundColor", 0);
                createRemoteViews.setImageViewBitmap(downloadIconId, appIconByInfoId);
            } else {
                createRemoteViews.setInt(downloadIconId, "setBackgroundResource", AppResourceUtils.getNewNotificationActionDrawable());
            }
        }
        if (notificationType == 1 || notificationType == 4) {
            builder = notificationBuilder;
            String str6 = AppDownloadUtils.bytesToHuman(j) + "/" + AppDownloadUtils.bytesToHuman(totalBytes);
            if (notificationType == 1) {
                if (getStatus() == 11) {
                    stringId = ResourceUtils.getStringId("tt_appdownloader_notification_waiting_download_complete_handler");
                } else {
                    stringId = ResourceUtils.getStringId("tt_appdownloader_notification_downloading");
                }
            } else {
                stringId = ResourceUtils.getStringId("tt_appdownloader_notification_prepare");
            }
            string = this.mContext.getResources().getString(stringId);
            string2 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_pause"));
            createRemoteViews.setViewVisibility(getDownloadProgressId(id), 0);
            createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSucceedId(), 8);
            createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadTextId(), 0);
            int downloadActionId2 = AppResourceUtils.getDownloadActionId();
            if (AppDownloadUtils.isBindApp(this.extra)) {
                createRemoteViews.setViewVisibility(downloadActionId2, 8);
            } else {
                createRemoteViews.setViewVisibility(downloadActionId2, 0);
            }
            if (obtain.optInt("enable_notification_ui") >= 2) {
                createRemoteViews.setViewVisibility(downloadActionId2, 8);
            }
            str = str6;
        } else if (notificationType == 2) {
            str = AppDownloadUtils.bytesToHuman(j) + "/" + AppDownloadUtils.bytesToHuman(totalBytes);
            string = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_pausing"));
            string2 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_resume"));
            if (obtain.optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.NOTIFICATION_OPT_2) == 1) {
                if (i3 >= obtain.optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.NOTI_PROGRESS_SHOW_TH, 70)) {
                    createRemoteViews.setViewVisibility(getDownloadProgressId(id), 0);
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadTextId(), 0);
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSucceedId(), 8);
                    i2 = 8;
                } else {
                    createRemoteViews.setViewVisibility(getDownloadProgressId(id), 8);
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadTextId(), 8);
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSucceedId(), 0);
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSuccessSizeId(), 8);
                    string = this.res.getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_continue"));
                    i2 = 8;
                }
            } else {
                createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadTextId(), 0);
                int downloadProgressId2 = getDownloadProgressId(id);
                if (obtain.optInt("enable_notification_ui") >= 2) {
                    createRemoteViews.setViewVisibility(downloadProgressId2, 0);
                    i2 = 8;
                } else {
                    i2 = 8;
                    createRemoteViews.setViewVisibility(downloadProgressId2, 8);
                }
                createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSucceedId(), i2);
            }
            int downloadActionId3 = AppResourceUtils.getDownloadActionId();
            if (AppDownloadUtils.isBindApp(this.extra)) {
                createRemoteViews.setViewVisibility(downloadActionId3, i2);
            } else {
                createRemoteViews.setViewVisibility(downloadActionId3, 0);
                if (obtain.optInt("enable_notification_ui") >= 2) {
                    str = AppDownloadUtils.bytesToHuman(j, false) + "/" + AppDownloadUtils.bytesToHuman(totalBytes, false);
                }
            }
            builder = notificationBuilder;
        } else {
            String str7 = "";
            if (notificationType == 3) {
                DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(id);
                if (getStatus() == -1 || getStatus() == -4) {
                    if (obtain.optInt("enable_notification_ui") >= 2 && getStatus() == -1 && (DownloadUtils.isNetworkError(baseException) || DownloadUtils.isInsufficientSpaceError(baseException))) {
                        str2 = AppDownloadUtils.bytesToHuman(j) + "/" + AppDownloadUtils.bytesToHuman(totalBytes);
                        createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSuccessSizeId(), 8);
                        baseException2 = baseException;
                        if (baseException2 == null) {
                            str3 = str2;
                            if (baseException.getErrorCode() == 1006) {
                                string3 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_space_failed"));
                                String str8 = string3;
                                String string4 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_restart"));
                                createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadActionId(), 8);
                                if (obtain.optInt("enable_notification_ui") >= 2 && getStatus() == -1) {
                                    if (!DownloadUtils.isNetworkError(baseException)) {
                                        if (DownloadUtils.isWaitWifiAndInNet(baseException2, downloadInfo)) {
                                            str7 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_no_wifi_and_in_net"));
                                            string4 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_resume"));
                                        } else {
                                            str7 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_no_internet_error"));
                                        }
                                        builder = notificationBuilder;
                                    } else if (DownloadUtils.isInsufficientSpaceError(baseException)) {
                                        builder = notificationBuilder;
                                        str7 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_insufficient_space_error"), AppDownloadUtils.bytesToHumanOnSpaceError(totalBytes - j));
                                    }
                                    string2 = string4;
                                }
                                builder = notificationBuilder;
                                str7 = str8;
                                string2 = string4;
                            }
                        } else {
                            str3 = str2;
                        }
                        if (!needShowWaitNetText(baseException2, obtain, downloadInfo)) {
                            if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                                stringId2 = ResourceUtils.getStringId("tt_appdownloader_notification_download_waiting_wifi");
                            } else {
                                stringId2 = ResourceUtils.getStringId("tt_appdownloader_notification_download_waiting_net");
                            }
                            string3 = this.mContext.getResources().getString(stringId2);
                        } else {
                            string3 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_failed"));
                        }
                        String str82 = string3;
                        String string42 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_restart"));
                        createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadActionId(), 8);
                        if (obtain.optInt("enable_notification_ui") >= 2) {
                            if (!DownloadUtils.isNetworkError(baseException)) {
                            }
                            string2 = string42;
                        }
                        builder = notificationBuilder;
                        str7 = str82;
                        string2 = string42;
                    }
                    str2 = "";
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSuccessSizeId(), 8);
                    baseException2 = baseException;
                    if (baseException2 == null) {
                    }
                    if (!needShowWaitNetText(baseException2, obtain, downloadInfo)) {
                    }
                    String str822 = string3;
                    String string422 = this.mContext.getResources().getString(ResourceUtils.getStringId("tt_appdownloader_notification_download_restart"));
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadActionId(), 8);
                    if (obtain.optInt("enable_notification_ui") >= 2) {
                    }
                    builder = notificationBuilder;
                    str7 = str822;
                    string2 = string422;
                } else if (getStatus() == -3) {
                    String bytesToHuman = AppDownloadUtils.bytesToHuman(totalBytes);
                    if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                        if (AppDownloadUtils.isApkInstalled(this.mContext, downloadInfo, false)) {
                            stringId3 = ResourceUtils.getStringId("tt_appdownloader_notification_install_finished_open");
                            i = ResourceUtils.getStringId("tt_appdownloader_notification_download_open");
                        } else {
                            stringId3 = ResourceUtils.getStringId("tt_appdownloader_notification_download_complete_with_install");
                            i = ResourceUtils.getStringId("tt_appdownloader_notification_download_install");
                        }
                        str4 = "";
                    } else {
                        stringId3 = ResourceUtils.getStringId("tt_appdownloader_notification_download_complete_without_install");
                        if (((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getNotificationClickCallback(id) != null) {
                            stringId3 = ResourceUtils.getStringId("tt_appdownloader_notification_download_complete_open");
                        }
                        str4 = "";
                        i = 0;
                    }
                    String string5 = this.res.getString(stringId3);
                    notificationBuilder.setContentText(string5);
                    String string6 = i != 0 ? this.res.getString(i) : str4;
                    if (obtain.optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.NOTIFICATION_OPT_2) == 1) {
                        createRemoteViews.setTextViewText(AppResourceUtils.getDownloadActionId(), string6);
                        createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSuccessSizeId(), 8);
                    } else {
                        createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadActionId(), 8);
                    }
                    baseException2 = baseException;
                    builder = notificationBuilder;
                    string2 = string6;
                    str7 = string5;
                    str3 = bytesToHuman;
                } else {
                    baseException2 = baseException;
                    builder = notificationBuilder;
                    string2 = "";
                    str3 = string2;
                }
                createRemoteViews.setViewVisibility(getDownloadProgressId(id), 8);
                createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSucceedId(), 0);
                createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadTextId(), 8);
                if (obtain.optInt("enable_notification_ui") >= 2 && getStatus() == -1 && (DownloadUtils.isNetworkError(baseException) || DownloadUtils.isInsufficientSpaceError(baseException))) {
                    createRemoteViews.setViewVisibility(getDownloadProgressId(id), 0);
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadSucceedId(), 8);
                    createRemoteViews.setViewVisibility(AppResourceUtils.getDownloadTextId(), 0);
                    int downloadActionId4 = AppResourceUtils.getDownloadActionId();
                    if (DownloadUtils.isWaitWifiAndInNet(baseException2, downloadInfo)) {
                        createRemoteViews.setViewVisibility(downloadActionId4, 0);
                        str = AppDownloadUtils.bytesToHuman(j, false) + "/" + AppDownloadUtils.bytesToHuman(totalBytes, false);
                        string = str7;
                    } else {
                        createRemoteViews.setViewVisibility(downloadActionId4, 8);
                    }
                }
                string = str7;
                str = str3;
            } else {
                builder = notificationBuilder;
                str = "";
                string2 = str;
                string = string2;
            }
        }
        createRemoteViews.setTextViewText(AppResourceUtils.getDownloadSizeId(), str);
        createRemoteViews.setTextViewText(AppResourceUtils.getDownloadStatusId(), string);
        createRemoteViews.setTextViewText(AppResourceUtils.getDownloadSuccessSizeId(), str);
        createRemoteViews.setTextViewText(AppResourceUtils.getDownloadSuccessStatusId(), string);
        int downloadActionId5 = AppResourceUtils.getDownloadActionId();
        if (TextUtils.isEmpty(string2)) {
            createRemoteViews.setViewVisibility(downloadActionId5, 8);
        } else {
            createRemoteViews.setTextViewText(downloadActionId5, string2);
        }
        Notification build = builder.build();
        build.contentView = createRemoteViews;
        return build;
    }

    private boolean needShowWaitNetText(BaseException baseException, DownloadSetting downloadSetting, DownloadInfo downloadInfo) {
        if (baseException != null) {
            return (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && downloadSetting.optInt(DownloadSettingKeys.NOTIFICATION_TEXT_OPT, 0) == 1;
        }
        return false;
    }

    private RemoteViews createRemoteViews() {
        RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), AppResourceUtils.getNotificationLayout());
        try {
            if (AppDownloadUtils.isMaterialNotification(this.mContext)) {
                remoteViews.setInt(AppResourceUtils.getNotificationRootId(), "setBackgroundColor", this.mContext.getResources().getColor(AppResourceUtils.getNotificationColorId()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    private int getSmallIcon(int i, int i2) {
        if (DownloadSetting.obtain(i2).optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.NOTIFICATION_OPT_2) == 1) {
            return AppResourceUtils.getAndroidCompleteDrawable();
        }
        if (i == 1 || i == 4) {
            return AppResourceUtils.getAndroidDownloadDrawable();
        }
        if (i == 2) {
            return AppResourceUtils.getAndroidWarningDrawable();
        }
        if (i == 3) {
            return AppResourceUtils.getAndroidCompleteDrawable();
        }
        return 0;
    }

    private PendingIntent getCommonHandleIntent(String str, int i, int i2) {
        return getCommonHandleIntentImpl(AppDownloader.createHandlerIntent(this.mContext, i2), str, i, i2);
    }

    private PendingIntent getCommonHandleIntent(String str, int i, int i2, int i3) {
        Pair<Intent, Boolean> createHandlerIntent;
        if (DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.TARGET_34_OPT_NOTIFICATION, 1) > 0 && Constants.ACTION_CLICK_BTN.equals(str) && i3 != -3) {
            createHandlerIntent = AppDownloader.createHandlerIntent(this.mContext, i2, true);
        } else {
            createHandlerIntent = AppDownloader.createHandlerIntent(this.mContext, i2);
        }
        return getCommonHandleIntentImpl(createHandlerIntent, str, i, i2);
    }

    private PendingIntent getCommonHandleIntentImpl(Pair<Intent, Boolean> pair, String str, int i, int i2) {
        Intent intent = (Intent) pair.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra(Constants.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_TYPE, i);
        intent.putExtra(Constants.EXTRA_FROM_NOTIFICATION, true);
        return AppDownloader.getHandlerPendingIntent(this.mContext, pair, i2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:17:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    private androidx.core.app.NotificationCompat.Builder getNotificationBuilder() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.AppDownloader r0 = com.ss.android.socialbase.appdownloader.AppDownloader.getInstance()
            java.lang.String r0 = r0.getNotificationChannelId()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.mContext
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.mContext
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.AppDownloadUtils.getNotificationChannelId(r0)
        L22:
            com.ss.android.socialbase.appdownloader.AppDownloader r1 = com.ss.android.socialbase.appdownloader.AppDownloader.getInstance()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.depend.IDownloadNotificationBuilder r1 = r1.getAppDownloadNotificationBuilder()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.AppDownloader r1 = com.ss.android.socialbase.appdownloader.AppDownloader.getInstance()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.depend.IDownloadNotificationBuilder r1 = r1.getAppDownloadNotificationBuilder()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.mContext     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.createNotification(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.mContext     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.mContext
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.notification.AppNotificationItem.getNotificationBuilder():androidx.core.app.NotificationCompat$Builder");
    }

    private CharSequence formatDuration(Resources resources, long j) {
        if (j >= 3600000) {
            return resources.getString(ResourceUtils.getStringId(this.mContext, "tt_appdownloader_duration_hours"), Integer.valueOf((int) ((j + 1800000) / 3600000)));
        }
        if (j < MINUTE_IN_MILLIS) {
            return resources.getString(ResourceUtils.getStringId(this.mContext, "tt_appdownloader_duration_seconds"), Integer.valueOf((int) ((j + 500) / 1000)));
        }
        return resources.getString(ResourceUtils.getStringId(this.mContext, "tt_appdownloader_duration_minutes"), Integer.valueOf((int) ((j + 30000) / MINUTE_IN_MILLIS)));
    }

    private int getDownloadProgressId(int i) {
        if (DownloadSetting.obtain(i).optInt("enable_notification_ui") >= 1) {
            return AppResourceUtils.getNewDownloadProgressId();
        }
        return AppResourceUtils.getDownloadProgressId();
    }
}
