package com.bytedance.sync.p005v4.presistence;

import android.content.Context;
import android.util.Log;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.SyncConstants;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.presistence.dao.BusinessDao;
import com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4;
import com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4;
import com.bytedance.sync.p005v4.presistence.table.Business;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.presistence.table.SyncHistoryLogV4;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
import com.bytedance.sync.p005v4.protocal.Bucket;
import com.bytedance.sync.p005v4.protocal.ConsumeType;
import com.bytedance.sync.p005v4.protocal.PacketStatus;
import com.bytedance.sync.p005v4.protocal.TopicType;
import com.bytedance.sync.p005v4.utils.ProcessLock;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.bytedance.sync.util.UidHelper;
import com.bytedance.tracing.internal.TracingConstants;
import com.ss.android.ug.bus.UgBusFramework;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: DBServiceImplV4.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J%\u00100\u001a\u0004\u0018\u0001H1\"\u0004\b\u0000\u001012\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H103H\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020-H\u0016J\u0010\u00106\u001a\u00020-2\u0006\u00107\u001a\u000208H\u0016J\u0016\u00109\u001a\u00020-2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0016J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0006H\u0016J\u0016\u0010@\u001a\u00020>2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0;H\u0016J\b\u0010C\u001a\u00020-H\u0016J\u0018\u0010D\u001a\u00020-2\u0006\u0010?\u001a\u0002082\u0006\u0010E\u001a\u000208H\u0016J \u0010F\u001a\u00020-2\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020<0Hj\b\u0012\u0004\u0012\u00020<`IH\u0016J(\u0010J\u001a\u00020-2\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020B0Hj\b\u0012\u0004\u0012\u00020B`I2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u0002082\u0006\u0010O\u001a\u00020PH\u0016J\u0016\u0010Q\u001a\u0002082\f\u0010R\u001a\b\u0012\u0004\u0012\u00020P0;H\u0016J\u000e\u0010S\u001a\b\u0012\u0004\u0012\u00020M0TH\u0016J0\u0010U\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u0002082\b\u0010Y\u001a\u0004\u0018\u00010\u00062\u0006\u0010Z\u001a\u00020[H\u0016J\u001e\u0010\\\u001a\b\u0012\u0004\u0012\u00020P0T2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020[H\u0016J0\u0010]\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010V\u001a\u00020W2\u0006\u0010^\u001a\u0002082\b\u0010Y\u001a\u0004\u0018\u00010\u00062\u0006\u0010Z\u001a\u00020[H\u0016J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020`0TH\u0016J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020M0;2\u0006\u0010b\u001a\u00020cH\u0016J\u0012\u0010d\u001a\u0004\u0018\u00010M2\u0006\u0010?\u001a\u000208H\u0016J\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020M0T2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00060;H\u0016J\u0018\u0010g\u001a\u00020/2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010^\u001a\u000208H\u0016J\u001e\u0010h\u001a\b\u0012\u0004\u0012\u00020/0;2\u0006\u0010Z\u001a\u00020[2\u0006\u0010i\u001a\u00020[H\u0016J<\u0010j\u001a\b\u0012\u0004\u0012\u00020B0;2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002080k2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020[2\u0006\u0010i\u001a\u00020[2\u0006\u0010o\u001a\u000208H\u0016J.\u0010p\u001a\b\u0012\u0004\u0012\u00020B0;2\u0006\u0010^\u001a\u0002082\u0006\u0010Z\u001a\u00020[2\u0006\u0010i\u001a\u00020[2\u0006\u0010o\u001a\u000208H\u0016J&\u0010q\u001a\b\u0012\u0004\u0012\u00020P0;2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u00062\u0006\u0010n\u001a\u00020[H\u0016J.\u0010q\u001a\b\u0012\u0004\u0012\u00020P0;2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u00062\u0006\u0010u\u001a\u00020\u00062\u0006\u0010n\u001a\u00020[H\u0016J\b\u0010v\u001a\u00020-H\u0016J\u001e\u0010w\u001a\u00020>2\u0006\u0010x\u001a\u00020/2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020B0;H\u0016J2\u0010z\u001a\u00020-2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020M0T2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00060;2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020`0;H\u0016J\u001f\u0010~\u001a\u00020>2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020P0;2\u0007\u0010\u0080\u0001\u001a\u00020MH\u0016J/\u0010\u0081\u0001\u001a\u00020>2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020P0;2\u0007\u0010\u0080\u0001\u001a\u00020M2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020P0;H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R#\u0010\"\u001a\n \t*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R#\u0010'\u001a\n \t*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b)\u0010*¨\u0006\u0083\u0001"}, d2 = {"Lcom/bytedance/sync/v4/presistence/DBServiceImplV4;", "Lcom/bytedance/sync/v4/intf/IDBServiceV4;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "mBusinessDao", "Lcom/bytedance/sync/v4/presistence/dao/BusinessDao;", "kotlin.jvm.PlatformType", "getMBusinessDao", "()Lcom/bytedance/sync/v4/presistence/dao/BusinessDao;", "mBusinessDao$delegate", "Lkotlin/Lazy;", "mDbInst", "Lcom/bytedance/sync/v4/presistence/AppDatabaseV4;", "getMDbInst", "()Lcom/bytedance/sync/v4/presistence/AppDatabaseV4;", "mDbInst$delegate", "mHistoryDao", "Lcom/bytedance/sync/v4/presistence/dao/HistoryDaoV4;", "getMHistoryDao", "()Lcom/bytedance/sync/v4/presistence/dao/HistoryDaoV4;", "mHistoryDao$delegate", "mProcessLock", "Lcom/bytedance/sync/v4/utils/ProcessLock;", "getMProcessLock", "()Lcom/bytedance/sync/v4/utils/ProcessLock;", "mProcessLock$delegate", "mProcessLockFileDir", "Ljava/io/File;", "getMProcessLockFileDir", "()Ljava/io/File;", "mProcessLockFileDir$delegate", "mSyncDao", "Lcom/bytedance/sync/v4/presistence/dao/SyncDaoV4;", "getMSyncDao", "()Lcom/bytedance/sync/v4/presistence/dao/SyncDaoV4;", "mSyncDao$delegate", "mUpStreamDao", "Lcom/bytedance/sync/v3/presistence/dao/UploadDaoV4;", "getMUpStreamDao", "()Lcom/bytedance/sync/v3/presistence/dao/UploadDaoV4;", "mUpStreamDao$delegate", "changeSnapshotToNotified", "", "it", "Lcom/bytedance/sync/v4/presistence/table/Snapshot;", "databaseOpHandle", "T", "opFunc", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deleteAllTableData", "deleteExpireSyncLog", "ts", "", "deleteHistorySyncLog", "deleteHistoryLogs", "", "Lcom/bytedance/sync/v4/presistence/table/SyncHistoryLogV4;", "deleteLocalData", "", "syncId", "deleteSyncLog", "obj", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "deleteUpStreamMsgIfBusinessNotExist", "deleteUploadData", "cursor", "insertHistorySyncLog", "historyLogs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "insertSyncLogAndCursor", TracingConstants.KEY_LOGS, "newCursor", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "insertUpStreamItem", "item", "Lcom/bytedance/sync/v4/presistence/table/UploadItemV4;", "insertUpStreamItemList", "items", "queryAllLocalSyncCursorInfo", "", "queryDeleteHistorySyncLog", "topicType", "Lcom/bytedance/sync/v4/protocal/TopicType;", "businessId", "topic", "limit", "", "queryDistributeMsgs", "queryHistorySyncLog", "business", "queryLocalBusinesses", "Lcom/bytedance/sync/v4/presistence/table/Business;", "queryLocalSyncCursorInfoWithDeviceInfo", "deviceInfo", "Lcom/bytedance/sync/user/AccountEventSynchronizer$DeviceInfo;", "queryLocalSyncCursorInfoWithSyncId", "queryLocalSyncCursorInfoWithSyncIds", "syncIds", "querySnapshot", "querySnapshots", "offset", "querySyncLogs", "", "packetStatus", "Lcom/bytedance/sync/v4/protocal/PacketStatus;", "size", "curTs", "querySyncLogsByBusiness", "queryUploadMsgByDeviceInfo", "bucket", "Lcom/bytedance/sync/v4/protocal/Bucket;", "did", "uid", "resetAllCursor", "updateSnapshotAndDeleteSyncLog", IFileDataCacheService.TYPE_SNAPSHOT, "syncLogs", "updateSyncCursorAndBusiness", "syncCursors", "pendingDelete", "businesses", "updateUploadCursor", "undistributedUploads", "syncCursor", "updateUploadCursorAndDelete", "pendingDeleteList", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DBServiceImplV4 implements IDBServiceV4 {
    private final String TAG;

    /* renamed from: mBusinessDao$delegate, reason: from kotlin metadata */
    private final Lazy mBusinessDao;
    private final Context mContext;

    /* renamed from: mDbInst$delegate, reason: from kotlin metadata */
    private final Lazy mDbInst;

    /* renamed from: mHistoryDao$delegate, reason: from kotlin metadata */
    private final Lazy mHistoryDao;

    /* renamed from: mProcessLock$delegate, reason: from kotlin metadata */
    private final Lazy mProcessLock;

    /* renamed from: mProcessLockFileDir$delegate, reason: from kotlin metadata */
    private final Lazy mProcessLockFileDir;

    /* renamed from: mSyncDao$delegate, reason: from kotlin metadata */
    private final Lazy mSyncDao;

    /* renamed from: mUpStreamDao$delegate, reason: from kotlin metadata */
    private final Lazy mUpStreamDao;

    public DBServiceImplV4(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.TAG = "[DBServiceImplV4] ";
        this.mDbInst = LazyKt.lazy(new Function0<AppDatabaseV4>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$mDbInst$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AppDatabaseV4 m947invoke() {
                Context context2;
                context2 = DBServiceImplV4.this.mContext;
                RoomDatabase.Builder databaseBuilder = Room.databaseBuilder(context2, AppDatabaseV4.class, SyncConstants.DB_V4);
                Intrinsics.checkNotNullExpressionValue(databaseBuilder, "databaseBuilder(mContext…ava, SyncConstants.DB_V4)");
                RoomDatabase build = databaseBuilder.build();
                Intrinsics.checkNotNullExpressionValue(build, "dbBuilder.build()");
                return (AppDatabaseV4) build;
            }
        });
        this.mUpStreamDao = LazyKt.lazy(new Function0<UploadDaoV4>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$mUpStreamDao$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final UploadDaoV4 m952invoke() {
                AppDatabaseV4 mDbInst;
                mDbInst = DBServiceImplV4.this.getMDbInst();
                return mDbInst.upStreamDao();
            }
        });
        this.mBusinessDao = LazyKt.lazy(new Function0<BusinessDao>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$mBusinessDao$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BusinessDao m946invoke() {
                AppDatabaseV4 mDbInst;
                mDbInst = DBServiceImplV4.this.getMDbInst();
                return mDbInst.businessDao();
            }
        });
        this.mSyncDao = LazyKt.lazy(new Function0<SyncDaoV4>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$mSyncDao$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SyncDaoV4 m951invoke() {
                AppDatabaseV4 mDbInst;
                mDbInst = DBServiceImplV4.this.getMDbInst();
                return mDbInst.syncDao();
            }
        });
        this.mHistoryDao = LazyKt.lazy(new Function0<HistoryDaoV4>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$mHistoryDao$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final HistoryDaoV4 m948invoke() {
                AppDatabaseV4 mDbInst;
                mDbInst = DBServiceImplV4.this.getMDbInst();
                return mDbInst.historyDao();
            }
        });
        this.mProcessLockFileDir = LazyKt.lazy(new Function0<File>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$mProcessLockFileDir$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final File m950invoke() {
                Context context2;
                context2 = DBServiceImplV4.this.mContext;
                return context2.getFilesDir().getAbsoluteFile();
            }
        });
        this.mProcessLock = LazyKt.lazy(new Function0<ProcessLock>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$mProcessLock$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ProcessLock m949invoke() {
                File mProcessLockFileDir;
                mProcessLockFileDir = DBServiceImplV4.this.getMProcessLockFileDir();
                return new ProcessLock("sync_sdk", mProcessLockFileDir);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppDatabaseV4 getMDbInst() {
        return (AppDatabaseV4) this.mDbInst.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UploadDaoV4 getMUpStreamDao() {
        return (UploadDaoV4) this.mUpStreamDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BusinessDao getMBusinessDao() {
        return (BusinessDao) this.mBusinessDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SyncDaoV4 getMSyncDao() {
        return (SyncDaoV4) this.mSyncDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HistoryDaoV4 getMHistoryDao() {
        return (HistoryDaoV4) this.mHistoryDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getMProcessLockFileDir() {
        Object value = this.mProcessLockFileDir.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mProcessLockFileDir>(...)");
        return (File) value;
    }

    private final ProcessLock getMProcessLock() {
        return (ProcessLock) this.mProcessLock.getValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:2|3|(6:8|(2:10|(4:21|22|23|24))(1:27)|14|15|16|17)|28|14|15|16|17) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <T> T databaseOpHandle(Function0<? extends T> opFunc) {
        try {
            Configuration config = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
            if (config.enableMultiProcess && getMProcessLock().processLockOk()) {
                if (!ToolUtils.isMainProcess(this.mContext)) {
                    if (ToolUtils.isMainProcessAlive(this.mContext) || !getMProcessLock().tryProcessLock()) {
                        LogUtils.m185d(this.TAG + "curProcess is " + ((Object) ToolUtils.getCurProcessName(this.mContext)) + ", main process is alive " + ToolUtils.isMainProcessAlive(this.mContext));
                        return null;
                    }
                } else {
                    getMProcessLock().processLock();
                }
                T t = (T) opFunc.invoke();
                getMProcessLock().unProcessLock();
                return t;
            }
            LogUtils.m185d(this.TAG + "mConfiguration enableMultiProcess: " + config.enableMultiProcess + ", mProcessLock lock ok : " + getMProcessLock().processLockOk());
            T t2 = (T) opFunc.invoke();
            getMProcessLock().unProcessLock();
            return t2;
        } catch (Throwable th) {
            try {
                LogUtils.m186e(this.TAG + "databaseOpHandle error: " + th);
                try {
                    getMProcessLock().unProcessLock();
                } catch (Throwable unused) {
                }
                return null;
            } finally {
                try {
                    getMProcessLock().unProcessLock();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public long insertUpStreamItem(final UploadItemV4 item) {
        Intrinsics.checkNotNullParameter(item, "item");
        databaseOpHandle(new Function0<Long>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$insertUpStreamItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Long m944invoke() {
                UploadDaoV4 mUpStreamDao;
                mUpStreamDao = DBServiceImplV4.this.getMUpStreamDao();
                return Long.valueOf(mUpStreamDao.insert(item));
            }
        });
        return 0L;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public long insertUpStreamItemList(final List<? extends UploadItemV4> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$insertUpStreamItemList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m945invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m945invoke() {
                UploadDaoV4 mUpStreamDao;
                mUpStreamDao = DBServiceImplV4.this.getMUpStreamDao();
                mUpStreamDao.insert(items);
            }
        });
        return 0L;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void deleteUpStreamMsgIfBusinessNotExist() {
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$deleteUpStreamMsgIfBusinessNotExist$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m939invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m939invoke() {
                UploadDaoV4 mUpStreamDao;
                mUpStreamDao = DBServiceImplV4.this.getMUpStreamDao();
                mUpStreamDao.deleteUpStreamMsgIfBusinessNotExist();
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<SyncCursor> queryLocalSyncCursorInfoWithSyncIds(final List<String> syncIds) {
        Intrinsics.checkNotNullParameter(syncIds, "syncIds");
        List<SyncCursor> list = (List) databaseOpHandle(new Function0<List<SyncCursor>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryLocalSyncCursorInfoWithSyncIds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<SyncCursor> invoke() {
                BusinessDao mBusinessDao;
                mBusinessDao = DBServiceImplV4.this.getMBusinessDao();
                return mBusinessDao.queryCommonSyncCursorWithSyncIds(syncIds);
            }
        });
        return list == null ? new ArrayList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public SyncCursor queryLocalSyncCursorInfoWithSyncId(final long syncId) {
        return (SyncCursor) databaseOpHandle(new Function0<SyncCursor>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryLocalSyncCursorInfoWithSyncId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SyncCursor m958invoke() {
                BusinessDao mBusinessDao;
                mBusinessDao = DBServiceImplV4.this.getMBusinessDao();
                return mBusinessDao.queryCommonSyncCursorWithSyncId(syncId);
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<SyncCursor> queryLocalSyncCursorInfoWithDeviceInfo(final AccountEventSynchronizer.DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        List<SyncCursor> list = (List) databaseOpHandle(new Function0<List<? extends SyncCursor>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryLocalSyncCursorInfoWithDeviceInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<SyncCursor> invoke() {
                String str;
                ArrayList arrayList;
                BusinessDao mBusinessDao;
                try {
                    mBusinessDao = DBServiceImplV4.this.getMBusinessDao();
                    String str2 = deviceInfo.did;
                    Intrinsics.checkNotNullExpressionValue(str2, "deviceInfo.did");
                    arrayList = mBusinessDao.queryCommonSyncCursorWithDid(str2);
                } catch (Throwable th) {
                    str = DBServiceImplV4.this.TAG;
                    LogUtils.m186e(Intrinsics.stringPlus(str, Log.getStackTraceString(th)));
                    SyncMonitor.monitorException(th, "exception when queryLocalSyncCursorInfo");
                    arrayList = new ArrayList();
                }
                AccountEventSynchronizer.DeviceInfo deviceInfo2 = deviceInfo;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    SyncCursor syncCursor = (SyncCursor) obj;
                    if (syncCursor.bucket == Bucket.Device || UidHelper.isSameUser(syncCursor.uid, deviceInfo2.uid)) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<SyncCursor> queryAllLocalSyncCursorInfo() {
        List<SyncCursor> list = (List) databaseOpHandle(new Function0<List<SyncCursor>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryAllLocalSyncCursorInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final List<SyncCursor> invoke() {
                BusinessDao mBusinessDao;
                mBusinessDao = DBServiceImplV4.this.getMBusinessDao();
                return mBusinessDao.queryAllCommonSyncCursors();
            }
        });
        return list == null ? new ArrayList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void updateSyncCursorAndBusiness(List<SyncCursor> syncCursors, List<String> pendingDelete, List<? extends Business> businesses) {
        Intrinsics.checkNotNullParameter(syncCursors, "syncCursors");
        Intrinsics.checkNotNullParameter(pendingDelete, "pendingDelete");
        Intrinsics.checkNotNullParameter(businesses, "businesses");
        databaseOpHandle(new DBServiceImplV4$updateSyncCursorAndBusiness$1(this, businesses, syncCursors, pendingDelete));
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<Business> queryLocalBusinesses() {
        List<Business> list = (List) databaseOpHandle(new Function0<List<Business>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryLocalBusinesses$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final List<Business> invoke() {
                BusinessDao mBusinessDao;
                mBusinessDao = DBServiceImplV4.this.getMBusinessDao();
                return mBusinessDao.queryBusinesses();
            }
        });
        return list == null ? new ArrayList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void insertSyncLogAndCursor(ArrayList<SyncLogV4> logs, SyncCursor newCursor) {
        Intrinsics.checkNotNullParameter(logs, TracingConstants.KEY_LOGS);
        Intrinsics.checkNotNullParameter(newCursor, "newCursor");
        databaseOpHandle(new DBServiceImplV4$insertSyncLogAndCursor$1(this, logs, newCursor));
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void resetAllCursor() {
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$resetAllCursor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m966invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m966invoke() {
                AppDatabaseV4 mDbInst;
                mDbInst = DBServiceImplV4.this.getMDbInst();
                mDbInst.businessDao().resetAllCursor();
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<SyncLogV4> querySyncLogs(final Set<Long> syncIds, final PacketStatus packetStatus, final int size, final int offset, final long curTs) {
        Intrinsics.checkNotNullParameter(syncIds, "syncIds");
        Intrinsics.checkNotNullParameter(packetStatus, "packetStatus");
        List<SyncLogV4> list = (List) databaseOpHandle(new Function0<List<? extends SyncLogV4>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$querySyncLogs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<SyncLogV4> invoke() {
                SyncDaoV4 mSyncDao;
                mSyncDao = DBServiceImplV4.this.getMSyncDao();
                return mSyncDao.queryAllLogs(syncIds, packetStatus, size, offset, curTs);
            }
        });
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public boolean deleteSyncLog(final List<? extends SyncLogV4> obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Boolean bool = (Boolean) databaseOpHandle(new Function0<Boolean>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$deleteSyncLog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m938invoke() {
                SyncDaoV4 mSyncDao;
                boolean z = false;
                try {
                    mSyncDao = DBServiceImplV4.this.getMSyncDao();
                    if (mSyncDao.delete(obj) > 0) {
                        z = true;
                    }
                } catch (Exception e) {
                    SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when deleteSyncLog");
                }
                return Boolean.valueOf(z);
            }
        });
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public Snapshot querySnapshot(final String syncId, final long business) {
        Intrinsics.checkNotNullParameter(syncId, "syncId");
        Snapshot snapshot = (Snapshot) databaseOpHandle(new Function0<Snapshot>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$querySnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Snapshot m960invoke() {
                SyncDaoV4 mSyncDao;
                mSyncDao = DBServiceImplV4.this.getMSyncDao();
                return mSyncDao.querySnapshot(syncId, business);
            }
        });
        return snapshot == null ? new Snapshot() : snapshot;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<Snapshot> querySnapshots(final int limit, final int offset) {
        List<Snapshot> list = (List) databaseOpHandle(new Function0<List<? extends Snapshot>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$querySnapshots$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<Snapshot> invoke() {
                SyncDaoV4 mSyncDao;
                mSyncDao = DBServiceImplV4.this.getMSyncDao();
                return mSyncDao.querySnapshots(limit, offset);
            }
        });
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public boolean updateSnapshotAndDeleteSyncLog(Snapshot snapshot, List<? extends SyncLogV4> syncLogs) {
        Intrinsics.checkNotNullParameter(snapshot, IFileDataCacheService.TYPE_SNAPSHOT);
        Intrinsics.checkNotNullParameter(syncLogs, "syncLogs");
        Boolean bool = (Boolean) databaseOpHandle(new DBServiceImplV4$updateSnapshotAndDeleteSyncLog$1(this, snapshot, syncLogs));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void changeSnapshotToNotified(final Snapshot it) {
        Intrinsics.checkNotNullParameter(it, "it");
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$changeSnapshotToNotified$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m932invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m932invoke() {
                SyncDaoV4 mSyncDao;
                mSyncDao = DBServiceImplV4.this.getMSyncDao();
                mSyncDao.changeSnapshotToNotified(it);
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<SyncLogV4> querySyncLogsByBusiness(final long business, final int limit, final int offset, final long curTs) {
        List<SyncLogV4> list = (List) databaseOpHandle(new Function0<List<? extends SyncLogV4>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$querySyncLogsByBusiness$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<SyncLogV4> invoke() {
                String str;
                SyncDaoV4 mSyncDao;
                try {
                    mSyncDao = DBServiceImplV4.this.getMSyncDao();
                    return mSyncDao.querySyncLogs(business, limit, ConsumeType.OneByOne, offset, curTs);
                } catch (Throwable th) {
                    str = DBServiceImplV4.this.TAG;
                    LogUtils.m186e(Intrinsics.stringPlus(str, Log.getStackTraceString(th)));
                    SDKMonitor.inst().ensureNotReachHere(th, th.getMessage());
                    return Collections.emptyList();
                }
            }
        });
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<UploadItemV4> queryUploadMsgByDeviceInfo(final Bucket bucket, final String did, final int size) {
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Intrinsics.checkNotNullParameter(did, "did");
        List<UploadItemV4> list = (List) databaseOpHandle(new Function0<List<? extends UploadItemV4>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryUploadMsgByDeviceInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<UploadItemV4> invoke() {
                UploadDaoV4 mUpStreamDao;
                mUpStreamDao = DBServiceImplV4.this.getMUpStreamDao();
                return mUpStreamDao.queryUploadMsgByDeviceInfo(bucket, did, size);
            }
        });
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<UploadItemV4> queryUploadMsgByDeviceInfo(final Bucket bucket, final String did, final String uid, final int size) {
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(uid, "uid");
        List<UploadItemV4> list = (List) databaseOpHandle(new Function0<List<? extends UploadItemV4>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryUploadMsgByDeviceInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<UploadItemV4> invoke() {
                UploadDaoV4 mUpStreamDao;
                mUpStreamDao = DBServiceImplV4.this.getMUpStreamDao();
                return mUpStreamDao.queryUploadMsgByDeviceInfo(bucket, did, uid, size);
            }
        });
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public boolean updateUploadCursor(List<? extends UploadItemV4> undistributedUploads, SyncCursor syncCursor) {
        Intrinsics.checkNotNullParameter(undistributedUploads, "undistributedUploads");
        Intrinsics.checkNotNullParameter(syncCursor, "syncCursor");
        Boolean bool = (Boolean) databaseOpHandle(new DBServiceImplV4$updateUploadCursor$1(this, undistributedUploads, syncCursor));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public boolean updateUploadCursorAndDelete(List<? extends UploadItemV4> undistributedUploads, SyncCursor syncCursor, List<? extends UploadItemV4> pendingDeleteList) {
        Intrinsics.checkNotNullParameter(undistributedUploads, "undistributedUploads");
        Intrinsics.checkNotNullParameter(syncCursor, "syncCursor");
        Intrinsics.checkNotNullParameter(pendingDeleteList, "pendingDeleteList");
        Boolean bool = (Boolean) databaseOpHandle(new DBServiceImplV4$updateUploadCursorAndDelete$1(this, undistributedUploads, pendingDeleteList, syncCursor));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<UploadItemV4> queryDistributeMsgs(final String syncId, final int limit) {
        Intrinsics.checkNotNullParameter(syncId, "syncId");
        Object databaseOpHandle = databaseOpHandle(new Function0<List<UploadItemV4>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryDistributeMsgs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<UploadItemV4> invoke() {
                UploadDaoV4 mUpStreamDao;
                mUpStreamDao = DBServiceImplV4.this.getMUpStreamDao();
                return mUpStreamDao.queryDistributeMsgs(syncId, limit);
            }
        });
        if (databaseOpHandle != null) {
            return TypeIntrinsics.asMutableList(databaseOpHandle);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.sync.v4.presistence.table.UploadItemV4>");
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void deleteUploadData(final long syncId, final long cursor) {
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$deleteUploadData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m940invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m940invoke() {
                UploadDaoV4 mUpStreamDao;
                mUpStreamDao = DBServiceImplV4.this.getMUpStreamDao();
                mUpStreamDao.deleteUploadData(syncId, cursor);
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public boolean deleteLocalData(String syncId) {
        Intrinsics.checkNotNullParameter(syncId, "syncId");
        Boolean bool = (Boolean) databaseOpHandle(new DBServiceImplV4$deleteLocalData$1(this, syncId));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<SyncHistoryLogV4> queryHistorySyncLog(final TopicType topicType, final long business, final String topic, final int limit) {
        Intrinsics.checkNotNullParameter(topicType, "topicType");
        List<SyncHistoryLogV4> list = (List) databaseOpHandle(new Function0<List<? extends SyncHistoryLogV4>>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$queryHistorySyncLog$1

            /* compiled from: DBServiceImplV4.kt */
            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[TopicType.values().length];
                    iArr[TopicType.SpecTopic.ordinal()] = 1;
                    iArr[TopicType.CustomTopic.ordinal()] = 2;
                    iArr[TopicType.GlobalTopic.ordinal()] = 3;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<SyncHistoryLogV4> invoke() {
                String str;
                HistoryDaoV4 mHistoryDao;
                HistoryDaoV4 mHistoryDao2;
                HistoryDaoV4 mHistoryDao3;
                try {
                    AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
                    int i = WhenMappings.$EnumSwitchMapping$0[TopicType.this.ordinal()];
                    if (i == 1) {
                        mHistoryDao = this.getMHistoryDao();
                        String str2 = deviceInfo.did;
                        Intrinsics.checkNotNullExpressionValue(str2, "deviceInfo.did");
                        String str3 = deviceInfo.uid;
                        Intrinsics.checkNotNullExpressionValue(str3, "deviceInfo.uid");
                        return mHistoryDao.queryHistorySpecSyncLogs(str2, str3, business, TopicType.this, limit);
                    }
                    if (i == 2) {
                        String sb = new StringBuilder().append(business).append(':').append((Object) topic).toString();
                        mHistoryDao2 = this.getMHistoryDao();
                        String str4 = deviceInfo.did;
                        Intrinsics.checkNotNullExpressionValue(str4, "deviceInfo.did");
                        String str5 = deviceInfo.uid;
                        Intrinsics.checkNotNullExpressionValue(str5, "deviceInfo.uid");
                        return mHistoryDao2.queryHistoryCustomSyncLogs(str4, str5, business, TopicType.this, sb, limit);
                    }
                    if (i == 3) {
                        mHistoryDao3 = this.getMHistoryDao();
                        String str6 = deviceInfo.did;
                        Intrinsics.checkNotNullExpressionValue(str6, "deviceInfo.did");
                        String str7 = deviceInfo.uid;
                        Intrinsics.checkNotNullExpressionValue(str7, "deviceInfo.uid");
                        return mHistoryDao3.queryHistoryGlobalSyncLogs(str6, str7, business, TopicType.this, limit);
                    }
                    return CollectionsKt.emptyList();
                } catch (Throwable th) {
                    str = this.TAG;
                    LogUtils.m186e(Intrinsics.stringPlus(str, Log.getStackTraceString(th)));
                    return CollectionsKt.emptyList();
                }
            }
        });
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public List<SyncHistoryLogV4> queryDeleteHistorySyncLog(TopicType topicType, long businessId, String topic, int limit) {
        Intrinsics.checkNotNullParameter(topicType, "topicType");
        try {
            List<SyncHistoryLogV4> queryHistorySyncLog = queryHistorySyncLog(topicType, businessId, topic, -1);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : queryHistorySyncLog) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (i >= limit) {
                    arrayList.add(obj);
                }
                i = i2;
            }
            return arrayList;
        } catch (Throwable th) {
            LogUtils.m186e(Intrinsics.stringPlus(this.TAG, Log.getStackTraceString(th)));
            SyncMonitor.monitorException(th, Intrinsics.stringPlus("deleteLimitHistorySyncLog failed, error: ", Log.getStackTraceString(th)));
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void deleteHistorySyncLog(final List<? extends SyncHistoryLogV4> deleteHistoryLogs) {
        Intrinsics.checkNotNullParameter(deleteHistoryLogs, "deleteHistoryLogs");
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$deleteHistorySyncLog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m935invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m935invoke() {
                HistoryDaoV4 mHistoryDao;
                mHistoryDao = DBServiceImplV4.this.getMHistoryDao();
                mHistoryDao.deleteHistorySyncLogs(deleteHistoryLogs);
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void insertHistorySyncLog(final ArrayList<SyncHistoryLogV4> historyLogs) {
        Intrinsics.checkNotNullParameter(historyLogs, "historyLogs");
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$insertHistorySyncLog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m941invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m941invoke() {
                String str;
                HistoryDaoV4 mHistoryDao;
                try {
                    mHistoryDao = DBServiceImplV4.this.getMHistoryDao();
                    mHistoryDao.insertHistorySyncLogs(historyLogs);
                } catch (Throwable th) {
                    str = DBServiceImplV4.this.TAG;
                    LogUtils.m186e(Intrinsics.stringPlus(str, Log.getStackTraceString(th)));
                    SyncMonitor.monitorException(th, Intrinsics.stringPlus("insertHistorySyncLog failed, error: ", Log.getStackTraceString(th)));
                }
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void deleteExpireSyncLog(final long ts) {
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$deleteExpireSyncLog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m934invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m934invoke() {
                String str;
                SyncDaoV4 mSyncDao;
                try {
                    mSyncDao = DBServiceImplV4.this.getMSyncDao();
                    mSyncDao.deleteExpireSyncLog(ts);
                } catch (Exception e) {
                    str = DBServiceImplV4.this.TAG;
                    LogUtils.m186e(Intrinsics.stringPlus(str, Log.getStackTraceString(e)));
                }
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IDBServiceV4
    public void deleteAllTableData() {
        databaseOpHandle(new Function0<Unit>() { // from class: com.bytedance.sync.v4.presistence.DBServiceImplV4$deleteAllTableData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m933invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m933invoke() {
                String str;
                AppDatabaseV4 mDbInst;
                String str2;
                try {
                    mDbInst = DBServiceImplV4.this.getMDbInst();
                    mDbInst.clearAllTables();
                    str2 = DBServiceImplV4.this.TAG;
                    LogUtils.m187i(Intrinsics.stringPlus(str2, "try to clear all table data"));
                } catch (Exception e) {
                    str = DBServiceImplV4.this.TAG;
                    Exception exc = e;
                    LogUtils.m186e(Intrinsics.stringPlus(str, Log.getStackTraceString(exc)));
                    SDKMonitor.inst().ensureNotReachHere(exc, "error when delete syncLogV3 and syncCursor all data ");
                }
            }
        });
    }
}
