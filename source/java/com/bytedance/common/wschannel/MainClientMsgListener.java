package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MainClientMsgListener implements ClientMsgParser.ParserListener {
    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String str, boolean z) {
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg wsChannelMsg) {
        WsChannelImpl channel;
        if (wsChannelMsg == null || (channel = WsChannelSdk2.getChannel(wsChannelMsg.getChannelId())) == null) {
            return;
        }
        channel.onReceive(wsChannelMsg);
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveConnectEvent(ConnectEvent connectEvent, JSONObject jSONObject) {
        WsChannelImpl channel;
        if (connectEvent == null || (channel = WsChannelSdk2.getChannel(connectEvent.mChannelId)) == null) {
            return;
        }
        channel.onReceiveConnectEvent(connectEvent, jSONObject);
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveServiceEvent(ServiceConnectEvent serviceConnectEvent) {
        WsChannelImpl channel = WsChannelSdk2.getChannel(serviceConnectEvent.getChannelId());
        if (channel != null) {
            channel.syncServiceState(serviceConnectEvent);
            channel.onReceiveServiceConnectEvent(serviceConnectEvent);
        }
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void syncState(int i, ConnectionState connectionState, boolean z) {
        WsChannelImpl channel = WsChannelSdk2.getChannel(i);
        if (channel != null) {
            channel.syncState(connectionState, z);
        }
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void replySendMsgResult(WsChannelMsg wsChannelMsg, boolean z) {
        WsChannelImpl channel = WsChannelSdk2.getChannel(wsChannelMsg.getChannelId());
        if (channel != null) {
            channel.replySendMsgResult(wsChannelMsg, z);
        }
    }
}
