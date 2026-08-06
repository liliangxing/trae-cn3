package com.bytedance.sync.p005v4.presistence.dao;

import com.bytedance.sync.p005v4.presistence.table.Business;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.protocal.Bucket;
import java.util.List;
import kotlin.Metadata;

/* compiled from: BusinessDao.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H'J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H'J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0014H'J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\b\u0010\u0017\u001a\u00020\u0003H'J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H'J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0014H'J0\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H'¨\u0006 "}, d2 = {"Lcom/bytedance/sync/v4/presistence/dao/BusinessDao;", "", "deleteSyncCursor", "", "pendingDelete", "", "", "insertBusiness", "businesses", "Lcom/bytedance/sync/v4/presistence/table/Business;", "insertSyncCursor", "syncCursors", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "queryAllCommonSyncCursors", "", "queryBusinesses", "queryCommonSyncCursorWithDid", "did", "queryCommonSyncCursorWithSyncId", "syncId", "", "queryCommonSyncCursorWithSyncIds", "syncIds", "resetAllCursor", "resetCursor", "updateReportCursor", "", "cursor", "uid", "bucket", "Lcom/bytedance/sync/v4/protocal/Bucket;", "reportCursor", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface BusinessDao {
    void deleteSyncCursor(List<String> pendingDelete);

    void insertBusiness(List<? extends Business> businesses);

    void insertSyncCursor(List<? extends SyncCursor> syncCursors);

    List<SyncCursor> queryAllCommonSyncCursors();

    List<Business> queryBusinesses();

    List<SyncCursor> queryCommonSyncCursorWithDid(String did);

    SyncCursor queryCommonSyncCursorWithSyncId(long syncId);

    List<SyncCursor> queryCommonSyncCursorWithSyncIds(List<String> syncIds);

    void resetAllCursor();

    void resetCursor(String syncId);

    int updateReportCursor(String syncId, long cursor);

    void updateReportCursor(String did, String uid, String syncId, Bucket bucket, long reportCursor);
}
