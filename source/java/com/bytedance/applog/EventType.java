package com.bytedance.applog;

/* loaded from: classes3.dex */
public enum EventType {
    V3(0),
    V1(1),
    LogData(2),
    Launch(3),
    Terminate(4),
    IMPRESSION(5),
    FORWARD_V3(6),
    UNKNOWN(99);

    final int value;

    EventType(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
