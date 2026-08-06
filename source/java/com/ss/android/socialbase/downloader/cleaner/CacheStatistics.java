package com.ss.android.socialbase.downloader.cleaner;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CacheStatistics {
    private static final String CACHE_NAME = "name";
    private static final String CACHE_SIZE = "size";
    private static final String COUNT = "count";
    private static final String DURATION = "duration";
    private static final String NO_MATCH_DB = "NoMatchDB";
    private static final String TAG = "CleanerStatistics";
    private static final String TEMP_CACHE_SIZE = "tpSize";
    private static final String TEMP_SUFFIX = ".tp";
    private static final int TEMP_SUFFIX_LENGTH = 3;
    private static final String TOP_CACHE = "topCache";
    private static final String TOTAL_CACHE = "totalCache";
    private static final String UNKNOWN = "UNKNOWN";
    private Map<String, Map<String, DownloadDiskInfo>> mPathDiskInfoMap = new HashMap();
    private int mTopCacheCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CacheSize implements Comparable<CacheSize> {
        int mCount;
        public long mDuration;
        public String mName;
        public long mSize;
        public long mTpSize;

        private CacheSize() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.mName, ((CacheSize) obj).mName);
        }

        public int hashCode() {
            return Objects.hash(this.mName);
        }

        @Override // java.lang.Comparable
        public int compareTo(CacheSize cacheSize) {
            long j = this.mSize + this.mTpSize;
            long j2 = cacheSize.mSize + cacheSize.mTpSize;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? -1 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class DownloadDiskInfo {
        public Set<CacheSize> mTopCache;
        public CacheSize mTotalCache;

        private DownloadDiskInfo() {
            this.mTotalCache = new CacheSize();
            this.mTopCache = new TreeSet();
        }
    }

    public static void start(final CleanerConfig cleanerConfig) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "start", "Run");
        }
        int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.MONITOR_CACHE_DELAY_TIME_S);
        if (optInt <= 0) {
            return;
        }
        int optInt2 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.MONITOR_CACHE_INTERVAL_D);
        if (optInt2 > 0) {
            long cacheLastReportTime = cleanerConfig.getCacheLastReportTime();
            if (cacheLastReportTime > 0 && System.currentTimeMillis() - cacheLastReportTime < optInt2 * DownloadConstants.DAY) {
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "start", "It has already been reported, lastReportTime:" + cacheLastReportTime);
                    return;
                }
                return;
            }
            cleanerConfig.updateCacheReportTime();
        }
        if (DownloadComponentManager.getAppContext() == null) {
            return;
        }
        DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.cleaner.CacheStatistics.1
            @Override // java.lang.Runnable
            public void run() {
                if (Logger.debug()) {
                    Logger.globalDebug(CacheStatistics.TAG, "start", "Run Start");
                }
                try {
                    new CacheStatistics().runImpl(CleanerConfig.this);
                } catch (Throwable th) {
                    Logger.globalError(CacheStatistics.TAG, "start", "Error:" + th);
                }
                if (Logger.debug()) {
                    Logger.globalDebug(CacheStatistics.TAG, "start", "Run End");
                }
            }
        }, optInt, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runImpl(CleanerConfig cleanerConfig) throws Throwable {
        this.mTopCacheCount = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.MONITOR_CACHE_TOP_COUNT);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "run", "TopCacheCount:" + this.mTopCacheCount);
        }
        if (this.mTopCacheCount <= 0) {
            return;
        }
        handleCachePath(cleanerConfig);
        report();
    }

    private void handleCachePath(CleanerConfig cleanerConfig) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(DownloadComponentManager.getAppContext().getPackageName()) || (optJSONArray = DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.MONITOR_CACHE_PATH_LIST)) == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString = optJSONArray.optString(i);
            File realExternalFile = CleanerConfig.getRealExternalFile(optString, cleanerConfig.getPackageName());
            if (realExternalFile != null && realExternalFile.isDirectory()) {
                handleCachePath(realExternalFile);
            } else {
                File realInternalFile = CleanerConfig.getRealInternalFile(optString, cleanerConfig.getPackageName());
                if (realInternalFile != null && realInternalFile.isDirectory()) {
                    handleCachePath(realInternalFile);
                }
            }
        }
    }

    private void handleCachePath(File file) {
        Map<String, DownloadDiskInfo> map = this.mPathDiskInfoMap.get(file.getAbsolutePath());
        if (map == null) {
            map = new HashMap<>();
            this.mPathDiskInfoMap.put(file.getAbsolutePath(), map);
        }
        List<DownloadInfo> downloadInfosBySavePath = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfosBySavePath(file.getAbsolutePath() + "%");
        HashMap hashMap = new HashMap();
        if (downloadInfosBySavePath != null && !downloadInfosBySavePath.isEmpty()) {
            for (DownloadInfo downloadInfo : downloadInfosBySavePath) {
                hashMap.put(new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName()).getAbsolutePath(), downloadInfo);
            }
        }
        handleCacheSize(file, map, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleCacheSize(File file, Map<String, DownloadDiskInfo> map, Map<String, DownloadInfo> map2) {
        File[] listFiles;
        DownloadInfo downloadInfo;
        String monitorScene;
        DownloadDiskInfo downloadDiskInfo;
        if (file == null || !file.exists()) {
            return;
        }
        int i = 0;
        if (file.isFile()) {
            String absolutePath = file.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                return;
            }
            if (absolutePath.endsWith(TEMP_SUFFIX)) {
                int length = absolutePath.length();
                int i2 = TEMP_SUFFIX_LENGTH;
                if (length > i2) {
                    absolutePath = absolutePath.substring(0, absolutePath.length() - i2);
                    downloadInfo = map2.get(absolutePath);
                    if (downloadInfo != null) {
                        monitorScene = NO_MATCH_DB;
                    } else {
                        monitorScene = downloadInfo.getMonitorScene();
                        if (TextUtils.isEmpty(monitorScene)) {
                            monitorScene = UNKNOWN;
                        }
                    }
                    downloadDiskInfo = map.get(monitorScene);
                    if (downloadDiskInfo == null) {
                        downloadDiskInfo = new DownloadDiskInfo();
                    }
                    CacheSize cacheSize = new CacheSize();
                    if (i == 0) {
                        cacheSize.mSize = file.length();
                    } else {
                        cacheSize.mTpSize = file.length();
                    }
                    cacheSize.mDuration = System.currentTimeMillis() - file.lastModified();
                    cacheSize.mName = file.getName();
                    downloadDiskInfo.mTopCache.add(cacheSize);
                    downloadDiskInfo.mTotalCache.mSize += cacheSize.mSize;
                    downloadDiskInfo.mTotalCache.mTpSize += cacheSize.mTpSize;
                    downloadDiskInfo.mTotalCache.mDuration += cacheSize.mDuration;
                    downloadDiskInfo.mTotalCache.mCount++;
                    map.put(monitorScene, downloadDiskInfo);
                    return;
                }
            }
            i = 1;
            downloadInfo = map2.get(absolutePath);
            if (downloadInfo != null) {
            }
            downloadDiskInfo = map.get(monitorScene);
            if (downloadDiskInfo == null) {
            }
            CacheSize cacheSize2 = new CacheSize();
            if (i == 0) {
            }
            cacheSize2.mDuration = System.currentTimeMillis() - file.lastModified();
            cacheSize2.mName = file.getName();
            downloadDiskInfo.mTopCache.add(cacheSize2);
            downloadDiskInfo.mTotalCache.mSize += cacheSize2.mSize;
            downloadDiskInfo.mTotalCache.mTpSize += cacheSize2.mTpSize;
            downloadDiskInfo.mTotalCache.mDuration += cacheSize2.mDuration;
            downloadDiskInfo.mTotalCache.mCount++;
            map.put(monitorScene, downloadDiskInfo);
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            while (i < listFiles.length) {
                handleCacheSize(listFiles[i], map, map2);
                i++;
            }
        }
    }

    private void report() throws Throwable {
        if (this.mPathDiskInfoMap.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<Map.Entry<String, Map<String, DownloadDiskInfo>>> it = this.mPathDiskInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Map<String, DownloadDiskInfo>> next = it.next();
            String key = next.getKey();
            Map<String, DownloadDiskInfo> value = next.getValue();
            if (!value.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject();
                Iterator<Map.Entry<String, DownloadDiskInfo>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry<String, DownloadDiskInfo> next2 = it2.next();
                    String key2 = next2.getKey();
                    DownloadDiskInfo value2 = next2.getValue();
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("size", value2.mTotalCache.mSize);
                    jSONObject4.put(TEMP_CACHE_SIZE, value2.mTotalCache.mTpSize);
                    jSONObject4.put("duration", value2.mTotalCache.mDuration);
                    jSONObject4.put(COUNT, value2.mTotalCache.mCount);
                    jSONObject3.put(TOTAL_CACHE, jSONObject4);
                    JSONArray jSONArray = new JSONArray();
                    int i = 0;
                    for (CacheSize cacheSize : value2.mTopCache) {
                        i++;
                        if (i > this.mTopCacheCount) {
                            break;
                        }
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("size", cacheSize.mSize);
                        jSONObject5.put(TEMP_CACHE_SIZE, cacheSize.mTpSize);
                        jSONObject5.put("name", cacheSize.mName);
                        jSONObject5.put("duration", cacheSize.mDuration);
                        jSONArray.put(jSONObject5);
                        it = it;
                        it2 = it2;
                    }
                    jSONObject3.put(TOP_CACHE, jSONArray);
                    jSONObject2.put(key2, jSONObject3);
                    it = it;
                    it2 = it2;
                }
                jSONObject.put(key, jSONObject2);
            }
        }
        if (jSONObject.length() <= 0) {
            return;
        }
        DownloadMonitorHelper.monitorDownloadDiskCache(jSONObject);
    }
}
