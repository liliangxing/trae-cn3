package com.ss.android.socialbase.downloader.p005db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadDBHelper extends SQLiteOpenHelper {
    private static volatile DownloadDBHelper instance;
    private final String TAG;
    private boolean mIgnoreDuplicateColumn;
    private boolean tempDirSetted;

    public static DownloadDBHelper getInstance() {
        return getInstance(DBDefinition.DATABASE_NAME);
    }

    public static DownloadDBHelper getInstance(String str) {
        if (instance == null) {
            synchronized (DownloadDBHelper.class) {
                if (instance == null) {
                    instance = new DownloadDBHelper(str);
                }
            }
        }
        return instance;
    }

    private DownloadDBHelper(String str) {
        super(DownloadComponentManager.getAppContext(), str, (SQLiteDatabase.CursorFactory) null, 20);
        this.TAG = "DownloadDBHelper";
        this.tempDirSetted = false;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        Context appContext = DownloadComponentManager.getAppContext();
        if (!this.tempDirSetted && appContext != null) {
            try {
                File file = new File("/data/data/" + appContext.getPackageName() + "/database/main/");
                if (!file.exists()) {
                    file.mkdir();
                }
                super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");
                this.tempDirSetted = true;
            } catch (Exception e) {
                e.printStackTrace();
                Logger.globalError("DownloadDBHelper", "getReadableDatabase", "Error:" + e);
            }
            return super.getReadableDatabase();
        }
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (Logger.debug()) {
            Logger.globalDebug("DownloadDBHelper", "onCreate", "Run");
        }
        sQLiteDatabase.execSQL(DBDefinition.CREATE_DOWNLOAD_TABLE);
        sQLiteDatabase.execSQL(DBDefinition.CREATE_SEGMENT_TABLE);
        if (Logger.debug()) {
            Logger.globalDebug("DownloadDBHelper", "onCreate", "Run End");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        if (Build.VERSION.SDK_INT == 28) {
            sQLiteDatabase.disableWriteAheadLogging();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (Logger.debug()) {
            Logger.globalDebug("DownloadDBHelper", "onUpgrade", "Run OldVersion: " + i + " newVersion: " + i2);
        }
        try {
            onUpgradeImpl(sQLiteDatabase, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError("DownloadDBHelper", "onUpgrade", "Error:" + th);
            if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQLITE_UPGRADE_FAIL_DROP_TABLE) > 0) {
                dropAndCreateDBTable(sQLiteDatabase);
            } else {
                throw th;
            }
        }
        if (Logger.debug()) {
            Logger.globalDebug("DownloadDBHelper", "onUpgrade", "Run End");
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0044. Please report as an issue. */
    private void onUpgradeImpl(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.mIgnoreDuplicateColumn = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQLITE_UPGRADE_IGNORE_DUPLICATE_COLUMN) > 0;
        if (Logger.debug()) {
            Logger.globalDebug("DownloadDBHelper", "onUpgradeImpl", "OldVersion: " + i + " newVersion: " + i2 + " ignoreDuplicateColumn:" + this.mIgnoreDuplicateColumn);
        }
        switch (i) {
            case 1:
                addItem(sQLiteDatabase, "mimeType TEXT");
                addItem(sQLiteDatabase, "title TEXT");
                addItem(sQLiteDatabase, "notificationEnable INTEGER");
                addItem(sQLiteDatabase, "notificationVisibility INTEGER");
            case 2:
                addItem(sQLiteDatabase, "isFirstDownload INTEGER");
            case 3:
                addItem(sQLiteDatabase, "isFirstSuccess INTEGER");
            case 4:
                addItem(sQLiteDatabase, "needHttpsToHttpRetry INTEGER");
                addItem(sQLiteDatabase, "downloadTime INTEGER");
            case 5:
                addItem(sQLiteDatabase, "packageName TEXT");
                addItem(sQLiteDatabase, "md5 TEXT");
            case 6:
                addItem(sQLiteDatabase, "retryDelay INTEGER");
                addItem(sQLiteDatabase, "curRetryTime INTEGER");
                addItem(sQLiteDatabase, "retryDelayStatus INTEGER");
                addItem(sQLiteDatabase, "defaultHttpServiceBackUp INTEGER");
            case 7:
            case 8:
                addItem(sQLiteDatabase, "chunkRunnableReuse INTEGER");
            case 9:
                addItem(sQLiteDatabase, "retryDelayTimeArray TEXT");
            case 10:
                addItem(sQLiteDatabase, "chunkDowngradeRetry INTEGER");
                addItem(sQLiteDatabase, "backUpUrlsStr TEXT");
                addItem(sQLiteDatabase, "backUpUrlRetryCount INTEGER");
                addItem(sQLiteDatabase, "realDownloadTime INTEGER");
                addItem(sQLiteDatabase, "retryScheduleMinutes INTEGER");
                addItem(sQLiteDatabase, "independentProcess INTEGER");
            case 11:
                addItem(sQLiteDatabase, "auxiliaryJsonobjectString TEXT");
            case 12:
                addItem(sQLiteDatabase, "iconUrl TEXT");
                addItem(sQLiteDatabase, "appVersionCode INTEGER");
            case 13:
                sQLiteDatabase.execSQL(DBDefinition.CREATE_SEGMENT_TABLE);
            case 14:
                addItem(sQLiteDatabase, "taskId TEXT");
            case 15:
                addItem(sQLiteDatabase, "downloadStartTimeStamp INTEGER");
                addItem(sQLiteDatabase, "downloadFinishTimeStamp INTEGER");
                addItem(sQLiteDatabase, "installedTimeStamp INTEGER");
                addItem(sQLiteDatabase, "hasDoInstallation INTEGER");
            case 16:
                addItem(sQLiteDatabase, "cacheLifeTimeMax INTEGER");
            case 17:
                addItem(sQLiteDatabase, "pcdnUrlsStr TEXT");
                addItem(sQLiteDatabase, "cdnUrlsStr TEXT");
            case 18:
                addItem(sQLiteDatabase, "backCurBytes INTEGER");
                addItem(sQLiteDatabase, "realBackDownloadTime INTEGER");
            case 19:
                addItem(sQLiteDatabase, "monitorScene TEXT");
                return;
            default:
                return;
        }
    }

    private void addItem(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE downloader ADD " + str);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.globalError("DownloadDBHelper", "addItem", "Error:" + e);
            if (!this.mIgnoreDuplicateColumn) {
                throw e;
            }
            String message = e.getMessage();
            if (!TextUtils.isEmpty(message) && message.contains("duplicate column")) {
                Logger.globalError("DownloadDBHelper", "addItem", "duplicate column");
                return;
            }
            throw e;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (Logger.debug()) {
            Logger.globalDebug("DownloadDBHelper", "onDowngrade", "OldVersion: " + i + " newVersion: " + i2);
        }
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SUPPORT_SQLITE_DOWNGRADE) > 0) {
            dropAndCreateDBTable(sQLiteDatabase);
        }
    }

    private void dropAndCreateDBTable(SQLiteDatabase sQLiteDatabase) {
        if (Logger.debug()) {
            Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Run");
        }
        try {
            sQLiteDatabase.execSQL(DBDefinition.DROP_DOWNLOAD_TABLE);
            sQLiteDatabase.execSQL(DBDefinition.DROP_SEGMENT_TABLE);
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Error: " + th);
        }
        onCreate(sQLiteDatabase);
        if (Logger.debug()) {
            Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Run End");
        }
    }
}
