package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RoomState {
    JOIN_SUCCESS(0),
    JOIN_FAILED(1),
    LEFT(2);

    private int value;

    RoomState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RoomState valueOf(int value) {
        if (value == 0) {
            return JOIN_SUCCESS;
        }
        if (value == 1) {
            return JOIN_FAILED;
        }
        if (value != 2) {
            return null;
        }
        return LEFT;
    }
}
