package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class SendPayloadParse extends BaseIntentParse {
    public SendPayloadParse(ClientMsgParser.ParserListener parserListener) {
        super(parserListener);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent intent, ClientServiceTrace clientServiceTrace) {
        intent.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        String stringExtra = intent.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);
        boolean booleanExtra = intent.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);
        if (Logger.debug()) {
            Logger.m190d(AbsWsClientService.TAG, "get payloadMd5 = " + stringExtra + " sendResult = " + booleanExtra);
        }
        this.mListener.onSendResult(stringExtra, booleanExtra);
    }
}
