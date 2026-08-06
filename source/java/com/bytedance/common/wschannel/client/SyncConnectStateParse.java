package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SyncConnectStateParse extends BaseIntentParse {
    public SyncConnectStateParse(ClientMsgParser.ParserListener parserListener) {
        super(parserListener);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent intent, ClientServiceTrace clientServiceTrace) {
        Logger.m190d(AbsWsClientService.TAG, "sync socket state");
        intent.setExtrasClassLoader(SocketState.class.getClassLoader());
        ArrayList<SocketState> parcelableArrayListExtra = intent.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);
        if (parcelableArrayListExtra != null) {
            for (SocketState socketState : parcelableArrayListExtra) {
                if (socketState != null) {
                    syncConnectState(socketState.getChannelId(), socketState.getConnectionState(), socketState.isPrivateProtocolEnabled());
                }
            }
        }
    }
}
