package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum SEIStreamUpdateEvent {
    STREAM_ADD(0),
    STREAM_REMOVE(1);

    int value;

    SEIStreamUpdateEvent(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
