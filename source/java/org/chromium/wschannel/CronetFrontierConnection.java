package org.chromium.wschannel;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.util.AsyncIOTaskManager;
import com.bytedance.frameworks.baselib.network.http.util.AsyncTask;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.webx.addr.AddressParam;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.ttnet.org.chromium.net.impl.TTServiceInfo;
import java.net.CookieHandler;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CronetFrontierConnection {
    private static final String CLIENT_KEY_MANAGER_CLASS = "com.bytedance.ttnet.clientkey.ClientKeyManager";
    private static final String FALLBACK_TIMEOUT_MILLS = "fallback_timeout_mills";
    private static final int FALL_BACK_SECONDS = 10;
    private static final int FALL_BACK_WEBSOCKET = 1;
    private static final String LOG_TYPE = "private_protocol";
    private static final int MAX_RETRY_COUNT = 3;
    private static final String METHOD_ID_HEADER = "method_id";
    private static final String MSG_ID_HEADER = "msg_id";
    private static final String MSG_SERVER_TIMING_HEADER = "server_timing";
    private static final String PAYLOAD_ENCODING_HEADER = "payload_encoding";
    private static final String PAYLOAD_TYPE_HEADER = "payload_type";
    private static final String PING_INTERVAL_HEADER = "ttnet_heartbeat_interval";
    private static final int PRIVATE_PROTOCOL_PROXY_DEFAULT_SERVICE_ID = 1;
    private static final int SHARED_STREAM_SERVICE_ID = 9000;
    private static final String TAG = "CronetFrontierConnection";
    private static final String TIME_OUT_HEADER = "ttnet_timeout_millis";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine sCronetEngine = null;
    private static volatile String sPrivateProtocolUrl = "";
    private WebSocketCallbackImpl mCallback;
    private DestroyTimeoutControl mDestroyTimeoutControl;
    private CronetFrontierClient mFrontierClient;
    private TTWebsocketConnection mWebsocketConnection;
    private IWsChannelClient mWsChannelClient;
    private static final String FALLBACK_WEBSOCKET_TASK_ID = UUID.randomUUID().toString();
    private static boolean sDisableFallbackTask = false;
    public static CronetFrontierClient.TransportMode sMode = CronetFrontierClient.TransportMode.QUIC;
    private static volatile AtomicInteger sFirstConnection = new AtomicInteger(0);
    private static volatile int sChannelID = -1;
    private final AtomicBoolean mUsePrivateProtocol = new AtomicBoolean(false);
    private final AtomicBoolean mUsePrivateProtocolProxy = new AtomicBoolean(false);
    private final AtomicInteger mRetryAttempts = new AtomicInteger(0);
    private int mPingInterval = 10000;
    private int mTimeOut = 10000;
    private Map<Integer, Boolean> mAllServiceBuildInfo = new ConcurrentHashMap();
    private AtomicBoolean mIsFallbackTaskRunning = new AtomicBoolean(false);
    private volatile int mAppState = -1;
    private volatile boolean mIsFirstStreamReady = false;
    private boolean mSharedConnection = true;

    public void registerService(int i) {
    }

    public void unregisterService(int i) {
    }

    public CronetFrontierConnection(IWsChannelClient iWsChannelClient) {
        this.mWsChannelClient = iWsChannelClient;
        this.mCallback = new WebSocketCallbackImpl(this.mWsChannelClient);
        try {
            loadCronetKernel();
        } catch (Throwable th) {
            th.printStackTrace();
            if (Logger.debug()) {
                Logger.d(TAG, "TTNet init failed, cronet engine is null.");
            }
        }
        sCronetEngine = CronetClient.getCronetEngine();
    }

    private static void loadCronetKernel() throws Exception {
        Object newInstance = Class.forName(TTNET_INIT_CLASS).newInstance();
        Reflect.on(newInstance).call("getInitCompletedLatch");
        Reflect.on(newInstance).call("preInitCronetKernel");
    }

    private Map<String, String> getClientKeyHeaders() {
        try {
            return (Map) Class.forName(CLIENT_KEY_MANAGER_CLASS).getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConnectionWithWebSocket(Map<String, Object> map, List<String> list) {
        this.mUsePrivateProtocol.set(false);
        this.mUsePrivateProtocolProxy.set(false);
        if (sFirstConnection.incrementAndGet() > 1) {
            this.mSharedConnection = false;
        }
        Object obj = map.get("channel_id");
        int intValue = obj == null ? -1 : ((Integer) obj).intValue();
        if (sChannelID == -1 && intValue > 0 && sFirstConnection.get() == 1) {
            sChannelID = intValue;
        }
        TTWebsocketConnection.Builder newWebsocketConnectionBuilder = sCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        try {
            newWebsocketConnectionBuilder.setUrlList(list);
            newWebsocketConnectionBuilder.setAppKey(String.valueOf(map.get("app_key")));
            newWebsocketConnectionBuilder.setFpid(((Integer) map.get("fpid")).intValue());
            newWebsocketConnectionBuilder.setAppVersion(((Integer) map.get(ReportUtil.Params.APP_VERSION)).intValue());
            newWebsocketConnectionBuilder.setAppId(((Integer) map.get("aid")).intValue());
            newWebsocketConnectionBuilder.setDeviceId(Long.parseLong((String) map.get(ReportUtil.Params.DEVICE_ID)));
            newWebsocketConnectionBuilder.setInstallId(Long.parseLong((String) map.get("iid")));
            if (intValue > 0 && intValue == sChannelID) {
                this.mSharedConnection = true;
            }
            newWebsocketConnectionBuilder.setSharedConnection(false);
            if (map.containsKey("sid")) {
                newWebsocketConnectionBuilder.setSessionId((String) map.get("sid"));
            }
            String str = (String) map.get(CustomDataTagHandler.EXTRA_ATTRIBUTE);
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                }
            }
            try {
                HashMap hashMap2 = new HashMap();
                Map<String, String> clientKeyHeaders = getClientKeyHeaders();
                if (Logger.debug()) {
                    Logger.d(TAG, "Client key: " + clientKeyHeaders);
                }
                if (clientKeyHeaders != null && !clientKeyHeaders.isEmpty()) {
                    hashMap2.putAll(clientKeyHeaders);
                }
                Map map2 = (Map) map.get("custom_headers");
                if (map2 != null && !map2.isEmpty()) {
                    hashMap2.putAll(map2);
                }
                if (!hashMap2.isEmpty()) {
                    newWebsocketConnectionBuilder.setCustomizedHeaders(hashMap2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            DestroyTimeoutControl destroyTimeoutControl = this.mDestroyTimeoutControl;
            if (destroyTimeoutControl != null && destroyTimeoutControl.getWebsocketTimeout() > 0) {
                long websocketTimeout = this.mDestroyTimeoutControl.getWebsocketTimeout();
                if (Logger.debug()) {
                    Logger.d(TAG, "WS destroy timeout:" + websocketTimeout);
                }
                hashMap.put(TIME_OUT_HEADER, String.valueOf(websocketTimeout));
            }
            newWebsocketConnectionBuilder.setCustomizedParams(hashMap);
            TTWebsocketConnection build = newWebsocketConnectionBuilder.build();
            this.mWebsocketConnection = build;
            build.startConnection();
        } catch (Throwable th2) {
            th2.printStackTrace();
            throw new IllegalArgumentException("configMap contain err params !!!");
        }
    }

    private void parseExtraParamsForPrivateProtocol(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    try {
                        if (split[0].equals(PING_INTERVAL_HEADER)) {
                            this.mPingInterval = Integer.valueOf(split[1]).intValue() * 1000;
                        } else if (split[0].equals(TIME_OUT_HEADER)) {
                            this.mTimeOut = Integer.valueOf(split[1]).intValue();
                        } else if (!this.mUsePrivateProtocolProxy.get()) {
                            hashMap.put(split[0], split[1]);
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static void mergeServiceId(Map<String, Object> map, List<Integer> list) {
        ArrayList arrayList = (ArrayList) map.get("service_id_list");
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (!list.contains(Integer.valueOf(intValue))) {
                list.add(Integer.valueOf(intValue));
            }
        }
    }

    private void startConnectionWithPrivateProtocol(Map<String, Object> map, URI uri) {
        String str;
        int port = uri.getPort();
        String path = uri.getPath();
        String query = uri.getQuery();
        if (port <= 0) {
            port = 443;
        }
        int i = port;
        if (Logger.debug()) {
            Logger.d(TAG, "PP connection host:" + uri.getHost() + ":" + i + path + "?" + query);
        }
        CronetFrontierClient.TransportMode covertTransportMode = covertTransportMode(((Integer) map.get("transport_mode")).intValue());
        sMode = covertTransportMode;
        ArrayList<Integer> arrayList = new ArrayList();
        if (this.mUsePrivateProtocolProxy.get()) {
            arrayList.add(1);
        } else {
            arrayList.add(9000);
            if (!NetworkParams.isEnablePPForceUseSharedStream()) {
                mergeServiceId(map, arrayList);
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String str2 = (String) map.get(CustomDataTagHandler.EXTRA_ATTRIBUTE);
        parseExtraParamsForPrivateProtocol(str2, hashMap);
        try {
            Map<String, String> clientKeyHeaders = getClientKeyHeaders();
            if (Logger.debug()) {
                Logger.d(TAG, "PP client key: " + clientKeyHeaders);
            }
            if (clientKeyHeaders != null && !clientKeyHeaders.isEmpty()) {
                hashMap.putAll(clientKeyHeaders);
            }
            Map<? extends String, ? extends String> map2 = (Map) map.get("custom_headers");
            if (map2 != null && !map2.isEmpty()) {
                hashMap.putAll(map2);
            }
            if (privateProtocolProxyEnabled()) {
                String defaultUserAgent = MySelfChannelImpl.getDefaultUserAgent();
                if (!TextUtils.isEmpty(defaultUserAgent)) {
                    hashMap.put("user-agent", defaultUserAgent);
                }
                String cookieHeader = getCookieHeader(uri);
                if (!TextUtils.isEmpty(cookieHeader)) {
                    hashMap.put("cookie", cookieHeader);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mAllServiceBuildInfo.clear();
        DestroyTimeoutControl destroyTimeoutControl = this.mDestroyTimeoutControl;
        if (destroyTimeoutControl != null && destroyTimeoutControl.getPrivateProtocolTimeout() > 0) {
            int privateProtocolTimeout = (int) this.mDestroyTimeoutControl.getPrivateProtocolTimeout();
            if (Logger.debug()) {
                Logger.d(TAG, "PP destroy timeout:" + privateProtocolTimeout);
            }
            this.mTimeOut = privateProtocolTimeout;
        }
        CronetFrontierClient.Builder callback = CronetFrontierClient.Builder.create(((Integer) map.get("aid")).intValue(), ((Integer) map.get("fpid")).intValue(), uri.getHost(), i, Integer.toString(((Integer) map.get(ReportUtil.Params.APP_VERSION)).intValue()), (String) map.get(ReportUtil.Params.DEVICE_ID), (String) map.get("app_key")).pingInterval(this.mPingInterval).timeout(this.mTimeOut).transportMode(covertTransportMode).headers(hashMap).callback(new PrivateProtocolCallbackImpl(this.mWsChannelClient, this));
        if (this.mUsePrivateProtocolProxy.get()) {
            callback.proxy(true);
            String constructQueryForProxyMode = constructQueryForProxyMode(query, str2, map.get("iid"));
            if (Logger.debug()) {
                str = TAG;
                Logger.d(str, "PP connection real query:" + constructQueryForProxyMode + " path:" + path);
            } else {
                str = TAG;
            }
            callback.query(constructQueryForProxyMode);
            callback.path(path);
        } else {
            str = TAG;
        }
        callback.uniqueServiceIdList(arrayList);
        this.mFrontierClient = callback.build();
        if (Logger.debug()) {
            Logger.d(str, "Register serviceIdList: " + arrayList + " mode:" + covertTransportMode);
        }
        for (Integer num : arrayList) {
            registerServiceById(num.intValue(), null, null);
            this.mAllServiceBuildInfo.put(num, false);
        }
    }

    private static String constructQueryForProxyMode(String str, String str2, Object obj) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(str2);
        }
        try {
            long parseLong = Long.parseLong((String) obj);
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append("iid=" + parseLong);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    private static String getCookieHeader(URI uri) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        try {
            CookieHandler cookieHandler = CookieHandler.getDefault();
            Map<String, List<String>> map = cookieHandler != null ? cookieHandler.get(uri, hashMap) : null;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if ("cookie".equalsIgnoreCase(entry.getKey()) && !entry.getValue().isEmpty()) {
                        int i = 0;
                        for (String str : entry.getValue()) {
                            if (i > 0) {
                                sb.append("; ");
                            }
                            sb.append(str);
                            i++;
                        }
                    }
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private CronetFrontierClient.TransportMode covertTransportMode(int i) {
        if (i == 3 || i == 4) {
            this.mUsePrivateProtocolProxy.set(true);
        }
        if (i == 1 || i == 2 || i == 4) {
            return CronetFrontierClient.TransportMode.TLS;
        }
        return CronetFrontierClient.TransportMode.QUIC;
    }

    public void setFirstStreamReady(boolean z) {
        this.mIsFirstStreamReady = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class ServiceMessageReceiverImpl implements CronetFrontierClient.IServiceMessageReceiver {
        ServiceMessageReceiverImpl() {
        }

        public void onServiceReady(int i, String str) {
            if (Logger.debug()) {
                Logger.d(CronetFrontierConnection.TAG, "onServiceReady ServiceId:" + i + " log info:" + str);
            }
            if (!CronetFrontierConnection.this.mIsFirstStreamReady) {
                CronetFrontierConnection.this.mIsFirstStreamReady = true;
                if (CronetFrontierConnection.this.mFrontierClient != null && CronetFrontierConnection.this.mAppState != -1) {
                    CronetFrontierConnection.this.mFrontierClient.reportAppStateChange(CronetFrontierConnection.this.mAppState == 1);
                }
            }
            CronetFrontierConnection.this.mAllServiceBuildInfo.put(Integer.valueOf(i), true);
            if (CronetFrontierConnection.this.isFallbackTaskRunning() && CronetFrontierConnection.this.isAllServiceConnected()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", 1);
                    jSONObject.put("private_protocol_enable", 1);
                    jSONObject.put("state", 4);
                    jSONObject.put("url", CronetFrontierConnection.sPrivateProtocolUrl);
                    if (Logger.debug()) {
                        Logger.d(CronetFrontierConnection.TAG, "PP onConnectionStateChanged state: 4 url:" + CronetFrontierConnection.sPrivateProtocolUrl);
                    }
                    CronetFrontierConnection.this.mWsChannelClient.onConnection(jSONObject);
                } catch (Throwable unused) {
                }
            }
            CronetFrontierConnection.this.mWsChannelClient.onServiceConnectEvent(i, true, "");
        }

        public void onError(int i, int i2, String str) {
            if (Logger.debug()) {
                Logger.d(CronetFrontierConnection.TAG, "onError ServiceId:" + i + " error code:" + i2 + " info:" + str);
            }
            CronetFrontierConnection.this.mWsChannelClient.onServiceConnectEvent(i, false, "");
        }

        public void onReceivedMessage(int i, Map<String, String> map, byte[] bArr) {
            if (CronetFrontierConnection.this.mUsePrivateProtocolProxy.get()) {
                if (Logger.debug()) {
                    Logger.d(CronetFrontierConnection.TAG, "proxy onReceivedMessage service id:" + i + " data length:" + bArr.length);
                }
                CronetFrontierConnection.this.mWsChannelClient.onMessage(bArr);
                return;
            }
            if (Logger.debug()) {
                Logger.d(CronetFrontierConnection.TAG, "onReceivedMessage service id:" + i + " data length:" + bArr.length);
            }
            WsChannelMsg wsChannelMsg = new WsChannelMsg();
            wsChannelMsg.setService(i);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    if (entry.getKey().equals(CronetFrontierConnection.METHOD_ID_HEADER)) {
                        try {
                            wsChannelMsg.setMethod(Integer.valueOf(entry.getValue()).intValue());
                        } catch (NumberFormatException e) {
                            Logger.e(CronetFrontierConnection.TAG, "method_id is not valid: " + entry.getValue());
                            e.printStackTrace();
                        }
                    } else if (entry.getKey().equalsIgnoreCase(CronetFrontierConnection.PAYLOAD_ENCODING_HEADER)) {
                        wsChannelMsg.setPayloadEncoding(entry.getValue());
                    } else if (entry.getKey().equalsIgnoreCase(CronetFrontierConnection.PAYLOAD_TYPE_HEADER)) {
                        wsChannelMsg.setPayloadType(entry.getValue());
                    } else if (entry.getKey().equalsIgnoreCase(CronetFrontierConnection.MSG_ID_HEADER)) {
                        wsChannelMsg.setMsgId(entry.getValue());
                    } else if (entry.getKey().equalsIgnoreCase(CronetFrontierConnection.MSG_SERVER_TIMING_HEADER)) {
                        wsChannelMsg.setServerTiming(entry.getValue());
                    } else {
                        WsChannelMsg.MsgHeader msgHeader = new WsChannelMsg.MsgHeader();
                        msgHeader.setKey(entry.getKey());
                        msgHeader.setValue(entry.getValue());
                        arrayList.add(msgHeader);
                    }
                }
            }
            wsChannelMsg.setMsgHeaders(arrayList);
            wsChannelMsg.setPayload(bArr);
            if (wsChannelMsg.getPayloadEncoding() == null) {
                wsChannelMsg.setPayloadEncoding("");
            }
            if (wsChannelMsg.getPayloadType() == null) {
                wsChannelMsg.setPayloadType("");
            }
            if (Logger.debug()) {
                Logger.d(CronetFrontierConnection.TAG, "onReceivedMessage:" + wsChannelMsg);
            }
            CronetFrontierConnection.this.mWsChannelClient.onMessage(wsChannelMsg);
        }

        public void onReceivedAck(int i, long j, String str, Boolean bool) {
            if (Logger.debug()) {
                Logger.d(CronetFrontierConnection.TAG, "onReceivedAck serviceId:" + i + " messageId:" + j + " logInfo:" + str);
            }
        }
    }

    private void registerServiceById(int i, ByteBuffer byteBuffer, String[] strArr) {
        if (this.mFrontierClient != null) {
            this.mFrontierClient.registerService(new TTServiceInfo(i, new ServiceMessageReceiverImpl()), byteBuffer, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAllServiceConnected() {
        if (this.mAllServiceBuildInfo.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<Integer, Boolean>> it = this.mAllServiceBuildInfo.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private URI parsePrivateProtocolUrl(Map<String, Object> map) {
        String str = (String) map.get("private_protocol_url");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        sPrivateProtocolUrl = str;
        try {
            if (str.startsWith("wss:")) {
                str = "https:" + str.substring(4);
            } else if (str.startsWith("ws:")) {
                str = "http:" + str.substring(3);
            }
            return UrlUtils.safeCreateUri(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean canUsePrivateProtocol(Map<String, Object> map) {
        if (!NetworkParams.isPrivateProtocolEnabled() || this.mRetryAttempts.get() >= 3) {
            if (Logger.debug()) {
                Logger.d(TAG, "Retry attempts:" + this.mRetryAttempts.get() + ",tnc enabled:" + NetworkParams.isPrivateProtocolEnabled());
            }
            return false;
        }
        Object obj = map.get("private_protocol_enable");
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public void startConnection(Map<String, Object> map, List<String> list) {
        if (list == null || list.size() <= 0) {
            throw new IllegalArgumentException("urls size <= 0 !!!");
        }
        if (Logger.debug()) {
            Logger.d(TAG, "openConnection url:" + list.get(0));
        }
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("configMap is empty !!!");
        }
        destroyConnection();
        if (!canUsePrivateProtocol(map)) {
            this.mDestroyTimeoutControl = new DestroyTimeoutControl(map, true);
            startConnectionWithWebSocket(map, list);
            return;
        }
        URI parsePrivateProtocolUrl = parsePrivateProtocolUrl(map);
        if (parsePrivateProtocolUrl == null) {
            this.mDestroyTimeoutControl = new DestroyTimeoutControl(map, true);
            startConnectionWithWebSocket(map, list);
            return;
        }
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(map, false);
        Object obj = map.get("disable_fallback_websocket");
        boolean booleanValue = obj != null ? ((Boolean) obj).booleanValue() : false;
        if (Logger.debug()) {
            Logger.d(TAG, "DisableFallbackTask:" + sDisableFallbackTask + " DisableFallbackWS:" + booleanValue);
        }
        if (!sDisableFallbackTask && !booleanValue && this.mDestroyTimeoutControl.shouldFallbackToWebSocket()) {
            long fallbackTimeoutSeconds = getFallbackTimeoutSeconds(map);
            if (Logger.debug()) {
                Logger.d(TAG, "Fallback to websocket timeout:" + fallbackTimeoutSeconds);
            }
            AsyncIOTaskManager.getInstance().postTask(new FallbackWebSocketTask(fallbackTimeoutSeconds, map, list));
            this.mIsFallbackTaskRunning.set(true);
        }
        this.mUsePrivateProtocol.set(true);
        startConnectionWithPrivateProtocol(map, parsePrivateProtocolUrl);
    }

    private long getFallbackTimeoutSeconds(Map<String, Object> map) {
        Map map2 = (Map) map.get("custom_headers");
        if (map2 == null || map2.isEmpty() || !map2.containsKey(FALLBACK_TIMEOUT_MILLS)) {
            return C0878a.f531q;
        }
        String str = (String) map2.get(FALLBACK_TIMEOUT_MILLS);
        if (TextUtils.isEmpty(str)) {
            return C0878a.f531q;
        }
        try {
            int intValue = Integer.valueOf(str).intValue();
            return intValue > 0 ? intValue : C0878a.f531q;
        } catch (Exception unused) {
            return C0878a.f531q;
        }
    }

    public boolean isFallbackTaskRunning() {
        return this.mIsFallbackTaskRunning.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public final class FallbackWebSocketTask extends AsyncTask {
        private final Map<String, Object> mConfigMap;
        private final List<String> mUrls;

        public FallbackWebSocketTask(long j, Map<String, Object> map, List<String> list) {
            super(j, CronetFrontierConnection.FALLBACK_WEBSOCKET_TASK_ID);
            this.mConfigMap = map;
            this.mUrls = list;
        }

        public void run() {
            if (CronetFrontierConnection.this.isAllServiceConnected()) {
                CronetFrontierConnection.this.mRetryAttempts.set(0);
                CronetFrontierConnection.this.mIsFallbackTaskRunning.set(false);
                return;
            }
            int incrementAndGet = CronetFrontierConnection.this.mRetryAttempts.incrementAndGet();
            if (Logger.debug()) {
                Logger.d(CronetFrontierConnection.TAG, "Fallback to websocket connection, retry attempts:" + incrementAndGet);
            }
            CronetFrontierConnection.this.destroyConnection();
            CronetFrontierConnection.this.startConnectionWithWebSocket(this.mConfigMap, this.mUrls);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retry_attempts", incrementAndGet);
                jSONObject.put("reason", "connect timeout fallback");
                CronetFrontierConnection.this.reportPrivateProtocolRelatedLog(jSONObject, 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void disableFallbackToWebSocket(boolean z) {
        sDisableFallbackTask = z;
    }

    public boolean privateProtocolEnabled() {
        return this.mUsePrivateProtocol.get();
    }

    public boolean privateProtocolProxyEnabled() {
        return this.mUsePrivateProtocolProxy.get();
    }

    public void stopConnection() {
        disconnectConnection();
    }

    public void destroyConnection() {
        disconnectConnection();
    }

    private void disconnectConnection() {
        TTWebsocketConnection tTWebsocketConnection = this.mWebsocketConnection;
        if (tTWebsocketConnection != null) {
            tTWebsocketConnection.stopConnection();
            this.mWebsocketConnection.destroyConnection();
        }
        CronetFrontierClient cronetFrontierClient = this.mFrontierClient;
        if (cronetFrontierClient != null) {
            cronetFrontierClient.destroy();
            AsyncIOTaskManager.getInstance().removeTaskById(FALLBACK_WEBSOCKET_TASK_ID);
            this.mIsFallbackTaskRunning.set(false);
        }
    }

    public boolean isConnected() {
        TTWebsocketConnection tTWebsocketConnection;
        CronetFrontierClient cronetFrontierClient;
        if (this.mUsePrivateProtocol.get() && (cronetFrontierClient = this.mFrontierClient) != null) {
            return cronetFrontierClient.isConnected();
        }
        if (this.mUsePrivateProtocol.get() || (tTWebsocketConnection = this.mWebsocketConnection) == null) {
            return false;
        }
        return tTWebsocketConnection.isConnected();
    }

    public boolean sendMessageWithWebSocket(byte[] bArr) {
        if (Logger.debug()) {
            Logger.d(TAG, "WS sendMessage data:" + bArr);
        }
        if (this.mWebsocketConnection == null) {
            return false;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        this.mWebsocketConnection.asyncSendBinary(allocateDirect);
        return true;
    }

    private void reportAppStateChange(List<WsChannelMsg.MsgHeader> list) {
        for (WsChannelMsg.MsgHeader msgHeader : list) {
            if (msgHeader != null && "IsBackground".equals(msgHeader.getKey())) {
                String value = msgHeader.getValue();
                if (value.equals("1")) {
                    this.mAppState = 1;
                } else if (value.equals(AddressParam.TYPE_DISAPPROVE)) {
                    this.mAppState = 0;
                }
                if (!this.mIsFirstStreamReady || this.mAppState == -1) {
                    return;
                }
                this.mFrontierClient.reportAppStateChange(this.mAppState == 1);
                return;
            }
        }
    }

    public boolean sendMessageWithPrivateProtocolProxy(byte[] bArr) {
        if (Logger.debug()) {
            Logger.d(TAG, "PP proxy sendMessage data:" + bArr.toString());
        }
        CronetFrontierClient cronetFrontierClient = this.mFrontierClient;
        if (cronetFrontierClient == null || bArr == null) {
            return false;
        }
        if (!cronetFrontierClient.isServiceExisted(1)) {
            registerServiceById(1, null, null);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        this.mFrontierClient.sendMessage(1, (String[]) null, allocateDirect);
        return true;
    }

    public boolean sendMessageWithPrivateProtocol(WsChannelMsg wsChannelMsg) {
        if (Logger.debug()) {
            Logger.d(TAG, "PP sendMessage data:" + wsChannelMsg.toString());
        }
        if (this.mFrontierClient == null || wsChannelMsg == null) {
            return false;
        }
        int service = wsChannelMsg.getService();
        if (service == 9000 && wsChannelMsg.getMethod() == 4) {
            reportAppStateChange(wsChannelMsg.getMsgHeaders());
            return true;
        }
        String[] constructMessageMetaInfo = constructMessageMetaInfo(wsChannelMsg);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(wsChannelMsg.getPayload().length);
        allocateDirect.put(wsChannelMsg.getPayload());
        this.mFrontierClient.sendMessage(service, constructMessageMetaInfo, allocateDirect);
        if (Logger.debug()) {
            Logger.d(TAG, "PP sendMessage serviceId:" + service);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPrivateProtocolRelatedLog(JSONObject jSONObject, int i) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        jSONObject.put("report_type", i);
        jSONObject.put("report_time", System.currentTimeMillis());
        if (Logger.debug()) {
            Logger.d(TAG, "report log:" + jSONObject.toString());
        }
        CronetAppProviderManager.inst().sendAppMonitorEvent(jSONObject.toString(), LOG_TYPE);
    }

    private static String[] constructMessageMetaInfo(WsChannelMsg wsChannelMsg) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(METHOD_ID_HEADER);
        arrayList.add(String.valueOf(wsChannelMsg.getMethod()));
        if (!TextUtils.isEmpty(wsChannelMsg.getPayloadType())) {
            arrayList.add(PAYLOAD_TYPE_HEADER);
            arrayList.add(wsChannelMsg.getPayloadType());
        }
        if (!TextUtils.isEmpty(wsChannelMsg.getPayloadEncoding())) {
            arrayList.add(PAYLOAD_ENCODING_HEADER);
            arrayList.add(wsChannelMsg.getPayloadEncoding());
        }
        if (wsChannelMsg.getMsgHeaders() == null) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        for (WsChannelMsg.MsgHeader msgHeader : wsChannelMsg.getMsgHeaders()) {
            if (!TextUtils.isEmpty(msgHeader.getKey()) && !TextUtils.isEmpty(msgHeader.getValue())) {
                arrayList.add(msgHeader.getKey());
                arrayList.add(msgHeader.getValue());
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
