package com.bytedance.common.wschannel.channel.impl.p007ok.ws;

import okhttp3.Response;
import okio.ByteString;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class WebSocketListener {
    public void onClosed(CustomHeartBeatWebSocket customHeartBeatWebSocket, int i, String str) {
    }

    public void onClosing(CustomHeartBeatWebSocket customHeartBeatWebSocket, int i, String str) {
    }

    public void onFailure(CustomHeartBeatWebSocket customHeartBeatWebSocket, Throwable th, Response response) {
    }

    public void onMessage(CustomHeartBeatWebSocket customHeartBeatWebSocket, String str) {
    }

    public void onMessage(CustomHeartBeatWebSocket customHeartBeatWebSocket, ByteString byteString) {
    }

    public void onOpen(CustomHeartBeatWebSocket customHeartBeatWebSocket, Response response) {
    }

    public void onPong(CustomHeartBeatWebSocket customHeartBeatWebSocket, ByteString byteString) {
    }
}
