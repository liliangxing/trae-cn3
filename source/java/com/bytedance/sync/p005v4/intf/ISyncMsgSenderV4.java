package com.bytedance.sync.p005v4.intf;

import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
import com.ss.android.ug.bus.IUgBusService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

/* compiled from: ISyncMsgSenderV4.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J:\u0010\u0004\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0003H&J\u001c\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\u0016\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005H&J\u0016\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005H&J\b\u0010\u0018\u001a\u00020\u000eH&J\b\u0010\u0019\u001a\u00020\u000eH&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sync/v4/intf/ISyncMsgSenderV4;", "Lcom/ss/android/ug/bus/IUgBusService;", "isPendingPayloadToSend", "", "sendPayload", "", "Lkotlin/Pair;", "", "syncId", "dataList", "", "Lcom/bytedance/sync/v4/presistence/table/UploadItemV4;", "sendWithHttps", "sendPollMsg", "", "forceHttp", "reason", "", "sendSnapshotFinMsg", "snapshots", "Lcom/bytedance/sync/v4/presistence/table/Snapshot;", "sendSyncLogFinMsg", "syncLog", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "sendSyncMsg", "sendSyncPollMsg", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ISyncMsgSenderV4 extends IUgBusService {
    boolean isPendingPayloadToSend();

    List<Pair<String, String>> sendPayload(String syncId, List<UploadItemV4> dataList, boolean sendWithHttps);

    void sendPollMsg(boolean forceHttp, int reason);

    void sendSnapshotFinMsg(List<? extends Snapshot> snapshots);

    void sendSyncLogFinMsg(List<? extends SyncLogV4> syncLog);

    void sendSyncMsg();

    void sendSyncPollMsg();

    /* compiled from: ISyncMsgSenderV4.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void sendPollMsg$default(ISyncMsgSenderV4 iSyncMsgSenderV4, boolean z, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPollMsg");
            }
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            iSyncMsgSenderV4.sendPollMsg(z, i);
        }
    }
}
