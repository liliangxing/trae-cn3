package com.bytedance.sync.p005v4.presistence.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
import com.bytedance.sync.p005v4.presistence.converter.DataTypeConverter;
import com.bytedance.sync.p005v4.presistence.converter.ExtraConverter;
import com.bytedance.sync.p005v4.presistence.converter.PacketCtrlConverter;
import com.bytedance.sync.p005v4.presistence.converter.PacketStatusConverter;
import com.bytedance.sync.p005v4.presistence.converter.TopicTypeConverter;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.protocal.ConsumeType;
import com.bytedance.sync.p005v4.protocal.PacketStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SyncDaoV4_Impl implements SyncDaoV4 {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SyncLogV4> __deletionAdapterOfSyncLogV4;
    private final EntityInsertionAdapter<Snapshot> __insertionAdapterOfSnapshot;
    private final EntityInsertionAdapter<SyncLogV4> __insertionAdapterOfSyncLogV4;
    private final SharedSQLiteStatement __preparedStmtOfDeleteExpireSyncLog;
    private final SharedSQLiteStatement __preparedStmtOfDeleteSnapshot;
    private final SharedSQLiteStatement __preparedStmtOfDeleteSyncId;

    public SyncDaoV4_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSyncLogV4 = new EntityInsertionAdapter<SyncLogV4>(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.SyncDaoV4_Impl.1
            public String createQuery() {
                return "INSERT OR REPLACE INTO `t_synclog` (`sync_id`,`did`,`uid`,`sync_cursor`,`data`,`md5`,`business`,`consume_type`,`data_type`,`publish_ts`,`receive_ts`,`bucket`,`req_id`,`topic_type`,`packet_status`,`expire_ts`,`packet_ctrl`,`extra`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncLogV4 syncLogV4) {
                if (syncLogV4.syncId == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncLogV4.syncId);
                }
                if (syncLogV4.did == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, syncLogV4.did);
                }
                if (syncLogV4.uid == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, syncLogV4.uid);
                }
                supportSQLiteStatement.bindLong(4, syncLogV4.syncCursor);
                if (syncLogV4.data == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, syncLogV4.data);
                }
                if (syncLogV4.md5 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, syncLogV4.md5);
                }
                supportSQLiteStatement.bindLong(7, syncLogV4.business);
                supportSQLiteStatement.bindLong(8, ConsumeTypeConverter.converterDate(syncLogV4.consumeType));
                supportSQLiteStatement.bindLong(9, DataTypeConverter.converterDate(syncLogV4.dataType));
                supportSQLiteStatement.bindLong(10, syncLogV4.publishTs);
                supportSQLiteStatement.bindLong(11, syncLogV4.receiveTs);
                supportSQLiteStatement.bindLong(12, BucketConverter.converterDate(syncLogV4.bucket));
                if (syncLogV4.reqId == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, syncLogV4.reqId);
                }
                supportSQLiteStatement.bindLong(14, TopicTypeConverter.converterStatus(syncLogV4.topicType));
                supportSQLiteStatement.bindLong(15, PacketStatusConverter.converterStatus(syncLogV4.packetStatus));
                supportSQLiteStatement.bindLong(16, syncLogV4.expireTs);
                supportSQLiteStatement.bindLong(17, PacketCtrlConverter.converterStatus(syncLogV4.packetCtrl));
                String converterStatus = ExtraConverter.converterStatus(syncLogV4.extra);
                if (converterStatus == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, converterStatus);
                }
            }
        };
        this.__insertionAdapterOfSnapshot = new EntityInsertionAdapter<Snapshot>(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.SyncDaoV4_Impl.2
            public String createQuery() {
                return "INSERT OR REPLACE INTO `t_snapshot` (`sync_id`,`business`,`uid`,`did`,`cursor`,`data`,`notified`,`bucket`,`data_type`,`publish_ts`,`receive_ts`,`consume_type`,`patch_cnt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Snapshot snapshot) {
                if (snapshot.syncId == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, snapshot.syncId);
                }
                supportSQLiteStatement.bindLong(2, snapshot.business);
                if (snapshot.uid == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, snapshot.uid);
                }
                if (snapshot.did == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, snapshot.did);
                }
                supportSQLiteStatement.bindLong(5, snapshot.cursor);
                if (snapshot.data == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, snapshot.data);
                }
                supportSQLiteStatement.bindLong(7, snapshot.notified);
                supportSQLiteStatement.bindLong(8, BucketConverter.converterDate(snapshot.bucket));
                supportSQLiteStatement.bindLong(9, DataTypeConverter.converterDate(snapshot.dataType));
                supportSQLiteStatement.bindLong(10, snapshot.publishTs);
                supportSQLiteStatement.bindLong(11, snapshot.receiveTs);
                supportSQLiteStatement.bindLong(12, ConsumeTypeConverter.converterDate(snapshot.consumeType));
                supportSQLiteStatement.bindLong(13, snapshot.patchCnt);
            }
        };
        this.__deletionAdapterOfSyncLogV4 = new EntityDeletionOrUpdateAdapter<SyncLogV4>(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.SyncDaoV4_Impl.3
            public String createQuery() {
                return "DELETE FROM `t_synclog` WHERE `sync_id` = ? AND `sync_cursor` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncLogV4 syncLogV4) {
                if (syncLogV4.syncId == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncLogV4.syncId);
                }
                supportSQLiteStatement.bindLong(2, syncLogV4.syncCursor);
            }
        };
        this.__preparedStmtOfDeleteSyncId = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.SyncDaoV4_Impl.4
            public String createQuery() {
                return "DELETE FROM t_synclog WHERE sync_id = ?";
            }
        };
        this.__preparedStmtOfDeleteSnapshot = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.SyncDaoV4_Impl.5
            public String createQuery() {
                return "DELETE FROM t_snapshot WHERE sync_id = ?";
            }
        };
        this.__preparedStmtOfDeleteExpireSyncLog = new SharedSQLiteStatement(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.SyncDaoV4_Impl.6
            public String createQuery() {
                return "DELETE FROM t_synclog WHERE expire_ts < ?";
            }
        };
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public void insertSyncLogs(ArrayList<SyncLogV4> arrayList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSyncLogV4.insert(arrayList);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public long insertOrReplaceSnapshot(Snapshot snapshot) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfSnapshot.insertAndReturnId(snapshot);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public void changeSnapshotToNotified(Snapshot snapshot) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSnapshot.insert(snapshot);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public int delete(List<? extends SyncLogV4> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__deletionAdapterOfSyncLogV4.handleMultiple(list) + 0;
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public void deleteSyncId(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteSyncId.acquire();
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
            this.__preparedStmtOfDeleteSyncId.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public void deleteSnapshot(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteSnapshot.acquire();
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
            this.__preparedStmtOfDeleteSnapshot.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public void deleteExpireSyncLog(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteExpireSyncLog.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteExpireSyncLog.release(acquire);
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public List<SyncLogV4> queryAllLogs(Set<Long> set, PacketStatus packetStatus, int i, int i2, long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        String string;
        int i3;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM t_synclog WHERE sync_id in (");
        int size = set.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") AND packet_status =");
        newStringBuilder.append("?");
        newStringBuilder.append(" AND expire_ts >= (");
        newStringBuilder.append("?");
        newStringBuilder.append(") ORDER BY sync_id, business, sync_cursor ASC LIMIT ");
        newStringBuilder.append("?");
        newStringBuilder.append(" offset ");
        newStringBuilder.append("?");
        int i4 = size + 4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), i4);
        int i5 = 1;
        for (Long l : set) {
            if (l == null) {
                acquire.bindNull(i5);
            } else {
                acquire.bindLong(i5, l.longValue());
            }
            i5++;
        }
        acquire.bindLong(size + 1, PacketStatusConverter.converterStatus(packetStatus));
        acquire.bindLong(size + 2, j);
        acquire.bindLong(size + 3, i);
        acquire.bindLong(i4, i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sync_cursor");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "md5");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "business");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "consume_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "data_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "publish_ts");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "receive_ts");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "req_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "topic_type");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "packet_status");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "expire_ts");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "packet_ctrl");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "extra");
                int i6 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SyncLogV4 syncLogV4 = new SyncLogV4();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        syncLogV4.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        syncLogV4.syncId = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        syncLogV4.did = null;
                    } else {
                        syncLogV4.did = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        syncLogV4.uid = null;
                    } else {
                        syncLogV4.uid = query.getString(columnIndexOrThrow3);
                    }
                    int i7 = columnIndexOrThrow2;
                    syncLogV4.syncCursor = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        syncLogV4.data = null;
                    } else {
                        syncLogV4.data = query.getBlob(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        syncLogV4.md5 = null;
                    } else {
                        syncLogV4.md5 = query.getString(columnIndexOrThrow6);
                    }
                    syncLogV4.business = query.getLong(columnIndexOrThrow7);
                    syncLogV4.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    syncLogV4.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    syncLogV4.publishTs = query.getLong(columnIndexOrThrow10);
                    syncLogV4.receiveTs = query.getLong(columnIndexOrThrow11);
                    syncLogV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        syncLogV4.reqId = null;
                    } else {
                        syncLogV4.reqId = query.getString(columnIndexOrThrow13);
                    }
                    int i8 = i6;
                    syncLogV4.topicType = TopicTypeConverter.revertTopicType(query.getInt(i8));
                    int i9 = columnIndexOrThrow15;
                    int i10 = columnIndexOrThrow;
                    syncLogV4.packetStatus = PacketStatusConverter.revertTopicType(query.getInt(i9));
                    int i11 = columnIndexOrThrow16;
                    int i12 = columnIndexOrThrow13;
                    syncLogV4.expireTs = query.getLong(i11);
                    int i13 = columnIndexOrThrow17;
                    syncLogV4.packetCtrl = PacketCtrlConverter.revertTopicType(query.getInt(i13));
                    int i14 = columnIndexOrThrow18;
                    if (query.isNull(i14)) {
                        i3 = i11;
                        string = null;
                    } else {
                        string = query.getString(i14);
                        i3 = i11;
                    }
                    syncLogV4.extra = ExtraConverter.revertTopicType(string);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(syncLogV4);
                    columnIndexOrThrow18 = i14;
                    i6 = i8;
                    columnIndexOrThrow2 = i7;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i10;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow13 = i12;
                    columnIndexOrThrow16 = i3;
                    columnIndexOrThrow17 = i13;
                }
                ArrayList arrayList4 = arrayList2;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [androidx.room.RoomSQLiteQuery] */
    /* JADX WARN: Type inference failed for: r16v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public Snapshot querySnapshot(String str, long j) {
        ?? r16;
        RoomSQLiteQuery roomSQLiteQuery;
        Snapshot snapshot;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_snapshot WHERE sync_id = ? AND business = ? ", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "business");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cursor");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "notified");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "data_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "publish_ts");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "receive_ts");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "consume_type");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "patch_cnt");
            if (query.moveToFirst()) {
                Snapshot snapshot2 = new Snapshot();
                r16 = query.isNull(columnIndexOrThrow);
                try {
                    if (r16 != 0) {
                        r16 = acquire;
                        snapshot2.syncId = null;
                    } else {
                        r16 = acquire;
                        snapshot2.syncId = query.getString(columnIndexOrThrow);
                    }
                    snapshot2.business = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        snapshot2.uid = null;
                    } else {
                        snapshot2.uid = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        snapshot2.did = null;
                    } else {
                        snapshot2.did = query.getString(columnIndexOrThrow4);
                    }
                    snapshot2.cursor = query.getLong(columnIndexOrThrow5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        snapshot2.data = null;
                    } else {
                        snapshot2.data = query.getBlob(columnIndexOrThrow6);
                    }
                    snapshot2.notified = query.getLong(columnIndexOrThrow7);
                    snapshot2.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    snapshot2.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    snapshot2.publishTs = query.getLong(columnIndexOrThrow10);
                    snapshot2.receiveTs = query.getLong(columnIndexOrThrow11);
                    snapshot2.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    snapshot2.patchCnt = query.getInt(columnIndexOrThrow13);
                    snapshot = snapshot2;
                    roomSQLiteQuery = r16;
                } catch (Throwable th) {
                    th = th;
                    query.close();
                    r16.release();
                    throw th;
                }
            } else {
                roomSQLiteQuery = acquire;
                snapshot = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return snapshot;
        } catch (Throwable th2) {
            th = th2;
            r16 = acquire;
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public List<Snapshot> querySnapshots(int i, int i2) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_snapshot WHERE notified < cursor ORDER BY sync_id,business LIMIT ? offset ?", 2);
        acquire.bindLong(1, i);
        acquire.bindLong(2, i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "business");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "cursor");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "notified");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "data_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "publish_ts");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "receive_ts");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "consume_type");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "patch_cnt");
            roomSQLiteQuery = acquire;
            try {
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    Snapshot snapshot = new Snapshot();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        snapshot.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        snapshot.syncId = query.getString(columnIndexOrThrow);
                    }
                    int i3 = columnIndexOrThrow;
                    snapshot.business = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        snapshot.uid = null;
                    } else {
                        snapshot.uid = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        snapshot.did = null;
                    } else {
                        snapshot.did = query.getString(columnIndexOrThrow4);
                    }
                    snapshot.cursor = query.getLong(columnIndexOrThrow5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        snapshot.data = null;
                    } else {
                        snapshot.data = query.getBlob(columnIndexOrThrow6);
                    }
                    snapshot.notified = query.getLong(columnIndexOrThrow7);
                    snapshot.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    snapshot.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    snapshot.publishTs = query.getLong(columnIndexOrThrow10);
                    snapshot.receiveTs = query.getLong(columnIndexOrThrow11);
                    snapshot.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    snapshot.patchCnt = query.getInt(columnIndexOrThrow13);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(snapshot);
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i3;
                }
                ArrayList arrayList4 = arrayList2;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4
    public List<SyncLogV4> querySyncLogs(long j, int i, ConsumeType consumeType, int i2, long j2) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        String string;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_synclog WHERE business = ? AND consume_type = ? AND expire_ts >= ? ORDER BY sync_cursor ASC limit ? offset ?", 5);
        acquire.bindLong(1, j);
        acquire.bindLong(2, ConsumeTypeConverter.converterDate(consumeType));
        acquire.bindLong(3, j2);
        acquire.bindLong(4, i);
        acquire.bindLong(5, i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sync_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "did");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sync_cursor");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "md5");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "business");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "consume_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "data_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "publish_ts");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "receive_ts");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "bucket");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "req_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "topic_type");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "packet_status");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "expire_ts");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "packet_ctrl");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "extra");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SyncLogV4 syncLogV4 = new SyncLogV4();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        syncLogV4.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        syncLogV4.syncId = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        syncLogV4.did = null;
                    } else {
                        syncLogV4.did = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        syncLogV4.uid = null;
                    } else {
                        syncLogV4.uid = query.getString(columnIndexOrThrow3);
                    }
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    syncLogV4.syncCursor = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        syncLogV4.data = null;
                    } else {
                        syncLogV4.data = query.getBlob(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        syncLogV4.md5 = null;
                    } else {
                        syncLogV4.md5 = query.getString(columnIndexOrThrow6);
                    }
                    syncLogV4.business = query.getLong(columnIndexOrThrow7);
                    syncLogV4.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    syncLogV4.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    syncLogV4.publishTs = query.getLong(columnIndexOrThrow10);
                    syncLogV4.receiveTs = query.getLong(columnIndexOrThrow11);
                    syncLogV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        syncLogV4.reqId = null;
                    } else {
                        syncLogV4.reqId = query.getString(columnIndexOrThrow13);
                    }
                    int i7 = i4;
                    syncLogV4.topicType = TopicTypeConverter.revertTopicType(query.getInt(i7));
                    int i8 = columnIndexOrThrow15;
                    int i9 = columnIndexOrThrow;
                    syncLogV4.packetStatus = PacketStatusConverter.revertTopicType(query.getInt(i8));
                    int i10 = columnIndexOrThrow16;
                    int i11 = columnIndexOrThrow13;
                    syncLogV4.expireTs = query.getLong(i10);
                    int i12 = columnIndexOrThrow17;
                    syncLogV4.packetCtrl = PacketCtrlConverter.revertTopicType(query.getInt(i12));
                    int i13 = columnIndexOrThrow18;
                    if (query.isNull(i13)) {
                        i3 = i10;
                        string = null;
                    } else {
                        string = query.getString(i13);
                        i3 = i10;
                    }
                    syncLogV4.extra = ExtraConverter.revertTopicType(string);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(syncLogV4);
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow13 = i11;
                    columnIndexOrThrow16 = i3;
                    columnIndexOrThrow17 = i12;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i9;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow2 = i5;
                    i4 = i7;
                    columnIndexOrThrow3 = i6;
                }
                ArrayList arrayList4 = arrayList2;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
