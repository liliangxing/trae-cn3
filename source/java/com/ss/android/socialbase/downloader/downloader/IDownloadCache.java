package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public interface IDownloadCache {
    DownloadInfo OnDownloadTaskCancel(int i, long j);

    DownloadInfo OnDownloadTaskCompleted(int i, long j);

    DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2);

    DownloadInfo OnDownloadTaskError(int i, long j);

    DownloadInfo OnDownloadTaskIntercept(int i);

    DownloadInfo OnDownloadTaskPause(int i, long j);

    DownloadInfo OnDownloadTaskPrepare(int i);

    DownloadInfo OnDownloadTaskProgress(int i, long j);

    DownloadInfo OnDownloadTaskRetry(int i);

    boolean cacheExist(int i);

    void clearData();

    void clearMemoryCacheData(double d);

    boolean ensureDownloadCacheSyncSuccess();

    List<DownloadInfo> getAllDownloadInfo();

    DownloadInfo getDownloadInfo(int i);

    List<DownloadInfo> getDownloadInfoList(String str);

    List<DownloadInfo> getDownloadInfosByFileExtension(String str);

    List<DownloadInfo> getDownloadInfosByFilters(String str, String str2);

    Map<Long, Segment> getSegmentMap(int i);

    List<Segment> getSegments(int i);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str);

    void init(boolean z);

    void initImmediately();

    boolean isDownloadCacheSyncSuccess();

    DownloadInfo onDownloadTaskStart(int i);

    boolean removeDownloadInfo(int i);

    boolean removeDownloadTaskData(int i);

    void removeSegments(int i);

    void syncDownloadInfo(DownloadInfo downloadInfo);

    void syncDownloadInfoFromOtherCache(int i);

    boolean updateDownloadInfo(DownloadInfo downloadInfo);

    boolean updateSegments(int i, Map<Long, Segment> map);
}
