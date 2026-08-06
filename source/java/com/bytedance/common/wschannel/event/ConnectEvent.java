package com.bytedance.common.wschannel.event;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class ConnectEvent {
    public final ConnectionState connectionState;
    public final int mChannelId;
    public final ChannelType mType;

    public ConnectEvent(ConnectionState connectionState, ChannelType channelType, int i) {
        this.connectionState = connectionState;
        this.mType = channelType;
        this.mChannelId = i;
    }

    public String toString() {
        return "ConnectEvent{mType=" + this.mType + ", connectionState=" + this.connectionState + ", mChannelId=" + this.mChannelId + AbstractJsonLexerKt.END_OBJ;
    }
}
