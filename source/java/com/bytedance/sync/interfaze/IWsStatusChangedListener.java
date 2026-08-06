package com.bytedance.sync.interfaze;

import com.bytedance.common.wschannel.event.ConnectEvent;

/* loaded from: classes5.dex */
public interface IWsStatusChangedListener {
    void onReceiveConnectEvent(ConnectEvent connectEvent);
}
