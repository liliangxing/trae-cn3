package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DefaultDownloadServiceHandler extends AbsDownloadServiceHandler {
    private static final String TAG = "DefaultDownloadServiceHandler";

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
            startFakeService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startFakeService() {
        onStartCommandOnMainThread();
        ExecutorService cPUThreadExecutor = DownloadComponentManager.getCPUThreadExecutor();
        if (cPUThreadExecutor != null) {
            cPUThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultDownloadServiceHandler.this.onStartCommand(null, 0, 0);
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) DownloadService.class));
        this.isServiceAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
        this.isServiceAlive = true;
        this.isInvokeStartService.set(false);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onStartCommandOnMainThread", "Run");
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent intent, int i, int i2) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onStartCommand", "Run");
        }
        resumePendingTask();
    }
}
