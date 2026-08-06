package com.bytedance.sync.p005v4.net;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class NetTrace {
    int mSendMethod = 0;
    int mSendResult = 0;
    public int mSendMsgType = 0;
    public int mIsConnect = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public @interface SendMethod {
        public static final int UNKNOWN = 0;
        public static final int WITH_HTTPS = 2;
        public static final int WITH_SOCKET = 1;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public @interface SendResult {
        public static final int SEND_FAILED = 2;
        public static final int SEND_FAILED_NET_NOT_AVAILABLE = 3;
        public static final int SEND_SUCCESS = 1;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public @interface Strategy {
        public static final int HTTP_FIRST_BACKGROUND = 4;
        public static final int HTTP_FIRST_FOREGROUND = 3;
        public static final int UNKNOWN = 0;
        public static final int WS_FIRST_CONNECTED = 1;
        public static final int WS_FIRST_DISCONNECTED = 2;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface TraceDepend {
        int getCurrentStrategy();
    }

    public abstract void send();
}
