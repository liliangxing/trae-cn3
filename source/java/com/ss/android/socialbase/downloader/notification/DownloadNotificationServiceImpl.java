package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.ThreadWithHandler;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadNotificationServiceImpl {
    private static final long NOTIFY_TIME_WINDOW = 1000;
    private static final String TAG = "DownloadNotificationServiceImpl";
    private static volatile DownloadNotificationServiceImpl mInstance;
    private volatile long mLastImportantNotifyTimestamp;
    private volatile long mLastNotifyTimestamp;
    private volatile ThreadWithHandler mNotifyThreadHandler;
    private long mNotifyTimeWindow = 1000;
    private final SparseArray<Notification> mPendingImportantNotify = new SparseArray<>(2);
    private AtomicBoolean mInited = new AtomicBoolean(false);
    private boolean mEnabledFixLeak = isEnableFixNotificationLeak();

    public static DownloadNotificationServiceImpl getInstance() {
        if (mInstance == null) {
            synchronized (DownloadNotificationServiceImpl.class) {
                if (mInstance == null) {
                    mInstance = new DownloadNotificationServiceImpl();
                }
            }
        }
        return mInstance;
    }

    public void init() {
        if (!this.mEnabledFixLeak || this.mInited.compareAndSet(false, true)) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "init", "Create DownloaderNotifyThread");
            }
            this.mNotifyThreadHandler = new ThreadWithHandler("DownloaderNotifyThread");
            this.mNotifyThreadHandler.start();
            long optLong = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.NOTIFICATION_TIME_WINDOW, 1000L);
            this.mNotifyTimeWindow = optLong;
            if (optLong < 0 || optLong > 1200) {
                this.mNotifyTimeWindow = 1000L;
            }
        }
    }

    public void onDestroy() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) <= 0 && this.mNotifyThreadHandler != null) {
            try {
                this.mNotifyThreadHandler.quit();
            } catch (Throwable unused) {
            }
            this.mNotifyThreadHandler = null;
        }
    }

    public void handleIntent(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            Logger.globalError(TAG, "handleIntent", "Intent Error:" + intent);
            return;
        }
        init();
        if (this.mNotifyThreadHandler == null) {
            Logger.globalError(TAG, "handleIntent", "NotifyThreadHandler is null");
        } else {
            this.mNotifyThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadNotificationServiceImpl.this.handleIntentImpl(intent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIntentImpl(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        DownloadInfo downloadInfo;
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            Logger.globalError(TAG, "handleIntentImpl", "Context is null");
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) appContext.getSystemService("notification");
        int intExtra = intent.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, 0);
        if (NotificationConstants.ACTION_NOTIFICATION_NOTIFY.equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra(NotificationConstants.EXTRA_NOTIFICATION);
            int intExtra2 = intent.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 == -2 || intExtra2 == -3) {
                    doImportantNotify(notificationManager, intExtra, notification);
                    return;
                } else {
                    doImportantNotify(notificationManager, intExtra, notification);
                    return;
                }
            }
            if (Downloader.getInstance(DownloadComponentManager.getAppContext()).isDownloading(intExtra) && (downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(intExtra)) != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - this.mLastImportantNotifyTimestamp > this.mNotifyTimeWindow) {
                doNotify(notificationManager, intExtra, notification);
                downloadInfo.setLastNotifyProgressTime();
                return;
            }
            return;
        }
        if (NotificationConstants.ACTION_NOTIFICATION_CANCEL.equals(action)) {
            if (intExtra != 0) {
                doCancel(notificationManager, intExtra);
                return;
            }
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            try {
                if (DownloadHelper.checkPermission(appContext, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(DownloadConstants.MIME_APK)) {
                        arrayList.add(DownloadConstants.MIME_APK);
                    }
                    arrayList.add(DownloadConstants.MIME_PLG);
                    Downloader.getInstance(appContext).restartAllFailedDownloadTasks(arrayList);
                    Downloader.getInstance(appContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                Downloader.getInstance(DownloadComponentManager.getAppContext()).pauseAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void doImportantNotify(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.mPendingImportantNotify) {
            int indexOfKey = this.mPendingImportantNotify.indexOfKey(i);
            if (indexOfKey >= 0 && indexOfKey < this.mPendingImportantNotify.size()) {
                this.mPendingImportantNotify.setValueAt(indexOfKey, notification);
                return;
            }
            long currentTimeMillis = this.mNotifyTimeWindow - (System.currentTimeMillis() - this.mLastNotifyTimestamp);
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis > 20000) {
                currentTimeMillis = 20000;
            }
            long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
            this.mLastImportantNotifyTimestamp = currentTimeMillis2;
            this.mLastNotifyTimestamp = currentTimeMillis2;
            if (currentTimeMillis <= 0) {
                doNotify(notificationManager, i, notification);
            } else if (this.mNotifyThreadHandler != null) {
                synchronized (this.mPendingImportantNotify) {
                    this.mPendingImportantNotify.put(i, notification);
                }
                this.mNotifyThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationServiceImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationServiceImpl.this.performImportantNotify(notificationManager, i);
                    }
                }, currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performImportantNotify(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.mPendingImportantNotify) {
            notification = this.mPendingImportantNotify.get(i);
            this.mPendingImportantNotify.remove(i);
        }
        if (notification != null) {
            doNotify(notificationManager, i, notification);
        }
    }

    private void doNotify(NotificationManager notificationManager, int i, Notification notification) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastNotifyTimestamp < currentTimeMillis) {
                this.mLastNotifyTimestamp = currentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    private void doCancel(NotificationManager notificationManager, int i) {
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused) {
        }
    }

    private boolean isEnableFixNotificationLeak() {
        return DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_NOTIFICATION_LEAK, 1) > 0;
    }
}
