package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum NetworkDetectionStopReason {
    USER(0),
    TIMEOUT(1),
    CONNECTION_LOST(2),
    STREAMING(3),
    INNER_ERR(4);

    int value;

    NetworkDetectionStopReason(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static NetworkDetectionStopReason fromId(int type) {
        for (NetworkDetectionStopReason networkDetectionStopReason : values()) {
            if (networkDetectionStopReason.value() == type) {
                return networkDetectionStopReason;
            }
        }
        return USER;
    }
}
