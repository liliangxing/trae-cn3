package com.ss.bytertc.engine.device;

/* loaded from: classes7.dex */
public enum DeviceState {
    INIT(0),
    START(1),
    STOP(2),
    REMOVE(3);

    int type;

    DeviceState(int type) {
        this.type = type;
    }

    public int getId() {
        return this.type;
    }

    public static DeviceState fromId(int id) {
        for (DeviceState deviceState : values()) {
            if (deviceState.getId() == id) {
                return deviceState;
            }
        }
        return null;
    }
}
