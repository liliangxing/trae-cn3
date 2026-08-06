package com.bytedance.sync.p005v4.process.flag;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.DataType;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IDataPatchService;
import com.bytedance.sync.p005v4.intf.IMsgHandlerWithMethod;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.process.flag.AbsDataMsgHandlerV4;
import com.bytedance.sync.p005v4.protocal.BsyncHeader;
import com.bytedance.sync.p005v4.protocal.BsyncPacket;
import com.bytedance.sync.p005v4.protocal.BsyncPayload;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import com.bytedance.sync.p005v4.protocal.Flag;
import com.bytedance.sync.p005v4.protocal.Reason;
import com.bytedance.sync.p005v4.protocal.TopicType;
import com.bytedance.sync.p005v4.utils.UtilKtKt;
import com.bytedance.timon.pipeline.BuildConfig;
import com.ss.android.ug.bus.IUgBusService;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;
import org.json.JSONObject;

/* compiled from: DataMsgHandlerV4.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J.\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J&\u0010#\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0$H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0016J(\u0010(\u001a\u00020)2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-2\u0006\u0010.\u001a\u00020/H\u0002J \u00100\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\"H\u0016J0\u00104\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\"H\u0014J\b\u00105\u001a\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u00066"}, d2 = {"Lcom/bytedance/sync/v4/process/flag/DataMsgHandlerV4;", "Lcom/bytedance/sync/v4/intf/IMsgHandlerWithMethod;", "Lcom/bytedance/sync/v4/protocal/Flag;", "Lcom/bytedance/sync/v4/process/flag/AbsDataMsgHandlerV4;", "Landroid/os/Handler$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "BATCH_POLL_TIMEOUT_WHAT", "", "TAG", "", "mBatchPollCount", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "canHandle", "", "obj", "continuePoll", "", "reason", "Lcom/bytedance/sync/v4/protocal/Reason;", "dealWithTopic", "method", "syncId", "", "header", "Lcom/bytedance/sync/v4/protocal/BsyncHeader;", "topics", "", "Lcom/bytedance/sync/v4/protocal/BsyncTopic;", "handle", "", "handleMessage", "msg", "Landroid/os/Message;", "handlerDataBase", "Lcom/bytedance/sync/v4/process/flag/AbsDataMsgHandlerV4$PatchResult;", "syncLogs", "Ljava/util/ArrayList;", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "Lkotlin/collections/ArrayList;", "syncCursor", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "monitorReceive", "packet", "Lcom/bytedance/sync/v4/protocal/BsyncPacket;", "topic", "patchAndSave", "sendPollMsgAndResetCount", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DataMsgHandlerV4 extends AbsDataMsgHandlerV4 implements IMsgHandlerWithMethod<Flag>, Handler.Callback {
    private final int BATCH_POLL_TIMEOUT_WHAT;
    private final String TAG;
    private final Context context;
    private int mBatchPollCount;

    /* renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMsgHandlerV4(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.TAG = "[DataMsgHandlerV4] ";
        this.BATCH_POLL_TIMEOUT_WHAT = 1;
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.sync.v4.process.flag.DataMsgHandlerV4$mHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m990invoke() {
                return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get(), DataMsgHandlerV4.this);
            }
        });
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgHandlerWithMethod
    public void handle(int method, BsyncHeader header, List<BsyncTopic> topics) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topics, "topics");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : topics) {
            Long l = ((BsyncTopic) obj).sync_id;
            Object obj2 = linkedHashMap.get(l);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(l, obj2);
            }
            ((List) obj2).add(obj);
        }
        Reason reason = Reason.DataAck;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            if (dealWithTopic(method, ((Number) key).longValue(), header, (List) entry.getValue()) == -5) {
                reason = Reason.DataLost;
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Long l2 : linkedHashMap.keySet()) {
            Intrinsics.checkNotNullExpressionValue(l2, "syncId");
            linkedHashSet.add(l2);
        }
        continuePoll(reason);
        ((IDataPatchService) UgBusFramework.getService(IDataPatchService.class)).notifyPatch(linkedHashSet);
    }

    private final AbsDataMsgHandlerV4.PatchResult handlerDataBase(ArrayList<SyncLogV4> syncLogs, SyncCursor syncCursor) {
        try {
            ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).insertSyncLogAndCursor(syncLogs, syncCursor);
            return new AbsDataMsgHandlerV4.PatchResult(true, syncCursor);
        } catch (Throwable th) {
            SDKMonitor.inst().ensureNotReachHere(th, "execute sql failed when insertSyncLogAndCursor");
            th.printStackTrace();
            return new AbsDataMsgHandlerV4.PatchResult(false, null);
        }
    }

    @Override // com.bytedance.sync.p005v4.process.flag.AbsDataMsgHandlerV4
    public int dealWithTopic(int method, long syncId, BsyncHeader header, List<BsyncTopic> topics) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topics, "topics");
        try {
            SyncCursor queryLocalSyncCursorInfoWithSyncId = getDbService().queryLocalSyncCursorInfoWithSyncId(syncId);
            if (topics.isEmpty()) {
                LogUtils.m187i(Intrinsics.stringPlus(this.TAG, "topics is null !"));
                return -2;
            }
            if (queryLocalSyncCursorInfoWithSyncId == null) {
                LogUtils.m186e(this.TAG + "can't be found in local db, " + syncId + ' ');
                return -2;
            }
            if (!ensureSyncCursor(syncId, header, queryLocalSyncCursorInfoWithSyncId)) {
                LogUtils.m186e(this.TAG + "info not match when handle " + syncId + '.');
                return -3;
            }
            int i = 0;
            for (BsyncTopic bsyncTopic : CollectionsKt.sortedWith(topics, new Comparator() { // from class: com.bytedance.sync.v4.process.flag.DataMsgHandlerV4$dealWithTopic$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((BsyncTopic) t).ref_cursor, ((BsyncTopic) t2).ref_cursor);
                }
            })) {
                Long l = bsyncTopic.ref_cursor;
                Intrinsics.checkNotNullExpressionValue(l, "it.ref_cursor");
                if (l.longValue() <= queryLocalSyncCursorInfoWithSyncId.receiveCursor) {
                    AbsDataMsgHandlerV4.PatchResult patchAndSave = patchAndSave(method, syncId, queryLocalSyncCursorInfoWithSyncId, header, bsyncTopic);
                    boolean success = patchAndSave.getSuccess();
                    SyncCursor syncCursor = patchAndSave.getSyncCursor();
                    if (!success || syncCursor == null) {
                        LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "patchAndSave failed. break process data"));
                        i = -4;
                    } else {
                        queryLocalSyncCursorInfoWithSyncId = syncCursor;
                    }
                } else {
                    LogUtils.m186e(this.TAG + bsyncTopic.ref_cursor + " > " + queryLocalSyncCursorInfoWithSyncId.receiveCursor + ", server cursor > db cursor when patch syncId = " + syncId);
                    if (!Intrinsics.areEqual(bsyncTopic.ref_cursor, bsyncTopic.new_cursor)) {
                        i = -5;
                    }
                }
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when queryLocalSyncCursorInfo when receive data");
            return -1;
        }
    }

    @Override // com.bytedance.sync.p005v4.process.flag.AbsDataMsgHandlerV4
    protected AbsDataMsgHandlerV4.PatchResult patchAndSave(int method, long syncId, SyncCursor syncCursor, BsyncHeader header, BsyncTopic topic) {
        long longValue;
        boolean z;
        Intrinsics.checkNotNullParameter(syncCursor, "syncCursor");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topic, "topic");
        List<BsyncPacket> list = topic.packets;
        Intrinsics.checkNotNullExpressionValue(list, "topic.packets");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long l = ((BsyncPacket) next).cursor.cursor;
            Intrinsics.checkNotNullExpressionValue(l, "it.cursor.cursor");
            if (l.longValue() > syncCursor.receiveCursor) {
                arrayList.add(next);
            }
        }
        List<BsyncPacket> mutableList = CollectionsKt.toMutableList(arrayList);
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: com.bytedance.sync.v4.process.flag.DataMsgHandlerV4$patchAndSave$lambda-6$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((BsyncPacket) t).cursor.cursor, ((BsyncPacket) t2).cursor.cursor);
                }
            });
        }
        ArrayList<SyncLogV4> arrayList2 = new ArrayList<>();
        TopicType topicType = topic.topic_type;
        for (BsyncPacket bsyncPacket : mutableList) {
            Intrinsics.checkNotNullExpressionValue(bsyncPacket, "packet");
            monitorReceive(syncId, bsyncPacket, topic);
            onEventRecvData(method, syncId, bsyncPacket, topic);
            Long l2 = bsyncPacket.expire_ts;
            Intrinsics.checkNotNullExpressionValue(l2, "packet.expire_ts");
            if (l2.longValue() > 0) {
                Long l3 = bsyncPacket.expire_ts;
                Intrinsics.checkNotNullExpressionValue(l3, "packet.expire_ts");
                if (l3.longValue() < System.currentTimeMillis()) {
                    continue;
                }
            }
            SyncLogV4 syncLogV4 = new SyncLogV4();
            if (syncLogV4.extra == null) {
                syncLogV4.extra = new HashMap();
            }
            Map<String, String> map = syncLogV4.extra;
            Intrinsics.checkNotNullExpressionValue(map, "syncLog.extra");
            map.put(Constant.KEY_CHANNEL, String.valueOf(method));
            if (bsyncPacket.extra != null) {
                Map<String, String> map2 = syncLogV4.extra;
                Map<String, String> map3 = bsyncPacket.extra;
                Intrinsics.checkNotNullExpressionValue(map3, "packet.extra");
                map2.putAll(map3);
            }
            Long l4 = bsyncPacket.expire_ts;
            Intrinsics.checkNotNullExpressionValue(l4, "packet.expire_ts");
            syncLogV4.expireTs = l4.longValue();
            if (syncLogV4.expireTs <= 0) {
                syncLogV4.expireTs = System.currentTimeMillis() + 86400000;
            }
            syncLogV4.packetCtrl = bsyncPacket.ctrl;
            syncLogV4.topicType = topicType;
            BsyncPayload bsyncPayload = bsyncPacket.payload;
            syncLogV4.business = bsyncPayload.business.intValue();
            syncLogV4.consumeType = bsyncPayload.consume_type;
            syncLogV4.syncId = String.valueOf(syncId);
            syncLogV4.md5 = bsyncPayload.md5;
            Long l5 = bsyncPacket.f238ts;
            if (l5 == null) {
                Long l6 = BsyncHeader.DEFAULT_TS;
                Intrinsics.checkNotNullExpressionValue(l6, "DEFAULT_TS");
                longValue = l6.longValue();
            } else {
                longValue = l5.longValue();
            }
            syncLogV4.publishTs = longValue;
            syncLogV4.receiveTs = System.currentTimeMillis();
            Long l7 = bsyncPacket.cursor.cursor;
            Intrinsics.checkNotNullExpressionValue(l7, "packet.cursor.cursor");
            syncLogV4.syncCursor = l7.longValue();
            syncLogV4.did = header.did;
            syncLogV4.uid = header.uid;
            syncLogV4.bucket = topic.bucket;
            String str = topic.req_id;
            if (str == null) {
                str = "";
            }
            syncLogV4.reqId = str;
            if (bsyncPacket.payload.data == null) {
                syncLogV4.data = ByteString.EMPTY.toByteArray();
                syncLogV4.dataType = DataType.ORIGIN;
            } else if (bsyncPacket.payload.data.size() > getMSettings().dbStoreSizeLimit()) {
                try {
                    String putData = getFileDataCache().putData(IFileDataCacheService.TYPE_SYNC_LOG, syncId, syncLogV4.syncCursor, bsyncPacket.payload.data.toByteArray());
                    if (putData != null) {
                        byte[] bytes = putData.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        syncLogV4.data = bytes;
                        syncLogV4.dataType = DataType.FILE_PATH;
                        z = true;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("save_file", z);
                        SyncMonitor.monitor$default("sync_sdk_synclog_save_file", jSONObject, null, UtilKtKt.toMonitorExtra(syncLogV4), 4, null);
                        LogUtils.m188v(this.TAG + "add sync_log to list : " + syncLogV4);
                        arrayList2.add(syncLogV4);
                    } else {
                        LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "save data to file failed"));
                        return new AbsDataMsgHandlerV4.PatchResult(false, null);
                    }
                } catch (Exception unused) {
                    LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "UnsupportedEncodingException when save syncLog data"));
                    return new AbsDataMsgHandlerV4.PatchResult(false, null);
                }
            } else {
                syncLogV4.data = bsyncPacket.payload.data.toByteArray();
                syncLogV4.dataType = DataType.ORIGIN;
            }
            z = false;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("save_file", z);
            SyncMonitor.monitor$default("sync_sdk_synclog_save_file", jSONObject2, null, UtilKtKt.toMonitorExtra(syncLogV4), 4, null);
            LogUtils.m188v(this.TAG + "add sync_log to list : " + syncLogV4);
            arrayList2.add(syncLogV4);
        }
        SyncCursor syncCursor2 = new SyncCursor(syncCursor);
        Long l8 = topic.new_cursor;
        Intrinsics.checkNotNullExpressionValue(l8, "topic.new_cursor");
        syncCursor2.receiveCursor = l8.longValue();
        return handlerDataBase(arrayList2, syncCursor2);
    }

    @Override // com.bytedance.sync.p005v4.process.flag.AbsDataMsgHandlerV4
    public void monitorReceive(long syncId, BsyncPacket packet, BsyncTopic topic) {
        Integer num;
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(topic, "topic");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("topic", topic.topic_type.getValue());
        jSONObject.put(BuildConfig.TIMON_COMPONENT_NAME, "receive");
        JSONObject jSONObject2 = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        Long l = packet.f238ts;
        Intrinsics.checkNotNullExpressionValue(l, "packet.ts");
        jSONObject2.put("time_consuming", currentTimeMillis - l.longValue());
        jSONObject2.put("receive_cnt", 1);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("sync_id", syncId);
        BsyncPayload bsyncPayload = packet.payload;
        int i = 0;
        if (bsyncPayload != null && (num = bsyncPayload.business) != null) {
            i = num.intValue();
        }
        jSONObject3.put("business", i);
        SyncMonitor.monitor("sync_sdk_pipeline", jSONObject, jSONObject2, jSONObject3);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what != this.BATCH_POLL_TIMEOUT_WHAT) {
            return true;
        }
        sendPollMsgAndResetCount();
        return true;
    }

    private final void sendPollMsgAndResetCount() {
        IUgBusService service = UgBusFramework.getService(ISyncMsgSenderV4.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(ISyncMsgSenderV4::class.java)");
        ISyncMsgSenderV4.DefaultImpls.sendPollMsg$default((ISyncMsgSenderV4) service, false, Reason.DataAck.getValue(), 1, null);
        this.mBatchPollCount = 0;
    }

    private final void continuePoll(Reason reason) {
        LogUtils.m187i(Intrinsics.stringPlus(this.TAG, "handle data finished. continue poll again..."));
        if (reason == Reason.DataLost || !getMSettings().enableBatchAck()) {
            IUgBusService service = UgBusFramework.getService(ISyncMsgSenderV4.class);
            Intrinsics.checkNotNullExpressionValue(service, "getService(ISyncMsgSenderV4::class.java)");
            ISyncMsgSenderV4.DefaultImpls.sendPollMsg$default((ISyncMsgSenderV4) service, false, reason.getValue(), 1, null);
            return;
        }
        int i = this.mBatchPollCount + 1;
        this.mBatchPollCount = i;
        if (i >= getMSettings().batchAckCount()) {
            sendPollMsgAndResetCount();
            getMHandler().removeMessages(this.BATCH_POLL_TIMEOUT_WHAT);
        } else {
            if (getMHandler().hasMessages(this.BATCH_POLL_TIMEOUT_WHAT)) {
                return;
            }
            getMHandler().sendEmptyMessageDelayed(this.BATCH_POLL_TIMEOUT_WHAT, getMSettings().batchAckInterval() * 1000);
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgHandlerWithMethod
    public boolean canHandle(Flag obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return obj == Flag.Data;
    }
}
