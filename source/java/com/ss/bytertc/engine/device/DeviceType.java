package com.ss.bytertc.engine.device;

/* loaded from: classes7.dex */
public enum DeviceType {
    MICROPHONE(0),
    SPEAKER(1),
    CAMERA(2);

    int type;

    DeviceType(int type) {
        this.type = type;
    }

    int getId() {
        return this.type;
    }

    public static DeviceType fromId(int id) {
        for (DeviceType deviceType : values()) {
            if (deviceType.getId() == id) {
                return deviceType;
            }
        }
        return null;
    }
}
