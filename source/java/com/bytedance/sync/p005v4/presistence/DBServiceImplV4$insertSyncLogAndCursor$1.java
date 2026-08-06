package com.bytedance.sync.p005v4.presistence;

import com.bytedance.sync.p005v4.presistence.dao.BusinessDao;
import com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DBServiceImplV4.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DBServiceImplV4$insertSyncLogAndCursor$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ArrayList<SyncLogV4> $logs;
    final /* synthetic */ SyncCursor $newCursor;
    final /* synthetic */ DBServiceImplV4 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBServiceImplV4$insertSyncLogAndCursor$1(DBServiceImplV4 dBServiceImplV4, ArrayList<SyncLogV4> arrayList, SyncCursor syncCursor) {
        super(0);
        this.this$0 = dBServiceImplV4;
        this.$logs = arrayList;
        this.$newCursor = syncCursor;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m943invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m943invoke() {
        AppDatabaseV4 mDbInst;
        mDbInst = this.this$0.getMDbInst();
        final DBServiceImplV4 dBServiceImplV4 = this.this$0;
        final ArrayList<SyncLogV4> arrayList = this.$logs;
        final SyncCursor syncCursor = this.$newCursor;
        mDbInst.runInTransaction(new Runnable() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$insertSyncLogAndCursor$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DBServiceImplV4$insertSyncLogAndCursor$1.m942invoke$lambda0(DBServiceImplV4.this, arrayList, syncCursor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m942invoke$lambda0(DBServiceImplV4 dBServiceImplV4, ArrayList arrayList, SyncCursor syncCursor) {
        SyncDaoV4 mSyncDao;
        BusinessDao mBusinessDao;
        Intrinsics.checkNotNullParameter(dBServiceImplV4, "this$0");
        Intrinsics.checkNotNullParameter(arrayList, "$logs");
        Intrinsics.checkNotNullParameter(syncCursor, "$newCursor");
        mSyncDao = dBServiceImplV4.getMSyncDao();
        mSyncDao.insertSyncLogs(arrayList);
        mBusinessDao = dBServiceImplV4.getMBusinessDao();
        mBusinessDao.insertSyncCursor(CollectionsKt.arrayListOf(new SyncCursor[]{syncCursor}));
    }
}
