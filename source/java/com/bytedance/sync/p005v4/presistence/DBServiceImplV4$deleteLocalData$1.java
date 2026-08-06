package com.bytedance.sync.p005v4.presistence;

import android.util.Log;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.presistence.dao.BusinessDao;
import com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DBServiceImplV4.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DBServiceImplV4$deleteLocalData$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ String $syncId;
    final /* synthetic */ DBServiceImplV4 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBServiceImplV4$deleteLocalData$1(DBServiceImplV4 dBServiceImplV4, String str) {
        super(0);
        this.this$0 = dBServiceImplV4;
        this.$syncId = str;
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m937invoke() {
        String str;
        AppDatabaseV4 mDbInst;
        try {
            mDbInst = this.this$0.getMDbInst();
            final DBServiceImplV4 dBServiceImplV4 = this.this$0;
            final String str2 = this.$syncId;
            return (Boolean) mDbInst.runInTransaction(new Callable() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$deleteLocalData$1$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean m936invoke$lambda0;
                    m936invoke$lambda0 = DBServiceImplV4$deleteLocalData$1.m936invoke$lambda0(DBServiceImplV4.this, str2);
                    return m936invoke$lambda0;
                }
            });
        } catch (Exception e) {
            str = this.this$0.TAG;
            Exception exc = e;
            LogUtils.m186e(Intrinsics.stringPlus(str, Log.getStackTraceString(exc)));
            SDKMonitor.inst().ensureNotReachHere(exc, Intrinsics.stringPlus("error when delete ", this.$syncId));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final Boolean m936invoke$lambda0(DBServiceImplV4 dBServiceImplV4, String str) {
        SyncDaoV4 mSyncDao;
        SyncDaoV4 mSyncDao2;
        BusinessDao mBusinessDao;
        Intrinsics.checkNotNullParameter(dBServiceImplV4, "this$0");
        Intrinsics.checkNotNullParameter(str, "$syncId");
        mSyncDao = dBServiceImplV4.getMSyncDao();
        mSyncDao.deleteSyncId(str);
        mSyncDao2 = dBServiceImplV4.getMSyncDao();
        mSyncDao2.deleteSnapshot(str);
        mBusinessDao = dBServiceImplV4.getMBusinessDao();
        mBusinessDao.resetCursor(str);
        return true;
    }
}
