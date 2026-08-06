package com.bytedance.common.wschannel;

import android.content.Context;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WsChannelImpl implements WsChannel {
    private final OnMessageAckListener mAckReceiver;
    private ChannelInfo mChannelInfo;
    private final Context mContext;
    private final WsChannelApi mImpl;
    private boolean mPrivateProtocolEnabled;
    private final OnMessageReceiveListener mReceiver;
    private final OnServiceConnectListener mServiceListener;
    private ConnectionState mState;
    private SsWsApp mWsApp;
    private AtomicBoolean mPendingUnRegister = new AtomicBoolean(false);
    private ConcurrentHashMap<Integer, Boolean> mServiceState = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public WsChannelImpl(Context context, WsChannelApi wsChannelApi, ChannelInfo channelInfo, OnMessageReceiveListener onMessageReceiveListener, OnServiceConnectListener onServiceConnectListener, OnMessageAckListener onMessageAckListener) {
        this.mContext = context;
        this.mImpl = wsChannelApi;
        this.mChannelInfo = channelInfo;
        this.mReceiver = onMessageReceiveListener;
        this.mServiceListener = onServiceConnectListener;
        this.mAckReceiver = onMessageAckListener;
        this.mWsApp = WsChannelSdk2.createParameterMap(channelInfo);
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public int getChannelId() {
        return this.mChannelInfo.channelId;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void unregister() {
        this.mImpl.unRegisterApp(this.mContext, this.mChannelInfo.channelId);
        this.mPendingUnRegister.set(true);
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void onParamChanged(ChannelInfo channelInfo) {
        if (channelInfo == null || channelInfo.channelId != this.mChannelInfo.channelId) {
            throw new IllegalArgumentException("channelId isn't the same");
        }
        if (this.mPendingUnRegister.get()) {
            return;
        }
        this.mChannelInfo = channelInfo;
        SsWsApp createParameterMap = WsChannelSdk2.createParameterMap(channelInfo);
        this.mWsApp = createParameterMap;
        this.mImpl.onParameterChange(this.mContext, createParameterMap);
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public boolean isConnected() {
        return this.mState == ConnectionState.CONNECTED;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public boolean isServiceConnected(int i) {
        Boolean bool = this.mServiceState.get(Integer.valueOf(i));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public boolean isPrivateProtocolEnabled() {
        return this.mPrivateProtocolEnabled;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void sendMsg(WsChannelMsg wsChannelMsg, MsgSendListener msgSendListener) {
        if (wsChannelMsg.getChannelId() != this.mChannelInfo.channelId) {
            throw new IllegalArgumentException("channelId isn't the same");
        }
        if (!this.mPendingUnRegister.get()) {
            this.mImpl.sendPayload(this.mContext, new MainProcessMsg(wsChannelMsg, msgSendListener));
        } else if (msgSendListener != null) {
            msgSendListener.onSendResult(wsChannelMsg, false);
        }
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public String sendMsgWithAck(WsChannelMsg wsChannelMsg, MsgSendListener msgSendListener) {
        if (wsChannelMsg.getChannelId() != this.mChannelInfo.channelId) {
            throw new IllegalArgumentException("channelId isn't the same");
        }
        if (this.mPendingUnRegister.get()) {
            if (msgSendListener == null) {
                return null;
            }
            msgSendListener.onSendResult(wsChannelMsg, false);
            return null;
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        wsChannelMsg.setUUID(replace);
        this.mImpl.sendPayload(this.mContext, new MainProcessMsg(wsChannelMsg, msgSendListener));
        return replace;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void registerService(int i) {
        this.mImpl.registerServiceId(this.mContext, this.mChannelInfo.channelId, i);
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void unregisterService(int i) {
        this.mImpl.unregisterServiceId(this.mContext, this.mChannelInfo.channelId, i);
        this.mServiceState.remove(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void register() {
        this.mImpl.registerApp(this.mContext, this.mWsApp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onReceive(WsChannelMsg wsChannelMsg) {
        if (this.mReceiver != null && !wsChannelMsg.isAckMsg()) {
            this.mReceiver.onReceiveMsg(wsChannelMsg);
        } else {
            if (this.mAckReceiver == null || !wsChannelMsg.isAckMsg()) {
                return;
            }
            MessageAckEvent messageAckEvent = new MessageAckEvent(wsChannelMsg.getUUID(), wsChannelMsg.getChannelId(), wsChannelMsg.getService(), wsChannelMsg.getMethod(), wsChannelMsg.getLogInfo());
            messageAckEvent.setState(wsChannelMsg.getState());
            this.mAckReceiver.onReceiveMsgAck(messageAckEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onReceiveConnectEvent(ConnectEvent connectEvent, JSONObject jSONObject) {
        OnMessageReceiveListener onMessageReceiveListener = this.mReceiver;
        if (onMessageReceiveListener != null) {
            onMessageReceiveListener.onReceiveConnectEvent(connectEvent, jSONObject);
        }
        if (connectEvent.connectionState == ConnectionState.CONNECT_CLOSED && this.mPendingUnRegister.get()) {
            WsChannelSdk2.unregister(getChannelId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onReceiveServiceConnectEvent(ServiceConnectEvent serviceConnectEvent) {
        OnServiceConnectListener onServiceConnectListener = this.mServiceListener;
        if (onServiceConnectListener != null) {
            onServiceConnectListener.onServiceConnectEvent(serviceConnectEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syncState(ConnectionState connectionState, boolean z) {
        this.mState = connectionState;
        this.mPrivateProtocolEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syncServiceState(ServiceConnectEvent serviceConnectEvent) {
        this.mServiceState.put(Integer.valueOf(serviceConnectEvent.getServiceId()), Boolean.valueOf(serviceConnectEvent.isServiceConnected()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replySendMsgResult(WsChannelMsg wsChannelMsg, boolean z) {
        if (wsChannelMsg instanceof MainProcessMsg) {
            MainProcessMsg mainProcessMsg = (MainProcessMsg) wsChannelMsg;
            WsChannelMsg origin = mainProcessMsg.getOrigin();
            MsgSendListener listener = mainProcessMsg.getListener();
            if (listener != null) {
                listener.onSendResult(origin, z);
            }
        }
    }
}
