package com.ss.android.socialbase.downloader.p005db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ss.android.socialbase.downloader.cleaner.CacheKeyCleaner;
import com.ss.android.socialbase.downloader.cleaner.CleanDownloadInfo;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadBackgroundCleaner {
    private static final String TAG = "DownloadBackgroundCleaner";
    private static IMemoryListener sMemoryListener;
    private static AtomicBoolean sRunCleaner = new AtomicBoolean(false);
    private static boolean sHighMemoryStop = false;

    private static String getCleanDownloadInfoSql() {
        return "SELECT _id,name,savePath,tempPath,monitorScene,url FROM downloader WHERE cacheLifeTimeMax = 0 ";
    }

    public static void setDownloadMemoryListener(IMemoryListener iMemoryListener) {
        if (sMemoryListener == null) {
            return;
        }
        sMemoryListener = iMemoryListener;
    }

    private static boolean isEnabled(AppStatusManager appStatusManager) {
        IMemoryListener iMemoryListener;
        if (appStatusManager.isAppForeground()) {
            if (Logger.alog()) {
                Logger.globalDebug(TAG, "startCleanerImpl", "AppForeground");
            }
            return false;
        }
        if (!sHighMemoryStop || (iMemoryListener = sMemoryListener) == null || iMemoryListener.getMemoryLevel() < 3) {
            return true;
        }
        if (Logger.alog()) {
            Logger.globalDebug(TAG, "startCleanerImpl", "High Memory:" + sMemoryListener.getMemoryLevel());
        }
        return false;
    }

    public static void startBackgroundCleaner() {
        final int optInt;
        final int optInt2;
        if (DownloadComponentManager.getAppContext() == null || !DownloadHelper.isMainProcess() || !Cleaner.getInstance().getCleanerConfig().checkTimeInterval() || (optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.RUN_CLEANER_BACKGROUND_DELAY_TIME_S)) <= 0 || (optInt2 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CLEANER_BACKGROUND_SINGLE_LOAD_COUNT_LIMIT)) <= 0) {
            return;
        }
        final long optLong = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.CLEANER_BACKGROUND_SINGLE_LOAD_SLEEP_TIME_MS);
        if (optLong <= 0) {
            return;
        }
        final AppStatusManager appStatusManager = AppStatusManager.getInstance();
        appStatusManager.init(DownloadComponentManager.getAppContext());
        appStatusManager.registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.socialbase.downloader.db.DownloadBackgroundCleaner.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
                if (DownloadBackgroundCleaner.sRunCleaner.compareAndSet(false, true)) {
                    AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                    DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.DownloadBackgroundCleaner.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadBackgroundCleaner.startCleanerImpl(optInt2, optLong, appStatusManager);
                        }
                    }, optInt, TimeUnit.SECONDS);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startCleanerImpl(int i, long j, AppStatusManager appStatusManager) {
        SQLiteDatabase database;
        sHighMemoryStop = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CLEANER_BACKGROUND_HIGH_MEMORY_STOP) > 0;
        if (isEnabled(appStatusManager)) {
            IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
            if (downloadCache instanceof DefaultDownloadCache) {
                ISqlDownloadCache sqlDownloadCache = ((DefaultDownloadCache) downloadCache).getSqlDownloadCache();
                if ((sqlDownloadCache == null || (sqlDownloadCache instanceof SqlDownloadCache)) && (database = ((SqlDownloadCache) sqlDownloadCache).getDatabase()) != null) {
                    Cleaner cleaner = Cleaner.getInstance();
                    CacheKeyCleaner cacheKeyCleaner = cleaner.getCacheKeyCleaner();
                    forceCleanImpl(database, cleaner, cacheKeyCleaner, i, j, appStatusManager);
                    normalCleanImpl(database, cleaner, cacheKeyCleaner, i, j, appStatusManager);
                    cacheKeyCleaner.finish();
                    if (Logger.alog()) {
                        Logger.globalDebug(TAG, "startCleanerImpl", "End");
                    }
                }
            }
        }
    }

    private static void forceCleanImpl(SQLiteDatabase sQLiteDatabase, Cleaner cleaner, CacheKeyCleaner cacheKeyCleaner, int i, long j, AppStatusManager appStatusManager) {
        if (isEnabled(appStatusManager)) {
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery(getForceCleanDownloadInfoSql(), null);
                if (Logger.alog()) {
                    Logger.globalDebug(TAG, "forceCleanImpl", "Force Clean Count:" + cursor.getCount());
                }
                int columnIndex = cursor.getColumnIndex("_id");
                int columnIndex2 = cursor.getColumnIndex("name");
                int columnIndex3 = cursor.getColumnIndex(DBDefinition.SAVE_PATH);
                int columnIndex4 = cursor.getColumnIndex(DBDefinition.TEMP_PATH);
                while (true) {
                    int i2 = 0;
                    while (cursor.moveToNext()) {
                        CleanDownloadInfo cleanDownloadInfo = new CleanDownloadInfo();
                        cleanDownloadInfo.setId(cursor.getInt(columnIndex));
                        cleanDownloadInfo.setName(cursor.getString(columnIndex2));
                        cleanDownloadInfo.setSavePath(cursor.getString(columnIndex3));
                        cleanDownloadInfo.setTempPath(cursor.getString(columnIndex4));
                        cleaner.forceUpdateCleanDownloadId(cleanDownloadInfo, false);
                        i2++;
                        if (i2 > i) {
                            if (isEnabled(appStatusManager)) {
                                cacheKeyCleaner.batchStart();
                                if (Logger.debug()) {
                                    Logger.globalDebug(TAG, "forceCleanImpl", "Sleep:" + j);
                                }
                                Thread.sleep(j);
                            } else {
                                DownloadUtils.safeClose(cursor);
                                return;
                            }
                        }
                    }
                    Thread.sleep(j);
                    cacheKeyCleaner.batchStart();
                    DownloadUtils.safeClose(cursor);
                    return;
                }
            } catch (Throwable th) {
                try {
                    Logger.globalError(TAG, "forceCleanImpl", "Error:" + th);
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
    }

    private static void normalCleanImpl(SQLiteDatabase sQLiteDatabase, Cleaner cleaner, CacheKeyCleaner cacheKeyCleaner, int i, long j, AppStatusManager appStatusManager) {
        if (isEnabled(appStatusManager)) {
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery(getCleanDownloadInfoSql(), null);
                if (Logger.alog()) {
                    Logger.globalDebug(TAG, "normalCleanImpl", "Normal Clean Count:" + cursor.getCount());
                }
                int columnIndex = cursor.getColumnIndex("_id");
                int columnIndex2 = cursor.getColumnIndex("name");
                int columnIndex3 = cursor.getColumnIndex(DBDefinition.SAVE_PATH);
                int columnIndex4 = cursor.getColumnIndex(DBDefinition.TEMP_PATH);
                int columnIndex5 = cursor.getColumnIndex(DBDefinition.MONITOR_SCENE);
                int columnIndex6 = cursor.getColumnIndex("url");
                while (true) {
                    int i2 = 0;
                    while (cursor.moveToNext()) {
                        CleanDownloadInfo cleanDownloadInfo = new CleanDownloadInfo();
                        cleanDownloadInfo.setId(cursor.getInt(columnIndex));
                        cleanDownloadInfo.setName(cursor.getString(columnIndex2));
                        cleanDownloadInfo.setSavePath(cursor.getString(columnIndex3));
                        cleanDownloadInfo.setTempPath(cursor.getString(columnIndex4));
                        cleanDownloadInfo.setMonitorScene(cursor.getString(columnIndex5));
                        cleanDownloadInfo.setUrl(cursor.getString(columnIndex6));
                        cleaner.updateCleanDownloadId(cleanDownloadInfo);
                        i2++;
                        if (i2 > i) {
                            if (isEnabled(appStatusManager)) {
                                cacheKeyCleaner.batchStart();
                                if (Logger.debug()) {
                                    Logger.globalDebug(TAG, "normalCleanImpl", "Sleep:" + j);
                                }
                                Thread.sleep(j);
                            } else {
                                DownloadUtils.safeClose(cursor);
                                return;
                            }
                        }
                    }
                    Thread.sleep(j);
                    cacheKeyCleaner.batchStart();
                    DownloadUtils.safeClose(cursor);
                    return;
                }
            } catch (Throwable th) {
                try {
                    Logger.globalError(TAG, "normalCleanImpl", "Error:" + th);
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
    }

    private static String getForceCleanDownloadInfoSql() {
        StringBuilder sb = new StringBuilder("SELECT _id,name,savePath,tempPath FROM downloader WHERE ");
        long currentTimeMillis = System.currentTimeMillis();
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_CHECK_CACHE_ENABLE, 0) > 0) {
            sb.append("(cacheLifeTimeMax > 0 AND downloadStartTimeStamp > 0 AND (downloadStartTimeStamp+cacheLifeTimeMax*1000 ) < ");
            sb.append(currentTimeMillis);
            sb.append(") OR ");
        }
        long optLong = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.INCOMPLETE_FILE_EXPIRED_TIME);
        if (optLong > 0) {
            sb.append("(status != -3 AND downloadStartTimeStamp > 0 AND  downloadStartTimeStamp<");
            sb.append(currentTimeMillis - (optLong * 1000));
            sb.append(") OR ");
        }
        sb.append(" (status = 1 AND curBytes <= 0)");
        return sb.toString();
    }
}
