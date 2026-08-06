package com.bytedance.sync.interfaze;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.SyncBiz;
import com.bytedance.sync.SyncBusiness;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.model.Topic;
import com.bytedance.sync.p005v4.history.ISyncHistory;
import java.util.Collection;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ISyncApi {
    List<ISyncClient.Data> getHistoryData(ISyncHistory.HistoryData historyData);

    Collection<SyncBusiness> getRegisteredBusinesses();

    void onReceiveWsChannelEvent(WsChannelMsg wsChannelMsg);

    ISyncClient registerBusiness(SyncBiz syncBiz);

    void start(String str);

    void subscribeTopic(Topic topic, Callback<Void> callback);

    void trySyncDataFromService();

    void unsubscribeTopic(Topic topic, Callback<Void> callback);
}
