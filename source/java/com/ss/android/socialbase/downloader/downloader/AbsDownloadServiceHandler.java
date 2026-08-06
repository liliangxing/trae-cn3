package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsDownloadServiceHandler implements IDownloadServiceHandler {
    private static final String TAG = "AbsDownloadServiceHandler";
    private WeakReference<Service> downloadService;
    protected final SparseArray<List<DownloadTask>> pendingTasks = new SparseArray<>();
    protected volatile boolean isServiceAlive = false;
    protected AtomicBoolean isInvokeStartService = new AtomicBoolean(false);
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable debounceStartServiceRunnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.2
        @Override // java.lang.Runnable
        public void run() {
            if (Logger.debug()) {
                Logger.globalDebug(AbsDownloadServiceHandler.TAG, "debounceStartServiceRunnable_run", "Try startService");
            }
            if (AbsDownloadServiceHandler.this.isServiceAlive) {
                return;
            }
            if (Logger.debug()) {
                Logger.globalDebug(AbsDownloadServiceHandler.TAG, "debounceStartServiceRunnable_run", "Try startService Error");
            }
            AbsDownloadServiceHandler.this.startService(DownloadComponentManager.getAppContext(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(IDownloadServiceConnectionListener iDownloadServiceConnectionListener) {
    }

    protected void startFakeService() {
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setDownloadService(WeakReference weakReference) {
        this.downloadService = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public boolean isServiceAlive() {
        return this.isServiceAlive;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder onBind(Intent intent) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onBind", "OnBind Abs");
        }
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onDestroy() {
        this.isServiceAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void pendDownloadTask(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        synchronized (this.pendingTasks) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "pendDownloadTask", "PendingTasks.size:" + this.pendingTasks.size());
            }
            List<DownloadTask> list = this.pendingTasks.get(downloadId);
            if (list == null) {
                list = new ArrayList<>();
                this.pendingTasks.put(downloadId, list);
            }
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "pendDownloadTask", "Before taskArray.size:" + list.size());
            }
            list.add(downloadTask);
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "pendDownloadTask", "After pendingTasks.size:" + this.pendingTasks.size());
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        ((IDownloadGlobalThrottleService) DownloadServiceManager.getService(IDownloadGlobalThrottleService.class)).start(downloadTask);
        if (DownloadUtils.optimizeMultiProcess()) {
            startFakeService();
        }
        if (!this.isServiceAlive) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "tryDownload", "Service is not alive");
            }
            if (this.isInvokeStartService.compareAndSet(false, true)) {
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, "tryDownload", "Do StartService");
                }
                if (downloadTask.getDownloadInfo().isNeedCurrentProcess()) {
                    startFakeService();
                    if (Logger.debugScene(downloadInfo)) {
                        Logger.taskDebug(TAG, downloadInfo, "tryDownload", "NeedCurrentProcess");
                    }
                } else {
                    DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbsDownloadServiceHandler.this.startService(DownloadComponentManager.getAppContext(), null);
                        }
                    });
                }
            } else {
                this.handler.removeCallbacks(this.debounceStartServiceRunnable);
                this.handler.postDelayed(this.debounceStartServiceRunnable, 10L);
            }
        }
        if (this.pendingTasks.get(downloadTask.getDownloadId()) != null) {
            synchronized (this.pendingTasks) {
                if (this.pendingTasks.get(downloadTask.getDownloadId()) != null) {
                    this.pendingTasks.remove(downloadTask.getDownloadId());
                }
            }
        }
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.tryDownload(downloadTask);
        }
        resumePendingTask();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resumePendingTask() {
        SparseArray<List<DownloadTask>> clone;
        synchronized (this.pendingTasks) {
            clone = this.pendingTasks.clone();
            this.pendingTasks.clear();
        }
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        if (Logger.debugScene(downloadTask.getDownloadInfo())) {
                            Logger.taskDebug(TAG, downloadTask.getDownloadInfo(), "resumePendingTask", "Resume Task");
                        }
                        downloadEngine.tryDownload(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int i) {
        Logger.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.isServiceAlive) {
            return;
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "startService", "Run StartService");
        }
        startService(DownloadComponentManager.getAppContext(), null);
    }
}
