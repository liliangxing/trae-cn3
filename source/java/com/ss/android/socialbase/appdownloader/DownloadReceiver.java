package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService;
import com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String TAG = "AppDownloadReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
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
        if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            autoRefreshUnsuccessDownloadTask(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    ((IDownloadAppInstallService) AppDownloadServiceManager.getService(IDownloadAppInstallService.class)).handleApkInstalled(data.getSchemeSpecificPart());
                }
            });
        }
    }

    private void autoRefreshUnsuccessDownloadTask(final Context context, final String str) {
        if (DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            long optLong = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.DELAY_REFRESH_UNSUCCESS_TASK_MS, 2000L);
            DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                        intent.setAction(str);
                        if (DownloadUtils.optimizeMultiProcess()) {
                            ((IDownloadHandlerService) AppDownloadServiceManager.getService(IDownloadHandlerService.class)).onStartCommand(context, intent);
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
}
