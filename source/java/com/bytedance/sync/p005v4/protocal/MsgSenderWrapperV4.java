package com.bytedance.sync.p005v4.protocal;

import android.content.Context;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sync.ICommonParamProvider;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.model.PayloadEntry;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
import com.bytedance.sync.p005v4.protocal.BsyncCursor;
import com.bytedance.sync.p005v4.protocal.BsyncHeader;
import com.bytedance.sync.p005v4.protocal.BsyncPacket;
import com.bytedance.sync.p005v4.protocal.BsyncPayload;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.ss.android.ug.bus.IUgBusService;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.json.JSONObject;

/* compiled from: MsgSenderWrapperV4.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J:\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010H\u0016J\u0016\u0010\u001f\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0010H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/sync/v4/protocal/MsgSenderWrapperV4;", "Lcom/bytedance/sync/v4/intf/ISyncMsgSenderV4;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "mMsgSender", "Lcom/bytedance/sync/v4/intf/IMsgSender;", "(Landroid/content/Context;Lcom/bytedance/sync/v4/intf/IMsgSender;)V", "TAG", "", "getCommonParamsJsonObject", "Lorg/json/JSONObject;", "isPendingPayloadToSend", "", "sendPayload", "", "Lkotlin/Pair;", "syncId", "dataList", "", "Lcom/bytedance/sync/v4/presistence/table/UploadItemV4;", "sendWithHttps", "sendPollMsg", "", "forceHttp", "reason", "", "sendSnapshotFinMsg", "snapshots", "Lcom/bytedance/sync/v4/presistence/table/Snapshot;", "sendSyncLogFinMsg", "syncLog", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "sendSyncMsg", "sendSyncPollMsg", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MsgSenderWrapperV4 implements ISyncMsgSenderV4 {
    private final String TAG;
    private final Context mContext;
    private final IMsgSender mMsgSender;

    @Override // com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4
    public void sendSyncMsg() {
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4
    public void sendSyncPollMsg() {
    }

    public MsgSenderWrapperV4(Context context, IMsgSender iMsgSender) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(iMsgSender, "mMsgSender");
        this.mContext = context;
        this.mMsgSender = iMsgSender;
        this.TAG = "[MsgSenderWrapperV4] ";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MsgSenderWrapperV4(Context context) {
        this(context, (IMsgSender) r0);
        Intrinsics.checkNotNullParameter(context, "context");
        IUgBusService service = UgBusFramework.getService(IMsgSender.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(IMsgSender::class.java)");
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4
    public void sendPollMsg(boolean forceHttp, int reason) {
        IDBServiceV4 iDBServiceV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        try {
            Intrinsics.checkNotNullExpressionValue(deviceInfo, "deviceInfo");
            ArrayList queryLocalSyncCursorInfoWithDeviceInfo = iDBServiceV4.queryLocalSyncCursorInfoWithDeviceInfo(deviceInfo);
            HashMap hashMap = new HashMap();
            JSONObject commonParamsJsonObject = getCommonParamsJsonObject();
            Integer valueOf = Integer.valueOf(InfoKey.Params.getValue());
            ByteString encodeUtf8 = ByteString.encodeUtf8(commonParamsJsonObject.toString());
            Intrinsics.checkNotNullExpressionValue(encodeUtf8, "encodeUtf8(params.toString())");
            hashMap.put(valueOf, encodeUtf8);
            BsyncHeader.Builder infos = new BsyncHeader.Builder().version(Version.V4).did(deviceInfo.getDid()).uid(deviceInfo.getUid()).m189ts(Long.valueOf(System.currentTimeMillis())).sdk_version(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW).platform(Platform.android).infos(hashMap);
            if (reason == Reason.Init.getValue() || reason == Reason.Switch.getValue()) {
                infos.ctrl = Ctrl.NeedData;
            }
            infos.reason = Reason.fromValue(reason);
            BsyncHeader m995build = infos.m995build();
            if (!ToolUtils.isMainProcess(this.mContext)) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : queryLocalSyncCursorInfoWithDeviceInfo) {
                    if (((SyncCursor) obj).topicType == TopicType.SpecTopic) {
                        arrayList.add(obj);
                    }
                }
                queryLocalSyncCursorInfoWithDeviceInfo = arrayList;
            }
            if (queryLocalSyncCursorInfoWithDeviceInfo.isEmpty()) {
                SyncCursor syncCursor = new SyncCursor();
                syncCursor.topicType = TopicType.SpecTopic;
                syncCursor.bucket = Bucket.Device;
                syncCursor.syncId = "0";
                syncCursor.receiveCursor = 0L;
                queryLocalSyncCursorInfoWithDeviceInfo = CollectionsKt.listOf(syncCursor);
            }
            List<SyncCursor> list = queryLocalSyncCursorInfoWithDeviceInfo;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (SyncCursor syncCursor2 : list) {
                BsyncTopic.Builder bucket = new BsyncTopic.Builder().flag(Flag.Poll).topic_type(syncCursor2.topicType).bucket(syncCursor2.bucket);
                String str = syncCursor2.syncId;
                Intrinsics.checkNotNullExpressionValue(str, "it.syncId");
                arrayList2.add(bucket.sync_id(Long.valueOf(Long.parseLong(str))).ref_cursor(Long.valueOf(syncCursor2.receiveCursor)).m1007build());
            }
            BsyncProtocol m1004build = new BsyncProtocol.Builder().header(m995build).topics(arrayList2).m1004build();
            PayloadEntry payloadEntry = new PayloadEntry();
            payloadEntry.canFallback = !forceHttp;
            payloadEntry.forceHttps = forceHttp;
            payloadEntry.msg = m1004build;
            payloadEntry.sendReason = reason;
            this.mMsgSender.send(payloadEntry);
        } catch (Throwable th) {
            SyncMonitor.monitorException$default(th, null, 2, null);
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4
    public void sendSyncLogFinMsg(List<? extends SyncLogV4> syncLog) {
        Intrinsics.checkNotNullParameter(syncLog, "syncLog");
        if (syncLog.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        IDBServiceV4 iDBServiceV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        HashMap hashMap = new HashMap();
        JSONObject commonParamsJsonObject = getCommonParamsJsonObject();
        Integer valueOf = Integer.valueOf(InfoKey.Params.getValue());
        ByteString encodeUtf8 = ByteString.encodeUtf8(commonParamsJsonObject.toString());
        Intrinsics.checkNotNullExpressionValue(encodeUtf8, "encodeUtf8(params.toString())");
        hashMap.put(valueOf, encodeUtf8);
        BsyncHeader m995build = new BsyncHeader.Builder().version(Version.V4).did(deviceInfo.getDid()).uid(deviceInfo.getUid()).m189ts(Long.valueOf(currentTimeMillis)).sdk_version(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW).platform(Platform.android).infos(hashMap).m995build();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : syncLog) {
            String str = ((SyncLogV4) obj).syncId;
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(obj);
        }
        try {
            List<SyncCursor> queryLocalSyncCursorInfoWithSyncIds = iDBServiceV4.queryLocalSyncCursorInfoWithSyncIds(CollectionsKt.toList(linkedHashMap.keySet()));
            ArrayList arrayList = new ArrayList();
            for (SyncCursor syncCursor : queryLocalSyncCursorInfoWithSyncIds) {
                List list = (List) linkedHashMap.get(syncCursor.syncId);
                if (list != null) {
                    BsyncTopic.Builder builder = new BsyncTopic.Builder().flag(Flag.FIN).topic_type(syncCursor.topicType);
                    String str2 = syncCursor.syncId;
                    Intrinsics.checkNotNullExpressionValue(str2, "syncCursor.syncId");
                    BsyncTopic.Builder ref_cursor = builder.sync_id(Long.valueOf(Long.parseLong(str2))).ref_cursor(Long.valueOf(syncCursor.receiveCursor));
                    List<SyncLogV4> list2 = list;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (SyncLogV4 syncLogV4 : list2) {
                        arrayList2.add(new BsyncPacket.Builder().cursor(new BsyncCursor.Builder().cursor(Long.valueOf(syncLogV4.syncCursor)).m992build()).payload(new BsyncPayload.Builder().business(Integer.valueOf((int) syncLogV4.business)).consume_type(syncLogV4.consumeType).data(ByteString.EMPTY).m1001build()).m190ts(Long.valueOf(currentTimeMillis)).m998build());
                    }
                    arrayList.add(ref_cursor.packets(CollectionsKt.toMutableList(arrayList2)).m1007build());
                }
            }
            BsyncProtocol m1004build = new BsyncProtocol.Builder().header(m995build).topics(arrayList).m1004build();
            PayloadEntry payloadEntry = new PayloadEntry();
            payloadEntry.canFallback = true;
            payloadEntry.msg = m1004build;
            this.mMsgSender.send(payloadEntry);
        } catch (Throwable th) {
            SyncMonitor.monitorException$default(th, null, 2, null);
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4
    public void sendSnapshotFinMsg(List<? extends Snapshot> snapshots) {
        Intrinsics.checkNotNullParameter(snapshots, "snapshots");
        long currentTimeMillis = System.currentTimeMillis();
        IDBServiceV4 iDBServiceV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        HashMap hashMap = new HashMap();
        JSONObject commonParamsJsonObject = getCommonParamsJsonObject();
        Integer valueOf = Integer.valueOf(InfoKey.Params.getValue());
        ByteString encodeUtf8 = ByteString.encodeUtf8(commonParamsJsonObject.toString());
        Intrinsics.checkNotNullExpressionValue(encodeUtf8, "encodeUtf8(params.toString())");
        hashMap.put(valueOf, encodeUtf8);
        BsyncHeader m995build = new BsyncHeader.Builder().version(Version.V4).did(deviceInfo.getDid()).uid(deviceInfo.getUid()).m189ts(Long.valueOf(currentTimeMillis)).sdk_version(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW).platform(Platform.android).infos(hashMap).m995build();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : snapshots) {
            String str = ((Snapshot) obj).syncId;
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(obj);
        }
        try {
            List<SyncCursor> queryLocalSyncCursorInfoWithSyncIds = iDBServiceV4.queryLocalSyncCursorInfoWithSyncIds(CollectionsKt.toList(linkedHashMap.keySet()));
            ArrayList arrayList = new ArrayList();
            for (SyncCursor syncCursor : queryLocalSyncCursorInfoWithSyncIds) {
                List list = (List) linkedHashMap.get(syncCursor.syncId);
                if (list != null) {
                    BsyncTopic.Builder builder = new BsyncTopic.Builder().flag(Flag.FIN).topic_type(syncCursor.topicType);
                    String str2 = syncCursor.syncId;
                    Intrinsics.checkNotNullExpressionValue(str2, "syncCursor.syncId");
                    BsyncTopic.Builder ref_cursor = builder.sync_id(Long.valueOf(Long.parseLong(str2))).ref_cursor(Long.valueOf(syncCursor.receiveCursor));
                    List<Snapshot> list2 = list;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (Snapshot snapshot : list2) {
                        arrayList2.add(new BsyncPacket.Builder().cursor(new BsyncCursor.Builder().cursor(Long.valueOf(snapshot.cursor)).m992build()).payload(new BsyncPayload.Builder().business(Integer.valueOf((int) snapshot.business)).consume_type(snapshot.consumeType).data(ByteString.EMPTY).m1001build()).m190ts(Long.valueOf(currentTimeMillis)).m998build());
                    }
                    arrayList.add(ref_cursor.packets(CollectionsKt.toMutableList(arrayList2)).m1007build());
                }
            }
            BsyncProtocol m1004build = new BsyncProtocol.Builder().header(m995build).topics(arrayList).m1004build();
            PayloadEntry payloadEntry = new PayloadEntry();
            payloadEntry.canFallback = true;
            payloadEntry.msg = m1004build;
            this.mMsgSender.send(payloadEntry);
        } catch (Throwable th) {
            SyncMonitor.monitorException$default(th, null, 2, null);
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4
    public List<Pair<String, String>> sendPayload(String syncId, List<UploadItemV4> dataList, boolean sendWithHttps) {
        Intrinsics.checkNotNullParameter(syncId, "syncId");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (dataList.isEmpty()) {
            LogUtils.m186e(this.TAG + "payload is null or empty when send to server,syncId = " + syncId);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        HashMap hashMap = new HashMap();
        JSONObject commonParamsJsonObject = getCommonParamsJsonObject();
        Integer valueOf = Integer.valueOf(InfoKey.Params.getValue());
        ByteString encodeUtf8 = ByteString.encodeUtf8(commonParamsJsonObject.toString());
        Intrinsics.checkNotNullExpressionValue(encodeUtf8, "encodeUtf8(params.toString())");
        hashMap.put(valueOf, encodeUtf8);
        BsyncHeader m995build = new BsyncHeader.Builder().version(Version.V4).did(deviceInfo.getDid()).uid(deviceInfo.getUid()).m189ts(Long.valueOf(currentTimeMillis)).sdk_version(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW).platform(Platform.android).infos(hashMap).m995build();
        ArrayList arrayList = new ArrayList();
        BsyncTopic.Builder sync_id = new BsyncTopic.Builder().flag(Flag.Data).topic_type(TopicType.SpecTopic).sync_id(Long.valueOf(Long.parseLong(syncId)));
        List<UploadItemV4> list = dataList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (UploadItemV4 uploadItemV4 : list) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            String str = uploadItemV4.msg_id;
            if (str == null) {
                str = uploadItemV4.did + ((Object) uploadItemV4.syncId) + uploadItemV4.cursor;
            }
            arrayList.add(TuplesKt.to(str, uuid));
            arrayList2.add(new BsyncPacket.Builder().cursor(new BsyncCursor.Builder().cursor(Long.valueOf(uploadItemV4.cursor)).m992build()).payload(new BsyncPayload.Builder().business(Integer.valueOf((int) uploadItemV4.business)).data(ByteString.of(uploadItemV4.data, 0, uploadItemV4.data.length)).m1001build()).m190ts(Long.valueOf(currentTimeMillis)).extra(MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", str), TuplesKt.to("msg_req_id", uuid)})).m998build());
        }
        BsyncProtocol m1004build = new BsyncProtocol.Builder().header(m995build).topics(CollectionsKt.arrayListOf(new BsyncTopic[]{sync_id.packets(CollectionsKt.toList(arrayList2)).m1007build()})).m1004build();
        PayloadEntry payloadEntry = new PayloadEntry();
        payloadEntry.canFallback = !sendWithHttps;
        payloadEntry.msg = m1004build;
        payloadEntry.forceHttps = sendWithHttps;
        payloadEntry.sendReason = 3;
        this.mMsgSender.send(payloadEntry);
        return arrayList;
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4
    public boolean isPendingPayloadToSend() {
        return this.mMsgSender.isPendingPayloadToSend();
    }

    private final JSONObject getCommonParamsJsonObject() {
        Object commonParams = ((ICommonParamProvider) UgBusFramework.getService(ICommonParamProvider.class)).getCommonParams();
        if (commonParams == null) {
            commonParams = new JSONObject();
        }
        try {
            try {
                return new JSONObject((Map) commonParams);
            } catch (Throwable unused) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : ((Map) commonParams).entrySet()) {
                    Object key = entry.getKey();
                    if (key == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    jSONObject.put((String) key, entry.getValue());
                }
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return new JSONObject();
        }
    }
}
