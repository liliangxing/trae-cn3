package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationServiceImpl;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String TAG = "DownloadReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onReceive", "Action:" + action);
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            autoRefreshUnsuccessDownloadTask(context, action);
            return;
        }
        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            forceStopAllDownloadTask(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadDirUtils.forceLoadStoragePathCache(context);
                }
            });
        }
    }

    private void autoRefreshUnsuccessDownloadTask(final Context context, final String str) {
        if (DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            long optLong = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.DELAY_REFRESH_UNSUCCESS_TASK_MS, 2000L);
            DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) > 0) {
                            DownloadNotificationServiceImpl.getInstance().handleIntent(intent);
                        } else {
                            context.startService(intent);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, optLong > 0 ? optLong : 2000L, TimeUnit.MILLISECONDS);
        }
    }

    private void forceStopAllDownloadTask(final Context context, final String str) {
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadDirUtils.forceLoadStoragePathCache(context);
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) > 0) {
                        DownloadNotificationServiceImpl.getInstance().handleIntent(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
