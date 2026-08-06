package com.bytedance.sdk.xbridge.cn.websocket.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public interface BdpWsClient {
    public static final int DATA_TYPE_BINARY = 2;
    public static final int DATA_TYPE_TEXT = 1;
    public static final int DATA_TYPE_UNKNOWN = 0;
    public static final String KEY_LOG = "__MP_LOG";
    public static final String KEY_RESP_HEADER = "__MP_RESP_HEADER";
    public static final String KEY_TRANSPORT_PROTOCOL = "__MP_TRANSPORT_PROTOCOL";

    /* loaded from: classes5.dex */
    public interface OnStateChangeListener {
        public static final int STATE_CLOSED = 3;
        public static final int STATE_CONNECTED = 4;
        public static final int STATE_CONNECTING = 1;
        public static final int STATE_DISCONNECTING = 5;
        public static final int STATE_FAILED = 2;

        void onConnStateChange(int i, String str, String str2);

        void onMessage(byte[] bArr, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface SocketDataType {
    }

    boolean isConnected();

    void onParameterChange(Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2);

    void openConnection(Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2);

    boolean sendMessage(byte[] bArr, int i);

    void stopConnection();
}
