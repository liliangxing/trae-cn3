package com.bytedance.sync.p005v4.presistence;

import com.bytedance.sync.p005v4.presistence.dao.BusinessDao;
import com.bytedance.sync.p005v4.presistence.table.Business;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DBServiceImplV4.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DBServiceImplV4$updateSyncCursorAndBusiness$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<Business> $businesses;
    final /* synthetic */ List<String> $pendingDelete;
    final /* synthetic */ List<SyncCursor> $syncCursors;
    final /* synthetic */ DBServiceImplV4 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBServiceImplV4$updateSyncCursorAndBusiness$1(DBServiceImplV4 dBServiceImplV4, List<? extends Business> list, List<SyncCursor> list2, List<String> list3) {
        super(0);
        this.this$0 = dBServiceImplV4;
        this.$businesses = list;
        this.$syncCursors = list2;
        this.$pendingDelete = list3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m971invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m971invoke() {
        AppDatabaseV4 mDbInst;
        mDbInst = this.this$0.getMDbInst();
        final DBServiceImplV4 dBServiceImplV4 = this.this$0;
        final List<Business> list = this.$businesses;
        final List<SyncCursor> list2 = this.$syncCursors;
        final List<String> list3 = this.$pendingDelete;
        mDbInst.runInTransaction(new Runnable() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$updateSyncCursorAndBusiness$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DBServiceImplV4$updateSyncCursorAndBusiness$1.m970invoke$lambda0(DBServiceImplV4.this, list, list2, list3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m970invoke$lambda0(DBServiceImplV4 dBServiceImplV4, List list, List list2, List list3) {
        BusinessDao mBusinessDao;
        BusinessDao mBusinessDao2;
        BusinessDao mBusinessDao3;
        Intrinsics.checkNotNullParameter(dBServiceImplV4, "this$0");
        Intrinsics.checkNotNullParameter(list, "$businesses");
        Intrinsics.checkNotNullParameter(list2, "$syncCursors");
        Intrinsics.checkNotNullParameter(list3, "$pendingDelete");
        mBusinessDao = dBServiceImplV4.getMBusinessDao();
        mBusinessDao.insertBusiness(list);
        mBusinessDao2 = dBServiceImplV4.getMBusinessDao();
        mBusinessDao2.insertSyncCursor(list2);
        mBusinessDao3 = dBServiceImplV4.getMBusinessDao();
        mBusinessDao3.deleteSyncCursor(list3);
    }
}
