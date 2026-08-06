package com.bytedance.sync.v4.presistence.dao;

import com.bytedance.sync.v4.presistence.table.SyncHistoryLogV4;
import com.bytedance.sync.v4.protocal.TopicType;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: HistoryDaoV4.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\bH'J6\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH'J>\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H'J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'J6\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H'J.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'J6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sync/v4/presistence/dao/HistoryDaoV4;", "", "deleteHistorySyncLogs", "", "logs", "", "Lcom/bytedance/sync/v4/presistence/table/SyncHistoryLogV4;", "insertHistorySyncLogs", "Ljava/util/ArrayList;", "queryHistoryCustomSyncLogs", CommonConstants.KEY_DEVICE_ID, "", "uid", "businessId", "", "topicType", "Lcom/bytedance/sync/v4/protocal/TopicType;", "reqId", "limit", "", "queryHistoryGlobalSyncLogs", "queryHistorySpecSyncLogs", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface HistoryDaoV4 {
    void deleteHistorySyncLogs(List<? extends SyncHistoryLogV4> logs);

    void insertHistorySyncLogs(ArrayList<SyncHistoryLogV4> logs);

    List<SyncHistoryLogV4> queryHistoryCustomSyncLogs(String did, String uid, long businessId, TopicType topicType, String reqId);

    List<SyncHistoryLogV4> queryHistoryCustomSyncLogs(String did, String uid, long businessId, TopicType topicType, String reqId, int limit);

    List<SyncHistoryLogV4> queryHistoryGlobalSyncLogs(String did, String uid, long businessId, TopicType topicType);

    List<SyncHistoryLogV4> queryHistoryGlobalSyncLogs(String did, String uid, long businessId, TopicType topicType, int limit);

    List<SyncHistoryLogV4> queryHistorySpecSyncLogs(String did, String uid, long businessId, TopicType topicType);

    List<SyncHistoryLogV4> queryHistorySpecSyncLogs(String did, String uid, long businessId, TopicType topicType, int limit);
}
