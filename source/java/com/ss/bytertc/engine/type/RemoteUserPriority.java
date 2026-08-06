package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RemoteUserPriority {
    REMOTE_USER_PRIORITY_LOW(0),
    REMOTE_USER_PRIORITY_MEDIUM(100),
    REMOTE_USER_PRIORITY_HIGH(200);

    private int value;

    RemoteUserPriority(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
