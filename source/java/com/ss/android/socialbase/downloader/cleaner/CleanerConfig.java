package com.ss.android.socialbase.downloader.cleaner;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CleanerConfig {
    private static final int FORCE_CLEAN_ID = -1;
    private static final String KEY_CLEAN_FINISH = "key_clean_finish";
    private static final String KEY_CLEAN_TIME = "key_clean_time";
    private static final String KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY = "key_download_cache_clean_strategy";
    private static final String KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME = "key_download_cache_last_directory_clean_time";
    private static final String KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME = "key_download_cache_last_report_time";
    private static final String TAG = "CleanerConfig";
    private String mPackageName;
    private volatile Map<Integer, CleanItem> mCleanItemMaps = new HashMap();
    private volatile Map<Integer, CleanItem> mNeedCleanItemMaps = new HashMap();
    private volatile Map<Integer, List<Integer>> mCleanCacheKeyMaps = new HashMap();
    private volatile Set<Integer> mCleanDownloadIdSet = new CopyOnWriteArraySet();
    private volatile Map<Integer, String> mFileDirPathMap = new HashMap();
    private volatile Map<Integer, String> mFileNameMap = new HashMap();
    private volatile Map<Integer, String> mTempSavePath = new HashMap();
    private volatile Set<Integer> mOnlyCleanFileSet = new HashSet();
    private volatile boolean mFinish = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CleanItem {
        boolean finish;
        List<String> prefixUrls;
        Set<String> savePaths;
        Set<String> scenes;

        private CleanItem() {
            this.scenes = new HashSet();
            this.prefixUrls = new ArrayList();
            this.savePaths = new HashSet();
        }

        public String toString() {
            return "CleanItem{finish=" + this.finish + ", scenes=" + this.scenes + ", prefixUrls=" + this.prefixUrls + ", savePaths=" + this.savePaths + '}';
        }
    }

    public void init() {
        try {
            if (DownloadComponentManager.getAppContext() == null) {
                return;
            }
            String packageName = DownloadComponentManager.getAppContext().getPackageName();
            this.mPackageName = packageName;
            if (TextUtils.isEmpty(packageName)) {
                return;
            }
            parseCleanSetting(getString(KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY));
            parseCleanSetting(DownloadSetting.getGlobalSettings());
            DirectoryCleaner.init(this);
            if (this.mCleanItemMaps.isEmpty()) {
                return;
            }
            for (Map.Entry<Integer, CleanItem> entry : this.mCleanItemMaps.entrySet()) {
                CleanItem value = entry.getValue();
                if (!value.finish) {
                    this.mNeedCleanItemMaps.put(entry.getKey(), value);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void addToCleanDownloadIdSet(int i) {
        if (this.mFinish || i == 0) {
            return;
        }
        this.mCleanDownloadIdSet.add(Integer.valueOf(i));
    }

    public void removeFromCleanDownloadIdSet(int i) {
        this.mCleanDownloadIdSet.remove(Integer.valueOf(i));
    }

    public boolean isNoCacheNeedClean() {
        return this.mCleanDownloadIdSet.isEmpty();
    }

    public boolean isCacheCleanEnabled() {
        return checkTimeInterval() && (!isNoCacheNeedClean() || DirectoryCleaner.isEnabled());
    }

    public boolean checkTimeInterval() {
        int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CacheCleaner.CLEAN_INTERVAL_D);
        if (optInt <= 0) {
            return true;
        }
        long j = getLong(KEY_CLEAN_TIME);
        if (j > 0 && System.currentTimeMillis() - j < optInt * DownloadConstants.DAY) {
            if (!Logger.debug()) {
                return false;
            }
            Logger.globalDebug(TAG, "start", "It has already been clean, lastCleanTime:" + j);
            return false;
        }
        putLong(KEY_CLEAN_TIME, System.currentTimeMillis());
        return true;
    }

    public boolean isExistInCleanSet(int i) {
        if (this.mFinish || this.mCleanDownloadIdSet.isEmpty()) {
            return false;
        }
        return this.mCleanDownloadIdSet.contains(Integer.valueOf(i));
    }

    private void saveFilePath(CleanDownloadInfo cleanDownloadInfo) {
        if (TextUtils.isEmpty(cleanDownloadInfo.getSavePath()) || TextUtils.isEmpty(cleanDownloadInfo.getName())) {
            return;
        }
        this.mFileDirPathMap.put(Integer.valueOf(cleanDownloadInfo.getId()), cleanDownloadInfo.getSavePath());
        this.mFileNameMap.put(Integer.valueOf(cleanDownloadInfo.getId()), cleanDownloadInfo.getName());
        if (TextUtils.isEmpty(cleanDownloadInfo.getTempPath())) {
            return;
        }
        this.mTempSavePath.put(Integer.valueOf(cleanDownloadInfo.getId()), cleanDownloadInfo.getTempPath());
    }

    public String getSavePath(int i) {
        return this.mFileDirPathMap.get(Integer.valueOf(i));
    }

    public String getName(int i) {
        return this.mFileNameMap.get(Integer.valueOf(i));
    }

    public String getTempSavePath(int i) {
        return this.mTempSavePath.get(Integer.valueOf(i));
    }

    public boolean isOnlyCleanFile(int i) {
        return this.mOnlyCleanFileSet.contains(Integer.valueOf(i));
    }

    public boolean updateCleanDownloadId(CleanDownloadInfo cleanDownloadInfo) {
        for (Map.Entry<Integer, CleanItem> entry : this.mNeedCleanItemMaps.entrySet()) {
            if (matchCleanItem(entry.getValue(), cleanDownloadInfo)) {
                addCleanDownloadItem(entry.getKey().intValue(), cleanDownloadInfo, false);
                return true;
            }
        }
        return false;
    }

    public boolean forceUpdateCleanDownloadId(CleanDownloadInfo cleanDownloadInfo, boolean z) {
        if (cleanDownloadInfo == null) {
            return false;
        }
        addCleanDownloadItem(-1, cleanDownloadInfo, z);
        return true;
    }

    private void addCleanDownloadItem(int i, CleanDownloadInfo cleanDownloadInfo, boolean z) {
        List<Integer> list = this.mCleanCacheKeyMaps.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(Integer.valueOf(cleanDownloadInfo.getId()));
        addToCleanDownloadIdSet(cleanDownloadInfo.getId());
        this.mCleanCacheKeyMaps.put(Integer.valueOf(i), list);
        saveFilePath(cleanDownloadInfo);
        if (z) {
            this.mOnlyCleanFileSet.add(Integer.valueOf(cleanDownloadInfo.getId()));
        }
    }

    private boolean matchCleanItem(CleanItem cleanItem, CleanDownloadInfo cleanDownloadInfo) {
        if (cleanItem != null && cleanDownloadInfo != null && !TextUtils.isEmpty(cleanDownloadInfo.getSavePath())) {
            if (!cleanItem.scenes.isEmpty() && !TextUtils.isEmpty(cleanDownloadInfo.getMonitorScene()) && cleanItem.scenes.contains(cleanDownloadInfo.getMonitorScene())) {
                return true;
            }
            if (!cleanItem.prefixUrls.isEmpty()) {
                String url = cleanDownloadInfo.getUrl();
                if (TextUtils.isEmpty(url)) {
                    return false;
                }
                Iterator<String> it = cleanItem.prefixUrls.iterator();
                while (it.hasNext()) {
                    if (url.startsWith(it.next())) {
                        return true;
                    }
                }
            }
            if (!cleanItem.savePaths.isEmpty() && !TextUtils.isEmpty(this.mPackageName)) {
                String savePath = cleanDownloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath) || savePath.indexOf(this.mPackageName) <= 0) {
                    return false;
                }
                if (savePath.endsWith("/")) {
                    savePath = savePath.substring(0, savePath.length() - 1);
                }
                if (cleanItem.savePaths.contains(savePath)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<Integer, List<Integer>> getCleanCacheKeyMaps() {
        return this.mCleanCacheKeyMaps;
    }

    private void parseCleanSetting(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        parseCleanSetting(new JSONObject(str));
    }

    private void parseCleanSetting(JSONObject jSONObject) throws Throwable {
        JSONArray optJSONArray;
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "parseCleanSetting", "Run");
        }
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(DownloadSettingKeys.CacheCleaner.CLEAN_GROUP)) == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            int optInt = jSONObject2.optInt(DownloadSettingKeys.CacheCleaner.CLEAN_ID);
            if (!this.mCleanItemMaps.containsKey(Integer.valueOf(optInt))) {
                CleanItem cleanItem = new CleanItem();
                cleanItem.finish = jSONObject2.optBoolean(KEY_CLEAN_FINISH);
                if (cleanItem.finish) {
                    this.mCleanItemMaps.put(Integer.valueOf(optInt), cleanItem);
                    this.mCleanCacheKeyMaps.put(Integer.valueOf(optInt), new ArrayList());
                } else {
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray(DownloadSettingKeys.CacheCleaner.MONITOR_SCENE_LIST);
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String optString = optJSONArray2.optString(i2);
                            if (!TextUtils.isEmpty(optString)) {
                                cleanItem.scenes.add(optString);
                            }
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray(DownloadSettingKeys.CacheCleaner.URL_PREFIX_LIST);
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            String optString2 = optJSONArray3.optString(i3);
                            if (!TextUtils.isEmpty(optString2)) {
                                cleanItem.prefixUrls.add(optString2);
                            }
                        }
                    }
                    JSONArray optJSONArray4 = jSONObject2.optJSONArray(DownloadSettingKeys.CacheCleaner.SAVE_PATH_LIST);
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            String optString3 = optJSONArray4.optString(i4);
                            if (!TextUtils.isEmpty(optString3)) {
                                cleanItem.savePaths.add(optString3);
                            }
                        }
                    }
                    if (!cleanItem.scenes.isEmpty() || !cleanItem.prefixUrls.isEmpty() || !cleanItem.savePaths.isEmpty()) {
                        this.mCleanItemMaps.put(Integer.valueOf(optInt), cleanItem);
                        this.mCleanCacheKeyMaps.put(Integer.valueOf(optInt), new ArrayList());
                    }
                }
            }
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "parseCleanSetting", "Result: " + this.mCleanItemMaps);
        }
    }

    public static File getRealExternalFile(String str, String str2) {
        String str3;
        int length;
        File externalCacheDir;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() <= (length = (str3 = "Android/data/" + str2).length()) || (externalCacheDir = DownloadDirUtils.getExternalCacheDir(DownloadComponentManager.getAppContext(), false)) == null) {
            return null;
        }
        String parent = externalCacheDir.getParent();
        if (str.startsWith(str3) && !TextUtils.isEmpty(parent)) {
            return new File(parent, str.substring(length));
        }
        return null;
    }

    public static File getRealInternalFile(String str, String str2) {
        int length;
        File filesDir;
        if (TextUtils.isEmpty(str) || str.length() <= (length = str2.length()) || (filesDir = DownloadDirUtils.getFilesDir(DownloadComponentManager.getAppContext(), false)) == null) {
            return null;
        }
        String parent = filesDir.getParent();
        if (!str.startsWith(str2) || TextUtils.isEmpty(parent)) {
            return null;
        }
        return new File(parent, str.substring(length));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateCleanSetting(int i) {
        boolean z;
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "updateCleanSetting", "Run:" + i);
        }
        if (this.mCleanItemMaps.isEmpty() || this.mCleanItemMaps.get(Integer.valueOf(i)) == null || this.mCleanItemMaps.get(Integer.valueOf(i)).finish) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Integer, CleanItem> entry : this.mCleanItemMaps.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(DownloadSettingKeys.CacheCleaner.CLEAN_ID, entry.getKey());
                CleanItem value = entry.getValue();
                if (!value.finish && entry.getKey().intValue() != i) {
                    z = false;
                    value.finish = z;
                    jSONObject2.put(KEY_CLEAN_FINISH, value.finish);
                    if (!value.finish) {
                        jSONArray.put(jSONObject2);
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator<String> it = value.scenes.iterator();
                        while (it.hasNext()) {
                            jSONArray2.put(it.next());
                        }
                        jSONObject2.put(DownloadSettingKeys.CacheCleaner.MONITOR_SCENE_LIST, jSONArray2);
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<String> it2 = value.prefixUrls.iterator();
                        while (it2.hasNext()) {
                            jSONArray3.put(it2.next());
                        }
                        jSONObject2.put(DownloadSettingKeys.CacheCleaner.URL_PREFIX_LIST, jSONArray3);
                        JSONArray jSONArray4 = new JSONArray();
                        Iterator<String> it3 = value.savePaths.iterator();
                        while (it3.hasNext()) {
                            jSONArray4.put(it3.next());
                        }
                        jSONObject2.put(DownloadSettingKeys.CacheCleaner.SAVE_PATH_LIST, jSONArray4);
                        jSONArray.put(jSONObject2);
                    }
                }
                z = true;
                value.finish = z;
                jSONObject2.put(KEY_CLEAN_FINISH, value.finish);
                if (!value.finish) {
                }
            }
            jSONObject.put(DownloadSettingKeys.CacheCleaner.CLEAN_GROUP, jSONArray);
            putString(KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY, jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "updateCleanSetting", "Error:" + th);
        }
    }

    private SharedPreferences getDownloadCacheSp() {
        return DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0);
    }

    private String getString(String str) {
        try {
            return getDownloadCacheSp().getString(str, "");
        } catch (Throwable th) {
            Logger.globalError(TAG, "getString", "Error:" + th);
            return "";
        }
    }

    private void putString(String str, String str2) {
        try {
            getDownloadCacheSp().edit().putString(str, str2).apply();
        } catch (Throwable th) {
            Logger.globalError(TAG, "putString", "Error:" + th);
        }
    }

    private long getLong(String str) {
        try {
            return getDownloadCacheSp().getLong(str, 0L);
        } catch (Throwable th) {
            Logger.globalError(TAG, "getLong", "Error:" + th);
            return 0L;
        }
    }

    private void putLong(String str, long j) {
        try {
            getDownloadCacheSp().edit().putLong(str, j).apply();
        } catch (Throwable th) {
            Logger.globalError(TAG, "putLong", "Error:" + th);
        }
    }

    public void updateCacheReportTime() {
        putLong(KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME, System.currentTimeMillis());
    }

    public long getCacheLastReportTime() {
        return getLong(KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME);
    }

    public void updateCleanDirectoryTime() {
        putLong(KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME, System.currentTimeMillis());
    }

    public long getLastCleanDirectoryTime() {
        return getLong(KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public boolean isNeedClean() {
        return !this.mNeedCleanItemMaps.isEmpty();
    }

    public void clearData() {
        this.mCleanCacheKeyMaps.clear();
        this.mFileDirPathMap.clear();
        this.mFileNameMap.clear();
        this.mTempSavePath.clear();
        this.mOnlyCleanFileSet.clear();
        this.mCleanDownloadIdSet.clear();
    }

    public void finish() {
        this.mFinish = true;
        this.mCleanItemMaps.clear();
        this.mNeedCleanItemMaps.clear();
        clearData();
    }
}
