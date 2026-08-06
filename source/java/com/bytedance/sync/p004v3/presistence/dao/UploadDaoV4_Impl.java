package com.bytedance.sync.p004v3.presistence.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.p005v4.presistence.converter.BucketConverter;
import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
import com.bytedance.sync.p005v4.protocal.Bucket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UploadDaoV4_Impl implements UploadDaoV4 {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<UploadItemV4> __deletionAdapterOfUploadItemV4;
    private final EntityInsertionAdapter<UploadItemV4> __insertionAdapterOfUploadItemV4;
    private final EntityInsertionAdapter<UploadItemV4> __insertionAdapterOfUploadItemV4_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteUpStreamMsgIfBusinessNotExist;
    private final SharedSQLiteStatement __preparedStmtOfDeleteUploadData;
    private final EntityDeletionOrUpdateAdapter<UploadItemV4> __updateAdapterOfUploadItemV4;

    public UploadDaoV4_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUploadItemV4 = new EntityInsertionAdapter<UploadItemV4>(roomDatabase) { // from class: com.bytedance.sync.v3.presistence.dao.UploadDaoV4_Impl.1
            public String createQuery() {
                return "INSERT OR ABORT INTO `t_report_synclog` (`id`,`sync_id`,`business`,`did`,`uid`,`bucket`,`cursor`,`data`,`md5`,`msg_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UploadItemV4 uploadItemV4) {
                supportSQLiteStatement.bindLong(1, uploadItemV4.f235id);
                if (uploadItemV4.syncId == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, uploadItemV4.syncId);
                }
                supportSQLiteStatement.bindLong(3, uploadItemV4.business);
                if (uploadItemV4.did == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, uploadItemV4.did);
                }
                if (uploadItemV4.uid == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, uploadItemV4.uid);
                }
                supportSQLiteStatement.bindLong(6, BucketConverter.converterDate(uploadItemV4.bucket));
                supportSQLiteStatement.bindLong(7, uploadItemV4.cursor);
                if (uploadItemV4.data == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindBlob(8, uploadItemV4.data);
                }
                if (uploadItemV4.md5 == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, uploadItemV4.md5);
                }
                if (uploadItemV4.msg_id == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, uploadItemV4.msg_id);
                }
            }
        };
        this.__insertionAdapterOfUploadItemV4_1 = new EntityInsertionAdapter<UploadItemV4>(roomDatabase) { // from class: com.bytedance.sync.v3.presistence.dao.UploadDaoV4_Impl.2
            public String createQuery() {
                return "INSERT OR REPLACE INTO `t_report_synclog` (`id`,`sync_id`,`business`,`did`,`uid`,`bucket`,`cursor`,`data`,`md5`,`msg_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UploadItemV4 uploadItemV4) {
                supportSQLiteStatement.bindLong(1, uploadItemV4.f235id);
                if (uploadItemV4.syncId == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, uploadItemV4.syncId);
                }
                supportSQLiteStatement.bindLong(3, uploadItemV4.business);
                if (uploadItemV4.did == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, uploadItemV4.did);
                }
                if (uploadItemV4.uid == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, uploadItemV4.uid);
                }
                supportSQLiteStatement.bindLong(6, BucketConverter.converterDate(uploadItemV4.bucket));
                supportSQLiteStatement.bindLong(7, uploadItemV4.cursor);
                if (uploadItemV4.data == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindBlob(8, uploadItemV4.data);
                }
                if (uploadItemV4.md5 == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, uploadItemV4.md5);
                }
                if (uploadItemV4.msg_id == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, uploadItemV4.msg_id);
                }
            }
        };
        this.__deletionAdapterOfUploadItemV4 = new EntityDeletionOrUpdateAdapter<UploadItemV4>(roomDatabase) { // from class: com.bytedance.sync.v3.presistence.dao.UploadDaoV4_Impl.3
            public String createQuery() {
                return "DELETE FROM `t_report_synclog` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UploadItemV4 uploadItemV4) {
                supportSQLiteStatement.bindLong(1, uploadItemV4.f235id);
            }
        };
        this.__updateAdapterOfUploadItemV4 = new EntityDeletionOrUpdateAdapter<UploadItemV4>(roomDatabase) { // from class: com.bytedance.sync.v3.presistence.dao.UploadDaoV4_Impl.4
            public String createQuery() {
                return "UPDATE OR REPLACE `t_report_synclog` SET `id` = ?,`sync_id` = ?,`business` = ?,`did` = ?,`uid` = ?,`bucket` = ?,`cursor` = ?,`data` = ?,`md5` = ?,`msg_id` = ? WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UploadItemV4 uploadItemV4) {
                supportSQLiteStatement.bindLong(1, uploadItemV4.f235id);
                if (uploadItemV4.syncId == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, uploadItemV4.syncId);
                }
                supportSQLiteStatement.bindLong(3, uploadItemV4.business);
                if (uploadItemV4.did == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, uploadItemV4.did);
                }
                if (uploadItemV4.uid == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, uploadItemV4.uid);
                }
                supportSQLiteStatement.bindLong(6, BucketConverter.converterDate(uploadItemV4.bucket));
                supportSQLiteStatement.bindLong(7, uploadItemV4.cursor);
                if (uploadItemV4.data == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindBlob(8, uploadItemV4.data);
                }
                if (uploadItemV4.md5 == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, uploadItemV4.md5);
                }
                if (uploadItemV4.msg_id == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, uploadItemV4.msg_id);
                }
                supportSQLiteStatement.bindLong(11, uploadItemV4.f235id);
            }
        };
        this.__preparedStmtOfDeleteUpStreamMsgIfBusinessNotExist = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v3.presistence.dao.UploadDaoV4_Impl.5
            public String createQuery() {
                return "DELETE FROM t_report_synclog WHERE t_report_synclog.business not in (SELECT distinct id from t_business) ";
            }
        };
        this.__preparedStmtOfDeleteUploadData = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v3.presistence.dao.UploadDaoV4_Impl.6
            public String createQuery() {
                return "DELETE FROM t_report_synclog WHERE sync_id = ? AND cursor > 0 AND cursor <=?";
            }
        };
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public long insert(UploadItemV4 uploadItemV4) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfUploadItemV4.insertAndReturnId(uploadItemV4);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public void insert(List<? extends UploadItemV4> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfUploadItemV4_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public int deleteUploadDataList(List<? extends UploadItemV4> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__deletionAdapterOfUploadItemV4.handleMultiple(list) + 0;
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public int update(List<? extends UploadItemV4> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfUploadItemV4.handleMultiple(list) + 0;
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public void deleteUpStreamMsgIfBusinessNotExist() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteUpStreamMsgIfBusinessNotExist.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteUpStreamMsgIfBusinessNotExist.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public void deleteUploadData(long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteUploadData.acquire();
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteUploadData.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public List<UploadItemV4> queryUploadMsgByDeviceInfo(Bucket bucket, String str, int i) {
        Object obj;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_report_synclog WHERE cursor <= 0 and did = ? and business in (SELECT distinct id from t_business where bucket=?) ORDER BY id ASC LIMIT ?", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, BucketConverter.converterDate(bucket));
        acquire.bindLong(3, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "business");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "cursor");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "md5");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "msg_id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                UploadItemV4 uploadItemV4 = new UploadItemV4();
                int i2 = columnIndexOrThrow2;
                uploadItemV4.f235id = query.getLong(columnIndexOrThrow);
                if (query.isNull(i2)) {
                    uploadItemV4.syncId = null;
                } else {
                    uploadItemV4.syncId = query.getString(i2);
                }
                int i3 = columnIndexOrThrow;
                uploadItemV4.business = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    uploadItemV4.did = null;
                } else {
                    uploadItemV4.did = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    uploadItemV4.uid = null;
                } else {
                    uploadItemV4.uid = query.getString(columnIndexOrThrow5);
                }
                uploadItemV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow6));
                uploadItemV4.cursor = query.getLong(columnIndexOrThrow7);
                if (query.isNull(columnIndexOrThrow8)) {
                    uploadItemV4.data = null;
                } else {
                    uploadItemV4.data = query.getBlob(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    uploadItemV4.md5 = null;
                } else {
                    uploadItemV4.md5 = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    obj = null;
                    uploadItemV4.msg_id = null;
                } else {
                    obj = null;
                    uploadItemV4.msg_id = query.getString(columnIndexOrThrow10);
                }
                arrayList.add(uploadItemV4);
                columnIndexOrThrow2 = i2;
                columnIndexOrThrow = i3;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public List<UploadItemV4> queryUploadMsgByDeviceInfo(Bucket bucket, String str, String str2, int i) {
        Object obj;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_report_synclog WHERE cursor <= 0 and did = ? and uid = ? and business in (SELECT distinct id from t_business where bucket=?) ORDER BY id ASC LIMIT ?", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        acquire.bindLong(3, BucketConverter.converterDate(bucket));
        acquire.bindLong(4, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "business");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "cursor");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "md5");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "msg_id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                UploadItemV4 uploadItemV4 = new UploadItemV4();
                int i2 = columnIndexOrThrow2;
                uploadItemV4.f235id = query.getLong(columnIndexOrThrow);
                if (query.isNull(i2)) {
                    uploadItemV4.syncId = null;
                } else {
                    uploadItemV4.syncId = query.getString(i2);
                }
                int i3 = columnIndexOrThrow;
                uploadItemV4.business = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    uploadItemV4.did = null;
                } else {
                    uploadItemV4.did = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    uploadItemV4.uid = null;
                } else {
                    uploadItemV4.uid = query.getString(columnIndexOrThrow5);
                }
                uploadItemV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow6));
                uploadItemV4.cursor = query.getLong(columnIndexOrThrow7);
                if (query.isNull(columnIndexOrThrow8)) {
                    uploadItemV4.data = null;
                } else {
                    uploadItemV4.data = query.getBlob(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    uploadItemV4.md5 = null;
                } else {
                    uploadItemV4.md5 = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    obj = null;
                    uploadItemV4.msg_id = null;
                } else {
                    obj = null;
                    uploadItemV4.msg_id = query.getString(columnIndexOrThrow10);
                }
                arrayList.add(uploadItemV4);
                columnIndexOrThrow2 = i2;
                columnIndexOrThrow = i3;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4
    public List<UploadItemV4> queryDistributeMsgs(String str, int i) {
        Object obj;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_report_synclog WHERE cursor > 0 and sync_id=? ORDER BY cursor ASC LIMIT ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "business");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "cursor");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "md5");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "msg_id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                UploadItemV4 uploadItemV4 = new UploadItemV4();
                int i2 = columnIndexOrThrow2;
                uploadItemV4.f235id = query.getLong(columnIndexOrThrow);
                if (query.isNull(i2)) {
                    uploadItemV4.syncId = null;
                } else {
                    uploadItemV4.syncId = query.getString(i2);
                }
                int i3 = columnIndexOrThrow;
                uploadItemV4.business = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    uploadItemV4.did = null;
                } else {
                    uploadItemV4.did = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    uploadItemV4.uid = null;
                } else {
                    uploadItemV4.uid = query.getString(columnIndexOrThrow5);
                }
                uploadItemV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow6));
                uploadItemV4.cursor = query.getLong(columnIndexOrThrow7);
                if (query.isNull(columnIndexOrThrow8)) {
                    uploadItemV4.data = null;
                } else {
                    uploadItemV4.data = query.getBlob(columnIndexOrThrow8);
                }
                if (query.isNull(columnIndexOrThrow9)) {
                    uploadItemV4.md5 = null;
                } else {
                    uploadItemV4.md5 = query.getString(columnIndexOrThrow9);
                }
                if (query.isNull(columnIndexOrThrow10)) {
                    obj = null;
                    uploadItemV4.msg_id = null;
                } else {
                    obj = null;
                    uploadItemV4.msg_id = query.getString(columnIndexOrThrow10);
                }
                arrayList.add(uploadItemV4);
                columnIndexOrThrow2 = i2;
                columnIndexOrThrow = i3;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
