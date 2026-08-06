package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RoomEvent {
    USER_NOTIFY_STOP(WarningCode.WARNING_CODE_RECEIVE_USER_NOTIFY_STOP),
    FORBIDDEN(-2012);

    private int value;

    RoomEvent(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RoomEvent valueOf(int value) {
        if (value == -2013) {
            return USER_NOTIFY_STOP;
        }
        if (value != -2012) {
            return null;
        }
        return FORBIDDEN;
    }
}
