package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.thread.DownloadThreadPool;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DefaultDownloadEngine extends AbsDownloadEngine {
    private static final String TAG = "DefaultDownloadEngine";
    private static DownloadThreadPool downloadThreadPool;

    public DefaultDownloadEngine() {
        downloadThreadPool = new DownloadThreadPool();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean isDownloading(int i) {
        DownloadInfo downloadInfo;
        return downloadThreadPool.containsTask(i) && (downloadInfo = getDownloadInfo(i)) != null && DownloadStatus.isDownloading(downloadInfo.getStatus());
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void removeDownloadRunnable(DownloadRunnable downloadRunnable) {
        downloadThreadPool.removeUnAliveDownloadRunnable(downloadRunnable);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public Future doDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        if (Logger.debugScene(downloadTask.getDownloadInfo())) {
            Logger.taskDebug(TAG, downloadTask.getDownloadInfo(), "doDownload", "start doDownload for task");
        }
        downloadTask.getTimingInfo().doDownloadTime = System.currentTimeMillis();
        return downloadThreadPool.execute(new DownloadRunnable(downloadTask, this.mainHandler));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void doPause(int i, boolean z) {
        downloadThreadPool.pause(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    protected DownloadRunnable doCancel(int i) {
        return downloadThreadPool.cancel(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public List<Integer> getAllAliveDownloadIds() {
        return downloadThreadPool.getAllAliveDownloadIds();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doSetThrottleNetSpeed(int i, long j, int i2) {
        downloadThreadPool.setThrottleNetSpeed(i, j, i2);
    }
}
