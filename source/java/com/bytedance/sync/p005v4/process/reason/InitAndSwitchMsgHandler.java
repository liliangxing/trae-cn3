package com.bytedance.sync.p005v4.process.reason;

import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.ICompensatorServiceV4;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IMsgHandler;
import com.bytedance.sync.p005v4.intf.IPayloadSendServiceV4;
import com.bytedance.sync.p005v4.intf.ISyncStatus;
import com.bytedance.sync.p005v4.lifecycle.SyncLifeCycle;
import com.bytedance.sync.p005v4.presistence.table.Business;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.protocal.BsyncHeader;
import com.bytedance.sync.p005v4.protocal.BsyncPacket;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import com.bytedance.sync.p005v4.protocal.Bucket;
import com.bytedance.sync.p005v4.protocal.Reason;
import com.bytedance.sync.p005v4.protocal.TopicStatus;
import com.bytedance.sync.p005v4.protocal.TopicType;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitAndSwitchMsgHandler.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016JB\u0010\u0014\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00130\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sync/v4/process/reason/InitAndSwitchMsgHandler;", "Lcom/bytedance/sync/v4/intf/IMsgHandler;", "Lcom/bytedance/sync/v4/protocal/Reason;", "()V", "TAG", "", "bindSyncCursor", "", "it", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "topic", "Lcom/bytedance/sync/v4/protocal/BsyncTopic;", "header", "Lcom/bytedance/sync/v4/protocal/BsyncHeader;", "canHandle", "", "obj", "handle", "topics", "", "transform", "Lkotlin/Triple;", "", "Lcom/bytedance/sync/v4/presistence/table/Business;", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitAndSwitchMsgHandler implements IMsgHandler<Reason> {
    private final String TAG = "[InitMsgHandler] ";

    @Override // com.bytedance.sync.p005v4.intf.IMsgHandler
    public void handle(BsyncHeader header, List<BsyncTopic> topics) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topics, "topics");
        LogUtils.m187i(Intrinsics.stringPlus(this.TAG, "recv init msg , try send msg to server"));
        try {
            Triple<List<String>, List<SyncCursor>, List<Business>> transform = transform(topics, header);
            List<String> list = (List) transform.component1();
            ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).updateSyncCursorAndBusiness((List) transform.component2(), list, (List) transform.component3());
            ((ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class)).onReceiveSyncMsg();
            ((ISyncStatus) UgBusFramework.getService(ISyncStatus.class)).onReceiveSyncMsg();
            ((IPayloadSendServiceV4) UgBusFramework.getService(IPayloadSendServiceV4.class)).startSendToServer();
            try {
                ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().syncLifeCycle.onLifeCycle(SyncLifeCycle.Start);
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            LogUtils.m186e(Intrinsics.stringPlus(" recv init msg err:", th));
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgHandler
    public boolean canHandle(Reason obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return obj == Reason.Init || obj == Reason.Switch;
    }

    private final Triple<List<String>, List<SyncCursor>, List<Business>> transform(List<BsyncTopic> topics, BsyncHeader header) {
        ArrayList arrayList;
        List<BsyncTopic> list = topics;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((BsyncTopic) it.next()).topic_type);
        }
        Set set = CollectionsKt.toSet(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            BsyncTopic bsyncTopic = (BsyncTopic) next;
            if (bsyncTopic.topic_type == TopicType.CustomTopic && bsyncTopic.topic_status != TopicStatus.Active) {
                z = false;
            }
            if (z) {
                arrayList3.add(next);
            }
        }
        ArrayList<BsyncTopic> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        for (BsyncTopic bsyncTopic2 : arrayList4) {
            arrayList5.add(TuplesKt.to(String.valueOf(bsyncTopic2.sync_id), bsyncTopic2));
        }
        Map map = MapsKt.toMap(arrayList5);
        Set keySet = map.keySet();
        try {
            arrayList = ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).queryLocalSyncCursorInfoWithDeviceInfo(new AccountEventSynchronizer.DeviceInfo(header.did, header.uid));
        } catch (Exception e) {
            e.printStackTrace();
            arrayList = new ArrayList();
        }
        List<SyncCursor> list2 = arrayList;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj : list2) {
            if (set.contains(((SyncCursor) obj).topicType)) {
                arrayList6.add(obj);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        for (Object obj2 : arrayList6) {
            if (!keySet.contains(((SyncCursor) obj2).syncId)) {
                arrayList7.add(obj2);
            }
        }
        ArrayList arrayList8 = arrayList7;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
        Iterator it3 = arrayList8.iterator();
        while (it3.hasNext()) {
            arrayList9.add(((SyncCursor) it3.next()).syncId);
        }
        ArrayList arrayList10 = arrayList9;
        ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (SyncCursor syncCursor : list2) {
            arrayList11.add(TuplesKt.to(syncCursor.syncId, syncCursor));
        }
        Map map2 = MapsKt.toMap(arrayList11);
        ArrayList arrayList12 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            SyncCursor syncCursor2 = (SyncCursor) map2.get(entry.getKey());
            if (syncCursor2 == null) {
                syncCursor2 = new SyncCursor();
            }
            bindSyncCursor(syncCursor2, (BsyncTopic) entry.getValue(), header);
            arrayList12.add(syncCursor2);
        }
        ArrayList arrayList13 = new ArrayList();
        for (BsyncTopic bsyncTopic3 : map.values()) {
            List<BsyncPacket> list3 = bsyncTopic3.packets;
            if (list3 != null) {
                for (BsyncPacket bsyncPacket : list3) {
                    if (bsyncPacket != null) {
                        Business business = new Business();
                        Integer num = bsyncPacket.payload.business;
                        Intrinsics.checkNotNullExpressionValue(num, "pkg.payload.business");
                        business.f234id = num.intValue();
                        business.bucket = bsyncTopic3.bucket;
                        business.consumeType = bsyncPacket.payload.consume_type;
                        arrayList13.add(business);
                    }
                }
            }
        }
        return new Triple<>(arrayList10, arrayList12, arrayList13);
    }

    private final void bindSyncCursor(SyncCursor it, BsyncTopic topic, BsyncHeader header) {
        Intrinsics.checkNotNull(topic);
        it.syncId = String.valueOf(topic.sync_id);
        it.did = header.did;
        it.uid = topic.bucket == Bucket.Device ? "0" : header.uid;
        it.bucket = topic.bucket;
        it.topicType = topic.topic_type;
        Long l = topic.ref_cursor;
        Intrinsics.checkNotNullExpressionValue(l, "topic.ref_cursor");
        if (l.longValue() > it.reportCursor) {
            Long l2 = topic.ref_cursor;
            Intrinsics.checkNotNullExpressionValue(l2, "topic.ref_cursor");
            it.reportCursor = l2.longValue();
        }
    }
}
