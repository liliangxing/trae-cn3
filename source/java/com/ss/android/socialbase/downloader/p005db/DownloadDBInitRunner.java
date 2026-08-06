package com.ss.android.socialbase.downloader.p005db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadDBInitRunner {
    private static final int NO_LIMIT = -1;
    private static final String TAG = "DownloadDBInitRunner";
    private List<DownloadInfo> mAutoResumeList;
    private SqlCacheLoadCompleteCallback mCallback;
    private ISqlCacheLoadCompleteCallbackAidl mCallbackAidl;
    private SparseArray<DownloadInfo> mCopyDownloadInfoMap;
    private SQLiteDatabase mDatabase;
    private DownloadDBInitInfo mDbInfo;
    private int mLruLimit = -1;
    private Set<Integer> mLruMemoryCacheId;
    private List<String> mMimeTypes;
    private int mSingleLoadCountLimit;
    private long mSingleLoadSleepTimeMs;
    private Set<Integer> mUnreadDBSet;

    public DownloadDBInitRunner(SQLiteDatabase sQLiteDatabase, DownloadDBInitInfo downloadDBInitInfo, SparseArray<DownloadInfo> sparseArray, Set<Integer> set, List<DownloadInfo> list, List<String> list2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback, ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl, int i, long j) {
        this.mDatabase = sQLiteDatabase;
        this.mDbInfo = downloadDBInitInfo;
        this.mCopyDownloadInfoMap = sparseArray;
        this.mUnreadDBSet = set;
        this.mAutoResumeList = list;
        this.mMimeTypes = list2;
        this.mCallback = sqlCacheLoadCompleteCallback;
        this.mCallbackAidl = iSqlCacheLoadCompleteCallbackAidl;
        this.mSingleLoadCountLimit = i;
        this.mSingleLoadSleepTimeMs = j;
    }

    public void start() {
        if (Logger.alog()) {
            Logger.globalDebug(TAG, "start", "Run Start");
        }
        try {
            startImpl();
        } finally {
            callbackDownloadInfo(true);
            this.mDbInfo.initDuration = System.currentTimeMillis() - this.mDbInfo.initDuration;
            DownloadMonitorHelper.monitorDownloadDB(this.mDbInfo);
            IDownloadDBListener downloadDBListener = DownloadComponentManager.getDownloadDBListener();
            if (downloadDBListener != null) {
                downloadDBListener.onInitFinish(this.mDbInfo);
            }
            if (Logger.alog()) {
                Logger.globalDebug(TAG, "start", "Run End");
            }
            DownloadBackgroundCleaner.startBackgroundCleaner();
        }
    }

    private void startImpl() {
        this.mDbInfo.diskCacheCount = -1;
        this.mDbInfo.diskCacheSize = -1L;
        if (this.mUnreadDBSet != null) {
            this.mLruLimit = SqlDownloadCache.DOWNLOAD_CACHE_LRU_CAPACITY_MAX;
            this.mLruMemoryCacheId = new HashSet();
        }
        loadNormalData();
        loadLruUnreadDBData();
    }

    private void loadNormalData() {
        String buildQuery = buildQuery("*", this.mLruLimit);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "loadNormalData", "Run sql:" + buildQuery);
        }
        handleDownloadInfoData(buildQuery);
    }

    private void loadLruUnreadDBData() {
        Set<Integer> set = this.mLruMemoryCacheId;
        if (set == null || set.size() < this.mLruLimit) {
            return;
        }
        String buildQuery = buildQuery("_id", -1);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "loadLruUnreadDBData", "Run sql:" + buildQuery);
        }
        handleUnreadDBIdData(buildQuery);
    }

    private String buildQuery(String str, int i) {
        StringBuilder sb = new StringBuilder("SELECT " + str + " FROM downloader");
        buildQueryString(sb, DBDefinition.MONITOR_SCENE, DownloadHelper.getDbInitSceneSet());
        buildQueryString(sb, DBDefinition.MIME_TYPE, DownloadHelper.getSkipDbInitExpectMimeTypeSet());
        if (i > 0) {
            sb.append(" LIMIT ");
            sb.append(i);
        }
        return sb.toString();
    }

    private void buildQueryString(StringBuilder sb, String str, Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if (sb.indexOf(" WHERE ") < 0) {
            sb.append(" WHERE " + str + " IN (");
        } else {
            sb.append(" OR " + str + " IN (");
        }
        for (String str2 : set) {
            sb.append("\"");
            sb.append(str2);
            sb.append("\",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
    }

    private void handleDownloadInfoData(String str) {
        DownloadInfo parsePartialDownloadInfo;
        List<String> list;
        DownloadHelper.SceneLruLimitInfo sceneLruLimitInfo;
        Cursor cursor = null;
        try {
            cursor = this.mDatabase.rawQuery(str, null);
            int count = cursor.getCount();
            this.mDbInfo.memoryCacheCount += count;
            if (Logger.alog()) {
                Logger.globalDebug(TAG, "handleDownloadInfoData", "Count:" + count);
            }
            SqlDownloadHelper.loadDownloadInfoIndex(cursor);
            DownloadInfo.setOptimizeMonitorLoad(true);
            Map<String, DownloadHelper.SceneLruLimitInfo> dbInitSceneLruLimitMap = DownloadHelper.getDbInitSceneLruLimitMap();
            while (true) {
                int i = 0;
                while (cursor.moveToNext()) {
                    if (dbInitSceneLruLimitMap == null) {
                        parsePartialDownloadInfo = SqlDownloadHelper.parsePartialDownloadInfo(cursor);
                    } else {
                        parsePartialDownloadInfo = new DownloadInfo();
                        boolean parseMonitorScene = SqlDownloadHelper.parseMonitorScene(cursor, parsePartialDownloadInfo);
                        String monitorScene = parsePartialDownloadInfo.getMonitorScene();
                        if (!TextUtils.isEmpty(monitorScene) && (sceneLruLimitInfo = dbInitSceneLruLimitMap.get(monitorScene)) != null) {
                            if (sceneLruLimitInfo.curCount <= sceneLruLimitInfo.limit) {
                                sceneLruLimitInfo.curCount++;
                            }
                        }
                        SqlDownloadHelper.parsePartialDownloadInfo(cursor, parsePartialDownloadInfo, parseMonitorScene);
                    }
                    SqlDownloadHelper.parseAllRemainingDownloadInfo(cursor, parsePartialDownloadInfo);
                    if (parsePartialDownloadInfo.isCanResumeFromBreakPointStatus()) {
                        parsePartialDownloadInfo.setDBInitStatus(parsePartialDownloadInfo.getStatus());
                        parsePartialDownloadInfo.setStatus(-5);
                    }
                    if (parsePartialDownloadInfo.getStatus() != -3 && parsePartialDownloadInfo.getStatus() != 11 && !parsePartialDownloadInfo.isFileDataValidOptimize()) {
                        parsePartialDownloadInfo.reset();
                    } else if (parsePartialDownloadInfo.getStatus() == 11) {
                        parsePartialDownloadInfo.setStatus(-5);
                    }
                    Set<Integer> set = this.mLruMemoryCacheId;
                    if (set != null) {
                        set.add(Integer.valueOf(parsePartialDownloadInfo.getId()));
                        if (this.mAutoResumeList != null && (list = this.mMimeTypes) != null && !list.isEmpty() && this.mMimeTypes.contains(parsePartialDownloadInfo.getMimeType()) && (DownloadSetting.obtain(parsePartialDownloadInfo).optInt("enable_notification_ui") >= 2 || parsePartialDownloadInfo.getRealStatus() != -2 || parsePartialDownloadInfo.isPauseReserveOnWifi())) {
                            this.mAutoResumeList.add(parsePartialDownloadInfo);
                        }
                    }
                    this.mCopyDownloadInfoMap.put(parsePartialDownloadInfo.getId(), parsePartialDownloadInfo);
                    int i2 = this.mSingleLoadCountLimit;
                    if (i2 > 0 && (i = i + 1) >= i2) {
                        break;
                    }
                }
                DownloadUtils.safeClose(cursor);
                return;
                callbackDownloadInfo(false);
            }
        } catch (Throwable th) {
            try {
                Logger.globalError(TAG, "handleDownloadInfoData", "Error:" + th);
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th2) {
                DownloadUtils.safeClose(cursor);
                throw th2;
            }
        }
    }

    private void handleUnreadDBIdData(String str) {
        Cursor cursor = null;
        try {
            cursor = this.mDatabase.rawQuery(str, null);
            if (Logger.alog()) {
                Logger.globalDebug(TAG, "handleUnreadDBIdData", "Count:" + cursor.getCount());
            }
            while (cursor.moveToNext()) {
                int parseDownloadId = SqlDownloadHelper.parseDownloadId(cursor);
                if (!this.mLruMemoryCacheId.contains(Integer.valueOf(parseDownloadId))) {
                    this.mUnreadDBSet.add(Integer.valueOf(parseDownloadId));
                }
            }
            DownloadUtils.safeClose(cursor);
        } catch (Throwable th) {
            try {
                Logger.globalError(TAG, "handleUnreadDBIdData", "Error:" + th);
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th2) {
                DownloadUtils.safeClose(cursor);
                throw th2;
            }
        }
    }

    private void callbackDownloadInfo(boolean z) {
        SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback = this.mCallback;
        if (sqlCacheLoadCompleteCallback != null) {
            sqlCacheLoadCompleteCallback.callback(z);
        }
        if (this.mCallbackAidl != null) {
            try {
                this.mCallbackAidl.callback(DownloadHelper.sparseArrayToHashMap(this.mCopyDownloadInfoMap), DownloadHelper.setConvertToList(this.mUnreadDBSet), DownloadHelper.listConvertToMap(this.mAutoResumeList), z);
            } catch (Throwable th) {
                Logger.globalError(TAG, "callbackDownloadInfo", "Error:" + th);
            }
        }
        this.mCopyDownloadInfoMap.clear();
        if (z) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "callbackDownloadInfo", "Finish");
            }
        } else if (this.mSingleLoadSleepTimeMs > 0) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "callbackDownloadInfo", "Sleep:" + this.mSingleLoadSleepTimeMs);
            }
            try {
                Thread.sleep(this.mSingleLoadSleepTimeMs);
            } catch (Throwable unused) {
            }
        }
    }
}
