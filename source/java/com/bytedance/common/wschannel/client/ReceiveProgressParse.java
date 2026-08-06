package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.model.ClientServiceTrace;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class ReceiveProgressParse extends BaseIntentParse {
    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent intent, ClientServiceTrace clientServiceTrace) {
    }

    public ReceiveProgressParse(ClientMsgParser.ParserListener parserListener) {
        super(parserListener);
    }
}
