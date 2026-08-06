package com.bytedance.sync.p005v4.presistence;

import com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DBServiceImplV4.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DBServiceImplV4$updateSnapshotAndDeleteSyncLog$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Snapshot $snapshot;
    final /* synthetic */ List<SyncLogV4> $syncLogs;
    final /* synthetic */ DBServiceImplV4 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBServiceImplV4$updateSnapshotAndDeleteSyncLog$1(DBServiceImplV4 dBServiceImplV4, Snapshot snapshot, List<? extends SyncLogV4> list) {
        super(0);
        this.this$0 = dBServiceImplV4;
        this.$snapshot = snapshot;
        this.$syncLogs = list;
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m969invoke() {
        AppDatabaseV4 mDbInst;
        mDbInst = this.this$0.getMDbInst();
        final DBServiceImplV4 dBServiceImplV4 = this.this$0;
        final Snapshot snapshot = this.$snapshot;
        final List<SyncLogV4> list = this.$syncLogs;
        return (Boolean) mDbInst.runInTransaction(new Callable() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$updateSnapshotAndDeleteSyncLog$1$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m968invoke$lambda0;
                m968invoke$lambda0 = DBServiceImplV4$updateSnapshotAndDeleteSyncLog$1.m968invoke$lambda0(DBServiceImplV4.this, snapshot, list);
                return m968invoke$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final Boolean m968invoke$lambda0(DBServiceImplV4 dBServiceImplV4, Snapshot snapshot, List list) {
        SyncDaoV4 mSyncDao;
        Intrinsics.checkNotNullParameter(dBServiceImplV4, "this$0");
        Intrinsics.checkNotNullParameter(snapshot, "$snapshot");
        Intrinsics.checkNotNullParameter(list, "$syncLogs");
        mSyncDao = dBServiceImplV4.getMSyncDao();
        return Boolean.valueOf(mSyncDao.insertOrReplaceSnapshot(snapshot) > 0 && dBServiceImplV4.deleteSyncLog(list));
    }
}
