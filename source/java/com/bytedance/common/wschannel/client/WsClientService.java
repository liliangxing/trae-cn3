package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsClientService extends AbsWsClientService {
    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void replySendMsgResult(WsChannelMsg wsChannelMsg, boolean z) {
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService, com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg wsChannelMsg) {
        if (wsChannelMsg != null) {
            try {
                OnMessageReceiveListener listener = WsConstants.getListener(wsChannelMsg.getChannelId());
                if (listener != null && !wsChannelMsg.isAckMsg()) {
                    listener.onReceiveMsg(wsChannelMsg);
                } else {
                    OnMessageAckListener messageAckListener = WsConstants.getMessageAckListener();
                    if (messageAckListener != null && wsChannelMsg.isAckMsg()) {
                        MessageAckEvent messageAckEvent = new MessageAckEvent(wsChannelMsg.getUUID(), wsChannelMsg.getChannelId(), wsChannelMsg.getService(), wsChannelMsg.getMethod(), wsChannelMsg.getLogInfo());
                        messageAckEvent.setState(wsChannelMsg.getState());
                        messageAckListener.onReceiveMsgAck(messageAckEvent);
                    }
                }
            } catch (Throwable th) {
                Logger.m192e(th.toString());
            }
        }
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService, com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String str, boolean z) {
        super.onSendResult(str, z);
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveConnectEvent(ConnectEvent connectEvent, JSONObject jSONObject) {
        OnMessageReceiveListener listener;
        if (connectEvent == null || (listener = WsConstants.getListener(connectEvent.mChannelId)) == null) {
            return;
        }
        listener.onReceiveConnectEvent(connectEvent, jSONObject);
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveServiceEvent(ServiceConnectEvent serviceConnectEvent) {
        if (serviceConnectEvent == null) {
            return;
        }
        WsConstants.setServiceState(serviceConnectEvent);
        OnServiceConnectListener serviceConnectListener = WsConstants.getServiceConnectListener();
        if (serviceConnectListener != null) {
            serviceConnectListener.onServiceConnectEvent(serviceConnectEvent);
        }
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void syncState(int i, ConnectionState connectionState, boolean z) {
        WsConstants.setConnectionState(i, connectionState, z);
    }
}
