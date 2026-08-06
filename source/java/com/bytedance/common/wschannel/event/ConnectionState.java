package com.bytedance.common.wschannel.event;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public enum ConnectionState {
    CONNECTION_UNKNOWN(1),
    CONNECTING(2),
    CONNECT_FAILED(4),
    CONNECT_CLOSED(8),
    CONNECTED(16);

    final int mTypeValue;

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.mTypeValue + AbstractJsonLexerKt.END_OBJ;
    }

    ConnectionState(int i) {
        this.mTypeValue = i;
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }
}
