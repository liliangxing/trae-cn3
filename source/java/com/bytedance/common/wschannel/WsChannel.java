package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* loaded from: classes3.dex */
public interface WsChannel {
    int getChannelId();

    boolean isConnected();

    boolean isPrivateProtocolEnabled();

    boolean isServiceConnected(int i);

    void onParamChanged(ChannelInfo channelInfo);

    void registerService(int i);

    void sendMsg(WsChannelMsg wsChannelMsg, MsgSendListener msgSendListener);

    String sendMsgWithAck(WsChannelMsg wsChannelMsg, MsgSendListener msgSendListener);

    void unregister();

    void unregisterService(int i);
}
