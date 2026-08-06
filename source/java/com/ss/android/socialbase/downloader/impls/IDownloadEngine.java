package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadEngine {
    void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z);

    void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2);

    boolean cancel(int i, boolean z);

    void clearDownloadData(int i, boolean z, boolean z2);

    Future doDownload(DownloadTask downloadTask);

    void doPause(int i, boolean z);

    IDownloadFileUriProvider getDownloadFileUriProvider(int i);

    DownloadInfo getDownloadInfo(int i);

    List<DownloadInfo> getDownloadInfoList(String str);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int i);

    DownloadTask getDownloadTask(int i, int i2);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str);

    INotificationClickCallback getNotificationClickCallback(int i);

    boolean isDownloading(int i);

    boolean isInDownloadTaskPool(int i);

    boolean pause(int i);

    void refreshDownloadTaskMap(int i, int i2, int i3);

    void removeDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z);

    void removeDownloadRunnable(DownloadRunnable downloadRunnable);

    void resetDownloadData(int i, boolean z);

    boolean restart(int i);

    void restartAllFailedDownloadTasks(List<String> list);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> list);

    boolean restartAsyncWaitingTask(int i);

    boolean resume(int i);

    void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener);

    void setThrottleNetSpeed(int i, long j, int i2);

    void shutDown();

    void tryDownload(DownloadTask downloadTask);
}
