package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadNotificationManagerImpl {
    private static final String TAG = "DownloadNotificationManagerImpl";
    private static volatile DownloadNotificationManagerImpl instance;
    private final long PROGRESS_NOTIFY_DURATION = 1000;
    private final SparseArray<Long> PROGRESS_NOTIFY_LAST_TIME_INFO = new SparseArray<>();
    private final SparseArray<AbsNotificationItem> notificationItemArray = new SparseArray<>();

    static boolean isCompleteVisibility(int i) {
        return i == 1 || i == 3;
    }

    private DownloadNotificationManagerImpl() {
    }

    public static DownloadNotificationManagerImpl getInstance() {
        if (instance == null) {
            synchronized (DownloadNotificationManagerImpl.class) {
                if (instance == null) {
                    instance = new DownloadNotificationManagerImpl();
                }
            }
        }
        return instance;
    }

    public void hideNotification(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        updateNotificationState(downloadInfo);
        cancelCompleteNotification(downloadInfo);
    }

    void updateNotificationState(DownloadInfo downloadInfo) {
        if (downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            Downloader.getInstance(DownloadComponentManager.getAppContext()).updateDownloadInfo(downloadInfo);
        }
    }

    void cancelCompleteNotification(DownloadInfo downloadInfo) {
        if (isCompleteAndVisible(downloadInfo)) {
            cancelNotification(downloadInfo.getId());
        }
    }

    static boolean isCompleteAndVisible(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && isCompleteVisibility(downloadInfo.getNotificationVisibility());
    }

    public void notifyByService(int i, int i2, Notification notification) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.PROGRESS_NOTIFY_LAST_TIME_INFO) {
                Long l = this.PROGRESS_NOTIFY_LAST_TIME_INFO.get(i);
                long currentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.PROGRESS_NOTIFY_LAST_TIME_INFO.put(i, Long.valueOf(currentTimeMillis));
                }
            }
        }
        Intent intent = new Intent(appContext, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction(NotificationConstants.ACTION_NOTIFICATION_NOTIFY);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, i2);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, i);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION, notification);
            if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) > 0) {
                DownloadNotificationServiceImpl.getInstance().handleIntent(intent);
            } else {
                appContext.startService(intent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.taskError(TAG, i, "notifyByService", "Error:" + th);
            if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_BACKGROUND_NOTIFICATION)) {
                DownloadNotificationServiceImpl.getInstance().handleIntent(intent);
            }
        }
    }

    public void cancel(int i) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null || i == 0) {
            return;
        }
        Intent intent = new Intent(appContext, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction(NotificationConstants.ACTION_NOTIFICATION_CANCEL);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, i);
            if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) > 0) {
                DownloadNotificationServiceImpl.getInstance().handleIntent(intent);
            } else {
                appContext.startService(intent);
            }
        } catch (Throwable th) {
            Logger.taskError(TAG, i, "cancel", "Error:" + th);
            th.printStackTrace();
            if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_BACKGROUND_NOTIFICATION)) {
                DownloadNotificationServiceImpl.getInstance().handleIntent(intent);
            }
        }
    }

    public void addNotification(AbsNotificationItem absNotificationItem) {
        if (absNotificationItem == null) {
            return;
        }
        synchronized (this.notificationItemArray) {
            this.notificationItemArray.put(absNotificationItem.getId(), absNotificationItem);
        }
    }

    public AbsNotificationItem removeNotification(int i) {
        AbsNotificationItem absNotificationItem;
        if (i == 0) {
            return null;
        }
        synchronized (this.notificationItemArray) {
            absNotificationItem = this.notificationItemArray.get(i);
            if (absNotificationItem != null) {
                this.notificationItemArray.remove(i);
            }
        }
        return absNotificationItem;
    }

    public AbsNotificationItem getNotificationItem(int i) {
        AbsNotificationItem absNotificationItem;
        if (i == 0) {
            return null;
        }
        synchronized (this.notificationItemArray) {
            absNotificationItem = this.notificationItemArray.get(i);
        }
        return absNotificationItem;
    }

    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        SparseArray<AbsNotificationItem> sparseArray;
        synchronized (this.notificationItemArray) {
            sparseArray = this.notificationItemArray;
        }
        return sparseArray;
    }

    public void cancelNotification(int i) {
        removeNotification(i);
        if (i != 0) {
            DownloadNotificationManager.getInstance().cancel(i);
        }
    }

    public void clearNotification() {
        SparseArray<AbsNotificationItem> clone;
        synchronized (this.notificationItemArray) {
            clone = this.notificationItemArray.clone();
            this.notificationItemArray.clear();
        }
        for (int i = 0; i < clone.size(); i++) {
            clone.get(clone.keyAt(i)).cancel();
        }
    }
}
