package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum ConnectionState {
    CONNECTION_STATE_DISCONNECTED(1),
    CONNECTION_STATE_CONNECTING(2),
    CONNECTION_STATE_CONNECTED(3),
    CONNECTION_STATE_RECONNECTING(4),
    CONNECTION_STATE_RECONNECTED(5),
    CONNECTION_STATE_LOST(6),
    CONNECTION_STATE_FAILED(7);

    private int value;

    ConnectionState(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

    public static ConnectionState fromId(int type) {
        for (ConnectionState connectionState : values()) {
            if (connectionState.getValue() == type) {
                return connectionState;
            }
        }
        return CONNECTION_STATE_DISCONNECTED;
    }
}
