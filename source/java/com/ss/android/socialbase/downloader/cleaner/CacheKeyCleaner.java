package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.cleaner.CleanerImpl;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CacheKeyCleaner implements CleanerImpl.CleanerHandler {
    private static final String TAG = "CacheKeyCleaner";
    private Map<Integer, List<Integer>> mCleanCacheKeyMaps;
    private CleanerConfig mCleanerConfig;
    private CleanerImpl mCleanerImpl;

    public CacheKeyCleaner(CleanerImpl cleanerImpl, CleanerConfig cleanerConfig) {
        this.mCleanerImpl = cleanerImpl;
        this.mCleanerConfig = cleanerConfig;
        this.mCleanCacheKeyMaps = cleanerConfig.getCleanCacheKeyMaps();
    }

    public static boolean isEnabled(CleanerConfig cleanerConfig) {
        return (cleanerConfig.isNoCacheNeedClean() || cleanerConfig.getCleanCacheKeyMaps().isEmpty()) ? false : true;
    }

    public void batchStart() {
        if (this.mCleanCacheKeyMaps.isEmpty()) {
            return;
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "loadDataAndStart", "Run" + this.mCleanCacheKeyMaps.size());
        }
        start();
        this.mCleanerConfig.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.cleaner.CleanerImpl.CleanerHandler
    public void start() {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "start", "Run");
        }
        try {
            startImpl();
        } catch (Throwable th) {
            try {
                Logger.globalError(TAG, "start", "Error:" + th);
                if (!Logger.debug()) {
                }
            } finally {
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "start", "Run End");
                }
            }
        }
    }

    private void startImpl() {
        Iterator<Map.Entry<Integer, List<Integer>>> it = this.mCleanCacheKeyMaps.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = it.next();
            int intValue = next.getKey().intValue();
            Iterator<Integer> it2 = next.getValue().iterator();
            while (it2.hasNext()) {
                CleanerImpl cleanerImpl = this.mCleanerImpl;
                if (cleanerImpl != null && cleanerImpl.isStop()) {
                    if (Logger.debug()) {
                        Logger.globalDebug(TAG, "startImpl", "stop cleaning");
                        return;
                    }
                    return;
                }
                int intValue2 = it2.next().intValue();
                if (!this.mCleanerConfig.isExistInCleanSet(intValue2)) {
                    if (Logger.debug()) {
                        Logger.globalDebug(TAG, "startImpl", "dwg888Find in visit history,can't do clean,downloadId=" + intValue2);
                    }
                    it2.remove();
                } else {
                    DownloadUtils.clearDownloadFile(this.mCleanerConfig.getSavePath(intValue2), this.mCleanerConfig.getTempSavePath(intValue2), this.mCleanerConfig.getName(intValue2));
                    if (!this.mCleanerConfig.isOnlyCleanFile(intValue2)) {
                        DownloadComponentManager.getDownloadCache().removeDownloadTaskData(intValue2);
                    }
                    if (Logger.debug()) {
                        Logger.globalDebug(TAG, "startImpl", "clean cache downloadId=" + intValue2);
                    }
                    it2.remove();
                    this.mCleanerConfig.removeFromCleanDownloadIdSet(intValue2);
                }
            }
            it.remove();
            this.mCleanerConfig.updateCleanSetting(intValue);
        }
    }

    public void finish() {
        this.mCleanerConfig.finish();
    }
}
