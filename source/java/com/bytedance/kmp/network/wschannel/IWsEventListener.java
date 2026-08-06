package com.bytedance.kmp.network.wschannel;

import kotlin.Metadata;

/* compiled from: IWsEventListener.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/network/wschannel/IWsEventListener;", "", "onConnectStateChange", "", "state", "Lcom/bytedance/kmp/network/wschannel/ConnectionState;", "connectLog", "", "onMsgReceived", "msg", "Lcom/bytedance/kmp/network/wschannel/WsChannelMsg;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IWsEventListener {
    void onConnectStateChange(ConnectionState state, String connectLog);

    void onMsgReceived(WsChannelMsg msg);
}
