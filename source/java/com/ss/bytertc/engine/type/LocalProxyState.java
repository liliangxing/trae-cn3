package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum LocalProxyState {
    INITED(0),
    CONNECTED(1),
    ERROR(2);

    private int value;

    LocalProxyState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static LocalProxyState fromId(int id) {
        for (LocalProxyState localProxyState : values()) {
            if (localProxyState.value() == id) {
                return localProxyState;
            }
        }
        return null;
    }
}
