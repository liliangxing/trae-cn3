package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TTNetWebSocketUtil {
    private static final String CRONET_CHANNEL_IMPL_CLASS = "org.chromium.wschannel.WsClient";
    public static final String TAG = "TTNetWebSocketUtil";
    public static final String TRANSPORT_PROTOCOL_QUIC = "quic";
    public static final String TRANSPORT_PROTOCOL_TCP = "tcp";

    /* JADX INFO: Access modifiers changed from: private */
    public static int originType2SocketDataType(int i) {
        if (i == 1) {
            return 1;
        }
        return i == 2 ? 2 : 0;
    }

    public static BdpWsClient createWsClient(final BdpWsClient.OnStateChangeListener onStateChangeListener) {
        try {
            IWsClient tryResolveWsClient = tryResolveWsClient(new IMessageReceiveListener() { // from class: com.bytedance.sdk.xbridge.cn.websocket.utils.TTNetWebSocketUtil.1
                private String mJSON;
                private String mURL;
                private final int STATE_CONNECTED = 4;
                private final int STATE_CLOSED = 3;
                private final int STATE_FAILED = 2;

                public void onConnection(int i, String str, JSONObject jSONObject) {
                    if (BdpWsClient.OnStateChangeListener.this == null) {
                        return;
                    }
                    String valueOf = jSONObject != null ? String.valueOf(jSONObject) : "{}";
                    if (i == 4 || i == 3 || i == 2) {
                        this.mURL = str;
                        this.mJSON = valueOf;
                    } else {
                        BdpWsClient.OnStateChangeListener.this.onConnStateChange(i, str, valueOf);
                    }
                }

                public void onMessage(byte[] bArr, int i) {
                    BdpWsClient.OnStateChangeListener onStateChangeListener2 = BdpWsClient.OnStateChangeListener.this;
                    if (onStateChangeListener2 == null) {
                        return;
                    }
                    onStateChangeListener2.onMessage(bArr, TTNetWebSocketUtil.originType2SocketDataType(i));
                }

                public void onFeedBackLog(String str) {
                    JSONObject safeToJsonObj;
                    int optInt;
                    if (BdpWsClient.OnStateChangeListener.this == null || (optInt = (safeToJsonObj = TTNetWebSocketUtil.safeToJsonObj(str)).optInt("ws_state", -1)) == -1) {
                        return;
                    }
                    if (optInt != 0) {
                        if (optInt == 1 || optInt == 3) {
                            BdpWsClient.OnStateChangeListener.this.onConnStateChange(3, this.mURL, safeToJsonObj.optString("ws_error"));
                            return;
                        }
                        return;
                    }
                    String str2 = safeToJsonObj.optBoolean("using_quic") ? TTNetWebSocketUtil.TRANSPORT_PROTOCOL_QUIC : TTNetWebSocketUtil.TRANSPORT_PROTOCOL_TCP;
                    JSONObject safeToJsonObj2 = TTNetWebSocketUtil.safeToJsonObj(this.mJSON);
                    TTNetWebSocketUtil.safePutStr(safeToJsonObj2, BdpWsClient.KEY_RESP_HEADER, safeToJsonObj.optString("response_header"));
                    TTNetWebSocketUtil.safePutStr(safeToJsonObj2, BdpWsClient.KEY_TRANSPORT_PROTOCOL, str2);
                    TTNetWebSocketUtil.safePutObj(safeToJsonObj2, BdpWsClient.KEY_LOG, safeToJsonObj);
                    BdpWsClient.OnStateChangeListener.this.onConnStateChange(4, this.mURL, String.valueOf(safeToJsonObj2));
                }
            });
            if (tryResolveWsClient == null) {
                return null;
            }
            return new BdpWsClientImpl(tryResolveWsClient);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static IWsClient tryResolveWsClient(IMessageReceiveListener iMessageReceiveListener) throws Exception {
        Class<?> cls;
        try {
            cls = Class.forName(CRONET_CHANNEL_IMPL_CLASS);
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            throw new ClassNotFoundException("org.chromium.wschannel.WsClient class not found");
        }
        Object newInstance = cls.getDeclaredConstructor(IMessageReceiveListener.class).newInstance(iMessageReceiveListener);
        if (newInstance instanceof IWsClient) {
            return (IWsClient) newInstance;
        }
        return null;
    }

    public static boolean isConnect(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            XBridge.log(message);
            return false;
        }
    }

    public static JSONObject safeToJsonObj(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public static void safePutStr(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public static void safePutObj(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
        }
    }
}
