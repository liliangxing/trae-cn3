package com.bytedance.sync.p005v4.presistence;

import android.util.Log;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4;
import com.bytedance.sync.p005v4.presistence.dao.BusinessDao;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
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
final class DBServiceImplV4$updateUploadCursor$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ SyncCursor $syncCursor;
    final /* synthetic */ List<UploadItemV4> $undistributedUploads;
    final /* synthetic */ DBServiceImplV4 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBServiceImplV4$updateUploadCursor$1(DBServiceImplV4 dBServiceImplV4, List<? extends UploadItemV4> list, SyncCursor syncCursor) {
        super(0);
        this.this$0 = dBServiceImplV4;
        this.$undistributedUploads = list;
        this.$syncCursor = syncCursor;
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m974invoke() {
        String str;
        AppDatabaseV4 mDbInst;
        try {
            mDbInst = this.this$0.getMDbInst();
            final DBServiceImplV4 dBServiceImplV4 = this.this$0;
            final List<UploadItemV4> list = this.$undistributedUploads;
            final SyncCursor syncCursor = this.$syncCursor;
            return (Boolean) mDbInst.runInTransaction(new Callable() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$updateUploadCursor$1$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean m973invoke$lambda0;
                    m973invoke$lambda0 = DBServiceImplV4$updateUploadCursor$1.m973invoke$lambda0(DBServiceImplV4.this, list, syncCursor);
                    return m973invoke$lambda0;
                }
            });
        } catch (Exception e) {
            Exception exc = e;
            SDKMonitor.inst().ensureNotReachHere(exc, "execute sql failed when updateUploadCursor");
            str = this.this$0.TAG;
            LogUtils.m186e(Intrinsics.stringPlus(str, Log.getStackTraceString(exc)));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final Boolean m973invoke$lambda0(DBServiceImplV4 dBServiceImplV4, List list, SyncCursor syncCursor) {
        UploadDaoV4 mUpStreamDao;
        boolean z;
        BusinessDao mBusinessDao;
        Intrinsics.checkNotNullParameter(dBServiceImplV4, "this$0");
        Intrinsics.checkNotNullParameter(list, "$undistributedUploads");
        Intrinsics.checkNotNullParameter(syncCursor, "$syncCursor");
        mUpStreamDao = dBServiceImplV4.getMUpStreamDao();
        if (mUpStreamDao.update(list) > 0) {
            mBusinessDao = dBServiceImplV4.getMBusinessDao();
            String str = syncCursor.syncId;
            Intrinsics.checkNotNullExpressionValue(str, "syncCursor.syncId");
            if (mBusinessDao.updateReportCursor(str, syncCursor.reportCursor) > 0) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
