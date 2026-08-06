package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.chromium.CronetClient;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WsClient implements IWsClient {
    private static final String TAG = "WsClient";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine mCronetEngine;
    private CallbackImpl mCallback = new CallbackImpl();
    private IMessageReceiveListener mListener;
    private TTWebsocketConnection mWebsocketConnection;

    /* JADX INFO: Access modifiers changed from: private */
    public int cronetToWsStateAdapter(int i) {
        if (i == -1) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (i != 1) {
            return i;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class CallbackImpl extends TTWebsocketConnection.Callback {
        CallbackImpl() {
        }

        public void onMessageReceived(TTWebsocketConnection tTWebsocketConnection, ByteBuffer byteBuffer, int i) {
            byte[] bArr = new byte[byteBuffer.capacity()];
            if (i != 1 && i != 2) {
                i = 0;
            }
            try {
                byteBuffer.get(bArr);
                if (WsClient.this.mListener != null) {
                    WsClient.this.mListener.onMessage(bArr, i);
                }
            } catch (Throwable unused) {
            }
        }

        public void onConnectionStateChanged(TTWebsocketConnection tTWebsocketConnection, int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("state", WsClient.this.cronetToWsStateAdapter(i));
                jSONObject.put("url", str);
                if (WsClient.this.mListener != null) {
                    WsClient.this.mListener.onConnection(i, str, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }

        public void onConnectionError(TTWebsocketConnection tTWebsocketConnection, int i, String str, String str2) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("error", str2);
                if (WsClient.this.mListener != null) {
                    WsClient.this.mListener.onConnection(i, str, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }

        public void onFeedbackLog(TTWebsocketConnection tTWebsocketConnection, String str) {
            if (WsClient.this.mListener != null) {
                WsClient.this.mListener.onFeedBackLog(str);
            }
        }

        public void onTrafficChanged(TTWebsocketConnection tTWebsocketConnection, String str, long j, long j2, boolean z) {
            try {
                TrafficChangedObservable.inst().onTrafficChanged(str, j, j2, z);
            } catch (Throwable unused) {
            }
        }
    }

    public WsClient(IMessageReceiveListener iMessageReceiveListener) throws NullPointerException {
        if (mCronetEngine == null) {
            mCronetEngine = getCronetEngine();
        }
        this.mListener = iMessageReceiveListener;
    }

    private CronetEngine getCronetEngine() {
        if (Logger.debug()) {
            Logger.d(TAG, "Init cronet engine");
        }
        try {
            loadCronetKernel();
        } catch (Throwable th) {
            th.printStackTrace();
            if (Logger.debug()) {
                Logger.d(TAG, "TTNet init failed, cronet engine is null.");
            }
        }
        return CronetClient.getCronetEngine();
    }

    private static void loadCronetKernel() throws Exception {
        Object newInstance = Class.forName(TTNET_INIT_CLASS).newInstance();
        Reflect.on(newInstance).call("getInitCompletedLatch");
        Reflect.on(newInstance).call("preInitCronetKernel");
    }

    public boolean isConnected() {
        TTWebsocketConnection tTWebsocketConnection = this.mWebsocketConnection;
        if (tTWebsocketConnection == null) {
            return false;
        }
        return tTWebsocketConnection.isConnected();
    }

    public void openConnection(Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2) {
        if (list == null || list.size() <= 0) {
            throw new IllegalArgumentException("urls size <= 0 !!!");
        }
        if (Logger.debug()) {
            Logger.d(TAG, "openConnection url:" + list.get(0));
        }
        TTWebsocketConnection.Builder newWebsocketConnectionBuilder = mCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        newWebsocketConnectionBuilder.setUrlList(list);
        if (map != null && !map.isEmpty()) {
            newWebsocketConnectionBuilder.setCustomizedParams(map);
        }
        if (map2 != null && !map2.isEmpty()) {
            newWebsocketConnectionBuilder.setCustomizedHeaders(map2);
        }
        newWebsocketConnectionBuilder.setSharedConnection(z);
        newWebsocketConnectionBuilder.useFrontierProtocol(z2);
        TTWebsocketConnection build = newWebsocketConnectionBuilder.build();
        this.mWebsocketConnection = build;
        build.startConnection();
    }

    public void stopConnection() {
        TTWebsocketConnection tTWebsocketConnection = this.mWebsocketConnection;
        if (tTWebsocketConnection != null) {
            tTWebsocketConnection.stopConnection();
            this.mWebsocketConnection.destroyConnection();
        }
    }

    public void onParameterChange(Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2) {
        TTWebsocketConnection tTWebsocketConnection = this.mWebsocketConnection;
        if (tTWebsocketConnection != null) {
            tTWebsocketConnection.stopConnection();
            this.mWebsocketConnection.destroyConnection();
        }
        openConnection(map, map2, list, z, z2);
    }

    public boolean sendMessage(byte[] bArr, int i) throws Exception {
        if (Logger.debug()) {
            Logger.d(TAG, "sendMessage data:" + bArr);
        }
        if (this.mWebsocketConnection == null) {
            return false;
        }
        if (i == 2) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
            allocateDirect.put(bArr);
            this.mWebsocketConnection.asyncSendBinary(allocateDirect);
        } else if (i == 1) {
            this.mWebsocketConnection.asyncSendText(new String(bArr, Utf8Charset.NAME));
        } else {
            throw new IllegalArgumentException("Unsupported message type: " + i);
        }
        return true;
    }
}
