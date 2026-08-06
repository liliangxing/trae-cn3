package com.bytedance.sync.p005v4.intf;

import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.p005v4.history.ISyncHistory;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IHistoryMsgProcessor.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sync/v4/intf/IHistoryMsgProcessor;", "", "queryHistoryData", "", "Lcom/bytedance/sync/interfaze/ISyncClient$Data;", "historyData", "Lcom/bytedance/sync/v4/history/ISyncHistory$HistoryData;", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IHistoryMsgProcessor {
    List<ISyncClient.Data> queryHistoryData(ISyncHistory.HistoryData historyData);
}
