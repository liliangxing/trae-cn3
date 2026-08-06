package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.SocketState;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class ReceiveConnectionActionParse extends BaseIntentParse {
    public ReceiveConnectionActionParse(ClientMsgParser.ParserListener parserListener) {
        super(parserListener);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent intent, ClientServiceTrace clientServiceTrace) {
        intent.setExtrasClassLoader(SocketState.class.getClassLoader());
        SocketState socketState = (SocketState) intent.getParcelableExtra(WsConstants.KEY_CONNECTION);
        try {
            this.mListener.onReceiveConnectEvent(new ConnectEvent(syncConnectState(socketState.getChannelId(), socketState.getConnectionState(), socketState.isPrivateProtocolEnabled()), socketState.getChannelType(), socketState.getChannelId()), socketState.toJson());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
