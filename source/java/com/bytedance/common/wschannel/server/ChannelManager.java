package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.applog.throttle.CongestionController;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.channel.WsChannelClient;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.log.WsChannelLog;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.IEnableObserver;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ChannelManager implements WeakHandler.IHandler, IEnableObserver.OnWsChannelEnableChangedObserver {
    private final ChannelKeeper mChannelKeeper;
    private final IWsChannelSaver mChannelSaver;
    private final Context mContext;
    private final IMessageHandler mMessageHandler;
    private final WeakHandler mThreadHandler;
    private IEnableObserver mWsChannelEnableObserver;
    private final Object mLock = new Object();
    private AtomicLong mCounter = new AtomicLong(0);
    private boolean mIsForeground = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelManager(Context context, Looper looper, IWsChannelSaver iWsChannelSaver, ChannelKeeper channelKeeper, IMessageHandler iMessageHandler, final IEnableObserver iEnableObserver) {
        this.mContext = context.getApplicationContext();
        this.mThreadHandler = new WeakHandler(looper, this);
        this.mChannelSaver = iWsChannelSaver;
        this.mChannelKeeper = channelKeeper;
        this.mMessageHandler = iMessageHandler;
        this.mWsChannelEnableObserver = iEnableObserver;
        iEnableObserver.setEnableListener(this);
        runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.server.ChannelManager.1
            @Override // java.lang.Runnable
            public void run() {
                iEnableObserver.startLoad();
                ChannelManager channelManager = ChannelManager.this;
                channelManager.tryConnectIfEnable(channelManager.mChannelSaver.loadWsChannels());
            }
        });
    }

    private Map<String, Object> getConfigMap(IWsApp iWsApp) {
        HashMap hashMap = new HashMap();
        hashMap.put(WsConstants.KEY_APP_KEY, iWsApp.getAppKey());
        hashMap.put(WsConstants.KEY_FPID, Integer.valueOf(iWsApp.getFPID()));
        hashMap.put("sdk_version", 2);
        hashMap.put("platform", 0);
        hashMap.put("app_version", Integer.valueOf(iWsApp.getAppVersion()));
        hashMap.put("aid", Integer.valueOf(iWsApp.getAppId()));
        hashMap.put("device_id", iWsApp.getDeviceId());
        hashMap.put("iid", iWsApp.getInstallId());
        hashMap.put(WsConstants.KEY_HEADERS, iWsApp.getHeaders());
        String extra = iWsApp.getExtra();
        if (extra == null) {
            onNullParamLog("extra");
            extra = "";
        }
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable()) {
            String[] split = extra.split("&");
            String concat = "is_background=".concat(isForeground() ? "0" : "1");
            extra = (split.length <= 0 || TextUtils.isEmpty(split[0])) ? concat : extra + "&" + concat;
        }
        hashMap.put("extra", extra);
        if (iWsApp.getDeviceId() == null) {
            onNullParamLog("device_id");
        }
        if (iWsApp.getInstallId() == null) {
            onNullParamLog("install_id");
        }
        if (StringUtils.isEmpty(iWsApp.getAppKey())) {
            onNullParamLog(WsConstants.KEY_APP_KEY);
        }
        hashMap.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, Boolean.valueOf(iWsApp.newPrivateProtocolEnabled()));
        if (iWsApp.getServiceIdList() != null) {
            hashMap.put(WsConstants.KEY_SERVICE_ID_LIST, iWsApp.getServiceIdList());
        }
        if (!TextUtils.isEmpty(iWsApp.getPrivateProtocolUrl())) {
            hashMap.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, iWsApp.getPrivateProtocolUrl());
        }
        hashMap.put(WsConstants.KEY_TRANSPORT_MODE, Integer.valueOf(iWsApp.getTransportMode()));
        hashMap.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, Boolean.valueOf(iWsApp.disableFallbackWSEnabled()));
        return hashMap;
    }

    private boolean isForeground() {
        return this.mIsForeground;
    }

    private void onNullParamLog(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("param_name", str);
        WsChannelLog.onEventV3Bundle(this.mContext, "wschannel_param_null", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryConnectIfEnable(Map<Integer, IWsApp> map) {
        if ((!isEnableOfflineDetect() || NetworkUtils.isNetworkAvailable(this.mContext)) && this.mWsChannelEnableObserver.isEnable() && map != null) {
            for (IWsApp iWsApp : map.values()) {
                if (iWsApp != null) {
                    doRegisterChannel(iWsApp);
                }
            }
        }
    }

    private boolean isEnableOfflineDetect() {
        WsChannelSettings inst;
        Context context = this.mContext;
        if (context == null || (inst = WsChannelSettings.inst(context)) == null) {
            return false;
        }
        return inst.isEnableOfflineDetect();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
        final Message obtain = Message.obtain(message);
        runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.server.ChannelManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (obtain.what == 1 || ChannelManager.this.mWsChannelEnableObserver.isEnable()) {
                    ChannelManager.this.doHandleMsg(obtain);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doHandleMsg(Message message) {
        IWsChannelClient remove;
        boolean sendMessage;
        try {
            int i = message.what;
            if (i == 0) {
                message.getData().setClassLoader(SsWsApp.class.getClassLoader());
                Parcelable parcelable = message.getData().getParcelable(WsConstants.KEY_WS_APP);
                if (parcelable instanceof IWsApp) {
                    doRegisterChannel((IWsApp) parcelable);
                    return;
                }
                return;
            }
            boolean z = true;
            if (i == 1) {
                message.getData().setClassLoader(SsWsApp.class.getClassLoader());
                Parcelable parcelable2 = message.getData().getParcelable(WsConstants.KEY_WS_APP);
                if (parcelable2 instanceof IntegerParcelable) {
                    int data = ((IntegerParcelable) parcelable2).getData();
                    synchronized (WsChannelService.class) {
                        this.mChannelKeeper.mWsAppMap.remove(Integer.valueOf(data));
                        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);
                    }
                    synchronized (this.mLock) {
                        remove = this.mChannelKeeper.mWsChannelClientMap.remove(Integer.valueOf(data));
                    }
                    if (remove != null) {
                        if (Logger.debug()) {
                            Logger.m190d("WsChannelService", "stopConnection,channelId = " + data);
                        }
                        remove.destroy();
                    }
                    this.mChannelKeeper.mChannelState.remove(Integer.valueOf(data));
                    this.mThreadHandler.sendMessageDelayed(this.mThreadHandler.obtainMessage(8, remove), 1000L);
                    return;
                }
                return;
            }
            boolean z2 = false;
            if (i == 2) {
                int i2 = message.arg1;
                if (Logger.debug()) {
                    Logger.m190d("WsChannelService", "appState = " + i2);
                }
                if (i2 != 1) {
                    z = false;
                }
                this.mIsForeground = z;
                this.mMessageHandler.tryResendMsg();
                if (isEnable()) {
                    sendAppStateChangeEvent(this.mChannelKeeper.mWsChannelClientMap.values());
                    for (IWsChannelClient iWsChannelClient : this.mChannelKeeper.mWsChannelClientMap.values()) {
                        if (iWsChannelClient != null) {
                            iWsChannelClient.onAppStateChanged(i2);
                        }
                    }
                    return;
                }
                return;
            }
            if (i == 3) {
                int i3 = message.arg1;
                if (Logger.debug()) {
                    Logger.m190d("WsChannelService", "networkState = " + i3);
                }
                this.mMessageHandler.tryResendMsg();
                if (isEnable()) {
                    for (IWsChannelClient iWsChannelClient2 : this.mChannelKeeper.mWsChannelClientMap.values()) {
                        if (iWsChannelClient2 != null) {
                            iWsChannelClient2.onNetworkStateChanged(i3);
                        }
                    }
                    return;
                }
                return;
            }
            if (i == 4) {
                message.getData().setClassLoader(SsWsApp.class.getClassLoader());
                Parcelable parcelable3 = message.getData().getParcelable(WsConstants.KEY_WS_APP);
                if (parcelable3 instanceof IWsApp) {
                    doOnParamChange((IWsApp) parcelable3);
                    return;
                }
                return;
            }
            if (i != 5) {
                if (i == 9) {
                    this.mMessageHandler.syncSocketState();
                    return;
                }
                if (i != 10) {
                    if (i == 12) {
                        message.getData().setClassLoader(ServiceParcelable.class.getClassLoader());
                        Parcelable parcelable4 = message.getData().getParcelable(WsConstants.KEY_WS_APP);
                        if (parcelable4 instanceof ServiceParcelable) {
                            int channelId = ((ServiceParcelable) parcelable4).getChannelId();
                            int serviceId = ((ServiceParcelable) parcelable4).getServiceId();
                            IWsChannelClient iWsChannelClient3 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(channelId));
                            if (iWsChannelClient3 != null) {
                                if (Logger.debug()) {
                                    Logger.m190d("WsChannelService", "register serviceId = " + serviceId);
                                }
                                iWsChannelClient3.registerService(serviceId);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (i != 13) {
                        return;
                    }
                    message.getData().setClassLoader(ServiceParcelable.class.getClassLoader());
                    Parcelable parcelable5 = message.getData().getParcelable(WsConstants.KEY_WS_APP);
                    if (parcelable5 instanceof ServiceParcelable) {
                        int channelId2 = ((ServiceParcelable) parcelable5).getChannelId();
                        int serviceId2 = ((ServiceParcelable) parcelable5).getServiceId();
                        IWsChannelClient iWsChannelClient4 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(channelId2));
                        if (iWsChannelClient4 != null) {
                            if (Logger.debug()) {
                                Logger.m190d("WsChannelService", "unregister serviceId = " + serviceId2);
                            }
                            iWsChannelClient4.unregisterService(serviceId2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (i != 10) {
                z = false;
            }
            message.getData().setClassLoader(WsChannelMsg.class.getClassLoader());
            Parcelable parcelable6 = message.getData().getParcelable(WsConstants.KEY_PAYLOAD);
            if (parcelable6 instanceof WsChannelMsg) {
                WsChannelMsg wsChannelMsg = (WsChannelMsg) parcelable6;
                if (wsChannelMsg.getSeqId() <= 0) {
                    wsChannelMsg.setSeqId(this.mCounter.incrementAndGet());
                }
                IWsChannelClient iWsChannelClient5 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(wsChannelMsg.getChannelId()));
                if (z) {
                    Logger.m190d("WsChannelService", "retry send msg");
                }
                if (iWsChannelClient5 != null) {
                    if (i != 10 && (iWsChannelClient5 instanceof WsChannelClient) && ((WsChannelClient) iWsChannelClient5).isOkChannelImpl()) {
                        wsChannelMsg = tryAddOkWsPayloadOpaque(iWsChannelClient5, wsChannelMsg);
                    }
                    if (iWsChannelClient5.privateProtocolEnabled() && !iWsChannelClient5.privateProtocolProxyEnabled()) {
                        sendMessage = iWsChannelClient5.sendMessage(wsChannelMsg);
                    } else {
                        sendMessage = iWsChannelClient5.sendMessage(MsgConverterFactory.getConverter().encode(wsChannelMsg));
                    }
                    z2 = sendMessage;
                    long retryDelay = WsChannelSettings.inst(this.mContext).getRetryDelay();
                    if (!z2 && !z && retryDelay > 0) {
                        Message obtain = Message.obtain(message);
                        obtain.what = 10;
                        this.mThreadHandler.sendMessageDelayed(obtain, retryDelay);
                    }
                    if (z2 || retryDelay <= 0 || z) {
                        this.mMessageHandler.replySendMsgResult(wsChannelMsg, z2);
                    }
                } else {
                    this.mMessageHandler.replySendMsgResult(wsChannelMsg, false);
                }
                if (Logger.debug()) {
                    Logger.m190d("WsChannelService", "send payload success = " + z2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public WsChannelMsg tryAddOkWsPayloadOpaque(IWsChannelClient iWsChannelClient, WsChannelMsg wsChannelMsg) {
        WsChannelSettings.OkOpaqueCallback okOpaqueCallback = WsChannelSettings.getOkOpaqueCallback();
        if (okOpaqueCallback == null) {
            return wsChannelMsg;
        }
        try {
            for (Map.Entry<String, String> entry : okOpaqueCallback.onCallToWSPayloadOpaque(wsChannelMsg.toMap()).entrySet()) {
                wsChannelMsg.addHeader(entry.getKey(), entry.getValue());
            }
            return wsChannelMsg;
        } catch (Exception e) {
            Logger.m204w("tryAddOkWsPayloadOpaque failed with exception" + e);
            return wsChannelMsg;
        }
    }

    private void sendAppStateChangeEvent(Collection<IWsChannelClient> collection) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable()) {
            Iterator<IWsChannelClient> it = collection.iterator();
            while (it.hasNext()) {
                try {
                    sendAppStateChangeMessage(it.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    WsChannelMsg createStateChangedMsg() {
        return WsChannelMsg.Builder.create(CongestionController.MAX_REQUEST_FREQUENCY_REALTIME).setMethod(4).setService(WsConstants.APP_STATE_CHANGE_SERVICE).setLogId(1008601L).setPayload(new byte[0]).setPayloadEncoding("pb").setPayloadType("pb").addMsgHeader(WsConstants.APP_STATE_BACKGROUND_KEY, isForeground() ? "0" : "1").build();
    }

    private void doOnParamChange(IWsApp iWsApp) {
        if (Logger.debug()) {
            Logger.m190d("WsChannelService", "doOnParamChange");
        }
        int clientKey = WsChannelService.getClientKey(iWsApp);
        if (isEnable()) {
            try {
                IWsChannelClient iWsChannelClient = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(iWsApp.getChannelId()));
                synchronized (WsChannelService.class) {
                    IWsApp iWsApp2 = this.mChannelKeeper.mWsAppMap.get(Integer.valueOf(clientKey));
                    if (iWsChannelClient != null && (!iWsApp.equals(iWsApp2) || !iWsChannelClient.isConnected())) {
                        this.mChannelKeeper.mWsAppMap.put(Integer.valueOf(clientKey), iWsApp);
                        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);
                        Map<String, Object> configMap = getConfigMap(iWsApp);
                        if (configMap != null) {
                            iWsChannelClient.onParameterChange(configMap, iWsApp.getConnectUrls());
                            return;
                        }
                        throw new IllegalArgumentException("configMap is empty !!!");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void doRegisterChannel(IWsApp iWsApp) {
        boolean z;
        boolean z2;
        int clientKey = WsChannelService.getClientKey(iWsApp);
        if (isEnable()) {
            synchronized (WsChannelService.class) {
                IWsApp iWsApp2 = this.mChannelKeeper.mWsAppMap.get(Integer.valueOf(clientKey));
                IWsChannelClient iWsChannelClient = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(clientKey));
                z = false;
                z2 = true;
                if (iWsApp2 != null && iWsApp.equals(iWsApp2)) {
                    if (iWsChannelClient != null) {
                        z2 = false;
                    }
                    z2 = false;
                    z = true;
                } else if (iWsApp2 == null) {
                    this.mChannelKeeper.mWsAppMap.put(Integer.valueOf(clientKey), iWsApp);
                    this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);
                    z2 = false;
                    z = true;
                }
            }
            if (z) {
                tryOpenConnection(iWsApp);
            } else if (z2) {
                doOnParamChange(iWsApp);
            }
        }
    }

    private void tryOpenConnection(IWsApp iWsApp) {
        IWsChannelClient iWsChannelClient;
        if (Logger.debug()) {
            Logger.m190d("WsChannelService", "tryOpenConnection");
        }
        synchronized (this.mLock) {
            iWsChannelClient = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(iWsApp.getChannelId()));
            if (iWsChannelClient == null) {
                iWsChannelClient = WsChannelClient.newInstance(iWsApp.getChannelId(), this.mMessageHandler, this.mThreadHandler);
                iWsChannelClient.init(this.mContext, iWsChannelClient);
                this.mChannelKeeper.mWsChannelClientMap.put(Integer.valueOf(iWsApp.getChannelId()), iWsChannelClient);
            }
        }
        if (iWsChannelClient.isConnected()) {
            SocketState socketState = this.mChannelKeeper.mChannelState.get(Integer.valueOf(iWsApp.getChannelId()));
            Logger.m190d("WsChannelService", "state = " + socketState);
            if (socketState != null) {
                try {
                    this.mMessageHandler.onConnection(iWsChannelClient, socketState);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        try {
            if (Logger.debug()) {
                Logger.m190d("WsChannelService", "try to open connection ,channelId = " + iWsApp.getChannelId());
            }
            Map<String, Object> configMap = getConfigMap(iWsApp);
            if (configMap != null) {
                iWsChannelClient.openConnection(configMap, iWsApp.getConnectUrls());
                return;
            }
            throw new IllegalArgumentException("configMap is empty !!!");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean isEnable() {
        return this.mWsChannelEnableObserver.isEnable();
    }

    private void runOnHandlerThread(Runnable runnable) {
        this.mThreadHandler.post(runnable);
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver.OnWsChannelEnableChangedObserver
    public void onWsChannelEnableChange(boolean z) {
        if (z) {
            tryConnectIfEnable(this.mChannelSaver.loadWsChannels());
        } else {
            stopAllSocket();
        }
    }

    private void stopAllSocket() {
        try {
            synchronized (this.mLock) {
                Iterator<Map.Entry<Integer, IWsChannelClient>> it = this.mChannelKeeper.mWsChannelClientMap.entrySet().iterator();
                while (it.hasNext()) {
                    IWsChannelClient value = it.next().getValue();
                    if (value != null) {
                        value.destroy();
                    }
                }
                this.mChannelKeeper.mWsChannelClientMap.clear();
            }
            this.mChannelKeeper.mWsAppMap.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syncCurrentState(final IWsChannelClient iWsChannelClient) {
        if (iWsChannelClient.isConnected()) {
            this.mThreadHandler.post(new Runnable() { // from class: com.bytedance.common.wschannel.server.ChannelManager.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelManager.this.sendAppStateChangeMessage(iWsChannelClient);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAppStateChangeMessage(IWsChannelClient iWsChannelClient) {
        if (iWsChannelClient == null) {
            return;
        }
        WsChannelMsg createStateChangedMsg = createStateChangedMsg();
        if (iWsChannelClient.privateProtocolEnabled()) {
            iWsChannelClient.sendMessage(createStateChangedMsg);
        } else {
            iWsChannelClient.sendMessage(MsgConverterFactory.getConverter().encode(createStateChangedMsg));
        }
    }
}
