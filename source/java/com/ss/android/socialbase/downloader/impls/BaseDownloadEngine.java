package com.ss.android.socialbase.downloader.impls;

import android.util.Log;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class BaseDownloadEngine extends AbsDownloadEngine {
    private static final String TAG = "BaseDownloadEngine";

    protected abstract void addDownloadListenerImpl(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2);

    protected abstract void cancelImpl(int i, boolean z);

    protected abstract void pauseImpl(int i);

    protected abstract void refreshDownloadTaskMapImpl(int i, int i2, int i3);

    protected abstract void restartAllFailedDownloadTasksImpl(List<String> list);

    protected abstract void restartAllPauseReserveOnWifiDownloadTasksImpl(List<String> list);

    protected abstract void restartAsyncWaitingTaskImpl(int i);

    protected abstract void restartImpl(int i);

    protected abstract void resumeImpl(int i);

    protected abstract void setThrottleNetSpeedImpl(int i, long j, int i2);

    protected abstract void tryDownloadImpl(DownloadTask downloadTask);

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void tryDownload(final DownloadTask downloadTask) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.1
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.tryDownloadImpl(downloadTask);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean pause(final int i) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.2
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.pauseImpl(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean cancel(final int i, final boolean z) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.3
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.cancelImpl(i, z);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean resume(final int i) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "resume", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.4
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.resumeImpl(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean restart(final int i) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, i, "restart", "Trace:" + Log.getStackTraceString(new Throwable()));
        }
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.5
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.restartImpl(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public boolean restartAsyncWaitingTask(final int i) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.6
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.restartAsyncWaitingTaskImpl(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void restartAllFailedDownloadTasks(final List<String> list) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.7
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.restartAllFailedDownloadTasksImpl(list);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void restartAllPauseReserveOnWifiDownloadTasks(final List<String> list) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.8
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.restartAllPauseReserveOnWifiDownloadTasksImpl(list);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void refreshDownloadTaskMap(final int i, final int i2, final int i3) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.9
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.refreshDownloadTaskMapImpl(i, i2, i3);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void setThrottleNetSpeed(final int i, final long j, final int i2) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.10
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.setThrottleNetSpeedImpl(i, j, i2);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.impls.IDownloadEngine
    public void addDownloadListener(final int i, final int i2, final IDownloadListener iDownloadListener, final ListenerType listenerType, final boolean z, final boolean z2) {
        runInSingleThread(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine.11
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloadEngine.this.addDownloadListenerImpl(i, i2, iDownloadListener, listenerType, z, z2);
            }
        });
    }

    private void runInSingleThread(Runnable runnable) {
        if (DownloadComponentManager.SINGLE_THREAD_NAME.equals(Thread.currentThread().getName())) {
            runnable.run();
        } else {
            DownloadComponentManager.submitSingleTask(runnable);
        }
    }
}
