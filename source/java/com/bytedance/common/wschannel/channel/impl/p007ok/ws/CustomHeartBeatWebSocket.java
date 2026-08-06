package com.bytedance.common.wschannel.channel.impl.p007ok.ws;

import okhttp3.WebSocket;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface CustomHeartBeatWebSocket extends WebSocket {
    void sendPing();
}
