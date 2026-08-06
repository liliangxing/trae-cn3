package com.bytedance.kmp.network.websocket;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: IRawWsEventListener.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;", "", "onConnectStateChange", "", "state", "Lcom/bytedance/kmp/network/websocket/RawWebsocketState;", "error", "Lcom/bytedance/kmp/network/websocket/WebsocketBizError;", "onHeaderReceived", "headerMap", "", "", "onMsgReceived", "msg", "Lcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IRawWsEventListener {
    void onConnectStateChange(RawWebsocketState state, WebsocketBizError error);

    void onHeaderReceived(Map<String, String> headerMap);

    void onMsgReceived(String error, RawWebsocketlMsg msg);
}
