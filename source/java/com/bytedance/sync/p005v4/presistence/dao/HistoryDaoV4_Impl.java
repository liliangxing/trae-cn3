package com.bytedance.sync.p005v4.presistence.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.p005v4.presistence.converter.BucketConverter;
import com.bytedance.sync.p005v4.presistence.converter.ConsumeTypeConverter;
import com.bytedance.sync.p005v4.presistence.converter.DataTypeConverter;
import com.bytedance.sync.p005v4.presistence.converter.ExtraConverter;
import com.bytedance.sync.p005v4.presistence.converter.PacketCtrlConverter;
import com.bytedance.sync.p005v4.presistence.converter.PacketStatusConverter;
import com.bytedance.sync.p005v4.presistence.converter.TopicTypeConverter;
import com.bytedance.sync.p005v4.presistence.table.SyncHistoryLogV4;
import com.bytedance.sync.p005v4.protocal.TopicType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HistoryDaoV4_Impl implements HistoryDaoV4 {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SyncHistoryLogV4> __deletionAdapterOfSyncHistoryLogV4;
    private final EntityInsertionAdapter<SyncHistoryLogV4> __insertionAdapterOfSyncHistoryLogV4;

    public HistoryDaoV4_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSyncHistoryLogV4 = new EntityInsertionAdapter<SyncHistoryLogV4>(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.HistoryDaoV4_Impl.1
            public String createQuery() {
                return "INSERT OR REPLACE INTO `t_history_synclog` (`sync_id`,`did`,`uid`,`sync_cursor`,`data`,`md5`,`business`,`consume_type`,`data_type`,`publish_ts`,`receive_ts`,`bucket`,`req_id`,`topic_type`,`packet_status`,`expire_ts`,`packet_ctrl`,`extra`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncHistoryLogV4 syncHistoryLogV4) {
                if (syncHistoryLogV4.syncId == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncHistoryLogV4.syncId);
                }
                if (syncHistoryLogV4.did == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, syncHistoryLogV4.did);
                }
                if (syncHistoryLogV4.uid == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, syncHistoryLogV4.uid);
                }
                supportSQLiteStatement.bindLong(4, syncHistoryLogV4.syncCursor);
                if (syncHistoryLogV4.data == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, syncHistoryLogV4.data);
                }
                if (syncHistoryLogV4.md5 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, syncHistoryLogV4.md5);
                }
                supportSQLiteStatement.bindLong(7, syncHistoryLogV4.business);
                supportSQLiteStatement.bindLong(8, ConsumeTypeConverter.converterDate(syncHistoryLogV4.consumeType));
                supportSQLiteStatement.bindLong(9, DataTypeConverter.converterDate(syncHistoryLogV4.dataType));
                supportSQLiteStatement.bindLong(10, syncHistoryLogV4.publishTs);
                supportSQLiteStatement.bindLong(11, syncHistoryLogV4.receiveTs);
                supportSQLiteStatement.bindLong(12, BucketConverter.converterDate(syncHistoryLogV4.bucket));
                if (syncHistoryLogV4.reqId == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, syncHistoryLogV4.reqId);
                }
                supportSQLiteStatement.bindLong(14, TopicTypeConverter.converterStatus(syncHistoryLogV4.topicType));
                supportSQLiteStatement.bindLong(15, PacketStatusConverter.converterStatus(syncHistoryLogV4.packetStatus));
                supportSQLiteStatement.bindLong(16, syncHistoryLogV4.expireTs);
                supportSQLiteStatement.bindLong(17, PacketCtrlConverter.converterStatus(syncHistoryLogV4.packetCtrl));
                String converterStatus = ExtraConverter.converterStatus(syncHistoryLogV4.extra);
                if (converterStatus == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, converterStatus);
                }
            }
        };
        this.__deletionAdapterOfSyncHistoryLogV4 = new EntityDeletionOrUpdateAdapter<SyncHistoryLogV4>(roomDatabase) { // from class: com.bytedance.sync.v4.presistence.dao.HistoryDaoV4_Impl.2
            public String createQuery() {
                return "DELETE FROM `t_history_synclog` WHERE `sync_id` = ? AND `sync_cursor` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncHistoryLogV4 syncHistoryLogV4) {
                if (syncHistoryLogV4.syncId == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncHistoryLogV4.syncId);
                }
                supportSQLiteStatement.bindLong(2, syncHistoryLogV4.syncCursor);
            }
        };
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4
    public void insertHistorySyncLogs(ArrayList<SyncHistoryLogV4> arrayList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSyncHistoryLogV4.insert(arrayList);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4
    public void deleteHistorySyncLogs(List<? extends SyncHistoryLogV4> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSyncHistoryLogV4.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4
    public List<SyncHistoryLogV4> queryHistorySpecSyncLogs(String str, String str2, long j, TopicType topicType) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        String string;
        int i;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? ORDER BY sync_cursor DESC", 4);
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
        acquire.bindLong(3, j);
        acquire.bindLong(4, TopicTypeConverter.converterStatus(topicType));
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
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SyncHistoryLogV4 syncHistoryLogV4 = new SyncHistoryLogV4();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        syncHistoryLogV4.did = null;
                    } else {
                        syncHistoryLogV4.did = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        syncHistoryLogV4.uid = null;
                    } else {
                        syncHistoryLogV4.uid = query.getString(columnIndexOrThrow3);
                    }
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    syncHistoryLogV4.syncCursor = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        syncHistoryLogV4.data = null;
                    } else {
                        syncHistoryLogV4.data = query.getBlob(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        syncHistoryLogV4.md5 = null;
                    } else {
                        syncHistoryLogV4.md5 = query.getString(columnIndexOrThrow6);
                    }
                    syncHistoryLogV4.business = query.getLong(columnIndexOrThrow7);
                    syncHistoryLogV4.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    syncHistoryLogV4.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    syncHistoryLogV4.publishTs = query.getLong(columnIndexOrThrow10);
                    syncHistoryLogV4.receiveTs = query.getLong(columnIndexOrThrow11);
                    syncHistoryLogV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        syncHistoryLogV4.reqId = null;
                    } else {
                        syncHistoryLogV4.reqId = query.getString(columnIndexOrThrow13);
                    }
                    int i5 = i2;
                    syncHistoryLogV4.topicType = TopicTypeConverter.revertTopicType(query.getInt(i5));
                    int i6 = columnIndexOrThrow15;
                    int i7 = columnIndexOrThrow;
                    syncHistoryLogV4.packetStatus = PacketStatusConverter.revertTopicType(query.getInt(i6));
                    int i8 = columnIndexOrThrow16;
                    int i9 = columnIndexOrThrow13;
                    syncHistoryLogV4.expireTs = query.getLong(i8);
                    int i10 = columnIndexOrThrow17;
                    syncHistoryLogV4.packetCtrl = PacketCtrlConverter.revertTopicType(query.getInt(i10));
                    int i11 = columnIndexOrThrow18;
                    if (query.isNull(i11)) {
                        i = i8;
                        string = null;
                    } else {
                        string = query.getString(i11);
                        i = i8;
                    }
                    syncHistoryLogV4.extra = ExtraConverter.revertTopicType(string);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(syncHistoryLogV4);
                    columnIndexOrThrow18 = i11;
                    columnIndexOrThrow13 = i9;
                    columnIndexOrThrow16 = i;
                    columnIndexOrThrow17 = i10;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i7;
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow2 = i3;
                    i2 = i5;
                    columnIndexOrThrow3 = i4;
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

    @Override // com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4
    public List<SyncHistoryLogV4> queryHistorySpecSyncLogs(String str, String str2, long j, TopicType topicType, int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        String string;
        int i2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? ORDER BY sync_cursor DESC  LIMIT ?", 5);
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
        acquire.bindLong(3, j);
        acquire.bindLong(4, TopicTypeConverter.converterStatus(topicType));
        acquire.bindLong(5, i);
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
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SyncHistoryLogV4 syncHistoryLogV4 = new SyncHistoryLogV4();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        syncHistoryLogV4.did = null;
                    } else {
                        syncHistoryLogV4.did = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        syncHistoryLogV4.uid = null;
                    } else {
                        syncHistoryLogV4.uid = query.getString(columnIndexOrThrow3);
                    }
                    int i4 = columnIndexOrThrow2;
                    int i5 = columnIndexOrThrow3;
                    syncHistoryLogV4.syncCursor = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        syncHistoryLogV4.data = null;
                    } else {
                        syncHistoryLogV4.data = query.getBlob(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        syncHistoryLogV4.md5 = null;
                    } else {
                        syncHistoryLogV4.md5 = query.getString(columnIndexOrThrow6);
                    }
                    syncHistoryLogV4.business = query.getLong(columnIndexOrThrow7);
                    syncHistoryLogV4.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    syncHistoryLogV4.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    syncHistoryLogV4.publishTs = query.getLong(columnIndexOrThrow10);
                    syncHistoryLogV4.receiveTs = query.getLong(columnIndexOrThrow11);
                    syncHistoryLogV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        syncHistoryLogV4.reqId = null;
                    } else {
                        syncHistoryLogV4.reqId = query.getString(columnIndexOrThrow13);
                    }
                    int i6 = i3;
                    syncHistoryLogV4.topicType = TopicTypeConverter.revertTopicType(query.getInt(i6));
                    int i7 = columnIndexOrThrow15;
                    int i8 = columnIndexOrThrow;
                    syncHistoryLogV4.packetStatus = PacketStatusConverter.revertTopicType(query.getInt(i7));
                    int i9 = columnIndexOrThrow16;
                    int i10 = columnIndexOrThrow13;
                    syncHistoryLogV4.expireTs = query.getLong(i9);
                    int i11 = columnIndexOrThrow17;
                    syncHistoryLogV4.packetCtrl = PacketCtrlConverter.revertTopicType(query.getInt(i11));
                    int i12 = columnIndexOrThrow18;
                    if (query.isNull(i12)) {
                        i2 = i9;
                        string = null;
                    } else {
                        string = query.getString(i12);
                        i2 = i9;
                    }
                    syncHistoryLogV4.extra = ExtraConverter.revertTopicType(string);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(syncHistoryLogV4);
                    columnIndexOrThrow18 = i12;
                    columnIndexOrThrow13 = i10;
                    columnIndexOrThrow16 = i2;
                    columnIndexOrThrow17 = i11;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i8;
                    columnIndexOrThrow15 = i7;
                    columnIndexOrThrow2 = i4;
                    i3 = i6;
                    columnIndexOrThrow3 = i5;
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

    @Override // com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4
    public List<SyncHistoryLogV4> queryHistoryCustomSyncLogs(String str, String str2, long j, TopicType topicType, String str3) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        String string;
        int i;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? AND req_id = ? ORDER BY sync_cursor DESC", 5);
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
        acquire.bindLong(3, j);
        acquire.bindLong(4, TopicTypeConverter.converterStatus(topicType));
        if (str3 == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str3);
        }
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
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SyncHistoryLogV4 syncHistoryLogV4 = new SyncHistoryLogV4();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        syncHistoryLogV4.did = null;
                    } else {
                        syncHistoryLogV4.did = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        syncHistoryLogV4.uid = null;
                    } else {
                        syncHistoryLogV4.uid = query.getString(columnIndexOrThrow3);
                    }
                    int i3 = columnIndexOrThrow2;
                    syncHistoryLogV4.syncCursor = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        syncHistoryLogV4.data = null;
                    } else {
                        syncHistoryLogV4.data = query.getBlob(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        syncHistoryLogV4.md5 = null;
                    } else {
                        syncHistoryLogV4.md5 = query.getString(columnIndexOrThrow6);
                    }
                    syncHistoryLogV4.business = query.getLong(columnIndexOrThrow7);
                    syncHistoryLogV4.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    syncHistoryLogV4.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    syncHistoryLogV4.publishTs = query.getLong(columnIndexOrThrow10);
                    syncHistoryLogV4.receiveTs = query.getLong(columnIndexOrThrow11);
                    syncHistoryLogV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        syncHistoryLogV4.reqId = null;
                    } else {
                        syncHistoryLogV4.reqId = query.getString(columnIndexOrThrow13);
                    }
                    int i4 = i2;
                    syncHistoryLogV4.topicType = TopicTypeConverter.revertTopicType(query.getInt(i4));
                    int i5 = columnIndexOrThrow15;
                    int i6 = columnIndexOrThrow;
                    syncHistoryLogV4.packetStatus = PacketStatusConverter.revertTopicType(query.getInt(i5));
                    int i7 = columnIndexOrThrow16;
                    int i8 = columnIndexOrThrow13;
                    syncHistoryLogV4.expireTs = query.getLong(i7);
                    int i9 = columnIndexOrThrow17;
                    syncHistoryLogV4.packetCtrl = PacketCtrlConverter.revertTopicType(query.getInt(i9));
                    int i10 = columnIndexOrThrow18;
                    if (query.isNull(i10)) {
                        i = i7;
                        string = null;
                    } else {
                        string = query.getString(i10);
                        i = i7;
                    }
                    syncHistoryLogV4.extra = ExtraConverter.revertTopicType(string);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(syncHistoryLogV4);
                    columnIndexOrThrow18 = i10;
                    i2 = i4;
                    columnIndexOrThrow2 = i3;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow13 = i8;
                    columnIndexOrThrow16 = i;
                    columnIndexOrThrow17 = i9;
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

    @Override // com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4
    public List<SyncHistoryLogV4> queryHistoryCustomSyncLogs(String str, String str2, long j, TopicType topicType, String str3, int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        String string;
        int i2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? AND req_id = ? ORDER BY sync_cursor DESC LIMIT ?", 6);
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
        acquire.bindLong(3, j);
        acquire.bindLong(4, TopicTypeConverter.converterStatus(topicType));
        if (str3 == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str3);
        }
        acquire.bindLong(6, i);
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
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SyncHistoryLogV4 syncHistoryLogV4 = new SyncHistoryLogV4();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        syncHistoryLogV4.did = null;
                    } else {
                        syncHistoryLogV4.did = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        syncHistoryLogV4.uid = null;
                    } else {
                        syncHistoryLogV4.uid = query.getString(columnIndexOrThrow3);
                    }
                    int i4 = columnIndexOrThrow2;
                    syncHistoryLogV4.syncCursor = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        syncHistoryLogV4.data = null;
                    } else {
                        syncHistoryLogV4.data = query.getBlob(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        syncHistoryLogV4.md5 = null;
                    } else {
                        syncHistoryLogV4.md5 = query.getString(columnIndexOrThrow6);
                    }
                    syncHistoryLogV4.business = query.getLong(columnIndexOrThrow7);
                    syncHistoryLogV4.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    syncHistoryLogV4.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    syncHistoryLogV4.publishTs = query.getLong(columnIndexOrThrow10);
                    syncHistoryLogV4.receiveTs = query.getLong(columnIndexOrThrow11);
                    syncHistoryLogV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        syncHistoryLogV4.reqId = null;
                    } else {
                        syncHistoryLogV4.reqId = query.getString(columnIndexOrThrow13);
                    }
                    int i5 = i3;
                    syncHistoryLogV4.topicType = TopicTypeConverter.revertTopicType(query.getInt(i5));
                    int i6 = columnIndexOrThrow15;
                    int i7 = columnIndexOrThrow;
                    syncHistoryLogV4.packetStatus = PacketStatusConverter.revertTopicType(query.getInt(i6));
                    int i8 = columnIndexOrThrow16;
                    int i9 = columnIndexOrThrow13;
                    syncHistoryLogV4.expireTs = query.getLong(i8);
                    int i10 = columnIndexOrThrow17;
                    syncHistoryLogV4.packetCtrl = PacketCtrlConverter.revertTopicType(query.getInt(i10));
                    int i11 = columnIndexOrThrow18;
                    if (query.isNull(i11)) {
                        i2 = i8;
                        string = null;
                    } else {
                        string = query.getString(i11);
                        i2 = i8;
                    }
                    syncHistoryLogV4.extra = ExtraConverter.revertTopicType(string);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(syncHistoryLogV4);
                    columnIndexOrThrow18 = i11;
                    i3 = i5;
                    columnIndexOrThrow2 = i4;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i7;
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow13 = i9;
                    columnIndexOrThrow16 = i2;
                    columnIndexOrThrow17 = i10;
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

    @Override // com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4
    public List<SyncHistoryLogV4> queryHistoryGlobalSyncLogs(String str, String str2, long j, TopicType topicType) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        String string;
        int i;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? ORDER BY publish_ts DESC", 4);
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
        acquire.bindLong(3, j);
        acquire.bindLong(4, TopicTypeConverter.converterStatus(topicType));
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
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SyncHistoryLogV4 syncHistoryLogV4 = new SyncHistoryLogV4();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        syncHistoryLogV4.did = null;
                    } else {
                        syncHistoryLogV4.did = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        syncHistoryLogV4.uid = null;
                    } else {
                        syncHistoryLogV4.uid = query.getString(columnIndexOrThrow3);
                    }
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    syncHistoryLogV4.syncCursor = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        syncHistoryLogV4.data = null;
                    } else {
                        syncHistoryLogV4.data = query.getBlob(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        syncHistoryLogV4.md5 = null;
                    } else {
                        syncHistoryLogV4.md5 = query.getString(columnIndexOrThrow6);
                    }
                    syncHistoryLogV4.business = query.getLong(columnIndexOrThrow7);
                    syncHistoryLogV4.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    syncHistoryLogV4.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    syncHistoryLogV4.publishTs = query.getLong(columnIndexOrThrow10);
                    syncHistoryLogV4.receiveTs = query.getLong(columnIndexOrThrow11);
                    syncHistoryLogV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        syncHistoryLogV4.reqId = null;
                    } else {
                        syncHistoryLogV4.reqId = query.getString(columnIndexOrThrow13);
                    }
                    int i5 = i2;
                    syncHistoryLogV4.topicType = TopicTypeConverter.revertTopicType(query.getInt(i5));
                    int i6 = columnIndexOrThrow15;
                    int i7 = columnIndexOrThrow;
                    syncHistoryLogV4.packetStatus = PacketStatusConverter.revertTopicType(query.getInt(i6));
                    int i8 = columnIndexOrThrow16;
                    int i9 = columnIndexOrThrow13;
                    syncHistoryLogV4.expireTs = query.getLong(i8);
                    int i10 = columnIndexOrThrow17;
                    syncHistoryLogV4.packetCtrl = PacketCtrlConverter.revertTopicType(query.getInt(i10));
                    int i11 = columnIndexOrThrow18;
                    if (query.isNull(i11)) {
                        i = i8;
                        string = null;
                    } else {
                        string = query.getString(i11);
                        i = i8;
                    }
                    syncHistoryLogV4.extra = ExtraConverter.revertTopicType(string);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(syncHistoryLogV4);
                    columnIndexOrThrow18 = i11;
                    columnIndexOrThrow13 = i9;
                    columnIndexOrThrow16 = i;
                    columnIndexOrThrow17 = i10;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i7;
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow2 = i3;
                    i2 = i5;
                    columnIndexOrThrow3 = i4;
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

    @Override // com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4
    public List<SyncHistoryLogV4> queryHistoryGlobalSyncLogs(String str, String str2, long j, TopicType topicType, int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        String string;
        int i2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? ORDER BY publish_ts DESC  LIMIT ?", 5);
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
        acquire.bindLong(3, j);
        acquire.bindLong(4, TopicTypeConverter.converterStatus(topicType));
        acquire.bindLong(5, i);
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
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SyncHistoryLogV4 syncHistoryLogV4 = new SyncHistoryLogV4();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = null;
                    } else {
                        arrayList = arrayList2;
                        syncHistoryLogV4.syncId = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        syncHistoryLogV4.did = null;
                    } else {
                        syncHistoryLogV4.did = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        syncHistoryLogV4.uid = null;
                    } else {
                        syncHistoryLogV4.uid = query.getString(columnIndexOrThrow3);
                    }
                    int i4 = columnIndexOrThrow2;
                    int i5 = columnIndexOrThrow3;
                    syncHistoryLogV4.syncCursor = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        syncHistoryLogV4.data = null;
                    } else {
                        syncHistoryLogV4.data = query.getBlob(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        syncHistoryLogV4.md5 = null;
                    } else {
                        syncHistoryLogV4.md5 = query.getString(columnIndexOrThrow6);
                    }
                    syncHistoryLogV4.business = query.getLong(columnIndexOrThrow7);
                    syncHistoryLogV4.consumeType = ConsumeTypeConverter.revertDate(query.getInt(columnIndexOrThrow8));
                    syncHistoryLogV4.dataType = DataTypeConverter.revertDate(query.getInt(columnIndexOrThrow9));
                    syncHistoryLogV4.publishTs = query.getLong(columnIndexOrThrow10);
                    syncHistoryLogV4.receiveTs = query.getLong(columnIndexOrThrow11);
                    syncHistoryLogV4.bucket = BucketConverter.revertDate(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        syncHistoryLogV4.reqId = null;
                    } else {
                        syncHistoryLogV4.reqId = query.getString(columnIndexOrThrow13);
                    }
                    int i6 = i3;
                    syncHistoryLogV4.topicType = TopicTypeConverter.revertTopicType(query.getInt(i6));
                    int i7 = columnIndexOrThrow15;
                    int i8 = columnIndexOrThrow;
                    syncHistoryLogV4.packetStatus = PacketStatusConverter.revertTopicType(query.getInt(i7));
                    int i9 = columnIndexOrThrow16;
                    int i10 = columnIndexOrThrow13;
                    syncHistoryLogV4.expireTs = query.getLong(i9);
                    int i11 = columnIndexOrThrow17;
                    syncHistoryLogV4.packetCtrl = PacketCtrlConverter.revertTopicType(query.getInt(i11));
                    int i12 = columnIndexOrThrow18;
                    if (query.isNull(i12)) {
                        i2 = i9;
                        string = null;
                    } else {
                        string = query.getString(i12);
                        i2 = i9;
                    }
                    syncHistoryLogV4.extra = ExtraConverter.revertTopicType(string);
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(syncHistoryLogV4);
                    columnIndexOrThrow18 = i12;
                    columnIndexOrThrow13 = i10;
                    columnIndexOrThrow16 = i2;
                    columnIndexOrThrow17 = i11;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow = i8;
                    columnIndexOrThrow15 = i7;
                    columnIndexOrThrow2 = i4;
                    i3 = i6;
                    columnIndexOrThrow3 = i5;
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
