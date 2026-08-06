package com.bytedance.kmp.network.websocket;

import com.bytedance.kmp.network.util.NLog;
import com.example.interopdemo.websocket.NativeConnectionState;
import com.example.interopdemo.websocket.NativeRawWsListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NativeRawWsService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/kmp/network/websocket/NativeRawListenerImpl;", "Lcom/example/interopdemo/websocket/NativeRawWsListener;", "listener", "Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;", "(Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;)V", "onBinaryMessage", "", "data", "", "onConnectStateChange", "state", "Lcom/example/interopdemo/websocket/NativeConnectionState;", "json", "", "onConnectionError", "onTextMessage", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NativeRawListenerImpl implements NativeRawWsListener {
    private final IRawWsEventListener listener;

    public NativeRawListenerImpl(IRawWsEventListener iRawWsEventListener) {
        Intrinsics.checkNotNullParameter(iRawWsEventListener, "listener");
        this.listener = iRawWsEventListener;
    }

    public void onBinaryMessage(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.listener.onMsgReceived("", new RawWebsocketlMsg(null, data));
    }

    public void onTextMessage(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.listener.onMsgReceived("", new RawWebsocketlMsg(data, null));
    }

    public void onConnectionError(String json) {
        String str;
        Intrinsics.checkNotNullParameter(json, "json");
        NLog nLog = NLog.INSTANCE;
        NLog.Level level = NLog.Level.DEBUG;
        if (level.compareTo(nLog.getLevel()) >= 0) {
            String str2 = "onConnectionError " + json;
            if (str2 == null || (str = str2.toString()) == null) {
                str = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
        }
    }

    public void onConnectStateChange(NativeConnectionState state, String json) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(json, "json");
        WebsocketBizError websocketBizError = new WebsocketBizError();
        websocketBizError.setName("");
        websocketBizError.setCode(-1);
        websocketBizError.setReason(json);
        this.listener.onConnectStateChange(NativeRawWsServiceKt.toRawState(state), websocketBizError);
    }
}
