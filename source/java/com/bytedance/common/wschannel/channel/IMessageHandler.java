package com.bytedance.common.wschannel.channel;

import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IMessageHandler {
    void onConnection(IWsChannelClient iWsChannelClient, int i, JSONObject jSONObject);

    void onConnection(IWsChannelClient iWsChannelClient, SocketState socketState);

    void onLinkProgress(String str, JSONObject jSONObject);

    void onMessage(int i, WsChannelMsg wsChannelMsg);

    void onMessage(int i, byte[] bArr);

    void onServiceConnectEvent(ServiceConnectEvent serviceConnectEvent);

    void replySendMsgResult(WsChannelMsg wsChannelMsg, boolean z);

    void syncSocketState();

    void tryResendMsg();
}
