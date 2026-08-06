package com.bytedance.sync.p005v4.presistence.dao;

import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.protocal.ConsumeType;
import com.bytedance.sync.p005v4.protocal.PacketStatus;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: SyncDaoV4.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0005H'J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H'J<\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH'J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\rH'J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H'J6\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH'¨\u0006%"}, d2 = {"Lcom/bytedance/sync/v4/presistence/dao/SyncDaoV4;", "", "changeSnapshotToNotified", "", "it", "Lcom/bytedance/sync/v4/presistence/table/Snapshot;", "delete", "", "obj", "", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "deleteExpireSyncLog", "curTs", "", "deleteSnapshot", "syncId", "", "deleteSyncId", "insertOrReplaceSnapshot", IFileDataCacheService.TYPE_SNAPSHOT, "insertSyncLogs", TracingConstants.KEY_LOGS, "Ljava/util/ArrayList;", "queryAllLogs", "syncIds", "", "packetStatus", "Lcom/bytedance/sync/v4/protocal/PacketStatus;", "size", "offset", "querySnapshot", "business", "querySnapshots", "limit", "querySyncLogs", "consumeType", "Lcom/bytedance/sync/v4/protocal/ConsumeType;", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface SyncDaoV4 {
    void changeSnapshotToNotified(Snapshot it);

    int delete(List<? extends SyncLogV4> obj);

    void deleteExpireSyncLog(long curTs);

    void deleteSnapshot(String syncId);

    void deleteSyncId(String syncId);

    long insertOrReplaceSnapshot(Snapshot snapshot);

    void insertSyncLogs(ArrayList<SyncLogV4> logs);

    List<SyncLogV4> queryAllLogs(Set<Long> syncIds, PacketStatus packetStatus, int size, int offset, long curTs);

    Snapshot querySnapshot(String syncId, long business);

    List<Snapshot> querySnapshots(int limit, int offset);

    List<SyncLogV4> querySyncLogs(long business, int limit, ConsumeType consumeType, int offset, long curTs);
}
