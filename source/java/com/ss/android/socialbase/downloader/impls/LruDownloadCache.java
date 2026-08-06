package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.p005db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LruDownloadCache extends DownloadCache {
    static final String TAG = "LruDownloadCache";
    private final List<DownloadInfo> autoResumeList;
    private final LinkedHashMap<Integer, DownloadInfo> lruDownloadInfoMap;
    private final SparseArray<Map<Long, Segment>> lruSegmentListMap;
    private final Set<Integer> mUnreadDBSet;
    private ISqlDownloadCache sqlDownloadCache;

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean z) {
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToUnreadMap(Integer num) {
        this.mUnreadDBSet.add(num);
    }

    private void removeFromUnreadMap(Integer num) {
        if (num.intValue() == 0) {
            return;
        }
        this.mUnreadDBSet.remove(num);
    }

    private boolean isExistInUnreadMap(Integer num) {
        if (num.intValue() == 0) {
            return false;
        }
        return this.mUnreadDBSet.contains(num);
    }

    private void addToLruSegmentListMap(int i, Map<Long, Segment> map) {
        if (i == 0) {
            return;
        }
        synchronized (this.lruSegmentListMap) {
            this.lruSegmentListMap.put(i, map);
        }
    }

    private void removeFromLruSegmentListMap(Integer num) {
        synchronized (this.lruSegmentListMap) {
            this.lruSegmentListMap.remove(num.intValue());
        }
    }

    private Map<Long, Segment> getFromLruSegmentListMap(Integer num) {
        Map<Long, Segment> map;
        synchronized (this.lruSegmentListMap) {
            map = this.lruSegmentListMap.get(num.intValue());
        }
        return map;
    }

    private void addToLruDownloadInfoMap(Integer num, DownloadInfo downloadInfo) {
        if (num.intValue() == 0) {
            return;
        }
        synchronized (this.lruDownloadInfoMap) {
            this.lruDownloadInfoMap.put(num, downloadInfo);
        }
    }

    private void removeFromLruDownloadInfoMap(Integer num) {
        synchronized (this.lruDownloadInfoMap) {
            this.lruDownloadInfoMap.remove(num);
        }
    }

    private DownloadInfo getFromLruDownloadInfoMap(Integer num) {
        DownloadInfo downloadInfo;
        synchronized (this.lruDownloadInfoMap) {
            downloadInfo = this.lruDownloadInfoMap.get(num);
        }
        return downloadInfo;
    }

    private void clearUnreadMap() {
        this.mUnreadDBSet.clear();
    }

    private void clearLruSegmentListMap() {
        synchronized (this.lruSegmentListMap) {
            this.lruSegmentListMap.clear();
        }
    }

    private void clearLruDownloadInfoMap() {
        synchronized (this.lruDownloadInfoMap) {
            this.lruDownloadInfoMap.clear();
        }
    }

    public LruDownloadCache(ISqlDownloadCache iSqlDownloadCache) {
        super(iSqlDownloadCache);
        this.lruSegmentListMap = new SparseArray<>();
        this.mUnreadDBSet = new CopyOnWriteArraySet();
        this.autoResumeList = new ArrayList();
        this.lruDownloadInfoMap = new LinkedHashMap<Integer, DownloadInfo>(0, 0.75f, true) { // from class: com.ss.android.socialbase.downloader.impls.LruDownloadCache.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<Integer, DownloadInfo> entry) {
                if (size() <= SqlDownloadCache.DOWNLOAD_CACHE_LRU_CAPACITY_MAX || SqlDownloadCache.lruHotCacheKeysMap != null) {
                    return false;
                }
                LruDownloadCache.this.addToUnreadMap(entry.getKey());
                return true;
            }
        };
        this.sqlDownloadCache = iSqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i) {
        return getDownloadInfo(i) != null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i) {
        visitDownloadMemoryInfo();
        DownloadInfo downloadInfo = null;
        try {
            downloadInfo = getFromLruDownloadInfoMap(Integer.valueOf(i));
            if (downloadInfo == null && isExistInUnreadMap(Integer.valueOf(i))) {
                downloadInfo = this.sqlDownloadCache.getDownloadInfo(i);
                if (downloadInfo != null) {
                    addToLruDownloadInfoMap(Integer.valueOf(i), downloadInfo);
                }
                removeFromUnreadMap(Integer.valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        visitDownloadMemoryInfo();
        try {
            return this.sqlDownloadCache.getDownloadInfoList(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.sqlDownloadCache.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.sqlDownloadCache.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.sqlDownloadCache.getDownloadInfosByFileExtension(str);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        visitDownloadMemoryInfo();
        return this.sqlDownloadCache.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        visitDownloadMemoryInfo();
        return getDownloadInfosByFilters(this.sqlDownloadCache.getAllDownloadInfo(), str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        visitDownloadMemoryInfo();
        if (downloadInfo == null) {
            return true;
        }
        boolean z = getDownloadInfo(downloadInfo.getId()) != null;
        addToLruDownloadInfoMap(Integer.valueOf(downloadInfo.getId()), downloadInfo);
        removeFromUnreadMap(Integer.valueOf(downloadInfo.getId()));
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i) {
        visitDownloadMemoryInfo();
        removeFromLruDownloadInfoMap(Integer.valueOf(i));
        removeFromUnreadMap(Integer.valueOf(i));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i) {
        removeDownloadInfo(i);
        removeSegments(i);
        removeFromUnreadMap(Integer.valueOf(i));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        visitDownloadMemoryInfo();
        clearLruDownloadInfoMap();
        clearUnreadMap();
        clearLruSegmentListMap();
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double d) {
        visitDownloadMemoryInfo();
        if (d <= 0.0d || d > 1.0d) {
            return;
        }
        synchronized (this.lruDownloadInfoMap) {
            int size = (int) (this.lruDownloadInfoMap.size() * d);
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "clearMemoryCacheData", "Before LruDownloadInfoMap Size:" + this.lruDownloadInfoMap.size() + " ClearSize:" + size);
            }
            Iterator<Map.Entry<Integer, DownloadInfo>> it = this.lruDownloadInfoMap.entrySet().iterator();
            for (int i = 0; it.hasNext() && i < size; i++) {
                if (!DownloadComponentManager.getDownloadEngine().isDownloading(it.next().getKey().intValue())) {
                    it.remove();
                }
            }
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "clearMemoryCacheData", "End LruDownloadInfoMap Size:" + this.lruDownloadInfoMap.size());
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setTotalBytes(j);
            downloadInfo.seteTag(str);
            if (TextUtils.isEmpty(downloadInfo.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfo.setName(str2);
            }
            downloadInfo.setStatus(3);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfo.getStatus()) && downloadInfo.getStatus() != -4) {
                downloadInfo.setStatus(4);
            }
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-1);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(5);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-3);
            downloadInfo.setFirstDownload(false);
            downloadInfo.setFirstSuccess(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-4);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(1);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(-7);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int i) {
        Map<Long, Segment> segmentMap = getSegmentMap(i);
        if (segmentMap == null) {
            return null;
        }
        return new ArrayList(segmentMap.values());
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i) {
        Map<Long, Segment> fromLruSegmentListMap = getFromLruSegmentListMap(Integer.valueOf(i));
        if (fromLruSegmentListMap == null) {
            fromLruSegmentListMap = this.sqlDownloadCache.getSegmentMap(i);
            if (fromLruSegmentListMap == null) {
                return null;
            }
            addToLruSegmentListMap(i, fromLruSegmentListMap);
        }
        return fromLruSegmentListMap;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, Map<Long, Segment> map) {
        addToLruSegmentListMap(i, map);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
        removeFromLruSegmentListMap(Integer.valueOf(i));
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public void addToDownloadCacheInfoMap(DownloadInfo downloadInfo) {
        addToLruDownloadInfoMap(Integer.valueOf(downloadInfo.getId()), downloadInfo);
        removeFromUnreadMap(Integer.valueOf(downloadInfo.getId()));
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public Set<Integer> getUnreadDBSet() {
        return this.mUnreadDBSet;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public List<DownloadInfo> getAutoResumeList() {
        return this.autoResumeList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public List<String> getMimeTypes() {
        IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
        if (downloadLaunchHandler != null) {
            return downloadLaunchHandler.getResumeMimeTypes();
        }
        return null;
    }
}
