package com.bytedance.sync.p005v4.process.flag;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.diff.DiffMatchPatch;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.DataType;
import com.bytedance.sync.p005v4.history.ISyncHistory;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IHistoryMsgProcessor;
import com.bytedance.sync.p005v4.intf.IMsgHandlerWithMethod;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.presistence.table.SyncHistoryLogV4;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.process.flag.AbsDataMsgHandlerV4;
import com.bytedance.sync.p005v4.protocal.BsyncHeader;
import com.bytedance.sync.p005v4.protocal.BsyncPacket;
import com.bytedance.sync.p005v4.protocal.BsyncPayload;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import com.bytedance.sync.p005v4.protocal.ConsumeType;
import com.bytedance.sync.p005v4.protocal.Flag;
import com.bytedance.sync.p005v4.protocal.TopicType;
import com.bytedance.sync.settings.SyncSettings;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;

/* compiled from: HistoryDataMsgHandlerV4.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001DB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0019j\b\u0012\u0004\u0012\u00020\u0013`\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0010H\u0002J.\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0010H\u0016J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\tH\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020\u0013H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010'\u001a\u00020\u001cH\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0013H\u0002J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001cH\u0002J\"\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010\tH\u0002J&\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$02H\u0016J(\u00103\u001a\u0002042\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0019j\b\u0012\u0004\u0012\u00020\u0013`\u001a2\u0006\u00106\u001a\u000207H\u0002J \u00108\u001a\u0002012\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0019j\b\u0012\u0004\u0012\u00020\u0013`\u001aH\u0002J\u000e\u00109\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001cJ \u0010:\u001a\u0002012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010/\u001a\u00020$H\u0016J\u0018\u0010=\u001a\u00020\r2\u0006\u0010/\u001a\u00020$2\u0006\u0010;\u001a\u00020<H\u0002J\u001a\u0010>\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\tH\u0002J>\u0010?\u001a\u0002042\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u00106\u001a\u0002072\u0006\u0010!\u001a\u00020\"2\u0006\u0010/\u001a\u00020$2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020<0\u0010H\u0002J6\u0010?\u001a\u0002042\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u00106\u001a\u0002072\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0010H\u0014J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010B\u001a\u00020CH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006E"}, d2 = {"Lcom/bytedance/sync/v4/process/flag/HistoryDataMsgHandlerV4;", "Lcom/bytedance/sync/v4/intf/IHistoryMsgProcessor;", "Lcom/bytedance/sync/v4/intf/IMsgHandlerWithMethod;", "Lcom/bytedance/sync/v4/protocal/Flag;", "Lcom/bytedance/sync/v4/process/flag/AbsDataMsgHandlerV4;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getMContext", "()Landroid/content/Context;", "canHandle", "", "obj", "convertHistoryLogToClientData", "", "Lcom/bytedance/sync/interfaze/ISyncClient$Data;", "historyLogList", "Lcom/bytedance/sync/v4/presistence/table/SyncHistoryLogV4;", "convertTopicType", "Lcom/bytedance/sync/v4/protocal/TopicType;", "topicTypeValue", "", "converterToHistory", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "syncLogs", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "dealWithTopic", "method", "syncId", "", "header", "Lcom/bytedance/sync/v4/protocal/BsyncHeader;", "topics", "Lcom/bytedance/sync/v4/protocal/BsyncTopic;", "doPatch", "Lcom/bytedance/sync/v4/process/flag/HistoryDataMsgHandlerV4$HistoryPatchResult;", "syncLog", "lastData", "getCustomTopic", "syncHistoryLog", "reqId", "getTopicHistoryLimit", "businessId", "topicType", "topic", "handle", "", "", "handlerDataBase", "Lcom/bytedance/sync/v4/process/flag/AbsDataMsgHandlerV4$PatchResult;", "historySyncLogs", "syncCursor", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "handlerHistory", "isExistHistory", "monitorReceive", "packet", "Lcom/bytedance/sync/v4/protocal/BsyncPacket;", "packetIntercept", "patch", "patchAndSave", "packets", "queryHistoryData", "historyData", "Lcom/bytedance/sync/v4/history/ISyncHistory$HistoryData;", "HistoryPatchResult", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HistoryDataMsgHandlerV4 extends AbsDataMsgHandlerV4 implements IHistoryMsgProcessor, IMsgHandlerWithMethod<Flag> {
    private final String TAG;
    private final Context mContext;

    /* compiled from: HistoryDataMsgHandlerV4.kt */
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

    @Override // com.bytedance.sync.p005v4.process.flag.AbsDataMsgHandlerV4
    public void monitorReceive(long syncId, BsyncPacket packet, BsyncTopic topic) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(topic, "topic");
    }

    public final Context getMContext() {
        return this.mContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryDataMsgHandlerV4(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.TAG = "[HistoryDataMsgHandlerV4] ";
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
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            dealWithTopic(method, ((Number) key).longValue(), header, (List) entry.getValue());
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IHistoryMsgProcessor
    public List<ISyncClient.Data> queryHistoryData(ISyncHistory.HistoryData historyData) {
        Intrinsics.checkNotNullParameter(historyData, "historyData");
        try {
            String topic = (historyData.topic == null || TextUtils.isEmpty(historyData.topic.getTopic())) ? null : historyData.topic.getTopic();
            if (getTopicHistoryLimit(historyData.businessId, convertTopicType(historyData.dataType), topic) <= 0) {
                return new ArrayList();
            }
            return convertHistoryLogToClientData(getDbService().queryHistorySyncLog(convertTopicType(historyData.dataType), historyData.businessId, topic, historyData.count));
        } catch (Throwable th) {
            LogUtils.m186e(this.TAG + "queryHistorySyncLog error: " + Log.getStackTraceString(th));
            return new ArrayList();
        }
    }

    @Override // com.bytedance.sync.p005v4.process.flag.AbsDataMsgHandlerV4
    public int dealWithTopic(int method, long syncId, BsyncHeader header, List<BsyncTopic> topics) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topics, "topics");
        try {
            SyncCursor queryLocalSyncCursorInfoWithSyncId = getDbService().queryLocalSyncCursorInfoWithSyncId(syncId);
            if (queryLocalSyncCursorInfoWithSyncId == null) {
                LogUtils.m186e(this.TAG + "can't be found in local db, " + syncId + ' ');
                return -2;
            }
            if (!ensureSyncCursor(syncId, header, queryLocalSyncCursorInfoWithSyncId)) {
                LogUtils.m186e(this.TAG + " info not match when handle " + syncId + '.');
                return -2;
            }
            AbsDataMsgHandlerV4.PatchResult patchAndSave = patchAndSave(method, syncId, queryLocalSyncCursorInfoWithSyncId, header, CollectionsKt.sortedWith(topics, new Comparator() { // from class: com.bytedance.sync.v4.process.flag.HistoryDataMsgHandlerV4$dealWithTopic$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((BsyncTopic) t).ref_cursor, ((BsyncTopic) t2).ref_cursor);
                }
            }));
            return (!patchAndSave.getSuccess() || patchAndSave.getSyncCursor() == null) ? -3 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when queryLocalSyncCursorInfo when receive data");
            return -1;
        }
    }

    @Override // com.bytedance.sync.p005v4.process.flag.AbsDataMsgHandlerV4
    protected AbsDataMsgHandlerV4.PatchResult patchAndSave(int method, long syncId, SyncCursor syncCursor, BsyncHeader header, List<BsyncTopic> topics) {
        Intrinsics.checkNotNullParameter(syncCursor, "syncCursor");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topics, "topics");
        ArrayList arrayList = new ArrayList();
        for (BsyncTopic bsyncTopic : CollectionsKt.sortedWith(topics, new Comparator() { // from class: com.bytedance.sync.v4.process.flag.HistoryDataMsgHandlerV4$patchAndSave$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((BsyncTopic) t).ref_cursor, ((BsyncTopic) t2).ref_cursor);
            }
        })) {
            Long l = bsyncTopic.ref_cursor;
            Intrinsics.checkNotNullExpressionValue(l, "it.ref_cursor");
            if (l.longValue() <= syncCursor.receiveCursor) {
                List<BsyncPacket> list = bsyncTopic.packets;
                Intrinsics.checkNotNullExpressionValue(list, "it.packets");
                arrayList.addAll(list);
            } else {
                LogUtils.m186e(this.TAG + bsyncTopic.ref_cursor + " > " + syncCursor.receiveCursor + ", server cursor > db cursor when patch syncId = " + syncId);
            }
        }
        AbsDataMsgHandlerV4.PatchResult patchResult = new AbsDataMsgHandlerV4.PatchResult(false, null);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            Long l2 = ((BsyncPacket) obj).cursor.cursor;
            Intrinsics.checkNotNullExpressionValue(l2, "it.cursor.cursor");
            if (l2.longValue() > syncCursor.receiveCursor) {
                arrayList2.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList2) {
            Integer num = ((BsyncPacket) obj2).payload.business;
            Object obj3 = linkedHashMap.get(num);
            if (obj3 == null) {
                obj3 = (List) new ArrayList();
                linkedHashMap.put(num, obj3);
            }
            ((List) obj3).add(obj2);
        }
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            patchResult = patchAndSave(method, syncId, syncCursor, header, (BsyncTopic) CollectionsKt.first(topics), (List) it.next());
        }
        return patchResult;
    }

    private final AbsDataMsgHandlerV4.PatchResult patchAndSave(int method, long syncId, SyncCursor syncCursor, BsyncHeader header, BsyncTopic topic, List<BsyncPacket> packets) {
        long longValue;
        boolean z;
        ArrayList<SyncHistoryLogV4> arrayList = new ArrayList<>();
        TopicType topicType = topic.topic_type;
        Snapshot querySnapshot = getDbService().querySnapshot(String.valueOf(syncId), ((BsyncPacket) CollectionsKt.first(packets)).payload.business.intValue());
        byte[] bArr = querySnapshot == null ? null : querySnapshot.data;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = packets.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long l = ((BsyncPacket) next).cursor.cursor;
            Intrinsics.checkNotNullExpressionValue(l, "it.cursor.cursor");
            Iterator it2 = it;
            if (l.longValue() > syncCursor.receiveCursor) {
                arrayList2.add(next);
            }
            it = it2;
        }
        List<BsyncPacket> mutableList = CollectionsKt.toMutableList(arrayList2);
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: com.bytedance.sync.v4.process.flag.HistoryDataMsgHandlerV4$patchAndSave$lambda-10$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((BsyncPacket) t).cursor.cursor, ((BsyncPacket) t2).cursor.cursor);
                }
            });
        }
        for (BsyncPacket bsyncPacket : mutableList) {
            if (!packetIntercept(topic, bsyncPacket)) {
                SyncHistoryLogV4 syncHistoryLogV4 = new SyncHistoryLogV4();
                if (syncHistoryLogV4.extra == null) {
                    syncHistoryLogV4.extra = new HashMap();
                }
                Map<String, String> map = syncHistoryLogV4.extra;
                Intrinsics.checkNotNullExpressionValue(map, "syncHistoryLog.extra");
                map.put(Constant.KEY_CHANNEL, String.valueOf(method));
                if (bsyncPacket.extra != null) {
                    Map<String, String> map2 = syncHistoryLogV4.extra;
                    Map<String, String> map3 = bsyncPacket.extra;
                    Intrinsics.checkNotNullExpressionValue(map3, "it.extra");
                    map2.putAll(map3);
                }
                Long l2 = bsyncPacket.expire_ts;
                Intrinsics.checkNotNullExpressionValue(l2, "it.expire_ts");
                syncHistoryLogV4.expireTs = l2.longValue();
                if (syncHistoryLogV4.expireTs <= 0) {
                    System.currentTimeMillis();
                }
                syncHistoryLogV4.topicType = topicType;
                BsyncPayload bsyncPayload = bsyncPacket.payload;
                syncHistoryLogV4.business = bsyncPayload.business.intValue();
                syncHistoryLogV4.consumeType = bsyncPayload.consume_type;
                syncHistoryLogV4.syncId = String.valueOf(syncId);
                syncHistoryLogV4.md5 = bsyncPayload.md5;
                Long l3 = bsyncPacket.f238ts;
                if (l3 == null) {
                    Long l4 = BsyncHeader.DEFAULT_TS;
                    Intrinsics.checkNotNullExpressionValue(l4, "DEFAULT_TS");
                    longValue = l4.longValue();
                } else {
                    longValue = l3.longValue();
                }
                syncHistoryLogV4.publishTs = longValue;
                syncHistoryLogV4.receiveTs = System.currentTimeMillis();
                Long l5 = bsyncPacket.cursor.cursor;
                Intrinsics.checkNotNullExpressionValue(l5, "it.cursor.cursor");
                syncHistoryLogV4.syncCursor = l5.longValue();
                syncHistoryLogV4.did = header.did;
                syncHistoryLogV4.uid = header.uid;
                syncHistoryLogV4.bucket = topic.bucket;
                String str = topic.req_id;
                if (str == null) {
                    str = "";
                }
                syncHistoryLogV4.reqId = str;
                if (bsyncPacket.payload.data == null) {
                    syncHistoryLogV4.data = ByteString.EMPTY.toByteArray();
                    syncHistoryLogV4.dataType = DataType.ORIGIN;
                    z = false;
                } else {
                    byte[] byteArray = bsyncPacket.payload.data.toByteArray();
                    syncHistoryLogV4.data = byteArray;
                    if (syncHistoryLogV4.consumeType == ConsumeType.Increment) {
                        HistoryPatchResult patch = patch(syncHistoryLogV4, bArr != null ? new String(bArr, Charsets.UTF_8) : "");
                        if (patch != null && patch.getSuccess()) {
                            String data = patch.getData();
                            if (data == null) {
                                bArr = null;
                            } else {
                                bArr = data.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bArr, "(this as java.lang.String).getBytes(charset)");
                            }
                            byteArray = bArr;
                        }
                    }
                    if (byteArray.length > getMSettings().dbStoreSizeLimit()) {
                        try {
                            String putData = getFileDataCache().putData(IFileDataCacheService.TYPE_HISTORY_SYNC_LOG, syncId, syncHistoryLogV4.syncCursor, byteArray);
                            if (putData != null) {
                                byte[] bytes = putData.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                                syncHistoryLogV4.data = bytes;
                                syncHistoryLogV4.dataType = DataType.FILE_PATH;
                                z = true;
                            } else {
                                LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "save data to file failed"));
                                return new AbsDataMsgHandlerV4.PatchResult(false, null);
                            }
                        } catch (Exception unused) {
                            LogUtils.m186e("UnsupportedEncodingException when save syncLog data");
                            return new AbsDataMsgHandlerV4.PatchResult(false, null);
                        }
                    } else {
                        syncHistoryLogV4.data = byteArray;
                        syncHistoryLogV4.dataType = DataType.ORIGIN;
                        z = false;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("save_file", z);
                        SyncMonitor.monitor$default("sync_sdk_synclog_save_file", jSONObject, null, new JSONObject(), 4, null);
                        LogUtils.m188v(Intrinsics.stringPlus("add history_sync_log to list : ", syncHistoryLogV4));
                        arrayList.add(syncHistoryLogV4);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("save_file", z);
                SyncMonitor.monitor$default("sync_sdk_synclog_save_file", jSONObject2, null, new JSONObject(), 4, null);
                LogUtils.m188v(Intrinsics.stringPlus("add history_sync_log to list : ", syncHistoryLogV4));
                arrayList.add(syncHistoryLogV4);
            }
        }
        SyncCursor syncCursor2 = new SyncCursor(syncCursor);
        Long l6 = topic.new_cursor;
        Intrinsics.checkNotNullExpressionValue(l6, "topic.new_cursor");
        syncCursor2.receiveCursor = l6.longValue();
        if (arrayList.isEmpty()) {
            return new AbsDataMsgHandlerV4.PatchResult(true, syncCursor);
        }
        return handlerDataBase(arrayList, syncCursor2);
    }

    private final AbsDataMsgHandlerV4.PatchResult handlerDataBase(ArrayList<SyncHistoryLogV4> historySyncLogs, SyncCursor syncCursor) {
        try {
            LogUtils.m185d(this.TAG + "save history_sync_logs to db : " + syncCursor + " + " + historySyncLogs);
            getDbService().insertHistorySyncLog(historySyncLogs);
            handlerHistory(historySyncLogs);
            return new AbsDataMsgHandlerV4.PatchResult(true, syncCursor);
        } catch (Exception e) {
            SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when handler history database");
            e.printStackTrace();
            return new AbsDataMsgHandlerV4.PatchResult(false, null);
        }
    }

    private final HistoryPatchResult patch(SyncHistoryLogV4 syncLog, String lastData) {
        HistoryPatchResult doPatch = doPatch(syncLog, lastData);
        if (doPatch == null) {
            return new HistoryPatchResult(false, null, null, 0L);
        }
        if (doPatch.getSuccess()) {
            String encrypt = StringEncryptUtils.encrypt(doPatch.getData(), "MD5");
            return !TextUtils.equals(encrypt, syncLog.md5) ? new HistoryPatchResult(false, null, "different md5. local is  " + ((Object) encrypt) + ",server is " + ((Object) syncLog.md5) + " when patch " + syncLog.syncCursor + " and syncId = " + syncLog.syncId, 0L) : doPatch;
        }
        return new HistoryPatchResult(false, null, "patch failed", 0L);
    }

    private final HistoryPatchResult doPatch(SyncHistoryLogV4 syncLog, String lastData) {
        Object[] patch_apply;
        Object obj;
        Object obj2;
        try {
            DiffMatchPatch diffMatchPatch = new DiffMatchPatch();
            try {
                byte[] bArr = syncLog.data;
                Intrinsics.checkNotNullExpressionValue(bArr, "syncLog.data");
                String str = new String(bArr, Charsets.UTF_8);
                if (TextUtils.isEmpty(lastData)) {
                    lastData = "";
                }
                LinkedList<DiffMatchPatch.Patch> linkedList = (LinkedList) diffMatchPatch.patch_fromText(str);
                if (linkedList != null && (patch_apply = diffMatchPatch.patch_apply(linkedList, lastData)) != null && patch_apply.length == 2 && (obj = patch_apply[0]) != null && (obj2 = patch_apply[1]) != null) {
                    if (obj != null) {
                        String str2 = (String) obj;
                        if (obj2 != null) {
                            boolean[] zArr = (boolean[]) obj2;
                            int length = zArr.length;
                            int i = 0;
                            while (true) {
                                boolean z = true;
                                while (i < length) {
                                    boolean z2 = zArr[i];
                                    i++;
                                    if (!z || !z2) {
                                        z = false;
                                    }
                                }
                                return new HistoryPatchResult(true, str2, null, 0L);
                            }
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.BooleanArray");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                return null;
            } catch (Throwable th) {
                return new HistoryPatchResult(false, null, Log.getStackTraceString(th), 0L);
            }
        } catch (Throwable unused) {
            return new HistoryPatchResult(false, null, null, 0L);
        }
    }

    private final void handlerHistory(ArrayList<SyncHistoryLogV4> historySyncLogs) {
        try {
            SyncHistoryLogV4 syncHistoryLogV4 = historySyncLogs.get(0);
            Intrinsics.checkNotNullExpressionValue(syncHistoryLogV4, "historySyncLogs[0]");
            SyncHistoryLogV4 syncHistoryLogV42 = syncHistoryLogV4;
            int coerceAtMost = RangesKt.coerceAtMost(getTopicHistoryLimit(syncHistoryLogV42), SyncSettings.inst(this.mContext).getSettings().historyLimit());
            if (coerceAtMost <= 0) {
                return;
            }
            getDbService().insertHistorySyncLog(historySyncLogs);
            String customTopic = getCustomTopic(syncHistoryLogV42);
            IDBServiceV4 dbService = getDbService();
            TopicType topicType = syncHistoryLogV42.topicType;
            Intrinsics.checkNotNullExpressionValue(topicType, "syncLog.topicType");
            List<SyncHistoryLogV4> queryDeleteHistorySyncLog = dbService.queryDeleteHistorySyncLog(topicType, syncHistoryLogV42.business, customTopic, coerceAtMost);
            if (queryDeleteHistorySyncLog != null && !queryDeleteHistorySyncLog.isEmpty()) {
                getDbService().deleteHistorySyncLog(queryDeleteHistorySyncLog);
                IFileDataCacheService iFileDataCacheService = (IFileDataCacheService) UgBusFramework.getService(IFileDataCacheService.class);
                for (SyncHistoryLogV4 syncHistoryLogV43 : queryDeleteHistorySyncLog) {
                    if (syncHistoryLogV43.dataType == DataType.FILE_PATH) {
                        byte[] bArr = syncHistoryLogV43.data;
                        Intrinsics.checkNotNullExpressionValue(bArr, "syncHistoryLog.data");
                        iFileDataCacheService.deleteFile(new String(bArr, Charsets.UTF_8));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private final ArrayList<SyncHistoryLogV4> converterToHistory(List<? extends SyncLogV4> syncLogs) {
        ArrayList<SyncHistoryLogV4> arrayList = new ArrayList<>();
        if (syncLogs != null && !syncLogs.isEmpty()) {
            for (SyncLogV4 syncLogV4 : syncLogs) {
                SyncHistoryLogV4 syncHistoryLogV4 = new SyncHistoryLogV4();
                syncHistoryLogV4.syncId = syncLogV4.syncId;
                syncHistoryLogV4.did = syncLogV4.did;
                syncHistoryLogV4.uid = syncLogV4.uid;
                syncHistoryLogV4.syncCursor = syncLogV4.syncCursor;
                syncHistoryLogV4.data = syncLogV4.data;
                syncHistoryLogV4.md5 = syncLogV4.md5;
                syncHistoryLogV4.business = syncLogV4.business;
                syncHistoryLogV4.consumeType = syncLogV4.consumeType;
                syncHistoryLogV4.dataType = syncLogV4.dataType;
                syncHistoryLogV4.publishTs = syncLogV4.publishTs;
                syncHistoryLogV4.receiveTs = syncLogV4.receiveTs;
                syncHistoryLogV4.bucket = syncLogV4.bucket;
                syncHistoryLogV4.reqId = syncLogV4.reqId;
                syncHistoryLogV4.topicType = syncLogV4.topicType;
                syncHistoryLogV4.expireTs = syncLogV4.expireTs;
                arrayList.add(syncHistoryLogV4);
            }
        }
        return arrayList;
    }

    public final boolean isExistHistory(SyncLogV4 syncLog) {
        Intrinsics.checkNotNullParameter(syncLog, "syncLog");
        String customTopic = getCustomTopic(syncLog);
        IDBServiceV4 dbService = getDbService();
        TopicType topicType = syncLog.topicType;
        Intrinsics.checkNotNullExpressionValue(topicType, "syncLog.topicType");
        List<SyncHistoryLogV4> queryHistorySyncLog = dbService.queryHistorySyncLog(topicType, syncLog.business, customTopic, -1);
        if (queryHistorySyncLog != null && !queryHistorySyncLog.isEmpty()) {
            Iterator<SyncHistoryLogV4> it = queryHistorySyncLog.iterator();
            while (it.hasNext()) {
                if (it.next().syncCursor == syncLog.syncCursor) {
                    return true;
                }
            }
        }
        return false;
    }

    private final TopicType convertTopicType(int topicTypeValue) {
        if (topicTypeValue == TopicType.SpecTopic.getValue()) {
            return TopicType.SpecTopic;
        }
        if (topicTypeValue == TopicType.CustomTopic.getValue()) {
            return TopicType.CustomTopic;
        }
        return TopicType.GlobalTopic;
    }

    private final List<ISyncClient.Data> convertHistoryLogToClientData(List<? extends SyncHistoryLogV4> historyLogList) {
        ISyncClient.Data data;
        Object[] array;
        ArrayList arrayList = new ArrayList();
        if (historyLogList != null && !historyLogList.isEmpty()) {
            for (SyncHistoryLogV4 syncHistoryLogV4 : historyLogList) {
                try {
                    data = new ISyncClient.Data();
                    if (syncHistoryLogV4.dataType == DataType.FILE_PATH) {
                        IFileDataCacheService iFileDataCacheService = (IFileDataCacheService) UgBusFramework.getService(IFileDataCacheService.class);
                        Long l = Long.getLong(syncHistoryLogV4.syncId);
                        Intrinsics.checkNotNull(l);
                        Intrinsics.checkNotNullExpressionValue(l, "getLong(syncHistoryLog.syncId)!!");
                        long longValue = l.longValue();
                        byte[] bArr = syncHistoryLogV4.data;
                        Intrinsics.checkNotNullExpressionValue(bArr, "syncHistoryLog.data");
                        String readData = iFileDataCacheService.readData(longValue, new String(bArr, Charsets.UTF_8));
                        if (readData == null) {
                            readData = "";
                        }
                        byte[] bytes = readData.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        data.data = bytes;
                    } else {
                        data.data = syncHistoryLogV4.data;
                    }
                    data.did = syncHistoryLogV4.did;
                    data.uid = syncHistoryLogV4.uid;
                    data.receiveTimeStamp = syncHistoryLogV4.receiveTs;
                    data.publishTimeStamp = syncHistoryLogV4.publishTs;
                    data.cursor = syncHistoryLogV4.syncCursor;
                    String str = syncHistoryLogV4.reqId;
                    Intrinsics.checkNotNullExpressionValue(str, "syncHistoryLog.reqId");
                    array = new Regex(":").split(str, 0).toArray(new String[0]);
                } catch (Throwable unused) {
                }
                if (array != null) {
                    data.topic = ((String[]) array)[r1.length - 1];
                    arrayList.add(data);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    break;
                }
            }
        }
        return arrayList;
    }

    private final int getTopicHistoryLimit(long businessId, TopicType topicType, String topic) {
        int i;
        try {
            int i2 = WhenMappings.$EnumSwitchMapping$0[topicType.ordinal()];
            if (i2 == 1) {
                ISyncHistory.HistoryDataConfiguration historyDataConfiguration = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().syncHistoryConfiguration.get(new StringBuilder().append(topicType.getValue()).append(':').append(businessId).toString());
                Intrinsics.checkNotNull(historyDataConfiguration);
                i = historyDataConfiguration.limit;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return 0;
                }
                ISyncHistory.HistoryDataConfiguration historyDataConfiguration2 = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().syncHistoryConfiguration.get(new StringBuilder().append(topicType.getValue()).append(':').append(businessId).toString());
                Intrinsics.checkNotNull(historyDataConfiguration2);
                i = historyDataConfiguration2.limit;
            } else {
                if (TextUtils.isEmpty(topic)) {
                    return 0;
                }
                ISyncHistory.HistoryDataConfiguration historyDataConfiguration3 = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().syncHistoryConfiguration.get(new StringBuilder().append(topicType.getValue()).append(':').append(businessId).append(':').append((Object) topic).toString());
                Intrinsics.checkNotNull(historyDataConfiguration3);
                i = historyDataConfiguration3.limit;
            }
            return i;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private final int getTopicHistoryLimit(SyncLogV4 syncLog) {
        long j = syncLog.business;
        TopicType topicType = syncLog.topicType;
        Intrinsics.checkNotNullExpressionValue(topicType, "syncLog.topicType");
        return getTopicHistoryLimit(j, topicType, getCustomTopic(syncLog));
    }

    private final int getTopicHistoryLimit(SyncHistoryLogV4 syncHistoryLog) {
        long j = syncHistoryLog.business;
        TopicType topicType = syncHistoryLog.topicType;
        Intrinsics.checkNotNullExpressionValue(topicType, "syncHistoryLog.topicType");
        return getTopicHistoryLimit(j, topicType, getCustomTopic(syncHistoryLog));
    }

    private final String getCustomTopic(SyncLogV4 syncLog) {
        return getCustomTopic(syncLog.reqId);
    }

    private final String getCustomTopic(String reqId) {
        List split$default;
        try {
            if (!TextUtils.isEmpty(reqId) && reqId != null && (split$default = StringsKt.split$default(reqId, new String[]{":"}, false, 0, 6, (Object) null)) != null) {
                return (String) CollectionsKt.last(split$default);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final String getCustomTopic(SyncHistoryLogV4 syncHistoryLog) {
        try {
            String str = syncHistoryLog.reqId;
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNullExpressionValue(str, "reqId");
                Object[] array = new Regex(":").split(str, 0).toArray(new String[0]);
                if (array != null) {
                    return ((String[]) array)[r3.length - 1];
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private final boolean packetIntercept(BsyncTopic topic, BsyncPacket packet) {
        try {
            long intValue = packet.payload.business.intValue();
            TopicType topicType = topic.topic_type;
            Intrinsics.checkNotNullExpressionValue(topicType, "topic.topic_type");
            return getTopicHistoryLimit(intValue, topicType, getCustomTopic(topic.req_id)) <= 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgHandlerWithMethod
    public boolean canHandle(Flag obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return obj == Flag.Data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HistoryDataMsgHandlerV4.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sync/v4/process/flag/HistoryDataMsgHandlerV4$HistoryPatchResult;", "", "success", "", "data", "", "errMsg", "timeConsumed", "", "(ZLjava/lang/String;Ljava/lang/String;J)V", "getData", "()Ljava/lang/String;", "getErrMsg", "setErrMsg", "(Ljava/lang/String;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "getTimeConsumed", "()J", "setTimeConsumed", "(J)V", "toString", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class HistoryPatchResult {
        private final String data;
        private String errMsg;
        private boolean success;
        private long timeConsumed;

        public HistoryPatchResult(boolean z, String str, String str2, long j) {
            this.success = z;
            this.data = str;
            this.errMsg = str2;
            this.timeConsumed = j;
        }

        public /* synthetic */ HistoryPatchResult(boolean z, String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? 0L : j);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final void setSuccess(boolean z) {
            this.success = z;
        }

        public final String getData() {
            return this.data;
        }

        public final String getErrMsg() {
            return this.errMsg;
        }

        public final void setErrMsg(String str) {
            this.errMsg = str;
        }

        public final long getTimeConsumed() {
            return this.timeConsumed;
        }

        public final void setTimeConsumed(long j) {
            this.timeConsumed = j;
        }

        public String toString() {
            return "PatchResult(success=" + this.success + ", data=~~~, errMsg=" + ((Object) this.errMsg) + ", timeConsumed=" + this.timeConsumed + ')';
        }
    }
}
