package com.bytedance.common.wschannel.client;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ReceivePayloadParse extends BaseIntentParse {
    public ReceivePayloadParse(ClientMsgParser.ParserListener parserListener) {
        super(parserListener);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent intent, ClientServiceTrace clientServiceTrace) {
        intent.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        WsChannelMsg wsChannelMsg = (WsChannelMsg) intent.getParcelableExtra(WsConstants.KEY_PAYLOAD);
        if (!WsConstants.getOptLogic().get().booleanValue()) {
            Message message = new Message();
            message.getData().putParcelable(WsConstants.KEY_PAYLOAD, wsChannelMsg);
            message.getData().setClassLoader(WsChannelMsg.class.getClassLoader());
            Parcelable parcelable = message.getData().getParcelable(WsConstants.KEY_PAYLOAD);
            wsChannelMsg = parcelable instanceof WsChannelMsg ? (WsChannelMsg) parcelable : null;
        }
        if (wsChannelMsg != null) {
            if (Logger.debug()) {
                Logger.m190d(AbsWsClientService.TAG, "get wsChannelMsg = " + wsChannelMsg.toString());
            }
            if (clientServiceTrace != null) {
                wsChannelMsg.receiveDataFromIpcTs = clientServiceTrace.onReceiveDataFromIpcTs;
            }
            this.mListener.onReceive(wsChannelMsg);
        }
    }
}
