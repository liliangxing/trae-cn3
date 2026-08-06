package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SqlDownloadCacheService extends Service {
    private static final String TAG = "SqlDownloadCacheService";

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public static void startServiceAndBind(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Logger.globalError(TAG, "startServiceAndBind", "Exception:" + th.toString());
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ISqlDownloadCache iSqlDownloadCache;
        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
        if (downloadCache instanceof DefaultDownloadCache) {
            iSqlDownloadCache = ((DefaultDownloadCache) downloadCache).getSqlDownloadCache();
        } else {
            iSqlDownloadCache = downloadCache instanceof ISqlDownloadCache ? (ISqlDownloadCache) downloadCache : null;
        }
        if (iSqlDownloadCache instanceof IBinder) {
            return (IBinder) iSqlDownloadCache;
        }
        return new Binder();
    }
}
