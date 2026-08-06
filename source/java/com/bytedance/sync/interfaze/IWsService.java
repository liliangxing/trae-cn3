package com.bytedance.sync.interfaze;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* loaded from: classes5.dex */
public interface IWsService {
    boolean isConnect();

    void registerOnWsStatusChangedListener(IWsStatusChangedListener iWsStatusChangedListener);

    void send(WsChannelMsg wsChannelMsg);
}
