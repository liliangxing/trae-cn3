package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.MainClientMsgListener;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.bytedance.common.wschannel.utils.Utils;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MainMsgHandler implements IMessageHandler {
    private final ChannelKeeper channelKeeper;
    private final Context mContext;
    private ChannelManager mManager;
    private ClientMsgParser.ParserListener mListener = new MainClientMsgListener();
    private ClientMsgParser parser = new ClientMsgParser(this.mListener);
    private final AtomicInteger mMsgCount = new AtomicInteger(0);
    private final boolean traceEnable = false;

    private long getTsIfEnable() {
        return 0L;
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onLinkProgress(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void tryResendMsg() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MainMsgHandler(Context context, ChannelKeeper channelKeeper) {
        this.mContext = context;
        this.channelKeeper = channelKeeper;
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        handleMessage(new WsChannelService.Msg(i, bArr, 0L));
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int i, WsChannelMsg wsChannelMsg) {
        if (wsChannelMsg == null) {
            return;
        }
        handleMessage(new WsChannelService.Msg(i, wsChannelMsg, 0L));
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient iWsChannelClient, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(WsConstants.KEY_CHANNEL_ID, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onConnection(iWsChannelClient, SocketState.fromJson(jSONObject));
        trySyncCurrentState(iWsChannelClient);
    }

    private void trySyncCurrentState(IWsChannelClient iWsChannelClient) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable()) {
            this.mManager.syncCurrentState(iWsChannelClient);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient iWsChannelClient, SocketState socketState) {
        if (socketState == null) {
            return;
        }
        this.channelKeeper.mChannelState.put(Integer.valueOf(socketState.getChannelId()), socketState);
        try {
            Intent intent = new Intent();
            intent.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);
            intent.putExtra(WsConstants.KEY_CONNECTION, socketState);
            this.parser.parse(intent, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onServiceConnectEvent(ServiceConnectEvent serviceConnectEvent) {
        try {
            Intent intent = new Intent();
            intent.setAction(WsConstants.RECEIVE_SERVICE_ACTION);
            intent.putExtra("service", serviceConnectEvent);
            this.parser.parse(intent, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void handleMessage(WsChannelService.Msg msg) {
        WsChannelMsg decode;
        if (msg != null) {
            if (msg.data == null && msg.message == null) {
                return;
            }
            boolean z = msg.message != null;
            try {
                long tsIfEnable = getTsIfEnable();
                if (z) {
                    decode = msg.message;
                } else {
                    byte[] bArr = msg.data;
                    if (Logger.debug()) {
                        Logger.m190d("WsChannelService", "data = " + Utils.byte2HexStr(bArr) + " data.length = " + bArr.length);
                    }
                    decode = MsgConverterFactory.getConverter().decode(bArr);
                }
                long tsIfEnable2 = getTsIfEnable();
                if (decode != WsChannelMsg.EMPTY && !FrontierMessageManager.shouldDropMessageByFilter(decode)) {
                    decode.setNewMsgTimeHolder(new NewMsgTimeHolder(msg.f132ts, tsIfEnable, tsIfEnable2));
                    decode.setChannelId(msg.channelId);
                    decode.setReplayToComponentName(new ComponentName(this.mContext, (Class<?>) WsChannelService.class));
                    if (Logger.debug()) {
                        Logger.m190d("WsChannelService", "version =  seqId = " + decode.getSeqId() + " logId = " + decode.getLogId() + " wsChannelMsg = " + decode.toString());
                    }
                    if (this.channelKeeper.mWsAppMap != null && this.channelKeeper.mWsAppMap.size() > 0) {
                        Iterator<Map.Entry<Integer, IWsApp>> it = this.channelKeeper.mWsAppMap.entrySet().iterator();
                        while (it.hasNext()) {
                            IWsApp value = it.next().getValue();
                            if (value != null && value.getChannelId() == decode.getChannelId()) {
                                Intent intent = new Intent();
                                intent.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);
                                intent.putExtra(WsConstants.KEY_PAYLOAD, decode);
                                if (Logger.debug()) {
                                    intent.putExtra(WsConstants.MSG_COUNT, this.mMsgCount.addAndGet(1));
                                }
                                this.parser.parse(intent, null);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (th instanceof ProtocolException) {
                    Logger.m193e("WsChannelSdk", "Unsupported message protocol, ignore this message");
                } else {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void syncSocketState() {
        Intent intent = new Intent();
        intent.setAction(WsConstants.SYNC_CONNECT_STATE);
        intent.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList<>(this.channelKeeper.mChannelState.values()));
        this.parser.parse(intent, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setChannelManager(ChannelManager channelManager) {
        this.mManager = channelManager;
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void replySendMsgResult(WsChannelMsg wsChannelMsg, boolean z) {
        this.mListener.replySendMsgResult(wsChannelMsg, z);
    }
}
