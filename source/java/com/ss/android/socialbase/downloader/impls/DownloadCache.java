package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadCache implements IDownloadCache {
    private static final String TAG = "DownloadCache";
    private boolean activeLoadDownloadCache;
    private final Map<Integer, DownloadInfo> downloadInfoMap = new ConcurrentHashMap();
    private final Map<Integer, Map<Long, Segment>> segmentListMap = new ConcurrentHashMap();

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    public List<String> getMimeTypes() {
        return null;
    }

    public Set<Integer> getUnreadDBSet() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean z) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i) {
    }

    public DownloadCache(ISqlDownloadCache iSqlDownloadCache) {
        this.activeLoadDownloadCache = false;
        this.activeLoadDownloadCache = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.ACTIVE_LOAD_DOWNLOAD_CACHE) > 0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i) {
        return getDownloadInfo(i) != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i) {
        visitDownloadMemoryInfo();
        return this.downloadInfoMap.get(Integer.valueOf(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        visitDownloadMemoryInfo();
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (DownloadInfo downloadInfo : this.downloadInfoMap.values()) {
            if (str.equals(downloadInfo.getUrl())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(str) || this.downloadInfoMap.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DownloadInfo downloadInfo : this.downloadInfoMap.values()) {
            if (!TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(str) || this.downloadInfoMap.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DownloadInfo downloadInfo : this.downloadInfoMap.values()) {
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String str) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(str) || this.downloadInfoMap.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DownloadInfo downloadInfo : this.downloadInfoMap.values()) {
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getName()) && downloadInfo.getName().endsWith(str)) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        visitDownloadMemoryInfo();
        if (this.downloadInfoMap.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DownloadInfo> it = this.downloadInfoMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        visitDownloadMemoryInfo();
        return getDownloadInfosByFilters(this.downloadInfoMap.values(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<DownloadInfo> getDownloadInfosByFilters(Collection<DownloadInfo> collection, String str, String str2) {
        if (collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DownloadInfo downloadInfo : collection) {
            if (checkFilter(downloadInfo, str, str2)) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    private boolean checkFilter(DownloadInfo downloadInfo, String str, String str2) {
        String str3;
        if (downloadInfo == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(downloadInfo.getMimeType()) && str.equals(downloadInfo.getMimeType())) {
            return true;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(downloadInfo.getUrl())) {
            return false;
        }
        try {
            str3 = Uri.parse(downloadInfo.getUrl()).getLastPathSegment();
        } catch (Throwable th) {
            th.printStackTrace();
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        return str3.endsWith(str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        visitDownloadMemoryInfo();
        if (downloadInfo == null) {
            return true;
        }
        boolean z = this.downloadInfoMap.get(Integer.valueOf(downloadInfo.getId())) != null;
        this.downloadInfoMap.put(Integer.valueOf(downloadInfo.getId()), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i) {
        visitDownloadMemoryInfo();
        this.downloadInfoMap.remove(Integer.valueOf(i));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i) {
        removeDownloadInfo(i);
        removeSegments(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        visitDownloadMemoryInfo();
        this.downloadInfoMap.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double d) {
        visitDownloadMemoryInfo();
        if (d <= 0.0d || d > 1.0d) {
            return;
        }
        int size = (int) (this.downloadInfoMap.size() * d);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "clearMemoryCacheData", "Before DownloadInfoMap Size:" + this.downloadInfoMap.size() + " ClearSize:" + size);
        }
        Iterator<Map.Entry<Integer, DownloadInfo>> it = this.downloadInfoMap.entrySet().iterator();
        int i = 0;
        while (it.hasNext() && i < size) {
            if (!DownloadComponentManager.getDownloadEngine().isDownloading(it.next().getKey().intValue())) {
                it.remove();
                i++;
            }
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "clearMemoryCacheData", "End DownloadInfoMap Size:" + this.downloadInfoMap.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
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

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
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

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-1);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(5);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
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

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-4);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(1);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(-7);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int i) {
        Map<Long, Segment> map = this.segmentListMap.get(Integer.valueOf(i));
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new ArrayList(map.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i) {
        return this.segmentListMap.get(Integer.valueOf(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, Map<Long, Segment> map) {
        if (map == null) {
            return false;
        }
        this.segmentListMap.put(Integer.valueOf(i), map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
        this.segmentListMap.remove(Integer.valueOf(i));
    }

    public void addToDownloadCacheInfoMap(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.downloadInfoMap.put(Integer.valueOf(downloadInfo.getId()), downloadInfo);
    }

    public void copyDownloadInfoMap(SparseArray<DownloadInfo> sparseArray) {
        for (Map.Entry<Integer, DownloadInfo> entry : this.downloadInfoMap.entrySet()) {
            if (entry.getKey().intValue() != 0 && entry.getValue() != null) {
                sparseArray.put(entry.getKey().intValue(), entry.getValue());
            }
        }
    }

    public List<DownloadInfo> getAutoResumeList() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
        if (downloadLaunchHandler != null) {
            list = downloadLaunchHandler.getResumeMimeTypes();
            arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
        } else {
            list = null;
            arrayList = null;
        }
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<Integer, DownloadInfo> entry : this.downloadInfoMap.entrySet()) {
            if (entry.getKey().intValue() != 0 && entry.getValue() != null) {
                sparseArray.put(entry.getKey().intValue(), entry.getValue());
            }
        }
        if (sparseArray.size() == 0) {
            return null;
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (keyAt != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt)) != null) {
                int realStatus = downloadInfo.getRealStatus();
                int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                    DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), null, downloadInfo, null, -5);
                }
                if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (DownloadSetting.obtain(downloadInfo.getId()).optInt("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                    downloadInfo.setDownloadFromReserveWifi(false);
                    arrayList.add(downloadInfo);
                }
            }
        }
        return arrayList;
    }

    public boolean isActiveLoadDownloadCache() {
        return this.activeLoadDownloadCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void visitDownloadMemoryInfo() {
        IDownloadMemoryInfoListener downloadMemoryInfoListener = DownloadComponentManager.getDownloadMemoryInfoListener();
        if (downloadMemoryInfoListener != null) {
            downloadMemoryInfoListener.onVisitMemoryInfo();
        }
        if (!this.activeLoadDownloadCache || DownloadUtils.isMainThread()) {
            return;
        }
        DownloadComponentManager.getDownloadCache().ensureDownloadCacheSyncSuccess();
    }
}
