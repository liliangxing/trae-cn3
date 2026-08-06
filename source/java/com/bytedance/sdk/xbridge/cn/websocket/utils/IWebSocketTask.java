package com.bytedance.sdk.xbridge.cn.websocket.utils;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: IWebSocketTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\nH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/IWebSocketTask;", "", "isWsConnected", "", "sendMessage", "", "byteData", "", "msg", "setStatusListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/WsStatusListener;", "startConnect", "stopConnect", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IWebSocketTask {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String HEADER_SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";

    boolean isWsConnected();

    String sendMessage(String msg);

    String sendMessage(byte[] byteData);

    void setStatusListener(WsStatusListener listener);

    void startConnect();

    void stopConnect();

    /* compiled from: IWebSocketTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/IWebSocketTask$Companion;", "", "()V", "HEADER_SEC_WEB_SOCKET_PROTOCOL", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String HEADER_SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";

        private Companion() {
        }
    }
}
