package com.ss.android.socialbase.downloader.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadNotificationService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
        DownloadNotificationServiceImpl.getInstance().init();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DownloadNotificationServiceImpl.getInstance().onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        DownloadNotificationServiceImpl.getInstance().handleIntent(intent);
        return 2;
    }
}
