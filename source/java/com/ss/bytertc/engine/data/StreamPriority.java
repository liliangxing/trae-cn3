package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum StreamPriority {
    STREAM_PRIORITY_LOW(0),
    STREAM_PRIORITY_MEDIAM(1),
    STREAM_PRIORITY_HIGH(2);

    private int value;

    StreamPriority(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static StreamPriority fromId(int id) {
        for (StreamPriority streamPriority : values()) {
            if (streamPriority.value() == id) {
                return streamPriority;
            }
        }
        return null;
    }
}
