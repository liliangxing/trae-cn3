package com.bytedance.kmp.network.websocket;

import com.bytedance.kmp.network.util.NLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Websocket.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/kmp/network/websocket/SafeRawWsEventListenerDecorator;", "Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;", "delegate", "(Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;)V", "onConnectStateChange", "", "state", "Lcom/bytedance/kmp/network/websocket/RawWebsocketState;", "error", "Lcom/bytedance/kmp/network/websocket/WebsocketBizError;", "onHeaderReceived", "headerMap", "", "", "onMsgReceived", "msg", "Lcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SafeRawWsEventListenerDecorator implements IRawWsEventListener {
    private final IRawWsEventListener delegate;

    public SafeRawWsEventListenerDecorator(IRawWsEventListener iRawWsEventListener) {
        Intrinsics.checkNotNullParameter(iRawWsEventListener, "delegate");
        this.delegate = iRawWsEventListener;
    }

    @Override // com.bytedance.kmp.network.websocket.IRawWsEventListener
    public void onConnectStateChange(RawWebsocketState state, WebsocketBizError error) {
        String str;
        Intrinsics.checkNotNullParameter(error, "error");
        try {
            this.delegate.onConnectStateChange(state, error);
        } catch (Exception e) {
            NLog nLog = NLog.INSTANCE;
            NLog.Level level = NLog.Level.ERROR;
            if (level.compareTo(nLog.getLevel()) >= 0) {
                String str2 = "onConnectStateChange: " + e.getMessage();
                if (str2 == null || (str = str2.toString()) == null) {
                    str = "null";
                }
                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
            }
        }
    }

    @Override // com.bytedance.kmp.network.websocket.IRawWsEventListener
    public void onMsgReceived(String error, RawWebsocketlMsg msg) {
        String str;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            this.delegate.onMsgReceived(error, msg);
        } catch (Exception e) {
            NLog nLog = NLog.INSTANCE;
            NLog.Level level = NLog.Level.ERROR;
            if (level.compareTo(nLog.getLevel()) >= 0) {
                String str2 = "onMsgReceived: " + e.getMessage();
                if (str2 == null || (str = str2.toString()) == null) {
                    str = "null";
                }
                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
            }
        }
    }

    @Override // com.bytedance.kmp.network.websocket.IRawWsEventListener
    public void onHeaderReceived(Map<String, String> headerMap) {
        String str;
        Intrinsics.checkNotNullParameter(headerMap, "headerMap");
        try {
            this.delegate.onHeaderReceived(headerMap);
        } catch (Exception e) {
            NLog nLog = NLog.INSTANCE;
            NLog.Level level = NLog.Level.ERROR;
            if (level.compareTo(nLog.getLevel()) >= 0) {
                String str2 = "onHeaderReceived: " + e.getMessage();
                if (str2 == null || (str = str2.toString()) == null) {
                    str = "null";
                }
                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
            }
        }
    }
}
