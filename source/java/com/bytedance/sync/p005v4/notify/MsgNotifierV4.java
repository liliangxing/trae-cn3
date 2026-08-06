package com.bytedance.sync.p005v4.notify;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.sync.BusinessManager;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.SyncBusiness;
import com.bytedance.sync.SyncEventCompat;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.DataType;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.protocal.Bucket;
import com.bytedance.sync.p005v4.protocal.PacketCtrl;
import com.bytedance.sync.p005v4.protocal.TopicType;
import com.bytedance.sync.p005v4.utils.UtilKtKt;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.bytedance.sync.util.JSONUtils;
import com.bytedance.sync.util.UidHelper;
import com.bytedance.timon.pipeline.BuildConfig;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: MsgNotifierV4.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 >2\u00020\u0001:\u0001>B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J=\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002¢\u0006\u0002\u0010!J+\u0010\u0014\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#J\u001c\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020#2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0(J\u001a\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010*\u001a\u00020 H\u0002J\u0012\u0010+\u001a\u00020\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0014\u00100\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0(J\u001a\u00101\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u00102\u001a\u00020#J\u0010\u00101\u001a\u00020\u00152\b\b\u0002\u00102\u001a\u00020#J\"\u00103\u001a\u00020\u00152\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0(2\b\b\u0002\u00105\u001a\u00020 H\u0002J \u00106\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\bH\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u001eH\u0002J$\u0010<\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010=\u001a\u00020 2\b\b\u0002\u00102\u001a\u00020#H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006?"}, d2 = {"Lcom/bytedance/sync/v4/notify/MsgNotifierV4;", "Landroid/os/Handler$Callback;", "configuration", "Lcom/bytedance/sync/Configuration;", "mBusinessManager", "Lcom/bytedance/sync/BusinessManager;", "(Lcom/bytedance/sync/Configuration;Lcom/bytedance/sync/BusinessManager;)V", "TAG", "", "mFileDataCache", "Lcom/bytedance/sync/interfaze/IFileDataCacheService;", "getMFileDataCache", "()Lcom/bytedance/sync/interfaze/IFileDataCacheService;", "mFileDataCache$delegate", "Lkotlin/Lazy;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "asyncNotify", "", "executor", "Ljava/util/concurrent/ExecutorService;", "listeners", "", "", "data", "Lcom/bytedance/sync/interfaze/ISyncClient$Data;", "syncLog", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "notifyCnt", "", "(Ljava/util/concurrent/ExecutorService;[Ljava/lang/Object;Lcom/bytedance/sync/interfaze/ISyncClient$Data;Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;I)V", "business", "", "([Ljava/lang/Object;Lcom/bytedance/sync/interfaze/ISyncClient$Data;J)V", "doNotifyBusiness", "doNotifyOnce", "businessId", "", "doNotifyOneByOneByBusiness", "currentOffset", "doNotifySnapshots", "handleMessage", "", "msg", "Landroid/os/Message;", "notifyOnce", "notifySnapshots", "delay", "onEventSubmit", "syncLogList", "result", "onMonitor", "sendCalibrationEvent", "syncId", "errMsg", "tryDeleteSyncLog", "obj", "tryNotifyOneByOne", "offset", "Companion", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MsgNotifierV4 implements Handler.Callback {
    private static final int MSG_WHAT_NOTICE_ONCE = 104;
    private static final int MSG_WHAT_NOTIFY_SNAPSHOT = 102;
    private static final int MSG_WHAT_NOTIFY_SYNC_LOG_WITH_BUSINESS = 103;
    private final String TAG;
    private final Configuration configuration;
    private final BusinessManager mBusinessManager;

    /* renamed from: mFileDataCache$delegate, reason: from kotlin metadata */
    private final Lazy mFileDataCache;

    /* renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler;

    /* compiled from: MsgNotifierV4.kt */
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

    public MsgNotifierV4(Configuration configuration, BusinessManager businessManager) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(businessManager, "mBusinessManager");
        this.configuration = configuration;
        this.mBusinessManager = businessManager;
        this.TAG = "[MsgNotifierV4] ";
        this.mFileDataCache = LazyKt.lazy(new Function0<IFileDataCacheService>() { // from class: com.bytedance.sync.v4.notify.MsgNotifierV4$mFileDataCache$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IFileDataCacheService m930invoke() {
                return (IFileDataCacheService) UgBusFramework.getService(IFileDataCacheService.class);
            }
        });
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.sync.v4.notify.MsgNotifierV4$mHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m931invoke() {
                return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get(), MsgNotifierV4.this);
            }
        });
    }

    private final IFileDataCacheService getMFileDataCache() {
        Object value = this.mFileDataCache.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mFileDataCache>(...)");
        return (IFileDataCacheService) value;
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    public final void notifyOnce(List<? extends SyncLogV4> syncLog) {
        Intrinsics.checkNotNullParameter(syncLog, "syncLog");
        getMHandler().obtainMessage(104, syncLog).sendToTarget();
    }

    public final void doNotifyBusiness(long business) {
        notifySnapshots(50L);
        tryNotifyOneByOne(business, 0, 50L);
    }

    public static /* synthetic */ void notifySnapshots$default(MsgNotifierV4 msgNotifierV4, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        msgNotifierV4.notifySnapshots(j);
    }

    public final void notifySnapshots(long delay) {
        getMHandler().removeMessages(102);
        getMHandler().sendMessageDelayed(getMHandler().obtainMessage(102), delay);
    }

    public static /* synthetic */ void notifySnapshots$default(MsgNotifierV4 msgNotifierV4, SyncLogV4 syncLogV4, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        msgNotifierV4.notifySnapshots(syncLogV4, j);
    }

    public final void notifySnapshots(SyncLogV4 syncLog, long delay) {
        doNotifySnapshots(syncLog);
    }

    static /* synthetic */ void tryNotifyOneByOne$default(MsgNotifierV4 msgNotifierV4, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        msgNotifierV4.tryNotifyOneByOne(j, i3, j2);
    }

    private final void tryNotifyOneByOne(long business, int offset, long delay) {
        getMHandler().removeMessages(103, Long.valueOf(business));
        Message obtainMessage = getMHandler().obtainMessage(103, Long.valueOf(business));
        obtainMessage.arg1 = offset;
        getMHandler().sendMessageDelayed(obtainMessage, delay);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 102) {
            getMHandler().removeMessages(102);
            doNotifySnapshots$default(this, null, 1, null);
        }
        if (msg.what == 104) {
            Object obj = msg.obj;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.sync.v4.presistence.table.SyncLogV4>");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : (List) obj) {
                Long valueOf = Long.valueOf(((SyncLogV4) obj2).business);
                Object obj3 = linkedHashMap.get(valueOf);
                if (obj3 == null) {
                    obj3 = (List) new ArrayList();
                    linkedHashMap.put(valueOf, obj3);
                }
                ((List) obj3).add(obj2);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                doNotifyOnce(((Number) entry.getKey()).longValue(), (List) entry.getValue());
            }
        }
        if (msg.what != 103) {
            return false;
        }
        Object obj4 = msg.obj;
        if (obj4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        long longValue = ((Long) obj4).longValue();
        int i = msg.arg1;
        getMHandler().removeMessages(103, Long.valueOf(longValue));
        doNotifyOneByOneByBusiness(longValue, i);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int doNotifyOnce(long businessId, List<? extends SyncLogV4> syncLog) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        Intrinsics.checkNotNullParameter(syncLog, "syncLog");
        try {
            ExecutorService callbackExecutors = UtilKtKt.callbackExecutors();
            SyncBusiness businessById = this.mBusinessManager.getBusinessById(businessId);
            if (businessById == null) {
                LogUtils.m187i(this.TAG + "business not register,ignore it. business = " + businessId);
                onEventSubmit(syncLog, 1);
                return -1;
            }
            Object[] connectOnDataUpdateListener = businessById.connectOnDataUpdateListener();
            if (connectOnDataUpdateListener != null) {
                if (!(connectOnDataUpdateListener.length == 0)) {
                    z = false;
                    if (!z) {
                        LogUtils.m185d(this.TAG + "listener is empty ,ignore it. business = " + businessId);
                        return -1;
                    }
                    ArrayList arrayList = new ArrayList();
                    AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
                    Intrinsics.checkNotNullExpressionValue(deviceInfo, "getService(IDeviceInfoGe…r::class.java).deviceInfo");
                    Iterator<T> it = syncLog.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = true;
                            break;
                        }
                        SyncLogV4 syncLogV4 = (SyncLogV4) it.next();
                        if (!TextUtils.equals(syncLogV4.did, deviceInfo.did)) {
                            LogUtils.m186e(this.TAG + "did is error ,not notify. did = " + ((Object) syncLogV4.did) + ", current = " + ((Object) deviceInfo.did));
                        } else if (syncLogV4.bucket == Bucket.User && !UidHelper.isSameUser(syncLogV4.uid, deviceInfo.uid)) {
                            LogUtils.m186e(this.TAG + "uid is error ,not notify. uid = " + ((Object) syncLogV4.uid) + ", current = " + ((Object) deviceInfo.uid));
                        } else {
                            ISyncClient.Data data = new ISyncClient.Data();
                            if (syncLogV4.dataType == DataType.FILE_PATH) {
                                IFileDataCacheService mFileDataCache = getMFileDataCache();
                                String str2 = syncLogV4.syncId;
                                Intrinsics.checkNotNullExpressionValue(str2, "it.syncId");
                                long parseLong = Long.parseLong(str2);
                                byte[] bArr = syncLogV4.data;
                                Intrinsics.checkNotNullExpressionValue(bArr, "it.data");
                                byte[] readDataV2 = mFileDataCache.readDataV2(parseLong, new String(bArr, Charsets.UTF_8));
                                if (readDataV2 == null) {
                                    String str3 = syncLogV4.syncId;
                                    Intrinsics.checkNotNullExpressionValue(str3, "it.syncId");
                                    sendCalibrationEvent(Long.parseLong(str3), "deserialization failed when submit syncLog");
                                    z2 = false;
                                    break;
                                }
                                data.data = readDataV2;
                            } else {
                                data.data = syncLogV4.data;
                            }
                            data.did = syncLogV4.did;
                            data.uid = syncLogV4.uid;
                            data.receiveTimeStamp = syncLogV4.receiveTs;
                            data.publishTimeStamp = syncLogV4.publishTs;
                            data.cursor = syncLogV4.syncCursor;
                            String str4 = syncLogV4.reqId;
                            if (str4 == null) {
                                str = null;
                                z3 = false;
                            } else {
                                z3 = false;
                                List split$default = StringsKt.split$default(str4, new char[]{':'}, false, 0, 6, (Object) null);
                                str = split$default == null ? null : (String) CollectionsKt.last(split$default);
                            }
                            data.topic = str;
                            Map<String, String> map = syncLogV4.extra;
                            data.msgId = map == null ? null : map.get("msg_id");
                            if (tryDeleteSyncLog(syncLogV4)) {
                                Intrinsics.checkNotNullExpressionValue(connectOnDataUpdateListener, "listener");
                                asyncNotify(callbackExecutors, connectOnDataUpdateListener, data, syncLogV4, 1);
                                if (syncLogV4.packetCtrl == PacketCtrl.NeedFin) {
                                    arrayList.add(syncLogV4);
                                }
                            } else {
                                LogUtils.m186e(this.TAG + "delete syncLog failed, not notify, syncId = " + syncLogV4.syncId + ", cursor = " + syncLogV4.syncCursor);
                                onEventSubmit(CollectionsKt.listOf(syncLogV4), 2);
                                z2 = z3;
                                break;
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ((ISyncMsgSenderV4) UgBusFramework.getService(ISyncMsgSenderV4.class)).sendSyncLogFinMsg(arrayList);
                    }
                    if (z2) {
                        return arrayList.size();
                    }
                    return -1;
                }
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            SDKMonitor.inst().ensureNotReachHere(e, null);
            return -1;
        }
    }

    private final boolean tryDeleteSyncLog(SyncLogV4 obj) {
        boolean deleteSyncLog = ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).deleteSyncLog(CollectionsKt.arrayListOf(new SyncLogV4[]{obj}));
        if (deleteSyncLog && obj.dataType == DataType.FILE_PATH) {
            IFileDataCacheService mFileDataCache = getMFileDataCache();
            byte[] bArr = obj.data;
            Intrinsics.checkNotNullExpressionValue(bArr, "obj.data");
            mFileDataCache.deleteFile(new String(bArr, Charsets.UTF_8));
        }
        return deleteSyncLog;
    }

    static /* synthetic */ void doNotifyOneByOneByBusiness$default(MsgNotifierV4 msgNotifierV4, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        msgNotifierV4.doNotifyOneByOneByBusiness(j, i);
    }

    private final void doNotifyOneByOneByBusiness(long business, int currentOffset) {
        Intrinsics.checkNotNullExpressionValue(((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo(), "getService(IDeviceInfoGe…r::class.java).deviceInfo");
        List<SyncLogV4> querySyncLogsByBusiness = ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).querySyncLogsByBusiness(business, 50, currentOffset, System.currentTimeMillis());
        List<SyncLogV4> list = querySyncLogsByBusiness;
        if (list == null || list.isEmpty()) {
            LogUtils.m187i(this.TAG + "submit one by one finished, business = " + business);
            return;
        }
        int doNotifyOnce = doNotifyOnce(business, querySyncLogsByBusiness);
        if (doNotifyOnce < 0) {
            return;
        }
        if (querySyncLogsByBusiness.size() >= 50) {
            LogUtils.m187i(this.TAG + "continue one by one, business = " + business);
            tryNotifyOneByOne$default(this, business, querySyncLogsByBusiness.size() - doNotifyOnce, 0L, 4, null);
        } else {
            LogUtils.m187i(this.TAG + "submit one by one finished, business = " + business);
        }
    }

    private final void asyncNotify(ExecutorService executor, final Object[] listeners, final ISyncClient.Data data, final SyncLogV4 syncLog, final int notifyCnt) {
        executor.submit(new Runnable() { // from class: com.bytedance.sync.v4.notify.MsgNotifierV4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MsgNotifierV4.m929asyncNotify$lambda4(SyncLogV4.this, this, data, notifyCnt, listeners);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: asyncNotify$lambda-4, reason: not valid java name */
    public static final void m929asyncNotify$lambda4(SyncLogV4 syncLogV4, MsgNotifierV4 msgNotifierV4, ISyncClient.Data data, int i, Object[] objArr) {
        Intrinsics.checkNotNullParameter(msgNotifierV4, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(objArr, "$listeners");
        if (syncLogV4 == null) {
            LogUtils.m186e(Intrinsics.stringPlus(msgNotifierV4.TAG, "asyncNotify syncLog is null !!!"));
            return;
        }
        msgNotifierV4.onMonitor(syncLogV4.business, data, i);
        onEventSubmit$default(msgNotifierV4, CollectionsKt.listOf(syncLogV4), 0, 2, null);
        msgNotifierV4.asyncNotify(objArr, data, syncLogV4.business);
    }

    private final void asyncNotify(Object[] listeners, ISyncClient.Data data, long business) {
        boolean z;
        RuntimeException runtimeException;
        LogUtils.m187i(this.TAG + "notify ->>>>>> business=" + business + ", data=" + data + " to " + listeners);
        int length = listeners.length;
        int i = 0;
        while (i < length) {
            Object obj = listeners[i];
            i++;
            try {
                ((OnDataUpdateListener) obj).onDataUpdate(data);
            } finally {
                if (!z) {
                }
            }
        }
    }

    static /* synthetic */ void onEventSubmit$default(MsgNotifierV4 msgNotifierV4, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        msgNotifierV4.onEventSubmit(list, i);
    }

    private final void onEventSubmit(List<? extends SyncLogV4> syncLogList, int result) {
        SyncLogV4 next;
        Map<String, String> map;
        String str;
        try {
            if (syncLogList.isEmpty()) {
                return;
            }
            Iterator<? extends SyncLogV4> it = syncLogList.iterator();
            while (it.hasNext() && (next = it.next()) != null && (map = next.extra) != null && Intrinsics.areEqual(map.get("hit_sampling"), "1")) {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                String str2 = map.get("msg_id");
                if (str2 == null) {
                    str2 = "";
                }
                JSONUtils.safePutParam(jSONObject, "msg_id", str2);
                JSONUtils.safePutParam(jSONObject, "biz_id", next.business);
                JSONUtils.safePutParam(jSONObject, "sync_id", next.syncId);
                JSONUtils.safePutParam(jSONObject, "cursor", next.syncCursor);
                String str3 = next.extra.get(Constant.KEY_CHANNEL);
                JSONUtils.safePutParam(jSONObject, "ev_channel", (str3 == null ? -1 : Integer.parseInt(str3)) == 0 ? "frontier" : "http");
                int i = WhenMappings.$EnumSwitchMapping$0[next.topicType.ordinal()];
                if (i == 1) {
                    str = "spec";
                } else if (i == 2) {
                    str = "custom";
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "global";
                }
                JSONUtils.safePutParam(jSONObject, "topic_type", str);
                JSONUtils.safePutParam(jSONObject, "step", "biz_recv");
                JSONUtils.safePutParam(jSONObject, "start_ms", System.currentTimeMillis());
                JSONUtils.safePutParam(jSONObject, "cost_ms", currentTimeMillis - next.publishTs);
                JSONUtils.safePutParam(jSONObject, "result", result == 0 ? "success" : "failed");
                if (result != 0) {
                    JSONUtils.safePutParam(jSONObject, "reason", "err");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("err", result == 1 ? "no_biz" : "db_err");
                    Unit unit = Unit.INSTANCE;
                    JSONUtils.safePutParam(jSONObject, "extra", jSONObject2.toString());
                }
                SyncEventCompat.onEvent("sync_sdk_event_biz", jSONObject);
            }
        } catch (Throwable th) {
            LogUtils.m186e(this.TAG + "onEventSubmit error: " + Log.getStackTraceString(th));
        }
    }

    private final void onMonitor(long business, ISyncClient.Data data, int notifyCnt) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("time_consuming", System.currentTimeMillis() - data.receiveTimeStamp);
        jSONObject.put("submit_cnt", notifyCnt);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("business", business);
        jSONObject2.put(BuildConfig.TIMON_COMPONENT_NAME, "submit");
        SyncMonitor.monitor$default("sync_sdk_pipeline", jSONObject2, jSONObject, null, 8, null);
    }

    public static /* synthetic */ void doNotifySnapshots$default(MsgNotifierV4 msgNotifierV4, SyncLogV4 syncLogV4, int i, Object obj) {
        if ((i & 1) != 0) {
            syncLogV4 = null;
        }
        msgNotifierV4.doNotifySnapshots(syncLogV4);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:41|(2:43|(3:45|46|47)(1:49))(1:58)|50|51|52|53|54|46|47) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01e6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01e7, code lost:
    
        r13 = r6;
        r0.printStackTrace();
        com.bytedance.sync.SDKMonitor.inst().ensureNotReachHere(r0, "execute sql failed when changeSnapshotToNotified.");
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doNotifySnapshots(SyncLogV4 syncLog) {
        boolean z;
        int i;
        LogUtils.m187i(Intrinsics.stringPlus(this.TAG, "doNotifySnapshots"));
        IDBServiceV4 iDBServiceV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
        ArrayList arrayList = new ArrayList();
        try {
            ExecutorService callbackExecutors = UtilKtKt.callbackExecutors();
            boolean z2 = true;
            int i2 = 0;
            while (z2) {
                try {
                    List<Snapshot> querySnapshots = iDBServiceV4.querySnapshots(50, i2);
                    List<Snapshot> list = querySnapshots;
                    if (list == null || list.isEmpty()) {
                        LogUtils.m187i(Intrinsics.stringPlus(this.TAG, "snapshots is null ,not notify"));
                        return;
                    }
                    int size = i2 + querySnapshots.size();
                    boolean z3 = querySnapshots.size() >= 50;
                    AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
                    Intrinsics.checkNotNullExpressionValue(deviceInfo, "getService(IDeviceInfoGe…r::class.java).deviceInfo");
                    IFileDataCacheService iFileDataCacheService = (IFileDataCacheService) UgBusFramework.getService(IFileDataCacheService.class);
                    for (Snapshot snapshot : querySnapshots) {
                        SyncBusiness businessById = this.mBusinessManager.getBusinessById(snapshot.business);
                        if (businessById == null) {
                            LogUtils.m187i(this.TAG + "business not register,ignore submit snapshot. business = " + snapshot.business);
                        } else {
                            Object[] connectOnDataUpdateListener = businessById.connectOnDataUpdateListener();
                            if (connectOnDataUpdateListener != null) {
                                if (!(connectOnDataUpdateListener.length == 0)) {
                                    z = false;
                                    if (!z) {
                                        LogUtils.m186e(this.TAG + "listener is null ,not notify.snapshot = " + snapshot + " business = " + snapshot.business);
                                    } else if (!TextUtils.equals(snapshot.did, deviceInfo.did)) {
                                        LogUtils.m186e(this.TAG + "did is error ,not notify. did = " + ((Object) snapshot.did) + ", current = " + ((Object) deviceInfo.did));
                                    } else if (snapshot.bucket == Bucket.User && !UidHelper.isSameUser(snapshot.uid, deviceInfo.uid)) {
                                        LogUtils.m186e(this.TAG + "uid is error ,not notify. uid = " + ((Object) snapshot.uid) + ", current = " + ((Object) deviceInfo.uid));
                                    } else {
                                        ISyncClient.Data data = new ISyncClient.Data();
                                        if (snapshot.dataType == DataType.FILE_PATH) {
                                            String str = snapshot.syncId;
                                            Intrinsics.checkNotNullExpressionValue(str, "it.syncId");
                                            i = size;
                                            long parseLong = Long.parseLong(str);
                                            byte[] bArr = snapshot.data;
                                            Intrinsics.checkNotNullExpressionValue(bArr, "it.data");
                                            String readData = iFileDataCacheService.readData(parseLong, new String(bArr, Charsets.UTF_8));
                                            if (readData == null) {
                                                String str2 = snapshot.syncId;
                                                Intrinsics.checkNotNullExpressionValue(str2, "it.syncId");
                                                sendCalibrationEvent(Long.parseLong(str2), "deserialization failed when submit snapshots");
                                                size = i;
                                            } else {
                                                byte[] bytes = readData.getBytes(Charsets.UTF_8);
                                                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                                                data.data = bytes;
                                            }
                                        } else {
                                            i = size;
                                            data.data = snapshot.data;
                                        }
                                        data.did = snapshot.did;
                                        data.uid = snapshot.uid;
                                        data.publishTimeStamp = snapshot.publishTs;
                                        data.receiveTimeStamp = snapshot.receiveTs;
                                        data.cursor = snapshot.cursor;
                                        snapshot.notified = snapshot.cursor;
                                        int i3 = snapshot.patchCnt;
                                        snapshot.patchCnt = 0;
                                        iDBServiceV4.changeSnapshotToNotified(snapshot);
                                        arrayList.add(snapshot);
                                        Intrinsics.checkNotNullExpressionValue(connectOnDataUpdateListener, "listener");
                                        IFileDataCacheService iFileDataCacheService2 = iFileDataCacheService;
                                        asyncNotify(callbackExecutors, connectOnDataUpdateListener, data, syncLog, i3);
                                        iFileDataCacheService = iFileDataCacheService2;
                                        size = i;
                                    }
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                    z2 = z3;
                    i2 = size;
                } catch (Exception e) {
                    e.printStackTrace();
                    SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed. notifySnapshots .");
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            SDKMonitor.inst().ensureNotReachHere(e2, null);
        }
    }

    private final void sendCalibrationEvent(long syncId, String errMsg) {
        LogUtils.m186e(this.TAG + "something is wrong when notify. syncId = " + syncId + ", errMsg = " + errMsg);
    }
}
