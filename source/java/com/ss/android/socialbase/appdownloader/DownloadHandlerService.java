package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadHandlerService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int intExtra;
        super.onStartCommand(intent, i, i2);
        if (DownloadUtils.optimizeMultiProcess() && intent != null && (intExtra = intent.getIntExtra(Constants.EXTRA_NOTIFICATION_PID, -1)) != -1 && intExtra != DownloadUtils.getPid()) {
            Intent intent2 = new Intent();
            intent2.setAction(intent.getAction());
            intent2.putExtras(intent.getExtras());
            sendBroadcast(intent2);
            stopSelf();
            return 2;
        }
        ((IDownloadHandlerService) AppDownloadServiceManager.getService(IDownloadHandlerService.class)).onStartCommand(this, intent);
        stopSelf();
        return 2;
    }

    public static void handleActionClickWithoutType(Context context, DownloadInfo downloadInfo, IAppDownloadEventHandler iAppDownloadEventHandler, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        ((IDownloadHandlerService) AppDownloadServiceManager.getService(IDownloadHandlerService.class)).handleActionClickWithoutType(context, downloadInfo, iAppDownloadEventHandler, iDownloadNotificationEventListener);
    }
}
