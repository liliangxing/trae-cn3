package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ClientMsgParser extends BaseIntentParse {
    private final Map<String, IntentParse> parseMap;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ParserListener {
        void onReceive(WsChannelMsg wsChannelMsg);

        void onReceiveConnectEvent(ConnectEvent connectEvent, JSONObject jSONObject);

        void onReceiveServiceEvent(ServiceConnectEvent serviceConnectEvent);

        void onSendResult(String str, boolean z);

        void replySendMsgResult(WsChannelMsg wsChannelMsg, boolean z);

        void syncState(int i, ConnectionState connectionState, boolean z);
    }

    public ClientMsgParser(ParserListener parserListener) {
        super(parserListener);
        HashMap hashMap = new HashMap();
        hashMap.put(WsConstants.RECEIVE_CONNECTION_ACTION, new ReceiveConnectionActionParse(parserListener));
        hashMap.put(WsConstants.SYNC_CONNECT_STATE, new SyncConnectStateParse(parserListener));
        hashMap.put(WsConstants.RECEIVE_PROGRESS_ACTION, new ReceiveProgressParse(parserListener));
        hashMap.put(WsConstants.RECEIVE_PAYLOAD_ACTION, new ReceivePayloadParse(parserListener));
        hashMap.put(WsConstants.SEND_PAYLOAD_ACTION, new SendPayloadParse(parserListener));
        hashMap.put(WsConstants.RECEIVE_SERVICE_ACTION, new ReceiveServiceActionParse(parserListener));
        this.parseMap = Collections.unmodifiableMap(hashMap);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent intent, ClientServiceTrace clientServiceTrace) {
        try {
            IntentParse intentParse = this.parseMap.get(intent.getAction());
            if (intentParse != null) {
                intentParse.parse(intent, clientServiceTrace);
            } else {
                Logger.m192e("error action!");
            }
        } catch (Throwable th) {
            Logger.m193e(AbsWsClientService.TAG, th.toString());
        }
        if (Logger.debug()) {
            Logger.m190d(AbsWsClientService.TAG, "count = " + intent.getIntExtra(WsConstants.MSG_COUNT, -1));
        }
    }
}
