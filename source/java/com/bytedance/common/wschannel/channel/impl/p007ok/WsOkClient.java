package com.bytedance.common.wschannel.channel.impl.p007ok;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.impl.p007ok.WsStatus;
import com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryPolicy;
import com.bytedance.common.wschannel.channel.impl.p007ok.ws.CustomHeartBeatRealWebSocket;
import com.bytedance.common.wschannel.channel.impl.p007ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketListener;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.CompensateHeartBeatManager;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatPolicy;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.server.NetworkUtils;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.squareup.wire.Wire;
import java.io.Closeable;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsOkClient implements WeakHandler.IHandler {
    private static final int MSG_APP_STATE_CHANGED = 5;
    private static final int MSG_CONNECT = 2;
    private static final int MSG_DESTROY = 4;
    private static final int MSG_NETWORK_CHANGED = 3;
    private static final int MSG_PARAMETER_CHANGED = 7;
    private static final int MSG_RECONNECT = 1;
    private static final int MSG_RELEASE_PENDGING_SOCKET = 6;
    private boolean isManualClose;
    private CompensateHeartBeatManager mCompensateHeartBeatManager;
    private final Config mConfig;
    private Map<String, Object> mConfigMap;
    private final Context mContext;
    private CustomHeartBeatRealWebSocket mCurrentSocket;
    private int mCurrentStatus;
    private Handler mHandler;
    private BaseHeartBeatPolicy mHeartBeatPolicy;
    private WebSocketListener mListener;
    private OkHttpClient mOkHttpClient;
    private boolean mPendingConnectAfterClosed;
    private WsPolicy mPolicy;
    private Request mRequest;
    private WsStatusListener mWsStatusListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface WsStatusListener {
        void onClosed(String str, int i, String str2);

        void onConnecting(String str);

        void onFailure(String str, int i, String str2);

        void onMessage(String str);

        void onMessage(ByteString byteString);

        void onOpen(Response response);
    }

    private static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorReason(int i) {
        return i == 0 ? "success" : i == 404 ? "uri not found" : i == 409 ? "fpid not registered" : i == 410 ? "invalid device id" : i == 411 ? "appid not registered" : i == 412 ? "websocket protocol not support" : i == 413 ? "the device already connected" : i == 414 ? "server can't accept more connection,try again later" : i == 415 ? "device was blocked" : i == 416 ? "parameter error" : i == 417 ? "authentication failed" : i == 510 ? "server internal error" : i == 511 ? "server is busy，try again later" : i == 512 ? "server is shutting down" : i == 513 ? "auth server is error" : i == 514 ? "auth return error" : "";
    }

    private WsOkClient(Config config) {
        this.mCurrentStatus = 3;
        this.mConfigMap = new ConcurrentHashMap();
        this.mHandler = new WeakHandler(Looper.myLooper(), this);
        this.mListener = new WsListener();
        this.mConfig = config;
        this.mContext = config.mContext;
        this.mOkHttpClient = config.mOkHttpClient;
        BaseHeartBeatPolicy baseHeartBeatPolicy = config.mHeartBeatPolicy;
        this.mHeartBeatPolicy = baseHeartBeatPolicy;
        if (baseHeartBeatPolicy == null) {
            this.mHeartBeatPolicy = new NormalHeartBeatPolicy(new NormalHeartBeatMeta().provideDefaultMeta());
        }
        this.mHeartBeatPolicy.init(new HeartBeatReactListener() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.1
            @Override // com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener
            public void onHeartBeatTimeout() {
                WsOkClient.this.reactOnHeartBeatTimeout();
            }

            @Override // com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener
            public void onSendPing() {
                WsOkClient.this.reactOnSendPing();
            }
        }, this.mHandler);
        this.mCompensateHeartBeatManager = new CompensateHeartBeatManager(new CompensateHeartBeatManager.OnHeartBeatTimeoutListener() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.2
            @Override // com.bytedance.common.wschannel.heartbeat.CompensateHeartBeatManager.OnHeartBeatTimeoutListener
            public void onTimeout() {
                WsOkClient.this.reactOnHeartBeatTimeout();
            }
        }, this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryConnect(String str) {
        if (!isNetworkConnected(this.mContext)) {
            notifyFailedAndReset(str, 1, "network error", true);
            return;
        }
        int currentStatus = getCurrentStatus();
        if (currentStatus == 4 || currentStatus == 1) {
            return;
        }
        try {
            initAndConnect(str);
        } catch (Throwable th) {
            th.printStackTrace();
            if (this.mWsStatusListener != null) {
                this.mWsStatusListener.onFailure(str, 4, Log.getStackTraceString(th));
            }
            if (WsConstants.TTNET_TRAFFIC_CONTROL_DROP.equals(th.getMessage())) {
                String nextUrl = this.mPolicy.getNextUrl();
                if (!TextUtils.isEmpty(nextUrl)) {
                    Logger.m190d(OkChannelImpl.TAG, th.getMessage() + ":" + str + ", try next url:" + nextUrl);
                    tryReconnect(0L, nextUrl, true);
                } else {
                    Logger.m190d(OkChannelImpl.TAG, "All urls are dropped, stop retry.");
                    this.mPolicy.reset();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReconnect(long j, String str, boolean z) {
        this.mHandler.removeMessages(1);
        if (!isNetworkConnected(this.mContext)) {
            notifyFailedAndReset(str, 1, "network error", z);
            Logger.m190d(OkChannelImpl.TAG, "network not available，cancel retry");
            return;
        }
        if (this.isManualClose) {
            Logger.m190d(OkChannelImpl.TAG, "close manually");
            return;
        }
        if (j == -1 || StringUtils.isEmpty(str)) {
            Logger.m190d(OkChannelImpl.TAG, "retry finished ---> interval: " + j + " , url :" + str);
            Logger.m190d(OkChannelImpl.TAG, "retry finished，waiting the next time to reconnect");
            Bundle bundle = new Bundle();
            bundle.putString("method", "tryReconnect");
            bundle.putLong("interval", j);
            notifyFailedAndReset(str, 2, "retry failed", z);
            str = this.mPolicy.getUrl();
        } else {
            setStatus(5);
        }
        Logger.m190d(OkChannelImpl.TAG, "the next time to reconnect is " + Utils.getTimeFormat(System.currentTimeMillis() + j));
        Message message = new Message();
        message.what = 1;
        message.obj = str;
        this.mHandler.sendMessageDelayed(message, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopConnect() {
        runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.3
            @Override // java.lang.Runnable
            public void run() {
                WsOkClient.this.isManualClose = true;
                WsOkClient.this.stopConnectInternal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopConnectInternal() {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(5);
        cancelReconnect();
        disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelReconnect() {
        resetPolicy();
        this.mHandler.removeMessages(1);
    }

    private boolean disconnect() {
        int currentStatus = getCurrentStatus();
        if (currentStatus == 3 || currentStatus == 2 || currentStatus == 5) {
            return true;
        }
        this.mHeartBeatPolicy.onDisconnected();
        CustomHeartBeatRealWebSocket customHeartBeatRealWebSocket = this.mCurrentSocket;
        if (customHeartBeatRealWebSocket == null) {
            return true;
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(6, customHeartBeatRealWebSocket), 1000L);
        if (currentStatus == 4) {
            this.mCurrentSocket.close(1000, WsStatus.TIP.NORMAL_CLOSE);
            setStatus(6);
            return false;
        }
        this.mCurrentSocket.cancel();
        setStatus(3);
        return currentStatus != 1;
    }

    private void initAndConnect(String str) throws Exception {
        if (this.mOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
            this.mOkHttpClient = enableTls12OnPreLollipop(builder).build();
        }
        Map<String, Object> map = this.mConfigMap;
        String createUrl = createUrl(str, map);
        Map map2 = map != null ? (Map) map.get(WsConstants.KEY_HEADERS) : null;
        if (StringUtils.isEmpty(createUrl)) {
            Logger.m193e(OkChannelImpl.TAG, "url is empty,cancel connect");
            return;
        }
        ensureWebSocketClosed();
        Logger.m190d(OkChannelImpl.TAG, "try tu open socket:" + createUrl);
        Request request = this.mRequest;
        if (request == null || !createUrl.equals(request.url().toString())) {
            Request.Builder url = new Request.Builder().addHeader("Sec-Websocket-Protocol", "pbbp").addHeader("x-support-ack", "1").url(createUrl);
            if (map2 != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    url.addHeader((String) entry.getKey(), (String) entry.getValue());
                }
            }
            this.mRequest = url.build();
        }
        setStatus(1);
        CustomHeartBeatRealWebSocket create = CustomHeartBeatRealWebSocket.create(this.mRequest, WsChannelSettings.inst(this.mContext).getSocketReadLimitSize(), this.mListener);
        this.mCurrentSocket = create;
        create.connect(this.mOkHttpClient);
        this.mCompensateHeartBeatManager.setWebSocket(this.mCurrentSocket);
        WsStatusListener wsStatusListener = this.mWsStatusListener;
        if (wsStatusListener != null) {
            wsStatusListener.onConnecting(createUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPolicy() {
        WsPolicy wsPolicy = this.mPolicy;
        if (wsPolicy != null) {
            wsPolicy.reset();
        }
    }

    private String doUrlDispatch(String str) throws Exception {
        if (!URLDispatcher.inst().isDispatchActionsEmpty()) {
            DispatchResult dispatchResultForUrl = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(str, "GET"));
            if (dispatchResultForUrl != null && !str.equals(dispatchResultForUrl.mDispatchedURL)) {
                if (dispatchResultForUrl.mDispatchedURL.isEmpty() && !dispatchResultForUrl.mActionRuleIdList.isEmpty()) {
                    throw new Exception(WsConstants.TTNET_TRAFFIC_CONTROL_DROP);
                }
                if (UrlUtils.isValidUrl(dispatchResultForUrl.mDispatchedURL)) {
                    return dispatchResultForUrl.mDispatchedURL;
                }
            }
        } else {
            Logger.m190d(OkChannelImpl.TAG, "fallback to host replace map");
            String handleHostMapping = URLDispatcher.inst().handleHostMapping(str);
            if (!str.equals(handleHostMapping) && UrlUtils.isValidUrl(handleHostMapping)) {
                return handleHostMapping;
            }
        }
        return str;
    }

    private String createUrl(String str, Map<String, Object> map) throws Exception {
        if (TextUtils.isEmpty(str) || map == null) {
            return "";
        }
        String lowerCase = Utils.md5(String.valueOf(map.get(WsConstants.KEY_FPID)) + String.valueOf(map.get(WsConstants.KEY_APP_KEY)) + String.valueOf(map.get("device_id")) + WsConstants.SALT).toLowerCase();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.equals(entry.getKey(), WsConstants.KEY_HEADERS)) {
                String obj = entry.getValue() == null ? "" : entry.getValue().toString();
                String key = entry.getKey();
                if (!StringUtils.equal(WsConstants.KEY_APP_KEY, key) && !StringUtils.equal(key, "extra")) {
                    if (StringUtils.equal("app_version", key)) {
                        buildUpon.appendQueryParameter("version_code", obj);
                    } else {
                        buildUpon.appendQueryParameter(key, obj);
                    }
                }
            }
        }
        String str2 = (String) map.get("extra");
        if (!StringUtils.isEmpty(str2)) {
            for (String str3 : str2.split("&")) {
                if (!TextUtils.isEmpty(str3)) {
                    String[] split = str3.split("=");
                    if (split.length == 2) {
                        buildUpon.appendQueryParameter(split[0], Uri.decode(split[1]));
                    }
                }
            }
        }
        buildUpon.appendQueryParameter("access_key", lowerCase);
        buildUpon.appendQueryParameter("ne", String.valueOf(networkType()));
        String uri = buildUpon.build().toString();
        Logger.m190d(OkChannelImpl.TAG, "origin url: " + uri);
        try {
            String doUrlDispatch = doUrlDispatch(uri);
            Logger.m190d(OkChannelImpl.TAG, "Dispatch final url: " + doUrlDispatch);
            return doUrlDispatch;
        } catch (Exception e) {
            throw e;
        }
    }

    private int networkType() {
        NetworkUtils.NetworkType networkType = NetworkUtils.getNetworkType(this.mContext);
        if (networkType == null || networkType == NetworkUtils.NetworkType.NONE) {
            return 0;
        }
        if (networkType == NetworkUtils.NetworkType.WIFI) {
            return 1;
        }
        if (networkType == NetworkUtils.NetworkType.MOBILE_2G) {
            return 2;
        }
        return networkType == NetworkUtils.NetworkType.MOBILE_3G ? 3 : 4;
    }

    synchronized int getCurrentStatus() {
        return this.mCurrentStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isConnected() {
        return getCurrentStatus() == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setStatus(int i) {
        this.mCurrentStatus = i;
        String str = "";
        if (i == 1) {
            str = "connecting";
        } else if (i == 2) {
            str = "connect failed";
        } else if (i == 3) {
            str = "connection close ";
        } else if (i == 4) {
            str = "connected";
        } else if (i == 5) {
            str = "retry...";
        } else if (i == 6) {
            str = "half-close status";
        }
        Logger.m190d(OkChannelImpl.TAG, "current status is :".concat(str));
    }

    void setConfigMap(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        map.remove(WsConstants.KEY_CHANNEL_ID);
        this.mConfigMap.putAll(map);
    }

    private boolean isNetworkConnected(Context context) {
        return NetworkUtils.isNetworkAvailable(context);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
        AppState appState;
        if (message == null) {
            return;
        }
        int i = message.what;
        if (i == 1) {
            if (isConnected()) {
                return;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            tryConnect((String) message.obj);
            return;
        }
        if (i == 2) {
            try {
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(1);
                this.mConfig.wsUrls = (List) message.obj;
                this.isManualClose = false;
                this.mPolicy = new WsPolicy(this.mConfig.wsUrls, this.mConfig.mRetryPolicy);
                cancelReconnect();
                tryConnect(this.mPolicy.getUrl());
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (i == 3) {
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(1);
            if (isConnected()) {
                return;
            }
            cancelReconnect();
            if (isNetworkConnected(this.mContext)) {
                if (disconnect()) {
                    WsPolicy wsPolicy = this.mPolicy;
                    if (wsPolicy == null) {
                        return;
                    }
                    tryConnect(wsPolicy.getUrl());
                    return;
                }
                this.mPendingConnectAfterClosed = true;
                return;
            }
            Logger.m190d(OkChannelImpl.TAG, "network changed! but the network is not available，do not retry");
            return;
        }
        if (i == 5) {
            if (((Boolean) message.obj).booleanValue()) {
                appState = AppState.STATE_FOREGROUND;
            } else {
                appState = AppState.STATE_BACKGROUND;
            }
            this.mCompensateHeartBeatManager.updateCurrentAppState(appState);
            this.mHeartBeatPolicy.onAppStateUpdate(appState);
            return;
        }
        if (i == 7) {
            try {
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(1);
                this.mConfig.wsUrls = (List) message.obj;
                this.isManualClose = false;
                this.mPolicy = new WsPolicy(this.mConfig.wsUrls, this.mConfig.mRetryPolicy);
                cancelReconnect();
                if (disconnect()) {
                    tryConnect(this.mPolicy.getUrl());
                } else {
                    this.mPendingConnectAfterClosed = true;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void ensureWebSocketClosed() {
        CustomHeartBeatRealWebSocket customHeartBeatRealWebSocket = this.mCurrentSocket;
        if (customHeartBeatRealWebSocket != null) {
            customHeartBeatRealWebSocket.closeQuietly(1000, WsStatus.TIP.NORMAL_CLOSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void connect(final Map<String, Object> map, final List<String> list) {
        if (list.isEmpty()) {
            Logger.m193e(OkChannelImpl.TAG, "error : no target ws url ,return");
        } else {
            runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.4
                @Override // java.lang.Runnable
                public void run() {
                    int currentStatus = WsOkClient.this.getCurrentStatus();
                    if (currentStatus == 4 || currentStatus == 1 || currentStatus == 5) {
                        Log.d(OkChannelImpl.TAG, "cancel connect :,current state = " + currentStatus);
                        return;
                    }
                    WsOkClient.this.setConfigMap(map);
                    WsOkClient wsOkClient = WsOkClient.this;
                    wsOkClient.handleMsg(wsOkClient.mHandler.obtainMessage(2, list));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNetworkStateChanged(int i) {
        this.mHandler.obtainMessage(3, Integer.valueOf(i)).sendToTarget();
    }

    public boolean sendMessage(String str) {
        return send(str);
    }

    private boolean sendMessage(ByteString byteString) {
        return send(byteString);
    }

    private boolean send(Object obj) {
        Logger.m190d(OkChannelImpl.TAG, "send msg : " + obj);
        if (this.mCurrentSocket != null && isConnected()) {
            if (obj instanceof String) {
                return this.mCurrentSocket.send((String) obj);
            }
            if (obj instanceof ByteString) {
                return this.mCurrentSocket.send((ByteString) obj);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sendMessage(byte[] bArr) {
        return sendMessage(ByteString.of(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWsStatusListener(WsStatusListener wsStatusListener) {
        this.mWsStatusListener = wsStatusListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String safeGetUrl(WebSocket webSocket) {
        Request request;
        HttpUrl url;
        return (webSocket == null || (request = webSocket.request()) == null || (url = request.url()) == null) ? "" : url.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(5);
        runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.5
            @Override // java.lang.Runnable
            public void run() {
                WsOkClient.this.stopConnect();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAppStateChanged(boolean z) {
        this.mHandler.obtainMessage(5, Boolean.valueOf(z)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getErrorCode(Response response) {
        if (response == null) {
            return -1;
        }
        try {
            return Integer.parseInt(response.header("Handshake-Status"));
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private void notifyFailedAndReset(String str, int i, String str2, boolean z) {
        setStatus(2);
        resetPolicy();
        WsStatusListener wsStatusListener = this.mWsStatusListener;
        if (wsStatusListener == null || !z) {
            return;
        }
        wsStatusListener.onFailure(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reactOnHeartBeatTimeout() {
        WsStatusListener wsStatusListener;
        Request request = this.mRequest;
        if (request != null && (wsStatusListener = this.mWsStatusListener) != null) {
            wsStatusListener.onFailure(request.url().toString(), 3, "heatbeat timeout");
        }
        Pair<String, Long> retryUrlAndInterval = this.mPolicy.getRetryUrlAndInterval(null);
        stopConnectInternal();
        ensureWebSocketClosed();
        tryReconnect(0L, (String) retryUrlAndInterval.first, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reactOnSendPing() {
        this.mHandler.post(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WsOkClient.this.mCurrentSocket != null) {
                        Logger.m190d(OkChannelImpl.TAG, "send ping");
                        WsOkClient.this.mCurrentSocket.sendPing();
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onParameterChange(final Map<String, Object> map, final List<String> list) {
        if (list.isEmpty()) {
            Logger.m193e(OkChannelImpl.TAG, "error : no target ws url ,return");
        } else {
            runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.7
                @Override // java.lang.Runnable
                public void run() {
                    WsOkClient.this.setConfigMap(map);
                    WsOkClient wsOkClient = WsOkClient.this;
                    wsOkClient.handleMsg(wsOkClient.mHandler.obtainMessage(7, list));
                }
            });
        }
    }

    private static OkHttpClient.Builder enableTls12WithTwoParamsMethod(OkHttpClient.Builder builder, SSLContext sSLContext) throws Exception {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                builder.sslSocketFactory(new Tls12SocketFactory(sSLContext.getSocketFactory()), (X509TrustManager) trustManager);
                return builder;
            }
        }
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Config {
        private Context mContext;
        private BaseHeartBeatPolicy mHeartBeatPolicy;
        private OkHttpClient mOkHttpClient;
        private RetryPolicy mRetryPolicy;
        private List<String> wsUrls;

        public String toString() {
            return "Config{mHeartBeatPolicy=" + this.mHeartBeatPolicy + ", mContext=" + this.mContext + ", wsUrls=" + this.wsUrls + ", mOkHttpClient=" + this.mOkHttpClient + ", mRetryPolicy=" + this.mRetryPolicy + '}';
        }

        Config(Context context, List<String> list, OkHttpClient okHttpClient, RetryPolicy retryPolicy, BaseHeartBeatPolicy baseHeartBeatPolicy) {
            this.mContext = context;
            this.wsUrls = list;
            this.mOkHttpClient = okHttpClient;
            this.mRetryPolicy = retryPolicy;
            this.mHeartBeatPolicy = baseHeartBeatPolicy;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Builder {
        private Context mContext;
        private BaseHeartBeatPolicy mHeartBeatPolicy;
        private OkHttpClient mOkHttpClient;
        private RetryPolicy mRetryPolicy;
        private List<String> wsUrls;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder retryPolicy(RetryPolicy retryPolicy) {
            this.mRetryPolicy = retryPolicy;
            return this;
        }

        public Builder setUrls(List<String> list) {
            this.wsUrls = list;
            return this;
        }

        public Builder client(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder heartBeatPolicy(BaseHeartBeatPolicy baseHeartBeatPolicy) {
            if (baseHeartBeatPolicy != null) {
                this.mHeartBeatPolicy = baseHeartBeatPolicy;
            }
            return this;
        }

        public WsOkClient build() {
            return new WsOkClient(new Config(this.mContext, this.wsUrls, this.mOkHttpClient, this.mRetryPolicy, this.mHeartBeatPolicy));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private class WsListener extends WebSocketListener {
        /* JADX INFO: Access modifiers changed from: private */
        public boolean canRetry(int i) {
            return i <= 0 || i == 414 || i == 511 || i == 512 || i == 513;
        }

        private WsListener() {
        }

        @Override // com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketListener
        public void onOpen(final CustomHeartBeatWebSocket customHeartBeatWebSocket, final Response response) {
            WsOkClient.this.runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsListener.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m190d(OkChannelImpl.TAG, "----------onOpen--------");
                    if (WsOkClient.this.mCurrentSocket == customHeartBeatWebSocket) {
                        WsOkClient.this.setStatus(4);
                        WsOkClient.this.cancelReconnect();
                        WsOkClient.this.mHeartBeatPolicy.onConnected(response);
                        if (WsOkClient.this.mWsStatusListener != null) {
                            WsOkClient.this.mWsStatusListener.onOpen(response);
                        }
                    }
                }
            });
        }

        @Override // com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketListener
        public void onMessage(CustomHeartBeatWebSocket customHeartBeatWebSocket, final ByteString byteString) {
            WsOkClient.this.runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsListener.2
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m190d(OkChannelImpl.TAG, "----------onMessage--------");
                    try {
                        WsOkClient.this.sendMessageAckIfNeeded(byteString.toByteArray());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (WsOkClient.this.mWsStatusListener != null) {
                        WsOkClient.this.mWsStatusListener.onMessage(byteString);
                    }
                }
            });
        }

        @Override // com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketListener
        public void onMessage(CustomHeartBeatWebSocket customHeartBeatWebSocket, final String str) {
            WsOkClient.this.runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsListener.3
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m190d(OkChannelImpl.TAG, "----------onMessage--------");
                    if (WsOkClient.this.mWsStatusListener != null) {
                        WsOkClient.this.mWsStatusListener.onMessage(str);
                    }
                }
            });
        }

        @Override // com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketListener
        public void onClosing(CustomHeartBeatWebSocket customHeartBeatWebSocket, int i, String str) {
            super.onClosing(customHeartBeatWebSocket, i, str);
            WsOkClient.this.runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsListener.4
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m190d(OkChannelImpl.TAG, "----------onClosing--------");
                    WsOkClient.this.setStatus(6);
                }
            });
        }

        @Override // com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketListener
        public void onClosed(final CustomHeartBeatWebSocket customHeartBeatWebSocket, final int i, final String str) {
            final String safeGetUrl = WsOkClient.this.safeGetUrl(customHeartBeatWebSocket);
            WsOkClient.this.runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsListener.5
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m190d(OkChannelImpl.TAG, "----------onClosed--------");
                    if (WsOkClient.this.mCurrentSocket == customHeartBeatWebSocket) {
                        WsOkClient.this.setStatus(3);
                        WsOkClient.this.mCurrentSocket = null;
                        WsOkClient.this.mHeartBeatPolicy.onDisconnected();
                        if (WsOkClient.this.mWsStatusListener != null) {
                            WsOkClient.this.mWsStatusListener.onClosed(safeGetUrl, i, str);
                        }
                        if (WsOkClient.this.mPendingConnectAfterClosed) {
                            WsOkClient.this.mPendingConnectAfterClosed = false;
                            WsOkClient.this.tryConnect(WsOkClient.this.mPolicy.getUrl());
                        } else {
                            if (WsOkClient.this.isManualClose) {
                                return;
                            }
                            Pair<String, Long> retryUrlAndInterval = WsOkClient.this.mPolicy.getRetryUrlAndInterval(null);
                            WsOkClient.this.tryReconnect(((Long) retryUrlAndInterval.second).longValue(), (String) retryUrlAndInterval.first, true);
                        }
                    }
                }
            });
        }

        @Override // com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketListener
        public void onFailure(final CustomHeartBeatWebSocket customHeartBeatWebSocket, Throwable th, Response response) {
            final String str;
            final String safeGetUrl = WsOkClient.this.safeGetUrl(customHeartBeatWebSocket);
            final int errorCode = WsOkClient.this.getErrorCode(response);
            String errorReason = WsOkClient.this.getErrorReason(errorCode);
            if (StringUtils.isEmpty(errorReason)) {
                str = StringUtils.isEmpty(th.getMessage()) ? Log.getStackTraceString(th) : th.getMessage();
            } else {
                str = errorReason;
            }
            final Pair<String, Long> retryUrlAndInterval = WsOkClient.this.mPolicy.getRetryUrlAndInterval(response);
            WsOkClient.this.safeClose(response);
            WsOkClient.this.runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsListener.6
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m190d(OkChannelImpl.TAG, "----------onFailure--------");
                    if (WsOkClient.this.mWsStatusListener != null) {
                        WsOkClient.this.mWsStatusListener.onFailure(safeGetUrl, errorCode, str);
                    }
                    if (WsOkClient.this.mPendingConnectAfterClosed) {
                        WsOkClient.this.mPendingConnectAfterClosed = false;
                        WsOkClient.this.tryConnect(WsOkClient.this.mPolicy.getUrl());
                    } else {
                        if (WsOkClient.this.mCurrentSocket == customHeartBeatWebSocket) {
                            if (WsListener.this.canRetry(errorCode)) {
                                WsOkClient.this.mHeartBeatPolicy.onDisconnected();
                                WsOkClient.this.tryReconnect(((Long) retryUrlAndInterval.second).longValue(), (String) retryUrlAndInterval.first, false);
                                return;
                            } else {
                                WsOkClient.this.setStatus(2);
                                WsOkClient.this.resetPolicy();
                                return;
                            }
                        }
                        Logger.m190d(OkChannelImpl.TAG, "socket is expired");
                    }
                }
            });
        }

        @Override // com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketListener
        public void onPong(final CustomHeartBeatWebSocket customHeartBeatWebSocket, ByteString byteString) {
            WsOkClient.this.runOnHandlerThread(new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsListener.7
                @Override // java.lang.Runnable
                public void run() {
                    if (customHeartBeatWebSocket != WsOkClient.this.mCurrentSocket) {
                        return;
                    }
                    if (WsOkClient.this.mCompensateHeartBeatManager.isWaitingPong()) {
                        WsOkClient.this.mCompensateHeartBeatManager.onReceivePong();
                    } else {
                        WsOkClient.this.mHeartBeatPolicy.onReceivePong();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnHandlerThread(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageAckIfNeeded(byte[] bArr) throws IOException {
        Logger.m190d(OkChannelImpl.TAG, "enter sendMessageAckIfNeeded");
        Frame frame = (Frame) Frame.ADAPTER.decode(bArr);
        List<Frame.ExtendedEntry> list = (List) Wire.get(frame.headers, Collections.emptyList());
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        String str = null;
        for (Frame.ExtendedEntry extendedEntry : list) {
            if (!extendedEntry.key.equals(WsConstants.KEY_NEED_ACK) || !extendedEntry.value.equals("1")) {
                if (extendedEntry.key.equals(WsConstants.KEY_FRONTIER_MSGID) && !TextUtils.isEmpty(extendedEntry.value)) {
                    str = extendedEntry.value;
                }
                if (z && !TextUtils.isEmpty(str)) {
                    break;
                }
            } else {
                z = true;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_IS_ACK).value("1").m446build());
            arrayList.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_ACK_ID).value((String) Wire.get(frame.logidnew, "")).m446build());
            arrayList.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_ACK_CODE).value("0").m446build());
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_FRONTIER_MSGID).value(str).m446build());
            }
            sendMessage(Frame.ADAPTER.encode(new Frame.Builder().seqid((Long) Wire.get(frame.seqid, Frame.DEFAULT_SEQID)).logid((Long) Wire.get(frame.logid, Frame.DEFAULT_LOGID)).service((Integer) Wire.get(frame.service, Frame.DEFAULT_SERVICE)).method((Integer) Wire.get(frame.method, Frame.DEFAULT_METHOD)).logidnew((String) Wire.get(frame.logidnew, "")).headers(arrayList).m444build()));
        }
    }
}
