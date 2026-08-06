package com.bytedance.sync.p005v4.presistence;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4;
import com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4_Impl;
import com.bytedance.sync.p005v4.presistence.dao.BusinessDao;
import com.bytedance.sync.p005v4.presistence.dao.BusinessDao_Impl;
import com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4;
import com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4_Impl;
import com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4;
import com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppDatabaseV4_Impl extends AppDatabaseV4 {
    private volatile BusinessDao _businessDao;
    private volatile HistoryDaoV4 _historyDaoV4;
    private volatile SyncDaoV4 _syncDaoV4;
    private volatile UploadDaoV4 _uploadDaoV4;

    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.bytedance.sync.v4.presistence.AppDatabaseV4_Impl.1
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_business` (`id` INTEGER NOT NULL, `consume_type` INTEGER, `bucket` INTEGER, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_report_synclog` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sync_id` TEXT, `business` INTEGER NOT NULL, `did` TEXT, `uid` TEXT, `bucket` INTEGER, `cursor` INTEGER NOT NULL, `data` BLOB, `md5` TEXT, `msg_id` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_sync_cursor` (`sync_id` TEXT NOT NULL, `did` TEXT, `uid` TEXT, `topic_type` INTEGER, `bucket` INTEGER, `recv_cursor` INTEGER NOT NULL, `report_cursor` INTEGER NOT NULL, PRIMARY KEY(`sync_id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_synclog` (`sync_id` TEXT NOT NULL, `did` TEXT, `uid` TEXT, `sync_cursor` INTEGER NOT NULL, `data` BLOB, `md5` TEXT, `business` INTEGER NOT NULL, `consume_type` INTEGER, `data_type` INTEGER, `publish_ts` INTEGER NOT NULL, `receive_ts` INTEGER NOT NULL, `bucket` INTEGER, `req_id` TEXT, `topic_type` INTEGER NOT NULL, `packet_status` INTEGER NOT NULL, `expire_ts` INTEGER NOT NULL, `packet_ctrl` INTEGER NOT NULL, `extra` TEXT, PRIMARY KEY(`sync_id`, `sync_cursor`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_snapshot` (`sync_id` TEXT NOT NULL, `business` INTEGER NOT NULL, `uid` TEXT, `did` TEXT, `cursor` INTEGER NOT NULL, `data` BLOB, `notified` INTEGER NOT NULL, `bucket` INTEGER, `data_type` INTEGER, `publish_ts` INTEGER NOT NULL, `receive_ts` INTEGER NOT NULL, `consume_type` INTEGER, `patch_cnt` INTEGER NOT NULL, PRIMARY KEY(`sync_id`, `business`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_history_synclog` (`sync_id` TEXT NOT NULL, `did` TEXT, `uid` TEXT, `sync_cursor` INTEGER NOT NULL, `data` BLOB, `md5` TEXT, `business` INTEGER NOT NULL, `consume_type` INTEGER, `data_type` INTEGER, `publish_ts` INTEGER NOT NULL, `receive_ts` INTEGER NOT NULL, `bucket` INTEGER, `req_id` TEXT, `topic_type` INTEGER, `packet_status` INTEGER, `expire_ts` INTEGER NOT NULL, `packet_ctrl` INTEGER NOT NULL, `extra` TEXT, PRIMARY KEY(`sync_id`, `sync_cursor`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6d03e4e34642405367b0801527728f44')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_business`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_report_synclog`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_sync_cursor`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_synclog`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_snapshot`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `t_history_synclog`");
                if (AppDatabaseV4_Impl.this.mCallbacks != null) {
                    int size = AppDatabaseV4_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabaseV4_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (AppDatabaseV4_Impl.this.mCallbacks != null) {
                    int size = AppDatabaseV4_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabaseV4_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                AppDatabaseV4_Impl.this.mDatabase = supportSQLiteDatabase;
                AppDatabaseV4_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (AppDatabaseV4_Impl.this.mCallbacks != null) {
                    int size = AppDatabaseV4_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabaseV4_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("consume_type", new TableInfo.Column("consume_type", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("t_business", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "t_business");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "t_business(com.bytedance.sync.v4.presistence.table.Business).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(10);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap2.put("sync_id", new TableInfo.Column("sync_id", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("business", new TableInfo.Column("business", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("did", new TableInfo.Column("did", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("uid", new TableInfo.Column("uid", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0, (String) null, 1));
                hashMap2.put("cursor", new TableInfo.Column("cursor", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("data", new TableInfo.Column("data", "BLOB", false, 0, (String) null, 1));
                hashMap2.put("md5", new TableInfo.Column("md5", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("msg_id", new TableInfo.Column("msg_id", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("t_report_synclog", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "t_report_synclog");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "t_report_synclog(com.bytedance.sync.v4.presistence.table.UploadItemV4).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(7);
                hashMap3.put("sync_id", new TableInfo.Column("sync_id", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("did", new TableInfo.Column("did", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("uid", new TableInfo.Column("uid", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("topic_type", new TableInfo.Column("topic_type", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("recv_cursor", new TableInfo.Column("recv_cursor", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("report_cursor", new TableInfo.Column("report_cursor", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("t_sync_cursor", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "t_sync_cursor");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "t_sync_cursor(com.bytedance.sync.v4.presistence.table.SyncCursor).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(18);
                hashMap4.put("sync_id", new TableInfo.Column("sync_id", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("did", new TableInfo.Column("did", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("uid", new TableInfo.Column("uid", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("sync_cursor", new TableInfo.Column("sync_cursor", "INTEGER", true, 2, (String) null, 1));
                hashMap4.put("data", new TableInfo.Column("data", "BLOB", false, 0, (String) null, 1));
                hashMap4.put("md5", new TableInfo.Column("md5", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("business", new TableInfo.Column("business", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("consume_type", new TableInfo.Column("consume_type", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("data_type", new TableInfo.Column("data_type", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("publish_ts", new TableInfo.Column("publish_ts", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("receive_ts", new TableInfo.Column("receive_ts", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("req_id", new TableInfo.Column("req_id", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("topic_type", new TableInfo.Column("topic_type", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("packet_status", new TableInfo.Column("packet_status", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("expire_ts", new TableInfo.Column("expire_ts", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("packet_ctrl", new TableInfo.Column("packet_ctrl", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("extra", new TableInfo.Column("extra", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo4 = new TableInfo("t_synclog", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "t_synclog");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "t_synclog(com.bytedance.sync.v4.presistence.table.SyncLogV4).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(13);
                hashMap5.put("sync_id", new TableInfo.Column("sync_id", "TEXT", true, 1, (String) null, 1));
                hashMap5.put("business", new TableInfo.Column("business", "INTEGER", true, 2, (String) null, 1));
                hashMap5.put("uid", new TableInfo.Column("uid", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("did", new TableInfo.Column("did", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("cursor", new TableInfo.Column("cursor", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("data", new TableInfo.Column("data", "BLOB", false, 0, (String) null, 1));
                hashMap5.put("notified", new TableInfo.Column("notified", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("data_type", new TableInfo.Column("data_type", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("publish_ts", new TableInfo.Column("publish_ts", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("receive_ts", new TableInfo.Column("receive_ts", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("consume_type", new TableInfo.Column("consume_type", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("patch_cnt", new TableInfo.Column("patch_cnt", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo5 = new TableInfo("t_snapshot", hashMap5, new HashSet(0), new HashSet(0));
                TableInfo read5 = TableInfo.read(supportSQLiteDatabase, "t_snapshot");
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "t_snapshot(com.bytedance.sync.v4.presistence.table.Snapshot).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(18);
                hashMap6.put("sync_id", new TableInfo.Column("sync_id", "TEXT", true, 1, (String) null, 1));
                hashMap6.put("did", new TableInfo.Column("did", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("uid", new TableInfo.Column("uid", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("sync_cursor", new TableInfo.Column("sync_cursor", "INTEGER", true, 2, (String) null, 1));
                hashMap6.put("data", new TableInfo.Column("data", "BLOB", false, 0, (String) null, 1));
                hashMap6.put("md5", new TableInfo.Column("md5", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("business", new TableInfo.Column("business", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("consume_type", new TableInfo.Column("consume_type", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("data_type", new TableInfo.Column("data_type", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("publish_ts", new TableInfo.Column("publish_ts", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("receive_ts", new TableInfo.Column("receive_ts", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("req_id", new TableInfo.Column("req_id", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("topic_type", new TableInfo.Column("topic_type", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("packet_status", new TableInfo.Column("packet_status", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("expire_ts", new TableInfo.Column("expire_ts", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("packet_ctrl", new TableInfo.Column("packet_ctrl", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("extra", new TableInfo.Column("extra", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo6 = new TableInfo("t_history_synclog", hashMap6, new HashSet(0), new HashSet(0));
                TableInfo read6 = TableInfo.read(supportSQLiteDatabase, "t_history_synclog");
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "t_history_synclog(com.bytedance.sync.v4.presistence.table.SyncHistoryLogV4).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "6d03e4e34642405367b0801527728f44", "3d169a4e9b45d6f96877cb9348070b8e")).build());
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"t_business", "t_report_synclog", "t_sync_cursor", "t_synclog", "t_snapshot", "t_history_synclog"});
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `t_business`");
            writableDatabase.execSQL("DELETE FROM `t_report_synclog`");
            writableDatabase.execSQL("DELETE FROM `t_sync_cursor`");
            writableDatabase.execSQL("DELETE FROM `t_synclog`");
            writableDatabase.execSQL("DELETE FROM `t_snapshot`");
            writableDatabase.execSQL("DELETE FROM `t_history_synclog`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(BusinessDao.class, BusinessDao_Impl.getRequiredConverters());
        hashMap.put(SyncDaoV4.class, SyncDaoV4_Impl.getRequiredConverters());
        hashMap.put(UploadDaoV4.class, UploadDaoV4_Impl.getRequiredConverters());
        hashMap.put(HistoryDaoV4.class, HistoryDaoV4_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // com.bytedance.sync.p005v4.presistence.AppDatabaseV4
    public BusinessDao businessDao() {
        BusinessDao businessDao;
        if (this._businessDao != null) {
            return this._businessDao;
        }
        synchronized (this) {
            if (this._businessDao == null) {
                this._businessDao = new BusinessDao_Impl(this);
            }
            businessDao = this._businessDao;
        }
        return businessDao;
    }

    @Override // com.bytedance.sync.p005v4.presistence.AppDatabaseV4
    public SyncDaoV4 syncDao() {
        SyncDaoV4 syncDaoV4;
        if (this._syncDaoV4 != null) {
            return this._syncDaoV4;
        }
        synchronized (this) {
            if (this._syncDaoV4 == null) {
                this._syncDaoV4 = new SyncDaoV4_Impl(this);
            }
            syncDaoV4 = this._syncDaoV4;
        }
        return syncDaoV4;
    }

    @Override // com.bytedance.sync.p005v4.presistence.AppDatabaseV4
    public UploadDaoV4 upStreamDao() {
        UploadDaoV4 uploadDaoV4;
        if (this._uploadDaoV4 != null) {
            return this._uploadDaoV4;
        }
        synchronized (this) {
            if (this._uploadDaoV4 == null) {
                this._uploadDaoV4 = new UploadDaoV4_Impl(this);
            }
            uploadDaoV4 = this._uploadDaoV4;
        }
        return uploadDaoV4;
    }

    @Override // com.bytedance.sync.p005v4.presistence.AppDatabaseV4
    public HistoryDaoV4 historyDao() {
        HistoryDaoV4 historyDaoV4;
        if (this._historyDaoV4 != null) {
            return this._historyDaoV4;
        }
        synchronized (this) {
            if (this._historyDaoV4 == null) {
                this._historyDaoV4 = new HistoryDaoV4_Impl(this);
            }
            historyDaoV4 = this._historyDaoV4;
        }
        return historyDaoV4;
    }
}
