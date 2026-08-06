package com.ss.android.socialbase.downloader.downloader;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl;
import com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Set;

/* loaded from: classes7.dex */
public interface ISqlDownloadCache extends IDownloadCache {
    void init(SparseArray<DownloadInfo> sparseArray, Set<Integer> set, List<DownloadInfo> list, List<String> list2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback);

    void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl);
}
