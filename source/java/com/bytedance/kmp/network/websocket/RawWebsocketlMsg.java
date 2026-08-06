package com.bytedance.kmp.network.websocket;

import kotlin.Metadata;

/* compiled from: RawWebsocketlMsg.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;", "", "payloadString", "", "payloadBuffer", "", "(Ljava/lang/String;[B)V", "getPayloadBuffer", "()[B", "getPayloadString", "()Ljava/lang/String;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RawWebsocketlMsg {
    private final byte[] payloadBuffer;
    private final String payloadString;

    public RawWebsocketlMsg(String str, byte[] bArr) {
        this.payloadString = str;
        this.payloadBuffer = bArr;
    }

    public final String getPayloadString() {
        return this.payloadString;
    }

    public final byte[] getPayloadBuffer() {
        return this.payloadBuffer;
    }
}
