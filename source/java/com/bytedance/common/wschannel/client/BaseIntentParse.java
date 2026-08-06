package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.event.ConnectionState;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseIntentParse implements IntentParse {
    protected final ClientMsgParser.ParserListener mListener;

    public BaseIntentParse(ClientMsgParser.ParserListener parserListener) {
        this.mListener = parserListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ConnectionState syncConnectState(int i, int i2, boolean z) {
        ConnectionState connectionState = ConnectionState.CONNECTION_UNKNOWN;
        if (i2 == 0) {
            connectionState = ConnectionState.CONNECTION_UNKNOWN;
        } else if (i2 == 1) {
            connectionState = ConnectionState.CONNECTING;
        } else if (i2 == 2) {
            connectionState = ConnectionState.CONNECT_FAILED;
        } else if (i2 == 3) {
            connectionState = ConnectionState.CONNECT_CLOSED;
        } else if (i2 == 4) {
            connectionState = ConnectionState.CONNECTED;
        }
        if (Logger.debug()) {
            Logger.m190d(AbsWsClientService.TAG, "state = " + i2 + " connectionState = " + connectionState);
        }
        this.mListener.syncState(i, connectionState, z);
        return connectionState;
    }
}
