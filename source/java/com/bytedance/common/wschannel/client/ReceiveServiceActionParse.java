package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ReceiveServiceActionParse extends BaseIntentParse {
    public ReceiveServiceActionParse(ClientMsgParser.ParserListener parserListener) {
        super(parserListener);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent intent, ClientServiceTrace clientServiceTrace) {
        intent.setExtrasClassLoader(ServiceConnectEvent.class.getClassLoader());
        try {
            this.mListener.onReceiveServiceEvent((ServiceConnectEvent) intent.getParcelableExtra("service"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
