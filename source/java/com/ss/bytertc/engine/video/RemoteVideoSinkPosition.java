package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public enum RemoteVideoSinkPosition {
    AFTER_DECODER(0),
    AFTER_POST_PROCESS(1);

    private int value;

    RemoteVideoSinkPosition(int v) {
        this.value = v;
    }

    public static RemoteVideoSinkPosition convertFromInt(int v) {
        return values()[v];
    }

    public int getValue() {
        return this.value;
    }
}
