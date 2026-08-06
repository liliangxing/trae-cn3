package com.bytedance.sync.p005v4.presistence.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.p005v4.presistence.converter.BucketConverter;
import com.bytedance.sync.p005v4.presistence.converter.ConsumeTypeConverter;
import com.bytedance.sync.p005v4.presistence.converter.TopicTypeConverter;
import com.bytedance.sync.p005v4.presistence.table.Business;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.protocal.Bucket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BusinessDao_Impl implements BusinessDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Business> __insertionAdapterOfBusiness;
    private final EntityInsertionAdapter<SyncCursor> __insertionAdapterOfSyncCursor;
    private final SharedSQLiteStatement __preparedStmtOfResetAllCursor;
    private final SharedSQLiteStatement __preparedStmtOfResetCursor;
    private final SharedSQLiteStatement __preparedStmtOfUpdateReportCursor;
    private final SharedSQLiteStatement __preparedStmtOfUpdateReportCursor_1;

    public BusinessDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfBusiness = new EntityInsertionAdapter<Business>(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.BusinessDao_Impl.1
            public String createQuery() {
                return "INSERT OR REPLACE INTO `t_business` (`id`,`consume_type`,`bucket`) VALUES (?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Business business) {
                supportSQLiteStatement.bindLong(1, business.f234id);
                supportSQLiteStatement.bindLong(2, ConsumeTypeConverter.converterDate(business.consumeType));
                supportSQLiteStatement.bindLong(3, BucketConverter.converterDate(business.bucket));
            }
        };
        this.__insertionAdapterOfSyncCursor = new EntityInsertionAdapter<SyncCursor>(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.BusinessDao_Impl.2
            public String createQuery() {
                return "INSERT OR REPLACE INTO `t_sync_cursor` (`sync_id`,`did`,`uid`,`topic_type`,`bucket`,`recv_cursor`,`report_cursor`) VALUES (?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncCursor syncCursor) {
                if (syncCursor.syncId == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncCursor.syncId);
                }
                if (syncCursor.did == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, syncCursor.did);
                }
                if (syncCursor.uid == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, syncCursor.uid);
                }
                supportSQLiteStatement.bindLong(4, TopicTypeConverter.converterStatus(syncCursor.topicType));
                supportSQLiteStatement.bindLong(5, BucketConverter.converterDate(syncCursor.bucket));
                supportSQLiteStatement.bindLong(6, syncCursor.receiveCursor);
                supportSQLiteStatement.bindLong(7, syncCursor.reportCursor);
            }
        };
        this.__preparedStmtOfUpdateReportCursor = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.BusinessDao_Impl.3
            public String createQuery() {
                return "UPDATE t_sync_cursor SET report_cursor = ?,did=?,uid=?,bucket=? WHERE sync_id = ? ";
            }
        };
        this.__preparedStmtOfUpdateReportCursor_1 = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.BusinessDao_Impl.4
            public String createQuery() {
                return "UPDATE t_sync_cursor SET report_cursor = ? WHERE sync_id = ? ";
            }
        };
        this.__preparedStmtOfResetCursor = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.BusinessDao_Impl.5
            public String createQuery() {
                return "UPDATE t_sync_cursor SET recv_cursor = 0 WHERE sync_id=?";
            }
        };
        this.__preparedStmtOfResetAllCursor = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.BusinessDao_Impl.6
            public String createQuery() {
                return "UPDATE t_sync_cursor set recv_cursor = 0";
            }
        };
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public void insertBusiness(List<? extends Business> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBusiness.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public void insertSyncCursor(List<? extends SyncCursor> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSyncCursor.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public void updateReportCursor(String str, String str2, String str3, Bucket bucket, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateReportCursor.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        acquire.bindLong(4, BucketConverter.converterDate(bucket));
        if (str3 == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str3);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateReportCursor.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public int updateReportCursor(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateReportCursor_1.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateReportCursor_1.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public void resetCursor(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetCursor.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetCursor.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public void resetAllCursor() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetAllCursor.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetAllCursor.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public List<SyncCursor> queryCommonSyncCursorWithSyncIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_sync_cursor WHERE sync_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "topic_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "recv_cursor");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "report_cursor");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                SyncCursor syncCursor = new SyncCursor();
                if (query.isNull(columnIndexOrThrow)) {
                    syncCursor.syncId = null;
                } else {
                    syncCursor.syncId = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    syncCursor.did = null;
                } else {
                    syncCursor.did = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    syncCursor.uid = null;
                } else {
                    syncCursor.uid = query.getString(columnIndexOrThrow3);
                }
                syncCursor.topicType = TopicTypeConverter.revertTopicType(query.getInt(columnIndexOrThrow4));
                syncCursor.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow5));
                syncCursor.receiveCursor = query.getLong(columnIndexOrThrow6);
                syncCursor.reportCursor = query.getLong(columnIndexOrThrow7);
                arrayList.add(syncCursor);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public List<Business> queryBusinesses() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_business", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "consume_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Business business = new Business();
                business.f234id = query.getInt(columnIndexOrThrow);
                business.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow2));
                business.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow3));
                arrayList.add(business);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public List<SyncCursor> queryCommonSyncCursorWithDid(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_sync_cursor WHERE did = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "topic_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "recv_cursor");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "report_cursor");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                SyncCursor syncCursor = new SyncCursor();
                if (query.isNull(columnIndexOrThrow)) {
                    syncCursor.syncId = null;
                } else {
                    syncCursor.syncId = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    syncCursor.did = null;
                } else {
                    syncCursor.did = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    syncCursor.uid = null;
                } else {
                    syncCursor.uid = query.getString(columnIndexOrThrow3);
                }
                syncCursor.topicType = TopicTypeConverter.revertTopicType(query.getInt(columnIndexOrThrow4));
                syncCursor.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow5));
                syncCursor.receiveCursor = query.getLong(columnIndexOrThrow6);
                syncCursor.reportCursor = query.getLong(columnIndexOrThrow7);
                arrayList.add(syncCursor);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public SyncCursor queryCommonSyncCursorWithSyncId(long j) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_sync_cursor WHERE sync_id = ?", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        SyncCursor syncCursor = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "topic_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "recv_cursor");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "report_cursor");
            if (query.moveToFirst()) {
                SyncCursor syncCursor2 = new SyncCursor();
                if (query.isNull(columnIndexOrThrow)) {
                    syncCursor2.syncId = null;
                } else {
                    syncCursor2.syncId = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    syncCursor2.did = null;
                } else {
                    syncCursor2.did = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    syncCursor2.uid = null;
                } else {
                    syncCursor2.uid = query.getString(columnIndexOrThrow3);
                }
                syncCursor2.topicType = TopicTypeConverter.revertTopicType(query.getInt(columnIndexOrThrow4));
                syncCursor2.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow5));
                syncCursor2.receiveCursor = query.getLong(columnIndexOrThrow6);
                syncCursor2.reportCursor = query.getLong(columnIndexOrThrow7);
                syncCursor = syncCursor2;
            }
            return syncCursor;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public List<SyncCursor> queryAllCommonSyncCursors() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_sync_cursor", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "topic_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "recv_cursor");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "report_cursor");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                SyncCursor syncCursor = new SyncCursor();
                if (query.isNull(columnIndexOrThrow)) {
                    syncCursor.syncId = null;
                } else {
                    syncCursor.syncId = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    syncCursor.did = null;
                } else {
                    syncCursor.did = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    syncCursor.uid = null;
                } else {
                    syncCursor.uid = query.getString(columnIndexOrThrow3);
                }
                syncCursor.topicType = TopicTypeConverter.revertTopicType(query.getInt(columnIndexOrThrow4));
                syncCursor.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow5));
                syncCursor.receiveCursor = query.getLong(columnIndexOrThrow6);
                syncCursor.reportCursor = query.getLong(columnIndexOrThrow7);
                arrayList.add(syncCursor);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.BusinessDao
    public void deleteSyncCursor(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE from t_sync_cursor where sync_id in (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(newStringBuilder.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
