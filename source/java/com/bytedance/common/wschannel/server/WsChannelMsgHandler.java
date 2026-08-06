package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.bytedance.common.wschannel.utils.TimeCompactUtil;
import com.bytedance.common.wschannel.utils.Utils;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelMsgHandler implements IMessageHandler {
    private static AtomicBoolean mDispatcherAlive = new AtomicBoolean(true);
    private final Context mContext;
    private final ChannelKeeper mKeeper;
    private ChannelManager mManager;
    private final ClientMsgSender mMessageSender;
    private BlockingQueue<WsChannelService.Msg> mMessageQueue = new LinkedBlockingQueue();
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private Runnable mMessageDispatcher = createMessageDispatcher();
    private Future<?> mMessageDispatcherFeature = null;
    private final boolean traceEnable = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WsChannelMsgHandler(Context context, ChannelKeeper channelKeeper) {
        this.mContext = context;
        this.mKeeper = channelKeeper;
        this.mMessageSender = new ClientMsgSender(context, WsClientService.class);
        startMessageDispatcher();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            this.mMessageQueue.offer(new WsChannelService.Msg(i, bArr, getTsIfEnable()));
            mDispatcherAlive.getAndSet(true);
            startMessageDispatcher();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int i, WsChannelMsg wsChannelMsg) {
        if (wsChannelMsg == null) {
            return;
        }
        try {
            this.mMessageQueue.offer(new WsChannelService.Msg(i, wsChannelMsg, getTsIfEnable()));
            mDispatcherAlive.getAndSet(true);
            startMessageDispatcher();
        } catch (Throwable th) {
            th.printStackTrace();
        }
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
        SocketState fromJson = SocketState.fromJson(jSONObject);
        onConnection(iWsChannelClient, fromJson);
        trySyncCurrentState(iWsChannelClient);
        if (Logger.debug()) {
            Logger.m190d("WsChannelService", "onConnection: state=" + fromJson.connectionState + " | type=" + fromJson.connectionType + " | error=" + fromJson.error);
        }
    }

    private void trySyncCurrentState(IWsChannelClient iWsChannelClient) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable()) {
            this.mManager.syncCurrentState(iWsChannelClient);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onLinkProgress(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        jSONObject.put(WsConstants.KEY_PROGRESS, str);
        Intent intent = new Intent();
        intent.setAction(WsConstants.RECEIVE_PROGRESS_ACTION);
        intent.setComponent(new ComponentName(this.mContext, (Class<?>) WsClientService.class));
        intent.putExtra(WsConstants.KEY_PROGRESS, jSONObject.toString());
        startOrBindService(intent);
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient iWsChannelClient, SocketState socketState) {
        if (socketState == null) {
            return;
        }
        this.mKeeper.mChannelState.put(Integer.valueOf(socketState.getChannelId()), socketState);
        try {
            Intent intent = new Intent();
            intent.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);
            intent.setComponent(new ComponentName(this.mContext, (Class<?>) WsClientService.class));
            intent.putExtra(WsConstants.KEY_CONNECTION, socketState);
            startOrBindService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onServiceConnectEvent(ServiceConnectEvent serviceConnectEvent) {
        try {
            Intent intent = new Intent();
            intent.setAction(WsConstants.RECEIVE_SERVICE_ACTION);
            intent.setComponent(new ComponentName(this.mContext, (Class<?>) WsClientService.class));
            intent.putExtra("service", serviceConnectEvent);
            startOrBindService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void startMessageDispatcher() {
        if (this.mMessageDispatcher == null) {
            this.mMessageDispatcher = createMessageDispatcher();
        }
        try {
            this.mMessageDispatcherFeature = this.mExecutorService.submit(this.mMessageDispatcher);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Runnable createMessageDispatcher() {
        return new Runnable() { // from class: com.bytedance.common.wschannel.server.WsChannelMsgHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.currentThread().setName("MessageDispatcher");
                    while (true) {
                        Thread.currentThread();
                        if (Thread.interrupted()) {
                            break;
                        }
                        WsChannelMsgHandler.mDispatcherAlive.getAndSet(true);
                        try {
                            WsChannelMsgHandler.this.handleMessage((WsChannelService.Msg) WsChannelMsgHandler.this.mMessageQueue.take());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                WsChannelMsgHandler.mDispatcherAlive.getAndSet(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(WsChannelService.Msg msg) {
        WsChannelMsg decode;
        if (msg == null) {
            return;
        }
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
                if (this.mKeeper.mWsAppMap != null && this.mKeeper.mWsAppMap.size() > 0) {
                    Iterator<Map.Entry<Integer, IWsApp>> it = this.mKeeper.mWsAppMap.entrySet().iterator();
                    while (it.hasNext()) {
                        IWsApp value = it.next().getValue();
                        if (value == null) {
                            Logger.m193e("WsChannelService", "wsApp is null!");
                        } else if (value.getChannelId() == decode.getChannelId()) {
                            try {
                                Intent intent = new Intent();
                                intent.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);
                                intent.setComponent(new ComponentName(this.mContext, (Class<?>) WsClientService.class));
                                intent.putExtra(WsConstants.KEY_PAYLOAD, decode);
                                startOrBindService(intent);
                            } catch (Throwable th) {
                                Logger.m193e("WsChannelService", "deliver fail,reason:" + th);
                            }
                        }
                    }
                    return;
                }
                Logger.m193e("WsChannelService", "mKeeper.mWsAppMap is empty!");
                return;
            }
            Logger.m193e("WsChannelService", "handleMessage decode msg is EMPTY!");
        } catch (Throwable th2) {
            if (th2 instanceof ProtocolException) {
                Logger.m193e("WsChannelSdk", "Unsupported message protocol, ignore this message");
            } else {
                th2.printStackTrace();
            }
        }
    }

    private long getTsIfEnable() {
        if (this.traceEnable) {
            return TimeCompactUtil.getTimeStampNanos();
        }
        return 0L;
    }

    private void startOrBindService(Intent intent) {
        this.mMessageSender.sendMsg(intent);
    }

    void onDestroy() {
        try {
            Future<?> future = this.mMessageDispatcherFeature;
            if (future != null) {
                future.cancel(true);
                this.mMessageDispatcherFeature = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            ExecutorService executorService = this.mExecutorService;
            if (executorService != null) {
                executorService.shutdown();
                this.mExecutorService = null;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void syncSocketState() {
        try {
            Intent intent = new Intent();
            intent.setAction(WsConstants.SYNC_CONNECT_STATE);
            intent.setComponent(new ComponentName(this.mContext, (Class<?>) WsClientService.class));
            intent.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList<>(this.mKeeper.mChannelState.values()));
            startOrBindService(intent);
            Logger.m190d("WsChannelSdk", "try sync socket state to main process");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void replySendMsgResult(WsChannelMsg wsChannelMsg, boolean z) {
        ComponentName replayToComponentName = wsChannelMsg.getReplayToComponentName();
        if (replayToComponentName != null) {
            try {
                byte[] payload = wsChannelMsg.getPayload();
                if (payload == null) {
                    payload = new byte[1];
                }
                Intent intent = new Intent();
                intent.setAction(WsConstants.SEND_PAYLOAD_ACTION);
                intent.setComponent(replayToComponentName);
                intent.putExtra(WsConstants.KEY_SEND_RESULT, z);
                intent.putExtra(WsConstants.KEY_PAYLOAD_MD5, DigestUtils.md5Hex(payload));
                if (Logger.debug()) {
                    Logger.m190d("WsChannelService", "send result = " + z + " payloadMd5 = " + intent.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));
                }
                this.mContext.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void tryResendMsg() {
        this.mMessageSender.tryResendMsg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setChannelManager(ChannelManager channelManager) {
        this.mManager = channelManager;
    }
}
