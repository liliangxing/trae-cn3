package com.bytedance.sync.p005v4.intf;

import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.p005v4.presistence.table.Business;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.presistence.table.SyncHistoryLogV4;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
import com.bytedance.sync.p005v4.protocal.Bucket;
import com.bytedance.sync.p005v4.protocal.PacketStatus;
import com.bytedance.sync.p005v4.protocal.TopicType;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.bytedance.tracing.internal.TracingConstants;
import com.ss.android.ug.bus.IUgBusService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: IDBServiceV4.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0016\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH&J \u0010\u0018\u001a\u00020\u00032\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\r0\u001aj\b\u0012\u0004\u0012\u00020\r`\u001bH&J(\u0010\u001c\u001a\u00020\u00032\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001aj\b\u0012\u0004\u0012\u00020\u0014`\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H&J\u0016\u0010#\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\fH&J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0&H&J0\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u00112\u0006\u0010,\u001a\u00020-H&J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0&2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-H&J0\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010(\u001a\u00020)2\u0006\u00100\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u00112\u0006\u0010,\u001a\u00020-H&J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002020&H&J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u001f0\f2\u0006\u00104\u001a\u000205H&J\u0012\u00106\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0010\u001a\u00020\tH&J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f0&2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00110\fH&J\u001a\u00109\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00100\u001a\u00020\tH&J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010;\u001a\u00020-H&J<\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\t0=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020-2\u0006\u0010;\u001a\u00020-2\u0006\u0010A\u001a\u00020\tH&J.\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u00100\u001a\u00020\t2\u0006\u0010,\u001a\u00020-2\u0006\u0010;\u001a\u00020-2\u0006\u0010C\u001a\u00020\tH&J&\u0010D\u001a\b\u0012\u0004\u0012\u00020\"0\f2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00112\u0006\u0010@\u001a\u00020-H&J.\u0010D\u001a\b\u0012\u0004\u0012\u00020\"0\f2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u0010@\u001a\u00020-H&J\b\u0010I\u001a\u00020\u0003H&J\u001e\u0010J\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u00052\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00140\fH&J2\u0010M\u001a\u00020\u00032\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001f0&2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002020\fH&J\u001e\u0010Q\u001a\u00020\u000f2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\"0\f2\u0006\u0010S\u001a\u00020\u001fH&J,\u0010T\u001a\u00020\u000f2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\"0\f2\u0006\u0010S\u001a\u00020\u001f2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\"0\fH&¨\u0006V"}, d2 = {"Lcom/bytedance/sync/v4/intf/IDBServiceV4;", "Lcom/ss/android/ug/bus/IUgBusService;", "changeSnapshotToNotified", "", "it", "Lcom/bytedance/sync/v4/presistence/table/Snapshot;", "deleteAllTableData", "deleteExpireSyncLog", "ts", "", "deleteHistorySyncLog", "deleteHistoryLogs", "", "Lcom/bytedance/sync/v4/presistence/table/SyncHistoryLogV4;", "deleteLocalData", "", "syncId", "", "deleteSyncLog", "obj", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "deleteUpStreamMsgIfBusinessNotExist", "deleteUploadData", "cursor", "insertHistorySyncLog", "historyLogs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "insertSyncLogAndCursor", TracingConstants.KEY_LOGS, "newCursor", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "insertUpStreamItem", "item", "Lcom/bytedance/sync/v4/presistence/table/UploadItemV4;", "insertUpStreamItemList", "items", "queryAllLocalSyncCursorInfo", "", "queryDeleteHistorySyncLog", "topicType", "Lcom/bytedance/sync/v4/protocal/TopicType;", "businessId", "topic", "limit", "", "queryDistributeMsgs", "queryHistorySyncLog", "business", "queryLocalBusinesses", "Lcom/bytedance/sync/v4/presistence/table/Business;", "queryLocalSyncCursorInfoWithDeviceInfo", "deviceInfo", "Lcom/bytedance/sync/user/AccountEventSynchronizer$DeviceInfo;", "queryLocalSyncCursorInfoWithSyncId", "queryLocalSyncCursorInfoWithSyncIds", "syncIds", "querySnapshot", "querySnapshots", "offset", "querySyncLogs", "", "packetStatus", "Lcom/bytedance/sync/v4/protocal/PacketStatus;", "size", "expireTs", "querySyncLogsByBusiness", "curTs", "queryUploadMsgByDeviceInfo", "bucket", "Lcom/bytedance/sync/v4/protocal/Bucket;", "did", "uid", "resetAllCursor", "updateSnapshotAndDeleteSyncLog", IFileDataCacheService.TYPE_SNAPSHOT, "syncLogs", "updateSyncCursorAndBusiness", "syncCursors", "pendingDelete", "businesses", "updateUploadCursor", "undistributedUploads", "syncCursor", "updateUploadCursorAndDelete", "pendingDeleteList", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IDBServiceV4 extends IUgBusService {
    void changeSnapshotToNotified(Snapshot it);

    void deleteAllTableData();

    void deleteExpireSyncLog(long ts);

    void deleteHistorySyncLog(List<? extends SyncHistoryLogV4> deleteHistoryLogs);

    boolean deleteLocalData(String syncId);

    boolean deleteSyncLog(List<? extends SyncLogV4> obj);

    void deleteUpStreamMsgIfBusinessNotExist();

    void deleteUploadData(long syncId, long cursor);

    void insertHistorySyncLog(ArrayList<SyncHistoryLogV4> historyLogs);

    void insertSyncLogAndCursor(ArrayList<SyncLogV4> logs, SyncCursor newCursor);

    long insertUpStreamItem(UploadItemV4 item);

    long insertUpStreamItemList(List<? extends UploadItemV4> items);

    List<SyncCursor> queryAllLocalSyncCursorInfo();

    List<SyncHistoryLogV4> queryDeleteHistorySyncLog(TopicType topicType, long businessId, String topic, int limit);

    List<UploadItemV4> queryDistributeMsgs(String syncId, int limit);

    List<SyncHistoryLogV4> queryHistorySyncLog(TopicType topicType, long business, String topic, int limit);

    List<Business> queryLocalBusinesses();

    List<SyncCursor> queryLocalSyncCursorInfoWithDeviceInfo(AccountEventSynchronizer.DeviceInfo deviceInfo);

    SyncCursor queryLocalSyncCursorInfoWithSyncId(long syncId);

    List<SyncCursor> queryLocalSyncCursorInfoWithSyncIds(List<String> syncIds);

    Snapshot querySnapshot(String syncId, long business);

    List<Snapshot> querySnapshots(int limit, int offset);

    List<SyncLogV4> querySyncLogs(Set<Long> syncIds, PacketStatus packetStatus, int size, int offset, long expireTs);

    List<SyncLogV4> querySyncLogsByBusiness(long business, int limit, int offset, long curTs);

    List<UploadItemV4> queryUploadMsgByDeviceInfo(Bucket bucket, String did, int size);

    List<UploadItemV4> queryUploadMsgByDeviceInfo(Bucket bucket, String did, String uid, int size);

    void resetAllCursor();

    boolean updateSnapshotAndDeleteSyncLog(Snapshot snapshot, List<? extends SyncLogV4> syncLogs);

    void updateSyncCursorAndBusiness(List<SyncCursor> syncCursors, List<String> pendingDelete, List<? extends Business> businesses);

    boolean updateUploadCursor(List<? extends UploadItemV4> undistributedUploads, SyncCursor syncCursor);

    boolean updateUploadCursorAndDelete(List<? extends UploadItemV4> undistributedUploads, SyncCursor syncCursor, List<? extends UploadItemV4> pendingDeleteList);
}
